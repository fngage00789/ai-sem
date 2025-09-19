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


@org.hibernate.annotations.NamedNativeQuery(
    name="queryElectricFTRateSearch",  
    query="call SEM_PG_EL_SITE_INFO_PROCESS_SP_FT_RATE_SRCH(?,:fromTermOfPayment,:toTermOfPayment)",   
    callable = true, readOnly = true,
    resultClass=ElectricFTRateSearch.class 
)  


@Entity 
public class ElectricFTRateSearch implements Serializable{
	private static final long serialVersionUID = 1137928449676053552L;	
	private static final SimpleDateFormat exportFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
	
	
	/*  In parameter
	

	 */
	
	@Id
	@Column(name = "SERVICE_RATE_ID")	
	private String serviceRateID;
	
	@Column(name = "STRAT_EFFECTIVE_DT")	
	private Date startEffectiveDt
	;
	
	@Column(name = "END_EFFECTIVE_DT")	
	private Date endEffectiveDt
	;
	
	@Column(name = "EL_FT_TYPE")	
	private String ftRateType;
	
	@Column(name = "RECOTD_STATUS")	
	private String recordStatus;
	
	@Column(name = "SEQ_NO")	
	private int seqNo;
	
	//private String txtStartTH;
	//private String txtEndTH;
	
	public String getServiceRateID() {
		return serviceRateID;
	}

	public void setServiceRateID(String serviceRateID) {
		this.serviceRateID = serviceRateID;
	}

	public Date getStartEffectiveDt() {
		return startEffectiveDt;
	}

	public void setStartEffectiveDt(Date startEffectiveDt) {
		this.startEffectiveDt = startEffectiveDt;
	}

	public Date getEndEffectiveDt() {
		return endEffectiveDt;
	}

	public void setEndEffectiveDt(Date endEffectiveDt) {
		this.endEffectiveDt = endEffectiveDt;
	}

	public String getFtRateType() {
		return ftRateType;
	}

	public void setFtRateType(String ftRateType) {
		this.ftRateType = ftRateType;
	}

	

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
	@Transient
	public String getTxtStartTH(){
		String dtStrReturn = (null != startEffectiveDt) ? exportFormat.format(startEffectiveDt) : "";
		
		return dtStrReturn;
	}
	
	@Transient
	public String getTxtEndTH(){
		String dtStrReturn = (null != endEffectiveDt) ? exportFormat.format(endEffectiveDt) : "";
		
		return dtStrReturn;
	}

	
	

	
	
	
	
}
