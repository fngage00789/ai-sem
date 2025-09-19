<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt004" var="jspMsgPt002"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsgPt002['header.name2']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmErrorPt004">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt004Bean.msgTop}">
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
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="97%">
				<h:form id="frmSearchPage2">
					<h:panelGroup>
						<table width="100%">
							<tr>
							<td width="50%" align="left">
							</td>
							<td width="50%" align="right" valign="bottom">
								<table id="tblButton">
								<tr>
								<td>
									<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" action="#{navAction.navi}"
											 reRender="oppContent">
												<a4j:actionparam name="navModule" value="pt" />
												<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
												<a4j:actionparam name="moduleWithNavi" value="pt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
												<a4j:actionparam name="methodWithNavi" value="doBack" />
									</a4j:commandButton>
				           		</td>
				           		<td>
				           			<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" action="#{navAction.navi}"
										 reRender="frmErrorPt004,pnlDetailPay,pnlDetailSave,pnlPayment" onclick="validateAllCalendarFromTo('frmSearchPage2','cldChqDt2','cldChqDt');">	
											<a4j:actionparam name="navModule" value="pt" />
											<a4j:actionparam name="navProgram" value="SEMMPT004-2" />
											<a4j:actionparam name="moduleWithNavi" value="pt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
											<a4j:actionparam name="methodWithNavi" value="doSave" />
									</a4j:commandButton>
				           		</td>
				           		<td>
				           			<a4j:commandButton id="btnNew2" value="New" styleClass="rich-button" action="#{navAction.navi}" reRender="frmErrorPt004,frmSearchPage2,pnlSearchCriteria">		 		 
											<a4j:actionparam name="navModule" value="pt" />
											<a4j:actionparam name="navProgram" value="SEMMPT004-2" />
											<a4j:actionparam name="moduleWithNavi" value="pt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
											<a4j:actionparam name="methodWithNavi" value="doClearFormPay" />
									</a4j:commandButton>
				           		</td>
				           		</tr>
				           		</table>
			           		</td>
			           		</tr>
						</table>
					</h:panelGroup>
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsgPt002['header.propertyTax2']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
							<rich:panel id="pnlPopupSearchResult">
							<!-- begin content criteria -->
							<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
												<td align="left" width="15%">
													<h:outputText value="#{jspMsgPt002['header.pnlContractNo']}" styleClass="ms7" style="text-decoration:underline;" />
												</td>
							                	<td align="right" width="17%">
								                	<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.contractNo']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="23%">
					                				<h:panelGroup>
					                				<h:inputText id="txtContractNo" value="#{popupSiteContractAntCriBean.contractNo}" size="23" maxlength="20" onblur="GetLocationListJS();"
					                				 disabled="#{semmpt004Bean.renderContractNo}"/>
					                				 <a4j:jsFunction name="GetLocationListJS" reRender="frmErrorPt004,pnlDetailPay,pnlPayment,txtContractNo" action="#{semmpt004Action.doCheckContractNo}"/>
					                				 <a4j:commandButton id="btnPopupSearchContractNo"  oncomplete="#{rich:component('popupSearchContractAntCri')}.show(); return false"
														value="..."  reRender="popupSearchContractAntCri"
									            		action="#{navAction.navi}"
									            		disabled="#{semmpt004Bean.renderContractNo}">
									            		<a4j:actionparam name="navModule" value="pt" />
														<a4j:actionparam name="navProgram" value="SEMMPT004-2" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupSiteContractAntCri" />
														<a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
							            			 </a4j:commandButton>
							            			 </h:panelGroup>
							                	</td>
							                	<td align="right" width="20%">
							                	</td>
												<td width="25%" align="right">
													<a4j:commandButton id="btnViewPay" value="#{jspMsgPt002['btn.viewPay']}" styleClass="rich-button"  style="width:100px"
													 action="#{navAction.navi}" reRender="frmErrorPage2,popupResult,popupViewPropertyTax,pnlPopupSearchResult"
													 oncomplete="if(#{semmpt002Bean.popupClose == 'true'})#{rich:component('popupViewPropertyTax')}.show(); return false">
														<a4j:actionparam name="navModule" value="pt" />
														<a4j:actionparam name="navProgram" value="SEMMPT004-2" />
														<a4j:actionparam name="moduleWithNavi" value="pt" />
														<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
														<a4j:actionparam name="methodWithNavi" value="doShow" />
													</a4j:commandButton>
												</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
						</h:panelGrid>	
						
						<!--  start -->
						<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
							<rich:panel id="pnlReamInfo">
							<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
												<td align="left" width="15%">
													<h:outputText value="#{jspMsgPt002['header.pnlPay']}" style="text-decoration:underline;" styleClass="ms7"/>
												</td>
							                	<td align="right" width="17%">
								                	<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="#{jspMsgPt002['label.pTaxYearFrom2']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="23%">
					                				<h:selectOneMenu id="ddlYear" value="#{semmpt004Bean.mpt004SrchD.pTaxYear}" disabled="#{semmpt004Bean.disablePtaxYear}">
														<f:selectItems value="#{semmpt004Bean.pTaxYearFromList}"/>
													</h:selectOneMenu>
							                	</td>
							                	<td align="right" width="20%">
							                		<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.expenseType']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:selectOneMenu id="ddlExpenseType2" value="#{semmpt004Bean.mpt004SrchD.expenseType}" onchange="onRenderExpenseType();">
														<f:selectItems value="#{semmpt004Bean.expenseTypeList}"/>
													</h:selectOneMenu>
													<a4j:jsFunction name="onRenderExpenseType" action="#{semmpt004Action.onRenderExpenseType}" reRender="ddlPenalTy"></a4j:jsFunction>
												</td>
										</tr>
										
										<tr>
												<td align="left" width="15%">
												</td>
												<td align="right" width="13%">
													<h:outputText value="#{jspMsgPt002['label.periodType']}" styleClass="ms7"/>
												</td>
												<td width="78%" colspan="3">
													<h:panelGrid columns="5">
														<h:panelGroup>
															<h:selectOneRadio id="rbtPayPeriodType05" value="#{semmpt004Bean.payPeriodType05}"  styleClass="ms7" rendered="true"
															onclick="setPayPeriodType05();">
															<f:selectItem itemValue="05" itemLabel="#{jspMsgPt002['label.payPeriodType05']} " />
															<a4j:jsFunction name="setPayPeriodType05" action="#{semmpt004Action.renderPayPeriodType}" 
															 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear,
															 ddlMonthFrom,ddlMonthTo,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
															<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
															</a4j:jsFunction>
															</h:selectOneRadio>
														</h:panelGroup>
														<h:panelGroup>
															<h:selectOneRadio id="rbtPayPeriodType01" value="#{semmpt004Bean.payPeriodType01}"  styleClass="ms7" rendered="true"
															onclick="setPayPeriodType01();">
															<f:selectItem itemValue="01" itemLabel="#{jspMsgPt002['label.payPeriodType01']} " />
															 <a4j:jsFunction name="setPayPeriodType01" action="#{semmpt004Action.renderPayPeriodType}" 
															 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear,
															 ddlMonthFrom,ddlMonthTo,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
															<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
															</a4j:jsFunction>
															</h:selectOneRadio>
														</h:panelGroup>
														<h:panelGroup>
															<h:selectOneRadio id="rbtPayPeriodType02" value="#{semmpt004Bean.payPeriodType02}"  styleClass="ms7" rendered="true"
															onclick="setPayPeriodType02();">
															<f:selectItem itemValue="02" itemLabel="#{jspMsgPt002['label.payPeriodType02']}"/>
															<a4j:jsFunction name="setPayPeriodType02" action="#{semmpt004Action.renderPayPeriodType}" 
															 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear,
															 ddlMonthFrom,ddlMonthTo,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
															<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
															</a4j:jsFunction>
															</h:selectOneRadio>
														</h:panelGroup>
														<h:panelGroup>
														<table>
															<tr> 
															<td>
															<h:selectOneRadio id="rbtPayPeriodType03" value="#{semmpt004Bean.payPeriodType03}"  styleClass="ms7" rendered="true"
															onclick="setPayPeriodType03();">
															<f:selectItem itemValue="03" itemLabel="#{jspMsgPt002['label.payPeriodType03']} " />
															<a4j:jsFunction name="setPayPeriodType03" action="#{semmpt004Action.renderPayPeriodType}" 
															 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear,
															 ddlMonthFrom,ddlMonthTo,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
															<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
															</a4j:jsFunction>
															</h:selectOneRadio>
															</td>
															<td>
															<h:inputText id="txtPayPeriodTypeMonth" size="5" value="#{semmpt004Bean.payPeriod03}" disabled="#{semmpt004Bean.disableMonth}"
															 onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
															</h:inputText>
															<rich:spacer width="5"></rich:spacer>
															<h:outputText value="#{jspMsgPt002['label.month']}" styleClass="ms7"></h:outputText>
															</td>
															</tr>
															</table>
														</h:panelGroup>
														<h:panelGroup>
														<table>
															<tr>
															<td>
															<h:selectOneRadio id="rbtPayPeriodType04" value="#{semmpt004Bean.payPeriodType04}"  styleClass="ms7" rendered="true"
															onclick="setPayPeriodType04();">
															<f:selectItem itemValue="04" itemLabel="#{jspMsgPt002['label.payPeriodType03']} " />
															<a4j:jsFunction name="setPayPeriodType04" action="#{semmpt004Action.renderPayPeriodType}" 
															 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear,
															 ddlMonthFrom,ddlMonthTo,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
															<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
															</a4j:jsFunction>
															</h:selectOneRadio>
															</td>
															<td>
															<h:inputText id="txtPayPeriodTypeYear" size="5" value="#{semmpt004Bean.payPeriod04}" disabled="#{semmpt004Bean.disableYear}"
															 onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
															</h:inputText>
															<rich:spacer width="5"></rich:spacer>
															<h:outputText value="#{jspMsgPt002['label.year']}" styleClass="ms7"></h:outputText>
															</td>
															</tr>
															</table>
														</h:panelGroup>
													</h:panelGrid>
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
												</td>
												<td align="right" width="13%">
													<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.pTaxAmt']}" styleClass="ms7"/>
												</td>
												<td width="78%" colspan="3">
													<h:selectOneMenu id="ddlMonthFrom" value="#{semmpt004Bean.mpt004SrchD.monthFrom}" disabled="#{semmpt004Bean.disableMonthFrom}">
														<f:selectItems value="#{semmpt004Bean.monthFromList}"/>
													</h:selectOneMenu>
												</td>
										</tr>
										
									</table>
								</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
						</h:panelGrid>
						
						
						<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
							<rich:panel id="pnlDetailPay">
							<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
								<div align="left">
									<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt004Bean.pnlPayInfo}"/>
								</div>
									<table width="100%">
										<tr>
												<td align="left" width="15%">
													<h:outputText value="#{jspMsgPt002['header.pnlDetailPay']}" style="text-decoration:underline;" styleClass="ms7"/>
												</td>
							                	<td align="right" width="17%">
							                		<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
								                	<h:outputText value="#{jspMsgPt002['label.docType']}" styleClass="ms7"/>
												</td>
					                			<td width="23%">
					                				<h:selectOneMenu id="ddlDocType2" value="#{semmpt004Bean.mpt004SrchD.docType}" onchange="renderVatAndWhtType();">
														<a4j:jsFunction name="renderVatAndWhtType" reRender="optVatType,optWhtType,ddlWhtRate,pnlDetailPay" action="#{semmpt004Action.onRenderVatAndWhtType}"/>
														<f:selectItems value="#{semmpt004Bean.docTypeList}"/>
													</h:selectOneMenu>
							                	</td>
							                	<td align="right" width="20%">
							                		<h:outputText value="#{jspMsgPt002['label.penaltyType']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:selectOneMenu id="ddlPenalTy" value="#{semmpt004Bean.mpt004SrchD.penaltyType}" disabled="#{semmpt004Bean.disablePaneltyType}">
														<f:selectItems value="#{semmpt004Bean.penaltyTypeList}"/>
													</h:selectOneMenu>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:graphicImage value="images/icon_required.gif" rendered="#{semmpt004Bean.requireDocVat}"  id="rqDoc"/>
														<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.docNo']}" styleClass="ms7"/>
												</td>
												<td width="23%">
													<h:inputText id="txtDocNo" value="#{semmpt004Bean.mpt004SrchD.docNo}" size="18" maxlength="15">
														<a4j:support event="onchange" action="#{semmpt004Action.onRenderCheckBeforeSave}" reRender="btnSave,frmErrorPt004,txtPTaxPayType,
														 chkPayGovtFlag,txtPaymentStatus,txtPaymentStatusDesc,txtVendorCode,txtVendorName,txtPayeeName,txtEstmAmt,txtPtaxAmt,pnlDetailPay,hypGovt,
														 ddlPaymentType2,ddlPaymentMethod,txtBankName,txtBankAccNo"></a4j:support>
													</h:inputText>
												</td>
												<td align="right" width="20%">
													<h:graphicImage value="images/icon_required.gif"  rendered="#{semmpt004Bean.requireDocVat}"  id="rqDt"/>
														<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.docDt']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<rich:calendar id="cldDocDt" 
						                				locale="th" 
						                				enableManualInput="true"
														datePattern="dd/MM/yyyy" 
														showWeeksBar="false"
														inputSize="13" 
														value="#{semmpt004Bean.mpt004SrchD.docDt}"
														oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														cellWidth="20px" cellHeight="20px"
														label="#{jspMsgPt002['column.header.docDt']}">
													</rich:calendar>
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
												
												</td>
												<td align="right" width="17%">
													<h:outputText value="#{jspMsgPt002['label.pTaxPayType']}" styleClass="ms7"/>
												</td>
												<td width="23%">
													<h:inputText id="txtPTaxPayType" value="#{semmpt004Bean.mpt004SrchD.pTaxPayTypeDesc}" size="28" maxlength="25" disabled="true"/>
												</td>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsgPt002['label.payGovtFlag']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:selectBooleanCheckbox id="chkPayGovtFlag" value="#{semmpt004Bean.chkPayGovtFlag}" disabled="true">
														<a4j:support event="onclick" action="#{semmpt004Action.onRenderpayGovtFlag}" reRender="pnlDetailPay,hypGovt"/>
													</h:selectBooleanCheckbox> 
													<a4j:commandLink id="hlkGovt" value="#{jspMsgPt002['label.commandLink1']}" action="#{semmpt004Action.doShowPopupContractNo}" rendered="#{semmpt004Bean.renderLinkPayGovtFlag}"
													 oncomplete="if(#{semmpt004Bean.showPopupContract == 'true'})#{rich:component('popupShowContractNo')}.show();"
													 reRender="frmErrorPt004,popupFrmShowContractNo,pnlDetailPay,pnlPayment">
														
													</a4j:commandLink>
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
												
												</td>
												<td align="right" width="17%">
													<h:outputText value="#{jspMsgPt002['label.paymentStatus']}" styleClass="ms7"/>
												</td>
												<td colspan="3" width="68%">
													<h:inputText id="txtPaymentStatusDesc" value="#{semmpt004Bean.mpt004SrchD.paymentStatusDesc}" size="28" maxlength="25" disabled="true"/>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:outputText value="#{jspMsgPt002['label.vendorId']}" styleClass="ms7"/>
												</td>
												<td width="23%">
													<h:inputText id="txtVendorCode" value="#{semmpt004Bean.mpt004SrchD.vendorCode}" size="23" maxlength="20" disabled="true"/>
												</td>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsgPt002['label.vendorName']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:inputText id="txtVendorName" value="#{semmpt004Bean.mpt004SrchD.vendorName}" size="30" maxlength="255" disabled="true"/>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													
												</td>
												<td width="23%">
													
												</td>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsgPt002['label.payeeName']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:inputText id="txtPayeeName" value="#{semmpt004Bean.mpt004SrchD.payeeName}" size="30" maxlength="255" disabled="true"/>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:outputText value="#{jspMsgPt002['label.estmAmt']}" styleClass="ms7"/>
												</td>
												<td width="23%">
													<h:inputText id="txtEstmAmt" value="#{semmpt004Bean.mpt004SrchD.estmAmt}"
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
													<h:outputText value="#{jspMsgPt002['label.pTaxAmt']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:inputText id="txtPtaxAmt" value="#{semmpt004Bean.mpt004SrchD.pTaxAmt}" 
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
												<td align="left" width="15%">
												
												</td>
												<td align="right" width="17%">
													<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.totalAmt']}" styleClass="ms7"/>
												</td>
												<td colspan="3" width="68%">
													<h:inputText id="txtTotalAmt" value="#{semmpt004Bean.mpt004SrchD.totalAmt}" onchange="ChangeAmount();"
		                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                						 onblur="return numberformat.moneyFormat(this);"
		                						 onfocus="return numberformat.setCursorPosToEnd(this);"
		                						 maxlength="16" 
		                						 styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                				</h:inputText>
				                				<a4j:jsFunction name="ChangeAmount" action="#{semmpt004Action.onRenderAmount}"  
												 reRender="txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt,txtDiffAmt,pnlDetailPay">
												</a4j:jsFunction>
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
												
												</td>
												<td align="right" width="17%">
													<h:outputText value="#{jspMsgPt002['label.vatType']}" styleClass="ms7"/>
												</td>
												<td colspan="3" width="68%">
													<h:selectOneRadio id="optVatType" value="#{semmpt004Bean.mpt004SrchD.vatType}" styleClass="ms7" onclick="ChangeAmount();" disabled="#{semmpt004Bean.disableVatAndWhtType}">
														<f:selectItem id="vt1" itemLabel="#{jspMsgPt002['label.vatType2']}" itemValue="01" />
														<f:selectItem id="vt2" itemLabel="#{jspMsgPt002['label.vatType3']}" itemValue="02" />
														<f:selectItem id="vt3" itemLabel="#{jspMsgPt002['label.vatType4']}" itemValue="03" />
													</h:selectOneRadio>
													<a4j:jsFunction name="ChangeAmount" action="#{semmpt004Action.onRenderAmount}"  
													 reRender="txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt,txtDiffAmt">
													</a4j:jsFunction>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:outputText value="#{jspMsgPt002['label.whtType']}" styleClass="ms7"/>
												</td>
												<td colspan="2" width="43%">
													<table width="100%">
														<tr>
															<td>
																<h:selectOneRadio id="optWhtType" value="#{semmpt004Bean.mpt004SrchD.whtType}" styleClass="ms7" onclick="ChangeAmount();" disabled="#{semmpt004Bean.disableVatAndWhtType}">
																<f:selectItem id="wht1" itemLabel="#{jspMsgPt002['label.whtType2']}" itemValue="01" />
																<f:selectItem id="wht2" itemLabel="#{jspMsgPt002['label.whtType3']}" itemValue="02" />
																<f:selectItem id="wht3" itemLabel="#{jspMsgPt002['label.whtType4']}" itemValue="03" />
																
																</h:selectOneRadio>	
																<a4j:jsFunction name="ChangeAmount" action="#{semmpt004Action.onRenderAmount}"  
																 reRender="pnlDetailPay,txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt,txtDiffAmt,ddlWhtRate">
																</a4j:jsFunction>	
															</td>
															<td align="right">
																<h:outputText value="#{jspMsgPt002['label.whtRate']}" styleClass="ms7"/>		
															</td>
														</tr>
													</table>
												</td>
												<td width="25%">
			                						 <h:selectOneMenu id="ddlWhtRate" value="#{semmpt004Bean.mpt004SrchD.whtRate}" disabled="#{semmpt004Bean.disableWhtRate}" 
			                						  onchange="ChangeWhtRate();">
			                						  <a4j:actionparam name="whtFlag" value="fromWhtRate"/>
														<f:selectItems value="#{semmpt004Bean.whtRateList}"/>
													  <a4j:jsFunction name="ChangeWhtRate" action="#{semmpt004Action.onRenderWhtRateChange}" 
													  reRender="txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt,txtDiffAmt,pnlDetailPay"></a4j:jsFunction> 
													</h:selectOneMenu>
													<h:outputText value="#{jspMsgPt002['lebel.percecnt']}" styleClass="ms7"/>
													<a4j:jsFunction name="ChangeAmount" action="#{semmpt004Action.onRenderAmount}"  
													 reRender="txtExcAmt,txtVatAmt,txtIncAmt,txtWhtAmt,txtChqAmt,txtDiffAmt,pnlDetailPay">
													</a4j:jsFunction>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.excAmt']}" styleClass="ms7"/>
												</td>
												<td width="23%">
													<h:inputText id="txtExcAmt" value="#{semmpt004Bean.mpt004SrchD.excAmt}" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
			                						 <a4j:support event="onchange" action="#{semmpt004Action.onRenderIncludeAmt}" reRender="txtExcAmt,txtIncAmt,txtChqAmt,frmErrorPt004,pnlDetailPay"></a4j:support>
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                						</h:inputText>
												</td>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsgPt002['label.vatAmt']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:inputText id="txtVatAmt" value="#{semmpt004Bean.mpt004SrchD.vatAmt}" 
			                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						 onblur="return numberformat.moneyFormat(this);"
			                						 onfocus="return numberformat.setCursorPosToEnd(this);"
			                						 maxlength="16" 
			                						 styleClass="inputRight">
			                						 <a4j:support event="onchange" action="#{semmpt004Action.onRenderIncludeAmt}" reRender="txtExcAmt,txtIncAmt,txtVatAmt,txtChqAmt,frmErrorPt004,pnlDetailPay"></a4j:support>
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                					</h:inputText>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.incAmt']}" styleClass="ms7"/>
												</td>
												<td width="23%">
													<h:inputText id="txtIncAmt" value="#{semmpt004Bean.mpt004SrchD.incAmt}" disabled="true"
				                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                						 onblur="return numberformat.moneyFormat(this);"
				                						 onfocus="return numberformat.setCursorPosToEnd(this);"
				                						 maxlength="16" 
				                						 styleClass="inputRight">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                					</h:inputText>
												</td>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsgPt002['label.whtAmt']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:inputText id="txtWhtAmt" value="#{semmpt004Bean.mpt004SrchD.whtAmt}" 
				                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                						 onblur="return numberformat.moneyFormat(this);"
				                						 onfocus="return numberformat.setCursorPosToEnd(this);"
				                						 maxlength="16" 
				                						 styleClass="inputRight">
				                					<a4j:support event="onchange" action="#{semmpt004Action.onRenderTotalAmt}" reRender="txtWhtAmt,txtChqAmt,frmErrorPt004"></a4j:support>
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                					</h:inputText>
												</td>
										</tr>
										<tr>
												<td colspan="2" align="right" width="32%">
													<h:graphicImage value="images/icon_required.gif"/>
													<rich:spacer width="5"/>
													<h:outputText value="#{jspMsgPt002['label.chqAmt']}" styleClass="ms7"/>
												</td>
												<td width="23%">
														<h:inputText id="txtChqAmt" value="#{semmpt004Bean.mpt004SrchD.chqAmt}" disabled="true"
					                						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
					                						 onblur="return numberformat.moneyFormat(this);"
					                						 onfocus="return numberformat.setCursorPosToEnd(this);"
					                						 maxlength="16" 
					                						 styleClass="inputRight">
														<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                					</h:inputText>
												</td>
												<td align="right" width="20%">
													<h:outputText value="#{jspMsgPt002['label.diffAmt']}" styleClass="ms7"/>
												</td>
												<td width="25%">
													<h:inputText id="txtDiffAmt" value="#{semmpt004Bean.mpt004SrchD.diffAmt}" disabled="true"
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
												<td colspan="2" align="right" width="32%">
													<h:outputText value="#{jspMsgPt002['label.diffRemark2']}" styleClass="ms7"/>
												</td>
												<td colspan="3" width="68%">
													<h:inputTextarea id="txtDiffRemark" value="#{semmpt004Bean.mpt004SrchD.diffRemark}" 
													 cols="30" rows="3"/>
												</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
						</h:panelGrid>
						
						<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
							<rich:panel id="pnlPayment">
							<!-- begin content criteria -->
							<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
								<div align="left">
									<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt004Bean.pnlPayment}"/>
								</div>
									<table width="100%">
										<tr>
												<td align="left" width="15%">
													<h:outputText value="#{jspMsgPt002['header.pnlPayment']}" style="text-decoration:underline;" styleClass="ms7"/>	
												</td>
							                	<td align="right" width="17%">
								                	<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="#{jspMsgPt002['label.paymentType']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="23%">
					                				<h:selectOneMenu id="ddlPaymentType2" value="#{semmpt004Bean.mpt004SrchD.paymentType}" >
															<f:selectItems value="#{semmpt004Bean.paymentTypeList}"/>
															<a4j:support event="onchange" action= "#{semmpt004Action.onrenderPaymentType}" reRender="pnlPayment,cldChqDt,cldChqReceiveDt,cldTransferDt,ddlPaymentMethod,test,test2"></a4j:support>
															
															<!--
															<a4j:jsFunction name="ChangeDatePaymentType" action="#{semmpt004Action.onrenderPaymentType}"  
													 reRender="cldChqDt,cldChqReceiveDt,cldTransferDt,ddlPaymentMethod">
													</a4j:jsFunction>-->
													</h:selectOneMenu>
													
							                	</td>
							                	<td align="right" width="20%">
							                		<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="Payment Type :" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td width="25%"><h:outputText value=""></h:outputText>
													<h:selectOneMenu id="ddlPaymentMethod" value="#{semmpt004Bean.mpt004SrchD.paymentMethod}" disabled="#{semmpt004Bean.renderedPaymentMethod}">
														<f:selectItems value="#{semmpt004Bean.paymentMethodList}"/>
														<a4j:support event="onchange" reRender="pnlPayment"></a4j:support>
													</h:selectOneMenu>
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
														
												</td>
							                	<td align="right" width="17%">
								                	<h:panelGroup>
														<h:outputText value="#{jspMsgPt002['label.bankName']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="23%">
					                				<h:inputText id="txtBankName" value="#{semmpt004Bean.mpt004SrchD.bankName}" size="18" maxlength="15"
		                							 disabled="true"/>
							                	</td>
							                	<td align="right" width="20%">
							                		<h:panelGroup>
														<h:outputText value="#{jspMsgPt002['label.bankAccNo']}" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td width="25%">
													<h:inputText id="txtBankAccNo" value="#{semmpt004Bean.mpt004SrchD.bankAccNo}" size="18" maxlength="15"
		                							 disabled="true"/>
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
														
												</td>
							                	<td align="right" width="17%">
								                	<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="#{jspMsgPt002['label.chqDt']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="23%">
					                				<rich:calendar id="cldChqDt" 
													 showWeeksBar="false" locale="th/TH" 
													 enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmpt004Bean.mpt004SrchD.chqDt}" 
						                			 inputSize="13" 
						                			 disabled="#{semmpt004Bean.renderCldChqDt}"
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													 cellWidth="20px" cellHeight="20px" 
													 label="#{jspMsgPt002['column.header.chqDt']}"
													 oninputblur="validateCalendarFromToWithPaymentType('frmSearchPage2','cldChqDt','cldChqReceiveDt','#{semmpt004Bean.mpt004SrchD.paymentMethod}');"
									 					oncollapse="validateCalendarFromToWithPaymentType('frmSearchPage2','cldChqDt','cldChqReceiveDt','#{semmpt004Bean.mpt004SrchD.paymentMethod}');"
													>
													<a4j:support ></a4j:support>
													</rich:calendar>		                			 					
							                	</td>
							                	<td align="right" width="20%">
							                		<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="#{jspMsgPt002['label.chqReceiveDt']}" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td width="25%">
													<rich:calendar id="cldChqReceiveDt" 
													 showWeeksBar="false" locale="th/TH" 
													 enableManualInput="true" datePattern="dd/MM/yyyy" 
						                			 value="#{semmpt004Bean.mpt004SrchD.chqReceiveDt}" 
						                			 inputSize="13" 
						                			 disabled="#{semmpt004Bean.renderCldChqReceiveDt}"
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													 cellWidth="20px" cellHeight="20px" 
													 label="#{jspMsgPt002['column.header.chqReceiveDt']}"
													>
													</rich:calendar>
													
													 
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
														
												</td>
							                	<td align="right" width="17%" valign="top">
								                	<h:panelGroup>
								                		<h:graphicImage value="images/icon_required.gif"/>
														<rich:spacer width="5"/>
														<h:outputText value="#{jspMsgPt002['label.transferDt']}" styleClass="ms7"/>
													</h:panelGroup>
												</td>
					                			<td width="23%" valign="top">
					                				<rich:calendar id="cldTransferDt" 
					                				 showWeeksBar="false" locale="th/TH" 
					                				 enableManualInput="true" 
					                				 datePattern="dd/MM/yyyy" 
						                			 value="#{semmpt004Bean.mpt004SrchD.transferDt}" 
						                			 inputSize="13" 
						                			 disabled="#{semmpt004Bean.renderCldTransferDt}"
						                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													 cellWidth="20px" cellHeight="20px" 
													 label="#{jspMsgPt002['column.header.transferDt']}"
													 >
													 	
													 </rich:calendar>
							                	</td>
							                	<td align="right" width="20%" valign="top">
							                		<h:panelGroup>
														<h:outputText value="#{jspMsgPt002['label.remark']}" styleClass="ms7"/>
													</h:panelGroup>
							                	</td>
												<td width="25%">
													<h:inputTextarea id="txtRemark" value="#{semmpt004Bean.mpt004SrchD.remark}"
		                							 cols="30" rows="3"/>	
												</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
						</h:panelGrid>	
						
						<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
							<rich:panel id="pnlDetailSave">
							<!-- begin content criteria -->
							<h:panelGrid width="97%"  border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
												<td align="left" width="15%">
													<h:outputText value="#{jspMsgPt002['header.pnlDetailSave']}" style="text-decoration:underline;" styleClass="ms7"/>	
												</td>
							                	<td align="right" width="17%">
								                	<h:outputText value="#{jspMsgPt002['label.createBy']}" styleClass="ms7"/>
												</td>
					                			<td width="23%">
					                				<h:inputText id="txtCreateBy" value="#{semmpt004Bean.mpt004SrchD.createBy}" 
		                							 readonly="true" disabled="true" />
							                	</td>
							                	<td align="right" width="20%">
							                		<h:outputText value="#{jspMsgPt002['label.createDt']}" styleClass="ms7"/>
							                	</td>
												<td width="25%">
													<rich:calendar id="cldCreateDate" locale="th" 
														datePattern="dd/MM/yyyy HH:mm:ss" 
													    value="#{semmpt004Bean.mpt004SrchD.createDt}"
													    inputSize="20" 
													    cellWidth="20px" cellHeight="20px" 
													    buttonIcon="/images/hide-button.png"
													    buttonIconDisabled="/images/hide-button.png"
													    disabled="true" />
												</td>
										</tr>
										<tr>
												<td align="left" width="15%">
														
												</td>
							                	<td align="right" width="17%">
								                	<h:outputText value="#{jspMsgPt002['label.updateBy']}" styleClass="ms7"/>
												</td>
					                			<td width="23%">
					                				<h:inputText id="txtUpdateBy" value="#{semmpt004Bean.mpt004SrchD.updateBy}" 
		                							readonly="true" disabled="true" />
							                	</td>
							                	<td align="right" width="20%">
							                		<h:outputText value="#{jspMsgPt002['label.updateDt']}" styleClass="ms7"/>
							                	</td>
												<td width="25%">
													<rich:calendar id="cldUpdateDate" locale="th" 
														datePattern="dd/MM/yyyy HH:mm:ss" 
													    value="#{semmpt004Bean.mpt004SrchD.updateDt}"
													    showWeeksBar="false" 
													    inputSize="20" 
													    cellWidth="20px" cellHeight="20px" 
													    buttonIcon="/images/hide-button.png"
													    buttonIconDisabled="/images/hide-button.png"
													    disabled="true" />
												</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
							</rich:panel>
						</h:panelGrid>	
						
						<!-- end content criteria -->
					</rich:panel>
					</h:form>
					<a4j:include id="content2Semmpt004Popup" viewId="../../pages/pt/semmpt004-popup.jsp"/>
					<a4j:include id="content2Semmpt002Popup" viewId="../../pages/pt/semmpt002-popup.jsp"/>
					<a4j:include id="content2SiteContractPopup" viewId="../../pages/popup/sitecontractantcri-popup.jsp" />
				</h:panelGrid>
	
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>