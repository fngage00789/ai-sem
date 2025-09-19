package th.co.ais.web.si.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.si.Msi004SeqSubRentSP;
import th.co.ais.domain.si.Msi004SrchSubRentSP;
import th.co.ais.domain.si.SubRent;
import th.co.ais.service.si.ISiteSubRentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab7Bean;

public class SEMMSI004Tab7Action extends AbstractAction {

	private static final long serialVersionUID = -4365395207732624915L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if (methodWithNavi.equalsIgnoreCase("doAddSubRent")) {
			flag = doAddSubRent();
		}
		if (methodWithNavi.equalsIgnoreCase("doUpdateSubRent")) {
			flag = doUpdateSubRent();
		}
		if (methodWithNavi.equalsIgnoreCase("doClearSubRent")) {
			flag = doClearSubRent();
		}
		if (methodWithNavi.equalsIgnoreCase("initUpdateSubRent")) {
			flag = initUpdateSubRent();
		}
		if (methodWithNavi.equalsIgnoreCase("initDeleteSubRent")) {
			flag = initDeleteSubRent();
		}
		if (methodWithNavi.equalsIgnoreCase("doDeleteSubRent")) {
			flag = doDeleteSubRent();
		}
		
		
		return flag;
	}

	private boolean doDeleteSubRent() {
		boolean flag = false;
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			service.deleteSubRent(semmsi004tab7Bean.getSubRent());
			semmsi004tab7Bean.setSubRentSPList(null);
			this.searchSubRent();
			addMessageInfo("M0002");
		}catch(Exception e){
			log.error(e);
			addMessageError("E0002");
		}
		semmsi004tab7Bean.setRenderedMsgFormTop(true);
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab7Bean(semmsi004tab7Bean);
		return flag;
	}

	private boolean initDeleteSubRent() {
		boolean flag = false;
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			String rowId = (String)getFacesUtils().getRequestParameter("rowId");
			if(rowId != null){
				SubRent subRent = service.querySubRentByRowId(rowId);
				if(subRent != null){
					semmsi004tab7Bean.setSubRent(subRent);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab7Bean(semmsi004tab7Bean);
		return flag;
	}

	private boolean initUpdateSubRent() {
		boolean flag = false;
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			SubRent subRent = service.querySubRentByRowId(rowId);
			if(subRent != null){
				semmsi004tab7Bean.setSubRent(subRent);
				semmsi004tab7Bean.setDisabledBtnAdd(true);
				semmsi004tab7Bean.setDisabledBtnSave(false);
				setSemmsi004tab7Bean(semmsi004tab7Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	private boolean doClearSubRent() {
		boolean flag = false;
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		semmsi004tab7Bean.getSubRent().setSubCompany("");
		semmsi004tab7Bean.getSubRent().setSubContractNo("");
		semmsi004tab7Bean.getSubRent().setEffectiveDt(null);
		semmsi004tab7Bean.getSubRent().setExpireDt(null);
		semmsi004tab7Bean.getSubRent().setRentType("01");
		semmsi004tab7Bean.getSubRent().setDetail("");
		semmsi004tab7Bean.setDisabledBtnAdd(false);
		semmsi004tab7Bean.setDisabledBtnSave(true);
		semmsi004tab7Bean.getSubRent().setRentAmt(null);
		semmsi004tab7Bean.getSubRent().setRentPeriodType("");
		setSemmsi004tab7Bean(semmsi004tab7Bean);
		return flag;
	}

	private boolean doUpdateSubRent() {
		boolean flag = false;
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validate()){
			semmsi004tab7Bean.setRenderedMsgFormTop(true);
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab7Bean(semmsi004tab7Bean);
			return flag;
		}
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			semmsi004tab7Bean.getSubRent().setCurrentUser(semmsi004tab7Bean.getUserLogin());
			service.updateSubRent(semmsi004tab7Bean.getSubRent());
			semmsi004tab7Bean.setSubRentSPList(null);
			this.searchSubRent();
			this.doClearSubRent();
			addMessageInfo("M0001");
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab7Bean.setRenderedMsgFormTop(true);
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab7Bean(semmsi004tab7Bean);
		return flag;
	}

	private boolean doAddSubRent() {
		boolean flag = false;
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validate()){
			semmsi004tab7Bean.setRenderedMsgFormTop(true);
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab7Bean(semmsi004tab7Bean);
			return flag;
		}
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			if(semmsi004tab7Bean.getSubRent() != null){
				semmsi004tab7Bean.getSubRent().setCurrentUser(semmsi004tab7Bean.getUserLogin());
				semmsi004tab7Bean.getSubRent().setSeqNo(this.getSubRentSeqNo());
				semmsi004tab7Bean.getSubRent().setSiteInfoId(semmsi004tab7Bean.getSiteInfoId());
				service.createSiteSubRent(semmsi004tab7Bean.getSubRent());
				addMessageInfo("M0001");
				semmsi004tab7Bean.setSubRentSPList(null);
				this.searchSubRent();
				this.doClearSubRent();
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab7Bean.setRenderedMsgFormTop(true);
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab7Bean(semmsi004tab7Bean);
		return flag;
	}
	

	private Integer getSubRentSeqNo() {
		Integer seqNo = 0;
		List<Msi004SeqSubRentSP> to = null;
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			Msi004SeqSubRentSP criteria = new Msi004SeqSubRentSP();
			criteria.setSiteInfoId(getSemmsi004tab7Bean().getSiteInfoId());
			to = service.querySPList(EQueryName.SP_MSI004_SEQ_SUB_RENT.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo subRent [" + seqNo + "]");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return seqNo;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		SEMMSI004Tab7Bean semmsi004tab7Bean = new SEMMSI004Tab7Bean();
		semmsi004tab7Bean.setSubRent(new SubRent());
		semmsi004tab7Bean.setSubRentSPList(new ArrayList<Msi004SrchSubRentSP>());
		semmsi004tab7Bean.setCompanyList(new ArrayList<SelectItem>());
		semmsi004tab7Bean.setRenderedMsgFormTop(false);
		setSemmsi004tab7Bean(semmsi004tab7Bean);
	}
	
	public void initTab7(String siteInfoId) {
		init();
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		semmsi004tab7Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		semmsi004tab7Bean.setSiteInfoId(siteInfoId);
		semmsi004tab7Bean.setDisabledBtnAdd(false);
		semmsi004tab7Bean.setDisabledBtnSave(true);
		semmsi004tab7Bean.getSubRent().setRentType("01");
		this.searchSubRent();
		setSemmsi004tab7Bean(semmsi004tab7Bean);
		
	}

	private void searchSubRent() {
		semmsi004tab7Bean = getSemmsi004tab7Bean();
		List<Msi004SrchSubRentSP> to = null;
		try{
			ISiteSubRentService service = (ISiteSubRentService)getBean("siteSubRentService");
			Msi004SrchSubRentSP criteria = new Msi004SrchSubRentSP();
			criteria.setSiteInfoId(semmsi004tab7Bean.getSiteInfoId());
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_SUB_RENT.name, criteria);
			if(to != null && to.size() > 0){
				List<Msi004SrchSubRentSP> subRentList = new ArrayList<Msi004SrchSubRentSP>();
				for(Msi004SrchSubRentSP subRent : to){
					if(subRent.getEffDate() != null) {
						subRent.setEffDate(convertYearENtoTH(subRent.getEffDate()));
					}
					if(subRent.getExpDate() != null){
						subRent.setExpDate(convertYearENtoTH(subRent.getExpDate()));
					}
					subRentList.add(subRent);
				}
				semmsi004tab7Bean.setSubRentSPList(subRentList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab7Bean(semmsi004tab7Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi004tab7Bean().getSubRent().getSubCompany())){
			addMessageError("W0001", msg("message.subCompany"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(getSemmsi004tab7Bean().getSubRent().getSubContractNo())){
			addMessageError("W0001", msg("message.subContractNo"));
			flgValid = false;
		}
		
		Date effDate = getSemmsi004tab7Bean().getSubRent().getEffectiveDt();
		Date expDate = getSemmsi004tab7Bean().getSubRent().getExpireDt();
		
		if(effDate == null){
			addMessageError("W0001", msg("message.contractEffDate"));
			flgValid = false;
		}
		if(expDate == null){
			addMessageError("W0001", msg("message.contractExpDate"));
			flgValid = false;
		}
		
		if(effDate != null && expDate != null){
			if (effDate.after(expDate)) {
				addMessageErrorWithArgument("W0005" ,msg("message.contractEffDate"), msg("message.contractExpDate"));
				flgValid = false;
			}
		}
		
		return flgValid;
	}
	
	private SEMMSI004Tab7Bean semmsi004tab7Bean;


	public SEMMSI004Tab7Bean getSemmsi004tab7Bean() {
		return (SEMMSI004Tab7Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab7Bean");
	}

	public void setSemmsi004tab7Bean(SEMMSI004Tab7Bean semmsi004tab7Bean) {
		this.semmsi004tab7Bean = semmsi004tab7Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab7Bean", semmsi004tab7Bean);
	}
	private SEMMSI004Bean semmsi004Bean;
	
	public SEMMSI004Bean getSemmsi004Bean() {
		if(semmsi004Bean == null){
			semmsi004Bean = new SEMMSI004Bean();
		}
		return (SEMMSI004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004Bean");
	}

	public void setSemmsi004Bean(SEMMSI004Bean semmsi004Bean) {
		this.semmsi004Bean = semmsi004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004Bean", this.semmsi004Bean);
	}
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}

	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", this.semmsi004tab1Bean);
	}


}
