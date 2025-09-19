package th.co.ais.web.si.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;



import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Electric;
import th.co.ais.domain.si.Msi004CheckEditDepositElectricSP;
import th.co.ais.domain.si.Msi004GenDpstSP;
import th.co.ais.domain.si.Msi004SeqDepositSP;
import th.co.ais.domain.si.Msi004SrchDepositElectricSP;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.domain.si.Msi004SrchSumDpstESP;
import th.co.ais.domain.si.Msi004UpdateNoDepositElectricSP;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteDepositService;
import th.co.ais.service.si.ISiteElectricService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.bean.common.PopupSiteContractBean;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab3Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab5Bean;
import th.co.ais.web.util.FrontMessageUtils;

public class SEMMSI004Tab5Action extends AbstractAction{

	private static final long serialVersionUID = -7897962206372404476L;
	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		if(methodWithNavi.equalsIgnoreCase("doAddDepositElectricNormal")){
			flag = doAddDepositElectricNormal();
		}
		else if(methodWithNavi.equalsIgnoreCase("doUpdateDepositElectricNormal")){
			flag = doUpdateDepositElectricNormal();
		}
		else if(methodWithNavi.equalsIgnoreCase("doClearDepositElectricNormal")){
			flag = doClearDepositElectricNormal();
		}
		else if(methodWithNavi.equalsIgnoreCase("initDeleteDepositElectricNormal")){
			flag = initDeleteDepositElectricNormal();
		}
		else if(methodWithNavi.equalsIgnoreCase("doDeleteDepositElectricNormal")){
			flag = doDeleteDepositElectricNormal();
		}
		else if(methodWithNavi.equalsIgnoreCase("initUpdateDepositElectricNormal")){
			flag = initUpdateDepositElectricNormal();
		}
		else if(methodWithNavi.equalsIgnoreCase("doUpdateDepositElectricSpecial")){
			flag = doUpdateDepositElectricSpecial();
		}
		else if(methodWithNavi.equalsIgnoreCase("doSaveTotalDepositElectric")){
			flag = doSaveTotalDepositElectric();
		}else if(methodWithNavi.equalsIgnoreCase("doAddSiteAppELCond")){
			flag = this.doAddSiteAppELCond();
		}else if(methodWithNavi.equalsIgnoreCase("doUpdateSiteAppELCond")){
			flag = this.doUpdateSiteAppELCond();
		}else if(methodWithNavi.equalsIgnoreCase("doClearSiteAppEl")){
			flag = this.doClearSiteAppEl();
		}else if(methodWithNavi.equalsIgnoreCase("doEditEL")){
			flag = 	this.doEditEL();
		}else if(methodWithNavi.equalsIgnoreCase("doDetSiteAppELCond")){
			flag = 	this.doDetSiteAppELCond();
		}else if(methodWithNavi.equalsIgnoreCase("doCheckElChange")){
			flag = 	this.doCheckElChange();
		}else if(methodWithNavi.equalsIgnoreCase("doCheckElDepositChange")){
			flag = 	this.doCheckElDepositChange();
		}
		
		
		return flag;
	}
	
	private boolean doSaveTotalDepositElectric() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			if(semmsi004tab5Bean.isChkNoDepositElectric()){
				try{
					// CALL SP_MSI004_UPD_NO_DEPOSIT_E
					List<Msi004UpdateNoDepositElectricSP> to = null;
					Msi004UpdateNoDepositElectricSP criteria = new Msi004UpdateNoDepositElectricSP();
					criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
					criteria.setCurrentUser(semmsi004tab5Bean.getUserLogin());
					to = service.querySPList(EQueryName.SP_MSI004_UPD_NO_DEPOSIT_E.name, criteria);
					if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
						log.debug("no deposit rent result [" + to.get(0).getResultMsg());
						semmsi004tab5Bean.setDepositElectricBgSPList(null);
						semmsi004tab5Bean.setDepositElectricCashSPList(null);
						getSemmsi004tab1Action().getSiteElectricBySiteInfoId(semmsi004tab5Bean.getSiteInfoId());
						semmsi004tab5Bean.setSiteElectric(getSemmsi004tab1Bean().getSiteElectric());
						this.getDepositElectricSpecial("02"); // special
						addMessageInfo("M0001");
					}
				}catch(Exception e){
					e.printStackTrace();
					addMessageError("E0001");
				}
			}else{
				try{
					String depositCondType = semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType();
					// normal
					if(depositCondType.equals("01")){
						// delete deposit special
						this.deleteDepositSpecial();
						// update site electric
						this.updateSiteElectric();
					}else{
						// special
						if(!validateDepositSpecial()){
							semmsi004tab1Bean.setRenderedMsgFormSearch(false);
							semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
							semmsi004tab5Bean.setRenderedMsgFormBottom(true);
							setSemmsi004tab1Bean(semmsi004tab1Bean);
							setSemmsi004tab5Bean(semmsi004tab5Bean);
							return flag;
						}
						this.doUpdateDepositElectricSpecial();
					}
				}catch(Exception e){
					e.printStackTrace();
					addMessageError("E0001");
				}
			}
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
			semmsi004tab5Bean.setRenderedMsgFormBottom(true);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}

	private boolean validateDepositSpecial() {
		boolean flgValid = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(!StringUtils.isEmpty(semmsi004tab5Bean.getElectricDepositSpecialBg().getDetail()) &&
				semmsi004tab5Bean.getTotalDeposit().getTotalDepositBgAmt() == null){
				addMessageError("W0001", msg("message.totalDepositBgAmt"));
				flgValid = false;
			}
			if(!StringUtils.isEmpty(semmsi004tab5Bean.getElectricDepositSpecialCash().getDetail()) &&
				semmsi004tab5Bean.getTotalDeposit().getTotalDepositCashAmt() == null){
					addMessageError("W0001", msg("message.totalDepositCashAmt"));
					flgValid = false;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flgValid;
	}

	private boolean doUpdateDepositElectricSpecial() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
			// delete deposit electric normal
			this.deleteDepositElectricNormal();
			// udpate site electric
//			this.updateSiteElectric();
			// BG
			if(semmsi004tab5Bean.getElectricDepositSpecialBg().getDetail() != null){
				// update deposit special Bg
				String rowId = semmsi004tab5Bean.getElectricDepositSpecialBg().getRowId();
				if(rowId != null){
					Deposit depositBg = service.queryDepositByRowId(rowId);
					if(depositBg != null){
						depositBg.setCurrentUser(semmsi004tab5Bean.getUserLogin());
						depositBg.setDetail(semmsi004tab5Bean.getElectricDepositSpecialBg().getDetail());
						service.updateDeposit(depositBg);
						
					}
				}else{
					
					// insert deposit electric special BG
					semmsi004tab5Bean.getElectricDepositSpecialBg().setCurrentUser(semmsi004tab5Bean.getUserLogin());
					semmsi004tab5Bean.getElectricDepositSpecialBg().setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
					semmsi004tab5Bean.getElectricDepositSpecialBg().setSeqNo(1);
					semmsi004tab5Bean.getElectricDepositSpecialBg().setNewStatus("Y");
					semmsi004tab5Bean.getElectricDepositSpecialBg().setExpenseType("08");
					semmsi004tab5Bean.getElectricDepositSpecialBg().setDepositCondType("02");
					semmsi004tab5Bean.getElectricDepositSpecialBg().setDepositType("01"); // BG
					service.createSiteDeposit(semmsi004tab5Bean.getElectricDepositSpecialBg());
					
				}
			}
			// Cash
			if(semmsi004tab5Bean.getElectricDepositSpecialCash().getDetail() != null){
				// update deposit special Cash
				String rowId = semmsi004tab5Bean.getElectricDepositSpecialCash().getRowId();
				if(rowId != null){
					Deposit depositCash = service.queryDepositByRowId(rowId);
					if(depositCash != null){
						depositCash.setCurrentUser(semmsi004tab5Bean.getUserLogin());
						depositCash.setDetail(semmsi004tab5Bean.getElectricDepositSpecialCash().getDetail());
						depositCash.setVatType(semmsi004tab5Bean.getElectricDepositSpecialCash().getVatType());
						service.updateDeposit(depositCash);
					}
				}else{
					// insert deposit electric special Cash
					semmsi004tab5Bean.getElectricDepositSpecialCash().setCurrentUser(semmsi004tab5Bean.getUserLogin());
					semmsi004tab5Bean.getElectricDepositSpecialCash().setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
					semmsi004tab5Bean.getElectricDepositSpecialCash().setSeqNo(2);
					semmsi004tab5Bean.getElectricDepositSpecialCash().setNewStatus("Y");
					semmsi004tab5Bean.getElectricDepositSpecialCash().setExpenseType("08");
					semmsi004tab5Bean.getElectricDepositSpecialCash().setDepositCondType("02");
					semmsi004tab5Bean.getElectricDepositSpecialCash().setDepositType("02"); // Cash
					service.createSiteDeposit(semmsi004tab5Bean.getElectricDepositSpecialCash());
					
				}
			}
			// get sum deposit electric for update table site electric
//			this.searchSumDepositElectric();
			this.updateElectric();
			this.updateSiteInfoDepositElectricEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("5-1");
//			addMessageInfo("M0001");
		}catch(Exception e){
			e.printStackTrace();
//			addMessageError("E0001");
		}
