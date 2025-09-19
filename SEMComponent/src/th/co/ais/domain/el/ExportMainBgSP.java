package th.co.ais.domain.el;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@org.hibernate.annotations.NamedNativeQuery(
	    name="queryExportMainBgSP",
	    query="call SEM.SEM_SP_EL_EXP_MAIN_BG(?, :bgMasterId)",
	    callable = true, readOnly = true,
	    resultClass=ExportMainBgSP.class
	)  
	
@Entity
public class ExportMainBgSP implements Serializable{

	private static final long serialVersionUID = -5273532339016530344L;

	@Id
	@Column(name = "BG_MASTER_ID")	
	private String rowId;
	@Column(name = "E_AREA_NAME")
	private String eAreaName;
	@Column(name = "E_AREA_CODE")
	private String eAreaCode;
	@Column(name = "METER_ID")
	private String meterId;
	@Column(name = "SITE_ADDRESS")
	private String siteAddress;
	@Column(name = "SITE_AMPHUR")
	private String siteAmphur;
	@Column(name = "SITE_TUMBON")
	private String siteTumbon;
	@Column(name = "PROVINCE")
	private String province;
	@Column(name = "E_TRANSFORMER_SIZE")
	private String eTransformerSize;
	@Column(name = "E_METER_SIZE")
	private String eMeterSize;
	@Column(name = "E_METER_WIRE")
	private String eMeterWire;
	@Column(name = "AMT")
	private String amt;
	@Column(name = "CONTRACT_NO")
	private String contractNo;
	@Column(name = "SITE_NAME")
	private String siteName;
	@Column(name = "LOCATION_ID")
	private String locationId;
	@Column(name = "LOCATION_CODE")
	private String locationCode;
	
	public String geteAreaName() {
		return eAreaName;
	}
	public void seteAreaName(String eAreaName) {
		this.eAreaName = eAreaName;
	}
	public String geteAreaCode() {
		return eAreaCode;
	}
	public void seteAreaCode(String eAreaCode) {
		this.eAreaCode = eAreaCode;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getSiteAddress() {
		return siteAddress;
	}
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}
	public String getSiteAmphur() {
		return siteAmphur;
	}
	public void setSiteAmphur(String siteAmphur) {
		this.siteAmphur = siteAmphur;
	}
	public String getSiteTumbon() {
		return siteTumbon;
	}
	public void setSiteTumbon(String siteTumbon) {
		this.siteTumbon = siteTumbon;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String geteTransformerSize() {
		return eTransformerSize;
	}
	public void seteTransformerSize(String eTransformerSize) {
		this.eTransformerSize = eTransformerSize;
	}
	public String geteMeterSize() {
		return eMeterSize;
	}
	public void seteMeterSize(String eMeterSize) {
		this.eMeterSize = eMeterSize;
	}
	public String geteMeterWire() {
		return eMeterWire;
	}
	public void seteMeterWire(String eMeterWire) {
		this.eMeterWire = eMeterWire;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
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
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
}
