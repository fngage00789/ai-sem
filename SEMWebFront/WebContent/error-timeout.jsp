<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page isErrorPage="true" %>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="th.co.ais.web.util.WebUtil"%>

<%
	session.invalidate();
%>

<html>
<head>
   	<title>Error Timeout</title>
   	<script type="text/javascript" language="javascript">
	</script>
</head>

<body onload="setTimeout('onloader()', 3000);">
	<div>
		<div style="padding-top: 120px">&nbsp;</div>
		<div style="height: 330px; 
					background-image: url('images/oops-form.png'); 
					background-position: center top; background-repeat: no-repeat;" >
			<div style="height: 204px; widht: 100%;">
				&nbsp;
			</div>
		</div>
	</div>
</body>
</html>