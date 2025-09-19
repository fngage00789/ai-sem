<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<jsp:include page="../../pages/popup/vendorSupplier-popup.jsp" />
<jsp:include page="../../pages/el/semmel006_popupAddVendor.jsp" />

<f:loadBundle basename="resources.el.semmel001-12" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlPayment012">
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
											<td align="right">
												<a4j:commandButton id="btnCancel"
													value="#{jspMsg['btn.back']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													rendered="#{!semmel001Bean.disableButtonForPaymentPage8}">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
													<a4j:actionparam name="page" value="2" />
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
											<td align="right">
												<a4j:commandButton id="btnSave" disabled="#{semmel001Bean.viewMode}"
													value="#{jspMsg['btn.save']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
													<a4j:actionparam name="page" value="12" />
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnAllCancel"
													value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													disabled="#{semmel001Bean.disableButtonForPaymentPage8}">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doInit" />
													<a4j:actionparam name="page" value="12" />
												</a4j:commandButton>
											</td>
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
						<rich:panel id="pnlManagement">	<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractNo']}" />
						</f:facet>				
							<h:panelGrid width="80%" border="0" cellpadding="0"
							cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.company']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricManage.company }" /></td>
										<td align="right" width="20%">
										<h:outputText
											value="#{jspMsg['label.oldContractNo']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricManage.oldContractNo }" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText 
											value="#{jspMsg['label.contactNo']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricManage.contractNo}" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.region']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricManage.region }" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.siteName']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricManage.siteName }" /></td>
										<td align="right" width="20%">
											<h:outputText
											value="#{jspMsg['label.siteStatus']}" styleClass="ms7" /></td>
										<td width="30%"><h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.electricManage.siteStatusDisplay }" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText style="width : 160px"
											value="#{jspMsg['label.electricUserType']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:outputText styleClass="ms7" style="width : 160px"
											value="#{semmel001Bean.manageWrapper.electricManage.electricUseTypeDisplay }" /></td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.approveDate']}"
											 styleClass="ms7" /></td>
										<td width="30%"><h:outputText style="width : 160px" styleClass="ms7"
											value="#{semmel001Bean.manageWrapper.approveDtDisplay}" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>
									</tr>
									</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				
				<h:panelGrid width="90%">				
					<rich:panel id="pnlDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.feeInfo']}" />
						</f:facet>
							<h:panelGrid width="80%" border="0" cellpadding="0" id="panelGridVendor"
							cellspacing="1">
								<h:panelGroup>
									<table width="100%">
									
									<tr>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/>
											<h:outputText	value="#{jspMsg['label.expenseType']}" styleClass="ms7" />
											</td>
										<td width="30%">
											<h:selectOneMenu id="expenseTypeList" disabled="#{semmel001Bean.viewMode}"
												value="#{semmel001Bean.manageWrapper.electricPayment.expenseType}" style="width : 160px">
			                					<f:selectItems value="#{semmel001Bean.expenseTypeList}" />
			                					<a4j:support event="onchange" action="#{semmel001Action.doChangeExpenseType12}" reRender="pnlAmount" />
			                					
			                				</h:selectOneMenu>
			                			</td>
										<td align="right" width="20%">
										<h:graphicImage	value="images/icon_required.gif" /><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.referenceType']}" styleClass="ms7" /></td>
										<td width="30%"><h:selectOneMenu id="detailRefDocType"
											disabled="#{semmel001Bean.frefDocTypeDisable or semmel001Bean.viewMode}"
											value="#{semmel001Bean.manageWrapper.electricPayment.docType}"
											style="width : 160px">
											<f:selectItems value="#{semmel001Bean.refDocTypeList}" />
										</h:selectOneMenu></td>
									</tr>
									<tr>
										<td align="right" width="20%">
										<h:graphicImage	value="images/icon_required.gif" /><rich:spacer width="5"/>
										<h:outputText	value="#{jspMsg['label.referenceNo']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText size="18"
											value="#{semmel001Bean.manageWrapper.electricPayment.docNo }"
											style="width : 160px"
											disabled="#{semmel001Bean.frefDocNoDisable or semmel001Bean.viewMode}" /></td>
										<td align="right" width="20%">
										<h:graphicImage	value="images/icon_required.gif" /><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.referenceDate']}" styleClass="ms7" /></td>
										<td width="30%"><rich:calendar locale="th/TH"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmel001Bean.manageWrapper.electricPayment.docDt }"
											style="width : 160px" showWeeksBar="false" inputSize="20"
											disabled="#{semmel001Bean.frefDocDtDisable or semmel001Bean.viewMode}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.vendorId']}" styleClass="ms7" /></td>
										<td width="30%"><h:panelGroup id="pnlDisplayVendorCode">
								                			<h:inputText id="txtVendorCode" 
								                			value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorCode} "	
								                			readonly="true" disabled="true"	style="width : 160px" maxlength="255"/>	
								                			
								                			<a4j:jsFunction name="GetLocationListJS" 
								                			reRender="pnlDisplayVendorCode, pnlDisplayVendorName" />
								                			<rich:spacer width="2"></rich:spacer>
								            				
								            				<a4j:commandButton id="btnPopupSearchSupplier"  
								            				oncomplete="#{rich:component('popupVendorSupplier')}.show(); return false"
															value="..." disabled="#{semmel001Bean.viewMode}"
															reRender="popupVendorSupplier" 
										            		action="#{navAction.navi}">
											            		<a4j:actionparam name="navModule" value="el" />
																<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
																<a4j:actionparam name="moduleWithNavi" value="common" />
																<a4j:actionparam name="actionWithNavi" value="PopupVendorSupplier" />
																<a4j:actionparam name="methodWithNavi" value="initPopupSearchVendorSupplier" />
																<a4j:actionparam name="popupType" value="SUPPLIER" />
																<a4j:actionparam name="page" value="semmel001" />
																<a4j:actionparam name="contractNo" value="#{semmel001Bean.manageWrapper.electricManage.contractNo}"/>
								            				</a4j:commandButton>
								            				
								            				<rich:spacer width="5"></rich:spacer>
								            				
								            				<a4j:commandButton id="btnVendorMaster" value="#{jspMsg['label.vendorMaster']}" 
															styleClass="rich-button" 
															disabled="#{semmel001Bean.viewMode}"
															rendered="false"
										            		action="#{navAction.navi}" reRender="oppContent" style="width:100">
															    <a4j:actionparam name="navModule" value="el" />
																<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />
																<a4j:actionparam name="moduleWithNavi" value="el" />
																<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
																<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
																<a4j:actionparam name="contractNo" value="#{semmel001Bean.manageWrapper.electricManage.contractNo}" />
																
																<a4j:actionparam name="navModuleFrom" value="el" />
																<a4j:actionparam name="navProgramFrom" value="SEMMEL001-12" />
																<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL006" />
															</a4j:commandButton>
								            				
						                				</h:panelGroup></td>

										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5"/><h:outputText
											value="#{jspMsg['label.vendorName']}" styleClass="ms7" /></td>
										<td width="30%"><h:panelGroup id="pnlDisplayVendorName">
								                			<h:inputText id="txtVendorName" value="#{popupVendorSupplierBean.popupVendorSupplierSearchSP.vendorName} "	readonly="true" disabled="true" style="width : 160px"	maxlength="255"/>
						                				</h:panelGroup></td>
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
												action="#{semmel001Action.doChangePaymentType12}"
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
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.disableRequireField}"/>
											<rich:spacer width="5" rendered="#{semmel001Bean.disableRequireField}"/>											
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
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.disableRequireField}"/>
											<rich:spacer width="5" rendered="#{semmel001Bean.disableRequireField}"/>
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
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
												oninputblur="validateRichCalendarFromTo('frmDetail','chqPostingDt','chqReceivedDtId');"
									 			oncollapse="validateRichCalendarFromTo('frmDetail','chqPostingDt','chqReceivedDtId');"/>
										</td>
										<td align="right" width="20%">
											
											<rich:spacer width="5" rendered="#{!semmel001Bean.fchqReceivedDtDisable }"/>
											<h:outputText value="#{jspMsg['label.chequeReceiveDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar locale="th/TH"
												enableManualInput="true" datePattern="dd/MM/yyyy"
												disabled="#{semmel001Bean.fchqReceivedDtDisable or semmel001Bean.viewMode}"
												value="#{semmel001Bean.manageWrapper.electricPayment.chqReceivedDt }"
												style="width : 160px" showWeeksBar="false" inputSize="20"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
												id="chqReceivedDtId"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											
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
										<td width="30%" align="left"><h:inputTextarea disabled="#{semmel001Bean.fpaymentRemark or semmel001Bean.viewMode}"
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
							<h:outputText value="#{jspMsg['header.panel.feeInfoDetail']}" />
						</f:facet>
							<h:panelGrid width="80%" border="0" cellpadding="0"
							cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td align="right" width="20%">
											<h:outputText	value="#{jspMsg['label.feeAreaCode']}" styleClass="ms7" />
												</td>
											<td width="30%">																				
													<h:inputText size="18" maxlength="15" 
													value="#{semmel001Bean.manageWrapper.electricPaymentDetail.feeAreaCode }" style="width : 160px">		
													</h:inputText>								
											</td>
											<td align="right" width="20%">
											<h:outputText	value="#{jspMsg['label.feeMeterId']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:inputText size="18" maxlength="15"
												value="#{semmel001Bean.manageWrapper.electricPaymentDetail.feeMeterId}" style="width : 160px">
													
												</h:inputText>
											</td>
										</tr>
										<tr>
											<td align="right" width="20%">
											<h:outputText	value="#{jspMsg['label.feecheckArea']}" styleClass="ms7" />
											</td>
											<td width="30%">																			
												<h:selectOneMenu id="feecheckArea"
												value="#{semmel001Bean.manageWrapper.electricPaymentDetail.feeCheckArea}" style="width : 160px">
			                					<f:selectItems value="#{semmel001Bean.feeCheckAreaList}" />
			                				</h:selectOneMenu>
												
											</td>
											<td align="right" width="20%" id="feeWBSCode"><h:graphicImage id="reqfeeWBSCode" value="images/icon_required.gif"/>
											<rich:spacer width="5"/>
											<h:outputText	value="#{jspMsg['label.feeWBSCode']}" styleClass="ms7"/>
											</td>
											<td width="30%">
												<h:inputText size="25" maxlength="25"
												value="#{semmel001Bean.manageWrapper.electricPaymentDetail.feeWbsCode}" style="width : 160px">
												
												</h:inputText>
											</td>
										</tr>
										
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.insuranceAmount']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18"
												value="#{semmel001Bean.manageWrapper.electricPaymentDetail.payAmt }"
												style="width : 160px; text-align:right"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												maxlength="18" styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
												<a4j:support event="onchange" action="#{semmel001Action.doChangePayAmt}" reRender="pnlAmount" />
											</h:inputText>
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
													layout="lineDirection" disabled="#{semmel001Bean.manageWrapper.electricPaymentDetail.disableVatType}">
													<f:selectItem itemValue="01"
														itemLabel="#{jspMsg['label.includeVat']}" />
													<f:selectItem itemValue="02"
														itemLabel="#{jspMsg['label.excludeVat']}" />
													<f:selectItem itemValue="03"
														itemLabel="#{jspMsg['label.freeVat']}" />
													<a4j:support event="onclick"
														action="#{semmel001Action.doChangePayAmt}"
														reRender="pnlAmount" />
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
											<h:inputText size="18" maxlength="15" disabled="false" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											value="#{semmel001Bean.manageWrapper.electricPaymentDetail.excludeVatAmt }" style="width : 160px; text-align:right">
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
											<h:inputText size="18" maxlength="15" disabled="false" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											value="#{semmel001Bean.manageWrapper.electricPaymentDetail.includeVatAmt }" style="width : 160px; text-align:right">
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
											<h:inputText size="18" maxlength="15" disabled="false" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											value="#{semmel001Bean.manageWrapper.electricPaymentDetail.chqAmt }" style="width : 160px; text-align:right">
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
														    rendered="#{semmel001Bean.editFeePayment}"
															styleClass="rich-button" action="#{navAction.navi}"
															reRender="dtbElecMeterCash,pnlSumAmount,pnlBtHead,pnlAmount,pnlDetail"
															disabled="#{!semmel001Bean.btaddVisible or semmel001Bean.viewMode}">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
															<a4j:actionparam name="methodWithNavi" value="doAdd12New" />
															<a4j:actionparam name="page" value="12" />
														</a4j:commandButton>
													</td>
													<td>
														<a4j:commandButton id="btnUpdate" value="Update"
															styleClass="rich-button" action="#{navAction.navi}"
															reRender="dtbElecMeterCash,pnlSumAmount,pnlBtHead,pnlAmount,buttomRow,pnlDetail"
															disabled="#{!semmel001Bean.btUpdateVisible or semmel001Bean.viewMode}">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
															<a4j:actionparam name="methodWithNavi" value="doUpdate12" />
															<a4j:actionparam name="page" value="12" />
														</a4j:commandButton>
													</td>
													<td>
														<a4j:commandButton id="btnClear" value="Clear"
															styleClass="rich-button" action="#{navAction.navi}"
															reRender="pnlSumAmount,pnlBtHead,pnlAmount,pnlDetail">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
															<a4j:actionparam name="methodWithNavi" value="doClear12" />
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
											<f:convertNumber type="currency" currencySymbol=""/>
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
											<f:convertNumber type="currency" currencySymbol=""/>
										</h:inputText>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.vatTotalAmount']}" styleClass="ms7" />
									</td>
									<td width="30%">
										<h:inputText size="18" maxlength="15" disabled="true" value="#{semmel001Bean.manageWrapper.electricPayment.includeVatAmt }" style="width : 160px; text-align:right">
											<f:convertNumber type="currency" currencySymbol=""/>
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
				<rich:panel id="pnlItemList" >
					<f:facet name="header">
						<h:outputText value="#{jspMsg['header.panel.listItem']}" style="width: 100%" />
					</f:facet>
				<rich:panel id="pnlFileStore" styleClass="sem_autoScrollbar"
					style="width: 1100px">
					
					<!-- begin dataTable -->
					<rich:dataTable id="dtbElecMeterCash" width="100%" cellpadding="1"
						cellspacing="0" border="0" var="ElectricPaymentWrapper"
						value="#{semmel001Bean.paymentWrapperList}"
						reRender="dtbElecMeterCash"
						rowKeyVar="rowIndex"
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
						rowClasses="cur" styleClass="contentform">
						<!-- begin column -->

						<rich:column width="5%">
							<f:facet name="header">
								<h:outputText value="Edit" style="width: 40px" />
							</f:facet>
							<div align="center">
								<a4j:commandButton 
									oncomplete="#{rich:component('mdpConfirmEditDialog')}.show(); return false"
									image="images/edit.png" style="height: 15; width: 15;" disabled="#{semmel001Bean.viewMode}"
									action="#{navAction.navi}" reRender="pnlDetail,pnlAmount,mdpConfirmEditDialog"
									title="edit">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
									<a4j:actionparam name="methodWithNavi" value="doInitEdit12" />
									<a4j:actionparam name="rowIndex" value="#{rowIndex}" />
								</a4j:commandButton>
							</div>
						</rich:column>

						<rich:column width="5%" 
						rendered="#{semmel001Bean.editFeePayment}">
							<f:facet name="header">
								<h:outputText value="Delete" style="width: 40px" />
							</f:facet>
							<div align="center">
							<a4j:commandButton
								oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false"
								action="#{navAction.navi}" image="images/delete.png" disabled="#{semmel001Bean.viewMode}"
								style="height: 15; width: 15;" title="delete" 
								reRender="pnlAmount,dtbElecMeterCash,pnlSumAmount,pnlDetail,mdpConfirmDelDialog">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="initDelete12" />
								<a4j:actionparam name="rowIndex" value="#{rowIndex}" />
								<a4j:actionparam name="page" value="12" />
							</a4j:commandButton></div>
						</rich:column>
						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.expenseTypeTxt }">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.expenseType']}" style="width: 50px" />
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.expenseTypeTxt}" /></div>
						</rich:column>
						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.refDocTypeTxt }">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.referenceType']}" style="width: 50px" />
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.refDocTypeTxt}" /></div>
						</rich:column>
						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.docNo}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.referenceNo']}" style="width: 50px" />
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.docNo}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.docDt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.referenceDate']}" style="width: 100px">
									
								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.docDtTH}" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText>
								</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.vendorId}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.vendorId']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.vendorId}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.vendorName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.vendorName']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.vendorName}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.payeeId}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.receiverId']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.payeeId}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.payeeName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.receiverName']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.payeeName}" /></div>
						</rich:column>
						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.feeWbsCode}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.feeWBSCode']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.feeWbsCode}" /></div>
						</rich:column>
						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.payAmt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.insuranceAmount']}" style="width: 100px">
									
								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.payAmt}" >
									<f:convertNumber pattern="###,##0.00" />
								</h:outputText>
								</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.vatTypeTxt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.VATType']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.vatTypeTxt}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.excludeVatAmt }">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.beforeVATAmount']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.excludeVatAmt }" >
								<f:convertNumber pattern="###,##0.00" />
								</h:outputText>
								</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.vatAmt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.vatAmount']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.vatAmt}" >
								<f:convertNumber pattern="###,##0.00" />
								</h:outputText>
								</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.includeVatAmt }">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.includeVat']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.includeVatAmt }" >
								<f:convertNumber pattern="###,##0.00" />
								</h:outputText>
								</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPaymentDetail.chqAmt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.chequeAmount']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPaymentDetail.chqAmt}" >
								<f:convertNumber pattern="###,##0.00" />
								</h:outputText>
								</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.paymentTypeTxt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.paymentMethod']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.paymentTypeTxt}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.paymentMethodTxt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.paymentType']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.paymentMethodTxt}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.bankName}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.bankName']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.bankName}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.bankAccount}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.bankAccount']}" style="width: 100px">

								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.bankAccount}" /></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.chqPostingDt }">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.chequeDate']}" style="width: 100px">
									
								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.chqPostingDtTH}" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText>
							</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.chqReceivedDt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.chequeReceiveDate']}" style="width: 100px">
									
								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.chqReceivedDtTH}" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText></div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.transferDt}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.transferDate']}" style="width: 100px">
									
								</h:outputText>
							</f:facet>
							<div align="center"><h:outputText
								value="#{ElectricPaymentWrapper.electricPayment.transferDtTH}" >
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
								</h:outputText>
							</div>
						</rich:column>

						<rich:column sortBy="#{ElectricPaymentWrapper.electricPayment.remark}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['header.remark']}" style="width: 100px">

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
										<td width="30%"><h:outputText styleClass="ms7" value="#{semmel001Bean.manageWrapper.electricPayment.updateDt }" style="width : 160px">
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
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
						reRender="dtbElecMeterCash,pnlSumAmount,pnlBtHead,pnlDetail, rbtVatType">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doDelete12" />
						<a4j:actionparam name="page" value="12" />
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
						<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doEdit12" />
						<a4j:actionparam name="page" value="12" />
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
