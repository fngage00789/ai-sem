<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semrsi015" var="jspMsg"/>
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
				<h:panelGrid width="90%" border="0">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						
						<h:panelGrid id="pnlGridSearchCriteria" border="0" 
									 cellpadding="1" cellspacing="1"
									 width="90%" >
							<h:panelGroup>
								<table id="dtbSearchCriteria" border="0" 
									   cellpadding="0" cellspacing="1" 
									   width="100%" >
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlCompany" value="#{semrsi015Bean.company}" >
												<f:selectItems value="#{semrsi015Bean.companyList}"/>
											</h:selectOneMenu>
	
					               		</td>
					               		<td width="10%" align="right">
					               			<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.year']} :" styleClass="ms7"/>
					               		</td>
					               		<td width="40%">
						               		<rich:spacer width="5px"></rich:spacer>
						               		<h:inputText id="ddlYear"  value="#{semrsi015Bean.year}"  size="5"/>		
					               		</td>
									</tr>
									
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlRegion" value="#{semrsi015Bean.region}">
												<f:selectItems value="#{semrsi015Bean.regionList}"/>
											</h:selectOneMenu>
	
					               		</td>
					               		<td width="10%" align="right">
											<h:outputText value="#{jspMsg['label.month']} :" styleClass="ms7"/>
					               		</td>
					               		<td width="40%">
						               		<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlMonth" value="#{semrsi015Bean.month}" >
												<f:selectItems value="#{semrsi015Bean.monthList}"/>
											</h:selectOneMenu>		
					               		</td>
									</tr>	
									<tr>
										<td align="right">
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value = "#{jspMsg['label.siteType']}:" styleClass="ms7"/>
										</td>
										<td>
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlSiteType" value="#{semrsi015Bean.siteType}"  >
												<f:selectItems value="#{semrsi015Bean.siteTypeList}"/>
											</h:selectOneMenu>
										</td>
										<td>
										</td>
										<td>
										</td>
									
									</tr>		
									
									<tr>
						               	<td align="right" width="25%" valign="middle">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.reportType']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%" colspan="3">
					             			<rich:spacer width="5px"></rich:spacer>
					             			
											<h:selectOneRadio value="#{semrsi015Bean.reportSummaryFlag}" id="ddlReportSummary" styleClass="ms7" >
												<f:selectItem itemLabel="#{jspMsg['label.radio.summary']}" itemValue="true"/>
												<f:selectItem itemLabel="#{jspMsg['label.radio.detail']}" itemValue="false"/>
											</h:selectOneRadio>		
											
					               		</td>
<!--					               		<td width="10%" align="right">-->
<!--					               		</td>-->
<!--					               		<td width="40%">	-->
<!--					               		</td>-->
									</tr>																
									
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['label.btn.runReport']}" 
											   action="#{navAction.navi}">
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRSI015-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRSI015" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrsi015Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['label.btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRSI015-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRSI015" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrsi015Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrsi015Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
						
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
