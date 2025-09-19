<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemulticontract-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultilocation-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />
<jsp:include page="../../pages/popup/multivendor-popup.jsp" />

<f:loadBundle basename="resources.report.semrrt024" var="jspMsg"/>
<h:panelGrid style="width:100%">

	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages globalOnly="true" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green"/>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%" border="0">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						
						<h:panelGrid id="pnlGridSearchCriteria" border="0" 
									 cellpadding="0" cellspacing="1"
									 width="90%" >
							<h:panelGroup>
								<table id="dtbSearchCriteria" border="0" 
									   cellpadding="1" cellspacing="1" 
									   width="100%" >
								<tr>
									<td align="right" width="20%" valign="baseline">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                				</td>
		                				<td align="left" width="30%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlCompany" value="#{semrrt024Bean.company}" >
												<f:selectItems value="#{semrrt024Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td align="right" width="20%" valign="baseline">
						               		<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="30%">
					             			<rich:spacer width="5px"></rich:spacer>
										<h:selectOneMenu value="#{semrrt024Bean.region}" >
											<f:selectItems value="#{semrrt024Bean.regionList}"/>
										</h:selectOneMenu>
					               		</td>
								</tr>
								
								<tr>
									<td align="right" valign="top">
									<h:outputText id="lblContractNo" value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
									</td>
									<td align="left">
									<rich:spacer width="5px"></rich:spacer>
										<h:inputTextarea id="txtContract" value="#{semrrt024Bean.contracNo}" cols="30" rows="3" />
									</td>
										<td align="right" width="10%">
											<h:outputText value="#{jspMsg['label.locationId']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" >
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtLocationId" value="#{semrrt024Bean.locationId}" />
					               		</td>
								
								</tr>
								<tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.effDt']} : " styleClass="ms7"/>	
									</td>
									<td align="left">
									<rich:spacer width="5px"></rich:spacer>
									<rich:calendar id="effDateFrom" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semrrt024Bean.startDate}"
									   showWeeksBar="false" 
									   inputSize="11" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   label = "#{jspMsg['label.effDt']}">
									   </rich:calendar>
			                	<rich:spacer width="5"/>
			                	<h:outputText id="dateTo" value="#{jspMsg['label.to']} : " styleClass="ms7" />
			                	<rich:spacer width="5"/>
			                	<rich:calendar id="effDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semrrt024Bean.startToDate}"
									   showWeeksBar="false" 
									   inputSize="11" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   label="#{jspMsg['label.to']}"
									   >
									   </rich:calendar>
									</td>
									<td align="right">
										<h:outputText value="#{jspMsg['label.endDt']} : " styleClass="ms7"/>	
									</td>
									<td align="left">
									<rich:spacer width="5px"></rich:spacer>
									<rich:calendar id="endDateFrom" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semrrt024Bean.endDate}"
									   showWeeksBar="false" 
									   inputSize="11" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   label = "#{jspMsg['label.effDt']}">
									   </rich:calendar>
			                	<rich:spacer width="5"/>
			                	<h:outputText id="dateTo2" value="#{jspMsg['label.to']} : " styleClass="ms7" />
			                	<rich:spacer width="5"/>
			                	<rich:calendar id="endDateTo" locale="th" enableManualInput="true" 
									   datePattern="dd/MM/yyyy" 
									   value="#{semrrt024Bean.endToDate}"
									   showWeeksBar="false" 
									   inputSize="11" 
									   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   cellWidth="20px" cellHeight="20px"
									   label="#{jspMsg['label.to']}">
									   </rich:calendar>
									</td>
								</tr>
								<tr>
									
									<td colspan="4">
										<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.runReport']}" 
											   action="#{navAction.navi}" >
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT024-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT024" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt024Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT024-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT024" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt024Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt024Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
									</td>
									
								</tr>
								
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
		</h:panelGrid>
		</h:panelGrid>
	</rich:panel>

</h:panelGrid>