package th.co.ais.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import th.co.ais.service.gm.IMessageService;
import th.co.ais.domain.gm.Message;
import th.co.ais.util.EComponentCode;

public class MSGCacheUtil implements Serializable{
	
	private static final long serialVersionUID = -7649064908760186026L;
	
	private Logger log = Logger.getLogger(getClass());
	
	private static MSGCacheUtil instance = null;
	
	private static List<Message> msg;
	
	private HashMap componentMap = null;
	
	private MSGCacheUtil(){

	}
	public static void initMsg() {
		if (msg == null) {
			try {
				IMessageService msgService = (IMessageService)FacesUtils.getInstance().getBean("messageService");
				msg = msgService.queryMessageAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static synchronized MSGCacheUtil getInstance() {
        if (instance == null) {
            instance = new MSGCacheUtil();
        }
        return instance;
    }
	public void loadComponent(){
		initMsg();
		componentMap = new HashMap();
		setMessageList(componentMap);
	}
	
	@SuppressWarnings("unchecked")
	private void setMessageList(HashMap rawData){
//		List<Message> msgList = new ArrayList<Message>();
//		Message msgObj = null;
		try {
//			if(rawData.containsKey(EComponentCode.M_CODE_MESSAGE.name) && rawData.get(EComponentCode.M_CODE_MESSAGE.name) != null) {
//				if(((List)rawData.get(EComponentCode.M_CODE_MESSAGE.name)).size() > 0){
//					for (Message message : ((List<Message>)rawData.get(EComponentCode.M_CODE_MESSAGE.name))) {
//						msgObj = new Message();
//						msgObj.setMessageCode(message.getMessageCode());
//						msgObj.setMessageDesc(message.getMessageDesc());
//						msgList.add(msgObj);
//					}
//					componentMap.put(EComponentCode.M_CODE_MESSAGE.name, msgList);
//				}
//			}else{
				if(msg != null && !msg.isEmpty()){
					componentMap.put(EComponentCode.M_CODE_MESSAGE.name, msg);
					for(Message message : msg){
						componentMap.put(message.getMessageCode(), message.getMessageDesc());
					}
				}
//			}
		} catch (Exception e) {
			log.error("error in setMessageList : " + e);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Message> getMessageList(){
		List<Message> returnList = new ArrayList<Message>();
		if(componentMap == null){ loadComponent(); }
		try {
			returnList = (List<Message>)componentMap.get(EComponentCode.M_CODE_MESSAGE.name);
		} catch (Exception e) {
			log.error("error in getMessageList : " + e);
		}
		return returnList;
	}
	
	public String getMessageByCode(String messageCode){
		String messageDesc = "";
		if(componentMap == null){ loadComponent(); }
		try {
			messageDesc = (String)componentMap.get(messageCode);
		} catch (Exception e) {
			log.error("error in getMessageByMessageCode : " + e);
		}
		return messageDesc;
	}
	
	public HashMap getComponentMap() {
		return componentMap;
	}
	public void setComponentMap(HashMap componentMap) {
		this.componentMap = componentMap;
	}
	public static List<Message> getMsg() {
		return msg;
	}
	public static void setMsg(List<Message> msg) {
		MSGCacheUtil.msg = msg;
	}
		
}