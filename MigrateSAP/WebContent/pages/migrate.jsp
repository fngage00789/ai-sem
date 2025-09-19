<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.ais.migrate.sem.model.DatFile"%>
<%@page import="com.ais.migrate.sem.model.SyncFile"%>
<%@page import="com.ais.migrate.sem.model.SPProcedure.EProcedureName"%>
<%@page import="com.ais.migrate.sem.model.SPProcedure.EProcedureName"%>
<%@page import="com.ais.migrate.sem.model.SPProcedure"%>
<%@page import="com.ais.migrate.sem.utilities.MigrateSAPUtility"%>
<%@page import="com.ais.migrate.spring.controller.MigrateSAPController"%><html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Migrate Data from sap into table MIGRATE_SAPCT_AIS</title>
	<script type="text/javascript">
		function chkAllItem(chkAll){
			var chkItem = document.getElementsByName("chkItem");		
			for (i = 0; i < chkItem.length; i++){
				chkItem[i].checked = chkAll.checked;
			}
		}
	</script>
</head>

<%
	MigrateSAPController miCtrl = new MigrateSAPController();
	List<File> templates = (List<File>)request.getSession().getAttribute("SAPTemplates");
	List<DatFile> datFiles = (List<DatFile>)request.getSession().getAttribute("DATFiles");
	String successMsg = (String)request.getAttribute("successMsg"),
	 	   errorMsg = (String)request.getAttribute("errorMsg");
	boolean isSuccess = StringUtils.isNotEmpty(successMsg);
	String attrMsg = isSuccess?"successMsg":"errorMsg";
	String filePath = request.getParameter("filePath"),
		   selTemplate = request.getParameter("ddlTemplate"),
		   selProc = request.getParameter("ddlProcedures");
