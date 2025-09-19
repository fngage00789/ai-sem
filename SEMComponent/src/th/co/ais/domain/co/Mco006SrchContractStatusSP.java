package th.co.ais.domain.co;

import java.util.Date;

import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;
import th.co.ais.util.SEMDataUtility;

public class Mco006SrchContractStatusSP extends AbstractDomain{
	private static final long serialVersionUID = -7563082147781224969L;
	
	private String rowId;
	private String company;
	private String reqType;
	private String contractNo;
	private String old_contractNo;
	private String siteInfoId;
	private String locationId;
	private String docNo;
	private String reqTypeName;
	private Date effDate;
	private Date expDate;
	private Double dutyAmt;
	private String contractStatusName;
	private String siteName;
	private Date d1;
	private Date d2;
	private Date d3;
	private Date d4;
	private Date d5;
	private Date d6;
	private Date d7;
	private Date d8;
	private String remark;
	private boolean selected;
	private String age;
	private String region;
	private String contractStatus;
	private String siteStatusName;
	private String flowStatus;
	private Date receiveDateFrom;
	private Date receiveDateTo;
	private int no;
	private String terminateFlag;
	
	private boolean isPico;
	private String strPico;
	
	private String siteApprovePersonName;
	private String receivePersonCode;
 	private String createPersonCode;
 	private String maintain;
 	private Double totalDutyAmount;
	private String oldContractNo;
	private String oldSiteInfoId;
	
	private String effDtStr;
	private String expDtStr;
	private String d1Str1;
	private String d2Str;
	private String d3Str;
	private String d4Str;
	private String d5Str;
	private String d6Str;
	private String d7Str;
	private String d8Str;
	private String borrowStatus;
	
	public String getTerminateFlag() {
		return terminateFlag;
	}

	public void setTerminateFlag(String terminateFlag) {
		this.terminateFlag = terminateFlag;
	}

	
	@PCell(cellType = String.class ,no = 0)
	public String getStringNo() {
		return no + "";
	}
	@PCell(cellType = String.class ,no = 1)
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@PCell(cellType = String.class ,no = 2)
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	@PCell(cellType = String.class ,no = 3)
	public String getReqTypeName() {
		return reqTypeName;
	}
	public void setReqTypeName(String reqTypeName) {
		this.reqTypeName = reqTypeName;
	}
	
	@PCell(cellType = String.class ,no = 4)
	public String getYear() {
		String year = "";
		d1 = getD1();
		if(d1 != null){
			try{
				String d1Str = SEMDataUtility.toStringEngDateSimpleFormat(d1);
				String[] d1Arr = d1Str.split("/");
				//month = d1Arr[1];
				 year = d1Arr[2];
			}catch(Exception e){				
			}
		}else{
			year = "";
		}
		return year;
	}
	
	@PCell(cellType = String.class ,no = 5)
	public String getMonth() {
		String month = "";
		d1 = getD1();
		if(d1 != null){
			try{
				String d1Str = SEMDataUtility.toStringEngDateSimpleFormat(d1);
				String[] d1Arr = d1Str.split("/");
				month = d1Arr[1];
			}catch(Exception e){				
			}
		}else{
			month = "";
		}
		return month;
	}
	
	@PCell(cellType = String.class ,no = 6)
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@PCell(cellType = String.class ,no = 8)
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	
	@PCell(cellType = String.class ,no = 9)
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	
	@PCell(cellType = String.class ,no = 10)
	public String getEffDateStr() {
		String effDateStr = "";
		effDate = getEffDate();
		if(effDate != null){
			try{
				effDateStr = SEMDataUtility.toStringEngDateSimpleFormat(effDate);
			}catch(Exception e){				
			}
		}else{
			effDateStr = "";
		}
		return effDateStr;
	}
	
	@PCell(cellType = String.class ,no = 11)
	public String getExpDateStr() {
		String expDateStr = "";
		expDate = getExpDate();
		if(expDate != null){
			try{
				expDateStr = SEMDataUtility.toStringEngDateSimpleFormat(expDate);
			}catch(Exception e){				
			}
		}else{
			expDateStr = "";
		}
		return expDateStr;
	}
	@PCell(cellType = String.class ,no = 12)
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@PCell(cellType = Double.class ,no = 13)
	public Double getDutyAmt() {
		return dutyAmt;
	}
	public void setDutyAmt(Double dutyAmt) {
		this.dutyAmt = dutyAmt;
	}
	
	
	//@PCell(cellType = String.class ,no = 14)
	public String getReceiveBy() {
		return "";
	}
	
	//@PCell(cellType = String.class ,no = 15)
	public String getCreatedBy() {
		return "";
	}
	
	//@PCell(cellType = String.class ,no = 16)
	public String getMaintainBy() {
		return "";
	}
	@PCell(cellType = String.class ,no = 17)
	public String getStringD1() {
		String d1Str = "";
		d1 = getD1();
		if(d1 != null){
			try{
				d1Str = SEMDataUtility.toStringEngDateSimpleFormat(d1);
			}catch(Exception e){				
			}
		}else{
			d1Str = "";
		}
		return d1Str;
	}
	@PCell(cellType = String.class ,no = 18)
	public String getExportDate() {
		return "";
	}
	
