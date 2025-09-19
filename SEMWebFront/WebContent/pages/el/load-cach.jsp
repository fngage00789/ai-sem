<%@ page language="java" %>
<%@ page import="th.co.ais.web.util.config.ParameterConfigUtil" %>
<%@ page import="th.co.ais.web.util.LOVCacheUtil" %>
<%@ page import="th.co.ais.web.util.MSGCacheUtil" %>
<%@ page import="th.co.ais.web.util.ManagementMasterCacheUtil" %>
<%@ page import="java.util.*" %>
<%@ page import="th.co.ais.domain.gm.ParameterConfig" %>
<%@ page import="th.co.ais.web.util.CompanyCacheUtil" %>
<%@ page import="th.co.ais.web.util.RegionCacheUtil" %>
<%
	ParameterConfigUtil.setParametersConfig(null);
	ParameterConfigUtil.getInstance().setConfigCache(null);
	LOVCacheUtil.setLov(null);
	MSGCacheUtil.setMsg(null);
	MSGCacheUtil.getInstance().setComponentMap(null);
	ManagementMasterCacheUtil.setManagementMasterList(null);
	CompanyCacheUtil.getInstance().setCompanyALL(null);
	CompanyCacheUtil.getInstance().setSelectItemDataCache(null);
	RegionCacheUtil.getInstance().setComponentMap(null);
	RegionCacheUtil.getInstance().setRegion(null);
%>
<div align="center"><a href="javascript:location.reload(true)">Hit me for refresh cache Yeah yea</a></div>
<div align="center"><a href="print-cach.jsp">Get it!!!</a></div>