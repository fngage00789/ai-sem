package th.co.ais.web.util;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;


public class FrontMessageUtils {
	//	Log
	public static Logger logger = Logger.getLogger(FrontMessageUtils.class);
	
	public static void addMessage(String messageKey, Object param) {
        FacesContext context = FacesContext.getCurrentInstance( );
        Application application = context.getApplication( );
        String messageBundleName = application.getMessageBundle( );
        Locale locale = context.getViewRoot( ).getLocale( );
        ResourceBundle rb = ResourceBundle.getBundle(messageBundleName, locale);
        String msgPattern = rb.getString(messageKey);
        String msg = msgPattern;

        if (param != null) {
            Object[] params = {param};
            msg = MessageFormat.format(msgPattern, params);
        }

        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

        context.addMessage(null, facesMsg);
    }
	
	public static void addGlobalMsg(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletRequest request = (ServletRequest) facesContext.getExternalContext().getRequest();
        request.setAttribute("globalMessages", "true");
    }
	
	public static void delectGlobalMsg(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ServletRequest request = (ServletRequest) facesContext.getExternalContext().getRequest();
		Object obj = request.getAttribute("globalMessages");
        request.setAttribute("globalMessages", "false");
    }
	
	public static void addMessage(Severity messageType, String message) {
		FacesContext context = FacesContext.getCurrentInstance( );
		context.addMessage(null, new FacesMessage(messageType, message, message));
		addGlobalMsg();
	}
	
	public static void deleteMessage(Severity messageType, String message) {
		FacesContext context = FacesContext.getCurrentInstance( );
//		context.addMessage(null, new FacesMessage(messageType, message, message));
		Iterator<FacesMessage> it = context.getMessages();
		while (it.hasNext()) {
		    FacesMessage msg = it.next();
		    if (msg != null && msg.getSeverity() == FacesMessage.SEVERITY_INFO) {
		            it.remove();
		    }

		}
//		delectGlobalMsg();
	}
	
	public static void deleteMessage() {
		FacesContext context = FacesContext.getCurrentInstance( );
//		context.addMessage(null, new FacesMessage(messageType, message, message));
		Iterator<FacesMessage> it = context.getMessages();
		while (it.hasNext()) {
		    FacesMessage msg = it.next();
		    if (msg != null) {
		            it.remove();
		    }

		}
		delectGlobalMsg();
	}
	
	public static void addMessage(String clientId, Severity messageType, String message) {
		FacesContext context = FacesContext.getCurrentInstance( );
		context.addMessage(clientId , new FacesMessage(messageType, message, message));
	}	
	
	public static void addMessage(Severity messageType, List<String> messageList) {
		FacesContext context = FacesContext.getCurrentInstance( );
		for (String message : messageList) {
			context.addMessage(null, new FacesMessage(messageType, message, message));
		}
		addGlobalMsg();		
	}
	
	public static void addMessage(String clientId, Severity messageType, List<String> messageList) {
		FacesContext context = FacesContext.getCurrentInstance( );
		for (String message : messageList) {
			context.addMessage(clientId, new FacesMessage(messageType, message, message));
		}
	}	
	
	public static void addMessageInfo(String message){
		addMessage(FacesMessage.SEVERITY_INFO, message);
	}
	
	public static void deleteMessageInfo(String message){
		deleteMessage(FacesMessage.SEVERITY_INFO, "");
	}
	
	public static void addMessageInfo(String clientId, String message){
		addMessage(clientId, FacesMessage.SEVERITY_INFO, message);
	}	
	
	public static void addMessageError(String message){
		addMessage(FacesMessage.SEVERITY_ERROR, message);
	}
	
	public static void addMessageError(String clientId, String message){
		addMessage(clientId, FacesMessage.SEVERITY_ERROR, message);
	}	
	
	public static void addMessageError(List<String> messageList){
		addMessage(FacesMessage.SEVERITY_ERROR, messageList);
	}
	
	public static void addMessageError(String clientId, List<String> messageList){
		addMessage(clientId, FacesMessage.SEVERITY_ERROR, messageList);
	}	
	
//	public static void addMessageError(Exception e) {
//		String exceptionName =  e.getClass().toString();
//		String message = "";
//		
//		if (exceptionName.endsWith("IPFMBusinessException")) {
//			//SffBusinessException
//			IPFMBusinessException myException = (IPFMBusinessException) e;
//			
//			if (myException.getMessageCode() == null || "".equals(myException.getMessageCode())) {
//				//Message from other exceptions
//				message = myException.getMessage();
//			} else {
//				//Message from IPFM_MESSAGE_MASTER
//				try {
//					String[] arguments = myException.getArguments();
//					if (arguments == null) {
//						message = messageMasterService.getEnMessageByMessageCode(myException.getMessageCode());
//					} else {
//						List<String> argumentsList = new ArrayList<String>();
//						for (int i = 0; i < arguments.length; i++) {
//							argumentsList.add(arguments[i]);
//						}
//						message = messageMasterService.getEnMessageByMessageCode(myException.getMessageCode(), argumentsList);
//					}
//				} catch (IPFMBusinessException ex) {
//					logger.error(e,e.getCause());
//				}catch (Exception ex) {
//					logger.error(e,e.getCause());
//				}
//			}
//		} else {
//			//Other exceptions
//			message = exceptionName + " : " + e.getMessage();
//		}
//		
//		addMessage(FacesMessage.SEVERITY_ERROR, message);
//	}
	
	public static void addMessageWarn(String message){
		addMessage(FacesMessage.SEVERITY_WARN, message);
	}
	
	public static void addMessageWarn(String clientId, String message){
		addMessage(clientId, FacesMessage.SEVERITY_WARN, message);
	}	
	
	public static void addMessageFatal(String message) {
		addMessage(FacesMessage.SEVERITY_FATAL, message);
	}
	
	public static void addMessageFatal(String clientId, String message) {
		addMessage(FacesMessage.SEVERITY_FATAL, message);
	}
}
