package th.co.ais.domain.el;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ElSOGetVendorId extends AbstractDomain implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7372283170924290326L;
	/**
	 * 
	 */
	private String keyElectrictId;
	private String valVendorId;
	private String stringElectrictId;
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
	public String getKeyElectrictId() {
		return keyElectrictId;
	}
	public void setKeyElectrictId(String keyElectrictId) {
		this.keyElectrictId = keyElectrictId;
	}
	public String getValVendorId() {
		return valVendorId;
	}
	public void setValVendorId(String valVendorId) {
		this.valVendorId = valVendorId;
	}
	public String getStringElectrictId() {
		return stringElectrictId;
	}
	public void setStringElectrictId(String stringElectrictId) {
		this.stringElectrictId = stringElectrictId;
	}
	
	/**
	 * 
	 */

}
