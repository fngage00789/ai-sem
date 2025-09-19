package th.co.ais.web.si.action;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;
import Permission.bean.ais.com.SSOResponse;

import com.ais.websrv.EmployeeServiceWebServiceV2;
import com.ais.websrv.EmployeeServiceWebServiceV2ServiceLocator;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import common.bean.ais.com.Message;

import th.co.ais.domain.gm.Employee;
import th.co.ais.domain.gm.TransPayment;
import th.co.ais.domain.sap.SapMapping;
import th.co.ais.domain.sap.SapTrxDtl;
import th.co.ais.domain.sap.SapTrxHdr;
import th.co.ais.domain.sap.SapTrxLog;
import th.co.ais.domain.si.SiteApproveDisplaySP;
import th.co.ais.service.gm.ITransPaymentService;
import th.co.ais.service.sap.ISAPService;
import th.co.ais.util.EComponentCode;
import th.co.ais.util.SAPUtility;
import th.co.ais.util.SFTPUtilities;
import th.co.ais.util.SSHUserInfo;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.si.bean.SEMS001Bean;
import th.co.ais.web.util.CompanyCacheUtil;
import th.co.ais.web.util.LOVCacheUtil;
import th.co.ais.web.util.RegionCacheUtil;
import th.co.ais.web.util.WebUtil;

public class SEMS001Action extends AbstractAction{

	private static final long serialVersionUID = -5833854159521536218L;

