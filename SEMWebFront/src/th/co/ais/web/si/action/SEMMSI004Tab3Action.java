package th.co.ais.web.si.action;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.mm.ItemResultSP;
import th.co.ais.domain.sa.SiteAppRegHistSrch;
import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Deposit;
import th.co.ais.domain.si.Msi004CheckEditDepositRentSP;
import th.co.ais.domain.si.Msi004CheckEditRentSP;
import th.co.ais.domain.si.Msi004GenDpstSP;
import th.co.ais.domain.si.Msi004SeqDepositSP;
import th.co.ais.domain.si.Msi004SeqRentCondSP;
import th.co.ais.domain.si.Msi004SrchDepositRentSP;
import th.co.ais.domain.si.Msi004SrchRentCondSP;
import th.co.ais.domain.si.Msi004UpdateNoDepositRentSP;
import th.co.ais.domain.si.Msi004UpdateNoRentSP;
import th.co.ais.domain.si.Rent;
import th.co.ais.domain.si.RentCond;
import th.co.ais.domain.si.SiteInfo;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.domain.si.SumDepositRentSP;
import th.co.ais.domain.si.SumRentSP;
import th.co.ais.service.gm.ILovMasterService;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.service.si.ISiteDepositService;
import th.co.ais.service.si.ISiteInfoService;
import th.co.ais.service.si.ISiteRentCondService;
import th.co.ais.service.si.ISiteRentService;
import th.co.ais.util.ELovType;
import th.co.ais.util.ELovVal;
import th.co.ais.util.EQueryName;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.si.bean.SEMMSI004Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab1Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab2Bean;
import th.co.ais.web.si.bean.SEMMSI004Tab3Bean;
import th.co.ais.web.util.FrontMessageUtils;

public class SEMMSI004Tab3Action extends AbstractAction {
	

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(getClass());

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;
		
		// table RentCond
		if(methodWithNavi.equalsIgnoreCase("initDeleteRentCond")){
			flag = initDeleteRentCond();
		}
		if(methodWithNavi.equalsIgnoreCase("doDeleteRentCond")){
			flag = doDeleteRentCond();
		}
		if(methodWithNavi.equalsIgnoreCase("initUpdateRentCond")){
			flag = initUpdateRentCond();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateRentCond")){
			flag = doUpdateRentCond();
		}
		if(methodWithNavi.equalsIgnoreCase("doAddRentCond")){
			flag = doAddRentCond();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearRentCond")){
			flag = doClearRentCond();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateRentCondSpecial")){
			flag = doUpdateRentCondSpecial();
		}
		
		// table Deposit BG,Cash 
		if(methodWithNavi.equalsIgnoreCase("initDeleteDepositNormal")){
			flag = initDeleteDepositNormal();
		}
		if(methodWithNavi.equalsIgnoreCase("doDeleteDepositNormal")){
			flag = doDeleteDepositNormal();
		}
		if(methodWithNavi.equalsIgnoreCase("initUpdateDepositNormal")){
			flag = initUpdateDepositNormal();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateDepositNormal")){
			flag = doUpdateDepositNormal();
		}
		if(methodWithNavi.equalsIgnoreCase("doClearDepositNormal")){
			flag = doClearDepositNormal();
		}
		if(methodWithNavi.equalsIgnoreCase("doAddDepositNormal")){
			flag = doAddDepositNormal();
		}
		if(methodWithNavi.equalsIgnoreCase("doUpdateDepositSpecial")){
			flag = doUpdateDepositSpecial();
		}
		if(methodWithNavi.equalsIgnoreCase("doSaveTotalRent")){
			flag = doSaveTotalRent();
		}
		if(methodWithNavi.equalsIgnoreCase("doSaveTotalDeposit")){
			flag = doSaveTotalDeposit();
		}
		if(methodWithNavi.equalsIgnoreCase("doCheckRentalChange")){
			flag = this.doCheckRentalChange();
		}
		if(methodWithNavi.equalsIgnoreCase("doCheckRentalDepositChange")){
			flag = this.doCheckRentalDepositChange();
		}
		
		
		return flag;
	}
	
	private boolean doSaveTotalDeposit() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(false);
		semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
		
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			if(semmsi004tab3Bean.isChkNoRentDeposit()){
				try{
					// CALL SP_MSI004_UPD_NO_DEPOSIT_R
					List<Msi004UpdateNoDepositRentSP> to = null;
					Msi004UpdateNoDepositRentSP criteria = new Msi004UpdateNoDepositRentSP();
					criteria.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
					criteria.setCurrentUser(semmsi004tab3Bean.getUserLogin());
					to = service.querySPList(EQueryName.SP_MSI004_UPD_NO_DEPOSIT_R.name, criteria);
					if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
						log.debug("no deposit rent result [" + to.get(0).getResultMsg());
						semmsi004tab3Bean.setDepositRentBgSPList(null);
						semmsi004tab3Bean.setDepositRentCashSPList(null);
						this.getTotalDeposit();
//						addMessageInfo("M0001");
						if(semmsi004tab3Bean.isRenderAlertMessage()){
							addMessageInfo("M0001");
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					addMessageError("E0001");
				}
			}else{
				try{
					String depositCondType = semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType();
					// normal
//					if(depositCondType.equals("01")){
						// delete deposit special before insert deposit normal
//						this.deleteDepositSpecial(semmsi004tab3Bean.getSiteInfoId());
						this.updateSiteRent(ELovVal.V_CT_DEPOSIT_RENT.name, depositCondType);
//					}else{
						// special
						if(!validateDepositSpecial()){
							semmsi004tab3Bean.setRenderedMsgFormBottom(true);
							semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
							setSemmsi004tab1Bean(semmsi004tab1Bean);
							setSemmsi004tab3Bean(semmsi004tab3Bean);
							return flag;
						}
						this.doUpdateDepositSpecial();
//						addMessageInfo("M0001");
//					}
				}catch(Exception e){
					e.printStackTrace();
					addMessageError("E0001");
				}
			}
		semmsi004tab3Bean.setRenderedMsgFormBottom(true);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
//		flag = doSaveTotalRent();
		
		return flag;
	}

	private boolean validateDepositSpecial() {
		boolean flgValid = true;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			if(!StringUtils.isEmpty(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail()) &&
			   semmsi004tab3Bean.getTotalDeposit().getTotalDepositBgAmt() == 0.0){
				addMessageError("W0001", msg("message.totalDepositBgAmt"));
				flgValid = false;
			}
			if(!StringUtils.isEmpty(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail()) &&
			   semmsi004tab3Bean.getTotalDeposit().getTotalDepositCashAmt() == 0.0){
					addMessageError("W0001", msg("message.totalDepositCashAmt"));
					flgValid = false;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flgValid;
	}

	private void getTotalDeposit() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ISiteRentService siteRentService = (ISiteRentService)getBean("siteRentService");
			Rent rent = siteRentService.queryRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			if(rent != null){
				semmsi004tab3Bean.setTotalDeposit(rent);
				if(rent.getNoDeposit() != null && rent.getNoDeposit().equals("Y")){
					semmsi004tab3Bean.setChkNoRentDeposit(true);
				}else{
					semmsi004tab3Bean.setChkNoRentDeposit(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}

	private boolean doSaveTotalRent() {
		boolean flag = false;
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			if(semmsi004tab3Bean.isChkNoRent()){
				// CALL SP_MSI004_UPD_NO_RENT
				try{
					List<Msi004UpdateNoRentSP> to = null;
					Msi004UpdateNoRentSP criteria = new Msi004UpdateNoRentSP();
					criteria.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
					criteria.setCurrentUser(semmsi004tab3Bean.getUserLogin());
					to = service.querySPList(EQueryName.SP_MSI004_UPD_NO_RENT.name, criteria);
					if(to != null && !to.isEmpty() && to.get(0).getResultMsg().equals("Success")){
						log.debug("no rent result [" + to.get(0).getResultMsg());
						semmsi004tab3Bean.setRentCondSPList(null);
						this.getTotalRent();
//						addMessageInfo("M0001");
						if(semmsi004tab3Bean.isRenderAlertMessage()){
							addMessageInfo("M0001");
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					addMessageError("E0001");
				}
			}else{
				try{
					String rentCondType = semmsi004tab3Bean.getRentCondNormal().getRentCondType();
					// normal
//					if(rentCondType.equals("01")){
						// check and delete rentCond special before insert rentCond normal
//						this.deleteRentCondSpecial(semmsi004tab3Bean.getSiteInfoId());
						rentCondType = "01";
						this.updateSiteRent(ELovVal.V_CT_RENT.name, rentCondType);
//					}else{
//					if(semmsi004tab3Bean.getRentCondSpecial1() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getRentCondSpecial1().getDetail())){
					if(semmsi004tab3Bean.getRentCondSpecial1() != null ){
						// special
//						if(!validateRentCondSpecial()){
//							semmsi004tab1Bean.setRenderedMsgFormSearch(false);
//							semmsi004tab3Bean.setRenderedMsgFormTop(false);
//							semmsi004tab3Bean.setRenderedMsgFormMiddle(true);
//							semmsi004tab3Bean.setRenderedMsgFormBottom(false);
//							semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
//							setSemmsi004tab1Bean(semmsi004tab1Bean);
//							setSemmsi004tab3Bean(semmsi004tab3Bean);
//							return flag;
//						}
						// UPDATE RENT COND SPECIAL
						this.doUpdateRentCondSpecial();
						// UPDATE TOTAL RENT
						Rent rent = service.queryRentBySiteInfoId(getSemmsi004tab3Bean().getSiteInfoId());
						if(rent != null){
							rent.setTotalRentAddAmt(semmsi004tab3Bean.getTotalRent().getTotalRentAddAmt());
							rent.setTotalRentAddPeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentAddPeriodType());
							rent.setTotalServiceAddAmt(semmsi004tab3Bean.getTotalRent().getTotalServiceAddAmt());
							rent.setTotalServiceAddPeriodType(semmsi004tab3Bean.getTotalRent().getTotalServiceAddPeriodType());
							rent.setTotalRentAmt(semmsi004tab3Bean.getTotalRent().getTotalRentAmt());
							rent.setTotalRentPeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentPeriodType());
							rent.setTotalServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalServiceAmt());
							rent.setTotalServicePeriodType(semmsi004tab3Bean.getTotalRent().getTotalServicePeriodType());
							rent.setTotalRentServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalRentServiceAmt());
							rent.setTotalRentServicePeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentServicePeriodType());
							rent.setTotalAgeRentServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeRentServiceAmt());
							rent.setTotalAgeRentAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeRentAmt());
							rent.setTotalAgeServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt());
							rent.setCurrentUser(getSemmsi004tab3Bean().getUserLogin());
							semmsi004tab3Bean.setTotalRent(service.updateSiteRent(rent));
//							addMessageInfo("M0001");
							if(semmsi004tab3Bean.isRenderAlertMessage()){
								addMessageInfo("M0001");
							}
						}
						//added BY NEW 2015/04/29
						this.setRentCondSpecial(getSemmsi004tab3Bean().getSiteInfoId(),"02");
					}
//					}
				}catch(Exception e){
					e.printStackTrace();
					addMessageError("E0001");
				}
		}
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(false);
//		semmsi004tab3Bean.setRenderedMsgFormTop(true);
		semmsi004tab3Bean.setRenderedMsgFormMiddle(true);
//		semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab3Bean.setRenderedMsgFormBottom(false);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	

	private boolean validateRentCondSpecial() {
		boolean flgValid = true;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			log.debug("semmsi004tab3Bean.getRentCondSpecial1().getDetail() ver = "+semmsi004tab3Bean.getRentCondSpecial1().getDetail());
			if(!StringUtils.isEmpty(semmsi004tab3Bean.getRentCondSpecial1().getDetail())&&
			   semmsi004tab3Bean.getTotalRent().getTotalAgeRentAmt() == 0.00){
				addMessageError("W0001", msg("message.totalAgeRentAmt"));
				flgValid = false;
			}
			if(!StringUtils.isEmpty(semmsi004tab3Bean.getRentCondSpecial2().getDetail()) &&
			   semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt() == 0.00){
					addMessageError("W0001", msg("message.totalAgeServiceAmt"));
					flgValid = false;
			}
			if(!StringUtils.isEmpty(semmsi004tab3Bean.getRentCondSpecial3().getDetail()) &&
					   semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt() == 0.00){
							addMessageError("W0001", msg("message.totalAgeRentAmt"));
							flgValid = false;
			}
			if(!StringUtils.isEmpty(semmsi004tab3Bean.getRentCondSpecial4().getDetail()) &&
					   semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt() == 0.00){
							addMessageError("W0001", msg("message.totalAgeServiceAmt"));
							flgValid = false;
			}
			Rent totalRent = semmsi004tab3Bean.getTotalRent();
			if(totalRent.getTotalRentAddAmt() != 0.00 &&  StringUtils.isEmpty(totalRent.getTotalRentAddPeriodType())){
				addMessageError("W0001", msg("message.totalRentAddAmtPeriodType"));
				flgValid = false;
			}
			if(totalRent.getTotalRentAddAmt() == null &&  !StringUtils.isEmpty(totalRent.getTotalRentAddPeriodType())){
				addMessageError("W0001", msg("message.totalRentAddAmt"));
				flgValid = false;
			}
			if(totalRent.getTotalServiceAddAmt() != 0.00  &&  StringUtils.isEmpty(totalRent.getTotalServiceAddPeriodType())){
				addMessageError("W0001", msg("message.totalServiceAddAmtPeriodType"));
				flgValid = false;
			}
			if(totalRent.getTotalServiceAddAmt() == null &&  !StringUtils.isEmpty(totalRent.getTotalServiceAddPeriodType())){
				addMessageError("W0001", msg("message.totalServiceAddAmt"));
				flgValid = false;
			}
			if(totalRent.getTotalRentAmt() != 0.00  &&  StringUtils.isEmpty(totalRent.getTotalRentPeriodType())){
				addMessageError("W0001", msg("message.totalRentAmtPeriodType"));
				flgValid = false;
			}
			if(totalRent.getTotalRentAmt() == null &&  !StringUtils.isEmpty(totalRent.getTotalRentPeriodType())){
				addMessageError("W0001", msg("message.totalRentAmt"));
				flgValid = false;
			}
			if(totalRent.getTotalServiceAmt() != 0.00  &&  StringUtils.isEmpty(totalRent.getTotalServicePeriodType())){
				addMessageError("W0001", msg("message.totalServiceAmtPeriodType"));
				flgValid = false;
			}
			if(totalRent.getTotalServiceAmt() == null &&  !StringUtils.isEmpty(totalRent.getTotalServicePeriodType())){
				addMessageError("W0001", msg("message.totalServiceAmt"));
				flgValid = false;
			}
			if(totalRent.getTotalRentServiceAmt() != 0.00  &&  StringUtils.isEmpty(totalRent.getTotalRentServicePeriodType())){
				addMessageError("W0001", msg("message.totalRentServicePeriodType"));
				flgValid = false;
			}
			if(totalRent.getTotalRentServiceAmt() == null &&  !StringUtils.isEmpty(totalRent.getTotalRentServicePeriodType())){
				addMessageError("W0001", msg("message.totalRentService"));
				flgValid = false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flgValid;
	}

	public void getTotalRent() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ISiteRentService siteRentService = (ISiteRentService)getBean("siteRentService");
			Rent rent = siteRentService.queryRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			if(rent != null){
				semmsi004tab3Bean.setTotalRent(rent);
				if(rent.getNoRent() != null && rent.getNoRent().equals("Y")){
					semmsi004tab3Bean.setChkNoRent(true);
				}else{
					semmsi004tab3Bean.setChkNoRent(false);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private boolean doUpdateDepositSpecial() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
			// delete deposit normal before insert deposit special
//			this.deleteDepositNormal(siteInfoId);
			// update site rent (depositCondType = '02')
			String depositCondType = "02";
			this.updateSiteRent(ELovVal.V_CT_DEPOSIT_RENT.name, depositCondType);
			// BG
			log.debug("semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail() = "+semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail());
			if(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail() != null){
				if(StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail())){
				// update deposit special Bg
				String rowId = semmsi004tab3Bean.getSiteDepositSpecialBg().getRowId();
				if(rowId != null){
					Deposit depositBg = service.queryDepositByRowId(rowId);
					if(depositBg != null){
						depositBg.setCurrentUser(semmsi004tab3Bean.getUserLogin());
						depositBg.setDetail(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail());
						service.updateDeposit(depositBg);
						
					}
				}else{
					// insert deposit special
					semmsi004tab3Bean.getSiteDepositSpecialBg().setSiteInfoId(siteInfoId);
					semmsi004tab3Bean.getSiteDepositSpecialBg().setDepositCondType(depositCondType);
					semmsi004tab3Bean.getSiteDepositSpecialBg().setSeqNo(1);
					semmsi004tab3Bean.getSiteDepositSpecialBg().setNewStatus("Y");
					semmsi004tab3Bean.getSiteDepositSpecialBg().setDepositType("01"); // BG
					service.createSiteDeposit(semmsi004tab3Bean.getSiteDepositSpecialBg());
					
				}
				}
			}
			// Cash
			log.debug("semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail() = "+semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail());
			if(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail() != null){
				if(StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail())){
				// update deposit special Cash
				String rowId = semmsi004tab3Bean.getSiteDepositSpecialCash().getRowId();
				if(rowId != null){
					Deposit depositCash = service.queryDepositByRowId(rowId);
					if(depositCash != null){
						depositCash.setCurrentUser(semmsi004tab3Bean.getUserLogin());
						depositCash.setDetail(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail());
						depositCash.setVatType(semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType());
						service.updateDeposit(depositCash);
						
					}
				}else{
					// insert deposit special
					semmsi004tab3Bean.getSiteDepositSpecialCash().setSiteInfoId(siteInfoId);
					semmsi004tab3Bean.getSiteDepositSpecialCash().setDepositCondType(depositCondType);
					semmsi004tab3Bean.getSiteDepositSpecialCash().setSeqNo(2);
					semmsi004tab3Bean.getSiteDepositSpecialCash().setNewStatus("Y");
					semmsi004tab3Bean.getSiteDepositSpecialCash().setDepositType("02"); // Cash
					service.createSiteDeposit(semmsi004tab3Bean.getSiteDepositSpecialCash());
				}
				}
			}
			 // update site rent (totalDepositBg, totalDepositCash)
			this.updateTotalDeposit();
			this.updateSiteInfoDepositRentEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("3-1");
//			addMessageInfo("M0001");
		}catch(Exception e){
			e.printStackTrace();
//			addMessageError("E0001");
		}
//		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
//		semmsi004tab3Bean.setRenderedMsgFormTop(false);
//		semmsi004tab3Bean.setRenderedMsgFormBottom(true);
//		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
		return flag;
	}

	private void updateTotalDeposit() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent rent = service.queryRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			if(rent != null){
				
				//Add 7/12/2012
				SumDepositRentSP sumDepositRent = semmsi004tab1Bean.getSumDepositRentSP();
				if(semmsi004tab3Bean.getSiteDepositSpecialBg() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail())){
					rent.setTotalDepositBgAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositBgAmt());
				}else{
					if(sumDepositRent.getDepositBgAmt() != null)rent.setTotalDepositBgAmt(sumDepositRent.getDepositBgAmt());
				}
				
				if(semmsi004tab3Bean.getSiteDepositSpecialCash() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail())){
					rent.setTotalDepositCashAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositCashAmt());
				}else{
					if(sumDepositRent.getDepositCashAmt() != null)rent.setTotalDepositCashAmt(sumDepositRent.getDepositCashAmt());
				}
				
				
//				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("01")){
//					SumDepositRentSP sumDepositRent = semmsi004tab1Bean.getSumDepositRentSP();
//					rent.setTotalDepositBgAmt(sumDepositRent.getDepositBgAmt());
//					rent.setTotalDepositCashAmt(sumDepositRent.getDepositCashAmt());
//				}else{
//					rent.setTotalDepositBgAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositBgAmt());
//					rent.setTotalDepositCashAmt(semmsi004tab3Bean.getTotalDeposit().getTotalDepositCashAmt());
//				}
				
				rent.setCurrentUser(semmsi004tab3Bean.getUserLogin());
				semmsi004tab3Bean.setTotalDeposit(service.updateSiteRent(rent));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private boolean doUpdateRentCondSpecial() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
			String rentCondType = "02";
			
			// check and delete rentCond normal before insert rentCond special
