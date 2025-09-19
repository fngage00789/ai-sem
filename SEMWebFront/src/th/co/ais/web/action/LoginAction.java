package th.co.ais.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import th.co.ais.web.bean.LoginBean;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.util.SerializeManager;
import th.co.ais.web.util.WebUtil;


public class LoginAction {
	
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",new Locale("en","EN"));
	
	public String login() throws Exception{
		logger.debug("Check Login");
		String result = "login";
		LoginBean loginBean =  (LoginBean)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("loginBean");
		loginBean.setDisplayErrorMsg(false);
		try{
			/*if(loginBean!=null && loginBean.getUsername()!=null && loginBean.getPassword()!=null &&
					loginBean.getUsername().equalsIgnoreCase("a") && loginBean.getPassword().equalsIgnoreCase("b")){								
				result = "login_pass";
			}else{
				loginBean.setDisplayErrorMsg(true);
				loginBean.setErrorMsg("Login Process Error!");
			}*/
			
			/** For test **/
			if(null!=loginBean && null!=loginBean.getUsername() && null!=loginBean.getPassword()){
				
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath");
				if("rapeesuw".equals(loginBean.getUsername()) && "rapeesuw".equals(loginBean.getPassword())){
					ssoSerlzePath = ssoSerlzePath.concat("ssoBean_").concat(loginBean.getUsername()).concat(".xml");					
					result = "login_pass";
				}else if("vorapt49".equals(loginBean.getUsername()) && "vorapt49".equals(loginBean.getPassword())){
					ssoSerlzePath = ssoSerlzePath.concat("ssoBean_").concat(loginBean.getUsername()).concat(".xml");
					result = "login_pass";
				}
				
				if("login_pass".equals(result)){
					SsoBean ssoBean = (SsoBean)SerializeManager.read(ssoSerlzePath);
					ec.getSessionMap().put("ssoBean", ssoBean);
				}else{
					loginBean.setDisplayErrorMsg(true);
					loginBean.setErrorMsg("Login Process Error!");
				}
			}else{
				loginBean.setDisplayErrorMsg(true);
				loginBean.setErrorMsg("Login Process Error!");
			}
			
		}catch (Exception e) {
			throw e;
		}
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
		return result;
	}
	
}
