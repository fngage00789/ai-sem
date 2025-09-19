package th.co.ais.web.el.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.el.MeterInfo;
import th.co.ais.web.bean.AbstractBean;

public class SEMMEL004Bean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = -168357028041134335L;

	private String company;
	private String electricUseType;
	private String oneBillAddFlag;
	private String contractNo;
	private String siteName;
	private String pMeterOwnerName;
	private String locationId;
	private String locationCode;
	private Date uploadMeterDtFrom;
	private Date uploadMeterDtTo;
	private Date eOneBillDt;
	private Date eOneBillDtFrom;
	private Date eOneBillDtTo;

	private boolean chkSelAll;
	private boolean disabledBtnExport = true;
	private List<MeterInfo> meterInfoList;

	// data dropdown list
	private List<SelectItem> companyList;
	private List<SelectItem> electricUseTypeList;
	private List<SelectItem> oneBillAddFlagList;

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
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

	public String getpMeterOwnerName() {
		return pMeterOwnerName;
	}

	public void setpMeterOwnerName(String pMeterOwnerName) {
		this.pMeterOwnerName = pMeterOwnerName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getUploadMeterDtFrom() {
		return uploadMeterDtFrom;
	}

	public void setUploadMeterDtFrom(Date uploadMeterDtFrom) {
		this.uploadMeterDtFrom = uploadMeterDtFrom;
	}

	public Date getUploadMeterDtTo() {
		return uploadMeterDtTo;
	}

	public void setUploadMeterDtTo(Date uploadMeterDtTo) {
		this.uploadMeterDtTo = uploadMeterDtTo;
	}

	public Date geteOneBillDt() {
		return eOneBillDt;
	}

	public void seteOneBillDt(Date eOneBillDt) {
		this.eOneBillDt = eOneBillDt;
	}

	public List<SelectItem> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}

	public List<SelectItem> getElectricUseTypeList() {
		return electricUseTypeList;
	}

	public void setElectricUseTypeList(List<SelectItem> electricUseTypeList) {
		this.electricUseTypeList = electricUseTypeList;
	}

	public List<SelectItem> getOneBillAddFlagList() {
		return oneBillAddFlagList;
	}

	public void setOneBillAddFlagList(List<SelectItem> oneBillAddFlagList) {
		this.oneBillAddFlagList = oneBillAddFlagList;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getElectricUseType() {
		return electricUseType;
	}

	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public String getOneBillAddFlag() {
		return oneBillAddFlag;
	}

	public void setOneBillAddFlag(String oneBillAddFlag) {
		this.oneBillAddFlag = oneBillAddFlag;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public List<MeterInfo> getMeterInfoList() {
		return meterInfoList;
	}

	public void setMeterInfoList(List<MeterInfo> meterInfoList) {
		this.meterInfoList = meterInfoList;
	}

	public Date geteOneBillDtFrom() {
		return eOneBillDtFrom;
	}

	public void seteOneBillDtFrom(Date eOneBillDtFrom) {
		this.eOneBillDtFrom = eOneBillDtFrom;
	}

	public Date geteOneBillDtTo() {
		return eOneBillDtTo;
	}

	public void seteOneBillDtTo(Date eOneBillDtTo) {
		this.eOneBillDtTo = eOneBillDtTo;
	}

}
