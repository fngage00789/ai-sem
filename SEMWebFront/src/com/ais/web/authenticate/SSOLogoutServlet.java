package com.ais.web.authenticate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class SSOLogoutServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(SSOLogoutServlet.class);
	private static final long serialVersionUID = -1751173700698442898L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		log.debug("Invoke session invalidate.");
		session.invalidate();
	}
	
}
