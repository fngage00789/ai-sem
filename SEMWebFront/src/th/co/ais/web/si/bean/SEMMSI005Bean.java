package th.co.ais.web.si.bean;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.si.SendRenew;
import th.co.ais.domain.si.SendRenewExpSrchSP;
import th.co.ais.domain.si.SendRenewSrchSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI005Bean extends AbstractBean{

	private List<SelectItem> companyList;
	private List<SelectItem> regionList;
	private List<SelectItem> sendRenewapproveStatusList;
	private List<SelectItem> sendRenewTypeList;
	private List<SelectItem> sendRenewStatusList;
	private List<SelectItem> siteTypeList;
	
	private List<WrapperBeanObject<SendRenewSrchSP>> sendRenewSrchSPList;
	private SendRenewSrchSP sendRenewSrchSP;
	
	private List<WrapperBeanObject<SendRenewExpSrchSP>> sendRenewExpSrchSPList;
	private SendRenewExpSrchSP sendRenewExpSrchSP;
	
	private SendRenew sendRenew; 
	private Date sendRenewBackDt;
	private String validatePopup;
	private boolean validateDelete;
	
	public String tmpRowId2;
	
	private boolean chkSelAll = false;
	private boolean disabledBtnExport=true;
	
	private boolean disableBtnApprove;
	private boolean disableBtnSam;
	
	private String tmpSendrenewStatus;
	
	//Page 2
	private boolean chkSelAll2 = false;
	private boolean disabledBtnExport2=true;
	
	private boolean chkFlag;
	private boolean chkPico;
	
	public List<SelectItem> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<SelectItem> companyList) {
		this.companyList = companyList;
	}
	public List<SelectItem> getRegionList() {
		return regionList;
	}
	public void setRegionList(List<SelectItem> regionList) {
		this.regionList = regionList;
	}
	
	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}
	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	public SendRenewSrchSP getSendRenewSrchSP() {
		return sendRenewSrchSP;
	}
	public void setSendRenewSrchSP(SendRenewSrchSP sendRenewSrchSP) {
		this.sendRenewSrchSP = sendRenewSrchSP;
	}
	public List<SelectItem> getSendRenewTypeList() {
		return sendRenewTypeList;
	}
	public void setSendRenewTypeList(List<SelectItem> sendRenewTypeList) {
		this.sendRenewTypeList = sendRenewTypeList;
	}
	public List<SelectItem> getSendRenewStatusList() {
		return sendRenewStatusList;
	}
	public void setSendRenewStatusList(List<SelectItem> sendRenewStatusList) {
		this.sendRenewStatusList = sendRenewStatusList;
	}
	public void setSendRenewapproveStatusList(
			List<SelectItem> sendRenewapproveStatusList) {
		this.sendRenewapproveStatusList = sendRenewapproveStatusList;
	}
	public List<SelectItem> getSendRenewapproveStatusList() {
		return sendRenewapproveStatusList;
	}
	public SendRenewExpSrchSP getSendRenewExpSrchSP() {
		return sendRenewExpSrchSP;
	}
	public void setSendRenewExpSrchSP(SendRenewExpSrchSP sendRenewExpSrchSP) {
		this.sendRenewExpSrchSP = sendRenewExpSrchSP;
	}
	public void setSendRenew(SendRenew sendRenew) {
		this.sendRenew = sendRenew;
	}
	public SendRenew getSendRenew() {
		return sendRenew;
	}
	public String getTmpRowId2() {
		return tmpRowId2;
	}
	public void setTmpRowId2(String tmpRowId2) {
		this.tmpRowId2 = tmpRowId2;
	}
	public void setSendRenewBackDt(Date sendRenewBackDt) {
		this.sendRenewBackDt = sendRenewBackDt;
	}
	public Date getSendRenewBackDt() {
		return sendRenewBackDt;
	}
	public void setValidatePopup(String validatePopup) {
		this.validatePopup = validatePopup;
	}
	public String getValidatePopup() {
		return validatePopup;
	}
	public void setValidateDelete(boolean validateDelete) {
		this.validateDelete = validateDelete;
	}
	public boolean getValidateDelete() {
		return validateDelete;
	}
	public void setSendRenewSrchSPList(List<WrapperBeanObject<SendRenewSrchSP>> sendRenewSrchSPList) {
		this.sendRenewSrchSPList = sendRenewSrchSPList;
	}
	public List<WrapperBeanObject<SendRenewSrchSP>> getSendRenewSrchSPList() {
		return sendRenewSrchSPList;
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
	public void setSendRenewExpSrchSPList(List<WrapperBeanObject<SendRenewExpSrchSP>> sendRenewExpSrchSPList) {
		this.sendRenewExpSrchSPList = sendRenewExpSrchSPList;
	}
	public List<WrapperBeanObject<SendRenewExpSrchSP>> getSendRenewExpSrchSPList() {
		return sendRenewExpSrchSPList;
	}
	public boolean isChkSelAll2() {
		return chkSelAll2;
	}
	public void setChkSelAll2(boolean chkSelAll2) {
		this.chkSelAll2 = chkSelAll2;
	}
	public boolean isDisabledBtnExport2() {
		return disabledBtnExport2;
	}
	public void setDisabledBtnExport2(boolean disabledBtnExport2) {
		this.disabledBtnExport2 = disabledBtnExport2;
	}
	public void setSiteTypeList(List<SelectItem> siteTypeList) {
		this.siteTypeList = siteTypeList;
	}
	public List<SelectItem> getSiteTypeList() {
		return siteTypeList;
	}
	public boolean isDisableBtnApprove() {
		return disableBtnApprove;
	}
	public void setDisableBtnApprove(boolean disableBtnApprove) {
		this.disableBtnApprove = disableBtnApprove;
	}
	public boolean isDisableBtnSam() {
		return disableBtnSam;
	}
	public void setDisableBtnSam(boolean disableBtnSam) {
		this.disableBtnSam = disableBtnSam;
	}
	public void setTmpSendrenewStatus(String tmpSendrenewStatus) {
		this.tmpSendrenewStatus = tmpSendrenewStatus;
	}
	public String getTmpSendrenewStatus() {
		return tmpSendrenewStatus;
	}
	public void setChkFlag(boolean chkFlag) {
		this.chkFlag = chkFlag;
	}
	public boolean isChkFlag() {
		return chkFlag;
	}
	public boolean isChkPico() {
		return chkPico;
	}
	public void setChkPico(boolean chkPico) {
		this.chkPico = chkPico;
	}

}
