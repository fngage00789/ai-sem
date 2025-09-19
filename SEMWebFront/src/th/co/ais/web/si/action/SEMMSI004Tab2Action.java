package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.gm.Province;
import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.MSA001LovSP;
import th.co.ais.domain.si.Contract;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Lessor;
import th.co.ais.domain.si.Msi004CalcAgeSP;
import th.co.ais.domain.si.Msi004CheckEditContractSP;
import th.co.ais.domain.si.Msi004SeqLessorSP;
import th.co.ais.domain.si.Msi004SrchDepositRentSP;
import th.co.ais.domain.si.Msi004SrchLessorSP;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.domain.si.Msi004SrchSumRentAgeSP;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteContractService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISiteLessorService;
import th.co.ais.service.si.ISiteRentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab3Bean;

public class SEMMSI004Tab2Action extends AbstractAction {

	private static final long serialVersionUID = 7936959856367098510L;
	private Logger log = Logger.getLogger(getClass());
	

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("initAddLessorName")) {
			flag = initAddLessorName();
		}
		if(methodWithNavi.equalsIgnoreCase("doCopySiteInfoAddressToContractLessorAddress")){
			flag = doCopySiteInfoAddressToContractLessorAddress();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateContractLessor")){
			flag = doUpdateContractLessor();
		}
		if(methodWithNavi.equalsIgnoreCase("doCopyContactAddress")){
			flag = doCopyContactAddress();
		}
		if(methodWithNavi.equalsIgnoreCase("initUpdateContractLessor")){
			flag = initUpdateContractLessor();
		}
		if(methodWithNavi.equalsIgnoreCase("initDeleteContractLessor")){
			flag = initDeleteContractLessor();
		}
		if(methodWithNavi.equalsIgnoreCase("doDeleteContractLessor")){
			flag = doDeleteContractLessor();
		}
		
		// popup Add Lessor (semmsi004-4)
		if(methodWithNavi.equalsIgnoreCase("doCopySiteInfoAddressToLessorAddress")){
			flag = doCopySiteInfoAddressToLessorAddress();
		}
		if(methodWithNavi.equalsIgnoreCase("doSaveLessor")){
			flag = doSaveLessor();
		}
		if(methodWithNavi.equalsIgnoreCase("doCheckContractInfoChange")){
			flag = this.doCheckContractInfoChange();
		}
		return flag;
	}
	

	private boolean initAddLessorName() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab2Bean.setSiteLessor(new Lessor());
		semmsi004tab2Bean.setLessorAmphurList(getEmptyDropDown());
		semmsi004tab2Bean.getSiteLessor().setLessorName("");
		semmsi004tab2Bean.getSiteLessor().setHouseNo("");
		semmsi004tab2Bean.getSiteLessor().setStreet("");
		semmsi004tab2Bean.getSiteLessor().setTambon("");
		semmsi004tab2Bean.getSiteLessor().setAmphurId("");
		semmsi004tab2Bean.getSiteLessor().setProvinceId("");
		semmsi004tab2Bean.getSiteLessor().setTel("");
		semmsi004tab2Bean.getSiteLessor().setFax("");
		semmsi004tab2Bean.setChkOverFlag(false);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flag;
	}
	
	private boolean doCopySiteInfoAddressToContractLessorAddress() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		SiteInfo siteInfo = semmsi004tab1Bean.getSiteInfo();
		Contract contract = semmsi004tab2Bean.getContract();
		contract.setLessorHouseNo(siteInfo.getSiteHouseNo());
		contract.setLessorStreet(siteInfo.getSiteStreet());
		contract.setLessorTambon(siteInfo.getSiteTambon());
		contract.setLessorProvinceId(siteInfo.getSiteProvinceId());
		contract.setLessorPostcode(siteInfo.getSitePostcode());
		if(siteInfo.getSiteAmphurId() != null && !siteInfo.getSiteAmphurId().equals("")
				&& siteInfo.getSiteProvinceId() != null && !siteInfo.getSiteProvinceId().equals("")){
					Province province = new Province();
					province.setRowId(siteInfo.getSiteProvinceId());
					semmsi004tab2Bean.setContractLessorAmphurList(getAmphurByProvince(province));
					contract.setLessorAmphurId(siteInfo.getSiteAmphurId());
		}
		
		
		semmsi004tab2Bean.setContract(contract);
		
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flag;
	}
	
	private boolean doUpdateContractLessor() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateLessor()){
			semmsi004tab2Bean.setRenderedMsgFormMiddle(true);
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			setSemmsi004tab2Bean(semmsi004tab2Bean);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			return flag;
		}
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		try{
			Lessor lessor = null;
			Contract contract = semmsi004tab2Bean.getContract();
			lessor = new Lessor();
			lessor.setSiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			lessor.setSeqNo(this.getLessorSeqNo(lessor.getSiteInfoId()));
			lessor.setCreateBy(semmsi004tab2Bean.getUserLogin());
			lessor.setLessorName(contract.getOwnerName());
			lessor.setHouseNo(contract.getLessorHouseNo());
			lessor.setStreet(contract.getLessorStreet());
			lessor.setTambon(contract.getLessorTambon());
			lessor.setAmphurId(contract.getLessorAmphurId());
			lessor.setProvinceId(contract.getLessorProvinceId());
			lessor.setTel(contract.getLessorTel());
			lessor.setFax(contract.getLessorFax());
			lessor.setPostcode(contract.getLessorPostcode());
			service.createSiteLessor(lessor);
			
			this.updateSiteInfoLessorEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("2-1");
			
			addMessageInfo("M0001");
			searchLessorList(semmsi004tab1Bean.getSiteInfo().getRowId());
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab2Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab2Bean.setRenderedMsgFormSearch(false);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
		return flag;
	}
	
	private boolean validateLessor() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getLessorName())){
			addMessageError("W0001", msg("message.lessorName"));
			flgValid = false;
		}
		return flgValid;
	}

	private void updateSiteInfoLessorEditFlag() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String siteInfoId = semmsi004tab2Bean.getSiteContract().getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab2Bean.getUserLogin());
				siteInfo.setLessorEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private Integer getLessorSeqNo(String siteInfoId) {
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		List<Msi004SeqLessorSP> to = null;
		Integer seqNo = 0;
		try{
			Msi004SeqLessorSP criteria = new Msi004SeqLessorSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_SEQ_LESSOR.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo Lessor [" + seqNo + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return seqNo;
	}
	
	private void searchLessorList(String siteInfoId) {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab2Bean.setLessorSPList(new ArrayList<Msi004SrchLessorSP>());
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		Msi004SrchLessorSP criteria = new Msi004SrchLessorSP();
		criteria.setSiteInfoId(siteInfoId);
		List<Msi004SrchLessorSP> list = null;
		try{
			list = service.querySPList(EQueryName.SP_MSI004_SRCH_LESSOR.name, criteria);
			
			if(list != null && !list.isEmpty()){
				log.debug("size [" + list.size() + "]");
				semmsi004tab2Bean.setLessorSPList(list);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}
	
	private boolean doCopyContactAddress() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		Contract contract = semmsi004tab2Bean.getContract();
		if(contract.getLessorAmphurId() != null && !contract.getLessorAmphurId().equals("")
				&& contract.getLessorProvinceId() != null && !contract.getLessorProvinceId().equals("")){
					Province province = new Province();
					province.setRowId(contract.getLessorProvinceId());
					semmsi004tab2Bean.setContactAmphurList(getAmphurByProvince(province));
					contract.setContactAmphurId(contract.getLessorAmphurId());
		}
		
		
		semmsi004tab2Bean.setContract(contract);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
		return flag;
	}

	private boolean initUpdateContractLessor() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004tab2Bean.getSiteLessor().setRowId(rowId);
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		try{
			Lessor lessor = service.queryLessorByRowId(rowId);
			if(lessor != null){
				semmsi004tab2Bean.setSiteLessor(lessor);
				
				if(lessor.getProvinceId() != null){
					// get amphur by province
					Province province = new Province();
					province.setRowId(lessor.getProvinceId());
					semmsi004tab2Bean.setLessorAmphurList(getAmphurByProvince(province));
					
				}else{
					semmsi004tab2Bean.setLessorAmphurList(getEmptyDropDown());
				}
				
				if(lessor.getOverFlag() != null && lessor.getOverFlag().equals("Y")){
					semmsi004tab2Bean.setChkOverFlag(true);
				}else{
					semmsi004tab2Bean.setChkOverFlag(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
		return flag;
	}
	
	private boolean initDeleteContractLessor() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		try{
			Lessor lessor = service.queryLessorByRowId(rowId);
			if(lessor != null){
				semmsi004tab2Bean.setSiteLessor(lessor);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
		return flag;
	}

	private boolean doDeleteContractLessor() {
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
		try{
			service.deleteLessor(semmsi004tab2Bean.getSiteLessor());
			searchLessorList(semmsi004tab1Bean.getSiteInfo().getRowId());
			addMessageInfo("M0002");
			this.updateSiteInfoLessorEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("2-1");
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0002");
		}
		
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab2Bean.setRenderedMsgFormMiddle(true);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		
		return flag;
	}
	private boolean doCopySiteInfoAddressToLessorAddress() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		SiteInfo siteInfo = semmsi004tab1Bean.getSiteInfo();
		Lessor lessor = semmsi004tab2Bean.getSiteLessor();
		lessor.setHouseNo(siteInfo.getSiteHouseNo());
		lessor.setStreet(siteInfo.getSiteStreet());
		lessor.setTambon(siteInfo.getSiteTambon());
		lessor.setProvinceId(siteInfo.getSiteProvinceId());
		lessor.setPostcode(siteInfo.getSitePostcode());
		if(siteInfo.getSiteAmphurId() != null && !siteInfo.getSiteAmphurId().equals("")
				&& siteInfo.getSiteProvinceId() != null && !siteInfo.getSiteProvinceId().equals("")){
					Province province = new Province();
					province.setRowId(siteInfo.getSiteProvinceId());
					semmsi004tab2Bean.setLessorAmphurList(getAmphurByProvince(province));
					lessor.setAmphurId(siteInfo.getSiteAmphurId());
		}
		
		semmsi004tab2Bean.setSiteLessor(lessor);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flag;
	}
	
	private boolean doSaveLessor() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		if(!validateSaveLessor()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab2Bean.setRenderedMsgFormMiddle(false);
			semmsi004tab2Bean.setRenderedMsgFormSearch(true);
			semmsi004tab2Bean.setPopupClose(false);
			setSemmsi004tab2Bean(semmsi004tab2Bean);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			return flag;
		}
		try{
			ISiteLessorService service = (ISiteLessorService)getBean("siteLessorService");
			semmsi004tab2Bean.getSiteLessor().setCreateBy(semmsi004tab2Bean.getUserLogin());
			String siteInfoId = semmsi004tab1Bean.getSiteInfo().getRowId();
			semmsi004tab2Bean.getSiteLessor().setSiteInfoId(siteInfoId);
			if(semmsi004tab2Bean.isChkOverFlag()){
				semmsi004tab2Bean.getSiteLessor().setOverFlag("Y");
			}else{
				semmsi004tab2Bean.getSiteLessor().setOverFlag(null);
			}
			// INSERT
			if(semmsi004tab2Bean.getSiteLessor().getRowId() == null){
				semmsi004tab2Bean.getSiteLessor().setSeqNo(this.getLessorSeqNo(siteInfoId));
				service.createSiteLessor(semmsi004tab2Bean.getSiteLessor());	
			// UPDATE
			}else{
				service.updateLessor(semmsi004tab2Bean.getSiteLessor());
			}
			semmsi004tab2Bean.setPopupClose(true);
			searchLessorList(siteInfoId);
			addMessageInfo("M0001");
			this.updateSiteInfoLessorEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("2-1");
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab2Bean.setRenderedMsgFormMiddle(true);
		semmsi004tab2Bean.setRenderedMsgFormSearch(false);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
	}
	private boolean validateSaveLessor() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getSiteLessor().getLessorName())){
			addMessageError("W0001", msg("message.lessorName"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	public boolean doUpdateTab2() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		boolean flag = false;
		// comment by ming 20110407
		if(!validateTab2()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(true);
			semmsi004tab2Bean.setRenderedMsgFormMiddle(false);
			setSemmsi004tab2Bean(semmsi004tab2Bean);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			return flag;
		}
		
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		try{
			semmsi004tab2Bean.getContract().setCurrentUser(semmsi004tab2Bean.getUserLogin());
			semmsi004tab2Bean.getContract().setRecordStatus("Y");
			this.doSetCheckboxTab2();
			Contract contract = service.updateContract(semmsi004tab2Bean.getContract());
			
			semmsi004tab2Bean.setContract(contract);
			// update contract edit flag
			this.updateSiteInfoContractEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
			// set AuditLog
			this.setAuditLog();
			this.doGetCheckboxTab2();
			if(getSemmsi004Bean().isShowMessageSave() == true){
				addMessageInfo("M0001");
			}
			flag = true;
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		semmsi004tab2Bean.setRenderedMsgFormMiddle(false);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
		return flag;
	}
	
	public void doSetCheckboxTab2(){
		log.debug(" #### Start semmsi004tab2Action doSetCheckboxTab2 ### ");
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			if(semmsi004tab2Bean.isChkLeaseholdRights()){
				semmsi004tab2Bean.getContract().setLeaseholdRights("Y");
			}else{
				semmsi004tab2Bean.getContract().setLeaseholdRights("");
			}
			
			if(semmsi004tab2Bean.isChkOwnerContractFlag()){
				semmsi004tab2Bean.getContract().setOwnerContractFlag("Y");
			}else{
				semmsi004tab2Bean.getContract().setOwnerContractFlag("");
			}
			
			if(semmsi004tab2Bean.isChkContractWanted()){
				semmsi004tab2Bean.getContract().setContractWanted("Y");
			}else{
				semmsi004tab2Bean.getContract().setContractWanted("");
			}
			
			if(semmsi004tab2Bean.isChkContRentAdj()){
				semmsi004tab2Bean.getContract().setRenewRentFlag("Y");
			}else{
				semmsi004tab2Bean.getContract().setRenewRentFlag("");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			log.error("  END semmsi004tab2Action doSetCheckboxTab2 : "+e);
		}finally{
			log.debug(" #### END semmsi004tab2Action doSetCheckboxTab2 ### ");
			setSemmsi004tab2Bean(semmsi004tab2Bean);
		}
	}

	public void doGetCheckboxTab2(){
		log.debug(" #### Start semmsi004tab2Action doGetCheckboxTab2 ### ");
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			
			if(StringUtils.equals("Y", semmsi004tab2Bean.getContract().getLeaseholdRights())){
				semmsi004tab2Bean.setChkLeaseholdRights(true);
			}else{
				semmsi004tab2Bean.setChkLeaseholdRights(false);
			}
			
			if(StringUtils.equals("Y", semmsi004tab2Bean.getContract().getOwnerContractFlag())){
				semmsi004tab2Bean.setChkOwnerContractFlag(true);
			}else{
				semmsi004tab2Bean.setChkOwnerContractFlag(false);
			}
			
			if(StringUtils.equals("Y", semmsi004tab2Bean.getContract().getContractWanted())){
				semmsi004tab2Bean.setChkContractWanted(true);
			}else{
				semmsi004tab2Bean.setChkContractWanted(false);
			}
			
			if(StringUtils.equals("Y", semmsi004tab2Bean.getContract().getRenewRentFlag())){
				semmsi004tab2Bean.setChkContRentAdj(true);
			}else{
				semmsi004tab2Bean.setChkContRentAdj(false);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			log.error("  END semmsi004tab2Action doGetCheckboxTab2 : "+e);
		}finally{
			log.debug(" #### END semmsi004tab2Action doGetCheckboxTab2 ### ");
			setSemmsi004tab2Bean(semmsi004tab2Bean);
		}
	}
	
	public void updateSiteInfoContractEditFlag() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String siteInfoId = semmsi004tab2Bean.getContract().getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			if(!StringUtils.isEmpty(siteInfoId)) {
				SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
				if(siteInfo != null && "N".equalsIgnoreCase(siteInfo.getContractEditFlag())){
					siteInfo.setCurrentUser(semmsi004tab2Bean.getUserLogin());
					siteInfo.setContractEditFlag("Y");
					siteInfoService.updateSiteInfo(siteInfo);
					
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean calAge(){
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			Date effDate = semmsi004tab2Bean.getSiteContract().getEffectiveDt();
			Date expDate = semmsi004tab2Bean.getSiteContract().getExpireDt();
			if(effDate != null && expDate != null){
				if (effDate.after(expDate)) {
					addMessageErrorWithArgument("W0005" ,msg("message.contractEffDate"), msg("message.contractExpDate"));
					flag = false;
				}else{
					semmsi004Bean = getSemmsi004Bean();
					this.calAgeContract(effDate, expDate);
					if (semmsi004Bean.getReqTypeParam().equals("01")) {
						semmsi004tab2Bean.getSiteContract().setFirstEffectiveDt(effDate);
					}
					this.getSumRent();
					
				}
			}else{
				semmsi004tab2Bean.getSiteContract().setAgeYear(null);
				semmsi004tab2Bean.getSiteContract().setAgeMonth(null);
				semmsi004tab2Bean.getSiteContract().setAgeDay(null);
				semmsi004tab2Bean.getSiteContract().setAgeYearInt(null);
				semmsi004tab2Bean.getSiteContract().setAgeMonthInt(null);
				semmsi004tab2Bean.getSiteContract().setAgeDayInt(null);
				if(effDate != null) semmsi004tab2Bean.getSiteContract().setFirstEffectiveDt(effDate);
			} 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flag;
	}
	
	private void getSumRent() {
		semmsi004Bean = getSemmsi004Bean();
//		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			List<Msi004SrchSumRentAgeSP> to = null;
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Msi004SrchSumRentAgeSP criteria = new Msi004SrchSumRentAgeSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			criteria.setAgeYear(semmsi004tab2Bean.getSiteContract().getAgeYear().intValue());
			criteria.setAgeMonth(semmsi004tab2Bean.getSiteContract().getAgeMonth().intValue());
			criteria.setAgeDay(semmsi004tab2Bean.getSiteContract().getAgeDay().intValue());
			
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_SUM_RENT_A.name, criteria);
			if(to != null && to.size() > 0){
				Msi004SrchSumRentAgeSP sumRent = to.get(0);
				semmsi004Bean.getSiteRent().setTotalAgeRentAmt(sumRent.getAgeRentAmt());
				semmsi004Bean.getSiteRent().setTotalAgeServiceAmt(sumRent.getAgeServiceAmt());
				semmsi004Bean.getSiteRent().setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004Bean(semmsi004Bean);
		
	}

	public boolean renderedDisplayContractNo(){
		boolean flag = false;
		String contractNo = "";
		try{
			semmsi004tab2Bean = getSemmsi004tab2Bean();
			if(semmsi004tab2Bean.getContractNo1() != null && !semmsi004tab2Bean.getContractNo1().equals("")){
				contractNo = semmsi004tab2Bean.getContractNo1();
			}
			if((semmsi004tab2Bean.getContractNo2() != null && !semmsi004tab2Bean.getContractNo2().equals(""))){
				contractNo += " " + semmsi004tab2Bean.getContractNo2();
			}
			if(semmsi004tab2Bean.getContractNo3() != null && !semmsi004tab2Bean.getContractNo3().equals("")){
				contractNo += "." + semmsi004tab2Bean.getContractNo3();
			}
			semmsi004tab2Bean.getSiteContract().setContractNo(contractNo);
//			if(semmsi004tab2Bean.isChkDummyFlag()){
			if (semmsi004tab2Bean.isChkDummyFlag() && 
					(StringUtils.isEmpty(semmsi004tab2Bean.getSiteContract().getNoFormat()) || 
					semmsi004tab2Bean.getSiteContract().getNoFormat().equals("N"))) {
				if(getSemmsi004tab1Bean().getDummyContractNo() != null && !getSemmsi004tab1Bean().getDummyContractNo().equals("")){
					semmsi004tab2Bean.getSiteContract().setContractNo(getSemmsi004tab1Bean().getDummyContractNo().toUpperCase());
				}
			} else if (StringUtils.isNotEmpty(semmsi004tab2Bean.getSiteContract().getNoFormat()) 
				&& semmsi004tab2Bean.getSiteContract().getNoFormat().equals("Y")) {
				if(getSemmsi004tab2Bean().getContractNoFormat() != null && !getSemmsi004tab2Bean().getContractNoFormat().equals("")){
					semmsi004tab2Bean.getSiteContract().setContractNo(getSemmsi004tab2Bean().getContractNoFormat().toUpperCase());
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		return flag;
	}
	
	private void calAgeContract(Date effDate, Date expDate) {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		// CALL MSI004_CALC_AGE
		ISiteContractService service = (ISiteContractService)getBean("siteContractService");
		List<Msi004CalcAgeSP> to = null;
		semmsi004tab2Bean.getSiteContract().setAgeYear(null);
		semmsi004tab2Bean.getSiteContract().setAgeMonth(null);
		semmsi004tab2Bean.getSiteContract().setAgeDay(null);
		semmsi004tab2Bean.getSiteContract().setAgeYearInt(null);
		semmsi004tab2Bean.getSiteContract().setAgeMonthInt(null);
		semmsi004tab2Bean.getSiteContract().setAgeDayInt(null);
		try{
			Msi004CalcAgeSP criteria = new Msi004CalcAgeSP();
			criteria.setEffDate(effDate);
			criteria.setExpDate(expDate);
			to = service.querySPList(EQueryName.SP_MSI004_CALC_AGE.name, criteria);
			if(to != null && to.size() > 0){
				Msi004CalcAgeSP cal = to.get(0);
				if(cal.getAgeYear() != null){
					semmsi004tab2Bean.getSiteContract().setAgeYear(new Double(cal.getAgeYear()));	
					semmsi004tab2Bean.getSiteContract().setAgeYearInt(cal.getAgeYear());		
					
				}
				if(cal.getAgeMonth() != null){
					semmsi004tab2Bean.getSiteContract().setAgeMonth(new Double(cal.getAgeMonth()));
					semmsi004tab2Bean.getSiteContract().setAgeMonthInt((cal.getAgeMonth()));
				}
				if(cal.getAgeDay() != null){
					semmsi004tab2Bean.getSiteContract().setAgeDay(new Double(cal.getAgeDay()));
					semmsi004tab2Bean.getSiteContract().setAgeDayInt((cal.getAgeDay()));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}

	private boolean validateTab2() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getOwnerName())){
			addMessageError("W0001", msg("message.ownerName"));
			flgValid = false;
		}
		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getLessorName())){
			addMessageError("W0001", msg("message.lessorName"));
			flgValid = false;
		}
		// validate contract lessor address
//		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getLessorHouseNo())){
//			addMessageError("W0001", msg("message.lessorHouseNo"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getLessorTambon())){
//			addMessageError("W0001", msg("message.lessorTambon"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getLessorAmphurId())){
//			addMessageError("W0001", msg("message.lessorAmphur"));
//			flgValid = false;
//		}
//		if(StringUtils.isEmpty(getSemmsi004tab2Bean().getContract().getLessorProvinceId())){
//			addMessageError("W0001", msg("message.lessorProvince"));
//			flgValid = false;
//		}
				
		return flgValid;
	}
	
	public void getContractLessorAmphurList(){
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		Province province = new Province();
		province.setRowId(semmsi004tab2Bean.getContract().getLessorProvinceId());
		semmsi004tab2Bean.setContractLessorAmphurList(getAmphurByProvince(province));
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}
	
	public void getContactAmphurList(){
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		Province province = new Province();
		province.setRowId(semmsi004tab2Bean.getContract().getContactProvinceId());
		semmsi004tab2Bean.setContactAmphurList(getAmphurByProvince(province));
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}
	
	public void getLessorAmphurList(){
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		Province province = new Province();
		province.setRowId(semmsi004tab2Bean.getSiteLessor().getProvinceId());
		semmsi004tab2Bean.setLessorAmphurList(getAmphurByProvince(province));
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}
	
	public void getSiteContractBySiteInfoId(String siteInfoId) {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab2Bean.setContract(new Contract());
		try{
			ISiteContractService siteContractService = (ISiteContractService)getBean("siteContractService");
			Contract contract = siteContractService.queryContractBySiteInfoId(siteInfoId);
			if(contract != null){
				semmsi004tab2Bean.setContract(contract);
				
				if(contract.getPromiseRenewTime() != null && contract.getPromiseRenewTime() == 0){
					semmsi004tab2Bean.getContract().setPromiseRenewTime(null);
				}
				if(contract.getPromiseRenewPeriod() != null && contract.getPromiseRenewPeriod() == 0){
					semmsi004tab2Bean.getContract().setPromiseRenewPeriod(null);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}
	
	public boolean initTab2(){
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			this.getSiteContractBySiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			semmsi004tab2Bean = getSemmsi004tab2Bean();
			if(semmsi004tab2Bean.getContract() != null){
				if(semmsi004tab2Bean.getContract().getLessorProvinceId() != null &&
				  !semmsi004tab2Bean.getContract().getLessorProvinceId().equals("")){
					Province province = new Province();
					province.setRowId(semmsi004tab2Bean.getContract().getLessorProvinceId());
					semmsi004tab2Bean.setContractLessorAmphurList(getAmphurByProvince(province));
				}else{
					semmsi004tab2Bean.setContractLessorAmphurList(getEmptyDropDown());
				}
				if(semmsi004tab2Bean.getContract().getContactProvinceId() != null &&
				  !semmsi004tab2Bean.getContract().getContactProvinceId().equals("")){
					Province province = new Province();
					province.setRowId(semmsi004tab2Bean.getContract().getContactProvinceId());
					semmsi004tab2Bean.setContactAmphurList(getAmphurByProvince(province));
				}else{
					semmsi004tab2Bean.setContactAmphurList(getEmptyDropDown());
				}
				// default promiseRenewPeriodType = 'Y'
				if(semmsi004tab2Bean.getContract().getPromiseRenewPeriodType() == null){
					semmsi004tab2Bean.getContract().setPromiseRenewPeriodType("Y"); // year
				}
				// set Log
				this.setAuditLog();
			}
			// search lessor
			searchLessorList(semmsi004tab1Bean.getSiteInfo().getRowId());
			
			// CHECK MODE VIEW/EDIT
			this.checkMode();
			
			this.doGetCheckboxTab2();
		}catch(Exception e){
			e.printStackTrace();
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		return flag;
		
	}
	
	private void checkMode() {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				if(semmsi004tab1Bean.getCancelableFlag() != null &&
						semmsi004tab1Bean.getCancelableFlag().equals("N")){
					// check editable contract flag
					this.checkEditableContract();
					if(getSemmsi004tab2Bean().getEditableContractFlag() != null &&
					   getSemmsi004tab2Bean().getEditableContractFlag().equals("Y")){
						semmsi004tab2Bean.setDisabledContract(false);
					}else{
						semmsi004tab2Bean.setDisabledContract(true);
					}
				}
			}else{
				// MODE VIEW
				semmsi004tab2Bean.setDisabledContract(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}

	public void checkEditableContract() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		List<Msi004CheckEditContractSP> to = null;
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Msi004CheckEditContractSP criteria = new Msi004CheckEditContractSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_CONTRACT.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable contract flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab2Bean.setEditableContractFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}

	public void setContractNo() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String contractNo = semmsi004tab2Bean.getSiteContract().getContractNo();
		String noFormat = semmsi004tab2Bean.getSiteContract().getNoFormat();
		if(contractNo != null){
			if (StringUtils.isEmpty(noFormat) || noFormat.equals("N")) {
				String[] contractNoArr = contractNo.split(" ");
				if(contractNoArr != null && contractNoArr.length > 0){
					// setContractNo1
					if(contractNoArr != null && contractNoArr.length > 0){
						semmsi004tab2Bean.setContractNo1(contractNoArr[0]);
					}
					// setContractNo2 and setContractNo3
					if(contractNoArr != null && contractNoArr[1] != null){
						// split by dot
						String[] contractNoArr2 = contractNoArr[1].split("\\.");
						if(contractNoArr2 != null && contractNoArr2.length > 0){
								semmsi004tab2Bean.setContractNo2(contractNoArr2[0]);
							if(contractNoArr2.length > 1){
								semmsi004tab2Bean.setContractNo3(contractNoArr2[1]);
							}
						}else{
							semmsi004tab2Bean.setContractNo2(contractNoArr[1]);
						}
					}
				}
			} else {
				semmsi004tab2Bean.setContractNoFormat(contractNo);
			}
			
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		
	}

	private void setAuditLog() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		Contract contract = semmsi004tab2Bean.getContract();
		if(contract != null){
			semmsi004Bean = getSemmsi004Bean();
			semmsi004Bean.setCreateBy(contract.getCreateBy());
			semmsi004Bean.setCreateDate(contract.getCreateDt());
			semmsi004Bean.setUpdateBy(contract.getUpdateBy());
			semmsi004Bean.setUpdateDate(contract.getUpdateDt());
			setSemmsi004Bean(semmsi004Bean);
		}
		
	}
	
	public boolean renderAge(){
		boolean flag = false;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		if(semmsi004tab2Bean.isChkNoExpireFlag()){
			semmsi004tab2Bean.setDisabledExpDate(true);
			semmsi004tab2Bean.setRenderStarImage(false);
			semmsi004tab2Bean.getSiteContract().setAgeYear(null);
			semmsi004tab2Bean.getSiteContract().setAgeMonth(null);
			semmsi004tab2Bean.getSiteContract().setAgeDay(null);
			semmsi004tab2Bean.getSiteContract().setExpireDt(null);
			semmsi004tab2Bean.getSiteContract().setAgeYearInt(null);
			semmsi004tab2Bean.getSiteContract().setAgeMonthInt(null);
			semmsi004tab2Bean.getSiteContract().setAgeDayInt(null);
			//check and put value in firstEFFDate
			if(semmsi004tab2Bean.getSiteContract().getFirstEffectiveDt() == null){
				semmsi004tab2Bean.getSiteContract().setFirstEffectiveDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
			}
		}else{
			this.getSiteContractBySiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			Date effDate = semmsi004tab2Bean.getSiteContract().getEffectiveDt();
			Date expDate = semmsi004tab2Bean.getSiteContract().getExpireDt();
			if(effDate != null && expDate != null){
				this.calAgeContract(effDate, expDate);
			}
			semmsi004tab2Bean.setDisabledExpDate(false);
			semmsi004tab2Bean.setRenderStarImage(true);
		}
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		log.debug("semmsi004tab2Bean.getSiteContract().getFirstEffectiveDt() = "+semmsi004tab2Bean.getSiteContract().getFirstEffectiveDt());
		return flag;
	}
	
	
	private SEMMSI004Tab2Bean semmsi004tab2Bean;
	
	public SEMMSI004Tab2Bean getSemmsi004tab2Bean() {
		return (SEMMSI004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab2Bean");
	}
	
	public void setSemmsi004tab2Bean(SEMMSI004Tab2Bean semmsi004tab2Bean) {
		this.semmsi004tab2Bean = semmsi004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab2Bean", this.semmsi004tab2Bean);
	}
	
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}

	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", this.semmsi004tab1Bean);
	}
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI004Tab2Bean semmsi004tab2Bean = new SEMMSI004Tab2Bean();
		semmsi004tab2Bean.setContract(new Contract());
		semmsi004tab2Bean.setSiteLessor(new Lessor());
		semmsi004tab2Bean.setDisabledContractNo(false);
		semmsi004tab2Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab2Bean.setDisabledChkDummyContract(false);
		semmsi004tab2Bean.setPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
//		semmsi004tab2Bean.setContractDocTypeList(getLovItemsByType(ELovType.T_SI_CONTRACT_DOC_TYPE.name));
		semmsi004tab2Bean.setOwnerGroupList(getLovItemsByType(ELovType.T_SI_SITE_OWNER_GROUP.name));
		semmsi004tab2Bean.setTitleList(getLovItemsByType(ELovType.T_SA_SITE_APP_TITLE.name));
		//added by NEW 2018/10/17
		semmsi004tab2Bean.setOwnerCategoryList(getLovItemsByType(ELovType.T_SA_OWNER_CATEGORY.name));
		semmsi004tab2Bean.setOwnerSubCategoryList(getLovItemsByType(ELovType.T_SA_OWNER_SUB_CATEGORY.name));
		initTab3();
		setSemmsi004tab2Bean(semmsi004tab2Bean);
	}
	
	public void initTab3() {
		SEMMSI004Tab3Bean semmsi004tab3Bean = new SEMMSI004Tab3Bean();
		semmsi004tab3Bean.setRentCondNormal(new RentCond());
		semmsi004tab3Bean.getRentCondNormal().setRentCondType("01");
		semmsi004tab3Bean.setDisabledBtnAddRentCond(false);
		semmsi004tab3Bean.setDisabledBtnUpdateRentCond(true);
		semmsi004tab3Bean.setDisabledBtnAddDepositNormal(false);
		semmsi004tab3Bean.setDisabledBtnUpdateDepositNormal(true);
		semmsi004tab3Bean.setRenderConditionNormal(true);
		semmsi004tab3Bean.setDisabledWhtRateNormal(true);
		semmsi004tab3Bean.setRenderDataTableRentCond(true);
		semmsi004tab3Bean.setChkWhtRateNormal(false);
		semmsi004tab3Bean.setRenderedRentOldAmt(true);
		semmsi004tab3Bean.setRenderConditionSpecial(false);
		semmsi004tab3Bean.setRentCondSpecial1(new RentCond());
		semmsi004tab3Bean.getRentCondSpecial1().setVatType("04");
		semmsi004tab3Bean.setRentCondSpecial2(new RentCond());
		semmsi004tab3Bean.setRentCondSpecial3(new RentCond());
		semmsi004tab3Bean.setRentCondSpecial3(new RentCond());
		semmsi004tab3Bean.getRentCondSpecial3().setVatType("04");
		semmsi004tab3Bean.setRentCondSpecial4(new RentCond());
		semmsi004tab3Bean.getRentCondSpecial4().setVatType("04");
		semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
		semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType("01");
		semmsi004tab3Bean.setRenderDepositRentNormal(true);
		semmsi004tab3Bean.setRenderDepositRentSpecial(false);
		semmsi004tab3Bean.setRenderDataTableDeposit(true);
		semmsi004tab3Bean.setDisabledPeriodType(false);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
		semmsi004tab3Bean.setChkNoRentDeposit(false);
		semmsi004tab3Bean.setChkNoRent(false);
		semmsi004tab3Bean.setFix5Percent(false);
		semmsi004tab3Bean.setRenderedNoRent(true);
		semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(false);
		semmsi004tab3Bean.setRenderedMsgFormBottom(false);
		semmsi004tab3Bean.setDisabledPayPeriod03(true);
		semmsi004tab3Bean.setDisabledPayPeriod04(true);
		semmsi004tab3Bean.setRenderedNoRentDeposit(true);
		semmsi004tab3Bean.setDisabledTotalNormalRent(true);
		semmsi004tab3Bean.setDisabledTotalNormalDeposit(true);
		semmsi004tab3Bean.setChkOverFlag(false);
		semmsi004tab3Bean.setDisabledRentOldAmt(false);
		semmsi004tab3Bean.setSiteDepositSpecialBg(new Deposit());
		semmsi004tab3Bean.setSiteDepositSpecialCash(new Deposit());
		semmsi004tab3Bean.setTotalDeposit(new Rent());
		semmsi004tab3Bean.setTotalRent(new Rent());
		semmsi004tab3Bean.setRentCondSPList(new ArrayList<Msi004SrchRentCondSP>());
		semmsi004tab3Bean.setDepositRentBgSPList(new ArrayList<Msi004SrchDepositRentSP>());
		semmsi004tab3Bean.setDepositRentCashSPList(new ArrayList<Msi004SrchDepositRentSP>());
		semmsi004tab3Bean.setExpenseTypeRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_AND, ELovVal.V_CT_RENT.name, null, null));
//		semmsi004tab3Bean.setExpenseTypeDepositRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null));
		semmsi004tab3Bean.setExpenseTypeDepositRentList(getEmptyDropDown());
		semmsi004tab3Bean.setColumnVatRate("");
		semmsi004tab3Bean.setServTypeList(getEmptyDropDown());
		semmsi004tab3Bean.setRentAdjList(getLovItemsByType(ELovType.T_SA_RENT_ADJ.name));
		semmsi004tab3Bean.setPromiseRenewPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
		
		//added by NEW 2018/
		semmsi004tab3Bean.setChkRentalEditFlag(false);
		semmsi004tab3Bean.setFix5PercentList(getEmptyDropDown());
		//added by NEW 201810/18
		semmsi004tab3Bean.setFix5PercentList(getLovItemsByType(ELovType.T_CT_FIX_RENTAL_ADD_PERCENT.name));
		
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	
	private SEMMSI004Tab3Bean semmsi004tab3Bean;
	
	public SEMMSI004Tab3Bean getSemmsi004tab3Bean() {
		return (SEMMSI004Tab3Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab3Bean");
	}
	
	public void setSemmsi004tab3Bean(SEMMSI004Tab3Bean semmsi004tab3Bean) {
		this.semmsi004tab3Bean = semmsi004tab3Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab3Bean", this.semmsi004tab3Bean);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}

	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}
	
	private SEMMSI004Action semmsi004Action;

	
	public SEMMSI004Action getSemmsi004Action() {
		if(semmsi004Action == null){
			semmsi004Action = new SEMMSI004Action();
		}
		return semmsi004Action;
	}

	public void setSemmsi004Action(SEMMSI004Action semmsi004Action) {
		this.semmsi004Action = semmsi004Action;
	}
	
	private SEMMSI004Tab1Action semmsi004tab1Action;
	
	public SEMMSI004Tab1Action getSemmsi004tab1Action() {
		if(semmsi004tab1Action == null){
			semmsi004tab1Action = new SEMMSI004Tab1Action();
		}
		return semmsi004tab1Action;
	}

	public void setSemmsi004tab1Action(SEMMSI004Tab1Action semmsi004tab1Action) {
		this.semmsi004tab1Action = semmsi004tab1Action;
	}

	public boolean compareTab2() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			ISiteContractService service = (ISiteContractService)getBean("siteContractService");
			Contract temp = service.queryContractBySiteInfoId(semmsi004tab1Bean.getSiteInfo().getRowId());
			Contract current = semmsi004tab2Bean.getContract();
			if(temp != null && current != null){
//				if(!checkObjNull(temp.getContractDocType()).equals(checkObjNull(current.getContractDocType()))){
//					flag = true; 
//					return flag;
//				}
				if(!checkObjNull(temp.getPromiseRenewTime()).equals(checkObjNull(current.getPromiseRenewTime()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getPromiseRenewPeriod()).equals(checkObjNull(current.getPromiseRenewPeriod()))){
					flag = true; 
					return flag;
				}
				if(temp.getPromiseRenewPeriodType() != null && !checkObjNull(temp.getPromiseRenewPeriodType()).equals(checkObjNull(current.getPromiseRenewPeriodType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getOwnerGroup()).equals(checkObjNull(current.getOwnerGroup()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getOwnerName()).equals(checkObjNull(current.getOwnerName()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorName()).equals(checkObjNull(current.getLessorName()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorHouseNo()).equals(checkObjNull(current.getLessorHouseNo()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorStreet()).equals(checkObjNull(current.getLessorStreet()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorTambon()).equals(checkObjNull(current.getLessorTambon()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorAmphurId()).equals(checkObjNull(current.getLessorAmphurId()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorProvinceId()).equals(checkObjNull(current.getLessorProvinceId()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorPostcode()).equals(checkObjNull(current.getLessorPostcode()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorTel()).equals(checkObjNull(current.getLessorTel()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getLessorFax()).equals(checkObjNull(current.getLessorFax()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactName()).equals(checkObjNull(current.getContactName()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactHouseNo()).equals(checkObjNull(current.getContactHouseNo()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactStreet()).equals(checkObjNull(current.getContactStreet()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactTambon()).equals(checkObjNull(current.getContactTambon()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactAmphurId()).equals(checkObjNull(current.getContactAmphurId()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactProvinceId()).equals(checkObjNull(current.getContactProvinceId()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactPostcode()).equals(checkObjNull(current.getContactPostcode()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getContactTel()).equals(checkObjNull(current.getContactTel()))){
					flag = true; 
					return flag;
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public void doSetParamConfirmNotChangeContractInfo(){
		log.debug(" ####### Start SEMMSI004Tab2Action doSetParamConfirmNotChangeContractInfo ####### ");
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab2Bean.getContractInfoEditFlag())){
				itemObj.setResultMessage(msg("msg.warn.notchange"));
				//set button type
				itemObj.setResultType("01");
				itemObj.setVal1("Y");
				itemObj.setVal3("Y");
			}else{
				itemObj.setResultMessage(msg("msg.warn.change"));
				//set button type
				itemObj.setResultType("01");
				itemObj.setVal1("N");
				itemObj.setVal3("N");
			}
			
			
			itemObj.setOkBtnLabel("Yes");
			itemObj.setNavProgram("SEMMSI004-2");
			itemObj.setMethodWithNavi("doCheckContractInfoChange");
			itemObj.setActionWithNavi("SEMMSI004Tab2");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckContractInfoChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab2");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab2Action doSetParamConfirmNotChangeContractInfo : "+e);
			
		}finally{
			setSemmsi004tab2Bean(semmsi004tab2Bean);
			log.debug(" ####### End SEMMSI004Tab2Action doSetParamConfirmNotChangeContractInfo  ####### ");
		}
	}
	
	public boolean doCheckContractInfoChange(){
		log.debug(" ##### Start SEMMSI004Tab2Action doCheckContractInfoChange ##### ");
		boolean flag = true;
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
			if(StringUtils.equals("Y", confirmNotChRental)){
				if(StringUtils.equals("Y", changeType)){
					log.debug(" doCheckContractInfoChange changeType = "+ changeType);
					this.doContractUndo();
				}
				
				//TODO clear save param obj
//				this.doClearSiteAppRentCont();
			}else{
				if(semmsi004tab2Bean.isChkContractInfoEditFlag()){
					semmsi004tab2Bean.setContractInfoEditFlag("Y");
				}else{
					semmsi004tab2Bean.setContractInfoEditFlag("N");
				}
//				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
			}
			
			//set render panel deposit
			if(StringUtils.equals("Y", semmsi004tab2Bean.getContractInfoEditFlag())){
				semmsi004tab2Bean.setChkContractInfoEditFlag(true);
			}else{
				semmsi004tab2Bean.setChkContractInfoEditFlag(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ##### Error SEMMSI004Tab2Action doCheckContractInfoChange : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab2Action doCheckContractInfoChange ##### ");
			setSemmsi004tab2Bean(semmsi004tab2Bean);
			flag = false;
		}
		return flag;
	}
	
	public boolean doContractUndo(){
		
		log.debug(" #### Start SEMMSI004tab2Action doContractUndo ####");
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004Bean = getSemmsi004Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		boolean flag = true;
		try{
			log.debug("doContractUndo getSiteAppId :"+semmsi004Bean.getSiteInfoId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			objParam.setSiteInfoId(semmsi004Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_CONTRACT_UNDO.name, objParam);
			log.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab2Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab2Bean.setContract(new Contract());
			}
				
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab2Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						this.getSiteContractBySiteInfoId(semmsi004Bean.getSiteInfoId());
						
					}else{
						
						semmsi004tab2Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					
					}
					
				}else{
					addMessageError("Error SEMMSI004Tab2Action doContractUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSI004Tab2Action doContractUndo : ","E0001");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab2Action doContractUndo : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab2Action doContractUndo #####");
			setSemmsi004tab2Bean(semmsi004tab2Bean);
		}
		return flag;
	}
	
	public void getSubCategoryList() {
		try {
			
			semmsi004tab2Bean = getSemmsi004tab2Bean();
			
			SelectItem selItem = null;
			List<SelectItem> selList = new ArrayList<SelectItem>();
			List<SelectItem> selTempList = new ArrayList<SelectItem>();

			String myOwnerCatCode = semmsi004tab2Bean.getContract().getOwnerSubCategory();
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			MSA001LovSP lovSP = new MSA001LovSP();
			lovSP.setLovType("CT_SUB_CATEGORY");
			lovSP.setRecordStatus("Y");
			lovSP.setLovName2("");
			lovSP.setLovVal2(myOwnerCatCode);
			
			if(myOwnerCatCode != null && !myOwnerCatCode.equals("")) {
				List<MSA001LovSP> retLst = service.siteAppSiteDao_querySPList(EQueryName.SP_MSA001_SRCH_TEAM.name, lovSP);
		
				if(retLst != null && !retLst.isEmpty()){
					for(MSA001LovSP lov : retLst){
						selItem = new SelectItem();
						selItem.setLabel(lov.getLovName());
						selItem.setValue(lov.getLovCode());
						selList.add(selItem);
					}
					
					// -- insert label '-- select --' at index 0
					if(selList.size() >= 1) {
						selTempList = selList;
						SelectItem selItem_idx0 = new SelectItem();
						selItem_idx0.setLabel("-- Select --");
						selItem_idx0.setValue("");
						
						selList = new ArrayList<SelectItem>();
						selList.add(selItem_idx0);
						
						for(int i = 0;i < selTempList.size();i++){
							SelectItem selItem_idx1 = new SelectItem();
							selItem_idx1.setLabel(selTempList.get(i).getLabel());
							selItem_idx1.setValue(selTempList.get(i).getValue());

							selList.add(selItem_idx1);
						}
//						SelectItem selItem_idx1 = new SelectItem();
//						selItem_idx1.setLabel(selList.get(0).getLabel());
//						selItem_idx1.setValue(selList.get(0).getValue());

//						selList = new ArrayList<SelectItem>();
//						selList.add(selItem_idx0);
//						selList.add(selItem_idx1);
					}
					// --
				} else {
					selItem = new SelectItem();
					selItem.setLabel("-- not found --");
					selItem.setValue("");
					selList.add(selItem);
				}
			} else {
				selItem = new SelectItem();
				selItem.setLabel("-- Select --");
				selItem.setValue("");
				selList.add(selItem);
			}
			semmsi004tab2Bean.getContract().setOwnerSubCategory("");
			semmsi004tab2Bean.setOwnerSubCategoryList(selList);
			
			setSemmsi004tab2Bean(semmsi004tab2Bean);
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			log.debug(e);
		}
	}
}
