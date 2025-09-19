package th.co.ais.web.report.bean;

import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import th.co.ais.rpt.service.ServiceConstants;
import th.co.ais.web.bean.common.PopupMultiVendorBean;
import th.co.ais.web.bean.common.PopupSiteMultiContractBean;
import th.co.ais.web.bean.common.PopupSiteMultiLocationBean;
import th.co.ais.web.bean.common.PopupSiteMultiRegionBean;
import th.co.ais.web.report.AbstractReportBean;

public class SEMRRT012Bean extends AbstractReportBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621663925471015690L;
	
	private List<SelectItem> companyList;
	private List<SelectItem> depositTypeList;
	private List<SelectItem> bankCodeList;
	private List<SelectItem> expenseTypeList;
	private List<SelectItem> contactStatusList;
	private List<SelectItem> networkStatusList;
	private String company;
	private String contractNo;
	private String locationId;
	private String region;
	private String vendor;
	private String depositType;
	private String payDate;
	private String asOfDate;
	private String bgNumber;
	private String bankCode;
	private String expenseType;
	private String contactStatus;
	private String networkStatus;
	private String depositStatus;
	private String multiContract;
	private String multiRegion;
	private String multiVendor;
	
	
	private PopupSiteMultiLocationBean popupSiteMultiLocationBean;
	private PopupSiteMultiContractBean popupSiteMultiContractBean;
	private PopupSiteMultiRegionBean popupSiteMultiRegionBean;
	private PopupMultiVendorBean popupMultiVendorBean;
	
	private boolean disableBgNo = true;
	private boolean disableBank = true;
	private Date depositDtFrom;
	private Date depositDtTo;
	
	public SEMRRT012Bean() {
		super(ServiceConstants.TYPE_XLS);
	}
	
	
	public PopupSiteMultiContractBean getPopupSiteMultiContractBean() {
		return (PopupSiteMultiContractBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiContractBean");
	}
	

	public String getBankCode() {
		return bankCode;
	}


	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	public String getExpenseType() {
		return expenseType;
	}


	public String getMultiContract() {
		return multiContract;
	}


	public void setMultiContract(String multiContract) {
		this.multiContract = multiContract;
	}


	public String getMultiRegion() {
		return multiRegion;
	}


	public void setMultiRegion(String multiRegion) {
		this.multiRegion = multiRegion;
	}


	public String getMultiVendor() {
		return multiVendor;
	}


	public void setMultiVendor(String multiVendor) {
		this.multiVendor = multiVendor;
	}


	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}


	public String getContactStatus() {
		return contactStatus;
	}


	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}


	public String getNetworkStatus() {
		return networkStatus;
	}


	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}


	public String getDepositStatus() {
		return depositStatus;
	}


	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}


	public void setPopupSiteMultiContractBean(
		PopupSiteMultiContractBean popupSiteMultiContractBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiContractBean", popupSiteMultiContractBean);
	}
	
	public PopupSiteMultiLocationBean getPopupSiteMultiLocationBean() {
		return (PopupSiteMultiLocationBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiLocationBean");
	}


	public List<SelectItem> getExpenseTypeList() {
		return expenseTypeList;
	}


	public void setExpenseTypeList(List<SelectItem> expenseTypeList) {
		this.expenseTypeList = expenseTypeList;
	}


	public List<SelectItem> getContactStatusList() {
		return contactStatusList;
	}


	public void setContactStatusList(List<SelectItem> contactStatusList) {
		this.contactStatusList = contactStatusList;
	}


	public List<SelectItem> getNetworkStatusList() {
		return networkStatusList;
	}


	public void setNetworkStatusList(List<SelectItem> networkStatusList) {
		this.networkStatusList = networkStatusList;
	}


	public List<SelectItem> getBankCodeList() {
		return bankCodeList;
	}


	public void setBankCodeList(List<SelectItem> bankCodeList) {
		this.bankCodeList = bankCodeList;
	}


	public void setPopupSiteMultiLocationBean(
		PopupSiteMultiLocationBean popupSiteMultiLocationBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiLocationBean", popupSiteMultiLocationBean);
	}
	
	public String getBgNumber() {
		return bgNumber;
	}


	public void setBgNumber(String bgNumber) {
		this.bgNumber = bgNumber;
	}


	public PopupSiteMultiRegionBean getPopupSiteMultiRegionBean() {
		return (PopupSiteMultiRegionBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupSiteMultiRegionBean");
	}


	public void setPopupSiteMultiRegionBean(
			PopupSiteMultiRegionBean popupSiteMultiRegionBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupSiteMultiRegionBean", popupSiteMultiRegionBean);
	}

	public PopupMultiVendorBean getPopupMultiVendorBean() {
		return (PopupMultiVendorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("popupMultiVendorBean");
	}


	public void setPopupMultiVendorBean(
			PopupMultiVendorBean popupMultiVendorBean) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("popupMultiVendorBean", popupMultiVendorBean);
	}
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}


	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}


	public List<SelectItem> getDepositTypeList() {
		return depositTypeList;
	}


	public void setDepositTypeList(List<SelectItem> depositTypeList) {
		this.depositTypeList = depositTypeList;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getContractNo() {
		return contractNo;
	}


	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}


	public String getLocationId() {
		return locationId;
	}


	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public String getDepositType() {
		return depositType;
	}


	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}


	public String getPayDate() {
		return payDate;
	}


	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}


	public String getAsOfDate() {
		return asOfDate;
	}


	public void setAsOfDate(String asOfDate) {
		this.asOfDate = asOfDate;
	}


	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}


	public boolean isDisableBgNo() {
		return disableBgNo;
	}


	public void setDisableBgNo(boolean disableBgNo) {
		this.disableBgNo = disableBgNo;
	}


	public boolean isDisableBank() {
		return disableBank;
	}


	public void setDisableBank(boolean disableBank) {
		this.disableBank = disableBank;
	}


	public Date getDepositDtFrom() {
		return depositDtFrom;
	}


	public void setDepositDtFrom(Date depositDtFrom) {
		this.depositDtFrom = depositDtFrom;
	}


	public Date getDepositDtTo() {
		return depositDtTo;
	}


	public void setDepositDtTo(Date depositDtTo) {
		this.depositDtTo = depositDtTo;
	}
	
	
}
