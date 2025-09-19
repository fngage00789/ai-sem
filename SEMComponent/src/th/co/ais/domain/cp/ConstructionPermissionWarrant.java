package th.co.ais.domain.cp;

import java.math.BigDecimal;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class ConstructionPermissionWarrant extends AbstractDomain{

	private static final long serialVersionUID = -7397386665680139424L;
	
	private BigDecimal itemNo;
	private String company;
	private String contractNo;
	private String loactionId;
	private String areaName;
	private String supplierId;
	private String supplierName;
	private String antennaType;
	private String antennaHight;
	private String department;
	private Date supplierRequestWarrantDt;
	private Date stampWarrantDt;
	private String warrantNo;
	private String warrantStatus;
	
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getLoactionId() {
		return loactionId;
	}
	public void setLoactionId(String loactionId) {
		this.loactionId = loactionId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getAntennaType() {
		return antennaType;
	}
	public void setAntennaType(String antennaType) {
		this.antennaType = antennaType;
	}
	public String getAntennaHight() {
		return antennaHight;
	}
	public void setAntennaHight(String antennaHight) {
		this.antennaHight = antennaHight;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getSupplierRequestWarrantDt() {
		return supplierRequestWarrantDt;
	}
	public void setSupplierRequestWarrantDt(Date supplierRequestWarrantDt) {
		this.supplierRequestWarrantDt = supplierRequestWarrantDt;
	}
	public Date getStampWarrantDt() {
		return stampWarrantDt;
	}
	public void setStampWarrantDt(Date stampWarrantDt) {
		this.stampWarrantDt = stampWarrantDt;
	}
	public String getWarrantNo() {
		return warrantNo;
	}
	public void setWarrantNo(String warrantNo) {
		this.warrantNo = warrantNo;
	}
	public String getWarrantStatus() {
		return warrantStatus;
	}
	public void setWarrantStatus(String warrantStatus) {
		this.warrantStatus = warrantStatus;
	}
	public BigDecimal getItemNo() {
		return itemNo;
	}
	public void setItemNo(BigDecimal itemNo) {
		this.itemNo = itemNo;
	}
	
	
}
