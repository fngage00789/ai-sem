package th.co.ais.domain.el;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQuery;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_EL_BG_MAP_CONTRACT", schema="SEM")
@Filter(name="validRecord", condition="RECORD_STATUS = 'Y'")

//@NamedQuery(name="BgMapContract.recordStatus", query="select n from SEM_EL_BG_MAP_CONTRACT n where n.RECORD_STATUS = 'Y'")

public class BgMapContract extends AbstractDomain {

	private static final long serialVersionUID = 4613071878180287297L;
	
	private String rowId;
	private BgMaster bgMasterId;
	private String contractNo;
	private Management electricId;
	private String recordStatus;

	@Id
  	@GeneratedValue(generator="system-uuid")
  	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="BG_MAP_CONTRACT_ID")
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}	
	
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name = "BG_MASTER_ID")
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "electricId")
	public BgMaster getBgMasterId() {
		return bgMasterId;
	}
	public void setBgMasterId(BgMaster bgMasterId) {
		this.bgMasterId = bgMasterId;
	}
	
	@Column(name="CONTRACT_NO")
	public String getContractNo() {
		return contractNo;
	}	
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTRIC_ID", nullable = false)
	public Management getElectricId() {
		return electricId;
	}
	
	public void setElectricId(Management electricId) {
		this.electricId = electricId;
	}
	
	@Column(name="RECORD_STATUS")
	
	public String getRecordStatus() {
		return recordStatus;
	}
	
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
}
