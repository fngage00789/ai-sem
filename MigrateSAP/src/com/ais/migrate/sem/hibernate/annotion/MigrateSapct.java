package com.ais.migrate.sem.hibernate.annotion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TEST_MIGRATE_SAPCT", schema="SEM")
public class MigrateSapct implements Serializable {

	private static final long serialVersionUID = 7406072507781805239L;
	
	private Integer no;
	
	private String rectyp;
	private String comcod;
	private String basnam;
	private String conno;
	private Integer subcon;
	
	private String contyp;
	private String locid;
	private String phase;
	private String system;
	private String region;
	
	private String jobtyp;
	private String stadat;
	private String enddat;
	private String vencod;
	private Integer coscen;
	
	private String provin;
	private String altnam;
	private String premon;
	private String terint;
	private Double depamt;
	
	private Double vatdep;
	private Double conamt;
	private Double monamt;
	private Double abswit;
	private Double basamt;
	
	private Double adjamt;
	private String adjrea;
	private String adjdat;
	private Integer witcod1;
	private Integer witbas1;
	
	private Integer witcod2;
	private Integer witbas2;
	private String fstdue;
	private Double rntamt;
	private Double svcamt;
	
	private Double wthrnt;
	private Double wthsvc;
	private Double amtbill;
	private Double amtpai;
	private Double amtout;
	
	private Double prpamt;
	private Double prpout;
	private Integer tembill;
	private Integer tempai;
	private Integer temout;

