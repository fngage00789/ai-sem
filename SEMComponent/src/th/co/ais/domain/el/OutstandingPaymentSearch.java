package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class OutstandingPaymentSearch  implements Serializable {

	private static final long serialVersionUID = -748599263289088321L;	
	
	private String company;
	private String contractNo;
	private String region;
	private String province;	
	private Date fromTermOfPaymentDt;	
	private Date toTermOfPaymentDt;	
	private String termOfPayment;
	private String  electricUseType;	
	private String fromTermOfPaymentDtMonth;
	private String fromTermOfPaymentDtYear;
	private String toTermOfPaymentDtMonth;
	private String toTermOfPaymentDtYear;	
	private BigDecimal totalSiteOutstanding;
	
	
	
	
	public BigDecimal getTotalSiteOutstanding() {
		return totalSiteOutstanding;
	}
	public void setTotalSiteOutstanding(BigDecimal totalSiteOutstanding) {
		this.totalSiteOutstanding = totalSiteOutstanding;
	}
	public String getTermOfPayment() {
		return termOfPayment;
	}
	public void setTermOfPayment(String termOfPayment) {
		this.termOfPayment = termOfPayment;
	}
	public String getFromTermOfPaymentDtMonth() {
		return fromTermOfPaymentDtMonth;
	}
	public void setFromTermOfPaymentDtMonth(String fromTermOfPaymentDtMonth) {
		this.fromTermOfPaymentDtMonth = fromTermOfPaymentDtMonth;
	}
	public String getFromTermOfPaymentDtYear() {
		return fromTermOfPaymentDtYear;
	}
	public void setFromTermOfPaymentDtYear(String fromTermOfPaymentDtYear) {
		this.fromTermOfPaymentDtYear = fromTermOfPaymentDtYear;
	}
	public String getToTermOfPaymentDtMonth() {
		return toTermOfPaymentDtMonth;
	}
	public void setToTermOfPaymentDtMonth(String toTermOfPaymentDtMonth) {
		this.toTermOfPaymentDtMonth = toTermOfPaymentDtMonth;
	}
	public String getToTermOfPaymentDtYear() {
		return toTermOfPaymentDtYear;
	}
	public void setToTermOfPaymentDtYear(String toTermOfPaymentDtYear) {
		this.toTermOfPaymentDtYear = toTermOfPaymentDtYear;
	}
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}


	public Date getFromTermOfPaymentDt() {
		return fromTermOfPaymentDt;
	}
	public void setFromTermOfPaymentDt(Date fromTermOfPaymentDt) {
		this.fromTermOfPaymentDt = fromTermOfPaymentDt;
	}
	public Date getToTermOfPaymentDt() {
		return toTermOfPaymentDt;
	}
	public void setToTermOfPaymentDt(Date toTermOfPaymentDt) {
		this.toTermOfPaymentDt = toTermOfPaymentDt;
	}

	
	
	
	
	
}