	private ISAPService getSAPService(){ return (ISAPService)getBean("sapService");}
	private ITransPaymentService getTransPaymentService(){ return (ITransPaymentService)getBean("transPaymentService");}
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		return true;
	}	

	private boolean init;
	public void setInit(boolean init) {
		this.init = init;
	}
	public boolean isInit() {
		return init;
	}
	
	@Override
	public void init() {
		
		//SEMS001Bean sems001Bean = new SEMS001Bean();
		sems001Bean = getSEMS001Bean();
		if(sems001Bean==null){
			sems001Bean = new SEMS001Bean();
		}
		
		//sems001Bean.setSearchCriteria(new SiteApproveDisplaySP());		
		//sems001Bean.setCompanyList(getCompanyItemsAll());		
		//sems001Bean.setRegionList(RegionCacheUtil.getInstance().getRegionSelList());
		//sems001Bean.setReqTypeList(LOVCacheUtil.getInstance().getApproveTypeSelList());
		//sems001Bean.setSiteApproveStatusList(getLovItemsByType(EComponentCode.M_CODE_APPROVE_STATUS.name));//LOVCacheUtil.getInstance().getSiteApproveStatusSelList());
		//setSapPath();
		
		try {
			String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath").concat(getUserLogIn()+"*");
			List<File> files = SAPUtility.listFile(ssoSerlzePath);
			if(files!=null){
				System.out.println("Loop Sso xml");
				List<SelectItem> items = new ArrayList<SelectItem>();
				for(File file : files){
					System.out.println(" - "+file.getName());
					items.add(new SelectItem(file.getName(), file.getName()));
				}
				sems001Bean.setSsoXmlList(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//check null
		List<SelectItem> emptyList = new ArrayList<SelectItem>();
		sems001Bean.setCompanyList(null!=sems001Bean.getCompanyList()?sems001Bean.getCompanyList():emptyList);
		sems001Bean.setRegionList(null!=sems001Bean.getRegionList()?sems001Bean.getRegionList():emptyList);
		sems001Bean.setReqTypeList(null!=sems001Bean.getReqTypeList()?sems001Bean.getReqTypeList():emptyList);
		sems001Bean.setSiteApproveStatusList(null!=sems001Bean.getSiteApproveStatusList()?sems001Bean.getSiteApproveStatusList():emptyList);
		sems001Bean.setListFileSAP(null!=sems001Bean.getListFileSAP()?sems001Bean.getListFileSAP():emptyList);
		sems001Bean.setListFileSEM(null!=sems001Bean.getListFileSEM()?sems001Bean.getListFileSEM():emptyList);
		sems001Bean.setSsoXmlList(null!=sems001Bean.getSsoXmlList()?sems001Bean.getSsoXmlList():emptyList);
		
		setSEMMS001Bean(sems001Bean);
	}
	public boolean setSapPath(){
		boolean flag = false;
		try {			
			sems001Bean = getSEMS001Bean();					
			SFTPUtilities sftp = new SFTPUtilities(true);			
			System.out.println("List<LsEntry> entrys = sftp.listEntry("+sems001Bean.getSapPath()+");");			
			List<String> entries = sftp.listLsEntryLongname(sems001Bean.getSapPath());
			if(entries!=null){
				System.out.println("Loop List<LsEntry>");
				List<SelectItem> items = new ArrayList<SelectItem>();
				for(String longNm : entries){
					System.out.println("longName: "+longNm);
					items.add(new SelectItem(longNm, longNm));
				}
				sems001Bean.setListFileSAP(items);
			}
			sftp.disconnect();
			setSEMMS001Bean(sems001Bean);			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", e.getMessage());
		}
		return flag;
	}
	public boolean setSemPath(){
		boolean flag = false;
		try {			
			sems001Bean = getSEMS001Bean();					
			List<File> files = SAPUtility.listFile(sems001Bean.getSemPath());
			if(files!=null){
				System.out.println("Loop List<File>");
				List<SelectItem> items = new ArrayList<SelectItem>();
				for(File file : files){
					System.out.println(" - "+file.getName());
					items.add(new SelectItem(file.getName(), file.getName()));
				}
				sems001Bean.setListFileSEM(items);
			}
			setSEMMS001Bean(sems001Bean);			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", e.getMessage());
		}
		return flag;
	}
	
	
	static final int DEFAULT_BUFFER_SIZE = 4096;
    static final long TIMEOUT = 5000L;
    static final long POLL_TIMEOUT = 1000L;
    static final String NL = "\n";
	public boolean exec() {
		sems001Bean = getSEMS001Bean();
		sems001Bean.setCommandOutput("");
		sems001Bean.setCommandError("");
		
		if(StringUtils.isEmpty(sems001Bean.getCommand().trim())){
			addMessageError("EL0000", "Please input command to exec.");
			return false;
		}
		
		
		Process process = null;
		try {
			
			String[] cmd = sems001Bean.getCommand().split(" ");
			process = Runtime.getRuntime().exec(cmd);
			
	        InputStream in = process.getInputStream();
	        BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
	        String s=null;
		    StringBuilder sb = new StringBuilder();
		    while ((s = inReader.readLine()) != null) {
		    	System.out.println(s);
			    sb.append(s).append(NL);
		    }
		    sems001Bean.setCommandOutput(sb.toString());
		    
	        InputStream err = process.getErrorStream();	        
		    BufferedReader errReader = new BufferedReader(new InputStreamReader(err));		    
		    String sE = null;
		    StringBuilder sbErr = new StringBuilder();
		    while ((sE = errReader.readLine()) != null) {
		    	System.out.println(sE);
		    	sbErr.append(sE).append(NL);
		    }
		    sems001Bean.setCommandError(sbErr.toString());
		    
	        
		}catch (Exception e) {
			//sems001Bean.setCommandOutput(e.getMessage());
			sems001Bean.setCommandError(e.getMessage());
			e.printStackTrace();
		} finally {
			if(process != null){
				//System.out.println("process.exitValue(): "+process.exitValue());
				//process.destroy();
			}
		}
		return true;
	}
	
	public boolean syncSessionSSO(){
		sems001Bean = getSEMS001Bean();
		sems001Bean.setCommandError("");
		sems001Bean.setSyncSsoMsg(new Message());
		
		try {
			Message msg = new Message();
			EmployeeServiceWebServiceV2 empService = (new EmployeeServiceWebServiceV2ServiceLocator()).getEmployeeServiceWebServiceV2SoapPort();
			SSOResponse resp = empService.syncUserSession(sems001Bean.getToken());
			sems001Bean.setSyncSsoMsg(resp.getMessage());
			sems001Bean.setCommandError("Call success!!!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sems001Bean.setCommandError(e.getMessage());
		}
		
		return true;
	}
	
	public boolean loadComponents(){
		sems001Bean = getSEMS001Bean();
		
		sems001Bean.setCommandError("");
		sems001Bean.setCompCodes(null);
		try {
			
			/*SSOCompCode compCode = WebUtil.getCompCodes(sems001Bean.getProgramCode(), sems001Bean.getComponentCode());
			sems001Bean.setOutputComponent(
					"<<Component Code>>"+NL+
					"CompCode: "+compCode.getCompCode()+NL+
					"Edit: "+compCode.getEdit()+NL+
					"Enable: "+compCode.getEnable()+NL+
					"Visible: "+compCode.getVisible()+NL+
					"ProgCodeName: "+compCode.getProgCodeName()+NL
			);*/
			
			List<SSOCompCode> compCodes = null;
			if(null==sems001Bean.getProgramCode() || "".equals(sems001Bean.getProgramCode())){
				sems001Bean.setCommandError("Please input ProgramCode.");				
				return false;
			}else{
				
				if(null!=sems001Bean.getComponentCode() && !"".equals(sems001Bean.getComponentCode())){
					SSOCompCode compCode = WebUtil.getCompCodes(sems001Bean.getProgramCode(), sems001Bean.getComponentCode());
					compCodes = new ArrayList<SSOCompCode>(); 
					compCodes.add(compCode);					
				}else{
					compCodes = WebUtil.getListCompCodes(sems001Bean.getProgramCode());
					if(compCodes.isEmpty()){
						sems001Bean.setCommandError("Component codes find not found.");
					}
				}
				sems001Bean.setCompCodes(compCodes);
			}			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sems001Bean.setCommandError(e.getMessage());
		}
		
		return true;
	}
	
	public boolean deleteSAPFile(){
		boolean flag = false;
		try {
			sems001Bean = getSEMS001Bean();
			//SFTPUtilities sftp = new SFTPUtilities(true);
			//sftp.getChannelSftp().rm(sems001Bean.getSapPath());
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", e.getMessage());
		}	
		return flag;
	}
	public boolean deleteSEMFile(){
		boolean flag = false;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", e.getMessage());
		}	
		return flag;
	}
	
	public boolean doSendToSAP() {
		boolean flag = false;
		/*ISAPService service = getSAPService();
		try {
			SEMS001Bean sems001Bean = getSEMS001Bean();
			List<TransPayment> tP = sems001Bean.getTransPayments();
			List<TransPayment> selectTPay = new ArrayList<TransPayment>();
			for(TransPayment selItm : tP){
				if(selItm.isSelected())
					selectTPay.add(selItm);				
			}
			
			if(selectTPay.size()==0){
				addMessageError("W0010", "Approve");
				return false;
			}			
			//service.createTransactionToSAP(tP, getEmployee());
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", e.getMessage());
		}*/
		return flag;
	}
	
	public boolean doSearch() {
		boolean flag = false;
		SEMS001Bean SEMS001Bean = getSEMS001Bean();
		ITransPaymentService srveTrans = getTransPaymentService();
		try {
			List<TransPayment> tPayments = srveTrans.queryTransPayment(null);
			SEMS001Bean.setTransPayments(tPayments);
			setSEMMS001Bean(SEMS001Bean);			
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			addMessageError("EL0000", e.getMessage());
		}
		return flag;
	}
	
	public void selectAllRow(){
		try{
			boolean chkAll = getSEMS001Bean().isChkSelAll();
			List<TransPayment> detailList = getSEMS001Bean().getTransPayments();
			for(int i=0; i<detailList.size(); i++){
				detailList.get(i).setSelected(chkAll);
			}
		}catch(NullPointerException ne){
			ne.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean validate() {
		boolean flagValid = true;
		
		return flagValid;
	}

	
	private SEMS001Bean sems001Bean;	
	public SEMS001Bean getSEMS001Bean() {
		return (SEMS001Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sems001Bean");
	}	
	public void setSEMMS001Bean(SEMS001Bean sems001Bean) {
		this.sems001Bean = sems001Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sems001Bean", this.sems001Bean);
	}
	
}