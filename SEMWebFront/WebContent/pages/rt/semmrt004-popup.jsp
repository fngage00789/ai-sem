<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt004" var="jspMsg"/>
	<rich:modalPanel id="popupEditRentalPayNormal" width="750" autosized="true" minWidth="220">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpEdt']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditRentalPayNormal" style="cursor:pointer"/>
					<rich:componentControl for="popupEditRentalPayNormal" attachTo="hidePopupEditRentalPayNormal" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupEdtSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmEdit"> 
			<rich:panel id="pnlEditRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpEdt']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtContractNo" value="#{semmrt004Bean.rentalPayNormalSearchDSP.contractNo}" size="18" maxlength="15" disabled="true"/>
				                	</td>
				                	<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtExpenseType" value="#{semmrt004Bean.rentalPayNormalSearchDSP.expenseType}" size="30" maxlength="30" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<rich:calendar id="cldDueDtFrom" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt004Bean.rentalPayNormalSearchDSP.dueDt}" showWeeksBar="false" disabled="true"
										inputSize="13"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.periodNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPeriodNo" value="#{semmrt004Bean.rentalPayNormalSearchDSP.periodNo}" size="5" maxlength="2" disabled="true"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.periodType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPeriodType" value="#{semmrt004Bean.rentalPayNormalSearchDSP.payPeriodType}" size="13" maxlength="10" disabled="true"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.payPeriodY']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPayPeriodY" value="#{semmrt004Bean.rentalPayNormalSearchDSP.periodY}" size="2" maxlength="2"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"/>
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
				                		<rich:spacer width="5"/>
				                		<h:inputText id="txtPayPeriodM" value="#{semmrt004Bean.rentalPayNormalSearchDSP.periodM}" size="2" maxlength="2"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"
				                		 />
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
				                		<rich:spacer width="5"/>
				                		<h:inputText id="txtPayPeriodD" value="#{semmrt004Bean.rentalPayNormalSearchDSP.periodD}" size="2" maxlength="3"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"
				                		 />
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.day']}" styleClass="ms7"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.calYear']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlDayPerYear" value="#{semmrt004Bean.rentalPayNormalSearchDSP.calYear}">
		                					<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,ddlDayPerMonth" action="#{semmrt004Action.onrenderAmountVat}">
												<a4j:actionparam name="modeChange" value="year" />
											</a4j:support>
											<f:selectItems value="#{semmrt004Bean.dayPerYearList}"/>
									</h:selectOneMenu>
		                			</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.calMonth']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlDayPerMonth" value="#{semmrt004Bean.rentalPayNormalSearchDSP.calMonth}" >
		                					<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,ddlDayPerYear" action="#{semmrt004Action.onrenderAmountVat}">
												<a4j:actionparam name="modeChange" value="month" />
											</a4j:support>
											<f:selectItems value="#{semmrt004Bean.dayPermonthList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.dueAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtDueAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.dueAmt}"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                		 onblur="return numberformat.moneyFormat(this);"
			                		 onfocus="return numberformat.setCursorPosToEnd(this);"
			                		 maxlength="16" 
			                		 styleClass="inputRight">
									 	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlVatType" value="#{semmrt004Bean.rentalPayNormalSearchDSP.vatType}" disabled="true">
											<f:selectItems value="#{semmrt004Bean.vatTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 	<td align="right" >
										<h:selectBooleanCheckbox id="discountCheckBox" value="#{semmrt004Bean.rentalPayNormalSearchDSP.discountFlg}" >
				                			<a4j:support event="onclick" action="#{semmrt004Action.renderDiscountCheckBox}" reRender="txtDiscountRate,txtDiscountAmt"/>
										</h:selectBooleanCheckbox>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.discount']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="2">
		                				<table width="100%">
		                					<tr>
		                						<td width="100">
						                			<h:inputText id="txtDiscountRate" value="#{semmrt004Bean.rentalPayNormalSearchDSP.discountRate}"
						                			 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
							                		 onfocus="return numberformat.setCursorPosToEnd(this);"
							                		 styleClass="inputRight"
							                		 maxlength="3"
							                		 size="3" 
							                		 disabled="#{!semmrt004Bean.rentalPayNormalSearchDSP.discountFlg}">
							                		 	<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,txtDiscountAmt" action="#{semmrt004Action.calDiscountPercent}"/>
													</h:inputText>
													<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
												</td>
												<td align="left">
													<h:inputText id="txtDiscountAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.discountAmt}"
						                			 onkeypress="return numberformat.keyPressDecimalCustomize(16, this, event);" 
							                		 onfocus="return numberformat.setCursorPosToEnd(this);"
							                		 styleClass="inputRight"
							                		 maxlength="18"
							                		 size="10"
							                		 disabled="#{!semmrt004Bean.rentalPayNormalSearchDSP.discountFlg}">
							                		 	<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,txtDiscountAmt,txtDiscountRate" action="#{semmrt004Action.calDiscountAmt}"/>
							                		 	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
														pattern="#,##0.00"/>
													</h:inputText>
													<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
												</td>
											</tr>
										</table>
									</td>
										
									<td>
										<h:selectBooleanCheckbox id="fineCheckBox" value="#{semmrt004Bean.rentalPayNormalSearchDSP.fineFlg}" >
				                			<a4j:support event="onclick" reRender="txtLimitLost,txtWhtRate"/>
										</h:selectBooleanCheckbox>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.fine']}" styleClass="ms7"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.excAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtExcAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.excAmt}"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                		 onblur="return numberformat.moneyFormat(this);"
			                		 onfocus="return numberformat.setCursorPosToEnd(this);"
			                		 maxlength="16" 
			                		 styleClass="inputRight"
		                			 >
		                			 	<a4j:support event="onchange" action="#{semmrt004Action.onRenderIncludeAmt}" reRender="txtIncAmt,txtExcAmt,frmErrorPopupSave"></a4j:support>
										<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7"/>
										<h:inputText id="txtVatRate" value="#{semmrt004Bean.rentalPayNormalSearchDSP.vatRate}" size="3"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 disabled="true">
										  	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
										  </h:inputText>
				                		<h:outputText value="#{jspMsg['label.vatRate2']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtVatAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.vatAmt}"
		                				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight"
										 disabled="#{semmrt004Bean.renderedvatRate}"
										 >
										 	<a4j:support event="onchange" action="#{semmrt004Action.onRenderIncludeAmt}" reRender="txtIncAmt,txtVatAmt"></a4j:support>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.incAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtIncAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.incAmt}"
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
										<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7"/>
										<h:inputText id="txtWhtRate" value="#{semmrt004Bean.rentalPayNormalSearchDSP.whtRate}" size="3" disabled="true"
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
										 >
										 	<a4j:support event="onchange" action="#{semmrt004Action.onRenderVatRate}" reRender="txtWhtAmt"></a4j:support>
										  	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									    </h:inputText>
				                		<h:outputText value="#{jspMsg['label.vatRate2']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			
				                		<h:inputText id="txtWhtAmt" value="#{semmrt004Bean.rentalPayNormalSearchDSP.whtAmt}"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight"
				                		 disabled="#{semmrt004Bean.renderedWhtRate}"
				                		 >
				                		 	<a4j:support event="onchange" action="#{semmrt004Action.onRenderTotalAmt}" reRender="txtTotalAmtEdit,txtWhtAmt"></a4j:support>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
												pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtTotalAmtEdit" value="#{semmrt004Bean.rentalPayNormalSearchDSP.totalAmt}"
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
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupEdtSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError" 
									oncomplete="if(#{semmrt004Bean.popupClose == 'true'})#{rich:component('popupEditRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
										<a4j:actionparam name="methodWithNavi" value="doSaveEdt" />
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" 
									 reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError" >
										<rich:componentControl for="popupEditRentalPayNormal" operation="hide" event="onclick" />
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
	
	
	<rich:modalPanel id="popupApproveRentalPayNormal" width="470" minWidth="250" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupApproveRentalPayNormal" style="cursor:pointer"/>
					<rich:componentControl for="popupApproveRentalPayNormal" attachTo="hidePopupApproveRentalPayNormal" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupApproveSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmAct">
			<rich:panel id="pnlEditRentalPayNormal">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpApprove']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td align="right" valign="top" colspan="3" width="50%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputTextarea id="txtremark" value="#{semmrt004Bean.remark}" rows="3" cols="60"/>
				                	</td>
				                	<td>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td colspan="3" width="50%"></td>
			                	 	<td width="25%">
			                	 		<a4j:commandButton id="btnPopupApproveSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError" 
									oncomplete="if(#{semmrt004Bean.popupClose == 'true'})#{rich:component('popupApproveRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}" 
									 reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError">
									 <a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
										<a4j:actionparam name="methodWithNavi" value="doClearApproveStatus" />
										<rich:componentControl for="popupApproveRentalPayNormal" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>