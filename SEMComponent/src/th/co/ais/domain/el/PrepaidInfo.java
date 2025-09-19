package th.co.ais.domain.el;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@org.hibernate.annotations.NamedNativeQuery(
		name = "queryPrepaidInfo", 
		query = "call SEM_SP_EL006_GET_PREPAID_INFO(?)", 
		callable = true, 
		readOnly = true, 
		resultClass = PrepaidInfo.class)

@Entity
public class PrepaidInfo implements Serializable {

	private static final long serialVersionUID = -748599263289088321L;

	@Id
	@Column(name = "DIS_CONTRACT_NO")
	private String totalExpenseSite;

	@Column(name = "TOTAL_CONTRACT_NO")
	private String totalExpenseBill;

	public String getTotalExpenseSite() {
		return totalExpenseSite;
	}

	public void setTotalExpenseSite(String totalExpenseSite) {
		this.totalExpenseSite = totalExpenseSite;
	}

	public String getTotalExpenseBill() {
		return totalExpenseBill;
	}

	public void setTotalExpenseBill(String totalExpenseBill) {
		this.totalExpenseBill = totalExpenseBill;
	}

}
