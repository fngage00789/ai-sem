package th.co.ais.web.util;

import javax.faces.context.FacesContext;

public abstract class FacesContextWrapper extends FacesContext {

	/**
	 * setCurrentInstance
	 * 
	 * @param facesContext FacesContext
	 */
	public static void setCurrentInstance(final FacesContext facesContext) {
		FacesContext.setCurrentInstance(facesContext);
	}

}
