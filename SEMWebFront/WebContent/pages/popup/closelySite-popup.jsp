<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.popup.closelySite" var="jspMsgClosely" />
<rich:modalPanel id="popupCloselySite" height="550" width="700" autosized="true" resizeable="false">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgClosely['header.label.closelySite']}" ></h:outputText>
		</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="/images/ico_close.png"
				id="hidePopupCloselySite" style="cursor:pointer" /> 
				<rich:componentControl for="popupCloselySite" attachTo="hidePopupCloselySite" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
<a4j:form id="frmPopupCloselySite">	
<h:panelGrid width="100%" id="grdPopupCloselySite">
	<h:panelGroup >
		<rich:panel  style="width:800px; overflow:auto;">
			<f:facet name="header">
				<h:outputText value="#{jspMsgClosely['header.label.closelySiteDetail']}" style="width:1200px"/>
			</f:facet>
		<rich:dataTable id="dtbCloselySite" cellpadding="1" cellspacing="0" border="0" var="closelySite" value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.closelySiteList}" align="center"
						rows="" rowClasses="cur" styleClass="dataTable"><!--
							<!-- begin column -->
							
							<rich:column width="80" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.contractNo']}" style="width: 80" />
								</f:facet>
								<div align="center">
								<h:outputText value= "#{closelySite.contractNo}" style="width: 80" />
								</div>
							</rich:column>
							
							<rich:column width="80" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.oldContractNo']}"
										style="width: 80" />
								</f:facet>
								<div align="center">
								<h:outputText value= "#{closelySite.oldContractNo}" style="width: 80" />
								</div>
							</rich:column>
							
							<rich:column width="120" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.effDt']}"
										style="width: 120" />
								</f:facet>
								<div align="center">
								<h:outputText value= "#{closelySite.effDateStr}" style="width: 120" >
								</h:outputText>
								</div>
							</rich:column>
							
							<rich:column width="120" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.expDt']}"
										style="width: 120" />
								</f:facet>
								<div align="center">
								<h:outputText value= "#{closelySite.expDateStr}" style="width: 120" >
								</h:outputText>
								</div>
							</rich:column>
							
							<rich:column width="200" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.address']}"
										style="width: 200" />
								</f:facet>
								<div align="left">
								<h:outputText value= "#{closelySite.address}" style="width: 200" />
								</div>
							</rich:column>
							
							<rich:column  width="100" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.type']}"
										style="width: 100" />
								</f:facet>
								<div align="left">
								<h:outputText value= "#{closelySite.placeType}" style="width: 100" />
								</div>
							</rich:column>
							<rich:column width="80" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.rentAmt']}"
										style="width: 80" />
								</f:facet>
								<div align="right">
								<h:outputText value= "#{closelySite.rtAmountPerYer}" style="width: 80" >
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
								
								</div>
							</rich:column>
							<rich:column width="80" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.serviceAmt']}"
										style="width: 80" />
								</f:facet>
								<div align="right">
								<h:outputText value= "#{closelySite.svAmountPerYer}" style="width: 80" >
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
								</div>
							</rich:column>
							<rich:column  width="80" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.averageRentAmt']}"
										style="width: 80" />
								</f:facet>
								<div align="right">
								<h:outputText value= "#{closelySite.rtAmountCenter}" style="width: 80" >
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
								</div>
							</rich:column>
							<rich:column width="90" rendered="true">
								<f:facet name="header">
									<h:outputText value= "#{jspMsgClosely['column.averageServiceAmt']}"
										style="width: 90" />
								</f:facet>
								<div align="right">
									<h:outputText value= "#{closelySite.svAmountCenter}" style="width: 90" >
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
								</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
							<rich:columnGroup>
								<rich:column colspan="3">
									<h:outputFormat value="#{msg['message.totalRecords']}">
										<f:param value="#{fn:length(popupViewSiteInfoBean.popupViewSiteInfoSearchSP.closelySiteList)}"></f:param>
									</h:outputFormat>
								</rich:column>
								<rich:column colspan="7">
									<rich:datascroller immediate="true" rendered="true" align="left" for="dtbCloselySite"
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
						</br>
						
						<table width="100%">
							<tr>
								<td>
									<h:outputText value= "*#{jspMsgClosely['label.noteText']}" styleClass="ms7" style="color: red" />
								</td>
							</tr>
							<tr>
								<td align="left" colspan="8">
									<h:commandButton id="btnExport" value="Export" styleClass="rich-button" 
									action="#{popupViewSiteInfoAction.exportExcel}" >
									</h:commandButton>
									<rich:spacer width="5"></rich:spacer>
									<a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
										<rich:componentControl for="popupCloselySite" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
				<!-- ShowReport Panel -->
				<h:panelGrid id="show_report" style="height:50px;width:50px;" width="0" columns="0">
					<h:panelGroup id="show_report_in" rendered="#{semmsi001Bean.displayBtn}" style="height:50px;width:50px;" >							
						<script type="text/javascript">
							var ctrl = document.getElementById('incContent:frmSearch:btnSearch');
							ctrl.click();
						</script>
					</h:panelGroup>							
				</h:panelGrid>
				<!-- End Code -->
				</a4j:form>
</rich:modalPanel>