package th.co.ais.web.servlet;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import th.co.ais.web.bean.ReActivateSsoStored;
import th.co.ais.web.bean.ReActivateSsoToken;
import th.co.ais.web.bean.SsoBean;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		Object object = arg0.getValue();
//		System.out.println("SessionAttributeListener attributeAddedobject = " + object);
		if (object instanceof SsoBean) {
			ReActivateSsoStored.getInstance().addItem(((SsoBean) object));
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		Object object = arg0.getValue();
		
		if (object instanceof SsoBean) {
			ReActivateSsoStored.getInstance().removeItem(((SsoBean) object).getSessionId(), ((SsoBean) object).getUserName());
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		Object object = arg0.getValue();
//		System.out.println("SessionAttributeListener attributeReplaced = " + object);
		if (object instanceof SsoBean) {
			ReActivateSsoStored.getInstance().addItem(((SsoBean) object));
		}
	}

}
