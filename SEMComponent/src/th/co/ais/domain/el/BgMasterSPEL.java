package th.co.ais.domain.el;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@org.hibernate.annotations.NamedNativeQuery(
    name="queryBgMasterSP",
    query="call SEM.SEM_SP_EL_GET_MAIN_BG_CONTRACT(?, :bgMasterId)",
    callable = true, readOnly = true,
    resultClass=BgMasterSPEL.class
)  
	
@Entity
public class BgMasterSPEL implements Serializable{

	private static final long serialVersionUID = -6143054336106745040L;
	
	@Id
	@Column(name = "BG_MASTER_ID")	
	private String bgMasterId;
	@Column(name = "CONTRACT_NO")	
	private String contractNo;
	@Column(name = "SITE_NAME")
	private String siteName;
	@Column(name = "METER_ID")
	private String meterId;
	@Column(name = "E_AREA_CODE")
	private String eAreaCode;
	@Column(name = "E_AREA_NAME")
	private String eAreaName;
	
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
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String geteAreaCode() {
		return eAreaCode;
	}
	public void seteAreaCode(String eAreaCode) {
		this.eAreaCode = eAreaCode;
	}
	public String geteAreaName() {
		return eAreaName;
	}
	public void seteAreaName(String eAreaName) {
		this.eAreaName = eAreaName;
	}
	public String getBgMasterId() {
		return bgMasterId;
	}
	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}
	
}
