package th.co.ais.domain.mm;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Mmm001ChangeVendorHistory extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2454172654824607984L;
	
	private Date changeVendorDt;
	private String changeType;
	private String vendorOld;
	private String vendor;
	private Date effectiveDt;
    private Date expireDt;
    private Date updateDt;

    
    
	public Date getChangeVendorDt() {
		return changeVendorDt;
	}

	public void setChangeVendorDt(Date changeVendorDt) {
		this.changeVendorDt = changeVendorDt;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getVendorOld() {
		return vendorOld;
	}

	public void setVendorOld(String vendorOld) {
		this.vendorOld = vendorOld;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
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
