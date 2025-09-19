<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@page import="javax.faces.context.FacesContext"%>
<%@page import="th.co.ais.web.bean.LoginBean"%>
<%
if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("timeout")!=null){
	LoginBean loginBean = new LoginBean();
	loginBean.setDisplayErrorMsg(true);
	loginBean.setErrorMsg("Session TimeOut!");
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
}else if(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("nologin")!=null){
	LoginBean loginBean = new LoginBean();
	loginBean.setDisplayErrorMsg(true);
	loginBean.setErrorMsg("User Not Login!");
	FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("loginBean", loginBean);
}
%>

<html>
<head>
<title>Site Expense Management</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="js/common.js"></script>
</head>
<body>
<f:view>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
	<tr>
    	<td height="200" >&nbsp;</td>
  	</tr>
	<tr>
		<td width="50%" align="center" valign="top">
			<table width="255" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<h:form id="frmLogin" >
    						<rich:panel header="Login ...." >    			
 								<h:panelGrid columns="3">
 									<h:outputText value="Error" styleClass="ms8red" rendered="#{loginBean.displayErrorMsg}"  />
 									<h:outputText value=":" styleClass="ms8red" rendered="#{loginBean.displayErrorMsg}"  />
 									<h:outputText value="#{loginBean.errorMsg}" styleClass="ms8red" rendered="#{loginBean.displayErrorMsg}" />
 									<h:outputText value="User Name" styleClass="ms8" />
 									<h:outputText value=":" styleClass="ms8" />
 									<h:inputText id="txtUserName" value="#{loginBean.username}" maxlength="20" size="20" />
 									<h:outputText value="Password" styleClass="ms8" />
 									<h:outputText value=":" styleClass="ms8" />
 									<h:inputSecret id="txtPassWord" value="#{loginBean.password}" maxlength="20" size="20"  />
 									<h:commandButton id="login" value="Login" action="#{loginAction.login}" />
 								</h:panelGrid>	        		       
        					</rich:panel>
        				</h:form>
        			</td>
        		</tr>
        </table>
        </td>
       </tr>
       </table>			
</f:view>
</body>
</html>
