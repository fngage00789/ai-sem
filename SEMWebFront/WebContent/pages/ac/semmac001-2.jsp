<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.account.semmac001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name2']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError2">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
				<a4j:form id="frmSearch2">
					<rich:panel id="pnlVeiw1">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.name2']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentDocNo2']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtPaymentDocNoPopup" value="#{semmac001Bean.mac001SrchD.paymentDocNo}" size="18" maxlength="15" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtExpenseTypePopup" value="#{semmac001Bean.mac001SrchD.expenseTypeDesc}" size="30" maxlength="30" readonly="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.dueDt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldDueDtPopup" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmac001Bean.mac001SrchD.dueDt}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   oninputkeyup="this.value = this.value.substring(0, 10);" 
										 cellWidth="20px" cellHeight="20px"
										 readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['column.expenseDesc']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtExpenseDescPopup" value="#{semmac001Bean.mac001SrchD.expenseDesc}" size="30" maxlength="30" readonly="true"/>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<a4j:commandLink id="hypContractNoPopup" value="#{semmac001Bean.mac001SrchD.contractNo}" 
											oncomplete="showViewSiteInfoPopup()"
											action="#{navAction.navi}" style="width:100">
											<a4j:actionparam name="navModule" value="ac" />
											<a4j:actionparam name="navProgram" value="SEMMAC001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmac001Bean.mac001SrchD.siteInfoId}" />
										</a4j:commandLink>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.preContractNo']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<a4j:commandLink id="hypViewPreSiteInfo" value="#{semmac001Bean.mac001SrchD.preContractNo}" rendered="#{semmac001Bean.renderedLinkContract}"
											oncomplete="showViewSiteInfoPopup()"
											action="#{navAction.navi}" style="width:100">
											<a4j:actionparam name="navModule" value="ac" />
											<a4j:actionparam name="navProgram" value="SEMMAC001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmac001Bean.mac001SrchD.preSiteInfoId}" />
										</a4j:commandLink>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Site Name :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtSiteNamePopup" value="#{semmac001Bean.mac001SrchD.siteName}" size="30" maxlength="255" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtSiteStatusPopup" value="#{semmac001Bean.mac001SrchD.siteStatus}" size="25" maxlength="22" readonly="true"/>
									</td>
							</tr>
							<tr>
									
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtNetWorkStatusPopup" value="#{semmac001Bean.mac001SrchD.networkStatus}" size="18" maxlength="15" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pmsStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPmsStatusPopup" value="#{semmac001Bean.mac001SrchD.pmsStatus}" size="18" maxlength="15" readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Vendor Code :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorCodePopup" value="#{semmac001Bean.mac001SrchD.vendorCode}" size="23" maxlength="20" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="Vendor Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorNamePopup" value="#{semmac001Bean.mac001SrchD.vendorName}" size="30" maxlength="255" readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Pre Vendor Code :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPreVendorPopup" value="#{semmac001Bean.mac001SrchD.preVendorCode}" size="30" maxlength="255" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="Pre Vendor Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPreVendorNamePopup" value="#{semmac001Bean.mac001SrchD.preVendorName}" size="18" maxlength="15" readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Payee Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayeeNamePopup" value="#{semmac001Bean.mac001SrchD.payeeName}" size="30" maxlength="255" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="Bank Acc No :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtBankAccNoPopup" value="#{semmac001Bean.mac001SrchD.bankAccNo}" size="18" maxlength="15" readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Pre Payee Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayeeVendorNamePopup" value="#{semmac001Bean.mac001SrchD.prePayeeName}" size="30" maxlength="255" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="Pre Bank Account No. :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPreBankAccNoPopup" value="#{semmac001Bean.mac001SrchD.preBankAccNo}" size="18" maxlength="15" readonly="true"/>
									</td>
							</tr>
							<tr>
								<td colspan="4" width="100%">
									<h:outputText value="#{semmac001Bean.msgHeaderPopup1}" styleClass="ms7red"></h:outputText><br></br>
								    <h:outputText value="#{semmac001Bean.msgHeaderPopup2}" styleClass="ms7red"></h:outputText>
								</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					
					<rich:panel id="pnlVeiw2">
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Vat Type :" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtVatTypePopup" value="#{semmac001Bean.mac001SrchD.vatType}" size="23" maxlength="20" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Vat Rate :" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtVatRatePopup" value="#{semmac001Bean.mac001SrchD.vatRate}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 size="6"
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="WHT Type :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtWhtTypePopup" value="#{semmac001Bean.mac001SrchD.whtType}" size="23" maxlength="20" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="WHT Rate :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtWhtRatePopup" value="#{semmac001Bean.mac001SrchD.whtRate}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 size="6"
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlVeiw3">
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['header.pnlInfo']}" styleClass="ms7"/>
								</td>
							</tr>
							<tr>
								<td align="right" width="20%">
										<h:outputText value="Exclude Amount :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtExcAmtPopup" value="#{semmac001Bean.mac001SrchD.excAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="VAT :" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtVatPopup" value="#{semmac001Bean.mac001SrchD.vatAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 size="6"
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Include Amount :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtIncludeAmtPopup" value="#{semmac001Bean.mac001SrchD.incAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="WHT :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtWhtPopup" value="#{semmac001Bean.mac001SrchD.whtAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 size="6"
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.dutyAmt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtDutyAmtPopup" value="#{semmac001Bean.mac001SrchD.dutyAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
									<td align="right">
									<h:panelGroup>
										<h:outputText value="#{jspMsg['label.periodTypeDesc']} :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtPerioTypeDesc" value="#{semmac001Bean.mac001SrchD.periodTypeDesc}"
			                						 maxlength="2" 
			                						 size="6"
			                						 styleClass="inputRight"
			                						 readonly="true">
					                	</h:inputText>
				                	</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlVeiw4">
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right">
									<h:outputText value="#{jspMsg['header.pnlInfo2']}" styleClass="ms7"/>
								</td>
							</tr>
							<tr>
								<td align="right" width="20%">
										<h:outputText value="Doc Type :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtDocTypePopup" value="#{semmac001Bean.mac001SrchD.docType}" size="30" maxlength="30" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Doc No :" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtDocNoPopup" value="#{semmac001Bean.mac001SrchD.docNo}" size="23" maxlength="20" readonly="true"/>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Exclude Amount :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtPayExcAmtPopup" value="#{semmac001Bean.mac001SrchD.payExcAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="VAT :" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtPayVatPopup" value="#{semmac001Bean.mac001SrchD.payVatAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Include Amount :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayIncludeAmtPopup" value="#{semmac001Bean.mac001SrchD.payIncAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
									<td align="right" width="20%">
										<h:outputText value="WHT :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayWhtPopup" value="#{semmac001Bean.mac001SrchD.payWhtAmt}" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.dutyAmt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayDutyAmtPopup" value="#{semmac001Bean.mac001SrchD.payDutyAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.depositAmt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtDepositAmtPopup" value="#{semmac001Bean.mac001SrchD.depositAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.totalAmt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtTotalAmtPopup" value="#{semmac001Bean.mac001SrchD.totalAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['labelpreTotalAmt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPreTotalAmtPopup" value="#{semmac001Bean.mac001SrchD.preTotalAmt}"
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight"
			                						 readonly="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                				</h:inputText>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlVeiw5">
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right" width="20%">
										<h:outputText value="GL Account :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtGlAccountPopup" value="#{semmac001Bean.mac001SrchD.glAccount}" size="23" maxlength="20" readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="Cost Center :" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtCostCenterPopup" value="#{semmac001Bean.mac001SrchD.costCenter}" size="23" maxlength="20" readonly="true"/>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.paymentDt']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<rich:calendar id="cldPaymentDtPopup" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmac001Bean.mac001SrchD.paymentDt}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 oninputkeyup="this.value = this.value.substring(0, 10);" 
										 cellWidth="20px" cellHeight="20px"
										 readonly="true"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:inputText id="txtPaymentStatusPopup" value="#{semmac001Bean.mac001SrchD.paymentStatus}" size="30" maxlength="30" readonly="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPaymentTypePopup" value="#{semmac001Bean.mac001SrchD.paymentTypeDesc}" size="23" maxlength="20" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPaymentMethodPopup" value="#{semmac001Bean.mac001SrchD.paymentMethodDesc}" size="30" maxlength="30" readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.chqDt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldChqDtPopup" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmac001Bean.mac001SrchD.chqDt}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 oninputkeyup="this.value = this.value.substring(0, 10);" 
										 cellWidth="20px" cellHeight="20px"
										 readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldChqReceiveDtPopup" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmac001Bean.mac001SrchD.chqReceiveDt}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 oninputkeyup="this.value = this.value.substring(0, 10);" 
										 cellWidth="20px" cellHeight="20px"
										 readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.chqNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtChqNoPopup" value="#{semmac001Bean.mac001SrchD.chqNo}" size="23" maxlength="20" readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.doc68']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtdoc68Popup" value="#{semmac001Bean.mac001SrchD.doc68}" size="23" maxlength="20" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.doc68Dt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldDoc68DtPopup" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmac001Bean.mac001SrchD.doc68Dt}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 oninputkeyup="this.value = this.value.substring(0, 10);" 
										 cellWidth="20px" cellHeight="20px"
										 readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.doc92']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtdoc92Popup" value="#{semmac001Bean.mac001SrchD.doc92}" size="23" maxlength="20" readonly="true"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.doc92Dt']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldDoc92DtPopup" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmac001Bean.mac001SrchD.doc92Dt}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 oninputkeyup="this.value = this.value.substring(0, 10);" 
										 cellWidth="20px" cellHeight="20px"
										 readonly="true"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.popupRemark']}" styleClass="ms7"/>
									</td>
									<td width="30%" colspan="3">
										<h:inputTextarea id="txtRemarkPopup" value="#{semmac001Bean.mac001SrchD.remark}" rows="3" cols="75" readonly="true"/>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<h:panelGrid columns="4" id="grdSearchCommand">
							<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
							 action="#{navAction.navi}" reRender="oppContent">
									<a4j:actionparam name="navModule" value="#{semmac001Bean.tmpNavModuleFrom}" />
								<a4j:actionparam name="navProgram" value="#{semmac001Bean.tmpNavProgramFrom}" />
								<a4j:actionparam name="moduleWithNavi" value="#{semmac001Bean.tmpModuleWithNavi}" />
								<a4j:actionparam name="actionWithNavi" value="#{semmac001Bean.tmpActionWithNavi}" />
								<a4j:actionparam name="methodWithNavi" value="#{semmac001Bean.tmpMethodWithNavi}" />	
							</a4j:commandButton>
							<a4j:commandButton id="btnEdit" value="Edit" styleClass="rich-button" reRender="popupViewApproveForms"
							 action="#{semmac001Action.onRenderPaymentMethod}" oncomplete="#{rich:component('popupViewApproveForms')}.show(); return false" >	
							</a4j:commandButton>
							<a4j:commandButton id="btnViewSap" value="#{jspMsg['btn.viewSap']}" styleClass="rich-button" 
							 oncomplete="#{rich:component('popupSap')}.show(); return false" >	
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
					<jsp:include page="../../pages/ac/semmac001-popup.jsp"/>
				</h:panelGrid>			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

