package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.RegionZone;
import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.report.AbstractReportBean;
import th.co.ais.web.util.FacesUtils;

public class SEMRSI012Bean extends AbstractReportBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4138051482284034078L;
	private List<SelectItem> regionList;
	private List<SelectItem> zoneList;
	private RegionZone regionZone;
	private String region;
	private String zone;
	
	
//	private PopupMultiZoneBean popupMultiZoneBean;

	
//	public PopupMultiZoneBean getPopupMultiZoneBean() {
//		PopupMultiZoneBean popupMultiZone = (PopupMultiZoneBean) FacesUtils.getInstance().getSessionMapValue("popupMultiZoneBean");
//		if (popupMultiZone == null) {
//			popupMultiZone = new PopupMultiZoneBean();
//		}
//		return popupMultiZone;
//	}
//
//
//	public void setPopupMultiZoneBean(PopupMultiZoneBean popupMultiZoneBean) {
//		FacesUtils.getInstance().setSessionMapValue("popupMultiZoneBean",popupMultiZoneBean);
//		this.popupMultiZoneBean = popupMultiZoneBean;
//	}


	public List<SelectItem> getZoneList() {
		return zoneList;
	}


	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}


	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}


	public SEMRSI012Bean() {
		super(ServiceConstants.TYPE_XLS);
	}


	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public RegionZone getRegionZone() {
		return regionZone;
	}


	public void setRegionZone(RegionZone regionZone) {
		this.regionZone = regionZone;
	}


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

}
