<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/sitemultiregion-popup.jsp" />

<f:loadBundle basename="resources.report.semrrt022" var="jspMsg"/>
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
											<h:selectOneMenu id="ddlCompany" value="#{semrrt022Bean.company}">
												<f:selectItems value="#{semrrt022Bean.companyList}"/>
											</h:selectOneMenu>
					               		</td>
					               		<td width="25%"></td>
					               		<td width="25%"></td>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.previousMonthFrom']} :" styleClass="ms7"/>											
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtPreviousMonthFrom" value="#{semrrt022Bean.previousMonthFrom}"
											onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
											onkeyup="addSlashForDate(this)"
											onblur="autoAddYear(this)"
											maxlength="7"
											size="10"
											/>
											<rich:spacer width="5px"></rich:spacer>
											<h:outputText value = "#{jspMsg['label.monthYearFormat']} " styleClass="ms7"/>
							
					               		</td>
					               		<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.previousMonthTo']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtPreviousMonthTo" value="#{semrrt022Bean.previousMonthTo}"
											onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
											onkeyup="addSlashForDate(this)"
											onblur="autoAddYear(this)"
											maxlength="7"
											size="10"
											/>
											<rich:spacer width="5px"></rich:spacer>
											<h:outputText value = "#{jspMsg['label.monthYearFormat']} " styleClass="ms7"/>
					               		</td>
					               		
									</tr>		
									<tr>
						               	<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.currentMonthFrom']} :" styleClass="ms7"/>											
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtCuerrentMonthFrom" value="#{semrrt022Bean.currentMonthFrom}"
											onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
											onkeyup="addSlashForDate(this)"
											onblur="autoAddYear(this)"
											maxlength="7"
											size="10"
											/>
											<rich:spacer width="5px"></rich:spacer>
											<h:outputText value = "#{jspMsg['label.monthYearFormat']} " styleClass="ms7"/>
					               		</td>
					               		<td align="right" width="25%" valign="baseline">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.currentMonthTo']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputText id="txtCuerrentMonthTo" value="#{semrrt022Bean.currentMonthTo}"
											onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
											onkeyup="addSlashForDate(this)"
											onblur="autoAddYear(this)"
											maxlength="7"
											size="10"
											/>
											<rich:spacer width="5px"></rich:spacer>
											<h:outputText value = "#{jspMsg['label.monthYearFormat']} " styleClass="ms7"/>
					               		</td>
					               		
									</tr>
									<tr>
										<td align="right" width="25%" valign="top">
						               		<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.expenseType']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlExpenseType" value="#{semrrt022Bean.expenseType}" >
												<f:selectItems value="#{semrrt022Bean.expenseTypeList}"/>
											</h:selectOneMenu>
					               		</td>
					               		
									</tr>							
									<tr>
									<td align="right" width="25%" valign="top">
<!--						               		<h:graphicImage value="images/icon_required.gif"/>-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:inputTextarea id="ddlContractNo" value="#{semrrt022Bean.contractNo}" cols="30" rows="5"/>
					               		</td>
									</tr>
									
									<tr>
						               	<td align="right" width="25%" valign="top">
<!--						               		<h:graphicImage value="images/icon_required.gif"/>-->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.percentDiff']} :" styleClass="ms7"/>
		                				</td>
					             		
					             		<td colspan="2" align="left" width="25%">
					             			<rich:spacer width="5px"></rich:spacer>
											<h:selectOneMenu id="ddlPercentDiff" value="#{semrrt022Bean.percentDiffType}" >
												<f:selectItems value="#{semrrt022Bean.diffList}"/>
											</h:selectOneMenu>
											<rich:spacer width="10px"></rich:spacer>
											<h:inputText id="txtpercentDiff" value="#{semrrt022Bean.percentDiffAmt}" size="5">
												<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
											<rich:spacer width="10px"></rich:spacer>
											<h:outputText value="#{jspMsg['label.percent']} " styleClass="ms7"/>
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
								<a4j:actionparam name="navProgram" value="SEMRRT022-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT022" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearch, pnlShowReport" rendered="#{semrrt022Bean.displayShowReport}"/>
							</a4j:commandButton>
														
							<a4j:commandButton id="btnClear" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmSearch"
											   value="#{jspMsg['btn.clear']}" 
											   action="#{navAction.navi}" ajaxSingle="true">
								
								<a4j:actionparam name="navModule" value="report" />
								<a4j:actionparam name="navProgram" value="SEMRRT022-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMRRT022" />
								<a4j:actionparam name="methodWithNavi" value="doClearReport" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
							<h:panelGroup id="pnlInShowReport" rendered="#{semrrt022Bean.displayShowReport}" style="height:0px;width:0px;" >
								<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semrrt022Action.showReport}"  />								
								<script>document.getElementById('incContent:frmSearch:bthShowReport').click();</script>
							</h:panelGroup>							
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
