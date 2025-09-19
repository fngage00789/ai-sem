package th.co.ais.web.co.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.groovy.tools.shell.commands.SetCommand;

import th.co.ais.domain.co.Mco002SrchNoFoundSP;
import th.co.ais.domain.co.Mco006SrchContractStatusSP;
import th.co.ais.domain.co.Mco007MasterContractDetailSP;
import th.co.ais.domain.co.Mco007MasterContractSP;
import th.co.ais.domain.sa.SiteAcqSP;
import th.co.ais.domain.temp.MockUpTemp;
import th.co.ais.service.co.IContractStatusService;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.co.bean.SEMMCO007Bean;

public class SEMMCO007Action extends AbstractAction {
	
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		if (methodWithNavi.equalsIgnoreCase("initAddMasterContract")) {
			flag = initAddMasterContract();
		}else if(methodWithNavi.equalsIgnoreCase("doSearch")){
			flag = doSearch();
		}else if(methodWithNavi.equalsIgnoreCase("doClear")){
			flag = doClear();
		}else if(methodWithNavi.equalsIgnoreCase("doDelContractTitle")){
			flag = this.doDelContractTitle();
		}else if(methodWithNavi.equalsIgnoreCase("doAddContractTitle")){
			flag = this.doAddContractTitle();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveContractTitle")){
			flag = this.doSaveContractTitle();
		}else if(methodWithNavi.equalsIgnoreCase("doClearContTitle")){
			flag = this.doClearContTitle();
		}else if(methodWithNavi.equalsIgnoreCase("doBack")){
			flag = this.doBack();
		}else if(methodWithNavi.equalsIgnoreCase("doAddContractDetail")){
			flag = this.doAddContractDetail();
		}else if(methodWithNavi.equalsIgnoreCase("doInitEditContDetail")){
			flag = this.doInitEditContDetail();
		}else if(methodWithNavi.equalsIgnoreCase("doSaveContractDetail")){
			flag = this.doSaveContractDetail();
		}else if(methodWithNavi.equalsIgnoreCase("doClearContDetail")){
			flag = this.doClearContDetail();
		}else if(methodWithNavi.equalsIgnoreCase("doDelContractDetail")){
			flag = this.doDelContractDetail();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		SEMMCO007Bean semmco007Bean = new SEMMCO007Bean();
		
		semmco007Bean.setMasterContractSP(new Mco007MasterContractSP());
		semmco007Bean.setMasterContractWrapList(new ArrayList<WrapperBeanObject<Mco007MasterContractSP>>());
		semmco007Bean.setChkContractBold(false);
		semmco007Bean.setChkContractUnderline(false);
		
		setSemmco007Bean(semmco007Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMCO007Bean semmco007Bean;
	
	public SEMMCO007Bean getSemmco007Bean() {
		return (SEMMCO007Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmco007Bean");
	}
	
	public void setSemmco007Bean(SEMMCO007Bean semmco007Bean) {
		this.semmco007Bean = semmco007Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmco007Bean", this.semmco007Bean);
	}
	
	private boolean doValidateSearch(){
		log.debug("######### Start SEMMCO007Action doValidateSearch #########");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		try{
			if(semmco007Bean.getMasterContractSP().getContractFormName() == null
					|| StringUtils.isEmpty(semmco007Bean.getMasterContractSP().getContractFormName())){
				flag = false;
				addMessageError("W0001", msg("msg.contName"));
			}
			
			if(semmco007Bean.getMasterContractSP().getRecordStatus() == null
				|| StringUtils.isEmpty(semmco007Bean.getMasterContractSP().getRecordStatus())){
				flag = false;
				addMessageError("W0001", msg("msg.contStatus"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			flag = false;
			e.printStackTrace();
			log.error("######### ERROR SEMMCO007Action doValidateSearch : "+e);
		}
		log.debug("######### End SEMMCO007Action doValidateSearch #########");
		return flag;
	}

	private boolean doSearch() {
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
//		if(!validateSearch()){
//			log.info("validate Search pass");
//			semmco006Bean.setRenderedMsgFormSearch(true);
//			return flag;
//		}
		
//		List<Mco006SrchContractStatusSP> to = null;
		try{
			log.info("Starting Do Searching1 ...");
			
			if(this.doValidateSearch()){
				
				IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
				to = service.querySPList(EQueryName.SP_MCO007_MC_SRCH.name, semmco007Bean.getMasterContractSP());
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
					semmco007Bean.setRenderedMsgDataNotFound(true);
					semmco007Bean.setMasterContractWrapList(null);
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco007Bean.setRenderedMsgDataNotFound(false);
					semmco007Bean.setMasterContractWrapList(new ArrayList<WrapperBeanObject<Mco007MasterContractSP>>());
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractSP>();
						
						if(contObj.getCreateDt() != null) {
							contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
						}
						if(contObj.getUpdateDt() != null){
	//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
							contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
						}
						
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco007Bean.getMasterContractWrapList().add(tmpWrapperBean);
						
					}
				}
			}
			
		}catch(Exception e){
			log.info("Exception SEMMCO007Action doSearch() ..."+e);
			e.printStackTrace();
			flag = false;
		}
		setSemmco007Bean(semmco007Bean);
		return flag;
	}
	
	public boolean doClear(){
		log.debug("######### Start SEMMCO007Action doClear #########");
		semmco007Bean = getSemmco007Bean();
		try{
			semmco007Bean.setMasterContractSP(new Mco007MasterContractSP());
			semmco007Bean.setMasterContractWrapList(new ArrayList<WrapperBeanObject<Mco007MasterContractSP>>());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("######### ERROR SEMMCO007Action doClear : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("######### End SEMMCO007Action doClear #########");
		}
		return true;
	}
	
	public boolean initAddMasterContract(){
		log.debug("######### Start SEMMCO007Action initAddMasterContract ##########");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		MockUpTemp mockTmp = new MockUpTemp();
		List<MockUpTemp> mockTmpList = new ArrayList<MockUpTemp>();
		String paramMode = getFacesUtils().getRequestParameter("paramMode") == null ? "" : (String)getFacesUtils().getRequestParameter("paramMode");
		String contractFormId = getFacesUtils().getRequestParameter("contractFormId") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormId");
		String contractFormName = getFacesUtils().getRequestParameter("contractFormName") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormName");
		String contractFormTitle = getFacesUtils().getRequestParameter("contractFormTitle") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormTitle");
		String contractFormEnding = getFacesUtils().getRequestParameter("contractFormEnding") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormEnding");
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		try{
			semmco007Bean.setMasterContractTitleSP(new Mco007MasterContractSP());
			semmco007Bean.setMasterContractDetailSP(new Mco007MasterContractSP());
			semmco007Bean.setMasterContractDetailList(new ArrayList<WrapperBeanObject<Mco007MasterContractSP>>());
			
			if(StringUtils.equals("E", paramMode)){
				if(StringUtils.isNotEmpty(contractFormId)){
					semmco007Bean.getMasterContractTitleSP().setContractFormId(contractFormId);
				}
				
				if(StringUtils.isNotEmpty(contractFormName)){
					semmco007Bean.getMasterContractTitleSP().setContractFormName(contractFormName);
				}
				
				if(StringUtils.isNotEmpty(contractFormTitle)){
					semmco007Bean.getMasterContractTitleSP().setContractFormTitle(contractFormTitle);
				}
				
				if(StringUtils.isNotEmpty(contractFormEnding)){
					semmco007Bean.setChkContEndingFlag(StringUtils.equalsIgnoreCase("Y", contractFormEnding) ? true : false);
				}
				setSemmco007Bean(semmco007Bean);
				flag = this.doMasterContractDetailSrch();
//				this.doContractParamNameSrch();
			}
			this.doContractParamNameSrch();
			
			semmco007Bean.setContractList(mockTmpList);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" #### Error SEMMCO007Action initAddMasterContract : "+e);
		}finally{
			log.debug("######### End SEMMCO007Action initAddMasterContract ##########");
			setSemmco007Bean(semmco007Bean);
		}
//		List<MockUpTemp> mockTmpList = new ArrayList<MockUpTemp>();
//		mockTmp.setValue2("สัญญาเช่าสถานที่");
//		mockTmp.setValue3("สัญญาเช่าสถานที่ ฉบับนี้ทำขึ้นระหว่าง");
//		mockTmp.setValue4("ซึ่งต่อไปในสัญญานี้จะเรียก “ผู้ให้เช่า” ฝ่ายหนึ่ง กับ บริษัท ทีโอที จำกัด (มหาชน) โดย นางสาวชัชนีย์ โสตถิสิริ ผู้จัดการส่วนจัดการงานผลประโยชน์ที่ 2.1 ผู้รับมอบอำนาจกระทำการแทนผู้จัดการฝ่ายบริหารผลประโยชน์ที่ 2 ตามคำสั่งฝ่ายบริหารผลประโยชน์ที่ 2/2549 ซึ่งต่อไปในสัญญานี้จะเรียก “ผู้เช่า” อีกฝ่ายหนึ่ง ทั้งสองฝ่ายตกลงทำสัญญามีข้อความดังต่อไปนี้");
//		mockTmp.setValue5("ผู้ให้เช่าตกลงให้เช่า และผู้เช่าตกลงเช่า");
//		mockTmp.setValue6("ซึ่งผู้ให้เช่าเป็นผู้มีสิทธิในสถานที่เช่า ซึ่งต่อไปในสัญญานี้จะเรียก “สถานที่เช่า”  เพื่อใช้เป็นสถานที่ติดตั้งเครื่องมือและอุปกรณ์ระบบโทรศัพท์เคลื่อนที่ ตลอดจนอุปกรณ์ต่อเนื่องที่ติดตั้งเพิ่มในอนาคต เพื่อปรับปรุง และพัฒนาประสิทธิภาพการให้บริการให้ดียิ่งขึ้น ในกิจการที่ผู้เช่าร่วม กับ บมจ.แอดวานซ์ อินโฟร์ เซอร์วิส ทั้งนี้อุปกรณ์เพิ่มดังกล่าวจะต้องไม่เป็นการเพิ่มการใช้พื้นที่เช่ามากขึ้นหรือเพิ่มน้ำหนักจนเป็นอันตรายต่อโครงสร้างอาคาร");
//		
//		semmco007Bean.setContract(mockTmp);
//		
//		mockTmp = new MockUpTemp();
//		mockTmp.setValue1("ข้อ 1 ข้อสัญญาของผู้เช่");
//		mockTmp.setValue2("1.1 ผู้เช่าสัญญาว่าผู้เช่าจะใช้สถานที่เช่า โดยมีวัตถุประสงค์เพื่อใช้เป็นสถานที่ ติดตั้งเครื่องมือและอุปกรณ์ตามที่ระบุไว้ในสัญญานี้ ร่วมกับ บมจ. แอดวานซ์ อินโฟร์ เซอร์วิส และจะใช้สถานที่เช่าโดยผู้เช่าและ/หรือ บมจ. แอดวานซ์ อินโฟร์ เซอร์วิส เท่านั้น เว้นแต่จะได้รับความยินยอมเป็นลายลักษณ์อักษรจากผู้ให้เช่าให้ผู้อื่นร่วมใช้ได้");
//		mockTmp.setValue3("1");
//		mockTmpList.add(mockTmp);
//		
//		mockTmp = new MockUpTemp();
//		mockTmp.setValue1("ข้อ 1 ข้อสัญญาของผู้เช่า");
//		mockTmp.setValue2("1.2 ผู้เช่าสัญญาว่าจะไม่โอนสิทธิในการเช่าสถานที่เช่านี้ หรือ นำสถานที่เช่า ทั้งหมด หรือบางส่วนไปให้บุคคลอื่นเช่าช่วง หรือ ยอมให้บุคคลอื่นเข้าครอบครอง หรือ ใช้ประโยชน์แทนไม่ว่าเป็นการประจำหรือชั่วคราวเว้นแต่ จะได้รับความยินยอมเป็นลายลักษณ์อักษรจากผู้ให้เช่า");
//		mockTmp.setValue3("2");
//		mockTmpList.add(mockTmp);
//		
//		mockTmp = new MockUpTemp();
//		mockTmp.setValue1("ข้อ 2 ในกรณีครบกำหนดสัญญา");
//		mockTmp.setValue2("เมื่อครบระยะเวลาการเช่าตามสัญญาฉบับนี้ และไม่มีการต่อสัญญาเช่าหรือเมื่อการเช่าได้สิ้นสุดลงก่อนกำหนด ผู้เช่าจะต้องส่งมอบคืนสถานที่เช่าในสภาพที่เรียบร้อยและจะต้องขนย้ายทรัพย์สินออกไป จากสถานที่เช่าภายในกำหนด 60 วัน นับแต่วันที่ครบกำหนดตามสัญญาฉบับนี้ หรือเมื่อการเช่าได้สิ้นสุดลง กับจะต้องซ่อมแซมสถานที่เช่าให้อยู่ในสภาพเรียบร้อยดังเดิม");
//		mockTmp.setValue3("3");
//		mockTmpList.add(mockTmp);
//		
//		semmco007Bean.setContractList(mockTmpList);
		
		
		return flag;
		
	}
	
	public boolean doMasterContractDetailSrch(){
		boolean flag = true;
		log.debug("####### Start SEMMCO007Action doMasterContractDetailSrch #######");
		semmco007Bean = getSemmco007Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(semmco007Bean.getMasterContractTitleSP().getContractFormId() != null){
				paramObj.setContractFormId(semmco007Bean.getMasterContractTitleSP().getContractFormId());
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.SP_MCO007_MC_DETAIL_SRCH.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
					semmco007Bean.setRenderedMsgDataNotFound(true);
					semmco007Bean.setMasterContractDetailList(null);
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco007Bean.setRenderedMsgDataNotFound(false);
					semmco007Bean.setMasterContractDetailList(new ArrayList<WrapperBeanObject<Mco007MasterContractSP>>());
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractSP>();
						
//						if(contObj.getCreateDt() != null) {
//							contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
//						}
//						if(contObj.getUpdateDt() != null){
////							siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
//							contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
//						}
//						
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco007Bean.getMasterContractDetailList().add(tmpWrapperBean);
						
					}
					setSemmco007Bean(semmco007Bean);
					this.doGetContractChk();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO007Action doMasterContractDetailSrch : "+e);
			flag = false;
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doMasterContractDetailSrch #######");
		}
		return flag;
	}
	
	private void doGetContractChk(){
		
		semmco007Bean = getSemmco007Bean();
		try{
			if(StringUtils.equals("Y", semmco007Bean.getMasterContractDetailSP().getContractBold())){
				semmco007Bean.setChkContractBold(true);
			}else{
				semmco007Bean.setChkContractBold(false);
			}
			
			if(StringUtils.equals("Y", semmco007Bean.getMasterContractDetailSP().getContractUnderline())){
				semmco007Bean.setChkContractUnderline(true);
			}else{
				semmco007Bean.setChkContractUnderline(false);
			}
			
			if(StringUtils.equals("Y", semmco007Bean.getMasterContractDetailSP().getContractNewline())){
				semmco007Bean.setChkContractNewline(true);
			}else{
				semmco007Bean.setChkContractNewline(false);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("####### Error SEMMCO007Action doGetContractChk");
		}finally{
			setSemmco007Bean(semmco007Bean);
		}
	}
	
	private void doSetContractChk(){
		semmco007Bean = getSemmco007Bean();
		try{
			
			if(semmco007Bean.isChkContractBold()){
				semmco007Bean.getMasterContractDetailSP().setContractBold("Y");
			}else{
				semmco007Bean.getMasterContractDetailSP().setContractBold("N");
			}
			
			if(semmco007Bean.isChkContractUnderline()){
				semmco007Bean.getMasterContractDetailSP().setContractUnderline("Y");
			}else{
				semmco007Bean.getMasterContractDetailSP().setContractUnderline("N");
			}
			
			if(semmco007Bean.isChkContractNewline()){
				semmco007Bean.getMasterContractDetailSP().setContractNewline("Y");
			}else{
				semmco007Bean.getMasterContractDetailSP().setContractNewline("N");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("####### Error SEMMCO007Action doSetContractChk");
		}finally{
			setSemmco007Bean(semmco007Bean);
		}
	}
	
	public boolean doDelContractTitle(){
		log.debug("####### Start SEMMCO007Action doDelContractTitle #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		String contractFormId = getFacesUtils().getRequestParameter("contractFormId") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormId");
		String contractFormName = getFacesUtils().getRequestParameter("contractFormName") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormName");
		String contractFormTitle = getFacesUtils().getRequestParameter("contractFormTitle") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormTitle");
		try{
			flag = this.doDelContract("M", contractFormId, "");
			
			if(flag){
				this.doSearch();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("############ Error SEMMCO007Action doDelContractTitle : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doDelContractTitle #######");
		}
		
		return flag;
	}
	
	public boolean doDelContractDetail(){
		log.debug("####### Start SEMMCO007Action doDelContractDetail #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		String contractFormId = getFacesUtils().getRequestParameter("contractFormId") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormId");
		String contractFormDetailId = getFacesUtils().getRequestParameter("contractFormDetailId") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormDetailId");
		String contractFormTitle = getFacesUtils().getRequestParameter("contractFormTitle") == null ? "" : (String)getFacesUtils().getRequestParameter("contractFormTitle");
		try{
			flag = this.doDelContract("D", contractFormId, contractFormDetailId);
			
			if(flag){
				flag = this.doMasterContractDetailSrch();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("############ Error SEMMCO007Action doDelContractDetail : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doDelContractDetail #######");
		}
		
		return flag;
	}
	
	public boolean doDelContract(String mode, String contId, String ContDetailId){
		log.debug("####### Start SEMMCO007Action doDelContract #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(StringUtils.isNotEmpty(mode) && (StringUtils.isNotEmpty(contId) || StringUtils.isNotEmpty(ContDetailId))){
				
				if(mode != null)paramObj.setMode(mode);
				if(contId != null)paramObj.setContractFormId(contId);
				if(ContDetailId != null)paramObj.setContractFormDetailId(ContDetailId);
				paramObj.setRecordStatus("N");
			
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.SP_MCO007_MC_DETAIL_DEL.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
//					semmco007Bean.setMasterContractDetailList(null);
					addMessageError("E0002");
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco007Bean.setRenderedMsgDataNotFound(false);
					if(StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())){
						addMessageInfo("M0003");
					}else{
						addGeneralMessageError(to.get(0).getRetResult());
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			addMessageError("E0002");
			log.error("############ Error SEMMCO007Action doDelContract : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doDelContract #######");
		}
		
		return flag;
	}
	
	private boolean doSearchAfterSave(Mco007MasterContractSP paramObj) {
		boolean flag = false;
		semmco007Bean = getSemmco007Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
//		if(!validateSearch()){
//			log.info("validate Search pass");
//			semmco006Bean.setRenderedMsgFormSearch(true);
//			return flag;
//		}
		
//		List<Mco006SrchContractStatusSP> to = null;
		try{
			log.info("Starting Do Searching1 ...");
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			paramObj.setRecordStatus("Y");
			to = service.querySPList(EQueryName.SP_MCO007_MC_SRCH.name, paramObj);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmco007Bean.setRenderedMsgDataNotFound(true);
//				semmco007Bean.setMasterContractTitleSP(null);
			}
			
			if(to != null && to.size() > 0){
				flag = true;
				
				semmco007Bean.setRenderedMsgDataNotFound(false);
//				semmco007Bean.setMasterContractWrapList(new ArrayList<WrapperBeanObject<Mco007MasterContractSP>>());
				semmco007Bean.setMasterContractTitleSP(new Mco007MasterContractSP());
				for (int i = 0; i < to.size(); i++) {
					Mco007MasterContractSP contObj = to.get(i);
					WrapperBeanObject<Mco007MasterContractSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractSP>();
					
					if(contObj.getCreateDt() != null) {
						contObj.setCreateDtStr(convertYearENtoTHStr(contObj.getCreateDt()));
					}
					if(contObj.getUpdateDt() != null){
//						siteInfo.setExpDate(convertYearENtoTH(siteInfo.getExpDate()));
						contObj.setUpdateDtStr(convertYearENtoTHStr(contObj.getUpdateDt()));
					}
					
					semmco007Bean.setMasterContractTitleSP(contObj);
//					tmpWrapperBean.setDataObj(contObj);
//					tmpWrapperBean.setMessage("");
//					tmpWrapperBean.setCheckBox(false);
//					semmco007Bean.getMasterContractWrapList().add(tmpWrapperBean);
					
				}
			}
		
			
		}catch(Exception e){
			log.info("Exception SEMMCO007Action doSearchAfterSave() ..."+e);
			e.printStackTrace();
			flag = false;
		}
		setSemmco007Bean(semmco007Bean);
		return flag;
	}
	
	private boolean doValidateContractTitle(){
		log.debug("####### Start SEMMCO007Action doValidateContractTitle #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		try{
			if(semmco007Bean.getMasterContractTitleSP().getContractFormName() == null
					|| StringUtils.isEmpty(semmco007Bean.getMasterContractTitleSP().getContractFormName())){
				flag = false;
				addMessageError("W0001", msg("msg.contName"));
			}
			
			if(semmco007Bean.getMasterContractTitleSP().getContractFormTitle() == null
					|| StringUtils.isEmpty(semmco007Bean.getMasterContractTitleSP().getContractFormTitle())){
				flag = false;
				addMessageError("W0001", msg("msg.contTitle"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("########## Error SEMMCO007Action doValidateContractTitle : "+e);
		}finally{
			log.debug("####### End SEMMCO007Action doValidateContractTitle #######");
		}
		return flag;
	}
	
	public boolean doAddContractTitle(){
		log.debug("####### Start SEMMCO007Action doAddContractTitle #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			if(doValidateContractTitle()){
				semmco007Bean.getMasterContractTitleSP().setMode("M");
				flag = this.doAddMasterContract(semmco007Bean.getMasterContractTitleSP());
				if(flag){
					this.doSearchAfterSave(semmco007Bean.getMasterContractTitleSP());
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMCO007Action doAddContractTitle : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doAddContractTitle #######");
		}
		return flag;
	}
	
	private boolean doValidateContractDetail(){
		log.debug("####### Start SEMMCO007Action doValidateContractDetail #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		try{
			if(semmco007Bean.getMasterContractDetailSP().getContractFormDetail() == null
					|| StringUtils.isEmpty(semmco007Bean.getMasterContractDetailSP().getContractFormDetail())){
				flag = false;
				addMessageError("W0001", msg("msg.contDetail"));
			}
			
			if(semmco007Bean.getMasterContractDetailSP().getContractFormOrder() == null){
				flag = false;
				addMessageError("W0001", msg("msg.orderby"));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("########## Error SEMMCO007Action doValidateContractDetail : "+e);
		}finally{
			log.debug("####### End SEMMCO007Action doValidateContractDetail #######");
		}
		return flag;
	}
	
	public boolean doAddContractDetail(){
		log.debug("####### Start SEMMCO007Action doAddContractDetail #######");
		boolean flag = true;

		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			if(doValidateContractDetail()){
				this.doSetContractChk();
				semmco007Bean.getMasterContractDetailSP().setMode("D");
				if(semmco007Bean.getMasterContractTitleSP().getContractFormId() != null)
					semmco007Bean.getMasterContractDetailSP().setContractFormId(semmco007Bean.getMasterContractTitleSP().getContractFormId());
				flag = this.doAddMasterContract(semmco007Bean.getMasterContractDetailSP());
				if(flag){
					flag = this.doMasterContractDetailSrch();
					this.doClearContDetail();
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMCO007Action doAddContractDetail : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doAddContractDetail #######");
		}
		return flag;
	}

	private boolean doAddMasterContract(Mco007MasterContractSP paramObj){
		log.debug("####### Start SEMMCO007Action doAddMasterContract #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(StringUtils.isNotEmpty(paramObj.getMode()) && 
					((StringUtils.isNotEmpty(paramObj.getContractFormName()) && StringUtils.isNotEmpty(paramObj.getContractFormTitle())) || 
							(StringUtils.isNotEmpty(paramObj.getContractFormDetail()) && paramObj.getContractFormOrder() != null))){
				
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
				paramObj.setContEndingFlag(semmco007Bean.isChkContEndingFlag() == true ? "Y" : "N" );
				log.debug("getContEndingFlag : "+paramObj.getContEndingFlag());
			
				to = service.querySPList(EQueryName.SP_MCO007_MC_DETAIL_INS.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
//					semmco007Bean.setMasterContractDetailList(null);
					addMessageError("E0001");
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco007Bean.setRenderedMsgDataNotFound(false);
					if(StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())){
						addMessageInfo("M0001");
					}else{
						flag = false;
						addGeneralMessageError(to.get(0).getRetResult());
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			flag = false;
			e.printStackTrace();
			log.error("Error SEMMCO007Action doAddMasterContract : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doAddMasterContract #######");
		}
		return flag;
	}
	
	public boolean doSaveContractTitle(){
		log.debug("####### Start SEMMCO007Action doSaveContractTitle #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			if(doValidateContractTitle()){
				semmco007Bean.getMasterContractTitleSP().setMode("M");
				flag = this.doSaveMasterContract(semmco007Bean.getMasterContractTitleSP());
				if(flag){
					this.doSearchAfterSave(semmco007Bean.getMasterContractTitleSP());
				}else{
					flag = false;
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMCO007Action doSaveContractTitle : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doSaveContractTitle #######");
		}
		return flag;
	}
	
	private boolean doInitEditContDetail(){
		log.debug("####### Start SEMMCO007Action doInitEditContDetail #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		
		String contractFormDetailId = getFacesUtils().getRequestParameter("contractFormDetailId") == null ? "" : (String) getFacesUtils().getRequestParameter("contractFormDetailId");
		String contractFormDetail = getFacesUtils().getRequestParameter("contractFormDetail") == null ? "" : (String) getFacesUtils().getRequestParameter("contractFormDetail");
		BigDecimal contractFormOrder =  getFacesUtils().getRequestParameter("contractFormOrder") == null ? new BigDecimal(0) : new BigDecimal((String)getFacesUtils().getRequestParameter("contractFormOrder"));
		String contractBold = getFacesUtils().getRequestParameter("contractBold") == null ? "" : (String) getFacesUtils().getRequestParameter("contractBold");
		String contractUnderline = getFacesUtils().getRequestParameter("contractUnderline") == null ? "" : (String) getFacesUtils().getRequestParameter("contractUnderline");
		String contractNewline = getFacesUtils().getRequestParameter("contractNewline") == null ? "" : (String) getFacesUtils().getRequestParameter("contractNewline");
		
		try{
			if(StringUtils.isNotEmpty(contractFormDetailId)){
				semmco007Bean.setMasterContractDetailSP(new Mco007MasterContractSP());
				
				if(contractFormDetailId != null)
					semmco007Bean.getMasterContractDetailSP().setContractFormDetailId(contractFormDetailId);
				
				if(contractFormDetail != null)
					semmco007Bean.getMasterContractDetailSP().setContractFormDetail(contractFormDetail);
				
				if(contractFormOrder != null)
					semmco007Bean.getMasterContractDetailSP().setContractFormOrder(contractFormOrder);
				
				if(contractBold != null && StringUtils.equals("Y", contractBold)){
					semmco007Bean.setChkContractBold(true);
				}else
					semmco007Bean.setChkContractBold(false);
				
				if(contractUnderline != null && StringUtils.equals("Y", contractUnderline))
					semmco007Bean.setChkContractUnderline(true);
				else
					semmco007Bean.setChkContractUnderline(false);
				
				if(contractNewline != null && StringUtils.equals("Y", contractNewline))
					semmco007Bean.setChkContractNewline(true);
				else
					semmco007Bean.setChkContractNewline(false);
					
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMCO007Action doInitEditContDetail : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doInitEditContDetail #######");
		}
		return flag;
	}
	
	public boolean doSaveContractDetail(){
		log.debug("####### Start SEMMCO007Action doSaveContractDetail #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			if(doValidateContractDetail()){
				this.doSetContractChk();
				semmco007Bean.getMasterContractDetailSP().setMode("D");
				if(semmco007Bean.getMasterContractTitleSP().getContractFormId() != null)
					semmco007Bean.getMasterContractDetailSP().setContractFormId(semmco007Bean.getMasterContractTitleSP().getContractFormId());
				flag = this.doSaveMasterContract(semmco007Bean.getMasterContractDetailSP());
				if(flag){
					flag = this.doMasterContractDetailSrch();
					this.doClearContDetail();
				}else{
					flag = false;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMCO007Action doSaveContractDetail : "+e);
		}finally{
			log.debug("####### End SEMMCO007Action doSaveContractDetail #######");
		}
		return flag;
	}
	
	private boolean doSaveMasterContract(Mco007MasterContractSP paramObj){
		log.debug("####### Start SEMMCO007Action doSaveMasterContract #######");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		List<Mco007MasterContractSP> to = new ArrayList<Mco007MasterContractSP>();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
			if(StringUtils.isNotEmpty(paramObj.getMode()) && 
					(StringUtils.isNotEmpty(paramObj.getContractFormId()) || StringUtils.isNotEmpty(paramObj.getContractFormDetailId()))){
				
				paramObj.setRecordStatus("Y");
				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.SP_MCO007_MC_DETAIL_UPD.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
//					semmco007Bean.setMasterContractDetailList(null);
					addMessageError("E0001");
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
					semmco007Bean.setRenderedMsgDataNotFound(false);
					if(StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())){
						addMessageInfo("M0001");
					}else{
						flag = false;
						addGeneralMessageError(to.get(0).getRetResult());
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			flag = false;
			e.printStackTrace();
			log.error("Error SEMMCO007Action doSaveMasterContract : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doSaveMasterContract #######");
		}
		return flag;
	}
	
	private boolean doClearContTitle(){
		log.debug("######## Start SEMMCO007Action doClearContTitle #########");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		try{
			semmco007Bean.getMasterContractTitleSP().setContractFormName("");
			semmco007Bean.getMasterContractTitleSP().setContractFormTitle("");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("###### Error SEMMCO007Action doClearContTitle : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("######## End SEMMCO007Action doClearContTitle #########");
		}
		return flag;
	}
	
	private boolean doClearContDetail(){
		log.debug("######## Start SEMMCO007Action doClearContDetail #########");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		try{
//			semmco007Bean.getMasterContractTitleSP().setContractFormDetail("");
//			semmco007Bean.getMasterContractTitleSP().setContractFormOrder("");
//			semmco007Bean.getMasterContractTitleSP().setContractBold("");
//			semmco007Bean.getMasterContractTitleSP().setContractUnderline("");
			semmco007Bean.setMasterContractDetailSP(new Mco007MasterContractSP());
			
			semmco007Bean.setChkContractBold(false);
			semmco007Bean.setChkContractUnderline(false);
			semmco007Bean.setChkContractNewline(false);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("###### Error SEMMCO007Action doClearContDetail : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("######## End SEMMCO007Action doClearContDetail #########");
		}
		return flag;
	}
	
	private boolean doBack(){
		log.debug("######## Start SEMMCO007Action doClearContDetail #########");
		boolean flag = true;
		semmco007Bean = getSemmco007Bean();
		try{
			if(StringUtils.isNotEmpty(semmco007Bean.getMasterContractSP().getContractFormName())){
				this.doSearch();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("###### Error SEMMCO007Action doClearContDetail : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("######## End SEMMCO007Action doClearContDetail #########");
		}
		return flag;
	}
	
	private boolean doContractParamNameSrch(){
		boolean flag = true;
		log.debug("####### Start SEMMCO007Action doContractParamNameSrch #######");
		semmco007Bean = getSemmco007Bean();
		List<Mco007MasterContractDetailSP> to = new ArrayList<Mco007MasterContractDetailSP>();
		Mco007MasterContractSP paramObj = new Mco007MasterContractSP();
		try{
			IContractStatusService service = (IContractStatusService)getBean("contractStatusService");
			
			//set contractFormId 
//			if(semmco007Bean.getMasterContractTitleSP().getContractFormId() != null){
//				paramObj.setContractFormId(semmco007Bean.getMasterContractTitleSP().getContractFormId());
//				paramObj.setRecordStatus("Y");
//				paramObj.setUserId(getUserLogIn());
			
				to = service.querySPList(EQueryName.SP_MCO007_MC_PARAM_NAME.name, paramObj);
				
				log.debug("size [" + to.size() + "]");
				
				if(to == null || to.isEmpty()){
					// set data not found message
//					semmco007Bean.setRenderedMsgDataNotFound(true);
					semmco007Bean.setParamNameObjList(null);
					semmco007Bean.setTotalColumn(null);
					semmco007Bean.setTotalList(null);
				}
				
				if(to != null && to.size() > 0){
					flag = true;
					
//					semmco007Bean.setRenderedMsgDataNotFound(false);
					semmco007Bean.setParamNameObjList(new ArrayList<WrapperBeanObject<Mco007MasterContractDetailSP>>());
					semmco007Bean.setTotalList(to.size());
					if(to.size() > 5){
						semmco007Bean.setTotalColumn(5);
					}else{
						semmco007Bean.setTotalColumn(to.size());
					}
					
					for (int i = 0; i < to.size(); i++) {
						Mco007MasterContractDetailSP contObj = to.get(i);
						WrapperBeanObject<Mco007MasterContractDetailSP> tmpWrapperBean = new WrapperBeanObject<Mco007MasterContractDetailSP>();
					
						tmpWrapperBean.setDataObj(contObj);
						tmpWrapperBean.setMessage("");
						tmpWrapperBean.setCheckBox(false);
						semmco007Bean.getParamNameObjList().add(tmpWrapperBean);
						
					}
					setSemmco007Bean(semmco007Bean);
				}
//			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO007Action doContractParamNameSrch : "+e);
			flag = false;
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doContractParamNameSrch #######");
		}
		return flag;
	}
	
	public void doSelectParamToCont(){
		log.debug("####### Start SEMMCO007Action doSelectParamToCont #######");
		semmco007Bean = getSemmco007Bean();
		String paramCode = getFacesUtils().getRequestParameter("paramCode") == null ? "" : (String)getFacesUtils().getRequestParameter("paramCode");
		try{
			if(paramCode != null && StringUtils.isNotEmpty(paramCode)){
				semmco007Bean.getMasterContractDetailSP().setContractFormDetail(semmco007Bean.getMasterContractDetailSP().getContractFormDetail()+paramCode);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ##### Error SEMMCO007Action doSelectParamToCont : "+e);
		}finally{
			setSemmco007Bean(semmco007Bean);
			log.debug("####### End SEMMCO007Action doSelectParamToCont #######");
		}
	}
}
