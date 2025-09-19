package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElGetContractSP extends AbstractDomain {

	private String contractNo;
	private String importTranId;
	private Date effectiveDt;
	private Date expireDt;
	private String siteStatus;
	private String networkStatus;
	private String siteStatusDesc;
	private String networkStatusDesc;
	private String meterStatus;
	
	
	public String getImportTranId() {
		return importTranId;
	}

	public void setImportTranId(String importTranId) {
		this.importTranId = importTranId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getEffectiveDt() {
		return effectiveDt;
	}

	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}

	public Date getExpireDt() {
		return expireDt;
	}

	public void setExpireDt(Date expireDt) {
		this.expireDt = expireDt;
	}

	public String getSiteStatus() {
		return siteStatus;
	}

	public void setSiteStatus(String siteStatus) {
		this.siteStatus = siteStatus;
	}

	public String getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(String networkStatus) {
		this.networkStatus = networkStatus;
	}

	public String getSiteStatusDesc() {
		return siteStatusDesc;
	}

	public void setSiteStatusDesc(String siteStatusDesc) {
		this.siteStatusDesc = siteStatusDesc;
	}

	public String getNetworkStatusDesc() {
		return networkStatusDesc;
	}

	public void setNetworkStatusDesc(String networkStatusDesc) {
		this.networkStatusDesc = networkStatusDesc;
	}

	public String getMeterStatus() {
		return meterStatus;
	}

	public void setMeterStatus(String meterStatus) {
		this.meterStatus = meterStatus;
	}

	@Override
	public String getCreateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getCreateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getUpdateDt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreateBy(String createBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreateDt(Date createDt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateBy(String updateBy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setUpdateDt(Date updateDt) {
		// TODO Auto-generated method stub

	}

}
