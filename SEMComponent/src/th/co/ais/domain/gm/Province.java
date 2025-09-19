package th.co.ais.domain.gm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="VW_LU_PROVINCE", schema="SLIMS2")  /* Mayuree.T comments For Test 12/07/2022 */
//@Table(name="SLIMS2_VW_LU_PROVINCE", schema="SEM")
public class Province implements Serializable {

	private static final long serialVersionUID = -7211066450330042925L;
	
	// Fields
	private String rowId;
	private String provinceCode;
	private String thaiName;
	private String engName;
	private String areaCode;
	private String region;
	private String samRegion;
	private String zone;
	private String lacCode;
	private Set<Amphur> Amphurs = new HashSet<Amphur>(0);
	private String[] arrRegion;

	private boolean selected = false;
	
	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Transient
	public String[] getArrRegion() {
		return arrRegion;
	}

	public void setArrRegion(String[] arrRegion) {
		this.arrRegion = arrRegion;
	}

	// Property accessors
	@Id
	@Column(name = "PROVINCE_ID", unique = true, nullable = false, length = 10)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PROVINCE_CODE", nullable = false, length = 10)
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
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

	@Column(name = "AREA_CODE", length = 10)
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	@Column(name = "REGION", nullable = false, length = 10)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "SAM_REGION", length = 10)
	public String getSamRegion() {
		return samRegion;
	}

	public void setSamRegion(String samRegion) {
		this.samRegion = samRegion;
	}

	@Column(name = "ZONE", length = 10)
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name = "LAC_CODE", length = 2)
	public String getLacCode() {
		return lacCode;
	}

	public void setLacCode(String lacCode) {
		this.lacCode = lacCode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "province")
	public Set<Amphur> getAmphurs() {
		return Amphurs;
	}

	public void setAmphurs(Set<Amphur> Amphurs) {
		this.Amphurs = Amphurs;
	}

}