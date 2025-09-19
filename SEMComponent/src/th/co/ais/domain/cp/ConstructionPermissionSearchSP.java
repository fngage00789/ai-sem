package th.co.ais.domain.cp;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ConstructionPermissionSearchSP extends AbstractDomain{

	private static final long serialVersionUID = 6636113475771022070L;
	
	private String rowId;
	private String siteContructId;
	private String siteApproveId;
	private String reqId;
	private String siteInfoId;	
	private String company; 
	private String contractNo; 
	private String siteName; 
	private String locationId; // Location ID
	private String region;
	private String siteConstructStatus;
	private String siteConstructStatusName; 
	private String supplierName;
	private String docNo; 	
	private String conPermissionDocNo;
	private String conBuildDocNo;
	private String constructType; 
	private String constructTypeName;  
	private String constructStatus;   
	private String constructStatusName;
	private String conBillNo; 
	private String conBillPayStatus;
	private String conBillPayStatusName; 
	private String migrateFlag;
	private String siteStatusName;
	private String flowStatus;
	private String remarkNoRequest;
	private String totSendDocNo;
	private String totRefDocNo;
	private String siteAmphurId;
	private String siteProvinceId;

	
	
	// For Criterea
	
	private String companyCri; 
	private String contractNoCri;
	private String siteNameCri;
	private String locationIdCri;
	private String regionCri;
	private String siteConstructStatusCri;
	private String docNoCri;
	private String supplierNameCri;
	private String conPermissionDocNoCri;
	private String constructTypeCri;
	private String constructStatusCri;
	private String conBuildDocNoCri;
	private String conBillNoCri;
	private String conBillPayStatusCri; 
	private String migrateFlagCri;
	private String totSendDocNoCri;
	private String totRefDocNoCri;

	//added BY NEW 20190110 
	private String locationCodeCri;
	private String siteCodeCri;
	
	
	private boolean checkDisabled ;
	private boolean checkExpandPanel ; 
	private boolean checkExpandPanelTOT ;
	private boolean checkExpandPanelCon ;
	private boolean checkExpandPanelNoticeReject ;
	
	 
	private String vendorMasterId;   //VENDOR_MASTER_ID
	
	private String vendorCode;  	 // VENDOR_CODE
	private String vendorFullName; 	//VENDOR_FULL_NAME
	private String vendorName;   	//VENDOR_NAME
	private String vendorName2;		//VENDOR_NAME2
	private String vendorName3;		//VENDOR_NAME3
	private String vendorName4;		//VENDOR_NAME4
	private String idCard; //   ID_CARD
	private String taxId; //TAX_ID
	private String fullAddresss; // FULL_ADDRESS
	private String addresss; // ADDRESS
	
	
	
	private Date   docDt;
	private String project; 
	private String supplier; // supplier
	private String contactName;  
	private String telephone; 
	private String mobileNo; //MobileNo  MOBILE_NO
	private String fax;   // FAX
	private String email;
	private String detail; 
	private String postType; 
	private String postHeight;
	private String other; 
	private String localName; 
	private String localHouseNo;  
	private String district; 
	private String amphur;  
	private String province; 
	private String postCode; 
	
	//In case Select  TOT
	private Date tot_sup_req_dt;   
	private String tot_send_doc_no;  
	private Date tot_send_tot_dt; 			
	private Date tot_return_dt; 
	private String tot_result_status;  
	private String tot_ref_doc_no; 
	private String tot_remark_not_allow; 
	private Date tot_send_sup_dt; 
	private Date totSubReceiveDt;
	private Date tot_ref_doc_dt;
	
	// In Case Select 
	private Date con_sup_req_dt;	
	private Date con_permission_doc_dt = new Date(); 
	private String con_permission_doc_no; 
	private Date con_send_sup_dt; 
	private String con_result_status; 
	private String con_build_doc_no; 
	private String con_bill_no;
	private String con_bill_amt;
	private String con_wbs;// WBS
	private String con_bill_pay_flag; 
	private String con_bill_pay_status;
	private String con_remark_not_allow; 
	private Date con_bill_dt;
	private Date con_build_doc_dt;
	
	//Reject
	private Date  reject_dt	;	
	private String reject_by;		
	private String reject_remark;  		
	private Date reject_clear_dt; 		
	private String reject_clear_remark;	
	
	private String tokenProvince;
	
	private String create_by ;		
	private Date  create_dt;	
	private String update_by; 
	private Date  update_dt;		
	
	//flag
	
	private String editableFlag;
	
	private String contractId;
	private String terminateFlag;
	
	//added by NEW 19/03/2015 For Todo List To Search Page
	private String strParam;
	
	//added by NEW 2019/01/10 
	private String locationCode;
	private String siteCode;
	
	//Kanruethai.T
	private String noContract;
	private boolean noContractMigrate;
	private String dummyFlag;
	private boolean dummyFlagMigrate;
	private String recordStatus;
	private String userId;
	
	public String getCompanyCri() {
		return companyCri;
	}
	public void setCompanyCri(String companyCri) {
		this.companyCri = companyCri;
	}
	public String getContractNoCri() {
		return contractNoCri;
	}
	public void setContractNoCri(String contractNoCri) {
		this.contractNoCri = contractNoCri;
	}
	public String getSiteNameCri() {
		return siteNameCri;
	}
	public void setSiteNameCri(String siteNameCri) {
		this.siteNameCri = siteNameCri;
	}
	public String getLocationIdCri() {
		return locationIdCri;
	}
	public void setLocationIdCri(String locationIdCri) {
		this.locationIdCri = locationIdCri;
	}
	public String getRegionCri() {
		return regionCri;
	}
	public void setRegionCri(String regionCri) {
		this.regionCri = regionCri;
	}
	public String getSiteConstructStatusCri() {
		return siteConstructStatusCri;
	}
	public void setSiteConstructStatusCri(String siteConstructStatusCri) {
		this.siteConstructStatusCri = siteConstructStatusCri;
	}
	public String getDocNoCri() {
		return docNoCri;
	}
	public void setDocNoCri(String docNoCri) {
		this.docNoCri = docNoCri;
	}
	public String getSupplierNameCri() {
		return supplierNameCri;
	}
	public void setSupplierNameCri(String supplierNameCri) {
		this.supplierNameCri = supplierNameCri;
	}
	public String getConPermissionDocNoCri() {
		return conPermissionDocNoCri;
	}
	public void setConPermissionDocNoCri(String conPermissionDocNoCri) {
		this.conPermissionDocNoCri = conPermissionDocNoCri;
	}
	public String getConstructTypeCri() {
		return constructTypeCri;
	}
	public void setConstructTypeCri(String constructTypeCri) {
		this.constructTypeCri = constructTypeCri;
	}
	public String getConstructStatusCri() {
		return constructStatusCri;
	}
	public void setConstructStatusCri(String constructStatusCri) {
		this.constructStatusCri = constructStatusCri;
	}
	public String getConBuildDocNoCri() {
		return conBuildDocNoCri;
	}
	public void setConBuildDocNoCri(String conBuildDocNoCri) {
		this.conBuildDocNoCri = conBuildDocNoCri;
	}
	public String getConBillNoCri() {
		return conBillNoCri;
	}
	public void setConBillNoCri(String conBillNoCri) {
		this.conBillNoCri = conBillNoCri;
	}
	public String getConBillPayStatusCri() {
		return conBillPayStatusCri;
	}
	public void setConBillPayStatusCri(String conBillPayStatusCri) {
		this.conBillPayStatusCri = conBillPayStatusCri;
	}
	public String getMigrateFlagCri() {
		return migrateFlagCri;
	}
	public void setMigrateFlagCri(String migrateFlagCri) {
		this.migrateFlagCri = migrateFlagCri;
	}
	public boolean isCheckExpandPanelNoticeReject() {
		return checkExpandPanelNoticeReject;
	}
	public void setCheckExpandPanelNoticeReject(boolean checkExpandPanelNoticeReject) {
		this.checkExpandPanelNoticeReject = checkExpandPanelNoticeReject;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	public String getVendorCode() {
		return vendorCode;
	}
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
	public String getVendorFullName() {
		return vendorFullName;
	}
	public void setVendorFullName(String vendorFullName) {
		this.vendorFullName = vendorFullName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorName2() {
		return vendorName2;
	}
	public void setVendorName2(String vendorName2) {
		this.vendorName2 = vendorName2;
	}
	public String getVendorName3() {
		return vendorName3;
	}
	public void setVendorName3(String vendorName3) {
		this.vendorName3 = vendorName3;
	}
	public String getVendorName4() {
		return vendorName4;
	}
	public void setVendorName4(String vendorName4) {
		this.vendorName4 = vendorName4;
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
	public String getFullAddresss() {
		return fullAddresss;
	}
	public void setFullAddresss(String fullAddresss) {
		this.fullAddresss = fullAddresss;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	
	public boolean isCheckExpandPanelCon() {
		return checkExpandPanelCon;
	}
	public void setCheckExpandPanelCon(boolean checkExpandPanelCon) {
		this.checkExpandPanelCon = checkExpandPanelCon;
	}
	public boolean isCheckExpandPanelTOT() {
		return checkExpandPanelTOT;
	}
	public void setCheckExpandPanelTOT(boolean checkExpandPanelTOT) {
		this.checkExpandPanelTOT = checkExpandPanelTOT;
	}
	public Date getDocDt() {
		return docDt;
	}
	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public String getPostHeight() {
		return postHeight;
	}
	public void setPostHeight(String postHeight) {
		this.postHeight = postHeight;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getLocalHouseNo() {
		return localHouseNo;
	}
	public void setLocalHouseNo(String localHouseNo) {
		this.localHouseNo = localHouseNo;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Date getTot_sup_req_dt() {
		return tot_sup_req_dt;
	}
	public void setTot_sup_req_dt(Date totSupReqDt) {
		tot_sup_req_dt = totSupReqDt;
	}
	public String getTot_send_doc_no() {
		return tot_send_doc_no;
	}
	public void setTot_send_doc_no(String totSendDocNo) {
		tot_send_doc_no = totSendDocNo;
	}
	public Date getTot_send_tot_dt() {
		return tot_send_tot_dt;
	}
	public void setTot_send_tot_dt(Date totSendTotDt) {
		tot_send_tot_dt = totSendTotDt;
	}
	public Date getTot_return_dt() {
		return tot_return_dt;
	}
	public void setTot_return_dt(Date totReturnDt) {
		tot_return_dt = totReturnDt;
	}
	public String getTot_result_status() {
		return tot_result_status;
	}
	public void setTot_result_status(String totResultStatus) {
		tot_result_status = totResultStatus;
	}
	public String getTot_ref_doc_no() {
		return tot_ref_doc_no;
	}
	public void setTot_ref_doc_no(String totRefDocNo) {
		tot_ref_doc_no = totRefDocNo;
	}
	public String getTot_remark_not_allow() {
		return tot_remark_not_allow;
	}
	public void setTot_remark_not_allow(String totRemarkNotAllow) {
		tot_remark_not_allow = totRemarkNotAllow;
	}
	public Date getTot_send_sup_dt() {
		return tot_send_sup_dt;
	}
	public void setTot_send_sup_dt(Date totSendSupDt) {
		tot_send_sup_dt = totSendSupDt;
	}
	public Date getCon_sup_req_dt() {
		return con_sup_req_dt;
	}
	public void setCon_sup_req_dt(Date conSupReqDt) {
		con_sup_req_dt = conSupReqDt;
	}
	public Date getCon_permission_doc_dt() {
		return con_permission_doc_dt;
	}
	public void setCon_permission_doc_dt(Date conPermissionDocDt) {
		con_permission_doc_dt = conPermissionDocDt;
	}
	public String getCon_permission_doc_no() {
		return con_permission_doc_no;
	}
	public void setCon_permission_doc_no(String conPermissionDocNo) {
		con_permission_doc_no = conPermissionDocNo;
	}
	public Date getCon_send_sup_dt() {
		return con_send_sup_dt;
	}
	public void setCon_send_sup_dt(Date conSendSupDt) {
		con_send_sup_dt = conSendSupDt;
	}
	public String getCon_result_status() {
		return con_result_status;
	}
	public void setCon_result_status(String conResultStatus) {
		con_result_status = conResultStatus;
	}
	public String getCon_build_doc_no() {
		return con_build_doc_no;
	}
	public void setCon_build_doc_no(String conBuildDocNo) {
		con_build_doc_no = conBuildDocNo;
	}
	public String getCon_bill_no() {
		return con_bill_no;
	}
	public void setCon_bill_no(String conBillNo) {
		con_bill_no = conBillNo;
	}
	public String getCon_bill_amt() {
		return con_bill_amt;
	}
	public void setCon_bill_amt(String conBillAmt) {
		con_bill_amt = conBillAmt;
	}
	public String getCon_wbs() {
		return con_wbs;
	}
	public void setCon_wbs(String conWbs) {
		con_wbs = conWbs;
	}
	public String getCon_bill_pay_flag() {
		return con_bill_pay_flag;
	}
	public void setCon_bill_pay_flag(String conBillPayFlag) {
		con_bill_pay_flag = conBillPayFlag;
	}
	public String getCon_bill_pay_status() {
		return con_bill_pay_status;
	}
	public void setCon_bill_pay_status(String conBillPayStatus) {
		con_bill_pay_status = conBillPayStatus;
	}
	public String getCon_remark_not_allow() {
		return con_remark_not_allow;
	}
	public void setCon_remark_not_allow(String conRemarkNotAllow) {
		con_remark_not_allow = conRemarkNotAllow;
	}
	public Date getReject_dt() {
		return reject_dt;
	}
	public void setReject_dt(Date rejectDt) {
		reject_dt = rejectDt;
	}
	public String getReject_by() {
		return reject_by;
	}
	public void setReject_by(String rejectBy) {
		reject_by = rejectBy;
	}
	public String getReject_remark() {
		return reject_remark;
	}
	public void setReject_remark(String rejectRemark) {
		reject_remark = rejectRemark;
	}
	public Date getReject_clear_dt() {
		return reject_clear_dt;
	}
	public void setReject_clear_dt(Date rejectClearDt) {
		reject_clear_dt = rejectClearDt;
	}
	public String getReject_clear_remark() {
		return reject_clear_remark;
	}
	public void setReject_clear_remark(String rejectClearRemark) {
		reject_clear_remark = rejectClearRemark;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String createBy) {
		create_by = createBy;
	}
	public Date getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Date createDt) {
		create_dt = createDt;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String updateBy) {
		update_by = updateBy;
	}
	public Date getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(Date updateDt) {
		update_dt = updateDt;
	}
	
	public boolean isCheckExpandPanel() {
		return checkExpandPanel;
	}
	public void setCheckExpandPanel(boolean checkExpandPanel) {
		this.checkExpandPanel = checkExpandPanel;
	}
	public boolean isCheckDisabled() {
		return checkDisabled;
	}
	public void setCheckDisabled(boolean checkDisabled) {
		this.checkDisabled = checkDisabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSiteConstructStatus() {
		return siteConstructStatus;
	}
	public void setSiteConstructStatus(String siteConstructStatus) {
		this.siteConstructStatus = siteConstructStatus;
	}
	public String getSiteContructId() {
		return siteContructId;
	}
	public void setSiteContructId(String siteContructId) {
		this.siteContructId = siteContructId;
	}
	public String getConBuildDocNo() {
		return conBuildDocNo;
	}
	public void setConBuildDocNo(String conBuildDocNo) {
		this.conBuildDocNo = conBuildDocNo;
	}
	public String getConPermissionDocNo() {
		return conPermissionDocNo;
	}
	public void setConPermissionDocNo(String conPermissionDocNo) {
		this.conPermissionDocNo = conPermissionDocNo;
	}
	public String getSiteApproveId() {
		return siteApproveId;
	}
	public void setSiteApproveId(String siteApproveId) {
		this.siteApproveId = siteApproveId;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}	
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
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
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}	
	public String getSiteConstructStatusName() {
		return siteConstructStatusName;
	}
	public void setSiteConstructStatusName(String siteConstructStatusName) {
		this.siteConstructStatusName = siteConstructStatusName;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getConstructTypeName() {
		return constructTypeName;
	}
	public void setConstructTypeName(String constructTypeName) {
		this.constructTypeName = constructTypeName;
	}
	public String getConstructStatusName() {
		return constructStatusName;
	}
	public void setConstructStatusName(String constructStatusName) {
		this.constructStatusName = constructStatusName;
	}
	public String getConBillPayStatusName() {
		return conBillPayStatusName;
	}
	public void setConBillPayStatusName(String conBillPayStatusName) {
		this.conBillPayStatusName = conBillPayStatusName;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getConstructType() {
		return constructType;
	}
	public void setConstructType(String constructType) {
		this.constructType = constructType;
	}
	public String getConstructStatus() {
		return constructStatus;
	}
	public void setConstructStatus(String constructStatus) {
		this.constructStatus = constructStatus;
	}
	public String getConBillNo() {
		return conBillNo;
	}
	public void setConBillNo(String conBillNo) {
		this.conBillNo = conBillNo;
	}
	public String getConBillPayStatus() {
		return conBillPayStatus;
	}
	public void setConBillPayStatus(String conBillPayStatus) {
		this.conBillPayStatus = conBillPayStatus;
	}
	public String getMigrateFlag() {
		return migrateFlag;
	}
	public void setMigrateFlag(String migrateFlag) {
		this.migrateFlag = migrateFlag;
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
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegion() {
		return region;
	}
	public void setTotSubReceiveDt(Date totSubReceiveDt) {
		this.totSubReceiveDt = totSubReceiveDt;
	}
	public Date getTotSubReceiveDt() {
		return totSubReceiveDt;
	}
	public void setCon_bill_dt(Date con_bill_dt) {
		this.con_bill_dt = con_bill_dt;
	}
	public Date getCon_bill_dt() {
		return con_bill_dt;
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
	public String getRemarkNoRequest() {
		return remarkNoRequest;
	}
	public void setRemarkNoRequest(String remarkNoRequest) {
		this.remarkNoRequest = remarkNoRequest;
	}
	public String getTotSendDocNo() {
		return totSendDocNo;
	}
	public void setTotSendDocNo(String totSendDocNo) {
		this.totSendDocNo = totSendDocNo;
	}
	public String getTotRefDocNo() {
		return totRefDocNo;
	}
	public void setTotRefDocNo(String totRefDocNo) {
		this.totRefDocNo = totRefDocNo;
	}
	public String getTotSendDocNoCri() {
		return totSendDocNoCri;
	}
	public void setTotSendDocNoCri(String totSendDocNoCri) {
		this.totSendDocNoCri = totSendDocNoCri;
	}
	public String getTotRefDocNoCri() {
		return totRefDocNoCri;
	}
	public void setTotRefDocNoCri(String totRefDocNoCri) {
		this.totRefDocNoCri = totRefDocNoCri;
	}
	public String getSiteAmphurId() {
		return siteAmphurId;
	}
	public void setSiteAmphurId(String siteAmphurId) {
		this.siteAmphurId = siteAmphurId;
	}
	public String getSiteProvinceId() {
		return siteProvinceId;
	}
	public void setSiteProvinceId(String siteProvinceId) {
		this.siteProvinceId = siteProvinceId;
	}
	public String getEditableFlag() {
		return editableFlag;
	}
	public void setEditableFlag(String editableFlag) {
		this.editableFlag = editableFlag;
	}
	public String getTokenProvince() {
		return tokenProvince;
	}
	public void setTokenProvince(String tokenProvince) {
		this.tokenProvince = tokenProvince;
	}
	public Date getTot_ref_doc_dt() {
		return tot_ref_doc_dt;
	}
	public void setTot_ref_doc_dt(Date totRefDocDt) {
		tot_ref_doc_dt = totRefDocDt;
	}
	public Date getCon_build_doc_dt() {
		return con_build_doc_dt;
	}
	public void setCon_build_doc_dt(Date conBuildDocDt) {
		con_build_doc_dt = conBuildDocDt;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public String getTerminateFlag() {
		return terminateFlag;
	}
	public void setTerminateFlag(String terminateFlag) {
		this.terminateFlag = terminateFlag;
	}
	public String getStrParam() {
		return strParam;
	}
	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}
	public String getNoContract() {
		return noContract;
	}
	public void setNoContract(String noContract) {
		this.noContract = noContract;
	}
	public String getDummyFlag() {
		return dummyFlag;
	}
	public void setDummyFlag(String dummyFlag) {
		this.dummyFlag = dummyFlag;
	}
	public String getLocationCodeCri() {
		return locationCodeCri;
	}
	public void setLocationCodeCri(String locationCodeCri) {
		this.locationCodeCri = locationCodeCri;
	}
	public String getSiteCodeCri() {
		return siteCodeCri;
	}
	public void setSiteCodeCri(String siteCodeCri) {
		this.siteCodeCri = siteCodeCri;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean getDummyFlagMigrate() {
		if("Y".equalsIgnoreCase(this.dummyFlag)) {
			return true;
		}
		return false;
	}
	public void setDummyFlagMigrate(boolean dummyFlagMigrate) {
		this.dummyFlagMigrate = dummyFlagMigrate;
	}
	public boolean getNoContractMigrate() {
		if("Y".equalsIgnoreCase(this.noContract)) {
			return true;
		}
		return false;
	}
	public void setNoContractMigrate(boolean noContractMigrate) {
		this.noContractMigrate = noContractMigrate;
	}	
}