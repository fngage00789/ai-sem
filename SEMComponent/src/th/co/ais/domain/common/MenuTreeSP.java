package th.co.ais.domain.common;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class MenuTreeSP extends AbstractDomain {
	

	private static final long serialVersionUID = 276055409979519842L;
	/**
	 * 
	 */
	
	protected String rowId; 
	protected String menuLevel;
	protected String menuLabel;
	protected String menuUrl;
	protected String recordCount;
	protected String menuGroup;
	
	// added 2015/01/22
	protected String menuSubGroup;
	protected String userId;
	protected String strParam;
	
	// 2015/01/30 added by.. YUT
	protected String menuAction;
	
	//2015/02/25 added by.. NEW
	protected String company = "" ;
	protected String region = "";
	protected String elType = "";
	protected String menuGroupType;
	//2017/05/04 added by.. NEW
	protected boolean disableFlag;
	protected boolean renderedFlag;
	protected String headerFlag;
	
	protected BigDecimal mainId;
	protected BigDecimal refId;
	protected BigDecimal menuSeq;
	
	protected String vendorCode;
	protected String payeeName;
	protected String idCard;
	protected String taxId;
	protected String contractNo;
	protected String siteName;
	protected String accountNo;
	protected String accountName;
	protected String batchNo;
	protected String pageFlag;
	protected String userRole;
	protected String userLogin;
	protected String bacthNo;
	
	protected String teamName;
	
	protected String systemType;
	
	protected String createById;
	protected String teamId;
	protected BigDecimal vendorTotal;
	protected BigDecimal bookbankTotal;
	protected BigDecimal payeeTotal;
	protected BigDecimal bookbankPayeeTotal;
	protected BigDecimal allTotal;
	private String arrRegion[];
	private String totalSum;
	
	//addewd by new 24/07/2017
	private String oldContractNo;
	private String clearBatchFlag;
	private String viewSiteInfoId;
	
	private String vendorChange;
	private String bookbankChange;
	private String payeeChange;
	private String payeeBookbankChange;
	
	private Date contractEffectiveDt;
	private String contractEffectiveDtStr;
	private Date contractExpireDt;
	private String contractExpireDtStr;
	
	private String vendorBlackList;
	private String vendorStatus;
	private String vendorFlowStatus;
	private String bookbankStatus;
	private String bookbankFlowStatus;
	private String payeeStatus;
	private String payeeFlowStatus;
	private String bookbankPayeeId;
	private String bookbankPayeeStatus;
	private String bookbankPayeeFlowStatus;
	
	private String styleClass;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuLabel() {
		return menuLabel;
	}

	public void setMenuLabel(String menuLabel) {
		this.menuLabel = menuLabel;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
	
	

	public String getMenuGroupType() {
		return menuGroupType;
	}

	public void setMenuGroupType(String menuGroupType) {
		this.menuGroupType = menuGroupType;
	}

	@Override
	public String toString() {
		return "MenuTreeSP [menuGroup=" + menuGroup + ", menuLabel="
				+ menuLabel + ", menuLevel=" + menuLevel + ", menuSubGroup="
				+ menuSubGroup + ", menuUrl=" + menuUrl + ", region=" + region + ", recordCount="
				+ recordCount + ", rowId=" + rowId + ", renderedFlag=" + renderedFlag + ", headerFlag="
				+ headerFlag + ", mainId=" + mainId + ", refId=" + refId + ", menuSeq=" 
				+ menuSeq + ", payeeName=" + payeeName + ", idCard=" + idCard + ", taxId=" + taxId + ", contractNo="
				+ contractNo + ", siteName=" + siteName + ", accountNo=" + accountNo + ", accountName=" + accountName + ", batchNo="
				+ batchNo + ", pageFlag=" + pageFlag + ", userRole=" + userRole + ", userId=" + userId + "]";
	}
	
	
	@Override
	public String getCreateBy() {
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		return updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(String menuGroup) {
		this.menuGroup = menuGroup;
	}

	public String getMenuSubGroup() {
		return menuSubGroup;
	}

	public void setMenuSubGroup(String menuSubGroup) {
		this.menuSubGroup = menuSubGroup;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStrParam() {
		return strParam;
	}

	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}

	public String getMenuAction() {
		return menuAction;
	}

	public void setMenuAction(String menuAction) {
		this.menuAction = menuAction;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getElType() {
		return elType;
	}

	public void setElType(String elType) {
		this.elType = elType;
	}

	public boolean isDisableFlag() {
		return disableFlag;
	}

	public void setDisableFlag(boolean disableFlag) {
		this.disableFlag = disableFlag;
	}

	public boolean isRenderedFlag() {
		return renderedFlag;
	}

	public void setRenderedFlag(boolean renderedFlag) {
		this.renderedFlag = renderedFlag;
	}

	public String getHeaderFlag() {
		return headerFlag;
	}

	public void setHeaderFlag(String headerFlag) {
		this.headerFlag = headerFlag;
	}

	public BigDecimal getMainId() {
		return mainId;
	}

	public void setMainId(BigDecimal mainId) {
		this.mainId = mainId;
	}

	public BigDecimal getRefId() {
		return refId;
	}

	public void setRefId(BigDecimal refId) {
		this.refId = refId;
	}

	public BigDecimal getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(BigDecimal menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPageFlag() {
		return pageFlag;
	}

	public void setPageFlag(String pageFlag) {
		this.pageFlag = pageFlag;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getCreateById() {
		return createById;
	}

	public void setCreateById(String createById) {
		this.createById = createById;
	}

	public BigDecimal getVendorTotal() {
		return vendorTotal;
	}

	public void setVendorTotal(BigDecimal vendorTotal) {
		this.vendorTotal = vendorTotal;
	}

	public BigDecimal getBookbankTotal() {
		return bookbankTotal;
	}

	public void setBookbankTotal(BigDecimal bookbankTotal) {
		this.bookbankTotal = bookbankTotal;
	}

	public BigDecimal getPayeeTotal() {
		return payeeTotal;
	}

	public void setPayeeTotal(BigDecimal payeeTotal) {
		this.payeeTotal = payeeTotal;
	}

	public BigDecimal getBookbankPayeeTotal() {
		return bookbankPayeeTotal;
	}

	public void setBookbankPayeeTotal(BigDecimal bookbankPayeeTotal) {
		this.bookbankPayeeTotal = bookbankPayeeTotal;
	}

	public BigDecimal getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(BigDecimal allTotal) {
		this.allTotal = allTotal;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getBacthNo() {
		return bacthNo;
	}

	public void setBacthNo(String bacthNo) {
		this.bacthNo = bacthNo;
	}

	public String[] getArrRegion() {
		return arrRegion;
	}

	public void setArrRegion(String[] arrRegion) {
		this.arrRegion = arrRegion;
	}

	public String getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(String totalSum) {
		this.totalSum = totalSum;
	}

	public String getOldContractNo() {
		return oldContractNo;
	}

	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}

	public String getClearBatchFlag() {
		return clearBatchFlag;
	}

	public void setClearBatchFlag(String clearBatchFlag) {
		this.clearBatchFlag = clearBatchFlag;
	}

	public String getViewSiteInfoId() {
		return viewSiteInfoId;
	}

	public void setViewSiteInfoId(String viewSiteInfoId) {
		this.viewSiteInfoId = viewSiteInfoId;
	}

	public String getVendorChange() {
		return vendorChange;
	}

	public void setVendorChange(String vendorChange) {
		this.vendorChange = vendorChange;
	}

	public String getBookbankChange() {
		return bookbankChange;
	}

	public void setBookbankChange(String bookbankChange) {
		this.bookbankChange = bookbankChange;
	}

	public String getPayeeChange() {
		return payeeChange;
	}

	public void setPayeeChange(String payeeChange) {
		this.payeeChange = payeeChange;
	}

	public String getPayeeBookbankChange() {
		return payeeBookbankChange;
	}

	public void setPayeeBookbankChange(String payeeBookbankChange) {
		this.payeeBookbankChange = payeeBookbankChange;
	}

	public Date getContractEffectiveDt() {
		return contractEffectiveDt;
	}

	public void setContractEffectiveDt(Date contractEffectiveDt) {
		this.contractEffectiveDt = contractEffectiveDt;
	}

	public String getContractEffectiveDtStr() {
		return contractEffectiveDtStr;
	}

	public void setContractEffectiveDtStr(String contractEffectiveDtStr) {
		this.contractEffectiveDtStr = contractEffectiveDtStr;
	}

	public Date getContractExpireDt() {
		return contractExpireDt;
	}

	public void setContractExpireDt(Date contractExpireDt) {
		this.contractExpireDt = contractExpireDt;
	}

	public String getContractExpireDtStr() {
		return contractExpireDtStr;
	}

	public void setContractExpireDtStr(String contractExpireDtStr) {
		this.contractExpireDtStr = contractExpireDtStr;
	}

	public String getVendorBlackList() {
		return vendorBlackList;
	}

	public void setVendorBlackList(String vendorBlackList) {
		this.vendorBlackList = vendorBlackList;
	}

	public String getVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public String getVendorFlowStatus() {
		return vendorFlowStatus;
	}

	public void setVendorFlowStatus(String vendorFlowStatus) {
		this.vendorFlowStatus = vendorFlowStatus;
	}

	public String getBookbankStatus() {
		return bookbankStatus;
	}

	public void setBookbankStatus(String bookbankStatus) {
		this.bookbankStatus = bookbankStatus;
	}

	public String getBookbankFlowStatus() {
		return bookbankFlowStatus;
	}

	public void setBookbankFlowStatus(String bookbankFlowStatus) {
		this.bookbankFlowStatus = bookbankFlowStatus;
	}

	public String getPayeeStatus() {
		return payeeStatus;
	}

	public void setPayeeStatus(String payeeStatus) {
		this.payeeStatus = payeeStatus;
	}

	public String getPayeeFlowStatus() {
		return payeeFlowStatus;
	}

	public void setPayeeFlowStatus(String payeeFlowStatus) {
		this.payeeFlowStatus = payeeFlowStatus;
	}

	public String getBookbankPayeeId() {
		return bookbankPayeeId;
	}

	public void setBookbankPayeeId(String bookbankPayeeId) {
		this.bookbankPayeeId = bookbankPayeeId;
	}

	public String getBookbankPayeeStatus() {
		return bookbankPayeeStatus;
	}

	public void setBookbankPayeeStatus(String bookbankPayeeStatus) {
		this.bookbankPayeeStatus = bookbankPayeeStatus;
	}

	public String getBookbankPayeeFlowStatus() {
		return bookbankPayeeFlowStatus;
	}

	public void setBookbankPayeeFlowStatus(String bookbankPayeeFlowStatus) {
		this.bookbankPayeeFlowStatus = bookbankPayeeFlowStatus;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
	
}
