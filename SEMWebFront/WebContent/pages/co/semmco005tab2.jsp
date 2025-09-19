<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid id="pnlTab2" width="95%">
		<rich:panel id="pnlContractFile">
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.tab.contractFile']}" />
			</f:facet>
			<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
				<h:panelGroup>
					<table width="100%">
						<tr>     
							<td align="right" width="20%">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.contractDocType']}" styleClass="ms7" />
							</td>
							<td width="80%">
								<h:selectOneMenu id="ddlContractDocType" value="#{semeco001Bean.contractDocType}">
									<f:selectItems value="#{semmco005tab2Bean.contractDocType}" />	 					
								</h:selectOneMenu>
								
								<rich:spacer width="10"></rich:spacer> 
								<a4j:commandButton id="btnPrint" styleClass="rich-button"
												   value="#{jspMsg['btn.create']}" 
												   action="#{navAction.navi}"
												   reRender="frmContract,frmContractError" >
									<a4j:actionparam name="navModule" value="co" />
									<a4j:actionparam name="navProgram" value="SEMMCO005TAB2" />
									<a4j:actionparam name="moduleWithNavi" value="report" />
									<a4j:actionparam name="actionWithNavi" value="SEMECO001" />
									<a4j:actionparam name="methodWithNavi" value="doRunReport" />
									<a4j:actionparam name="fromPage" value="SEMMCO005" />
									
									<a4j:support event="oncomplete" reRender="pnlResultContractFile" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="co" />
										<a4j:actionparam name="navProgram" value="SEMMCO005TAB2" />
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO005Tab2" />
										<a4j:actionparam name="methodWithNavi" value="doSearchContractFile" />
									</a4j:support>
								</a4j:commandButton>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>
		<rich:spacer height="10"></rich:spacer>
		<!-- panel contract status history -->
		
		<rich:panel id="pnlResultContractFile">
			<f:facet name="header">
				<h:outputText value="#{jspMsg['header.panel.contractFile']}" />
			</f:facet>
			<rich:dataTable width="97%" id="dtbContractFile" cellpadding="1"
				cellspacing="0" border="0" var="contractFileSP"
				value="#{semmco005tab2Bean.contractFileSPList}"
				rows="10" rowClasses="cur"
				styleClass="dataTable">
				<a4j:support event="onRowClick"
					action="#{semmco005tab2Action.getRowIdOnClick}"
					reRender="dtbContractFile">
					<a4j:actionparam name="rowId" value="#{contractFileSP.rowId}" />
				</a4j:support>
				<rich:column
					styleClass="#{(semmco005tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="Delete" styleClass="contentform"
							style="width: 40" />
					</f:facet>
					<div align="center"><a4j:commandButton
						id="btnDeleteContractFile"
						oncomplete="#{rich:component('mdpConfirmDelDialogContractFile')}.show(); return false"
						action="#{navAction.navi}" image="images/delete.png"
						style="height: 15; width: 15">
						<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO005TAB2" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO005Tab2" />
						<a4j:actionparam name="methodWithNavi"
							value="initDeleteContractFile" />
						<a4j:actionparam name="rowId" value="#{contractFileSP.rowId}" />
					</a4j:commandButton></div>
				</rich:column>
				<rich:column
					styleClass="#{(semmco005tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="Download" styleClass="contentform"
							style="width: 40" />
					</f:facet>
					<div align="center">
					<h:commandLink id="btnDownloadFile" 
								   value="Download" 
								   action="#{semmco005tab2Action.doDownloadContractFile}">
						<a4j:support event="oncomplete" reRender="frmContractError"/>
						<f:param name="rowId" value="#{contractFileSP.rowId}" />
					</h:commandLink></div>
				</rich:column>
				<rich:column sortBy="#{contractFileSP.contractDocTypeName}"
					styleClass="#{(semmco005tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText
							value="#{jspMsg['column.header.contractDocTypeName']}"
							styleClass="contentform" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{contractFileSP.contractDocTypeName}"
						styleClass="contentform">
					</h:outputText></div>
				</rich:column>
				<rich:column sortBy="#{contractFileSP.fileName}"
					styleClass="#{(semmco005tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.header.FileName']}"
							styleClass="contentform" />
					</f:facet>
					<div align="left"><h:outputText
						value="#{contractFileSP.fileName}" styleClass="contentform" /></div>
				</rich:column>
				<rich:column sortBy="#{contractFileSP.updateBy}"
					styleClass="#{(semmco005tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.header.updateBy2']}"
							styleClass="contentform" />
					</f:facet>
					<div align="left"><h:outputText
						value="#{contractFileSP.updateBy}" styleClass="contentform" /></div>
				</rich:column>
				<rich:column  sortBy="#{contractFileSP.updateDt}"
					styleClass="#{(semmco005tab2Bean.tmpRowId==contractFileSP.rowId)?'onClick':'unClick'}">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.header.updateDate']}"
							styleClass="contentform" />
					</f:facet>
					<div align="center"><h:outputText
						value="#{contractFileSP.updateDt}" styleClass="contentform">
						<f:convertDateTime type="date" pattern="dd/MM/yyyy hh:mm:ss" locale="en" />
					</h:outputText></div>
				</rich:column>
				<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco005tab2Bean.contractFileSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractFile"
											maxPages="#{semmco005tab2Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractFile" 
											style="background-color: #cccccc;"
											page="#{semmco005tab2Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
			</rich:dataTable>
		</rich:panel>
	</h:panelGrid>
</h:panelGrid>
