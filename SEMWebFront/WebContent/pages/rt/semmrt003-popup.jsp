<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
	<rich:modalPanel id="popupEditRentalPayNormal" width="800" autosized="true" minWidth="220">
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
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="0">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtContractNo" value="#{semmrt003Bean.rentalPayNormalSearchDSP.contractNo}" size="18" maxlength="15" disabled="true"/>
				                	</td>
				                <%-- 	<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlExpenseTypePop" value="#{semmrt003Bean.rentalPayNormalSearchDSP.expenseType}" 
		                				disabled="#{semmrt003Bean.hasCheckExtraFine}"
		                				onchange="onChangeExpenseType();">
											<f:selectItems value="#{semmrt003Bean.rentalPayExpenseTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="onChangeExpenseType" action="#{semmrt003Action.onChangeExpenseType}" reRender="pnlEditRentalPayNormal"/>
				                	</td> 
				                	--%>
			                	 </tr>
			                	 <tr>
									
				                	<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlExpenseTypePop" value="#{semmrt003Bean.rentalPayNormalSearchDSP.expenseType}" 
		                				disabled="#{semmrt003Bean.hasCheckExtraFine}"
		                				onchange="onChangeExpenseType();">
											<f:selectItems value="#{semmrt003Bean.rentalPayExpenseTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="onChangeExpenseType" action="#{semmrt003Action.onChangeExpenseType}" reRender="pnlEditRentalPayNormal"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.expenseDesc']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">		                		
				                	<h:inputTextarea id="txtExpenseDesc" style="width:100%;" rows="2" 
					       					value="#{semmrt003Bean.rentalPayNormalSearchDSP.expenseDesc}" 
					       					disabled="true">
					       			</h:inputTextarea>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<rich:calendar id="cldDueDtFrom" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt003Bean.rentalPayNormalSearchDSP.dueDt}" showWeeksBar="false" disabled="#{semmrt003Bean.hasCheckExtraFine}"
										inputSize="13"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.periodNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPeriodNo" value="#{semmrt003Bean.rentalPayNormalSearchDSP.periodNo}" size="5" maxlength="2" disabled="true"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.periodType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlpayPeriodTypePop" value="#{semmrt003Bean.rentalPayNormalSearchDSP.payPeriodType}" disabled="#{semmrt003Bean.hasCheckExtraFine}">
											<f:selectItems value="#{semmrt003Bean.periodTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.payPeriodY']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPayPeriodY" value="#{semmrt003Bean.rentalPayNormalSearchDSP.periodY}" size="2" maxlength="2"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"/>
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
				                		<rich:spacer width="5"/>
				                		<h:inputText id="txtPayPeriodM" value="#{semmrt003Bean.rentalPayNormalSearchDSP.periodM}" size="2" maxlength="2"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"
				                		 />
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
				                		<rich:spacer width="5"/>
				                		<h:inputText id="txtPayPeriodD" value="#{semmrt003Bean.rentalPayNormalSearchDSP.periodD}" size="2" maxlength="3"
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
		                			<h:selectOneMenu id="ddlDayPerYear" value="#{semmrt003Bean.rentalPayNormalSearchDSP.calYear}" >
											<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,ddlDayPerMonth" action="#{semmrt003Action.onrenderAmountVat}">
												<a4j:actionparam name="modeChange" value="year" />
											</a4j:support>
											<f:selectItems value="#{semmrt003Bean.dayPerYearList}"/>
									</h:selectOneMenu>
		                			</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.calMonth']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlDayPerMonth" value="#{semmrt003Bean.rentalPayNormalSearchDSP.calMonth}" >
											<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,ddlDayPerYear" action="#{semmrt003Action.onrenderAmountVat}">
												<a4j:actionparam name="modeChange" value="month" />
											</a4j:support>
											<f:selectItems value="#{semmrt003Bean.dayPermonthList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.dueAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtDueAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.dueAmt}"
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
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlVatType" value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatType}" 
		                				disabled="#{semmrt003Bean.hasCheckExtraFine}"
		                				onchange="onChangeVat();">
											<f:selectItems value="#{semmrt003Bean.vatTypeList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="onChangeVat" action="#{semmrt003Action.onChangeVatType}" reRender="pnlEditRentalPayNormal">
									</a4j:jsFunction>
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 	<td width="25%"></td>
			                	 	<td width="25%"></td>
			                	 	<td width="25%" align="right">
				                	 	<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
			                	 	</td>
			                	 	<td width="25%">
										<h:selectOneMenu id="ddlWhtType" value="#{semmrt003Bean.rentalPayNormalSearchDSP.whtType}" disabled="#{semmrt003Bean.hasCheckExtraFine}"
										onchange="onChangeWht();">
												<f:selectItems value="#{semmrt003Bean.whtTypeList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="onChangeWht" action="#{semmrt003Action.changeWhtType}" reRender="pnlEditRentalPayNormal">
										</a4j:jsFunction>
					                	</td>
			                	 </tr>
			                	 <tr>
			                	 	<td width="25%" align="right">
			                	 	<h:selectBooleanCheckbox id="discountCheckBox" value="#{semmrt003Bean.rentalPayNormalSearchDSP.discountFlg}" >
				                			<a4j:support event="onclick" action="#{semmrt003Action.renderDiscountCheckBox}" reRender="ddlVatBefore,ddlWhtBefore,txtDiscountRate,txtDiscountAmt"/>
										</h:selectBooleanCheckbox>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.discount']}" styleClass="ms7"/>
			                	 	</td>
			                	 	<td width="25%">
			                	 		<h:selectOneMenu id="ddlVatBefore" value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatBefore}"  disabled="#{!semmrt003Bean.rentalPayNormalSearchDSP.discountFlg}">
												<f:selectItem itemLabel="ก่อน" itemValue="01"/>
												<f:selectItem itemLabel="หลัง" itemValue="02"/>
										</h:selectOneMenu>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.vatWht']}" styleClass="ms7"/>
			                	 	</td>
			                	 	<td width="25%" align="right">
			                	 	</td>
			                	 	<td width="25%">
										<a4j:commandButton id="btnPopupEdtCal" value="#{jspMsg['btn.calculate']}" styleClass="rich-button"
										action="#{navAction.navi}" reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,btnPopupEdtSave,frmError,pnlSearchResult,txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,ddlDayPerYear">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doCalculate" />
										</a4j:commandButton>
					                </td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" >
										<h:outputText value="#{jspMsg['label.discount']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="2">
		                				<table width="100%">
		                					<tr>
		                						<td width="100">
						                			<h:inputText id="txtDiscountRate" value="#{semmrt003Bean.rentalPayNormalSearchDSP.discountRate}"
						                			 onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
							                		 onfocus="return numberformat.setCursorPosToEnd(this);"
							                		 styleClass="inputRight"
							                		 maxlength="3"
							                		 size="3" 
							                		 disabled="#{!semmrt003Bean.rentalPayNormalSearchDSP.discountFlg}">
							                		 	<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,txtDiscountAmt" action="#{semmrt003Action.calDiscountPercent}"/>
													</h:inputText>
													<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
												</td>
												<td align="left">
													<h:inputText id="txtDiscountAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.discountAmt}"
						                			 onkeypress="return numberformat.keyPressDecimalCustomize(16, this, event);" 
							                		 onfocus="return numberformat.setCursorPosToEnd(this);"
							                		 styleClass="inputRight"
							                		 maxlength="18"
							                		 size="10"
							                		 disabled="#{!semmrt003Bean.rentalPayNormalSearchDSP.discountFlg}">
							                		 	<a4j:support event="onchange" reRender="txtDueAmt,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtTotalAmtEdit,txtDiscountAmt,txtDiscountRate" action="#{semmrt003Action.calDiscountAmt}"/>
							                		 	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
														pattern="#,##0.00"/>
													</h:inputText>
													<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
												</td>
											</tr>
										</table>
									</td>
										
									<td>
										<h:selectBooleanCheckbox id="fineCheckBox" value="#{semmrt003Bean.rentalPayNormalSearchDSP.fineFlg}" disabled="true" >
				                			<a4j:support event="onclick" action="#{semmrt003Action.onCheckFineExtraFlag}" reRender="txtLimitLost,txtWhtRate,btnPopupEdtDelete,extraCheckBox,pnlEditRentalPayNormal">
				                				<f:param name="fineFlag" value="Y"/>
				                			</a4j:support>
										</h:selectBooleanCheckbox>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.fine']}" styleClass="ms7"/>
										<rich:spacer width="5"/>
										<h:selectBooleanCheckbox id="extraCheckBox" value="#{semmrt003Bean.rentalPayNormalSearchDSP.extraFlg}" disabled="true" >
											<a4j:support event="onclick" action="#{semmrt003Action.onCheckFineExtraFlag}" reRender="btnPopupEdtDelete,pnlEditRentalPayNormal,fineCheckBox">
												<f:param name="fineFlag" value="N"/>
											</a4j:support>
										</h:selectBooleanCheckbox>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.extra']}" styleClass="ms7"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.excAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtExcAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.excAmt}"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                		 maxlength="16" 
			                		 styleClass="inputRight"
			                		 >
		                			 	<a4j:support event="onchange" action="#{semmrt003Action.onRenderIncludeAmt}" reRender="txtIncAmt,txtExcAmt,txtTotalAmtEdit,txtVatAmt,txtWhtAmt">
		                			 		<f:param name="excAmtFlag" value="Y"></f:param>
		                			 	</a4j:support>
										<f:convertNumber integerOnly="false"  maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
									
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7"/>
										<h:inputText id="txtVatRate" value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatRate}" size="3"
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
		                				<h:inputText id="txtVatAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatAmt}" size="18"
		                				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight"
										 disabled="#{semmrt003Bean.hasCheckExtraFine}">
											<a4j:support event="onchange" action="#{semmrt003Action.onRenderIncludeAmt}" reRender="txtIncAmt,txtExcAmt,txtTotalAmtEdit"></a4j:support>
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
		                			<h:inputText id="txtIncAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.incAmt}" size="18"
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
										
										<h:inputText id="txtWhtRate" value="#{semmrt003Bean.rentalPayNormalSearchDSP.whtRate}" size="3" 
										 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 maxlength="4" 
				                		 >
				                		 	<a4j:support event="onchange" action="#{semmrt003Action.onRenderWhtAmt}" reRender="txtTotalAmtEdit,txtWhtAmt,txtWhtRate"></a4j:support>
										  	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									    </h:inputText>
				                		<h:outputText value="#{jspMsg['label.vatRate2']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			
				                		<h:inputText id="txtWhtAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.whtAmt}" size="18"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 maxlength="16" 
				                		 styleClass="inputRight">
				                		 	<a4j:support event="onchange" action="#{semmrt003Action.onRenderTotalAmt}" reRender="txtTotalAmtEdit,txtWhtAmt"></a4j:support>
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
		                			<h:inputText id="txtTotalAmtEdit" value="#{semmrt003Bean.rentalPayNormalSearchDSP.totalAmt}" size="18"
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
			                	 <td colspan="3">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupEdtSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError,pnlSearchResult" 
									disabled="#{!semmrt003Bean.chkClickCal}"
									oncomplete="if(#{semmrt003Bean.popupClose == 'true'})#{rich:component('popupEditRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveEdt" />
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" 
									 reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError" >
										<rich:componentControl for="popupEditRentalPayNormal" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 <td align="right">
			                	 	<a4j:commandButton id="btnPopupEditCreate" value="#{jspMsg['btn.create']}" styleClass="rich-button" immediate="true"
										action="#{navAction.navi}" reRender="popupEditCreatNew,frmErrorPopupEditCreatNew,popupFrmEditCreatNew" 
										oncomplete="#{rich:component('popupEditCreatNew')}.show(); return false" >
										<rich:componentControl for="popupEditRentalPayNormal" operation="hide" event="onclick" />										
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doInitCreate" />
									</a4j:commandButton>
									<rich:spacer width="5px"></rich:spacer>
			                	 	<a4j:commandButton id="btnPopupEdtDelete" value="#{jspMsg['btn.delete']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError,pnlSearchResult"
									disabled="#{semmrt003Bean.hasCheckExtraFine}" 
									oncomplete="if(#{semmrt003Bean.popupClose == 'true'})#{rich:component('popupEditRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveEdt" />
										<f:param name="deleteFlag" value="Y"/>
									</a4j:commandButton>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	
	<rich:modalPanel id="popupEditCreatNew" width="1000" minWidth="1000" height="600" autosized="false" style="overflow:auto;">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupEditCreateNew']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditCreatNew" style="cursor:pointer"/>
					<rich:componentControl for="popupEditCreatNew" attachTo="hidePopupEditCreatNew" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupEditCreatNew">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderEditCreatNewMessage}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmEditCreatNew">
			<rich:panel id="pnlEditCreatNew" >
				
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%" border="0">
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtCtContractNo" value="#{semmrt003Bean.rentalPayNormalSearchDSP.contractNo}" size="18" maxlength="15" disabled="true"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtCtSiteName" value="#{semmrt003Bean.rentalPayNormalSearchDSP.siteName}" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldEffDate" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt003Bean.rentalPayNormalSearchDSP.effDate}" showWeeksBar="false" disabled="true"
										inputSize="13" onchanged="reRenderDt();"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.expDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldExpDate" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt003Bean.rentalPayNormalSearchDSP.expDate}" showWeeksBar="false" disabled="true"
										inputSize="13" onchanged="reRenderDt();"/>
				                	</td>
				                	<a4j:jsFunction name="reRenderDt" reRender="cldEffDate,cldExpDate"></a4j:jsFunction>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif" rendered="true"/>
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlCtExpenseTypePop" value="#{semmrt003Bean.rentalPayNormalSearchDSP.expenseType}" 
		                				disabled="false">
											<f:selectItems value="#{semmrt003Bean.expenseTypeListCreate}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:graphicImage value="images/icon_required.gif" rendered="true"/>
										<h:outputText value="#{jspMsg['label.expense']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlCtExpense" value="#{semmrt003Bean.rentalPayNormalSearchDSP.expense}" 
		                				disabled="false">
											<f:selectItem itemLabel="จ่ายค่าปรับ" itemValue="Y" />
											<f:selectItem itemLabel="Pay Extra" itemValue="N" />
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%" valign="top">
				                		<h:outputText value="#{jspMsg['label.whtTypeTH']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="25%" valign="top">
										<h:selectOneRadio id="rbtCtWhtType" styleClass="ms7" layout="pageDirection" 
											value="#{semmrt003Bean.rentalPayNormalSearchDSP.whtType}" onclick="changeCtDefaultWht();" >
											<a4j:jsFunction name="changeCtDefaultWht" 
				                							reRender="rbtCtWhtType,txtCtWhtRate" 
				                							action="#{semmrt003Action.setChangeWht}">
				              				</a4j:jsFunction>
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
										</h:selectOneRadio>
					                </td>	
					                <td valign="top" align="right">
					                <h:graphicImage value="images/icon_required.gif" rendered="true"/>
										<h:outputText value="#{jspMsg['label.whtRateTH']}" styleClass="ms7"/>
									</td>	
									<td  valign="top">
										<h:inputText id="txtCtWhtRate" disabled="#{!semmrt003Bean.disWhtRate}" 
											value="#{semmrt003Bean.rentalPayNormalSearchDSP.whtRate}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="onblurVatTypeJS();return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" size="3">
		                					<f:convertNumber pattern="#,##0"  maxIntegerDigits="13" />
		                				</h:inputText>
										<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
										<rich:spacer width="5"/>
										<h:selectBooleanCheckbox id="editCtWhtRateSelected" value="#{semmrt003Bean.disWhtRate}" 
											onclick="chkCtVisibleWhtRateJS();" disabled="false">
											<a4j:jsFunction name="chkCtVisibleWhtRateJS" 
												reRender="txtCtWhtRate"></a4j:jsFunction>
										</h:selectBooleanCheckbox>
						                <rich:spacer width="2"/>
						                <h:outputText value="#{jspMsg['label.edit']}" styleClass="ms7"/>
					                </td>
				                </tr>
			                	 	
			                	<tr>
				                	<td align="right" width="25%">
				                		<h:outputText value="#{jspMsg['label.vatTH']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="75%" colspan="3">
				                	<table width="100%">
				                		<tr>
				                		<td width="45%">
										<h:selectOneRadio id="rbtCtVatType" styleClass="ms7" 
											value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatType}" 
											disabled="false" onclick="changeDefaultVat();">
											<a4j:jsFunction name="changeDefaultVat" 
				                							reRender="rbtCtVatType,txtCtVatRate" 
				                							action="#{semmrt003Action.setChangeVat}">
				              				</a4j:jsFunction>
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
										</h:selectOneRadio>
									</td>
									<td width="20%" align="right">
					                	<h:outputText value="#{jspMsg['label.vatRateOnly']}" styleClass="ms7" />
					                </td>
					                <td>
					               <rich:spacer width="5"></rich:spacer>
					                	<h:inputText id="txtCtVatRate" disabled="true" 
											size="5" value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatRate}"/>
									</td>
									</tr>
									</table>
					                </td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="25%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodStDt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="25%">
				                		<rich:calendar id="cldCtPeriodStDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt003Bean.rentalPayNormalSearchDSP.periodStartDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   oninputblur="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
											 	   oncollapse="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.periodStDt']}" 
											   	   disabled="#{semmrt003Bean.viewMode}">
											   	   
										</rich:calendar>
										</td>
										<td width="20%" align="right"><h:graphicImage 
											value="images/icon_required.gif" rendered="true"/><rich:spacer width="5"></rich:spacer><h:outputText 
											value="#{jspMsg['label.periodEndDt']}" styleClass="ms7"></h:outputText>
										</td>
										<td width="30%">	
										<rich:calendar id="cldCtPeriodEndDt" locale="th" enableManualInput="true"  
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt003Bean.rentalPayNormalSearchDSP.periodEndDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   onchanged="changeDate();"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   oninputblur="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
											 	   oncollapse="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.periodEndDt']}" 
											   	   disabled="#{semmrt003Bean.viewMode}">
										</rich:calendar>
										
										<a4j:jsFunction name="changeDate" reRender="cldCtPeriodStDt,cldCtPeriodEndDt"></a4j:jsFunction>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="25%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodAmt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="75%" colspan="3">
				                		<h:inputText id="txtCtPeriodAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.dueAmt}" size="18"
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" 
		                					styleClass="inputRight" 
		                					disabled="#{semmrt003Bean.viewMode}">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                		<rich:spacer width="20px"></rich:spacer>
				                		<h:panelGroup >
											<a4j:commandButton id="btnCtCalculate" value="Calculate" styleClass="rich-button"
												action="#{semmrt003Action.doCalculateCreate}" 
												reRender="btnCtCalculate,txtCtExcAmt,txtCtIncAmt,txtCtTotalAmt,txtCtWhtAmt,txtCtVatAmt">
							            	</a4j:commandButton>
						            	</h:panelGroup>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.excAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtCtExcAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.excAmt}" size="18"
		                				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight" >
		                			 	<a4j:support event="onchange" action="#{semmrt003Action.onRenderIncludeAmtCreate}" reRender="txtCtIncAmt,txtCtExcAmt,txtCtTotalAmt,txtCtVatAmt,txtCtWhtAmt">
		                			 		<f:param name="excAmtFlag" value="Y"></f:param>
		                			 	</a4j:support>
										<f:convertNumber integerOnly="false"  maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
									
				                	</td>
				                	<td align="right" width="25%">
				                		<h:outputText value="#{jspMsg['label.vatAmnt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtCtVatAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.vatAmt}" size="18"
		                				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
			                			 styleClass="inputRight"
										 disabled="false">
											<a4j:support event="onchange" action="#{semmrt003Action.onRenderIncludeAmtCreate}" reRender="txtCtIncAmt,txtCtExcAmt,txtCtTotalAmt"></a4j:support>
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
		                			<h:inputText id="txtCtIncAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.incAmt}" size="18"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                		 onblur="return numberformat.moneyFormat(this);"
			                		 onfocus="return numberformat.setCursorPosToEnd(this);"
			                		 maxlength="16" 
			                		 styleClass="inputRight"
		                			 disabled="false">
		                			 <a4j:support event="onchange" action="#{semmrt003Action.onRenderWhtInclude}" reRender="txtCtExcAmt,txtCtIncAmt,txtCtTotalAmt,txtCtWhtAmt"></a4j:support>
										<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
									
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.whtAmnt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
				                		<h:inputText id="txtCtWhtAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.whtAmt}" size="18"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 maxlength="16" 
				                		 styleClass="inputRight"
				                		 
				                		 >
				                		 	<a4j:support event="onchange" action="#{semmrt003Action.onRenderTotalAmtCreate}" reRender="txtCtTotalAmt,txtCtWhtAmt"></a4j:support>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" 
												pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 	  
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputText id="txtCtTotalAmt" value="#{semmrt003Bean.rentalPayNormalSearchDSP.totalAmt}" size="18"
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
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="75%" colspan="3">
											<h:selectOneMenu value="#{semmrt003Bean.rentalPayNormalSearchDSP.vendorMasterId}" style="width:250px;">
				                			<f:selectItems value="#{semmrt003Bean.vendorList}"/>
				                			</h:selectOneMenu>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="25%">
				                		<h:outputText value="#{jspMsg['label.payee']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="75%" colspan="3">
				                		<h:selectOneMenu value="#{semmrt003Bean.rentalPayNormalSearchDSP.payeeId}" style="width:250px;">
				                			<f:selectItems value="#{semmrt003Bean.payeeList}"/>
				                		</h:selectOneMenu>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="25%">
				                		<h:outputText value="#{jspMsg['label.bookBank']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="75%" colspan="3">
				                		<h:inputText id="txtCtBookBank" disabled="true" value="#{semmrt003Bean.rentalPayNormalSearchDSP.bankAccNo}" 
				                			style="width: 250px"/>
				                		<rich:spacer width="40" />
				                		<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
				                		<rich:spacer width="5" />
				                		<h:inputText id="txtCtBankName" disabled="true" value="#{semmrt003Bean.rentalPayNormalSearchDSP.bankName}" 
				                			style="width: 250px"/>
				                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="25%" valign="top">
				                		<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="75%" colspan="3">
				                		<h:inputTextarea cols="100" rows="3" value="#{semmrt003Bean.rentalPayNormalSearchDSP.remark}" 
				                			disabled="#{semmrt003Bean.viewMode}"></h:inputTextarea>
				                	</td>
				                </tr>
				                <tr>
				                	<td colspan="4">
				                		<rich:spacer width="10"></rich:spacer>
				                	</td>
				                </tr>
				                
				                 <tr>
				                 	<td><rich:spacer width="10px"/></td>
				                	<td colspan="3" align="left">
				                			<a4j:commandButton id="btnCtSave" value="Save" styleClass="rich-button"
												action="#{navAction.navi}" reRender="btnCtSave,popupFrmEditCreatNew,pnlEditCreatNew,frmErrorPopupEditCreatNew,frmError,pnlSearchResult" 
												oncomplete="if(#{semmrt003Bean.popupClose == 'true'})#{rich:component('popupEditCreatNew')}.hide();">
							            		<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
												<a4j:actionparam name="methodWithNavi" value="doCtSaveAction" />
							            	</a4j:commandButton>
							            	<rich:spacer width="10px"></rich:spacer>
							            	<a4j:commandButton id="btnCtCancel" value="Cancel" styleClass="rich-button" immediate="true" 
									 			reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmError" >
												<rich:componentControl for="popupEditCreatNew" operation="hide" event="onclick" />
											</a4j:commandButton>
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
		                			<h:inputTextarea id="txtremark" value="#{semmrt003Bean.remark}" rows="3" cols="60"/>
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
									action="#{navAction.navi}" reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError,frmSearchResult" 
									oncomplete="if(#{semmrt003Bean.popupClose == 'true'})#{rich:component('popupApproveRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
									 reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError">
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
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
	
	<rich:modalPanel id="popupEditRentalPayNormalRemark" width="400" autosized="true" minWidth="220">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpRemark']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditRentalPayNormalRemark" style="cursor:pointer"/>
					<rich:componentControl for="popupEditRentalPayNormalRemark" attachTo="hidePopupEditRentalPayNormalRemark" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupFrmRemark">
			<table width="100%">
				<tr> 
					<td>
						<rich:panel id="pnlPopupRentalPayNormalRemark">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['panel.remark']}"/>
							</f:facet>
								
								<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="0">
									<h:panelGroup>
									<table width="100%">
										<tr>
											<td valign="top">
												<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
											</td>
											<td>
												<h:inputTextarea id="txtRemarkEdit" cols="40" rows="4" value="#{semmrt003Bean.mrt003UpdateRemark.remark}"  >
												</h:inputTextarea>
											</td>
										</tr>
									</table>
									</h:panelGroup>
								</h:panelGrid>
						</rich:panel>
					</td>
				</tr>
				<tr>
					<td>
						<rich:panel id="pnlPopupRentalPayNormalRemarkOther">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['panel.remarkOther']}"/>
							</f:facet>
								<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="0">
									<h:panelGroup>
									<table width="100%">
										<tr>
											<td valign="top">
												<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
											</td>
											<td>
												<h:inputTextarea id="textRemarkOther" cols="40" rows="4" value="#{semmrt003Bean.mrt003UpdateRemark.remarkOther}" />
												<a4j:jsFunction name="jsReRender" reRender="textRemarkOther,txtRemark"></a4j:jsFunction>
											</td>
										</tr>
									</table>
									</h:panelGroup>
								</h:panelGrid>
						</rich:panel>
					</td>
				</tr>
				<tr>
					<td align="center">
						<a4j:commandButton value="Save" styleClass="rich-button" action="#{navAction.navi}"
							 reRender="popupFrmRemark,frmErrorPopupApproveSave,pnlSearchResult,dtbRentalPayNormalSrch,frmError,pnlPopupRentalPayNormalRemarkOther" 
							 oncomplete="if(#{semmrt003Bean.popupEditRemarkClose == 'true'})#{rich:component('popupEditRentalPayNormalRemark')}.hide();">
						 	<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateRemark" />
						</a4j:commandButton>
						<rich:spacer width="5"/>
						<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError">
						 <rich:componentControl for="popupEditRentalPayNormalRemark" operation="hide" event="onclick" />						 	
						</a4j:commandButton>
					</td>
				</tr>
			</table>
		</a4j:form>
	</rich:modalPanel>