package th.co.ais.domain.si;

import java.io.Serializable;


public class SumRentSP implements Serializable {
	
	private static final long serialVersionUID = -9221556407261524724L;
	private String rowId;
	private String siteInfoId;
	private Double rentAddAmt;
	private String rentAddPeriodType;
	private String rentAddPeriodTypeName;
	private Double serviceAddAmt;
	private String serviceAddPeriodType;
	private String serviceAddPeriodTypeName;
	private Double rentAmt;
	private String rentPeriodType;
	private String rentPeriodTypeName;
	private Double serviceAmt;
	private String servicePeriodType;
	private String servicePeriodTypeName;
	private Double rentServiceAmt;
	private String rentServicePeriodType;
	private String rentServicePeriodTypeName;
	private Double ageRentServiceAmt;
	private Double ageRentAmt;
	private Double ageServiceAmt;
	private Double ageDonateAmt; // add 14/03/2023
	
	
	public Double getAgeRentAmt() {
		return ageRentAmt;
	}
	public void setAgeRentAmt(Double ageRentAmt) {
		this.ageRentAmt = ageRentAmt;
	}
	public Double getAgeServiceAmt() {
		return ageServiceAmt;
	}
	public void setAgeServiceAmt(Double ageServiceAmt) {
		this.ageServiceAmt = ageServiceAmt;
	}
	public Double getAgeRentServiceAmt() {
		return ageRentServiceAmt;
	}
	public void setAgeRentServiceAmt(Double ageRentServiceAmt) {
		this.ageRentServiceAmt = ageRentServiceAmt;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	public Double getRentAddAmt() {
		return rentAddAmt;
	}
	public void setRentAddAmt(Double rentAddAmt) {
		this.rentAddAmt = rentAddAmt;
	}
	public String getRentAddPeriodType() {
		return rentAddPeriodType;
	}
	public void setRentAddPeriodType(String rentAddPeriodType) {
		this.rentAddPeriodType = rentAddPeriodType;
	}
	public Double getServiceAddAmt() {
		return serviceAddAmt;
	}
	public void setServiceAddAmt(Double serviceAddAmt) {
		this.serviceAddAmt = serviceAddAmt;
	}
	public String getServiceAddPeriodType() {
		return serviceAddPeriodType;
	}
	public void setServiceAddPeriodType(String serviceAddPeriodType) {
		this.serviceAddPeriodType = serviceAddPeriodType;
	}
	public Double getRentAmt() {
		return rentAmt;
	}
	public void setRentAmt(Double rentAmt) {
		this.rentAmt = rentAmt;
	}
	public String getRentPeriodType() {
		return rentPeriodType;
	}
	public void setRentPeriodType(String rentPeriodType) {
		this.rentPeriodType = rentPeriodType;
	}
	public Double getServiceAmt() {
		return serviceAmt;
	}
	public void setServiceAmt(Double serviceAmt) {
		this.serviceAmt = serviceAmt;
	}
	public String getServicePeriodType() {
		return servicePeriodType;
	}
	public void setServicePeriodType(String servicePeriodType) {
		this.servicePeriodType = servicePeriodType;
	}
	public Double getRentServiceAmt() {
		return rentServiceAmt;
	}
	public void setRentServiceAmt(Double rentServiceAmt) {
		this.rentServiceAmt = rentServiceAmt;
	}
	public String getRentServicePeriodType() {
		return rentServicePeriodType;
	}
	public void setRentServicePeriodType(String rentServicePeriodType) {
		this.rentServicePeriodType = rentServicePeriodType;
	}
	public String getRentAddPeriodTypeName() {
		return rentAddPeriodTypeName;
	}
	public void setRentAddPeriodTypeName(String rentAddPeriodTypeName) {
		this.rentAddPeriodTypeName = rentAddPeriodTypeName;
	}

	public String getServiceAddPeriodTypeName() {
		return serviceAddPeriodTypeName;
	}
	public void setServiceAddPeriodTypeName(String serviceAddPeriodTypeName) {
		this.serviceAddPeriodTypeName = serviceAddPeriodTypeName;
	}
	public String getRentPeriodTypeName() {
		return rentPeriodTypeName;
	}
	public void setRentPeriodTypeName(String rentPeriodTypeName) {
		this.rentPeriodTypeName = rentPeriodTypeName;
	}
	public String getServicePeriodTypeName() {
		return servicePeriodTypeName;
	}
	public void setServicePeriodTypeName(String servicePeriodTypeName) {
		this.servicePeriodTypeName = servicePeriodTypeName;
	}
	public String getRentServicePeriodTypeName() {
		return rentServicePeriodTypeName;
	}
	public void setRentServicePeriodTypeName(String rentServicePeriodTypeName) {
		this.rentServicePeriodTypeName = rentServicePeriodTypeName;
	}

	public Double getAgeDonateAmt() {
		return ageDonateAmt;
	}
	public void setAgeDonateAmt(Double ageDonateAmt) {
		this.ageDonateAmt = ageDonateAmt;
	}
	

}
