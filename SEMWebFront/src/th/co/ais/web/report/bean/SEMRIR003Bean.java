package th.co.ais.web.report.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupMultiZoneBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRIR003Bean extends AbstractReportBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 773571588220830326L;
	private String company;
	private String insuranceYear;
	private String regions;
	private String lostType;
	private String zones;

	private List<SelectItem> companyList;
	private List<SelectItem> lostTypeList;

	private PopupMultiZoneBean popupMultiZoneBean;

	public SEMRIR003Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getInsuranceYear() {
		return insuranceYear;
	}

	public void setInsuranceYear(String insuranceYear) {
		this.insuranceYear = insuranceYear;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	public String getLostType() {
		return lostType;
	}

	public void setLostType(String lostType) {
		this.lostType = lostType;
	}

	public String getZones() {
		return zones;
	}

	public void setZones(String zones) {
		this.zones = zones;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getLostTypeList() {
		return lostTypeList;
	}

	public void setLostTypeList(List<SelectItem> lostTypeList) {
		this.lostTypeList = lostTypeList;
	}

	public PopupMultiZoneBean getPopupMultiZoneBean() {
		return (PopupMultiZoneBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiZoneBean");
	}

	public void setPopupMultiZoneBean(PopupMultiZoneBean popupMultiZoneBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiZoneBean", popupMultiZoneBean);
	}

	@Override
	public int getRowPerPage() {
		return rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

}
