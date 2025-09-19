package th.co.ais.domain.el;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_WARRANT_MASTER", schema="SEM")
public class WarrantMaster extends AbstractDomain {

	private static final long serialVersionUID = 280723181044317825L;
	private String rowId;
	private String company;
	private String electricUseType;
	private String companyName;
	private String signName;
	private BigDecimal signAge;
	private String signAddress;
	private String signCitizenId;
	private String encodeElectric;
	private String expireDt;
	private String recordStatus;
	private String receivedNo;
	
	@Id
   	@GeneratedValue(generator="system-uuid")
   	@GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="WARRANT_MASTER_ID")		
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	
	@Column(name="COMPANY")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name="ELECTRIC_USE_TYPE")
	public String getElectricUseType() {
		return electricUseType;
	}
	public void setElectricUseType(String electricUseType) {
		this.electricUseType = electricUseType;
	}
	
	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="SIGN_NAME")
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	
	@Column(name="SIGN_AGE")
	public BigDecimal getSignAge() {
		return signAge;
	}
	public void setSignAge(BigDecimal signAge) {
		this.signAge = signAge;
	}
	
	@Column(name="SIGN_ADDRESS")
	public String getSignAddress() {
		return signAddress;
	}
	public void setSignAddress(String signAddress) {
		this.signAddress = signAddress;
	}
	
	@Column(name="SIGN_CITIZEN_ID")
	public String getSignCitizenId() {
		return signCitizenId;
	}
	public void setSignCitizenId(String signCitizenId) {
		this.signCitizenId = signCitizenId;
	}
	
	@Column(name="ENCODE_ELECTRIC")
	public String getEncodeElectric() {
		return encodeElectric;
	}
	public void setEncodeElectric(String encodeElectric) {
		this.encodeElectric = encodeElectric;
	}
	
	@Column(name="EXPIRE_DT")
	public String getExpireDt() {
		return expireDt;
	}
	public void setExpireDt(String expireDt) {
		this.expireDt = expireDt;
	}
	
	@Column(name="RECORD_STATUS")
	public String getRecordStatus() {
		return recordStatus;
	}	
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	@Column(name="RECEIVED_NO")
	public String getReceivedNo() {
		return receivedNo;
	}
	public void setReceivedNo(String receivedNo) {
		this.receivedNo = receivedNo;
	}
	
	@Override
	@Column(name="CREATE_BY")
	public String getCreateBy() {
		return this.createBy;
	}
	@Override
	@Column(name="CREATE_DT")
	public Date getCreateDt() {
		return this.createDt;
	}

	@Override
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return this.updateBy;
	}

	@Override
	@Column(name="UPDATE_DT")
	public Date getUpdateDt() {
		return this.updateDt;
	}
	
	@Override
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
		
	}

	@Override
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;		
	}

	@Override
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy; 
		
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
		
	}
	
}