%>
<body>
	<div align="center">
	
		<br><br><br><br><br>
		<%--form id="formUpload" action="./migrate.run" enctype="multipart/form-data" method="post" >           
			<label>เลือกไฟล์ (*.zip) ที่ต้องการนำเข้า</label>
			<input type="file" name="m_file" id="m_file" />
			<input id="btnUpLoad" name="btnUpLoad" type="submit" value="Upload">
		</form--%>
		
		<%--form id="formImport" action="./migrate.run" method="post"--%>		
			<label>
				<font color="<%= isSuccess?"green":"red" %>" style="font-weight: bold;">					
					<%= request.getAttribute(attrMsg) %>
				</font>
			</label>
			
		<fieldset style="width: 90%">
			<legend align="left" >Import file(*.dat)</legend>
			<%--<table width="50%" border="1" cellpadding="0" cellspacing="0">
				<tr>
   					<td align="center" colspan="4">
   						form id="formUpload" action="./migrate.run" enctype="multipart/form-data" method="post" >
		   					<table width="100%" border="1" cellpadding="0" cellspacing="0">
		 						<tr>
		 							<td colspan="2">Upload zip file</td>
		 						</tr>
		 						<tr>
		 							<td align="left" width="20%">
	   									Template: 
	   								</td>
		 							<td align="left">
	   									<!--select id="ddlTemplate" name="ddlTemplate">
	   										<option value="MI_SAP_CONTRACT">MI_SAP_CONTRACT
	   										<option value="MI_SAP_MOVEMENT">MI_SAP_MOVEMENT
	   									</select-->
	   								</td>
		 						</tr>
		 						<tr>
		 							<td align="left">
	   									Select: 
	   								</td>
		 							<td align="left">
		 								<input type="file" name="m_file" id="m_file" />
		 							</td>
		 						</tr>
		 						<tr>
		 							<td align="left"></td>
		 							<td align="left">
										<input id="btnUpLoad" name="btnUpLoad" type="submit" value="Upload">
		 							</td>
		 						</tr>
		 					</table>
		 				</form>
	 				</td>
   				</tr>
   			</table>--%>
   			
   			<form id="formImport" action="./migrate.run" method="post">	
				<table width="98%" border="1" cellpadding="0" cellspacing="0">
					<tr>
	   					<td align="center" colspan="9">   						
	   						<table width="100%" border="1" cellpadding="0" cellspacing="0">
	   							<tr>
	   								<td align="left">
	   									Path: <input name="filePath" type="text" value="<%= miCtrl.getFilePath(request) %>" style="width: 60%"/>
	   									<input id="btnLoadTemplate" name="btnLoadTemplate" type="submit" value=" Load Template ">  									
	   									<br/>
	   									<select id="ddlTemplate" name="ddlTemplate" onchange="formImport.submit();">	   										
											<option value="" <%= "".equals(selTemplate)?"selected":"" %> >---------- Select Template ----------
								<% 
									if(templates!=null){
										for(File f : templates){
											if(f.isDirectory()){ 
												String dir = f.getName();
								%>
	   										<option value="<%= dir %>" <%= dir.equals(miCtrl.getTemplateId(request))?"selected":"" %> ><%= dir %>
	   							<%  		}
	   									} 
	   								}
	   							%>
	   									</select>	   									
	   									<input id="btnImport" name="btnImport" type="submit" value=" Import ">
	   								</td>
	   							</tr>
	   						</table>	   					
	   					</td>   					
	   				</tr>
	   				<tr>
	   					<td align="center" style="font-weight: bold;" colspan="4">Dat</td>
	   					<td align="center" style="font-weight: bold; font-size:20" colspan="5">Sync</td>
	   				</tr>
	   				<tr>
	   					<td align="center">
	   						<input name="chkAll" type="checkbox" onclick="chkAllItem(this);" >
	   					</td>
	   					<td align="center" style="font-weight: bold;">No</td>
	   					<td align="center" style="font-weight: bold;">File Name</td>
	   					<td align="center" style="font-weight: bold;">Size</td>
	   					
						<td align="center" style="font-weight: bold;">File Name</td>
						<td align="center" style="font-weight: bold;">Total Record</td>
	   					<td align="center" style="font-weight: bold;">Total Amount</td>
	   					<td align="center" style="font-weight: bold;">User ID</td>
	   					<td align="center" style="font-weight: bold;">Email</td>
	   				</tr>
			<%					
				String defaultSyncField = "[Empty]";
				NumberFormat formatNumber = new DecimalFormat("#,###");	
				DecimalFormat formatDecimal = new DecimalFormat("#,###.##");
				if(datFiles!=null){
					for(int i=0; i<datFiles.size(); i++){ 
						File dF = datFiles.get(i).getFile();
						SyncFile sF = datFiles.get(i).getSyncFile();					
			%> 				
	 				<tr>
	 					<td align="center">
	 						<input name="chkItem" type="checkbox" value="<%= i %>" >
	 					</td>
	   					<td align="center"><%= i+1 %></td>
	   					<td align="left"><%= dF.isFile()?dF.getName():"" %></td>
	   					<td align="right"><%= formatNumber.format(dF.length()/1000) %> KB</td>
	   					
	   					<td align="left"><%= sF.getFileName() %></td>
	   					<td align="right"><%= sF.getTotalRecord()!=null?formatNumber.format(sF.getTotalRecord()):defaultSyncField %></td>
	   					<td align="right"><%= sF.getTotalAmount()!=null?formatDecimal.format(sF.getTotalAmount()):defaultSyncField %></td>
	   					<td align="center"><%= StringUtils.defaultIfEmpty(sF.getUserId(), defaultSyncField) %></td>
	   					<td align="center"><%= StringUtils.defaultIfEmpty(sF.getEmail(), defaultSyncField) %></td>
	   				</tr>	
	 		<%	 				
	 				}
	 			}
	 		%>
	   			</table>
	   		</form>
	   	</fieldset>
	   	
	   	<br/><br/>
	   	<fieldset style="width: 90%">
			<legend align="left" >Execute StoreProcedures</legend>
			<form id="formExecProc" action="./migrate.run" method="post">
				<table width="98%" border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td align="left">
							<select id="ddlProcedures" name="ddlProcedures" onchange="formExecProc.submit();">	   										
								<option value="" <%= "".equals(selProc)?"selected":"" %> >---------- Select Template ----------								
					<%		
							for(EProcedureName proc : EProcedureName.values()){ 
					%>								
								<option value="<%= proc.name() %>" <%= proc.name().equals(selProc)?"selected":"" %> ><%= proc.name() %>
					<%		
							}
					%>
							</select>	   									
							<input id="btnExecProc" name="btnExecProc" type="submit" value=" Execute ">
						</td>
					</tr>
	   			</table>
   			</form>
		</fieldset>		
    </div> 
</body>
</html>