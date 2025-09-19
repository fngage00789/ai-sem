package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mrt010IfrsTodolistDetail extends AbstractDomain {

	private static final long serialVersionUID = -2284439289787505807L;

	private String referenceId;
	private String company;
	private String region;
	private String contractNo;
	private String siteName;
	private String dateFromCondition;
	private String dateUpToCondition;
	private String contractStatus;
	private String contractType;
	private String withHoldingTax;
	private String withHoldingTaxPercentage;
	private String vat;
	private String vendorCode;
	private String vendorName;
	private String status;
	private String errorMessage;
	private String firstPostingFrom;
	private String dateFirstContractEnd;
	private String perYearOrPerMonth;
	private String splitCase;
	private String currencyUnitPrice;
	private Double currencyUnitPriceFormatter;
	private String refxNo;
	private String recordStatus;
	private String rentalDetailId;
	private String semConditionId;
	private String siteInfoId;

	public Mrt010IfrsTodolistDetail() {
		super();
	}

	public Mrt010IfrsTodolistDetail(String referenceId) {
		super();
		this.referenceId = referenceId;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		return updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
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

	public String getDateFromCondition() {
		return dateFromCondition;
	}

	public void setDateFromCondition(String dateFromCondition) {
		this.dateFromCondition = dateFromCondition;
	}

	public String getDateUpToCondition() {
		return dateUpToCondition;
	}

	public void setDateUpToCondition(String dateUpToCondition) {
		this.dateUpToCondition = dateUpToCondition;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getWithHoldingTax() {
		return withHoldingTax;
	}

	public void setWithHoldingTax(String withHoldingTax) {
		this.withHoldingTax = withHoldingTax;
	}

	public String getWithHoldingTaxPercentage() {
		return withHoldingTaxPercentage;
	}

	public void setWithHoldingTaxPercentage(String withHoldingTaxPercentage) {
		this.withHoldingTaxPercentage = withHoldingTaxPercentage;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getFirstPostingFrom() {
		return firstPostingFrom;
	}

	public void setFirstPostingFrom(String firstPostingFrom) {
		this.firstPostingFrom = firstPostingFrom;
	}

	public String getDateFirstContractEnd() {
		return dateFirstContractEnd;
	}

	public void setDateFirstContractEnd(String dateFirstContractEnd) {
		this.dateFirstContractEnd = dateFirstContractEnd;
	}

	public String getPerYearOrPerMonth() {
		return perYearOrPerMonth;
	}

	public void setPerYearOrPerMonth(String perYearOrPerMonth) {
		this.perYearOrPerMonth = perYearOrPerMonth;
	}

	public String getSplitCase() {
		return splitCase;
	}

	public void setSplitCase(String splitCase) {
		this.splitCase = splitCase;
	}

	public String getCurrencyUnitPrice() {
		return currencyUnitPrice;
	}

	public void setCurrencyUnitPrice(String currencyUnitPrice) {
		this.currencyUnitPrice = currencyUnitPrice;
	}

	public Double getCurrencyUnitPriceFormatter() {
		return currencyUnitPriceFormatter;
	}

	public void setCurrencyUnitPriceFormatter(Double currencyUnitPriceFormatter) {
		this.currencyUnitPriceFormatter = currencyUnitPriceFormatter;
	}

	public String getRefxNo() {
		return refxNo;
	}

	public void setRefxNo(String refxNo) {
		this.refxNo = refxNo;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRentalDetailId() {
		return rentalDetailId;
	}

	public void setRentalDetailId(String rentalDetailId) {
		this.rentalDetailId = rentalDetailId;
	}

	public String getSemConditionId() {
		return semConditionId;
	}

	public void setSemConditionId(String semConditionId) {
		this.semConditionId = semConditionId;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

}
