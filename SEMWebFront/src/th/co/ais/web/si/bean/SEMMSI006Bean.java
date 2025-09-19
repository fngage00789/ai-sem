package th.co.ais.web.si.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.ApproveRenewSearchSP;
import th.co.ais.domain.si.RegionZone;
import th.co.ais.domain.si.SendRenew;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI006Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> zoneList;
	private List<SelectItem> sendRenewTypeList;
	private List<SelectItem> approveStatusList;
	private List<SelectItem> sendRenewStatusList;
	private List<SelectItem> renewAgeCodeList;
	private List<SelectItem> siteTypeList;
	private List<SelectItem> regionList;
	
	private List<WrapperBeanObject<ApproveRenewSearchSP>> approveRenewSearchSPList;
	private ApproveRenewSearchSP approveRenewSearchSP;
	private RegionZone regionZone;
	
	private SendRenew sendRenew;
	private String validatePopup;
	private String rowId;
	private Boolean buttonAdd;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	private String msgConfirmSave;
	private String tmpChkApproveStatus;
	private boolean tmpFlagChkBtn;
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getZoneList() {
		return zoneList;
	}
	public void setZoneList(List<SelectItem> zoneList) {
		this.zoneList = zoneList;
	}
	public List<SelectItem> getSendRenewTypeList() {
		return sendRenewTypeList;
	}
	public void setSendRenewTypeList(List<SelectItem> sendRenewTypeList) {
		this.sendRenewTypeList = sendRenewTypeList;
	}
	public List<SelectItem> getApproveStatusList() {
		return approveStatusList;
	}
	public void setApproveStatusList(List<SelectItem> approveStatusList) {
		this.approveStatusList = approveStatusList;
	}
	public List<SelectItem> getSendRenewStatusList() {
		return sendRenewStatusList;
	}
	public void setSendRenewStatusList(List<SelectItem> sendRenewStatusList) {
		this.sendRenewStatusList = sendRenewStatusList;
	}
	public ApproveRenewSearchSP getApproveRenewSearchSP() {
		return approveRenewSearchSP;
	}
	public void setApproveRenewSearchSP(ApproveRenewSearchSP approveRenewSearchSP) {
		this.approveRenewSearchSP = approveRenewSearchSP;
	}
	public void setRenewAgeCodeList(List<SelectItem> renewAgeCodeList) {
		this.renewAgeCodeList = renewAgeCodeList;
	}
	public List<SelectItem> getRenewAgeCodeList() {
		return renewAgeCodeList;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getRowId() {
		return rowId;
	}
	public void setSendRenew(SendRenew sendRenew) {
		this.sendRenew = sendRenew;
	}
	public SendRenew getSendRenew() {
		return sendRenew;
	}
	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}
	public String getValidatePopup() {
		return validatePopup;
	}
	public void setButtonAdd(Boolean buttonAdd) {
		this.buttonAdd = buttonAdd;
	}
	public Boolean getButtonAdd() {
		return buttonAdd;
	}

	public boolean isChkSelAll() {
		return chkSelAll;
	}

	public void setChkSelAll(boolean chkSelAll) {
		this.chkSelAll = chkSelAll;
	}

	public boolean isDisabledBtnExport() {
		return disabledBtnExport;
	}

	public void setDisabledBtnExport(boolean disabledBtnExport) {
		this.disabledBtnExport = disabledBtnExport;
	}

	public void setApproveRenewSearchSPList(List<WrapperBeanObject<ApproveRenewSearchSP>> approveRenewSearchSPList) {
		this.approveRenewSearchSPList = approveRenewSearchSPList;
	}

	public List<WrapperBeanObject<ApproveRenewSearchSP>> getApproveRenewSearchSPList() {
		return approveRenewSearchSPList;
	}

	public List<SelectItem> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}

	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}

	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}

	public void setMsgConfirmSave(String msgConfirmSave) {
		this.msgConfirmSave = msgConfirmSave;
	}

	public String getMsgConfirmSave() {
		return msgConfirmSave;
	}

	public void setTmpChkApproveStatus(String tmpChkApproveStatus) {
		this.tmpChkApproveStatus = tmpChkApproveStatus;
	}

	public String getTmpChkApproveStatus() {
		return tmpChkApproveStatus;
	}

	public RegionZone getRegionZone() {
		return regionZone;
	}

	public void setRegionZone(RegionZone regionZone) {
		this.regionZone = regionZone;
	}

	/**
	 * @param tmpFlagChkBtn the tmpFlagChkBtn to set
	 */
	public void setTmpFlagChkBtn(boolean tmpFlagChkBtn) {
		this.tmpFlagChkBtn = tmpFlagChkBtn;
	}

	/**
	 * @return the tmpFlagChkBtn
	 */
	public boolean isTmpFlagChkBtn() {
		return tmpFlagChkBtn;
	}

}
