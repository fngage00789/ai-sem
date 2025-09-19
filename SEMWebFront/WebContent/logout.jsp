<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="th.co.ais.web.util.WebUtil"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%

FacesContext context = FacesContext.getCurrentInstance();
HttpSession ses = (HttpSession)context.getExternalContext().getSession(true);
if(session!=null){
	WebUtil.clearAllSessionNotUsed();
	ses.invalidate();
}	

%>

<script type="text/javascript" language="javascript">
top.location.href="<%=request.getContextPath()%>/sso.jsp";
</script>