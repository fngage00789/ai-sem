<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.report.semrrt023" var="jspMsg"/>
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
											<h:selectOneMenu id="ddlCompany" value="#{semrrt023Bean.company}" >
												<f:selectItems value="#{semrrt023Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%"></td>
					               		<td width="25%"></td>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               	<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlRegion" value="#{semrrt023Bean.region}" >
												<f:selectItems value="#{semrrt023Bean.regionList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.year']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText value="#{semrrt023Bean.year}" size="4" maxlength="4" ></h:inputText>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<h:outputText value="#{jspMsg['label.paymentType']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlPaymentType" value="#{semrrt023Bean.paymentType}" >
												<f:selectItems value="#{semrrt023Bean.paymentTypeList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.module']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlModuleType" value="#{semrrt023Bean.module}" onchange="GetExpenseType();">
												<f:selectItems value="#{semrrt023Bean.moduleList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetExpenseType"
												action="#{navAction.navi}" reRender="ddlExpenseType">
												<a4j:actionparam name="navModule" value="report" />
												<a4j:actionparam name="navProgram" value="SEMRRT023-1" />
												<a4j:actionparam name="moduleWithNavi" value="report" />
												<a4j:actionparam name="actionWithNavi" value="SEMRRT023" />
												<a4j:actionparam name="methodWithNavi" value="getDDLExpenseType" />
											</a4j:jsFunction>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
											<h:outputText value="#{jspMsg['label.expenseType']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlExpenseType" value="#{semrrt023Bean.expenseType}" >
												<f:selectItems value="#{semrrt023Bean.expenseTypeList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td/>
					               		<td/>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid columns="2" id="pnlGridCommand">
							<a4j:commandButton id="btnRun" style=" width : 86px;" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['label.btn.runReport']}" 
											   action="#{navAction.navi}" >
							 
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT023-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT023" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt023Bean.displayShowReport}"/>
								
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['label.btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT023-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT023" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						  
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt023Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt023Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
						
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
