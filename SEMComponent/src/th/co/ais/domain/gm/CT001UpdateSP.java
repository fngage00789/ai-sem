package th.co.ais.domain.gm;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@org.hibernate.annotations.NamedNativeQuery(
		name="mct001Update",
		query="call SEM.SEM_SP_MCT001_SAVE(?, :vendorMasterId, :vendorMapPayeeId, :userId, :lessorId)",
		callable = true, 
		//readOnly = true,
		resultClass=CT001UpdateSP.class
) 

@Entity
public class CT001UpdateSP implements Serializable {

	private static final long serialVersionUID = 9010447918236542857L;
	
	private String status;
	private String remark;
	private String vendorMasterId;
	private String vendorMapPayeeId;
	private String userId;
	private String lessorId;
	
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
	public String getVendorMapPayeeId() {
		return vendorMapPayeeId;
	}
	public void setVendorMapPayeeId(String vendorMapPayeeId) {
		this.vendorMapPayeeId = vendorMapPayeeId;
	}
	@Transient
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Transient
	public String getLessorId() {
		return lessorId;
	}
	public void setLessorId(String lessorId) {
		this.lessorId = lessorId;
	}
	@Transient
	public String getVendorMasterId() {
		return vendorMasterId;
	}
	public void setVendorMasterId(String vendorMasterId) {
		this.vendorMasterId = vendorMasterId;
	}
	@Override
	public String toString() {
		return "CT001UpdateSP [lessorId=" + lessorId + ", remark=" + remark
				+ ", status=" + status + ", userId=" + userId
				+ ", vendorMapPayeeId=" + vendorMapPayeeId
				+ ", vendorMasterId=" + vendorMasterId + "]";
	}
	
	

}