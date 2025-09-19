package th.co.ais.web.bean.common;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.cp.PopupVendorSupplierSearchSP;
import th.co.ais.web.bean.AbstractBean;

public class PopupVendorSupplierBean extends AbstractBean {

	private static final long serialVersionUID = 6909615740636416423L;
	
	private PopupVendorSupplierSearchSP popupVendorSupplierSearchSP;
	private List<PopupVendorSupplierSearchSP> popupVendorSupplierSearchSPList;
	private String popupType;
	private String vendorSupplierType;
	private String confirmDeleteMsg;
	private Boolean popupClose;
	private String page;
	private String tmpContractNo;
	
	
	
	private List<SelectItem> postTypeList; //เสาอากาศ ชนิด
	private List<SelectItem> constructTypeList;  //ประเภทขออนุญาตก่อสร้าง
	private List<SelectItem> constructStatusList; //สถานะขออนุญาตก่อสร้าง
	private List<SelectItem> provinceList; 
	
	
	private int rowPerPage = 10;
	
	public List<SelectItem> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<SelectItem> provinceList) {
		this.provinceList = provinceList;
	}
	public List<SelectItem> getPostTypeList() {
		return postTypeList;
	}
	public void setPostTypeList(List<SelectItem> postTypeList) {
		this.postTypeList = postTypeList;
	}
	public List<SelectItem> getConstructTypeList() {
		return constructTypeList;
	}
	public void setConstructTypeList(List<SelectItem> constructTypeList) {
		this.constructTypeList = constructTypeList;
	}
	public List<SelectItem> getConstructStatusList() {
		return constructStatusList;
	}
	public void setConstructStatusList(List<SelectItem> constructStatusList) {
		this.constructStatusList = constructStatusList;
	}
	public String getVendorSupplierType() {
		return vendorSupplierType;
	}
	public void setVendorSupplierType(String vendorSupplierType) {
		this.vendorSupplierType = vendorSupplierType;
	}
	public String getConfirmDeleteMsg() {
		return confirmDeleteMsg;
	}
	public void setConfirmDeleteMsg(String confirmDeleteMsg) {
		this.confirmDeleteMsg = confirmDeleteMsg;
	}
	public Boolean getPopupClose() {
		return popupClose;
	}
	public void setPopupClose(Boolean popupClose) {
		this.popupClose = popupClose;
	}
	public String getPopupType() {
		return popupType;
	}
	public void setPopupType(String popupType) {
		this.popupType = popupType;
	}
	public PopupVendorSupplierSearchSP getPopupVendorSupplierSearchSP() {
		return popupVendorSupplierSearchSP;
	}
	public void setPopupVendorSupplierSearchSP(
			PopupVendorSupplierSearchSP popupVendorSupplierSearchSP) {
		this.popupVendorSupplierSearchSP = popupVendorSupplierSearchSP;
	}
	public List<PopupVendorSupplierSearchSP> getPopupVendorSupplierSearchSPList() {
		return popupVendorSupplierSearchSPList;
	}
	public void setPopupVendorSupplierSearchSPList(
			List<PopupVendorSupplierSearchSP> popupVendorSupplierSearchSPList) {
		this.popupVendorSupplierSearchSPList = popupVendorSupplierSearchSPList;
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTmpContractNo() {
		return tmpContractNo;
	}
	public void setTmpContractNo(String tmpContractNo) {
		this.tmpContractNo = tmpContractNo;
	}


}