//			this.deleteRentCondNormal(siteInfoId);
			// update rent
			this.updateSiteRent(ELovVal.V_CT_RENT.name, rentCondType);
			
			if(semmsi004tab3Bean.getRentCondSpecial1() != null ){
				log.debug("semmsi004tab3Bean.getRentCondSpecial1().getDetail() = "+semmsi004tab3Bean.getRentCondSpecial1().getDetail());
				// update rentcond special record1
				String rowId = semmsi004tab3Bean.getRentCondSpecial1().getRowId();
				log.debug("rowId = "+rowId);
				if(rowId != null){
					RentCond rentCond1 = service.queryRentCondByRowId(rowId);
					if(rentCond1 != null){
						rentCond1.setCurrentUser(semmsi004tab3Bean.getUserLogin());
						rentCond1.setDetail(semmsi004tab3Bean.getRentCondSpecial1().getDetail());
						rentCond1.setWhtType(semmsi004tab3Bean.getRentCondSpecial1().getWhtType());
						rentCond1.setWhtRate(semmsi004tab3Bean.getRentCondSpecial1().getWhtRate());
						rentCond1.setVatType(semmsi004tab3Bean.getRentCondSpecial1().getVatType());
						log.debug("rentCond1.getRecordStatus = "+rentCond1.getRecordStatus());
						log.debug("rentCond1.getRowId = "+rentCond1.getRowId());
						service.updateRentCond(rentCond1);
						this.updateSiteInfoRentEditFlag();
						// approve siteInfoId
						getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					}
					
				}else{
					// insert rentCond special record1
					semmsi004tab3Bean.getRentCondSpecial1().setCurrentUser(semmsi004tab3Bean.getUserLogin());
					semmsi004tab3Bean.getRentCondSpecial1().setSiteInfoId(siteInfoId);
					semmsi004tab3Bean.getRentCondSpecial1().setSeqNo(1);
					semmsi004tab3Bean.getRentCondSpecial1().setRentCondType("02");
					semmsi004tab3Bean.getRentCondSpecial1().setExpenseType("01");
					service.createSiteRentCond(semmsi004tab3Bean.getRentCondSpecial1());
					this.updateSiteInfoRentEditFlag();
					// approve siteInfoId
					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
				}
			}
			if(semmsi004tab3Bean.getRentCondSpecial2() != null){
				// update rentcond special record2
				log.debug("semmsi004tab3Bean.getRentCondSpecial2().getDetail() = "+semmsi004tab3Bean.getRentCondSpecial2().getDetail());
				String rowId = semmsi004tab3Bean.getRentCondSpecial2().getRowId();
				if(rowId != null){
					RentCond rentCond2 = service.queryRentCondByRowId(rowId);
					if(rentCond2 != null){
						rentCond2.setCurrentUser(semmsi004tab3Bean.getUserLogin());
						rentCond2.setDetail(semmsi004tab3Bean.getRentCondSpecial2().getDetail());
						rentCond2.setWhtType(semmsi004tab3Bean.getRentCondSpecial2().getWhtType());
						rentCond2.setWhtRate(semmsi004tab3Bean.getRentCondSpecial2().getWhtRate());
						rentCond2.setVatType(semmsi004tab3Bean.getRentCondSpecial2().getVatType());
						log.debug("rentCond2.getRecordStatus = "+rentCond2.getRecordStatus());
						log.debug("rentCond2.getRowId = "+rentCond2.getRowId());
						service.updateRentCond(rentCond2);
						this.updateSiteInfoRentEditFlag();
						// approve siteInfoId
						getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					}
				}else{
					
					// insert rentCond special record2
					semmsi004tab3Bean.getRentCondSpecial2().setCurrentUser(semmsi004tab3Bean.getUserLogin());
					semmsi004tab3Bean.getRentCondSpecial2().setSiteInfoId(siteInfoId);
					semmsi004tab3Bean.getRentCondSpecial2().setSeqNo(2);
					semmsi004tab3Bean.getRentCondSpecial2().setRentCondType("02");
					semmsi004tab3Bean.getRentCondSpecial2().setExpenseType("02");
					semmsi004tab3Bean.getRentCondSpecial2().setSubExpenseType("01");
					service.createSiteRentCond(semmsi004tab3Bean.getRentCondSpecial2());
					// approve siteInfoId
					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					this.updateSiteInfoRentEditFlag();
				}
			}
			if(semmsi004tab3Bean.getRentCondSpecial3() != null ){
				log.debug("semmsi004tab3Bean.getRentCondSpecial3().getDetail() = "+semmsi004tab3Bean.getRentCondSpecial3().getDetail());
				// update rentcond special record1
				String rowId = semmsi004tab3Bean.getRentCondSpecial3().getRowId();
				log.debug("rowId = "+rowId);
				if(rowId != null){
					RentCond rentCond3 = service.queryRentCondByRowId(rowId);
					if(rentCond3 != null){
						rentCond3.setCurrentUser(semmsi004tab3Bean.getUserLogin());
						rentCond3.setDetail(semmsi004tab3Bean.getRentCondSpecial3().getDetail());
						rentCond3.setWhtType(semmsi004tab3Bean.getRentCondSpecial3().getWhtType());
						rentCond3.setWhtRate(semmsi004tab3Bean.getRentCondSpecial3().getWhtRate());
						rentCond3.setVatType(semmsi004tab3Bean.getRentCondSpecial3().getVatType());
						log.debug("rentCond3.getRecordStatus = "+rentCond3.getRecordStatus());
						log.debug("rentCond3.getRowId = "+rentCond3.getRowId());
						service.updateRentCond(rentCond3);
						this.updateSiteInfoRentEditFlag();
						// approve siteInfoId
						getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					}
					
				}else{
					// insert rentCond special record1
					semmsi004tab3Bean.getRentCondSpecial3().setCurrentUser(semmsi004tab3Bean.getUserLogin());
					semmsi004tab3Bean.getRentCondSpecial3().setSiteInfoId(siteInfoId);
					semmsi004tab3Bean.getRentCondSpecial3().setSeqNo(1);
					semmsi004tab3Bean.getRentCondSpecial3().setRentCondType("02");
					semmsi004tab3Bean.getRentCondSpecial3().setExpenseType("02");
					semmsi004tab3Bean.getRentCondSpecial3().setSubExpenseType("02");
					service.createSiteRentCond(semmsi004tab3Bean.getRentCondSpecial3());
					this.updateSiteInfoRentEditFlag();
					// approve siteInfoId
					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
				}
			}
			if(semmsi004tab3Bean.getRentCondSpecial4() != null ){
				log.debug("semmsi004tab3Bean.getRentCondSpecial4().getDetail() = "+semmsi004tab3Bean.getRentCondSpecial4().getDetail());
				// update rentcond special record1
				String rowId = semmsi004tab3Bean.getRentCondSpecial4().getRowId();
				log.debug("rowId = "+rowId);
				if(rowId != null){
					RentCond rentCond4 = service.queryRentCondByRowId(rowId);
					if(rentCond4 != null){
						rentCond4.setCurrentUser(semmsi004tab3Bean.getUserLogin());
						rentCond4.setDetail(semmsi004tab3Bean.getRentCondSpecial4().getDetail());
						rentCond4.setWhtType(semmsi004tab3Bean.getRentCondSpecial4().getWhtType());
						rentCond4.setWhtRate(semmsi004tab3Bean.getRentCondSpecial4().getWhtRate());
						rentCond4.setVatType(semmsi004tab3Bean.getRentCondSpecial4().getVatType());
						log.debug("rentCond3.getRecordStatus = "+rentCond4.getRecordStatus());
						log.debug("rentCond3.getRowId = "+rentCond4.getRowId());
						service.updateRentCond(rentCond4);
						this.updateSiteInfoRentEditFlag();
						// approve siteInfoId
						getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
					}
					
				}else{
					// insert rentCond special record1
					semmsi004tab3Bean.getRentCondSpecial4().setCurrentUser(semmsi004tab3Bean.getUserLogin());
					semmsi004tab3Bean.getRentCondSpecial4().setSiteInfoId(siteInfoId);
					semmsi004tab3Bean.getRentCondSpecial4().setSeqNo(1);
					semmsi004tab3Bean.getRentCondSpecial4().setRentCondType("02");
					semmsi004tab3Bean.getRentCondSpecial4().setExpenseType("02");
					semmsi004tab3Bean.getRentCondSpecial4().setSubExpenseType("03");
					service.createSiteRentCond(semmsi004tab3Bean.getRentCondSpecial4());
					this.updateSiteInfoRentEditFlag();
					// approve siteInfoId
					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
				}
			}
			
//			if(semmsi004tab3Bean.getRentCondSpecial3()!= null ){
//				// update rentcond special record3
//				String rowId = semmsi004tab3Bean.getRentCondSpecial3().getRowId();
//				if(rowId != null){
//					RentCond rentCond3 = service.queryRentCondByRowId(rowId);
//					if(rentCond3 != null){
//						rentCond3.setCurrentUser(semmsi004tab3Bean.getUserLogin());
//						rentCond3.setDetail(semmsi004tab3Bean.getRentCondSpecial3().getDetail());
//						rentCond3.setWhtType(semmsi004tab3Bean.getRentCondSpecial3().getWhtType());
//						rentCond3.setWhtRate(semmsi004tab3Bean.getRentCondSpecial3().getWhtRate());
//						rentCond3.setVatType(semmsi004tab3Bean.getRentCondSpecial3().getVatType());
//						service.updateRentCond(rentCond3);
//						this.updateSiteInfoRentEditFlag();
//						// approve siteInfoId
//						getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
//					}
//				}else{
//					
//					// insert rentCond special record3
//					semmsi004tab3Bean.getRentCondSpecial3().setCurrentUser(semmsi004tab3Bean.getUserLogin());
//					semmsi004tab3Bean.getRentCondSpecial3().setSiteInfoId(siteInfoId);
//					semmsi004tab3Bean.getRentCondSpecial3().setSeqNo(3);
//					semmsi004tab3Bean.getRentCondSpecial3().setRentCondType("02");
//					semmsi004tab3Bean.getRentCondSpecial3().setExpenseType("03");
//					service.createSiteRentCond(semmsi004tab3Bean.getRentCondSpecial3());
//					// approve siteInfoId
//					getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
//					this.updateSiteInfoRentEditFlag();
//				}
//			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private void updateTotalRent() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent rent = service.queryRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			if(rent != null){
//				if(semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("01")){
					SumRentSP sumRent = semmsi004tab1Bean.getSumRentSP();
					if(sumRent != null){
						rent.setTotalRentAddAmt(sumRent.getRentAddAmt());
						rent.setTotalRentAddPeriodType(sumRent.getRentAddPeriodType());
						rent.setTotalServiceAddAmt(sumRent.getServiceAddAmt());
						rent.setTotalServiceAddPeriodType(sumRent.getServiceAddPeriodType());
						rent.setTotalRentAmt(sumRent.getRentAmt());
						rent.setTotalRentPeriodType(sumRent.getRentPeriodType());
						rent.setTotalServiceAmt(sumRent.getServiceAmt());
						rent.setTotalServicePeriodType(sumRent.getServicePeriodType());
						rent.setTotalRentServiceAmt(sumRent.getRentServiceAmt());
						rent.setTotalRentServicePeriodType(sumRent.getRentServicePeriodType());
						
						//rent.setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt())
						//13/03/2023 modify TotalAgeRentServiceAmt = TotalAgeRentServiceAmt+TotalAgeDonateAmt
						rent.setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt()+(sumRent.getAgeDonateAmt()==null?0:sumRent.getAgeDonateAmt()));
						rent.setTotalAgeDonateAmt(sumRent.getAgeDonateAmt());
						
						rent.setTotalAgeRentAmt(sumRent.getAgeRentAmt());
						rent.setTotalAgeServiceAmt(sumRent.getAgeServiceAmt());
						
					}
