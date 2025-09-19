package th.co.ais.domain.gm;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import th.co.ais.domain.AbstractDomain;

@Entity
@Table(name="SEM_CT_MESSAGE", schema="SEM")
public  class Message extends AbstractDomain {

	private static final long serialVersionUID = 8030793137267443856L;
	private String messageCode;
	private String messageDesc;
	private Date createDt;
	private String createBy;
	private Date updateDt;
	private String updateBy;


	// Property accessors
	@Id
	@Column(name = "MESSAGE_CODE", unique = true, nullable = false, length = 10)
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	@Column(name = "MESSAGE_DESC", length = 500)
	public String getMessageDesc() {
		return messageDesc;
	}

	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}
	
	@Override
	@Column(name = "CREATE_DT")
	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
	@Override
	@Column(name = "CREATE_BY", length = 50)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	@Override
	@Column(name = "UPDATE_DT")
	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@Override
	@Column(name = "UPDATE_BY", length = 50)
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

}