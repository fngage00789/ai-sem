<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.account.semmac004" var="jspMsgPopup4"/>
	<rich:modalPanel id="popupApproveForm" width="650" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupApproveForm" style="cursor:pointer"/>
					<rich:componentControl for="popupApproveForm" attachTo="hidePopupApproveForm" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorPopupSave">
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
		<a4j:form id="popupFrmSave"> 
			<rich:panel id="pnlApproveForm">
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
		                				<h:inputText id="txtPopupVendorCode" value="#{semmac004Bean.mac004Act.vendorCode}" size="23" maxlength="20" disabled="true"/>
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
			                	 <td colspan="2">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSave" value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="frmErrorPopupSave,dtbMac004Srch,frmError,pnlSearchResult"
									oncomplete="if(#{semmac004Bean.popupClose == 'true'})#{rich:component('popupApproveForm')}.hide();">
											<a4j:actionparam name="navModule" value="ac" />
											<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
											<a4j:actionparam name="moduleWithNavi" value="ac" />
											<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
											<a4j:actionparam name="methodWithNavi" value="doSaveAct" />	
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
									 reRender="frmErrorPopupSave,dtbMac004Srch">
										<rich:componentControl for="popupApproveForm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 <td colspan="2" align="right">
			                	 <h:panelGroup>
				                	 	<a4j:commandButton value="#{jspMsgPopup4['btn.cancelPayment']}" styleClass="rich-button" immediate="true" action="#{navAction.navi}" 
										oncomplete="#{rich:component('popupEditCuttingAc004Form')}.show(); return false" disabled="#{semmac004Bean.disableCancelBtn}"
										 reRender="popupFrmCuttingAc004Edit,pnlCuttingEditAc004Form,ddlPaymentStatus">
											<rich:componentControl for="popupApproveForm" operation="hide" event="onclick" />
												<a4j:actionparam name="navModule" value="ac" />
												<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
												<a4j:actionparam name="moduleWithNavi" value="ac" />
												<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
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
	
	
	<rich:modalPanel id="popupEditCuttingAc004Form" width="500" autosized="true">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup.savePayment']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditCuttingAc004Form" style="cursor:pointer" />
					<rich:componentControl for="popupEditCuttingAc004Form" attachTo="hidePopupEditCuttingAc004Form" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
		<a4j:form id="frmErrorPopupCuttingAc004Save">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmac004Bean.renderMessagePopup}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmCuttingAc004Edit"> 
			<table>
				<tr>
					<td align="right" width="10%">
						<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
						<h:outputText value="#{jspMsgPopup4['label.paymentStatus']}" styleClass="ms7"/>
		            </td>
		            <td width="30%" colspan="3">
		            	<h:selectOneMenu id="ddlPaymentStatusList" value="#{semmac004Bean.paySP.paymentStatus}">
							<f:selectItems value="#{semmac004Bean.paymentStatusListItems}"/>
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
		            	<h:inputTextarea id="txtPopRemark" value="#{semmac004Bean.paySP.remarkPaymentStatus}" rows="2" cols="60"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td colspan="3" align="right">
						<h:panelGroup>
									<a4j:commandButton id="btnPopupSave" value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="pnlSearchResult,frmErrorPopupCuttingAc004Save,dtbMac004Srch"
									oncomplete="if(#{semmac004Bean.popupCloseSave == 'true'})#{rich:component('popupEditCuttingAc004Form')}.hide();">
											<a4j:actionparam name="navModule" value="ac" />
											<a4j:actionparam name="navProgram" value="SEMMAC004-1" />
											<a4j:actionparam name="moduleWithNavi" value="ac" />
											<a4j:actionparam name="actionWithNavi" value="SEMMAC004" />
											<a4j:actionparam name="methodWithNavi" value="doUpdatePopupCutting" />	
									</a4j:commandButton>
							<rich:spacer width="10px"/>
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"  
							reRender="popupFrmCuttingAc004Edit">
							<rich:componentControl for="popupEditCuttingAc004Form" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGroup>
			        </td>
			     </tr>   
			</table>
		</a4j:form>		
	</rich:modalPanel>
	
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mac004PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mac004PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mac004PopUp_addVendor" attachTo="hide-mac004PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMac004PopUp_addVendor">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="เงื่อนไขการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorCode" value="#{semmac004Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmac004Bean.vendorMasterPopupObjParam.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmac004Action.doSearchPopupAddVendor}"
					reRender="frmMac004PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmac004Action.doClearPopupAddVendor}"
					reRender="frmMac004PopUp_addVendor, dataTable_searchVendor"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="ผลการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchVendor" cellpadding="1" cellspacing="0" border="0" 
							var="vendorLst"  value="#{semmac004Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmac004Action.doSelectPopupAddVendor}"
											reRender="oppContent">
												<a4j:actionparam name="paramVendorCode" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="paramVendorName" value="#{vendorLst.dataObj.vendorName}" />
											</a4j:commandLink>
									</div>	
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code ใหม่" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mac004_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mac004_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mac004_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mac004_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmac004Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmac004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmac004Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMac004PopUp_addVendor"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mac004PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->