//				}else{
//					rent.setTotalRentAddAmt(semmsi004tab3Bean.getTotalRent().getTotalRentAddAmt());
//					rent.setTotalRentAddPeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentAddPeriodType());
//					rent.setTotalServiceAddAmt(semmsi004tab3Bean.getTotalRent().getTotalServiceAddAmt());
//					rent.setTotalServiceAddPeriodType(semmsi004tab3Bean.getTotalRent().getTotalServiceAddPeriodType());
//					rent.setTotalRentAmt(semmsi004tab3Bean.getTotalRent().getTotalRentAmt());
//					rent.setTotalRentPeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentPeriodType());
//					rent.setTotalServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalServiceAmt());
//					rent.setTotalServicePeriodType(semmsi004tab3Bean.getTotalRent().getTotalServicePeriodType());
//					rent.setTotalRentServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalRentServiceAmt());
//					rent.setTotalRentServicePeriodType(semmsi004tab3Bean.getTotalRent().getTotalRentServicePeriodType());
//					rent.setTotalAgeRentServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalRentServiceAmt());
//					rent.setTotalAgeRentAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeRentAmt());
//					rent.setTotalAgeServiceAmt(semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt());
//				}
				rent.setCurrentUser(semmsi004tab3Bean.getUserLogin());
				semmsi004tab3Bean.setTotalRent(service.updateSiteRent(rent));	
				setSemmsi004tab3Bean(semmsi004tab3Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private boolean doAddDepositNormal() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateDepositNormal()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab3Bean.setRenderedMsgFormTop(false);
			semmsi004tab3Bean.setRenderedMsgFormBottom(true);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			return flag;
		}
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			String depositTmp = (String)getFacesUtils().getRequestParameter("depositeCondType");
			String depositCondType = "";
			if(StringUtils.isEmpty(depositTmp)){
				depositCondType = semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType();
			}else{
				depositCondType = depositTmp;
				semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType(depositTmp);
			}
			String siteInfoId = semmsi004tab3Bean.getSiteInfoId();
			// delete deposit special before insert deposit normal
				this.deleteDepositSpecial(siteInfoId);
			// update site rent (depositCondType = '01')
				this.updateSiteRent(ELovVal.V_CT_DEPOSIT_RENT.name, depositCondType);
			
			// insert deposit
			semmsi004tab3Bean.getSiteDepositNormal().setNewStatus("Y");
			semmsi004tab3Bean.getSiteDepositNormal().setSiteInfoId(siteInfoId);
			semmsi004tab3Bean.getSiteDepositNormal().setSeqNo(this.getDepositSeqNo(siteInfoId));
			
			if(semmsi004tab3Bean.getSiteDepositNormal().getExpenseType().equals("04")){
//				semmsi004tab3Bean.getSiteDepositNormal().setVatType(null);
			}
			if(StringUtils.equals(semmsi004tab3Bean.getSiteDepositNormal().getDepositType(), "02")) {
			semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
			}
			//Adding by JOHN 31/05/2011
			boolean chkNewStatus = semmsi004tab3Bean.getSiteDepositNormal().isChkNewStatus();
			if(chkNewStatus)
			semmsi004tab3Bean.getSiteDepositNormal().setNewStatus("N");
			else
			semmsi004tab3Bean.getSiteDepositNormal().setNewStatus("Y");
			
			this.doSetRentDepositChk();
			
			//set current user.
			semmsi004tab3Bean.getSiteDepositNormal().setCurrentUser(getUserLogIn());
			Deposit deposit = service.createSiteDeposit(semmsi004tab3Bean.getSiteDepositNormal());
			// search result
			semmsi004tab3Bean.setDepositRentBgSPList(null);
			semmsi004tab3Bean.setDepositRentCashSPList(null);
			this.semmsi004SearchDepositRentBG(siteInfoId);
			this.semmsi004SearchDepositRentCash(siteInfoId);
			// disabled checkbox no deposit
			if((semmsi004tab3Bean.getDepositRentBgSPList() != null && !semmsi004tab3Bean.getDepositRentBgSPList().isEmpty()) ||
			   (semmsi004tab3Bean.getDepositRentCashSPList() != null && !semmsi004tab3Bean.getDepositRentCashSPList().isEmpty())){
				semmsi004tab3Bean.setDisabledChkNoDeposit(true);
			}else{
				semmsi004tab3Bean.setDisabledChkNoDeposit(false);
			}
			
			this.doClearDepositNormal();
			this.updateSiteInfoDepositRentEditFlag();
			// get sum deposit rent for update table site rent
			getSemmsi004tab1Action().searchSumDepositRent(siteInfoId);
			this.updateTotalDeposit();
			//update msi004 GenDPST
			if(deposit != null){
				callMsi004GenDPST(deposit.getRowId(), EQueryName.SP_MSI004_GEN_DPST_R_ADD.name);
			}
			semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
			this.doClearDepositNormal();
			
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("3-1");
			addMessageInfo("M0001");
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(false);
		semmsi004tab3Bean.setRenderedMsgFormBottom(true);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	private void deleteDepositNormal(String siteInfoId) {
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			this.semmsi004SearchDepositRentBG(siteInfoId);
			this.semmsi004SearchDepositRentCash(siteInfoId);
			semmsi004tab3Bean = getSemmsi004tab3Bean();
			// delete deposit BG
			List<Msi004SrchDepositRentSP> bgList = semmsi004tab3Bean.getDepositRentBgSPList();
			if(bgList != null && bgList.size() > 0){
				for(Msi004SrchDepositRentSP bg : bgList){
					Deposit deposit = service.queryDepositByRowId(bg.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
				}
			}
			// delete deposit Cash
			List<Msi004SrchDepositRentSP> cashList = semmsi004tab3Bean.getDepositRentCashSPList();
			if(cashList != null && cashList.size() > 0){
				for(Msi004SrchDepositRentSP cash : cashList){
					Deposit deposit = service.queryDepositByRowId(cash.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
				}
			}
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void deleteDepositSpecial(String siteInfoId) {
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			this.semmsi004SearchDepositSpecial(siteInfoId, null, "02");
			semmsi004tab3Bean = getSemmsi004tab3Bean();
			List<Msi004SrchDepositRentSP> list = semmsi004tab3Bean.getDepositRentSpecialSPList();
			if(list != null && list.size() > 0){
				for(Msi004SrchDepositRentSP depositSpecial : list){
					Deposit deposit = service.queryDepositByRowId(depositSpecial.getRowId());
					if(deposit != null){
						service.deleteDeposit(deposit);
					}
						
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void updateSiteRent(String type, String condType) {
		try{
			semmsi004tab3Bean = getSemmsi004tab3Bean();
			getSemmsi004Action().getSiteRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			semmsi004Bean = getSemmsi004Bean();
			if(semmsi004Bean.getSiteRent() != null){
				if(type.equals(ELovVal.V_CT_RENT.name)){
					semmsi004Bean.getSiteRent().setRentCondType(condType);
					if(semmsi004tab3Bean.isChkNoRent()){
						semmsi004Bean.getSiteRent().setNoRent("Y");
					}else{
						semmsi004Bean.getSiteRent().setNoRent(null);
					}
				}else{
					semmsi004Bean.getSiteRent().setDepositCondType(condType);
					if(semmsi004tab3Bean.isChkNoRentDeposit()){
						semmsi004Bean.getSiteRent().setNoDeposit("Y");
					}else{
						semmsi004Bean.getSiteRent().setNoDeposit(null);
					}
				}
				
				//added by NEW 26/02/2016 set Fix5Percent
				if(semmsi004tab3Bean.isFix5Percent()){
					semmsi004Bean.getSiteRent().setFix5Percent("Y");
				}else{
					semmsi004Bean.getSiteRent().setFix5Percent("N");
				}
				
				//set record status
				semmsi004Bean.getSiteRent().setRecordStatus("Y");
				ISiteRentService service = (ISiteRentService)getBean("siteRentService");
				semmsi004Bean.getSiteRent().setCurrentUser(getUserLogIn());
//				semmsi004Bean.getSiteRent().setRentCondType("01");
				
				//add service_id
				semmsi004Bean.getSiteRent().setCurrentUser(getUserLogIn());
				
				service.updateSiteRent(semmsi004Bean.getSiteRent());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private Integer getDepositSeqNo(String siteInfoId){
		Integer seqNo = 0;
		List<Msi004SeqDepositSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SeqDepositSP criteria = new Msi004SeqDepositSP();
			criteria.setSiteInfoId(siteInfoId);
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
	

	private boolean validateDepositNormal() {
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi004tab3Bean().getSiteDepositNormal().getExpenseType())){
			addMessageError("W0001", msg("message.depositExpenseType"));
			flgValid = false;
		}
		
		if(StringUtils.isEmpty(getSemmsi004tab3Bean().getSiteDepositNormal().getDepositType())){
			addMessageError("W0001", msg("message.depositeType"));
			flgValid = false;
		}
		
		if(getSemmsi004tab3Bean().getSiteDepositNormal().getDepositAmt() == null){
			addMessageError("W0001", msg("message.depositAmt"));
			flgValid = false;
		}
		
		return flgValid;
	}

	private boolean doClearDepositNormal() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
		semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType("01"); // Normal
		semmsi004tab3Bean.getSiteDepositNormal().setDepositType("02"); // default Cash
		semmsi004tab3Bean.setRenderedDeposiNormalVatType(true); // show vat Adding by John
		semmsi004tab3Bean.getSiteDepositNormal().setVatType("01"); // set default value
		semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(null);
		semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
		semmsi004tab3Bean.setDisabledBtnUpdateDepositNormal(true);
		semmsi004tab3Bean.setDisabledBtnAddDepositNormal(false);
		semmsi004tab3Bean.setDisabledOldInsurance(false);
		this.doRenderDeptBgCash();
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
		return flag;
	}

	private boolean initUpdateDepositNormal() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		
		try{
			log.debug("rowId : "+rowId);
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Deposit deposit = service.queryDepositByRowId(rowId);
			if(deposit != null){
				if(StringUtils.isEmpty(deposit.getVatType())){
					deposit.setVatType("04");
				}
				
				semmsi004tab3Bean.setSiteDepositNormal(deposit);
					semmsi004tab3Bean.setDisabledBtnAddDepositNormal(true);
					semmsi004tab3Bean.setDisabledBtnUpdateDepositNormal(false);
					// cash
					if(deposit.getDepositType().equals("02")){
//						if(semmsi004tab3Bean.getSiteDepositNormal().getExpenseType().equals("04")){
//							semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
//						}else{
							semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
//						}
					}else{
						semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
					}
					this.doEditRentalDeposit();
//					semmsi004tab3Bean.setDisabledOldInsurance(true);
					semmsi004tab3Bean.setDisabledBtnAddDepositNormal(true);
					semmsi004tab3Bean.setDisabledBtnUpdateDepositNormal(false);
					
					setSemmsi004tab3Bean(semmsi004tab3Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	private boolean doDeleteDepositNormal() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		try{
			String siteInfoId = semmsi004tab3Bean.getSiteInfoId();
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			semmsi004tab3Bean.getSiteDepositNormal().setCurrentUser(semmsi004tab3Bean.getUserLogin());
			service.deleteDeposit(semmsi004tab3Bean.getSiteDepositNormal());
			
			semmsi004tab3Bean.setDepositRentBgSPList(null);
			this.semmsi004SearchDepositRentBG(siteInfoId);
			semmsi004tab3Bean.setDepositRentCashSPList(null);
			this.semmsi004SearchDepositRentCash(siteInfoId);
			addMessageInfo("M0002");
//			getSemmsi004tab1Action().searchSumDepositRent(siteInfoId);
			this.updateSiteInfoDepositRentEditFlag();
			// get sum deposit rent for update table site rent
			getSemmsi004tab1Action().searchSumDepositRent(siteInfoId);
			this.updateTotalDeposit();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("3-1");
			//call store
			callMsi004GenDPST(semmsi004tab3Bean.getSiteDepositNormal().getRowId(), EQueryName.SP_MSI004_GEN_DPST_R_DEL.name);
			
			this.semmsi004SearchDepositRentBG(siteInfoId);
			this.semmsi004SearchDepositRentCash(siteInfoId);
			// disabled checkbox no deposit
			if((semmsi004tab3Bean.getDepositRentBgSPList() != null && !semmsi004tab3Bean.getDepositRentBgSPList().isEmpty()) ||
			   (semmsi004tab3Bean.getDepositRentCashSPList() != null && !semmsi004tab3Bean.getDepositRentCashSPList().isEmpty())){
				semmsi004tab3Bean.setDisabledChkNoDeposit(true);
			}else{
				semmsi004tab3Bean.setDisabledChkNoDeposit(false);
			}
			this.doClearDepositNormal();
			
		}catch(Exception e){
			log.error(e);
			addMessageError("E0002");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(false);
		semmsi004tab3Bean.setRenderedMsgFormBottom(true);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private boolean initDeleteDepositNormal() {
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			semmsi004tab3Bean.setSiteDepositNormal(service.queryDepositByRowId(rowId));
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}catch(Exception e){
			log.error(e);
		}
		return flag;
	}


	private boolean doUpdateDepositNormal() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateDepositNormal()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab3Bean.setRenderedMsgFormTop(false);
			semmsi004tab3Bean.setRenderedMsgFormBottom(true);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			return flag;
		}
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			semmsi004tab3Bean.getSiteDepositNormal().setCurrentUser(semmsi004tab3Bean.getUserLogin());
			if(semmsi004tab3Bean.getSiteDepositNormal().getExpenseType().equals("04")){
//				semmsi004tab3Bean.getSiteDepositNormal().setVatType(null);
			}
			//clear deposit to null when select deposite type to BG.
			if(StringUtils.equals(semmsi004tab3Bean.getSiteDepositNormal().getDepositType(), "01")){
				semmsi004tab3Bean.getSiteDepositNormal().setVatType("04");
			}
			//Adding by JOHN 31/05/2011
			boolean chkNewStatus = semmsi004tab3Bean.getSiteDepositNormal().isChkNewStatus();
			if(chkNewStatus)
			semmsi004tab3Bean.getSiteDepositNormal().setNewStatus("N");
			else
			semmsi004tab3Bean.getSiteDepositNormal().setNewStatus("Y");
			
			this.doSetRentDepositChk();
			
			// update
			service.updateDeposit(semmsi004tab3Bean.getSiteDepositNormal());
			semmsi004tab3Bean.setDepositRentBgSPList(null);
			// search BG,Cash
			this.semmsi004SearchDepositRentBG(semmsi004tab3Bean.getSiteInfoId());
			semmsi004tab3Bean.setDepositRentCashSPList(null);
			this.semmsi004SearchDepositRentCash(semmsi004tab3Bean.getSiteInfoId());
			addMessageInfo("M0001");
			this.doClearDepositNormal();
			semmsi004tab3Bean.setDisabledBtnAddDepositNormal(false);
			semmsi004tab3Bean.setDisabledBtnUpdateDepositNormal(true);
			getSemmsi004tab1Action().searchSumDepositRent(semmsi004tab3Bean.getSiteInfoId());
			// get sum deposit rent for update table site rent
			getSemmsi004tab1Action().searchSumDepositRent(semmsi004tab3Bean.getSiteInfoId());
			this.updateTotalDeposit();
			
			this.doClearDepositNormal();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo("3-1");
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(false);
		semmsi004tab3Bean.setRenderedMsgFormBottom(true);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
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


	private boolean doClearRentCond() {
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
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
		
		
		// add 13/02/2023
		   if (StringUtils.equals("03", semmsi004tab3Bean.getRentCondNormal().getExpenseType())) {
			   semmsi004tab3Bean.setDisabledExpenseDesc(false);
		   }else {
			   semmsi004tab3Bean.setDisabledExpenseDesc(true);
			   semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
		   }
		
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private boolean doAddRentCond() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateRentCond()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab3Bean.setRenderedMsgFormTop(true);
			semmsi004tab3Bean.setRenderedMsgFormBottom(false);
			semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
			semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			return flag;
		}
			
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			String rentCondType = semmsi004tab3Bean.getRentCondNormal().getRentCondType();
			String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
			// check and delete rentCond special before insert rentCond normal
//				this.deleteRentCondSpecial(siteInfoId);
			
			// update rent
			this.updateSiteRent(ELovVal.V_CT_RENT.name, rentCondType);
			// set PayPeriodType
			this.setPayPeriodType();
			semmsi004tab3Bean.getRentCondNormal().setSiteInfoId(siteInfoId);
			semmsi004tab3Bean.getRentCondNormal().setCurrentUser(semmsi004tab3Bean.getUserLogin());
			semmsi004tab3Bean.getRentCondNormal().setSeqNo(this.getRentCondSeqNo(siteInfoId));
			if(semmsi004tab3Bean.getRentCondNormal().getExpenseType().equals("01")){
//				semmsi004tab3Bean.getRentCondNormal().setVatType(null);
			}
			// check effDate (new/renew) = null
			String reqType = getSemmsi004Bean().getReqTypeParam();
			if(reqType != null && (reqType.equals("01") || reqType.equals("02"))){
				semmsi004tab3Bean.getRentCondNormal().setEffectiveDt(null);
			}
			if(semmsi004tab3Bean.isChkOverFlag()){
				semmsi004tab3Bean.getRentCondNormal().setOverFlag("Y");
			}else{
				semmsi004tab3Bean.getRentCondNormal().setOverFlag(null);
			}
			
			//add  14/03/2023
			semmsi004tab3Bean.getRentCondNormal().setServiceId(
					semmsi004tab3Bean.getRentCondNormal().getServiceId()==null?"ALL":semmsi004tab3Bean.getRentCondNormal().getServiceId()
							);
			
			// insert new data
			service.createSiteRentCond(semmsi004tab3Bean.getRentCondNormal());
			addMessageInfo("M0001");
			semmsi004tab3Bean.setRentCondSPList(null);
			this.semmsi004SearchRentCond(siteInfoId, rentCondType);
			this.doClearRentCond();
			this.updateSiteInfoRentEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
			// get sum rent for update table site rent
			getSemmsi004tab1Action().searchSumRent(siteInfoId);
			this.updateTotalRent();
			
			//add 15/03/2023
			doGetSiteAppRentServSrch();
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(true);
		semmsi004tab3Bean.setRenderedMsgFormBottom(false);
		semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private void updateSiteInfoRentEditFlag() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String siteInfoId = semmsi004tab3Bean.getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab3Bean.getUserLogin());
				siteInfo.setRentEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void updateSiteInfoDepositRentEditFlag() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String siteInfoId = semmsi004tab3Bean.getSiteInfoId();
		try{
			ISiteInfoService siteInfoService = (ISiteInfoService)getBean("siteInfoService");
			SiteInfo siteInfo = siteInfoService.querySiteInfoByRowId(siteInfoId);
			if(siteInfo != null){
				siteInfo.setCurrentUser(semmsi004tab3Bean.getUserLogin());
				siteInfo.setDepositRentEditFlag("Y");
				siteInfoService.updateSiteInfo(siteInfo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void deleteRentCondNormal(String siteInfoId) {
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			List<RentCond> listNormal = null;
			listNormal = service.queryRentCondBySiteInfoIdAndRentCondType(siteInfoId, "01");
			if(listNormal != null && listNormal.size() > 0){
				for(RentCond rentCond : listNormal){
					service.deleteRentCond(rentCond);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	private void deleteRentCondSpecial(String siteInfoId) {
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			List<RentCond> listSpecial = null;
			listSpecial = service.queryRentCondBySiteInfoIdAndRentCondType(siteInfoId, "02");
			if(listSpecial != null && listSpecial.size() > 0){
				for(RentCond rentCond : listSpecial){
					service.deleteRentCond(rentCond);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void setPayPeriodType() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.getPayPeriodType01() != null && !semmsi004tab3Bean.getPayPeriodType01().equals("")){
			semmsi004tab3Bean.getRentCondNormal().setPayPeriod(null);
			semmsi004tab3Bean.getRentCondNormal().setPayPeriodType(semmsi004tab3Bean.getPayPeriodType01());
		}
		if(semmsi004tab3Bean.getPayPeriodType02() != null && !semmsi004tab3Bean.getPayPeriodType02().equals("")){
			semmsi004tab3Bean.getRentCondNormal().setPayPeriod(null);
			semmsi004tab3Bean.getRentCondNormal().setPayPeriodType(semmsi004tab3Bean.getPayPeriodType02());
		}
		if(semmsi004tab3Bean.getPayPeriodType03() != null && !semmsi004tab3Bean.getPayPeriodType03().equals("")){
			semmsi004tab3Bean.getRentCondNormal().setPayPeriod(semmsi004tab3Bean.getPayPeriod03());
			semmsi004tab3Bean.getRentCondNormal().setPayPeriodType(semmsi004tab3Bean.getPayPeriodType03());
		}
		if(semmsi004tab3Bean.getPayPeriodType04() != null && !semmsi004tab3Bean.getPayPeriodType04().equals("")){
			semmsi004tab3Bean.getRentCondNormal().setPayPeriod(semmsi004tab3Bean.getPayPeriod04());
			semmsi004tab3Bean.getRentCondNormal().setPayPeriodType(semmsi004tab3Bean.getPayPeriodType04());
		}
		if(semmsi004tab3Bean.getPayPeriodType05() != null && !semmsi004tab3Bean.getPayPeriodType05().equals("")){
			semmsi004tab3Bean.getRentCondNormal().setPayPeriod(null);
			semmsi004tab3Bean.getRentCondNormal().setPayPeriodType(semmsi004tab3Bean.getPayPeriodType05());
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private Integer getRentCondSeqNo(String siteInfoId) {
		Integer seqNo = 0;
		List<Msi004SeqRentCondSP> to = null;
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			Msi004SeqRentCondSP criteria = new Msi004SeqRentCondSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_SEQ_RENT_COND.name, criteria);
			if(to != null && to.size() > 0){
				seqNo = Integer.parseInt(to.get(0).getSeqNo());
				log.debug("seqNo rent cond [" + seqNo + "]");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return seqNo;
	}

	private boolean validateRentCond() {
		log.info("==== validateRentCond ====");
		boolean flgValid = true;
		if(StringUtils.isEmpty(getSemmsi004tab3Bean().getRentCondNormal().getExpenseType())){
			addMessageError("W0001", msg("message.rentCondExpenseType"));
			flgValid = false;
		}
				
//		if(getSemmsi004tab3Bean().getRentCondNormal().getRentAmt() == null){
//			addMessageError("W0001", msg("message.rentAmt"));
//			flgValid = false;
//		}
		if(getSemmsi004tab3Bean().getRentCondNormal().getRentAmt() != null && 
				getSemmsi004tab3Bean().getRentCondNormal().getRentAmt() > 0){
			if(StringUtils.isEmpty(getSemmsi004tab3Bean().getRentCondNormal().getRentPeriodType())){
				addMessageError("W0001", msg("message.rentAmtPeriodType"));
				flgValid = false;
			}
		}
		
		//effDate Date must between contractEffDate and contractExpDate
		String reqType = getSemmsi004Bean().getReqTypeParam();
		if(reqType != null && (!reqType.equals("01") && !reqType.equals("02"))){
			Date effDate = getSemmsi004tab3Bean().getRentCondNormal().getEffectiveDt();
			Date contractEffDate = getSemmsi004tab2Bean().getSiteContract().getEffectiveDt();
			Date contractExpDate = getSemmsi004tab2Bean().getSiteContract().getExpireDt();
			if(effDate != null ){
				log.info("effDate :" + effDate);
				log.info("contractEffDate :" + contractEffDate);
				log.info("contractExpDate :" + contractExpDate);
				
				if(contractEffDate != null && effDate.before(contractEffDate)){
					addMessageErrorWithArgument("W0047" ,msg("export.col.estmDt"), msg("message.contractEffDate"), msg("message.contractExpDate"));
					flgValid = false;
				}
				if(contractExpDate != null && effDate.after(contractExpDate)){
					addMessageErrorWithArgument("W0047" ,msg("export.col.estmDt"), msg("message.contractEffDate"), msg("message.contractExpDate"));
					flgValid = false;
				}
			}else{
				addMessageError("W0001", msg("export.col.estmDt"));
				flgValid = false;
			}
		}
		
		// add logic on 14/03/2023
		if(StringUtils.equals("03", semmsi004tab3Bean.getRentCondNormal().getExpenseType()) ){
			
			if (StringUtils.isEmpty(semmsi004tab3Bean.getRentCondNormal().getExpenseDesc())){
			    addMessageError("W0001",msg("msg.error.expenseDesc"));
			    flgValid = false;
			  
			}
			else if (semmsi004tab3Bean.getRentCondNormal().getExpenseDesc().length()>=100) {
				addMessageError("W0001",msg("msg.error.expenseDesc.Length"));
				flgValid = false;
				
			}
			
		
		}else semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
		
		return flgValid;
	}

	private boolean doUpdateRentCond() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		if(!validateRentCond()){
			semmsi004tab1Bean.setRenderedMsgFormSearch(false);
			semmsi004tab3Bean.setRenderedMsgFormTop(true);
			semmsi004tab3Bean.setRenderedMsgFormBottom(false);
			semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
			semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
			setSemmsi004tab1Bean(semmsi004tab1Bean);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			return flag;
		}
		try{
			String siteInfoId = semmsi004tab3Bean.getSiteInfoId();
			// update rent cond
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			semmsi004tab3Bean.getRentCondNormal().setCurrentUser(semmsi004tab3Bean.getUserLogin());
			if(semmsi004tab3Bean.getRentCondNormal().getExpenseType().equals("01")){
//				semmsi004tab3Bean.getRentCondNormal().setVatType(null);
			}
			// check effDate (new/renew) = null
			String reqType = getSemmsi004Bean().getReqTypeParam();
			if(reqType != null && (reqType.equals("01") || reqType.equals("02"))){
				semmsi004tab3Bean.getRentCondNormal().setEffectiveDt(null);
			}
			if(semmsi004tab3Bean.isChkOverFlag()){
				semmsi004tab3Bean.getRentCondNormal().setOverFlag("Y");
			}else{
				semmsi004tab3Bean.getRentCondNormal().setOverFlag(null);
			}
			// set PayPeriodType
			this.setPayPeriodType();
			// update RentCond
			log.debug("semmsi004tab3Bean.getRentCondNormal().getRowId() = "+semmsi004tab3Bean.getRentCondNormal().getRowId());
			log.debug("semmsi004tab3Bean.getRentCondNormal().getVersion() = "+semmsi004tab3Bean.getRentCondNormal().getVersion());
			log.debug("semmsi004tab3Bean.getRentCondNormal().getRentCondType() = "+semmsi004tab3Bean.getRentCondNormal().getRentCondType());
			service.updateRentCond(semmsi004tab3Bean.getRentCondNormal());
			addMessageInfo("M0001");
			this.doClearRentCond();
			semmsi004tab3Bean.setRentCondSPList(null);
			this.semmsi004SearchRentCond(siteInfoId, semmsi004tab3Bean.getRentCondNormal().getRentCondType());
			semmsi004tab3Bean.setDisabledBtnAddRentCond(false);
			semmsi004tab3Bean.setDisabledBtnUpdateRentCond(true);
			semmsi004tab3Bean.setDisabledPeriodType(false);
			this.updateSiteInfoRentEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
			// get sum rent for update table site rent
			getSemmsi004tab1Action().searchSumRent(siteInfoId);
			this.updateTotalRent();
			
			//add 15/03/2023
			doGetSiteAppRentServSrch();
			
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(true);
		semmsi004tab3Bean.setRenderedMsgFormBottom(false);
		semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
		semmsi004tab3Bean.setRenderedRentOldAmt(false);
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private boolean initUpdateRentCond() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			log.debug("rowId : "+rowId);
			RentCond rentCond = service.queryRentCondByRowId(rowId);
			log.debug("rentCond.getRowId() : "+rentCond.getRowId());
			if(rentCond != null){
				
				semmsi004tab3Bean.setRentCondNormal(rentCond);
				if(StringUtils.isEmpty(rentCond.getVatType())){
					rentCond.setVatType("04");
				}
				
				if(rentCond.getPayPeriodType() != null && rentCond.getPayPeriodType().equals("01")){
					semmsi004tab3Bean.setPayPeriodType01(rentCond.getPayPeriodType());
					semmsi004tab3Bean.setPayPeriodType02(null);
					semmsi004tab3Bean.setPayPeriodType03(null);
					semmsi004tab3Bean.setPayPeriodType04(null);
					semmsi004tab3Bean.setPayPeriodType05(null);
					semmsi004tab3Bean.setPayPeriod03(null);
					semmsi004tab3Bean.setPayPeriod04(null);
					semmsi004tab3Bean.setDisabledPayPeriod03(true);
					semmsi004tab3Bean.setDisabledPayPeriod04(true);
					
				}
				if(rentCond.getPayPeriodType() != null && rentCond.getPayPeriodType().equals("02")){
					semmsi004tab3Bean.setPayPeriodType02(rentCond.getPayPeriodType());
					semmsi004tab3Bean.setPayPeriodType01(null);
					semmsi004tab3Bean.setPayPeriodType03(null);
					semmsi004tab3Bean.setPayPeriodType04(null);
					semmsi004tab3Bean.setPayPeriodType05(null);
					semmsi004tab3Bean.setPayPeriod03(null);
					semmsi004tab3Bean.setPayPeriod04(null);
					semmsi004tab3Bean.setDisabledPayPeriod03(true);
					semmsi004tab3Bean.setDisabledPayPeriod04(true);
				}
				if(rentCond.getPayPeriodType() != null && rentCond.getPayPeriodType().equals("03")){
					semmsi004tab3Bean.setPayPeriod03(rentCond.getPayPeriod());
					semmsi004tab3Bean.setPayPeriodType03(rentCond.getPayPeriodType());
					semmsi004tab3Bean.setPayPeriodType01(null);
					semmsi004tab3Bean.setPayPeriodType02(null);
					semmsi004tab3Bean.setPayPeriodType04(null);
					semmsi004tab3Bean.setPayPeriodType05(null);
					semmsi004tab3Bean.setPayPeriod04(null);
					semmsi004tab3Bean.setDisabledPayPeriod03(false);
					semmsi004tab3Bean.setDisabledPayPeriod04(true);
				}
				if(rentCond.getPayPeriodType() != null && rentCond.getPayPeriodType().equals("04")){
					semmsi004tab3Bean.setPayPeriod04(rentCond.getPayPeriod());
					semmsi004tab3Bean.setPayPeriodType04(rentCond.getPayPeriodType());
					semmsi004tab3Bean.setPayPeriodType01(null);
					semmsi004tab3Bean.setPayPeriodType02(null);
					semmsi004tab3Bean.setPayPeriodType03(null);
					semmsi004tab3Bean.setPayPeriodType05(null);
					semmsi004tab3Bean.setPayPeriod03(null);
					semmsi004tab3Bean.setDisabledPayPeriod03(true);
					semmsi004tab3Bean.setDisabledPayPeriod04(false);
				}
				if(rentCond.getPayPeriodType() != null && rentCond.getPayPeriodType().equals("05")){
					semmsi004tab3Bean.setPayPeriodType05(rentCond.getPayPeriodType());
					semmsi004tab3Bean.setPayPeriodType01(null);
					semmsi004tab3Bean.setPayPeriodType02(null);
					semmsi004tab3Bean.setPayPeriodType03(null);
					semmsi004tab3Bean.setPayPeriodType04(null);
					semmsi004tab3Bean.setPayPeriod03(null);
					semmsi004tab3Bean.setPayPeriod04(null);
					semmsi004tab3Bean.setDisabledPayPeriod03(true);
					semmsi004tab3Bean.setDisabledPayPeriod04(true);
				}
				if(rentCond.getExpenseType() != null && rentCond.getExpenseType().equals("02")){
					semmsi004tab3Bean.setRenderedNormalVatType(true);
				}else{
					semmsi004tab3Bean.setRenderedNormalVatType(false);
				}
				if(rentCond.getWhtType() != null && !rentCond.getWhtType().equals("03")){
					semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
				}else{
					semmsi004tab3Bean.setDisabledChkWhtRateNormal(true);
				}
				if(rentCond.getOverFlag() != null && rentCond.getOverFlag().equals("Y")){
					semmsi004tab3Bean.setChkOverFlag(true);
				}else{
					semmsi004tab3Bean.setChkOverFlag(false);
				}
				semmsi004tab3Bean.getRentCondNormal().setRentCondType("01");
				semmsi004tab3Bean.setDisabledBtnAddRentCond(true);
				semmsi004tab3Bean.setDisabledBtnUpdateRentCond(false);
				semmsi004tab3Bean.setRentCondNormal(rentCond);
				semmsi004tab3Bean.setDisabledPeriodType(true);
				semmsi004tab3Bean.setDisabledWhtRateNormal(true);
				semmsi004tab3Bean.setDisabledRent(false);
				semmsi004tab3Bean.setDisabledRentSetup(false);
				if(rentCond.getRentOldAmt() != null){
					semmsi004tab3Bean.setRenderedRentOldAmt(true);
					semmsi004tab3Bean.setDisabledRentOldAmt(true);
				}else{
					semmsi004tab3Bean.setRenderedRentOldAmt(false);
				}
				
				
				// add 13/02/2023
			   if (StringUtils.equals("03", rentCond.getExpenseType())) {
				   semmsi004tab3Bean.setDisabledExpenseDesc(false);
			   }else {
				   semmsi004tab3Bean.setDisabledExpenseDesc(true);
				   semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
			   }
			   
				
				setSemmsi004tab3Bean(semmsi004tab3Bean);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	private boolean doDeleteRentCond() {
		boolean flag = false;
		initDeleteRentCond();
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab1Bean = getSemmsi004tab1Bean();
		String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			semmsi004tab3Bean.getRentCondNormal().setCurrentUser(semmsi004tab3Bean.getUserLogin());
			service.deleteRentCond(semmsi004tab3Bean.getRentCondNormal());
			this.doClearRentCond();
			semmsi004tab3Bean.setRentCondSPList(null);
			//this.semmsi004SearchRentCond(semmsi004tab3Bean.getSiteInfoId(), semmsi004tab3Bean.getRentCondNormal().getRentCondType());
			this.semmsi004SearchRentCond(siteInfoId, semmsi004tab3Bean.getRentCondNormal().getRentCondType());
			addMessageInfo("M0002");
			this.updateSiteInfoRentEditFlag();
			// approve siteInfoId
			getSemmsi004Action().approveSiteInfo(getSemmsi004Bean().getTabNo());
			// get sum rent for update table site rent
			//getSemmsi004tab1Action().searchSumRent(semmsi004tab3Bean.getSiteInfoId());		
			getSemmsi004tab1Action().searchSumRent(siteInfoId);
			this.updateTotalRent();
			
			//add 15/03/2023
			doGetSiteAppRentServSrch();
			
		}catch(Exception e){
			log.error(e);
			addMessageError("E0002");
		}
		semmsi004tab1Bean.setRenderedMsgFormSearch(false);
		semmsi004tab3Bean.setRenderedMsgFormTop(true);
		semmsi004tab3Bean.setRenderedMsgFormMiddle(false);
		semmsi004tab3Bean.setRenderedMsgFormBottom(false);
		semmsi004tab3Bean.setRenderedMsgSumDeposit(false);
				
		setSemmsi004tab1Bean(semmsi004tab1Bean);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private boolean initDeleteRentCond() {
		boolean flag = false;
		String rowId = (String)getFacesUtils().getRequestParameter("rowId");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			semmsi004tab3Bean.setRentCondNormal(service.queryRentCondByRowId(rowId));
		}catch(Exception e){
			log.error(e);
		}
		return flag;
	}

	public void initTab3(String siteInfoId){
		init();
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		semmsi004tab3Bean.setSiteInfoId(siteInfoId);
		System.out.println("1semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType() == "+semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType());
		try{
			// search rent
			getSemmsi004Action().getSiteRentBySiteInfoId(siteInfoId);
			Rent rent = getSemmsi004Bean().getSiteRent();
			// render oldAmt and effDate
			String reqType = getSemmsi004Bean().getReqTypeParam();
			if(reqType != null ){
				semmsi004tab3Bean.setRenderedRentOldAmt(false);
				if(reqType.equals("01")){
					semmsi004tab3Bean.setRenderedEffDate(false);
				}else{
					if(reqType.equals("02")){
						semmsi004tab3Bean.setRenderedEffDate(false);
					}else{
						semmsi004tab3Bean.setRenderedEffDate(true);
					}
				}
			}
			
			semmsi004tab3Bean.setDisabledPeriodType(false);
			if(rent != null){
				// check rentCondType
				if(rent.getRentCondType() != null && (rent.getRentCondType().equals("01") || rent.getRentCondType().equals("02"))){
					semmsi004tab3Bean.setRenderDataTableRentCond(true);
					semmsi004tab3Bean.setRenderConditionNormal(true);
//					semmsi004tab3Bean.setRenderConditionSpecial(false);
					semmsi004tab3Bean.setDisabledWhtRateNormal(true);
					semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
					semmsi004tab3Bean.setChkWhtRateNormal(false);
					semmsi004tab3Bean.setRenderedNormalVatType(true);
					semmsi004tab3Bean.getRentCondNormal().setRentCondType(rent.getRentCondType());
					
					semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
					semmsi004tab3Bean.getSiteDepositNormal().setDepositType("02");
					this.doClearRentCond();
					// search rent cond
					this.semmsi004SearchRentCond(siteInfoId, rent.getRentCondType());
					// search rent cond Existing
					this.semmsi004SearchRentCondExt(siteInfoId);
					// get vat rate
					this.getVatRate();
//				}else if(rent.getRentCondType() != null &&  rent.getRentCondType().equals("02") ){
//					semmsi004tab3Bean.setRenderDataTableRentCond(false);
					semmsi004tab3Bean.setRenderConditionSpecial(true);
//					semmsi004tab3Bean.setRenderConditionNormal(false);
					semmsi004tab3Bean.setDisabledWhtRateRentSpecial(true);
					semmsi004tab3Bean.setChkWhtRateRentSpecial(false);
					semmsi004tab3Bean.setDisabledWhtRateRentSetupSpecial(true);
					semmsi004tab3Bean.setChkWhtRateRentSetupSpecial(false);
					semmsi004tab3Bean.setDisabledWhtRateServiceSpecial(true);
					semmsi004tab3Bean.setChkWhtRateServiceSpecial(false);
					semmsi004tab3Bean.setDisabledWhtRateServiceOtherSpecial(true);
					semmsi004tab3Bean.setChkWhtRateServiceOtherSpecial(false);
					semmsi004tab3Bean.setDisabledWhtRateSupportSpecial(true);
					semmsi004tab3Bean.setChkWhtRateSupportSpecial(false);
					this.setRentCondSpecial(siteInfoId, rent.getRentCondType());
					semmsi004tab3Bean.getRentCondNormal().setRentCondType(rent.getRentCondType());
					semmsi004tab3Bean.setExpenseTypeDepositRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null));
				}else{
					// default rentCond normal
					semmsi004tab3Bean.setRenderDataTableRentCond(true);
					semmsi004tab3Bean.setRenderConditionNormal(true);
//					semmsi004tab3Bean.setRenderConditionSpecial(false);
//					semmsi004tab3Bean.setDisabledWhtRateNormal(false);
//					semmsi004tab3Bean.setChkWhtRateNormal(false);
					semmsi004tab3Bean.setRenderConditionSpecial(true);
					semmsi004tab3Bean.setDisabledWhtRateNormal(true);
					semmsi004tab3Bean.setChkWhtRateNormal(true);
					semmsi004tab3Bean.setRenderedNormalVatType(true);
					semmsi004tab3Bean.setDisabledPayPeriod03(true);
					semmsi004tab3Bean.setDisabledPayPeriod04(true);
					semmsi004tab3Bean.getRentCondNormal().setRentCondType("01");
//					semmsi004tab3Bean.setDisabledChkNoRent(false);
					semmsi004tab3Bean.setDisabledChkNoRent(true);
					this.doClearRentCond();
					
				}
				// check DepositCondType
				if(rent.getDepositCondType() != null && (rent.getDepositCondType().equals("01") || rent.getDepositCondType().equals("02"))){
					semmsi004tab3Bean.setRenderDepositRentNormal(true);
//					semmsi004tab3Bean.setRenderDepositRentSpecial(false);
					semmsi004tab3Bean.setRenderDataTableDeposit(true);
					semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(null);
					semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType(rent.getDepositCondType());
					this.defaultRadioDepositNormal();
					this.semmsi004SearchDepositRentBG(siteInfoId);
					this.semmsi004SearchDepositRentCash(siteInfoId);
					getSemmsi004tab1Action().searchSumDepositRent(siteInfoId);
					// disabled checkbox no deposit
					if((semmsi004tab3Bean.getDepositRentBgSPList() != null && !semmsi004tab3Bean.getDepositRentBgSPList().isEmpty()) ||
					   (semmsi004tab3Bean.getDepositRentCashSPList() != null && !semmsi004tab3Bean.getDepositRentCashSPList().isEmpty())){
						semmsi004tab3Bean.setDisabledChkNoDeposit(true);
					}else{
						semmsi004tab3Bean.setDisabledChkNoDeposit(false);
					}
//				}else if(rent.getDepositCondType() != null && rent.getDepositCondType().equals("02")){
//					semmsi004tab3Bean.setRenderDepositRentNormal(false);
					semmsi004tab3Bean.setRenderDepositRentSpecial(true);
//					semmsi004tab3Bean.setRenderDataTableDeposit(false);
					semmsi004tab3Bean.setRenderedDepositSpecialVatType(true);
					semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType(rent.getDepositCondType());
					this.setDepositSpecial(siteInfoId, null, rent.getDepositCondType());
					System.out.println("2semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType() == "+semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType());
				}else{
					// default deposit normal
					semmsi004tab3Bean.setRenderDepositRentNormal(true);
//					semmsi004tab3Bean.setRenderDepositRentSpecial(false);
					semmsi004tab3Bean.setRenderDepositRentSpecial(true);
					semmsi004tab3Bean.setRenderDataTableDeposit(true);
//					semmsi004tab3Bean.setDisabledBtnAddDepositNormal(false);
					semmsi004tab3Bean.setDisabledBtnAddDepositNormal(true);
					semmsi004tab3Bean.setDisabledBtnUpdateRentCond(true);
					semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(null);
					semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType("01");
//					semmsi004tab3Bean.setDisabledChkNoDeposit(false);
					semmsi004tab3Bean.setDisabledChkNoDeposit(true);
					this.defaultRadioDepositNormal();
				}
				
				// check no rent
				if(rent.getNoRent() != null && rent.getNoRent().equals("Y")){
					log.debug("rent.getNoRent() = "+rent.getNoRent());
					semmsi004tab3Bean.setChkNoRent(true);
					semmsi004tab3Bean.setRenderedNoRent(false);
					semmsi004tab3Bean.setRenderDataTableRentCond(false);
					
					//rental deposit
					semmsi004tab3Bean.setChkNoRentDeposit(true);
					semmsi004tab3Bean.setRenderedNoRentDeposit(false);
					
				}else{
					semmsi004tab3Bean.setChkNoRent(false);
					semmsi004tab3Bean.setRenderedNoRent(true);
					if(rent.getRentCondType() != null && rent.getRentCondType().equals("01")){
						semmsi004tab3Bean.setRenderDataTableRentCond(true);
					}
					
					//rental deposit
					if(rent.getNoDeposit() != null && rent.getNoDeposit().equals("Y")){
						semmsi004tab3Bean.setChkNoRentDeposit(true);
						semmsi004tab3Bean.setRenderedNoRentDeposit(false);
					}else{
						semmsi004tab3Bean.setChkNoRentDeposit(false);
						semmsi004tab3Bean.setRenderedNoRentDeposit(true);
					}
				}
				// check no deposit
//				if(rent.getNoDeposit() != null && rent.getNoDeposit().equals("Y")){
//					semmsi004tab3Bean.setChkNoRentDeposit(true);
//					semmsi004tab3Bean.setRenderedNoRentDeposit(false);
//				}else{
//					semmsi004tab3Bean.setChkNoRentDeposit(false);
//					semmsi004tab3Bean.setRenderedNoRentDeposit(true);
//				}
				
				// check fix 5 percent
//				if(rent.getFix5Percent() != null && rent.getFix5Percent().equals("Y")){
//					semmsi004tab3Bean.setFix5Percent(true);
////					semmsi004tab3Bean.setRenderedNoRentDeposit(false);
//				}else{
//					semmsi004tab3Bean.setFix5Percent(false);
////					semmsi004tab3Bean.setRenderedNoRentDeposit(true);
//				}
				
				// check mode
//				this.checkMode();
				
				// TOTAL RENT
				semmsi004tab3Bean.setTotalRent(rent);
				// TOTAL DEPOSIT
				semmsi004tab3Bean.setTotalDeposit(rent);
			}else{
				// TOTAL RENT
				semmsi004tab3Bean.setTotalRent(new Rent());
				// TOTAL DEPOSIT
				semmsi004tab3Bean.setTotalDeposit(new Rent());
			}
			
			//set default rent PeriodStartDt
			if(semmsi004tab2Bean.getSiteContract().getEffectiveDt() != null)
				semmsi004tab3Bean.getRentCondNormal().setPeriodStartDt(semmsi004tab2Bean.getSiteContract().getEffectiveDt());
			
			//set default rent setPeriodEndDt
			if(semmsi004tab2Bean.getSiteContract().getExpireDt() != null)
				semmsi004tab3Bean.getRentCondNormal().setPeriodEndDt(semmsi004tab2Bean.getSiteContract().getExpireDt());
			
			checkConditionType();
			
			//get rental service
			this.doGetSiteAppRentServSrch();
			
			//get dropdown service
//			this.doGetSiteAppServSelItem(siteInfoId);
			
//			this.doGetSiteAppRentContExisting();
//			this.doGetSiteAppRentCont();
//			log.debug("##### init getSiteAppId : "+semmsi004tab3Bean.getSiteAppRentObjParam().getSiteAppId());
//			this.doGetSiteAppRentServSrch();
//			this.doGetSiteAppRentAmtSrch();
			
//			this.doSiteAppDepositSrch();
			
			// check mode Add 6/12/2012
			this.checkMode();
			
			this.doRenderDeptBgCash();
		
		   // add 14/03/2023
		   if (StringUtils.equals("03", semmsi004tab3Bean.getRentCondNormal().getExpenseType())) {
			   semmsi004tab3Bean.setDisabledExpenseDesc(false);
		   }else {
			   semmsi004tab3Bean.setDisabledExpenseDesc(true);
			   semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
		   }
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("3semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType() == "+semmsi004tab3Bean.getSiteDepositSpecialCash().getVatType());
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}
	
	public void renderTotalRent(){
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(StringUtils.isNotEmpty(semmsi004tab3Bean.getRentCondSpecial1().getDetail())
				||StringUtils.isNotEmpty(semmsi004tab3Bean.getRentCondSpecial2().getDetail()) 
				||StringUtils.isNotEmpty(semmsi004tab3Bean.getRentCondSpecial3().getDetail()) 
				||StringUtils.isNotEmpty(semmsi004tab3Bean.getRentCondSpecial4().getDetail())){
			semmsi004tab3Bean.setDisabledTotalNormalRent(false);
		}else{
			semmsi004tab3Bean.setDisabledTotalNormalRent(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		this.updateTotalRent();
	}
	
	private void checkMode() {
		semmsi004Bean = getSemmsi004Bean();
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			String mode = semmsi004Bean.getMode();
			if(mode != null && mode.equals("EDIT")){
				if(getSemmsi004tab1Bean().getCancelableFlag() != null &&
				   getSemmsi004tab1Bean().getCancelableFlag().equals("N")){
					// check editable rent flag
					this.checkEditableRent();
					if(getSemmsi004tab3Bean().getEditableRentFlag() != null &&
					   getSemmsi004tab3Bean().getEditableRentFlag().equals("Y")){
						semmsi004tab3Bean.setDisabledRent(false);
						semmsi004tab3Bean.setDisabledRentSetup(false);
						semmsi004tab3Bean.setDisabledBtnAddRentCond(false);
						semmsi004tab3Bean.setDisabledPeriodType(false);
						semmsi004tab3Bean.setDisabledRentOldAmt(false);
						// special
//						if(semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("02")){
						if(StringUtils.isNotEmpty(semmsi004tab3Bean.getRentCondSpecial1().getDetail())){
							semmsi004tab3Bean.setDisabledTotalNormalRent(false);
						}else{
							semmsi004tab3Bean.setDisabledTotalNormalRent(true);
						}
					}else{
						semmsi004tab3Bean.setDisabledRent(true);
						semmsi004tab3Bean.setDisabledRentSetup(true);
						semmsi004tab3Bean.setDisabledBtnAddRentCond(true);
						semmsi004tab3Bean.setDisabledPeriodType(true);
						semmsi004tab3Bean.setDisabledTotalNormalRent(true);
						semmsi004tab3Bean.setDisabledRentOldAmt(true);
						semmsi004tab3Bean.setDisabledChkNoRent(true);
					}
					// check editable deposit rent flag
					this.checkEditableDepositRent();
					if(getSemmsi004tab3Bean().getEditableDepositRentFlag() != null &&
					   getSemmsi004tab3Bean().getEditableDepositRentFlag().equals("Y")){
						semmsi004tab3Bean.setDisabledDepositRent(false);
						semmsi004tab3Bean.setDisabledBtnAddDepositNormal(false);
						// special
						if(semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("02")){
							semmsi004tab3Bean.setDisabledTotalNormalDeposit(false);
						}else{
							semmsi004tab3Bean.setDisabledTotalNormalDeposit(true);
						}
					}else{
						semmsi004tab3Bean.setDisabledDepositRent(true);
						semmsi004tab3Bean.setDisabledBtnAddDepositNormal(true);
						semmsi004tab3Bean.setDisabledTotalNormalDeposit(true);
						semmsi004tab3Bean.setDisabledChkNoDeposit(true);
					}
				}
			}else{
				// MODE VIEW
				semmsi004tab3Bean.setDisabledRent(true);
				semmsi004tab3Bean.setDisabledRentSetup(true);
				semmsi004tab3Bean.setDisabledDepositRent(true);
				semmsi004tab3Bean.setDisabledPeriodType(true);
				semmsi004tab3Bean.setDisabledTotalNormalRent(true);
				semmsi004tab3Bean.setDisabledRentOldAmt(true);
				semmsi004tab3Bean.setDisabledChkNoRent(true);
				semmsi004tab3Bean.setDisabledChkNoDeposit(true);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}

	public void checkEditableDepositRent() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004CheckEditDepositRentSP> to = null;
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Msi004CheckEditDepositRentSP criteria = new Msi004CheckEditDepositRentSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_DPST_R.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable deposit rent flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab3Bean.setEditableDepositRentFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	public void checkEditableRent() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004CheckEditRentSP> to = null;
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Msi004CheckEditRentSP criteria = new Msi004CheckEditRentSP();
			criteria.setSiteInfoId(getSemmsi004tab1Bean().getSiteInfo().getRowId());
			to = service.querySPList(EQueryName.SP_MSI004_CHKEDIT_RENT.name, criteria);
			if(to != null && !to.isEmpty()){
				log.debug("editable rent flag [" + to.get(0).getEditableFlag() + "]");
				semmsi004tab3Bean.setEditableRentFlag(to.get(0).getEditableFlag());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private void getVatRate() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
			semmsi004tab3Bean.setColumnVatRate(service.getVatRate());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	
	public boolean calRentAddAmt(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		Double rentAddPercent = semmsi004tab3Bean.getRentCondNormal().getRentAddPercent();
		Double rentOldAmt = semmsi004tab3Bean.getRentCondNormal().getRentOldAmt();
		//added by NEW 20160601
		String rentOldPeriodType = semmsi004tab3Bean.getRentCondNormal().getRentOldPeriodType();
		String rentPeriodType = semmsi004tab3Bean.getRentCondNormal().getRentPeriodType();
		if(rentAddPercent != null && rentOldAmt != null){
			Double rentAdd = rentOldAmt * (rentAddPercent / 100);
			semmsi004tab3Bean.getRentCondNormal().setRentAddAmt(rentAdd);
			semmsi004tab3Bean.getRentCondNormal().setRentAmt(rentOldAmt + rentAdd);
			//added by NEW 20160601
			if(rentPeriodType.equals(rentOldPeriodType)){
//				rentAddAmt = rentAmt - rentOldAmt;
				semmsi004tab3Bean.getRentCondNormal().setRentAmt(rentOldAmt + rentAdd);
			}
			if(rentPeriodType.equals("Y") && rentOldPeriodType.equals("M")){
//				rentAddAmt = (rentAmt/12) - rentOldAmt;
				semmsi004tab3Bean.getRentCondNormal().setRentAmt((rentOldAmt + rentAdd)*12);
			}
			if(rentPeriodType.equals("M") && rentOldPeriodType.equals("Y")){
				semmsi004tab3Bean.getRentCondNormal().setRentAmt((rentOldAmt + rentAdd)/12);
			}
			
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean calTotalAgeServiceAmt(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
			
		Double totalAgeRentAmt = semmsi004tab3Bean.getTotalRent().getTotalAgeRentAmt();
		Double totalAgeServiceAmt = semmsi004tab3Bean.getTotalRent().getTotalAgeServiceAmt();	
		
		//---07/03/2023 add Logic cast amt is null = 0 
		totalAgeRentAmt = totalAgeRentAmt==null?0:totalAgeRentAmt;
		totalAgeServiceAmt = totalAgeServiceAmt==null?0:totalAgeServiceAmt;
		
		//---07/03/2023 new Logic TotalAgeRentServiceAmt = totalAgeRentAmt + totalAgeServiceAmt + totalAgeDonateAmt
		Double totalAgeDonateAmt = semmsi004tab3Bean.getTotalRent().getTotalAgeDonateAmt();
		totalAgeDonateAmt = totalAgeDonateAmt==null?0:totalAgeDonateAmt;
		Double totalAgeRentServiceDonateAmt = totalAgeRentAmt+totalAgeServiceAmt+totalAgeDonateAmt;
		totalAgeRentServiceDonateAmt = totalAgeRentServiceDonateAmt==0?null:totalAgeRentServiceDonateAmt;
		
		/* --- 07/03/2023 remove Logic because not need check null 
		if(totalAgeRentAmt != null && totalAgeServiceAmt != null){
			semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(totalAgeRentAmt + totalAgeServiceAmt);
		}else if(totalAgeRentAmt != null && totalAgeServiceAmt == null){
			semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(totalAgeRentAmt);
		}else if(totalAgeRentAmt == null && totalAgeServiceAmt != null){
			semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(totalAgeServiceAmt);
		}else{
			semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(null);
		}
		*/
		
		//---07/03/2023 new Logic TotalAgeRentServiceAmt
		semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(totalAgeRentServiceDonateAmt);
		
		
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean calRentAmt(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		//Double rentAddPercent = semmsi004tab3Bean.getRentCondNormal().getRentAddPercent();
		Double rentOldAmt = semmsi004tab3Bean.getRentCondNormal().getRentOldAmt();
		Double rentAddAmt = semmsi004tab3Bean.getRentCondNormal().getRentAddAmt();
		//added by NEW 20160601
		String rentOldPeriodType = semmsi004tab3Bean.getRentCondNormal().getRentOldPeriodType();
		String rentPeriodType = semmsi004tab3Bean.getRentCondNormal().getRentPeriodType();
		//Adding by mr.JOhn from SA (Surasit).
		Double newRentAddPercent = (rentAddAmt / rentOldAmt) * 100;
		//Show Rent Percent
		semmsi004tab3Bean.getRentCondNormal().setRentAddPercent(newRentAddPercent);
		//Total Rent Amount
		semmsi004tab3Bean.getRentCondNormal().setRentAmt(rentAddAmt + rentOldAmt); 
		//added by NEW 20160601
		if(rentPeriodType.equals(rentOldPeriodType)){
//			rentAddAmt = rentAmt - rentOldAmt;
			semmsi004tab3Bean.getRentCondNormal().setRentAmt(rentOldAmt + rentAddAmt);
		}
		if(rentPeriodType.equals("Y") && rentOldPeriodType.equals("M")){
//			rentAddAmt = (rentAmt/12) - rentOldAmt;
			semmsi004tab3Bean.getRentCondNormal().setRentAmt((rentOldAmt + rentAddAmt)*12);
		}
		if(rentPeriodType.equals("M") && rentOldPeriodType.equals("Y")){
			semmsi004tab3Bean.getRentCondNormal().setRentAmt((rentOldAmt + rentAddAmt)/12);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean calRentAddPercentAndRentAddAmt(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		Double rentAmt = semmsi004tab3Bean.getRentCondNormal().getRentAmt();
		Double rentOldAmt = semmsi004tab3Bean.getRentCondNormal().getRentOldAmt();
		String rentOldPeriodType = semmsi004tab3Bean.getRentCondNormal().getRentOldPeriodType();
		String rentPeriodType = semmsi004tab3Bean.getRentCondNormal().getRentPeriodType();
		try{
			if(semmsi004tab3Bean.isRenderedRentOldAmt()){
				if(rentOldAmt != null && rentAmt != null){
					Double rentAddAmt = null;
					Double rentAddPercent = null;
					if(rentPeriodType != null && rentOldPeriodType != null){
						if(rentPeriodType.equals(rentOldPeriodType)){
							rentAddAmt = rentAmt - rentOldAmt;
						}
						if(rentPeriodType.equals("Y") && rentOldPeriodType.equals("M")){
							rentAddAmt = (rentAmt/12) - rentOldAmt;
						}
						if(rentPeriodType.equals("M") && rentOldPeriodType.equals("Y")){
							rentAddAmt = (rentAmt*12) - rentOldAmt;
						}
						rentAddPercent = (rentAddAmt / rentOldAmt)* 100;
					}
					
					semmsi004tab3Bean.getRentCondNormal().setRentAddPercent(rentAddPercent);
					semmsi004tab3Bean.getRentCondNormal().setRentAddAmt(rentAddAmt);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean clearWhtRate(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String whtType = semmsi004tab3Bean.getRentCondNormal().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab3Bean.getRentCondNormal().setWhtRate(null);
			semmsi004tab3Bean.setDisabledChkWhtRateNormal(true);
			semmsi004tab3Bean.setDisabledWhtRateNormal(true);
		}else{
			this.renderedNormalVatType();
			semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
		}
		semmsi004tab3Bean.setChkWhtRateNormal(false);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean clearWhtRateRentSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String whtType = semmsi004tab3Bean.getRentCondSpecial1().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab3Bean.getRentCondSpecial1().setWhtRate(null);
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial1(true);
			semmsi004tab3Bean.setDisabledWhtRateRentSpecial(true);
		}else{
			semmsi004tab3Bean.getRentCondSpecial1().setWhtRate(this.getWhtRate("01")); // expenseType = 01 (rent)
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial1(false);
		}
		semmsi004tab3Bean.setChkWhtRateRentSpecial(false);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean clearWhtRateRentSetupSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String whtType = semmsi004tab3Bean.getRentCondSpecial3().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(null);
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial3(true);
			semmsi004tab3Bean.setDisabledWhtRateRentSetupSpecial(true);
		}else{
			semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(this.getWhtRate("02")); // expenseType = 01 (rent)
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial3(false);
		}
		semmsi004tab3Bean.setChkWhtRateRentSetupSpecial(false);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean clearWhtRateServiceSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String whtType = semmsi004tab3Bean.getRentCondSpecial2().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab3Bean.getRentCondSpecial2().setWhtRate(null);
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial2(true);
			semmsi004tab3Bean.setDisabledWhtRateServiceSpecial(true);
		}else{
			semmsi004tab3Bean.getRentCondSpecial2().setWhtRate(this.getWhtRate("02")); // expenseType = 02 (service)
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial2(false);
		}
		semmsi004tab3Bean.setChkWhtRateServiceSpecial(false);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean clearWhtRateServiceOtherSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String whtType = semmsi004tab3Bean.getRentCondSpecial4().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab3Bean.getRentCondSpecial4().setWhtRate(null);
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial4(true);
			semmsi004tab3Bean.setDisabledWhtRateServiceOtherSpecial(true);
		}else{
			semmsi004tab3Bean.getRentCondSpecial4().setWhtRate(this.getWhtRate("02")); // expenseType = 02 (service)
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial4(false);
		}
		semmsi004tab3Bean.setChkWhtRateServiceOtherSpecial(false);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean clearWhtRateSupportSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String whtType = semmsi004tab3Bean.getRentCondSpecial3().getWhtType();
		if(whtType != null && whtType.equals("03")){
			semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(null);
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial3(true);
			semmsi004tab3Bean.setDisabledWhtRateSupportSpecial(true);
		}else{
			semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(this.getWhtRate("02")); 
			semmsi004tab3Bean.setDisabledChkWhtRateSpecial3(false);
		}
		semmsi004tab3Bean.setChkWhtRateSupportSpecial(false);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}

	private void defaultRadioDepositNormal() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.getSiteDepositNormal().setDepositCondType("01");
		semmsi004tab3Bean.getSiteDepositNormal().setDepositType("02");
		semmsi004tab3Bean.getSiteDepositNormal().setVatType("01");
		semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(null);
		semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}


	private void setDepositSpecial(String siteInfoId, String depositType, String depositCondType) {
		this.semmsi004SearchDepositSpecial(siteInfoId, depositType, depositCondType);
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			if(semmsi004tab3Bean.getDepositRentSpecialSPList() != null && 
			   semmsi004tab3Bean.getDepositRentSpecialSPList().size() > 0){
				for(Msi004SrchDepositRentSP depositSpecial : semmsi004tab3Bean.getDepositRentSpecialSPList()){
					if(depositSpecial.getDepositType() != null && depositSpecial.getDepositType().equals("01")){
						semmsi004tab3Bean.getSiteDepositSpecialBg().setRowId(depositSpecial.getRowId());
						semmsi004tab3Bean.getSiteDepositSpecialBg().setSiteInfoId(depositSpecial.getSiteInfoId());
						semmsi004tab3Bean.getSiteDepositSpecialBg().setDepositCondType(depositSpecial.getDepositCondType());
						semmsi004tab3Bean.getSiteDepositSpecialBg().setSeqNo(Integer.parseInt(depositSpecial.getSeqNo()));
						semmsi004tab3Bean.getSiteDepositSpecialBg().setNewStatus(depositSpecial.getNewStatus());
						semmsi004tab3Bean.getSiteDepositSpecialBg().setDepositType(depositSpecial.getDepositType());
						semmsi004tab3Bean.getSiteDepositSpecialBg().setDetail(depositSpecial.getDetail());
					}
					if(depositSpecial.getDepositType() != null && depositSpecial.getDepositType().equals("02")){
						semmsi004tab3Bean.getSiteDepositSpecialCash().setRowId(depositSpecial.getRowId());
						if(depositSpecial.getVatType()!=null){
							semmsi004tab3Bean.getSiteDepositSpecialCash().setVatType(depositSpecial.getVatType());
						}else{
							semmsi004tab3Bean.getSiteDepositSpecialCash().setVatType("04");
						}
						semmsi004tab3Bean.getSiteDepositSpecialCash().setSiteInfoId(depositSpecial.getSiteInfoId());
						semmsi004tab3Bean.getSiteDepositSpecialCash().setDepositCondType(depositSpecial.getDepositCondType());
						semmsi004tab3Bean.getSiteDepositSpecialCash().setSeqNo(Integer.parseInt(depositSpecial.getSeqNo()));
						semmsi004tab3Bean.getSiteDepositSpecialCash().setNewStatus(depositSpecial.getNewStatus());
						semmsi004tab3Bean.getSiteDepositSpecialCash().setDepositType(depositSpecial.getDepositType());
						semmsi004tab3Bean.getSiteDepositSpecialCash().setDetail(depositSpecial.getDetail());
					}
				}
				
				semmsi004tab3Bean.setDisabledChkNoDeposit(true);
			}else{
				semmsi004tab3Bean.setSiteDepositSpecialBg(new Deposit());
				semmsi004tab3Bean.setSiteDepositSpecialCash(new Deposit());
				semmsi004tab3Bean.getSiteDepositSpecialCash().setVatType("04");
				semmsi004tab3Bean.setDisabledChkNoDeposit(false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private void semmsi004SearchDepositSpecial(String siteInfoId,
			String depositType, String depositCondType) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004SrchDepositRentSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositRentSP criteria = new Msi004SrchDepositRentSP();
			criteria.setSiteInfoId(siteInfoId);
			criteria.setDepositType(depositType);
			criteria.setDepositCondType(depositCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_R.name, criteria);
			log.debug("search rent depost special size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab3Bean.setDepositRentSpecialSPList(to);
			}else{
				semmsi004tab3Bean.setDepositRentSpecialSPList(new ArrayList<Msi004SrchDepositRentSP>());
			}
			 setSemmsi004tab3Bean(semmsi004tab3Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void setRentCondSpecial(String siteInfoId, String rentCondType) {
		// search rent cond
		log.debug("siteInfoId = "+siteInfoId);
		log.debug("rentCondType = "+rentCondType);
		this.semmsi004SearchRentCond(siteInfoId, rentCondType);
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004SrchRentCondSP> list = semmsi004tab3Bean.getRentCondSPList();
		List<Msi004SrchRentCondSP> listTmp = new ArrayList<Msi004SrchRentCondSP>();
		try{
			if(list != null && list.size() > 0){
				for(Msi004SrchRentCondSP rentCondSpecial : list){
					if(StringUtils.equals(rentCondSpecial.getRentCondType(),"02")){
						log.debug("rentCondSpecial.getExpenseType() = "+rentCondSpecial.getExpenseType());
						if(rentCondSpecial.getExpenseType() != null && rentCondSpecial.getExpenseType().equals("01")){
							semmsi004tab3Bean.getRentCondSpecial1().setRowId(rentCondSpecial.getRowId());
							semmsi004tab3Bean.getRentCondSpecial1().setDetail(rentCondSpecial.getDetail());
							if(rentCondSpecial.getWhtType() != null){
								semmsi004tab3Bean.getRentCondSpecial1().setWhtType(rentCondSpecial.getWhtType());
								//set temp by oum
								semmsi004tab3Bean.getRentCondSpecial1().setWhtTypeTemp(rentCondSpecial.getWhtType());
							}else{
								// default
								semmsi004tab3Bean.getRentCondSpecial1().setWhtType("01");
								
							}
							semmsi004tab3Bean.getRentCondSpecial1().setRecordStatus("Y");
							if(rentCondSpecial.getSeqNo() != null)semmsi004tab3Bean.getRentCondSpecial1().setSeqNo(Integer.parseInt(rentCondSpecial.getSeqNo()));
							semmsi004tab3Bean.getRentCondSpecial1().setSiteInfoId(siteInfoId);
							semmsi004tab3Bean.getRentCondSpecial1().setRentCondType(semmsi004tab3Bean.getRentCondNormal().getRentCondType());
							semmsi004tab3Bean.getRentCondSpecial1().setExpenseType(rentCondSpecial.getExpenseType());
							if(rentCondSpecial.getWhtRate() != null){
								semmsi004tab3Bean.getRentCondSpecial1().setWhtRate(rentCondSpecial.getWhtRate());
								//set temp by oum
								semmsi004tab3Bean.getRentCondSpecial1().setWhtRateTemp(rentCondSpecial.getWhtRate());
							}else{
								semmsi004tab3Bean.getRentCondSpecial1().setWhtRate(null);
							}
							
							
							if(rentCondSpecial.getVatType() != null){
								semmsi004tab3Bean.getRentCondSpecial1().setVatType(rentCondSpecial.getVatType());
								//set temp by oum
								semmsi004tab3Bean.getRentCondSpecial1().setVatTypeTemp(rentCondSpecial.getVatType());
							}else{
								semmsi004tab3Bean.getRentCondSpecial1().setVatType("04");
							}
						}
						if(rentCondSpecial.getExpenseType() != null && rentCondSpecial.getSubExpenseType() != null){
							if(rentCondSpecial.getExpenseType().equals("02") && rentCondSpecial.getSubExpenseType().equals("01")){
								semmsi004tab3Bean.getRentCondSpecial2().setRowId(rentCondSpecial.getRowId());
								semmsi004tab3Bean.getRentCondSpecial2().setDetail(rentCondSpecial.getDetail());
								
								if(rentCondSpecial.getWhtType() != null){
									semmsi004tab3Bean.getRentCondSpecial2().setWhtType(rentCondSpecial.getWhtType());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial2().setWhtTypeTemp(rentCondSpecial.getWhtType());
								}else{
									// set default
									semmsi004tab3Bean.getRentCondSpecial2().setWhtType("01");
								}
								semmsi004tab3Bean.getRentCondSpecial2().setRecordStatus("Y");
								if(rentCondSpecial.getSeqNo() != null)semmsi004tab3Bean.getRentCondSpecial2().setSeqNo(Integer.parseInt(rentCondSpecial.getSeqNo()));
								semmsi004tab3Bean.getRentCondSpecial2().setSiteInfoId(siteInfoId);
								semmsi004tab3Bean.getRentCondSpecial2().setRentCondType(semmsi004tab3Bean.getRentCondNormal().getRentCondType());
								semmsi004tab3Bean.getRentCondSpecial2().setExpenseType(rentCondSpecial.getExpenseType());
								semmsi004tab3Bean.getRentCondSpecial2().setSubExpenseType(rentCondSpecial.getSubExpenseType());
								if(rentCondSpecial.getWhtRate() != null){
									semmsi004tab3Bean.getRentCondSpecial2().setWhtRate(rentCondSpecial.getWhtRate());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial2().setWhtRateTemp(rentCondSpecial.getWhtRate());
								}else{
									semmsi004tab3Bean.getRentCondSpecial2().setWhtRate(null);
								}
								if(rentCondSpecial.getVatType() != null){
									semmsi004tab3Bean.getRentCondSpecial2().setVatType(rentCondSpecial.getVatType());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial2().setVatTypeTemp(rentCondSpecial.getVatType());
								}else{
									semmsi004tab3Bean.getRentCondSpecial2().setVatType("01");
								}
							}
						}
						if(rentCondSpecial.getExpenseType() != null && rentCondSpecial.getSubExpenseType() != null){
							if(rentCondSpecial.getExpenseType().equals("02") && rentCondSpecial.getSubExpenseType().equals("02")){
								semmsi004tab3Bean.getRentCondSpecial3().setRowId(rentCondSpecial.getRowId());
								semmsi004tab3Bean.getRentCondSpecial3().setDetail(rentCondSpecial.getDetail());
								
								if(rentCondSpecial.getWhtType() != null){
									semmsi004tab3Bean.getRentCondSpecial3().setWhtType(rentCondSpecial.getWhtType());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial3().setWhtTypeTemp(rentCondSpecial.getWhtType());
								}else{
									// set default
									semmsi004tab3Bean.getRentCondSpecial3().setWhtType("01");
								}
								semmsi004tab3Bean.getRentCondSpecial3().setRecordStatus("Y");
								if(rentCondSpecial.getSeqNo() != null)semmsi004tab3Bean.getRentCondSpecial3().setSeqNo(Integer.parseInt(rentCondSpecial.getSeqNo()));
								semmsi004tab3Bean.getRentCondSpecial3().setSiteInfoId(siteInfoId);
								semmsi004tab3Bean.getRentCondSpecial3().setRentCondType(semmsi004tab3Bean.getRentCondNormal().getRentCondType());
								semmsi004tab3Bean.getRentCondSpecial3().setExpenseType(rentCondSpecial.getExpenseType());
								semmsi004tab3Bean.getRentCondSpecial3().setSubExpenseType(rentCondSpecial.getSubExpenseType());
								if(rentCondSpecial.getWhtRate() != null){
									semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(rentCondSpecial.getWhtRate());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial3().setWhtRateTemp(rentCondSpecial.getWhtRate());
								}else{
									semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(null);
								}
								if(rentCondSpecial.getVatType() != null){
									semmsi004tab3Bean.getRentCondSpecial3().setVatType(rentCondSpecial.getVatType());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial3().setVatTypeTemp(rentCondSpecial.getVatType());
								}else{
									semmsi004tab3Bean.getRentCondSpecial3().setVatType("01");
								}
							}
							
						}
						if(rentCondSpecial.getExpenseType() != null && rentCondSpecial.getSubExpenseType() != null){
							if(rentCondSpecial.getExpenseType().equals("02") && rentCondSpecial.getSubExpenseType().equals("03")){
								semmsi004tab3Bean.getRentCondSpecial4().setRowId(rentCondSpecial.getRowId());
								semmsi004tab3Bean.getRentCondSpecial4().setDetail(rentCondSpecial.getDetail());
								
								if(rentCondSpecial.getWhtType() != null){
									semmsi004tab3Bean.getRentCondSpecial4().setWhtType(rentCondSpecial.getWhtType());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial4().setWhtTypeTemp(rentCondSpecial.getWhtType());
								}else{
									// set default
									semmsi004tab3Bean.getRentCondSpecial4().setWhtType("01");
								}
								semmsi004tab3Bean.getRentCondSpecial4().setRecordStatus("Y");
								if(rentCondSpecial.getSeqNo() != null)semmsi004tab3Bean.getRentCondSpecial4().setSeqNo(Integer.parseInt(rentCondSpecial.getSeqNo()));
								semmsi004tab3Bean.getRentCondSpecial4().setSiteInfoId(siteInfoId);
								semmsi004tab3Bean.getRentCondSpecial4().setRentCondType(semmsi004tab3Bean.getRentCondNormal().getRentCondType());
								semmsi004tab3Bean.getRentCondSpecial4().setExpenseType(rentCondSpecial.getExpenseType());
								semmsi004tab3Bean.getRentCondSpecial4().setSubExpenseType(rentCondSpecial.getSubExpenseType());
								if(rentCondSpecial.getWhtRate() != null){
									semmsi004tab3Bean.getRentCondSpecial4().setWhtRate(rentCondSpecial.getWhtRate());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial4().setWhtRateTemp(rentCondSpecial.getWhtRate());
								}else{
									semmsi004tab3Bean.getRentCondSpecial4().setWhtRate(null);
								}
								if(rentCondSpecial.getVatType() != null){
									semmsi004tab3Bean.getRentCondSpecial4().setVatType(rentCondSpecial.getVatType());
									//set temp by oum
									semmsi004tab3Bean.getRentCondSpecial4().setVatTypeTemp(rentCondSpecial.getVatType());
								}else{
									semmsi004tab3Bean.getRentCondSpecial4().setVatType("01");
								}
							}
						}
//						if(rentCondSpecial.getExpenseType() != null && rentCondSpecial.getExpenseType().equals("03")){
//							semmsi004tab3Bean.getRentCondSpecial3().setRowId(rentCondSpecial.getRowId());
//							semmsi004tab3Bean.getRentCondSpecial3().setDetail(rentCondSpecial.getDetail());
//							
//							if(rentCondSpecial.getWhtType() != null){
//								semmsi004tab3Bean.getRentCondSpecial3().setWhtType(rentCondSpecial.getWhtType());
//							}else{
//								// set default
//								semmsi004tab3Bean.getRentCondSpecial3().setWhtType("01");
//							}
//							semmsi004tab3Bean.getRentCondSpecial3().setRecordStatus("Y");
//							semmsi004tab3Bean.getRentCondSpecial3().setSeqNo(Integer.parseInt(rentCondSpecial.getSeqNo()));
//							semmsi004tab3Bean.getRentCondSpecial3().setSiteInfoId(siteInfoId);
//							semmsi004tab3Bean.getRentCondSpecial3().setRentCondType(semmsi004tab3Bean.getRentCondNormal().getRentCondType());
//							semmsi004tab3Bean.getRentCondSpecial3().setExpenseType(rentCondSpecial.getExpenseType());
//							if(rentCondSpecial.getWhtRate() != null){
//								semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(rentCondSpecial.getWhtRate());
//							}else{
//								semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(null);
//							}
//							if(rentCondSpecial.getVatType() != null){
//								semmsi004tab3Bean.getRentCondSpecial3().setVatType(rentCondSpecial.getVatType());
//							}else{
//								semmsi004tab3Bean.getRentCondSpecial3().setVatType("01");
//							}
//							
//						}
					}else{
						listTmp.add(rentCondSpecial);
					}
				}
				// set default case list is not null
				if(semmsi004tab3Bean.getRentCondSpecial1().getWhtType() == null){
					semmsi004tab3Bean.getRentCondSpecial1().setWhtType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial1().getVatType() == null){
					semmsi004tab3Bean.getRentCondSpecial1().setVatType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial2().getWhtType() == null){
					semmsi004tab3Bean.getRentCondSpecial2().setWhtType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial2().getVatType() == null){
					semmsi004tab3Bean.getRentCondSpecial2().setVatType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial3().getWhtType() == null){
					semmsi004tab3Bean.getRentCondSpecial3().setWhtType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial3().getVatType() == null){
					semmsi004tab3Bean.getRentCondSpecial3().setVatType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial4().getWhtType() == null){
					semmsi004tab3Bean.getRentCondSpecial4().setWhtType("01");
				}
				if(semmsi004tab3Bean.getRentCondSpecial4().getVatType() == null){
					semmsi004tab3Bean.getRentCondSpecial4().setVatType("01");
				}
				// disable checkbox no rent
				semmsi004tab3Bean.setDisabledChkNoRent(true);
			}else{
				//set default case list is  null
				this.defaultRadioRentCondSpecial();
				semmsi004tab3Bean.setDisabledChkNoRent(false);
			}
			
			//Add rentCondSpList
			semmsi004tab3Bean.setRentCondSPList(listTmp);
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}

	private void defaultRadioRentCondSpecial() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.getRentCondSpecial1().setWhtType("01");
		semmsi004tab3Bean.getRentCondSpecial1().setVatType("04");
		semmsi004tab3Bean.getRentCondSpecial2().setWhtType("01");
		semmsi004tab3Bean.getRentCondSpecial2().setVatType("01");
		semmsi004tab3Bean.getRentCondSpecial3().setWhtType("01");
		semmsi004tab3Bean.getRentCondSpecial3().setVatType("01");
		semmsi004tab3Bean.getRentCondSpecial4().setWhtType("01");
		semmsi004tab3Bean.getRentCondSpecial4().setVatType("01");
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}
	
	private void semmsi004SearchDepositRentCash(String siteInfoId) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004SrchDepositRentSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositRentSP criteria = new Msi004SrchDepositRentSP();
			criteria.setSiteInfoId(siteInfoId);
			criteria.setDepositType("02");
			criteria.setDepositCondType("01");
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_R.name, criteria);
			log.debug("search rent depost Cash size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab3Bean.setDepositRentCashSPList(new ArrayList<Msi004SrchDepositRentSP>());
				for(Msi004SrchDepositRentSP siteAcq : to){
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getBgEffectiveDt() != null){
						siteAcq.setBgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getBgEffectiveDt()));
					}
					
					if(siteAcq.getBgExpireDt() != null){
						siteAcq.setBgExpireDtStr(convertYearENtoTHStr(siteAcq.getBgExpireDt()));
					}
					
					 semmsi004tab3Bean.getDepositRentCashSPList().add(siteAcq);
				}
				
			}
			 setSemmsi004tab3Bean(semmsi004tab3Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void semmsi004SearchDepositRentBG(String siteInfoId) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004SrchDepositRentSP> to = null;
		try{
			ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
			Msi004SrchDepositRentSP criteria = new Msi004SrchDepositRentSP();
			criteria.setSiteInfoId(siteInfoId);
			criteria.setDepositType("01");
			criteria.setDepositCondType("01");
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_R.name, criteria);
			log.debug("search rent depost BG size [" + to.size() + "]");
			
			if(to != null && to.size() > 0){
				semmsi004tab3Bean.setDepositRentBgSPList(new ArrayList<Msi004SrchDepositRentSP>());
				for(Msi004SrchDepositRentSP siteAcq : to){
					if(siteAcq.getEffectiveDt() != null){
						siteAcq.setEffectiveDtStr(convertYearENtoTHStr(siteAcq.getEffectiveDt()));
					}
					
					if(siteAcq.getExpireDt() != null){
						siteAcq.setExpireDtStr(convertYearENtoTHStr(siteAcq.getExpireDt()));
					}
					

					if(siteAcq.getBgEffectiveDt() != null){
						siteAcq.setBgEffectiveDtStr(convertYearENtoTHStr(siteAcq.getBgEffectiveDt()));
					}
					
					if(siteAcq.getBgExpireDt() != null){
						siteAcq.setBgExpireDtStr(convertYearENtoTHStr(siteAcq.getBgExpireDt()));
					}
					
					 semmsi004tab3Bean.getDepositRentBgSPList().add(siteAcq);
				}
//				 semmsi004tab3Bean.setDepositRentBgSPList(to);
			}
			 setSemmsi004tab3Bean(semmsi004tab3Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void semmsi004SearchRentCond(String siteInfoId, String rentCondType) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004SrchRentCondSP> to = null;
		boolean flag01 = false;
		boolean flag02 = false;
		boolean flag03 = false;
		boolean flag04 = false;
		
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			Msi004SrchRentCondSP criteria = new Msi004SrchRentCondSP();
			criteria.setSiteInfoId(siteInfoId);
			criteria.setRentCondType(rentCondType);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_RENT_COND.name, criteria);
			log.debug("search rent cond size [" + to.size() + "]");
			
			// drop down expenseTypeDepositRent
			List<SelectItem> tempList = new ArrayList<SelectItem>();
			tempList = getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null);
			List<SelectItem> expenseTypeDepositRentList = new ArrayList<SelectItem>();
			SelectItem selItem = null;
			selItem = new SelectItem("" , msg("value.selectItem"));
			expenseTypeDepositRentList.add(selItem);
			List<Msi004SrchRentCondSP> list = new ArrayList<Msi004SrchRentCondSP>();
			if(to != null && to.size() > 0){
				// check editable rent flag
				this.checkEditableRent();
				for(Msi004SrchRentCondSP rentCondSP : to){
					if(rentCondSP.getRentOldAmt() != null && rentCondSP.getRentOldAmt() == 0.00) rentCondSP.setRentOldAmt(null);
					if(rentCondSP.getRentAddPercent() != null && rentCondSP.getRentAddPercent() == 0.0) rentCondSP.setRentAddPercent(null);
					if(rentCondSP.getRentAddAmt() != null && rentCondSP.getRentAddAmt() == 0.00) rentCondSP.setRentAddAmt(null);
					if(rentCondSP.getRentAmt() != null && rentCondSP.getRentAmt() == 0.00) rentCondSP.setRentAmt(null);
//					if(rentCondSP.getEffDate() != null) rentCondSP.setEffDate(convertYearENtoTH(rentCondSP.getEffDate()));
					if(rentCondSP.getEffDate() != null) rentCondSP.setEffDateStr(convertYearENtoTHStr(rentCondSP.getEffDate()));
					if(getSemmsi004tab3Bean().getEditableRentFlag().equals("Y")){
						/*if(rentCondSP.getRentOldAmt() != null){
							rentCondSP.setRenderedButtonDelete(false);
						}else{
							rentCondSP.setRenderedButtonDelete(true);
						}*/
						if(StringUtils.equals(rentCondSP.getDeleteableFlag(), "Y"))
						rentCondSP.setRenderedButtonDelete(true);
						else
						rentCondSP.setRenderedButtonDelete(false);	
					}else{
						rentCondSP.setRenderedButtonDelete(false);
					}
					
					if(rentCondSP.getPeriodStartDt() != null){
						rentCondSP.setPeriodStartDtStr(convertYearENtoTHStr(rentCondSP.getPeriodStartDt()));
					}
					
					if(rentCondSP.getPeriodEndDt() != null){
						rentCondSP.setPeriodEndDtStr(convertYearENtoTHStr(rentCondSP.getPeriodEndDt()));
					}
					
					if(rentCondSP.getEffDate() != null){
						rentCondSP.setEffDateStr(convertYearENtoTHStr(rentCondSP.getEffDate()));
					}
					
					if(rentCondSP.getStartDt() != null){
						rentCondSP.setStartDtStr(convertYearENtoTHStr(rentCondSP.getStartDt()));
					}
					
					if(rentCondSP.getExpireDt() != null){
						rentCondSP.setExpireDtStr(convertYearENtoTHStr(rentCondSP.getExpireDt()));
					}
					
					list.add(rentCondSP);
					// set drop down expenseTypeDepositRent
					if(!flag01 && rentCondSP.getExpenseType().equals("01")){
						selItem = new SelectItem();
						selItem.setLabel(tempList.get(1).getLabel());
						selItem.setValue(tempList.get(1).getValue());
						expenseTypeDepositRentList.add(selItem);
						flag01 = true;
					}
					if(!flag02 && rentCondSP.getExpenseType().equals("02")){
						selItem = new SelectItem();
						selItem.setLabel(tempList.get(2).getLabel());
						selItem.setValue(tempList.get(2).getValue());
						expenseTypeDepositRentList.add(selItem);
						flag02 = true;
					}
					
					if(StringUtils.isEmpty(rentCondSP.getVatType())){
						rentCondSP.setVatType("04");
					}
					
					
					if(rentCondSP.getPeriodStartDt() != null){
						rentCondSP.setPeriodStartDtStr(convertYearENtoTHStr(rentCondSP.getPeriodStartDt()));
					}
					if(rentCondSP.getPeriodEndDt() != null){
						rentCondSP.setPeriodEndDtStr(convertYearENtoTHStr(rentCondSP.getPeriodEndDt()));
					}
				}
				
				semmsi004tab3Bean.setDisabledChkNoRent(true);
			}else{
				semmsi004tab3Bean.setDisabledChkNoRent(false);
			}
			semmsi004tab3Bean.setRentCondSPList(list);
			semmsi004tab3Bean.setExpenseTypeDepositRentList(expenseTypeDepositRentList);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug("semmsi004tab3Bean.isDisabledChkNoRent() 1 = "+semmsi004tab3Bean.isDisabledChkNoRent());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void semmsi004SearchRentCondExt(String siteInfoId) {
		log.debug(" ##### Start Semmsi004tab3Action semmsi004SearchRentCondExt #####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<Msi004SrchRentCondSP> to = null;
		boolean flag01 = false;
		boolean flag02 = false;
		boolean flag03 = false;
		boolean flag04 = false;
		
		try{
			ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
			Msi004SrchRentCondSP criteria = new Msi004SrchRentCondSP();
			criteria.setSiteInfoId(siteInfoId);
			to = service.querySPList(EQueryName.SP_MSI004_SRCH_RENT_COND_EXT.name, criteria);
			log.debug("search rent cond size [" + to.size() + "]");
			
			// drop down expenseTypeDepositRent
//			List<SelectItem> tempList = new ArrayList<SelectItem>();
//			tempList = getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null);
//			List<SelectItem> expenseTypeDepositRentList = new ArrayList<SelectItem>();
			SelectItem selItem = null;
//			selItem = new SelectItem("" , msg("value.selectItem"));
//			expenseTypeDepositRentList.add(selItem);
			List<Msi004SrchRentCondSP> list = new ArrayList<Msi004SrchRentCondSP>();
			if(to != null && to.size() > 0){
//				// check editable rent flag
//				this.checkEditableRent();
				for(Msi004SrchRentCondSP rentCondSP : to){
					if(rentCondSP.getRentOldAmt() != null && rentCondSP.getRentOldAmt() == 0.00) rentCondSP.setRentOldAmt(null);
					if(rentCondSP.getRentAddPercent() != null && rentCondSP.getRentAddPercent() == 0.0) rentCondSP.setRentAddPercent(null);
					if(rentCondSP.getRentAddAmt() != null && rentCondSP.getRentAddAmt() == 0.00) rentCondSP.setRentAddAmt(null);
					if(rentCondSP.getRentAmt() != null && rentCondSP.getRentAmt() == 0.00) rentCondSP.setRentAmt(null);
//					if(rentCondSP.getEffDate() != null) rentCondSP.setEffDate(convertYearENtoTH(rentCondSP.getEffDate()));
					if(rentCondSP.getEffDate() != null) rentCondSP.setEffDateStr(convertYearENtoTHStr(rentCondSP.getEffDate()));
					if(StringUtils.equals("Y",  getSemmsi004tab3Bean().getEditableRentFlag())){
						/*if(rentCondSP.getRentOldAmt() != null){
							rentCondSP.setRenderedButtonDelete(false);
						}else{
							rentCondSP.setRenderedButtonDelete(true);
						}*/
						if(StringUtils.equals("Y", rentCondSP.getDeleteableFlag()))
						rentCondSP.setRenderedButtonDelete(true);
						else
						rentCondSP.setRenderedButtonDelete(false);	
					}else{
						rentCondSP.setRenderedButtonDelete(false);
					}
					
					if(rentCondSP.getEffDate() != null){
						rentCondSP.setEffDateStr(convertYearENtoTHStr(rentCondSP.getEffDate()));
					}
					
					if(rentCondSP.getExpireDt() != null){
						rentCondSP.setExpireDtStr(convertYearENtoTHStr(rentCondSP.getExpireDt()));
					}
					
					if(rentCondSP.getPeriodStartDt() != null){
						rentCondSP.setPeriodStartDtStr(convertYearENtoTHStr(rentCondSP.getPeriodStartDt()));
					}
					
					if(rentCondSP.getPeriodEndDt() != null){
						rentCondSP.setPeriodEndDtStr(convertYearENtoTHStr(rentCondSP.getPeriodEndDt()));
					}
					
					if(rentCondSP.getChangeEffectiveDt() != null){
						rentCondSP.setChangeEffectiveDtStr(convertYearENtoTHStr(rentCondSP.getChangeEffectiveDt()));
					}
					
					
					
					list.add(rentCondSP);
//					// set drop down expenseTypeDepositRent
//					if(!flag01 && rentCondSP.getExpenseType().equals("01")){
//						selItem = new SelectItem();
//						selItem.setLabel(tempList.get(1).getLabel());
//						selItem.setValue(tempList.get(1).getValue());
//						expenseTypeDepositRentList.add(selItem);
//						flag01 = true;
//					}
//					if(!flag02 && rentCondSP.getExpenseType().equals("02")){
//						selItem = new SelectItem();
//						selItem.setLabel(tempList.get(2).getLabel());
//						selItem.setValue(tempList.get(2).getValue());
//						expenseTypeDepositRentList.add(selItem);
//						flag02 = true;
//					}
					
					if(StringUtils.isEmpty(rentCondSP.getVatType())){
						rentCondSP.setVatType("04");
					}
					
				}
				
//				semmsi004tab3Bean.setDisabledChkNoRent(true);
			}else{
//				semmsi004tab3Bean.setDisabledChkNoRent(false);
			}
			semmsi004tab3Bean.setRentCondExtSPList(list);
//			semmsi004tab3Bean.setExpenseTypeDepositRentList(expenseTypeDepositRentList);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug("semmsi004tab3Bean.isDisabledChkNoRent() 1 = "+semmsi004tab3Bean.isDisabledChkNoRent());
		}catch(Exception e){
			log.error(" ##### error Semmsi004tab3Action semmsi004SearchRentCondExt #####");
			e.printStackTrace();
		}finally{
			log.debug(" ##### End Semmsi004tab3Action semmsi004SearchRentCondExt #####");
		}
		
	}


	private void setDropdownExpenseTypeDepositRent(String expenseType) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		boolean flag01 = false;
		boolean flag02 = false;
		// drop down expenseTypeDepositRent
		List<SelectItem> tempList = new ArrayList<SelectItem>();
		tempList = getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null);
		
		List<SelectItem> expenseTypeDepositRentList = new ArrayList<SelectItem>();
		SelectItem selItem = null;
		selItem = new SelectItem("" , msg("value.selectItem"));
		expenseTypeDepositRentList.add(selItem);
		// set drop down
		if(expenseType != null && expenseType.equals("01")){
			if(!flag01){
				selItem = new SelectItem();
				selItem.setLabel(tempList.get(1).getLabel());
				selItem.setValue(tempList.get(1).getValue());
				expenseTypeDepositRentList.add(selItem);
				flag01 = true;
			}
		}
		 
		if(expenseType != null && expenseType.equals("02")){
			if(!flag02){
				selItem = new SelectItem();
				selItem.setLabel(tempList.get(2).getLabel());
				selItem.setValue(tempList.get(2).getValue());
				expenseTypeDepositRentList.add(selItem);
				flag02 = true;
			}
		}
		semmsi004tab3Bean.setExpenseTypeDepositRentList(expenseTypeDepositRentList);
	}

	public void checkConditionType(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
//		if(semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("01")){
//			semmsi004tab3Bean.setRenderDataTableRentCond(true);
			semmsi004tab3Bean.setRenderConditionNormal(true);
//			semmsi004tab3Bean.setRenderConditionSpecial(false);
			semmsi004tab3Bean.setChkWhtRateNormal(false);
//			semmsi004tab3Bean.setDisabledTotalNormalRent(true);
			this.doClearRentCond();
			semmsi004tab3Bean.setRentCondSPList(null);
			this.semmsi004SearchRentCond(siteInfoId, semmsi004tab3Bean.getRentCondNormal().getRentCondType());
			// this.getTotalRentNormal();
			
//		}else{siteDepositNormal
//			semmsi004tab3Bean.setRenderDataTableRentCond(false);
//			semmsi004tab3Bean.setRenderConditionNormal(false);
			semmsi004tab3Bean.setRenderConditionSpecial(true);
			semmsi004tab3Bean.setDisabledWhtRateRentSpecial(true);
			semmsi004tab3Bean.setChkWhtRateRentSpecial(false);
			semmsi004tab3Bean.setDisabledWhtRateRentSetupSpecial(true);
			semmsi004tab3Bean.setChkWhtRateRentSetupSpecial(false);
			semmsi004tab3Bean.setDisabledWhtRateServiceSpecial(true);
			semmsi004tab3Bean.setChkWhtRateServiceSpecial(false);
			semmsi004tab3Bean.setDisabledWhtRateServiceOtherSpecial(true);
			semmsi004tab3Bean.setChkWhtRateServiceOtherSpecial(false);
//			semmsi004tab3Bean.setDisabledTotalNormalRent(false);
			semmsi004tab3Bean.setDisabledWhtRateSupportSpecial(true);
			semmsi004tab3Bean.setChkWhtRateSupportSpecial(false);
			this.defaultRadioRentCondSpecial();
			log.debug("semmsi004tab3Bean.getRentCondNormal().getRentCondType() = "+semmsi004tab3Bean.getRentCondNormal().getRentCondType());
//			this.setRentCondSpecial(siteInfoId, semmsi004tab3Bean.getRentCondNormal().getRentCondType());
			this.setRentCondSpecial(siteInfoId, "");
			semmsi004tab3Bean.setExpenseTypeDepositRentList(getLovItemsByType(ELovType.T_CT_EXPENSE_TYPE.name,EX_IN, ELovVal.V_CT_DEPOSIT_RENT.name, null, null));
			this.getWhtRateSpecial();
//			this.clearTotalRent();
			
			if(semmsi004tab3Bean.getSiteDepositSpecialBg() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail())){
				semmsi004tab3Bean.setDisabledTotalDepositBG(false);
			}else{
				semmsi004tab3Bean.setDisabledTotalDepositBG(true);
			}
			
			if(semmsi004tab3Bean.getSiteDepositSpecialCash() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail())){
				semmsi004tab3Bean.setDisabledTotalDepositCash(false);
			}else{
				semmsi004tab3Bean.setDisabledTotalDepositCash(true);
			}
//		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	
	private void getTotalRentNormal() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			// get sum rent for update table site rent
			getSemmsi004tab1Action().searchSumRent(semmsi004tab3Bean.getSiteInfoId());
			SumRentSP sumRent = getSemmsi004tab1Bean().getSumRentSP();
			if(sumRent != null){
				if(sumRent.getRentAddAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalRentAddAmt(sumRent.getRentAddAmt());
				semmsi004tab3Bean.getTotalRent().setTotalRentAddPeriodType(sumRent.getRentAddPeriodType());
				if(sumRent.getServiceAddAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalServiceAddAmt(sumRent.getServiceAddAmt());
				semmsi004tab3Bean.getTotalRent().setTotalServiceAddPeriodType(sumRent.getServiceAddPeriodType());
				if(sumRent.getRentAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalRentAmt(sumRent.getRentAmt());
				semmsi004tab3Bean.getTotalRent().setTotalRentPeriodType(sumRent.getRentPeriodType());
				if(sumRent.getServiceAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalServiceAmt(sumRent.getServiceAmt());
				semmsi004tab3Bean.getTotalRent().setTotalServicePeriodType(sumRent.getServicePeriodType());
				if(sumRent.getRentServiceAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalRentServiceAmt(sumRent.getRentServiceAmt());
				semmsi004tab3Bean.getTotalRent().setTotalRentServicePeriodType(sumRent.getRentServicePeriodType());
				if(sumRent.getAgeRentServiceAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(sumRent.getAgeRentServiceAmt());
				if(sumRent.getAgeRentAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalAgeRentAmt(sumRent.getAgeRentAmt());
				if(sumRent.getAgeServiceAmt() != null) semmsi004tab3Bean.getTotalRent().setTotalAgeServiceAmt(sumRent.getAgeServiceAmt());
				setSemmsi004tab3Bean(semmsi004tab3Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void clearTotalRent() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			semmsi004tab3Bean.getTotalRent().setTotalRentAddAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalRentAddPeriodType("");
			semmsi004tab3Bean.getTotalRent().setTotalServiceAddAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalServiceAddPeriodType("");
			semmsi004tab3Bean.getTotalRent().setTotalRentAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalRentPeriodType("");
			semmsi004tab3Bean.getTotalRent().setTotalServiceAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalServicePeriodType("");
			semmsi004tab3Bean.getTotalRent().setTotalRentServiceAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalRentServicePeriodType("");
			semmsi004tab3Bean.getTotalRent().setTotalAgeRentAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalAgeServiceAmt(null);
			semmsi004tab3Bean.getTotalRent().setTotalAgeRentServiceAmt(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private void getWhtRateSpecial() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
				String whtRateRent = service.getLovVal2ByTypeAndCode(ELovType.T_CT_EXPENSE_TYPE.name, "01");
				String whtRateService = service.getLovVal2ByTypeAndCode(ELovType.T_CT_EXPENSE_TYPE.name, "02");
				
				if(semmsi004tab3Bean.getRentCondSpecial1().getWhtRate()==null){
					if(whtRateRent != null) semmsi004tab3Bean.getRentCondSpecial1().setWhtRate(new Double(whtRateRent));
				}
				
				if(semmsi004tab3Bean.getRentCondSpecial3().getWhtRate()==null){
					if(whtRateRent != null) semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(new Double(whtRateService));
				}
				
				if(semmsi004tab3Bean.getRentCondSpecial2().getWhtRate()==null){
					if(whtRateService != null) semmsi004tab3Bean.getRentCondSpecial2().setWhtRate(new Double(whtRateService));
				}
				
				if(semmsi004tab3Bean.getRentCondSpecial4().getWhtRate()==null){
					if(whtRateService != null) semmsi004tab3Bean.getRentCondSpecial4().setWhtRate(new Double(whtRateService));
				}
				
				
				
//				semmsi004tab3Bean.getRentCondSpecial3().setWhtRate(null);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	public void checkDepositRentConditionType(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String siteInfoId = getSemmsi004tab1Bean().getSiteInfo().getRowId();
		if(semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType() != null &&
		   semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("01")){
			semmsi004tab3Bean.setRenderDepositRentNormal(true);
			semmsi004tab3Bean.setRenderDepositRentSpecial(false);
			semmsi004tab3Bean.setRenderDataTableDeposit(true);
			semmsi004tab3Bean.setDisabledTotalNormalDeposit(true);
			this.defaultRadioDepositNormal();
			semmsi004tab3Bean.setDepositRentBgSPList(null);
			semmsi004tab3Bean.setDepositRentCashSPList(null);
			this.semmsi004SearchDepositRentBG(siteInfoId);
			this.semmsi004SearchDepositRentCash(siteInfoId);
			this.getTotalDepositNormal();
			
			
		}else{
			semmsi004tab3Bean.setRenderDepositRentNormal(false);
			semmsi004tab3Bean.setRenderDepositRentSpecial(true);
			semmsi004tab3Bean.setRenderDataTableDeposit(false);
			semmsi004tab3Bean.setDisabledTotalNormalDeposit(false);
			semmsi004tab3Bean.getSiteDepositSpecialCash().setVatType("04");
			this.setDepositSpecial(siteInfoId, null, semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType());
			this.clearTotalDeposit();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}

	private void getTotalDepositNormal() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			// get sum deposit rent 
			getSemmsi004tab1Action().searchSumDepositRent(semmsi004tab3Bean.getSiteInfoId());
			SumDepositRentSP sumDeposit = getSemmsi004tab1Bean().getSumDepositRentSP();
			if(sumDeposit != null){
				semmsi004tab3Bean.getTotalDeposit().setTotalDepositBgAmt(sumDeposit.getDepositBgAmt());
				semmsi004tab3Bean.getTotalDeposit().setTotalDepositCashAmt(sumDeposit.getDepositCashAmt());
				setSemmsi004tab3Bean(semmsi004tab3Bean);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	private void clearTotalDeposit() {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			semmsi004tab3Bean.getTotalDeposit().setTotalDepositBgAmt(null);
			semmsi004tab3Bean.getTotalDeposit().setTotalDepositCashAmt(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
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
	
	public boolean renderWhtRateNormal(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkWhtRateNormal()){
			semmsi004tab3Bean.setDisabledWhtRateNormal(false);
		}else{
			semmsi004tab3Bean.setDisabledWhtRateNormal(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public void renderedNormalVatType(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		
		//add 14/03/2023
		semmsi004tab3Bean.setDisabledExpenseDesc(true);
		
		if(semmsi004tab3Bean.getRentCondNormal().getExpenseType() != null &&
		   semmsi004tab3Bean.getRentCondNormal().getExpenseType().equals("01")){
			semmsi004tab3Bean.setRenderedNormalVatType(false);
			semmsi004tab3Bean.getRentCondNormal().setVatType("04");
			semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
			
		}else if(semmsi004tab3Bean.getRentCondNormal().getExpenseType() != null &&
				   semmsi004tab3Bean.getRentCondNormal().getExpenseType().equals("02")){
			semmsi004tab3Bean.setRenderedNormalVatType(true);
			semmsi004tab3Bean.getRentCondNormal().setVatType("02");
			semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
			
		}else if(semmsi004tab3Bean.getRentCondNormal().getExpenseType() != null &&
				   semmsi004tab3Bean.getRentCondNormal().getExpenseType().equals("03")){
			semmsi004tab3Bean.setRenderedNormalVatType(true);
			semmsi004tab3Bean.getRentCondNormal().setWhtType("03");
			semmsi004tab3Bean.getRentCondNormal().setVatType("04");
			
			// add 14/03/2023
		   if (StringUtils.equals("03", semmsi004tab3Bean.getRentCondNormal().getExpenseType())) {
			   semmsi004tab3Bean.setDisabledExpenseDesc(false);
		   }
			
		}else{
			semmsi004tab3Bean.setRenderedNormalVatType(true);
			semmsi004tab3Bean.getRentCondNormal().setVatType("01");
			semmsi004tab3Bean.getRentCondNormal().setExpenseDesc(null);
		}
		semmsi004tab3Bean.setDisabledWhtRateNormal(true);
		semmsi004tab3Bean.setChkWhtRateNormal(false);
		semmsi004tab3Bean.setDisabledChkWhtRateNormal(false);
		semmsi004tab3Bean.getRentCondNormal().setWhtRate(this.getWhtRate(semmsi004tab3Bean.getRentCondNormal().getExpenseType()));
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	
	public void renderedNoRent(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkNoRent()){
			semmsi004tab3Bean.setRenderedNoRent(false);
			semmsi004tab3Bean.setRenderDataTableRentCond(false);
		}else{
			semmsi004tab3Bean.setRenderedNoRent(true);
			// case special
			if(semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("02")){
				semmsi004tab3Bean.setRenderDataTableRentCond(false);
			}else{
				semmsi004tab3Bean.setRenderDataTableRentCond(true);
			}
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	public void renderedNoRentDeposit(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkNoRentDeposit()){
			semmsi004tab3Bean.setRenderedNoRentDeposit(false);
			semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
		}else{
			semmsi004tab3Bean.setRenderedNoRentDeposit(true);
			if(StringUtils.equals(semmsi004tab3Bean.getSiteDepositNormal().getDepositType(), "02"))
			semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
			else
			semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	
	public void changeVatType(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		
		semmsi004tab3Bean.getSiteDepositSpecialCash().setVatTypeTemp("Y");
		
		setSemmsi004tab3Bean(semmsi004tab3Bean);
	}
	
	private Double getWhtRate(String expenseType) {
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		Double whtRate = null;
		try{
			ILovMasterService service = (ILovMasterService)getBean("lovMasterService");
			if(expenseType != null && !expenseType.equals("")){
				String rentAddPercent = service.getLovVal2ByTypeAndCode(ELovType.T_CT_EXPENSE_TYPE.name, expenseType);
				whtRate = new Double(rentAddPercent);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return whtRate;
	}

	public boolean renderedDepositNormalVatType(){
		boolean flag = true;
		try{
			semmsi004tab3Bean = getSemmsi004tab3Bean();
			// BG
			if(semmsi004tab3Bean.getSiteDepositNormal() != null &&
			   semmsi004tab3Bean.getSiteDepositNormal().getDepositType().equals("01")){
				semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
			}else{
				// CASH
				if(semmsi004tab3Bean.getSiteDepositNormal().getExpenseType() != null &&
				   semmsi004tab3Bean.getSiteDepositNormal().getExpenseType().equals("04")){
					semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
				}else{
					semmsi004tab3Bean.getSiteDepositNormal().setVatType("01");
					semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
				}
			}
			if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmt() != null  &&
			   semmsi004tab3Bean.getSiteDepositNormal().getDepositAmt() == 0.00){
				semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(null);
			}
		}catch(Exception e){
			e.printStackTrace();
			flag = false;
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		
		return flag;
	}
	
	public boolean renderedVatType(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			if(!semmsi004tab3Bean.getSiteDepositNormal().getExpenseType().equals("") ){
				if(semmsi004tab3Bean.getSiteDepositNormal().getExpenseType().equals("04") &&
				   semmsi004tab3Bean.getSiteDepositNormal().getDepositType().equals("02")){
//					   semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
					   semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
					   semmsi004tab3Bean.getSiteDepositNormal().setVatType("04");
				}else if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType().equals("01")){
					 semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
				}else{
					semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
					semmsi004tab3Bean.getSiteDepositNormal().setVatType("01");
				}
			}else{
				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType().equals("02")){
					semmsi004tab3Bean.setRenderedDeposiNormalVatType(true);
					semmsi004tab3Bean.getSiteDepositNormal().setVatType("01");
				}else{
					semmsi004tab3Bean.setRenderedDeposiNormalVatType(false);
				}
			}
			   
		}catch(Exception e){
			e.printStackTrace();
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	public boolean renderWhtRateRentSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkWhtRateRentSpecial()){
			semmsi004tab3Bean.setDisabledWhtRateRentSpecial(false);
		}else{
			semmsi004tab3Bean.setDisabledWhtRateRentSpecial(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean renderWhtRateRentSetupSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkWhtRateRentSetupSpecial()){
			semmsi004tab3Bean.setDisabledWhtRateRentSetupSpecial(false);
		}else{
			semmsi004tab3Bean.setDisabledWhtRateRentSetupSpecial(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean renderWhtRateServiceSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkWhtRateServiceSpecial()){
			semmsi004tab3Bean.setDisabledWhtRateServiceSpecial(false);
		}else{
			semmsi004tab3Bean.setDisabledWhtRateServiceSpecial(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean renderWhtRateServiceOtherSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkWhtRateServiceOtherSpecial()){
			semmsi004tab3Bean.setDisabledWhtRateServiceOtherSpecial(false);
		}else{
			semmsi004tab3Bean.setDisabledWhtRateServiceOtherSpecial(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean renderWhtRateSupportSpecial(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.isChkWhtRateSupportSpecial()){
			semmsi004tab3Bean.setDisabledWhtRateSupportSpecial(false);
		}else{
			semmsi004tab3Bean.setDisabledWhtRateSupportSpecial(true);
		}
		setSemmsi004tab3Bean(semmsi004tab3Bean);
		return flag;
	}
	
	public boolean renderPayPeriodType(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			String payPeriodType = (String)getFacesUtils().getRequestParameter("payPeriodType");
			if(payPeriodType.equals("01")){
				semmsi004tab3Bean.setPayPeriodType02("");
				semmsi004tab3Bean.setPayPeriodType03("");
				semmsi004tab3Bean.setPayPeriodType04("");
				semmsi004tab3Bean.setPayPeriodType05("");
				semmsi004tab3Bean.setPayPeriodType06("");
				semmsi004tab3Bean.setPayPeriodType07("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(true);
				semmsi004tab3Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("02")){
				semmsi004tab3Bean.setPayPeriodType01("");
				semmsi004tab3Bean.setPayPeriodType03("");
				semmsi004tab3Bean.setPayPeriodType04("");
				semmsi004tab3Bean.setPayPeriodType05("");
				semmsi004tab3Bean.setPayPeriodType06("");
				semmsi004tab3Bean.setPayPeriodType07("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(true);
				semmsi004tab3Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("03")){
				if(semmsi004tab3Bean.getPayPeriod03() != null) semmsi004tab3Bean.getRentCondNormal().setPayPeriod(semmsi004tab3Bean.getPayPeriod03());
				semmsi004tab3Bean.setPayPeriodType01("");
				semmsi004tab3Bean.setPayPeriodType02("");
				semmsi004tab3Bean.setPayPeriodType04("");
				semmsi004tab3Bean.setPayPeriodType05("");
				semmsi004tab3Bean.setPayPeriodType06("");
				semmsi004tab3Bean.setPayPeriodType07("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(false);
				semmsi004tab3Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("04")){
				if(semmsi004tab3Bean.getPayPeriod04() != null) semmsi004tab3Bean.getRentCondNormal().setPayPeriod(semmsi004tab3Bean.getPayPeriod04());
				semmsi004tab3Bean.setPayPeriodType01("");
				semmsi004tab3Bean.setPayPeriodType02("");
				semmsi004tab3Bean.setPayPeriodType03("");
				semmsi004tab3Bean.setPayPeriodType05("");
				semmsi004tab3Bean.setPayPeriodType06("");
				semmsi004tab3Bean.setPayPeriodType07("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(true);
				semmsi004tab3Bean.setDisabledPayPeriod04(false);
			}
			if(payPeriodType.equals("05")){
				semmsi004tab3Bean.setPayPeriodType01("");
				semmsi004tab3Bean.setPayPeriodType02("");
				semmsi004tab3Bean.setPayPeriodType03("");
				semmsi004tab3Bean.setPayPeriodType04("");
				semmsi004tab3Bean.setPayPeriodType06("");
				semmsi004tab3Bean.setPayPeriodType07("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(true);
				semmsi004tab3Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("06")){
				semmsi004tab3Bean.setPayPeriodType01("");
				semmsi004tab3Bean.setPayPeriodType02("");
				semmsi004tab3Bean.setPayPeriodType03("");
				semmsi004tab3Bean.setPayPeriodType04("");
				semmsi004tab3Bean.setPayPeriodType05("");
				semmsi004tab3Bean.setPayPeriodType07("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(true);
				semmsi004tab3Bean.setDisabledPayPeriod04(true);
			}
			if(payPeriodType.equals("07")){
				semmsi004tab3Bean.setPayPeriodType01("");
				semmsi004tab3Bean.setPayPeriodType02("");
				semmsi004tab3Bean.setPayPeriodType03("");
				semmsi004tab3Bean.setPayPeriodType04("");
				semmsi004tab3Bean.setPayPeriodType05("");
				semmsi004tab3Bean.setPayPeriodType06("");
				semmsi004tab3Bean.setPayPeriod03(null);
				semmsi004tab3Bean.setPayPeriod04(null);
				semmsi004tab3Bean.setDisabledPayPeriod03(true);
				semmsi004tab3Bean.setDisabledPayPeriod04(true);
			}
			semmsi004tab3Bean.getRentCondNormal().setPayPeriodType(payPeriodType);
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
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
	
	private SEMMSI004Tab3Bean semmsi004tab3Bean;
	
	public SEMMSI004Tab3Bean getSemmsi004tab3Bean() {
		return (SEMMSI004Tab3Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab3Bean");
	}
	
	public void setSemmsi004tab3Bean(SEMMSI004Tab3Bean semmsi004tab3Bean) {
		this.semmsi004tab3Bean = semmsi004tab3Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab3Bean", this.semmsi004tab3Bean);
	}
	
	private SEMMSI004Tab1Bean semmsi004tab1Bean;
	
	
	public SEMMSI004Tab1Bean getSemmsi004tab1Bean() {
		if(semmsi004tab1Bean == null){
			semmsi004tab1Bean = new SEMMSI004Tab1Bean();
		}
		return (SEMMSI004Tab1Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab1Bean");
	}

	public void setSemmsi004tab1Bean(SEMMSI004Tab1Bean semmsi004tab1Bean) {
		this.semmsi004tab1Bean = semmsi004tab1Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab1Bean", this.semmsi004tab1Bean);
	}
	
	private SEMMSI004Tab2Bean semmsi004tab2Bean;
	
	
	public SEMMSI004Tab2Bean getSemmsi004tab2Bean() {
		if(semmsi004tab2Bean == null){
			semmsi004tab2Bean = new SEMMSI004Tab2Bean();
		}
		return (SEMMSI004Tab2Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsi004tab2Bean");
	}

	public void setSemmsi004tab2Bean(SEMMSI004Tab2Bean semmsi004tab2Bean) {
		this.semmsi004tab2Bean = semmsi004tab2Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsi004tab2Bean", this.semmsi004tab2Bean);
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

	public boolean compareTab3() {
		boolean flag = false;
		try{
//			if(compareRentCondSpecial()){
//				flag = true;
//				return flag;
//			}
//			if(compareRentCondDepositSpecial()){
//				flag = true;
//				return flag;
//			}
			if(compareTotalRentCond()){
				flag = true;
				return flag;
			}
			if(compareTotalDeposit()){
				flag = true;
				return flag;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareTotalRentCond() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent temp = service.queryRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			Rent current = getSemmsi004tab3Bean().getTotalRent();
			if(temp != null && current != null){
				if(!checkObjNull(temp.getTotalRentAddAmt()).equals(checkObjNull(current.getTotalRentAddAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalRentAddPeriodType()).equals(checkObjNull(current.getTotalRentAddPeriodType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalServiceAddAmt()).equals(checkObjNull(current.getTotalServiceAddAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalServiceAddPeriodType()).equals(checkObjNull(current.getTotalServiceAddPeriodType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalRentAmt()).equals(checkObjNull(current.getTotalRentAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalRentPeriodType()).equals(checkObjNull(current.getTotalRentPeriodType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalServiceAmt()).equals(checkObjNull(current.getTotalServiceAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalServicePeriodType()).equals(checkObjNull(current.getTotalServicePeriodType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalRentServiceAmt()).equals(checkObjNull(current.getTotalRentServiceAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalRentServicePeriodType()).equals(checkObjNull(current.getTotalRentServicePeriodType()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalAgeRentAmt()).equals(checkObjNull(current.getTotalAgeRentAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalAgeServiceAmt()).equals(checkObjNull(current.getTotalAgeServiceAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalAgeRentServiceAmt()).equals(checkObjNull(current.getTotalAgeRentServiceAmt()))){
					flag = true; 
					return flag;
				}
				if((!checkObjNull(temp.getNoRent()).equals("Y") && semmsi004tab3Bean.isChkNoRent())
					|| (checkObjNull(temp.getNoRent()).equals("Y") && !semmsi004tab3Bean.isChkNoRent())){
					flag = true; 
					return flag;
				}
				if((!checkObjNull(temp.getFix5Percent()).equals("Y") && semmsi004tab3Bean.isFix5Percent())
						|| (checkObjNull(temp.getFix5Percent()).equals("Y") && !semmsi004tab3Bean.isFix5Percent())){
					flag = true; 
					return flag;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareTotalDeposit() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ISiteRentService service = (ISiteRentService)getBean("siteRentService");
			Rent temp = service.queryRentBySiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			Rent current = getSemmsi004tab3Bean().getTotalDeposit();
			if(temp != null && current != null){
				if(!checkObjNull(temp.getTotalDepositBgAmt()).equals(checkObjNull(current.getTotalDepositBgAmt()))){
					flag = true; 
					return flag;
				}
				if(!checkObjNull(temp.getTotalDepositCashAmt()).equals(checkObjNull(current.getTotalDepositCashAmt()))){
					flag = true; 
					return flag;
				}
				if((!checkObjNull(temp.getNoDeposit()).equals("Y") && semmsi004tab3Bean.isChkNoRentDeposit())
					|| (checkObjNull(temp.getNoDeposit()).equals("Y") && !semmsi004tab3Bean.isChkNoRentDeposit())){
					flag = true; 
					return flag;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	private boolean compareRentCondDepositSpecial() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
//			if(!semmsi004tab3Bean.isChkNoRentDeposit() && semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("02")){
			if(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail() != null
				|| semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail() != null){
				List<Msi004SrchDepositRentSP> to = null;
				ISiteDepositService service = (ISiteDepositService)getBean("siteDepositService");
				Msi004SrchDepositRentSP criteria = new Msi004SrchDepositRentSP();
				criteria.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
				criteria.setDepositType(null);
				criteria.setDepositCondType("02");
				to = service.querySPList(EQueryName.SP_MSI004_SRCH_DPST_R.name, criteria);
				log.debug("search rent depost special size [" + to.size() + "]");
				Deposit current1 = semmsi004tab3Bean.getSiteDepositSpecialBg();
				Deposit current2 = semmsi004tab3Bean.getSiteDepositSpecialCash();
				if(to != null && to.size() > 0){
					// compare BG
					if(to.get(0) != null){
						Msi004SrchDepositRentSP temp = to.get(0);
						if(temp != null && current1 != null){
							if(!checkObjNull(temp.getDetail()).equals(checkObjNull(current1.getDetail()))){
								flag = true; 
								return flag;
							}
						}
					}
					// compare Cash
					if(to.size() > 1 && to.get(1) != null){
						Msi004SrchDepositRentSP temp = to.get(1);
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
					}else{
						if(current2 != null){
							if(StringUtils.isNotEmpty(current2.getDetail())){
								flag = true; 
								return flag;
							}
							if(StringUtils.isNotEmpty(current2.getVatType())){
								flag = true; 
								return flag;
							}
							if(!(current2.getVatType()).equals("")){
								flag = true; 
								return flag;
							}
							
						}
					}
					
				}else{
					if(current1.getDetail() != null && !current1.getDetail().equals("")){
						flag = true; 
						return flag;
					}
					if(current2.getDetail() != null && !current2.getDetail().equals("")){
						flag = true; 
						return flag;
					}
					if(!(current2.getVatType()).equals("")){
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

	private boolean compareRentCondSpecial() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
//			if(!semmsi004tab3Bean.isChkNoRent() && semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("02")){
			if(semmsi004tab3Bean.getRentCondSpecial1() != null 
					|| semmsi004tab3Bean.getRentCondSpecial2() != null
					|| semmsi004tab3Bean.getRentCondSpecial3() != null
					|| semmsi004tab3Bean.getRentCondSpecial4() != null){
				List<Msi004SrchRentCondSP> to = null;
				ISiteRentCondService service = (ISiteRentCondService)getBean("siteRentCondService");
				Msi004SrchRentCondSP criteria = new Msi004SrchRentCondSP();
				criteria.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
				criteria.setRentCondType("02");
				to = service.querySPList(EQueryName.SP_MSI004_SRCH_RENT_COND.name, criteria);
				log.debug("search rent cond size [" + to.size() + "]");
				RentCond current1 = semmsi004tab3Bean.getRentCondSpecial1();
				RentCond current2 = semmsi004tab3Bean.getRentCondSpecial2();
				RentCond current3 = semmsi004tab3Bean.getRentCondSpecial3();
				RentCond current4 = semmsi004tab3Bean.getRentCondSpecial4();
				//RentCond rentCond = new RentCond();
				if(to != null && to.size() > 0){
					// compare rentCond special1
					if(to.size()<2){
						if(current1 != null && current2 != null && current3 != null && current4 != null && 
								StringUtils.isNotEmpty(current1.getDetail())&& StringUtils.isNotEmpty(current2.getDetail()) &&
								StringUtils.isNotEmpty(current3.getDetail())&& StringUtils.isNotEmpty(current4.getDetail())){
							flag = true;
							return flag;
						}
					}
					for(Msi004SrchRentCondSP rentCond : to){
						if(StringUtils.equals(rentCond.getExpenseType(), "01")){
							if(rentCond != null && current1 != null){
								if(!checkObjNull(rentCond.getDetail()).equals(checkObjNull(current1.getDetail()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtType()).equals(checkObjNull(current1.getWhtType()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtRate()).equals(checkObjNull(current1.getWhtRate()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getVatType()).equals(checkObjNull(current1.getVatType()))){
									flag = true; 
									return flag;
								}
							}
						}else if(StringUtils.equals(rentCond.getExpenseType(), "02") && StringUtils.equals(rentCond.getSubExpenseType(), "01")){
							if(rentCond != null && current2 != null){
								if(!checkObjNull(rentCond.getDetail()).equals(checkObjNull(current2.getDetail()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtType()).equals(checkObjNull(current2.getWhtType()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtRate()).equals(checkObjNull(current2.getWhtRate()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getVatType()).equals(checkObjNull(current2.getVatType()))){
									flag = true; 
									return flag;
								}
							}
						}else if(StringUtils.equals(rentCond.getExpenseType(), "02") && StringUtils.equals(rentCond.getSubExpenseType(), "02")){
							if(rentCond != null && current3 != null){
								if(!checkObjNull(rentCond.getDetail()).equals(checkObjNull(current3.getDetail()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtType()).equals(checkObjNull(current3.getWhtType()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtRate()).equals(checkObjNull(current3.getWhtRate()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getVatType()).equals(checkObjNull(current3.getVatType()))){
									flag = true; 
									return flag;
								}
							}
						}else if(StringUtils.equals(rentCond.getExpenseType(), "02") && StringUtils.equals(rentCond.getSubExpenseType(), "03")){
							if(rentCond != null && current4 != null){
								if(!checkObjNull(rentCond.getDetail()).equals(checkObjNull(current4.getDetail()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtType()).equals(checkObjNull(current4.getWhtType()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getWhtRate()).equals(checkObjNull(current4.getWhtRate()))){
									flag = true; 
									return flag;
								}
								if(!checkObjNull(rentCond.getVatType()).equals(checkObjNull(current4.getVatType()))){
									flag = true; 
									return flag;
								}
							}
						}
						
						
					}
					
//					if(to.get(0) != null){
//						if(StringUtils.equals(to.get(0).getExpenseType(), "01")){
//							Msi004SrchRentCondSP temp = to.get(0);
//							
//							if(temp != null && current1 != null){
//								if(!checkObjNull(temp.getDetail()).equals(checkObjNull(current1.getDetail()))){
//									flag = true; 
//									return flag;
//								}
//								if(!checkObjNull(temp.getWhtType()).equals(checkObjNull(current1.getWhtType()))){
//									flag = true; 
//									return flag;
//								}
//								if(!checkObjNull(temp.getWhtRate()).equals(checkObjNull(current1.getWhtRate()))){
//									flag = true; 
//									return flag;
//								}
//							}
//						}else{
//							Msi004SrchRentCondSP temp = to.get(0);
//							if(temp != null && current2 != null){
//								if(!checkObjNull(temp.getDetail()).equals(checkObjNull(current2.getDetail()))){
//									flag = true; 
//									return flag;
//								}
//								if(!checkObjNull(temp.getWhtType()).equals(checkObjNull(current2.getWhtType()))){
//									flag = true; 
//									return flag;
//								}
//								if(!checkObjNull(temp.getWhtRate()).equals(checkObjNull(current2.getWhtRate()))){
//									flag = true; 
//									return flag;
//								}
//								if(!checkObjNull(temp.getVatType()).equals(checkObjNull(current2.getVatType()))){
//									flag = true; 
//									return flag;
//								}
//							}
//						}
//					}
//					// compare rentCond special2
//					if(to.size() > 1 && to.get(1) != null){
//						Msi004SrchRentCondSP temp = to.get(1);
//						if(temp != null && current2 != null){
//							if(!checkObjNull(temp.getDetail()).equals(checkObjNull(current2.getDetail()))){
//								flag = true; 
//								return flag;
//							}
//							if(!checkObjNull(temp.getWhtType()).equals(checkObjNull(current2.getWhtType()))){
//								flag = true; 
//								return flag;
//							}
//							if(!checkObjNull(temp.getWhtRate()).equals(checkObjNull(current2.getWhtRate()))){
//								flag = true; 
//								return flag;
//							}
//							if(!checkObjNull(temp.getVatType()).equals(checkObjNull(current2.getVatType()))){
//								flag = true; 
//								return flag;
//							}
//						}
//					}
					
				}else{
					if(StringUtils.isNotEmpty(current1.getDetail())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current1.getWhtTypeTemp())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current1.getVatTypeTemp())){
						flag = true;
						return flag;
					}
					if(current1.getWhtRateTemp() != null && current1.getWhtRateTemp() > 0){
						flag = true;
						return flag;
					}
					
					
					if(StringUtils.isNotEmpty(current2.getDetail())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current2.getWhtTypeTemp())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current2.getVatTypeTemp())){
						flag = true;
						return flag;
					}
					if(current2.getWhtRateTemp() != null && current2.getWhtRateTemp() > 0){
						flag = true;
						return flag;
					}
					
					if(StringUtils.isNotEmpty(current3.getDetail())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current3.getWhtTypeTemp())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current3.getVatTypeTemp())){
						flag = true;
						return flag;
					}
					if(current3.getWhtRateTemp() != null && current3.getWhtRateTemp() > 0){
						flag = true;
						return flag;
					}
					
					if(StringUtils.isNotEmpty(current4.getDetail())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current4.getWhtTypeTemp())){
						flag = true;
						return flag;
					}
					if(StringUtils.isNotEmpty(current4.getVatTypeTemp())){
						flag = true;
						return flag;
					}
					if(current4.getWhtRateTemp() != null && current4.getWhtRateTemp() > 0){
						flag = true;
						return flag;
					}
					
					
						if(current1 != null ){
							if(!checkObjNull(current1.getWhtType()).equals("01")){
								flag = true; 
								return flag;
							}
							if(!checkObjNull(current1.getVatType()).equals("")){
								flag = true; 
								return flag;
							}
							
						if(current2 != null ){
							if(!checkObjNull(current2.getWhtType()).equals("01")){
								flag = true; 
								return flag;
							}
							if(!checkObjNull(current2.getVatType()).equals("01")){
								flag = true; 
								return flag;
							}
						}
						if(current3 != null){
							if(!checkObjNull(current3.getWhtType()).equals("01")){
								flag = true; 
								return flag;
							}
							if(!checkObjNull(current3.getVatType()).equals("01")){
								flag = true; 
								return flag;
							}
						}
						if(current4 != null){
							if(!checkObjNull(current4.getWhtType()).equals("01")){
								flag = true; 
								return flag;
							}
							if(!checkObjNull(current4.getVatType()).equals("01")){
								flag = true; 
								return flag;
							}
						}
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean autoSaveTab3() {
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.setRenderAlertMessage(false);
		try{
				// rentCond special
//				if(!semmsi004tab3Bean.isChkNoRent() && semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("02")){
//			if((semmsi004tab3Bean.getRentCondSpecial1() != null || semmsi004tab3Bean.getRentCondSpecial2().getDetail() != null
//					|| semmsi004tab3Bean.getRentCondSpecial3().getDetail() != null
//					|| semmsi004tab3Bean.getRentCondSpecial4().getDetail() != null)){
//					log.debug("compareRentCondSpecial() = "+compareRentCondSpecial());
//					if(compareRentCondSpecial()){
//						this.doUpdateRentCondSpecial();
//					}
//				}
			if(compareTotalRentCond() || semmsi004tab3Bean.isChkNoRent()){
				this.doSaveTotalRent();
			}
			
			// deposit special
//			if(!semmsi004tab3Bean.isChkNoRentDeposit() && semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("02")){
//			if(semmsi004tab3Bean.getSiteDepositSpecialBg() != null || semmsi004tab3Bean.getSiteDepositSpecialCash() != null){
//					log.debug("compareRentCondDepositSpecial() = "+compareRentCondDepositSpecial());
//				if(compareRentCondDepositSpecial()){
//					this.doUpdateDepositSpecial();
//				}
//			}
			if(compareTotalDeposit() || semmsi004tab3Bean.isChkNoRentDeposit()){
				this.doSaveTotalDeposit();
			}
			
			if(compareTotalRentCond()){
				String rentCondType = "01";
				this.updateSiteRent(ELovVal.V_CT_RENT.name, rentCondType);
			}
			
			//added by NEW 24/10/2018
//			this.validateRentCond();
//			this.validateDepositNormal();
			
			semmsi004tab3Bean.setRenderAlertMessage(true);
			if(semmsi004tab3Bean.isRenderAlertMessage()){
				addMessageInfo("M0001");
			}
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
			flag = false;
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}
		return flag;
	}
	
	public boolean autoSaveTab3(boolean flag) {
//		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
				// rentCond special
//				if(!semmsi004tab3Bean.isChkNoRent() && semmsi004tab3Bean.getRentCondNormal().getRentCondType().equals("02")){
			if((semmsi004tab3Bean.getRentCondSpecial1() != null || semmsi004tab3Bean.getRentCondSpecial2().getDetail() != null
					|| semmsi004tab3Bean.getRentCondSpecial3().getDetail() != null
					|| semmsi004tab3Bean.getRentCondSpecial4().getDetail() != null)){
					log.debug("compareRentCondSpecial() = "+compareRentCondSpecial());
					if(flag){
						this.doUpdateRentCondSpecial();
					}
				}
			if(compareTotalRentCond() || semmsi004tab3Bean.isChkNoRent()){
				this.doSaveTotalRent();
			}
			
			// deposit special
//			if(!semmsi004tab3Bean.isChkNoRentDeposit() && semmsi004tab3Bean.getSiteDepositNormal().getDepositCondType().equals("02")){
			if(semmsi004tab3Bean.getSiteDepositSpecialBg() != null || semmsi004tab3Bean.getSiteDepositSpecialCash() != null){
					log.debug("compareRentCondDepositSpecial() = "+compareRentCondDepositSpecial());
				if(compareRentCondDepositSpecial()){
					this.doUpdateDepositSpecial();
				}
			}
			if(compareTotalDeposit() || semmsi004tab3Bean.isChkNoRentDeposit()){
				this.doSaveTotalDeposit();
			}
			if(getSemmsi004Bean().isShowMessageSave() == true){
				addMessageInfo("M0001");
			}
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			addMessageError("E0001");
			flag = false;
		}
		return flag;
	}
	
	public void checkDepositSpecial(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		if(semmsi004tab3Bean.getSiteDepositSpecialBg() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialBg().getDetail())){
			semmsi004tab3Bean.setDisabledTotalDepositBG(false);
		}else{
			semmsi004tab3Bean.setDisabledTotalDepositBG(true);
		}
		
		if(semmsi004tab3Bean.getSiteDepositSpecialCash() != null && StringUtils.isNotEmpty(semmsi004tab3Bean.getSiteDepositSpecialCash().getDetail())){
			semmsi004tab3Bean.setDisabledTotalDepositCash(false);
		}else{
			semmsi004tab3Bean.setDisabledTotalDepositCash(true);
		}
		this.updateTotalDeposit();
		
	}
	
	public void doSetFix5Percent(){
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			if(semmsi004tab3Bean.isFix5Percent()){
				semmsi004tab3Bean.getSiteRent().setFix5Percent("Y");
			}else{
				semmsi004tab3Bean.getSiteRent().setFix5Percent("N");
			}
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void doGetSiteAppServSelItem(String siteInfoId){
		log.debug(" ### START SEMMSI004Tab3Action dogetSiteAppServSelItem ### ");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		List<WrapperBeanObject<SiteAppRegHistSrch>> siteAppServList = new ArrayList<WrapperBeanObject<SiteAppRegHistSrch>>();
		ISiteRentService service = (ISiteRentService)getBean("siteRentService");
		List<SiteAppRegHistSrch> to = null;
		SelectItem selItem = null;
		try{
//			siteAppServList = 
			SiteInfoMapSiteAcqSP siteInfoMapMSAObjParam  = new SiteInfoMapSiteAcqSP();
			
			if(siteInfoId != null)siteInfoMapMSAObjParam.setSiteInfoId(siteInfoId);
			siteInfoMapMSAObjParam.setMode("C");
			log.debug("siteInfoMapMSAObjParam.getSiteInfoId() : "+siteInfoMapMSAObjParam.getSiteInfoId());
			to = service.querySPList(EQueryName.SP_MSI004_SITE_INFO_SERVICE_SRCH.name, siteInfoMapMSAObjParam);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				semmsi004tab3Bean.setServTypeList(listlov);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				List<SelectItem> listlov = new LinkedList<SelectItem>();		
				selItem = new SelectItem("ALL" , msg("value.allServItem"));
				listlov.add(selItem);
				for (int i = 0; i < to.size(); i++) {
					SiteAppRegHistSrch siteAcq = (SiteAppRegHistSrch) to.get(i);
//					WrapperBeanObject<SiteAppRegHistSrch> tmpWrapperBean = new WrapperBeanObject<SiteAppRegHistSrch>();

					if (StringUtils.isNotBlank(siteAcq.getServiceId()) && 
							   StringUtils.isNotEmpty(siteAcq.getServName())) {
						selItem = new SelectItem();
						selItem.setLabel(siteAcq.getServName());
						selItem.setValue(siteAcq.getServiceId());
						listlov.add(selItem);
						log.debug("siteAcq.getServName() : "+siteAcq.getServName());
						log.debug("siteAcq.getServiceId() : "+siteAcq.getServiceId());
					}
				}
				
				semmsi004tab3Bean.setServTypeList(listlov);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab3Action dogetSiteAppServSelItem : "+e);
		}finally{
//			semmsi004tab3Bean.getSiteAppObjParam().setMode("");
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" ### END SEMMSI004Tab3Action dogetSiteAppServSelItem ### ");
		}
	}
	
	public void doRenderDeptBgCash(){
		log.debug(" #### Start SEMMSI004Tab3Action doRenderDeptBgCash ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.setRenderedPnlDeptCash(false);
		semmsi004tab3Bean.setRenderedPnlDeptBg(false);
		String tempDepositType = semmsi004tab3Bean.getSiteDepositNormal().getDepositType();
		try{
			if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null){
				if(StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
					semmsi004tab3Bean.setRenderedPnlDeptCash(false);
					semmsi004tab3Bean.setRenderedPnlDeptBg(true);
				}else if(StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
					
					semmsi004tab3Bean.setRenderedPnlDeptCash(true);
					semmsi004tab3Bean.setRenderedPnlDeptBg(false);
				}
				semmsi004tab3Bean.getSiteDepositNormal().setExpenseType("");
				semmsi004tab3Bean.getSiteDepositNormal().setServiceId("");
				semmsi004tab3Bean.getSiteDepositNormal().setRemark("");
//				semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
				semmsi004tab3Bean.getSiteDepositNormal().setDepositAmtOld(null);
				semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnType("");
				semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
				semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnAmt(null);
				semmsi004tab3Bean.getSiteDepositNormal().setDepositBringForward(null);
				semmsi004tab3Bean.getSiteDepositNormal().setDepositAmtNew(null);
				semmsi004tab3Bean.getSiteDepositNormal().setWithdrawFlag("");
				semmsi004tab3Bean.getSiteDepositNormal().setRentPaymentPeriod("");
				log.debug("tempDepositType  : "+tempDepositType);
				semmsi004tab3Bean.getSiteDepositNormal().setDepositType(tempDepositType);
//				semmsi004tab3Bean.setSiteDepositNormal(new Deposit());
				setSemmsi004tab3Bean(semmsi004tab3Bean);
				this.initUpdDeptReturnType();
				this.doCalDepositReturnAmt();
				this.doCalDepositAmt();
				this.doInitDeposit();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action doRenderDeptBgCash : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" #### END SEMMSI004Tab3Action doRenderDeptBgCash ####");
		}
	}
	
	public boolean renderDeptReturnType(){
		log.debug(" #### START SEMMSI004Tab3Action renderDeptReturnType ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		
		try{
			String deptReturnType = getFacesUtils().getRequestParameter("deptReturnType") == null ? "" : (String)getFacesUtils().getRequestParameter("deptReturnType");
			if(deptReturnType != null){
				if(StringUtils.equals("01", deptReturnType)){
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
					}else if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
					}
					
					
//					semmsi004tab3Bean.setDeptReturnType01(true);
					semmsi004tab3Bean.setDeptReturnType02("");
					semmsi004tab3Bean.setDeptReturnType03("");
				}
				
				if(StringUtils.equals("02", deptReturnType)){
					
					
					semmsi004tab3Bean.setDeptReturnType01("");
//					semmsi004tab3Bean.setDeptReturnType02(true);
					semmsi004tab3Bean.setDeptReturnType03("");
				}
				
				if(StringUtils.equals("03", deptReturnType)){
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
						if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() > 0){
							semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld());
						}else{
							semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
						}
						
//						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
					}else if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
						if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() > 0){
							semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld());
						}else{
							semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
						}
						
//						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(null);
					}
					
					semmsi004tab3Bean.setDeptReturnType01("");
					semmsi004tab3Bean.setDeptReturnType02("");
//					semmsi004tab3Bean.setDeptReturnType03(true);
				}
				
				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
					semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnType(deptReturnType);
				}else if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
					semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnType(deptReturnType);
				}
				setSemmsi004tab3Bean(semmsi004tab3Bean);
				this.doCalDepositReturnAmt();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action renderDeptReturnType : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" #### END SEMMSI004Tab3Action renderDeptReturnType ####");
		}
		return true;
	}
	
	public void initUpdDeptReturnType(){
		log.debug(" #### START SEMMSI004Tab3Action initUpdDeptReturnType ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType())){
						semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnType("");
					}
					
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType().equals("01")){
						semmsi004tab3Bean.setDeptReturnType01(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType());
						semmsi004tab3Bean.setDeptReturnType02(null);
						semmsi004tab3Bean.setDeptReturnType03(null);

						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
						
					}
					
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType().equals("02")){
						semmsi004tab3Bean.setDeptReturnType02(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType());
						semmsi004tab3Bean.setDeptReturnType01(null);
						semmsi004tab3Bean.setDeptReturnType03(null);

//						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
						
					}
					
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType().equals("03")){
						semmsi004tab3Bean.setDeptReturnType03(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType());
						semmsi004tab3Bean.setDeptReturnType01(null);
						semmsi004tab3Bean.setDeptReturnType02(null);

						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
						
					}
					
				}else{
					semmsi004tab3Bean.setDeptReturnType01(null);
					semmsi004tab3Bean.setDeptReturnType02(null);
					semmsi004tab3Bean.setDeptReturnType03(null);

					semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
				}
			}else if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null && StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType() != null){
					if(StringUtils.isEmpty(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType())){
						semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnType("");
					}
					
					if(semmsi004tab3Bean.getSiteDepositNormal().getRentPaymentPeriod() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType().equals("01")){
						semmsi004tab3Bean.setDeptReturnType01(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType());
						semmsi004tab3Bean.setDeptReturnType02(null);
						semmsi004tab3Bean.setDeptReturnType03(null);

						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
						
					}
					
					if(semmsi004tab3Bean.getSiteDepositNormal().getRentPaymentPeriod() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType().equals("02")){
						semmsi004tab3Bean.setDeptReturnType02(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType());
						semmsi004tab3Bean.setDeptReturnType01(null);
						semmsi004tab3Bean.setDeptReturnType03(null);

//						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
						
					}
					
					if(semmsi004tab3Bean.getSiteDepositNormal().getRentPaymentPeriod() != null && semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType().equals("03")){
						semmsi004tab3Bean.setDeptReturnType03(semmsi004tab3Bean.getSiteDepositNormal().getDepositReturnType());
						semmsi004tab3Bean.setDeptReturnType01(null);
						semmsi004tab3Bean.setDeptReturnType02(null);

						semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
						
					}
					
				}else{
					semmsi004tab3Bean.setDeptReturnType01(null);
					semmsi004tab3Bean.setDeptReturnType02(null);
					semmsi004tab3Bean.setDeptReturnType03(null);

					semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
				}
			}else{
				semmsi004tab3Bean.setDeptReturnType01(null);
				semmsi004tab3Bean.setDeptReturnType02(null);
				semmsi004tab3Bean.setDeptReturnType03(null);
				semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
				semmsi004tab3Bean.getSiteDepositNormal().setReturnAmt(new Double(0));
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action initUpdDeptReturnType : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" #### END SEMMSI004Tab3Action initUpdDeptReturnType ####");
		}
	}
	
	public void doCalDepositReturnAmt(){
		log.debug(" #### Start SEMMSI004Tab3Action doCalDepositReturnAmt ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		 Double deptReturnAmt = new Double(0);
		try{
			if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() != null){
				deptReturnAmt = semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld();
			}
			
			if(semmsi004tab3Bean.getDeptReturnType02() != null && StringUtils.equals("02", semmsi004tab3Bean.getDeptReturnType02())){
				if(semmsi004tab3Bean.getSiteDepositNormal().getReturnAmt() != null){
					deptReturnAmt = semmsi004tab3Bean.getSiteDepositNormal().getReturnAmt();
				}
				
			}
			
			
			semmsi004tab3Bean.getSiteDepositNormal().setDepositReturnAmt(deptReturnAmt);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action doCalDepositReturnAmt : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" #### End SEMMSI004Tab3Action doCalDepositReturnAmt ####");
		}
	}
	
	public void doCalDepositAmt(){
		log.debug(" #### Start SEMMSI004Tab3Action doCalDepositAmt ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		Double deptReturnAmt = new Double(0);
		try{
			
			if(StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() != null){
					deptReturnAmt = semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld();
				}
			
				
//				if(semmsi004tab3Bean.isWithdrawFlag()){
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtNew() != null){
						deptReturnAmt = semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtNew();
					}
					
//				}
				
				
				semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(deptReturnAmt);
			}
			
			if(StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
				if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld() != null){
					deptReturnAmt = semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtOld();
				}
			
				
//				if(semmsi004tab3Bean.isWithdrawFlag()){
					if(semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtNew() != null){
						deptReturnAmt = semmsi004tab3Bean.getSiteDepositNormal().getDepositAmtNew();
					}
					
//				}
				
				
				semmsi004tab3Bean.getSiteDepositNormal().setDepositAmt(deptReturnAmt);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action doCalDepositAmt : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" #### End SEMMSI004Tab3Action doCalDepositAmt ####");
		}
	}
	
	public void doInitDeposit(){
		log.debug(" ### START SEMMSI004Tab3Action doInitDeposit ### ");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String depositType = semmsi004tab3Bean.getSiteDepositNormal().getDepositType();
		try{
			if(StringUtils.equals("01", depositType)){
				if(semmsi004tab3Bean.getSiteDepositNormal().getWithdrawFlag() != null && StringUtils.equals("Y", semmsi004tab3Bean.getSiteDepositNormal().getWithdrawFlag())){
					semmsi004tab3Bean.setWithdrawFlag(true);
				}else{
					semmsi004tab3Bean.setWithdrawFlag(false);
				}
				log.debug("doInitDeposit Cash getWithdrawFlag : "+semmsi004tab3Bean.getSiteDepositNormal().getWithdrawFlag());
			
			}
			
			if(StringUtils.equals("02", depositType)){
				if(semmsi004tab3Bean.getSiteDepositNormal().getWithdrawFlag() != null && StringUtils.equals("Y", semmsi004tab3Bean.getSiteDepositNormal().getWithdrawFlag())){
					semmsi004tab3Bean.setWithdrawFlag(true);
				}else{
					semmsi004tab3Bean.setWithdrawFlag(false);
				}
				log.debug("doInitDeposit BG getWithdrawFlag : "+semmsi004tab3Bean.getSiteDepositNormal().getWithdrawFlag());
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error(" Error SEMMSI004Tab3Action doInitDeposit ");
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" ### END SEMMSI004Tab3Action doInitDeposit ### ");
		}
	}
	
	public void doSetRentDepositChk(){
		log.error("#####  Start SEMMSI004TAB4Action doSetRentDepositChk #######");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			if(semmsi004tab3Bean.isWithdrawFlag()){
				semmsi004tab3Bean.getSiteDepositNormal().setWithdrawFlag("Y");
			}else{
				semmsi004tab3Bean.getSiteDepositNormal().setWithdrawFlag("");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("#####  ERROR SEMMSI004TAB4Action doSetRentDepositChk"+e);
			
		}finally{
			log.error("#####  end SEMMSI004TAB4Action doSetRentDepositChk #######");
		}
	}
	
	public boolean doEditRentalDeposit(){
		log.debug(" ### START SEMMSI004Tab3Action doEditRentalDeposit ### ");
		boolean flag = true;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String siteAppDepositId = getFacesUtils().getRequestParameter("siteAppDepositId") == null ? "" : (String)getFacesUtils().getRequestParameter("siteAppDepositId");
		String depositType = getFacesUtils().getRequestParameter("depositType") == null ? "" : (String)getFacesUtils().getRequestParameter("depositType");
		try{
			
			this.doRenderEditDeptBgCash();
			this.initUpdDeptReturnType();
			this.doCalDepositReturnAmt();
			this.doCalDepositAmt();
			this.doInitDeposit();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("ERROR SEMMSI004Tab3Action doEditRentalDeposit : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" ### END SEMMSI004Tab3Action doEditRentalDeposit ### ");
		}
		return flag;
	}
	
	public void doRenderEditDeptBgCash(){
		log.debug(" #### Start SEMMSI004Tab3Action doRenderEditDeptBgCash ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab3Bean.setRenderedPnlDeptCash(false);
		semmsi004tab3Bean.setRenderedPnlDeptBg(false);
		try{
			if(semmsi004tab3Bean.getSiteDepositNormal().getDepositType() != null){
				if(StringUtils.equals("01", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
					semmsi004tab3Bean.setRenderedPnlDeptCash(false);
					semmsi004tab3Bean.setRenderedPnlDeptBg(true);
				}else if(StringUtils.equals("02", semmsi004tab3Bean.getSiteDepositNormal().getDepositType())){
				
					semmsi004tab3Bean.setRenderedPnlDeptCash(true);
					semmsi004tab3Bean.setRenderedPnlDeptBg(false);
				}
				
//				semmsi004tab3Bean.setSiteAppDeptCashObj(new Deposit());
//				semmsi004tab3Bean.setSiteAppDeptBgObj(new Deposit());
//				setSemmsi004tab3Bean(semmsi004tab3Bean);
			
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("Error SEMMSI004Tab3Action doRenderEditDeptBgCash : "+e);
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" #### END SEMMSI004Tab3Action doRenderEditDeptBgCash ####");
		}
	}
	
	public boolean calRentalPeriod(){
		boolean flag = false;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		semmsi004tab2Bean = getSemmsi004tab2Bean();
		try{
			//contract Date
			Date dtmEffct = semmsi004tab2Bean.getSiteContract().getEffectiveDt();
			Date dtmExpr = semmsi004tab2Bean.getSiteContract().getExpireDt();
			
			//rent period date
			Date dtmEffctPrd = semmsi004tab3Bean.getRentCondNormal().getPeriodStartDt();
			Date dtmExprPrd = semmsi004tab3Bean.getRentCondNormal().getPeriodEndDt();
			
			if(dtmEffctPrd != null && dtmExprPrd != null){
				if(dtmEffctPrd.after(dtmExprPrd)) {
					semmsi004tab3Bean.getRentCondNormal().setPeriodEndDt(null);
					
					addMessageErrorWithArgument("W0006", msg("message.startperioddate"), msg("message.endperioddt"));
					flag = false;
				} else {
					// do nothing
				}
				
			}
			
			if(dtmEffct != null && dtmEffctPrd != null){
				//check rentPeriodStartDate >= contractEffectiveDate
				if(dtmEffctPrd.before(dtmEffct)){
					semmsi004tab3Bean.getRentCondNormal().setPeriodStartDt(null);
					
					addMessageErrorWithArgument("W0006", msg("message.startperioddate"), msg("message.contractEffDate") );
					flag = false;
				}
				
			}
			
			if(!semmsi004tab2Bean.isChkNoExpireFlag()){
				if(dtmExpr != null){
					if(dtmExprPrd != null){
						//check rentPeriodEndDate <= contractExpireDate
						if(dtmExprPrd.after(dtmExpr)){
							semmsi004tab3Bean.getRentCondNormal().setPeriodEndDt(null);
							
							addMessageErrorWithArgument("W0122", msg("message.endperioddt"), msg("message.contractExpDate"));
							flag = false;
						}
					}
				}else{
					addMessageErrorWithArgument("W0001", msg("message.contractExpDate"));
					flag = false;
				}
			}
			
//			if(effDate != null && expDate != null){
//				if (effDate.after(expDate)) {
//					addMessageErrorWithArgument("W0005" ,msg("message.contractEffDate"), msg("message.contractExpDate"));
//					flag = false;
//				}else{
//					semmsi004Bean = getSemmsi004Bean();
////					this.calAgeContract(effDate, expDate);
//					if (semmsi004Bean.getReqTypeParam().equals("01")) {
//						semmsi004tab2Bean.getSiteContract().setFirstEffectiveDt(effDate);
//					}
////					this.getSumRent();
//					
//				}
//			}else{
//				semmsi004tab2Bean.getSiteContract().setAgeYear(null);
//				semmsi004tab2Bean.getSiteContract().setAgeMonth(null);
//				semmsi004tab2Bean.getSiteContract().setAgeDay(null);
//				if(effDate != null) semmsi004tab2Bean.getSiteContract().setFirstEffectiveDt(effDate);
//			} 
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}
		return flag;
	}
	
	public void doGetSiteAppRentServSrch(){
		log.debug(" #### Start SEMMSI004Tab3Action doGetSiteAppRentServSrch ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP paramObj = new SiteInfoMapSiteAcqSP();
		try{
			if(semmsi004tab3Bean.getSiteInfoId() != null)paramObj.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_RENT_SERV_SRCH.name, paramObj);
			log.debug("size [" + to.size() + "]");
			
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab3Bean.setRenderedMsgDataNotFound(true);
//				semmsi004tab3Bean.setSiteContInfo(null);
				
			}
			
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab3Bean.setRenderedMsgDataNotFound(false);

				semmsi004tab3Bean.setSiteAppRentServList(new ArrayList<WrapperBeanObject<SiteInfoMapSiteAcqSP>>());
				
				for (SiteInfoMapSiteAcqSP siteAcq : to) {
//					SiteAppSP siteAcq = (SiteAppSP) to.get(i);
					WrapperBeanObject<SiteInfoMapSiteAcqSP> tmpWrapperBean = new WrapperBeanObject<SiteInfoMapSiteAcqSP>();
					
//					if(siteAcq.getNoExpFlag() != null){
//						if(StringUtils.equals("Y", siteAcq.getNoExpFlag().toUpperCase())){
//							semmsi004tab3Bean.setNoExpFlag(true);
//						}else{
//							semmsi004tab3Bean.setNoExpFlag(false);
//						}
//					}else{
//						semmsi004tab3Bean.setNoExpFlag(false);
//					}
					
					tmpWrapperBean.setMessage("");
					tmpWrapperBean.setCheckBox(false);
					tmpWrapperBean.setDataObj(siteAcq);
					
					if(siteAcq != null){
						semmsi004tab3Bean.getSiteAppRentServList().add(tmpWrapperBean);
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab3Action doGetSiteAppRentServSrch : "+e);
		}finally{
			log.debug(" #### End SEMMSI004Tab3Action doGetSiteAppRentServSrch ####");
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}
	}
	
	public void doSetParamConfirmNotChangeRental(){
		log.debug(" ####### Start SEMMSI004Tab3Action doSetParamConfirmNotChangeRental ####### ");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab3Bean.getRentEditFlag())){
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
			itemObj.setMethodWithNavi("doCheckRentalChange");
			itemObj.setActionWithNavi("SEMMSI004Tab3");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckRentalChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab3");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab3Action doSetParamConfirmNotChangeRental : "+e);
			
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" ####### End SEMMSI004Tab3Action doSetParamConfirmNotChange  ####### ");
		}
	}
	
	public boolean doCheckRentalChange(){
		log.debug(" ##### Start SEMMSI004Tab3Action doCheckRentalChange ##### ");
		boolean flag = true;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
			if(StringUtils.equals("Y", confirmNotChRental)){
				if(StringUtils.equals("Y", changeType)){
					log.debug(" doCheckRentalChange changeType = "+ changeType);
					this.doRentalUndo();
				}
				
				//TODO clear save param obj
				this.doClearRentCond();
			}else{
				if(semmsi004tab3Bean.isChkRentalEditFlag()){
					semmsi004tab3Bean.setRentEditFlag("Y");
				}else{
					semmsi004tab3Bean.setRentEditFlag("N");
				}
//				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
			}
			
			//set render panel deposit
			if(StringUtils.equals("Y", semmsi004tab3Bean.getRentEditFlag())){
				semmsi004tab3Bean.setChkRentalEditFlag(true);
			}else{
				semmsi004tab3Bean.setChkRentalEditFlag(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ##### Error SEMMSI004Tab3Action doCheckRentalChange : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab3Action doCheckRentalChange ##### ");
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			flag = false;
		}
		return flag;
	}
	
	public boolean doRentalUndo(){
		
		log.debug(" #### Start SEMMSI004tab3Action doRentalUndo ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		boolean flag = true;
		try{
			log.debug("doRentalUndo getSiteAppId :"+semmsi004tab3Bean.getSiteInfoId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			objParam.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_RENTAL_UNDO.name, objParam);
			log.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab3Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab3Bean.setRentCondSPList(new ArrayList<Msi004SrchRentCondSP>());
			}
				
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab3Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						
						this.semmsi004SearchRentCond(semmsi004tab3Bean.getSiteInfoId(),"01");
						
					}else{
						
						semmsi004tab3Bean.setRenderedMsgDataNotFound(true);
						addGeneralMessageError(siteAcq.getResultMsg());
					
					}
					
				}else{
					addMessageError("Error SEMMSI004Tab3Action doRentalUndo : ","E0001");
				}

			}else{
				addMessageError("Error SEMMSI004Tab3Action doRentalUndo : ","E0001");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("Error SEMMSI004Tab3Action doRentalUndo : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab3Action doRentalUndo #####");
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}
		return flag;
	}
	
	public void doSetParamConfirmNotChangeRentalDeposit(){
		log.debug(" ####### Start SEMMSI004Tab3Action doSetParamConfirmNotChangeRentalDeposit ####### ");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		try{
			ItemResultSP itemObj = new ItemResultSP();
			
			if(StringUtils.equals("N", semmsi004tab3Bean.getRentDepositEditFlag())){
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
			itemObj.setMethodWithNavi("doCheckRentalDepositChange");
			itemObj.setActionWithNavi("SEMMSI004Tab3");
	
			itemObj.setCancelBtnLabel("No");
			itemObj.setNavProgramCancel("SEMMSI004-2");
			itemObj.setMethodWithNaviCancel("doCheckRentalDepositChange");
			itemObj.setActionWithNaviCancel("SEMMSI004Tab3");
			
			
			
			//set param in button OK
			itemObj.setVal2("Y");
			
			//set param in button Cancel
			itemObj.setVal4("N");
			
			Object obj = itemObj;
			this.getSemmsi004Action().doSetParamPopupConfirm(obj);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug("###### Error SEMMSI004Tab3Action doSetParamConfirmNotChangeRentalDeposit : "+e);
			
		}finally{
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			log.debug(" ####### End SEMMSI004Tab3Action doSetParamConfirmNotChangeRentalDeposit  ####### ");
		}
	}
	
	public boolean doCheckRentalDepositChange(){
		log.debug(" ##### Start SEMMSI004Tab3Action doCheckRentalDepositChange ##### ");
		boolean flag = true;
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		String changeType = getFacesUtils().getRequestParameter("val1") == null ? "" : (String)getFacesUtils().getRequestParameter("val1");
		String confirmNotChRental = getFacesUtils().getRequestParameter("val2") == null ? "" : (String)getFacesUtils().getRequestParameter("val2");
		try{
			if(StringUtils.equals("Y", confirmNotChRental)){
				if(StringUtils.equals("Y", changeType)){
					log.debug(" doCheckRentalDepositChange changeType = "+ changeType);
					this.doRentalDepositUndo();
				}
				
				//TODO clear save param obj
				this.doClearDepositNormal();
			}else{
				if(semmsi004tab3Bean.isChkRentalDepositEditFlag()){
					semmsi004tab3Bean.setRentDepositEditFlag("Y");
				}else{
					semmsi004tab3Bean.setRentDepositEditFlag("N");
				}
//				semmsa002Bean.getSiteAppObjParam().setRentEditFlag(changeType);
			}
			
			//set render panel deposit
			if(StringUtils.equals("Y", semmsi004tab3Bean.getRentDepositEditFlag())){
				semmsi004tab3Bean.setChkRentalDepositEditFlag(true);
			}else{
				semmsi004tab3Bean.setChkRentalDepositEditFlag(false);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.debug(" ##### Error SEMMSI004Tab3Action doCheckRentalDepositChange : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab3Action doCheckRentalDepositChange ##### ");
			setSemmsi004tab3Bean(semmsi004tab3Bean);
			flag = false;
		}
		return flag;
	}
	
	public boolean doRentalDepositUndo(){
		
		log.debug(" #### Start SEMMSI004tab3Action doRentalDepositUndo ####");
		semmsi004tab3Bean = getSemmsi004tab3Bean();
		ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService"); 
		List<SiteInfoMapSiteAcqSP> to = null;
		SiteInfoMapSiteAcqSP objParam = new SiteInfoMapSiteAcqSP();
		boolean flag = true;
		try{
			log.debug("doRentalDepositUndo getSiteAppId :"+semmsi004tab3Bean.getSiteInfoId());
//			semmsa002Bean.getSiteAppObjParam().setRentContMode("C");
			objParam.setSiteInfoId(semmsi004tab3Bean.getSiteInfoId());
			objParam.setUserId(getUserLogIn());
			to = service.siteAppSiteDao_querySPList(EQueryName.SP_MSI004_SITE_INFO_RENTAL_DEPOSIT_UNDO.name, objParam);
			log.debug("size [" + to.size() + "]");
				
			if(to == null || to.isEmpty()){
				// set data not found message
				semmsi004tab3Bean.setRenderedMsgDataNotFound(true);
				semmsi004tab3Bean.setRentCondSPList(new ArrayList<Msi004SrchRentCondSP>());
			}
				
			if(to != null && to.size() > 0){
//				flag = true;
				semmsi004tab3Bean.setRenderedMsgDataNotFound(false);
				SiteInfoMapSiteAcqSP siteAcq = (SiteInfoMapSiteAcqSP) to.get(0);
				if(StringUtils.isNotEmpty( siteAcq.getRowId())){
					if(StringUtils.equals("SUCCESS", siteAcq.getRetResult().toUpperCase())){
						
						this.semmsi004SearchDepositRentBG(semmsi004tab3Bean.getSiteInfoId());
						this.semmsi004SearchDepositRentCash(semmsi004tab3Bean.getSiteInfoId());
						this.doClearDepositNormal();
					}else{
						
						semmsi004tab3Bean.setRenderedMsgDataNotFound(true);
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
			log.debug("Error SEMMSI004Tab3Action doRentalDepositUndo : "+e);
		}finally{
			log.debug(" ##### End SEMMSI004Tab3Action doRentalDepositUndo #####");
			setSemmsi004tab3Bean(semmsi004tab3Bean);
		}
		return flag;
	}
	
	
}
