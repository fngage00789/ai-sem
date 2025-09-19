<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid columnClasses="gridContent" width="100%">
	<a4j:region id="rgnRentCond">
				<h:panelGrid  width="95%" id="pnlRent">
				<h:panelGroup>
					<rich:panel>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.rentAndService']}"/>
						</f:facet>
						<table width="80%">
						<tr>
						  <td align="right" width="100%" valign="top" colspan="4">
						      <a4j:commandButton style="" styleClass="rich-button" id="msi004tab3_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_rental']}"
                                action="#{semmsi004Action.doShowPopupHistory}" reRender="oppContent,popupDisplay3"
                                oncomplete="#{rich:component('tab3_panel_popupModalRetStatus')}.show(); return false;">
                                <f:param name="tabNo" value="3"/>
                              </a4j:commandButton>
                              <a4j:include id="popUpTab3"  viewId="../../pages/sa/semmsa002PopUpTab3.jsp" />
						  </td>
						</tr>
						<tr>
							<td align="right" width="35%" valign="top">
							<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
                			</td>
                			<td width="65%" colspan="3">
                			<h:inputText id="txtContractNoDisplay2" value="#{semmsi004tab2Bean.siteContract.contractNo}" 
                			 size="16"  readonly="true" styleClass="ms28Blue"/>
                			</td>
						</tr>
						<tr>
							<td align="right" width="25%">
							<h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
                			</td>
                			<td width="15%">
                			<rich:calendar id="cldEffDateDisplay" locale="th" enableManualInput="true" 
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab2Bean.siteContract.effectiveDt}" 
							showWeeksBar="false" 
							inputSize="13"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.effDate']}"
							disabled="true">
							</rich:calendar>
		                	</td>
		                	<td align="right" width="25%">
							<h:outputText value="#{jspMsg['label.expDate']} :" styleClass="ms7"/>
							</td>
							<td width="15%">
							<rich:calendar id="cldExpDateDisplay" locale="th" enableManualInput="true" 
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab2Bean.siteContract.expireDt}" 
							showWeeksBar="false" 
							inputSize="13"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.expDate']}"
							disabled="true">
							</rich:calendar>
                			</td>
	                	 </tr>
						</table>
					</rich:panel>
					</h:panelGroup>
					
					<rich:spacer height="10"></rich:spacer>
					
					<rich:panel id="pnlRentCond">
						<h:panelGrid style="width:90%;padding:0px;margin:0 auto;">
							<h:panelGroup style="width:90%;padding:0px;margin:0 auto;">
							
								<table width="100%">
									<tr>
										<td align="center">
											<div id="msi004tab3Service" style="width:600px; overflow:scroll; border:1px solid e0e0e0;padding:0px;margin:0 auto;"> 
									
												<rich:dataTable align="center" style="width:100%;" id="dataService1tab3" cellpadding="1" cellspacing="0" border="0" 
												var="appSiteService"  value="#{semmsi004tab1Bean.siteAppServList}" reRender="dataService1tab3" 
												rows="" rowClasses="cur" styleClass="dataTable">
																
													<!-- header -->
													<f:facet name="header">
										                <rich:columnGroup>
											                <rich:column colspan="3" style="text-align:left;">
											                	<h:outputText value="#{jspMsg['column.header.serviceList']}"/>
											                </rich:column>
										                    <rich:column breakBefore="true" > 
																<h:outputText value="Service"/>
										                    </rich:column>  
										                    <rich:column style="white-space:nowrap;width:120px;">
					                                            <h:outputText value="Action"/>
					                                        </rich:column>
										                    <rich:column style="white-space:nowrap;width:70px;">
										                        <h:outputText value="Seq"/>
										                    </rich:column>
										                </rich:columnGroup>
										            </f:facet>
										            <!-- header -->
											
													<!-- data -->
													
								                    <rich:column style="text-align:center;">
					                                    <h:outputText value="#{appSiteService.dataObj.servName}" />
					                                </rich:column>
								                    <rich:column>
								                        <h:outputText value="#{appSiteService.dataObj.action}" />
								                    </rich:column>
								                    <rich:column style="text-align:center">
								                        <h:outputText value="#{appSiteService.dataObj.seq}" />
								                    </rich:column>
										            <!-- data -->
														
													<!-- footer -->
													<f:facet name="footer">
														<rich:columnGroup>
															<!-- > 1 -->
															<rich:column colspan="1">
						                                        <h:outputFormat value="#{msg['message.totalRecords']}">
						                                        	<f:param value="#{fn:length(semmsi004tab1Bean.siteAppServList)}"></f:param>
						                                        </h:outputFormat>
						                                    </rich:column>
															<!-- > 2 -->
															<rich:column colspan="2">
																	<rich:datascroller immediate="true" rendered="true" align="left" for="dataService1tab3"
																		maxPages="#{semmsi004tab1Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																		stepControls="hide" fastControls="auto" boundaryControls="auto" 
																		id="scrllDataService1tab3" style="background-color: #cccccc;"
																		page="#{semmsi004tab1Bean.scrollerPage}">
																	<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
																	</rich:datascroller>
															</rich:column>
														</rich:columnGroup>
													</f:facet>
													<!-- footer -->            
												</rich:dataTable>
														    	
											</div> 
										</td>
									</tr>
								</table> 
								<!-- table column: 10:90 -->
								
							</h:panelGroup>	
						</h:panelGrid>
					</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
					
					<rich:panel >
				
		
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_rentalServOtherinfo']} (#{jspMsg['label.th.datafromsiteacq']})" style="width: 100%;"/>
						</f:facet>
					
						<h:panelGroup>
						
							<rich:panel id="pnlRentalServOtherinfo" styleClass="sem_autoScrollbarInSATab1">
								<rich:dataTable id="dtbRentCondExt" cellpadding="1" cellspacing="0" border="0"
								var="rentCondSP"  value="#{semmsi004tab3Bean.rentCondExtSPList}" reRender="dtbRentCond" 
								rows="#{semmsi004tab3Bean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
		                            
		                            <rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.effDateStr}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.expireDtStr}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.changeEffectiveDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.periodStartDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.periodEndDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.expenseTypeName}" />
		                                </div>
		                      		</rich:column>
		                      	    <rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.expenseDesc']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.expenseDesc}" />
		                                </div>
		                      		</rich:column>
		                      		
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="Detail" styleClass="contentform" style="width: 400"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.detail}" />
		                                </div>
		                      		</rich:column>
		                      		
		                      		<rich:column sortBy="#{rentCondSP.rentOldAmt}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.column.rentOldAmt']}" styleClass="contentform" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{rentCondSP.rentOldAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{rentCondSP.rentAddPercent}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.column.rentAddPercent']}" styleClass="contentform" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{rentCondSP.rentAddPercent}" styleClass="contentform"  />
									</div>
								</rich:column>
								<rich:column sortBy="#{rentCondSP.rentAddAmt}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['header.column.rentAddAmt']}" styleClass="contentform" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{rentCondSP.rentAddAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
									</div>
								</rich:column>	
		                      		
		                      		<rich:column sortBy="#{rentCondSP.rentAmt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="right">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.rentAmt}" >
		                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                                    </h:outputText>
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.rentPeriodTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="W/T" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.whtTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.vatTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column rendered="false">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.paymentCond']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.payPeriodTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.rentalChange']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.rentAdjName} " />
		                                    <h:outputText styleClass="contentform" value=" #{rentCondSP.rentAdjPeriodTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column>
		                                <f:facet name="header">
		                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.serviceName}" />
		                                </div>
		                      		</rich:column>
									
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="3">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmsi004tab3Bean.rentCondSPList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<rich:column colspan="13">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCondExt"
													maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dstRentCondExt" 
													style="background-color: #cccccc;"
													page="#{semmsi004tab3Bean.scrollerPage}" 
												/>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
		                            
		                   		</rich:dataTable>
							</rich:panel>
						
						</h:panelGroup>
					</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
					<h:panelGroup>
	                	<div>
	                		
	                		<h:outputText value="#{jspMsg['label.th_changeRentalInfo']}" styleClass="ms7" rendered="#{semmsi004Bean.reqTypeParam != '01'}"/>
						
							<h:selectOneRadio id="rbtMsi004tab3_changeRental" value="#{semmsi004tab3Bean.rentEditFlag}" styleClass="ms7" 
							rendered="#{semmsi004Bean.reqTypeParam != '01'}"
							disabled="" onclick="fnMsi004tab3_changeRentalComfirm();">
	                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_notEdit']}" />
	                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_edit']}"/>
	                		</h:selectOneRadio>
	                		
	                		<a4j:jsFunction name="fnMsi004tab3_changeRentalComfirm"
	                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
	                		action="#{semmsi004tab3Action.doSetParamConfirmNotChangeRental}"
	                		 reRender="msi004tab3_pnlRentalPayNormal,btnEditRental,btnDeleteRental,
	                		 msi004PopUpCommon_commonConfirm"></a4j:jsFunction>
	                	</div>
	                </h:panelGroup>
					
					<rich:panel id="msi004tab3_pnlRentalPayNormal">
				
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_rentalServOtherCond']}"/>
						</f:facet>
						
						<h:panelGroup style="width:100%;">
							<!-- table column: 50:50 -->
							<div align="left">
								<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgFormTop}"/>
							</div>
							<table style="width:100%; border:solid 0px;" >
							   <tr>
							       <td colspan="2">
							       		<table style="width:100%; border:solid 0px;" >
							       			<tr>
							       				<td style="width:43%;">
										        	<h:selectBooleanCheckbox id="chkNoRent" value="#{semmsi004tab3Bean.chkNoRent}" styleClass="ms7"
													onclick="RenderNoRentJS();" disabled="#{(semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
								                	<h:outputText value="#{jspMsg['label.noExpenses']}" styleClass="ms7" />
								                	<a4j:jsFunction name="RenderNoRentJS" reRender="pnlRent,pnlRentCond,pnlSumRent,pnlSearchRentCondCriteria,pnlResultSearchRentCond,pnlGRentCondSpecial" 
									                	action="#{semmsi004tab3Action.renderedNoRent}"/>
							       				</td>
							       				<td align="left">
							       					
							       						<a4j:commandButton styleClass="rich-button" id="msi004tab3_popHistRental" 
									       				value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_rental']}"
														rendered="false">
															<f:param name="tabNo" value="3"/>
														</a4j:commandButton>
							       					
								       				
							       				</td>
							       			</tr>
							       		</table>
							           
							       </td>
							   	</tr>
							   	<h:panelGroup id="pnlSearchRentCondCriteria" rendered="#{semmsi004tab3Bean.renderDataTableRentCond}">
							   		<tr>
							   		<td colspan="2">
							   			<table style="width:100%; border:solid 1px;" border="0">
							       		
							       			<!-- row for condition -->
											<tr>
												<td>
													<h:panelGroup>
														<table width="100%">
															<tr>
																<td width="75%" align="left">
																	<script type="text/javascript">
																	var tempWhtRateRentSpecial = '';
																	var tempWhtRateServiceSpecial = '';
																	function renderedImgRequireTotalRent(){
																		var rentCondType02 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtRentCondType:1");
																		var imgAgeRent = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalAgeRentAmt");
																		var imgAgeService = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalAgeServiceAmt");
																		var detail1 = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtRentCondSpecialDetail").value;
																		var detail2 = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtServiceDetail").value;
																		if(rentCondType02.checked){
																			if(detail1 != ''){
																				imgAgeRent.style.display = '';
																			}else{
																				imgAgeRent.style.display = 'none';
																			}
																			if(detail2 != ''){
																				imgAgeService.style.display = '';
																			}else{
																				imgAgeService.style.display = 'none';
																			}
																		}else{
																			imgAgeRent.style.display = 'none';
																			imgAgeService.style.display = 'none';
																		}
																		tempWhtRateRentSpecial = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtWhtRateRentSpecial").value;
																		tempWhtRateServiceSpecial = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtWhtRateServiceSpecial").value;
																												
																	}
																	</script>               				
																</td>
															</tr>
														</table>
													</h:panelGroup>
												</td>
											</tr>
							<!-- row for normal condition tab3 -->
							<tr>
							<td>
							<h:panelGroup  id="pnlRentCondNormal">
							<table width="100%">
							<tr>
							   <td width="20%" align="right">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
								</td>
								<td width=18%" align="left">
									<h:selectOneMenu id="ddlExpenseType" value="#{semmsi004tab3Bean.rentCondNormal.expenseType}"
									disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" onchange="RenderedNormalVatTypeJS();"> 
											<f:selectItems value="#{semmsi004tab3Bean.expenseTypeRentList}"/>
									</h:selectOneMenu>
									
									<a4j:jsFunction name="RenderedNormalVatTypeJS" reRender="pnlRentCondNormal" 
									action="#{semmsi004tab3Action.renderedNormalVatType}" oncomplete="setTempWhtRateNormal();"/>
									
									<script type="text/javascript">
										var tempWhtRateRentNormal = '';
										var tempWhtRateServiceNormal = '';
										function setTempWhtRateNormal(){
											var ddlExpenseType = document.getElementById("incContent:frmAddSiteInfo:incTab3:ddlExpenseType").value;
											var whtRate = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtWhtRateNormal");
											if(ddlExpenseType != '' && ddlExpenseType == '01'){
												tempWhtRateRentNormal = whtRate.value;
											}else if(ddlExpenseType != '' && ddlExpenseType == '02'){
												tempWhtRateServiceNormal = whtRate.value;
											}else{
												tempWhtRateRentNormal = '';
												tempWhtRateServiceNormal = '';
												whtRate.value = '';
											}
										}
									</script>
								</td>
								
								<td width="15%" align="right">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value=" #{jspMsg['label.th_expense_desc']} :" style="margin:0 0 0 0;" styleClass="ms7" />
								</td>
								<td align="left">
									<h:inputTextarea id="msi004tab3_expenseDesc" style="width:90%;" rows="2" 
			       					value="#{semmsi004tab3Bean.rentCondNormal.expenseDesc}" 
			       					disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || semmsi004tab3Bean.disabledExpenseDesc }">
			       					</h:inputTextarea>
							    </td>								
							  							
							</tr>
							<tr>
							 <td width="20%" align="right">											
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.placeName']}" styleClass="ms7"/>
							 </td>
							 <td width="30%" align="left">
								<h:inputText id="txtPlaceName" value="#{semmsi004tab3Bean.rentCondNormal.placeName}" 
                					size="30" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
						    </td>	
							</tr>
							<tr>
								<td align="right" width="20%" valign="top">
									<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
	                			</td>
	                			<td colspan="3" width="80%">
		                			<h:inputTextarea id="txtDetail" value="#{semmsi004tab3Bean.rentCondNormal.detail}" 
		                			cols="100" rows="3" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
			                	</td>
		                	 </tr>
		                	 <tr>
								<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.ownerGroup']}" styleClass="ms7"/>
	                			</td>
	                			<td width="80%" colspan="3">
		                			<h:selectOneMenu id="ddlOwnerGroup" value="#{semmsi004tab2Bean.contract.ownerGroup}"
		                			disabled="#{semmsi004tab2Bean.disabledContract || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
									<f:selectItems value="#{semmsi004tab2Bean.ownerGroupList}"/>
									</h:selectOneMenu>
			                	</td>
		                	 </tr>
		                	 
		                	 <h:panelGroup rendered="#{semmsi004tab3Bean.renderedRentOldAmt}">
		                	 	<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.rentOldAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="80%">
			                			<h:inputText id="txtRentOldAmt2" value="#{semmsi004tab3Bean.rentCondNormal.rentOldAmt}" size="15" 
		              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		              						 onblur="return numberformat.moneyFormat(this);"
		              						 onfocus="return numberformat.setCursorPosToEnd(this);"
		              						 maxlength="16" 
		              						 styleClass="inputRight"
		              						 disabled="#{semmsi004tab3Bean.disabledRentOldAmt || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
			                			<rich:spacer width="2"></rich:spacer>
			                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                			<rich:spacer width="2"></rich:spacer>
			                			<h:outputText value="/" styleClass="ms7"/>
			                			<rich:spacer width="2"></rich:spacer>
		               					<h:selectOneMenu id="ddlRentOldPeriodType" value="#{semmsi004tab3Bean.rentCondNormal.rentOldPeriodType}"
		               					disabled="#{semmsi004tab3Bean.disabledPeriodType || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
										<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
										</h:selectOneMenu>
				                	</td>
			                	</tr>
			                	<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.rentAddPercent']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="80%">
		                			<table width="75%">
		                				 <tr>
		                				 	<td width="20%">
		                				 	<h:inputText id="txtRentAddPercent" value="#{semmsi004tab3Bean.rentCondNormal.rentAddPercent}" 
		                					size="10" maxlength="12" styleClass="inputRight" 
		                					disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
		                					onchange="CalRentAddAmtJS();"
		                					onkeypress="return numberformat.keyPressDecimal(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		              						onfocus="return numberformat.setCursorPosToEnd(this);">
		                					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                					<a4j:support event="oninputchange" ajaxSingle="true" reRender="txtRentAddAmt2,txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAddAmt}"/>
											<a4j:support event="oninputblur" ajaxSingle="true" reRender="txtRentAddAmt2,txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAddAmt}"/>
											<a4j:support event="onchanged" ajaxSingle="true" reRender="txtRentAddAmt2,txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAddAmt}"/>
											<a4j:jsFunction name="CalRentAddAmtJS" action="#{semmsi004tab3Action.calRentAddAmt}" 
											 reRender="txtRentAddAmt2,txtRentalAmount"/>
		                					</h:inputText>
		                				 	<rich:spacer width="2" ></rich:spacer>
		                					<h:outputText value="%" styleClass="ms7"/>
		                				 	</td>
		                				 	<td width="55%" align="left" colspan="2">	
		                				 	<h:inputText id="txtRentAddAmt2" value="#{semmsi004tab3Bean.rentCondNormal.rentAddAmt}" size="15" 
		              						 onkeypress="return numberformat.keyPressDecimal(this, event);"
		              						 onblur="return numberformat.moneyFormat(this);"
		              						 onfocus="return numberformat.setCursorPosToEnd(this);"
		              						 maxlength="16" 
		              						 styleClass="inputRight"
		              						 disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
		              						 onchange="CalRentAmtJS();">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                					<a4j:support event="oninputchange" ajaxSingle="true" reRender="txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAmt}"/>
											<a4j:support event="oninputblur" ajaxSingle="true" reRender="txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAmt}"/>
											<a4j:support event="onchanged" ajaxSingle="true" reRender="txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAmt}"/>
											<a4j:jsFunction name="CalRentAmtJS" action="#{semmsi004tab3Action.calRentAmt}" 
											 reRender="txtRentalAmount,txtRentAddPercent"/>
		                					</h:inputText>
		                					<rich:spacer width="2"></rich:spacer>
				                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
				                			<rich:spacer width="2"></rich:spacer>
				                			<h:outputText value="/" styleClass="ms7"/>
				                			<rich:spacer width="2"></rich:spacer>
				                			<h:selectOneMenu id="ddlRentAddPeriodType" value="#{semmsi004tab3Bean.rentCondNormal.rentAddPeriodType}"
		                				 	disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
											<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
											</h:selectOneMenu>
		                				 	</td>
		                				 </tr>
		                				</table>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
			                	  <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.rentalAmount']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="80%">
					                	<h:inputText id="txtRentalAmount" value="#{semmsi004tab3Bean.rentCondNormal.rentAmt}" size="15" 
			              				onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			              				onblur="CalRentAddPercentAndRentAddAmt();return numberformat.moneyFormat(this);"
			              				onfocus="return numberformat.setCursorPosToEnd(this);"
			              						 maxlength="16" 
			              						 styleClass="inputRight"
			              						 disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
			              						 onchange="CalRentAddPercentAndRentAddAmt();">
												<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												<a4j:support event="oninputchange" ajaxSingle="true" reRender="txtRentAddPercent,txtRentAddAmt2" 
												action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}"/>
												<a4j:support event="oninputblur" ajaxSingle="true" reRender="txtRentAddPercent,txtRentAddAmt2" 
												action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}"/>
												<a4j:support event="onchanged" ajaxSingle="true" reRender="txtRentAddPercent,txtRentAddAmt2" 
												action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}"/>
					                			</h:inputText>
					                			<a4j:jsFunction name="CalRentAddPercentAndRentAddAmt" action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}" 
												reRender="txtRentAddPercent,txtRentAddAmt2"/>
					                			<rich:spacer width="2"></rich:spacer>
					                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
					                			<rich:spacer width="2"></rich:spacer>
					                			<h:outputText value="/" styleClass="ms7"/>
					                			<rich:spacer width="2"></rich:spacer>
			                					<h:selectOneMenu id="ddlRentalPeriodType" value="#{semmsi004tab3Bean.rentCondNormal.rentPeriodType}"
			                					disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" 
			                					onchange="defaultRentPayPeriodType();"> 
												<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
												</h:selectOneMenu>
												<script type="text/javascript">
												function defaultRentPayPeriodType(){
												var periodType = document.getElementById("incContent:frmAddSiteInfo:incTab3:ddlRentalPeriodType").value;
												var payPeriodType01 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType01:0");
												var payPeriodType02 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType02:0");
												var payPeriodType03 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType03:0");
												var payPeriodType04 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType04:0");
												var payPeriodType05 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType05:0");
												var year = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtPayPeriodTypeYear");
												var month = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtPayPeriodTypeMonth");
												if(periodType != '' && periodType == 'Y'){
													payPeriodType02.checked = true;
													payPeriodType01.checked = false;
													payPeriodType05.checked = false;
													
												} else if (periodType != '' && periodType == 'O') {
													payPeriodType01.checked = false;
													payPeriodType02.checked = false;
													payPeriodType05.checked = true;
												} else {
													payPeriodType01.checked = true;
													payPeriodType02.checked = false;
													payPeriodType05.checked = false;
												}
			
												payPeriodType03.checked = false;
												payPeriodType04.checked = false;
												
												year.value = '';
												month.value = '';
												year.disabled = true;
												month.disabled =true;
												CalRentAddPercentAndRentAddAmt();
											}
										</script>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" align="left" colspan="3">
			                			<table width="100%" border="0" cellspacing="0">
			                			 <tr>
			                			 <td width="50%" align="left">
				                			 <h:selectOneRadio id="rbtWhtTypeNormalRent" value="#{semmsi004tab3Bean.rentCondNormal.whtType}"  
				                			 styleClass="ms7" rendered="true" 
				                			 disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" 
				                			 onclick="ClearWhtRateJS();">
			                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']} " />
			                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}"/>
			                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']} " />
			                				</h:selectOneRadio>
			                				<a4j:jsFunction name="ClearWhtRateJS"  action="#{semmsi004tab3Action.clearWhtRate}"  reRender="txtWhtRateNormal,chkWhtRateNormal"/>
			                			 </td>
			                			<td width="50%" align="left">
			                			 <h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
										<rich:spacer width="2"></rich:spacer>
			                			<h:inputText id="txtWhtRateNormal" value="#{semmsi004tab3Bean.rentCondNormal.whtRate}" 
			                			disabled="#{semmsi004tab3Bean.disabledWhtRateNormal || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
			                				<f:convertNumber pattern="#,##0.00" maxIntegerDigits="7" maxFractionDigits="2" />
			                			</h:inputText>
			                			<rich:spacer width="2"></rich:spacer>
			                			<h:outputText value="%" styleClass="ms7"/>
			                			<rich:spacer width="2"></rich:spacer>
			                			<h:selectBooleanCheckbox id="chkWhtRateNormal"  styleClass="ms7" onclick="RenderWhtRateNormalJS();" 
			                			value="#{semmsi004tab3Bean.chkWhtRateNormal}" 
			                			disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
		                				<h:outputText value="#{jspMsg['label.edit']}"  styleClass="ms7"/>
		                				<a4j:jsFunction name="RenderWhtRateNormalJS" reRender="txtWhtRateNormal" 
		                				action="#{semmsi004tab3Action.renderWhtRateNormal}" />
			                			 </td>
			                			 </tr>
			                			 </table>
		                			 </td>
		                		</tr>
		                		<h:panelGroup  rendered="true">
		                		<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3" align="left">
		                			<h:selectOneRadio id="rbtVatType" value="#{semmsi004tab3Bean.rentCondNormal.vatType}"  
		                			styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
		                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
		                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
		                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
		                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.vatType00']} "/>
	                				</h:selectOneRadio>
				                	</td>
			                	</tr>
			                	</h:panelGroup>
			                	<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" align="left" colspan="3">
		                			<h:panelGrid columns="7">
		                			<h:panelGroup>
			                			<h:selectOneRadio id="rbtPayPeriodType01" value="#{semmsi004tab3Bean.payPeriodType01}"  styleClass="ms7" rendered="true"
			                			onclick="setPayPeriodType01();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
		                				
		                					<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
		                				
		                					<a4j:jsFunction name="setPayPeriodType01" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 	reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 	txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        		
							        			<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
							        		</a4j:jsFunction>
		                				</h:selectOneRadio>
	                				</h:panelGroup>
	                				
	                				<h:panelGroup>
										<h:selectOneRadio id="msi004tab3_rbtPayPeriodType06" value="#{semmsi004tab3Bean.payPeriodType06}"  styleClass="ms7" rendered="true"
			                			onclick="setPayPeriodType06();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													                				
											<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
											
											<a4j:jsFunction name="setPayPeriodType06" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 	reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 	txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        		
							        			<a4j:actionparam  name="payPeriodType" value="06"></a4j:actionparam>
							        		</a4j:jsFunction>
													             
										</h:selectOneRadio>
									</h:panelGroup>
									
									<h:panelGroup>
										<h:selectOneRadio id="msi004tab3_rbtPayPeriodType07" value="#{semmsi004tab3Bean.payPeriodType07}" styleClass="ms7" rendered="true"
			                			onclick="setPayPeriodType07();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
														                				
											<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
											
											<a4j:jsFunction name="setPayPeriodType07" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 	reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 	txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        		
							        			<a4j:actionparam  name="payPeriodType" value="07"></a4j:actionparam>
							        		</a4j:jsFunction>
														            
										</h:selectOneRadio>
									</h:panelGroup>
	                				
	                				<h:panelGroup>
			                			<h:selectOneRadio id="rbtPayPeriodType02" value="#{semmsi004tab3Bean.payPeriodType02}"  styleClass="ms7" rendered="true"
			                			onclick="setPayPeriodType02();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
		                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}"/>
		                				<a4j:jsFunction name="setPayPeriodType02" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        	<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
	                				</h:panelGroup>
	                				<h:panelGroup>
	                				<table>
	                					<tr> 
	                					<td>
	                					<h:selectOneRadio id="rbtPayPeriodType03" value="#{semmsi004tab3Bean.payPeriodType03}"  styleClass="ms7" rendered="true"
	                					onclick="setPayPeriodType03();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
		                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
		                				<a4j:jsFunction name="setPayPeriodType03" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        	<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
		                				</td>
		                				<td>
		                				<h:inputText id="txtPayPeriodTypeMonth" size="5"  disabled="#{semmsi004tab3Bean.disabledPayPeriod03 || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
		                				value="#{semmsi004tab3Bean.payPeriod03}" styleClass="inputRight"
		                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
		                				<rich:spacer width="5"></rich:spacer>
		                				<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
		                				</td>
		                				</tr>
		                				</table>
		                			</h:panelGroup>
		                			<h:panelGroup>
		                			<table>
	                					<tr>
	                					<td>
	                					<h:selectOneRadio id="rbtPayPeriodType04" value="#{semmsi004tab3Bean.payPeriodType04}"  styleClass="ms7" rendered="true"
	                					onclick="setPayPeriodType04();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
		                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
		                				<a4j:jsFunction name="setPayPeriodType04" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        	<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
		                				</td>
		                				<td>
		                				<h:inputText id="txtPayPeriodTypeYear" size="5"  disabled="#{semmsi004tab3Bean.disabledPayPeriod04 || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
		                				value="#{semmsi004tab3Bean.payPeriod04}" styleClass="inputRight"
		                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
		                				<rich:spacer width="5"></rich:spacer>
		                				<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"></h:outputText>
		                				</td>
		                				</tr>
		                				</table>
		                			</h:panelGroup>
		                			<h:panelGroup>
	                					<h:selectOneRadio id="rbtPayPeriodType05" value="#{semmsi004tab3Bean.payPeriodType05}"  styleClass="ms7" rendered="true"
	                					onclick="setPayPeriodType05();" disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
		                				<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
		                				<a4j:jsFunction name="setPayPeriodType05" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,
		                				 txtPayPeriodTypeYear,msi004tab3_rbtPayPeriodType06,msi004tab3_rbtPayPeriodType07">
							        	<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
		                			</h:panelGroup>
	                				
	                				</h:panelGrid>
	                				</td>
			                	 </tr>
			                	 
			                	 <tr>
							     	<td style="text-align:right;" valign="top">
													<h:outputText value="#{jspMsg['column.header.startPeriodDate']} : " styleClass="ms7" />
							       				</td>
							       				<td style="text-align:left;" valign="top" colspan="3">
							       					<a4j:region>
														<!-- begin date -->
														<rich:calendar id="msi004tab3_periodStartDt" locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmsi004tab3Bean.rentCondNormal.periodStartDt}"
															   showWeeksBar="false"
															   inputSize="10"
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														   	   cellWidth="15px" cellHeight="20px"
														   	   oninputblur="msa002tab3_calDtmJS();"
											   	   			   oncollapse="msa002tab3_calDtmJS();"
											   	   			   oninputchange="msa002tab3_calDtmJS();"
											   	   			   disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
														   	   styleClass="ms7">
														</rich:calendar>
														
														<rich:spacer width="50"></rich:spacer>
														<h:outputText value="#{jspMsg['column.header.endPeriodDate']} :  " styleClass="ms7" />
														<!-- end date -->
											<rich:calendar id="msi004tab3_periodEndDt" locale="th" enableManualInput="true" 
											datePattern="dd/MM/yyyy" 
											value="#{semmsi004tab3Bean.rentCondNormal.periodEndDt}" showWeeksBar="false"
											inputSize="10"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											oninputblur="msa002tab3_calDtmJS();"
											oncollapse="msa002tab3_calDtmJS();"
											oninputchange="msa002tab3_calDtmJS();"
											disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
											cellWidth="15px" cellHeight="20px" label="" styleClass="ms7">
											</rich:calendar>
										</a4j:region>
										
										<a4j:jsFunction name="msa002tab3_calDtmJS" action="#{semmsi004tab3Action.calRentalPeriod}"
										reRender="frmSiteInfoError,pnlRentMsgMid,msi004tab3_periodStartDt,msi004tab3_periodEndDt"></a4j:jsFunction>
							    	</td>
								</tr>
								
								<tr>
							       				<td style="text-align:right;" valign="top">
							       				</td>
							       				<td style="text-align:left;" valign="top" colspan="3">
							       					<h:selectBooleanCheckbox value="#{semmsi004tab3Bean.chkRentAdj}" onclick="reRenderRentAdd();"
							       					disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       						
							       					</h:selectBooleanCheckbox>
							       					<h:outputText value="#{jspMsg['column.header.rentalChange']}" styleClass="ms7"></h:outputText>
							       					<a4j:jsFunction name="reRenderRentAdd" reRender="msi004tab3_rentAdj,msi004tab3_rentAdjPeriod"></a4j:jsFunction>
							       					<rich:spacer width="10"></rich:spacer>
							       					
							       					<h:selectOneMenu id="msi004tab3_rentAdj" value="#{semmsi004tab3Bean.rentCondNormal.rentAdj}"
							       					disabled="#{!semmsi004tab3Bean.chkRentAdj || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       						<f:selectItems value="#{semmsi004tab3Bean.rentAdjList}"/> 
							       					</h:selectOneMenu>
							       					
							       					<rich:spacer width="10"></rich:spacer>
							       					
							       					<h:outputText value="#{jspMsg['column.header.perPeriod']} : " styleClass="ms7"></h:outputText>
							       					
							       					<h:selectOneMenu id="msi004tab3_rentAdjPeriod" value="#{semmsi004tab3Bean.rentCondNormal.rentAdjPeriodType}" 
							       					disabled="#{!semmsi004tab3Bean.chkRentAdj || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" styleClass="ms7">
														<f:selectItems value="#{semmsi004tab3Bean.promiseRenewPeriodTypeList}"/>
							       					</h:selectOneMenu>
							       					
							       					<rich:spacer width="90"></rich:spacer>
							       					
							       					<h:selectBooleanCheckbox value="#{semmsi004tab3Bean.chkServId}" onclick="reRenderServ();"
							       					disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:selectBooleanCheckbox>
							       					<h:outputText value="Service" styleClass="ms7"></h:outputText>
							       					<a4j:jsFunction name="reRenderServ" reRender="msi004tab3_service"></a4j:jsFunction>
							       					
							       					<rich:spacer width="10"></rich:spacer>
							       					
							       		<h:selectOneMenu id="msi004tab3_service" value="#{semmsi004tab3Bean.rentCondNormal.serviceId}"
							       		 disabled="#{!semmsi004tab3Bean.chkServId || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       			<f:selectItems value="#{semmsi004tab1Bean.servTypeList}"/>
							       		</h:selectOneMenu>
							       					
							    	</td>
							       				
							    </tr>
			                	 
			                	<h:panelGroup rendered="#{semmsi004tab3Bean.renderedEffDate}">
			                	<tr>
									<td align="right" width="20%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.effectiveDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="80%" colspan="3">
		                			<rich:calendar id="cldEffDate2" locale="th" enableManualInput="true"
									datePattern="dd/MM/yyyy" 
									value="#{semmsi004tab3Bean.rentCondNormal.effectiveDt}" 
									showWeeksBar="false"
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.effectiveDate']}"
									rendered="#{semmsi004Bean.reqTypeParam == '03' || semmsi004Bean.reqTypeParam == '04'}"
									disabled="#{semmsi004tab3Bean.disabledRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
									</rich:calendar>
		                			</td>
		                			</tr>
		                		</h:panelGroup>
		                		<tr>
									<td align="right" width="20%">
		                			</td>
		                			<td width="80%" colspan="3">
		                			<h:selectBooleanCheckbox id="chkRentOverFlag" value="#{semmsi004tab3Bean.chkOverFlag}" styleClass="ms7"
		                			disabled="#{semmsi004tab3Bean.disabledRent}" rendered="false"/>
						             <h:outputText value="#{jspMsg['label.overFlag']}" styleClass="ms7" rendered="false"/>
				                	</td>
			                	 </tr>
		                		<tr>
			                	 <td colspan="4" width="100%">
			                	 	<h:panelGroup rendered="#{semmsi004Bean.renderedModeView && semmsi004tab3Bean.renderDataTableRentCond}">
					                	<a4j:commandButton id="btnAddRentCond" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
						           		action="#{navAction.navi}" 
						           		reRender="msi004tab3_pnlRentalPayNormal,pnlResultSearchRentCond,pnlMsi004tab3_totalRental" 
						           		disabled="#{semmsi004tab3Bean.disabledBtnAddRentCond || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
						           		<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="doAddRentCond" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"></rich:spacer>
						           		
						           		<a4j:commandButton id="btnSaveRentCond" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
						           		action="#{navAction.navi}" 
						           		reRender="msi004tab3_pnlRentalPayNormal,pnlResultSearchRentCond,pnlMsi004tab3_totalRental" 
						           		disabled="#{semmsi004tab3Bean.disabledBtnUpdateRentCond || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
						           		<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="doUpdateRentCond" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"></rich:spacer>
					                	
					                	<a4j:commandButton id="btnCancelRentCond" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
						           		action="#{navAction.navi}" 
						           		reRender="msi004tab3_pnlRentalPayNormal,pnlResultSearchRentCond,pnlMsi004tab3_totalRental" 
						           		disabled="#{semmsi004tab3Bean.disabledRent || semmsi004Bean.disabledModeView || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
						           		<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="doClearRentCond" />
						           		</a4j:commandButton>
					           		</h:panelGroup>
			                	 </td>
			                	 </tr>
							</table>
							</h:panelGroup>
							</td>
							</tr>
							<!-- row for rentCond special -->
							<tr>
							<td>
							 
							</td>
							</tr>
							       		</table>
							   		</td>
							   	</tr>
							   	</h:panelGroup>
							   	
							</table>
							
						</h:panelGroup>
					</rich:panel>
		           
		           	<rich:spacer height="10"></rich:spacer>
		           	
		           	<rich:panel id="pnlResultSearchRentCond" rendered="#{semmsi004tab3Bean.renderDataTableRentCond}">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_rentalServOtherinfo']}" style="width: 100%;"/>
						</f:facet>
					
						<h:panelGroup>
						
							<rich:panel id="pnlRentalServOtherinfoCur" styleClass="sem_autoScrollbarInSATab1">
								<rich:dataTable id="dtbRentCond" cellpadding="1" cellspacing="0" border="0"
								var="rentCondSP"  value="#{semmsi004tab3Bean.rentCondSPList}" reRender="dtbRentCond" 
								rows="#{semmsi004tab3Bean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
		                            
		                            <rich:column styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}"
									rendered="#{semmsi004Bean.renderedModeView}">
										<f:facet name="header" >
											<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
										</f:facet>
										<div align="center">
			            					<a4j:commandButton id="btnEditRental" action="#{navAction.navi}" reRender="pnlRentCondNormal,pnlRentCond"
			            					image="images/edit.png" style="height: 15; width: 15" 
			            					rendered="#{semmsi004tab3Bean.editableRentFlag == 'Y'}"
			            					disabled="#{(semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
												<a4j:actionparam name="navModule" value="si" />
				            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
												<a4j:actionparam name="moduleWithNavi" value="si" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
												<a4j:actionparam name="methodWithNavi" value="initUpdateRentCond" />
												<a4j:actionparam name="rowId" value="#{rentCondSP.rowId}" />
			            					</a4j:commandButton>          							
										</div>
									</rich:column>
									 
								    <rich:column styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}" rendered="#{semmsi004Bean.renderedModeView}">
		                            <f:facet name="header">
		                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
		                            </f:facet>
		                            <div align="center">
			                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
			                            disabled="#{(semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"	
			                            reRender="msi004tab3_pnlRentalPayNormal,pnlResultSearchRentCond,pnlMsi004tab3_totalRental" 			                            
			                            rendered="#{rentCondSP.renderedButtonDelete && rentCondSP.recordStatus eq 'Y'}"
			                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" >
			                                <a4j:actionparam name="navModule" value="si" />
			                                <a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />		                                                    
			                                <a4j:actionparam name="moduleWithNavi" value="si" />
			                                <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
			                                <a4j:actionparam name="methodWithNavi" value="doDeleteRentCond" />
			                                <a4j:actionparam name="rowId" value="#{rentCondSP.rowId}" />		                             
			                            </a4j:commandButton>
		                            </div>
	                                </rich:column>									
									<rich:column sortBy="#{rentCondSP.recordStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="Status" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="ms7red" value="Delete" rendered="#{rentCondSP.recordStatus eq 'N'}"/>
		                                </div>
		                      		</rich:column>
									
									<rich:column sortBy="#{rentCondSP.startDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.startDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.expireDtStr}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.expireDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.effDate}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.effDateStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.periodStartDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.periodStartDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.periodEndDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 80"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.periodEndDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.expenseTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.expenseTypeName}"/>
		                                </div>
		                      		</rich:column>
		                      			<rich:column sortBy="#{rentCondSP.expenseDesc}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.expenseDesc']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.expenseDesc}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.detail}">
		                                <f:facet name="header">
		                                    <h:outputText value="Detail" styleClass="contentform" style="width: 300"/>
		                                </f:facet>
		                                <div align="left">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.detail}"/>
		                                </div>
		                      		</rich:column>
		                      		
		                      		<rich:column sortBy="#{rentCondSP.rentOldAmt}" >
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.column.rentOldAmt']}" styleClass="contentform" />
										</f:facet>
										<div align="right">
											<h:outputText value="#{rentCondSP.rentOldAmt}" styleClass="contentform">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
										</div>
									</rich:column>
									<rich:column sortBy="#{rentCondSP.rentAddPercent}" >
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.column.rentAddPercent']}" styleClass="contentform" />
										</f:facet>
										<div align="right">
											<h:outputText value="#{rentCondSP.rentAddPercent}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column sortBy="#{rentCondSP.rentAddAmt}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.column.rentAddAmt']}" styleClass="contentform" />
										</f:facet>
										<div align="right">
											<h:outputText value="#{rentCondSP.rentAddAmt}" styleClass="contentform">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
											</h:outputText>
										</div>
									</rich:column>	
		                      		
		                      		<rich:column sortBy="#{rentCondSP.rentAmt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="right">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.rentAmt}">
		                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                                    </h:outputText>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.rentPeriodTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.rentPeriodTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.whtTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="W/T" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.whtTypeName}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.vatTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.vatTypeName}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.payPeriodTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.paymentCond']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"   value="#{rentCondSP.payPeriodTypeName}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.payPeriodTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.rentalChange']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.rentAdjName}" />
		                                    <h:outputText styleClass="contentform" value="% " rendered="#{rentCondSP.rentAdj != '' && rentCondSP.rentAdj != null}"/>
		                                    <h:outputText styleClass="contentform" value="#{rentCondSP.rentAdjPeriodTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{rentCondSP.serviceName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{rentCondSP.serviceName}" />
		                                </div>
		                      		</rich:column>
									
									
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="3">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmsi004tab3Bean.rentCondSPList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<rich:column colspan="17">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCond"
													maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dstRentCond" 
													style="background-color: #cccccc;"
													page="#{semmsi004tab3Bean.scrollerPage}" 
												/>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
		                            
		                   		</rich:dataTable>
							</rich:panel>
						
						</h:panelGroup>
					</rich:panel>
		           	
		           	<rich:spacer height="10"></rich:spacer>
		           	
		           	<rich:panel id="pnlMsi004tab3_totalRental">
		           		<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgFormMiddle}"/>
						</div>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_totalPayment']}" />
						</f:facet>
					
						<h:panelGroup style="width:100%;">
							<table style="width:100%;">
								<tr>
									<td valign="top" colspan="4" align="center">
						       					
						       			<rich:dataTable style="width:50%;" id="dataService1tab2" cellpadding="1" cellspacing="0" border="0" 
										var="appSiteService"  value="#{semmsi004tab3Bean.siteAppRentServList}" reRender="dataService1tab2" 
										rows="" rowClasses="cur" styleClass="dataTable">
										
									                 <rich:column>
						                                <f:facet name="header">
						                                    <h:outputText value="#{jspMsg['column.header.paymenttype']}" styleClass="contentform" style="width: 100"/>
						                                </f:facet>
						                                <div align="center">
						                                    <h:outputText value="#{appSiteService.dataObj.expenseType}"  styleClass="ms7"/>
						                                </div>
						                      		</rich:column>
								                    <rich:column >
								                    	 <f:facet name="header">
						                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
						                                </f:facet>
						                                <div align="center">
						                                    <h:outputText value="#{appSiteService.dataObj.serviceName}"  styleClass="ms7"/>
						                                </div>
			                                        </rich:column>
								                    <rich:column >
								                     	<f:facet name="header">
						                                    <h:outputText value="#{jspMsg['column.header.totalPayment']}" styleClass="contentform" style="width: 100"/>
						                                </f:facet>
						                                <div align="right">
						                                    <h:outputText value="#{appSiteService.dataObj.rentAmt}" style="text-align:right;" styleClass="ms7">
																<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
															</h:outputText>
						                                </div>
								                    </rich:column>
								               
									
								            <!-- footer -->
											<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="3">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsi004tab3Bean.siteAppRentServList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
				                                </rich:columnGroup>
				                            </f:facet>
											<!-- footer -->
								            
								   		</rich:dataTable>
						       					
						       		</td>
								</tr>
								<tr>
									<td style="text-align:left;" valign="top" colspan="4">
						       			<h:outputText value="#{jspMsg['label.th_totalPaymentbyPaymentType']}" styleClass="ms7" style="text-decoration:underline;" />		
						       		</td>
						       		
								</tr>
								
							</table>
						</h:panelGroup>
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
								<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRent}">
		                		<tr>
								<td align="right" width="15%">
								<h:outputText value="#{jspMsg['label.rentAddAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="33%">
	                			 <h:inputText id="txtRentAddAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalRentAddAmt}" size="18" 
		   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		   						 onblur="return numberformat.moneyFormat(this);"
		   						 onfocus="return numberformat.setCursorPosToEnd(this);"
		   						 maxlength="16" 
		   						 styleClass="inputRight"
		   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		              			</h:inputText>
	              				<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="/" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	              				<h:selectOneMenu id="ddlTotalRentAddPeriodType" value="#{semmsi004tab3Bean.totalRent.totalRentAddPeriodType}"
	              				disabled="#{semmsi004tab3Bean.disabledRent  || semmsi004tab3Bean.disabledTotalNormalRent
	              				|| (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.serviceAddAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="32%">
	                			<h:inputText id="txtServiceAddAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalServiceAddAmt}" size="18" 
		   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		   						 onblur="return numberformat.moneyFormat(this);"
		   						 onfocus="return numberformat.setCursorPosToEnd(this);"
		   						 maxlength="16" 
		   						 styleClass="inputRight"
		   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		              			</h:inputText>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="/" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	              				<h:selectOneMenu id="ddlTotalServiceAddPeriodType" value="#{semmsi004tab3Bean.totalRent.totalServiceAddPeriodType}"
	              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
								</h:selectOneMenu>
			                	</td>
		                		</tr>
		                		
		                		<tr>
								<td align="right" width="15%">
								<h:outputText value="#{jspMsg['label.rentAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="33%">
	                			 <h:inputText id="txtRentAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalRentAmt}" size="18" 
		   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		   						 onblur="return numberformat.moneyFormat(this);"
		   						 onfocus="return numberformat.setCursorPosToEnd(this);"
		   						 maxlength="16" 
		   						 style="text-align:right;"
		   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		              			</h:inputText>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="/" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	              				<h:selectOneMenu id="ddlTotalRentPeriodType" value="#{semmsi004tab3Bean.totalRent.totalRentPeriodType}"
	              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
								</h:selectOneMenu>
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.serviceAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="32%">
	                			 <h:inputText id="txtServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalServiceAmt}" size="18" 
		   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		   						 onblur="return numberformat.moneyFormat(this);"
		   						 onfocus="return numberformat.setCursorPosToEnd(this);"
		   						 maxlength="16" 
		   						 style="text-align:right;"
		   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		              			</h:inputText>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="/" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	              				<h:selectOneMenu id="ddlTotalServicePeriodType" value="#{semmsi004tab3Bean.totalRent.totalServicePeriodType}"
	              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
								</h:selectOneMenu>
			                	</td>
		                		</tr>
		                		
		                		<tr>
		                		<td align="right" width="15%">
								<h:outputText value="#{jspMsg['label.rentServiceAmt']}" styleClass="ms7BlueBold"/>
	                			</td>
	                			<td width="85%" colspan="3">
	                			 <h:inputText id="txtRentServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalRentServiceAmt}" size="18" 
		   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		   						 onblur="return numberformat.moneyFormat(this);"
		   						 onfocus="return numberformat.setCursorPosToEnd(this);"
		   						 maxlength="16" 
		   						 style="text-align:right;"
		   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		              			</h:inputText>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="/" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	              				<h:selectOneMenu id="ddlTotalRentServicePeriodType" value="#{semmsi004tab3Bean.totalRent.totalRentServicePeriodType}"
	              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
								</h:selectOneMenu>
			                	</td>
		                		</tr>
		                		<tr>
								<td align="right" width="15%">
	                			</td>
	                			<td width="33%">
			                	</td>
			                	<td align="right" width="20%">
								<h:graphicImage id="imgRequireTotalAgeRentAmt" value="images/icon_required.gif" 
								style="#{(not(semmsi004tab3Bean.rentCondSpecial1.detail eq '') and semmsi004tab3Bean.rentCondNormal.rentCondType eq '02') ? '':'display:none;'}"/>
								<rich:spacer width="2"></rich:spacer>
								<h:outputText value="#{jspMsg['label.totalAgeRentAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="32%">
	                			 <h:inputText id="txtTotalAgeRentAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeRentAmt}" 
	        						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	        						 onblur="SumTotalRentServiceAmtJS();return numberformat.moneyFormat(this);"
	        						 onfocus="return numberformat.setCursorPosToEnd(this);"
	        						 maxlength="16" 
	        						 style="text-align:right;"
	        						 size="18"
	        						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                			</h:inputText>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                	</td>
		                		</tr>
		                		
		                		<tr>
								<td align="right" width="15%">
	                			</td>
	                			<td width="33%">
			                	</td>
			                	<td align="right" width="20%">
								<h:graphicImage id="imgRequireTotalAgeServiceAmt" value="images/icon_required.gif" 
								style="#{(not(semmsi004tab3Bean.rentCondSpecial2.detail eq '') and semmsi004tab3Bean.rentCondNormal.rentCondType eq '02') ? '':'display:none;'}"/>
								<rich:spacer width="2"></rich:spacer>
								<h:outputText value="#{jspMsg['label.totalAgeServiceAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="32%">
	                			 <h:inputText id="txtTotalAgeServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeServiceAmt}" 
	       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	       						 onblur="SumTotalRentServiceAmtJS();return numberformat.moneyFormat(this);"
	       						 onfocus="return numberformat.setCursorPosToEnd(this);"
	       						 maxlength="16" 
	       						 style="text-align:right;"
	       						 size="18"
	       						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                			</h:inputText>
	                			<a4j:jsFunction name="SumTotalRentServiceAmtJS" reRender="txtTotalAgeRentServiceAmtTab3" 
	                			action="#{semmsi004tab3Action.calTotalAgeServiceAmt}"/>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                	</td>
		                		</tr>
		                		
		                		
		                		<!--Begin added on 07/03/2023 totalAgeDonateAmt -->
		                		<tr>
								<td align="right" width="15%">
	                			</td>	                			
			                	<td align="right" colspan="2" width="53%">		
								<h:outputText value="#{jspMsg['label.totalAgeDonateAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="32%">
	                			 <h:inputText id="txtTotalAgeDonateAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeDonateAmt}" 
	       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	       						 onblur="SumTotalRentServiceAmtJS();return numberformat.moneyFormat(this);"
	       						 onfocus="return numberformat.setCursorPosToEnd(this);"
	       						 maxlength="16" 	       						
	       						 style="text-align:right;"
	       						 size="18"
	       						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent || (semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                			</h:inputText>
	                			<a4j:jsFunction name="SumTotalRentServiceAmtJS" reRender="txtTotalAgeRentServiceAmtTab3" 
	                			action="#{semmsi004tab3Action.calTotalAgeServiceAmt}"/>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                	</td>
		                		</tr>
		                		<!--End added on 07/03/2023 totalAgeDonateAmt -->
		                		
		                		<tr>
								<td align="right" width="15%">
	                			</td>
	                			<td width="33%">
			                	</td>
			                	<td align="right" width="20%">
								<h:outputText value="#{jspMsg['label.totalAgeRentServiceAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td width="32%">
	                			 <h:inputText id="txtTotalAgeRentServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeRentServiceAmt}" size="18" 
		   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		   						 onblur="return numberformat.moneyFormat(this);"
		   						 onfocus="return numberformat.setCursorPosToEnd(this);"
		   						 maxlength="16" 
		   						 style="text-align:right;"
		   						 disabled="true">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		              			</h:inputText>
		              			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                	</td>
		                		</tr>
		                		
		                		</h:panelGroup>
		                		<tr>
								<td align="right" width="15%">
	                			</td>
	                			<td width="33%">
			                	</td>
			                	<td align="right" width="20%">
								
	                			</td>
	                			<td width="32%">
	                			 	<h:outputText value="Fix" styleClass="ms7" />
				                	
				                	<rich:spacer width="5"></rich:spacer>
				                	
				                	<h:selectOneMenu id="ddFix5Percent_tab3" value="#{semmsi004tab3Bean.totalRent.fix5Percent}" styleClass="ms7" 
			              			disabled="#{(semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
				                		<f:selectItems value="#{semmsi004tab3Bean.fix5PercentList}"/>
				                	</h:selectOneMenu>
				                	
				                	<rich:spacer width="5"></rich:spacer>
				                	
				                	<h:outputText value="%" styleClass="ms7" />
				                	
				                	<a4j:jsFunction name="RenderFix5JS" reRender="pnlRent,pnlRentCond,pnlSumRent,pnlResultSearchRentCond,pnlGRentCondSpecial" 
					                	action="#{semmsi004tab3Action.doSetFix5Percent}"/>
			                	</td>
		                		</tr>
		                		
		                		
		                		
		                		<tr>
		                		<td colspan="4" align="left">
		                		 <a4j:commandButton id="btnSaveTotalRent" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="msi004tab3_pnlRentalPayNormal,pnlResultSearchRentCond,pnlMsi004tab3_totalRental,pnlRentalDeposit" 
					           		disabled="#{(semmsi004tab3Bean.rentEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
					           		rendered="#{!semmsi004tab3Bean.disabledRent}">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
									<a4j:actionparam name="methodWithNavi" value="doSaveTotalRent" />
					           		</a4j:commandButton>
		                		</td>
		                		</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
		           	
		           	<rich:spacer height="10"></rich:spacer>
		           	
		           	<h:panelGroup>
	                	<div>
	                		<h:selectBooleanCheckbox rendered="false"></h:selectBooleanCheckbox>
	                		<h:outputText value="#{jspMsg['label.th_changeRentalDepInfo']}" styleClass="ms7" rendered="false" />
	                	</div>
	                </h:panelGroup>
		           	
		           	<rich:spacer height="10"></rich:spacer>
		           	
		           	<h:panelGroup>
		           		<h:outputText value="#{jspMsg['label.th_changeRentalDepInfo']}" styleClass="ms7" 
		           		rendered="#{semmsi004Bean.reqTypeParam != '01'}"/>
						
							<h:selectOneRadio id="rbtMsi004tab3_changeRentalDeposit" value="#{semmsi004tab3Bean.rentDepositEditFlag}" styleClass="ms7" 
							rendered="#{semmsi004Bean.reqTypeParam != '01'}"
							disabled="" onclick="fnMsi004tab3_changeRentalDepositComfirm();">
	                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_notEdit']}" />
	                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_edit']}"/>
	                		</h:selectOneRadio>
	                		
	                		<a4j:jsFunction name="fnMsi004tab3_changeRentalDepositComfirm"
	                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
	                		action="#{semmsi004tab3Action.doSetParamConfirmNotChangeRentalDeposit}"
	                		 reRender="pnlRentalDeposit,
	                		 msi004PopUpCommon_commonConfirm"></a4j:jsFunction>
		           	</h:panelGroup>
		           	
		           	<rich:panel id="pnlRentalDeposit">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.rentalserviceDep']}" />
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgFormBottom}"/>
						</div>
					
						<h:panelGroup style="width:98%;" >
							
						 	
						 	<h:panelGroup id="pnlRentDepositParam" rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}" >
						 		<div style="width:100%; border:solid 0px;padding:5px;">
					 		<table style="width:100%; " >
								<tr>
									<td align="right" style="width:20%">
							       			<h:outputText value="* " style="font-style:bold; color:red;" />       
										    <h:outputText value="#{jspMsg['label.rentalDepType']} :" styleClass="ms7"></h:outputText>
							       		</td>
							       		<td align="left">
							       			<h:selectOneMenu id="depType" value="#{semmsi004tab3Bean.siteDepositNormal.depositType}" 
							       			style=" height : 19px;" onchange="renderDeptBgCash()"
							       			disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       				<f:selectItem itemLabel=" -- Select -- " itemValue=""/>
							       				<f:selectItem itemLabel=" BG " itemValue="01"/>
							       				<f:selectItem itemLabel=" Cash " itemValue="02"/>
							       			</h:selectOneMenu>
							       			
							       			<a4j:jsFunction name="renderDeptBgCash" action="#{semmsi004tab3Action.doRenderDeptBgCash}" reRender="msi004tab3_pnlRentDeposit"></a4j:jsFunction>
							       		</td>
							       		<td align="right" style="width:20%">
							       			 <h:outputText value="* " style="font-style:bold; color:red;" />      
										    <h:outputText value="#{jspMsg['column.header.rantalPayment']} :" styleClass="ms7"></h:outputText>
							       		</td>
							       		<td align="left">
							       			<h:selectOneMenu value="#{semmsi004tab3Bean.siteDepositNormal.expenseType}"
							       			disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       				<f:selectItems value="#{semmsi004tab3Bean.expenseTypeDepositRentList}"/>
							       			</h:selectOneMenu>
							       			
							       			<a4j:jsFunction name="doCalDepositAmt" action="#{semmsi004tab3Action.doCalDepositAmt}"
							       			reRender="msa002Tab3_cashDepositAmt,msa002Tab3_bgDepositAmt">
							       			
							       			</a4j:jsFunction>
							       		</td>
							       	</tr>
							   </table>
							   
					 		<h:panelGrid width="100%" id="msi004tab3_pnlRentDeposit">
					 			<h:panelGroup id="pnlDeptCash" rendered="#{semmsi004tab3Bean.renderedPnlDeptCash}">
					 				<div id="cash" style="width:100%; border:solid 1px fff;padding:5px;">
							 			
							 			<h:panelGroup id="msi004Tab3_pnlCashDepositOld" rendered="#{semmsi004Bean.reqTypeParam != '01' and
					 					semmsi004tab3Bean.siteDepositNormal.depositAmtOld > 0}">
					 						<div style="width:100%; border:solid 1px dddddd;padding:5px;">
							 					<table style="width:100%;">
													       				
													<tr>
														<td align="right" width="15%">
															<h:outputText value="#{jspMsg['label.th_old_insure_money']} :" styleClass="ms7"></h:outputText>
														</td>
														<td align="left">
															<h:inputText  value="#{semmsi004tab3Bean.siteDepositNormal.depositAmtOld}" maxlength="17" 
															onkeypress="return numberformat.keyPressDecimalOnly(this, event);" styleClass="inputRight"
															onblur="return numberformat.moneyFormat(this);"
															onfocus="return numberformat.setCursorPosToEnd(this);"
															disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" 
									   	 					readonly="true">
																<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
															</h:inputText>
															<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
														</td>
																       		<td align="left">
																       			<h:panelGrid columns="1">
											        								<h:panelGroup>
											        									<h:selectOneRadio id="msa002Tab3_rbtDeptReturnType01" value="#{semmsi004tab3Bean.deptReturnType01}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnType01();"
											        									disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
																					    	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.fullGetBackDep']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnType01" action="#{semmsi004tab3Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_txtDeptReturnType02,
																					    msa002Tab3_rbtDeptReturnType03,msa002tab3_depositReturnAmt">
																					    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="01"></a4j:actionparam>
																						</a4j:jsFunction>
											        								</h:panelGroup>
											        							</h:panelGrid>   
																       		</td>
																       		<td>
																       		
																       		</td>
													       				</tr>
													       				<tr>
													       					<td align="left">
													       			       
																			</td>
																       		<td align="left">
																       			
																       		</td>
																       		<td align="left">
																       			<h:panelGrid columns="3">
											        								<h:panelGroup>
											        									<h:selectOneRadio id="msa002Tab3_rbtDeptReturnType02" value="#{semmsi004tab3Bean.deptReturnType02}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnType02();"
											        									disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
																					    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.someGetBackDep']}"/>
																					    	
																					    </h:selectOneRadio>
																					    
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnType02" action="#{semmsi004tab3Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_txtDeptReturnType02,
																					    msa002Tab3_rbtDeptReturnType03,msa002tab3_depositReturnAmt">
																					    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="02"></a4j:actionparam>
																						</a4j:jsFunction>
																					 </h:panelGroup>
																					 <h:panelGroup>
																					    
																					    <h:inputText id="msa002Tab3_txtDeptReturnType02" value="#{semmsi004tab3Bean.siteDepositNormal.returnAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
																							styleClass="inputRight"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsi004tab3Bean.disabledDepositRent || semmsi004tab3Bean.deptReturnType02 != '02'
																							|| (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
																							onchange="doCalDepositReturnAmt()">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																					 
																					 	<a4j:jsFunction name="doCalDepositReturnAmt" action="#{semmsi004tab3Action.doCalDepositReturnAmt}"
																					 	 reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_txtDeptReturnType02,
																					    msa002Tab3_rbtDeptReturnType03,msa002tab3_depositReturnAmt">
																					 	
																					 	</a4j:jsFunction>
																					 </h:panelGroup>
																					 <h:panelGroup>
																		       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
											        								
											        								</h:panelGroup>
																       			</h:panelGrid>       
																			    
																       		</td>
																       		<td>
																       			<h:outputText value="#{jspMsg['label.balance']} : " styleClass="ms7"/>
																       			<h:inputText id="msa002tab3_depositReturnAmt" value="#{semmsi004tab3Bean.siteDepositNormal.depositReturnAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
																							styleClass="inputRight"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							readonly="true">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																       		</td>
													       				</tr>
													       				<tr>
													       					<td align="right">
													       			       
																       		</td>
																       		<td align="left">
																       		</td>
																       		<td align="left">
																       			<h:panelGrid columns="1">
											        								<h:panelGroup>       
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnType03" value="#{semmsi004tab3Bean.deptReturnType03}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnType03();"
											        									disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
																					    	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.noGetBack']}"/>
																					    </h:selectOneRadio>
																					    
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnType03" action="#{semmsi004tab3Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_txtDeptReturnType02,
																					    msa002Tab3_rbtDeptReturnType03,msa002tab3_depositReturnAmt" >
																					    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="03"></a4j:actionparam>
																						</a4j:jsFunction>
																					 </h:panelGroup>
																				</h:panelGrid>
																       		
																       		</td>
																       		<td>
																       		
																       		</td>
													       				</tr>
													       			</table>
							 				
							 				</div>
					 					</h:panelGroup>
							 			
							 			<table style="width:100%; border:solid 0px;">
													       				
											<tr>
													       					<td align="right">
													       			       
																			   	<h:outputText value="#{jspMsg['label.th_all_rentalDep']} : " styleClass="ms7"></h:outputText>
																       		</td>
																       		<td align="left">
																       			
																       			<h:inputText id="msa002Tab3_cashDepositAmt" value="#{semmsi004tab3Bean.siteDepositNormal.depositAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
																							styleClass="inputRight"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							readonly="true">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																    			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																       		</td>
																       		<td align="right">
													       			       
																			   	<h:outputText value="#{jspMsg['label.th_new_insure']} :" styleClass="ms7"></h:outputText>
																       		</td>
																       		<td align="left">
																       			<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
																       				<h:panelGroup>
																       					<h:inputText value="#{semmsi004tab3Bean.siteDepositNormal.depositAmtNew}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
																							styleClass="inputRight"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
																							onchange="doCalDepositAmt();">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																    			
																    					<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																    					
																       				</h:panelGroup>
																       			
																       				
																       				<rich:spacer width="20"></rich:spacer>
																       				
																       				<h:panelGroup>
																       					
																       				</h:panelGroup>
																       				
																       				<h:panelGroup>
																       				
																       				</h:panelGroup>
																       			</h:panelGrid>
																       			
																    			
																       		</td>
																       	</tr>
																    </table>
					 				</div>
					 			</h:panelGroup>
					 		
					 			<h:panelGroup id="pnlDeptBg" rendered="#{semmsi004tab3Bean.renderedPnlDeptBg}">
					 				<div id="BG" style="width:100%; border:solid 1px ffffff;padding:5px;" >
							 			
							 			<h:panelGroup id="msi004Tab3_pnlBgDepositOld" rendered="#{semmsi004Bean.reqTypeParam != '01' and
					 					semmsi004tab3Bean.siteDepositNormal.depositAmtOld > 0}">
					 						<div style="width:100%; border:solid 1px dddddd;padding:5px;">
							 					<table style="width:100%;">
													       				
													<tr>
														<td align="right" width="10%">
															<h:outputText value="#{jspMsg['label.oldBG']} :" styleClass="ms7"></h:outputText>
														</td>
														<td align="left">
															<h:inputText value="#{semmsi004tab3Bean.siteDepositNormal.depositAmtOld}" maxlength="17" 
															onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
															styleClass="inputRight"
						              						onblur="return numberformat.moneyFormat(this);"
						              						onfocus="return numberformat.setCursorPosToEnd(this);"
															readonly="true">
																<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
															</h:inputText>
															
															<h:outputText value=" #{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
														</td>
																       		<td align="left">
																       			<h:panelGrid columns="1">
											        								<h:panelGroup>
											        									
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnTypeBG01" value="#{semmsi004tab3Bean.deptReturnType01}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnTypeBG01()"
											        									disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
																					    	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.alreadyget']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnTypeBG01" action="#{semmsi004tab3Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnTypeBG01,msa002Tab3_rbtDeptReturnTypeBG02,msa002Tab3_txtDeptReturnTypeBG02,
																					    msa002Tab3_rbtDeptReturnTypeBG03">
																					    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="01"></a4j:actionparam>
																						</a4j:jsFunction>
											        								</h:panelGroup>
											        							</h:panelGrid>   
																       		</td>
																       		<td>
																       		
																       		</td>
													       				</tr>
													       				<tr>
													       					<td align="left">
													       			       
																			</td>
																       		<td align="left">
																       			
																       		</td>
																       		<td align="left">
																       			<h:panelGrid columns="3">
											        								<h:panelGroup>
											        									
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnTypeBG02" value="#{semmsi004tab3Bean.deptReturnType02}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnTypeBG02()"
											        									disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
																					    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.noBG']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnTypeBG02" action="#{semmsi004tab3Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnTypeBG01,msa002Tab3_rbtDeptReturnTypeBG02,msa002Tab3_txtDeptReturnTypeBG02,
																					    msa002Tab3_rbtDeptReturnTypeBG03">
																					    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="02"></a4j:actionparam>
																						</a4j:jsFunction>
																					 </h:panelGroup>
																					 <h:panelGroup>
																					    <h:inputText id="msa002Tab3_txtDeptReturnTypeBG02" value="#{semmsi004tab3Bean.siteDepositNormal.returnAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
																							styleClass="inputRight"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsi004tab3Bean.disabledDepositRent || semmsi004tab3Bean.deptReturnType02 != '02' 
																							|| (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																					 </h:panelGroup>
																					 <h:panelGroup>
																		       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
											        								
											        								</h:panelGroup>
																       			</h:panelGrid>       
																			    
																       		</td>
																       		<td >
																       			
																       		</td>
													       				</tr>
													       				<tr>
													       					<td align="right">
													       			       
																       		</td>
																       		<td align="left">
																       		</td>
																       		<td align="left">
																       			<h:panelGrid columns="1">
											        								<h:panelGroup>       
																					    
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnTypeBG03" value="#{semmsi004tab3Bean.deptReturnType03}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnTypeBG03()"
											        									disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
																					    	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payWhencancelContract']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnTypeBG03" action="#{semmsi004tab3Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnTypeBG01,msa002Tab3_rbtDeptReturnTypeBG02,msa002Tab3_txtDeptReturnTypeBG02,
																					    msa002Tab3_rbtDeptReturnTypeBG03">
																					    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="03"></a4j:actionparam>
																						</a4j:jsFunction>
																					 </h:panelGroup>
																				</h:panelGrid>
																       		
																       		</td>
																       		<td>
																       		
																       		</td>
													       				</tr>
													       			</table>
							 				
							 				</div>
					 					</h:panelGroup>
							 			
							 				<table style="width:100%; border:solid 0px;">
													       				
											<tr>
																       		<td align="right" colspan="3" width="70%">
													       			       
																			   	<h:outputText value="#{jspMsg['label.newBG']} :" styleClass="ms7"></h:outputText>
																       		</td>
																       		<td align="left">
																       			<h:panelGrid columns="5">
																       				<h:panelGroup>
																       					<h:inputText  value="#{semmsi004tab3Bean.siteDepositNormal.depositAmtNew}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
																							styleClass="inputRight"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
																							onchange="doCalDepositAmt();">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																       				</h:panelGroup>
																       				
																       				<h:panelGroup>
																       					<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																       				</h:panelGroup>
																       				
																       				<rich:spacer width="20"></rich:spacer>
																       				
																       				<h:panelGroup>
																       					
																       				</h:panelGroup>
																       				
																       				<h:panelGroup>
																       				
																       				</h:panelGroup>
																       			</h:panelGrid>
																       			
																    			
																       		</td>
																       	</tr>
																       	<tr>
													       					<td align="right">
													       			       
																			</td>
																       		<td align="left">
																       			
																       		</td>
																       		<td align="right">
													       			       
																       		</td>
																       		<td align="left">
																       			
																       		</td>
												</tr>
											</table>
					 					</div>
					 			</h:panelGroup>
					 			
					 		</h:panelGrid>
					 		
					 		<table width="100%">
					 			<tr>
					 				<td align="right" width="15%">
					 					<h:outputText value="VAT :" rendered="false"></h:outputText>
					 				</td>
					 				<td align="left">
					 					<h:selectOneRadio id="msa002tab3_rnsdepVatType" value="" 
													style="" styleClass="ms7" rendered="false">
						                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
						                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
						                				<f:selectItem itemValue="" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
						                			</h:selectOneRadio>
					 				</td>
					 			</tr>
					 			
					 			<tr>
					 				<td align="right">
					 				 	<h:outputText value="VAT :" styleClass="ms7"></h:outputText>
					 				</td>
					 				<td align="left">
					 					<h:selectOneRadio id="msa002tab3_rntDeptVatType" value="#{semmsi004tab3Bean.siteDepositNormal.vatType}" 
													style="" styleClass="ms7" disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
						                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
						                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
						                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
						                			</h:selectOneRadio>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td align="right">
					 				 	<h:outputText value="Service :" styleClass="ms7"></h:outputText>
					 				</td>
					 				<td align="left">
					 					<h:selectOneMenu value="#{semmsi004tab3Bean.siteDepositNormal.serviceId}" styleClass="ms7"
					 					disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
					 						<f:selectItems value="#{semmsi004tab1Bean.servTypeList}"/>
					 					</h:selectOneMenu>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td align="right" valign="top">
					 				 	<h:outputText value="#{jspMsg['label.th_remark']} :" styleClass="ms7"> </h:outputText>
					 				</td>
					 				<td align="left">
					 					<h:inputTextarea rows="5" style="width:80%;" value="#{semmsi004tab3Bean.siteDepositNormal.remark}"
					 					disabled="#{semmsi004tab3Bean.disabledDepositRent || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:inputTextarea>
					 				</td>
					 			</tr>
					 		</table>
					 	</div>
						 	
						 	<div style="width:100%; padding-left:50px;margin:10px;">
						 		<a4j:commandButton id="btnAddDepositNormal" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlRentDeposit,pnlDeposit,pnlAddDeposit,tableRentDepositCondition,dtbDepositRentBG,dtbDepositRentCash,pnlRentalDeposit"  
				           		disabled="#{semmsi004tab3Bean.disabledBtnAddDepositNormal || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si"/>
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doAddDepositNormal" />
								<a4j:actionparam name="depositeCondType" value="01" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
				           		<a4j:commandButton id="btnUpdateDepositDepositNormal" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlRentDeposit,pnlDeposit,pnlAddDeposit,tableRentDepositCondition,dtbDepositRentBG,dtbDepositRentCash,pnlRentalDeposit" 
				           		disabled="#{semmsi004tab3Bean.disabledBtnUpdateDepositNormal || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateDepositNormal" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
			                	 <a4j:commandButton id="btnClearDepositRentNormal" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlDeposit,pnlAddDeposit,tableRentDepositCondition,pnlRentDeposit,dtbDepositRentBG,dtbDepositRentCash,pnlRentalDeposit"
				           		disabled="#{semmsi004tab3Bean.disabledDepositRent || semmsi004Bean.disabledModeView || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" >
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doClearDepositNormal" />
				           		</a4j:commandButton>
						 	</div>
						 	</h:panelGroup>
						 	
						 	
						 	
						 	<h:panelGrid id="pnlDeposit"  width="95%">
								<h:panelGroup rendered="#{semmsi004tab3Bean.renderDataTableDeposit}">
								<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}">
								<rich:panel id="pnlResultBG" styleClass="sem_autoScrollbarInSI">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['header.panel.BG']}" style="width:2000px;"/>
									</f:facet>
										<rich:dataTable width="97%" id="dtbDepositRentBG"  cellpadding="1" cellspacing="0" border="0"
										var="depositRentBgSP" value="#{semmsi004tab3Bean.depositRentBgSPList}" reRender="dtbDepositRentBG" 
										rows="#{semmsi004tab3Bean.rowPerPage}"  rowClasses="cur" 	styleClass="dataTable">
										<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbDepositRentBG">
											<a4j:actionparam name="rowId" value="#{depositRentBgSP.rowId}" />
										</a4j:support>
										<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}"
										rendered="#{semmsi004Bean.renderedModeView}">
											<f:facet name="header" >
												<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
											</f:facet>
											<div align="center">
				            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlRentDeposit,pnlRentalDeposit"
				            					image="images/edit.png" style="height: 15; width: 15"
				            					disabled="#{(semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
				            					rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentBgSP.editableFlag == 'Y'}">
													<a4j:actionparam name="navModule" value="si" />
					            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
													<a4j:actionparam name="methodWithNavi" value="initUpdateDepositNormal" />
													<a4j:actionparam name="rowId" value="#{depositRentBgSP.rowId}" />
				            					</a4j:commandButton>          							
											</div>
										</rich:column>
										<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}"
										rendered="#{semmsi004Bean.renderedModeView}">
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
											</f:facet>
											<div align="center">
				            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDepositRentBgDialog')}.show(); return false" 
			     									   action="#{navAction.navi}" image="images/delete.png" style="width: 15; height : 15px;"
			     									   reRender="pnlRentalDeposit"
			     									   disabled="#{(semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
			     									   rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentBgSP.deleteableFlag == 'Y'}">
													<a4j:actionparam name="navModule" value="si" />
					            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
													<a4j:actionparam name="methodWithNavi" value="initDeleteDepositNormal" />
													<a4j:actionparam name="rowId" value="#{depositRentBgSP.rowId}" />
				            					</a4j:commandButton>          							
											</div>
										</rich:column>
										
										<rich:column sortBy="#{depositRentBgSP.effectiveDt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.effectiveDtStr}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.expireDt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.expireDtStr}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.expenseTypeName}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 50"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.expenseTypeName}"  />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.depositAmt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.depositAmt}" >
			                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                                    </h:outputText>
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.depositReturnType}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.depositReturnTypeName}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.depositStatus}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.depositStatus}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.vatTypeName}">
			                                <f:facet name="header">
			                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.vatTypeName}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.remark}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.remark}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.serviceId}">
			                                <f:facet name="header">
			                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.serviceName}" />
			                                </div>
			                      		</rich:column>
			                      		
			                      		<rich:column sortBy="#{depositRentBgSP.bgNo}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.BGNo']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.bgNo}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.bgBang}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.bank']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.bgBang}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.bgAmt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.BGamt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.bgAmt}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.bgEffectiveDt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.BGstartDate']}" styleClass="contentform" style="width: 80"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.bgEffectiveDtStr}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentBgSP.bgExpireDt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.BGendDate']}" styleClass="contentform" style="width: 80"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentBgSP.bgExpireDtStr}" />
			                                </div>
			                      		</rich:column>
										<rich:column sortBy="#{depositRentBgSP.newStatusName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['header.column.status']}" styleClass="contentform" style="width:50;"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{depositRentBgSP.newStatusName}" styleClass="contentform"  />
											</div>
										</rich:column>
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="4">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmsi004tab3Bean.depositRentBgSPList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<rich:column colspan="13">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositRentBG"
														maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dstDepositRentBG" 
														style="background-color: #cccccc;"
														page="#{semmsi004tab3Bean.scrollerPage}" 
													/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>
								</rich:panel>
							
								<rich:spacer height="20"></rich:spacer>
								<!-- panel Cash -->
								<rich:panel id="pnlResultCash" styleClass="sem_autoScrollbarInSI">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['header.panel.Cash']}" style="width:1300px;"/>
									</f:facet>
										<rich:dataTable width="97%" id="dtbDepositRentCash"  cellpadding="1" cellspacing="0" border="0"
										var="depositRentCashSP" value="#{semmsi004tab3Bean.depositRentCashSPList}" reRender="dtbDepositRentCash" 
										rows="#{semmsi004tab3Bean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
										<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbDepositRentCash">
											<a4j:actionparam name="rowId" value="#{depositRentCashSP.rowId}" />
										</a4j:support>
										<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}"
										rendered="#{semmsi004Bean.renderedModeView}">
											<f:facet name="header" >
												<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
											</f:facet>
											<div align="center">
				            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlRentDeposit,pnlRentalDeposit"
				            					image="images/edit.png" style="height: 15; width: 15"
				            					disabled="#{(semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
				            					rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentCashSP.editableFlag == 'Y'}">
													<a4j:actionparam name="navModule" value="si" />
					            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
													<a4j:actionparam name="methodWithNavi" value="initUpdateDepositNormal" />
													<a4j:actionparam name="rowId" value="#{depositRentCashSP.rowId}" />
				            					</a4j:commandButton>          							
											</div>
										</rich:column>
										<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}"
										rendered="#{semmsi004Bean.renderedModeView}">
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
											</f:facet>
											<div align="center">
				            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDepositRentCashDialog')}.show(); return false" 
			     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
			     									   disabled="#{(semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
			     									   rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentCashSP.deleteableFlag == 'Y'}">
													<a4j:actionparam name="navModule" value="si" />
					            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
													<a4j:actionparam name="methodWithNavi" value="initDeleteDepositNormal" />
													<a4j:actionparam name="rowId" value="#{depositRentCashSP.rowId}" />
				            					</a4j:commandButton>          							
											</div>
										</rich:column>
										
										
										<rich:column sortBy="#{depositRentCashSP.effectiveDt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform"  value="#{depositRentCashSP.effectiveDtStr}"/>
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.expireDt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.expireDtStr}"/>
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.expenseTypeName}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 50"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.expenseTypeName}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.depositAmt}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.depositAmt}">
			                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                                    </h:outputText>
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.depositReturnType}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.depositReturnTypeName}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.depositStatus}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.depositStatus}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.vatTypeName}">
			                                <f:facet name="header">
			                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.vatTypeName}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.remark}">
			                                <f:facet name="header">
			                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.remark}" />
			                                </div>
			                      		</rich:column>
			                      		<rich:column sortBy="#{depositRentCashSP.serviceName}">
			                                <f:facet name="header">
			                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText styleClass="contentform" value="#{depositRentCashSP.serviceName}" />
			                                </div>
			                      		</rich:column>
										<rich:column sortBy="#{depositRentCashSP.newStatusName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['header.column.status']}" styleClass="contentform" style="width:50;"/>
											</f:facet>
											<div align="center">
												<h:outputText value="#{depositRentCashSP.newStatusName}" styleClass="contentform"  />
											</div>
										</rich:column>
										<f:facet name="footer">
											<rich:columnGroup>
												<rich:column colspan="4">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmsi004tab3Bean.depositRentCashSPList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<rich:column colspan="8">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositRentCash"
														maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dstDepositRentCash" 
														style="background-color: #cccccc;"
														page="#{semmsi004tab3Bean.scrollerPage}" 
													/>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
									</rich:dataTable>
							</rich:panel>
							</h:panelGroup>
							</h:panelGroup>
							
								 
							
							<rich:spacer height="10"></rich:spacer>
							<rich:panel>
							<h:panelGrid id="pnlTotalDepositRent" width="95%" border="0" cellpadding="0" cellspacing="1">
							<div align="left">
										<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgSumDeposit}"/>
							</div>
							<h:panelGroup>
								<table width="100%">
								<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}">
			               		<tr>
								<td align="right" width="15%">
								<h:graphicImage id="imgRequireTotalDepositBgAmt" value="images/icon_required.gif" 
								style="#{(not(semmsi004tab3Bean.siteDepositSpecialBg.detail eq '') and semmsi004tab3Bean.siteDepositNormal.depositCondType eq '02') ? '':'display:none;'}"/>
								<rich:spacer width="2"></rich:spacer>
								<h:outputText value="#{jspMsg['label.depositBgAmt']}" styleClass="ms7"/>
			              			</td>
			              			<td width="33%">
			           			  	<h:inputText id="txtDepositBgAmtTab3" value="#{semmsi004tab3Bean.totalDeposit.totalDepositBgAmt}" size="18" 
			   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			   						 onblur="return numberformat.moneyFormat(this);"
			   						 onfocus="return numberformat.setCursorPosToEnd(this);"
			   						 maxlength="16" 
			   						 styleClass="inputRight"
			   						 disabled="#{semmsi004tab3Bean.disabledTotalDepositBG || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			              			</h:inputText>
			              			 <rich:spacer width="5"></rich:spacer>
			              			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                	</td>
			                	<td align="right" width="20%">
									<h:graphicImage id="imgRequireTotalDepositCashAmt" value="images/icon_required.gif" 
									style="#{(not(semmsi004tab3Bean.siteDepositSpecialCash.detail eq '') and semmsi004tab3Bean.siteDepositNormal.depositCondType eq '02') ? '':'display:none;'}"/>
									<rich:spacer width="2"></rich:spacer>
								<h:outputText value="#{jspMsg['label.depositCashAmt']}" styleClass="ms7"/>
			              			</td>
			              			<td width="32%">
			              			<h:inputText id="txtDepositCashAmtTab3" value="#{semmsi004tab3Bean.totalDeposit.totalDepositCashAmt}" size="18" 
			   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			   						 onblur="return numberformat.moneyFormat(this);"
			   						 onfocus="return numberformat.setCursorPosToEnd(this);"
			   						 maxlength="16" 
			   						 styleClass="inputRight"
			   						 disabled="#{semmsi004tab3Bean.disabledTotalDepositCash || (semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			              			</h:inputText>
			              			<rich:spacer width="5"></rich:spacer>
			              			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                	</td>
			               		</tr>
			               		</h:panelGroup>
			               		<tr>
				               		<td align="right" width="15%">
				             		</td>
				             		<td width="85%" colspan="3">
					             		<h:selectBooleanCheckbox id="chkNoRentDeposit" value="#{semmsi004tab3Bean.chkNoRentDeposit}" styleClass="ms7"
					             		disabled="#{(semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
										onclick="RenderNoRentDepositJS();"/>
					                	<h:outputText value="#{jspMsg['label.noDeposit']}" styleClass="ms7" />
					                	<a4j:jsFunction name="RenderNoRentDepositJS" reRender="pnlAddDeposit, pnlDeposit, pnlTotalDepositRent, pnlRentDepositParam, pnlRentalDeposit" 
								        action="#{semmsi004tab3Action.renderedNoRentDeposit}"/>
				              		</td>
			               		</tr>
			               		<tr>
			               		<td colspan="4" align="left">
			             		<a4j:commandButton id="btnSaveTotalDeposit" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlTotalDepositRent,pnlAddDeposit,pnlRentDeposit,pnlSumRent,pnlRentCond" 
				           		disabled="#{(semmsi004tab3Bean.rentDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
				           		rendered="#{!semmsi004tab3Bean.disabledDepositRent}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doSaveTotalDeposit" />
				           		</a4j:commandButton>
			               		</td>
			               		</tr>
								</table>
								</h:panelGroup>
								</h:panelGrid>
								</rich:panel>
							</h:panelGrid>
							
							
						</h:panelGroup>
					</rich:panel>
					
				</h:panelGrid>
					
		</a4j:region>
		</h:panelGrid>
