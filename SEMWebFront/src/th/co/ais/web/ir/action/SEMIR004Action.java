package th.co.ais.web.ir.action;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.axis.utils.StringUtils;

import th.co.ais.domain.ir.Deduct;
import th.co.ais.domain.ir.DeductibleSP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.ir.IDeductibleService;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.ir.bean.SEMIR004Bean;
import th.co.ais.web.util.LOVCacheUtil;

public class SEMIR004Action extends AbstractAction{

	private static final long serialVersionUID = 7078642759252466129L;

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("initEdit")){
			flag = initEdit();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdate")){
			flag = doUpdate();
		}else if(methodWithNavi.equalsIgnoreCase("initDelete")){
			flag = initDelete();
		}else if(methodWithNavi.equalsIgnoreCase("doDelete")){
			flag = doDelete();
		}else if(methodWithNavi.equalsIgnoreCase("initAdd")){
			flag = initAdd();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}
		return false;
	}

	@Override
	public void clearSessionNotUsed() {
		clearAllSessionNotUsed();

	}

	@Override
	public void init() {
		SEMIR004Bean semir004Bean = new SEMIR004Bean(); 
		semir004Bean.setDeductibleSP(new DeductibleSP());
		semir004Bean.setCompanyList(LOVCacheUtil.getInstance().getCompanySelList());
		semir004Bean.setNetworkTypeList(LOVCacheUtil.getInstance().getNetworkTypeSelList());
		semir004Bean.setTransferTypeList(LOVCacheUtil.getInstance().getTransferTypeSelList());
		semir004Bean.setLossTypeList(LOVCacheUtil.getInstance().getLossTypeSelList());
		setSemir004Bean(semir004Bean);
		
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
//		FrontMessageUtils.addMessageError("incContent:frmSearch:somCompany", "  " + AISDataUtility.buildMessage(ErrorMessageUtil.getMessage("ER0001"), "Company"));
		return flgValid;
	}
	
	private SEMIR004Bean semir004Bean;
	
	public void setSemir004Bean(SEMIR004Bean semir004Bean) {
		this.semir004Bean = semir004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semir004Bean", semir004Bean);
	}

	public SEMIR004Bean getSemir004Bean() {
		return (SEMIR004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semir004Bean");
	}

	public boolean doSearch(){
		
		boolean flag = false;
		SEMIR004Bean semir004Bean = getSemir004Bean();
		ILovMasterService lovMasterService = (ILovMasterService)getBean("lovMasterService");
		List<DeductibleSP> to = null;
		try {
			 to = lovMasterService.querySPList(EQueryName.Q_DEDUCTIBLE.name, semir004Bean.getDeductibleSP());
			 if(to != null && !to.isEmpty()){
				 semir004Bean.setDeductibleSPList(to);
			 }
			 setSemir004Bean(semir004Bean);
			 flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean initEdit(){
		boolean flag = false;
		semir004Bean = getSemir004Bean();
		IDeductibleService deductibleService = (IDeductibleService)getBean("deductibleService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		String deductCompany = (String)getFacesUtils().getRequestParameter("deductCompany");
		String deductNtType = (String)getFacesUtils().getRequestParameter("deductNtType");
		String deductTfType = (String)getFacesUtils().getRequestParameter("deductTfType");
		String deductLsType = (String)getFacesUtils().getRequestParameter("deductLsType");
		Deduct deduct = new Deduct();
		
		if(StringUtils.isEmpty(rowId)){
			deduct.setCompany(deductCompany);
			deduct.setNetworkType(deductNtType);
			deduct.setTransferType(deductTfType);
			deduct.setLossType(deductLsType);
			semir004Bean.setEditDedutible(deduct);
		}else {
			try {
				semir004Bean.setEditDedutible(deductibleService.queryDeductibleByRowId(rowId));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
				
		return flag;
	}
	
	public boolean initDelete(){
		boolean flag = false;
		IDeductibleService deductibleService = (IDeductibleService)getBean("deductibleService");
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semir004Bean = getSemir004Bean();
		try {
			semir004Bean.setEditDedutible(deductibleService.queryDeductibleByRowId(rowId));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean initAdd() {
		boolean flag = false;
		semir004Bean = getSemir004Bean();
		semir004Bean.setEditDedutible(new Deduct());
		setSemir004Bean(semir004Bean);
		return flag;
	}
	
	public boolean doUpdate(){
		boolean flag = false;
		IDeductibleService deductibleService = (IDeductibleService)getBean("deductibleService");
		semir004Bean = getSemir004Bean();
		try {
			semir004Bean.getEditDedutible().setRowId(null);
			deductibleService.updateDeductible(semir004Bean.getEditDedutible());
			doSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doDelete(){
		boolean flag = false;
		IDeductibleService deductibleService = (IDeductibleService)getBean("deductibleService");
		semir004Bean = getSemir004Bean();
		try {
			deductibleService.deleteDeduct(semir004Bean.getEditDedutible());
			doSearch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean doClear() {
		boolean flag = false;
		semir004Bean = getSemir004Bean();
		semir004Bean.setEditDedutible(new Deduct());
		semir004Bean.setDeductibleSP(new DeductibleSP());
		semir004Bean.setDeductibleSPList(null);
		semir004Bean.setRowId(null);
		setSemir004Bean(semir004Bean);
		return flag;
	}

}
