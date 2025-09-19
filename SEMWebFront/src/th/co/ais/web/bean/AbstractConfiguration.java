package th.co.ais.web.bean;

import java.io.Serializable;

import org.apache.log4j.Logger;

import th.co.ais.util.EParamCode;
import th.co.ais.web.util.MSGCacheUtil;
import th.co.ais.web.util.config.ParameterConfigUtil;

public abstract class AbstractConfiguration implements Serializable {
	
	private static final long serialVersionUID = -2440870012267667196L;

	private static Logger LOG = Logger.getLogger(AbstractConfiguration.class);
	
	//Default
	public int rowPerPage = getConfigRowPerPage();
	public int rowPerPagePopup = 10;
	public String uploadPath = getConfigPathUploadContract();
	
	//Message 
	public String msgDataNotFound = getConfigMsgDataNotFound();
	public String msgDoDelete = getConfigMsgDoDelete();
	public String msgDoApprove = getConfigMsgDoApprove();
	

	public String getMsgDoConfirmResendFin() {
		return msgDoConfirmResendFin;
	}

	public void setMsgDoConfirmResendFin(String msgDoConfirmResendFin) {
		this.msgDoConfirmResendFin = msgDoConfirmResendFin;
	}

	public String msgDoCancel = getConfigMsgDoCancel();
	public String msgDoConfirmResendFin = getConfigConfirmResendFin();
	
	public static String getConfigByCode(String code) {
		String value= ParameterConfigUtil.getInstance().getConfigByCode(code);
		return value;
	}
	
	public String getMessageByCode(String msgCode) {
		String message= MSGCacheUtil.getInstance().getMessageByCode(msgCode);
		return message;
	}
	
	public static int getConfigRowPerPage(){
		try{
			int rowPerPage = Integer.parseInt(getConfigByCode(EParamCode.P_ROW_PER_PAGE.name));
			//LOG.info("row per page =" + rowPerPage);
			return rowPerPage;
		}catch(Exception e){
			return 10;
		}
	}
	
	public String getConfigPathUploadContract(){
		try{
			return getConfigByCode(EParamCode.P_PATH_UPLOAD_CONTRACT.name);
		}catch(Exception e){
			return "../upload_contract";
		}
	}
	
	public String getConfigMsgDataNotFound() {
		//LOG.info("getMsgDataNotFound");
		return getMessageByCode("M0004");
	}
	
	public String getConfigMsgDoDelete() {
		//LOG.info("getMsgDoDelete");
		return getMessageByCode("Q0002");
	}
	
	public String getConfigMsgDoApprove() {
		//LOG.info("getMsgDoApprove");
		return getMessageByCode("Q0006");
	}
	
	public String getConfigMsgDoCancel() {
		//LOG.info("getConfigMsgDoCancel");
		return getMessageByCode("Q0005");
	}
	
	public String getConfigConfirmResendFin() {
		return getMessageByCode("Q0017");
	}

	public String getMsgDataNotFound() {
		return msgDataNotFound;
	}

	public void setMsgDataNotFound(String msgDataNotFound) {
		this.msgDataNotFound = msgDataNotFound;
	}

	public String getMsgDoDelete() {
		return msgDoDelete;
	}

	public void setMsgDoDelete(String msgDoDelete) {
		this.msgDoDelete = msgDoDelete;
	}

	public String getMsgDoApprove() {
		return msgDoApprove;
	}

	public void setMsgDoApprove(String msgDoApprove) {
		this.msgDoApprove = msgDoApprove;
	}

	public String getMsgDoCancel() {
		return msgDoCancel;
	}

	public void setMsgDoCancel(String msgDoCancel) {
		this.msgDoCancel = msgDoCancel;
	}
	
	
	
}
