<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemulticontract-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultilocation-popup.jsp" />
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />
<jsp:include page="../../pages/popup/multivendor-popup.jsp" />

<f:loadBundle basename="resources.report.semrco001" var="jspMsg"/>
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
									<td align="right" width="25%" valign="baseline">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7"/>
		                				</td>
		                				<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlCompany" value="#{semrco001Bean.company}" >
												<f:selectItems value="#{semrco001Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td align="right" width="10%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.year']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="40%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText value="#{semrco001Bean.year}"  maxlength="4" size="4"></h:inputText>
					               		</td>
								</tr>
								
								<tr>
									<td align="right"><h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/></td>
									<td align="left">
										<rich:spacer width="5px"></rich:spacer>
										<h:selectOneMenu value="#{semrco001Bean.region}" >
											<f:selectItems value="#{semrco001Bean.regionList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="10%" valign="baseline">
											<h:outputText value="#{jspMsg['label.month']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlMonth" value="#{semrco001Bean.month}" >
												<f:selectItems value="#{semrco001Bean.monthList}"/>
											</h:selectOneMenu>
					               		</td>
								
								</tr>
								<tr>
									<td align="right">
											
									</td>
									<td align="left">
										<h:selectBooleanCheckbox value="#{semrco001Bean.pico}"></h:selectBooleanCheckbox>
										<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.pico']} " styleClass="ms7"/>
									</td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									
									<td colspan="4">
										<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.runReport']}" 
											   action="#{navAction.navi}" >
							
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRCO001-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRCO001" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrco001Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRCO001-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRCO001" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrco001Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrco001Action.showReport}"  />								
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