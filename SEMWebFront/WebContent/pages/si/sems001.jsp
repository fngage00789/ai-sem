<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<html>
<head>
<title>Site Expense Management.</title>
</head>
<body style="margin: 0 0" onload="pageOnLoad();" >
<script language="Javascript">
mapWidth();
mapWidthIn();
mapWidthHalf();
mapHeight();
mapWidthScaleHeight();
mapWidth5Rows();
</script>


<f:view>
<f:loadBundle basename="resources.application" var="msg" />
<f:loadBundle basename="resources.siteinfo.sems001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<h:inputTextarea id="itaAttribute" value="" onblur="alert(this.id)"/>
		
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<%--h:panelGrid width="650">
					<rich:panel id="pnlSearchCriteria" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid columns="6">
							<!-- first row -->
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:inputText id="txtDocNo" value="#{sems001Bean.searchCriteria.docNo}" />
							<rich:spacer width="50" />
							<h:panelGroup>
								<div align="right">
									<h:outputText value="#{jspMsg['label.docDate']}" styleClass="ms7"/>
								</div>
							</h:panelGroup>
							<rich:calendar id="cldDocDate" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" />							
							<rich:spacer width="5" />
							<!-- second row -->
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.reqOfficer']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:inputText id="txtReqOfficer" value="#{sems001Bean.searchCriteria.reqOfficer}" />
							<rich:spacer width="50" />
							<h:panelGroup><div align="right">
								<h:graphicImage value="images/icon_required.gif"/><h:outputText 
								value="#{jspMsg['label.company']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:selectOneMenu id="ddlCompany" value="#{sems001Bean.searchCriteria.company}" >
								<f:selectItems value="#{sems001Bean.companyList}"/>								
							</h:selectOneMenu>
							<h:message for="ddlCompany" styleClass="ms7red" />
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:selectOneMenu id="ddlReqType" value="#{sems001Bean.searchCriteria.reqType}" >
								<f:selectItems value="#{sems001Bean.reqTypeList}"/>
							</h:selectOneMenu>
							<rich:spacer width="50" />
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:inputText id="txtTitle" value="#{sems001Bean.searchCriteria.title}" />
							<rich:spacer width="5"/>
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:inputText id="txtContractNo" value="#{sems001Bean.searchCriteria.contractNo}" />
							<rich:spacer width="50" />
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.siteApproveStatus']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:selectOneMenu id="ddlSiteApproveStatus" value="#{sems001Bean.searchCriteria.siteApproveStatus}" >
								<f:selectItems value="#{sems001Bean.siteApproveStatusList}"/>								
							</h:selectOneMenu>
							<rich:spacer width="5"/>
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:inputText id="txtLocationId" value="#{sems001Bean.searchCriteria.locationId}" />
							<rich:spacer width="50"/>
							<h:panelGroup><div align="right">
								<h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
							</div></h:panelGroup>
							<h:inputText id="txtLocationName" value="#{sems001Bean.searchCriteria.locationName}" />
							<rich:spacer width="5" />
							<h:panelGroup>
								<div align="right">
									<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
								</div>
							</h:panelGroup>
							<h:selectOneMenu id="ddlRegion" value="#{sems001Bean.searchCriteria.region}" >
								<f:selectItems value="#{sems001Bean.regionList}"/>
							</h:selectOneMenu>
						</h:panelGrid>
						<!-- end content criteria -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<h:panelGrid columns="3" id="grdSearchCommand">
					<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
						action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult" >
						<a4j:actionparam name="navModule" value="si" />
							<a4j:actionparam name="navProgram" value="SEMS001" />
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMS001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
					</a4j:commandButton>
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.new']}" styleClass="rich-button" >							
					</a4j:commandButton>
					<a4j:commandButton id="btnExport" value="#{jspMsg['btn.export']}" styleClass="rich-button" >							
					</a4j:commandButton>
				</h:panelGrid--%>
				<!-- end content button -->
		
				<h:panelGrid width="1000" >
					<rich:simpleTogglePanel switchType="client" label="#{jspMsg['header.resultTable.name']}" width="100%" opened="disable" >
						<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{sems001Action.doSearch}" reRender="frmError,pnlSearchResult" />
						<rich:panel id="pnlSearchResult" >
							<%--f:facet name="header"><h:outputText value="#{jspMsg['header.resultTable.name']}"/></f:facet--%>
							<!-- begin dataTable -->
							<rich:dataTable width="95%" id="dtbTransPayment" cellpadding="1" cellspacing="0" border="0"
									var="transPayment" value="#{sems001Bean.transPayments}" reRender="dtbTransPayment" 
									rows="#{sems001Bean.rowPerPage}" onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
									onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
									styleClass="contentform">
									<rich:column styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.rowId)?'onClick':'unClick'}">
										<f:facet name="header">
											<h:selectBooleanCheckbox value="#{sems001Bean.chkSelAll}" style="width: 20px">
												<a4j:support event="onclick" action="#{sems001Action.selectAllRow}" reRender="dtbTransPayment"/>
											</h:selectBooleanCheckbox>
										</f:facet>
										<div align="center">
											<h:selectBooleanCheckbox id="siteApproveSelected" value="#{transPayment.selected}"/>
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="Delete" styleClass="contentform" />
										</f:facet>
										<div align="center">
			            					<a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15">
												<%--a4j:actionparam name="navModule" value="gm" />
				            					<a4j:actionparam name="navProgram" value="SEMMCT001" />	
												<a4j:actionparam name="moduleWithNavi" value="gm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMCT001" />
												<a4j:actionparam name="methodWithNavi" value="initDelete" />
												<a4j:actionparam name="rowId" value="#{transPayment.rowId}"/--%>
			            					</a4j:commandButton>          							
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.transPaymentId']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.transPaymentId}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.company']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.company}" styleClass="contentform" />
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.expenseType']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.expenseType}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.paymentDt']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.paymentDt}" styleClass="contentform" >
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
											</h:outputText>
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.paymentBatchNo']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.paymentBatchNo}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.paymentGroupNo']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.paymentGroupNo}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.paymentDocNo']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.paymentDocNo}" styleClass="contentform"  />
										</div>
									</rich:column>		
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.payeeName']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{transPayment.payeeName}" styleClass="contentform"  />
										</div>
									</rich:column>	
									<f:facet name="footer">
										<rich:datascroller immediate="true" rendered="true" align="center" for="dtbTransPayment" 
											maxPages="10" id="dstSiteApprove" selectedStyleClass="selectScroll" />
									</f:facet>
								</rich:dataTable>
							<!-- end dataTable -->
							
							<a4j:commandButton id="btnSendToSAP" value="Approve" styleClass="rich-button"
								action="#{sems001Action.doSendToSAP}" reRender="frmError,pnlSearchResult" disabled="true" />
						</rich:panel>
					</rich:simpleTogglePanel>
					
				</h:panelGrid>		
				<!-- end content layout data grid -->				
				
				<!-- For test -->
				<rich:simpleTogglePanel switchType="client" label="List File" width="100%" opened="disable" >
					<rich:panel id="pnlListFileSAP" >
						<!--<f:facet name="header"><h:outputText value="List File"/></f:facet>-->
						
						<h:outputText value="SAP Path"/>
						<h:inputText id="txtSapPath" value="#{sems001Bean.sapPath}" style="width: 300px"/>
						<a4j:commandButton id="btnSetSapPath" value="Set SAP Path" styleClass="rich-button" 
							action="#{sems001Action.setSapPath}" reRender="frmError,pnlListFileSAP" />
						<h:selectOneMenu id="ddlSapFile">						
							<f:selectItems value="#{sems001Bean.listFileSAP}"/>								
						</h:selectOneMenu>
						<br></br>
						<h:outputText value="SEM Path"/>
						<h:inputText id="txtSemPath" value="#{sems001Bean.semPath}" style="width: 300px"/>
						<a4j:commandButton id="btnSetSemPath" value="Set SEM Path" styleClass="rich-button" 
							action="#{sems001Action.setSemPath}" reRender="frmError,pnlListFileSAP" />
						<h:selectOneMenu id="ddlSemFile">						
							<f:selectItems value="#{sems001Bean.listFileSEM}"/>								
						</h:selectOneMenu> 
						
						<br></br>
						<h:selectOneMenu id="ddlSsoXmlList" value="#{sems001Bean.ssoXmlSelected}">						
							<f:selectItems value="#{sems001Bean.ssoXmlList}"/>								
						</h:selectOneMenu> 
						<h:commandButton id="btnShowSSOXML" value="Show SSO XML" styleClass="rich-button" 
							onclick="openSSOXml(this.form.name,'#{sems001Bean.userLogin}'); return false;" />						
						
					</rich:panel>
				</rich:simpleTogglePanel>
				
				
				
				<rich:simpleTogglePanel switchType="client" label="Execute" width="100%" opened="disable" >
					<rich:panel id="pnlExecuteCommand" >
						<br/><br/>
						<h:inputText id="txtCommand" value="#{sems001Bean.command}" style="width: 500px"/>
						<a4j:commandButton id="btnExecCmd" value="Exec" styleClass="rich-button" 
							action="#{sems001Action.exec}" reRender="frmError,pnlExecuteCommand,commandOutput" />					
						<br/>
						<font color="blue"><b><h:outputText value="Output: " /></b></font>
						<br/>
						<h:inputTextarea rows="10" style="width: 95%" value="#{sems001Bean.commandOutput}" />
						<br/>
						
						<font color="red"><b><h:outputText value="Error: " /></b></font>
						<br/>					
						<h:inputTextarea rows="10" style="width: 95%" value="#{sems001Bean.commandError}" />
						
					</rich:panel>
				</rich:simpleTogglePanel>
				
				
				
				<rich:simpleTogglePanel switchType="client" label="Sync Session SSO" width="100%" opened="disable" >
					<rich:panel id="pnlSyncSessionSSO" >
						<br/><br/>
						<h:inputText id="txtToken" value="#{sems001Bean.token}" style="width: 500px"/>
						<a4j:commandButton id="btnSyncSession" value="Sync Session" styleClass="rich-button" 
							action="#{sems001Action.syncSessionSSO}" reRender="frmError,pnlSyncSessionSSO,dtbSyncMsg" />					
						<br/>
						<font color="red"><b><h:outputText value="Error: " /></b></font><br/>
						<h:inputTextarea rows="5" style="width: 50%" readonly="true" value="#{sems001Bean.commandError}" />
						
						<br/>
						<rich:dataTable width="95%" id="dtbSyncMsg" cellpadding="1" cellspacing="0" border="0"
							var="msgSso" value="#{sems001Bean.syncSsoMsg}" reRender="dtbSyncMsg" 
							rows="20" onRowMouseOver="this.style.backgroundColor='#FFE4E1'" styleClass="contentform"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" >	
													
							<rich:column>
								<f:facet name="header">
									<h:outputText value="errorCode" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{msgSso.errorCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="errorMesg" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{msgSso.errorMesg}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="serviceName" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{msgSso.serviceName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="serviceType" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{msgSso.serviceType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="type" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{msgSso.type}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="flag" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{msgSso.flag}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSyncMsg" 
									maxPages="10" id="dstSyncMsg" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</rich:simpleTogglePanel>				
				
				<rich:simpleTogglePanel switchType="client" label="Test Component" width="100%" opened="disable" >
					<rich:panel id="pnlTestComponent" >
						<!--<h:outputLabel id="msgTestComponent" value="#{sems001Bean.commandError}" style="color:red" escape="true"/>-->
						<font color="red"><b><h:outputText value="Error: " /></b></font><br/>
						<h:inputTextarea rows="5" style="width: 50%" readonly="true" value="#{sems001Bean.commandError}" />
						
						<br/>
						ProgramCode: <h:inputText id="txtProgramCode" value="#{sems001Bean.programCode}" style="width: 250px" autocomplete="true"/><br/>
						ComponentCode: <h:inputText id="txtComponentCode" value="#{sems001Bean.componentCode}" style="width: 250px" autocomplete="true"/><br/>
						<a4j:commandButton id="btnLoadCompCodes" value="Load Component Codes" styleClass="rich-button" 
							action="#{sems001Action.loadComponents}" reRender="frmError,pnlTestComponent,msgTestComponent,dtbCompCodes" />					
						<br/>
						
						<rich:dataTable width="95%" id="dtbCompCodes" cellpadding="1" cellspacing="0" border="0"
							var="compCode" value="#{sems001Bean.compCodes}" reRender="dtbCompCodes" 
							rows="20" onRowMouseOver="this.style.backgroundColor='#FFE4E1'" styleClass="contentform"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" >	
													
							<rich:column>
								<f:facet name="header">
									<h:outputText value="compCode" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{compCode.compCode}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="compDesc" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{compCode.compDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="visible" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{compCode.visible}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="enable" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{compCode.enable}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="edit" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{compCode.edit}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbCompCodes" 
									maxPages="10" id="dstCompCodes" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						
						<br/>
					</rich:panel>
				</rich:simpleTogglePanel>
				
				
				<rich:simpleTogglePanel switchType="client" label="Logon by Serialize" width="30%" opened="disable" >
					<rich:panel id="pnlLogonComponent" >
						<font color="red"><b><h:outputText value="Error: " /></b></font><br/>
						
						<rich:dataTable width="95%" id="dtbSerialize" cellpadding="1" cellspacing="0" border="0"
							var="file" value="#{sems001Bean.xmlSerialize}" reRender="dtbSerialize" 
							rows="20" onRowMouseOver="this.style.backgroundColor='#FFE4E1'" styleClass="contentform"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" >	
							<rich:column>
								<f:facet name="header">
									<h:outputText value="UserName" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{file[0]}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="FileName" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{file[1]}" styleClass="contentform"  />
								</div>
							</rich:column>							
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSerialize" 
									maxPages="10" id="dstSerialize" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						
						<br/>
					</rich:panel>
				</rich:simpleTogglePanel>
			</a4j:form>
		</h:panelGrid>
	</rich:panel>	
</h:panelGrid>

<a4j:status onstart="#{rich:component('mdpWait')}.show(); doTimer()"
	onstop="pageOnLoad(); doClearTimer(); #{rich:component('mdpWait')}.hide()" />
<rich:modalPanel id="mdpWait" autosized="true" width="180" height="70" 
	moveable="false" resizeable="false">
	<f:facet name="header">
		<h:outputText value="Processing" />
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<h:graphicImage value="../../images/ico_close.png"
				id="gpiHidePopUpProgress" style="cursor:pointer" />
			<rich:componentControl for="mdpWait" attachTo="gpiHidePopUpProgress"
				operation="hide" event="onclick" />
		</h:panelGroup>
	</f:facet>

	<div align="center"><h:outputText styleClass="contentlabelform"
		value="Wait Please..." /> <br>
	</div>
</rich:modalPanel>

</f:view>
