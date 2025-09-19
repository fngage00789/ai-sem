package th.co.ais.web.report.action;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jboss.remoting.transport.web.WebUtil;

import th.co.ais.domain.gm.Zone;
import th.co.ais.rpt.parameter.SEMRSI012ReportParameter;
import th.co.ais.service.gm.IZoneService;
import th.co.ais.util.ELovType;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.report.AbstractReportAction;
import th.co.ais.web.report.bean.SEMRSI012Bean;
import th.co.ais.web.util.SemUtils;
import th.co.ais.web.util.ZoneCasheUtil;

public class SEMRSI012Action extends AbstractReportAction {
	private static final long serialVersionUID = -7410440438777216616L;
	private Logger log = Logger.getLogger(getClass());
	private SEMRSI012Bean semrsi012Bean;

	public SEMRSI012Bean getSemrsi012Bean() {
		return (SEMRSI012Bean) getFacesUtils().getSessionMapValue(
				"semrsi012Bean");
	}

	public void setSemrsi012Bean(SEMRSI012Bean semrsi012Bean) {
		getFacesUtils().setSessionMapValue("semrsi012Bean", semrsi012Bean);
	}

	@Override
	public boolean actionWithNavi(String methodWithNavi) {
		boolean flag = false;

		if (methodWithNavi.equalsIgnoreCase("doRunReport")) {
			runReport();
		} else if (methodWithNavi.equalsIgnoreCase("doShowReport")) {
			showReport();
		} else if (methodWithNavi.equalsIgnoreCase("doClearReport")) {
			clearReport();
		}
		return flag;
	}

	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		super.clearSessionBean();

		semrsi012Bean = new SEMRSI012Bean();
		semrsi012Bean.setRegionList(getRegionItems());
//		semrsi012Bean.setZoneList(ZoneCasheUtil.getInstance().getZoneSelList());
		semrsi012Bean.setZoneList(getEmptyDropDown());
		semrsi012Bean.setRegionZone(getRegionZoneList());
		setSemrsi012Bean(semrsi012Bean);
	}

	@Override
	public boolean validate() {
		boolean flgValid = true;
		if (StringUtils.isEmpty(getSemrsi012Bean().getRegion())) {
			addMessageError("W0001", msg("message.region"));
			flgValid = false;
		}

		return flgValid;
	}

	@Override
	public void clearReport() {
		// TODO Auto-generated method stub
		super.clearSessionBean();
		getSemrsi012Bean().clearReportSimple();
		
		getSemrsi012Bean().setRegion(null);
		
		enableBatchType();
	}

	@Override
	public void enableBatchType() {
		// TODO Auto-generated method stub
		super.enableBatchType("semrsi012Bean");
	}

	@Override
	public void resetReportDate() {
		// TODO Auto-generated method stub
		super.resetReportDate("semrsi012Bean");
	}

	@Override
	public void runReport() {
		// TODO Auto-generated method stub
		semrsi012Bean = getSemrsi012Bean();
		SEMRSI012ReportParameter param = null;
		List<SelectItem> s = null;
		if (validate()) {
			try {
				param = new SEMRSI012ReportParameter();
				param.setRegion(semrsi012Bean.getRegion());
				param.setP_username(getUserLogIn());
				param.setP_zone(semrsi012Bean.getZone());
				if(StringUtils.isNotEmpty(semrsi012Bean.getZone())){
					List<SelectItem> z = th.co.ais.web.util.WebUtil.getSelectItemByValue(semrsi012Bean.getZone(), semrsi012Bean.getZoneList());
					if (z!=null){
						param.setP_display_zone(z.get(0).getLabel());
					}
				}
				super.runReport("SEMRSI012", param, semrsi012Bean
						.getReportType(), semrsi012Bean.getRunType(),
						semrsi012Bean.getBatchType(), semrsi012Bean
								.getJobSchedule());

			} catch (Exception e) {
				log.error("RUN REPORT ERROR IN " + getClass() + " : " + e);
				e.printStackTrace();
			} finally {
				param = null;
			}
		}
	}

	
	@Override
	public void showReport() {
		// TODO Auto-generated method stub
		super.showReport("SEMRSI012", getSemrsi012Bean().getReportType());
	}
	
	@Override
	public void clearRenderedMsg(){
	
		semrsi012Bean = getSemrsi012Bean(); 
		semrsi012Bean.setRenderedMsgFormSearch(false);
		semrsi012Bean.setRenderedMsgFormTop(false);
	
	}
	
	public void getZone(){
//		Zone zone = new Zone();
//		List<Zone> zoneList = new ArrayList<Zone>();
//		IZoneService service = (IZoneService)getBean("zoneService");
//		semrsi012Bean = getSemrsi012Bean();
//		try{
//			zone.setRegion(semrsi012Bean.getRegion());
//			zoneList = service.searchZone(zone);
//			if(zoneList != null && zoneList.size() > 0){
//				semrsi012Bean.setZoneList(setZoneList(zoneList));
//			}
//			setSemrsi012Bean(semrsi012Bean);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		semrsi012Bean = getSemrsi012Bean();
		String region = semrsi012Bean.getRegion();
		List<SelectItem> zoneList =  ZoneCasheUtil.getInstance().getZoneSelList();
		List<SelectItem> tmpList = getEmptyDropDown();
		for(SelectItem st : zoneList){
			String s = semrsi012Bean.getRegionZone().findRegionByZone(st.getValue().toString());
			if(StringUtils.isNotEmpty(s)){
				if(s.equals(region)){
					tmpList.add(new SelectItem(st.getValue(),st.getLabel()));
				}
			}
		}
//		semrsi012Bean.getApproveRenewSearchSP().setZone(null);
		semrsi012Bean.setZoneList(tmpList);
		setSemrsi012Bean(semrsi012Bean);
	}
	
	
	public List<SelectItem> setZoneList(List<Zone> zoneList){
		SelectItem selectItem = new SelectItem();
		List<SelectItem> selectListZone = new ArrayList<SelectItem>();
		if(zoneList != null && zoneList.size() > 0){
			selectItem = new SelectItem("" , msg("value.selectItem"));
			selectListZone.add(selectItem);
			for(int i=0;i<zoneList.size();i++){
				selectItem = new SelectItem();
				selectItem.setLabel(zoneList.get(i).getDescription());
				selectItem.setValue(zoneList.get(i).getZone());
				selectListZone.add(selectItem);
			}
		}
		return selectListZone;
	}
}
