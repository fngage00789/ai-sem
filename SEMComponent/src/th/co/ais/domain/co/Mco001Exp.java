package th.co.ais.domain.co;

import java.util.Date;

import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mco001Exp extends AbstractDomain {
	private static final long serialVersionUID = -7563082147781224969L;

	private String rowId;
	private String company;
	private String region;
	private String docNo;
	private String reqType;
	private String reqTypeName;
	private String title;
	private String contractNo;
	private String siteName;
	private Date effDateFrom;
	private Date effDateTo;
	private Date expDateFrom;
	private Date expDateTo;
	private String lessorName;
	private String locationId;
	private String contractStatus;
	private String checkDocStatus;
	private String dutyPayStatus;
	private String totSendStatus;
	private String currentFlag;
	private String siteInfoId;
	private String contractId;
	private Date effDate;
	private Date expDate;
	private Date outDate;
	private String effDateStr;
	private String expDateStr;
	private String outDateStr;
	private String remark;
	private String contractStatusName;
	private String checkDocStatusName;
	private String dutyPayStatusName;
	private String totSendStatusName;
	private boolean selected;
	private Date legalPassOutDate;
	private String flowStatus;
	@Transient
	private String siteStatusName;
	@Transient
	private boolean currentFlagBoolean;
	private String noExpireFlag;
	private int no;
	private String oldContractNo;
	private String oldSiteInfoId;
	private String batchNo;
	private String borrowStatus;
	private String reqTypeName2;
	private Double dutyAmt;
	private String receivePerson;
	private String createPersonName;
	private String siteApprovePersonName;
	private Date d1;
	private Date d2;
	private Date d3;
	private Date d4;
	private Date d5;
	private Date d6;
	private Date d7;
	private Date d8;
	private Date d9;
	
	
	
	
	public String getReceiveDate() {
		return "";
	}
	public String getReceiveName() {
		return "";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getStringNo() {
		return no + "";
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
	
	public String getReqTypeName() {
		return reqTypeName;
	}

	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName="si002Field")
	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	@PCell(cellType = String.class ,no = 3, manualStyleName="si002Field")
	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 5, manualStyleName="si002Field")
	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	public String getReceiveDate1() {
		return "";
	}
	
	public String getReceiveName1() {
		return "";
	}
	public String getReceiveDate2() {
		return "";
	}
	
	public String getReceiveName2() {
		return "";
	}
	
	public String getReceiveDate3() {
		return "";
	}
	
	public String getReceiveName3() {
		return "";
	}
	
	public String getNoExpireFlag() {
		return noExpireFlag;
	}

	public void setNoExpireFlag(String noExpireFlag) {
		this.noExpireFlag = noExpireFlag;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	

	public Date getEffDateFrom() {
		return effDateFrom;
	}

	public void setEffDateFrom(Date effDateFrom) {
		this.effDateFrom = effDateFrom;
	}

	public Date getEffDateTo() {
		return effDateTo;
	}

	public void setEffDateTo(Date effDateTo) {
		this.effDateTo = effDateTo;
	}

	public Date getExpDateFrom() {
		return expDateFrom;
	}

	public void setExpDateFrom(Date expDateFrom) {
		this.expDateFrom = expDateFrom;
	}

	public Date getExpDateTo() {
		return expDateTo;
	}

	public void setExpDateTo(Date expDateTo) {
		this.expDateTo = expDateTo;
	}

	public String getLessorName() {
		return lessorName;
	}

	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	@PCell(cellType = String.class ,no = 2, manualStyleName="si002Field")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getCheckDocStatus() {
		return checkDocStatus;
	}

	public void setCheckDocStatus(String checkDocStatus) {
		this.checkDocStatus = checkDocStatus;
	}

	public String getDutyPayStatus() {
		return dutyPayStatus;
	}

	public void setDutyPayStatus(String dutyPayStatus) {
		this.dutyPayStatus = dutyPayStatus;
	}

	public String getTotSendStatus() {
		return totSendStatus;
	}

	public void setTotSendStatus(String totSendStatus) {
		this.totSendStatus = totSendStatus;
	}

	public String getCurrentFlag() {
		return currentFlag;
	}

	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	@PCell(cellType = Date.class ,no = 6, manualStyleName="si002Field")
	public Date getEffDate() {
		return effDate;
	}

	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	@PCell(cellType = Date.class ,no = 7, manualStyleName="si002Field")
	public Date getExpDate() {
		return expDate;
	}
	
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	@PCell(cellType = String.class ,no = 23, manualStyleName="si002Field")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@PCell(cellType = String.class ,no = 9, manualStyleName="si002Field")
	public String getContractStatusName() {
		return contractStatusName;
	}

	public void setContractStatusName(String contractStatusName) {
		this.contractStatusName = contractStatusName;
	}

	public String getCheckDocStatusName() {
		return checkDocStatusName;
	}

	public void setCheckDocStatusName(String checkDocStatusName) {
		this.checkDocStatusName = checkDocStatusName;
	}

	public String getDutyPayStatusName() {
		return dutyPayStatusName;
	}

	public void setDutyPayStatusName(String dutyPayStatusName) {
		this.dutyPayStatusName = dutyPayStatusName;
	}

	public String getTotSendStatusName() {
		return totSendStatusName;
	}

	public void setTotSendStatusName(String totSendStatusName) {
		this.totSendStatusName = totSendStatusName;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Date getLegalPassOutDate() {
		return legalPassOutDate;
	}

	public void setLegalPassOutDate(Date legalPassOutDate) {
		this.legalPassOutDate = legalPassOutDate;
	}

	@PCell(cellType = String.class ,no = 25, manualStyleName="si002Field")
	public String getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName="si002Field")
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	public String getOldSiteInfoId() {
		return oldSiteInfoId;
	}
	public void setOldSiteInfoId(String oldSiteInfoId) {
		this.oldSiteInfoId = oldSiteInfoId;
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
	@PCell(cellType = String.class ,no = 24, manualStyleName="si002Field")
	public String getSiteStatusName() {
		return siteStatusName;
	}

	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}

	public boolean isCurrentFlagBoolean() {
		return currentFlagBoolean;
	}

	public void setCurrentFlagBoolean(boolean currentFlagBoolean) {
		this.currentFlagBoolean = currentFlagBoolean;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getEffDateStr() {
		return effDateStr;
	}
	public void setEffDateStr(String effDateStr) {
		this.effDateStr = effDateStr;
	}
	public String getExpDateStr() {
		return expDateStr;
	}
	public void setExpDateStr(String expDateStr) {
		this.expDateStr = expDateStr;
	}
	public String getOutDateStr() {
		return outDateStr;
	}
	public void setOutDateStr(String outDateStr) {
		this.outDateStr = outDateStr;
	}
	@PCell(cellType = String.class ,no = 10, manualStyleName="si002Field")
	public String getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	
	@PCell(cellType = String.class ,no = 0, manualStyleName="si002Field")
	public String getReqTypeName2() {
		return reqTypeName2;
	}
	public void setReqTypeName2(String reqTypeName2) {
		this.reqTypeName2 = reqTypeName2;
	}
	@PCell(cellType = String.class ,no = 11, manualStyleName="si002Field")
	public String getReceivePerson() {
		return receivePerson;
	}
	public void setReceivePerson(String receivePerson) {
		this.receivePerson = receivePerson;
	}
	@PCell(cellType = String.class ,no = 12, manualStyleName="si002Field")
	public String getCreatePersonName() {
		return createPersonName;
	}
	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}
	@PCell(cellType = String.class ,no = 13, manualStyleName="si002Field")
	public String getSiteApprovePersonName() {
		return siteApprovePersonName;
	}
	public void setSiteApprovePersonName(String siteApprovePersonName) {
		this.siteApprovePersonName = siteApprovePersonName;
	}
	@PCell(cellType = Double.class ,no = 8, manualStyleName="rt002FieldMoney")
	public Double getDutyAmt() {
		return dutyAmt;
	}
	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}
	@PCell(cellType = Date.class ,no = 14, manualStyleName="si002Field")
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	@PCell(cellType = Date.class ,no = 15, manualStyleName="si002Field")
	public Date getD2() {
		return d2;
	}
	public void setD2(Date d2) {
		this.d2 = d2;
	}
	@PCell(cellType = Date.class ,no = 17, manualStyleName="si002Field")
	public Date getD3() {
		return d3;
	}
	public void setD3(Date d3) {
		this.d3 = d3;
	}
	@PCell(cellType = Date.class ,no = 18, manualStyleName="si002Field")
	public Date getD4() {
		return d4;
	}
	public void setD4(Date d4) {
		this.d4 = d4;
	}
	@PCell(cellType = Date.class ,no = 19, manualStyleName="si002Field")
	public Date getD5() {
		return d5;
	}
	public void setD5(Date d5) {
		this.d5 = d5;
	}
	@PCell(cellType = Date.class ,no = 20, manualStyleName="si002Field")
	public Date getD6() {
		return d6;
	}
	public void setD6(Date d6) {
		this.d6 = d6;
	}
	@PCell(cellType = Date.class ,no = 21, manualStyleName="si002Field")
	public Date getD7() {
		return d7;
	}
	public void setD7(Date d7) {
		this.d7 = d7;
	}
	@PCell(cellType = Date.class ,no = 22, manualStyleName="si002Field")
	public Date getD8() {
		return d8;
	}
	public void setD8(Date d8) {
		this.d8 = d8;
	}
	@PCell(cellType = Date.class ,no = 16, manualStyleName="si002Field")
	public Date getD9() {
		return d9;
	}
	public void setD9(Date d9) {
		this.d9 = d9;
	}
	
}
