package th.co.ais.domain.rt;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class EMAILModel extends AbstractDomain {
	private String row_ID = ""; 
	private String email_from = "";
	private String email_to = "";
	private String v_Subject = "";
	private String v_Message = "";
	private String v_Footer = "";
	private String v_type = "";
	private String userId;
	//added by NEW 20160407
	private String batchFlag = "";
	
	public String getRow_ID() {
		return row_ID;
	}
	public void setRow_ID(String rowID) {
		row_ID = rowID;
	}
	public String getEmail_from() {
		return email_from;
	}
	public void setEmail_from(String emailFrom) {
		email_from = emailFrom;
	}
	public String getEmail_to() {
		return email_to;
	}
	public void setEmail_to(String emailTo) {
		email_to = emailTo;
	}
	public String getV_Subject() {
		return v_Subject;
	}
	public void setV_Subject(String vSubject) {
		v_Subject = vSubject;
	}
	public String getV_Message() {
		return v_Message;
	}
	public void setV_Message(String vMessage) {
		v_Message = vMessage;
	}
	public String getV_Footer() {
		return v_Footer;
	}
	public void setV_Footer(String vFooter) {
		v_Footer = vFooter;
	}
	
	public String getV_type() {
		return v_type;
	}
	public void setV_type(String vType) {
		v_type = vType;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getBatchFlag() {
		return batchFlag;
	}
	public void setBatchFlag(String batchFlag) {
		this.batchFlag = batchFlag;
	}
	
	
}
