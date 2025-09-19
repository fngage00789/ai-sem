package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class Msi001GenDocNo extends AbstractDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2968955798271617896L;
	private String genDocNo;
	private String result;
	private String message;
	private String reqType;
	private String reqDocType;
	private String company;
	private String locationId;
	private String contractNo;
	
	public String getGenDocNo() {
		return genDocNo;
	}

	public void setGenDocNo(String genDocNo) {
		this.genDocNo = genDocNo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getReqDocType() {
		return reqDocType;
	}

	public void setReqDocType(String reqDocType) {
		this.reqDocType = reqDocType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
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
