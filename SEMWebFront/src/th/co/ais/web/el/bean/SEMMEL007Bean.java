package th.co.ais.web.el.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.MeterInstallmentSearch;
import th.co.ais.domain.el.PrepaidInfo;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL007Bean extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5024155468436141123L;

	// Search
	private PrepaidInfo prepaidInfo;
	private MeterInstallmentSearch criteria;
	private List<MeterInstallmentSearch> resultList;
	// DropDown
	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> provinceList;

	public PrepaidInfo getPrepaidInfo() {
		return prepaidInfo;
	}

	public void setPrepaidInfo(PrepaidInfo prepaidInfo) {
		this.prepaidInfo = prepaidInfo;
	}

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

	public List<SelectItem> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public MeterInstallmentSearch getCriteria() {
		return criteria;
	}

	public void setCriteria(MeterInstallmentSearch criteria) {
		this.criteria = criteria;
	}

	public List<MeterInstallmentSearch> getResultList() {
		return resultList;
	}

	public void setResultList(List<MeterInstallmentSearch> resultList) {
		this.resultList = resultList;
	}

}
