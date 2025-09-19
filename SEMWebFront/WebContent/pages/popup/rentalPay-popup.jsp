<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.popup.rentalPay" var="jspMsgPopup"/>
<rich:modalPanel id="popupfrmRentalPay" width="1200" minWidth="1200" minHeight="600" resizeable="false" height="600" style="overflow:auto;">

	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup['header.popup.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopUpAdd" style="cursor:pointer"/>
				<rich:componentControl for="popupfrmRentalPay" attachTo="hidePopUpAdd" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmRentPayPopup"> 
		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
				rendered="#{semmir007Bean.renderedMsgFormSearchPopup}">
		 		<f:facet name="header">
                     <h:outputText value="Entered Data Status:"></h:outputText>
                </f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                </f:facet>
		</rich:messages>
		
		<rich:panel styleClass="sem_autoScrollbar_10Rows">
			 	<table width="100%" border="0" cellspacing="0" cellpadding="0" >
				  	<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
				  		<h:panelGroup>
				  		<table width="100%">
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupCompony" value="#{jspMsgPopup['label.company']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupCompony" value="#{popupRentalPayBean.mrt003PopSP.company}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupSiteName" value="#{jspMsgPopup['label.siteName']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupSiteName" value="#{popupRentalPayBean.mrt003PopSP.siteName}" size="50"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupContract" value="#{jspMsgPopup['label.contractNo']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupContract" value="#{popupRentalPayBean.mrt003PopSP.contractNo}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupOldContractNo" value="#{jspMsgPopup['label.oldContract']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupOldContractNo" value="#{popupRentalPayBean.mrt003PopSP.oldContractNo}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupRegion" value="#{jspMsgPopup['label.region']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupRegion" value="#{popupRentalPayBean.mrt003PopSP.region}"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupEffectiveDt" value="#{jspMsgPopup['label.effectiveDt']}" styleClass="ms7" />
								</td>
								<td>
									<rich:calendar id="cldPopupEffectiveDt" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{popupRentalPayBean.mrt003PopSP.effectiveDt}"
									showWeeksBar="false" 
									inputSize="13" 
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['column.header.dueDtFrom']}"
									
									/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupExpireDt" value="#{jspMsgPopup['label.expireDt']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<rich:calendar id="cldPopupExpireDt" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{popupRentalPayBean.mrt003PopSP.expireDt}"
									showWeeksBar="false" 
									inputSize="13" 
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.siteName']}"
									
									/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupVendorId" value="#{jspMsgPopup['label.vendorId']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupVendorId" value="#{popupRentalPayBean.mrt003PopSP.vendorId}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupVendorName" value="#{jspMsgPopup['label.vendorName']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupVendorName" value="#{popupRentalPayBean.mrt003PopSP.vencdorName}" size="50"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
								</td>
								<td>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupPayeeName" value="#{jspMsgPopup['label.payeeName']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupPayeeName" value="#{popupRentalPayBean.mrt003PopSP.payeeName}" size="50"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupSiteStatus" value="#{jspMsgPopup['label.contractStatus']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupSiteStatus" value="#{popupRentalPayBean.mrt003PopSP.siteStatus}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupNetworkStatus" value="#{jspMsgPopup['label.networkStatus']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupNetworkStatus" value="#{popupRentalPayBean.mrt003PopSP.networkStatus}"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td colspan="6">
				  					<hr>
				  				</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupDueDt" value="#{jspMsgPopup['label.dueDt']}" styleClass="ms7" />
								</td>
								<td>
									<rich:calendar id="cldPopupDueDt" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{popupRentalPayBean.mrt003PopSP.dueDt}"
									showWeeksBar="false" 
									inputSize="13" 
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.dueDt']}"
									
									/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupDueDtTo" value="#{jspMsgPopup['label.dueDtTo']}" styleClass="ms7" />
								</td>
								<td>
									<rich:calendar id="cldPopupDueDtTo" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{popupRentalPayBean.mrt003PopSP.dueDtTo}"
									showWeeksBar="false" 
									inputSize="13" 
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.dueDtTo']}"
									
									/>
		                		</td>
		                	</tr>
		                	<tr>
		                		<td align="right">
				                	<h:outputText id="lblPopupPaymentStatus" value="#{jspMsgPopup['label.paymentStatus']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupPaymentStatus" value="#{popupRentalPayBean.mrt003PopSP.paymentStatusDesc}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupDoc68" value="#{jspMsgPopup['label.doc68']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupDoc68" value="#{popupRentalPayBean.mrt003PopSP.doc68}"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupPayPeriodType" value="#{jspMsgPopup['label.payPeriodType']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupPayPeriodType" value="#{popupRentalPayBean.mrt003PopSP.payPeriodType}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupPeriod" value="#{jspMsgPopup['label.period']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupPeriodNoStart" value="#{popupRentalPayBean.mrt003PopSP.periodNoStart}" size="2"/>
									<rich:spacer width="5"/>
									<h:outputText id="lblPopupTo" value="#{jspMsgPopup['label.to']}" styleClass="ms7" />
									<rich:spacer width="5"/>
									<h:inputText id="txtPopupPeriodNoEnd" value="#{popupRentalPayBean.mrt003PopSP.periodNoEnd}" size="2"/>
									<rich:spacer width="50"/>
									<h:inputText id="txtPopupPayPeriodYear" value="#{popupRentalPayBean.mrt003PopSP.payPeriodY}" size="2"/>
									<rich:spacer width="5"/>
									<h:outputText id="lblPopupYear" value="#{jspMsgPopup['label.year']}" styleClass="ms7" />
									<rich:spacer width="5"/>
									<h:inputText id="txtPopupPayPeriodMonth" value="#{popupRentalPayBean.mrt003PopSP.payPeriodM}" size="2"/>
									<rich:spacer width="5"/>
									<h:outputText id="lblPopupMonth" value="#{jspMsgPopup['label.month']}" styleClass="ms7" />
									<rich:spacer width="5"/>
									<h:inputText id="txtPopupPayPeriodDay" value="#{popupRentalPayBean.mrt003PopSP.payPeriodD}" size="2"/>
									<rich:spacer width="5"/>
									<h:outputText id="lblPopupDay" value="#{jspMsgPopup['label.day']}" styleClass="ms7" />
								</td>
		                	</tr>
		                	<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupTotalAmt" value="#{jspMsgPopup['label.totalAmt']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupTotalAmt" value="#{popupRentalPayBean.mrt003PopSP.totalAmt}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:inputText>
		                		</td>
		                	</tr>
		                	<tr>
				  				<td colspan="6">
				  					<hr>
				  				</td>
				  			</tr>
				  			<tr>
				  				<td colspan="6">
					  				<rich:dataTable width="100%" id="dtbRentalPayPopup" cellpadding="1" cellspacing="0" border="0"
									var="rentalPayPopup" value="#{popupRentalPayBean.mrt003PopSPList}" reRender="dstRentalPayNormalSrch" 
									 styleClass="dataTable" rowClasses="cur">
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.networkType']}" styleClass="contentform"  style="width:100px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.expenseTypeDesc}" styleClass="contentform" >
													
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.periodAmt']}" styleClass="contentform"  style="width:50px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.periodAmt}" styleClass="contentform" >
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.vatType']}" styleClass="contentform"  style="width:70px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.vatTypeDesc}" styleClass="contentform" >
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.vat']}" styleClass="contentform"  style="width:70px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.vatRate}" styleClass="contentform" >
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.whtType']}" styleClass="contentform"  style="width:70px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.whtTypeDesc}" styleClass="contentform" >
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.whtPercent']}" styleClass="contentform"  style="width:30px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.whtRate}" styleClass="contentform" >
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.wht']}" styleClass="contentform"  style="width:100px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.whtAmt}" styleClass="contentform" >
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:outputText>
											</div>
										</rich:column>
										<rich:column>
											<f:facet name="header">
												<h:outputText value="#{jspMsgPopup['column.totalAmt']}" styleClass="contentform"  style="width:70px"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{rentalPayPopup.totalAmt}" styleClass="contentform" >
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:outputText>
											</div>
										</rich:column>
										<f:facet name="footer">
											<a4j:region>
												<rich:columnGroup>
													<rich:column colspan="8">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(popupRentalPayBean.mrt003PopSPList)}"></f:param>
														</h:outputFormat>
													</rich:column>
												</rich:columnGroup>		
											</a4j:region>			
										</f:facet>
									</rich:dataTable>
				  				</td>
				  			</tr>
				  			<tr>
				  				<td colspan="6">
				  					<hr>
				  				</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupPaymentType" value="#{jspMsgPopup['label.paymentType']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupPayment" value="#{popupRentalPayBean.mrt003PopSP.paymentTypeDesc}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupBankName" value="#{jspMsgPopup['label.bankName']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupBankName" value="#{popupRentalPayBean.mrt003PopSP.bankName}"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupBankAccNo" value="#{jspMsgPopup['label.bankAccNo']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupBankAccNo" value="#{popupRentalPayBean.mrt003PopSP.bankAccNo}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupBankAccName" value="#{jspMsgPopup['label.bankAccName']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupBankAccName" value="#{popupRentalPayBean.mrt003PopSP.bankAccName}"/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupBankBranch" value="#{jspMsgPopup['label.bankBranch']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupBankBranch" value="#{popupRentalPayBean.mrt003PopSP.bankBranch}"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				  					<h:outputText id="lblPopupChqDt" value="#{jspMsgPopup['label.chqDt']}" styleClass="ms7" />
				  				</td>
				  				<td>
									<rich:calendar id="cldPopupChqDt" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{popupRentalPayBean.mrt003PopSP.chqDt}"
									showWeeksBar="false" 
									inputSize="13" 
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.chqDt']}"
									
									/>
		                		</td>
		                		<td align="right">
				  					<h:outputText id="lblPopupChqReceiveDt" value="#{jspMsgPopup['label.chqReceiveDt']}" styleClass="ms7" />
				  				</td>
				  				<td>
									<rich:calendar id="cldPopupChqReceiveDt" locale="th" enableManualInput="true" 
									datePattern="dd/MM/yyyy" 
									value="#{popupRentalPayBean.mrt003PopSP.chqReceiveDt}"
									showWeeksBar="false" 
									inputSize="13" 
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.chqDt']}"
									
									/>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupChqNo" value="#{jspMsgPopup['label.chqNo']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupChqNo" value="#{popupRentalPayBean.mrt003PopSP.chqNo}"/>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupDepositAmt" value="#{jspMsgPopup['label.depositAmt']}" styleClass="ms7" />
								</td>
								<td>
									<h:inputText id="txtPopupDepositAmt" value="#{popupRentalPayBean.mrt003PopSP.depositAmt}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:inputText>
		                		</td>
		                		<td align="right">
				                	<h:outputText id="lblPopupChqAmt" value="#{jspMsgPopup['label.chqAmt']}" styleClass="ms7" />
								</td>
								<td colspan="3">
									<h:inputText id="txtPopupChqAmt" value="#{popupRentalPayBean.mrt003PopSP.chqAmt}">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:inputText>
		                		</td>
				  			</tr>
				  			<tr>
				  				<td align="right">
				                	<h:outputText id="lblPopupRemark" value="#{jspMsgPopup['label.remark']}" styleClass="ms7" />
								</td>
								<td colspan="5">
									<h:inputTextarea id="txtPopupRemark" value="#{popupRentalPayBean.mrt003PopSP.remark}" cols="70"/>
		                		</td>
		                	</tr>
						</table>
						</h:panelGroup>
					</h:panelGrid>
						<h:panelGrid columns="3">
						  <a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
							<rich:componentControl for="popupfrmRentalPay" operation="hide" event="onclick" />
						  </a4j:commandButton>
						</h:panelGrid>
				  </table>
		</rich:panel>
	  </a4j:form>
</rich:modalPanel>
