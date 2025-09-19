package th.co.ais.domain.co;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mco007MasterContractSP extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1646564845549082791L;
	
	private String rowId;
	private String contractFormId;
	private String contractFormName;
	private String contractFormTitle;
	private String recordStatus;

	private String contractFormDetailId;
	private String contractFormDetail;
	private BigDecimal contractFormOrder;
	private String contractBold;
	private String contractUnderline;
	private String contractNewline;
	private String mode;
	
	private String createDtStr;
	private String updateDtStr;
	private String userId;
	
	private String retResult;
	private String retRemark;
	
	private String contractNo;
	private String siteName; 		
	private String companyAddr;
	private String contractId;
	
	private String companyName;
	private String siteType;
	private String siteHouseNo;
	private String araeSize;
	private String ageContract;
	private String propertyTaxPayType;
	private String promise;
	private Date docDt;
	private String contEndingFlag;
	private String siteInstall;
	private String docDtStr;
	private String locationId;
	private String signName; 
	private String byName; 
	private String signNameStr;
	private String byNameStr; 
	private String expenseStr;

	public String getSignNameStr() {
		return signNameStr;
	}

	public void setSignNameStr(String signNameStr) {
		this.signNameStr = signNameStr;
	}

	public String getByNameStr() {
		return byNameStr;
	}

	public void setByNameStr(String byNameStr) {
		this.byNameStr = byNameStr;
	}

	public String getExpenseStr() {
		return expenseStr;
	}

	public void setExpenseStr(String expenseStr) {
		this.expenseStr = expenseStr;
	}

	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getDocDtStr() {
		return docDtStr;
	}

	public void setDocDtStr(String docDtStr) {
		this.docDtStr = docDtStr;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getContractFormId() {
		return contractFormId;
	}

	public void setContractFormId(String contractFormId) {
		this.contractFormId = contractFormId;
	}

	public String getContractFormName() {
		return contractFormName;
	}

	public void setContractFormName(String contractFormName) {
		this.contractFormName = contractFormName;
	}

	public String getContractFormTitle() {
		return contractFormTitle;
	}

	public void setContractFormTitle(String contractFormTitle) {
		this.contractFormTitle = contractFormTitle;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getContractFormDetailId() {
		return contractFormDetailId;
	}

	public void setContractFormDetailId(String contractFormDetailId) {
		this.contractFormDetailId = contractFormDetailId;
	}

	public String getContractFormDetail() {
		return contractFormDetail;
	}

	public void setContractFormDetail(String contractFormDetail) {
		this.contractFormDetail = contractFormDetail;
	}

	public BigDecimal getContractFormOrder() {
		return contractFormOrder;
	}

	public void setContractFormOrder(BigDecimal contractFormOrder) {
		this.contractFormOrder = contractFormOrder;
	}

	public String getContractBold() {
		return contractBold;
	}

	public void setContractBold(String contractBold) {
		this.contractBold = contractBold;
	}

	public String getContractUnderline() {
		return contractUnderline;
	}

	public void setContractUnderline(String contractUnderline) {
		this.contractUnderline = contractUnderline;
	}

	public String getRetResult() {
		return retResult;
	}

	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}

	public String getRetRemark() {
		return retRemark;
	}

	public void setRetRemark(String retRemark) {
		this.retRemark = retRemark;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getCreateDtStr() {
		return createDtStr;
	}

	public void setCreateDtStr(String createDtStr) {
		this.createDtStr = createDtStr;
	}

	public String getUpdateDtStr() {
		return updateDtStr;
	}

	public void setUpdateDtStr(String updateDtStr) {
		this.updateDtStr = updateDtStr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContractNewline() {
		return contractNewline;
	}

	public void setContractNewline(String contractNewline) {
		this.contractNewline = contractNewline;
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

	public String getCompanyAddr() {
		return companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteHouseNo() {
		return siteHouseNo;
	}

	public void setSiteHouseNo(String siteHouseNo) {
		this.siteHouseNo = siteHouseNo;
	}

	public String getAraeSize() {
		return araeSize;
	}

	public void setAraeSize(String araeSize) {
		this.araeSize = araeSize;
	}

	public String getAgeContract() {
		return ageContract;
	}

	public void setAgeContract(String ageContract) {
		this.ageContract = ageContract;
	}

	public String getPropertyTaxPayType() {
		return propertyTaxPayType;
	}

	public void setPropertyTaxPayType(String propertyTaxPayType) {
		this.propertyTaxPayType = propertyTaxPayType;
	}

	public String getPromise() {
		return promise;
	}

	public void setPromise(String promise) {
		this.promise = promise;
	}

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public String getContEndingFlag() {
		return contEndingFlag;
	}

	public void setContEndingFlag(String contEndingFlag) {
		this.contEndingFlag = contEndingFlag;
	}

	public String getSiteInstall() {
		return siteInstall;
	}

	public void setSiteInstall(String siteInstall) {
		this.siteInstall = siteInstall;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return createBy;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return createDt;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return updateBy;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return updateDt;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub
		this.createBy = createBy;
	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub
		this.createDt = createDt;
	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub
		this.updateBy = updateBy;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub
		this.updateDt = updateDt;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

}
