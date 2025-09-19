package th.co.ais.web.servlet;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.faces.FactoryFinder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
//import org.jacorb.notification.util.LogUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import Permission.bean.ais.com.SSOCompCode;
import Permission.bean.ais.com.SSOProgCode;
import Permission.bean.ais.com.SSOResponse;

import com.ais.websrv.EmployeeServiceWebServiceV2;
import com.ais.websrv.EmployeeServiceWebServiceV2ServiceLocator;
import common.bean.ais.com.Message;
import th.co.ais.domain.gm.Employee;
import th.co.ais.service.gm.IEmployeeService;
import th.co.ais.web.bean.SsoBean;
import th.co.ais.web.bean.UserSession;
import th.co.ais.web.util.SerializeManager;
import th.co.ais.web.util.WebUtil;

/**
 * Servlet implementation class SpringContext
 */
public class SSOLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SSOLoginServlet.class);
	private EmployeeServiceWebServiceV2 empService;	
	private FacesContextFactory facesContextFactory;
    private Lifecycle lifecycle;    
    
    /**
     * Default constructor. 
     */
    public SSOLoginServlet() {
    	 super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);		
		LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
		facesContextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
		lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = null;
		String flag = null;
		System.out.println("<<<<< ".concat(getClass().getName()).concat(".doGet() >>>>>"));

		try {
			session = request.getSession();
			flag = WebUtil.getQueryString(request, "flag");
			
			if(StringUtils.equalsIgnoreCase("logout", flag) || StringUtils.equalsIgnoreCase("decreaseCounter",flag)){
				session.invalidate();
			}
					
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("<<<<< ".concat(getClass().getName()).concat(".doPost() >>>>>"));

		try {	
			boolean useSerialize = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","useSerialize"));
			
			ExternalContext ec = getFacesContext(request, response).getExternalContext();
			SsoBean ssoBean = null;
			
			//Clear Session
			//ec.getSessionMap().remove("ssoBean");
			//WebUtil.clearAllSessionNotUsed();
			logger.debug("byPass = "+request.getParameter("byPass"));
			if(!useSerialize && !StringUtils.equalsIgnoreCase("byPass", request.getParameter("byPass"))){
				ssoBean = getSSOParams(request, response);
				Message msg = WebUtil.syncUserSession(ssoBean.getToken());
				if("Success".equals(msg.getErrorMesg())){
					getSsoData(ssoBean,request,response);		
					ec.getSessionMap().put("ssoBean", ssoBean);
					request.getRequestDispatcher("/pages/home.jsf").forward(request, response);
					
				}else{
					request.setAttribute("errorCode", "Single Sign On System (SSO)");
					request.setAttribute("errorHeader", msg.getErrorMesg()+" ("+msg.getErrorCode()+")");
					request.setAttribute("errorMessage","");
					request.getRequestDispatcher("/error.jsf").forward(request, response);
				}
			}else{
				/** Fix for test (ใช้เทสไม่ผ่าน SSO)**/
				String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath")
				 						 .concat(WebUtil.getQueryString(request,"userName")+".xml");
				ssoBean = (SsoBean)SerializeManager.read(ssoSerlzePath);
				ssoBean.setLoginDt(new Timestamp(Calendar.getInstance(new Locale("th", "TH")).getTimeInMillis()));
				ssoBean.setSessionId(request.getSession().getId());
				
				ec.getSessionMap().put("ssoBean", ssoBean);
				request.getRequestDispatcher("/pages/home.jsf").forward(request, response);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			request.setAttribute("errorCode", "Exception");
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorHeader", e.getClass().toString());
			request.getRequestDispatcher("/error.jsf").forward(request, response);
			
		}
		
	}
	
	private SsoBean getSSOParams(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		/** Check ÇèÒ ssoBean session ÁÕÍÂÙèÃÖà»ÅèÒ áÅÐ token µÃ§¡Ñ¹ËÃ×ÍäÁè **/
		ExternalContext ec = getFacesContext(request, response).getExternalContext();
		SsoBean sso = (SsoBean)ec.getSessionMap().get("ssoBean");
		if(null!=sso){
			
			/* IF 	 token, rn = session's token, rn : No Logout @SSO
			 * THEN Use data in Session */
			if(request.getParameter("token").equals(sso.getToken()) && 
			   request.getParameter("rn").equals(sso.getRn()) ){
				return sso;
			}
		}
		
		
		/** Print parameters posted from SSO **/
		Enumeration paramNames = request.getParameterNames();
	    while(paramNames.hasMoreElements()) {
	      String paramName = (String)paramNames.nextElement();
	      System.out.println(paramName.concat(" >> ").concat(request.getParameter(paramName)));
	    }
		
	    /** Keep posted SSO parameters to Model & Session **/
	    sso = new SsoBean();
		sso.setToken(request.getParameter("token"));
		sso.setRid(request.getParameter("rid"));
		sso.setSid(request.getParameter("sid"));
		sso.setRn(request.getParameter("rn"));
		sso.setSn(request.getParameter("sn"));
		
		sso.setFn(request.getParameter("fn"));
		sso.setLn(request.getParameter("ln"));
		sso.setTheme(request.getParameter("theme"));
		sso.setTemplate(request.getParameter("template"));
		sso.setHost(request.getParameter("host"));
		
		sso.setLc(request.getParameter("lc"));
		sso.setGl(request.getParameter("gl"));
		sso.setDc(request.getParameter("dc"));
		sso.setSc(request.getParameter("sc"));
		sso.setPt(request.getParameter("pt"));
		sso.setLoginDt(new Timestamp(Calendar.getInstance(new Locale("th", "TH")).getTimeInMillis()));
		sso.setSessionId(request.getSession().getId());
		
		if(null!=sso.getToken()){
			String[] tokens = sso.getToken().split(",");
	        sso.setTokenId(tokens[0]);
	        sso.setUserName(tokens[1]);
	        sso.setGroupId(tokens[2]);
	        sso.setSubModuleId(tokens[3]);
	        sso.setClientIpAddress(tokens[4]);
		}
		return sso;
	}
	
	private void getSsoData(SsoBean ssoBean, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//ExternalContext ec = getFacesContext(request, response).getExternalContext();
		logger.debug("Start Get Permission");		
		if(null==ssoBean.getSsoCompCodes() || null==ssoBean.getSsoProgCodes()){
			empService = (new EmployeeServiceWebServiceV2ServiceLocator()).getEmployeeServiceWebServiceV2SoapPort();
			
			/** ´Ö§ ProgCode Code ·Ñé§ËÁ´¨Ò¡ SSO **/
			logger.debug("Begin getAllPermission");
			SSOResponse respP = empService.getAllPermission(ssoBean.getToken());
			logger.debug("END getAllPermission");
			SSOProgCode[] allProgCode = respP.getSSOProgCodecArr();
			//SSOCompCode[] allCompCode = respP.getSSOCompCode();
						
			/** ÊÃéÒ§ HashMap<ProgCode,SSOCompCode[]> à¾×èÍàÃÕÂ¡ãªéã¹ÃÐºº **/
			HashMap<String, SSOProgCode> mapP = new HashMap<String, SSOProgCode>();
			HashMap<String, SSOCompCode[]> mapC = new HashMap<String, SSOCompCode[]>();
			if(allProgCode!=null) {
				//System.out.println("List ProCode: ");
				logger.debug("allProgCode.length = "+allProgCode.length);
				for (SSOProgCode sp : allProgCode) {	
					//System.out.println(" - "+sp.getProgCodeName()+ " [inq:" +sp.getInq()+"]");
					if(!mapP.containsKey(sp.getProgCodeName())){
						mapP.put(sp.getProgCodeName(), sp);
					}
					
					if(!mapC.containsKey(sp.getProgCodeName())){
						/** ´Ö§ªØ´¢Í§ CompCode[] µÒÁ ProgCode **/
//						logger.debug("Begin getPermission");
						SSOResponse respC = empService.getPermission(ssoBean.getToken(), sp.getProgCodeName());
//						logger.debug("END getPermission");
						if("Success".equals(respC.getMessage().getErrorMesg())){
							mapC.put(sp.getProgCodeName(), respC.getSSOCompCode());
						}
					}
				}
			}
			logger.debug("END Get Permission");
			
			ssoBean.setSsoProgCodes(mapP);
			ssoBean.setSsoCompCodes(mapC);				
			
			/** ดึงข้อมูล Employee (เช่น OrgName, PositionID, Email, etc..) **/
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			IEmployeeService empService = (IEmployeeService)ctx.getBean("employeeService");
			Employee param = new Employee();
			param.setUserStamp(ssoBean.getUserName());
			List<Employee> employees = empService.getEmployees(param);
			if(employees!=null && employees.size()>0){
				ssoBean.setEmployee(employees.get(0));
			}
						
		}
		
		/** Keep 4 test without SSO's parameters 
		 *  Edit 25/01/2011 by vorapt49, for performance by Thread **/ 
		/*boolean writeXmlSerialize = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","writeXmlSerialize"));
		if(writeXmlSerialize){
			String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath")
									.concat(ssoBean.getUserName()+"_"+ssoBean.getSn()+".xml");
			SerializeManager.write(ssoBean, ssoSerlzePath);
		}*/
		Thread thead1 = new Thread(new WriteSSOXml(ssoBean), "ThreadWriteSsoXML");
		thead1.start();
	}
	
	public void mockMenues(HashMap<String, SSOProgCode> mapP) {
		mockMenu("SEMMSA001-0", mapP);
		mockMenu("SEMMSA003-1", mapP);
		mockMenu("SEMMSA004-1", mapP);
	}
	
	public void mockMenu(String progCode, HashMap<String, SSOProgCode> mapP) {
		boolean removeDat = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","removeDat"));
		if(removeDat)
			mapP.put(WebUtil.PREFIX_PROG_CODE + progCode.replace("-", ""), mockProgCode(progCode));
		else
			mapP.put(progCode.replace("-", ""), mockProgCode(progCode));
	}
	
	public SSOProgCode mockProgCode(String progCode) {
		SSOProgCode progObj = new SSOProgCode();
		progObj.setProgCodeName(progCode);
		return progObj;
	}

	private FacesContext getFacesContext(HttpServletRequest request, HttpServletResponse response){
		FacesContext fc = facesContextFactory.getFacesContext(getServletContext(), request, response, lifecycle);
		return fc;
	}
}

class WriteSSOXml extends Thread{
	public WriteSSOXml(){		
	}
	
	private SsoBean ssoBean;
	public SsoBean getSsoBean(){return ssoBean;}
	public void setSsoBean(SsoBean ssoBean){this.ssoBean = ssoBean;}
	
	public WriteSSOXml(SsoBean ssoBean){
		setSsoBean(ssoBean);
		System.out.println(this);
	}	
	
	public void run() {
		//Display info about this particular thread
		System.out.println(Thread.currentThread().getName());
		
		try {
			boolean writeXmlSerialize = Boolean.parseBoolean(WebUtil.getResources("resources.application_th","writeXmlSerialize"));
			if(writeXmlSerialize){
				String ssoSerlzePath = WebUtil.getResources("resources.application_th", "ssoSerializePath");
				String fileName = ssoSerlzePath+ssoBean.getUserName()+"_"+ssoBean.getSn()+".xml";
				SerializeManager.write(ssoBean, fileName);				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
