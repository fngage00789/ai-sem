package th.co.ais.domain.si;

import java.io.Serializable;
import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class RentHistorySP extends AbstractDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8187303275010628999L;
	/**
	 * 
	 */
	
	
	private String contractNo;
	private Date effDt;
	private Date expDt;
	private Double rentalAmt;
	private Double serviceAmt;
	private Double total;
	private String percent;
	private Double percentTotal;
	
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

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public Date getEffDt() {
		return effDt;
	}

	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}

	public Date getExpDt() {
		return expDt;
	}

	public void setExpDt(Date expDt) {
		this.expDt = expDt;
	}

	public Double getRentalAmt() {
		return rentalAmt;
	}

	public void setRentalAmt(Double rentalAmt) {
		this.rentalAmt = rentalAmt;
	}

	public Double getServiceAmt() {
		return serviceAmt;
	}

	public void setServiceAmt(Double serviceAmt) {
		this.serviceAmt = serviceAmt;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getPercentTotal() {
		return percentTotal;
	}

	public void setPercentTotal(Double percentTotal) {
		this.percentTotal = percentTotal;
	}
	
	
	
	
}
