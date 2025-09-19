package th.co.ais.web.rt.bean;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import th.co.ais.domain.rt.RentalPaySSearchSp;
import th.co.ais.domain.rt.RentalPaySearchSP;
import th.co.ais.web.bean.AbstractBean;
import th.co.ais.web.bean.common.PopupRentalPayBean;

public class SEMMRT002Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> siteStatusList;
	private List<SelectItem> networkStatusList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> rentalPayExpenseTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> paymentStatusList;
	private List<SelectItem> paymentTypeList;
	private List<SelectItem> jobTypeList;
	
	private List<RentalPaySSearchSp> rentalPaySSearchSpList;
	private RentalPaySSearchSp rentalPaySSearchSp;
	
	private List<RentalPaySearchSP> rentalPaySearchSPList;
	private RentalPaySearchSP rentalPaySearchSP;
	
	//for rendered field Seacrh 3 feild
	private boolean tmpGroup1;
	
	//for rendered field Seacrh 1 feild
	private boolean tmpGroup2;
	
	public boolean RenderedMsgDataNotFound2 = false;
	
	
	private PopupRentalPayBean popupRentalPayBean;
	
	public List<RentalPaySSearchSp> getRentalPaySSearchSpList() {
		return rentalPaySSearchSpList;
	}
	public void setRentalPaySSearchSpList(
			List<RentalPaySSearchSp> rentalPaySSearchSpList) {
		this.rentalPaySSearchSpList = rentalPaySSearchSpList;
	}
	public RentalPaySSearchSp getRentalPaySSearchSp() {
		return rentalPaySSearchSp;
	}
	public void setRentalPaySSearchSp(RentalPaySSearchSp rentalPaySSearchSp) {
		this.rentalPaySSearchSp = rentalPaySSearchSp;
	}
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
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
	public List<SelectItem> getSiteStatusList() {
		return siteStatusList;
	}
	public void setSiteStatusList(List<SelectItem> siteStatusList) {
		this.siteStatusList = siteStatusList;
	}
	public List<SelectItem> getNetworkStatusList() {
		return networkStatusList;
	}
	public void setNetworkStatusList(List<SelectItem> networkStatusList) {
		this.networkStatusList = networkStatusList;
	}
	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}
	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}
	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}
	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}
	public List<SelectItem> getPaymentStatusList() {
		return paymentStatusList;
	}
	public void setPaymentStatusList(List<SelectItem> paymentStatusList) {
		this.paymentStatusList = paymentStatusList;
	}
	public List<RentalPaySearchSP> getRentalPaySearchSPList() {
		return rentalPaySearchSPList;
	}
	public void setRentalPaySearchSPList(
			List<RentalPaySearchSP> rentalPaySearchSPList) {
		this.rentalPaySearchSPList = rentalPaySearchSPList;
	}
	public RentalPaySearchSP getRentalPaySearchSP() {
		return rentalPaySearchSP;
	}
	public void setRentalPaySearchSP(RentalPaySearchSP rentalPaySearchSP) {
		this.rentalPaySearchSP = rentalPaySearchSP;
	}
	public void setPaymentTypeList(List<SelectItem> paymentTypeList) {
		this.paymentTypeList = paymentTypeList;
	}
	public List<SelectItem> getPaymentTypeList() {
		return paymentTypeList;
	}
	public void setRentalPayExpenseTypeList(List<SelectItem> rentalPayExpenseTypeList) {
		this.rentalPayExpenseTypeList = rentalPayExpenseTypeList;
	}
	public List<SelectItem> getRentalPayExpenseTypeList() {
		return rentalPayExpenseTypeList;
	}
	public boolean isTmpGroup1() {
		return tmpGroup1;
	}
	public void setTmpGroup1(boolean tmpGroup1) {
		this.tmpGroup1 = tmpGroup1;
	}
	public boolean isTmpGroup2() {
		return tmpGroup2;
	}
	public void setTmpGroup2(boolean tmpGroup2) {
		this.tmpGroup2 = tmpGroup2;
	}
	public List<SelectItem> getJobTypeList() {
		return jobTypeList;
	}
	public void setJobTypeList(List<SelectItem> jobTypeList) {
		this.jobTypeList = jobTypeList;
	}
	public PopupRentalPayBean getPopupRentalPayBean() {
		return (PopupRentalPayBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupRentalPayBean");
	}
	public void setPopupRentalPayBean(PopupRentalPayBean popupRentalPayBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupRentalPayBean", popupRentalPayBean);
	}
	public boolean isRenderedMsgDataNotFound2() {
		return RenderedMsgDataNotFound2;
	}
	public void setRenderedMsgDataNotFound2(boolean renderedMsgDataNotFound2) {
		RenderedMsgDataNotFound2 = renderedMsgDataNotFound2;
	}
	
	
}
