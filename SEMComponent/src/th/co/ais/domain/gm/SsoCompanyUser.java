package th.co.ais.domain.gm;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SSO_COMPANY_USER", schema="SEM")
public class SsoCompanyUser implements Serializable{
	
	private static final long serialVersionUID = -3452065263549033757L;
	private SsoCompanyUserId id;
	private String userGroupDesc;
	private String subModule;
	
	public SsoCompanyUser() {
	}

	public SsoCompanyUser(SsoCompanyUserId id) {
		this.id = id;
	}

	public SsoCompanyUser(SsoCompanyUserId id, String userGroupDesc, String subModule) {
		this.id = id;
		this.userGroupDesc = userGroupDesc;
		this.subModule = subModule;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "companyCode", column = @Column(name = "COMPANY_CODE", nullable = false, length = 10)),
			@AttributeOverride(name = "userGroup", column = @Column(name = "USER_GROUP", nullable = false, length = 100)) })
	public SsoCompanyUserId getId() {
		return this.id;
	}

	public void setId(SsoCompanyUserId id) {
		this.id = id;
	}
	
	@Column(name = "USER_GROUP_DESC", length = 500)
	public String getUserGroupDesc() {
		return userGroupDesc;
	}
	public void setUserGroupDesc(String userGroupDesc) {
		this.userGroupDesc = userGroupDesc;
	}
	
	@Column(name = "SUB_MODULE", length = 10)
	public String getSubModule() {
		return subModule;
	}
	public void setSubModule(String subModule) {
		this.subModule = subModule;
	}

}
