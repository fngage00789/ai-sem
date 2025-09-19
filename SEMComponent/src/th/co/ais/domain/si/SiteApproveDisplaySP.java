package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class SiteApproveDisplaySP extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5415687623468195762L;
	
	private String docNo;
	private Date docDate;
	private Date docDateFrom;
	private Date docDateTo;
	private String reqOfficer;
	private String company;
	private String reqType;
	private String title;
	private String contractNo;
	private String siteApproveStatus;
	private String locationId;
	private String locationName;
	private String region;
	private String legalApproveStatusName;
	private String currentFlag;
	private boolean chkCurrentFlag;
	
	private String reqTypeName;
	private String siteApproveStatusName;
	private Date outDt;
	private String regionName;
	private String flowStatus;
	private String siteInfoId;
	private String editFlag;
	private String deleteFlag;
	private String cancelFlag;
	private String closeFlag;
	private String siteStatusName;
	private String siteInfo;
	private String reject;
	private String newElectic;
	private String electric;
	private String rental;	
	private String receipt;
	private Date receiptDt;
	private String raw;
	private Date inDt;
	private Date cancelDt;
	private Date siteInfoApproveDt;
	private String contract;
	private int no;
	private String insurance;
	private String chkReceiptDt;
	private String chkCancelDt;
	private String siApproveDt;
	
	private String siteInfoStatus;
	private String batchNo;
	
	private String docDateStr;
	private String outDtStr;
	private String zone;
	
//	@PCell(cellType = String.class ,no = 6, manualStyleName = "rt003Field")
	public String getChkReceiptDt() {
		return chkReceiptDt;
	}
	public void setChkReceiptDt(String chkReceiptDt) {
		this.chkReceiptDt = chkReceiptDt;
	}
//	@PCell(cellType = String.class ,no = 7, manualStyleName = "rt003Field")
	public String getChkCancelDt() {
		return chkCancelDt;
	}
	public void setChkCancelDt(String chkCancelDt) {
		this.chkCancelDt = chkCancelDt;
	}
	
//	@PCell(cellType = String.class ,no = 8, manualStyleName = "rt003Field")
	public String getSiApproveDt() {
		return siApproveDt;
	}
	public void setSiApproveDt(String siApproveDt) {
		this.siApproveDt = siApproveDt;
	}
	@PCell(cellType = String.class ,no = 12, manualStyleName = "rt003Field")
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	@PCell(cellType = String.class ,no = 0, manualStyleName = "rt003Field")
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@PCell(cellType = String.class ,no = 15, manualStyleName = "rt003Field")
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getCloseFlag() {
		return closeFlag;
	}
	public void setCloseFlag(String closeFlag) {
		this.closeFlag = closeFlag;
	}
	public String getSiteStatusName() {
		return siteStatusName;
	}
	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public Date getDocDateFrom() {
		return docDateFrom;
	}
	public void setDocDateFrom(Date docDateFrom) {
		this.docDateFrom = docDateFrom;
	}
	public Date getDocDateTo() {
		return docDateTo;
	}
	public void setDocDateTo(Date docDateTo) {
		this.docDateTo = docDateTo;
	}
	public String getLegalApproveStatusName() {
		return legalApproveStatusName;
	}
	public void setLegalApproveStatusName(String legalApproveStatusName) {
		this.legalApproveStatusName = legalApproveStatusName;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@PCell(cellType = String.class ,no = 3, manualStyleName = "rt003Field")
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public Date getDocDate() {
		return docDate;
	}
	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}
	public String getReqOfficer() {
		return reqOfficer;
	}
	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}
	
	@PCell(cellType = String.class ,no = 1, manualStyleName = "rt003Field")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	@PCell(cellType = String.class ,no = 16, manualStyleName = "rt003Field")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@PCell(cellType = String.class ,no = 4, manualStyleName = "rt003Field")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getSiteApproveStatus() {
		return siteApproveStatus;
	}
	public void setSiteApproveStatus(String siteApproveStatus) {
		this.siteApproveStatus = siteApproveStatus;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@PCell(cellType = String.class ,no = 5, manualStyleName = "rt003Field")
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getReqTypeName() {
		return reqTypeName;
	}
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}
	public String getSiteApproveStatusName() {
		return siteApproveStatusName;
	}
	public void setSiteApproveStatusName(String siteApproveStatusName) {
		this.siteApproveStatusName = siteApproveStatusName;
	}
	public Date getOutDt() {
		return outDt;
	}
	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}
	@PCell(cellType = String.class ,no = 2, manualStyleName = "rt003Field")
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	@PCell(cellType = Date.class ,no = 6, manualStyleName = "rt003Field")
	public Date getInDt() {
		return inDt;
	}
	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}
	
	@PCell(cellType = Date.class ,no = 7, manualStyleName = "rt003Field")
	public Date getCancelDt() {
		return cancelDt;
	}
	public void setCancelDt(Date cancelDt) {
		this.cancelDt = cancelDt;
	}

	@PCell(cellType = Date.class ,no = 8, manualStyleName = "rt003Field")
	public Date getSiteInfoApproveDt() {
		return siteInfoApproveDt;
	}
	public void setSiteInfoApproveDt(Date siteInfoApproveDt) {
		this.siteInfoApproveDt = siteInfoApproveDt;
	}
	@Override
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	public Date getCreateDt() {
		return this.createDt;
	}
	@Override
	public String getUpdateBy() {
		return this.updateBy;
	}
	@Override
	public Date getUpdateDt() {
		return this.updateDt;
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
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	@PCell(cellType = String.class ,no = 10, manualStyleName = "rt003Field")
	public String getSiteInfo() {
		return siteInfo;
	}
	public void setSiteInfo(String siteInfo) {
		this.siteInfo = siteInfo;
	}
	
	public String getReject() {
		return reject;
	}
	public void setReject(String reject) {
		this.reject = reject;
	}
	@PCell(cellType = String.class ,no = 11, manualStyleName = "rt003Field")
	public String getNewElectic() {
		return newElectic;
	}
	public void setNewElectic(String newElectic) {
		this.newElectic = newElectic;
	}
	@PCell(cellType = String.class ,no = 13, manualStyleName = "rt003Field")
	public String getElectric() {
		return electric;
	}
	public void setElectric(String electric) {
		this.electric = electric;
	}
	@PCell(cellType = String.class ,no = 14, manualStyleName = "rt003Field")
	public String getRental() {
		return rental;
	}
	public void setRental(String rental) {
		this.rental = rental;
	}

	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	
	public Date getReceiptDt() {
		return receiptDt;
	}
	public void setReceiptDt(Date receiptDt) {
		this.receiptDt = receiptDt;
	}
	@PCell(cellType = String.class ,no = 9, manualStyleName = "rt003Field")
	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public boolean isChkCurrentFlag() {
		return chkCurrentFlag;
	}
	public void setChkCurrentFlag(boolean chkCurrentFlag) {
		this.chkCurrentFlag = chkCurrentFlag;
	}
	public String getSiteInfoStatus() {
		return siteInfoStatus;
	}
	public void setSiteInfoStatus(String siteInfoStatus) {
		this.siteInfoStatus = siteInfoStatus;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getDocDateStr() {
		return docDateStr;
	}
	public void setDocDateStr(String docDateStr) {
		this.docDateStr = docDateStr;
	}
	public String getOutDtStr() {
		return outDtStr;
	}
	public void setOutDtStr(String outDtStr) {
		this.outDtStr = outDtStr;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	
}
