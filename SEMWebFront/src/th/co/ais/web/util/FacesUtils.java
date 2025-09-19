package th.co.ais.web.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.faces.model.SelectItem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FacesUtils implements Serializable{

	private static final long serialVersionUID = 3200062616523014421L;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(FacesUtils.class);

	private static FacesUtils instance = new FacesUtils();

	/**
	 * prevent from creating new instance.
	 */
	private FacesUtils() {
	}

	/**
	 * Singleton instance accessor
	 *
	 * @return FacesUtils
	 */
	public static FacesUtils getInstance() {
		return instance;
	}

	// TODO: Rename this method.
	public void redirect(final String urlRequest) throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(urlRequest);
	}
	
	public String getContextPath() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
	}

	public ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	}

	public void clearContext() {
		HttpSession session = getHttpSession(false);
		try {
			session.invalidate();
		} catch(Exception ex) {
			// do nothing
		}
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
		//AuditTrailContextHolder.clearContext();		
	}
	
	/**
	 * Gets the request dispatcher.
	 *
	 * @param urlRequest
	 *            the uRL
	 *
	 * @return the request dispatcher
	 */
	public RequestDispatcher getRequestDispatcher(final String urlRequest) {
		return ((ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestDispatcher(urlRequest);
	}

	/**
	 * Gets the servlet request.
	 *
	 * @return the servlet request
	 */
	public ServletRequest getServletRequest() {
		return (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Gets the servlet response.
	 *
	 * @return the servlet response
	 */
	public ServletResponse getServletResponse() {
		return (ServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}
	
	public HttpServletRequest getHttpRequest(){   
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();   
    }   
    
	
    public HttpServletResponse getHttpResponse(){   
        return(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();   
    }   

	/**
	 * Gets the http session.getSession(bool), true if we want to create.
	 *
	 * @param create
	 *            the create
	 *
	 * @return the http session
	 */
	public HttpSession getHttpSession(final boolean create) {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(create);
	}

	/**
	 * Gets the action attribute.
	 *
	 * @param event
	 *            the event
	 * @param name
	 *            the name
	 *
	 * @return the action attribute
	 */
	public Object getActionAttribute(final ActionEvent event, final String name) {
		return event.getComponent().getAttributes().get(name);
	}

	/**
	 * Gets the action attribute.
	 *
	 * @param event
	 *            the event
	 * @param name
	 *            the name
	 *
	 * @return the action attribute
	 */
	public Object getValueChangeEventAttribute(final ValueChangeEvent event, final String name) {
		return event.getComponent().getAttributes().get(name);
	}

	/**
	 * Gets the request map value.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the request map value
	 */
	public Object getRequestMapValue(final String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(key);
	}

	/**
	 * Gets the session map value.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the session map value
	 */
	public Object getSessionMapValue(final String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	/**
	 * Gets the application map value.
	 *
	 * @param key
	 *            the key
	 *
	 * @return the application map value
	 */
	public Object getApplicationMapValue(final String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
	}

	/**
	 * Gets the application map.
	 *
	 * @return the application map
	 */
	public Map<String, Object> getApplicationMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
	}

	/**
	 * Gets the request parameter.
	 *
	 * @param name
	 *            the name
	 *
	 * @return the request parameter
	 */
	public Object getRequestParameter(final String name) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	}

	// Setters
	// --------------------------------------------------------------------------
	// ---------

	/**
	 * Sets the request map value.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void setRequestMapValue(final String key, final Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(key, value);
	}

	/**
	 * Sets the session map value.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void setSessionMapValue(final String key, final Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	}

	public void setSessionMapValue(FacesContext context, String key, Object value) {
		context.getExternalContext().getSessionMap().put(key, value);
	}

	/**
	 * Remove the session map value.
	 *
	 * @param key
	 *            the key
	 */
	public void removeSessionMapValue(final String key) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
	}

	public Object getBean(final String beanName) {
		final FacesContext context = FacesContext.getCurrentInstance();
		final Object myBean = context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);

		return myBean;
	}

	public Object getSpringBean(final String beanName) {
		final Object myBean = WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean(beanName);
		return myBean;
	}

	/**
	 * Gets the faces context.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 *
	 * @return the faces context
	 */
	public FacesContext getFacesContext(final HttpServletRequest request, final HttpServletResponse response) {
		// Get current FacesContext.
		FacesContext facesContext = FacesContext.getCurrentInstance();

		// Check current FacesContext.
		if (facesContext == null) {

			// Create new Lifecycle.
			final LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			final Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

			// Create new FacesContext.
			final FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
			facesContext = contextFactory.getFacesContext(request.getSession().getServletContext(), request, response, lifecycle);

			// Create new View.
			final UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "");
			facesContext.setViewRoot(view);

			// Set current FacesContext.
			FacesContextWrapper.setCurrentInstance(facesContext);
		}

		return facesContext;
	}

	/**
	 * binary search from selectItem
	 */
	public ArrayList<SelectItem> generateSearchMatchesFromSelectItems(String searchWord, List<SelectItem> searchList, int maxMatches) {

		Comparator<SelectItem> LABEL_COMPARATOR = new Comparator<SelectItem>() {
			// compare method for city entries.
			//@Override
			public int compare(SelectItem o1, SelectItem o2) {
				if (o1 == null && o2 == null) {
					return 0;
				} else if (o1 == null && o2 != null) {
					return -1;
				} else if (o1 != null && o2 == null) {
					return 1;
				}
				// compare ignoring case, give the user a more automated feel
				// when
				// typing
				return o1.getLabel().compareToIgnoreCase(o2.getLabel());
			}
		};

		java.util.Collections.sort(searchList, LABEL_COMPARATOR); // sort

		ArrayList<SelectItem> matchList = new ArrayList<SelectItem>();
//		if (CommonUtils.isNullOrEmpty(searchWord)) {
//			return null; // clear list
//		}

		final SelectItem searchItem = new SelectItem("", searchWord);
		int insert = Collections.binarySearch(searchList, searchItem, LABEL_COMPARATOR);

		// less then zero if we have a partial match
		if (insert < 0) {
			insert = Math.abs(insert) - 1;
		} else {
			// If there are duplicates in a list, ensure we start from the
			// first one
			if (insert != searchList.size() && LABEL_COMPARATOR.compare(searchItem, searchList.get(insert)) == 0) {
				while (insert > 0 && LABEL_COMPARATOR.compare(searchItem, searchList.get(insert - 1)) == 0) {
					insert = insert - 1;
				}
			}
		}

		for (int i = 0; i < maxMatches; i++) {
			if ((insert + i) >= searchList.size() || i >= maxMatches) {
				break;
			}
			matchList.add(searchList.get(insert + i));
		}

		return matchList;
	}

	/**
	 * return physical path on disk
	 */
	public String getPhysicalPath() {
		return getHttpSession(false).getServletContext().getRealPath("");
	}
	
	/**
	 * 
	 * looks up an object in a {@link List} of {@link SelectItem}s
	 * with the object's {@link String} representation generated
	 * by IceFaces's decoder/encoder.
	 * 
	 * @param stringRepOfObjectGeneratedByIceFaces
	 * @param selectItems
	 * @return
	 */
	public Object lookupObject(final String stringRepOfObjectGeneratedByIceFaces, final List<SelectItem> selectItems){		
		for(SelectItem s: selectItems){
			if(s.getValue().toString().equals(stringRepOfObjectGeneratedByIceFaces)){
				Object o = s.getValue();
				return o;
			}
		}		
		return null;
	}

}
