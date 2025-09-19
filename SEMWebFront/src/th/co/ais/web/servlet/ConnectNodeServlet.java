package th.co.ais.web.servlet;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import th.co.ais.web.gm.action.SEMMCT007Action;

import com.ais.websrv.EmployeeServiceWebServiceV2;

public class ConnectNodeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 752525340750050518L;

	private static final Logger logger = Logger.getLogger(SSOLoginServlet.class);
	private EmployeeServiceWebServiceV2 empService;	
	private FacesContextFactory facesContextFactory;
    private Lifecycle lifecycle;    
    
//    public void init(ServletConfig config) throws ServletException {
//		super.init(config);		
//		LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
//		facesContextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
//		lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
//	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = null;
		String flag = null;
//		System.out.println("<<<<< ".concat(getClass().getName()).concat(".doGet() >>>>>"));
//		logger.debug("ConnectNodeServlet doGet byPass = "+request.getParameter("byPass"));
		logger.debug("##### Start ConnectNodeServlet doGet ####");
		try{
			SEMMCT007Action semmct007Action = new SEMMCT007Action();
			
			semmct007Action.clearOldLovValueCache();
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("ERROR ConnectNodeServlet doget : "+e);
			// TODO: handle exception
		}
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
	
}
