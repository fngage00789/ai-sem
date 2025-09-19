<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg" />

	<rich:modalPanel id="popupPaymentHistory" width="800" autosized="true" minWidth="800">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.popupHistory.name']}" />
		</f:facet>
		
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left"><h:graphicImage value="images/ico_close.png"
					id="hidePopupsPaymentHistory" style="cursor:pointer" /> 
					<rich:componentControl for="popupPaymentHistory" attachTo="hidePopupsPaymentHistory" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid>
			<a4j:form id="frmErrorPopup">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="frmPaymentHistList">
		<h:panelGrid width="100%">
						<rich:panel id="pnlFileStore" 
						style="height:400px;width:1000px;overflow:auto;padding-bottom:0px;padding-left:0px;padding-right:0px;padding-top:0px;">

							<!-- begin dataTable -->
							<rich:dataTable id="dtbElecMeterCash" width="95%"
								rows="10"
								var="PaymentWrapper"
								value="#{semmel006Bean.paymentHistoryWrapperList}"
								reRender="dtbElecMeterCash" rowKeyVar="rowIndex"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform">
								<!-- begin column -->

								


								<rich:column
									sortBy="#{PaymentWrapper.histPayment.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractNo']}"
											 />
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.contractNo}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.oldContractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.oldContractNo']}"
											 />
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.oldContractNo}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPayment.company}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.company']}"
											>
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText	value="#{PaymentWrapper.histPayment.company}">						
										</h:outputText>
									</div> 
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.expenseType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expenseType']}"
											>
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.expenseTypeTxt}" />
									</div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.vendorId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendorId']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.vendorId}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPayment.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.vendorName']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText style="width: 200"
										value="#{PaymentWrapper.histPayment.vendorName}" /></div> 
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPayment.payeeId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeeId']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.payeeId}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPayment.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeeName']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.payeeName}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.meterId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.meterIdExpense']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.meterId}">
										
									</h:outputText></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.termOfPaymentDate}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.termOfPaymentDt']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.termOfPaymentDate}">
										
									</h:outputText></div>
								</rich:column>

								<rich:column sortBy="#{PaymentWrapper.histPaymentDetail.fromTermOfPaymentDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.fromTermOfPaymentDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{PaymentWrapper.histPaymentDetail.fromTermOfPaymentDtTH}" />
									</div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.toTermOfPaymentDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.toTermOfPaymentDt']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.toTermOfPaymentDtTH}">
									
									</h:outputText></div>
								</rich:column>

								<rich:column
								>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.totalTermOfPayment']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="1">
									
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.pRead}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pRead']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.pRead}">
									
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.lRead}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.lRead']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.lRead}">
							
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.kwhTotal}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.kwhTotal']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.kwhTotal}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.unitPrice}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.unitPrice']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.unitPrice}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										</div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.unitVatType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.unitVatType']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.unitVatTypeTxt}" /></div>
								</rich:column>
	
	
								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.payAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.payAmt}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										
										</div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.vatType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vatType']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.vatTypeTxt}" /></div>
								</rich:column>
								
								

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.excludeVatAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.excludeVatAmt']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.excludeVatAmt}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										</div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.vatAmt }">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vatAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.vatAmt }">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.includeVatAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.includeVatAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.includeVatAmt}">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.whtAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.whtAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.whtAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.chqAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.chqAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.chqAmt}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										
										</div>
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.histPayment.paymentType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.paymentChannel']}"
										>

										</h:outputText>
									</f:facet>

																	<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.paymentTypeTxt}" /></div>		
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.histPayment.paymentMethod}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.paymentType']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.paymentMethodTxt}" /></div>
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.histPayment.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bankName']}" style="width: 200"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.bankName}" /></div>
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.histPayment.bankAccount}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bankAccount']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.bankAccount}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.chqNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.chqNo']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.chqNo}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.chqPostingDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.chqPostingDt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.chqPostingDtTH}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.chqReceivedDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.chqReceivedDt']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.chqReceivedDtTH}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.transferDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transferDt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.transferDtTH}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.chqClearingDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.clearingChqDate']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.chqClearingDtTH}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.doc68}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.doc68']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.doc68}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.doc92}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.doc92']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.doc92}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.histPayment.remark}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPayment.remark}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.createBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.createBy']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.createBy}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.histPaymentDetail.createDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.createDt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.histPaymentDetail.createDtTH}" /></div>
								</rich:column>
								<!-- end column -->
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true"
										align="center" for="dtbElecMeterCash" maxPages="10"
										id="dstSiteApprove" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>
							<!-- end dataTable -->
						</rich:panel>
						
						<h:panelGrid id="pnlEnd" columns="10">
							<h:panelGroup>
							<a4j:commandButton value="Close" styleClass="rich-button"
								immediate="true">
								<rich:componentControl for="popupPaymentHistory" operation="hide"
							event="onclick" />
							<rich:spacer width="5px"></rich:spacer>
						</a4j:commandButton>
						<h:commandButton id ="btnExportSuccss" action="#{semmel006Action.exportHistoryPayment}"  
	            		styleClass="rich-button" value="Export"/>	
							</h:panelGroup>
				        </h:panelGrid>
				        
		</h:panelGrid>
		</a4j:form>
		</rich:modalPanel>
		
