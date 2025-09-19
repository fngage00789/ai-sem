<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsgPopup4"/>
	<rich:modalPanel id="popupCuttingForm" width="650" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupCuttingForm" style="cursor:pointer"/>
					<rich:componentControl for="popupCuttingForm" attachTo="hidePopupCuttingForm" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorPopupCutting">
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
		<a4j:form id="popupFrmCuttingSave"> 
			<rich:panel id="pnlCuttingForm">
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
		                				<h:inputText id="txtPopupVendorCode" value="#{semmrt003Bean.manualSettleSP.vendorCode}" size="23" maxlength="20" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Vendor Name :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupVendorName" value="#{semmrt003Bean.manualSettleSP.vendorName}" size="23" maxlength="20" disabled="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Payee name :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupPayeeName" value="#{semmrt003Bean.manualSettleSP.payeeName}" size="23" maxlength="20" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Bank Acc No :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupBankAccNo" value="#{semmrt003Bean.manualSettleSP.bankAccNo}" size="23" maxlength="20" disabled="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Invoice No :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupInvoiceNo" value="#{semmrt003Bean.manualSettleSP.invoiceNo}" size="23" maxlength="20" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="Amount :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPopupAmount" value="#{semmrt003Bean.manualSettleSP.totalAmt}" size="23" maxlength="20" disabled="true"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="VAT :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtEstmAmt" value="#{semmrt003Bean.manualSettleSP.vatAmt}"
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
		                				<h:inputText id="txtPopupWhtAmt" value="#{semmrt003Bean.manualSettleSP.whtAmt}"
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
		                				<h:inputText id="txtPopupDutyAmt" value="#{semmrt003Bean.manualSettleSP.dutyAmt}"
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
		                				<h:inputText id="txtPopupTotalAmt" value="#{semmrt003Bean.manualSettleSP.payamount}"
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
										<h:outputText value="#{jspMsgPopup4['label.paymentTypePop']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentTypePopup" value="#{semmrt003Bean.manualSettleSP.paymentType}" disabled="true">
											<f:selectItems value="#{semmrt003Bean.paymentTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
											<h:outputText value="#{jspMsgPopup4['label.paymentMethodBank']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentMethodPopup" value="#{semmrt003Bean.manualSettleSP.paymentMethod}" disabled="true">
											<f:selectItems value="#{semmrt003Bean.paymentMethodList}"/>
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
											value="#{semmrt003Bean.manualSettleSP.chqDt}"
											disabled="#{semmrt003Bean.renderedChqDt}"
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
											value="#{semmrt003Bean.manualSettleSP.chqReceiveDt}"
											disabled="#{semmrt003Bean.renderedChqDt}"
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
											value="#{semmrt003Bean.manualSettleSP.transferDt}"
											disabled="#{semmrt003Bean.renderedTransferDt}"
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
		                				<h:inputText id="txtDoc68" value="#{semmrt003Bean.manualSettleSP.doc68}" size="18"/>
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
											value="#{semmrt003Bean.manualSettleSP.doc68Dt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											converterMessage="#{semmrt003Bean.messageErrorDate} - #{jspMsgPopup4['column.header.doc68Dt']}"
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
		                				<h:inputText id="txtDocPayment" value="#{semmrt003Bean.manualSettleSP.docPayment}" size="18"/>
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
											value="#{semmrt003Bean.manualSettleSP.docPaymentDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											converterMessage="#{semmrt003Bean.messageErrorDate} - #{jspMsgPopup4['column.docPaymentDt']}"
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
		                				<h:inputText id="txtDocCancel" value="#{semmrt003Bean.manualSettleSP.docCancel}" size="18"/>
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
											value="#{semmrt003Bean.manualSettleSP.docCancelDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											converterMessage="#{semmrt003Bean.messageErrorDate} - #{jspMsgPopup4['column.docCancelDt']}"
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
			                	 <td colspan="4" align="right">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton value="#{jspMsgPopup4['btn.cancelPayment']}" styleClass="rich-button" immediate="true" action="#{navAction.navi}" 
									oncomplete="#{rich:component('popupEditCuttingForm')}.show(); return false"
									 reRender="popupFrmCuttingEdit,pnlCuttingEditForm,ddlPaymentStatus">
										<rich:componentControl for="popupCuttingForm" operation="hide" event="onclick" />
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
											<a4j:actionparam name="methodWithNavi" value="doInitPopupRemark" />	
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
	
	<rich:modalPanel id="popupEditCuttingForm" width="500" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup.savePayment']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditCuttingForm" style="cursor:pointer" />
					<rich:componentControl for="popupEditCuttingForm" attachTo="hidePopupEditCuttingForm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
		<a4j:form id="frmErrorPopupCuttingSave">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderMessagePopup}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmCuttingEdit"> 
			<table>
				<tr>
					<td align="right" width="10%">
						<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
						<h:outputText value="#{jspMsgPopup4['label.paymentStatus']}" styleClass="ms7"/>
		            </td>
		            <td width="30%" colspan="3">
		            	<h:selectOneMenu id="ddlPaymentStatusList" value="#{semmrt003Bean.manualSettleSP.paymentStatus}">
							<f:selectItems value="#{semmrt003Bean.pamentStatusList}"/>
						</h:selectOneMenu>
					</td>
				</tr>
				<tr>
					<td align="right" width="20%">
						<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
						<h:outputText value="#{jspMsgPopup4['label.remark']}" styleClass="ms7" />
		            </td>
		            <td width="30%" colspan="3">
		            	<h:inputTextarea id="txtPopRemark" value="#{semmrt003Bean.manualSettleSP.remarkPaymentStatus}" rows="2" cols="60"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" align="left">
						<h:panelGroup>
									<a4j:commandButton id="btnPopupSave" value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="pnlSearchResult,frmErrorPopupCuttingSave,dtbRentalPayNormalSrch"
									oncomplete="if(#{semmrt003Bean.popupCloseSave == 'true'})#{rich:component('popupEditCuttingForm')}.hide();">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
											<a4j:actionparam name="methodWithNavi" value="doUpdatePopupCutting" />	
									</a4j:commandButton>
							<rich:spacer width="10px"/>
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"  
							reRender="popupFrmCuttingEdit">
							<rich:componentControl for="popupEditCuttingForm" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGroup>
			        </td>
			     </tr>   
			</table>
		</a4j:form>		
	</rich:modalPanel>