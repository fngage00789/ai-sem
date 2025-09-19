<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.el.semmel006" var="jspMsgElGrpMeter" />

<rich:modalPanel id="popupRecentGrpMeter" width="800" autosized="true" minWidth="800" height="600">
	<f:facet name="header">
		<h:outputText value="#{jspMsgElGrpMeter['header.popup.recentGrpMeter']}" />
	</f:facet>
	
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidePopupRecentGrpMeter" style="cursor:pointer" /> 
				<rich:componentControl for="popupRecentGrpMeter" attachTo="hidePopupRecentGrpMeter" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
		
	<h:panelGrid>
		<a4j:form id="frmErrorPopupRecentGrpMeter">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
		</a4j:form>
	</h:panelGrid>
	
	<a4j:form id="frmPopupRecentGrpMeter">
		<h:panelGrid width="100%">
					<rich:panel id="pnlRecentGrpMeter" 
						style="height:400px;width:1000px;overflow:auto;padding-bottom:0px;padding-left:0px;padding-right:0px;padding-top:0px;">

							<!-- begin dataTable -->
							<rich:dataTable id="dtbRecentGrpMeter" width="95%"
								var="RecentGrpMeter"
								value="#{semmel006Bean.elGroupSPList}"
								rowKeyVar="rowIndex"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform">
								<!-- begin column -->
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.contractNo']}"/>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.contractNo}" /></div>
								</rich:column>
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.siteName']}"/>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.siteName}" /></div>
								</rich:column>
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.region']}"/>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.region}" /></div>
								</rich:column>

								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.locationCode']}" >
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText	value="#{RecentGrpMeter.locationCode}">						
										</h:outputText>
									</div> 
								</rich:column>
								
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.periodDt']}" >
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText	value="#{RecentGrpMeter.periodDt}">		
										<f:convertDateTime pattern="MM/yyyy" locale="th"/>				
										</h:outputText>
									</div> 
								</rich:column>

								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.paymentDtFrom']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.paymentDtFrom}" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.paymentDtTo']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.paymentDtTo}" >
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
									</h:outputText>
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.Kwh']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.kwh}" />
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.unit']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.unit}" />
									</div>
								</rich:column>
								
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsgElGrpMeter['column.header.amt']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText value="#{RecentGrpMeter.amt}" />
									</div>
								</rich:column>
								<!-- end column -->
								<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel006Bean.elGroupSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="8">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRecentGrpMeter"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRecentGrpMeter" 
											style="background-color: #cccccc;"
											page="#{semmel006Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							</rich:dataTable>
							
							<!-- end dataTable -->
					</rich:panel>
					<table width="95%">
								<tr>
									<td>
										<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
											<rich:componentControl for="popupRecentGrpMeter" operation="hide" event="onclick" />
										</a4j:commandButton>
									</td>
								</tr>
							
					</table>
			</h:panelGrid>
		</a4j:form>
</rich:modalPanel>
		
	