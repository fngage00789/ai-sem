package th.co.ais.domain.gm;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
//@Table(name="LU_REGION", schema="SLIMS")
//@Table(name="VW_LU_REGION", schema="SLIMS2")
@Table(name="SEM_V_REGION", schema="SEM")//View
public class Region implements Serializable{

	private static final long serialVersionUID = 5374452051581526385L;
	// Fields
	private String rowId;
	private String thaiDescription;
	private String engDescription;

	private boolean selected = false;
	
	@Transient
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	// Property accessors
	@Id
	@Column(name = "REGION", unique = true, nullable = false, length = 10)
	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "THAI_DESCRIPTION", length = 250)
	public String getThaiDescription() {
		return thaiDescription;
	}

	public void setThaiDescription(String thaiDescription) {
		this.thaiDescription = thaiDescription;
	}

	@Column(name = "ENG_DESCRIPTION", length = 250)
	public String getEngDescription() {
		return engDescription;
	}

	public void setEngDescription(String engDescription) {
		this.engDescription = engDescription;
	}

	

}