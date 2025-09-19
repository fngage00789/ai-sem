package th.co.ais.domain.gm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@org.hibernate.annotations.NamedNativeQuery(
		name="mct001ActApprove",
//		query="call SEM.SEM_SP_MCT001_ACT(?, :vendorMapPayeeIds, :userId)",
		query="call SEM.SEM_SP_MCT001_PM_ACT(?, :vendorMapPayeeIds, :userId)",
		callable = true, 
		//readOnly = true,
		resultClass=SPStatus.class
) 

@Entity
public class SPStatus implements Serializable {

	private static final long serialVersionUID = 9010447918236542857L;
	
	private String status;
	private String remark;
	private String vendorMapPayeeIds;
	private String userId;
	
	@Id
	@Column(name = "P_RESULT")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "P_REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Transient
	public String getVendorMapPayeeIds() {
		return vendorMapPayeeIds;
	}
	public void setVendorMapPayeeIds(String vendorMapPayeeIds) {
		this.vendorMapPayeeIds = vendorMapPayeeIds;
	}
	@Transient
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}