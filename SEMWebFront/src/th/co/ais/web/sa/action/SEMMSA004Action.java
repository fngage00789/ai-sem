package th.co.ais.web.sa.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.service.sa.ISiteAcquistionService;
import th.co.ais.util.ELovType;
import th.co.ais.util.EQueryName;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.action.AbstractAction;
import th.co.ais.web.sa.bean.SEMMSA004Bean;
import th.co.ais.web.util.FrontMessageUtils;

public class SEMMSA004Action extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7699285993768992130L;
	private static final Logger LOG = Logger.getLogger(SEMMSA004Action.class);
	
	private SEMMSA004Bean semmsa004Bean;

	public SEMMSA004Bean getSemmsa004Bean() {
		return (SEMMSA004Bean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("semmsa004Bean");
	}

	public void setSemmsa004Bean(SEMMSA004Bean semmsa004Bean) {
		this.semmsa004Bean = semmsa004Bean;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("semmsa004Bean", semmsa004Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		LOG.info("::: SEMMSA004Action :: actionWithNavi >> BEGIN :::");
		boolean flag = false;
		
		try {
			
			semmsa004Bean = getSemmsa004Bean();
			
			if(methodWithNavi.equalsIgnoreCase("doInitialExctApprove")) {
				flag = this.doInitialExctApproveList();
			}
			
			setSemmsa004Bean(semmsa004Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA004Action");
			flag = false;
			
			//semmsa004Bean.setRenderedMsgAlert(true);
			setSemmsa004Bean(semmsa004Bean);
		} finally {
			LOG.info("::: SEMMSA004Action :: actionWithNavi >> END :::");
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		LOG.info("::: SEMMSA004Action :: init >> BEGIN :::");
		
		try {
			
			SEMMSA004Bean semmsa004Bean = new SEMMSA004Bean();
			
			// >> initial declare 
			semmsa004Bean.setCompanyList(getLovItemsByType(ELovType.T_COMPANY.name));
			
			semmsa004Bean.setSiteAppObjParam(new SiteAppSP());
			semmsa004Bean.setExctApproveList(new ArrayList<WrapperBeanObject<SiteAppSP>>());

			setSemmsa004Bean(semmsa004Bean);
			// << initial declare 
			
			// >> do other thing after.. initial declared
			this.doInitialExctApproveList();
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA004Action");
			
			semmsa004Bean.setRenderedMsgAlert(true);
			setSemmsa004Bean(semmsa004Bean);
		} finally {
			LOG.info("::: SEMMSA004Action :: init >> END :::");
		}
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean doInitialExctApproveList() {
		LOG.info("::: SEMMSA004Action :: doInitialExctApproveList >> BEGIN :::");
		boolean flag = true;

		try {
			semmsa004Bean = getSemmsa004Bean();
			
			ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
			List<SiteAppSP> resultList = new ArrayList<SiteAppSP>();
			
			semmsa004Bean.setExctApproveList(new ArrayList<WrapperBeanObject<SiteAppSP>>());
			
			resultList = service.siteAppDao_querySPList(EQueryName.SP_MSA004_EXECUTIVE_TO_DO_LIST.name, semmsa004Bean.getSiteAppObjParam());
			
			if(resultList != null && !resultList.isEmpty()){
				for(int i = 0; i < resultList.size(); i++){
					SiteAppSP ret = (SiteAppSP) resultList.get(i);
					
					WrapperBeanObject<SiteAppSP> tmpWrapperBean = new WrapperBeanObject<SiteAppSP>();
					
					if(ret.getEffectiveDt() != null){
						ret.setEffectiveDtStr(this.convertYearENtoTHStr(ret.getEffectiveDt()));
					}
					
					if(ret.getExpireDt() != null){
						ret.setExpireDtStr(this.convertYearENtoTHStr(ret.getExpireDt()));
					}
					
					tmpWrapperBean.setDataObj(ret);
					tmpWrapperBean.setMessage("");

					semmsa004Bean.getExctApproveList().add(tmpWrapperBean);
				}
        	} else {
        		addMessageWarn("M0004");	// data not found
        		semmsa004Bean.setRenderedMsgAlert(true);
        	}
			
			setSemmsa004Bean(semmsa004Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA004Action");
			flag = false;
			
			semmsa004Bean.setRenderedMsgAlert(true);
			setSemmsa004Bean(semmsa004Bean);
		} finally {
			LOG.info("::: SEMMSA004Action :: doInitialExctApproveList >> END :::");
		}
		return flag;
	}
	
	public void doPrepareCallPopup() {
		try {
			
			semmsa004Bean = getSemmsa004Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			semmsa004Bean.getSiteAppObjParam().setSiteAppId(paramSiteAppId);

			setSemmsa004Bean(semmsa004Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA004Action");
			
			semmsa004Bean.setRenderedMsgAlert(true);
			setSemmsa004Bean(semmsa004Bean);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void doSaveAvpApprove() {
		LOG.info("::: SEMMSA004Action :: doSaveAvpApprove >> BEGIN :::");
		
		try {
			
			semmsa004Bean = getSemmsa004Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			LOG.info("ooo siteAppId: " + paramSiteAppId);

			if(!paramSiteAppId.equals("")) {
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> resultList = new ArrayList<SiteAppSP>();
				
				semmsa004Bean.getSiteAppObjParam().setSiteAppId(paramSiteAppId);
				semmsa004Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	
				resultList = service.siteAppDao_querySPList(EQueryName.SP_MSA004_EXECUTIVE_APPROVE.name, semmsa004Bean.getSiteAppObjParam());
				
				if (resultList != null && !resultList.isEmpty()) {
					if (resultList.get(0).getRetResult().equals("Success")) {
						addMessageInfo("M0001");	// data save success
						
						// reload
						this.doInitialExctApproveList();
					} else {
						addMessageError("E0001");	// data save fail
					}
					semmsa004Bean.setRenderedMsgAlert(true);
				}
			}

			setSemmsa004Bean(semmsa004Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA004Action");
			
			semmsa004Bean.setRenderedMsgAlert(true);
			setSemmsa004Bean(semmsa004Bean);
		} finally {
			LOG.info("::: SEMMSA004Action :: doSaveAvpApprove >> END :::");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void doSaveReject() {
		LOG.info("::: SEMMSA004Action :: doSaveReject >> BEGIN :::");
		
		try {
			
			semmsa004Bean = getSemmsa004Bean();
			
			String paramSiteAppId = getFacesUtils().getRequestParameter("paramSiteAppId") == null ? "" : (String) getFacesUtils().getRequestParameter("paramSiteAppId");
			String strRemark = semmsa004Bean.getSiteAppObjParam().getRemark() == null ? "" : semmsa004Bean.getSiteAppObjParam().getRemark();
			LOG.info("ooo siteAppId: " + paramSiteAppId);
			LOG.info("ooo remark: " + strRemark);

			if(paramSiteAppId.equals("")) {
				// error when 'siteAppId' is null
				addMessageError("EL0000", "SEMMSA004Action");
				semmsa004Bean.setRenderedMsgAlert(true);
			} else if(strRemark.equals("")) {
				FrontMessageUtils.addMessageWarn("กรุณาระบุ เหตุผล");	// optional
				semmsa004Bean.setRenderedMsgAlert(true);
			} else {
				ISiteAcquistionService service = (ISiteAcquistionService)getBean("siteAcquistionService");
				List<SiteAppSP> resultList = new ArrayList<SiteAppSP>();
				
				semmsa004Bean.getSiteAppObjParam().setSiteAppId(paramSiteAppId);
				semmsa004Bean.getSiteAppObjParam().setUserLogin(getUserLogIn());
	
				resultList = service.siteAppDao_querySPList(EQueryName.SP_MSA004_EXECUTIVE_REJECT.name, semmsa004Bean.getSiteAppObjParam());
				
				if (resultList != null && !resultList.isEmpty()) {
					if (resultList.get(0).getRetResult().equals("Success")) {
						addMessageInfo("M0001");	// data save success
						
						// reload
						this.doInitialExctApproveList();
					} else {
						addMessageError("E0001");	// data save fail
					}
					semmsa004Bean.setRenderedMsgAlert(true);
				}
			}

			setSemmsa004Bean(semmsa004Bean);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error(e);
			addMessageError("EL0000", "SEMMSA004Action");
			
			semmsa004Bean.setRenderedMsgAlert(true);
			setSemmsa004Bean(semmsa004Bean);
		} finally {
			LOG.info("::: SEMMSA004Action :: doSaveReject >> END :::");
		}
	}
	
	// custom convert DTM
	public String convertYearENtoTHStr(Date date){
		if(date == null)
			return null;
		try {
			return this.convertToThYearStr(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String convertToThYearStr(Date inputDate) throws Exception {
		String result = "";
		try {
			Date currentDate = SEMDataUtility.getCurrentDate();
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
			SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
			SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

			String strCurrYear = yearFormat.format(currentDate);
			String strInputYear = yearFormat.format(inputDate);
			String strInputMonth = monthFormat.format(inputDate);
			String strInputDay = dayFormat.format(inputDate);
			String strInputTime = timeFormat.format(inputDate);
			if (StringUtils.isNumeric(strInputYear) && StringUtils.isNumeric(strCurrYear)) {
				int inputYear = Integer.parseInt(strInputYear);
				int currYear = Integer.parseInt(strCurrYear);

				// lazy solution 555 !!
				if (inputYear < 2400) {
					inputYear += 543;
				}

					strInputYear = Integer.toString(inputYear);
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
					inputDate = (Date) formatter.parse(strInputDay + "/" + strInputMonth + "/" + strInputYear + " " + strInputTime);
					result = strInputDay + "/" + strInputMonth + "/" + strInputYear;
				//}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		return result;
	}
	// custom convert DTM

}
