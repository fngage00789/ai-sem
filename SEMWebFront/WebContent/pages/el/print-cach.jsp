<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="th.co.ais.web.util.config.ParameterConfigUtil" %>
<%@ page import="th.co.ais.web.util.LOVCacheUtil" %>
<%@ page import="th.co.ais.web.util.MSGCacheUtil" %>
<%@ page import="th.co.ais.web.util.ManagementMasterCacheUtil" %>
<%@ page import="java.util.*" %>
<%@ page import="th.co.ais.domain.gm.ParameterConfig" %>
<%
	List<ParameterConfig> parameterList = ParameterConfigUtil.getParametersConfig();
	if(null==parameterList){
		out.print("<div align='center'><font color='red'>Go to play SEM Application and comeback to me. Go go go !!!</font></div>");
	}else{
		out.print("<div align='center'><a href='load-cach.jsp'>Hit me for refresh cache Yeah yea</a></div>");
		for(ParameterConfig obj : parameterList){
			out.print("<font color=blue>Param code : "+obj.getRowId()+"</font><br>");
			out.print("Param name : "+obj.getParamName()+"<br>");
			out.print("Param value : "+obj.getParamValue()+"<br>");
			out.print("=====================================<br>");
		}
	}
%>