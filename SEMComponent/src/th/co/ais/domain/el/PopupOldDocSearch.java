package th.co.ais.domain.el;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@org.hibernate.annotations.NamedNativeQuery(
    name="querySearchELOldDoc",  
    query="call SEM.SEM_SP_EL006_SRCH_OLD_DOC(?,:docNo, :fromDocDt,:toDocDt)",   
    callable = true, readOnly = true,
    resultClass=PopupOldDocSearch.class 
)  


@Entity 
public class PopupOldDocSearch implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	
	@Id
	@Column(name = "DOC_NO")	
	private String docNo;
	
	@Column(name = "DOC_DT")
	private Date docDt;

	
	@Column(name = "DOC_TYPE")
	private String docType;
	
	@Transient
	private String 	docTypeDisplay;
	
	@Transient
	private String docDtTH;
	
	@Transient
	private Date fromDocDt;
	
	@Transient
	private Date toDocDt;

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public Date getDocDt() {
		return docDt;
	}

	public void setDocDt(Date docDt) {
		this.docDt = docDt;
	}

	public Date getFromDocDt() {
		return fromDocDt;
	}

	public void setFromDocDt(Date fromDocDt) {
		this.fromDocDt = fromDocDt;
	}

	public Date getToDocDt() {
		return toDocDt;
	}

	public void setToDocDt(Date toDocDt) {
		this.toDocDt = toDocDt;
	}

	public String getDocDtTH() {
		return docDt!=null?exportFormat.format(docDt):"";
	}



	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getDocTypeDisplay() {
		return docTypeDisplay;
	}

	public void setDocTypeDisplay(String docTypeDisplay) {
		this.docTypeDisplay = docTypeDisplay;
	}

	
	
	
}
