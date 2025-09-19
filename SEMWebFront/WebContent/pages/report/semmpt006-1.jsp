<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.propertyTax.semmpt006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
				<h:message for="cldDueDtFrom" errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" />
				<h:message for="cldDueDtTo" errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" />
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%" border="0">
				<a4j:form id="frmSearch">
				<table width="100%" >
							<tr valign="bottom">
				                	<td align="right" width="25%">
				                		<a4j:commandButton
											id="btnBack" 
											value="Back"
											styleClass="rich-button"
											action="#{navAction.navi}"
											rendered="#{semmpt006Bean.disPlaybtnBack}"
											reRender="oppContent">
											<a4j:actionparam name="navModule" value="#{semmpt006Bean.paramNavModule}" />
											<a4j:actionparam name="navProgram" value="#{semmpt006Bean.paramNavProgram}" />
											<a4j:actionparam name="moduleWithNavi" value="#{semmpt006Bean.paramModuleWithNavi}" />
											<a4j:actionparam name="actionWithNavi" value="#{semmpt006Bean.paramActionWithNavi}" />
											<a4j:actionparam name="methodWithNavi" value="#{semmpt006Bean.paramMethodWithNavi}" />											
										</a4j:commandButton>
		                			</td>
		                			
		                	</tr>
		         </table>
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" >
							<tr valign="bottom">
				                	<td align="right" width="25%">
				                		<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
										<h:selectOneMenu id="ddlPTaxPayType" value="#{semmpt006Bean.mpt006Srch.ptTaxPayType}">
											<f:selectItems value="#{semmpt006Bean.propertyTaxTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="25%">
										
									</td>
									<td width="25%">
										
									</td>
							</tr>
							<tr valign="bottom">
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.createDateFrom']}" styleClass="ms7"/>
									</td>
									<td colspan="3" width="75%">
										<rich:calendar id="cldDueDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmpt006Bean.mpt006Srch.createDateFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   cellWidth="20px" cellHeight="20px">
										</rich:calendar>	
									<rich:spacer width="5"/>
									<h:outputText value="#{jspMsg['label.createDateTo']}" styleClass="ms7"/>
									<rich:spacer width="5"/>
		                			 <rich:calendar id="cldDueDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                			 value="#{semmpt006Bean.mpt006Srch.createDateTo}" 
		                			 inputSize="13" 
		                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
		                			 oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
									 oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
									 cellWidth="20px" cellHeight="20px"/>
									</td>
							</tr>
							<tr valign="bottom" >
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
									</td>
									<td colspan="2" width="50%">
										<h:inputText id="txtCreatBy" value="#{semmpt006Bean.mpt006Srch.createBy}" size="53" maxlength="50"/>
									</td>
									<td width="25%">
										
									</td>
							</tr>
							
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
						
						<h:commandButton id="btnRun" styleClass="rich-button" 
						value="Export to Excel" action="#{semmpt006Action.runReport}"
						style="width:90px"/>
													
						<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clearPropertyTax']}" 
						 styleClass="rich-button" 
				 		 action="#{semmpt006Action.clearReport}" 
				 		 reRender="pnlSearchCriteria,show_report, frmError"  ajaxSingle="true"/>
						</h:panelGrid>
							
						
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
