<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
	<rich:modalPanel id="popupRentalPayNormal" width="550" autosized="true" minWidth="220">
		<f:facet name="header">
				<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupRentalPayNormal" style="cursor:pointer"/>
					<rich:componentControl for="popupRentalPayNormal" attachTo="hidePopupRentalPayNormal" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
		<table width="100%" border="0">
			<a4j:form id="frmErrorPopupSave">
			<tr>
				<td>
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt001PayBean.renderedMsgFormPopup}">
					 		<f:facet name="header">
	                        	<h:outputText value="Entered Data Status:"></h:outputText>
	                    	</f:facet>
				 			<f:facet name="errorMarker">
				 				 <h:graphicImage value="images/error.gif" />  
		                    </f:facet>
	                </rich:messages>
				</td>
			</tr>
			</a4j:form>
			</table>
		</h:panelGrid>
		<a4j:form id="popupFrmSave"> 
			<h:panelGrid width="550" id="grdPopupRentalPlan">
				<rich:panel id="pnlRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.name']}"/>
				</f:facet>
				<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.paymentAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<h:inputText id="txtPaymentAmt" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.paymentAmt}"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 styleClass="inputRight"
			                			 maxlength="16" 
			                			 disabled="true">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.paymentType}" onchange="ChangeCalendar();">
												<f:selectItems value="#{semmrt001PayBean.paymentTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeCalendar" action="#{semmrt001PayAction.onRenderPaymentMethod}"  
										 reRender="cldTransferDt,cldChqReceiveDt,cldChqDt,ddlPaymentMethod">
										</a4j:jsFunction>
				                	</td>
				                	<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentMethod" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.paymentMethod}" disabled="#{semmrt001PayBean.renderedPaymentMethod}">
												<f:selectItems value="#{semmrt001PayBean.paymentMethodList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bankAccNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankAccNo" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.bankAccNo}" size="18" maxlength="15" disabled="true"/>
		                			</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankName" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.bankName}" size="18" maxlength="15" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
						<h:outputText value="#{jspMsg['label.chqDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldChqDt" 
			                				locale="th" 
			                				enableManualInput="true"
											datePattern="dd/MM/yyyy" 
											showWeeksBar="false"
											inputSize="13" 
											value="#{semmrt001PayBean.rentalPayNormalSearchDSP.chqDt}"
											disabled="#{semmrt001PayBean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputkeyup="this.value = this.value.substring(0, 10);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['column.header.chqDt']}">
												<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmErrorPopupSave" />
												<a4j:support event="onchanged" ajaxSingle="true" reRender="frmErrorPopupSave" />
											</rich:calendar>
				                	</td>
				                	<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldChqReceiveDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.chqReceiveDt}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmrt001PayBean.renderedChqDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										oninputkeyup="this.value = this.value.substring(0, 10);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.chqDt']}">
											<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmErrorPopupSave" />
												<a4j:support event="onchanged" ajaxSingle="true" reRender="frmErrorPopupSave" />
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldTransferDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.transferDt}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmrt001PayBean.renderedTransferDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										oninputkeyup="this.value = this.value.substring(0, 10);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.transferDt']}">
											<a4j:support event="oninputblur" ajaxSingle="true" reRender="frmErrorPopupSave" />
												<a4j:support event="onchanged" ajaxSingle="true" reRender="frmErrorPopupSave" />
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="75%">
			                			<h:inputTextarea id="txtRemark" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.remark}" rows="3" cols="65"/>
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
									<a4j:commandButton id="btnPopupSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="frmErrorPopupSave,dtbRentalPayNormalSrch,frmSearchPay,tblMessageRentalPay,pnlSearchResult" 
									oncomplete="if(#{semmrt001PayBean.popupClose == 'true'})#{rich:component('popupRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSavePay" />
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
									 reRender="frmErrorPopupSave,dtbRentalPayNormalSrch,frmSearchPay,tblMessageRentalPay,pnlSearchResult">
										<rich:componentControl for="popupRentalPayNormal" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
				</rich:panel>
				<!-- end content criteria -->
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>