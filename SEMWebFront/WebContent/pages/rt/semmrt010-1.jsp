<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<f:loadBundle basename="resources.rental.semmrt010" var="jspMsg" />
<h:panelGrid columnClasses="gridContent" width="100%">
	<a4j:form id="frmResult">
		<!-- begin content layout data grid -->
		<h:panelGrid style="width: 100%">
			<rich:panel id="pnlIfrsToDoList" styleClass="sem_autoScrollbar">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.resultTable.name']}"
						style="width: 1500" />
				</f:facet>
				<!-- begin dataTable -->
				<rich:dataTable id="dtbIfrsInterface" cellpadding="1"
					cellspacing="0" border="0" var="ifrsInterface"
					value="#{semmrt010Bean.resultList}" reRender="dtbIfrsInterface"
					rows="#{semmrt010Bean.rowPerPage}" rowClasses="cur"
					styleClass="contentform">
					<!-- begin column -->
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.referenceId)?'onClick':'unClick'}">
						<f:facet name="header">
							<a4j:region>
								<h:selectBooleanCheckbox value="#{semmrt010Bean.chkSelAll}"
									style="width: 20">
									<a4j:support event="onclick"
										action="#{semmrt010Action.selectAllRow}"
										reRender="dtbIfrsInterface" />
								</h:selectBooleanCheckbox>
							</a4j:region>
						</f:facet>
						<div align="center"><a4j:region>
							<h:selectBooleanCheckbox id="ifrsInterfaceSelected"
								value="#{ifrsInterface.checkBox}">
								<a4j:actionparam name="checkBox"
									value="#{ifrsInterface.checkBox}" />
								<a4j:support event="onclick"
									action="#{semmrt010Action.selectRow}"
									reRender="dtbIfrsInterface" />
							</h:selectBooleanCheckbox>
						</a4j:region></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.contractNo)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.contractNo}"
						title="#{ifrsInterface.dataObj.contractNo}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.contractNo']}"
								style="width: 60" />
						</f:facet>
						<div align="left"><h:outputText
							value="#{ifrsInterface.dataObj.contractNo}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.activity)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.activity}"
						title="#{ifrsInterface.dataObj.activity}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.activity']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.activity}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.companyCode1)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.companyCode1}"
						title="#{ifrsInterface.dataObj.companyCode1}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.companyCode1']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.companyCode1}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.sapRefxNo)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.sapRefxNo}"
						title="#{ifrsInterface.dataObj.sapRefxNo}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.refxNo']}"
								style="width: 60" />
						</f:facet>
						<div align="left"><h:outputText
							value="#{ifrsInterface.dataObj.sapRefxNo}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.sapStatusCode)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.sapStatusCode}"
						title="#{ifrsInterface.dataObj.sapStatusCode}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.statusCode']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.sapStatusCode}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.sapStatusMessage)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.sapStatusMessage}"
						title="#{ifrsInterface.dataObj.sapStatusMessage}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.statusMessage']}"
								style="width: 180" />
						</f:facet>
						<div align="left"><h:outputText
							value="#{ifrsInterface.dataObj.sapStatusMessage}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.contractType)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.contractType}"
						title="#{ifrsInterface.dataObj.contractType}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.contractType']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.contractType}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.conditionPurpose1)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.conditionPurpose1}"
						title="#{ifrsInterface.dataObj.conditionPurpose1}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsg['column.header.conditionPurpose1']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><a4j:commandLink
							value="#{ifrsInterface.dataObj.conditionPurpose1}"
							action="#{navAction.navi}" reRender="oppContent" rendered="true"
							id="hypSaveDetail">
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT010-2" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
							<a4j:actionparam name="methodWithNavi" value="ToDoListDetail" />
							<a4j:actionparam name="backPage" value="SEMMRT010-1" />
							<a4j:actionparam name="referenceId"
								value="#{ifrsInterface.dataObj.referenceId}" />
						</a4j:commandLink></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.dateFromCondition)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.dateFromCondition}"
						title="#{ifrsInterface.dataObj.dateFromCondition}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsg['column.header.dateFromCondition']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.dateFromCondition}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.dateUpToCondition)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.dateUpToCondition}"
						title="#{ifrsInterface.dataObj.dateUpToCondition}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsg['column.header.dateUpToCondition']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.dateUpToCondition}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.splitCase)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.splitCase}"
						title="#{ifrsInterface.dataObj.splitCase}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.splitCase']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.splitCase}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.firstPostingFrom1)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.firstPostingFrom1}"
						title="#{ifrsInterface.dataObj.firstPostingFrom1}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsg['column.header.firstPostingFrom1']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.firstPostingFrom1}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.dateFirstContractEnd)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.dateFirstContractEnd}"
						title="#{ifrsInterface.dataObj.dateFirstContractEnd}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsg['column.header.dateFirstContractEnd']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.dateFirstContractEnd}" /></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.currencyUnitPrice)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.currencyUnitPrice}"
						title="#{ifrsInterface.dataObj.currencyUnitPrice}">
						<f:facet name="header">
							<h:outputText
								value="#{jspMsg['column.header.currencyUnitPrice']}"
								style="width: 60" />
						</f:facet>
						<div align="right"><h:outputText
							value="#{ifrsInterface.dataObj.currencyUnitPriceFormatter}">
							<f:convertNumber pattern="#,##0.00" />
						</h:outputText></div>
					</rich:column>
					<rich:column
						styleClass="#{(semmrt010Bean.tmpRowId==ifrsInterface.dataObj.updateDt)?'onClick':'unClick'}"
						sortBy="#{ifrsInterface.dataObj.updateDt}"
						title="#{ifrsInterface.dataObj.updateDt}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['column.header.updateDt']}"
								style="width: 60" />
						</f:facet>
						<div align="center"><h:outputText
							value="#{ifrsInterface.dataObj.updateDtStr}" /></div>
					</rich:column>
					<f:facet name="footer">
						<rich:columnGroup>
							<rich:column colspan="4">
								<h:outputFormat value="#{msg['message.totalRecords']}">
									<f:param value="#{fn:length(semmrt010Bean.resultList)}"></f:param>
								</h:outputFormat>
							</rich:column>
							<rich:column colspan="18">
								<rich:datascroller immediate="true" rendered="true" align="left"
									for="dtbIfrsInterface" maxPages="#{semmrt010Bean.rowPerPage}"
									selectedStyleClass="selectScroll" stepControls="hide"
									fastControls="auto" boundaryControls="auto"
									id="dstIfrsInterface" style="background-color: #cccccc;"
									page="#{semmrt010Bean.scrollerPage}" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>
				</rich:dataTable>
				<!-- end dataTable -->


				<center><h:panelGroup id="grdCommand" style="width:96%;">
					<table width="100%">
						<tr>
							<td></td>
							<td align="right" style="width: 70%"><a4j:commandButton
								id="btnResend" value="RESEND REFX" styleClass="rich-button"
								action="#{navAction.navi}" reRender="dtbIfrsInterface">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT010-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
								<a4j:actionparam name="methodWithNavi" value="doResend" />
							</a4j:commandButton></td>
							<td></td>
						</tr>
					</table>
				</h:panelGroup></center>
			</rich:panel>
		</h:panelGrid>
		<!-- end content layout data grid -->
	</a4j:form>
</h:panelGrid>