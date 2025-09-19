package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class LegalApproveDisplaySP extends AbstractDomain{

	private boolean selected;
	private String rowId;
	private String docNo;
	private Date docDateFrom;
	private Date docDateTo;
	private String reqOfficer;
	private String company;
	private String reqTypeName;
	private String title;
	private String contractNo;
	private Date inDtFrom;
	private Date inDtTo;
	private Date outDtFrom;
	private Date outDtTo;
	private String legalApproveStatus;
	private String legalApproveStatusName;
	private String locationId;
	private String locationName;
	private String regionName;
	private String docStatus;
	private String siteStatus;
	private String reqType;
	private String siteInfoId;
	
	private String legalApproveId;
	private boolean renderCheckBox;
	
	
	private Date docDate;
	private Date inDt;
	private Date outDt;
	private String docDateStr;
	private String inDtStr;
	private String outDtStr;	
	
	private String editFlag;
	private boolean flagLinkEdit;
	private String flowStatus;
	private String currentFlag;
	
	private String strOutDt;
	private String outDtString;
	private String batchNo;
	private String rentType;
	
	//edit by new 28/12/2014
	private String siteAppId;
	private String placeType;
	private String partiesType;
	private String placeTypeRemark;
	private String partiesTypeRemark;
	private String pageMode;
	
	@PCell(cellType = String.class, no = 7, manualStyleName="si002Field")
	public String getOutDtString() {
		return outDtString;
	}

	public void setOutDtString(String outDtString) {
		this.outDtString = outDtString;
	}

	@PCell(cellType = String.class, no = 3)
	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	@PCell(cellType = String.class, no = 6)
	public String getReqOfficer() {
		return reqOfficer;
	}

	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}

	@PCell(cellType = String.class, no = 2)
	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@PCell(cellType = String.class, no = 4)
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getLegalApproveStatusName() {
		return legalApproveStatusName;
	}

	public void setLegalApproveStatusName(String legalApproveStatusName) {
		this.legalApproveStatusName = legalApproveStatusName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@PCell(cellType = String.class, no = 5)
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
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

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@PCell(cellType = String.class, no = 0, manualStyleName="si002Field")
	public String getCompany() {
		return company;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@PCell(cellType = String.class, no = 1, manualStyleName="si002Field")
	public String getRegionName() {
		return regionName;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRenderCheckBox(boolean renderCheckBox) {
		this.renderCheckBox = renderCheckBox;
	}

	public boolean isRenderCheckBox() {
		return renderCheckBox;
	}

	public void setLegalApproveId(String legalApproveId) {
		this.legalApproveId = legalApproveId;
	}

	public String getLegalApproveId() {
		return legalApproveId;
	}

	public void setLegalApproveStatus(String legalApproveStatus) {
		this.legalApproveStatus = legalApproveStatus;
	}

	public String getLegalApproveStatus() {
		return legalApproveStatus;
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

	public Date getInDtFrom() {
		return inDtFrom;
	}

	public void setInDtFrom(Date inDtFrom) {
		this.inDtFrom = inDtFrom;
	}

	public Date getInDtTo() {
		return inDtTo;
	}

	public void setInDtTo(Date inDtTo) {
		this.inDtTo = inDtTo;
	}

	public Date getOutDtFrom() {
		return outDtFrom;
	}

	public void setOutDtFrom(Date outDtFrom) {
		this.outDtFrom = outDtFrom;
	}

	public Date getOutDtTo() {
		return outDtTo;
	}

	public void setOutDtTo(Date outDtTo) {
		this.outDtTo = outDtTo;
	}

	public Date getDocDate() {
		return docDate;
	}

	public void setDocDate(Date docDate) {
		this.docDate = docDate;
	}

	public Date getInDt() {
		return inDt;
	}

	public void setInDt(Date inDt) {
		this.inDt = inDt;
	}


	public Date getOutDt() {
		return outDt;
	}

	public void setOutDt(Date outDt) {
		this.outDt = outDt;
	}

	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}

	public String getEditFlag() {
		return editFlag;
	}

	public void setFlagLinkEdit(boolean flagLinkEdit) {
		this.flagLinkEdit = flagLinkEdit;
	}

	public boolean isFlagLinkEdit() {
		return flagLinkEdit;
	}

	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}

	public String getCurrentFlag() {
		return currentFlag;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}
	
	@PCell(cellType = String.class, no = 9)
	public String getRecipients() {
		return "";
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	
	@PCell(cellType = String.class, no = 8)
	public String getStrOutDt() {
		return "";
	}

	public void setStrOutDt(String strOutDt) {
		this.strOutDt = strOutDt;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getDocDateStr() {
		return docDateStr;
	}

	public void setDocDateStr(String docDateStr) {
		this.docDateStr = docDateStr;
	}

	public String getInDtStr() {
		return inDtStr;
	}

	public void setInDtStr(String inDtStr) {
		this.inDtStr = inDtStr;
	}

	public String getOutDtStr() {
		return outDtStr;
	}

	public void setOutDtStr(String outDtStr) {
		this.outDtStr = outDtStr;
	}

	public String getPlaceType() {
		return placeType;
	}

	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	public String getPartiesType() {
		return partiesType;
	}

	public void setPartiesType(String partiesType) {
		this.partiesType = partiesType;
	}

	public String getPlaceTypeRemark() {
		return placeTypeRemark;
	}

	public void setPlaceTypeRemark(String placeTypeRemark) {
		this.placeTypeRemark = placeTypeRemark;
	}

	public String getPartiesTypeRemark() {
		return partiesTypeRemark;
	}

	public void setPartiesTypeRemark(String partiesTypeRemark) {
		this.partiesTypeRemark = partiesTypeRemark;
	}

	public String getSiteAppId() {
		return siteAppId;
	}

	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}

	public String getPageMode() {
		return pageMode;
	}

	public void setPageMode(String pageMode) {
		this.pageMode = pageMode;
	}
	
}