//		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
//		semmsi004tab5Bean.setRenderedMsgFormMiddle(true);
//		semmsi004tab5Bean.setRenderedMsgFormBottom(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
		return flag;
		
	}

	private void updateElectric() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Electric electric = service.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			if(electric != null){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType().equals("01")){
					// Normal
					electric.setTotalDepositBgAmt(semmsi004tab5Bean.getSumDepositElectric().getDepositBgAmt());
					electric.setTotalDepositCashAmt(semmsi004tab5Bean.getSumDepositElectric().getDepositCashAmt());
				}else{
					// Special
					electric.setTotalDepositBgAmt(semmsi004tab5Bean.getTotalDeposit().getTotalDepositBgAmt());
					electric.setTotalDepositCashAmt(semmsi004tab5Bean.getTotalDeposit().getTotalDepositCashAmt());
				}
				electric.setDepositCondType(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				electric.setCurrentUser(semmsi004tab5Bean.getUserLogin());
				semmsi004tab5Bean.setSiteElectric(service.updateSiteElectric(electric));
				setSemmsi004tab5Bean(semmsi004tab5Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void updateSiteInfoElectricEditFlag() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String siteInfoId = semmsi004tab5Bean.getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab5Bean.getUserLogin());
				siteInfo.setElectricEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void updateSiteInfoDepositElectricEditFlag() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String siteInfoId = semmsi004tab5Bean.getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab5Bean.getUserLogin());
				siteInfo.setDepositElectricEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void deleteDepositElectricNormal() {
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			this.searchElectricDepositBG("01");
			this.searchElectricDepositCash("01");
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			// delete BG
			List<Msi004SrchDepositElectricSP> bgList = semmsi004tab5Bean.getDepositElectricBgSPList();
			if(bgList != null && bgList.size() > 0){
				for(Msi004SrchDepositElectricSP bg : bgList){
					Deposit deposit = service.queryDepositByRowId(bg.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
				}
			}
			// delete Cash
			List<Msi004SrchDepositElectricSP> cashList = semmsi004tab5Bean.getDepositElectricCashSPList();
			if(cashList != null && cashList.size() > 0){
				for(Msi004SrchDepositElectricSP cash : cashList){
					Deposit deposit = service.queryDepositByRowId(cash.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private boolean initUpdateDepositElectricNormal() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Deposit deposit = service.queryDepositByRowId(rowId);
			if(deposit != null){
				this.doClearDepositElectricNormal();
				semmsi004tab5Bean.setDisabledOldInsurance(true);
				log.debug("vatType : "+deposit.getVatType());
				semmsi004tab5Bean.setElectricDepositNormal(deposit);
				semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(true);
				semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(false);
				if(deposit.getVatType() != null && deposit.getDepositType().equals("02")){
					semmsi004tab5Bean.setRenderVatType(true);
				}else{
					semmsi004tab5Bean.setRenderVatType(false);
				}
				setSemmsi004tab5Bean(semmsi004tab5Bean);
				
				this.doInitDepositEl();
				this.doRenderEditDeptBgCashEl();
				this.initUpdDeptReturnTypeEl();
				this.doCalDepositElReturnAmt();
				this.doCalDepositElAmt();
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean doClearDepositElectricNormal() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.setElectricDepositNormal(new Deposit());
		semmsi004tab5Bean.getElectricDepositNormal().setDepositCondType("01");
		semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(null);
		semmsi004tab5Bean.getElectricDepositNormal().setRemark("");
		semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
		semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(true);
		semmsi004tab5Bean.setRenderVatType(true);
		//Adding by JOHN
		semmsi004tab5Bean.getElectricDepositNormal().setDepositType("02");
		semmsi004tab5Bean.getElectricDepositNormal().setVatType("01");
		this.initUpdDeptElReturnType();
		this.doRenderDeptBgCashEl();
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}

	private boolean doUpdateDepositElectricNormal() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateDepositElectricNormal()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab5Bean.setRenderedMsgFormMiddle(true);
			semmsi004tab5Bean.setRenderedMsgFormBottom(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			return flag;
		}
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			if(semmsi004tab5Bean.getElectricDepositNormal().getRowId() != null){
				semmsi004tab5Bean.getElectricDepositNormal().setCurrentUser(semmsi004tab5Bean.getUserLogin());
				//clear deposit to null when select deposite type to BG.
//				if(StringUtils.equals(semmsi004tab5Bean.getElectricDepositNormal().getDepositType(), "01")){
//					semmsi004tab5Bean.getElectricDepositNormal().setVatType("");
//				}
				
				//Adding by JOHN 31/05/2011
				boolean chkNewStatus = semmsi004tab5Bean.getElectricDepositNormal().isChkNewStatus();
				if(chkNewStatus)
				semmsi004tab5Bean.getElectricDepositNormal().setNewStatus("N");
				else
				semmsi004tab5Bean.getElectricDepositNormal().setNewStatus("Y");
				
				if(semmsi004tab5Bean.isWithdrawFlagEl()){
					semmsi004tab5Bean.getElectricDepositNormal().setWithdrawFlag("Y");
				}else{
					semmsi004tab5Bean.getElectricDepositNormal().setWithdrawFlag("");
				}
				
				service.updateDeposit(semmsi004tab5Bean.getElectricDepositNormal());
				addMessageInfo("M0001");
				this.updateSiteInfoDepositElectricEditFlag();
				
				/*if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType().equals("01")){
					semmsi004tab5Bean.setDepositElectricBgSPList(null);
					this.searchElectricDepositBG(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				}else{
					semmsi004tab5Bean.setDepositElectricCashSPList(null);
					this.searchElectricDepositCash(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				}*/
				
				semmsi004tab5Bean.setDepositElectricCashSPList(null);
				semmsi004tab5Bean.setDepositElectricBgSPList(null);
				this.searchElectricDepositBG(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				this.searchElectricDepositCash(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				
				semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
				semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(true);
				this.doClearDepositElectricNormal();
				// get sum deposit for update table site electric
				this.searchSumDepositElectric();
				this.updateElectric();
				// approve siteInfoId
				getSemmsi004Action().approveSiteInfo("5-1");
			}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(true);
		semmsi004tab5Bean.setRenderedMsgFormBottom(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
		return flag;
	}

	private boolean doAddDepositElectricNormal() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateDepositElectricNormal()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab5Bean.setRenderedMsgFormMiddle(true);
			semmsi004tab5Bean.setRenderedMsgFormBottom(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			return flag;
		}
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			// delete deposit special
			this.deleteDepositSpecial();
			// update site electric
//			this.updateSiteElectric();
			// insert deposit electric
			semmsi004tab5Bean.getElectricDepositNormal().setNewStatus("Y");
			semmsi004tab5Bean.getElectricDepositNormal().setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			semmsi004tab5Bean.getElectricDepositNormal().setExpenseType("08");
			semmsi004tab5Bean.getElectricDepositNormal().setCurrentUser(semmsi004tab5Bean.getUserLogin());
			semmsi004tab5Bean.getElectricDepositNormal().setSeqNo(this.getDepositeElectricSeqNo());
			// depositType is BG set VatType = null
//			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType().equals("01")){
//				semmsi004tab5Bean.getElectricDepositNormal().setVatType(null);
//			}
			
			if(semmsi004tab5Bean.isWithdrawFlagEl()){
				semmsi004tab5Bean.getElectricDepositNormal().setWithdrawFlag("Y");
			}else{
				semmsi004tab5Bean.getElectricDepositNormal().setWithdrawFlag("");
			}
			
			//Adding by JOHN 31/05/2011
			boolean chkNewStatus = semmsi004tab5Bean.getElectricDepositNormal().isChkNewStatus();
			if(chkNewStatus)
			semmsi004tab5Bean.getElectricDepositNormal().setNewStatus("N");
			else
			semmsi004tab5Bean.getElectricDepositNormal().setNewStatus("Y");
			
			Deposit deposit = service.createSiteDeposit(semmsi004tab5Bean.getElectricDepositNormal());
			
			addMessageInfo("M0001");
			this.updateSiteInfoDepositElectricEditFlag();
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType().equals("01")){
				semmsi004tab5Bean.setDepositElectricBgSPList(null);
				this.searchElectricDepositBG(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				
			}else{
				semmsi004tab5Bean.setDepositElectricCashSPList(null);
				this.searchElectricDepositCash(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
			}
			
			// disabled checkbox no deposit
			if((semmsi004tab5Bean.getDepositElectricBgSPList() != null && !semmsi004tab5Bean.getDepositElectricBgSPList().isEmpty()) ||
			   (semmsi004tab5Bean.getDepositElectricCashSPList() != null && !semmsi004tab5Bean.getDepositElectricCashSPList().isEmpty())){
				semmsi004tab5Bean.setDisabledChkNoDeposit(true);
			}else{
				semmsi004tab5Bean.setDisabledChkNoDeposit(false);
			}
			this.doClearDepositElectricNormal();
			// get sum deposit electric for update table site electric
			this.searchSumDepositElectric();
			this.updateElectric();
			
			if(deposit!=null){
				callMsi004GenDPST(deposit.getRowId(), EQueryName.SP_MSI004_GEN_DPST_E_ADD.name);
			}
			
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("5-1");
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(true);
		semmsi004tab5Bean.setRenderedMsgFormBottom(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}
	
	public String callMsi004GenDPST(String siteDepositeId, String queryName) {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String result = "";
		List<Msi004GenDpstSP> to = null;
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			Msi004GenDpstSP criteria = new Msi004GenDpstSP();
			criteria.setSiteDepositeId(siteDepositeId);
			criteria.setUserId(getUserLogIn());
			to = siteInfoService.querySPList(queryName, criteria);
			log.debug("sum deposit rent size [" + to.size() + "]");
			if(to != null && to.size() > 0){
				result = to.get(0).getResult();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	private Integer getDepositeElectricSeqNo() {
		Integer seqNo = 0;
		
		List<Msi004SeqDepositSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SeqDepositSP criteria = new Msi004SeqDepositSP();
			criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			to = service.querySPList(EQueryName.SP_MSI004_SEQ_DEPOSIT.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo deposit [" + seqNo + "]");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return seqNo;
	}

	private void updateSiteElectric() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Electric electric = service.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			if(electric != null){
				electric.setDepositCondType(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType());
				if(semmsi004tab5Bean.isChkNoDepositElectric()){
					electric.setNoDeposit("Y");
				}else{
					electric.setNoDeposit(null);
				}
				electric.setCurrentUser(semmsi004tab5Bean.getUserLogin());
				semmsi004tab5Bean.setSiteElectric(service.updateSiteElectric(electric));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
	}

	private void deleteDepositSpecial() {
		
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			this.getDepositElectricSpecial("02");
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			List<Msi004SrchDepositElectricSP> list = semmsi004tab5Bean.getElectricDepositSpecialSPList();
			if(list != null && list.size() > 0){
				for(Msi004SrchDepositElectricSP electricSpecial : list){
					Deposit deposit = service.queryDepositByRowId(electricSpecial.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
						
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void initTab5(String siteInfoId) {
		init();
		popupSiteContractBean = new PopupSiteContractBean();
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		semmsi004tab5Bean.setSiteInfoId(siteInfoId);
		semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(null);
		semmsi004tab5Bean.getSiteElectric().setRemark(null);
		getSemmsi004tab1Action().getSiteElectricBySiteInfoId(semmsi004tab5Bean.getSiteInfoId());
		Electric electric = getSemmsi004tab1Bean().getSiteElectric();
		semmsi004tab5Bean.setChkNoExpenses(false);
		if(electric != null){
			semmsi004tab5Bean.setSiteElectric(electric);
			semmsi004tab5Bean.setTotalDeposit(electric);
			this.setElectricData();
			if(!electric.getElectricType3().equals("")){ // electric.getElectricType3() != null 
				this.setPayPeriodType(electric);
			}
			// check depositCondType
				if(StringUtils.equals("Y", electric.getNoDeposit())){
					semmsi004tab5Bean.setChkNoDepositElectric(true);
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(false);
				}
			
				if(electric.getDepositCondType() != null && electric.getDepositCondType().equals("01")){
					semmsi004tab5Bean.setRenderElectricDepositNormal(true);
					semmsi004tab5Bean.setRenderElectricDepositSpecial(false);
					semmsi004tab5Bean.setDepositElectricBgSPList(null);
					semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
					semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(true);
					semmsi004tab5Bean.getElectricDepositNormal().setDepositType("02");
					semmsi004tab5Bean.getElectricDepositNormal().setDepositCondType(electric.getDepositCondType());
					//Adding by JOHN
					semmsi004tab5Bean.setRenderVatType(true);
					semmsi004tab5Bean.getElectricDepositNormal().setVatType("01");
					this.searchElectricDepositBG(electric.getDepositCondType());
					semmsi004tab5Bean.setDepositElectricCashSPList(null);
					this.searchElectricDepositCash(electric.getDepositCondType());
					// disabled checkbox no deposit
					if(!StringUtils.equals("Y", electric.getNoDeposit())){
						if((semmsi004tab5Bean.getDepositElectricBgSPList() != null && !semmsi004tab5Bean.getDepositElectricBgSPList().isEmpty()) ||
								   (semmsi004tab5Bean.getDepositElectricCashSPList() != null && !semmsi004tab5Bean.getDepositElectricCashSPList().isEmpty())){
									semmsi004tab5Bean.setDisabledChkNoDeposit(true);
						}else{
									semmsi004tab5Bean.setDisabledChkNoDeposit(false);
						}
					}
					
				}else if(electric.getDepositCondType() != null && electric.getDepositCondType().equals("02")){
					semmsi004tab5Bean.setRenderElectricDepositSpecial(true);
					semmsi004tab5Bean.setRenderElectricDepositNormal(false);
					semmsi004tab5Bean.getElectricDepositSpecialCash().setVatType("01");
					semmsi004tab5Bean.getElectricDepositNormal().setDepositCondType(electric.getDepositCondType());
					this.getDepositElectricSpecial(electric.getDepositCondType());
				}else{
						semmsi004tab5Bean.setRenderElectricDepositNormal(true);
						semmsi004tab5Bean.setRenderElectricDepositSpecial(false);
						semmsi004tab5Bean.getElectricDepositNormal().setDepositType("02"); //default Cash
						semmsi004tab5Bean.getElectricDepositNormal().setDepositCondType("01");
						semmsi004tab5Bean.setRenderVatType(false);
						semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
						semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(true);
						semmsi004tab5Bean.setDepositElectricBgSPList(null);
						semmsi004tab5Bean.setDepositElectricCashSPList(null);
						semmsi004tab5Bean.setDisabledChkNoDeposit(false);
				}
			// set log
			this.setAuditlog();
			
		}else{
			// set default 
			this.setDefaultElectric();
			semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			semmsi004tab5Bean.getElectricDepositNormal().setDepositCondType("01");
			semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
			semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(true);
			semmsi004tab5Bean.setChkNoDepositElectric(false);
			
		}
		// check mode
		this.checkMode();
		
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		setSemmsi004tab2Bean(semmsi004tab2Bean);
		setPopupSiteContractBean(popupSiteContractBean);
		//Check NoExpenses
		checkNoExpenses();
		
		//TODO init TAB5
		this.doSiteAppELCondSrch();
		if(semmsi004tab5Bean.isChkElectricType3()){
			//this.doSiteAppELCondSrch("U");
			//this.doSiteAppELCondSrch("T");
			//this.doSiteAppELCondSrch("N");
			
//			if(semmsi004tab5Bean.getSiteAppELCondUnitList() != null && semmsi004tab5Bean.getSiteAppELCondUnitList().size() > 0){
//				semmsi004tab5Bean.setRenderedTbElUnit(true);
//			}else{
//				semmsi004tab5Bean.setRenderedTbElUnit(false);
//			}
//			
//			if(semmsi004tab5Bean.getSiteAppELCondTakeAllList() != null && semmsi004tab5Bean.getSiteAppELCondTakeAllList().size() > 0){
//				semmsi004tab5Bean.setRenderedTbElTakeAll(true);
//			}else{
//				semmsi004tab5Bean.setRenderedTbElTakeAll(false);
//			}
		}
		
		if(semmsi004tab5Bean.isChkElectricType4()){
			//this.doSiteAppELCondSrch("O");
			if(semmsi004tab5Bean.getSiteAppELCondTakeAllList() != null && semmsi004tab5Bean.getSiteAppELCondTakeAllList().size() > 0){
				semmsi004tab5Bean.setRenderedTbElUseOth(true);
			}else{
				semmsi004tab5Bean.setRenderedTbElUseOth(false);
			}
		}
		
		this.doRenderDeptBgCashEl();
	}
	
	private void checkNoExpenses(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		//Check NoExpenses
		if("Y".equalsIgnoreCase(semmsi004tab5Bean.getSiteElectric().getElectricType3()) && "00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
			semmsi004tab5Bean.setChkNoExpenses(true);
//			semmsi004tab5Bean.setChkElectricType3(false);
			semmsi004tab5Bean.setRenderedElectricOwnerType(false);
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}
	
	public void checkMode() {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				if(getSemmsi004tab1Bean().getCancelableFlag() != null &&
				   getSemmsi004tab1Bean().getCancelableFlag().equals("N")){
					// check deposit electric flag
					this.checkDepositElectricFlag();
					if(getSemmsi004tab5Bean().getEditableDepositElectricFlag() != null &&
					   getSemmsi004tab5Bean().getEditableDepositElectricFlag().equals("Y")){
						semmsi004tab5Bean.setDisabledDepositElectric(false);
						semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
						// special
						if(semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType() != null &&
						   semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType().equals("02")){
							semmsi004tab5Bean.setDisabledTotalNormalDeposit(false);
						}else{
							semmsi004tab5Bean.setDisabledTotalNormalDeposit(true);
						}
					}else{
						semmsi004tab5Bean.setDisabledDepositElectric(true);
						semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(true);
						semmsi004tab5Bean.setDisabledTotalNormalDeposit(true);
						semmsi004tab5Bean.setDisabledChkNoDeposit(true);
					}
				}
			}else{
				// MODE VIEW
				semmsi004tab5Bean.setDisabledTakeAllAmt(true);
				semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab5Bean.setDisabledSiteContractNo(true);
				semmsi004tab5Bean.setDisabledDepositElectric(true);
				semmsi004tab5Bean.setDisabledTotalNormalDeposit(true);
				semmsi004tab5Bean.setDisabledChkNoDeposit(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void checkDepositElectricFlag() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		List<Msi004CheckEditDepositElectricSP> to = null;
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Msi004CheckEditDepositElectricSP criteria = new Msi004CheckEditDepositElectricSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_DPST_E.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable deposit electric flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab5Bean.setEditableDepositElectricFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void setAuditlog() {
		Electric electric = getSemmsi004tab1Bean().getSiteElectric();
		if(electric != null){
			semmsi004Bean = getSemmsi004Bean();
			semmsi004Bean.setCreateBy(electric.getCreateBy());
			semmsi004Bean.setCreateDate(electric.getCreateDt());
			semmsi004Bean.setUpdateBy(electric.getUpdateBy());
			semmsi004Bean.setUpdateDate(electric.getUpdateDt());
			setSemmsi004Bean(semmsi004Bean);
		}
		
	}

	private void setPayPeriodType(Electric electric) {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String payPeriodType = electric.getPayPeriodType();
		if(payPeriodType != null){
			if(payPeriodType.equals("01")){
				semmsi004tab5Bean.setPayPeriodType01(payPeriodType);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsi004tab5Bean.setPayPeriodType02(payPeriodType);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(electric.getPayPeriod() != null && electric.getPayPeriod() == 0){
					semmsi004tab5Bean.setPayPeriod03(null);
				}else{
					semmsi004tab5Bean.setPayPeriod03(electric.getPayPeriod());
				}
				semmsi004tab5Bean.setPayPeriodType03(payPeriodType);
				semmsi004tab5Bean.setDisabledPayPeriod03(false);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(electric.getPayPeriod() != null && electric.getPayPeriod() == 0){
					semmsi004tab5Bean.setPayPeriod04(null);
				}else{
					semmsi004tab5Bean.setPayPeriod04(electric.getPayPeriod());
				}
				semmsi004tab5Bean.setPayPeriodType04(payPeriodType);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsi004tab5Bean.setPayPeriodType05(payPeriodType);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
		}else{
			//set default
			semmsi004tab5Bean.setPayPeriodType01("01");
			semmsi004tab5Bean.setPayPeriod03(null);
			semmsi004tab5Bean.setPayPeriod04(null);
			semmsi004tab5Bean.setDisabledPayPeriod03(true);
			semmsi004tab5Bean.setDisabledPayPeriod04(true);
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void searchSumDepositElectric() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		List<Msi004SrchSumDpstESP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchSumDpstESP criteria = new Msi004SrchSumDpstESP();
			criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_SUM_DPST_E.name, criteria);
			if(to != null && to.size() > 0){
				semmsi004tab5Bean.setSumDepositElectric(to.get(0));
				if(semmsi004tab5Bean.getSumDepositElectric().getDepositBgAmt() != null &&
				   semmsi004tab5Bean.getSumDepositElectric().getDepositBgAmt() == 0.00){
					semmsi004tab5Bean.getSumDepositElectric().setDepositBgAmt(null);
				}else{
					semmsi004tab5Bean.getTotalDeposit().setTotalDepositBgAmt(semmsi004tab5Bean.getSumDepositElectric().getDepositBgAmt());
				}
				if(semmsi004tab5Bean.getSumDepositElectric().getDepositCashAmt() != null &&
				   semmsi004tab5Bean.getSumDepositElectric().getDepositCashAmt() == 0.00){
						semmsi004tab5Bean.getSumDepositElectric().setDepositCashAmt(null);
				}else{
					semmsi004tab5Bean.getTotalDeposit().setTotalDepositCashAmt(semmsi004tab5Bean.getSumDepositElectric().getDepositCashAmt());
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void setElectricData() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		Electric electric = semmsi004tab5Bean.getSiteElectric();
		semmsi004tab5Bean.setRenderedElectricOwnerType(false);
		if(electric.getElectricOwnerType() == null){
			semmsi004tab5Bean.getSiteElectric().setElectricOwnerType("01");
		}
		
		
		if(electric.getNoUnitPriceFlag() != null && electric.getNoUnitPriceFlag().equals("Y")){
			if(StringUtils.isEmpty(electric.getVatType())){
				semmsi004tab5Bean.getSiteElectric().setVatType("");
			}
		}else{
			if(electric.getVatType() != null){
				semmsi004tab5Bean.getSiteElectric().setVatType(electric.getVatType());
			}else{
				semmsi004tab5Bean.getSiteElectric().setVatType("01");
			}			
		}
		if(electric.getElectricType1() != null && StringUtils.equals("Y", electric.getElectricType1())){
			semmsi004tab5Bean.setChkElectricType1(true);
			semmsi004tab5Bean.getSiteElectric().setElectricType1("Y");
		}else{
			semmsi004tab5Bean.setChkElectricType1(false);
			semmsi004tab5Bean.getSiteElectric().setElectricType1("");
		}
		if(electric.getElectricType2() != null && StringUtils.equals("Y", electric.getElectricType2())){
			semmsi004tab5Bean.setChkElectricType2(true);
			semmsi004tab5Bean.getSiteElectric().setElectricType2("Y");
		}else{
			semmsi004tab5Bean.setChkElectricType2(false);
			semmsi004tab5Bean.getSiteElectric().setElectricType2("");
		}
		if(electric.getElectricType3() != null && StringUtils.equals("Y", electric.getElectricType3())){
			semmsi004tab5Bean.setChkElectricType3(true);
			semmsi004tab5Bean.getSiteElectric().setElectricType3("Y");
			semmsi004tab5Bean.setRenderedElectricOwnerType(true);
			if(electric.getElectricOwnerType() != null){
				if(electric.getElectricOwnerType().equals("01")){
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
					if(electric.getNoUnitPriceFlag() != null && electric.getNoUnitPriceFlag().equals("Y")){
						semmsi004tab5Bean.setChkNoUnitPriceFlag(true);
						semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
					}else{
						semmsi004tab5Bean.setDisabledUnitPriceAmt(false);
						semmsi004tab5Bean.setChkNoUnitPriceFlag(false);
					}
				}else{
					semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
					semmsi004tab5Bean.setDisabledChkNoUnitPriceFlag(true);
					semmsi004tab5Bean.setChkNoUnitPriceFlag(false);
				}
				
				if(electric.getElectricOwnerType().equals("02")){
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
					semmsi004tab5Bean.setDisabledTakeAllAmt(false);
				}else{
					semmsi004tab5Bean.setDisabledTakeAllAmt(true);
				}
				if(electric.getElectricOwnerType().equals("00")){
					semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
					semmsi004tab5Bean.setDisabledTakeAllAmt(true);
					semmsi004tab5Bean.setRenderedVatType(false);
					semmsi004tab5Bean.setChkNoUnitPriceFlag(false);
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(false);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
				}else{
					semmsi004tab5Bean.setRenderedVatType(true);
					if(electric.getNoDeposit() != null && electric.getNoDeposit().equals("Y")){
						semmsi004tab5Bean.setChkNoDepositElectric(true);
						semmsi004tab5Bean.setNoDepositElectric("Y");
						semmsi004tab5Bean.setRenderedNoDepositElectric(false);
						semmsi004tab5Bean.setRenderedNoDepositElectric2(true);
						
					}else{
						semmsi004tab5Bean.setChkNoDepositElectric(false);
						semmsi004tab5Bean.setNoDepositElectric("N");
						semmsi004tab5Bean.setRenderedNoDepositElectric(true);
						semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
					}
				}
			}
			
			// CHECK DEPOSIT ELECTRIC
			if(checkDepositElectric()){
				semmsi004tab5Bean.setChkNoDepositElectric(false);
				semmsi004tab5Bean.setNoDepositElectric("N");
			}else{
				semmsi004tab5Bean.setChkNoDepositElectric(true);
				semmsi004tab5Bean.setNoDepositElectric("Y");
			}
			
		}else{
			semmsi004tab5Bean.setChkElectricType3(false);
			semmsi004tab5Bean.getSiteElectric().setElectricType3("");
			semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
		}
		
		if(electric.getElectricType4() != null  && StringUtils.equals("Y", electric.getElectricType4())){
			semmsi004tab5Bean.setChkElectricType4(true);
			semmsi004tab5Bean.getSiteElectric().setElectricType4("Y");
			semmsi004tab5Bean.setDisabledSiteContractNo(false);
		}else{
			semmsi004tab5Bean.setChkElectricType4(false);
			semmsi004tab5Bean.getSiteElectric().setElectricType4("");
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
		}
		if(electric.getElectricType5() != null  && StringUtils.equals("Y", electric.getElectricType5())){
			semmsi004tab5Bean.setChkElectricType5(true);
			semmsi004tab5Bean.getSiteElectric().setElectricType5("Y");
			semmsi004tab5Bean.setDisabledSiteContractNo(false);
		}else{
			semmsi004tab5Bean.setChkElectricType5(false);
			semmsi004tab5Bean.getSiteElectric().setElectricType5("");
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
		}
		if(electric.getElectricType6() != null  && StringUtils.equals("Y", electric.getElectricType6())){
			semmsi004tab5Bean.setChkElectricType6(true);
			semmsi004tab5Bean.getSiteElectric().setElectricType6("Y");
			semmsi004tab5Bean.setDisabledSiteContractNo(false);
		}else{
			semmsi004tab5Bean.setChkElectricType6(false);
			semmsi004tab5Bean.getSiteElectric().setElectricType6("");
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
		}
		if(electric.getMultiElectricTypeFlag() != null  && StringUtils.equals("Y", electric.getMultiElectricTypeFlag())){
			semmsi004tab5Bean.setChkMultiElectricTypeFlag(true);
			semmsi004tab5Bean.getSiteElectric().setMultiElectricTypeFlag("Y");
		}else{
			semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
			semmsi004tab5Bean.getSiteElectric().setMultiElectricTypeFlag("");
		}
		if(electric.getFromContractNo() != null){
			getPopupSiteContractBean().setContractNo(electric.getFromContractNo());
			setPopupSiteContractBean(getPopupSiteContractBean());
		}
//		if(electric.getElectricType1() == null && electric.getElectricType2() == null &&
//				electric.getElectricType3() == null && electric.getElectricType4() == null){
//			semmsi004tab5Bean.setChkElectricType1(true);
//		}
		semmsi004tab5Bean.getSiteElectric().setElectricOwnerType(electric.getElectricOwnerType());
		if(electric.getUnitPriceAmt() != null && electric.getUnitPriceAmt() == 0.00){
			semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(null);
		}else{
			semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(electric.getUnitPriceAmt());
		}
		if(electric.getTakeAllAmt() != null && electric.getTakeAllAmt() == 0.00){
			semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(null);
			semmsi004tab5Bean.getSiteElectric().setTakeAllPeriodType(null);
		}else{
			semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(electric.getTakeAllAmt());
		}
		
		
		
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
	}

	private void setDefaultElectric() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.setChkElectricType1(true);
		semmsi004tab5Bean.setChkElectricType2(false);
		semmsi004tab5Bean.setChkElectricType3(false);
		semmsi004tab5Bean.setChkElectricType4(false);
		semmsi004tab5Bean.setChkElectricType5(false);
		semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
		semmsi004tab5Bean.getSiteElectric().setElectricType1("Y");
		semmsi004tab5Bean.getSiteElectric().setPayPeriodType("01");
		semmsi004tab5Bean.getSiteElectric().setElectricOwnerType("01");
		semmsi004tab5Bean.getSiteElectric().setVatType("01");
		semmsi004tab5Bean.getElectricDepositNormal().setDepositCondType("01");
		
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void getDepositElectricSpecial(String depositCondType) {
		List<Msi004SrchDepositElectricSP> to = null;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
			criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			criteria.setDepositCondType(depositCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
			log.debug("search deposit special size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab5Bean.setElectricDepositSpecialSPList(new ArrayList<Msi004SrchDepositElectricSP>());
				for(Msi004SrchDepositElectricSP elObj : to){
					if(elObj.getContStartDt() != null){
						elObj.setContStartDtStr(convertYearENtoTHStr(elObj.getContStartDt()));
					}
					
					if(elObj.getContEndDt() != null){
						elObj.setContEndDtStr(convertYearENtoTHStr(elObj.getContEndDt()));
					}
					
					if(elObj.getBgStratDt() != null){
						elObj.setBgStratDtStr(convertYearENtoTHStr(elObj.getBgStratDt()));
					}
					
					if(elObj.getBgEndDt() != null){
						elObj.setBgEndDtStr(convertYearENtoTHStr(elObj.getBgEndDt()));
					}
					semmsi004tab5Bean.getElectricDepositSpecialSPList().add(elObj);
				}
//				semmsi004tab5Bean.setElectricDepositSpecialSPList(to);
				this.setElectricDepositSpecial();
				semmsi004tab5Bean.setDisabledChkNoDeposit(true);
			}else{
				semmsi004tab5Bean.setElectricDepositSpecialSPList(new ArrayList<Msi004SrchDepositElectricSP>());
				semmsi004tab5Bean.setElectricDepositSpecialBg(new Deposit());
				semmsi004tab5Bean.setElectricDepositSpecialCash(new Deposit());
				semmsi004tab5Bean.getElectricDepositSpecialCash().setVatType("01");
				semmsi004tab5Bean.setDisabledChkNoDeposit(false);
			}
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void setElectricDepositSpecial() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			List<Msi004SrchDepositElectricSP> list = semmsi004tab5Bean.getElectricDepositSpecialSPList();
			if(list != null && list.size() > 0){
				for(Msi004SrchDepositElectricSP depositSpecial : list){
					if(depositSpecial.getDepositType() != null && depositSpecial.getDepositType().equals("01")){
						semmsi004tab5Bean.getElectricDepositSpecialBg().setRowId(depositSpecial.getRowId());
						semmsi004tab5Bean.getElectricDepositSpecialBg().setDetail(depositSpecial.getDetail());
						semmsi004tab5Bean.getElectricDepositSpecialBg().setSiteInfoId(depositSpecial.getSiteInfoId());
						semmsi004tab5Bean.getElectricDepositSpecialBg().setDepositCondType(depositSpecial.getDepositCondType());
						semmsi004tab5Bean.getElectricDepositSpecialBg().setSeqNo(Integer.parseInt(depositSpecial.getSeqNo()));
						semmsi004tab5Bean.getElectricDepositSpecialBg().setNewStatus(depositSpecial.getNewStatus());
						semmsi004tab5Bean.getElectricDepositSpecialBg().setDepositType(depositSpecial.getDepositType());
					}
					if(depositSpecial.getDepositType() != null && depositSpecial.getDepositType().equals("02")){
						semmsi004tab5Bean.getElectricDepositSpecialCash().setRowId(depositSpecial.getRowId());
						semmsi004tab5Bean.getElectricDepositSpecialCash().setDetail(depositSpecial.getDetail());
						semmsi004tab5Bean.getElectricDepositSpecialCash().setVatType(depositSpecial.getVatType());
						semmsi004tab5Bean.getElectricDepositSpecialCash().setSiteInfoId(depositSpecial.getSiteInfoId());
						semmsi004tab5Bean.getElectricDepositSpecialCash().setDepositCondType(depositSpecial.getDepositCondType());
						semmsi004tab5Bean.getElectricDepositSpecialCash().setSeqNo(Integer.parseInt(depositSpecial.getSeqNo()));
						semmsi004tab5Bean.getElectricDepositSpecialCash().setNewStatus(depositSpecial.getNewStatus());
						semmsi004tab5Bean.getElectricDepositSpecialCash().setDepositType(depositSpecial.getDepositType());
					}
				}
			}else{
				semmsi004tab5Bean.setElectricDepositSpecialBg(new Deposit());
				semmsi004tab5Bean.setElectricDepositSpecialCash(new Deposit());
				semmsi004tab5Bean.getElectricDepositSpecialCash().setVatType("01");
			}
			
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void searchElectricDepositCash(String depositCondType) {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		List<Msi004SrchDepositElectricSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
			criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			criteria.setDepositType("02");
			criteria.setDepositCondType(depositCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
			log.debug("search electric depost Cash size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab5Bean.setDepositElectricCashSPList(new ArrayList<Msi004SrchDepositElectricSP>());
				for(Msi004SrchDepositElectricSP elObj : to){
					if(elObj.getContStartDt() != null){
						elObj.setContStartDtStr(convertYearENtoTHStr(elObj.getContStartDt()));
					}
					
					if(elObj.getContEndDt() != null){
						elObj.setContEndDtStr(convertYearENtoTHStr(elObj.getContEndDt()));
					}
					
					if(elObj.getBgStratDt() != null){
						elObj.setBgStratDtStr(convertYearENtoTHStr(elObj.getBgStratDt()));
					}
					
					if(elObj.getBgEndDt() != null){
						elObj.setBgEndDtStr(convertYearENtoTHStr(elObj.getBgEndDt()));
					}
					semmsi004tab5Bean.getDepositElectricCashSPList().add(elObj);
				}
//				semmsi004tab5Bean.setDepositElectricCashSPList(to);
			}else{
				semmsi004tab5Bean.setDepositElectricCashSPList(new ArrayList<Msi004SrchDepositElectricSP>());
			}
			 setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void searchElectricDepositBG(String depositCondType) {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		List<Msi004SrchDepositElectricSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
			criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			criteria.setDepositType("01");
			criteria.setDepositCondType(depositCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
			log.debug("search electric depost BG size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab5Bean.setDepositElectricBgSPList(new ArrayList<Msi004SrchDepositElectricSP>());
				for(Msi004SrchDepositElectricSP elObj : to){
					if(elObj.getContStartDt() != null){
						elObj.setContStartDtStr(convertYearENtoTHStr(elObj.getContStartDt()));
					}
					
					if(elObj.getContEndDt() != null){
						elObj.setContEndDtStr(convertYearENtoTHStr(elObj.getContEndDt()));
					}
					
					if(elObj.getBgStratDt() != null){
						elObj.setBgStratDtStr(convertYearENtoTHStr(elObj.getBgStratDt()));
					}
					
					if(elObj.getBgEndDt() != null){
						elObj.setBgEndDtStr(convertYearENtoTHStr(elObj.getBgEndDt()));
					}
					semmsi004tab5Bean.getDepositElectricBgSPList().add(elObj);
				}
//				semmsi004tab5Bean.setDepositElectricBgSPList(to);
			}else{
				semmsi004tab5Bean.setDepositElectricBgSPList(new ArrayList<Msi004SrchDepositElectricSP>());
			}
			 setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public boolean renderPayPeriodType(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsi004tab5Bean.setPayPeriodType02("");
				semmsi004tab5Bean.setPayPeriodType03("");
				semmsi004tab5Bean.setPayPeriodType04("");
				semmsi004tab5Bean.setPayPeriodType05("");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsi004tab5Bean.setPayPeriodType01("");
				semmsi004tab5Bean.setPayPeriodType03("");
				semmsi004tab5Bean.setPayPeriodType04("");
				semmsi004tab5Bean.setPayPeriodType05("");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(semmsi004tab5Bean.getPayPeriod03() != null) semmsi004tab5Bean.getSiteElectric().setPayPeriod(semmsi004tab5Bean.getPayPeriod03());
				semmsi004tab5Bean.setPayPeriodType01("");
				semmsi004tab5Bean.setPayPeriodType02("");
				semmsi004tab5Bean.setPayPeriodType04("");
				semmsi004tab5Bean.setPayPeriodType05("");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setDisabledPayPeriod03(false);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsi004tab5Bean.getPayPeriod04() != null) semmsi004tab5Bean.getSiteElectric().setPayPeriod(semmsi004tab5Bean.getPayPeriod04());
				semmsi004tab5Bean.setPayPeriodType01("");
				semmsi004tab5Bean.setPayPeriodType02("");
				semmsi004tab5Bean.setPayPeriodType03("");
				semmsi004tab5Bean.setPayPeriodType05("");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsi004tab5Bean.setPayPeriodType01("");
				semmsi004tab5Bean.setPayPeriodType02("");
				semmsi004tab5Bean.setPayPeriodType03("");
				semmsi004tab5Bean.setPayPeriodType04("");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setDisabledPayPeriod03(true);
				semmsi004tab5Bean.setDisabledPayPeriod04(true);
			}
			semmsi004tab5Bean.getSiteElectric().setPayPeriodType(payPeriodType);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public void checkConditionType(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String depositCondType = semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType();
		if(depositCondType.equals("01")){
			semmsi004tab5Bean.setRenderElectricDepositNormal(true);
			semmsi004tab5Bean.setRenderElectricDepositSpecial(false);
			semmsi004tab5Bean.setDisabledBtnAddElectricDepositNormal(false);
			semmsi004tab5Bean.setDisabledBtnSaveElectricDepositNormal(true);
			semmsi004tab5Bean.setDisabledTotalNormalDeposit(true);
			semmsi004tab5Bean.setDepositElectricBgSPList(null);
			semmsi004tab5Bean.setDepositElectricCashSPList(null);
			semmsi004tab5Bean.getElectricDepositNormal().setDepositType("02");
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmt() != null &&
			   semmsi004tab5Bean.getElectricDepositNormal().getDepositAmt() == 0.00){
				semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(null);
			}
			this.searchElectricDepositBG(depositCondType);
			this.searchElectricDepositCash(depositCondType);
			this.searchSumDepositElectric();
		}else{
			semmsi004tab5Bean.setRenderElectricDepositNormal(false);
			semmsi004tab5Bean.setRenderElectricDepositSpecial(true);
			semmsi004tab5Bean.setDisabledTotalNormalDeposit(false);
			semmsi004tab5Bean.getElectricDepositSpecialCash().setVatType("01");
			this.clearTotalDeposit();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}
	
	private void clearTotalDeposit() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			semmsi004tab5Bean.getTotalDeposit().setTotalDepositBgAmt(null);
			semmsi004tab5Bean.getTotalDeposit().setTotalDepositCashAmt(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
	}
	
	private boolean initDeleteDepositElectricNormal() {
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			semmsi004tab5Bean.setElectricDepositNormal(service.queryDepositByRowId(rowId));
			
			semmsi004tab5Bean.getElectricDepositNormal().setDepositType("");
			semmsi004tab5Bean.getElectricDepositNormal().setDepositAmtNew(null);
			semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(null);
			semmsi004tab5Bean.getElectricDepositNormal().setServiceId("ALL");
			semmsi004tab5Bean.getElectricDepositNormal().setVatType("04");
			
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			log.error(e);
		}
		return flag;
	}
	private boolean doDeleteDepositElectricNormal() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			semmsi004tab5Bean.getElectricDepositNormal().setCurrentUser(semmsi004tab5Bean.getUserLogin());
			service.deleteDeposit(semmsi004tab5Bean.getElectricDepositNormal());
			this.updateSiteInfoDepositElectricEditFlag();
			String depositCondType = semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType();
			semmsi004tab5Bean.setDepositElectricBgSPList(null);
			semmsi004tab5Bean.setDepositElectricCashSPList(null);
			this.searchElectricDepositBG(depositCondType);
			this.searchElectricDepositCash(depositCondType);
			// disabled checkbox no deposit
			if((semmsi004tab5Bean.getDepositElectricBgSPList() != null && !semmsi004tab5Bean.getDepositElectricBgSPList().isEmpty()) ||
			   (semmsi004tab5Bean.getDepositElectricCashSPList() != null && !semmsi004tab5Bean.getDepositElectricCashSPList().isEmpty())){
				semmsi004tab5Bean.setDisabledChkNoDeposit(true);
			}else{
				semmsi004tab5Bean.setDisabledChkNoDeposit(false);
			}
			
			
			// get sum deposit for update table site electric
			this.searchSumDepositElectric();
			this.updateElectric();
			//call store update
			callMsi004GenDPST(semmsi004tab5Bean.getElectricDepositNormal().getRowId(), EQueryName.SP_MSI004_GEN_DPST_E_DEL.name);
			this.doClearDepositElectricNormal();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("5-1");
			addMessageInfo("M0002");
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			log.error(e);
			addMessageError("E0002");
		}
		
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(true);
		semmsi004tab5Bean.setRenderedMsgFormBottom(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
		return flag;
	}
	
	public boolean doUpdateTab5() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		// comment by ming 20110407
		if(!validateTab5()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(true);
			semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
			semmsi004tab5Bean.setRenderedMsgFormBottom(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			return flag;
		}
		this.setElectricType();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
				if(semmsi004tab5Bean.getSiteElectric() != null){
					if(semmsi004tab5Bean.isChkNoUnitPriceFlag()){
						semmsi004tab5Bean.getSiteElectric().setNoUnitPriceFlag("Y");
						semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
					}else{
						semmsi004tab5Bean.getSiteElectric().setNoUnitPriceFlag("");
					}
					if(semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
						semmsi004tab5Bean.getSiteElectric().setMultiElectricTypeFlag("Y");
					}else{
						semmsi004tab5Bean.getSiteElectric().setMultiElectricTypeFlag("");
					}
					
					//added by NEW 
					if(semmsi004tab5Bean.isChkNoDepositElectric()){
						semmsi004tab5Bean.getSiteElectric().setNoDeposit("Y");
						semmsi004tab5Bean.setNoDepositElectric("Y");
					}else{
						semmsi004tab5Bean.getSiteElectric().setNoDeposit("");
						semmsi004tab5Bean.setNoDepositElectric("");
					}
					if(semmsi004tab5Bean.isChkElectricType3() || semmsi004tab5Bean.isChkNoExpenses()){
						String electricOwnerType = semmsi004tab5Bean.getSiteElectric().getElectricOwnerType();
//						if(electricOwnerType != null){
//							if(electricOwnerType.equals("01")){
//								semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(null);
//								semmsi004tab5Bean.getSiteElectric().setTakeAllPeriodType(null);
//							}
//							if(electricOwnerType.equals("02")){
//								semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(null);
//								semmsi004tab5Bean.getSiteElectric().setNoUnitPriceFlag("N");
//							}
//							if(electricOwnerType.equals("00")){
//								semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(null);
//								semmsi004tab5Bean.getSiteElectric().setNoUnitPriceFlag("N");
//								semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(null);
//								semmsi004tab5Bean.getSiteElectric().setTakeAllPeriodType(null);
//								semmsi004tab5Bean.getSiteElectric().setVatType(null);
//								semmsi004tab5Bean.getSiteElectric().setPayPeriodType(null);
//								semmsi004tab5Bean.getSiteElectric().setPayPeriod(null);
//								// delete deposit
//								this.deleteDepositElectricNormal();
//								this.deleteDepositSpecial();
//								this.deleteTotalDeposit();
//								
//							}
//						}
						if(semmsi004tab5Bean.getPayPeriodType01() != null && !semmsi004tab5Bean.getPayPeriodType01().equals("")){
							semmsi004tab5Bean.getSiteElectric().setPayPeriodType(semmsi004tab5Bean.getPayPeriodType01());
						}
						if(semmsi004tab5Bean.getPayPeriodType02() != null && !semmsi004tab5Bean.getPayPeriodType02().equals("")){
							semmsi004tab5Bean.getSiteElectric().setPayPeriodType(semmsi004tab5Bean.getPayPeriodType02());
						}
						if(semmsi004tab5Bean.getPayPeriodType03() != null && !semmsi004tab5Bean.getPayPeriodType03().equals("")){
							semmsi004tab5Bean.getSiteElectric().setPayPeriodType(semmsi004tab5Bean.getPayPeriodType03());
							semmsi004tab5Bean.getSiteElectric().setPayPeriod(semmsi004tab5Bean.getPayPeriod03());
						}
						if(semmsi004tab5Bean.getPayPeriodType04() != null && !semmsi004tab5Bean.getPayPeriodType04().equals("")){
							semmsi004tab5Bean.getSiteElectric().setPayPeriodType(semmsi004tab5Bean.getPayPeriodType04());
							semmsi004tab5Bean.getSiteElectric().setPayPeriod(semmsi004tab5Bean.getPayPeriod04());
						}
						if(semmsi004tab5Bean.getPayPeriodType05() != null && !semmsi004tab5Bean.getPayPeriodType05().equals("")){
							semmsi004tab5Bean.getSiteElectric().setPayPeriodType(semmsi004tab5Bean.getPayPeriodType05());
						}
						
						// CHECK DEPOSIT ELECTRIC
						if(checkDepositElectric()){
							semmsi004tab5Bean.getSiteElectric().setNoDeposit(null);
							semmsi004tab5Bean.setChkNoDepositElectric(false);
							semmsi004tab5Bean.setNoDepositElectric("N");
						}else{
							semmsi004tab5Bean.getSiteElectric().setNoDeposit("Y");
							semmsi004tab5Bean.setChkNoDepositElectric(true);
							semmsi004tab5Bean.setNoDepositElectric("Y");
						}
					}else{
						this.clearElectricOwner();
					}
					
					if(semmsi004tab5Bean.isChkElectricType4()){
						if(getPopupSiteContractBean().getContractNo() != null && !getPopupSiteContractBean().getContractNo().equals("")){
							semmsi004tab5Bean.getSiteElectric().setFromContractNo(getPopupSiteContractBean().getContractNo());
							semmsi004tab5Bean.getSiteElectric().setFromSiteInfoId(getPopupSiteContractBean().getSiteInfoId());
						}
					}else{
						semmsi004tab5Bean.getSiteElectric().setFromContractNo(null);
						semmsi004tab5Bean.getSiteElectric().setFromSiteInfoId(null);
					}
					semmsi004tab5Bean.getSiteElectric().setCurrentUser(semmsi004tab5Bean.getUserLogin());
					log.debug("site_electric_id : "+semmsi004tab5Bean.getSiteElectric().getRowId());
					log.debug("version : "+semmsi004tab5Bean.getSiteElectric().getVersion());
					semmsi004tab5Bean.setSiteElectric(service.updateSiteElectric(semmsi004tab5Bean.getSiteElectric()));
					this.updateSiteInfoElectricEditFlag();
					// approve siteInfoId
					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					
					//approve EL Add 20120313
//					getSemmsi004Action().approveEL(getSemmsi004Bean().getTabNo());
					
					this.setAuditlog();
					if(getSemmsi004Bean().isShowMessageSave() == true){
						addMessageInfo("M0001");
					}
					semmsi004tab1Bean.setSiteElectric(semmsi004tab5Bean.getSiteElectric());
					flag = true;
				}
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(true);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab5Bean.setRenderedMsgFormBottom(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
		return flag;
	}
	
	private boolean validateTab5() {
		boolean flgValid = true;
//		if(!getSemmsi004tab5Bean().isChkElectricType1() && !getSemmsi004tab5Bean().isChkElectricType2() &&
//		  !getSemmsi004tab5Bean().isChkElectricType3() && !getSemmsi004tab5Bean().isChkElectricType4() &&
//		  !getSemmsi004tab5Bean().isChkNoExpenses()){
//					addMessageError("W0001", msg("message.electricType"));
//					flgValid = false;
//		}
		
		String electricOwnerType = getSemmsi004tab5Bean().getSiteElectric().getElectricOwnerType();
		if(electricOwnerType != null && getSemmsi004tab5Bean().isChkElectricType3()){
			if(electricOwnerType.equals("01")){
				if(getSemmsi004tab5Bean().getSiteElectric().getUnitPriceAmt() != null &&
				  getSemmsi004tab5Bean().getSiteElectric().getUnitPriceAmt() == 0.00 &&
				  !getSemmsi004tab5Bean().isChkNoUnitPriceFlag()){
					addMessageError("W0001", msg("message.unitPriceAmt"));
					flgValid = false;
				}
			}
			if(electricOwnerType.equals("02")){ 
				if(getSemmsi004tab5Bean().getSiteElectric().getTakeAllAmt() != null && 
				   getSemmsi004tab5Bean().getSiteElectric().getTakeAllAmt() == 0.00 &&  StringUtils.isEmpty(getSemmsi004tab5Bean().getSiteElectric().getRemark())){
					addMessageError("W0001", msg("message.takeAllAmt"));
					flgValid = false;
				}
				if(StringUtils.isEmpty(getSemmsi004tab5Bean().getSiteElectric().getTakeAllPeriodType())
						&&  StringUtils.isEmpty(getSemmsi004tab5Bean().getSiteElectric().getRemark())){
					addMessageError("W0001", msg("message.takeAllPeriodType"));
					flgValid = false;
				}
			}
			/*
			Date electricEffDate = getSemmsi004tab5Bean().getSiteElectric().getEffectiveDt();
			semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
			Date effDate = semmsi004tab2Bean.getSiteContract().getEffectiveDt();
			Date expDate =semmsi004tab2Bean.getSiteContract().getExpireDt();
			if(!getSemmsi004tab5Bean().getSiteElectric().getElectricOwnerType().equals("00")){
				if(electricEffDate != null){
					if(effDate != null && electricEffDate.before(effDate)){
						addMessageErrorWithArgument("W0047" ,msg("export.col.estmDt"), msg("message.contractEffDate"), msg("message.contractExpDate"));
						flgValid = false;
					}
					if(expDate != null && electricEffDate.after(expDate)){
						addMessageErrorWithArgument("W0047" ,msg("export.col.estmDt"), msg("message.contractEffDate"), msg("message.contractExpDate"));
						flgValid = false;
					}
				}else{
					addMessageError("W0001", msg("export.col.estmDt"));
					flgValid = false;
				}
			
			}
			*/
		}
		
		Integer count = 0;
		if(getSemmsi004tab5Bean().isChkElectricType1()){
			count++;
		}
		if(getSemmsi004tab5Bean().isChkElectricType2()){
			count++;
		}
		if(getSemmsi004tab5Bean().isChkElectricType3()){
			count++;
		}
		if(getSemmsi004tab5Bean().isChkElectricType4()){
			count++;
		}
		if(getSemmsi004tab5Bean().isChkMultiElectricTypeFlag()){
			if(count < 2){
				addMessageError("W0046");
				flgValid = false;
			}
		}else{
			if(count > 1){
				addMessageError("W0070");
				flgValid = false;
			}
		}
		return flgValid;
	}

	private void clearElectricOwner() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.getSiteElectric().setElectricOwnerType(null);
		semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(null);
		semmsi004tab5Bean.getSiteElectric().setNoUnitPriceFlag(null);
		semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(null);
		semmsi004tab5Bean.getSiteElectric().setTakeAllPeriodType(null);
		semmsi004tab5Bean.getSiteElectric().setEffectiveDt(null);
		semmsi004tab5Bean.getSiteElectric().setVatType(null);
		semmsi004tab5Bean.getSiteElectric().setPayPeriodType(null);
		semmsi004tab5Bean.getSiteElectric().setPayPeriod(null);
		semmsi004tab5Bean.getSiteElectric().setNoDeposit(null);
		// clear bg,cash
		this.deleteBg();
		this.deleteCash();
		// delete totalDepositBgAmt,totalDepositCashAmt
		this.deleteTotalDeposit();
		this.deleteDepositSpecial();
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}
	
	public boolean renderElectricOwnerType(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String electricOwnerType = semmsi004tab5Bean.getSiteElectric().getElectricOwnerType();
		if(electricOwnerType != null){
			
			if(electricOwnerType.equals("01")){
				semmsi004tab5Bean.setDisabledUnitPriceAmt(false);
				semmsi004tab5Bean.setDisabledChkNoUnitPriceFlag(false);
				semmsi004tab5Bean.getSiteElectric().setVatType("01");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
			}else{
				semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab5Bean.setDisabledChkNoUnitPriceFlag(true);
				semmsi004tab5Bean.setChkNoUnitPriceFlag(false);
			}
			
			if(electricOwnerType.equals("02")){
				semmsi004tab5Bean.setDisabledTakeAllAmt(false);
				semmsi004tab5Bean.getSiteElectric().setVatType("01");
				semmsi004tab5Bean.setPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
			}else{
				semmsi004tab5Bean.setDisabledTakeAllAmt(true);
			}
			if(electricOwnerType.equals("00")){
				semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
				semmsi004tab5Bean.setDisabledTakeAllAmt(true);
				semmsi004tab5Bean.setRenderedVatType(false);
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(false);
				semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
			}else{
				semmsi004tab5Bean.setRenderedVatType(true);
			}
			
			if(!electricOwnerType.equals("00")){
				// CHECK DEPOSIT ELECTRIC
				if(checkDepositElectric()){
					semmsi004tab5Bean.setChkNoDepositElectric(false);
					semmsi004tab5Bean.setNoDepositElectric("N");
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(true);
					semmsi004tab5Bean.setNoDepositElectric("Y");
				}
			}
			
			semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(null);
			semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(null);
			semmsi004tab5Bean.getSiteElectric().setTakeAllPeriodType("");
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}
	
	public void renderedNoDepositElectric(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		if(semmsi004tab5Bean.isChkNoDepositElectric()){
			semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			semmsi004tab5Bean.setRenderVatType(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric2(true);
		}else{
			semmsi004tab5Bean.setRenderedNoDepositElectric(true);
			semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
			//Adding by John
			semmsi004tab5Bean.setRenderVatType(true);
			semmsi004tab5Bean.getElectricDepositNormal().setVatType("01");
		}
		
		
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void deleteTotalDeposit() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			semmsi004tab5Bean.getSiteElectric().setTotalDepositBgAmt(null);
			semmsi004tab5Bean.getSiteElectric().setTotalDepositCashAmt(null);
			semmsi004tab5Bean.setSiteElectric(service.updateSiteElectric(semmsi004tab5Bean.getSiteElectric()));
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void deleteCash() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			List<Msi004SrchDepositElectricSP> list = semmsi004tab5Bean.getDepositElectricCashSPList();
			if(list != null && list.size() > 0){
				for(Msi004SrchDepositElectricSP cash : list){
					Deposit deposit = service.queryDepositByRowId(cash.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	private void deleteBg() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			List<Msi004SrchDepositElectricSP> list = semmsi004tab5Bean.getDepositElectricBgSPList();
			if(list != null && list.size() > 0){
				for(Msi004SrchDepositElectricSP bg : list){
					Deposit deposit = service.queryDepositByRowId(bg.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
	}

	public boolean renderElectricType1(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		// select only one checkbox
		if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab5Bean.isChkElectricType1()){
/*				semmsi004tab5Bean.setChkElectricType2(false);
				semmsi004tab5Bean.setChkElectricType3(false);
				semmsi004tab5Bean.setChkElectricType4(false);*/
				semmsi004tab5Bean.getSiteElectric().setElectricType1("Y");
//				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			}else{
				semmsi004tab5Bean.setChkElectricType1(false);
				semmsi004tab5Bean.getSiteElectric().setElectricType1("");
			}
			semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
			// select many checkbox
		}else{
			semmsi004tab5Bean.setChkElectricType2(false);
			if(semmsi004tab5Bean.isChkElectricType3()){
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				if("00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab5Bean.setRenderedVatType(false);
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(false);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
				}else{
					semmsi004tab5Bean.setRenderedVatType(true);
				}
				// CHECK DEPOSIT ELECTRIC
				if(checkDepositElectric()){
					semmsi004tab5Bean.setChkNoDepositElectric(false);
					semmsi004tab5Bean.setNoDepositElectric("N");
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(true);
					semmsi004tab5Bean.setNoDepositElectric("Y");
				}
			}else{
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
				semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			}
			setElectricType();
		}
		semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
		semmsi004tab5Bean.setChkNoDepositElectric(false);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}
	
	public boolean renderElectricType2(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		// select only one checkbox
		if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab5Bean.isChkElectricType2()){
/*				semmsi004tab5Bean.setChkElectricType1(false);
				semmsi004tab5Bean.setChkElectricType3(false);
				semmsi004tab5Bean.setChkElectricType4(false);*/
				semmsi004tab5Bean.getSiteElectric().setElectricType2("Y");
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			}else{
				semmsi004tab5Bean.setChkElectricType2(false);
				semmsi004tab5Bean.getSiteElectric().setElectricType2("");
			}
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
			semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
			// select many checkbox
		}else{
			// clear electric type1
			semmsi004tab5Bean.setChkElectricType1(false);
			if(semmsi004tab5Bean.isChkElectricType3()){
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				if("00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab5Bean.setRenderedVatType(false);
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(false);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
				}else{
					semmsi004tab5Bean.setRenderedVatType(true);
				}
				
				// CHECK DEPOSIT ELECTRIC
				if(checkDepositElectric()){
					semmsi004tab5Bean.setChkNoDepositElectric(false);
					semmsi004tab5Bean.setNoDepositElectric("N");
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(true);
					semmsi004tab5Bean.setNoDepositElectric("Y");
				}
				
			}else{
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
				semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			}
			setElectricType();
		}
		semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
		semmsi004tab5Bean.setChkNoDepositElectric(false);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		return flag;
	}
	
	public boolean renderElectricType3(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		// select only one checkbox
		if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab5Bean.isChkElectricType3()){
/*				semmsi004tab5Bean.setChkElectricType1(false);
				semmsi004tab5Bean.setChkElectricType2(false);
				semmsi004tab5Bean.setChkElectricType4(false);*/
				semmsi004tab5Bean.getSiteElectric().setElectricType3("Y");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType3("Y");
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				semmsi004tab5Bean.setRenderedVatType(true);
				semmsi004tab5Bean.setDisabledTakeAllAmt(true);
//				if("00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
//					semmsi004tab5Bean.setRenderedVatType(false);
//					semmsi004tab5Bean.setRenderedNoDepositElectric(false);
//					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
//					semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
//				}else{
					semmsi004tab5Bean.setRenderedVatType(true);
//				}
				if(semmsi004tab5Bean.getSiteElectric().getElectricType3() == null ||
					"00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
					// default electric vatType and payPeriodType
					semmsi004tab5Bean.getSiteElectric().setElectricOwnerType("01");
					semmsi004tab5Bean.getSiteElectric().setVatType("01");//edit from "" 19/12/2013
					semmsi004tab5Bean.setPayPeriodType01("01");
					semmsi004tab5Bean.setDisabledChkNoUnitPriceFlag(false);
				}else{
					if(semmsi004tab5Bean.getSiteElectric().getPayPeriodType() == null){
						semmsi004tab5Bean.setPayPeriodType01("01");
					}
					semmsi004tab5Bean.getSiteElectric().setVatType("01");//edit from "" 19/12/2013
				}
				
				// CHECK DEPOSIT ELECTRIC
				if(checkDepositElectric()){
					semmsi004tab5Bean.setChkNoDepositElectric(false);
					semmsi004tab5Bean.setNoDepositElectric("N");
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(true);
					semmsi004tab5Bean.setNoDepositElectric("Y");
				}
				
			}else{
				semmsi004tab5Bean.setChkElectricType3(false);
				semmsi004tab5Bean.getSiteElectric().setElectricType3("");
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
				semmsi004tab5Bean.setRenderedNoDepositElectric(false);
				
			}
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
			// select many checkbox
		}else{
			if(semmsi004tab5Bean.isChkElectricType3()){
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				semmsi004tab5Bean.setDisabledTakeAllAmt(true);
				semmsi004tab5Bean.getSiteElectric().setVatType("01");// 19/12/2013
				if("00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab5Bean.setRenderedVatType(false);
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(false);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
				}else{
					semmsi004tab5Bean.setRenderedVatType(true);
				}
				// CHECK DEPOSIT ELECTRIC
				if(checkDepositElectric()){
					semmsi004tab5Bean.setChkNoDepositElectric(false);
					semmsi004tab5Bean.setNoDepositElectric("N");
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(true);
					semmsi004tab5Bean.setNoDepositElectric("Y");
				}
			}else{
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
				semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			}
			setElectricType();
		}
//		semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
//		semmsi004tab5Bean.setChkNoDepositElectric(false);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		return flag;
	}
	
	public boolean renderChkElectricType(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		if(semmsi004tab5Bean.isChkNoExpenses()){
			semmsi004tab5Bean.setChkElectricType1(false);
			semmsi004tab5Bean.setChkElectricType2(false);
			semmsi004tab5Bean.setChkElectricType3(false);
			semmsi004tab5Bean.setChkElectricType4(false);
			semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
			semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			semmsi004tab5Bean.getSiteElectric().setElectricOwnerType("00");
			semmsi004tab5Bean.getSiteElectric().setVatType("01");
			semmsi004tab5Bean.setPayPeriodType01("01");
			semmsi004tab5Bean.getSiteElectric().setElectricType3("Y");
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
			semmsi004tab5Bean.setDisabledUnitPriceAmt(true);
			semmsi004tab5Bean.setDisabledTakeAllAmt(true);
			semmsi004tab5Bean.setRenderedVatType(false);
			
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return false;
	}
	private boolean checkDepositElectric() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		List<Msi004SrchDepositElectricSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
			criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			criteria.setDepositType(null);
			criteria.setDepositCondType(semmsi004tab5Bean.getSiteElectric().getDepositCondType());
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
			log.debug("search electric depost  size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
				flag = true;
			}else{
				flag = false;
				semmsi004tab5Bean.setRenderedNoDepositElectric(false);
				semmsi004tab5Bean.setRenderedNoDepositElectric2(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}

	public boolean renderElectricType4(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		// select only one checkbox
		if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
			if(semmsi004tab5Bean.isChkElectricType4()){
/*				semmsi004tab5Bean.setChkElectricType1(false);
				semmsi004tab5Bean.setChkElectricType2(false);
				semmsi004tab5Bean.setChkElectricType3(false);*/
				semmsi004tab5Bean.getSiteElectric().setElectricType4("Y");
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
				semmsi004tab5Bean.setDisabledSiteContractNo(false);
			}else{
				semmsi004tab5Bean.setChkElectricType4(false);
				semmsi004tab5Bean.getSiteElectric().setElectricType4("");
				semmsi004tab5Bean.setDisabledSiteContractNo(true);
			}
			semmsi004tab5Bean.setRenderedNoDepositElectric(false);
			// select many checkbox
		}else{
			if(semmsi004tab5Bean.isChkElectricType3()){
				semmsi004tab5Bean.setRenderedElectricOwnerType(true);
				semmsi004tab5Bean.setRenderedNoDepositElectric(true);
				if("00".equals(semmsi004tab5Bean.getSiteElectric().getElectricOwnerType())){
					semmsi004tab5Bean.setRenderedVatType(false);
					semmsi004tab5Bean.setRenderedElectricOwnerType(true);
					semmsi004tab5Bean.setRenderedNoDepositElectric(false);
					semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
				}else{
					semmsi004tab5Bean.setRenderedVatType(true);
				}
				
				// CHECK DEPOSIT ELECTRIC
				if(checkDepositElectric()){
					semmsi004tab5Bean.setChkNoDepositElectric(false);
					semmsi004tab5Bean.setNoDepositElectric("N");
				}else{
					semmsi004tab5Bean.setChkNoDepositElectric(true);
					semmsi004tab5Bean.setNoDepositElectric("Y");
				}
				
			}else{
				semmsi004tab5Bean.setRenderedElectricOwnerType(false);
			}
			setElectricType();
		}
		semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
		semmsi004tab5Bean.setChkNoDepositElectric(false);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		return flag;
	}
	
	private void clearElectricOwnerType() {
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		if(semmsi004tab5Bean.getSiteElectric().getUnitPriceAmt() != null 
		  && semmsi004tab5Bean.getSiteElectric().getUnitPriceAmt() == 0.00){
			semmsi004tab5Bean.getSiteElectric().setUnitPriceAmt(null);
		}
		if(semmsi004tab5Bean.getSiteElectric().getTakeAllAmt() != null 
		  && semmsi004tab5Bean.getSiteElectric().getTakeAllAmt() == 0.00){
			semmsi004tab5Bean.getSiteElectric().setTakeAllAmt(null);
		}
		if(semmsi004tab5Bean.getPayPeriod03() != null &&
		   semmsi004tab5Bean.getPayPeriod03() == 0){
			semmsi004tab5Bean.setPayPeriod03(null);
		}
		if(semmsi004tab5Bean.getPayPeriod04() != null && 
		   semmsi004tab5Bean.getPayPeriod04() == 0){
			semmsi004tab5Bean.setPayPeriod04(null);
		}
//		semmsi004tab5Bean.getSiteElectric().setElectricOwnerType("01");
//		semmsi004tab5Bean.getSiteElectric().setVatType("01");
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}
	
	public void setElectricType(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		if(semmsi004tab5Bean.isChkElectricType1()){
			semmsi004tab5Bean.getSiteElectric().setElectricType1("Y");
		}else{
			semmsi004tab5Bean.getSiteElectric().setElectricType1("");
		}
		if(semmsi004tab5Bean.isChkElectricType2()){
			semmsi004tab5Bean.getSiteElectric().setElectricType2("Y");
		}else{
			semmsi004tab5Bean.getSiteElectric().setElectricType2("");
		}
		if(semmsi004tab5Bean.isChkElectricType3() || semmsi004tab5Bean.isChkNoExpenses()){
			semmsi004tab5Bean.getSiteElectric().setElectricType3("Y");
		}else{
			semmsi004tab5Bean.getSiteElectric().setElectricType3("");
		}
		if(semmsi004tab5Bean.isChkElectricType4()){
			semmsi004tab5Bean.getSiteElectric().setElectricType4("Y");
			semmsi004tab5Bean.setDisabledSiteContractNo(false);
		}else{
			semmsi004tab5Bean.getSiteElectric().setElectricType4("");
			semmsi004tab5Bean.setDisabledSiteContractNo(true);
		}
		if(semmsi004tab5Bean.isChkElectricType5()){
			semmsi004tab5Bean.getSiteElectric().setElectricType5("Y");
		}else{
			semmsi004tab5Bean.getSiteElectric().setElectricType5("");
		}
		if(semmsi004tab5Bean.isChkElectricType6()){
			semmsi004tab5Bean.getSiteElectric().setElectricType6("Y");
		}else{
			semmsi004tab5Bean.getSiteElectric().setElectricType6("");
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}
	
	public void renderVatType(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		// BG No VatType
		if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType().equals("01")){
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmt() != null &&
					   semmsi004tab5Bean.getElectricDepositNormal().getDepositAmt() == 0.00){
						semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(null);
			}
			semmsi004tab5Bean.setRenderVatType(false);
		}else{
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmt() != null &&
			   semmsi004tab5Bean.getElectricDepositNormal().getDepositAmt() == 0.00){
				semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(null);
			}
			if(semmsi004tab5Bean.getElectricDepositNormal().getVatType() == null){
				semmsi004tab5Bean.getElectricDepositNormal().setVatType("01");
			}
			semmsi004tab5Bean.setRenderVatType(true);
		}
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		SEMMSI004Tab5Bean semmsi004tab5Bean = new SEMMSI004Tab5Bean();
		semmsi004tab5Bean.setElectricDepositNormal(new Deposit());
		semmsi004tab5Bean.setElectricDepositSpecialBg(new Deposit());
		semmsi004tab5Bean.setElectricDepositSpecialCash(new Deposit());
		semmsi004tab5Bean.setSiteElectric(new Electric());
		if(semmsi004tab1Bean.getSiteElectric() == null){
			semmsi004tab1Bean.setSiteElectric(new Electric());
		}
		semmsi004tab5Bean.setRenderedElectricOwnerType(false);
		semmsi004tab5Bean.setRenderedVatType(true);
		semmsi004tab5Bean.setChkNoDepositElectric(false);
		semmsi004tab5Bean.setDisabledPayPeriod03(true);
		semmsi004tab5Bean.setDisabledPayPeriod04(false);
		semmsi004tab5Bean.setDisabledSiteContractNo(true);
		semmsi004tab5Bean.setRenderedNoDepositElectric(false);
		semmsi004tab5Bean.setRenderedNoDepositElectric2(false);
		semmsi004tab5Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab5Bean.setRenderedMsgFormBottom(false);
		semmsi004tab5Bean.setDisabledTotalNormalDeposit(true);
		semmsi004tab5Bean.setDisabledChkNoDeposit(false);
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab5Bean.setSiteInfoObjELParam(new SiteInfoMapSiteAcqSP());
		semmsi004tab5Bean.setSiteInfoObjParam(new SiteInfoMapSiteAcqSP());
		semmsi004tab5Bean.setServTypeList(getEmptyDropDown());
		semmsi004tab5Bean.setExpenseTypeDepositElList(getEmptyDropDown());
		semmsi004tab5Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
		
		//TODO init TAB4
		semmsi004tab5Bean.setPromiseRenewPeriodTypeList(getLovItemsByType(ELovType.T_CT_PERIOD_TYPE.name));
		semmsi004tab5Bean.setSiteInfoObjELParam(new SiteInfoMapSiteAcqSP());
		semmsi004tab5Bean.setExpenseTypeDepositElList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_ELECTRIC.name, null, null));
		semmsi004tab5Bean.setSiteInfoELCondTakeAllList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
		semmsi004tab5Bean.setSiteInfoELCondUnitList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
		semmsi004tab5Bean.setSiteInfoELCondNoExpenseList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
		semmsi004tab5Bean.setSiteInfoELCondOtherList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
		semmsi004tab5Bean.setElCondTypeList(getLovItemsByType(ELovType.T_SA_EL_COND_TYPE.name)); 
		semmsi004tab5Bean.setElCondSubTypeList(getLovItemsByType(ELovType.T_SA_EL_COND_SUB_TYPE.name)); 
		semmsi004tab5Bean.setSiteInfoDeptElObj(new SiteInfoMapSiteAcqSP());
		semmsi004tab5Bean.setSiteInfoELCondExistingList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
		
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean validateDepositElectricNormal() {
		boolean flgValid = true;  
		if(getSemmsi004tab5Bean().getElectricDepositNormal().getDepositAmtNew() == null){
			addMessageError("W0001", msg("message.depositAmt"));
			flgValid = false;
		}
		
		return flgValid;
	}
	
	private PopupSiteContractBean popupSiteContractBean;
	
	public PopupSiteContractBean getPopupSiteContractBean() {
		return (PopupSiteContractBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteContractBean");
	}

	public void setPopupSiteContractBean(PopupSiteContractBean popupSiteContractBean) {
		this.popupSiteContractBean = popupSiteContractBean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteContractBean", this.popupSiteContractBean);
	}
	
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}
	
	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", semmsi004tab1Bean);
	}
	
	private SEMMSI004Tab5Bean semmsi004tab5Bean;


	public SEMMSI004Tab5Bean getSemmsi004tab5Bean() {
		return (SEMMSI004Tab5Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab5Bean");
	}

	public void setSemmsi004tab5Bean(SEMMSI004Tab5Bean semmsi004tab5Bean) {
		this.semmsi004tab5Bean = semmsi004tab5Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab5Bean", semmsi004tab5Bean);
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
	
	private SEMMSI004Tab2Bean semmsi004tab2Bean;
	
	public SEMMSI004Tab2Bean getSemmsi004tab2Bean() {
		return (SEMMSI004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("getSemmsi004tab2Bean");
	}

	public void setSemmsi004tab2Bean(SEMMSI004Tab2Bean semmsi004tab2Bean) {
		this.semmsi004tab2Bean = semmsi004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab2Bean", this.semmsi004tab2Bean);
	}
	
	private SEMMSI004Tab2Action semmsi004tab2Action;
	
	public SEMMSI004Tab2Action getSemmsi004tab2Action() {
		if(semmsi004tab2Action == null){
			semmsi004tab2Action = new SEMMSI004Tab2Action();
		}
		return semmsi004tab2Action;
	}

	public boolean compareTab5() {
		boolean flag = false;
		try{
			if(compareElectric()){
				flag = true;
				return flag;
			}
			if(compareDepositElectric()){
				flag = true;
				return flag;
			}
			if(compareTotalDepositElectric()){
				flag = true;
				return flag;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	private boolean compareTotalDepositElectric() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(semmsi004tab5Bean.isChkElectricType3()){
				ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
				Electric temp = service.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteInfoId());
				Electric current = semmsi004tab5Bean.getTotalDeposit();
				if(temp != null && current != null){
					if(!checkObjNull(temp.getTotalDepositBgAmt()).equals(checkObjNull(current.getTotalDepositBgAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getTotalDepositCashAmt()).equals(checkObjNull(current.getTotalDepositCashAmt()))){
						flag = true; 
						return flag;
					}
				/*	if((!checkObjNull(temp.getNoDeposit()).equals("Y") && semmsi004tab5Bean.isChkNoDepositElectric())
						|| (checkObjNull(temp.getNoDeposit()).equals("Y") && !semmsi004tab5Bean.isChkNoDepositElectric())){*/
					if((!checkObjNull(semmsi004tab5Bean.getNoDepositElectric()).equals("Y") && semmsi004tab5Bean.isChkNoDepositElectric())
							|| (checkObjNull(semmsi004tab5Bean.getNoDepositElectric()).equals("Y") && !semmsi004tab5Bean.isChkNoDepositElectric())){
						flag = true; 
						return flag;
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareDepositElectric() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(semmsi004tab5Bean.isChkElectricType3() 
			  && semmsi004tab5Bean.getElectricDepositNormal().getDepositCondType().equals("02")
			  && !semmsi004tab5Bean.isChkNoDepositElectric()){
				List<Msi004SrchDepositElectricSP> to = null;
				ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
				Msi004SrchDepositElectricSP criteria = new Msi004SrchDepositElectricSP();
				criteria.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
				criteria.setDepositCondType("02");
				to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_E.name, criteria);
				log.debug("search deposit special size [" + to.size() + "]");
				Deposit current1 = semmsi004tab5Bean.getElectricDepositSpecialBg();
				Deposit current2 = semmsi004tab5Bean.getElectricDepositSpecialCash();
				if(to != null && to.size() > 0){
					// compare BG
					if(to.get(0) != null){
						Msi004SrchDepositElectricSP temp = to.get(0);
						if(temp != null && current1 != null){
							if(!checkObjNull(temp.getDetail()).equals(checkObjNull(current1.getDetail()))){
								flag = true; 
								return flag;
							}
						}
					}
					// compare Cash
					if(to.size() >  1 && to.get(1) != null){
						Msi004SrchDepositElectricSP temp = to.get(1);
						if(temp != null && current2 != null){
							if(!checkObjNull(temp.getDetail()).equals(checkObjNull(current2.getDetail()))){
								flag = true; 
								return flag;
							}
							if(!checkObjNull(temp.getVatType()).equals(checkObjNull(current2.getVatType()))){
								flag = true; 
								return flag;
							}
						}
					}
					
				}else{
					if(current1.getDetail() != null){
						flag = true; 
						return flag;
					}
					if(current2.getDetail() != null){
						flag = true; 
						return flag;
					}
//					if(current2.getVatType() != null){
//						flag = true; 
//						return flag;
//					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareElectric() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ISiteElectricService service = (ISiteElectricService)getBean("siteElectricService");
			Electric temp = service.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			Electric current = semmsi004tab5Bean.getSiteElectric();
			if(temp != null && current != null){
				if((!checkObjNull(temp.getMultiElectricTypeFlag()).equals("Y") && semmsi004tab5Bean.isChkMultiElectricTypeFlag())
					|| (checkObjNull(temp.getMultiElectricTypeFlag()).equals("Y") && !semmsi004tab5Bean.isChkMultiElectricTypeFlag())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType1()).equals("Y") && semmsi004tab5Bean.isChkElectricType1())
					|| (checkObjNull(temp.getElectricType1()).equals("Y") && !semmsi004tab5Bean.isChkElectricType1())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType2()).equals("Y") && semmsi004tab5Bean.isChkElectricType2())
					|| (checkObjNull(temp.getElectricType2()).equals("Y") && !semmsi004tab5Bean.isChkElectricType2())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType3()).equals("Y") && semmsi004tab5Bean.isChkElectricType3())
					|| (checkObjNull(temp.getElectricType3()).equals("Y") && !semmsi004tab5Bean.isChkElectricType3())){
						flag = true; 
						return flag;
				}
				if((!checkObjNull(temp.getElectricType4()).equals("Y") && semmsi004tab5Bean.isChkElectricType4())
					|| (checkObjNull(temp.getElectricType4()).equals("Y") && !semmsi004tab5Bean.isChkElectricType4())){
						flag = true; 
						return flag;
				}
				if(!checkObjNull(temp.getFromContractNo()).equals(checkObjNull(getPopupSiteContractBean().getSiteContractNo()))){
						flag = true; 
						return flag;
				}
				if(semmsi004tab5Bean.isChkElectricType3()){
//					if(!checkObjNull(temp.getElectricOwnerType()).equals(checkObjNull(current.getElectricOwnerType()))){
//						flag = true; 
//						return flag;
//					}
					if(!checkObjNull(temp.getUnitPriceAmt()).equals(checkObjNull(current.getUnitPriceAmt()))){
						flag = true; 
						return flag;
					}
					if((!checkObjNull(temp.getNoUnitPriceFlag()).equals("Y") && semmsi004tab5Bean.isChkNoUnitPriceFlag())
						|| (checkObjNull(temp.getNoUnitPriceFlag()).equals("Y") && !semmsi004tab5Bean.isChkNoUnitPriceFlag())){
								flag = true; 
								return flag;
					}
					if(!checkObjNull(temp.getTakeAllAmt()).equals(checkObjNull(current.getTakeAllAmt()))){
						flag = true; 
						return flag;
					}
					if(!checkObjNull(temp.getTakeAllPeriodType()).equals(checkObjNull(current.getTakeAllPeriodType()))){
						flag = true; 
						return flag;
					}
					// electric owner type = 00 not compare
					if(!current.getElectricOwnerType().equals("00")){
						if(temp.getVatType() != null && !checkObjNull(temp.getVatType()).equals(checkObjNull(current.getVatType()))){
							flag = true; 
							return flag;
						}
						if(!current.getElectricOwnerType().equals("00") && !checkObjNull(temp.getPayPeriodType()).equals(checkObjNull(current.getPayPeriodType()))){
							flag = true; 
							return flag;
						}
						if(checkObjNull(current.getPayPeriodType()).equals("03") && 
						  !checkObjNull(temp.getPayPeriod()).equals(checkObjNull(current.getPayPeriod()))){
							flag = true;
							return flag;
						}
						if(checkObjNull(current.getPayPeriodType()).equals("04") && 
						  !checkObjNull(temp.getPayPeriod()).equals(checkObjNull(current.getPayPeriod()))){
							flag = true;
							return flag;
						}
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean autoSaveTab5() {
		boolean flag = false;
		try{
			if(compareElectric()){
				flag = this.doUpdateTab5();
				if(!flag){
					return flag;
				}
			}
			if(compareDepositElectric()){
				this.doUpdateDepositElectricSpecial();
				
			}
			if(compareTotalDepositElectric()){
				this.doSaveTotalDepositElectric();
			}
			
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public void onChangeNoUnit(){
		semmsi004tab5Bean = getSemmsi004tab5Bean();

		if(semmsi004tab5Bean.isChkNoUnitPriceFlag()){
			semmsi004tab5Bean.getSiteElectric().setVatType("");
		}else{
			semmsi004tab5Bean.getSiteElectric().setVatType("01");
		}
		
	}
	
	//added by NEW 2018/08/04 NEW EL Site Info
	public void initUpdDeptReturnTypeEl(){
		log.debug(" #### START SEMMSI004Tab5Action initUpdDeptReturnTypeEl ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType())){
						semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnType("");
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("01")){
						semmsi004tab5Bean.setDeptReturnTypeEl01(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

						if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null)semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("02")){
						semmsi004tab5Bean.setDeptReturnTypeEl02(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

//						semmsi004tab5Bean.getSiteAppDeptObj().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("03")){
						semmsi004tab5Bean.setDeptReturnTypeEl03(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);

						if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null)
							semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
				}else{
					semmsi004tab5Bean.setDeptReturnTypeEl01(null);
					semmsi004tab5Bean.setDeptReturnTypeEl02(null);
					semmsi004tab5Bean.setDeptReturnTypeEl03(null);

//					log.debug("semmsi004tab5Bean.getSiteInfoDeptCashObj().getReturnAmt() : "+semmsi004tab5Bean.getSiteInfoDeptCashObj().getReturnAmt());
					if(semmsi004tab5Bean.getSiteInfoDeptCashObj() != null && semmsi004tab5Bean.getSiteInfoDeptCashObj().getReturnAmt() != null)
						semmsi004tab5Bean.getSiteInfoDeptCashObj().setReturnAmt(null);
				}
			}else if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType())){
						semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnType("");
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("01")){
						semmsi004tab5Bean.setDeptReturnTypeEl01(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

						if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null)
							semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("02")){
						semmsi004tab5Bean.setDeptReturnTypeEl02(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

//						semmsi004tab5Bean.getSiteAppDeptObj().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("03")){
						semmsi004tab5Bean.setDeptReturnTypeEl03(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);

						if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null)
							semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
				}else{
					semmsi004tab5Bean.setDeptReturnTypeEl01(null);
					semmsi004tab5Bean.setDeptReturnTypeEl02(null);
					semmsi004tab5Bean.setDeptReturnTypeEl03(null);

					if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null)
						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
				}
			}else{
				semmsi004tab5Bean.setDeptReturnTypeEl01(null);
				semmsi004tab5Bean.setDeptReturnTypeEl02(null);
				semmsi004tab5Bean.setDeptReturnTypeEl03(null);
				if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null)
					semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action initUpdDeptReturnTypeEl : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### END SEMMSI004Tab5Action initUpdDeptReturnTypeEl ####");
		}
	}
	
	public boolean doEditDepositEl(){
		log.debug(" ### START SEMMSI004Tab5Action doEditDepositEl ### ");
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String siteAppDepositId = getFacesUtils().getRequestParameter("siteAppDepositId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppDepositId");
		String depositType = getFacesUtils().getRequestParameter("depositType") == null ? "" : (String)getFacesUtils().getRequestParameter("depositType");
		try{
			
			
				if(StringUtils.equals("01", depositType)){
					if(semmsi004tab5Bean.getSiteInfoDeptCashElList() != null && semmsi004tab5Bean.getSiteInfoDeptCashElList().size() > 0){
						for(WrapperBeanObject<SiteInfoMapSiteAcqSP> rentContWrapObj : semmsi004tab5Bean.getSiteInfoDeptCashElList()){
							SiteInfoMapSiteAcqSP siteApp = new SiteInfoMapSiteAcqSP(); 
							siteApp = (SiteInfoMapSiteAcqSP) rentContWrapObj.getDataObj();
							
							if(StringUtils.equals(siteAppDepositId, siteApp.getSiteAppDepositId())){
								if(StringUtils.equals("Y", siteApp.getWithdrawFlag())){
									semmsi004tab5Bean.setWithdrawFlagEl(true);
								}else{
									semmsi004tab5Bean.setWithdrawFlagEl(false);
								}
								
//								siteApp.setRentContMode("C");
								semmsi004tab5Bean.setSiteInfoDeptElObj(siteApp);
								semmsi004tab5Bean.setSiteInfoDeptCashElObj(siteApp);
								
								setSemmsi004tab5Bean(semmsi004tab5Bean);
								this.doRenderEditDeptBgCashEl();
								this.initUpdDeptReturnTypeEl();
								this.doCalDepositElReturnAmt();
								this.doCalDepositElAmt();
								this.doInitDepositEl();
								
//								semmsi004tab5Bean.getElectricDepositNormal().setSiteAppDepositId(siteAppDepositId);
//								semmsi004tab5Bean.getElectricDepositNormal().setSiteAppDepositId(siteAppDepositId);
							}
						}
					}
				}
				
				if(StringUtils.equals("02", depositType)){
					if(semmsi004tab5Bean.getSiteInfoDeptBGElList() != null && semmsi004tab5Bean.getSiteInfoDeptBGElList().size() > 0){
						for(WrapperBeanObject<SiteInfoMapSiteAcqSP> rentContWrapObj : semmsi004tab5Bean.getSiteInfoDeptBGElList()){
							SiteInfoMapSiteAcqSP siteApp = new SiteInfoMapSiteAcqSP(); 
							siteApp = (SiteInfoMapSiteAcqSP) rentContWrapObj.getDataObj();
							
							if(StringUtils.equals(siteAppDepositId, siteApp.getSiteAppDepositId())){

								if(StringUtils.equals("Y", siteApp.getWithdrawFlag())){
									semmsi004tab5Bean.setWithdrawFlagEl(true);
								}else{
									semmsi004tab5Bean.setWithdrawFlagEl(false);
								}
								
//								siteApp.setRentContMode("C");
								semmsi004tab5Bean.setSiteInfoDeptElObj(siteApp);
								semmsi004tab5Bean.setSiteInfoDeptBgElObj(siteApp);
								setSemmsi004tab5Bean(semmsi004tab5Bean);
								this.doRenderEditDeptBgCashEl();
								this.initUpdDeptReturnTypeEl();
								this.doCalDepositElReturnAmt();
								this.doCalDepositElAmt();
								this.doInitDepositEl();
								
//								semmsi004tab5Bean.getElectricDepositNormal().setSiteAppDepositId(siteAppDepositId);
//								semmsi004tab5Bean.getElectricDepositNormal().setSiteAppDepositId(siteAppDepositId);
							}
						}
					}
					
				}
				
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("ERROR SEMMSI004Tab5Action doEditDepositEl : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ### END SEMMSI004Tab5Action doEditDepositEl ### ");
		}
		return flag;
	}
	
	//added by NEW 11/02/2016 
	public boolean renderElPayPeriodType(){
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsi004tab5Bean.setElPayPeriodType02("");
				semmsi004tab5Bean.setElPayPeriodType03("");
				semmsi004tab5Bean.setElPayPeriodType04("");
				semmsi004tab5Bean.setElPayPeriodType05("");
				semmsi004tab5Bean.setElPayPeriodType06("");
				semmsi004tab5Bean.setElPayPeriodType07("");
				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsi004tab5Bean.setElPayPeriodType01("");
				semmsi004tab5Bean.setElPayPeriodType03("");
				semmsi004tab5Bean.setElPayPeriodType04("");
				semmsi004tab5Bean.setElPayPeriodType05("");
				semmsi004tab5Bean.setElPayPeriodType06("");
				semmsi004tab5Bean.setElPayPeriodType07("");
				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(semmsi004tab5Bean.getElPayPeriod03() != null) semmsi004tab5Bean.getSiteInfoObjELParam().setElPayPeriod(semmsi004tab5Bean.getElPayPeriod03());
				semmsi004tab5Bean.setElPayPeriodType01("");
				semmsi004tab5Bean.setElPayPeriodType02("");
				semmsi004tab5Bean.setElPayPeriodType04("");
				semmsi004tab5Bean.setElPayPeriodType05("");
				semmsi004tab5Bean.setElPayPeriodType06("");
				semmsi004tab5Bean.setElPayPeriodType07("");
//				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(false);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsi004tab5Bean.getPayPeriod04() != null) semmsi004tab5Bean.getSiteInfoObjELParam().setElPayPeriod(semmsi004tab5Bean.getElPayPeriod04());
				semmsi004tab5Bean.setElPayPeriodType01("");
				semmsi004tab5Bean.setElPayPeriodType02("");
				semmsi004tab5Bean.setElPayPeriodType03("");
				semmsi004tab5Bean.setElPayPeriodType05("");
				semmsi004tab5Bean.setElPayPeriodType06("");
				semmsi004tab5Bean.setElPayPeriodType07("");
				semmsi004tab5Bean.setElPayPeriod03(null);
//				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsi004tab5Bean.setElPayPeriodType01("");
				semmsi004tab5Bean.setElPayPeriodType02("");
				semmsi004tab5Bean.setElPayPeriodType03("");
				semmsi004tab5Bean.setElPayPeriodType04("");
				semmsi004tab5Bean.setElPayPeriodType06("");
				semmsi004tab5Bean.setElPayPeriodType07("");
				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("06")){
				semmsi004tab5Bean.setElPayPeriodType01("");
				semmsi004tab5Bean.setElPayPeriodType02("");
				semmsi004tab5Bean.setElPayPeriodType03("");
				semmsi004tab5Bean.setElPayPeriodType04("");
				semmsi004tab5Bean.setElPayPeriodType05("");
//				semmsi004tab5Bean.setPayPeriodType06("");
				semmsi004tab5Bean.setElPayPeriodType07("");
				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
			if(payPeriodType.equals("07")){
				semmsi004tab5Bean.setElPayPeriodType01("");
				semmsi004tab5Bean.setElPayPeriodType02("");
				semmsi004tab5Bean.setElPayPeriodType03("");
				semmsi004tab5Bean.setElPayPeriodType04("");
				semmsi004tab5Bean.setElPayPeriodType05("");
				semmsi004tab5Bean.setElPayPeriodType06("");
//				semmsi004tab5Bean.setPayPeriodType07("");
				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
			semmsi004tab5Bean.getSiteInfoObjELParam().setPayPeriodType(payPeriodType);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	private boolean initElUpdateCond() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
//		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		
		try{
//			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
//			RentCond rentCond = service.queryRentCondByRowId(rowId);
			if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null){
//				if(StringUtils.isEmpty(semmsi004tab5Bean.getSiteInfoObjELParam().getRentPaymentPeriod())){
//					semmsi004tab5Bean.getSiteInfoObjELParam().setRentPaymentPeriod("");
//				}
				
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("01")){
					semmsi004tab5Bean.setElPayPeriodType01(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType02(null);
					semmsi004tab5Bean.setElPayPeriodType03(null);
					semmsi004tab5Bean.setElPayPeriodType04(null);
					semmsi004tab5Bean.setElPayPeriodType05(null);
					semmsi004tab5Bean.setElPayPeriodType06(null);
					semmsi004tab5Bean.setElPayPeriodType07(null);
					semmsi004tab5Bean.setElPayPeriod03(null);
					semmsi004tab5Bean.setElPayPeriod04(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(true);
					semmsi004tab5Bean.setDisabledElPayPeriod04(true);
					
				}
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("02")){
					semmsi004tab5Bean.setElPayPeriodType02(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType01(null);
					semmsi004tab5Bean.setElPayPeriodType03(null);
					semmsi004tab5Bean.setElPayPeriodType04(null);
					semmsi004tab5Bean.setElPayPeriodType05(null);
					semmsi004tab5Bean.setElPayPeriodType06(null);
					semmsi004tab5Bean.setElPayPeriodType07(null);
					semmsi004tab5Bean.setElPayPeriod03(null);
					semmsi004tab5Bean.setElPayPeriod04(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(true);
					semmsi004tab5Bean.setDisabledElPayPeriod04(true);
				}
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("03")){
					log.debug("getElPayPeriod =: "+semmsi004tab5Bean.getSiteInfoObjELParam().getElPayPeriod());
					
					if(semmsi004tab5Bean.getSiteInfoObjELParam().getElPayPeriod() != null){
//						int payperiod = Integer.parseInt(semmsi004tab5Bean.getSiteInfoRentObjParam().getPayPeriod());
						semmsi004tab5Bean.setElPayPeriod03(semmsi004tab5Bean.getSiteInfoObjELParam().getElPayPeriod());
					}
					
//					semmsi004tab5Bean.setPayPeriod03(BigDecimal.valueOf(arg0) semmsi004tab5Bean.getSiteInfoRentObjParam().getPayPeriod());
					semmsi004tab5Bean.setElPayPeriodType03(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType01(null);
					semmsi004tab5Bean.setElPayPeriodType02(null);
					semmsi004tab5Bean.setElPayPeriodType04(null);
					semmsi004tab5Bean.setElPayPeriodType05(null);
					semmsi004tab5Bean.setElPayPeriodType06(null);
					semmsi004tab5Bean.setElPayPeriodType07(null);
					semmsi004tab5Bean.setElPayPeriod04(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(false);
					semmsi004tab5Bean.setDisabledElPayPeriod04(true);
				}
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("04")){
					
					log.debug("getElPayPeriod =: "+semmsi004tab5Bean.getSiteInfoObjELParam().getElPayPeriod());
					
					if(semmsi004tab5Bean.getSiteInfoObjELParam().getElPayPeriod() != null){
//						int payperiod = Integer.parseInt(semmsi004tab5Bean.getSiteInfoRentObjParam().getElPayPeriod());
						semmsi004tab5Bean.setElPayPeriod04(semmsi004tab5Bean.getSiteInfoObjELParam().getElPayPeriod());
					}
					
//					semmsi004tab5Bean.setElPayPeriod04(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriod());
					semmsi004tab5Bean.setElPayPeriodType04(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType01(null);
					semmsi004tab5Bean.setElPayPeriodType02(null);
					semmsi004tab5Bean.setElPayPeriodType03(null);
					semmsi004tab5Bean.setElPayPeriodType05(null);
					semmsi004tab5Bean.setElPayPeriodType06(null);
					semmsi004tab5Bean.setElPayPeriodType07(null);
					semmsi004tab5Bean.setElPayPeriod03(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(true);
					semmsi004tab5Bean.setDisabledElPayPeriod04(false);
				}
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("05")){
					semmsi004tab5Bean.setElPayPeriodType05(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType01(null);
					semmsi004tab5Bean.setElPayPeriodType02(null);
					semmsi004tab5Bean.setElPayPeriodType03(null);
					semmsi004tab5Bean.setElPayPeriodType04(null);
					semmsi004tab5Bean.setElPayPeriodType06(null);
					semmsi004tab5Bean.setElPayPeriodType07(null);
					semmsi004tab5Bean.setElPayPeriod03(null);
					semmsi004tab5Bean.setElPayPeriod04(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(true);
					semmsi004tab5Bean.setDisabledElPayPeriod04(true);
				}
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("06")){
					semmsi004tab5Bean.setElPayPeriodType06(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType01(null);
					semmsi004tab5Bean.setElPayPeriodType02(null);
					semmsi004tab5Bean.setElPayPeriodType03(null);
					semmsi004tab5Bean.setElPayPeriodType04(null);
					semmsi004tab5Bean.setElPayPeriodType05(null);
					semmsi004tab5Bean.setElPayPeriodType07(null);
					semmsi004tab5Bean.setElPayPeriod03(null);
					semmsi004tab5Bean.setElPayPeriod04(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(true);
					semmsi004tab5Bean.setDisabledElPayPeriod04(true);
					
				}
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType() != null && semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType().equals("07")){
					semmsi004tab5Bean.setElPayPeriodType07(semmsi004tab5Bean.getSiteInfoObjELParam().getPayPeriodType());
					semmsi004tab5Bean.setElPayPeriodType01(null);
					semmsi004tab5Bean.setElPayPeriodType02(null);
					semmsi004tab5Bean.setElPayPeriodType03(null);
					semmsi004tab5Bean.setElPayPeriodType04(null);
					semmsi004tab5Bean.setElPayPeriodType05(null);
					semmsi004tab5Bean.setElPayPeriodType06(null);
					semmsi004tab5Bean.setElPayPeriod03(null);
					semmsi004tab5Bean.setElPayPeriod04(null);
					semmsi004tab5Bean.setDisabledElPayPeriod03(true);
					semmsi004tab5Bean.setDisabledElPayPeriod04(true);
					
				}
				
				setSemmsi004tab5Bean(semmsi004tab5Bean);
			}else{
				semmsi004tab5Bean.setElPayPeriodType01(null);
				semmsi004tab5Bean.setElPayPeriodType02(null);
				semmsi004tab5Bean.setElPayPeriodType03(null);
				semmsi004tab5Bean.setElPayPeriodType04(null);
				semmsi004tab5Bean.setElPayPeriodType05(null);
				semmsi004tab5Bean.setElPayPeriodType06(null);
				semmsi004tab5Bean.setElPayPeriodType07(null);
				semmsi004tab5Bean.setElPayPeriod03(null);
				semmsi004tab5Bean.setElPayPeriod04(null);
				semmsi004tab5Bean.setDisabledElPayPeriod03(true);
				semmsi004tab5Bean.setDisabledElPayPeriod04(true);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public void doChkNoUnitPrice(){
		log.debug(" #### Start SEMMSI004Tab5Action doChkNoUnitPrice #### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(semmsi004tab5Bean.isChkNoUtilPrice()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(null);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" #### Error SEMMSI004Tab5Action doChkNoUnitPrice : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004Tab5Action doChkNoUnitPrice #### ");
		}
	}
	
	public void doGetNoUnitPrice(){
		log.debug(" #### Start SEMMSI004Tab5Action doGetNoUnitPrice #### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			
			if(semmsi004tab5Bean.getSiteInfoObjELParam().getNoUnitPriceFlag() != null 
					&& StringUtils.equals("Y", semmsi004tab5Bean.getSiteInfoObjELParam().getNoUnitPriceFlag())){
				semmsi004tab5Bean.setChkNoUtilPrice(true);
			}else{
				semmsi004tab5Bean.setChkNoUtilPrice(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" #### Error SEMMSI004Tab5Action doGetNoUnitPrice : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004Tab5Action doGetNoUnitPrice #### ");
		}
	}
	
	public boolean doEditEL(){
		log.debug(" ### START SEMMSI004Tab5Action doEditEL ### ");
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String siteInfoELContId = getFacesUtils().getRequestParameter("siteInfoELContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteInfoELContId");
		String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
		String elCondSubtype = getFacesUtils().getRequestParameter("electricCondSubtype") == null ? "" : (String)getFacesUtils().getRequestParameter("electricCondSubtype");
		
		
		try{
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>>  elObjList = new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>();

			if(StringUtils.equals("03", elType)){
				if(StringUtils.equals("01", elCondSubtype)){
					elType = "U";
				}else{
					elType = "T";
				}
			}else if(StringUtils.equals("04", elType)){
				elType = "O";
			}else if(StringUtils.equals("05", elType)){
				elType = "OTH";
			}else if(StringUtils.equals("01", elType)){
				elType = "MEA";
			}else if(StringUtils.equals("02", elType)){
				elType = "PEA";
			}
			
			elObjList = semmsi004tab5Bean.getSiteInfoELCondAllList();
			
			if(elObjList != null){
				for(WrapperBeanObject<SiteInfoMapSiteAcqSP> rentContWrapObj : elObjList){
					SiteInfoMapSiteAcqSP siteApp = new SiteInfoMapSiteAcqSP(); 
					siteApp = (SiteInfoMapSiteAcqSP) rentContWrapObj.getDataObj();
					
					semmsi004tab5Bean.getSiteInfoObjELParam().setServiceId(siteApp.getServiceId());
					
					if(StringUtils.equals(siteInfoELContId, siteApp.getSiteInfoELContId())){
						if(StringUtils.equals("U", elType)){
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt03(siteApp.getElEffectiveDt());
						
							if(siteApp.getElectricAmt() != null)siteApp.setElUnitPrice(siteApp.getElectricAmt());
							semmsi004tab5Bean.setChkElUseOwner(true); 
							
							System.out.println("getServiceId "+siteApp.getServiceId());

//							ow
//							--
							System.out.println("getElCondType "+siteApp.getElCondType());
							System.out.println("getElCondSubType "+siteApp.getElCondSubType());

//							unit
//							--
							System.out.println("getElUnitPric "+siteApp.getElUnitPrice());
							System.out.println("getChkNoUtilPrice "+siteApp.getNoUtilPrice());
							System.out.println("getElVatType "+siteApp.getElVatType());
							System.out.println("getPayPeriodType "+siteApp.getPayPeriodType());
							System.out.println("getElPayPeriod "+siteApp.getElPayPeriod());
							System.out.println("getPeriodStartDT "+siteApp.getPeriodStartDt());
							// set value for edit
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElCondType("01");
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElCondSubType("01");		
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElectricAmt(siteApp.getElectricAmt());				
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType(siteApp.getElVatType());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType(siteApp.getElVatType());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodStartDt(siteApp.getEffectiveDt());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(siteApp.getExpireDt());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(siteApp.getElectricAmt());
							
							semmsi004tab5Bean.setChkElectricType3(true);
							doSelectELUseCond();

						}else if(StringUtils.equals("T", elType)){
							if(siteApp.getDetail() != null)siteApp.setDetail03(siteApp.getDetail());
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt03(siteApp.getElEffectiveDt());
							
							semmsi004tab5Bean.setChkElUseOwner(true);
							semmsi004tab5Bean.setChkElectricType3(true);
							
							System.out.println("getServiceId "+siteApp.getServiceId());

//							ow
//							--
							System.out.println("getElCondType "+siteApp.getElCondType());
							System.out.println("getElCondSubType "+siteApp.getElCondSubType());

//							unit
//							--
							System.out.println("getElUnitPric "+siteApp.getElUnitPrice());
							System.out.println("getChkNoUtilPrice "+siteApp.getNoUtilPrice());
							System.out.println("getElVatType "+siteApp.getElVatType());
							System.out.println("getPayPeriodType "+siteApp.getPayPeriodType());
							System.out.println("getElPayPeriod "+siteApp.getElPayPeriod());
							System.out.println("getPeriodStartDT "+siteApp.getPeriodStartDt());
							
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElCondType("01");
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElCondSubType("02");
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElectricCondSubtype("02");
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElectricAmt(siteApp.getElectricAmt());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setTakeAllPeriodType(siteApp.getElectricPeriodType());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setDetail03(siteApp.getDetail());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType(siteApp.getElVatType());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodStartDt(siteApp.getEffectiveDt());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(siteApp.getExpireDt());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setPayPeriodType(siteApp.getPayPeriodType());
							
							semmsi004tab5Bean.setChkElectricType3(true);
							doSelectELUseCond();	
							
						}else if(StringUtils.equals("O", elType)){
							if(siteApp.getDetail() != null)siteApp.setDetail04(siteApp.getDetail());
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt04(siteApp.getElEffectiveDt());
							
							semmsi004tab5Bean.setChkElectricType4(true);
							
							semmsi004tab5Bean.setChkElUseOthSite(true); 
							if(siteApp.getDetail() != null)siteApp.setDetail04(siteApp.getDetail());
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt04(siteApp.getElEffectiveDt());
							
							System.out.println("getElEditFlag "+semmsi004tab5Bean.getSiteInfoObjELParam().getElEditFlag());
				
							
							siteApp.setElUseOthSiteContractNo(siteApp.getContractNo());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOthSiteContractNo(siteApp.getContractNo());
//							semmsi004tab5Bean.getSiteInfoObjELParam().setDetail04(siteApp.getDetail());
							
							
						}else if(StringUtils.equals("N", elType)){
							if(siteApp.getDetail() != null)siteApp.setDetail03(siteApp.getDetail());
							if(siteApp.getElEffectiveDt() != null)siteApp.setElEffectiveDt03(siteApp.getElEffectiveDt());
						}else if(StringUtils.equals("OTH", elType)){
							semmsi004tab5Bean.setChkElUseOth(true);
							semmsi004tab5Bean.getSiteInfoObjELParam().setElRemark(siteApp.getDetail());
							semmsi004tab5Bean.getSiteInfoObjELParam().setServiceId(siteApp.getServiceId());
							semmsi004tab5Bean.setChkElectricType6(true);
							semmsi004tab5Bean.getSiteElectric().setRemark(siteApp.getDetail());
							
							System.out.println("elEditFlag "+semmsi004tab5Bean.getSiteInfoObjELParam().getElEditFlag());
							
							
						}else if(StringUtils.equals("MEA", elType)){
							siteApp.setElectricType("01");
							siteApp.setSiteAppElContId(siteInfoELContId);
							semmsi004tab5Bean.setChkElectricType1(true);
						
						}else if(StringUtils.equals("PEA", elType)){
							siteApp.setElectricType("02");
							siteApp.setSiteAppElContId(siteInfoELContId);
							semmsi004tab5Bean.setChkElectricType2(true);
						}
						System.out.println("getWthType "+siteApp.getWthType());
//						siteApp.setRentContMode("H");
//						semmsi004tab5Bean.siteInfoObjELParam.wthType
						semmsi004tab5Bean.setSiteInfoObjELParam(siteApp);
						setSemmsi004tab5Bean(semmsi004tab5Bean);
						if(StringUtils.equals("U", elType) || StringUtils.equals("T", elType)){
							this.doGetNoUnitPrice();
							this.initElUpdateCond();
						}
					}
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("ERROR SEMMSI004Tab5Action doEditEL : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ### START SEMMSI004Tab5Action doEditEL ### ");
		}
		return flag;
	}
	
	public boolean doClearSiteAppDepositEl(){
		log.debug(" #### Start SEMMSI004Tab5Action doClearSiteAppDepositEl ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			semmsi004tab5Bean.setSiteInfoDeptElObj(new SiteInfoMapSiteAcqSP());
			semmsi004tab5Bean.setSiteInfoDeptCashElObj(new SiteInfoMapSiteAcqSP());
			semmsi004tab5Bean.setSiteInfoDeptBgElObj(new SiteInfoMapSiteAcqSP());
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			this.initUpdDeptElReturnType();
			this.doRenderDeptBgCashEl();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab5Action doClearSiteAppDepositEl : "+e);
		}
		log.debug(" #### End SEMMSI004Tab5Action doClearSiteAppDepositEl ####");
		return true;
	}
	
	public void doRenderDeptBgCashEl(){
		log.debug(" #### Start SEMMSI004Tab5Action doRenderDeptBgCash ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.setRenderedPnlDeptCashEl(false);
		semmsi004tab5Bean.setRenderedPnlDeptBgEl(false);
		try{
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null){
				if(StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
					semmsi004tab5Bean.setRenderedPnlDeptCashEl(true);
					semmsi004tab5Bean.setRenderedPnlDeptBgEl(false);
				}else if(StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
					semmsi004tab5Bean.setRenderedPnlDeptCashEl(false);
					semmsi004tab5Bean.setRenderedPnlDeptBgEl(true);
				}
				semmsi004tab5Bean.getElectricDepositNormal().setExpenseType("");
				semmsi004tab5Bean.getElectricDepositNormal().setServiceId("");
				semmsi004tab5Bean.getElectricDepositNormal().setRemark("");
				semmsi004tab5Bean.setSiteInfoDeptCashElObj(new SiteInfoMapSiteAcqSP());
				semmsi004tab5Bean.setSiteInfoDeptBgElObj(new SiteInfoMapSiteAcqSP());
				setSemmsi004tab5Bean(semmsi004tab5Bean);
				this.initUpdDeptElReturnType();
				this.doCalDepositElReturnAmt();
				this.doCalDepositElAmt();
				this.doInitDepositEl();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action doRenderDeptBgCash : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### END SEMMSI004Tab5Action doRenderDeptBgCash ####");
		}
	}
	
	public void doRenderEditDeptBgCashEl(){
		log.debug(" #### Start SEMMSI004Tab5Action doRenderEditDeptBgCashEl ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.setRenderedPnlDeptCashEl(false);
		semmsi004tab5Bean.setRenderedPnlDeptBgEl(false);
		try{
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null){
				if(StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
					semmsi004tab5Bean.setRenderedPnlDeptCashEl(true);
					semmsi004tab5Bean.setRenderedPnlDeptBgEl(false);
				}else if(StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
					semmsi004tab5Bean.setRenderedPnlDeptCashEl(false);
					semmsi004tab5Bean.setRenderedPnlDeptBgEl(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action doRenderEditDeptBgCashEl : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### END SEMMSI004Tab5Action doRenderEditDeptBgCashEl ####");
		}
	}
	
	public void initUpdDeptElReturnType(){
		log.debug(" #### START SEMMSI004Tab5Action initUpdDeptElReturnType ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType())){
						semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnType("");
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("01")){
						semmsi004tab5Bean.setDeptReturnTypeEl01(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("02")){
						semmsi004tab5Bean.setDeptReturnTypeEl02(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

//						semmsi004tab5Bean.getSiteAppDeptObj().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("03")){
						semmsi004tab5Bean.setDeptReturnTypeEl03(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);

						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
				}else{
					semmsi004tab5Bean.setDeptReturnTypeEl01(null);
					semmsi004tab5Bean.setDeptReturnTypeEl02(null);
					semmsi004tab5Bean.setDeptReturnTypeEl03(null);

					semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
				}
			}else if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType())){
						semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnType("");
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getRentPaymentPeriod() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("01")){
						semmsi004tab5Bean.setDeptReturnTypeEl01(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getRentPaymentPeriod() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("02")){
						semmsi004tab5Bean.setDeptReturnTypeEl02(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl03(null);

//						semmsi004tab5Bean.getSiteAppDeptObj().setReturnAmt(null);
						
					}
					
					if(semmsi004tab5Bean.getElectricDepositNormal().getRentPaymentPeriod() != null && semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType().equals("03")){
						semmsi004tab5Bean.setDeptReturnTypeEl03(semmsi004tab5Bean.getElectricDepositNormal().getDepositReturnType());
						semmsi004tab5Bean.setDeptReturnTypeEl01(null);
						semmsi004tab5Bean.setDeptReturnTypeEl02(null);

						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
						
					}
					
				}else{
					semmsi004tab5Bean.setDeptReturnTypeEl01(null);
					semmsi004tab5Bean.setDeptReturnTypeEl02(null);
					semmsi004tab5Bean.setDeptReturnTypeEl03(null);

					semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
				}
			}else{
				semmsi004tab5Bean.setDeptReturnTypeEl01(null);
				semmsi004tab5Bean.setDeptReturnTypeEl02(null);
				semmsi004tab5Bean.setDeptReturnTypeEl03(null);
				semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
				semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action initUpdDeptElReturnType : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### END SEMMSI004Tab5Action initUpdDeptElReturnType ####");
		}
	}
	
	public void doCalDepositElReturnAmt(){
		log.debug(" #### Start SEMMSI004Tab5Action doCalDepositElReturnAmt ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		Double deptReturnAmt = new Double(0);
		try{
			if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtOld() != null){
				deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtOld();
			}
			
			if(semmsi004tab5Bean.getDeptReturnTypeEl02() != null && StringUtils.equals("02", semmsi004tab5Bean.getDeptReturnTypeEl02())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt() != null){
					deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getReturnAmt();
				}
				
			}
			
			
			semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnAmt(deptReturnAmt);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action doCalDepositElReturnAmt : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004Tab5Action doCalDepositElReturnAmt ####");
		}
	}
	
	public void doCalDepositElAmt(){
		log.debug(" #### Start SEMMSI004Tab5Action doCalDepositElAmt ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		Double deptReturnAmt = new Double(0);
		try{
			
			if(StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtOld() != null){
					deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtOld();
				}
			
				
				if(semmsi004tab5Bean.isWithdrawFlagEl()){
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtNew() != null){
						deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtNew();
					}
					
				}
				
				
				semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(deptReturnAmt);
			}
			
			if(StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtOld() != null){
					deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtOld();
				}
			
				
				if(semmsi004tab5Bean.isWithdrawFlagEl()){
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtNew() != null){
						deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtNew();
					}
					
				}
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtNew() != null){
					deptReturnAmt = semmsi004tab5Bean.getElectricDepositNormal().getDepositAmtNew();
				}
			
				
				
				semmsi004tab5Bean.getElectricDepositNormal().setDepositAmt(deptReturnAmt);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action doCalDepositElAmt : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004Tab5Action doCalDepositElAmt ####");
		}
	}
	
	public void doInitDepositEl(){
		log.debug(" ### START SEMMSI004Tab5Action doInitDepositEl ### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String depositType = semmsi004tab5Bean.getElectricDepositNormal().getDepositType();
		try{
			if(StringUtils.equals("01", depositType)){
				if(semmsi004tab5Bean.getElectricDepositNormal().getWithdrawFlag() != null && StringUtils.equals("Y", semmsi004tab5Bean.getElectricDepositNormal().getWithdrawFlag())){
					semmsi004tab5Bean.setWithdrawFlagEl(true);
				}else{
					semmsi004tab5Bean.setWithdrawFlagEl(false);
				}
				log.debug("doInitDepositEl Cash getWithdrawFlag : "+semmsi004tab5Bean.getElectricDepositNormal().getWithdrawFlag());
			
			}
			
			if(StringUtils.equals("02", depositType)){
				if(semmsi004tab5Bean.getElectricDepositNormal().getWithdrawFlag() != null && StringUtils.equals("Y", semmsi004tab5Bean.getElectricDepositNormal().getWithdrawFlag())){
					semmsi004tab5Bean.setWithdrawFlagEl(true);
				}else{
					semmsi004tab5Bean.setWithdrawFlagEl(false);
				}
				log.debug("doInitDepositEl BG getWithdrawFlag : "+semmsi004tab5Bean.getElectricDepositNormal().getWithdrawFlag());
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" Error SEMMSI004Tab5Action doInitDepositEl ");
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ### END SEMMSI004Tab5Action doInitDepositEl ### ");
		}
	}
	
	public boolean renderDeptReturnTypeEl(){
		log.debug(" #### START SEMMSI004Tab5Action renderDeptReturnTypeEl ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		
		try{
			String deptReturnType = getFacesUtils().getRequestParameter("deptReturnType") == null ? "" : (String)getFacesUtils().getRequestParameter("deptReturnType");
			if(deptReturnType != null){
				if(StringUtils.equals("01", deptReturnType)){
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
					}else if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
					}
					
					
//					semmsi004tab5Bean.setDeptReturnType01(true);
					semmsi004tab5Bean.setDeptReturnTypeEl02("");
					semmsi004tab5Bean.setDeptReturnTypeEl03("");
				}
				
				if(StringUtils.equals("02", deptReturnType)){
					
					
					semmsi004tab5Bean.setDeptReturnTypeEl01("");
//					semmsi004tab5Bean.setDeptReturnType02(true);
					semmsi004tab5Bean.setDeptReturnTypeEl03("");
				}
				
				if(StringUtils.equals("03", deptReturnType)){
					if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
					}else if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
						semmsi004tab5Bean.getElectricDepositNormal().setReturnAmt(null);
					}
					
					semmsi004tab5Bean.setDeptReturnTypeEl01("");
					semmsi004tab5Bean.setDeptReturnTypeEl02("");
//					semmsi004tab5Bean.setDeptReturnType03(true);
				}
				if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
					semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnType(deptReturnType);
				}else if(semmsi004tab5Bean.getElectricDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab5Bean.getElectricDepositNormal().getDepositType())){
					semmsi004tab5Bean.getElectricDepositNormal().setDepositReturnType(deptReturnType);
				}
				setSemmsi004tab5Bean(semmsi004tab5Bean);
				this.doCalDepositElReturnAmt();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab5Action renderDeptReturnTypeEl : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### END SEMMSI004Tab5Action renderDeptReturnTypeEl ####");
		}
		return true;
	}
	
	public void doSiteAppELCondSrch(){
		log.debug(" #### Start SEMMSI004Tab5Action doSiteAppELCondSrch ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		try{
			log.debug("SEMMSI004tab5 getSiteInfoId : "+semmsi004tab5Bean.getSiteInfoId());
			SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
			siteAppObj.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			siteAppObj.setMode("A");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_SRCH.name, siteAppObj);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab5Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab5Bean.setSiteInfoELCondExistingList(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab5Bean.setRenderedMsgDataNotFound(false);

//				semmsi004tab5Bean.setSiteInfoDeptObj(new SiteInfoMapSiteAcqSP());
				semmsi004tab5Bean.setSiteInfoELCondExistingList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
//				semmsi004tab5Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
					WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsi004tab5Bean.setNoExpFlag(true);
//						}else{
//							semmsi004tab5Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsi004tab5Bean.setNoExpFlag(false);
//					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getElEffectiveDt() != null){
						siteAcq.setChgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getElEffectiveDt()));
					}
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
//					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsi004tab5Bean.getSiteInfoELCondExistingList().add(tmpWrapperBean);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab5Action doSiteAppELCondSrch : "+e);
		}finally{
			log.debug(" #### End SEMMSI004Tab5Action doSiteAppELCondSrch ####");
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
	}
	
	public void doSiteAppELCondSrch(String siteInfoId, String mode){
		log.debug(" #### Start SEMMSI004Tab5Action doSiteAppELCondSrch ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		try{
			log.debug("SEMMSI004tab5 getSiteInfoId : "+semmsi004tab5Bean.getSiteInfoId());
			SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
			siteAppObj.setSiteInfoId(siteInfoId);
			siteAppObj.setMode("A");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_SRCH.name, siteAppObj);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab5Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab5Bean.setSiteInfoELCondExistingList(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab5Bean.setRenderedMsgDataNotFound(false);

//				semmsi004tab5Bean.setSiteInfoDeptObj(new SiteInfoMapSiteAcqSP());
				semmsi004tab5Bean.setSiteInfoELCondExistingList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
//				semmsi004tab5Bean.setSiteAppDeptBGList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
					WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsi004tab5Bean.setNoExpFlag(true);
//						}else{
//							semmsi004tab5Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsi004tab5Bean.setNoExpFlag(false);
//					}
					
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getElEffectiveDt() != null){
						siteAcq.setChgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getElEffectiveDt()));
					}
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
//					
//					if(siteAcq.getEndDt() != null){
//						siteAcq.setEndDtStr(convertYearENtoTHStr(siteAcq.getEndDt()));
//					}
//					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsi004tab5Bean.getSiteInfoELCondExistingList().add(tmpWrapperBean);
						
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab5Action doSiteAppELCondSrch : "+e);
		}finally{
			log.debug(" #### End SEMMSI004Tab5Action doSiteAppELCondSrch ####");
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
	}
	
	public void msi004tab5_doChkContractElUse() {
		try {
			
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			
			String myRetResult = "";
			String myRetMsg = "";
			String myRetContractNo = "";
			
			//String strElUseOthSiteContractNo = semmsa002Bean.getSiteAppObjParam().getElUseOthSiteContractNo() == null ? "" : (String) semmsa002Bean.getSiteAppObjParam().getElUseOthSiteContractNo();
			
			List<SiteAppSP> resultList = new ArrayList<SiteAppSP>();
	        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 

	        resultList = service.siteAppDao_querySPList(EQueryName.SP_MSA002_CHECK_CONTRACT_EL_USE.name, semmsi004tab5Bean.getSiteInfoObjParam());
        	
	        if(resultList != null && !resultList.isEmpty()){
	        	myRetResult = resultList.get(0).getRetResult() == null ? "" : resultList.get(0).getRetResult().toString();
	        	myRetMsg = resultList.get(0).getRetResultMsg() == null ? "" : resultList.get(0).getRetResultMsg().toString();
	        	myRetContractNo = resultList.get(0).getContractNo() == null ? "" : resultList.get(0).getContractNo().toString();
				
	        	if(myRetResult.equalsIgnoreCase("FOUND")){
	        		//semmsa002Bean.getSiteAppObjParam().setElUseOthSiteContractNo(myRetContractNo);
	        	} else {
	        		if(myRetResult.equalsIgnoreCase("NOT FOUND")){
	        			semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOthSiteContractNo(myRetContractNo);
	        			
	        			FrontMessageUtils.addMessageError(myRetMsg);
	        			semmsi004tab5Bean.setRenderedMsgAlert(true);
	        		} else {
	        			semmsi004tab5Bean.setRenderedMsgAlert(false);
	        		}
	        	}
        	}
			
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsi004tab5Bean.setRenderedMsgAlert(true);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		} finally {
			
		}
	}
	
	public boolean doInitAddSiteAppELCond(){
		log.debug(" ####### Start SEMMSI004Tab5Action doInitAddSiteAppELCond ######");
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			if(StringUtils.equals("01", elType)){
				if(semmsi004tab5Bean.isChkElectricType1()){
					this.doAddSiteAppELCond();
				}else{
					this.doDetSiteAppELCond();
				}
			}else if(StringUtils.equals("02", elType)){
				if(semmsi004tab5Bean.isChkElectricType2()){
					this.doAddSiteAppELCond();
				}else{
					this.doDetSiteAppELCond();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" #### Error SEMMSI004Tab5Action doInitAddSiteAppELCond : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ####### Start SEMMSI004Tab5Action doInitAddSiteAppELCond ######");
		}
		return flag;
	}
	
	public void msi04tab5_doChkElctType() {
		
		try {
			
			semmsi004tab5Bean = getSemmsi004tab5Bean();
//			System.out.println("semmsi004tab5Bean.siteAppObjParam.elPayOnPackageAmt : "+semmsi004tab5Bean.getSiteAppObjParam().getElPayOnPackageAmt());
			//semmsi004tab5Bean.setDisabledElctTypeDetail(true);
			
			// -- 
			String paramChkElType = getFacesUtils().getRequestParameter("paramChkElType") == null ? "" : (String) getFacesUtils().getRequestParameter("paramChkElType");
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String) getFacesUtils().getRequestParameter("elType");
			semmsi004tab5Bean.getSiteInfoObjELParam().setElEffectiveDt(null);
			semmsi004tab5Bean.getSiteInfoObjELParam().setElCondType("");
			semmsi004tab5Bean.getSiteInfoObjELParam().setElCondSubType("");
			semmsi004tab5Bean.getSiteInfoObjELParam().setElRemark("");
			
			if(paramChkElType.equals("MEA")){
				semmsi004tab5Bean.setChkElUseOldMeter(false);
//				semmsi004tab5Bean.setChkElectricType1(true);
				semmsi004tab5Bean.setChkElectricType2(false);
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
					semmsi004tab5Bean.setChkElUseOldMeter(false);
//					semmsi004tab5Bean.setChkElUseNewMeter(false);
					semmsi004tab5Bean.setChkElUseOwner(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
					semmsi004tab5Bean.setChkElUseOthSite(false);
					semmsi004tab5Bean.setChkElUseOth(false);
//					semmsi004tab5Bean.setDisabledElctTypeDetail(true);
//					semmsi004tab5Bean.setDisabledElctPackageTypeDetail(true);
//					semmsi004tab5Bean.setDisabledElctUnitTypeDetail(true);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
					semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("");
//					semmsi004tab5Bean.setChkElectricType2(false);
//					semmsi004tab5Bean.setChkElectricType3(false);
//					semmsi004tab5Bean.setChkElectricType4(false);
//					semmsi004tab5Bean.setChkElectricType5(false);
//					semmsi004tab5Bean.setChkElectricType6(false);
				}
				if(semmsi004tab5Bean.isChkElUseOwner()){
//					semmsi004tab5Bean.setDisabledElctTypeDetail(false);
					
				} else {
					semmsi004tab5Bean.setChkElPayOnPackage(false);
//					semmsi004tab5Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
//					semmsi004tab5Bean.getSiteAppObjParam().setElPackagePeriodType("");
					semmsi004tab5Bean.setChkElOwnerType(false);
//					semmsi004tab5Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//					semmsi004tab5Bean.getSiteAppObjParam().setElVatType("");
				}
				this.renderElectricType1();
				this.doInitAddSiteAppELCond();
			}else if( paramChkElType.equals("PEA")){
				semmsi004tab5Bean.setChkElUseOldMeter(false);
//				semmsi004tab5Bean.setChkElectricType2(true);
				semmsi004tab5Bean.setChkElectricType1(false);
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
					semmsi004tab5Bean.setChkElUseOldMeter(false);
//					semmsi004tab5Bean.setChkElUseNewMeter(false);
					semmsi004tab5Bean.setChkElUseOwner(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
					semmsi004tab5Bean.setChkElUseOthSite(false);
					semmsi004tab5Bean.setChkElUseOth(false);
//					semmsi004tab5Bean.setDisabledElctTypeDetail(true);
//					semmsi004tab5Bean.setDisabledElctPackageTypeDetail(true);
//					semmsi004tab5Bean.setDisabledElctUnitTypeDetail(true);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
					semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("");
//					semmsi004tab5Bean.setChkElectricType1(false);
//					semmsi004tab5Bean.setChkElectricType3(false);
//					semmsi004tab5Bean.setChkElectricType4(false);
//					semmsi004tab5Bean.setChkElectricType5(false);
//					semmsi004tab5Bean.setChkElectricType6(false);
				}
				if(semmsi004tab5Bean.isChkElUseOwner()){
//					semmsi004tab5Bean.setDisabledElctTypeDetail(false);
					
				} else {
					semmsi004tab5Bean.setChkElPayOnPackage(false);
//					semmsi004tab5Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
//					semmsi004tab5Bean.getSiteAppObjParam().setElPackagePeriodType("");
					semmsi004tab5Bean.setChkElOwnerType(false);
//					semmsi004tab5Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//					semmsi004tab5Bean.getSiteAppObjParam().setElVatType("");
				}
				this.renderElectricType2();
				this.doInitAddSiteAppELCond();
			} else if(paramChkElType.equals("OWNER")){
//				semmsi004tab5Bean.setChkElUseOldMeter(false);
				//added by NEW 20160401 check if check MultiElectric checkbox
//				semmsi004tab5Bean.setChkElectricType3(true);
				if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
					semmsi004tab5Bean.setChkElUseOldMeter(false);
					semmsi004tab5Bean.setChkElUseNewMeter(false);
//					semmsi004tab5Bean.setChkElUseOwner(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
					semmsi004tab5Bean.setChkElUseOthSite(false);
					semmsi004tab5Bean.setChkElUseOth(false);
//					semmsi004tab5Bean.setChkElectricType1(false);
//					semmsi004tab5Bean.setChkElectricType2(false);
//					semmsi004tab5Bean.setChkElectricType4(false);
//					semmsi004tab5Bean.setChkElectricType5(false);
//					semmsi004tab5Bean.setChkElectricType6(false);
				}
				if(semmsi004tab5Bean.isChkElUseOwner()){
//					semmsi004tab5Bean.setDisabledElctTypeDetail(false);
//					semmsi004tab5Bean.setChkNoExpenses(false);
					if(!elType.equals("")){
						semmsi004tab5Bean.setChkNoExpenses(false);
						if(elType.equals("T")){
							semmsi004tab5Bean.getSiteInfoObjParam().setElUnitPrice(new BigDecimal(0));
							if(semmsi004tab5Bean.isChkElPayOnPackage()){
								semmsi004tab5Bean.setChkElOwnerType(false);
//								semmsi004tab5Bean.setDisabledElctPackageTypeDetail(false);
//								semmsi004tab5Bean.setDisabledElctUnitTypeDetail(true);
								semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
							}else{
//								semmsi004tab5Bean.setChkElPayOnPackage(false);
//								semmsi004tab5Bean.setDisabledElctPackageTypeDetail(true);
//								semmsi004tab5Bean.setDisabledElctUnitTypeDetail(false);
								semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
								semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
							}
//							semmsi004tab5Bean.setChkElPayOnPackage(true);
//							semmsi004tab5Bean.setChkElOwnerType(false);
						}else{
							semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(new BigDecimal(0));
							semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
							if(semmsi004tab5Bean.isChkElOwnerType()){
								semmsi004tab5Bean.setChkElPayOnPackage(false);
								semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
								semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
							}else{
//								semmsi004tab5Bean.setChkElOwnerType(false);
//								semmsi004tab5Bean.setDisabledElctPackageTypeDetail(false);
								semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
							}
//							semmsi004tab5Bean.setChkElPayOnPackage(false);
//							semmsi004tab5Bean.setChkElOwnerType(true);
						}
					}
				} else {
					semmsi004tab5Bean.setChkElPayOnPackage(false);
					semmsi004tab5Bean.setChkElOwnerType(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
				}
				this.renderElectricType3();
			}  else if(paramChkElType.equals("OLD")){
				//added by NEW 20160401 check if check MultiElectric checkbox
//				semmsi004tab5Bean.setChkElectricType5(true);
				if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
//					semmsi004tab5Bean.setChkElUseOldMeter(false);
					semmsi004tab5Bean.setChkElUseNewMeter(false);
					semmsi004tab5Bean.setChkElUseOwner(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
					semmsi004tab5Bean.setChkElUseOthSite(false);
					semmsi004tab5Bean.setChkElUseOth(false);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
					semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsi004tab5Bean.setChkElPayOnPackage(false);
					semmsi004tab5Bean.setChkElOwnerType(false);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("");
//					semmsi004tab5Bean.setChkElectricType1(false);
//					semmsi004tab5Bean.setChkElectricType2(false);
//					semmsi004tab5Bean.setChkElectricType3(false);
//					semmsi004tab5Bean.setChkElectricType4(false);
//					semmsi004tab5Bean.setChkElectricType6(false);
				}
				semmsi004tab5Bean.setChkElUseNewMeter(false);
//				semmsi004tab5Bean.setChkElUseOwner(false);
				
//				semmsi004tab5Bean.setChkElPayOnPackage(false);
//				semmsi004tab5Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
//				semmsi004tab5Bean.getSiteAppObjParam().setElPackagePeriodType("");
//				semmsi004tab5Bean.setChkElOwnerType(false);
//				semmsi004tab5Bean.setChkNoExpenses(false);
//				semmsi004tab5Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
//				semmsi004tab5Bean.getSiteAppObjParam().setElVatType("");
			}else if(paramChkElType.equals("OTHER")){
//				semmsi004tab5Bean.getSiteAppObjParam().setElUseOthSiteContractNo("");
				//added by NEW 20160401 check if check MultiElectric checkbox
//				semmsi004tab5Bean.setChkElectricType4(true);
				if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
					semmsi004tab5Bean.setChkElUseOldMeter(false);
					semmsi004tab5Bean.setChkElUseNewMeter(false);
					semmsi004tab5Bean.setChkElUseOwner(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
//					semmsi004tab5Bean.setChkElUseOthSite(false);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
					semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsi004tab5Bean.setChkElPayOnPackage(false);
					semmsi004tab5Bean.setChkElOwnerType(false);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("");
//					semmsi004tab5Bean.setChkElectricType1(false);
//					semmsi004tab5Bean.setChkElectricType2(false);
//					semmsi004tab5Bean.setChkElectricType3(false);
//					semmsi004tab5Bean.setChkElectricType5(false);
//					semmsi004tab5Bean.setChkElectricType6(false);
				}
				if(semmsi004tab5Bean.isChkElectricType4()){
					semmsi004tab5Bean.setDisabledElUserOthSite(false);
				}else{
					semmsi004tab5Bean.setDisabledElUserOthSite(true);
				}
				this.renderElectricType4();
			}else if(paramChkElType.equals("OTH")){
				semmsi004tab5Bean.setChkElUseOldMeter(false);
//				semmsi004tab5Bean.setChkElectricType6(true);
				//added by NEW 20160401 check if check MultiElectric checkbox
				if(!semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
					semmsi004tab5Bean.setChkElUseOldMeter(false);
					semmsi004tab5Bean.setChkElUseNewMeter(false);
					semmsi004tab5Bean.setChkElUseOwner(false);
					semmsi004tab5Bean.setChkNoExpenses(false);
					semmsi004tab5Bean.setChkElUseOthSite(false);
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackageAmt(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElPackagePeriodType("");
					semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(BigDecimal.valueOf(0));
					semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("");
//					semmsi004tab5Bean.setChkElectricType1(false);
//					semmsi004tab5Bean.setChkElectricType2(false);
//					semmsi004tab5Bean.setChkElectricType3(false);
//					semmsi004tab5Bean.setChkElectricType4(false);
//					semmsi004tab5Bean.setChkElectricType5(false);
				}
			}
			
			/*if(semmsi004tab5Bean.isChkElUseNewMeter()){
				semmsi004tab5Bean.setChkElPayOnPackage(false);
				semmsi004tab5Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
				semmsi004tab5Bean.getSiteAppObjParam().setElPackagePeriodType("");
				semmsi004tab5Bean.setChkElOwnerType(false);
				semmsi004tab5Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
				semmsi004tab5Bean.getSiteAppObjParam().setElVatType("");
				
				semmsi004tab5Bean.setDisabledElctTypeChk1(true);
				semmsi004tab5Bean.setDisabledElctTypeChk2(true);
			} else {
				semmsi004tab5Bean.setDisabledElctTypeChk1(false);
			}
			
			if(semmsi004tab5Bean.isChkElUseOwner()){
				semmsi004tab5Bean.setDisabledElctTypeDetail(false);
				semmsi004tab5Bean.setDisabledElctTypeChk1(false);
				semmsi004tab5Bean.setDisabledElctTypeChk2(true);
			} else {
				semmsi004tab5Bean.setDisabledElctTypeChk2(false);
			}
			
			if(semmsi004tab5Bean.isChkElUseOldMeter()){
				semmsi004tab5Bean.setChkElUseNewMeter(false);
				semmsi004tab5Bean.setChkElUseOwner(false);
				
				semmsi004tab5Bean.setChkElPayOnPackage(false);
				semmsi004tab5Bean.getSiteAppObjParam().setElPayOnPackageAmt(new BigDecimal(0));
				semmsi004tab5Bean.getSiteAppObjParam().setElPackagePeriodType("");
				semmsi004tab5Bean.setChkElOwnerType(false);
				semmsi004tab5Bean.getSiteAppObjParam().setElUnitPrice(new BigDecimal(0));
				semmsi004tab5Bean.getSiteAppObjParam().setElVatType("");
				
				semmsi004tab5Bean.setDisabledElctTypeChk1(true);
				semmsi004tab5Bean.setDisabledElctTypeChk2(false);
			} else {
				semmsi004tab5Bean.setDisabledElctTypeChk1(false);
			}*/
			
			countElType();
			doCheckElecticTypeChanged();
			
			setSemmsi004tab5Bean(semmsi004tab5Bean);
//			System.out.println("semmsi004tab5Bean.siteAppObjParam.elPayOnPackageAmt : "+semmsi004tab5Bean.getSiteAppObjParam().getElPayOnPackageAmt());
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
		}
	}
	
	public void countElType() {

		
		int count = 0;
		
		if((!semmsi004tab5Bean.isChkMultiElectricTypeFlag() )){
			int temp = 2;
			for (int i = 0; i == 0; i++) {
				if (semmsi004tab5Bean.isChkElectricType1() || semmsi004tab5Bean.isChkElectricType2()) {
					count = count + 1;
				}
				if (semmsi004tab5Bean.isChkElectricType3()) {
					count = count + 1;
				}
				if (semmsi004tab5Bean.isChkElectricType4()) {
					count = count + 1;
				}
				if (semmsi004tab5Bean.isChkElectricType5()) {
					count = count + 1;
				}

			}
			if(count >= temp){
				semmsi004tab5Bean.setChkMultiElectricTypeFlag(true);
			}else{
				semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
			}
		}else if(semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
			int temp = 2;
			for (int i = 0; i == 0; i++) {
				if (semmsi004tab5Bean.isChkElectricType1() || semmsi004tab5Bean.isChkElectricType2()) {
					count = count + 1;
				}
				if (semmsi004tab5Bean.isChkElectricType3()) {
					count = count + 1;
				}
				if (semmsi004tab5Bean.isChkElectricType4()) {
					count = count + 1;
				}if (semmsi004tab5Bean.isChkElectricType5()) {
					count = count + 1;
				}

			}
			if(count==2){
				semmsi004tab5Bean.setCount(2);
			}
			
			if(count <= temp){
				if(semmsi004tab5Bean.getCount()==2){
					semmsi004tab5Bean.setChkMultiElectricTypeFlag(true);
					semmsi004tab5Bean.setCount(0);
				}else if(count==1){
					semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
					semmsi004tab5Bean.setCount(0);
				}else{
					semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
				}
			}
			
		}		
		
	}
	
	public boolean doCheckElecticTypeChanged(){
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
		
			// ------------ chack EL MEA Meter----------------
			
			if(!semmsi004tab5Bean.isChkElectricType1()){
				if(StringUtils.equals("Y",semmsi004tab5Bean.getSiteElectric().getElectricType1())){
					addMessageErrorWithArgument("W0176", msg("msg.elmea"));
				}
			}
			
			
			// ------------ chack EL PEA Meter ----------------
			if(!semmsi004tab5Bean.isChkElectricType2()){
				if(StringUtils.equals("Y",semmsi004tab5Bean.getSiteElectric().getElectricType2())){
					addMessageErrorWithArgument("W0176", msg("msg.elpea"));
				}
			}
			
			// ------------ chack EL Owner ----------------
			if(!semmsi004tab5Bean.isChkElectricType3()){
				if(StringUtils.equals("Y",semmsi004tab5Bean.getSiteElectric().getElectricType3())){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOwner"));
				}
					
			}
			
			// ------------ chack EL chkElUseOthSite ----------------
			if(!semmsi004tab5Bean.isChkElectricType4()){
				if(StringUtils.equals("Y",semmsi004tab5Bean.getSiteElectric().getElectricType4())){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOthSite"));
				}
				
			}
			
			// ------------ chack EL chkElUseOth ----------------
			if(!semmsi004tab5Bean.isChkElectricType5()){
				if(StringUtils.equals("Y",semmsi004tab5Bean.getSiteElectric().getElectricType5())){
					addMessageErrorWithArgument("W0176", msg("msg.elUseOth"));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" ########## Error SEMMSI004Tab5Action doCheckElecticTypeChanged #########");
		}finally{
			
		}
		return flag;
	}
	
	public void doSelectELUseCond(){
		log.debug(" #### Start SEMMSI004Tab5Action doSelectELUseCond ####");	
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			log.debug("semmsi004tab5Bean.getSiteInfoObjELParam().getElCondType() : "+semmsi004tab5Bean.getSiteInfoObjELParam().getElCondType());
			if(StringUtils.equals("00", semmsi004tab5Bean.getSiteInfoObjELParam().getElCondType())){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElCondSubType("");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(null);
				semmsi004tab5Bean.setChkNoUtilPrice(false);
			}else{
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" #### ERROR SEMMSI004Tab5Action doSelectELUseCond : "+e);	
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004Tab5Action doSelectELUseCond ####");	
		}
	}
	
	public void tab5AddContractElUse_doClearContractElUse() {
		try {
			
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			
			semmsi004tab5Bean.setContractElUseObjParam(new SiteInfoMapSiteAcqSP());
			semmsi004tab5Bean.setContractElUseList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
			semmsi004tab5Bean.setMsgReqcompanyPopup(null);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSI004Tab5Action");
			
		} finally {
		}
	}
	
	
	public void doSetELCheckBoxEntity() {
		
		try {
			
			semmsi004tab5Bean = getSemmsi004tab5Bean();

			
			
			// tab4
			if(semmsi004tab5Bean.isChkElUseNewMeter()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseNewMeter("Y");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType1("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseNewMeter("");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType1("");
			}
			
			if(semmsi004tab5Bean.isChkElUseOwner()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOwner("Y");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType3("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOwner("");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType3("");
			}

			if(semmsi004tab5Bean.isChkElUseOldMeter()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOldMeter("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOldMeter("");
			}

			if(semmsi004tab5Bean.isChkElPayOnPackage()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackage("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElPayOnPackage("");
			}

			if(semmsi004tab5Bean.isChkElOwnerType()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElOwnerType("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElOwnerType("");
			}
			
			if(semmsi004tab5Bean.isChkElDepositFlag()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElDepositFlag("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElDepositFlag("");
			}
			
			if(semmsi004tab5Bean.isChkElUseOthSite()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOthSite("Y");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType4("Y");
			} else {
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOthSite("N");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType4("");
			}
			
			if(semmsi004tab5Bean.isChkNoExpenses()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElNoExpenses("Y");
			}else{
				semmsi004tab5Bean.getSiteInfoObjELParam().setElNoExpenses("");
			}
			
			if(semmsi004tab5Bean.isChkMultiElectricTypeFlag()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseMultiResourse("Y");
			}else{
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseMultiResourse("");
			}
			
			if(semmsi004tab5Bean.isChkNoUtilPrice()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setNoUtilPrice("Y");
			}else{
				semmsi004tab5Bean.getSiteInfoObjELParam().setNoUtilPrice("");
			}
			
			if(semmsi004tab5Bean.isChkElUseOth()){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOth("Y");
			}else{
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOth("");
			}
			
			
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSI004TAB5Action");
			
			semmsi004tab5Bean.setRenderedMsgAlert(true);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		} finally {
			
		}
	}
	
	public boolean doValidateEl(){
		log.debug(" #### Start SEMMSI004tab5Action doValidateEl ####");
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			if(semmsi004tab5Bean.isChkElectricType3()){
				
				if(StringUtils.equals("03", semmsi004tab5Bean.getSiteInfoObjELParam().getElectricType())){
					if(StringUtils.equals(null, semmsi004tab5Bean.getSiteInfoObjELParam().getElCondSubType())){
					
						
					
					/*if(StringUtils.isEmpty(semmsi004tab5Bean.getSiteInfoObjELParam().getElCondType())){
						addMessageError("W0001", msg("label.ELcond"));
						flag = false;
					}else{
						if(StringUtils.isEmpty(semmsi004tab5Bean.getSiteInfoObjELParam().getElCondSubType())){
							addMessageError("W0001", msg("label.ELcondOth"));
							flag = false;
						}
					}*/
					
					addMessageError("W0001", msg("label.ELcond"));
					flag = false;
				}
				
			}
			}
			/*
			if(semmsi004tab5Bean.isChkElectricType4()){
				if(StringUtils.isEmpty(semmsi004tab5Bean.getSiteInfoObjELParam().getElUseOthSiteContractNo())){
					addMessageError("W0001", msg("label.conNo_siteuseel"));
					flag = false;
				}
			}*/
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			 flag = false;
			 log.error(" #### Error SEMMSI004tab5Action doValidateEl : "+e);
		}
		log.debug(" #### End SEMMSI004tab5Action doValidateEl ####");
		return flag;
	}
	
	public boolean doAddSiteAppELCond(){
		log.debug(" #### Start SEMMSI004tab5Action doAddSiteAppELCond ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		ISiteElectricService serviceEL = (ISiteElectricService)getBean("siteElectricService");
		semmsi004tab5Bean = getSemmsi004tab5Bean(); 
		List<SiteInfoMapSiteAcqSP> to = null;
		String siteAppId = "";
		String depositType = "";
		SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
		String mode = "";
		semmsi004tab5Bean.setpRemark("");
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
			String siteInfoId = getFacesUtils().getRequestParameter("siteInfoId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteInfoId");


			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			siteAppId = semmsi004tab5Bean.getSiteInfoObjELParam().getSiteAppId();
			semmsi004tab5Bean.getSiteInfoObjELParam().setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			
			semmsi004tab5Bean.getSiteInfoObjELParam().setSiteAppId(siteAppId);
			semmsi004tab5Bean.getSiteInfoObjELParam().setUserId(getUserLogIn());
			semmsi004tab5Bean.getSiteInfoObjELParam().setElectricType(elType);
			
			semmsi004tab5Bean.getSiteInfoObjELParam().setElRemark(semmsi004tab5Bean.getSiteInfoObjParam().getElRemark());
			
			if(semmsi004tab5Bean.getSiteInfoObjELParam().getElectricType().equals("01")){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElectricType(null);
				semmsi004tab5Bean.getSiteInfoObjELParam().setElType1("Y");
				//semmsi004tab5Bean.setShowEditBtn(false);
			}
			
			if(this.doValidateEl()){	
				Object obj = this.doMapELParamObj((Object)semmsi004tab5Bean.getSiteInfoObjELParam());
				SiteInfoMapSiteAcqSP siteAppSP = new SiteInfoMapSiteAcqSP();
				siteAppSP = (SiteInfoMapSiteAcqSP)obj;
			
				log.debug("siteAppSP"+siteAppSP.getElType());
				log.debug("siteAppSP"+siteAppSP.getElectricType());
				
				log.debug("getTakeAllAmt "+siteAppSP.getTakeAllAmt());
				log.debug("getUnitPriceAmt "+siteAppSP.getUnitPriceAmt());
				log.debug("getElectricAmt "+siteAppSP.getElectricAmt());
				
				
				//siteAppSP.setElType(elType);
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_INS.name, siteAppSP);
				
				if (to != null && !to.isEmpty() && to.size() > 0) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
						semmsi004tab5Bean.setSiteElectric(serviceEL.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteElectric().getSiteInfoId()));
						semmsi004tab5Bean.setSiteElectric(serviceEL.updateSiteElectric(semmsi004tab5Bean.getSiteElectric()));
				
						this.doSiteInfoELCondSrch("A");
					
						flag = true;
						semmsi004tab5Bean.setRenderedMsgAlert(true);
						
						 if (siteAppSP.getElType().equals("01")) {
							 	semmsi004tab5Bean.setChkElectricType1(true);
								
							
						 }else if (siteAppSP.getElType().equals("03")) {
							semmsi004tab5Bean.setChkElUseOwner(true);

						} else if (siteAppSP.getElType().equals("04")) {
							semmsi004tab5Bean.setChkElUseOthSite(true);
							semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOthSiteContractNo(null);
							semmsi004tab5Bean.getSiteInfoObjELParam().setDetail04(null);

						} else if (siteAppSP.getElType().equals("05")) {
							semmsi004tab5Bean.setChkElUseOth(true);
							semmsi004tab5Bean.getSiteInfoObjParam().setElRemark(null);

						}else{
							System.out.println("getElType "+siteAppSP.getElType());
						}
						
						
						
						//TODO clear save param obj
						this.doClearSiteAppEl();
						
						
						
						//semmsi004tab5Bean.setpRemark(null);
						
					} else {
						if(to.get(0).getRetResult() != null){
							if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
								semmsi004tab5Bean.setpRemark(retMsg);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
								//semmsi004tab5Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
						semmsi004tab5Bean.setRenderedMsgAlert(true);
		        		
		        		
		        		//check checkBox
		        		
						if (siteAppSP.getElType().equals("03")) {
							semmsi004tab5Bean.setChkElUseOwner(true);

						} else if (siteAppSP.getElType().equals("04")) {
							semmsi004tab5Bean.setChkElUseOthSite(true);

						} else if (siteAppSP.getElType().equals("05")) {
							
							//semmsi004tab5Bean.getSiteInfoObjParam().setElRemark(null);
							semmsi004tab5Bean.getSiteElectric().setRemark(null);

						}
		        		
					}
					
					semmsi004tab5Bean.getSiteInfoObjELParam().setElRemark("");
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSA004Action doAddSiteAppELCond : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSA004Action doAddSiteAppELCond ####");
		}
		
		return flag;
	}
	
	/*public boolean doAddSiteAppELCond(){
		log.debug(" #### Start SEMMSI004TAB5Action doAddSiteAppELCond ####");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		List<SiteInfoMapSiteAcqSP> to = null;
		String siteInfoId = "";
		String depositType = "";
		SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
		String mode = "";
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			siteInfoId = semmsi004tab5Bean.getSiteInfoId();
//			depositType = semmsi004tab5Bean.getSiteAppDeptObj().getDepositType();
			
//			if(StringUtils.equals("01", depositType)){
//			this.doSetELCheckBoxEntity();	
			semmsi004tab5Bean.getSiteInfoObjELParam().setSiteInfoId(siteInfoId);
			semmsi004tab5Bean.getSiteInfoObjELParam().setUserId(getUserLogIn());
				
//			
//			}
//			semmsi004tab5Bean.getSiteAppDeptObj().setSiteInfoId(siteInfoId);
//			semmsi004tab5Bean.getSiteAppDeptObj().setUserId(getUserLogIn());
			log.debug("semmsi004tab5Bean.getEiteInfoObjELParam().getElCondType() : "+semmsi004tab5Bean.getSiteInfoObjELParam().getElCondType());
			
			if(this.doValidateEl()){
				Object obj = this.doMapELParamObj((Object)semmsi004tab5Bean.getSiteInfoObjELParam());
				SiteInfoMapSiteAcqSP siteAppSP = new SiteInfoMapSiteAcqSP();
				siteAppSP = (SiteInfoMapSiteAcqSP)obj;
				
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_INS.name, siteAppSP);
				
				if (to != null && !to.isEmpty() && to.size() > 0) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (StringUtils.equals("SUCCESS", to.get(0).getRetResult().toUpperCase())) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
						
						// -- Start Save EL Type
//						this.doUpdateAllonChangeTab();
						// -- End Save EL Type
						
						
//						this.doSiteAppELCondSrch();
						
						if(StringUtils.equals("03", elType)){
//							if(StringUtils.equals("01", elTypeSub)){
//								mode = "U";
//							}else if(StringUtils.equals("02", elTypeSub)){
//								mode = "T";
//							}else{
//								mode = "N";
//							}
							//this.doSiteAppELCondSrch("U");
							//this.doSiteAppELCondSrch("T");
							//this.doSiteAppELCondSrch("N");
						}else if(StringUtils.equals("04", elType)){
							mode = "O";
							this.doSiteAppELCondSrch(mode);
						}
//						this.doSiteAppELCondSrch(mode);
					
						flag = true;
						semmsi004tab5Bean.setRenderedMsgAlert(true);
						//TODO clear save param obj
						this.doClearSiteAppEl();
					} else {
						if(to.get(0).getRetResult() != null){
							if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
//								semmsi004tab5Bean.setDisabledButtonPopupResult(false);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
//								semmsi004tab5Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
		        		semmsi004tab5Bean.setRenderedMsgAlert(true);
					}
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004TAB5Action doAddSiteAppELCond : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004TAB5Action doAddSiteAppELCond ####");
		}
		
		return flag;
	}*/
	
	public Object doMapELParamObj(Object obj){
		Object object = new Object();
		object = obj;
		Object newObj = new Object();
		try{
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			
		
			SiteInfoMapSiteAcqSP siteApp = new SiteInfoMapSiteAcqSP();
			SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
			if(object != null){
				siteApp = (SiteInfoMapSiteAcqSP)object;
				log.debug("siteApp.getSiteInfoId() : "+siteApp.getSiteInfoId());
				log.debug("siteApp.getSiteInfoELContId() : "+siteApp.getSiteInfoELContId());
				if(siteApp.getSiteInfoId() != null)siteAppObj.setSiteInfoId(siteApp.getSiteInfoId());
				if(siteApp.getSiteInfoELContId() != null)siteAppObj.setSiteInfoELContId(siteApp.getSiteInfoELContId());
				if(siteApp.getElEffectiveDt() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt());
				if(elType != null)siteAppObj.setElOwnerType(elType);
				if(semmsi004tab5Bean.getSiteInfoObjELParam().getService() != null)siteAppObj.setServiceId(semmsi004tab5Bean.getSiteInfoObjELParam().getService());
				siteAppObj.setUserId(getUserLogIn());
				siteAppObj.setElType(elType);
				siteAppObj.setServiceId(semmsi004tab5Bean.getSiteInfoObjELParam().getServiceId());
				
					
				if(StringUtils.equals("03", elType)){//ELUserOwner
//					semmsi004tab5Bean.chkElUseOwner
					if(siteApp.getElCondSubType() != null)siteAppObj.setElCondSubType(siteApp.getElCondSubType());
					if(semmsi004tab5Bean.isChkElectricType3()){
						siteAppObj.setElUseOwner("Y");
						siteAppObj.setElType3("Y");
					} else {
						siteAppObj.setElUseOwner("");
						siteAppObj.setElType3("");
					}
					if(siteApp.getElCondType() != null)siteAppObj.setElCondType(siteApp.getElCondType());
					if(siteApp.getElCondSubType() != null)siteAppObj.setElCondSubType(siteApp.getElCondSubType());
					if(siteApp.getElEffectiveDt03() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt03());
					//unit
					if(StringUtils.equals("01", elTypeSub)){
						if(siteApp.getElUnitPrice() != null)siteAppObj.setElUnitPrice(siteApp.getElUnitPrice());
						if(semmsi004tab5Bean.isChkNoUtilPrice()){
							siteAppObj.setNoUtilPrice("Y");
						}else{
							siteAppObj.setNoUtilPrice("");
						}
						
						
						if(siteApp.getElPayOnPackageAmt() != null)siteAppObj.setElPayOnPackageAmt(siteApp.getElPayOnPackageAmt());
						if(siteApp.getElPackagePeriodType() != null)siteAppObj.setElPackagePeriodType(siteApp.getElPackagePeriodType());
						if(siteApp.getDetail() != null)siteAppObj.setDetail(siteApp.getDetail());
						if(siteApp.getElVatType() != null)siteAppObj.setElVatType(siteApp.getElVatType());
						if(siteApp.getElPayPeriod() != null)siteAppObj.setElPayPeriod(siteApp.getElPayPeriod());
						
						if(siteApp.getWhtType() != null)siteAppObj.setWhtType(siteApp.getWhtType());
						
						if(siteApp.getWhtRate() != null)siteAppObj.setWhtRate(siteApp.getWhtRate());
						
						if(siteApp.getElectricAmt() != null)siteAppObj.setElectricAmt(siteApp.getElectricAmt());
						if(siteApp.getTakeAllPeriodType() != null)siteAppObj.setTakeAllPeriodType(siteApp.getTakeAllPeriodType());
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getPeriodStartDt());
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
						if(siteApp.getDetail03() != null)siteAppObj.setDetail(siteApp.getDetail03());
					
						log.debug("-----> semmsi004tab5Bean.getElPayPeriodType01()="+semmsi004tab5Bean.getElPayPeriodType01() );
								
								
						
						if(semmsi004tab5Bean.getElPayPeriodType01() != "" && semmsi004tab5Bean.getElPayPeriodType01() != null){
							siteAppObj.setPayPeriodType("01");
						}else if(semmsi004tab5Bean.getElPayPeriodType02() != "" && semmsi004tab5Bean.getElPayPeriodType02() != null){
							siteAppObj.setPayPeriodType("02");
						}else if(semmsi004tab5Bean.getElPayPeriodType03() != "" && semmsi004tab5Bean.getElPayPeriodType03() != null){
							siteAppObj.setPayPeriodType("03");
						}else if(semmsi004tab5Bean.getElPayPeriodType04() != "" && semmsi004tab5Bean.getElPayPeriodType04() != null){
							siteAppObj.setPayPeriodType("04");
						}else if(semmsi004tab5Bean.getElPayPeriodType05() != "" && semmsi004tab5Bean.getElPayPeriodType05() != null){
							siteAppObj.setPayPeriodType("05");
						}else if(semmsi004tab5Bean.getElPayPeriodType06() != "" && semmsi004tab5Bean.getElPayPeriodType06() != null){
							siteAppObj.setPayPeriodType("06");
						}else if(semmsi004tab5Bean.getElPayPeriodType07() != "" && semmsi004tab5Bean.getElPayPeriodType07() != null){
							siteAppObj.setPayPeriodType("07");
						}
						
						
					}else if(StringUtils.equals("02", elTypeSub)){//takeAll
						if(siteApp.getElPayOnPackageAmt() != null)siteAppObj.setElPayOnPackageAmt(siteApp.getElPayOnPackageAmt());
						if(siteApp.getElPackagePeriodType() != null)siteAppObj.setElPackagePeriodType(siteApp.getElPackagePeriodType());
						if(siteApp.getDetail() != null)siteAppObj.setDetail(siteApp.getDetail());
						if(siteApp.getElVatType() != null)siteAppObj.setElVatType(siteApp.getElVatType());
						if(siteApp.getElPayPeriod() != null)siteAppObj.setElPayPeriod(siteApp.getElPayPeriod());
						if(semmsi004tab5Bean.getSiteInfoObjELParam().getWthType() != null){
							log.debug("semmsi004tab5Bean : getWthType : "+semmsi004tab5Bean.getSiteInfoObjELParam().getWthType());
							String wthType = semmsi004tab5Bean.getSiteInfoObjELParam().getWthType();
							siteAppObj.setWhtType(semmsi004tab5Bean.getSiteInfoObjELParam().getWthType());
							log.debug("siteAppObj : getWhtType : "+siteAppObj.getWhtType());
						}
						//siteAppObj.setWthRate(new BigDecimal(semmsi004tab5Bean.getSiteInfoObjELParam().getWhtRate()));
						siteAppObj.setWhtRate(semmsi004tab5Bean.getSiteInfoObjELParam().getWhtRate());
						log.debug("siteAppObj : WhtRate : "+siteAppObj.getWhtRate());
						
						//if(siteApp.getElectricAmt() != null)siteAppObj.setElectricAmt(siteApp.getElectricAmt());
						//if(siteApp.getElectricAmt() != null)siteAppObj.setUnitPriceAmt(siteApp.getElectricAmt().toString());
						if(siteApp.getElectricAmt() != null)siteAppObj.setTakeAllAmt(siteApp.getElectricAmt());
						
						if(siteApp.getTakeAllPeriodType() != null)siteAppObj.setTakeAllPeriodType(siteApp.getTakeAllPeriodType());
						if(siteApp.getPeriodStartDt() != null)siteAppObj.setPeriodStartDt(siteApp.getPeriodStartDt());
						if(siteApp.getPeriodEndDt() != null)siteAppObj.setPeriodEndDt(siteApp.getPeriodEndDt());
						if(siteApp.getDetail03() != null)siteAppObj.setDetail(siteApp.getDetail03());
						
						
						if(semmsi004tab5Bean.getElPayPeriodType01() != "" && semmsi004tab5Bean.getElPayPeriodType01() != null){
							siteAppObj.setPayPeriodType("01");
						}else if(semmsi004tab5Bean.getElPayPeriodType02() != "" && semmsi004tab5Bean.getElPayPeriodType02() != null){
							siteAppObj.setPayPeriodType("02");
						}else if(semmsi004tab5Bean.getElPayPeriodType03() != "" && semmsi004tab5Bean.getElPayPeriodType03() != null){
							siteAppObj.setPayPeriodType("03");
						}else if(semmsi004tab5Bean.getElPayPeriodType04() != "" && semmsi004tab5Bean.getElPayPeriodType04() != null){
							siteAppObj.setPayPeriodType("04");
						}else if(semmsi004tab5Bean.getElPayPeriodType05() != "" && semmsi004tab5Bean.getElPayPeriodType05() != null){
							siteAppObj.setPayPeriodType("05");
						}else if(semmsi004tab5Bean.getElPayPeriodType06() != "" && semmsi004tab5Bean.getElPayPeriodType06() != null){
							siteAppObj.setPayPeriodType("06");
						}else if(semmsi004tab5Bean.getElPayPeriodType07() != "" && semmsi004tab5Bean.getElPayPeriodType07() != null){
							siteAppObj.setPayPeriodType("07");
						}
						
					}
				}else if(StringUtils.equals("04", elType)){
					//EL Other Site
						
					if(semmsi004tab5Bean.isChkElUseOthSite()){
						siteAppObj.setElUseOthSite("Y");
						siteAppObj.setElType4("Y");
					} else {
						siteAppObj.setElUseOthSite("N");
						siteAppObj.setElType4("");
					}
					if(siteApp.getElUseOthSiteContractNo() != null)siteAppObj.setElUseOthSiteContractNo(siteApp.getElUseOthSiteContractNo());				
					if(siteApp.getElEffectiveDt() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt());
					if(siteApp.getDetail04() != null)siteAppObj.setDetail(siteApp.getDetail04());	
					if(siteApp.getElEffectiveDt04() != null)siteAppObj.setElEffectiveDt(siteApp.getElEffectiveDt04());
				}
				else if(StringUtils.equals("05", elType)){
					siteAppObj.setDetail(semmsi004tab5Bean.getSiteElectric().getRemark());
					
					if(semmsi004tab5Bean.isChkElectricType5()){
						siteAppObj.setElType5("Y");
					}else{
						siteAppObj.setElType5("");
					}
					
					siteAppObj.setElOwnerType("05");
					siteAppObj.setElType("05");
				}
				else if(StringUtils.equals("01", elType)){
					siteAppObj.setElType(null);
					siteAppObj.setElectricType(null);
					
					if(semmsi004tab5Bean.isChkElectricType2()){
						siteAppObj.setElType2("Y");
						siteAppObj.setElType1("");
						siteAppObj.setElOwnerType("02");
						siteAppObj.setElType("02");
					}else{
						siteAppObj.setElType1("Y");
						siteAppObj.setElType2("");
						siteAppObj.setElOwnerType("01");
						siteAppObj.setElType("01");
					}
					
				}else if(StringUtils.equals("02", elType)){
					siteAppObj.setElType("");
					
				}
			
				
				//Debug 
				log.debug("doMapELParamObj : getSiteInfoId : "+siteAppObj.getSiteInfoId());
				log.debug("doMapELParamObj : getSiteInfoELContId : "+siteAppObj.getSiteInfoELContId());
				log.debug("doMapELParamObj : getFromSiteInfoId : "+siteAppObj.getFromSiteInfoId()); 
				log.debug("doMapELParamObj : getRemark : "+siteAppObj.getRemark()); 
				log.debug("doMapELParamObj : getElOwnerType : "+siteAppObj.getElOwnerType()); 
				log.debug("doMapELParamObj : getElType : "+siteAppObj.getElType()); 
				log.debug("doMapELParamObj : getTakeAllAmt : "+siteAppObj.getTakeAllAmt()); 
				log.debug("doMapELParamObj : getTakeAllPeriodType : "+siteAppObj.getTakeAllPeriodType()); 
				log.debug("doMapELParamObj : getElUnitPrice : "+siteAppObj.getElUnitPrice());
				log.debug("doMapELParamObj : getPayPeriodType : "+siteAppObj.getPayPeriodType()); 
				log.debug("doMapELParamObj : getElPayPeriod : "+siteAppObj.getElPayPeriod()); 
				log.debug("doMapELParamObj : getDepositCondType : "+siteAppObj.getDepositCondType()); 
				log.debug("doMapELParamObj : getElUseMultiResourse : "+siteAppObj.getElUseMultiResourse()); 
				log.debug("doMapELParamObj : getElType1 : "+siteAppObj.getElType1()); 
				log.debug("doMapELParamObj : getElType2 : "+siteAppObj.getElType2()); 
				log.debug("doMapELParamObj : getElType3 : "+siteAppObj.getElType3()); 
				log.debug("doMapELParamObj : getElType4 : "+siteAppObj.getElType4()); 
				log.debug("doMapELParamObj : getNoUtilPrice : "+siteAppObj.getNoUtilPrice()); 
				log.debug("doMapELParamObj : getElUseOthSiteContractNo : "+siteAppObj.getElUseOthSiteContractNo()); 
				log.debug("doMapELParamObj : getVersion : "+siteAppObj.getVersion()); 
				log.debug("doMapELParamObj : getTotalDepositBgAmt : "+siteAppObj.getTotalDepositBgAmt()); 
				log.debug("doMapELParamObj : getTotalDepositCashAmt : "+siteAppObj.getTotalDepositCashAmt()); 
				log.debug("doMapELParamObj : getNoDeposit : "+siteAppObj.getNoDeposit()); 
				log.debug("doMapELParamObj : getElEffectiveDt : "+siteAppObj.getElEffectiveDt()); 
				log.debug("doMapELParamObj : getDetail : "+siteAppObj.getDetail()); 
				log.debug("doMapELParamObj : getElOldAmt  : "+siteAppObj.getElOldAmt()); 
				log.debug("doMapELParamObj : getElAddPercent : "+siteAppObj.getElAddPercent()); 
				log.debug("doMapELParamObj : getElAddAmt : "+siteAppObj.getElAddAmt()); 
				log.debug("doMapELParamObj : getElAmt : "+siteAppObj.getElAmt()); 
				log.debug("doMapELParamObj : getElPeriodType : "+siteAppObj.getElPeriodType());
				log.debug("doMapELParamObj : getWhtType : "+siteAppObj.getWhtType()); 
				log.debug("doMapELParamObj : getWhtRate : "+siteAppObj.getWhtRate()); 
				log.debug("doMapELParamObj : getVatType : "+siteAppObj.getVatType()); 
				log.debug("doMapELParamObj : getPeriodStartDt : "+siteAppObj.getPeriodStartDt()); 
				log.debug("doMapELParamObj : getPeriodEndDt : "+siteAppObj.getPeriodEndDt()); 
				log.debug("doMapELParamObj : getElAdj : "+siteAppObj.getElAdj()); 
				log.debug("doMapELParamObj : getElAdjPeriodType : "+siteAppObj.getElAdjPeriodType()); 
				log.debug("doMapELParamObj : getServiceId : "+siteAppObj.getServiceId());
				log.debug("doMapELParamObj : getElOldPeriodType : "+siteAppObj.getElOldPeriodType()); 
				log.debug("doMapELParamObj : getElAddPeriodType : "+siteAppObj.getElAddPeriodType()); 
				log.debug("doMapELParamObj : getRefSiteElCond : "+siteAppObj.getRefSiteElCond()); 
				log.debug("doMapELParamObj : getElCondType : "+siteAppObj.getElCondType());
				log.debug("doMapELParamObj : getElCondSubType : "+siteAppObj.getElCondSubType());
				log.debug("doMapELParamObj : getUserId : "+siteAppObj.getUserId()); 
				newObj = (Object)siteAppObj;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("ERROR doMapELParamObj : "+e);
		}
		return newObj;
	}
	
	public boolean doUpdateSiteAppELCond(){
		log.debug(" #### Start SEMMSI004TAB5Action doUpdateSiteAppELCond ####");
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String siteInfoId = "";
		String depositType = "";
		SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
		try{
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			ISiteElectricService serviceEL = (ISiteElectricService)getBean("siteElectricService");
			List<SiteInfoMapSiteAcqSP> to = null;
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String elTypeSub = getFacesUtils().getRequestParameter("elTypeSub") == null ? "" : (String)getFacesUtils().getRequestParameter("elTypeSub");
			String mode = "";
			
			siteInfoId = semmsi004tab5Bean.getSiteInfoId();
//			depositType = semmsi004tab5Bean.getSiteAppDeptObj().getDepositType();
			
//			this.doSetELCheckBoxEntity();	
			semmsi004tab5Bean.getSiteInfoObjELParam().setSiteInfoId(siteInfoId);
			semmsi004tab5Bean.getSiteInfoObjELParam().setUserId(getUserLogIn());
			
			if(this.doValidateEl()){
				Object obj = doMapELParamObj((Object)semmsi004tab5Bean.getSiteInfoObjELParam());
				SiteInfoMapSiteAcqSP siteAppSP = new SiteInfoMapSiteAcqSP();
				siteAppObj = (SiteInfoMapSiteAcqSP)obj;
//					//Debug 
				
				to = service.siteAppDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_UPD.name, siteAppObj);
				
				if (to != null && !to.isEmpty()) {
					String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
					
					if (to.get(0).getRetResult().equals("Success")) {

						
						String myMsgArr[];
						if(!retMsg.equals("")){
							myMsgArr = retMsg.split("<BR/>");
							
							for(int i=0; i < myMsgArr.length; i++){
								//addGeneralMessageInfo(myMsgArr[i]);
								//addGeneralMessageWarn(myMsgArr[i]);
								FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
							}
						}
						// -- Start Save EL Type
//						this.doUpdateAllonChangeTab();
						// -- End Save EL Type
						
						
//						this.doSiteAppELCondSrch();
						semmsi004tab5Bean.setSiteElectric(serviceEL.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteElectric().getSiteInfoId()));
						semmsi004tab5Bean.setSiteElectric(serviceEL.updateSiteElectric(semmsi004tab5Bean.getSiteElectric()));
						
						this.doSiteInfoELCondSrch("A");
						
						if(StringUtils.equals("03", elType)){
//							if(StringUtils.equals("01", elTypeSub)){
//								mode = "U";
//							}else if(StringUtils.equals("02", elTypeSub)){
//								mode = "T";
//							}else{
//								mode = "N";
//							}
							//this.doSiteAppELCondSrch("U");
							//this.doSiteAppELCondSrch("T");
							//this.doSiteAppELCondSrch("N");
						}else if(StringUtils.equals("04", elType)){
							mode = "O";
							this.doSiteAppELCondSrch(mode);
						}
//						this.doSiteAppELCondSrch(mode);
					
						flag = true;
						semmsi004tab5Bean.setRenderedMsgAlert(true);
						//TODO clear save param obj
						this.doClearSiteAppEl();
					} else {
						if(to.get(0).getRetResult() != null){
							if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
//								semmsi004tab5Bean.setDisabledButtonPopupResult(false);
							}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
//								semmsi004tab5Bean.setDisabledButtonPopupResult(true);
							}
							
						}
//						System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
						if(to.get(0).getRetResultMsg() != null)
							addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
						else
							addMessageError("E0001");	// data save fail
		        		semmsi004tab5Bean.setRenderedMsgAlert(true);
					}
				}
			}
			doSiteInfoELCondSrch("A");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004TAB5Action doUpdateSiteAppELCond : "+e);
		}
		log.debug(" #### End SEMMSI004TAB5Action doUpdateSiteAppELCond ####");
		return flag;
	}
	
	public boolean doInitDetSiteAppELCond(){
		log.debug(" #### Start SEMMSI004TAB5Action doInitDetSiteAppELCond #### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		boolean flag = true;
		
		try{
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004TAB5Action doInitDetSiteAppELCond : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### End SEMMSI004TAB5Action doInitDetSiteAppELCond #### ");
		}
		return flag;
	}
	
	public boolean doDetSiteAppELCond(){
		log.debug(" #### Start SEMMSI004TAB5Action doDetSiteAppELCond #### ");
		boolean flag = false;
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		ISiteElectricService serviceEL = (ISiteElectricService)getBean("siteElectricService");
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP siteAppObj = new SiteInfoMapSiteAcqSP();
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			//TODO get param
			String siteInfoELContId = getFacesUtils().getRequestParameter("siteInfoELContId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteInfoELContId");
			String siteInfoId = getFacesUtils().getRequestParameter("siteInfoId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteInfoId");
			String expenseType = getFacesUtils().getRequestParameter("expenseType") == null ? "" : (String)getFacesUtils().getRequestParameter("expenseType");
			String serviceId = getFacesUtils().getRequestParameter("serviceId") == null ? "" : (String)getFacesUtils().getRequestParameter("serviceId");
			String elType = getFacesUtils().getRequestParameter("elType") == null ? "" : (String)getFacesUtils().getRequestParameter("elType");
			String userId = getUserLogIn();
		
			siteAppObj.setSiteInfoELContId(siteInfoELContId);
			siteAppObj.setSiteInfoId(siteInfoId);
			siteAppObj.setExpenseType(expenseType);
			siteAppObj.setServiceId(serviceId);
			siteAppObj.setUserId(userId);
			
			log.debug("siteInfoELContId : "+siteInfoELContId);
			log.debug("siteInfoId : "+siteInfoId);
			log.debug("expenseType : "+expenseType);
			log.debug("serviceId : "+serviceId);
			log.debug("elType : "+elType);
			log.debug("userId : "+userId);
			
			to = service.siteAppDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_DEL.name, siteAppObj);
			
			if (to != null && !to.isEmpty()) {
				String retMsg = to.get(0).getRetResultMsg() == null ? "" : to.get(0).getRetResultMsg().toString();
				
				if (to.get(0).getRetResult().equals("Success")) {

					
					String myMsgArr[];
					if(!retMsg.equals("")){
						myMsgArr = retMsg.split("<BR/>");
						
						for(int i=0; i < myMsgArr.length; i++){
							//addGeneralMessageInfo(myMsgArr[i]);
							//addGeneralMessageWarn(myMsgArr[i]);
							FrontMessageUtils.addMessageWarn(myMsgArr[i]);	// optional
						}
					}
					
					//this.doSiteAppELCondSrch(semmsi004tab5Bean.getSiteInfoId());
					semmsi004tab5Bean.setSiteElectric(serviceEL.queryElectricBySiteInfoId(semmsi004tab5Bean.getSiteElectric().getSiteInfoId()));
					semmsi004tab5Bean.setSiteElectric(serviceEL.updateSiteElectric(semmsi004tab5Bean.getSiteElectric()));
					
					this.doSiteInfoELCondSrch("A");
					
					this.doClearSiteAppEl();
					
					flag = true;
					semmsi004tab5Bean.setRenderedMsgAlert(true);
				} else {
					if(to.get(0).getRetResult() != null){
						if("FAIL".equals(to.get(0).getRetResult().toUpperCase())){
//							semmsi004tab5Bean.setDisabledButtonPopupResult(false);
						}else if("FAIL2".equals(to.get(0).getRetResult().toUpperCase())){
//							semmsi004tab5Bean.setDisabledButtonPopupResult(true);
						}
						
					}
//					System.out.println("to.get(0).getRetResultMsg() = "+to.get(0).getRetResultMsg());
					if(to.get(0).getRetResultMsg() != null)
						addGeneralMessageError(to.get(0).getRetResultMsg());	// data save fail
					else
						addMessageError("E0001");	// data save fail
	        		semmsi004tab5Bean.setRenderedMsgAlert(true);
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004TAB5Action doDetSiteAppELCond : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
		log.debug(" #### End SEMMSI004TAB5Action doDetSiteAppELCond #### ");
		return flag;
	}
	
	public boolean doClearSiteAppEl(){
		log.debug(" #### Start SEMMSI004TAB5Action doClearSiteAppEl ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		try{
			semmsi004tab5Bean.setSiteInfoObjELParam(new SiteInfoMapSiteAcqSP());
//			semmsi004tab5Bean.setSiteAppDeptCashObj(new SiteInfoMapSiteAcqSP());
//			semmsi004tab5Bean.setSiteAppDeptBgObj(new SiteInfoMapSiteAcqSP());
			if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
				semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodStartDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
			
			//set default El setPeriodEndDt
			if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
				semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			
			
//			this.initUpdDeptReturnType();
//			this.doRenderDeptBgCash();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004TAB5Action doClearSiteAppEl : "+e);
		}
		log.debug(" #### End SEMMSI004TAB5Action doClearSiteAppEl ####");
		return true;
	}

	public void tab5AddContractElUse_doAddContractElUse() {
		try {
			
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			
			String paramContractNo = getFacesUtils().getRequestParameter("paramContractNo") == null ? "" : (String) getFacesUtils().getRequestParameter("paramContractNo");
			
			
			semmsi004tab5Bean.getSiteInfoObjELParam().setElUseOthSiteContractNo(paramContractNo);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSA002Action");
			
			semmsi004tab5Bean.setRenderedMsgAlert(true);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		} finally {
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
	}
	
	public void tab5AddContractElUse_doSearchContractElUse() {
		try {
			
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			
			semmsi004tab5Bean.setRenderedMsgAlert(false);
			
			String strCompany = semmsi004tab5Bean.getContractElUseObjParam().getCompany() == null ? "" : (String) semmsi004tab5Bean.getContractElUseObjParam().getCompany();
			log.info("strCompany: " + strCompany);
			
			if(strCompany.equals("")){
				semmsi004tab5Bean.setContractElUseList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
				semmsi004tab5Bean.setMsgReqcompanyPopup("T");
				//FrontMessageUtils.addMessageWarn("กรุณาระบุ บริษัท");	// optional
				//semmsi004tab5Bean.setRenderedMsgAlert(true);
			} else {
				List<SiteInfoMapSiteAcqSP> cntrctElUseList = new ArrayList<SiteInfoMapSiteAcqSP>();
		        ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		        semmsi004tab5Bean.setMsgReqcompanyPopup(null);
		        try{
		        	
		        }catch (Exception e) {
					// TODO: handle exception
				}
		        semmsi004tab5Bean.setContractElUseList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
				
				cntrctElUseList = service.siteAppDao_querySPList(EQueryName.SP_MSI004_POPUP_CONTRACT_EL_USE.name, semmsi004tab5Bean.getContractElUseObjParam());
	        	if(cntrctElUseList != null && !cntrctElUseList.isEmpty()){
					for(int i = 0; i < cntrctElUseList.size(); i++){
						SiteInfoMapSiteAcqSP ret = (SiteInfoMapSiteAcqSP) cntrctElUseList.get(i);
						
						WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
						
						if(ret.getEffectiveDt() != null){
							ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
						}else{
							break;
						}
						
						if(ret.getExpireDt() != null){
							ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
						}else{
							break;
						}
						
						// check status terminate of contract.
						if(ret.getContractStatusName().startsWith("Terminate")){
							ret.setTerminateOfcontractFlag("T");
							//popupSiteContractBean.getContractList().get(i).setTerminateOfcontractFlag("T");
							log.debug(ret.getContractNo()+" "+ret.getContractStatusName());
							
						}else{
							//popupSiteContractBean.getContractList().get(i).setTerminateOfcontractFlag("F");
							ret.setTerminateOfcontractFlag("F");
						}
						
						
						tmpWrapperBean.setDataObj(ret);
						tmpWrapperBean.setMessage("");
	
						semmsi004tab5Bean.getContractElUseList().add(tmpWrapperBean);
					}
	        	}
	        	//semmsi004tab5Bean.setRenderedMsgAlert(false);
			}
			
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			log.error(e);
			addMessageError("EL0000", "SEMMSI004tab5Action");
			
			semmsi004tab5Bean.setRenderedMsgAlert(true);
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		} finally {
		}
	}
	

	
	public void doSetDefaultEl(){
		log.debug(" #### start SEMMSi004TAB5Action doSetDefaultEl ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab2Bean = getSemmsi004tab2Action().getSemmsi004tab2Bean();
		try{
			if(StringUtils.equals("01", semmsi004tab5Bean.getSiteInfoObjELParam().getElCondSubType())){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("04");
				semmsi004tab5Bean.setElPayPeriodType01("01");
				
				if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
					semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodStartDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
				
				//set default El setPeriodEndDt
//				if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
//					semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
				//edit default end contractdate
				if(semmsi004tab2Bean.getSiteContract().getExpireDt()!= null)
				semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getExpireDt());
				
			}else if(StringUtils.equals("02", semmsi004tab5Bean.getSiteInfoObjELParam().getElCondSubType())){
				semmsi004tab5Bean.getSiteInfoObjELParam().setElUnitPrice(null);
				//set default El PeriodStartDt semmsi004tab2Bean.siteContract.effectiveDt
				if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
					semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodStartDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
				
				//set default El setPeriodEndDt
//				if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
//					semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
				//edit default end contractdate
				if(semmsi004tab2Bean.getSiteContract().getExpireDt()!= null)
				semmsi004tab5Bean.getSiteInfoObjELParam().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getExpireDt());
				
//				semmsi004tab5Bean.getSiteAppRentObjParam().setRentWhtType("03");
				
				semmsi004tab5Bean.setElPayPeriodType01("01");
				semmsi004tab5Bean.getSiteInfoObjELParam().setElVatType("04");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSi004TAB5Action doSetDefaultEl : "+e);
		}finally{
			log.debug(" #### End SEMMSi004TAB5Action doSetDefaultEl ####");
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
	}
	
	   public void doSiteAppELCondSrch(String siteInfo){
	    	log.debug(" #### Start SEMMSi004TAB5Action doSiteAppELCondSrch ####");
	    	semmsi004Bean = getSemmsi004Bean(); 
	    	semmsi004tab5Bean = getSemmsi004tab5Bean();
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteInfoMapSiteAcqSP> to = null;
			try{
				
				log.debug("doSiteInfoELCondSrch siteInfo : "+siteInfo);
				SiteInfoMapSiteAcqSP siteInfoObj = new SiteInfoMapSiteAcqSP();
				siteInfoObj.setSiteInfoId(siteInfo);
				
				to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SRCH_EL_COND.name, siteInfoObj);
				log.debug("size [" + to.size() + "]");
				
				
				if(to != null && to.size() > 0){
//					
					semmsi004tab5Bean.setSiteAppELCondExistingList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
					
					}
				
				for (int i = 0; i < to.size(); i++) {
					SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
					WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
				
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getElEffectiveDt() != null){
						siteAcq.setChgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getElEffectiveDt()));
					}
					
					if(siteAcq.getPeriodStartDt() != null){
						siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
					}
					
					if(siteAcq.getPeriodEndDt() != null){
						siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
					}
//						
					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
						
						semmsi004tab5Bean.getSiteAppELCondExistingList().add(tmpWrapperBean);
						
				}
					

				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.debug("Error SEMMSi004TAB5Action doSiteAppELCondSrch : "+e);
			}finally{
				log.debug(" #### End SEMMSi004TAB5Action doSiteAppELCondSrch ####");
				setSemmsi004Bean(semmsi004Bean);
			}
		}
	    
	public void doSiteInfoELCondSrch(String mode){
	    	log.debug(" #### Start SEMMSi004TAB5Action doSiteInfoELCondSrch ####");
	    	semmsi004Bean = getSemmsi004Bean(); 
	    	boolean flag = false;
	    	semmsi004tab5Bean = getSemmsi004tab5Bean();
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
			List<SiteInfoMapSiteAcqSP> to = null;
			try{
				
				log.debug("doSiteInfoELCondSrch siteInfo : "+semmsi004Bean.getSiteInfoId());
				SiteInfoMapSiteAcqSP siteInfoObj = new SiteInfoMapSiteAcqSP();
				siteInfoObj.setSiteInfoId(semmsi004Bean.getSiteInfoId());
				siteInfoObj.setMode(mode);
				
				to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_COND_SRCH.name, siteInfoObj);
				log.debug("size [" + to.size() + "]");
				
			
				if (to != null && !to.isEmpty()) {
//					
					semmsi004tab5Bean.setSiteInfoELCondAllList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
					
					}
				
				if(to.size() == 0){
					semmsi004tab5Bean.setSiteInfoELCondAllList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
					semmsi004tab5Bean.setChkElectricType1(false);
					semmsi004tab5Bean.setChkElectricType2(false);
					semmsi004tab5Bean.setChkElectricType3(false);
					semmsi004tab5Bean.setChkElectricType4(false);
					semmsi004tab5Bean.setChkElectricType6(false);
					semmsi004tab5Bean.setChkMultiElectricTypeFlag(false);
				}else{
				
						for (int i = 0; i < to.size(); i++) {
							SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(i);
							WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
							
							if(siteAcq.getEffectiveDt() != null){
								siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
							}
							
							if(siteAcq.getExpireDt() != null){
								siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
							}
							

							if(siteAcq.getElEffectiveDt() != null){
								siteAcq.setChgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getElEffectiveDt()));
							}
							
							if(siteAcq.getPeriodStartDt() != null){
								siteAcq.setPeriodStartDtStr(convertYearENtoTHStr(siteAcq.getPeriodStartDt()));
							}
							
							if(siteAcq.getPeriodEndDt() != null){
								siteAcq.setPeriodEndDtStr(convertYearENtoTHStr(siteAcq.getPeriodEndDt()));
							}
//							
							tmpWrapperBean.setMessage("");
							tmpWrapperBean.setCheckBox(false);
							tmpWrapperBean.setDataObj(siteAcq);
								
							semmsi004tab5Bean.getSiteInfoELCondAllList().add(tmpWrapperBean);
								
						}
				
				}	
		
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.debug("Error SEMMSi004TAB5Action doSiteInfoELCondSrch : "+e);
			}finally{
				log.debug(" #### End SEMMSi004TAB5Action doSiteInfoELCondSrch ####");
				setSemmsi004Bean(semmsi004Bean);
			}
		}
	
	public void doSetParamPopupConfirm(Object obj){
		log.debug(" ####### Start SEMMSi004TAB5Action doSetParamPopupConfirm  ####### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ItemResultSP itemObj = (ItemResultSP)obj;
			semmsi004tab5Bean.setRenderedMsgPopup(true);
			if(itemObj.getResultMessage() != null)
				semmsi004tab5Bean.getRetResultObj().setResultMessage(itemObj.getResultMessage());
			
			//set button type
			if(itemObj.getResultType() != null)semmsi004tab5Bean.getRetResultObj().setResultType(itemObj.getResultType());
			
			if(itemObj.getOkBtnLabel() != null)semmsi004tab5Bean.getRetResultObj().setOkBtnLabel(itemObj.getOkBtnLabel());
			if(itemObj.getNavProgram() != null)semmsi004tab5Bean.getRetResultObj().setNavProgram(itemObj.getNavProgram());
			if(itemObj.getMethodWithNavi() != null)semmsi004tab5Bean.getRetResultObj().setMethodWithNavi(itemObj.getMethodWithNavi());
			
			if(itemObj.getCancelBtnLabel() != null)semmsi004tab5Bean.getRetResultObj().setCancelBtnLabel(itemObj.getCancelBtnLabel());
			if(itemObj.getNavProgramCancel() != null)semmsi004tab5Bean.getRetResultObj().setNavProgramCancel(itemObj.getNavProgramCancel());
			if(itemObj.getMethodWithNaviCancel() != null)semmsi004tab5Bean.getRetResultObj().setMethodWithNaviCancel(itemObj.getMethodWithNaviCancel());
			
			//set param in button
			if(itemObj.getVal1() != null)semmsi004tab5Bean.getRetResultObj().setVal1(itemObj.getVal1());
			if(itemObj.getVal2() != null)semmsi004tab5Bean.getRetResultObj().setVal2(itemObj.getVal2());
			if(itemObj.getVal3() != null)semmsi004tab5Bean.getRetResultObj().setVal3(itemObj.getVal3());
			if(itemObj.getVal4() != null)semmsi004tab5Bean.getRetResultObj().setVal4(itemObj.getVal4());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSi004TAB5Action doSetParamPopupConfirm : "+e);
			
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ####### End SEMMSi004TAB5Action doSetParamPopupConfirm  ####### ");
		}
	}

	public boolean doElUndo(){
		
		log.debug(" #### Start SEMMSi004TAB5Action doElUndo ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		boolean flag = true;
		try{
			log.debug("doGetSiteInfoELCont getSiteAppId :"+semmsi004tab5Bean.getSiteInfoId());

			objParam.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());

			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_UNDO.name, objParam);

			log.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab5Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab5Bean.setSiteContInfo(null);
				//semmsa002Bean.setSiteAppRentCont(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			}

			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab5Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						
						//this.semmsi004SearchRentCond(semmsi004tab5Bean.getSiteInfoId(),"01");
						doSiteInfoELCondSrch("A");
						
					}else{
						
						semmsi004tab5Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					
					}
					
				}else{
					addMessageError("Error SEMMSi004TAB5Action doRentalUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSi004TAB5Action doRentalUndo : ","E0001");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSi004TAB5Action doRentalUndo : "+e);
		}finally{
			log.debug(" ##### End SEMMSi004TAB5Action doRentalUndo #####");
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
		return flag;
	}
	
	public void doSetParamConfirmNotChangeEl(){
		log.debug(" ####### Start SEMMSi004TAB5Action doSetParamConfirmNotChangeEl ####### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab5Bean.getElEditFlag())){
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
			itemObj.setMethodWithNavi("doCheckElChange");
			itemObj.setActionWithNavi("SEMMSI004Tab5");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckElChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab5");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab5Action doSetParamConfirmNotChangeRental : "+e);
			
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ####### End SEMMSI004Tab5Action doSetParamConfirmNotChange  ####### ");
		}
	}
	
	public void doSetParamConfirmNotChangeElDeposit(){

		log.debug(" ####### Start SEMMSi004TAB5Action doSetParamConfirmNotChangeEl ####### ");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab5Bean.getElDepositEditFlag())){
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
			itemObj.setMethodWithNavi("doCheckElDepositChange");
			itemObj.setActionWithNavi("SEMMSI004Tab5");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckElDepositChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab5");
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab5Action doSetParamConfirmNotChangeRental : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" ####### End SEMMSi004TAB5Action doSetParamConfirmNotChange  ####### ");
		}
	}
	
	public void doElDepositUndo(){
		log.debug(" #### Start SEMMSA002Action doElDepositUndo ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		try{
			log.debug("doElDepositUndo getSiteAppId :"+semmsi004tab5Bean.getSiteInfoObjParam().getSiteAppId());
			objParam.setSiteInfoId(semmsi004tab5Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());
			
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_EL_DEPOSIT_UNDO.name, objParam);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab5Bean.setRenderedMsgDataNotFound(true);
				//semmsi004tab5Bean.setel RentCondSPList(new ArrayList<Msi004SrchRentCondSP>());
			}
				
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab5Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						
						/*this.semmsi004SearchDepositRentBG(semmsi004tab5Bean.getSiteInfoId());
						this.semmsi004SearchDepositRentCash(semmsi004tab5Bean.getSiteInfoId());
						this.doClearDepositNormal();*/
						
						searchElectricDepositCash("01");
						searchElectricDepositBG("02");
						
					}else{
						
						semmsi004tab5Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					
					}
					
				}else{
					addMessageError("Error SEMMSI004Tab3Action doRentalDepositUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSI004Tab3Action doRentalDepositUndo : ","E0001");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab5Action doElDepositUndo : "+e);
		}finally{
			log.debug(" #### End SEMMSI004Tab5Action doElDepositUndo ####");
			setSemmsi004tab5Bean(semmsi004tab5Bean);
		}
	}
	 
	public boolean doCheckElChange(){
			log.debug(" ##### Start SEMMSI004Tab5Action doCheckElChange ##### ");
			boolean flag = true;
			semmsi004tab5Bean = getSemmsi004tab5Bean();
			String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
			String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
			try{
				if(StringUtils.equals("Y", confirmNotChRental)){
					if(StringUtils.equals("Y", changeType)){
						log.debug(" doCheckElChange changeType = "+ changeType);
						this.doElUndo();
					}
					
					//TODO clear save param obj
					//this.doClearRentCond();
				}else{
					if(semmsi004tab5Bean.isChkElEditFlag()){
						semmsi004tab5Bean.setElEditFlag("Y");
					}else{
						semmsi004tab5Bean.setElEditFlag("N");
					}
//					semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
				}
				
				//set render panel deposit
				if(StringUtils.equals("Y", semmsi004tab5Bean.getElEditFlag())){
					semmsi004tab5Bean.setChkElEditFlag(true);
				}else{
					semmsi004tab5Bean.setChkElEditFlag(false);
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.debug(" ##### Error SEMMSI004Tab5Action doCheckElChange : "+e);
			}finally{
				log.debug(" ##### End SEMMSI004Tab5Action doCheckElChange ##### ");
				setSemmsi004tab5Bean(semmsi004tab5Bean);
				flag = false;
			}
			return flag;
		}
	
	
	private boolean doClearElCond() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		boolean flag = false;
		/*semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.setRentCondNormal(new RentCond());
		semmsi004tab3Bean.getRentCondNormal().setRentCondType("01");
		semmsi004tab3Bean.getRentCondNormal().setWhtType("01");
		semmsi004tab3Bean.getRentCondNormal().setVatType("01");
		semmsi004tab3Bean.setDisabledWhtRateNormal(true);
		semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
		semmsi004tab3Bean.setChkWhtRateNormal(false);
		semmsi004tab3Bean.setDisabledBtnAddRentCond(false);
		semmsi004tab3Bean.setDisabledBtnUpdateRentCond(true);
		semmsi004tab3Bean.setDisabledPayPeriod03(true);
		semmsi004tab3Bean.setDisabledPayPeriod04(true);
		semmsi004tab3Bean.setPayPeriod03(null);
		semmsi004tab3Bean.setPayPeriod04(null);
		semmsi004tab3Bean.setPayPeriodType01("01");
		semmsi004tab3Bean.setPayPeriodType02(null);
		semmsi004tab3Bean.setPayPeriodType03(null);
		semmsi004tab3Bean.setPayPeriodType04(null);
		semmsi004tab3Bean.setPayPeriodType05(null);
		semmsi004tab3Bean.setChkOverFlag(false);
		semmsi004tab3Bean.setDisabledRentOldAmt(false);
		semmsi004tab3Bean.setRenderedRentOldAmt(false);
		
		//set default rent PeriodStartDt
		if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
			semmsi004tab3Bean.getRentCondNormal().setPeriodStartDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
		
		//set default rent setPeriodEndDt
		if(semmsi004tab2Bean.getSiteContract().getExpireDt() != null)
			semmsi004tab3Bean.getRentCondNormal().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getExpireDt());
		
		//set Default rent No VAT
		semmsi004tab3Bean.getRentCondNormal().setVatType("04");
		
		semmsi004tab3Bean.setChkRentAdj(false);
		semmsi004tab3Bean.setChkServId(false);
		semmsi004tab3Bean.setChkWhtRateNormal(false);
		
		setSemmsi004tab3Bean(semmsi004tab3Bean);*/
		return flag;
	}
	
	public boolean doCheckElDepositChange(){
		log.debug(" ##### Start SEMMSA002Action doCheckElDepositChange ##### ");
		boolean flag = true;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChElDeposit = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		System.out.println(" doCheckElDepositChange changeType = "+ changeType);
		
		try{
			if(StringUtils.equals("Y", confirmNotChElDeposit)){
				if(StringUtils.equals("Y", changeType)){
					
					this.doElDepositUndo();
					
				}
			}else{
				if(semmsi004tab5Bean.isChkEditELDeposit()){
					semmsi004tab5Bean.setElDepositEditFlag("Y");
				}else{
					semmsi004tab5Bean.setElDepositEditFlag("N");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ##### Error SEMMSA002Action doCheckElDepositChange : "+e);
		}finally{
			log.debug(" ##### End SEMMSA002Action doCheckElDepositChange ##### ");
			System.out.println("semmsa002Bean.disabledModeViewOnly "+semmsi004tab5Bean.isDisabledModeViewOnly());

			setSemmsi004tab5Bean(semmsi004tab5Bean);
			flag = false;
		}
		return flag;
	}
	
	private boolean doClearDepositNormal() {
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.setSiteDepositNormal(new Deposit());
		semmsi004tab5Bean.getSiteDepositNormal().setDepositCondType("01"); // Normal
		semmsi004tab5Bean.getSiteDepositNormal().setDepositType("02"); // default Cash
		semmsi004tab5Bean.setRenderedDeposiNormalVatType(true); // show vat Adding by John
		semmsi004tab5Bean.getSiteDepositNormal().setVatType("01"); // set default value
		semmsi004tab5Bean.getSiteDepositNormal().setDepositAmt(null);
		semmsi004tab5Bean.setRenderedDeposiNormalVatType(true);
		semmsi004tab5Bean.setDisabledBtnUpdateDepositNormal(true);
		semmsi004tab5Bean.setDisabledBtnAddDepositNormal(false);
		semmsi004tab5Bean.setDisabledOldInsurance(false);
		this.doRenderDeptBgCash();
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		
		return flag;
	}
	
	public void doRenderDeptBgCash(){
		log.debug(" #### Start SEMMSI004Tab3Action doRenderDeptBgCash ####");
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		semmsi004tab5Bean.setRenderedPnlDeptCash(false);
		semmsi004tab5Bean.setRenderedPnlDeptBg(false);
		String tempDepositType = semmsi004tab5Bean.getSiteDepositNormal().getDepositType();
		try{
			if(semmsi004tab5Bean.getSiteDepositNormal().getDepositType() != null){
				if(StringUtils.equals("01", semmsi004tab5Bean.getSiteDepositNormal().getDepositType())){
					semmsi004tab5Bean.setRenderedPnlDeptCash(false);
					semmsi004tab5Bean.setRenderedPnlDeptBg(true);
				}else if(StringUtils.equals("02", semmsi004tab5Bean.getSiteDepositNormal().getDepositType())){
					
					semmsi004tab5Bean.setRenderedPnlDeptCash(true);
					semmsi004tab5Bean.setRenderedPnlDeptBg(false);
				}
				semmsi004tab5Bean.getSiteDepositNormal().setExpenseType("");
				semmsi004tab5Bean.getSiteDepositNormal().setServiceId("");
				semmsi004tab5Bean.getSiteDepositNormal().setRemark("");
//				semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
				semmsi004tab5Bean.getSiteDepositNormal().setDepositAmtOld(null);
				semmsi004tab5Bean.getSiteDepositNormal().setDepositReturnType("");
				semmsi004tab5Bean.getSiteDepositNormal().setReturnAmt(null);
				semmsi004tab5Bean.getSiteDepositNormal().setDepositReturnAmt(null);
				semmsi004tab5Bean.getSiteDepositNormal().setDepositBringForward(null);
				semmsi004tab5Bean.getSiteDepositNormal().setDepositAmtNew(null);
				semmsi004tab5Bean.getSiteDepositNormal().setWithdrawFlag("");
				semmsi004tab5Bean.getSiteDepositNormal().setRentPaymentPeriod("");
				log.debug("tempDepositType  : "+tempDepositType);
				semmsi004tab5Bean.getSiteDepositNormal().setDepositType(tempDepositType);
//				semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
				setSemmsi004tab5Bean(semmsi004tab5Bean);
				
				//this.initUpdDeptReturnType();
				//this.doCalDepositReturnAmt();
				//this.doCalDepositAmt();
				//this.doInitDeposit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action doRenderDeptBgCash : "+e);
		}finally{
			setSemmsi004tab5Bean(semmsi004tab5Bean);
			log.debug(" #### END SEMMSI004Tab3Action doRenderDeptBgCash ####");
		}
	}
	
	public boolean clearWhtRate(){
		boolean flag = false;
		semmsi004tab5Bean = getSemmsi004tab5Bean();
		String whtType = semmsi004tab5Bean.getSiteInfoObjELParam().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab5Bean.getSiteInfoObjELParam().setWhtRate(null);
//			semmsi004tab5Bean.setDisabledChkWhtRateNormal(true);
//			semmsi004tab5Bean.setDisabledWhtRateNormal(true);
		}else{
//			this.renderedNormalVatType();
//			semmsi004tab5Bean.setDisabledChkWhtRateNormal(false);
		}
		semmsi004tab5Bean.setChkWhtRateNormal(false);
		setSemmsi004tab5Bean(semmsi004tab5Bean);
		return flag;
	}
}
