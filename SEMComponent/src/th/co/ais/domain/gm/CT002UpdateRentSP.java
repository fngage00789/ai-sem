package th.co.ais.domain.gm;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@org.hibernate.annotations.NamedNativeQuery(
		name="mct002UpdateRent",
		query="call SEM.SEM_SP_MCT002_UPDATE_RENT( ?, :siteInfoId, :rentalMasterId, :depositDetailId, :bgMasterId, :expenseType, :bgStatus, :reNewBgNo, :bgStartDt, :bgEndDt, :userId )",
		callable = true, 
		//readOnly = true,
		resultClass=CT002UpdateRentSP.class
) 

@Entity
public class CT002UpdateRentSP implements Serializable {

	private static final long serialVersionUID = 9010447918236542857L;
	
	private String status;
	private String remark;
	private String siteInfoId;
	private String rentalMasterId;
	private String depositDetailId;
	private String bgMasterId;
	private String expenseType;
	private String bgStatus;
	private String reNewBgNo;
	private Date bgStartDt;
	private Date bgEndDt;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Transient
	public String getSiteInfoId() {
		return siteInfoId;
	}
	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}
	@Transient
	public String getRentalMasterId() {
		return rentalMasterId;
	}
	public void setRentalMasterId(String rentalMasterId) {
		this.rentalMasterId = rentalMasterId;
	}
	@Transient
	public String getDepositDetailId() {
		return depositDetailId;
	}
	public void setDepositDetailId(String depositDetailId) {
		this.depositDetailId = depositDetailId;
	}
	@Transient
	public String getBgMasterId() {
		return bgMasterId;
	}
	public void setBgMasterId(String bgMasterId) {
		this.bgMasterId = bgMasterId;
	}
	@Transient
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	@Transient
	public String getBgStatus() {
		return bgStatus;
	}
	public void setBgStatus(String bgStatus) {
		this.bgStatus = bgStatus;
	}
	@Transient
	public String getReNewBgNo() {
		return reNewBgNo;
	}
	public void setReNewBgNo(String reNewBgNo) {
		this.reNewBgNo = reNewBgNo;
	}
	@Transient
	public Date getBgEndDt() {
		return bgEndDt;
	}
	public void setBgEndDt(Date bgEndDt) {
		this.bgEndDt = bgEndDt;
	}
	@Transient
	public Date getBgStartDt() {
		return bgStartDt;
	}
	public void setBgStartDt(Date bgStartDt) {
		this.bgStartDt = bgStartDt;
	}
	@Override
	public String toString() {
		return "CT002UpdateRentSP [bgEndDt=" + bgEndDt + ", bgMasterId="
				+ bgMasterId + ", bgStartDt=" + bgStartDt + ", bgStatus="
				+ bgStatus + ", depositDetailId=" + depositDetailId
				+ ", expenseType=" + expenseType + ", reNewBgNo=" + reNewBgNo
				+ ", remark=" + remark + ", rentalMasterId=" + rentalMasterId
				+ ", siteInfoId=" + siteInfoId + ", status=" + status
				+ ", userId=" + userId + "]";
	}
	
}