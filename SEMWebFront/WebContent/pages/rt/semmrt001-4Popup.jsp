<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
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
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt001PayBean.renderedMsgFormSearch}">
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
		                			<h:inputText id="txtContractNo" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.contractNo}" size="18" maxlength="15" disabled="true"/>
				                	</td>
				                	<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtExpenseType" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.expenseType}" size="30" maxlength="30" disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<rich:calendar id="cldDueDtFrom" locale="en/US" enableManualInput="true"
										datePattern="dd/MM/yyyy" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.dueDt}" showWeeksBar="false" disabled="true"
										inputSize="13"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.periodNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPeriodNo" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.periodNo}" size="5" maxlength="2" disabled="true"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.periodType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPeriodType" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.payPeriodType}" size="13" maxlength="10" disabled="true"/>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.payPeriodY']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtPayPeriodY" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.periodY}" size="2" maxlength="2"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"/>
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
				                		<rich:spacer width="5"/>
				                		<h:inputText id="txtPayPeriodM" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.periodM}" size="2" maxlength="2"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);" disabled="true"
				                		 />
				                		<rich:spacer width="5"/>
				                		<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
				                		<rich:spacer width="5"/>
				                		<h:inputText id="txtPayPeriodD" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.periodD}" size="2" maxlength="3"
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
		                			<h:selectOneMenu id="ddlDayPerYear" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.calYear}" disabled="#{semmrt001PayBean.renderedYear}">
											<f:selectItems value="#{semmrt001PayBean.dayPerYearList}"/>
									</h:selectOneMenu>
		                			</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.calMonth']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:selectOneMenu id="ddlDayPerMonth" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.calMonth}" disabled="#{semmrt001PayBean.renderedMonth}">
											<f:selectItems value="#{semmrt001PayBean.dayPerYearList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.dueAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtDueAmt" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.dueAmt}"
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
		                			<h:selectOneMenu id="ddlVatType" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.vatType}" disabled="true">
											<f:selectItems value="#{semmrt001PayBean.vatTypeList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.excAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputText id="txtExcAmt" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.excAmt}"
		                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                		 onblur="return numberformat.moneyFormat(this);"
			                		 onfocus="return numberformat.setCursorPosToEnd(this);"
			                		 maxlength="16" 
			                		 styleClass="inputRight"
		                			 >
		                			 	<a4j:support event="onchange" action="#{semmrt001PayAction.onRenderIncludeAmt}" reRender="txtIncAmt,txtExcAmt,frmErrorPopupSave"></a4j:support>
										<f:convertNumber integerOnly="false" maxFractionDigits="2" 
											pattern="#,##0.00"/>
									</h:inputText>
				                	</td>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7"/>
											<h:inputText id="txtVatRate" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.vatRate}" size="3"
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
		                				<h:inputText id="txtVatAmt" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.vatAmt}" size="18"
		                				 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                			 onblur="return numberformat.moneyFormat(this);"
			                			 onfocus="return numberformat.setCursorPosToEnd(this);"
			                			 maxlength="16" 
										 disabled="#{semmrt001PayBean.renderedvatRate}">
											<a4j:support event="onchange" action="#{semmrt001PayAction.onRenderIncludeAmt}" reRender="txtIncAmt,txtExcAmt,frmErrorPopupSave"></a4j:support>
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
		                			<h:inputText id="txtIncAmt" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.incAmt}" size="18"
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
											<h:inputText id="txtWhtRate" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.whtRate}" size="3" disabled="true"
												 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
						                		 onblur="return numberformat.moneyFormat(this);"
						                		 onfocus="return numberformat.setCursorPosToEnd(this);"
						                		 maxlength="16">
						                		 	<f:convertNumber integerOnly="false" maxFractionDigits="2" 
													pattern="#,##0.00"/>
											</h:inputText>
				                		<h:outputText value="#{jspMsg['label.vatRate2']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			
				                		<h:inputText id="txtWhtAmt" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.whtAmt}" size="18"
				                		 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 maxlength="16" 
				                		 styleClass="inputRight"
				                		 disabled="#{semmrt001PayBean.renderedWhtRate}"
				                		 >
				                		 	<a4j:support event="onchange" action="#{semmrt001PayAction.onRenderTotalAmt}" reRender="txtTotalAmtEdit,txtWhtAmt,frmErrorPopupSave"></a4j:support>
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
		                			<h:inputText id="txtTotalAmtEdit" value="#{semmrt001PayBean.rentalPayNormalSearchDSP.totalAmt}" size="18"
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
									action="#{navAction.navi}" reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmSearchPay,tblMessageRentalPay.frmSearchResult" 
									oncomplete="if(#{semmrt001PayBean.popupClose == 'true'})#{rich:component('popupEditRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSaveEdt" />
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" 
									 reRender="frmErrorPopupEdtSave,dtbRentalPayNormalSrch,frmSearchPay,tblMessageRentalPay" >
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
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt001PayBean.renderedMsgFormSearch}">
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
		                			<h:inputTextarea id="txtremark" value="#{semmrt001PayBean.remark}" rows="3" cols="60"/>
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
									action="#{navAction.navi}" reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmSearchPay,tblMessageRentalPay" 
									oncomplete="if(#{semmrt001PayBean.popupClose == 'true'})#{rich:component('popupApproveRentalPayNormal')}.hide();">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
									 reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmSearchPay,tblMessageRentalPay">
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
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