<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.co.semmco002" var="jspMsg"/>
<rich:modalPanel id="popupEditContractStatus" width="800" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.edit']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupEditContractStatus" style="cursor:pointer"/>
				<rich:componentControl for="popupEditContractStatus" attachTo="hidePopupEditContractStatus" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<a4j:form id="popupFrmEditContractStatus"> 
				<rich:panel id="pnlContractStatusHistory">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.history']}"/>
						</f:facet>
						<rich:dataTable width="97%" id="dtbContractStatusHistory" cellpadding="1" cellspacing="0" border="0"
							var="contractStatusHistorySP" value="#{semmco002Bean.contractStatusHistoryList}" reRender="dtbContractStatusHistory" 
							rows="10" rowClasses="cur"	 styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmco002Action.getRowIdOnClick}" reRender="dtbContractStatusHistory">
								<a4j:actionparam name="rowId" value="#{contractStatusHistorySP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmco002Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnEditHistory" action="#{navAction.navi}" reRender="pnlEditContractStatus"
	            					image="images/edit.png" style="height: 15; width: 15"
	            					rendered="#{contractStatusHistorySP.lastRecord and semmco002Bean.renderedUpdateHistory}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO002-3" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO002" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateContractStatusHistory" />
										<a4j:actionparam name="rowId" value="#{contractStatusHistorySP.rowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmco002Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton id="btnDeleteHistory" oncomplete="#{rich:component('mdpConfirmDelDialogContractStatusHistory')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
     									   rendered="#{contractStatusHistorySP.lastRecord and semmco002Bean.renderedDeleteHistory}">
										<a4j:actionparam name="navModule" value="co" />
		            					<a4j:actionparam name="navProgram" value="SEMMCO002-3" />	
										<a4j:actionparam name="moduleWithNavi" value="co" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCO002" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteContractStatusHistory" />
										<a4j:actionparam name="rowId" value="#{contractStatusHistorySP.rowId}"/>
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{contractStatusHistorySP.contractStatusName}" styleClass="#{(semmco002Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatusName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractStatusHistorySP.contractStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column width="5%" sortBy="#{contractStatusHistorySP.changeStatusDate}" styleClass="#{(semmco002Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.changeStatusDate']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractStatusHistorySP.changeStatusDate}" styleClass="contentform" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractStatusHistorySP.remark}" styleClass="#{(semmco002Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractStatusHistorySP.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{contractStatusHistorySP.updateBy}" styleClass="#{(semmco002Bean.tmpRowId==contractStatusHistorySP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.updateBy']}" styleClass="contentform" style="width: 50"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractStatusHistorySP.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmco002Bean.contractStatusHistoryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractStatusHistory"
											maxPages="#{semmco002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstContractStatusHistory" 
											style="background-color: #cccccc;"
											page="#{semmco002Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
				</rich:panel>
				<rich:spacer height="5"></rich:spacer>
				<rich:panel id="pnlEditContractStatus">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.name']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco002Bean.renderedMsgFormMiddle}"/>
						</div>
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
							<td align="right" width="25%" valign="baseline">
							<h:panelGroup>
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['labe.contractStatus']}" styleClass="ms7"/>
							</h:panelGroup>
                			</td>
                			<td width="75%" colspan="3" valign="bottom">
							<h:selectOneMenu id="ddlContractStatus2" value="#{semmco002Bean.contractStatus.contractStatus}"
											 onchange="RenderDDLBorrowOfficer();">
								<f:selectItems value="#{semmco002Bean.contractStatusList}"/>
							</h:selectOneMenu>
							<a4j:jsFunction name="RenderDDLBorrowOfficer" reRender="pnlEditContractStatus"/>
		                	</td>
	                	 </tr>
								<tr>
								<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.changeStatusDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
	                				<rich:calendar id="cldChangeStatusDate2" locale="th" enableManualInput="true"  
									datePattern="dd/MM/yyyy" 
									value="#{semmco002Bean.contractStatus.changeStatusDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.changeStatusDate']}">
									</rich:calendar> 
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtRemark2" value="#{semmco002Bean.contractStatus.remark}" 
		                			cols="100" rows="3"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <h:panelGroup id="pnlGp0023Recipient" rendered="#{semmco002Bean.contractStatus.contractStatus eq '01'}">
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="ผู้รับ :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlRecipient" value="#{semmco002Bean.contract.receivePersonCode}">
										<f:selectItems value="#{semmco002Bean.borrowOfficerList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
			                	 <h:panelGroup id="pnlGp0023Organizer" rendered="#{semmco002Bean.contractStatus.contractStatus eq '01'}">
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="ผู้จัดทำ :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlOrganizer" value="#{semmco002Bean.contract.createPersonCode}">
										<f:selectItems value="#{semmco002Bean.borrowOfficerList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
			                	 
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid  id="grdPopupEditCommand">
						<h:panelGroup rendered="#{semmco002Bean.renderedAddHistory}">
								<a4j:commandButton id="btnAddContractStatusHistory" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlContractStatusHistory,pnlEditContractStatus,pnlEditContractStatus,pnlSearchResult,dtbContractStatus" 
				           		disabled="#{semmco002Bean.disabledBtnAddContractStatusHistory}">
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO002-3" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO002" />
								<a4j:actionparam name="methodWithNavi" value="doAddContractStatusHistory" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
				           		<a4j:commandButton id="btnSaveContractStatusHistory" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlContractStatusHistory,pnlEditContractStatus,pnlEditContractStatus,pnlSearchResult,dtbContractStatus" 
				           		disabled="#{semmco002Bean.disabledBtnUpdateContractStatusHistory}">
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO002-3" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO002" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateContractStatusHistory" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
			                	 <a4j:commandButton id="btnClearContractStatusHistory" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlContractStatusHistory,pnlEditContractStatus,pnlEditContractStatus" >
				           		<a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMCO002-3" />
								<a4j:actionparam name="moduleWithNavi" value="co" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCO002" />
								<a4j:actionparam name="methodWithNavi" value="doClearContractStatusHistory" />
				           		</a4j:commandButton>
				           		</h:panelGroup>
					</h:panelGrid>
						</rich:panel>
				</a4j:form>
</rich:modalPanel>

