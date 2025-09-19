<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.report.semrel001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages globalOnly="true" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green"/>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%" border="0">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						
						<h:panelGrid id="pnlGridSearchCriteria" border="0" 
									 cellpadding="1" cellspacing="1"
									 width="95%" >
							<h:panelGroup>
								<table id="dtbSearchCriteria" border="0" 
									   cellpadding="2" cellspacing="2" 
									   width="100%" >
									<tr>
						               	<td align="right" width="25%" valign="bottom">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="5%" valign="bottom">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlCompany" value="#{semrel001Bean.company}" styleClass="ms7" 
											style="width:250px;">
												<f:selectItems value="#{semrel001Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td align="right" valign="bottom">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
		                				</td>					             		
					             		<td align="left" valign="bottom">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlRegion" value="#{semrel001Bean.region}" styleClass="ms7" 
											style="width:250px;">
												<f:selectItems value="#{semrel001Bean.regionList}"/>
											</h:selectOneMenu>
					               		</td>
									</tr>
									
									<tr>
						               	<td align="right" valign="bottom">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" valign="bottom">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlElectricUseType" value="#{semrel001Bean.electricUseType}" 
											styleClass="ms7" style="width:250px;">
												<f:selectItems value="#{semrel001Bean.electricUseTypeList}"/>
											</h:selectOneMenu>
					               		</td>
					               			<td align="right" valign="bottom">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.warrantType']}" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" valign="bottom">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlWarrantType" value="#{semrel001Bean.warrantType}" styleClass="ms7" 
											style="width:250px;">
												<f:selectItems value="#{semrel001Bean.warrantTypeList}"/>
											</h:selectOneMenu>
					               		</td>
									</tr>
									
									<tr>
						               	<td align="right" valign="bottom">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.meterData']}" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" valign="bottom">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlMeterData" value="#{semrel001Bean.meterData}" styleClass="ms7" 
											style="width:250px;">
												<f:selectItems value="#{semrel001Bean.meterDataList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td align="right" valign="bottom">
						               		<h:graphicImage value="images/icon_required.gif" 
						               		rendered="flase"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.onServiceDt']}" styleClass="ms7"/>
		                				</td>					             		
					             		<td align="left" valign="bottom">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlOnService" value="#{semrel001Bean.onService}" styleClass="ms7" 
											style="width:250px;">
												<f:selectItems value="#{semrel001Bean.onServiceList}"/>
											</h:selectOneMenu>
					               		</td>
									</tr>
									<tr>
										<td valign="top" align="right"><h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.numMonth']}" styleClass="ms7"/></td>
										<td colspan="3" valign="top">
										<h:panelGroup>
											<h:panelGrid columns="2"> 
												<h:panelGrid columns="4"> 
													<h:selectOneRadio id="rdo" layout="pageDirection" styleClass="ms7" value="#{semrel001Bean.numMonthType}">
														<f:selectItem itemValue="M" itemLabel="#{jspMsg['label.byMonth']}" />
														<f:selectItem itemValue="P" itemLabel="#{jspMsg['label.byPeriod']}" />
													</h:selectOneRadio>
												</h:panelGrid>
												<h:panelGrid columns="4">
													<h:selectOneMenu id="ddlMonth" value="#{semrel001Bean.month}" styleClass="ms7" 
													style="width:150px;">
														<f:selectItems value="#{semrel001Bean.monthList}"/>
													</h:selectOneMenu>
													<rich:spacer width="5px"></rich:spacer>
													<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
													<h:selectOneMenu id="ddlYear2" value="#{semrel001Bean.year}" styleClass="ms7" style="width:150px;">
														<f:selectItems value="#{semrel001Bean.yearList}"/>
													</h:selectOneMenu>
													<h:selectOneMenu id="ddlPeriod2" value="#{semrel001Bean.period}" styleClass="ms7" style="width:150px;">
														<f:selectItems value="#{semrel001Bean.periodList}"/>
													</h:selectOneMenu>
												</h:panelGrid>
											</h:panelGrid>
										</h:panelGroup>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.runReport']}" 
											   action="#{navAction.navi}">
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMREL001-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMREL001" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" 
								rendered="#{semrel001Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" 
											  >
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMREL001-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMREL001" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrel001Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrel001Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
