<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt004" var="jspMsg"/>
	<rich:modalPanel id="popupRentalPayNormal" width="600" autosized="true" minWidth="220">
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
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorPopupSave">
				 <h:outputText value="#{semmrt004Bean.checkVendor.msgWarning}" styleClass="ms7red"></h:outputText>
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt004Bean.renderedMsgFormSearch}">
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
				<rich:panel id="pnlRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.name']}"/>
				</f:facet>
				<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.totalAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtTotalAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.totalAmt}"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight"
										 disabled="true">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0.00"/>
										</h:inputText>
										
									</td>
				                	<td align="right" width="25%">
									<h:selectBooleanCheckbox id="chkDepositFlag" value="#{semmrt004Bean.chkDeposit}" onclick="ChangeDeposit2();" disabled="#{semmrt004Bean.periodNo == '1'}"/>
									<a4j:jsFunction name="ChangeDeposit2" action="#{semmrt004Action.onRenderDepositAmt}"  
															 reRender="txtDepositAmt,txtPaymentAmt">
									</a4j:jsFunction>
									<h:outputText value="#{jspMsg['label.depositFlag']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtDepositAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.depositAmt}"
										  onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			  onblur="return numberformat.moneyFormat(this);"
			                			  onfocus="return numberformat.setCursorPosToEnd(this);"
			                			  maxlength="16" 
			                			  styleClass="inputRight"
										  disabled="#{semmrt004Bean.renderedDepositAmt}">
										  	<a4j:support event="onchange" action="#{semmrt004Action.onRenderTotal}" reRender="frmErrorPopupSave,txtPaymentAmt"></a4j:support>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
																pattern="#,##0.00"/>
										 </h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.paymentAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<h:inputText id="txtPaymentAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.paymentAmt}"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight"
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
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmrt004Bean.rentalPayNormalSearchDSP.paymentType}" onchange="ChangeCalendar();">
												<f:selectItems value="#{semmrt004Bean.paymentTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="ChangeCalendar" action="#{semmrt004Action.onRenderPaymentMethod}"  
										 reRender="cldTransferDt,cldChqReceiveDt,cldChqDt,ddlPaymentMethod">
										</a4j:jsFunction>
				                	</td>
				                	<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentMethod" value="#{semmrt004Bean.rentalPayNormalSearchDSP.paymentMethod}" disabled="#{semmrt004Bean.renderedPaymentMethod}">
												<f:selectItems value="#{semmrt004Bean.paymentMethodList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bankAccNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankAccNo" value="#{semmrt004Bean.rentalPayNormalSearchDSP.bankAccNo}" size="18" maxlength="15" disabled="true"/>
		                			</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtBankName" value="#{semmrt004Bean.rentalPayNormalSearchDSP.bankName}" size="18" maxlength="15" disabled="true"/>
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
											value="#{semmrt004Bean.rentalPayNormalSearchDSP.chqDt}"
											disabled="#{semmrt004Bean.renderedChqDt}"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											cellWidth="20px" cellHeight="20px" 
											label="#{jspMsg['column.header.chqDt']}"
											oninputblur="validateRichCalendarFromTo('popupFrmSave','cldChqDt','cldChqReceiveDt');"
									 		oncollapse="validateRichCalendarFromTo('popupFrmSave','cldChqDt','cldChqReceiveDt');">
											</rich:calendar>
				                	</td>
				                	<td align="right" width="25%">
										<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<rich:calendar id="cldChqReceiveDt" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt004Bean.rentalPayNormalSearchDSP.chqReceiveDt}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmrt004Bean.renderedChqDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.chqReceiveDt']}">
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
										datePattern="dd/MM/yyyy" value="#{semmrt004Bean.rentalPayNormalSearchDSP.transferDt}" showWeeksBar="false"
										inputSize="13"
										disabled="#{semmrt004Bean.renderedTransferDt}"
										oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['column.header.transferDt']}">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="75%">
			                			<h:inputTextarea id="txtRemark" value="#{semmrt004Bean.rentalPayNormalSearchDSP.remark}" rows="3" cols="65"/>
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
									action="#{navAction.navi}" reRender="frmErrorPopupSave,dtbRentalPayNormalSrch,frmError" 
									oncomplete="if(#{semmrt004Bean.popupClose == 'true'})#{rich:component('popupRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
										<a4j:actionparam name="methodWithNavi" value="doSavePay" />
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="#{jspMsg['btn.cancle']}" styleClass="rich-button" immediate="true"
									 reRender="frmErrorPopupSave,dtbRentalPayNormalSrch,frmError">
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
		</a4j:form>
	</rich:modalPanel>