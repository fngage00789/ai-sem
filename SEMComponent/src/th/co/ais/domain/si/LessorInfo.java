package th.co.ais.domain.si;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@org.hibernate.annotations.NamedNativeQuery(
		name="queryLessorInfo",
		query="call SEM.SEM_SP_MCT001_SRCH_L(?, :siteLessorId)",
		callable = true, 
		readOnly = true,
		resultClass=LessorInfo.class
) 

@Entity
public class LessorInfo implements Serializable {
	
	private static final long serialVersionUID = -5214243245304167544L;
	
	@Id
	@Column(name = "SITE_LESSOR_ID")
	private String siteLessorId;
	@Column(name = "LESSOR_NAME")
	private String lessorName;
	@Column(name = "ADDRESS1")
    private String address1;
	@Column(name = "ADDRESS2")
    private String address2;
	@Column(name = "CITY")
    private String city;
	@Column(name = "POSTCODE")
    private String postcode;
	@Column(name = "TEL")
    private String tel;
	@Column(name = "FAX")
    private String fax;
    
	public String getSiteLessorId() {
		return siteLessorId;
	}
	public void setSiteLessorId(String siteLessorId) {
		this.siteLessorId = siteLessorId;
	}
	public String getLessorName() {
		return lessorName;
	}
	public void setLessorName(String lessorName) {
		this.lessorName = lessorName;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	

}