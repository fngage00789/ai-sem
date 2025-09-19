package th.co.ais.domain.gm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="VW_LU_AMPHUR", schema="SLIMS2")
//@Table(name="SLIMS2_VW_LU_AMPHUR", schema="SEM")
public class Amphur implements Serializable{
	
	private static final long serialVersionUID = 4951824882055639699L;
	// Fields
	private String rowId;
	private Province province;
	private String thaiName;
	private String engName;
	private String zip;
	private String zone;

	

	// Property accessors
	@Id
	@Column(name = "AMPHUR_ID", unique = true, nullable = false, length = 50)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROVINCE_ID", nullable = false)
	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Column(name = "THAI_NAME", nullable = false, length = 200)
	public String getThaiName() {
		return thaiName;
	}

	public void setThaiName(String thaiName) {
		this.thaiName = thaiName;
	}

	@Column(name = "ENG_NAME", nullable = false, length = 200)
	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	@Column(name = "ZIP", length = 10)
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "ZONE", length = 10)
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	

}