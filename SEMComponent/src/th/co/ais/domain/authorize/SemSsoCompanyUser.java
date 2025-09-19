package th.co.ais.domain.authorize;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SEM_SSO_COMPANY_USER", schema="SEM")
public class SemSsoCompanyUser implements Serializable{
	
	private String companyCode;
	private String userGroup;
	private String userGroupDesc;
	private String subModule;
	
	@Id
	@Column(name = "COMPANY_CODE", unique = true, nullable = false, length = 10)
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Column(name = "USER_GROUP", unique = true, nullable = false, length = 100)
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
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
