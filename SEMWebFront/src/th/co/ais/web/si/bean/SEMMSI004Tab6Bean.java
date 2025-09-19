package th.co.ais.web.si.bean;

import java.util.List;

import javax.faces.model.SelectItem;

import th.co.ais.domain.sa.SiteAppSP;
import th.co.ais.domain.si.Insurance;
import th.co.ais.domain.si.SiteInfoMapSiteAcqSP;
import th.co.ais.util.WrapperBeanObject;
import th.co.ais.web.bean.AbstractBean;

public class SEMMSI004Tab6Bean extends AbstractBean {

	private static final long serialVersionUID = -7689510868844542871L;
	
	private String payPeriodType01;
	private String payPeriodType02;
	private String payPeriodType03;
	private String payPeriodType04;
	private String payPeriodType05;
	private Integer payPeriod03;
	private Integer payPeriod04;
	private String siteInfoId;
	private Insurance insurance;
	private boolean renderedPLX;
	private boolean renderedInsuranceOwner;
	private boolean disabledPayPeriod03;
	private boolean disabledPayPeriod04;
	private boolean disabledInsurance;
	private String editableInsuranceFlag;
	private boolean noOwnerAmtFlag;
	private List<SelectItem> insuranceTypeList;
	private String irHeaderLabel = "";
	private List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppInsuranceList;
	
	//added by NEW 2018/10/17
	private boolean chkIREditFlag;
	private String InsuranceEditFlag = "N";
	
	
	public boolean isDisabledInsurance() {
		return disabledInsurance;
	}

	public void setDisabledInsurance(boolean disabledInsurance) {
		this.disabledInsurance = disabledInsurance;
	}

	public String getEditableInsuranceFlag() {
		return editableInsuranceFlag;
	}

	public void setEditableInsuranceFlag(String editableInsuranceFlag) {
		this.editableInsuranceFlag = editableInsuranceFlag;
	}

	public boolean isDisabledPayPeriod03() {
		return disabledPayPeriod03;
	}

	public void setDisabledPayPeriod03(boolean disabledPayPeriod03) {
		this.disabledPayPeriod03 = disabledPayPeriod03;
	}

	public boolean isDisabledPayPeriod04() {
		return disabledPayPeriod04;
	}

	public void setDisabledPayPeriod04(boolean disabledPayPeriod04) {
		this.disabledPayPeriod04 = disabledPayPeriod04;
	}

	public boolean isRenderedInsuranceOwner() {
		return renderedInsuranceOwner;
	}

	public void setRenderedInsuranceOwner(boolean renderedInsuranceOwner) {
		this.renderedInsuranceOwner = renderedInsuranceOwner;
	}

	public boolean isRenderedPLX() {
		return renderedPLX;
	}

	public void setRenderedPLX(boolean renderedPLX) {
		this.renderedPLX = renderedPLX;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getPayPeriodType01() {
		return payPeriodType01;
	}

	public void setPayPeriodType01(String payPeriodType01) {
		this.payPeriodType01 = payPeriodType01;
	}

	public String getPayPeriodType02() {
		return payPeriodType02;
	}

	public void setPayPeriodType02(String payPeriodType02) {
		this.payPeriodType02 = payPeriodType02;
	}

	public String getPayPeriodType03() {
		return payPeriodType03;
	}

	public void setPayPeriodType03(String payPeriodType03) {
		this.payPeriodType03 = payPeriodType03;
	}

	public String getPayPeriodType04() {
		return payPeriodType04;
	}

	public void setPayPeriodType04(String payPeriodType04) {
		this.payPeriodType04 = payPeriodType04;
	}

	public String getPayPeriodType05() {
		return payPeriodType05;
	}

	public void setPayPeriodType05(String payPeriodType05) {
		this.payPeriodType05 = payPeriodType05;
	}

	public Integer getPayPeriod03() {
		return payPeriod03;
	}

	public void setPayPeriod03(Integer payPeriod03) {
		this.payPeriod03 = payPeriod03;
	}

	public Integer getPayPeriod04() {
		return payPeriod04;
	}

	public void setPayPeriod04(Integer payPeriod04) {
		this.payPeriod04 = payPeriod04;
	}

	@Override
	public int getRowPerPage() {
		return this.rowPerPage;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
		
	}

	public boolean isNoOwnerAmtFlag() {
		return noOwnerAmtFlag;
	}

	public void setNoOwnerAmtFlag(boolean noOwnerAmtFlag) {
		this.noOwnerAmtFlag = noOwnerAmtFlag;
	}

	public List<SelectItem> getInsuranceTypeList() {
		return insuranceTypeList;
	}

	public void setInsuranceTypeList(List<SelectItem> insuranceTypeList) {
		this.insuranceTypeList = insuranceTypeList;
	}

	public String getIrHeaderLabel() {
		return irHeaderLabel;
	}

	public void setIrHeaderLabel(String irHeaderLabel) {
		this.irHeaderLabel = irHeaderLabel;
	}

	public List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> getSiteAppInsuranceList() {
		return siteAppInsuranceList;
	}

	public void setSiteAppInsuranceList(
			List<WrapperBeanObject<SiteInfoMapSiteAcqSP>> siteAppInsuranceList) {
		this.siteAppInsuranceList = siteAppInsuranceList;
	}

	public boolean isChkIREditFlag() {
		return chkIREditFlag;
	}

	public void setChkIREditFlag(boolean chkIREditFlag) {
		this.chkIREditFlag = chkIREditFlag;
	}

	public String getInsuranceEditFlag() {
		return InsuranceEditFlag;
	}

	public void setInsuranceEditFlag(String insuranceEditFlag) {
		InsuranceEditFlag = insuranceEditFlag;
	}

}
