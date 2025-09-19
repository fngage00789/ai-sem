package th.co.ais.domain.el;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

public class DepositSearchDetail implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;
	//private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	

	private String electricId;

	private String bgDetail;	
	
	private String elPayment;
    
	private String dataID;
	
	public String getElectricId() {
		return electricId;
	}

	public void setElectricId(String electricId) {
		this.electricId = electricId;
	}

	public String getBgDetail() {
		return bgDetail;
	}

	public void setBgDetail(String bgDetail) {
		this.bgDetail = bgDetail;
	}

	public String getElPayment() {
		return elPayment;
	}

	public void setElPayment(String elPayment) {
		this.elPayment = elPayment;
	}

	public String getDataID() {
		return dataID;
	}

	public void setDataID(String dataID) {
		this.dataID = dataID;
	}	
	
	
}
