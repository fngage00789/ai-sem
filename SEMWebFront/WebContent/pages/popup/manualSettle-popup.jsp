<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.popup.manualSettle" var="jspMsgPopup4"/>
	<rich:modalPanel id="popupManualSettleForm" width="650" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupManualSettleForm" style="cursor:pointer"/>
					<rich:componentControl for="popupManualSettleForm" attachTo="hidePopupManualSettleForm" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorPopupManualSettleSave">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		<a4j:form id="popupFrmManualSettleSave"> 
			<rich:panel id="pnlApproveManualSettleForm">
				<f:facet name="header">
							<h:outputText value="#{jspMsgPopup4['header.popup']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Vendor Code :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupVendorCode" value="#{popupSiteContractBean.vendorCode}" size="23" maxlength="20" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Vendor Name :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupVendorName" value="#{semmac004Bean.mac004Act.vendorName}" size="23" maxlength="20" disabled="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Payee name :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupPayeeName" value="#{semmac004Bean.mac004Act.payeeName}" size="23" maxlength="20" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Bank Acc No :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupBankAccNo" value="#{semmac004Bean.mac004Act.bankAccNo}" size="23" maxlength="20" disabled="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Invoice No :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupInvoiceNo" value="#{semmac004Bean.mac004Act.invoiceNo}" size="23" maxlength="20" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Amount :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupAmount" value="#{semmac004Bean.mac004Act.totalAmt}" size="23" maxlength="20" disabled="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="VAT :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtEstmAmt" value="#{semmac004Bean.mac004Act.vatAmt}"
			                						 disabled="true" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
		                					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="WHT :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupWhtAmt" value="#{semmac004Bean.mac004Act.whtAmt}"
			                						 disabled="true" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
		                					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:inputText>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsgPopup4['label.popup.duty']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupDutyAmt" value="#{semmac004Bean.mac004Act.dutyAmt}"
			                						 disabled="true" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
		                					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:inputText>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Total Amount :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupTotalAmt" value="#{semmac004Bean.mac004Act.payamount}"
			                						 disabled="true" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
		                					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:inputText>
				                	</td>
							</tr>
							<tr>
								<td colspan="4" width="100%">
									<hr>
								</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsgPopup4['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentTypePopup" value="#{semmac004Bean.mac004Act.paymentType}" onchange="ChangeCalendar();">
											<f:selectItems value="#{semmac004Bean.paymentTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeCalendar" action="#{semmac004Action.onRenderPaymentMethod}"  
										 reRender="cldChqDtPopup,cldChqReceiveDtPopup,cldTransferDtPopup,ddlPaymentMethodPopup">
										</a4j:jsFunction>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="#{jspMsgPopup4['label.paymentMethod']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentMethodPopup" value="#{semmac004Bean.mac004Act.paymentMethod}" disabled="#{semmac004Bean.disablePaymentMethod}">
											<f:selectItems value="#{semmac004Bean.paymentMethodList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsgPopup4['label.chqDtPopup']}" styleClass="ms7"/>	
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldChqDtPopup" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac004Bean.mac004Act.chqDt}"
											disabled="#{semmac004Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsgPopup4['column.header.chqDt']}">
												
											</rich:calendar>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsgPopup4['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldChqReceiveDtPopup" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac004Bean.mac004Act.chqReceiveDt}"
											disabled="#{semmac004Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsgPopup4['column.header.chqDt']}">
												
											</rich:calendar>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsgPopup4['label.transferDtPopup']}" styleClass="ms7"/>	
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldTransferDtPopup" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac004Bean.mac004Act.transferDt}"
											disabled="#{semmac004Bean.renderedTransferDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsgPopup4['column.header.transferDt']}">
												
											</rich:calendar>
				                	</td>
				                </tr>
				                
				                 <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif" rendered="false"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsgPopup4['label.doc68']}" styleClass="ms7"/>	
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtDoc68" value="#{semmac004Bean.mac004Act.doc68}" size="18"/>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif" rendered="false"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsgPopup4['label.doc68Dt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldDoc68DtPopup" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac004Bean.mac004Act.doc68Dt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											converterMessage="#{semmac004Bean.messageErrorDate} - #{jspMsgPopup4['column.header.doc68Dt']}"
											label="#{jspMsgPopup4['column.header.doc68Dt']}">
												
											</rich:calendar>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"  rendered="false"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsgPopup4['label.docPayment']}" styleClass="ms7"/>	
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtDocPayment" value="#{semmac004Bean.mac004Act.docPayment}" size="18"/>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif" rendered="false"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsgPopup4['label.docPaymentDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldDocPaymentDtPopup" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac004Bean.mac004Act.docPaymentDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											converterMessage="#{semmac004Bean.messageErrorDate} - #{jspMsgPopup4['column.docPaymentDt']}"
											label="#{jspMsgPopup4['column.docPaymentDt']}">
												
											</rich:calendar>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"  rendered="false"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsgPopup4['label.docCancel']}" styleClass="ms7"/>	
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtDocCancel" value="#{semmac004Bean.mac004Act.docCancel}" size="18"/>
				                	</td>
				                	<td align="right" width="20%">
				                			<h:graphicImage value="images/icon_required.gif" rendered="false"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsgPopup4['label.docCancelDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldDocCancelDtPopup" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmac004Bean.mac004Act.docCancelDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											converterMessage="#{semmac004Bean.messageErrorDate} - #{jspMsgPopup4['column.docCancelDt']}"
											label="#{jspMsgPopup4['column.docCancelDt']}">
												
											</rich:calendar>
				                	</td>
				                </tr>
				                
			                	<tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSave" value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="frmErrorPopupManualSettleSave,dtbMac004Srch,frmError,pnlSearchResult"
									oncomplete="if(#{semmac004Bean.popupClose == 'true'})#{rich:component('popupApproveForm')}.hide();">
											<a4j:actionparam name="navModule" value="ac" />
											<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
											<a4j:actionparam name="moduleWithNavi" value="ac" />
											<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
											<a4j:actionparam name="methodWithNavi" value="doSaveAct" />	
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
									 reRender="frmErrorPopupManualSettleSave,dtbMac004Srch">
										<rich:componentControl for="popupApproveForm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>