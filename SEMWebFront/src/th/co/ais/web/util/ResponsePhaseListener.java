package th.co.ais.web.util;

import javax.faces.context.ExternalContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

public class ResponsePhaseListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4753724964436547235L;

	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		 ExternalContext ectx = event.getFacesContext().getExternalContext();
	     HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
	     response.addHeader("X-UA-Compatible", "IE=8");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
