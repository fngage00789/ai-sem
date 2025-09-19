package th.co.ais.web.servlet;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionBindingListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("ValueBound is object :" + arg0.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("ValueUnBound is object :" + arg0.getName());
	}

}
