package th.co.ais.domain.sa;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.DataUtil;

public class SiteAppReportObj extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3516070343499710058L;
	
	private String rowId;
	
	private String paramStr1;
	private String paramStr2;
	private String paramStr3;
	private String paramStr4;
	private String paramStr5;
	private String paramStr6;
	private String paramStr7;
	private String paramStr8;
	private String paramStr9;
	private String paramStr10;
	
	private String paymentDetail;
    private BigDecimal rentAmt;
    private String rentAmtDesc;
    private String bahtTxt;
    private String rentPreiodType;
    private String rentPreiodTypeName;
    private BigDecimal whtRate;
    private String whtType;
    private String vatRate;
    private String vatType;
    private String payPeriodCond;
    private String payPeriodType;
	private String payPeriodTypeName;
	private String rentAmtTxt;
    private BigDecimal rentOldAmt;
    private String rentOldAmtDesc;
    private String rentOldPeriodType;
    private String incDec;
    private BigDecimal rentAddPercent;
    private String rentAddConclusion;
    private BigDecimal rentAddAmt;
    private String rentAddAmtDesc;
	private String renewFlag;
	
	private String siteAppDepositId;
	private String expenseType;
	private String expenseTypeName;
	private String depositType;
	private String depositTypeName;
	private String newStatus;
	private String newStatusName;
	private BigDecimal depositAmt;
	private String depositAmtDesc;
	private String depositStatus;
	private String vatTypeName;
	private BigDecimal depositAmtOld;
	private String depositAmtOldDesc;
	private BigDecimal depositAmtNew;
	private String depositAmtNewDesc;
	private BigDecimal incDecAmt;
	
	private String siteAppElectricCondId;
	 private String siteAppId;
	 private String saElectricType;
	 private String elType;
	 private String elTypeName;
	 private String elCondSubType;
	 private String elCondSubTypeName;
	 private BigDecimal elAmt;
	 private String elAmtDesc;
	 private String elPeriodType;
	 private String elPeriodTypeName;
	 private String detail;
	
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getParamStr1() {
		return paramStr1;
	}

	public void setParamStr1(String paramStr1) {
		this.paramStr1 = paramStr1;
	}

	public String getParamStr2() {
		return paramStr2;
	}

	public void setParamStr2(String paramStr2) {
		this.paramStr2 = paramStr2;
	}

	public String getParamStr3() {
		return paramStr3;
	}

	public void setParamStr3(String paramStr3) {
		this.paramStr3 = paramStr3;
	}

	public String getParamStr4() {
		return paramStr4;
	}

	public void setParamStr4(String paramStr4) {
		this.paramStr4 = paramStr4;
	}

	public String getParamStr5() {
		return paramStr5;
	}

	public void setParamStr5(String paramStr5) {
		this.paramStr5 = paramStr5;
	}

	public String getParamStr6() {
		return paramStr6;
	}

	public void setParamStr6(String paramStr6) {
		this.paramStr6 = paramStr6;
	}

	public String getParamStr7() {
		return paramStr7;
	}

	public void setParamStr7(String paramStr7) {
		this.paramStr7 = paramStr7;
	}

	public String getParamStr8() {
		return paramStr8;
	}

	public void setParamStr8(String paramStr8) {
		this.paramStr8 = paramStr8;
	}

	public String getParamStr9() {
		return paramStr9;
	}

	public void setParamStr9(String paramStr9) {
		this.paramStr9 = paramStr9;
	}

	public String getParamStr10() {
		return paramStr10;
	}

	public void setParamStr10(String paramStr10) {
		this.paramStr10 = paramStr10;
	}

	public String getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(String paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public BigDecimal getRentAmt() {
		return rentAmt;
	}

	public void setRentAmt(BigDecimal rentAmt) {
		this.rentAmt = rentAmt;
	}

	public String getRentAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getRentAmt());
	}

	public void setRentAmtDesc(String rentAmtDesc) {
		this.rentAmtDesc = rentAmtDesc;
	}

	public String getBahtTxt() {
		return bahtTxt;
	}

	public void setBahtTxt(String bahtTxt) {
		this.bahtTxt = bahtTxt;
	}

	public String getRentPreiodType() {
		return rentPreiodType;
	}

	public void setRentPreiodType(String rentPreiodType) {
		this.rentPreiodType = rentPreiodType;
	}

	public String getRentPreiodTypeName() {
		return rentPreiodTypeName;
	}

	public void setRentPreiodTypeName(String rentPreiodTypeName) {
		this.rentPreiodTypeName = rentPreiodTypeName;
	}

	public BigDecimal getWhtRate() {
		return whtRate;
	}

	public void setWhtRate(BigDecimal whtRate) {
		this.whtRate = whtRate;
	}

	public String getWhtType() {
		return whtType;
	}

	public void setWhtType(String whtType) {
		this.whtType = whtType;
	}

	public String getVatRate() {
		return vatRate;
	}

	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	public String getVatType() {
		return vatType;
	}

	public void setVatType(String vatType) {
		this.vatType = vatType;
	}

	public String getPayPeriodCond() {
		return payPeriodCond;
	}

	public void setPayPeriodCond(String payPeriodCond) {
		this.payPeriodCond = payPeriodCond;
	}

	public String getPayPeriodType() {
		return payPeriodType;
	}

	public void setPayPeriodType(String payPeriodType) {
		this.payPeriodType = payPeriodType;
	}

	public String getPayPeriodTypeName() {
		return payPeriodTypeName;
	}

	public void setPayPeriodTypeName(String payPeriodTypeName) {
		this.payPeriodTypeName = payPeriodTypeName;
	}

	public String getRentAmtTxt() {
		return rentAmtTxt;
	}

	public void setRentAmtTxt(String rentAmtTxt) {
		this.rentAmtTxt = rentAmtTxt;
	}

	public BigDecimal getRentOldAmt() {
		return rentOldAmt;
	}

	public void setRentOldAmt(BigDecimal rentOldAmt) {
		this.rentOldAmt = rentOldAmt;
	}

	public String getRentOldAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getRentOldAmt());
	}

	public void setRentOldAmtDesc(String rentOldAmtDesc) {
		this.rentOldAmtDesc = rentOldAmtDesc;
	}

	public String getRentOldPeriodType() {
		return rentOldPeriodType;
	}

	public void setRentOldPeriodType(String rentOldPeriodType) {
		this.rentOldPeriodType = rentOldPeriodType;
	}

	public String getIncDec() {
		return incDec;
	}

	public void setIncDec(String incDec) {
		this.incDec = incDec;
	}

	public BigDecimal getRentAddPercent() {
		return rentAddPercent;
	}

	public void setRentAddPercent(BigDecimal rentAddPercent) {
		this.rentAddPercent = rentAddPercent;
	}

	public String getRentAddConclusion() {
		return rentAddConclusion;
	}

	public void setRentAddConclusion(String rentAddConclusion) {
		this.rentAddConclusion = rentAddConclusion;
	}

	public BigDecimal getRentAddAmt() {
		return rentAddAmt;
	}

	public void setRentAddAmt(BigDecimal rentAddAmt) {
		this.rentAddAmt = rentAddAmt;
	}

	public String getRentAddAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getRentAddAmt());
	}

	public void setRentAddAmtDesc(String rentAddAmtDesc) {
		this.rentAddAmtDesc = rentAddAmtDesc;
	}

	public String getRenewFlag() {
		return renewFlag;
	}

	public void setRenewFlag(String renewFlag) {
		this.renewFlag = renewFlag;
	}

	public String getSiteAppDepositId() {
		return siteAppDepositId;
	}

	public void setSiteAppDepositId(String siteAppDepositId) {
		this.siteAppDepositId = siteAppDepositId;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseTypeName() {
		return expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName) {
		this.expenseTypeName = expenseTypeName;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public String getDepositTypeName() {
		return depositTypeName;
	}

	public void setDepositTypeName(String depositTypeName) {
		this.depositTypeName = depositTypeName;
	}

	public String getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public String getNewStatusName() {
		return newStatusName;
	}

	public void setNewStatusName(String newStatusName) {
		this.newStatusName = newStatusName;
	}

	public BigDecimal getDepositAmt() {
		return depositAmt;
	}

	public void setDepositAmt(BigDecimal depositAmt) {
		this.depositAmt = depositAmt;
	}

	public String getDepositAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getDepositAmt());
	}

	public void setDepositAmtDesc(String depositAmtDesc) {
		this.depositAmtDesc = depositAmtDesc;
	}

	public String getDepositStatus() {
		return depositStatus;
	}

	public void setDepositStatus(String depositStatus) {
		this.depositStatus = depositStatus;
	}

	public String getVatTypeName() {
		return vatTypeName;
	}

	public void setVatTypeName(String vatTypeName) {
		this.vatTypeName = vatTypeName;
	}

	public BigDecimal getDepositAmtOld() {
		return depositAmtOld;
	}

	public void setDepositAmtOld(BigDecimal depositAmtOld) {
		this.depositAmtOld = depositAmtOld;
	}

	public String getDepositAmtOldDesc() {
		return DataUtil.convert2ThaiBathSA(getDepositAmtOld());
	}

	public void setDepositAmtOldDesc(String depositAmtOldDesc) {
		this.depositAmtOldDesc = depositAmtOldDesc;
	}

	public BigDecimal getDepositAmtNew() {
		return depositAmtNew;
	}

	public void setDepositAmtNew(BigDecimal depositAmtNew) {
		this.depositAmtNew = depositAmtNew;
	}

	public String getDepositAmtNewDesc() {
		return DataUtil.convert2ThaiBathSA(getDepositAmtNew());
	}

	public void setDepositAmtNewDesc(String depositAmtNewDesc) {
		this.depositAmtNewDesc = depositAmtNewDesc;
	}

	public BigDecimal getIncDecAmt() {
		return incDecAmt;
	}

	public void setIncDecAmt(BigDecimal incDecAmt) {
		this.incDecAmt = incDecAmt;
	}

	public String getSiteAppElectricCondId() {
		return siteAppElectricCondId;
	}

	public void setSiteAppElectricCondId(String siteAppElectricCondId) {
		this.siteAppElectricCondId = siteAppElectricCondId;
	}

	public String getSiteAppId() {
		return siteAppId;
	}

	public void setSiteAppId(String siteAppId) {
		this.siteAppId = siteAppId;
	}

	public String getSaElectricType() {
		return saElectricType;
	}

	public void setSaElectricType(String saElectricType) {
		this.saElectricType = saElectricType;
	}

	public String getElType() {
		return elType;
	}

	public void setElType(String elType) {
		this.elType = elType;
	}

	public String getElTypeName() {
		return elTypeName;
	}

	public void setElTypeName(String elTypeName) {
		this.elTypeName = elTypeName;
	}

	public String getElCondSubType() {
		return elCondSubType;
	}

	public void setElCondSubType(String elCondSubType) {
		this.elCondSubType = elCondSubType;
	}

	public String getElCondSubTypeName() {
		return elCondSubTypeName;
	}

	public void setElCondSubTypeName(String elCondSubTypeName) {
		this.elCondSubTypeName = elCondSubTypeName;
	}

	public BigDecimal getElAmt() {
		return elAmt;
	}

	public void setElAmt(BigDecimal elAmt) {
		this.elAmt = elAmt;
	}

	public String getElAmtDesc() {
		return DataUtil.convert2ThaiBathSA(getElAmt());
	}

	public void setElAmtDesc(String elAmtDesc) {
		this.elAmtDesc = elAmtDesc;
	}

	public String getElPeriodType() {
		return elPeriodType;
	}

	public void setElPeriodType(String elPeriodType) {
		this.elPeriodType = elPeriodType;
	}

	public String getElPeriodTypeName() {
		return elPeriodTypeName;
	}

	public void setElPeriodTypeName(String elPeriodTypeName) {
		this.elPeriodTypeName = elPeriodTypeName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
