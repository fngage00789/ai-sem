<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsgPopup" />

	<rich:modalPanel id="popupPaymentHistory" width="800" autosized="true" minWidth="800">
		<f:facet name="header">
			<h:outputText value="#{jspMsgPopup['header.popupHistory.name']}" />
		</f:facet>
		
		<f:facet name="controls">
			<h:panelGroup>
				
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
							rows="10" var="PaymentWrapper" value="#{semmel005Bean.paymentHistList}"
							reRender="dtbElecMeterCash" rowKeyVar="rowIndex"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
							rowClasses="cur" styleClass="contentform">
								<!-- begin column -->

								


								<rich:column
									sortBy="#{PaymentWrapper.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.contractNo']}"
											 />
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.contractNo}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.oldContractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.oldContractNo']}"
											 />
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.oldContractNo}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.company}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.company']}"
											>
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText	value="#{PaymentWrapper.company}">						
										</h:outputText>
									</div> 
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.expenseType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.expenseType']}" style="width:120px;">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.expenseTypeDesc}" />
									</div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.vendorId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.vendorId']}">
										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.vendorId}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['header.vendorName']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText style="width: 200"
										value="#{PaymentWrapper.vendorName}" /></div> 
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.payeeId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.payeeId']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.payeeId}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.payeeName']}" style="width: 200"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.payeeName}" /></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.meterId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['label.meterIdExpense']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.meterId}">
										
									</h:outputText></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.termOfPaymentDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.termOfPaymentDt']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.termOfPaymentDtStr}">
										
									</h:outputText></div>
								</rich:column>

								<rich:column sortBy="#{PaymentWrapper.fromTermOfPaymentDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.paymentDtFrom']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{PaymentWrapper.fromTermOfPaymentDtStr}" />
									</div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.toTermOfPaymentDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.paymentDtTo']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.toTermOfPaymentDtStr}">
									
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.pRead}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.pRead']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.pRead}">
									
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.lRead}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.lRead']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.lRead}">
							
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.unitPrice}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.unitPrice']}">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.unitPrice}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										</div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.unitVatType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.unitVatType']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.unitVatType}" /></div>
								</rich:column>
	
	
								<rich:column
									sortBy="#{PaymentWrapper.payAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.payAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.payAmt}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										
										</div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.vatType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.vatType']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.vatTypeTxt}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.vatAmt }">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.vatAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.vatAmt }">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText></div>
								</rich:column>
								

								<rich:column
									sortBy="#{PaymentWrapper.excludeVatAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.excludeVatAmt']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.excludeVatAmt}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										</div>
								</rich:column>

								
								<rich:column
									sortBy="#{PaymentWrapper.includeVatAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.includeVatAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText value="#{PaymentWrapper.includeVatAmt}">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
									</div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.whtAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.whtAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.whtAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText></div>
								</rich:column>

								<rich:column
									sortBy="#{PaymentWrapper.chqAmt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.chqAmt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.chqAmt}" >
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
										
										</div>
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.paymentType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.paymentChannel']}"
										>

										</h:outputText>
									</f:facet>

																	<div align="center"><h:outputText
										value="#{PaymentWrapper.paymentTypeDesc}" /></div>		
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.paymentMethod}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.paymentType']}"
											>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.paymentMethodTxt}" /></div>
								</rich:column>
								
									<rich:column
									sortBy="#{PaymentWrapper.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.bankName']}" style="width: 200"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.bankName}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.bankAccount}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.bankAccount']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.bankAccount}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.chqNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.chqNo']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.chqNo}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.chqPostingDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.chqPostingDt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.chqPostingDtStr}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.chqReceivedDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.chqReceivedDt']}"
											style="width: 100px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.chqReceivedDtStr}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.transferDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.transferDt']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.transferDtStr}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.chqClearingDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.clearingChqDate']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.chqClearingDtStr}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.doc68}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.doc68']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.doc68}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.doc92}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.doc92']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.doc92}" /></div>
								</rich:column>
								<rich:column
									sortBy="#{PaymentWrapper.remark}">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.remark']}" style="width:250px">

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.remark}" /></div>
								</rich:column>
								
								<rich:column
									sortBy="#{PaymentWrapper.createBy}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.createBy']}"
										>

										</h:outputText>
									</f:facet>
									<div align="center"><h:outputText
										value="#{PaymentWrapper.createBy}" /></div>
								</rich:column>

								<rich:column sortBy="#{PaymentWrapper.createDt}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsgPopup['column.header.createDt']}">

										</h:outputText>
									</f:facet>
									<div align="center"></div>
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
									<rich:componentControl for="popupPaymentHistory" operation="hide" event="onclick" />
									<rich:spacer width="5px"></rich:spacer>
								</a4j:commandButton>
								
								<rich:spacer width="5"></rich:spacer>
								
						        <h:commandButton id="btnExportHist" value="Export" styleClass="rich-button" 
						         action="#{semmel005Action.doExportPaymentHist}" rendered="#{semmel005Bean.displayExportPaymentHist}" />
							</h:panelGroup>
				        </h:panelGrid>
				        
		</h:panelGrid>
		</a4j:form>
		</rich:modalPanel>
		