	@PCell(cellType = String.class ,no = 19)
	public String getLegalApprove() {
		return "";
	}
	
	@PCell(cellType = String.class ,no = 20)
	public String getWorks() {
		return "";
	}
	
	@PCell(cellType = String.class ,no = 21)
	public String getReturns() {
		return "";
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Date getReceiveDateFrom() {
		return receiveDateFrom;
	}
	public void setReceiveDateFrom(Date receiveDateFrom) {
		this.receiveDateFrom = receiveDateFrom;
	}
	public Date getReceiveDateTo() {
		return receiveDateTo;
	}
	public void setReceiveDateTo(Date receiveDateTo) {
		this.receiveDateTo = receiveDateTo;
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
	
	
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	
	public String getContractStatusName() {
		return contractStatusName;
	}
	public void setContractStatusName(String contractStatusName) {
		this.contractStatusName = contractStatusName;
	}
	public Date getD1() {
		return d1;
	}
	public void setD1(Date d1) {
		this.d1 = d1;
	}
	public Date getD2() {
		return d2;
	}
	public void setD2(Date d2) {
		this.d2 = d2;
	}
	public Date getD3() {
		return d3;
	}
	public void setD3(Date d3) {
		this.d3 = d3;
	}
	public Date getD4() {
		return d4;
	}
	public void setD4(Date d4) {
		this.d4 = d4;
	}
	public Date getD5() {
		return d5;
	}
	public void setD5(Date d5) {
		this.d5 = d5;
	}
	public Date getD6() {
		return d6;
	}
	public void setD6(Date d6) {
		this.d6 = d6;
	}
	public Date getD7() {
		return d7;
	}
	public void setD7(Date d7) {
		this.d7 = d7;
	}
	
	public Date getD8() {
		return d8;
	}
	public void setD8(Date d8) {
		this.d8 = d8;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
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
	
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public String getSiteStatusName() {
		return siteStatusName;
	}
	public void setSiteStatusName(String siteStatusName) {
		this.siteStatusName = siteStatusName;
	}
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}

	public boolean isPico() {
		return isPico;
	}
	public void setPico(boolean isPico) {
		this.isPico = isPico;
	}

	public String getStrPico() {
		return strPico;
	}

	public void setStrPico(String strPico) {
		this.strPico = strPico;
	}
	@PCell(cellType = String.class ,no = 16)
	public String getSiteApprovePersonName() {
		return siteApprovePersonName;
	}

	public void setSiteApprovePersonName(String siteApprovePersonName) {
		this.siteApprovePersonName = siteApprovePersonName;
	}
	
	@PCell(cellType = String.class ,no = 14)
	public String getReceivePersonCode() {
		return receivePersonCode;
	}

	public void setReceivePersonCode(String receivePersonCode) {
		this.receivePersonCode = receivePersonCode;
	}
	@PCell(cellType = String.class ,no = 15)
	public String getCreatePersonCode() {
		return createPersonCode;
	}

	public void setCreatePersonCode(String createPersonCode) {
		this.createPersonCode = createPersonCode;
	}
	@PCell(cellType = String.class ,no = 7)
	public String getOld_contractNo() {
		return old_contractNo;
	}

	public void setOld_contractNo(String oldContractNo) {
		old_contractNo = oldContractNo;
	}
	@PCell(cellType = String.class ,no = 22)
	public String getMaintain() {
		return maintain;
	}

	public void setMaintain(String maintain) {
		this.maintain = maintain;
	}
	
	public Double getTotalDutyAmount() {
		return totalDutyAmount;
	}
	
	public void setTotalDutyAmount(Double totalDutyAmount) {
		this.totalDutyAmount = totalDutyAmount;
	}

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

	public String getEffDtStr() {
		return effDtStr;
	}

	public void setEffDtStr(String effDtStr) {
		this.effDtStr = effDtStr;
	}

	public String getExpDtStr() {
		return expDtStr;
	}

	public void setExpDtStr(String expDtStr) {
		this.expDtStr = expDtStr;
	}

	public String getD1Str1() {
		return d1Str1;
	}

	public void setD1Str1(String d1Str1) {
		this.d1Str1 = d1Str1;
	}

	public String getD2Str() {
		return d2Str;
	}

	public void setD2Str(String d2Str) {
		this.d2Str = d2Str;
	}

	public String getD3Str() {
		return d3Str;
	}

	public void setD3Str(String d3Str) {
		this.d3Str = d3Str;
	}

	public String getD4Str() {
		return d4Str;
	}

	public void setD4Str(String d4Str) {
		this.d4Str = d4Str;
	}

	public String getD5Str() {
		return d5Str;
	}

	public void setD5Str(String d5Str) {
		this.d5Str = d5Str;
	}

	public String getD6Str() {
		return d6Str;
	}

	public void setD6Str(String d6Str) {
		this.d6Str = d6Str;
	}

	public String getD7Str() {
		return d7Str;
	}

	public void setD7Str(String d7Str) {
		this.d7Str = d7Str;
	}

	public String getD8Str() {
		return d8Str;
	}

	public void setD8Str(String d8Str) {
		this.d8Str = d8Str;
	}

	public String getBorrowStatus() {
		return borrowStatus;
	}

	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	
	
}
