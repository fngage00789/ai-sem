<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel001-9" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlPayment009">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<a4j:form id="frmDetail">

			<h:panelGrid columnClasses="gridContent" width="99%">
				<h:panelGrid width="90%">

					<h:panelGroup id="pnlBtHead">
						<table width="100%">
							<tr>
								<td width="50%" align="left">
									<h:panelGrid id="message">
										<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
									</h:panelGrid>
								</td>
								<td width="50%" align="right" valign="baseline">
								<table id="tblButton">
									<tr>
										<td>
											<a4j:commandButton id="btnCancel"
												value="#{jspMsg['btn.back']}" styleClass="rich-button"
												action="#{navAction.navi}" reRender="oppContent"
												rendered="#{!semmel001Bean.disableButtonForPaymentPage8}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doCancel" />
												<a4j:actionparam name="page" value="9" />
											</a4j:commandButton>
											<a4j:commandButton id="btnCancel2"
												value="#{jspMsg['btn.back']}" styleClass="rich-button"
												action="#{navAction.navi}" reRender="oppContent"
												rendered="#{semmel001Bean.disableButtonForPaymentPage8}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
												<a4j:actionparam name="methodWithNavi" value="doSearch" />
											</a4j:commandButton>
										</td>
										<td><a4j:commandButton id="btnSave"
											value="#{jspMsg['btn.save']}" styleClass="rich-button" disabled="#{semmel001Bean.viewMode}"
											action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doSave" />
											<a4j:actionparam name="page" value="9" />

										</a4j:commandButton></td>
										<td align="right"><a4j:commandButton id="btnAllCancel"
											value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="oppContent"
											disabled="#{semmel001Bean.disableButtonForPaymentPage8}">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInit" />
											<a4j:actionparam name="page" value="9" />

										</a4j:commandButton></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
			</h:panelGrid>

			<h:panelGrid columnClasses="gridContent" width="100%">
				<h:panelGrid width="90%">
					<rich:panel id="pnlPrivateDeposit">
						<h:outputText value="#{jspMsg['header.depositList']}" />
						<h:panelGrid width="80%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<rich:dataTable id="dtbPrivateDeposit" width="100%"
									cellpadding="1" cellspacing="0" border="0" var="PrivateDeposit"
									value="#{semmel001Bean.privateDepositList}"
									rowKeyVar="rowIndex" rowClasses="cur" styleClass="contentform">

									<rich:column>
										<f:facet name="header">
											<h:outputText value="Action" style="width: 100px" />
										</f:facet>
										<div align="center">
											<h:selectBooleanCheckbox title="chkAction" value="#{PrivateDeposit.selected}" disabled="#{!PrivateDeposit.newFlagBoolean || PrivateDeposit.added ||  semmel001Bean.viewMode}">
												<a4j:support event="onclick" action="#{semmel001Action.doCalculateTotalSelectedPrivateDeposit09}" reRender="pnlAmount,message,pnlPrivateDeposit" />
											</h:selectBooleanCheckbox>
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.expenseType']}"
												style="width: 100px">
											</h:outputText>
										</f:facet>
										<div align="center"><h:outputText value="#{PrivateDeposit.expenseTypeTxt}" /></div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.depositType']}"
												style="width: 100px">

											</h:outputText>
										</f:facet>
										<div align="center"><h:outputText
											value="#{PrivateDeposit.depositTypeTxt}" /></div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.depositAmt']}"
												style="width: 100px">

											</h:outputText>
										</f:facet>
										<div align="center"><h:outputText
											value="#{PrivateDeposit.depositAmt}">
											<f:convertNumber pattern="###,##0.00" />
										</h:outputText></div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="VAT Type" style="width: 100px"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{PrivateDeposit.vatTypeTxt}" />
										</div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.newFlag']}"
												style="width: 100px" />
										</f:facet>
										<div align="center"><h:outputText
											value="#{PrivateDeposit.newFlagTxt}" /></div>
									</rich:column>
									<rich:column>
										<f:facet name="header">
											<h:outputText value="Remark" style="width: 100px">

											</h:outputText>
										</f:facet>
										<div align="center"><h:outputText
											value="#{PrivateDeposit.remark}" /></div>
									</rich:column>
								</rich:dataTable>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columnClasses="gridContent" width="100%">

				<h:panelGrid width="90%">
					<rich:panel id="pnlDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.insurance']}" />
						</f:facet>
						<h:panelGrid width="80%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.contactNo']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.contractNo }" /></td>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.siteBaseName']}" styleClass="ms7" />
										</td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.siteName }" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.expenseType']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.expenseTypeDisplay }"
											style="width : 160px" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.referenceType']}" styleClass="ms7" /></td>
										<td width="30%"><h:selectOneMenu id="detailRefDocType"
											disabled="#{semmel001Bean.frefDocTypeDisable or semmel001Bean.viewMode}"
											value="#{semmel001Bean.manageWrapper.electricPayment.docType}"
											style="width : 160px">
											<f:selectItems value="#{semmel001Bean.refDocTypeList}" />
										</h:selectOneMenu></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.referenceNo']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText size="18" maxlength="25"
											value="#{semmel001Bean.manageWrapper.electricPayment.docNo }"
											style="width : 160px"
											disabled="#{semmel001Bean.frefDocNoDisable }" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.referenceDate']}" styleClass="ms7" /></td>
										<td width="30%"><rich:calendar locale="th/TH"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmel001Bean.manageWrapper.electricPayment.docDt }"
											style="width : 160px" showWeeksBar="false" inputSize="20"
											disabled="#{semmel001Bean.frefDocDtDisable or semmel001Bean.viewMode}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" /></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.vendorId']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.vendorId }"
											style="width : 160px" /></td>

										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.vendorName']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.vendorName }"
											style="width : 160px" /></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.receiverId']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.payeeId }"
											style="width : 160px" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.receiverName']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.payeeName }"
											style="width : 160px" /></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.paymentMethod']}" styleClass="ms7" />
										</td>
										<td width="30%"><h:selectOneMenu id="detailPaymentMethod"
											disabled="#{semmel001Bean.fpaymentTypeDisable or semmel001Bean.viewMode}"
											value="#{semmel001Bean.manageWrapper.electricPayment.paymentType}"
											style="width : 160px">
											<f:selectItems value="#{semmel001Bean.paymentTypeList}" />
											<a4j:support event="onchange"
												action="#{semmel001Action.doChangePaymentType}"
												reRender="pnlDetail" />
										</h:selectOneMenu></td>

										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.paymentType']}" styleClass="ms7" /></td>
										<td width="30%"><h:selectOneMenu id="detailPaymentType"
											disabled="#{semmel001Bean.fpaymentMethodDisable or semmel001Bean.viewMode}"
											value="#{semmel001Bean.manageWrapper.electricPayment.paymentMethod}"
											style="width : 160px">
											<f:selectItems value="#{semmel001Bean.paymentMethodList}" />
										</h:selectOneMenu></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText styleClass="ms7" 
												value=""
												style="width : 160px"
												rendered="#{semmel001Bean.fbankNameLabelVisible}" />
											<h:outputText styleClass="ms7" style="width : 160px"
												rendered="#{semmel001Bean.fbankNameInputVisible}"
												value="#{semmel001Bean.manageWrapper.electricPayment.bankName }" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bankAccount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText styleClass="ms7"
												value=""
												style="width : 160px"
												rendered="#{semmel001Bean.fbankNameLabelVisible}" />
											<h:outputText
												styleClass="ms7" style="width : 160px"
												rendered="#{semmel001Bean.fbankNameInputVisible}"
												value="#{semmel001Bean.manageWrapper.electricPayment.bankAccount}" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.fchqPostingDtDisable}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.fchqPostingDtDisable}"/>
											<h:outputText value="#{jspMsg['label.chequeDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="chqPostingDt"
												locale="th/TH"
												disabled="#{semmel001Bean.fchqPostingDtDisable or semmel001Bean.viewMode}"
												enableManualInput="true" datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.manageWrapper.electricPayment.chqPostingDt }"
												style="width : 160px" showWeeksBar="false" inputSize="20"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
											</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.fchqReceivedDtDisable }"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.fchqReceivedDtDisable }"/>
											<h:outputText value="#{jspMsg['label.chequeReceiveDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar locale="th/TH"
												enableManualInput="true" datePattern="dd/MM/yyyy"
												disabled="#{semmel001Bean.fchqReceivedDtDisable or semmel001Bean.viewMode}"
												value="#{semmel001Bean.manageWrapper.electricPayment.chqReceivedDt }"
												style="width : 160px" showWeeksBar="false" inputSize="20"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.ftransferDtDisable }"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.ftransferDtDisable }"/>
											<h:outputText value="#{jspMsg['label.transferDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar locale="th/TH"
												disabled="#{semmel001Bean.ftransferDtDisable or semmel001Bean.viewMode}"
												enableManualInput="true" datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.manageWrapper.electricPayment.transferDt }"
												style="width : 160px" showWeeksBar="false" inputSize="20"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.remark']}" styleClass="ms7" /></td>
										<td width="30%" align="left"><h:inputTextarea
											disabled="#{semmel001Bean.fpaymentRemark or semmel001Bean.viewMode}"
											value="#{semmel001Bean.manageWrapper.electricPayment.remark }"
											style="width : 160px" /></td>
									</tr>

								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>

			</h:panelGrid>

			<h:panelGrid columnClasses="gridContent" width="100%">

				<h:panelGrid width="90%">
					<rich:panel id="pnlAmount">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.insuranceDetail']}" />
						</f:facet>
						<h:panelGrid width="80%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">

									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.insuranceAmount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.manageWrapper.electricPaymentDetail.payAmt }" styleClass="ms7">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.VATType']}" styleClass="ms7" />
										</td>
										<td>
										<table>
											<tr>
												<td><h:selectOneRadio id="rbtVatType" styleClass="ms7"
													value="#{semmel001Bean.manageWrapper.electricPaymentDetail.vatType}"
													disabled="true"
													layout="lineDirection">
													<f:selectItems value="#{semmel001Bean.vatTypeList}"/>
												</h:selectOneRadio></td>
											</tr>
										</table>
										</td>
									</tr>

									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.beforeVATAmount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="3" maxlength="3" disabled="true" value="#{semmel001Bean.manageWrapper.electricPaymentDetail.excludeVatAmt }" style="width : 160px; text-align:right">
												<f:convertNumber pattern="###,##0.00" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatAmount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" 
												value="#{semmel001Bean.manageWrapper.electricPaymentDetail.vatAmt }"
												style="width : 160px; text-align:right" disabled="#{semmel001Bean.fvatAmtDisable}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												maxlength="18" styleClass="inputRight">
												<a4j:support event="onchange" action="#{semmel001Action.doChangeVatAmt}" reRender="pnlAmount,message" />
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatTotalAmount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" disabled="true" value="#{semmel001Bean.manageWrapper.electricPaymentDetail.includeVatAmt }" style="width : 160px; text-align:right">
												<f:convertNumber pattern="###,##0.00" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.chequeAmount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" disabled="true" value="#{semmel001Bean.manageWrapper.electricPaymentDetail.chqAmt }" style="width : 160px; text-align:right">
												<f:convertNumber pattern="###,##0.00" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td id="buttomRow" colspan="4" align="left">
											<table>
												<tr>
													<td>
														<a4j:commandButton id="btnAdd" value="Add"
															styleClass="rich-button" action="#{navAction.navi}"
															reRender="dtbElecMeterCash,pnlSumAmount,pnlBtHead,pnlDetail,pnlAmount,pnlPrivateDeposit"
															disabled="#{!semmel001Bean.btaddVisible or semmel001Bean.viewMode}">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
															<a4j:actionparam name="methodWithNavi" value="doAdd09MultiPrivate" />
															<a4j:actionparam name="page" value="09" />
														</a4j:commandButton>
													</td>
													<td>
														<a4j:commandButton id="btnUpdate" value="Update"
															styleClass="rich-button" action="#{navAction.navi}"
															reRender="dtbElecMeterCash,pnlSumAmount,pnlAmount,buttomRow"
															disabled="#{!semmel001Bean.btUpdateVisible or semmel001Bean.viewMode}">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
															<a4j:actionparam name="methodWithNavi" value="doUpdate09" />
															<a4j:actionparam name="page" value="9" />
														</a4j:commandButton>
													</td>
													<td>
														<a4j:commandButton id="btnClear" value="Clear"
															styleClass="rich-button" action="#{navAction.navi}"
															reRender="pnlSumAmount,pnlBtHead,pnlAmount,pnlDetail">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
															<a4j:actionparam name="methodWithNavi" value="doClear09" />
														</a4j:commandButton>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>

			</h:panelGrid>
		</a4j:form>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<h:panelGrid width="90%">
				<rich:panel id="pnlSumAmount">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['header.panel.sumPayment']}" />
					</f:facet>
					<h:panelGrid width="80%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.sumItem']}" styleClass="ms7" />
									</td>
									<td width="30%">
										<h:inputText size="3" maxlength="4" disabled="true" value="#{semmel001Bean.sumItem }"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.item']}" styleClass="ms7" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.beforeVATAmount']}" styleClass="ms7" />
									</td>
									<td width="30%">
										<h:inputText size="18" maxlength="15" disabled="true" value="#{semmel001Bean.manageWrapper.electricPayment.excludeVatAmt }" style="width : 160px; text-align:right">
											<f:convertNumber pattern="###,##0.00" />
										</h:inputText>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.vatAmount']}" styleClass="ms7" />
									</td>
									<td width="30%">
										<h:inputText size="18" maxlength="15" disabled="true" value="#{semmel001Bean.manageWrapper.electricPayment.vatAmt }" style="width : 160px; text-align:right">
											<f:convertNumber pattern="###,##0.00" />
										</h:inputText>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.vatTotalAmount']}" styleClass="ms7" />
									</td>
									<td width="30%">
										<h:inputText size="18" maxlength="15" disabled="true" value="#{semmel001Bean.manageWrapper.electricPayment.includeVatAmt }" style="width : 160px; text-align:right">
											<f:convertNumber pattern="###,##0.00" />
										</h:inputText>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>

		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmListInfo">
				<!-- begin content layout data grid -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlItemList">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.listItem']}"
								style="width: 100%" />
						</f:facet>
						<rich:panel id="pnlFileStore" styleClass="sem_autoScrollbar"
							style="width: 1100px">

							<!-- begin dataTable -->
							<rich:dataTable id="dtbElecMeterCash" width="100%"
								cellpadding="1" cellspacing="0" border="0"
								var="ElectricPaymentWrapper"
								value="#{semmel001Bean.paymentWrapperList}"
								reRender="dtbElecMeterCash" rowKeyVar="rowIndex"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform">
								<!-- begin column -->

								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="Edit" style="width: 40px" />
									</f:facet>
									<div align="center"><a4j:commandButton
										oncomplete="#{rich:component('mdpConfirmEditDialog')}.show(); return false"
										image="images/edit.png" style="height: 15; width: 15;"
										action="#{navAction.navi}" disabled="#{semmel001Bean.viewMode}"
										reRender="pnlDetail,pnlAmount,mdpConfirmEditDialog"
										title="edit">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="doInitEdit09" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}" />
									</a4j:commandButton></div>
								</rich:column>

								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="Delete" style="width: 40px" />
									</f:facet>
									<div align="center"><a4j:commandButton
										oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false"
										action="#{navAction.navi}" image="images/delete.png"
										style="height: 15; width: 15;" title="delete"  disabled="#{semmel001Bean.viewMode}"
										reRender="pnlAmount,dtbElecMeterCash,pnlSumAmount,pnlDetail,mdpConfirmDelDialog">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
										<a4j:actionparam name="methodWithNavi" value="initDelete09" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}" />
										<a4j:actionparam name="page" value="09" />
									</a4j:commandButton></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.refDocTypeTxt }">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.referenceType']}"
											style="width: 50px" />
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.refDocTypeTxt}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.docNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.referenceNo']}"
											style="width: 50px" />
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.docNo}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.docDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.referenceDate']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText value="#{ElectricPaymentWrapper.electricPayment.docDtTH}"/>
									</div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.vendorId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.vendorId']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.vendorId}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.vendorName']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.vendorName}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.payeeId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.receiverId']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.payeeId}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.receiverName']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.payeeName}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.payAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.insuranceAmount']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPaymentDetail.payAmt}">
										<f:convertNumber pattern="###,##0.00" />
									</h:outputText></div>
								</rich:column>

								<rich:column sortBy="#{ElectricPaymentWrapper.vatTypeTxt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.VATType']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{ElectricPaymentWrapper.vatTypeTxt}" />
									</div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.excludeVatAmt }">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.beforeVATAmount']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPaymentDetail.excludeVatAmt }">
										<f:convertNumber pattern="###,##0.00" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.vatAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.vatAmount']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPaymentDetail.vatAmt}">
										<f:convertNumber pattern="###,##0.00" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.includeVatAmt }">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.includeVat']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPaymentDetail.includeVatAmt }">
										<f:convertNumber pattern="###,##0.00" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.chqAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.chequeAmount']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPaymentDetail.chqAmt}">
										<f:convertNumber pattern="###,##0.00" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.paymentTypeTxt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.paymentMethod']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.paymentTypeTxt}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.paymentMethodTxt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.paymentType']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.paymentMethodTxt}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.bankName']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.bankName}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.bankAccount}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.bankAccount']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.bankAccount}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.chqPostingDt }">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.chequeDate']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.chqPostingDtTH }">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy"
											locale="th" dateStyle="medium" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.chqReceivedDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.chequeReceiveDate']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.chqReceivedDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy"
											locale="th" dateStyle="medium" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.transferDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.transferDate']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.transferDtTH}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy"
											locale="th" dateStyle="medium" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{ElectricPaymentWrapper.electricPayment.remark}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.remark']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{ElectricPaymentWrapper.electricPayment.remark}" /></div>
								</rich:column>

								<!-- end column -->
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true"
										align="center" for="dtbElecMeterCash" maxPages="10"
										id="dstSiteApprove" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>
							<!-- end dataTable -->
						</rich:panel>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmAudit">
				<h:panelGrid width="90%">
					<rich:panel id="pnlAudit">
						<h:panelGrid width="80%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">

									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.CreateBy']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.createBy}"
											style="width : 160px" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.CreateDate']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.createDt}"
											style="width : 160px">
											<f:convertDateTime type="date" pattern="dd/MM/yyyy"
												locale="th" />
										</h:outputText></td>
									</tr>

									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.UpdateBy']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.updateBy }"
											style="width : 160px" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.UpdateDate']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricPayment.updateDt }"
											style="width : 160px">
											<f:convertDateTime type="date" pattern="dd/MM/yyyy"
												locale="th" dateStyle="medium" />
										</h:outputText></td>
									</tr>

								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
		</h:panelGrid>

	</rich:panel>
</h:panelGrid>
<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Delete"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel001Bean.popupMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="dtbElecMeterCash,pnlSumAmount,pnlBtHead,pnlDetail,pnlPrivateDeposit">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doDelete09" />
						<a4j:actionparam name="page" value="09" />
						<rich:componentControl for="mdpConfirmDelDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmDelDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
<rich:modalPanel id="mdpConfirmEditDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Edit"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmEditDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel001Bean.popupMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="dtbElecMeterCash,pnlSumAmount,pnlBtHead,pnlAmount,pnlDetail">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doEdit09" />
						<a4j:actionparam name="page" value="09" />
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
