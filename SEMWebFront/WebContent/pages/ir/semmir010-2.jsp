<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.insurance.semmir010" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpEdt']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupEditInsurancePay" style="cursor:pointer"/>
					<rich:componentControl for="popupEditInsurancePay" attachTo="hidePopupEditInsurancePay" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupEdtSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir010Bean.renderedMsgFormSearch}">
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
			<rich:panel id="pnlEditInsurancePay">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpEdt']}"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.vendorCode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%" >
		                				<h:inputText id="txtVendorCode" value="#{semmir010Bean.popupPolicySP.vendorCode}" size="18" disabled="true"/>
		                				<rich:spacer width="5"/>
		                				<a4j:commandButton id="btnSearchVendor" value="#{jspMsg['btn.vendorMaster']}" styleClass="rich-button"
		            					action="#{navAction.navi}" reRender="oppContent,frmSearch_vmp" 
		            					rendered="#{semmir010Bean.renderBtnVendorMaster}">	
			            			    	<a4j:actionparam name="navModule" value="ir" />
											<a4j:actionparam name="navProgram" value="SEMMIR010-VMP" />
											<a4j:actionparam name="moduleWithNavi" value="ir" />
											<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
											<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
											<a4j:actionparam name="contractNo" value="#{semmir010Bean.popupPolicySP.contractNo}" />
												
											<a4j:actionparam name="navModuleFrom" value="ir" />
											<a4j:actionparam name="navProgramFrom" value="SEMMIR010-2" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR010" />
			            			    </a4j:commandButton>
			            			    <rich:spacer width="10" ></rich:spacer>
			            			    <a4j:commandButton id="btnVendorInsurance" value="#{jspMsg['btn.vendorInsurance']}"
					                    					   styleClass="rich-button"
					                    					   oncomplete="#{rich:component('mdpSrchVendor')}.show(); return false"
					                						   action="#{navAction.navi}"
															   reRender="frmError, mdpSrchVendor,popupFrmEdit" >
												<a4j:actionparam name="navModule" value="ir" />
												<a4j:actionparam name="navProgram" value="SEMMIR010-2" />
												<a4j:actionparam name="moduleWithNavi" value="ir" />
												<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
												<a4j:actionparam name="methodWithNavi" value="doSearchVendor" />
											</a4j:commandButton>	
				                	</td>
				                	
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.th_contractno']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtContractNo" value="#{semmir010Bean.popupPolicySP.contractNo}" size="40"  disabled="false"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtVendorName" value="#{semmir010Bean.popupPolicySP.vendorName}" size="40" disabled="true" />
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtPayeeName" value="#{semmir010Bean.popupPolicySP.payeeName}" size="40"  disabled="true"/>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['lable.amountSystem']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtAmtSystem" value="#{semmir010Bean.popupPolicySP.totalAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 disabled="true"
				                		 maxlength="18">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.invoiceNo']}" styleClass="ms7"/>
		                			</td>
				                	<td align="left" width="25%">
										<h:inputText id="txtInvoiceNo" value="#{semmir010Bean.popupPolicySP.invoiceNo}" size="18" />
		                			</td>
		                			<td align="right" width="25%">
		                				<h:outputText value="#{jspMsg['label.amount']}" styleClass="ms7"/>
				                	</td>
				                	<td align="left" width="25%">
										<h:inputText id="txtAmt" value="#{semmir010Bean.popupPolicySP.excAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="numberformat.moneyFormat(this);calculateTotalAmt();"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
				                		 	<a4j:jsFunction name="calculateTotalAmt" action="#{semmir010Action.calculateTotalAmt}" reRender="txtTotalAmt"/>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.vat']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
			                			<h:inputText id="txtVat" value="#{semmir010Bean.popupPolicySP.vatAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="numberformat.moneyFormat(this);calculateTotalAmt();"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
				                		 	<a4j:jsFunction name="calculateTotalAmt" action="#{semmir010Action.calculateTotalAmt}" reRender="txtTotalAmt"/>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.wht']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtWht" value="#{semmir010Bean.popupPolicySP.whtAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="numberformat.moneyFormat(this);calculateTotalAmt();"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
				                		 	<a4j:jsFunction name="calculateTotalAmt" action="#{semmir010Action.calculateTotalAmt}" reRender="txtTotalAmt"/>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.duty']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtDuty" value="#{semmir010Bean.popupPolicySP.dutyAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="numberformat.moneyFormat(this);calculateTotalAmt();"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 maxlength="18">
				                		 	<a4j:jsFunction name="calculateTotalAmt" action="#{semmir010Action.calculateTotalAmt}" reRender="txtTotalAmt"/>
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
									
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.totalAmount']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:inputText id="txtTotalAmt" value="#{semmir010Bean.popupPolicySP.totalPayAmt}"
			                			 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                		 onblur="return numberformat.moneyFormat(this);"
				                		 onfocus="return numberformat.setCursorPosToEnd(this);"
				                		 styleClass="inputRight"
				                		 disabled="true"
				                		 maxlength="18">
											<f:convertNumber integerOnly="false" maxFractionDigits="2" pattern="#,##0.00"/>
										</h:inputText>
										
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmir010Bean.popupPolicySP.paymentType}">
		                					<f:selectItems value="#{semmir010Bean.paymentTypeList}"/>
		                					<a4j:support event="onchange" action= "#{semmir010Action.onRenderPaymentMethod}" reRender="cldChqDt,cldChqReceiveDt,cldTransferDt,ddlPaymentMethod"></a4j:support>
		                				</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.bank']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<h:selectOneMenu id="ddlPaymentMethod" value="#{semmir010Bean.popupPolicySP.paymentMethod}">
		                					<f:selectItems value="#{semmir010Bean.paymentMethodList}"/>
		                				</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.chqDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldChqDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir010Bean.popupPolicySP.chqDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.chqDt']}"
										disabled="#{semmir010Bean.renderedChqDt}"
										oninputblur="validateCalendarFromToWithPaymentType('popupFrmEdit','cldChqDt','cldChqReceiveDt','#{semmir010Bean.popupPolicySP.paymentMethod}');"
									 					oncollapse="validateCalendarFromToWithPaymentType('popupFrmEdit','cldChqDt','cldChqReceiveDt','#{semmir010Bean.popupPolicySP.paymentMethod}');">
										</rich:calendar>
				                	</td>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.chqReceiveDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldChqReceiveDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir010Bean.popupPolicySP.chqReceiveDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.chqReceiveDt']}"
										disabled="#{semmir010Bean.renderedChqReceiveDt}">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                				<rich:calendar id="cldTransferDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir010Bean.popupPolicySP.transferDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.transferDt']}"
										disabled="#{semmir010Bean.renderedTransferDt}">
										</rich:calendar>
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
									action="#{navAction.navi}" reRender="oppContent">
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
										<a4j:actionparam name="methodWithNavi" value="doSaveEdt" />
									</a4j:commandButton><rich:spacer width="10"/>
									<a4j:commandButton id="btnPopupBack" value="#{jspMsg['btn.back']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="oppContent" >
										<a4j:actionparam name="navModule" value="ir" />
				            			<a4j:actionparam name="navProgram" value="SEMMIR010-1" />	
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
										<a4j:actionparam name="methodWithNavi" value="doBack" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpSrchVendor" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['title.popup.name']}"></h:outputText>
    </f:facet>
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupmdpSrchVendor" style="cursor:pointer"/>
				<rich:componentControl for="mdpSrchVendor" attachTo="hidePopupmdpSrchVendor" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	
	<a4j:form id="frmSrchVendor">
		<h:panelGrid width="650">
			<rich:panel styleClass="sem_autoScrollbar_Popup" style="margin: 0 auto;height:450px;width:100%;">
				<h:panelGroup>
					<table width="95%">
						<tr>
							<td>
								<rich:dataTable width="100%" id="dtbSrchVendorMaster" cellpadding="1" cellspacing="0" border="0"
													var="obj" value="#{semmir010Bean.vendorMasterSPList}" 
													rows="#{semmir010Bean.rowPerPage}"
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
													rowClasses="cur" styleClass="dataTable">
							
										<rich:column width="5%">
											<div align="center">
				            					<a4j:commandLink id="hlkSelect" value="Select"
				            									 action="#{navAction.navi}"
				            									 oncomplete="#{rich:component('mdpSrchVendor')}.hide(); return false"
				            									 reRender="frmError,popupFrmEdit">
								            		<a4j:actionparam name="navModule" value="ir" />
													<a4j:actionparam name="navProgram" value="SEMMIR010-2" />
													<a4j:actionparam name="moduleWithNavi" value="ir" />
													<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
													<a4j:actionparam name="methodWithNavi" value="doSelectVendorMaster" />
													<a4j:actionparam name="vendorMasterID" value="#{obj.rowId}"/>
				            					</a4j:commandLink>                 							
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.rowId}" width="15%">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.vendorMasterId']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.rowId}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.vendorCode}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.vendorCode}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column sortBy="#{obj.vendorName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform" />
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.vendorName}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>
										
										<rich:column >
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.payeeName']}"></h:outputText>
											</f:facet>
											<div align="center">
												<h:outputText value="#{obj.payeeName}" styleClass="contentform">
												</h:outputText>
											</div>
										</rich:column>

										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="3">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmir010Bean.vendorMasterSPList)}"></f:param>
														</h:outputFormat>
												</rich:column>
												<rich:column colspan="2">		
														<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSrchVendorMaster"
																			   maxPages="#{semmir010Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																			   id="dstSrchVendorMaster" 
																			   style="background-color: #cccccc;"
																			   page="#{semmir010Bean.scrollerPage}"/>						   
												</rich:column>
											</rich:columnGroup>					
										</f:facet>
									</rich:dataTable>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>
	
	
	