package th.co.ais.domain.gm;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
//@Table(name="LU_ZONE", schema="SLIMS")
@Table(name="VW_LU_ZONE", schema="SLIMS2")
//@Table(name="SLIMS2_VW_LU_ZONE", schema="SEM")
public class Zone implements Serializable{

	private static final long serialVersionUID = 835488532621580387L;
	
	// Fields
	private String zone;
	private String description;
	private String region;
	private String recordComment;
	
	private boolean selected;

	private String[] arrRegion;

	// Property accessors
	@Id
	@Column(name = "ZONE", unique = true, nullable = false, length = 10)
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	@Column(name = "DESCRIPTION", length = 50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "REGION", length = 10)
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "RECORD_COMMENT", length = 250)
	public String getRecordComment() {
		return recordComment;
	}

	public void setRecordComment(String recordComment) {
		this.recordComment = recordComment;
	}
	
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

}