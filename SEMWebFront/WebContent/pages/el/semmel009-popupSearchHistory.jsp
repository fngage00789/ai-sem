<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>

<f:loadBundle basename="resources.el.semmel009" var="jspMsg"/>
<rich:modalPanel id="popupSearchHistory" width="350" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.resultHistory']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupSearchHistory" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchHistory" attachTo="hidepopupSearchHistory" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		
	<a4j:form id="frmResultHistory">
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlSearchResultHistory" styleClass="contentform">
						<f:facet name="header">
							<h:outputText value="#{semmel009Bean.headerSearchResult}" style="width: 1000;" />
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbPaymentHistory" width="95%" cellpadding="1"
							cellspacing="0" border="0" var="paymentHistory" value="#{semmel009Bean.popupList}" reRender="dtbPaymentHistory"
							rows="#{semmel009Bean.rowPerPage}" rowClasses="cur"	styleClass="dataTable" rowKeyVar="rowIndex">
							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}"/>
								</f:facet>
								<div align="center">
								<h:outputText value="#{paymentHistory.contractNo}" 
								 style="width : 100px" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" 
									/>
								</f:facet>
								<div align="center">
								<h:outputText value="#{paymentHistory.siteName}" 
								 style="width : 100px" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}"	
									/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.region.rowId}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationCode']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.locationCode}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterId']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.meterId}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.term.of.payment.dt']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.termOfPaymentDtDisplay}" 
								style="width : 100px" >
								<f:convertDateTime pattern="dd/MM/yyyy"/>
								</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.fromTermOfPaymentDt']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.termOfPaymentDtFromDisplay}" 
								style="width : 100px" >
								<f:convertDateTime pattern="dd/MM/yyyy"/>
								</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.toTermOfPaymentDt']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.termOfPaymentDtToDisplay}" 
								style="width : 100px" >
								<f:convertDateTime pattern="dd/MM/yyyy"/>
								</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.kwh']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.kwhTotal}" 
								style="width : 100px" >
								<f:convertNumber pattern="#,##0"/>
								</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.unit']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.unit}" 
								style="width : 100px" >
								<f:convertNumber pattern="#,##0.00"/>
								</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodAmt']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{paymentHistory.amount}" 
								style="width : 100px" >
								<f:convertNumber pattern="#,##0.00"/>
								</h:outputText>
								</div>
							</rich:column>
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel009Bean.popupList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="8">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPaymentHistory"
											maxPages= "#{semmel009Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstdtboutstanding"
											style="background-color: #cccccc;"
											page="#{semmel009Bean.scrollerPage}"
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
			<!-- End Search Result -->
</rich:modalPanel>

