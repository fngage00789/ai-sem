package th.co.ais.web.action;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import th.co.ais.domain.gm.Employee;
import th.co.ais.util.EParamCode;
import th.co.ais.util.SEMDataUtility;
import th.co.ais.web.bean.AbstractConfiguration;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.util.FacesUtils;
import th.co.ais.web.util.FrontMessagePropUtil;
import th.co.ais.web.util.WebUtil;

public abstract class AbstractBaseAction implements Serializable {

	public static final long serialVersionUID = -6147330218923832972L;

	private static final Log LOG = LogFactory.getLog(AbstractBaseAction.class);
	
	public static final String TYPE_PAGE = "page";
	
	public static final String TYPE_POPUP = "popup";
	
	//expression for using in selectItemLovCachUtil
	public static final String EX_IN = "in";
	public static final String EX_AND = "and";
	public static final String EX_OR = "or";
	public static final String EX_ALL = "all";
	/**
	 * Get FacesUtils
	 *
	 * @return FacesUtils
	 */
	protected final FacesUtils getFacesUtils() {
		return FacesUtils.getInstance();
	}
	
	public Object getBean(final String name) {
		return getFacesUtils().getBean(name);
	}
	
	public Object getSpringBean(final String beanName){
		return getFacesUtils().getSpringBean(beanName);
	}
	
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	
//	protected final String msg(String key){
//		return getMenuPropUtil().getMessage(key);
//	}
	
	protected final String msg(String key) {
		FacesContext context = FacesContext.getCurrentInstance();
		String text = FrontMessagePropUtil.getMessageResourceString(
					  context.getApplication().getMessageBundle(), key, null, 
					  context.getViewRoot().getLocale());
		return text;
	}
	
	public String getUserLogIn(){
		String username = "";
		
		SsoBean ssoBean = (SsoBean)getFacesUtils().getSessionMapValue("ssoBean");
		if(ssoBean != null)
			username = ssoBean.getUserName();
		LOG.info("username :" + username);
		
		return username;
	}
	
	public UserSession getUserSession(){
		return (UserSession)getFacesUtils().getSessionMapValue("userSession");
	}
	
	public String getNavPrograme(){
		String navPro = "";
		UserSession  userSession = (UserSession)getFacesUtils().getSessionMapValue("userSession");
		if(userSession != null)
		navPro = userSession.getNavProgram();
		return navPro;
	}
	
	public Employee getEmployee(){
		Employee employee = new Employee();
		SsoBean ssoBean = (SsoBean)getFacesUtils().getSessionMapValue("ssoBean");
		
		if(ssoBean != null) {
			employee = ssoBean.getEmployee();
		}
		
		if(employee == null) {
			employee = generateEmptyEmployee(ssoBean);
		}
		LOG.info("getEmployee :" + employee.getEngName() + " " + employee.getEngSurname());
				
		return employee;
	}
	
	public Employee generateEmptyEmployee(SsoBean ssoBean) {
		Employee employee = new Employee();
		employee.setBuildingCode("-");
		employee.setCompanyCode("-");
		employee.setCostCenter("-");
		employee.setEmail("-");
		employee.setEmployeeGroup("-");
		employee.setEmployeeType("-");
		employee.setEngName("-");
		employee.setEngSurname("-");
		employee.setFloor("-");
		employee.setMobileNo("-");
		employee.setOrgDesc("-");
		employee.setOrgId("-");
		employee.setPin("-");
		employee.setPositionId("-");
		employee.setPositionName("-");
		employee.setProvinceName("-");
		employee.setRecDateTime("-");
		employee.setSection("-");
		employee.setStatus("-");
		employee.setTelNo("-");
		employee.setThaiName("-");
		employee.setThaiSurname("-");
		employee.setUserStamp(ssoBean != null ? ssoBean.getUserName() : "-");
		employee.setZone("-");
		return employee;
	}
	
	public Date convertYearENtoTH(Date date){
		if(date == null)
			return null;
		try {
			return SEMDataUtility.convertToThYear(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String convertYearENtoTHStr(Date date){
		if(date == null)
			return null;
		try {
			return SEMDataUtility.convertToThYearStr(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String convertYearTimeENtoTHStr(Date date){
		if(date == null)
			return null;
		try {
			return SEMDataUtility.convertToThYearTimeStr(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean useSsoAuthorizeMenu(){
		String paramValue = AbstractConfiguration.getConfigByCode(EParamCode.P_SSO_AUTHORIZE_MENU.name);
		return "Y".equalsIgnoreCase(paramValue); 
	}
	
	public boolean useSsoAuthorizeComponent(){
		String paramValue = AbstractConfiguration.getConfigByCode(EParamCode.P_SSO_AUTHORIZE_COMPONENT.name);
		return "Y".equalsIgnoreCase(paramValue); 
	}
	
	public Map<String, Boolean> getRendererSSO() {
		return WebUtil.getRenderSSO();
	}
	
	
}
