<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.report.semrrt018" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorRT018">
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
						               	<td align="right" width="25%" valign="top">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%" valign="top">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlCompany" value="#{semrrt018Bean.company}" >
												<f:selectItems value="#{semrrt018Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%" align="right" valign="top">
					               			<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
					               		</td>
					               		<td width="25%" align="left">
					               		<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea styleClass="inputbox-M" style="height:3em"  value="#{semrrt018Bean.multiContractNo}"></h:inputTextarea>
					               		</td>
									</tr>
									<tr>
						               	<td align="right" width="25%" valign="top">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationID']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea styleClass="inputbox-M" style="height:3em"  value="#{semrrt018Bean.multiLocationId}" ></h:inputTextarea>
					               		</td>
					               		<td align="right" valign="top">
					               			<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
					               		</td>
					               		<td align="left">
					               			<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea styleClass="inputbox-M" style="height:3em"  value="#{semrrt018Bean.multiRegion}"></h:inputTextarea>
					               		</td>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="top">
											<h:outputText value="#{jspMsg['label.vendor']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea styleClass="inputbox-M"  value="#{semrrt018Bean.multiVendor}" style="height:3em"></h:inputTextarea>
					               		</td>
					               		<td align="right" valign="top">
					               			
											<h:outputText value="#{jspMsg['label.contractStatus']} :" styleClass="ms7"/>
					               		</td>
					               		<td align="left" valign="top">
					               			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlContract" value="#{semrrt018Bean.contractStatus}" >
												<f:selectItems value="#{semrrt018Bean.contractStatusList}"/>
											</h:selectOneMenu>
					               		</td>
									</tr>
									
									
									<tr>
						               	<td align="right" width="25%" valign="top">
											<h:outputText value="#{jspMsg['label.networkStatus']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlNetwork" value="#{semrrt018Bean.networkStatus}" >
												<f:selectItems value="#{semrrt018Bean.networkStatusList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td></td>
					               		<td></td>
									</tr>
									<tr>
						               	<td align="right" width="25%" valign="top">
						               	    <h:graphicImage value="images/icon_required.gif"/>
					               			<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.asof']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText value="#{semrrt018Bean.asOf}" onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
											onkeyup="addSlashForDate(this)"
											onblur="autoAddYear(this)"
											maxlength="7"
											size="7"
											></h:inputText>
					               		</td>
					               		<td></td>
					               		<td></td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmErrorRT018, frmSearch"
											   value="#{jspMsg['label.btn.runReport']}" 
											   action="#{navAction.navi}">
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT018-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT018" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmErrorRT018, frmSearch, pnlShowReport" rendered="#{semrrt018Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmErrorRT018, frmSearch"
											   value="#{jspMsg['label.btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT018-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT018" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt018Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt018Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
