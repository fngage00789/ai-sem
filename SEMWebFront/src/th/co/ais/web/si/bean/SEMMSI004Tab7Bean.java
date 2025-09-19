package th.co.ais.web.si.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.Msi004SrchSubRentSP;
import th.co.ais.domain.si.SubRent;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab7Bean extends AbstractBean {

	private static final long serialVersionUID = -7689510868844542871L;
	
	private List<Msi004SrchSubRentSP> subRentSPList;
	private SubRent subRent;
	private boolean disabledBtnAdd;
	private boolean disabledBtnSave;
	private String siteInfoId;
	private List<SelectItem> companyList;
	
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public boolean isDisabledBtnAdd() {
		return disabledBtnAdd;
	}

	public void setDisabledBtnAdd(boolean disabledBtnAdd) {
		this.disabledBtnAdd = disabledBtnAdd;
	}

	public boolean isDisabledBtnSave() {
		return disabledBtnSave;
	}

	public void setDisabledBtnSave(boolean disabledBtnSave) {
		this.disabledBtnSave = disabledBtnSave;
	}


	public List<Msi004SrchSubRentSP> getSubRentSPList() {
		return subRentSPList;
	}

	public void setSubRentSPList(List<Msi004SrchSubRentSP> subRentSPList) {
		this.subRentSPList = subRentSPList;
	}

	public SubRent getSubRent() {
		return subRent;
	}

	public void setSubRent(SubRent subRent) {
		this.subRent = subRent;
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
