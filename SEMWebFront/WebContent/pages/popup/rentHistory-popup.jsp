<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.popup.rentHistory" var="jspMsgRentHistory" />
<rich:modalPanel id="popupRentHistory" height="600" width="800" resizeable="false" moveable="false" >
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgRentHistory['header.label.rentHistoryPopup']}" ></h:outputText>
		</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="/images/ico_close.png"
				id="hidePopupRentHistory" style="cursor:pointer" /> 
				<rich:componentControl for="popupRentHistory" attachTo="hidePopupRentHistory" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
<a4j:form id="frmPopupRentHistory">	
	<h:panelGrid id="pnlResultRentHistory" width="95%">
					<h:panelGroup rendered="true">
					<rich:panel  rendered="true" style="width:100%" >
					<f:facet name="header">
						<h:outputText value="#{jspMsgRentHistory['header.label.rentHistory']}"/>
					</f:facet>
					<!-- datatable -->
					<rich:dataTable id="dtbRentHistory" width="95%"  cellpadding="1" cellspacing="0" border="0"
						align="center" var="rentHistory"  value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentHistorySPList}" reRender="dtbRentHistory" 
						rows="10"	rowClasses="cur" styleClass="dataTable">
						<a4j:support event="onRowClick"   reRender="dtbRentHistory">
							<a4j:actionparam name="rowId" value="" />
						</a4j:support>
						<rich:column >
							<f:facet name="header" >
								<h:outputText value="#{jspMsgRentHistory['column.header.effDate']}" styleClass="contentform" style="width:60px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentHistory.effDt}" styleClass="contentform" style="width:60px">
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
								</h:outputText>
							</div>
						</rich:column>
						
						<rich:column >
							<f:facet name="header" >
								<h:outputText value="#{jspMsgRentHistory['column.header.expDate']}" styleClass="contentform" style="width:60px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentHistory.expDt}" styleClass="contentform" style="width:60px" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en"/>
								</h:outputText>
							</div>
						</rich:column>
						
						<rich:column>
							<f:facet name="header" >
								<h:outputText value="#{jspMsgRentHistory['column.header.rentAmt']}" styleClass="contentform" style="width:50px"/>
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentHistory.rentalAmt}" styleClass="contentform" style="width:50px" >
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
							</div>
						</rich:column>
						
						<rich:column >
							<f:facet name="header" >
								<h:outputText value="#{jspMsgRentHistory['column.header.serviceAmt']}" styleClass="contentform" style="width:50px"/>
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentHistory.serviceAmt}" styleClass="contentform"  style="width:50px" >
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
							</div>
						</rich:column>
						
						<rich:column>
							<f:facet name="header" >
								<h:outputText value="#{jspMsgRentHistory['column.header.total']}" styleClass="contentform" style="width:50px" />
							</f:facet>
							<div align="right">
								<h:outputText value="#{rentHistory.total}" styleClass="contentform" style="width:50px">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
							</div>
						</rich:column>
						
						<rich:column>
							<f:facet name="header" >
								<h:outputText value="#{jspMsgRentHistory['column.header.percentIncrease']}" styleClass="contentform" style="width:50px"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{rentHistory.percent}" styleClass="contentform" style="width:50px" />
							</div>
						</rich:column>
						
						
						<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="3">
									<h:outputFormat value="#{msg['message.totalRecords']}">
										<f:param value="#{fn:length(popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentHistorySPList)}"></f:param>
									</h:outputFormat>
								</rich:column>
								<rich:column colspan="13">
									<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCondDetail"
										selectedStyleClass="selectScroll"
										stepControls="hide" fastControls="auto" boundaryControls="auto" 
										id="dstRentCondDetail" 
										style="background-color: #cccccc;"
									/>
								</rich:column>
							</rich:columnGroup>
						</f:facet>
					</rich:dataTable>
					</rich:panel>
					<table width="95%">
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsgRentHistory['label.allContract']} : " styleClass="ms7"></h:outputText>
								<rich:spacer width="2px"></rich:spacer>
								<h:inputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.percentTotal}" size="6" disabled="true"/>
								<rich:spacer width="2px"></rich:spacer>
								<h:outputText value="#{jspMsgRentHistory['label.percent']}" styleClass="ms7"></h:outputText>
							</td>
						</tr>
						<tr>
							<td>
								<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
									<rich:componentControl for="popupRentHistory" operation="hide" event="onclick" />
								</a4j:commandButton>
							</td>
						</tr>
							
					</table>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
</rich:modalPanel>