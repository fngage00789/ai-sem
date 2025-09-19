package th.co.ais.domain.co;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mco003ChkContractSP  extends AbstractDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -659367631718941946L;
	private String contractNo;
	private String docNo;
	private String lMessage;
	private String companyCode;
	private String lDesc;
	private String lResult;
	
	//added by NEW 2015/07/10 param For Check process in PL
	private String chkFlag;
	private String siteInfoId;
	
	//added by NEW 2018/12/24 
	private String siteName;
	private String location;
	
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

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getlMessage() {
		return lMessage;
	}

	public void setlMessage(String lMessage) {
		this.lMessage = lMessage;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getlDesc() {
		return lDesc;
	}

	public void setlDesc(String lDesc) {
		this.lDesc = lDesc;
	}

	public String getlResult() {
		return lResult;
	}

	public void setlResult(String lResult) {
		this.lResult = lResult;
	}

	public String getChkFlag() {
		return chkFlag;
	}

	public void setChkFlag(String chkFlag) {
		this.chkFlag = chkFlag;
	}

	public String getSiteInfoId() {
		return siteInfoId;
	}

	public void setSiteInfoId(String siteInfoId) {
		this.siteInfoId = siteInfoId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
