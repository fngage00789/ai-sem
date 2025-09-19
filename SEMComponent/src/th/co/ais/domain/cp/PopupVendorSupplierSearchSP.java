package th.co.ais.domain.cp;

import java.io.Serializable;
import java.util.Date;
 
public class PopupVendorSupplierSearchSP implements Serializable{

	private static final long serialVersionUID = -5860905113316848734L;
	
	private String rowId;	
	// OutPut
	private String vendorMasterId;
	private String vendorName;
	/*private String vendorName2;
	private String vendorName3;
	private String vendorName4;*/
	
	private String addresss;
	
	private String mobileNo;
	
	private String vendorFullName;
	private String vendorFullNameLocal;
	private String fullAddresss;		
	
	private String vendorCode;
	private String name;
	private String identityId;
	private String taxId;
	
	private	String	docNo;	
	private	Date	docDt;	
	private	String	project; 	
	private	String	supplier; 	
	private String  contactName; 
	private String  telephone; 	
	private String  fax; 		
	private	String	email;	
	private	String	detail;	
	private	String	postType; 	
	private String  postHeight; 
	private	String	other;	
	private	String	localName; 	 
	private	String	localHouseNo;	
	private String  district; 	
	private String  amphur; 	
	private String  province; 	
	private String  postCode; 
	private	String	constructType; 	
	private	String	constructStatus;
	
	// add Spec 
	private	String	address1;	
	private	String	address2;	
	private	String	city;	
	
	
	
	
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
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

	// Input
	private String vendorCodeCri;
	private String nameCri;
	private String identityIdCri;
	private String taxIdCri;
	private String provinceCri;
	private String vendorSupplierType;
	
	
	
	public String getProvinceCri() {
		return provinceCri;
	}

	public void setProvinceCri(String provinceCri) {
		this.provinceCri = provinceCri;
	}

	public String getVendorCodeCri() {
		return vendorCodeCri;
	}

	public void setVendorCodeCri(String vendorCodeCri) {
		this.vendorCodeCri = vendorCodeCri;
	}

	public String getNameCri() {
		return nameCri;
	}

	public void setNameCri(String nameCri) {
		this.nameCri = nameCri;
	}

	public String getIdentityIdCri() {
		return identityIdCri;
	}

	public void setIdentityIdCri(String identityIdCri) {
		this.identityIdCri = identityIdCri;
	}

	public String getTaxIdCri() {
		return taxIdCri;
	}

	public void setTaxIdCri(String taxIdCri) {
		this.taxIdCri = taxIdCri;
	}

	public String getVendorFullNameLocal() {
		return vendorFullNameLocal;
	}

	public void setVendorFullNameLocal(String vendorFullNameLocal) {
		this.vendorFullNameLocal = vendorFullNameLocal;
	}

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}
	public String getVendorMasterId() {
		return vendorMasterId;
	}

	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public String getVendorFullName() {
		return vendorFullName;
	}

	public void setVendorFullName(String vendorFullName) {
		this.vendorFullName = vendorFullName;
	}

	public String getFullAddresss() {
		return fullAddresss;
	}

	public void setFullAddresss(String fullAddresss) {
		this.fullAddresss = fullAddresss;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	public String getVendorSupplierType() {
		return vendorSupplierType;
	}

	public void setVendorSupplierType(String vendorSupplierType) {
		this.vendorSupplierType = vendorSupplierType;
	}

}