	private String filename;
	private String createdate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator = "TEST_MIGRATE_SAPCT_SEQ")
	@SequenceGenerator(name="TEST_MIGRATE_SAPCT_SEQ", sequenceName = "TEST_MIGRATE_SAPCT_SEQ")
	@Column(name = "NO", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getNo() {
		return this.no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	@Column(name = "RECTYP", length = 3)
	public String getRectyp() {
		return this.rectyp;
	}

	public void setRectyp(String rectyp) {
		this.rectyp = rectyp;
	}

	@Column(name = "COMCOD", length = 10)
	public String getComcod() {
		return this.comcod;
	}

	public void setComcod(String comcod) {
		this.comcod = comcod;
	}

	@Column(name = "BASNAM", length = 50)
	public String getBasnam() {
		return this.basnam;
	}

	public void setBasnam(String basnam) {
		this.basnam = basnam;
	}

	@Column(name = "CONNO", length = 15)
	public String getConno() {
		return this.conno;
	}

	public void setConno(String conno) {
		this.conno = conno;
	}

	@Column(name = "SUBCON", precision = 22, scale = 0)
	public Integer getSubcon() {
		return this.subcon;
	}

	public void setSubcon(Integer subcon) {
		this.subcon = subcon;
	}

	@Column(name = "CONTYP", length = 2)
	public String getContyp() {
		return this.contyp;
	}

	public void setContyp(String contyp) {
		this.contyp = contyp;
	}

	@Column(name = "LOCID", length = 10)
	public String getLocid() {
		return this.locid;
	}

	public void setLocid(String locid) {
		this.locid = locid;
	}

	@Column(name = "PHASE", length = 10)
	public String getPhase() {
		return this.phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	@Column(name = "SYSTEM", length = 10)
	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(name = "REGION", length = 3)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "JOBTYP", length = 10)
	public String getJobtyp() {
		return this.jobtyp;
	}

	public void setJobtyp(String jobtyp) {
		this.jobtyp = jobtyp;
	}

	@Column(name = "STADAT", length = 8)
	public String getStadat() {
		return this.stadat;
	}

	public void setStadat(String stadat) {
		this.stadat = stadat;
	}

	@Column(name = "ENDDAT", length = 8)
	public String getEnddat() {
		return this.enddat;
	}

	public void setEnddat(String enddat) {
		this.enddat = enddat;
	}

	@Column(name = "VENCOD", length = 10)
	public String getVencod() {
		return this.vencod;
	}

	public void setVencod(String vencod) {
		this.vencod = vencod;
	}

	@Column(name = "COSCEN", precision = 22, scale = 0)
	public Integer getCoscen() {
		return this.coscen;
	}

	public void setCoscen(Integer coscen) {
		this.coscen = coscen;
	}

	@Column(name = "PROVIN", length = 20)
	public String getProvin() {
		return this.provin;
	}

	public void setProvin(String provin) {
		this.provin = provin;
	}

	@Column(name = "ALTNAM", length = 80)
	public String getAltnam() {
		return this.altnam;
	}

	public void setAltnam(String altnam) {
		this.altnam = altnam;
	}

	@Column(name = "PREMON", length = 2)
	public String getPremon() {
		return this.premon;
	}

	public void setPremon(String premon) {
		this.premon = premon;
	}

	@Column(name = "TERINT", length = 2)
	public String getTerint() {
		return this.terint;
	}

	public void setTerint(String terint) {
		this.terint = terint;
	}

	@Column(name = "DEPAMT", precision = 15)
	public Double getDepamt() {
		return this.depamt;
	}

	public void setDepamt(Double depamt) {
		this.depamt = depamt;
	}

	@Column(name = "VATDEP", precision = 15)
	public Double getVatdep() {
		return this.vatdep;
	}

	public void setVatdep(Double vatdep) {
		this.vatdep = vatdep;
	}

	@Column(name = "CONAMT", precision = 15)
	public Double getConamt() {
		return this.conamt;
	}

	public void setConamt(Double conamt) {
		this.conamt = conamt;
	}

	@Column(name = "MONAMT", precision = 15)
	public Double getMonamt() {
		return this.monamt;
	}

	public void setMonamt(Double monamt) {
		this.monamt = monamt;
	}

	@Column(name = "ABSWIT", precision = 15)
	public Double getAbswit() {
		return this.abswit;
	}

	public void setAbswit(Double abswit) {
		this.abswit = abswit;
	}

	@Column(name = "BASAMT", precision = 15)
	public Double getBasamt() {
		return this.basamt;
	}

	public void setBasamt(Double basamt) {
		this.basamt = basamt;
	}

	@Column(name = "ADJAMT", precision = 15)
	public Double getAdjamt() {
		return this.adjamt;
	}

	public void setAdjamt(Double adjamt) {
		this.adjamt = adjamt;
	}

	@Column(name = "ADJREA", length = 30)
	public String getAdjrea() {
		return this.adjrea;
	}

	public void setAdjrea(String adjrea) {
		this.adjrea = adjrea;
	}

	@Column(name = "ADJDAT", length = 8)
	public String getAdjdat() {
		return this.adjdat;
	}

	public void setAdjdat(String adjdat) {
		this.adjdat = adjdat;
	}

	@Column(name = "WITCOD1", precision = 22, scale = 0)
	public Integer getWitcod1() {
		return this.witcod1;
	}

	public void setWitcod1(Integer witcod1) {
		this.witcod1 = witcod1;
	}

	@Column(name = "WITBAS1", precision = 22, scale = 0)
	public Integer getWitbas1() {
		return this.witbas1;
	}

	public void setWitbas1(Integer witbas1) {
		this.witbas1 = witbas1;
	}

	@Column(name = "WITCOD2", precision = 22, scale = 0)
	public Integer getWitcod2() {
		return this.witcod2;
	}

	public void setWitcod2(Integer witcod2) {
		this.witcod2 = witcod2;
	}

	@Column(name = "WITBAS2", precision = 22, scale = 0)
	public Integer getWitbas2() {
		return this.witbas2;
	}

	public void setWitbas2(Integer witbas2) {
		this.witbas2 = witbas2;
	}

	@Column(name = "FSTDUE", length = 8)
	public String getFstdue() {
		return this.fstdue;
	}

	public void setFstdue(String fstdue) {
		this.fstdue = fstdue;
	}

	@Column(name = "RNTAMT", precision = 15)
	public Double getRntamt() {
		return this.rntamt;
	}

	public void setRntamt(Double rntamt) {
		this.rntamt = rntamt;
	}

	@Column(name = "SVCAMT", precision = 15)
	public Double getSvcamt() {
		return this.svcamt;
	}

	public void setSvcamt(Double svcamt) {
		this.svcamt = svcamt;
	}

	@Column(name = "WTHRNT", precision = 15)
	public Double getWthrnt() {
		return this.wthrnt;
	}

	public void setWthrnt(Double wthrnt) {
		this.wthrnt = wthrnt;
	}

	@Column(name = "WTHSVC", precision = 15)
	public Double getWthsvc() {
		return this.wthsvc;
	}

	public void setWthsvc(Double wthsvc) {
		this.wthsvc = wthsvc;
	}

	@Column(name = "AMTBILL", precision = 15)
	public Double getAmtbill() {
		return this.amtbill;
	}

	public void setAmtbill(Double amtbill) {
		this.amtbill = amtbill;
	}

	@Column(name = "AMTPAI", precision = 15)
	public Double getAmtpai() {
		return this.amtpai;
	}

	public void setAmtpai(Double amtpai) {
		this.amtpai = amtpai;
	}

	@Column(name = "AMTOUT", precision = 15)
	public Double getAmtout() {
		return this.amtout;
	}

	public void setAmtout(Double amtout) {
		this.amtout = amtout;
	}

	@Column(name = "PRPAMT", precision = 15)
	public Double getPrpamt() {
		return this.prpamt;
	}

	public void setPrpamt(Double prpamt) {
		this.prpamt = prpamt;
	}

	@Column(name = "PRPOUT", precision = 15)
	public Double getPrpout() {
		return this.prpout;
	}

	public void setPrpout(Double prpout) {
		this.prpout = prpout;
	}

	@Column(name = "TEMBILL", precision = 22, scale = 0)
	public Integer getTembill() {
		return this.tembill;
	}

	public void setTembill(Integer tembill) {
		this.tembill = tembill;
	}

	@Column(name = "TEMPAI", precision = 22, scale = 0)
	public Integer getTempai() {
		return this.tempai;
	}

	public void setTempai(Integer tempai) {
		this.tempai = tempai;
	}

	@Column(name = "TEMOUT", precision = 22, scale = 0)
	public Integer getTemout() {
		return this.temout;
	}

	public void setTemout(Integer temout) {
		this.temout = temout;
	}

	@Column(name = "FILENAME", length = 100)
	 public String getFilename() {
	  return this.filename;
	 }

	 public void setFilename(String filename) {
	  this.filename = filename;
	 }

	 @Column(name = "CREATEDATE", length = 8)
	 public String getCreatedate() {
	  return this.createdate;
	 }

	 public void setCreatedate(String createdate) {
	  this.createdate = createdate;
	 }
}
