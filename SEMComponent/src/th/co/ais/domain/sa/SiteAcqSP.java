package th.co.ais.domain.sa;

import java.io.Serializable;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class SiteAcqSP extends AbstractDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3157290914439150778L;
	private String rowId;
	private int no;
	private String can_edit;
	private String can_delete;
	private String can_print;
	private String docNo;
	private String p_company;
	private String p_region;
	private String p_req_type;
	private String p_title;
	private String p_docStatus;
	private String p_location_id;
	private String p_location_code;
	private String p_location_name;
	private String p_location_type;
	private String p_location_zone;
	private String p_site_code;
	private String p_contract_no;
	private String p_lessor_name;
	private Date p_effective_dt_from;
	private Date p_effective_dt_to;
	private Date p_expire_dt_from;
	private Date p_expire_dt_to;
	private String p_batch_no;
	private String p_user;
	private String p_address;
	private String p_province_id;
	private String p_phone;
	private String retResult;
	
	private String siteDetail;
	private String flowStatus;
	private String flowStatusId;
	private Date statusDT;
	private Date approveDT;
	private String approveBy;
	private String costPerYear;
	private String modifiedDetail;
	private String nearSiteCost;
	private String growingCost;
	private String flowRemark;
	private String networkStatus;
	private String editableFlag;
	private String reqOfficer;
	
	private String effDateStr;
	private String expDateStr;
	private String statusDTStr;
	private String approveDTStr;
	
	private String expireStatus;
	private String pendingStatus;
	private String currentFlag;
	private String noExpireFlag;
	private String sheetName;
	private String SiteId;
	private String owner;
	
	private String menuGroupDisplay;

	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getCan_edit() {
		return can_edit;
	}
	public void setCan_edit(String canEdit) {
		can_edit = canEdit;
	}
	public String getCan_delete() {
		return can_delete;
	}
	public void setCan_delete(String canDelete) {
		can_delete = canDelete;
	}
	public String getCan_print() {
		return can_print;
	}
	public void setCan_print(String canPrint) {
		can_print = canPrint;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getP_company() {
		return p_company;
	}
	public void setP_company(String pCompany) {
		p_company = pCompany;
	}
	public String getP_region() {
		return p_region;
	}
	public void setP_region(String pRegion) {
		p_region = pRegion;
	}
	
	public String getP_req_type() {
		return p_req_type;
	}
	public void setP_req_type(String pReqType) {
		p_req_type = pReqType;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String pTitle) {
		p_title = pTitle;
	}
	public String getP_docStatus() {
		return p_docStatus;
	}
	public void setP_docStatus(String pDocStatus) {
		p_docStatus = pDocStatus;
	}
	public String getP_location_id() {
		return p_location_id;
	}
	public void setP_location_id(String pLocationId) {
		p_location_id = pLocationId;
	}
	public String getP_location_code() {
		return p_location_code;
	}
	public void setP_location_code(String pLocationCode) {
		p_location_code = pLocationCode;
	}
	public String getP_location_name() {
		return p_location_name;
	}
	public void setP_location_name(String pLocationName) {
		p_location_name = pLocationName;
	}
	public String getP_location_type() {
		return p_location_type;
	}
	public void setP_location_type(String pLocationType) {
		p_location_type = pLocationType;
	}
	public String getP_location_zone() {
		return p_location_zone;
	}
	public void setP_location_zone(String pLocationZone) {
		p_location_zone = pLocationZone;
	}
	public String getP_site_code() {
		return p_site_code;
	}
	public void setP_site_code(String pSiteCode) {
		p_site_code = pSiteCode;
	}
	public String getP_contract_no() {
		return p_contract_no;
	}
	public void setP_contract_no(String pContractNo) {
		p_contract_no = pContractNo;
	}
	public String getP_lessor_name() {
		return p_lessor_name;
	}
	public void setP_lessor_name(String pLessorName) {
		p_lessor_name = pLessorName;
	}
	public Date getP_effective_dt_from() {
		return p_effective_dt_from;
	}
	public void setP_effective_dt_from(Date pEffectiveDtFrom) {
		p_effective_dt_from = pEffectiveDtFrom;
	}
	public Date getP_effective_dt_to() {
		return p_effective_dt_to;
	}
	public void setP_effective_dt_to(Date pEffectiveDtTo) {
		p_effective_dt_to = pEffectiveDtTo;
	}
	public Date getP_expire_dt_from() {
		return p_expire_dt_from;
	}
	public void setP_expire_dt_from(Date pExpireDtFrom) {
		p_expire_dt_from = pExpireDtFrom;
	}
	public Date getP_expire_dt_to() {
		return p_expire_dt_to;
	}
	public void setP_expire_dt_to(Date pExpireDtTo) {
		p_expire_dt_to = pExpireDtTo;
	}
	public String getP_batch_no() {
		return p_batch_no;
	}
	public void setP_batch_no(String pBatchNo) {
		p_batch_no = pBatchNo;
	}
	public String getP_user() {
		return p_user;
	}
	public void setP_user(String pUser) {
		p_user = pUser;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String pAddress) {
		p_address = pAddress;
	}
	public String getP_province_id() {
		return p_province_id;
	}
	public void setP_province_id(String pProvinceId) {
		p_province_id = pProvinceId;
	}
	public String getP_phone() {
		return p_phone;
	}
	public void setP_phone(String pPhone) {
		p_phone = pPhone;
	}
	public String getExpireStatus() {
		return expireStatus;
	}
	public void setExpireStatus(String expireStatus) {
		this.expireStatus = expireStatus;
	}
	public String getPendingStatus() {
		return pendingStatus;
	}
	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}
	
	
	public String getCurrentFlag() {
		return currentFlag;
	}
	public void setCurrentFlag(String currentFlag) {
		this.currentFlag = currentFlag;
	}
	public String getNoExpireFlag() {
		return noExpireFlag;
	}
	public void setNoExpireFlag(String noExpireFlag) {
		this.noExpireFlag = noExpireFlag;
	}
	
	public String getSiteDetail() {
		return siteDetail;
	}
	public void setSiteDetail(String siteDetail) {
		this.siteDetail = siteDetail;
	}
	
	public String getFlowStatus() {
		return flowStatus;
	}
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus;
	}
	public Date getStatusDT() {
		return statusDT;
	}
	public void setStatusDT(Date statusDT) {
		this.statusDT = statusDT;
	}
	public Date getApproveDT() {
		return approveDT;
	}
	public void setApproveDT(Date approveDT) {
		this.approveDT = approveDT;
	}
	public String getApproveBy() {
		return approveBy;
	}
	public void setApproveBy(String approveBy) {
		this.approveBy = approveBy;
	}
	public String getCostPerYear() {
		return costPerYear;
	}
	public void setCostPerYear(String costPerYear) {
		this.costPerYear = costPerYear;
	}
	public String getModifiedDetail() {
		return modifiedDetail;
	}
	public void setModifiedDetail(String modifiedDetail) {
		this.modifiedDetail = modifiedDetail;
	}
	public String getNearSiteCost() {
		return nearSiteCost;
	}
	public void setNearSiteCost(String nearSiteCost) {
		this.nearSiteCost = nearSiteCost;
	}
	public String getGrowingCost() {
		return growingCost;
	}
	public void setGrowingCost(String growingCost) {
		this.growingCost = growingCost;
	}
	public String getFlowRemark() {
		return flowRemark;
	}
	public void setFlowRemark(String flowRemark) {
		this.flowRemark = flowRemark;
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
	
	public String getNetworkStatus() {
		return networkStatus;
	}
	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}
	
	public String getEditableFlag() {
		return editableFlag;
	}
	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}
	
	public String getReqOfficer() {
		return reqOfficer;
	}
	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}
	
	public String getStatusDTStr() {
		return statusDTStr;
	}
	public void setStatusDTStr(String statusDTStr) {
		this.statusDTStr = statusDTStr;
	}
	
	public String getApproveDTStr() {
		return approveDTStr;
	}
	public void setApproveDTStr(String approveDTStr) {
		this.approveDTStr = approveDTStr;
	}
	
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getFlowStatusId() {
		return flowStatusId;
	}
	public void setFlowStatusId(String flowStatusId) {
		this.flowStatusId = flowStatusId;
	}
	
	public String getRetResult() {
		return retResult;
	}
	public void setRetResult(String retResult) {
		this.retResult = retResult;
	}
	
	public String getSiteId() {
		return SiteId;
	}
	public void setSiteId(String siteId) {
		SiteId = siteId;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getMenuGroupDisplay() {
		return menuGroupDisplay;
	}
	public void setMenuGroupDisplay(String menuGroupDisplay) {
		this.menuGroupDisplay = menuGroupDisplay;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}
}
