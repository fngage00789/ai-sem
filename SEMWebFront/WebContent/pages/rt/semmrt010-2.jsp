<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<f:loadBundle basename="resources.rental.semmrt010" var="jspMsg" />
<h:panelGrid width="100%">
	<a4j:form id="frmTodolistDetail">
		<!-- begin content layout -->
		<h:panelGrid width="100%">
			<rich:panel id="pnlRental">
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.frmTodolistDetail']}" />
				</f:facet>
				<!-- begin content -->
				<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="oppContent">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="#{semmrt010Bean.backPage}" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
									<a4j:actionparam name="methodWithNavi" value="backPage" />
								</a4j:commandButton>
							</tr>
							<tr>
								<td width="15%" align="right" style="padding-bottom: 10px;"><h:outputText
									value="#{jspMsg['label.company']}" styleClass="ms7" /></td>
								<td width="20%" style="padding-bottom: 10px;"><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.company}"
									disabled="true"></h:inputText></td>
								<td align="right" width="15%" style="padding-bottom: 10px;"><h:outputText
									value="#{jspMsg['label.region']}" styleClass="ms7" /></td>
								<td width="50%" style="padding-bottom: 10px;"><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.region}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.contractNo']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.contractNo}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.siteName']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.siteName}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.dateFromCondition']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.dateFromCondition}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.dateUpToCondition']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.dateUpToCondition}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right" style="padding-bottom: 20px;"><h:outputText
									value="#{jspMsg['label.contractStatus']}" styleClass="ms7" /></td>
								<td style="padding-bottom: 20px;"><h:inputText size="30"
									value="#{semmrt010Bean.displayFrmTodoList.contractStatus}"
									disabled="true"></h:inputText></td>
								<td style="padding-bottom: 20px;"></td>
								<td style="padding-bottom: 20px;"></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.contractType']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.contractType}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.withHoldingTax']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.withHoldingTax}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.withHoldingTaxPercentage']}"
									styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.withHoldingTaxPercentage}"
									disabled="true"></h:inputText><h:outputText
									value="#{jspMsg['label.percentage']}" styleClass="ms7" /></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.vat']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.vat}" disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.vendorCode']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.vendorCode}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.vendorName']}" styleClass="ms7" /></td>
								<td><h:inputText size="30"
									value="#{semmrt010Bean.displayFrmTodoList.vendorName}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.status']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.status}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.errorMessage']}" styleClass="ms7" /></td>
								<td><h:inputText size="75"
									value="#{semmrt010Bean.displayFrmTodoList.errorMessage}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.firstPostingFrom']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.firstPostingFrom}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.dateFirstContractEnd']}"
									styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.dateFirstContractEnd}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.perYearOrPerMonth']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.perYearOrPerMonth}"
									disabled="true"></h:inputText></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.splitCase']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.splitCase}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right"><h:outputText
									value="#{jspMsg['label.currencyUnitPrice']}" styleClass="ms7" /></td>
								<td><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.currencyUnitPriceFormatter}"
									disabled="true">
									<f:convertNumber pattern="#,##0.00" />
								</h:inputText><h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" /></td>
								<td align="right"><h:outputText
									value="#{jspMsg['label.updateDt']}" styleClass="ms7" /></td>
								<td><h:inputText size="25"
									value="#{semmrt010Bean.displayFrmTodoList.updateDt}"
									disabled="true"></h:inputText></td>
							</tr>
							<tr>
								<td align="right" style="padding-bottom: 20px;"><h:panelGroup>
									<h:graphicImage value="images/icon_required.gif" />
									<h:outputText value="#{jspMsg['label.refxNo']}"
										styleClass="ms7" />
								</h:panelGroup></td>
								<td style="padding-bottom: 20px;"><h:inputText
									value="#{semmrt010Bean.displayFrmTodoList.refxNo}"
									disabled="false"></h:inputText></td>
								<td style="padding-bottom: 20px;"></td>
								<td style="padding-bottom: 20px;"></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td><a4j:commandButton id="btnResend" value="RESEND REFX"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="oppContent" style="margin-right: 5px;">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="#{semmrt010Bean.backPage}" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
									<a4j:actionparam name="methodWithNavi"
										value="doResendToIfrsWithRefId" />
									<a4j:actionparam name="referenceId"
										value="#{semmrt010Bean.displayFrmTodoList.referenceId}" />
								</a4j:commandButton> <a4j:commandButton value="#{jspMsg['btn.closeJob']}"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="oppContent" style="margin-right: 5px;"
									disabled="false">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="#{semmrt010Bean.backPage}" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
									<a4j:actionparam name="methodWithNavi" value="doCloseJob" />
									<a4j:actionparam name="referenceId"
										value="#{semmrt010Bean.displayFrmTodoList.referenceId}" />
								</a4j:commandButton> <a4j:commandButton value="#{jspMsg['btn.saveAndClose']}"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="oppContent" disabled="false">
									<a4j:actionparam name="navModule" value="rt" />
									<a4j:actionparam name="navProgram" value="#{semmrt010Bean.backPage}" />
									<a4j:actionparam name="moduleWithNavi" value="rt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMRT010" />
									<a4j:actionparam name="methodWithNavi" value="doUpdateRefx" />
									<a4j:actionparam name="referenceId"
										value="#{semmrt010Bean.displayFrmTodoList.referenceId}" />
								</a4j:commandButton></td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
	</a4j:form>
</h:panelGrid>
