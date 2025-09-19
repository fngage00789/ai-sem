package th.co.ais.domain.rt;

import java.util.Date;

import javax.persistence.Transient;

import th.co.ais.domain.AbstractDomain;
import th.co.ais.rpt.util.annotation.PCell;

public class Mrt003Exp extends AbstractDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5490992221382808919L;
	
	private String p_PaymentId;
	private Integer no;
	private String rentalPaymentId;
	private String contractNo;
	private String oldContractNo;
	private String siteName;
	private String reqType;
	private String reqOfficer;
	private String expenseTypeDesc;
	private String chqNo;
	private Date chqDt;
	private String chqDtString;
	private String chqName;
	private String remark;
	private String company;

	@PCell(cellType = String.class ,no = 0, manualStyleName ="rt003Field")
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	@Transient
	public String getRentalPaymentId() {
		return rentalPaymentId;
	}
	public void setRentalPaymentId(String rentalPaymentId) {
		this.rentalPaymentId = rentalPaymentId;
	}
	@PCell(cellType = String.class ,no = 1, manualStyleName ="rt003Field")
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	@PCell(cellType = String.class ,no = 2, manualStyleName ="rt003Field")
	public String getOldContractNo() {
		return oldContractNo;
	}
	public void setOldContractNo(String oldContractNo) {
		this.oldContractNo = oldContractNo;
	}
	@PCell(cellType = String.class ,no = 3, manualStyleName ="rt003Field")
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	@PCell(cellType = String.class ,no = 4, manualStyleName ="rt003Field")
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	@PCell(cellType = String.class ,no = 5, manualStyleName ="rt003Field")
	public String getReqOfficer() {
		return reqOfficer;
	}
	public void setReqOfficer(String reqOfficer) {
		this.reqOfficer = reqOfficer;
	}
	@PCell(cellType = String.class ,no = 6, manualStyleName ="rt003Field")
	public String getExpenseTypeDesc() {
		return expenseTypeDesc;
	}
	public void setExpenseTypeDesc(String expenseTypeDesc) {
		this.expenseTypeDesc = expenseTypeDesc;
	}
	@PCell(cellType = String.class ,no = 7, manualStyleName ="rt003Field")
	public String getChqNo() {
		return chqNo;
	}
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	@PCell(cellType = String.class ,no = 8, manualStyleName ="rt003Field")
	public String getChqDtString() {
		return chqDtString;
	}
	public void setChqDtString(String chqDtString) {
		this.chqDtString = chqDtString;
	}
	@Transient
	public Date getChqDt() {
		return chqDt;
	}
	public void setChqDt(Date chqDt) {
		this.chqDt = chqDt;
	}
	@PCell(cellType = String.class ,no = 9, manualStyleName ="rt003Field")
	public String getChqName() {
		return chqName;
	}
	public void setChqName(String chqName) {
		this.chqName = chqName;
	}
	@PCell(cellType = String.class ,no = 10, manualStyleName ="rt003Field")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getP_PaymentId() {
		return p_PaymentId;
	}
	public void setP_PaymentId(String pPaymentId) {
		p_PaymentId = pPaymentId;
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
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
