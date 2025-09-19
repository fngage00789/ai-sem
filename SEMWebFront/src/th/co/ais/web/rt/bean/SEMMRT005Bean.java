package th.co.ais.web.rt.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.rt.RentalPlan;
import th.co.ais.web.bean.AbstractBean;

public class SEMMRT005Bean extends AbstractBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6737415052461381473L;

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> yearList;
	
	private RentalPlan rpCriteria, rp;
	private List<RentalPlan> rpList;
	
	private String pageStatus;
	private String txtContent;
	private String validatePopup;
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public RentalPlan getRpCriteria() {
		return rpCriteria;
	}

	public void setRpCriteria(RentalPlan rpCriteria) {
		this.rpCriteria = rpCriteria;
	}

	public RentalPlan getRp() {
		return rp;
	}

	public void setRp(RentalPlan rp) {
		this.rp = rp;
	}

	public List<RentalPlan> getRpList() {
		return rpList;
	}

	public void setRpList(List<RentalPlan> rpList) {
		this.rpList = rpList;
	}

	public String getPageStatus() {
		return pageStatus;
	}

	public void setPageStatus(String pageStatus) {
		this.pageStatus = pageStatus;
	}

	public String getTxtContent() {
		return txtContent;
	}

	public void setTxtContent(String txtContent) {
		this.txtContent = txtContent;
	}

	public String getValidatePopup() {
		return validatePopup;
	}

	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}

	public List<SelectItem> getYearList() {
		return yearList;
	}

	public void setYearList(List<SelectItem> yearList) {
		this.yearList = yearList;
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
