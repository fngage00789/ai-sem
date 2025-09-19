<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<f:loadBundle basename="resources.rental.semmrt010" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchVerifyRental" >
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue"
					infoClass="ms7green"
					rendered="#{semmrt001Bean.renderedMsgFormSearch}">
					<f:facet name="header">
						<h:outputText value="Entered Data Status:"></h:outputText>
					</f:facet>
					<f:facet name="errorMarker">
						<h:graphicImage value="images/error.gif" />
					</f:facet>
				</rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="50%">
					<rich:panel id="pnlSearchCriteria" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="40%" valign="baseline"><h:panelGroup>
											<!--<h:graphicImage value="images/icon_required.gif" />-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.th.company']}"
												styleClass="ms7" />
										</h:panelGroup></td>
										<td width="60%" colspan="3" valign="bottom"><a4j:region>
											<h:selectOneMenu
												value="#{semmrt010Bean.criteria.companyCode1}">
												<f:selectItems value="#{semmrt010Bean.companyList}" />
											</h:selectOneMenu>
										</a4j:region></td>
									</tr>
									<tr>
										<td align="right" width="40%" valign="baseline"><h:panelGroup>
											<!--<h:graphicImage value="images/icon_required.gif" />-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.th.region']}"
												styleClass="ms7" />
										</h:panelGroup></td>
										<td><h:inputText value="#{semmrt010Bean.criteria.region}"
											disabled="false"></h:inputText></td>
									</tr>
									<tr>
										<td align="right" valign="baseline"><h:outputText
											value="#{jspMsg['label.contractNo']}" styleClass="ms7" /></td>
										<td><h:inputText
											value="#{semmrt010Bean.criteria.contractNo}" disabled="false"></h:inputText></td>
									</tr>
									<tr>
										<td align="right" valign="baseline"><h:outputText
											value="#{jspMsg['label.refxNo']}" styleClass="ms7" /></td>
										<td><h:inputText
											value="#{semmrt010Bean.criteria.sapRefxNo}" disabled="false"></h:inputText></td>
									</tr>
									<tr>
										<td align="right" valign="baseline"><h:outputText
											value="#{jspMsg['label.postingDtFrom']}" styleClass="ms7" /></td>
										<td><rich:calendar id="cldPostingDtFrom" locale="th"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmrt010Bean.criteria.firstPostingFromFormatter}"
											showWeeksBar="false" inputSize="20"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.postingDtFrom']}"
											oninputblur="validateRichCalendarFromTo('frmSearch','cldPostingDtFrom','cldPostingDtTo');"
											oncollapse="validateRichCalendarFromTo('frmSearch','cldPostingDtFrom','cldPostingDtTo');">
										</rich:calendar> <rich:spacer width="5" /> <h:outputText
											value="#{jspMsg['label.to']}" styleClass="ms7" /> <rich:spacer
											width="5" /> <rich:calendar id="cldPostingDtTo" locale="th"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmrt010Bean.criteria.dateFirstContractEndFormatter}"
											showWeeksBar="false" inputSize="20"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.postingDtTo']}"
											oninputblur="validateRichCalendarFromTo('frmSearch','cldPostingDtTo','cldPostingDtFrom');"
											oncollapse="validateRichCalendarFromTo('frmSearch','cldPostingDtTo','cldPostingDtFrom');">
										</rich:calendar></td>
									</tr>
									<tr>
										<td align="right" valign="baseline"><h:outputText
											value="#{jspMsg['label.updateDt']}" styleClass="ms7" /></td>
										<td><rich:calendar id="cldUpdateDtFrom" locale="th"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmrt010Bean.criteria.interfaceDateFrom}"
											showWeeksBar="false" inputSize="20"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.updateDtFrom']}"
											oninputblur="validateRichCalendarFromTo('frmSearch','cldUpdateDtFrom','cldUpdateDtTo');"
											oncollapse="validateRichCalendarFromTo('frmSearch','cldUpdateDtFrom','cldUpdateDtTo');">
										</rich:calendar> <rich:spacer width="5" /> <h:outputText
											value="#{jspMsg['label.to']}" styleClass="ms7" /> <rich:spacer
											width="5" /> <rich:calendar id="cldUpdateDtTo" locale="th"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmrt010Bean.criteria.interfaceDateTo}"
											showWeeksBar="false" inputSize="20"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.updateDtTo']}"
											oninputblur="validateRichCalendarFromTo('frmSearch','cldUpdateDtTo','cldUpdateDtFrom');"
											oncollapse="validateRichCalendarFromTo('frmSearch','cldUpdateDtTo','cldUpdateDtFrom');">
										</rich:calendar></td>
									</tr>
									<tr>
										<td></td>
										<td><a4j:commandButton value="#{jspMsg['btn.search']}"
											styleClass="rich-button" action="#{navAction.navi}"
											reRender="oppContent" style="margin-right: 5px;"
											disabled="false">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT010-1" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
											<a4j:actionparam name="methodWithNavi" value="doSearch" />
										</a4j:commandButton> <a4j:commandButton value="#{jspMsg['btn.clear']}"
											styleClass="rich-button" action="#{navAction.navi}"
											reRender="oppContent" disabled="false">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT010-3" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
											<a4j:actionparam name="methodWithNavi" value="doClear" />
										</a4j:commandButton></td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					<rich:panel styleClass="sem_autoScrollbar">
						<rich:dataTable id="dtbIfrsInterface" cellpadding="1"
							cellspacing="0" border="0" var="ifrsInterface"
							value="#{semmrt010Bean.searchResultList}"
							reRender="dtbIfrsInterface" rows="#{semmrt010Bean.rowPerPage}"
							rowClasses="cur" styleClass="contentform sem_autoScrollbar">
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
									action="#{navAction.navi}" reRender="oppContent" rendered="true">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="SEMMRT010-2" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
									<a4j:actionparam name="methodWithNavi" value="ToDoListDetail" />
									<a4j:actionparam name="backPage" value="SEMMRT010-3" />
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
											<f:param value="#{fn:length(semmrt010Bean.searchResultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="18">
										<rich:datascroller immediate="true" rendered="true"
											align="left" for="dtbIfrsInterface"
											maxPages="#{semmrt010Bean.rowPerPage}"
											selectedStyleClass="selectScroll" stepControls="hide"
											fastControls="auto" boundaryControls="auto"
											id="dstIfrsInterface" style="background-color: #cccccc;"
											page="#{semmrt010Bean.scrollerPage}" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>