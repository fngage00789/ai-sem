<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

	<f:loadBundle basename="resources.rental.semmrt003" var="jspMsgPopup4"/>
	
	<!-- common_popupCuttingForm >> -->
	<rich:modalPanel id="common_popupCuttingForm" width="650" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-common_popupCuttingForm" style="cursor:pointer"/>
					<rich:componentControl for="common_popupCuttingForm" attachTo="hide-common_popupCuttingForm" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid style="">
			<table width="100%" border="0">
				<tr>
					<td>
						<a4j:form id="frmError-common_popupCutting">
							 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green">
							 		<f:facet name="header">
			                        	<h:outputText value="Entered Data Status:"></h:outputText>
			                    	</f:facet>
						 			<f:facet name="errorMarker">
						 				 <h:graphicImage value="images/error.gif" />  
				                    </f:facet>
			                </rich:messages>
						</a4j:form>
					</td>
				</tr>
			</table>
		</h:panelGrid>
		
		<a4j:form id="common_popupCuttingFormSave"> 
			<rich:panel id="pnlCuttingForm">
				<f:facet name="header">
					<h:outputText value="#{jspMsgPopup4['header.popup']}"/>
				</f:facet>
				
				<center>
				<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="100%" align="center" border="0">
							<tr>
								<td align="right" width="20%">
									<h:outputText value="Vendor Code :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtPopupVendorCode" value="#{popupCuttingBean.popupCuttingSP.vendorCode}" size="23" maxlength="20" disabled="true"/>
			                	</td>
			                	<td align="right" width="20%">
									<h:outputText value="Vendor Name :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtPopupVendorName" value="#{popupCuttingBean.popupCuttingSP.vendorName}" size="23" maxlength="20" disabled="true"/>
			                	</td>
							</tr>
							<tr>
								<td align="right" width="20%">
									<h:outputText value="Payee name :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtPopupPayeeName" value="#{popupCuttingBean.popupCuttingSP.payeeName}" size="23" maxlength="20" disabled="true"/>
			                	</td>
			                	<td align="right" width="20%">
									<h:outputText value="Bank Acc No :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtPopupBankAccNo" value="#{popupCuttingBean.popupCuttingSP.bankAccNo}" size="23" maxlength="20" disabled="true"/>
			                	</td>
							</tr>
							<tr>
								<td align="right" width="20%">
									<h:outputText value="Invoice No :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtPopupInvoiceNo" value="#{popupCuttingBean.popupCuttingSP.invoiceNo}" size="23" maxlength="20" disabled="true"/>
			                	</td>
			                	<td align="right" width="20%">
										<h:outputText value="Amount :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtPopupAmount" value="#{popupCuttingBean.popupCuttingSP.totalAmt}" size="23" maxlength="20" disabled="true"/>
			                	</td>
							</tr>
							<tr>
								<td align="right" width="20%">
									<h:outputText value="VAT :" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:inputText id="txtEstmAmt" value="#{popupCuttingBean.popupCuttingSP.vatAmt}" size="23"
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
	                				<h:inputText id="txtPopupWhtAmt" value="#{popupCuttingBean.popupCuttingSP.whtAmt}" size="23"
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
	                				<h:inputText id="txtPopupDutyAmt" value="#{popupCuttingBean.popupCuttingSP.dutyAmt}" size="23"
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
	                				<h:inputText id="txtPopupTotalAmt" value="#{popupCuttingBean.popupCuttingSP.payAmt}" size="23"
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
	                				<h:selectOneMenu id="slctPaymentType" value="#{popupCuttingBean.popupCuttingSP.paymentType}" disabled="true"
	                				rendered="#{not empty popupCuttingBean.popupCuttingSP.paymentType}">
	                					<f:selectItems value="#{popupCuttingBean.paymentTypeList}"/>
									</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
										<h:outputText value="#{jspMsgPopup4['label.paymentMethodBank']}" styleClass="ms7"/>
	                			</td>
	                			<td width="30%">
	                				<h:selectOneMenu id="slctPaymentMethod" value="#{popupCuttingBean.popupCuttingSP.paymentMethod}" disabled="true"
	                				rendered="#{not empty popupCuttingBean.popupCuttingSP.paymentMethod}">
										<f:selectItems value="#{popupCuttingBean.paymentMethodList}"/>
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
										value="#{popupCuttingBean.popupCuttingSP.chqDt}"
										disabled="#{popupCuttingBean.renderedChqDt}"
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
										value="#{popupCuttingBean.popupCuttingSP.chqReceiveDt}"
										disabled="#{popupCuttingBean.renderedChqDt}"
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
	                			<td colspan="3">
	                				<rich:calendar id="cldTransferDtPopup" 
		                				locale="th" 
		                				enableManualInput="true"
										datePattern="dd/MM/yyyy" 
										showWeeksBar="false"
										inputSize="13" 
										value="#{popupCuttingBean.popupCuttingSP.transferDt}"
										disabled="#{popupCuttingBean.renderedTransferDt}"
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
	                				<h:inputText id="txtDoc68" value="#{popupCuttingBean.popupCuttingSP.doc68}" size="23"/>
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
										value="#{popupCuttingBean.popupCuttingSP.doc68Dt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										oninputkeyup="this.value = this.value.substring(0, 10);"
										cellWidth="20px" cellHeight="20px"
										converterMessage="#{popupCuttingBean.messageErrorDate} - #{jspMsgPopup4['column.header.doc68Dt']}"
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
	                				<h:inputText id="txtDocPayment" value="#{popupCuttingBean.popupCuttingSP.docPayment}" size="23"/>
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
										value="#{popupCuttingBean.popupCuttingSP.docPaymentDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										oninputkeyup="this.value = this.value.substring(0, 10);"
										cellWidth="20px" cellHeight="20px"
										converterMessage="#{popupCuttingBean.messageErrorDate} - #{jspMsgPopup4['column.docPaymentDt']}"
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
	                				<h:inputText id="txtDocCancel" value="#{popupCuttingBean.popupCuttingSP.docCancel}" size="23"/>
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
										value="#{popupCuttingBean.popupCuttingSP.docCancelDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										oninputkeyup="this.value = this.value.substring(0, 10);"
										cellWidth="20px" cellHeight="20px"
										converterMessage="#{popupCuttingBean.messageErrorDate} - #{jspMsgPopup4['column.docCancelDt']}"
										label="#{jspMsgPopup4['column.docCancelDt']}">
									</rich:calendar>
			                	</td>
			                </tr>
			                <tr>
			                	<td colspan="4" />
		               		</tr>
		                	<tr>
		                	 	<td colspan="4" align="right">
									<h:panelGroup>
										<a4j:commandButton id="payCutBtn" value="#{jspMsgPopup4['btn.cancelPayment']}" 
										styleClass="rich-button" action="#{navAction.navi}" 
										oncomplete="#{rich:component('common_popupEditCuttingForm')}.show(); return false;"
										 reRender="ddlPaymentStatus,   common_popupEditCuttingFormSave, frmError-common_popupEditCuttingForm">
											<rich:componentControl for="common_popupCuttingForm" operation="hide" event="onclick" />
												
												<a4j:actionparam name="navModule" value="#{popupCuttingBean.paramNavModule}" />
												<a4j:actionparam name="navProgram" value="#{popupCuttingBean.paramNavProgram}" />
												
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
												<a4j:actionparam name="methodWithNavi" value="initPopupPayCut" />	
												
												<a4j:actionparam name="paramFwdNavModule" value="#{popupCuttingBean.paramFwdNavModule}" />
												<a4j:actionparam name="paramFwdNavAction" value="#{popupCuttingBean.paramFwdNavAction}" />
												<a4j:actionparam name="paramFwdNavMethod" value="#{popupCuttingBean.paramFwdNavMethod}" />
										</a4j:commandButton>
									</h:panelGroup>
		                	 	</td>
		              		</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>
				</center>
				
			</rich:panel>
		</a4j:form>
		
	</rich:modalPanel>
	<!-- common_popupCuttingForm << -->
	
	<!-- common_popupEditCuttingForm -->
	<rich:modalPanel id="common_popupEditCuttingForm" width="500" autosized="true" overlapEmbedObjects="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['header.popup.savePayment']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-common_popupEditCuttingForm" style="cursor:pointer" />
					<rich:componentControl for="common_popupEditCuttingForm" attachTo="hide-common_popupEditCuttingForm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid style="">
			<a4j:form id="frmError-common_popupEditCuttingForm">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{popupCuttingBean.renderMessagePopup}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" />  
                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="common_popupEditCuttingFormSave"> 
			<rich:panel id="pnlEditCuttingForm">
			
				<h:panelGrid width="90%" columns="1" cellpadding="0" cellspacing="1">
				<h:panelGroup>
					<table align="center" border="0">
						<tr>
							<td align="right" width="30%">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsgPopup4['label.paymentStatus']}" styleClass="ms7"/>
				            </td>
				            <td width="70%">
								<h:selectOneMenu id="slctPaymentStatusList" value="#{popupCuttingBean.popupCuttingSP.paymentStatus}" 
								rendered="#{not empty popupCuttingBean.popupCuttingSP.paymentStatus}">
									<f:selectItems value="#{popupCuttingBean.paymentStatusList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						
						<tr id="payCutCheckPanel">
							<td align="right" width="30%">
								&nbsp;
				            </td>
				            <td width="70%">
					            <h:selectOneRadio id="payCutCheck" value="#{popupCuttingBean.popupCuttingSP.payCutCheck}" styleClass="ms7">
								   <f:selectItem itemValue="1" itemLabel="#{jspMsgPopup4['label.payAll']}" />
								   <f:selectItem itemValue="2" itemLabel="#{jspMsgPopup4['label.paySome']}" />	   			
								</h:selectOneRadio>
							</td>
						</tr>
						
						<tr id="payCutAmountPanel">
							<td align="right" width="30%">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsgPopup4['label.rcptPayCutAmount']}" styleClass="ms7"/>
				            </td>
				            <td width="70%">
				            	<h:inputText id="rcptPayCutAmountTxt" value="#{popupCuttingBean.popupCuttingSP.rcptPayCutAmount}"  
				            				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" >
				            				 <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				            	</h:inputText> 
				            	<rich:spacer width="5"></rich:spacer>
				            	<h:outputText value="#{jspMsgPopup4['label.bath']}" styleClass="ms7"/>
							</td>
						</tr>
						
						<tr>
							<td align="right" width="30%">
								<h:graphicImage value="images/icon_required.gif"/>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsgPopup4['label.remark']}" styleClass="ms7" />
				            </td>
				            <td width="70%">
				            	<h:inputTextarea id="txtPopRemark" value="#{popupCuttingBean.popupCuttingSP.remarkPaymentStatus}" rows="2" cols="40"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="left">
								<h:panelGroup>
									<a4j:commandButton id="editCuttingBtn" value="Save" styleClass="rich-button" action="#{navAction.navi}" 
									reRender="pnlSearchResult, dtbRentalPayNormalSrch,    frmError-common_popupEditCuttingForm"
									oncomplete="if(#{popupCuttingBean.popupCloseSave == 'true'})#{rich:component('common_popupEditCuttingForm')}.hide(); callReloadAfterEditCutting();">
											
											<a4j:actionparam name="navModule" value="#{popupCuttingBean.paramNavModule}" />
											<a4j:actionparam name="navProgram" value="#{popupCuttingBean.paramNavProgram}" />
		
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
											<a4j:actionparam name="methodWithNavi" value="doUpdStatusPayCut" />	
											
											<a4j:actionparam name="paramFwdNavModule" value="#{popupCuttingBean.paramFwdNavModule}" />
											<a4j:actionparam name="paramFwdNavAction" value="#{popupCuttingBean.paramFwdNavAction}" />
											<a4j:actionparam name="paramFwdNavMethod" value="#{popupCuttingBean.paramFwdNavMethod}" />
									</a4j:commandButton>
									
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" reRender="common_popupEditCuttingFormSave">
										<rich:componentControl for="common_popupEditCuttingForm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
							</td>
						</tr>
					</table>
					
				</h:panelGroup>
				</h:panelGrid>
				
				<!-- reload after call .. must be initial inner of form 'common_popupEditCuttingForm' -->
				<a4j:jsFunction name="reloadAfterEditCutting" action="#{navAction.navi}" reRender="pnlSearchResult" >
					<a4j:actionparam name="navModule" value="#{popupCuttingBean.paramNavModule}" />
					<a4j:actionparam name="navProgram" value="#{popupCuttingBean.paramNavProgram}" />
												
					<a4j:actionparam name="moduleWithNavi" value="#{popupCuttingBean.paramFwdNavModule}" />
					<a4j:actionparam name="actionWithNavi" value="#{popupCuttingBean.paramFwdNavAction}" />
					<a4j:actionparam name="methodWithNavi" value="#{popupCuttingBean.paramFwdNavMethod}" />
				</a4j:jsFunction>
				<!-- reload after call -->
				
	
				<!-- javascript (extensible control) -->
				<script>
					jQuery(function($) {
						var payStat = $('#incContent\\:common_popupEditCuttingFormSave\\:slctPaymentStatusList');
						
						payStatusDis();
						payCutDis();
			
						payStat.change(function() {
							payStatusDis();
						});
			
						$('input[type=radio]').click(function() {
							payCutDis();
						});
					});
			
					function payStatusDis() {
						jQuery(function($) {
							var payStat = $('#incContent\\:common_popupEditCuttingFormSave\\:slctPaymentStatusList');
							var rcptPayCutAmountTxt = $('#incContent\\:common_popupEditCuttingFormSave\\:rcptPayCutAmountTxt');
			
							var payCutCheck_0 = $('#incContent\\:common_popupEditCuttingFormSave\\:payCutCheck\\:0');
							var payCutCheck_1 = $('#incContent\\:common_popupEditCuttingFormSave\\:payCutCheck\\:1');
			
							var payCutCheckPanel = $('#incContent\\:common_popupEditCuttingFormSave table tbody tr#payCutCheckPanel');
							var payCutAmountPanel = $('#incContent\\:common_popupEditCuttingFormSave table tbody tr#payCutAmountPanel');
							
							if(payStat.val() == '13'){
								if(rcptPayCutAmountTxt.val() == ''){
									payCutCheck_0.attr('checked', true);
								} else {
									payCutCheck_1.attr('checked', true);
								}
								
								payCutCheckPanel.show(); 
								payCutAmountPanel.show();
								payCutDis();
							} else {
								//rcptPayCutAmountTxt.val('');
								
								payCutCheckPanel.hide();
								payCutAmountPanel.hide();
							}
						});
					}
			
					function payCutDis() {
						jQuery(function($) {
							var payCutAmountPanel = $('#incContent\\:common_popupEditCuttingFormSave table tbody tr#payCutAmountPanel');
							var paySomeChecked = $('#incContent\\:common_popupEditCuttingFormSave\\:payCutCheck\\:1');
							var rcptPayCutAmountTxt = $('#incContent\\:common_popupEditCuttingFormSave\\:rcptPayCutAmountTxt');
							
							if(paySomeChecked.is(':checked')) {
								payCutAmountPanel.show();
							} else {
								rcptPayCutAmountTxt.val('');
								payCutAmountPanel.hide();
							}
						});
					}
			
					function callReloadAfterEditCutting() { reloadAfterEditCutting(); }
					function callReloadAfterUpdStatusNDisb() { reloadAfterUpdStatusNDisb(); }
				</script>
				<!-- javascript (extensible control) -->
				
			</rich:panel>
		</a4j:form>
	</rich:modalPanel>
	<!-- common_popupEditCuttingForm -->
	
	<!-- common_popupNotDisbursedForm -->
	<rich:modalPanel id="common_popupNotDisbursedForm" width="500" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup4['column.notDisbursed']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-common_popupNotDisbursedForm" style="cursor:pointer" />
					<rich:componentControl for="common_popupNotDisbursedForm" attachTo="hide-common_popupNotDisbursedForm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid>
			<a4j:form id="frmError-common_popupNotDisbursed">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{popupCuttingBean.renderMessagePopup}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="common_popupFrmNotDisbursed"> 
			<rich:panel id="pnlNotDisbursed">
			
				<h:panelGrid width="90%" columns="1" cellpadding="0" cellspacing="1">
				<h:panelGroup>
					<table align="center">
						<tr>
							<td align="right" width="30%">
								<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsgPopup4['label.paymentStatus']}" styleClass="ms7"/>
				            </td>
				            <td width="70%">
				            	<h:selectOneMenu id="slctDisbursedStatusList" value="#{popupCuttingBean.popupCuttingSP.paymentStatus}"
				            	rendered="#{not empty popupCuttingBean.popupCuttingSP.paymentStatus}">
									<f:selectItems value="#{popupCuttingBean.paymentStatusList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td align="right" width="30%">
								<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsgPopup4['label.remark']}" styleClass="ms7" />
				            </td>
				            <td width="70%">
				            	<h:inputTextarea id="txtPopRemark" value="#{popupCuttingBean.popupCuttingSP.remarkPaymentStatus}" rows="2" cols="40"/>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="left">
								<h:panelGroup>
									<a4j:commandButton id="notDisbBtn" value="Save" styleClass="rich-button" action="#{navAction.navi}" 
									oncomplete="if(#{popupCuttingBean.popupCloseSave == 'true'})callReloadAfterUpdStatusNDisb();" >
											<a4j:actionparam name="navModule" value="#{popupCuttingBean.paramNavModule}" />
											<a4j:actionparam name="navProgram" value="#{popupCuttingBean.paramNavProgram}" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
											<a4j:actionparam name="methodWithNavi" value="doUpdStatusNDisb" />
											
											<a4j:actionparam name="paramFwdNavModule" value="#{popupCuttingBean.paramFwdNavModule}" />
											<a4j:actionparam name="paramFwdNavAction" value="#{popupCuttingBean.paramFwdNavAction}" />
											<a4j:actionparam name="paramFwdNavMethod" value="#{popupCuttingBean.paramFwdNavMethod}" />
									</a4j:commandButton>
									<a4j:jsFunction name="popupCutting_reRender" reRender="pnlSearchResult, frmError-common_PopupNotDisbursed, dtbRentalPayNormalSrch, slctDisbursedStatusList"></a4j:jsFunction>		
									<rich:spacer width="10px"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button"   
									reRender="common_popupFrmNotDisbursed">
									<rich:componentControl for="common_popupNotDisbursedForm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
					        </td>
					     </tr>   
					</table>
				
					<!-- reload after call .. must be initial inner of form 'common_popupFrmNotDisbursed' -->
					<a4j:jsFunction name="reloadAfterUpdStatusNDisb" action="#{navAction.navi}" oncomplete="if(#{popupCuttingBean.popupCloseSave == 'true'}){popupCutting_reRender();#{rich:component('common_popupNotDisbursedForm')}.hide();}" >
						<a4j:actionparam name="navModule" value="#{popupCuttingBean.paramNavModule}" />
						<a4j:actionparam name="navProgram" value="#{popupCuttingBean.paramNavProgram}" />
													
						<a4j:actionparam name="moduleWithNavi" value="#{popupCuttingBean.paramFwdNavModule}" />
						<a4j:actionparam name="actionWithNavi" value="#{popupCuttingBean.paramFwdNavAction}" />
						<a4j:actionparam name="methodWithNavi" value="#{popupCuttingBean.paramFwdNavMethod}" />
					</a4j:jsFunction>
					<!-- reload after call -->
				
				</h:panelGroup>
				</h:panelGrid>
				
			</rich:panel>	
		</a4j:form>	
	</rich:modalPanel>
	<!-- common_popupNotDisbursedForm -->
	
	