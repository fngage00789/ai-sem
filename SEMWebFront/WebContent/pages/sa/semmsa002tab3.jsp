<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />
	
	<h:inputHidden value="#{semmsa002Bean.siteAppObjParam.reqType}" id="reqType_hidden" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab3" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_info']}#{jspMsg['label.th_cost_rental']}#{jspMsg['label.th_and']}#{jspMsg['label.th_cost_service']}" />
			</f:facet>
			<!-- << header content -->
			
				<!-- >> group 0 -->
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px; text-align:right;">
						<tr>
							<td style="background-color:ececec; border:solid dcdcdc 1px;">
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab3_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_rental']}"
								action="#{semmsa002Action.doShowPopupHistory}" reRender="oppContent,popupDisplay3"
								oncomplete="#{rich:component('tab3_panel_popupModalRetStatus')}.show(); return false;">
								<f:param name="tabNo" value="3"/>
								</a4j:commandButton>
								<a4j:include id="popUpTab3"  viewId="../../pages/sa/semmsa002PopUpTab3.jsp" />
							</td>
						</tr>
					</table>
				</h:panelGroup>
				<!-- << group 0 -->

				<rich:spacer height="10"></rich:spacer>
	
				<!-- >> group 1 -->
				<h:panelGrid id="msgTopTab3">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgFormChkExpire}">
                        
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
				</h:panelGrid>
				
				
				<rich:panel rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
				<h:panelGroup style="width:100%;"> 
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractNo}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.contract_status']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractStatus}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.pnextcont']} : " styleClass="ms7" ></h:outputText>
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.pNextContract}"></h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_firstStartContractDate']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar  locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.firstEffDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.effDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.expireDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
                            	<rich:spacer width="20"></rich:spacer>
                            	<h:selectBooleanCheckbox label="#{jspMsg['label.th_contractNeverExpireDt']}" 
								value="#{semmsa002Bean.noExpFlag}" disabled="true"></h:selectBooleanCheckbox>
								<h:outputText value="#{jspMsg['label.th_contractNeverExpireDt']}" styleClass="ms7" />
							</td>
							
						</tr>
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.locationId']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.locationId}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['column.header.locationName']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText style="width:300px;" disabled="true" value="#{semmsa002Bean.siteContInfo.locationThName}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['lable.th_locationstatus']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.status}"></h:inputText>
							</td>
						</tr>
					</table>
				</h:panelGroup>				
				</rich:panel>
				<!-- >> group 1 -->
				
				<rich:spacer height="10"></rich:spacer>
				
				<!-- >> group 2 -->
				<rich:panel>
				<h:panelGroup style="width:100%;"> 
				
					<table width="100%">
						<tr>
							<td align="center">
								<div id="msa002tab3Service" style="width:600px; overflow:scroll; border:1px solid e0e0e0;padding:0px;margin:0 auto;"> 
						
								<rich:dataTable align="center" style="width:100%;" id="dataService1tab3" cellpadding="1" cellspacing="0" border="0" 
								var="appServObj"  value="#{semmsa002Bean.siteAppServList}" reRender="dataService1tab3" 
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
					                                    <h:outputText value="#{appServObj.dataObj.servName}" />
					                                </rich:column>
								                    <rich:column>
								                        <h:outputText value="#{appServObj.dataObj.action}" />
								                    </rich:column>
								                    <rich:column style="text-align:center">
								                        <h:outputText value="#{appServObj.dataObj.seq}" />
								                    </rich:column>
										            <!-- data -->
										            
										            <!-- footer -->
													<f:facet name="footer">
														<rich:columnGroup>
															<!-- > 1 -->
															<rich:column colspan="1">
						                                        <h:outputFormat value="#{msg['message.totalRecords']}">
						                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppServList)}"></f:param>
						                                        </h:outputFormat>
						                                    </rich:column>
															<!-- > 2 -->
															<rich:column colspan="2">
																	<rich:datascroller immediate="true" rendered="true" align="left" for="dataService1tab3"
																		maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																		stepControls="hide" fastControls="auto" boundaryControls="auto" 
																		id="scrllDataService1tab3" style="background-color: #cccccc;"
																		page="#{semmsa002Bean.scrollerPage}">
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
				</rich:panel>
				<!-- >> group 2 -->
				
				<rich:spacer height="10"></rich:spacer>
				
                <rich:spacer height="10"></rich:spacer>
        		<!-- >> group 3 -->        
                <rich:panel id="pnlMsa002Tab3_rentContExisting">
				
		
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_rentalServOtherinfo']} (Existing)" style="width: 100%;"/>
					</f:facet>
				
					<h:panelGroup style="width:1200px; overflow:scroll; border:1px solid e0e0e0;">
					
						<rich:dataTable width="100%" id="dtbSiteInfo" cellpadding="1" cellspacing="0" border="0"
                        var="siteAcqSP" value="#{semmsa002Bean.siteAppRentContExisting}" reRender="dtbSiteInfo" 
                        rows="#{semmsa003Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            
                            <rich:column rendered="false">
	                            <f:facet name="header">
	                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton id="btnEdit"  action="#{navAction.navi}" image="images/edit.png" style="height: 15; width : 15px;"
		                            reRender="oppContent">
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doEditRentalExisting" />
		                                <a4j:actionparam name="siteAppRentContId" value="#{siteAcqSP.dataObj.siteAppRentContId}" />
		                                <a4j:actionparam name="siteAppRentContMode" value="H" />
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
	                        
	                        <rich:column rendered="false">
	                            <f:facet name="header">
	                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
		                            reRender="oppContent" rendered="#{siteAcqSP.dataObj.rowId != null}"
		                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
		                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppRentCont" />
		                                <a4j:actionparam name="siteAppRentContId" value="#{siteAcqSP.dataObj.siteAppRentContId}" />
										<a4j:actionparam name="siteAppId" value="#{siteAcqSP.dataObj.siteAppId}" />
										<a4j:actionparam name="expenseType" value="#{siteAcqSP.dataObj.expenseType}" />
										<a4j:actionparam name="serviceId" value="#{siteAcqSP.dataObj.serviceId}" />
										<a4j:actionparam name="siteAppRentContMode" value="H" />
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
                            
                            <rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.periodStartDtStr}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.periodEndDtStr}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.effectiveDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.startDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.endDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expenseName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.expenseDesc']}" styleClass="contentform" style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expenseDesc}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Detail" styleClass="contentform" style="width: 600"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentDetail}" />
                                </div>
                      		</rich:column>
                      		
                      		<rich:column sortBy="#{siteAcqSP.dataObj.rentAmtOld}" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentOldAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{siteAcqSP.dataObj.rentAmtOld}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteAcqSP.dataObj.rentAmtAddPerc}" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAddPercent']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{siteAcqSP.dataObj.rentAmtAddPerc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteAcqSP.dataObj.rentAmtAdd}" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAddAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{siteAcqSP.dataObj.rentAmtAdd}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
                      		
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentAmt}" >
                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentPeriodName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="W/T" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentWhtName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentVatName}" />
                                </div>
                      		</rich:column>
                      		<rich:column rendered="false">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.paymentCond']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentPaymentPeriodName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.rentalChange']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentAdjName}" />
                                    <h:outputText styleClass="contentform" value="%" rendered="#{siteAcqSP.dataObj.rentAdj != ''}"/>
                                    <h:outputText styleClass="contentform" value=" #{siteAcqSP.dataObj.rentAdjPeriodName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.serviceName}" />
                                </div>
                      		</rich:column>
                      		
                      		<f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppRentContExisting)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="15">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
                                            maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsa001Bean.scrollerPage}" />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            
                   		</rich:dataTable>
					
					</h:panelGroup>
				</rich:panel>
				
				<rich:spacer height="10"></rich:spacer>
				
				<h:panelGrid id="msgMidTab3">
					<rich:messages id="msgPnlTab3_mid" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgFormChkExpire}">
                        
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
				</h:panelGrid>
				
				<h:panelGroup>
                	<div>
                		<h:selectBooleanCheckbox id="chkRentalPayOneCond" value="#{semmsa002Bean.chkRentalPayOneCond}" 
						disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.disabledModeEditFromLG}" 
						onclick="msa002tab3_chkRantelOneCond();" rendered="false"/>
							<a4j:jsFunction name="msa002tab3_chkRantelOneCond" reRender="" 
			                action="#{semmsa002Action.msa002_chkRentalPayConditions}" >
						<a4j:actionparam name="paramRantalType" value="O" />
						</a4j:jsFunction>
						
						<a4j:commandButton id="msa002tab3_BtnUndoRental" value="#{jspMsg['label.th_undo']}#{jspMsg['label.th_changeRentalInfo']}" 
						disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab3_changeRentalComfirm();"
						styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:210px;">
						</a4j:commandButton>
						
                		<a4j:jsFunction name="fnMsa002tab3_changeRentalComfirm"
                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
                		action="#{semmsa002Action.doSetParamConfirmNotChangeRental}"
                		reRender="pnlMsa002Tab3_rentCont, panelTab3, 
                		msa002tab3_btnSaveRental, msa002tab3_btnSaveRental,msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
                		
                		<a4j:jsFunction name="fnMsa002tab3_changeRental" reRender="pnlMsa002Tab3_rentCont, panelTab3, 
                		msa002tab3_btnSaveRental, msa002tab3_btnSaveRental"></a4j:jsFunction>
                	</div>
                </h:panelGroup>
                 
                
				<!-- >> group 4 -->
				<rich:spacer height="10"></rich:spacer>
				
				<rich:panel id="pnlRental">
				
				<f:facet name="header">
					<h:outputText value="#{jspMsg['label.th_rentalServOtherCond']}"/>
				</f:facet>
				
				<h:panelGroup style="width:100%;" >
					<!-- table column: 50:50 -->
					
					<table style="width:100%; border:solid 0px;" >
					   <tr>
					       <td colspan="2">
					       		<table style="width:100%; border:solid 0px;" >
					       			<tr>
					       				<td style="width:43%;">
								           <h:selectBooleanCheckbox id="msa002tab3_chkRentalNoExpenses" value="#{semmsa002Bean.chkRentalNoExpenses}" 
								           disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.disabledModeEditFromLG
								           }" onclick="msa002tab3_chkRantelNoExpenses();"/>
								           
								           <a4j:jsFunction name="msa002tab3_chkRantelNoExpenses" reRender="pnlRental" 
			                                    action="#{semmsa002Action.chkRantelNoExpenses}">
			                                        <a4j:actionparam name="paramRantalType" value="00" />
			                              	</a4j:jsFunction>
								         
								        	<h:outputText value="#{jspMsg['label.noExpenses']}" styleClass="ms7"></h:outputText>
								        	
								        	<a4j:jsFunction name="msa002tab3_subCalAmt" reRender="msa002tab3_rentAmtOld, 
		                                    msa002tab3_rentPeriodTypeOld, msa002tab3_rentAmtAdd, msa002tab3_rentAmtAddPerc, msa002tab3_rentAmt,
		                                    panelTab3_totalRent,msa002tab3_rentServAmtAdd, msa002tab3_rentServAmtAddPerc" 
							                action="#{semmsa002Action.doCalAmt}">
							                    <a4j:actionparam name="paramCalDtm" value="tab2" />
							                </a4j:jsFunction>
					       				</td>
					       				<td align="left">
					       					
					       						<a4j:commandButton styleClass="rich-button" id="msa002tab3_popHistRental" 
							       				value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_rental']}"
												action="#{semmsa002Action.doShowPopupRentalHistory}" reRender="oppContent,tab3_panel_popupHistoryRental"
												disabled="#{semmsa002Bean.chkRentalPayOneCond == false || 
												semmsa002Bean.disabledModeViewOnly || semmsa002Bean.disabledModeEditFromLG
												 || semmsa002Bean.chkRentalNoExpenses}"
												 rendered="false"
												oncomplete="#{rich:component('tab3_panel_popupHistoryRental')}.show(); return false;">
												<f:param name="tabNo" value="3"/>
												</a4j:commandButton>
					       					
						       				
					       				</td>
					       			</tr>
					       		</table>
					           
					       </td>
					   	</tr>
					   	<tr>
					   		<td colspan="2">
					   			<table style="width:100%; border:solid 1px;" border="0">
					       			<tr>
					       				<td style="text-align:right;width:15%;" valign="top">
					       					<h:outputText value="* " style="font-style:bold; color:red;" />
					       					<h:outputText value="#{jspMsg['label.exp']} :" styleClass="ms7"></h:outputText>
					       				</td>
					       				<td style="text-align:left;width:10%;" valign="top">
					       					<h:selectOneMenu value="#{semmsa002Bean.siteAppRentObjParam.expenseType}" 
					       					onchange="setDefaultVAT();"
					       					 disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses }">
					       						<f:selectItems value="#{semmsa002Bean.expenseTypeRentList}"/>
					       					</h:selectOneMenu>
					       				</td>
					       				<a4j:jsFunction name="setDefaultVAT" action="#{semmsa002Action.doSetDefaultRental}"
					       				reRender="msa002tab3_rntWHT,msa002tab3_rntVatType,msa002tab3_expenseDesc"></a4j:jsFunction>
					       				
					       				<td style="text-align:right;" valign="top">
					       			    	<h:outputText value="* " style="font-style:bold; color:red;" />
					       					<h:outputText value=" #{jspMsg['label.th_expense_desc']} :" style="margin:0 0 0 0;" styleClass="ms7" />
					       				</td>
					       				
					       				<td style="text-align:left;" valign="top" colspan="3">
					       					<h:inputTextarea id="msa002tab3_expenseDesc" style="width:100%;" rows="2" 
					       					value="#{semmsa002Bean.siteAppRentObjParam.expenseDesc}" 
					       					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses ||semmsa002Bean.disabledExpenseDesc }">
					       					
					       					</h:inputTextarea>
					       				</td>	
					       				
					       				
					       			</tr>
					       			
					       			<rich:page rendered="#{semmsa002Bean.siteAppObjParam.reqType == '02' || semmsa002Bean.siteAppObjParam.reqType == '03'}">
					       				<tr>
					       					
							       				<td style="text-align:right;width:15%;" valign="top">
							       					<h:outputText value="#{jspMsg['label.th_cost_rental']}#{jspMsg['label.th_old_2']} : " styleClass="ms7" />
							       				</td>
							       				<td style="text-align:left;" valign="top">
							       					
							       					<h:inputText value="#{semmsa002Bean.siteAppRentObjParam.rentAmtOld}" id="msa002tab3_rentAmtOld" 
													maxlength="15" onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				              						onblur="msa002tab3_calAmt();return numberformat.moneyFormat(this);"
				              						onfocus="return numberformat.setCursorPosToEnd(this);" 
													disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}" 
													style="text-align:right;" styleClass="ms7">
														<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
													</h:inputText>
													<h:outputText value="#{jspMsg['label.th_unit_baht']}" styleClass="ms7"/>
							       				</td>
						       					<td style="text-align:right;width:15%;" valign="top">
							       					<h:outputText value=" #{jspMsg['label.th_per']} " style="margin:0 0 0 0;" styleClass="ms7" />
							       				</td>
							       				<td style="text-align:left;" valign="top" colspan="3">
							       					<h:selectOneMenu id="msa002tab3_rentPeriodTypeOld" value="#{semmsa002Bean.siteAppRentObjParam.rentPeriodTypeOld}" 
													disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}"
													styleClass="ms7" >
														<f:selectItems value="#{semmsa002Bean.promiseRenewPeriodTypeList}"/>
													</h:selectOneMenu>
							       				</td>
						       			</tr>
					       				<tr>
					       				
							       				<td style="text-align:right;width:15%;" valign="top">
							       					<h:outputText value="#{jspMsg['label.th_add']} : " styleClass="ms7" />
							       				</td>
							       				<td style="text-align:left;" valign="top" >
							       					
							       					<h:inputText value="#{semmsa002Bean.siteAppRentObjParam.rentAmtAdd}" id="msa002tab3_rentAmtAdd" 
													maxlength="15" onkeypress="return numberformat.keyPressDecimal(this, event);" 
													onblur="msa002tab3_calAmtRentCJS();return numberformat.moneyFormat(this);" 
													onchange="msa002tab3_calAmtRentCJS();"
				              						onfocus="return numberformat.setCursorPosToEnd(this);"
													style="text-align:right;" styleClass="ms7" 
													disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
														<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
													</h:inputText>
													
													<h:outputText value="#{jspMsg['label.th_unit_baht']} " style="margin:0 0 0 0px;" styleClass="ms7" />
													
													<a4j:jsFunction name="msa002tab3_calAmtRentCJS" reRender=" msa002tab3_rentAmtAdd, msa002tab3_rentAmtAddPerc, msa002tab3_rentAmt" 
													action="#{semmsa002Action.msa002_calAmtRate}" oncomplete="msa002tab3_subCalAmt();">
														<a4j:actionparam name="paramCalAmt" value="rentC" />
														<a4j:actionparam name="flag" value="R" />
													</a4j:jsFunction>
													
													<a4j:jsFunction name="msa002tab3_calAmtRentDJS" reRender=" msa002tab3_rentAmtAdd, msa002tab3_rentAmtAddPerc, msa002tab3_rentAmt" 
													action="#{semmsa002Action.msa002_calAmtRate}" oncomplete="msa002tab3_subCalAmt();">
														<a4j:actionparam name="paramCalAmt" value="rentD" />
														<a4j:actionparam name="flag" value="R" />
													</a4j:jsFunction>
							       				</td>
						       					<td style="text-align:right;width:15%;" valign="top">
							       					<h:outputText value="#{jspMsg['label.th_add']} " style="margin:0 0 0 5px;" styleClass="ms7" />
							       				</td>
							       				<td style="text-align:left;" valign="top" colspan="3">
							       					<h:inputText value="#{semmsa002Bean.siteAppRentObjParam.rentAmtAddPerc}" id="msa002tab3_rentAmtAddPerc"
													onblur="msa002tab3_calAmtRentDJS();" onchange="msa002tab3_calAmtRentDJS();"
													style="text-align:right; width:70px;" styleClass="ms7" 
													disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
														<f:convertNumber pattern="#,##0.00" maxIntegerDigits="7" maxFractionDigits="2" />
													</h:inputText>
													<h:outputText value="%" style="margin-left:5px;" styleClass="ms7" />
							       				</td>
						       			</tr>
					       			</rich:page>
					       			<tr>
					       				
					       				<td style="text-align:right;width:15%;" valign="top">
					       					<h:outputText value="#{jspMsg['label.el_pay']} : " styleClass="ms7"></h:outputText>
					       				</td>
					       				<td style="text-align:left;" valign="top" >
					       					
					       					<h:inputText id="msa002tab3_rentAmt" value="#{semmsa002Bean.siteAppRentObjParam.rentAmt}" maxlength="17" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
			              						onblur="msa002_calAmtAdd();return numberformat.moneyFormat(this);"
			              						onchange="msa002_calAmtAdd();"
			              						onfocus="return numberformat.setCursorPosToEnd(this);"
												disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
													<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
											</h:inputText>
					       					<h:outputText value="#{jspMsg['label.th_unit_baht']} " style="margin:0 0 0 0px;" styleClass="ms7" />
					       					<rich:spacer width="10"></rich:spacer>
					       					
					       					<a4j:jsFunction name="msa002_calAmtAdd" reRender="msa002tab3_rentAmtAdd, msa002tab3_rentAmtAddPerc, msa002tab3_rentAmt" 
							                action="#{semmsa002Action.msa002_calAmtAdd}">
							                </a4j:jsFunction>
					       					<a4j:jsFunction name="msa002tab3_calAmt" reRender="msa002tab3_rentAmtAdd, msa002tab3_rentAmtAddPerc, msa002tab3_rentAmt" 
							                action="#{semmsa002Action.doCalAmt}">
							                    <a4j:actionparam name="paramCalDtm" value="tab2" />
							                    <a4j:actionparam name="flagType" value="R" />
							                </a4j:jsFunction>
					       					
					       					<rich:spacer width="10"></rich:spacer>
					       					
					       					
											
											
											<a4j:jsFunction name="setDefaultRentPayPeriod" action="#{semmsa002Action.doSetDefaultRentPayPeriod}" 
											reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
												msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
												msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07,msa002tab3_rentPeriodType">
											</a4j:jsFunction>
					       				</td>
					       				<td style="text-align:right;width:15%;" valign="top">
							       			<h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="ms7"></h:outputText>
							       		</td>
							       		<td style="text-align:left;" valign="top" colspan="3">
							       			<h:selectOneMenu id="msa002tab3_rentPeriodType" value="#{semmsa002Bean.siteAppRentObjParam.rentPeriodType}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}"
											onchange="setDefaultRentPayPeriod();msa002_calAmtAdd();" styleClass="ms7">
												<f:selectItems value="#{semmsa002Bean.promiseRenewPeriodTypeList}"/>
											</h:selectOneMenu>
					       				</td>
					       			</tr>
					       			
					       			<tr>
					       				<td style="text-align:right;" valign="top">
					       					<h:outputText value="Detail : " styleClass="ms7"></h:outputText>
					       				</td>
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					<h:inputTextarea style="width:100%;" rows="5" 
					       					value="#{semmsa002Bean.siteAppRentObjParam.rentDetail}"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
					       					</h:inputTextarea>
					       				</td>
					       			</tr>
					       			<tr>
					       				<td style="text-align:right;" valign="top">
					       					<h:outputText value="W/T :" styleClass="ms7"></h:outputText>
					       				</td>
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					<h:panelGrid columns="4">
					       						<h:panelGroup>
					       							<h:selectOneRadio id="msa002tab3_rntWHT" value="#{semmsa002Bean.siteAppRentObjParam.rentWhtType}" 
			                                            style="" styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
			                                                <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']}#{jspMsg['label.th_tax']}" />
			                                                <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']}#{jspMsg['label.th_tax']}"/>
			                                                <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_free']}#{jspMsg['label.th_tax']}" />
			                              			</h:selectOneRadio> 
					       						</h:panelGroup>
					       						
					       						<rich:spacer width="120px"></rich:spacer>
					       						
					       						<h:panelGroup>
					       							<h:outputText value="VAT :" styleClass="ms7"></h:outputText>
					       						</h:panelGroup>
					       						
					       						<h:panelGroup>
					       							<h:selectOneRadio id="msa002tab3_rntVatType" value="#{semmsa002Bean.siteAppRentObjParam.rentVatType}" 
													style="" styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
						                				
						                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
						                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
						                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.vatType00']} "/>
						                			</h:selectOneRadio>
					       						</h:panelGroup>
					       					</h:panelGrid>
					       					
					       				</td>
					       				
					       			</tr>
					       			<tr>
					       				<td style="text-align:right;" valign="top">
					       					<h:outputText value="#{jspMsg['label.th_condition_ofPayment']} : " styleClass="ms7" />
					       				</td>
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					<h:panelGrid columns="9">
									        	<h:panelGroup>
							       					<h:selectOneRadio id="msa002tab3_rbtPayPeriodType01" value="#{semmsa002Bean.payPeriodType01}"  styleClass="ms7" rendered="true"
												    onclick="msa002tab3_setPayPeriodType01();" 
												    disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
											                				
											        	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
											                				 
													    <a4j:jsFunction name="msa002tab3_setPayPeriodType01" action="#{semmsa002Action.renderPayPeriodType}" 
													    reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
													    msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
													    msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
															<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
														</a4j:jsFunction>
											        </h:selectOneRadio>
									        	</h:panelGroup>
									        	<h:panelGroup>
							       					<h:selectOneRadio id="msa002tab3_rbtPayPeriodType06" value="#{semmsa002Bean.payPeriodType06}"  styleClass="ms7" rendered="true"
												    onclick="msa002tab3_setPayPeriodType06();" 
												    disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
											                				
											        	<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
											                				 
													    <a4j:jsFunction name="msa002tab3_setPayPeriodType06" action="#{semmsa002Action.renderPayPeriodType}" 
													    reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
													    msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
													    msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType07">
															<a4j:actionparam  name="payPeriodType" value="06"></a4j:actionparam>
														</a4j:jsFunction>
											        </h:selectOneRadio>
									        	</h:panelGroup>
									        	<h:panelGroup>
							       					<h:selectOneRadio id="msa002tab3_rbtPayPeriodType07" value="#{semmsa002Bean.payPeriodType07}"  styleClass="ms7" rendered="true"
												    onclick="msa002tab3_setPayPeriodType07();" 
												    disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
											                				
											        	<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
											                				 
													    <a4j:jsFunction name="msa002tab3_setPayPeriodType07" action="#{semmsa002Action.renderPayPeriodType}" 
													    reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
													    msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
													    msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06">
															<a4j:actionparam  name="payPeriodType" value="07"></a4j:actionparam>
														</a4j:jsFunction>
											        </h:selectOneRadio>
									        	</h:panelGroup>
									        	<h:panelGroup>
											        <h:selectOneRadio id="msa002tab3_rbtPayPeriodType02" value="#{semmsa002Bean.payPeriodType02}"  styleClass="ms7" rendered="true"
												    onclick="msa002tab3_setPayPeriodType02();" 
												    disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
											                				
												    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}"/>
												                				
												    	<a4j:jsFunction name="msa002tab3_setPayPeriodType02" action="#{semmsa002Action.renderPayPeriodType}" 
												    	reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
												    	msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
												    	msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
															<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
														</a4j:jsFunction>
											        </h:selectOneRadio>
											   	</h:panelGroup>
									        	<h:panelGroup>     
											        <h:selectOneRadio id="msa002tab3_rbtPayPeriodType03" value="#{semmsa002Bean.payPeriodType03}"  styleClass="ms7" rendered="true"
								                	onclick="msa002tab3_setPayPeriodType03();" 
								                	disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
									                				
										            	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
										                				
										                <a4j:jsFunction name="msa002tab3_setPayPeriodType03" action="#{semmsa002Action.renderPayPeriodType}" 
										                reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,
										                msa002tab3_rbtPayPeriodType03,msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,
										                msa002tab3_txtPayPeriodTypeMonth,msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
															<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
														</a4j:jsFunction>
									                </h:selectOneRadio>
									           	</h:panelGroup>
									        	<h:panelGroup>     
									                <h:inputText id="msa002tab3_txtPayPeriodTypeMonth" size="5"  
									                disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses || semmsa002Bean.payPeriodType03 != '03'}"
									                value="#{semmsa002Bean.payPeriod03}" styleClass="inputRight"
									                onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
									                onblur="msa002tab3_setPayPeriodType03();">
									                				
									                	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
										                				
										                <a4j:jsFunction name="msa002tab3_setPayPeriodType03" action="#{semmsa002Action.renderPayPeriodType}" 
										                reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,
										                msa002tab3_rbtPayPeriodType03,msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,
										                msa002tab3_txtPayPeriodTypeMonth,msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
															<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
														</a4j:jsFunction>
													</h:inputText>
									                			
									                			<rich:spacer width="5"></rich:spacer>
									                			<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
									           	</h:panelGroup>
									        	<h:panelGroup>     
									                <h:selectOneRadio id="msa002tab3_rbtPayPeriodType04" value="#{semmsa002Bean.payPeriodType04}"  styleClass="ms7" rendered="true"
								                	onclick="msa002tab3_setPayPeriodType04();" disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
									                				
										            	<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
										                			
										                			<a4j:jsFunction name="msa002tab3_setPayPeriodType04" action="#{semmsa002Action.renderPayPeriodType}" 
										                				 reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
										                				 msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
										                				 msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
															        	<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
															        	</a4j:jsFunction>
									                </h:selectOneRadio>
									            </h:panelGroup>
									        	<h:panelGroup>				
									                <h:inputText id="msa002tab3_txtPayPeriodTypeYear" size="5" 
									                disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses || semmsa002Bean.payPeriodType04 != '04'}"
									                value="#{semmsa002Bean.payPeriod04}" styleClass="inputRight"
									                onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
									                onblur="msa002tab3_setPayPeriodType04();">
									                	<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
										                			
										              	<a4j:jsFunction name="msa002tab3_setPayPeriodType04" action="#{semmsa002Action.renderPayPeriodType}" 
										                reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
										                msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
										                msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
														<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
														</a4j:jsFunction>
									                
									                </h:inputText>
									                				<rich:spacer width="5"></rich:spacer>
									                				<h:outputText value="#{jspMsg['label.th_year']}" styleClass="ms7"></h:outputText>
									            
								                </h:panelGroup>
								                <h:panelGroup>
								                	<h:selectOneRadio id="msa002tab3_rbtPayPeriodType05" value="#{semmsa002Bean.payPeriodType05}"  styleClass="ms7" rendered="true"
								                	onclick="msa002tab3_setPayPeriodType05();" 
								                	disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
									                				
										            	<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
										                				
										            	<a4j:jsFunction name="msa002tab3_setPayPeriodType05" action="#{semmsa002Action.renderPayPeriodType}" 
										            	reRender="msa002tab3_rbtPayPeriodType01,msa002tab3_rbtPayPeriodType02,msa002tab3_rbtPayPeriodType03,
										                msa002tab3_rbtPayPeriodType04,msa002tab3_rbtPayPeriodType05,msa002tab3_txtPayPeriodTypeMonth,
										                msa002tab3_txtPayPeriodTypeYear,msa002tab3_rbtPayPeriodType06,msa002tab3_rbtPayPeriodType07">
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
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					<a4j:region>
												<!-- begin date -->
												<rich:calendar id="msa002tab3_dateFrom" locale="th" enableManualInput="true" 
													datePattern="dd/MM/yyyy" 
													value="#{semmsa002Bean.siteAppRentObjParam.periodStartDt}"
													showWeeksBar="false"
													inputSize="10"
													oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   	cellWidth="15px" cellHeight="20px"
												   	label=""
												   	styleClass="ms7"
												   	oninputblur="msa002tab3_calDtmJS();"
									   	   			oncollapse="msa002tab3_calDtmJS();"
									   	   			oninputchange="msa002tab3_calDtmJS();"
												   	disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
												</rich:calendar>
												
												<rich:spacer width="50"></rich:spacer>
												<h:outputText value="#{jspMsg['column.header.endPeriodDate']} :  " styleClass="ms7" />
												<!-- end date -->
												<rich:calendar id="msa002tab3_dateTo" locale="th" enableManualInput="true" 
													   datePattern="dd/MM/yyyy" 
													   value="#{semmsa002Bean.siteAppRentObjParam.periodEndDt}"
													   showWeeksBar="false"
													   inputSize="10"
													   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   	   cellWidth="15px" cellHeight="20px"
												   	   label=""
												   	   styleClass="ms7"
												   	   oninputblur="msa002tab3_calDtmJS();"
									   	   			   oncollapse="msa002tab3_calDtmJS();"
									   	   			   oninputchange="msa002tab3_calDtmJS();"
												   	   disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly
												   	    || semmsa002Bean.chkRentalNoExpenses 
												   	    }">
												</rich:calendar>
												
												<a4j:jsFunction name="msa002tab3_calDtmJS" reRender="msgTopTab3,msgMidTab3
												,msa002tab3_dateFrom, msa002tab3_dateTo,test_text3,pnlRentalServ,pnlTotleRental" 
												action="#{semmsa002Action.msa002_calDtm}">
													<a4j:actionparam name="paramCalDtm" value="tab3" />
												</a4j:jsFunction>
												<rich:spacer width="90"></rich:spacer>
												
												<h:selectBooleanCheckbox value="#{semmsa002Bean.chkRentAmtAdd}" onclick="doChkRentAdd()"  
												disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses
												}">
					       						
						       					</h:selectBooleanCheckbox>
						       					
						       					<a4j:jsFunction name="doChkRentAdd" reRender="msa002tab3_rentAppPerc,msa002tab3_rentAddPeriodType">
						       					</a4j:jsFunction>
						       					
						       					<h:outputText value="#{jspMsg['column.header.rentalChange']}" styleClass="ms7"></h:outputText>
						       					
						       					<rich:spacer width="10"></rich:spacer>
						       					
						       					<h:selectOneMenu id="msa002tab3_rentAppPerc" value="#{semmsa002Bean.siteAppRentObjParam.rentAdj}"
						       					 style=" height : 19px;"
						       					 disabled="#{!semmsa002Bean.chkRentAmtAdd || semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
						       						<f:selectItems value="#{semmsa002Bean.rentAdjList}" />
						       					</h:selectOneMenu>
						       					
						       					<rich:spacer width="10"></rich:spacer>
						       					
						       					<h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="ms7"></h:outputText>
						       					
						       					<h:selectOneMenu id="msa002tab3_rentAddPeriodType" value="#{semmsa002Bean.siteAppRentObjParam.rentAdjPeriodType}" 
												disabled="#{!semmsa002Bean.chkRentAmtAdd || semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}" styleClass="ms7">
													<f:selectItems value="#{semmsa002Bean.promiseRenewPeriodTypeList}"/>
												</h:selectOneMenu>
						       					
						       					<rich:spacer width="90"></rich:spacer>
											</a4j:region>
					       				</td>
					       			</tr>
					       			<tr>
					       				<td style="text-align:right;" valign="top">
					       				</td>
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					
					       					<h:selectBooleanCheckbox value="#{semmsa002Bean.chkService}" onclick="doChkService()"
					       					 disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}"></h:selectBooleanCheckbox>
					       					<h:outputText value="Service" styleClass="ms7"></h:outputText>
					       					
					       					<a4j:jsFunction name="doChkService" reRender="msa002Tab3_service"></a4j:jsFunction>
					       					
					       					<rich:spacer width="10"></rich:spacer>
					       					
					       					<h:selectOneMenu id="msa002Tab3_service" value="#{semmsa002Bean.siteAppRentObjParam.serviceId}"
					       					disabled="#{!semmsa002Bean.chkService || semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
					       					
					       						<f:selectItems value="#{semmsa002Bean.servTypeList}"/>
					       					</h:selectOneMenu>
					       					
					       				</td>
					       			</tr>
					       			<tr>
					       				<td style="text-align:right;" valign="top">
					       					<h:outputText value="#{jspMsg['label.th_eff_dt']} :" styleClass="ms7"
					       					rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"></h:outputText>
					       				</td>
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					<rich:calendar locale="th" enableManualInput="true" 
													   datePattern="dd/MM/yyyy" 
													   value="#{semmsa002Bean.siteAppRentObjParam.effectiveDt}"
													   showWeeksBar="false"
													   inputSize="10"
													   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   	   cellWidth="15px" cellHeight="20px"
												   	   label=""
												   	   styleClass="ms7"
												   	   rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"
												   	   disabled="#{semmsa002Bean.disabledModeViewOnly or semmsa002Bean.chkRentalNoExpenses}">
												</rich:calendar>
					       				</td>
					       				<td style="text-align:right;" valign="top">
					       					
					       				</td>
					       				<td style="text-align:left;" valign="top">
					       					
					       				</td>
					       				<td style="text-align:right;" valign="top">
					       					
					       				</td>
					       				<td style="text-align:left;" valign="top">
					       					
					       				</td>
					       			</tr>
					       			
					       			<tr>
					       				<td style="text-align:right;" valign="top">
					       					
					       				</td>
					       				<td style="text-align:left;" valign="top" colspan="5">
					       					<a4j:commandButton id="msa002tab3_btnAddRental" value="Add" styleClass="rich-button" 
					       					rendered="#{semmsa002Bean.siteAppRentObjParam.siteAppId eq '' or semmsa002Bean.siteAppRentObjParam.siteAppId eq null}"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly or semmsa002Bean.chkRentalNoExpenses}"
					       					action="#{navAction.navi}" 
					       					reRender="oppContent,pnlMsa002Tab3_rentCont,pnlMsa002Tab3_rentContExisting" style=" width : 46px;">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppRentCont" />
					                            <a4j:actionparam name="siteAppRentContMode" value="#{semmsa002Bean.siteAppRentObjParam.rentContMode}" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab3_btnSaveRental" value="Save" styleClass="rich-button" 
					       					rendered="#{semmsa002Bean.siteAppRentObjParam.siteAppId != '' and semmsa002Bean.siteAppRentObjParam.siteAppId != null}"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly or semmsa002Bean.chkRentalNoExpenses}"
					       					action="#{navAction.navi}" reRender="oppContent,pnlMsa002Tab3_rentCont,pnlMsa002Tab3_rentContExisting">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppRentCont" />
					                            <a4j:actionparam name="siteAppRentContMode" value="#{semmsa002Bean.siteAppRentObjParam.rentContMode}" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab3_btnClearRental" value="Clear" styleClass="rich-button" rendered="true"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly or semmsa002Bean.chkRentalNoExpenses}"
					       					action="#{navAction.navi}" reRender="oppContent,pnlMsa002Tab3_rentCont,pnlMsa002Tab3_rentContExisting">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppRentCont" />
					                            <a4j:actionparam name="siteAppRentContMode" value="#{semmsa002Bean.siteAppRentObjParam.rentContMode}" />
					       					</a4j:commandButton>
					       				</td>
					       				
					       			</tr>
					       		</table>
					   		</td>
					   	</tr>
					</table>
					
				</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				<h:panelGrid id="msgMidTab3_1">
					<rich:messages id="msgPnlTab3_1_mid" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgFormChkExpire}">
                        
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
				</h:panelGrid>
				<rich:spacer height="10"></rich:spacer>
        		<!-- >> group 3 -->       
				
				<rich:panel id="pnlMsa002Tab3_rentCont">
				
		
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_rentalServOtherinfo']}" style="width: 100%;"/>
					</f:facet>
				
					<h:panelGroup style="width:1200px; overflow:scroll; border:1px solid e0e0e0;">
					
						<rich:dataTable width="100%" id="dtbRentalServOtherinfo" cellpadding="1" cellspacing="0" border="0"
                        var="siteAcqSP" value="#{semmsa002Bean.siteAppRentCont}" reRender="dtbSiteInfo" 
                        rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            
                            <rich:column rendered="#{semmsa002Bean.disabledModeViewOnly != true}">
	                            <f:facet name="header">
	                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
		                            reRender="pnlRental" 
		                            disabled="#{semmsa002Bean.chkRentalNoExpenses }"
		                            rendered="#{siteAcqSP.dataObj.rowId != null and semmsa002Bean.disabledModeViewOnly != true}" >
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doEditRental" />
		                                <a4j:actionparam name="siteAppRentContId" value="#{siteAcqSP.dataObj.siteAppRentContId}" />
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
	                        
	                        <rich:column rendered="#{semmsa002Bean.disabledModeViewOnly != true}">
	                            <f:facet name="header">
	                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
		                            disabled="#{semmsa002Bean.chkRentalNoExpenses }"
		                            reRender="oppContent" 
		                            rendered="#{siteAcqSP.dataObj.rowId != null and semmsa002Bean.disabledModeViewOnly != true and siteAcqSP.dataObj.recordStatus eq 'Y'}"
		                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
		                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppRentCont" />
		                               	<a4j:actionparam name="siteAppRentContId" value="#{siteAcqSP.dataObj.siteAppRentContId}" />
										<a4j:actionparam name="siteAppId" value="#{siteAcqSP.dataObj.siteAppId}" />
										<a4j:actionparam name="expenseType" value="#{siteAcqSP.dataObj.expenseType}" />
										<a4j:actionparam name="serviceId" value="#{siteAcqSP.dataObj.serviceId}" />
										<a4j:actionparam name="siteAppRentContMode" value="C" />
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
	                        
	                        <rich:column sortBy="#{siteAcqSP.dataObj.recordStatus}">
                                <f:facet name="header">
                                    <h:outputText value="Status" styleClass="contentform" style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="ms7red"  value="Delete" rendered="#{siteAcqSP.dataObj.recordStatus eq 'N'}"/>
                                </div>
                      		</rich:column>
                            <rich:column sortBy="#{siteAcqSP.dataObj.startDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.startDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{siteAcqSP.dataObj.endDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.endDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{siteAcqSP.dataObj.effectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.effectiveDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{siteAcqSP.dataObj.periodStartDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.periodStartDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{siteAcqSP.dataObj.periodEndDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 80"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.periodEndDtStr}"/>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{siteAcqSP.dataObj.expenseName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.expenseName}"/>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{siteAcqSP.dataObj.expenseDesc}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.expenseDesc']}" styleClass="contentform" style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.expenseDesc}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Detail" styleClass="contentform" style="width: 600"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.rentDetail}"/>
                                </div>
                      		</rich:column>
                      		
                      		<rich:column sortBy="#{siteAcqSP.dataObj.rentAmtOld}" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentOldAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{siteAcqSP.dataObj.rentAmtOld}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteAcqSP.dataObj.rentAmtAddPerc}" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAddPercent']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{siteAcqSP.dataObj.rentAmtAddPerc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{siteAcqSP.dataObj.rentAmtAdd}" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAddAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{siteAcqSP.dataObj.rentAmtAdd}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							
                      		<rich:column sortBy="#{siteAcqSP.dataObj.rentAmt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.rentAmt}">
                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 40"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentPeriodName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="W/T" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.rentWhtName}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Vat" styleClass="contentform" style="width: 60"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.rentVatName}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.paymentCond']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"   value="#{siteAcqSP.dataObj.rentPaymentPeriodName}"/>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.rentalChange']}" styleClass="contentform" style="width: 70"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.rentAdjName}" />
                                    <h:outputText styleClass="contentform" value="%" rendered="#{siteAcqSP.dataObj.rentAdj != null}"/>
                                    
                                    <h:outputText styleClass="contentform" value=" #{siteAcqSP.dataObj.rentAdjPeriodName}"></h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.serviceName}" />
                                </div>
                      		</rich:column>
                      		
                      		<f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppRentCont)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="15">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalServOtherinfo"
                                            maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstRentalServOtherinfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsa001Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            
                   		</rich:dataTable>
					
					</h:panelGroup>
				</rich:panel>
				
				<rich:spacer height="10"></rich:spacer>
        		<!-- >> group 3 -->        
                <rich:panel>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_totalPayment']}" />
					</f:facet>
				
					<h:panelGroup style="width:100%;" id="pnlRentalServ">
						<table style="width:100%;">
							<tr>
								<td valign="top" colspan="4" align="center">
					       					
					       			<rich:dataTable style="width:50%;" id="dataService1tab2" cellpadding="1" cellspacing="0" border="0" 
										var="appSiteService"  value="#{semmsa002Bean.siteAppRentServList}" reRender="dataService1tab2" 
										rows="5" rowClasses="cur" styleClass="dataTable">
										
											<!-- header -->
								                
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
													<!-- > 1 -->
													<rich:column colspan="1">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppRentServList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
													<!-- > 2 -->
													<rich:column colspan="2">
															<rich:datascroller immediate="true" rendered="true" align="left" for="dataService1tab2"
																maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																stepControls="hide" fastControls="auto" boundaryControls="auto" 
																id="scrllDataService1tab2" style="background-color: #cccccc;"
																page="#{semmsa002Bean.scrollerPage}">
															<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
															</rich:datascroller>
													</rich:column>
												</rich:columnGroup>
											</f:facet>
											<!-- footer -->
								            
								   	</rich:dataTable>
					       					
					       		</td>
							</tr>
							<h:panelGroup id="pnlTotleRental" style="width:100%;">
								<tr>
									<td style="text-align:left;" valign="top" colspan="4">
						       			<h:outputText value="#{jspMsg['label.th_totalPaymentbyPaymentType']}" styleClass="ms7" style="text-decoration:underline;" />		
						       		</td>
						       		
								</tr>
								<tr>
									<td style="text-align:right;" valign="top">
						       			<h:outputText value="#{jspMsg['label.totalRentalservice']} :" styleClass="ms7" />		
						       		</td>
						       		<td style="text-align:left;" valign="top">
						       			<h:inputText value="#{semmsa002Bean.siteAppRentAmt.rentServiceAmt}"
						       			 disabled="true" style="text-align:right;">
						       				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" /> 
						       			</h:inputText>
						       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />			
						       		</td>
						   
						       		<td style="text-align:right;" valign="top">
						       		   
						       			<h:outputText value="#{jspMsg['label.totalSupportAmt']} :" styleClass="ms7" />
						       			 	
						       		</td>
						       		<!-- remove 08/02/2023 new req_2023
						       		<td style="text-align:left;" valign="top">
						       			<h:inputText value="#{semmsa002Bean.siteAppRentAmt.supportAmt}" 
						       			disabled="true" style="text-align:right;">
						       				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						       			</h:inputText>
						       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />			
						       		</td>
						       		-->
						       		<td style="text-align:left;" valign="top">
						       			<h:inputText value="#{semmsa002Bean.siteAppRentAmt.donateAmt}" 
						       			disabled="true" style="text-align:right;">
						       				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						       			</h:inputText>
						       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />			
						       		</td>
						       		
								</tr>
								<!-- remove 08/02/2023 new req_2023
								<tr>
									<td style="text-align:right;" valign="top">
						       			<h:outputText value="#{jspMsg['label.totalDonateAmt']} :" styleClass="ms7" />		
						       		</td>
						       		<td style="text-align:left;" valign="top">
						       			<h:inputText value="#{semmsa002Bean.siteAppRentAmt.donateAmt}" disabled="true" style="text-align:right;">
						       				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						       			</h:inputText>
						       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />			
						       		</td>
						       		<td style="text-align:right;" valign="top">
						       			<h:outputText value="#{jspMsg['label.totalOtherAmt']} :" styleClass="ms7" />	
						       		</td>
						       		<td style="text-align:left;" valign="top">
						       			<h:inputText value="#{semmsa002Bean.siteAppRentAmt.otherPaymentAmt}" disabled="true" style="text-align:right;">
						       				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						       			</h:inputText>
						       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />			
						       		</td>
								</tr>
								-->
								<tr>
									<td style="text-align:right;" valign="top">
						       			
						       		</td>
						       		<td style="text-align:left;" valign="top">
						       					
						       		</td>
						       		<td style="text-align:right;" valign="top">
						       			<h:outputText value="#{jspMsg['label.totalAmt']} :" styleClass="ms7" />	
						       		</td>
						       		<td style="text-align:left;" valign="top">
						       			<h:inputText value="#{semmsa002Bean.siteAppRentAmt.allPaymentAmt}" disabled="true" style="text-align:right;">
						       				<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						       			</h:inputText>
						       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />			
						       		</td>
								</tr>
							</h:panelGroup>
						</table>
					</h:panelGroup>
				</rich:panel>
				
				<rich:spacer height="10"></rich:spacer>
				
				<h:panelGroup>
                	<div>
                		
                	
                		<a4j:commandButton id="msa002tab3_BtnUndoRentalDeposit" value="#{jspMsg['label.th_undo']}#{jspMsg['label.th_changeRentalDepInfo']}" 
						disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab3_changeRentalDepositComfirm();"
						styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:190px;">
						</a4j:commandButton>
                		
                		<a4j:jsFunction name="fnMsa002tab3_changeRentalDepositComfirm"
                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
                		action="#{semmsa002Action.doSetParamConfirmNotChangeRentalDeposit}"
                		reRender="pnlMsa002Tab3_rentCont, panelTab3, 
                		msa002tab3_btnSaveRental, msa002tab3_btnSaveRental, msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
                	</div>
                </h:panelGroup>
                
                <rich:spacer height="10"></rich:spacer>
        		<!-- >> group 3 -->        
                <rich:panel id="msa002Tab3_pnlRentalDeposit">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.rentalserviceDep']}" />
					</f:facet>
				
					<h:panelGroup style="width:98%;">
						<table style="width:100%; border:solid 0px;" >
					    	<tr>
					       		<td >
					       			<h:selectBooleanCheckbox id="msa002Tab3_chkNoRentalDeposit" value="#{semmsa002Bean.chkNoRentalDeposit}" 
								    disabled="#{semmsa002Bean.disabledModeViewOnly}" 
								    onclick="chkNoRentalDep();"/>
								           
								    <h:outputText value="#{jspMsg['label.nodeposit']}" styleClass="ms7"></h:outputText>
								    
								    <a4j:jsFunction name="chkNoRentalDep" action="#{navAction.navi}" reRender="msa002Tab3_pnlRentalDeposit"> 
								    	<a4j:actionparam name="navModule" value="sa" />
							            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							            <a4j:actionparam name="moduleWithNavi" value="sa" />
							            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppDeposit" />
								    </a4j:jsFunction>
								     
					       		</td>
					       		
					       	</tr>
					 	</table>
					 	
					 	<div style="width:100%; border:solid 0px;padding:5px;">
					 		<table style="width:100%; " >
								<tr>
									<td align="right" style="width:20%">
							       			<h:outputText value="* " style="font-style:bold; color:reๅd;" />       
										    <h:outputText value="#{jspMsg['label.rentalDepType']} :" styleClass="ms7"></h:outputText>
							       		</td>
							       		<td align="left">
							       			<h:selectOneMenu id="depType" value="#{semmsa002Bean.siteAppDeptObj.depositType}" 
							       			style=" height : 19px;" onchange="renderDeptBgCash()"
							       			disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit}">
							       				<f:selectItem itemLabel=" -- Select -- " itemValue=""/>
							       				<f:selectItem itemLabel=" BG " itemValue="01"/>
							       				<f:selectItem itemLabel=" Cash " itemValue="02"/>
							       			</h:selectOneMenu>
							       			
							       			<a4j:jsFunction name="renderDeptBgCash" action="#{semmsa002Action.doRenderDeptBgCash}" reRender="msa002Tab3_pnlRentalDeposit"></a4j:jsFunction>
							       		</td>
							       		<td align="right" style="width:20%">
							       			 <h:outputText value="* " style="font-style:bold; color:red;" />      
										    <h:outputText value="#{jspMsg['column.header.rantalPayment']} :" styleClass="ms7"></h:outputText>
							       		</td>
							       		<td align="left">
							       			<h:selectOneMenu value="#{semmsa002Bean.siteAppDeptObj.expenseType}"
							       			disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit}">
							       				<f:selectItems value="#{semmsa002Bean.expenseTypeDepositRentList}"/>
							       			</h:selectOneMenu>
							       			
							       			<a4j:jsFunction name="doCalDepositAmt" action="#{semmsa002Action.doCalDepositAmt}"
							       			reRender="msa002Tab3_cashDepositAmt,msa002Tab3_bgDepositAmt">
							       			
							       			</a4j:jsFunction>
							       		</td>
							       	</tr>
							   </table>
							   
					 		<h:panelGrid width="100%">
					 			<h:panelGroup id="pnlDeptCash" rendered="#{semmsa002Bean.renderedPnlDeptCash}">
					 				<div id="cash" style="width:100%; border:solid 1px fff;padding:5px;">
					 					
					 					<h:panelGroup id="msaTab3_pnlCashDepositOld" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01' and
					 					semmsa002Bean.siteAppDeptCashObj.depositAmtOld > 0}">
							 				<div style="width:100%; border:solid 1px dddddd;padding:5px;">
							 				
							 				<table style="width:100%;">
													       				
												<tr>
													<td align="right" width="15%">
														<h:outputText value="#{jspMsg['label.th_old_insure_money']} :" styleClass="ms7"></h:outputText>
													</td>
													<td align="left">
														<h:inputText  value="#{semmsa002Bean.siteAppDeptCashObj.depositAmtOld}" maxlength="17" 
														onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
														onblur="return numberformat.moneyFormat(this);"
														onfocus="return numberformat.setCursorPosToEnd(this);" 
								   	 					readonly="true">
															<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
														</h:inputText>
														<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
													</td>
																       		<td align="left">
																       			<h:panelGrid columns="1">
											        								<h:panelGroup>
											        									<h:selectOneRadio id="msa002Tab3_rbtDeptReturnType01" value="#{semmsa002Bean.deptReturnType01}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnType01();"
											        									disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"> 
																					    	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.fullGetBackDep']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnType01" action="#{semmsa002Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_rbtDeptReturnType03,
																					    msa002tab3_txtDeptReturnType02,msa002tab3_depositReturnAmt">
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
											        									<h:selectOneRadio id="msa002Tab3_rbtDeptReturnType02" value="#{semmsa002Bean.deptReturnType02}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnType02();"
											        									disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"> 
																					    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.someGetBackDep']}"/>
																					    	
																					    </h:selectOneRadio>
																					    
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnType02" action="#{semmsa002Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_rbtDeptReturnType03,
																					    msa002tab3_txtDeptReturnType02,msa002tab3_depositReturnAmt">
																					    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="02"></a4j:actionparam>
																						</a4j:jsFunction>
																					 </h:panelGroup>
																					 <h:panelGroup>
																					    
																					    <h:inputText id="msa002tab3_txtDeptReturnType02" value="#{semmsa002Bean.siteAppDeptCashObj.returnAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit  
																							|| semmsa002Bean.deptReturnType02 != '02'}"
																							onchange="doCalDepositReturnAmt()">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																					 	<a4j:jsFunction name="doCalDepositReturnAmt" action="#{semmsa002Action.doCalDepositReturnAmt}"
																					 	 reRender="msa002Tab3_pnlRentalDeposit">
																					 	
																					 	</a4j:jsFunction>
																					 </h:panelGroup>
																					 <h:panelGroup>
																		       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
											        								
											        								</h:panelGroup>
																       			</h:panelGrid>       
																			    
																       		</td>
																       		<td >
																       			<h:outputText value="#{jspMsg['label.balance']} : " styleClass="ms7"/>
																       			<h:inputText id="msa002tab3_depositReturnAmt" value="#{semmsa002Bean.siteAppDeptCashObj.depositReturnAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
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
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnType03" value="#{semmsa002Bean.deptReturnType03}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnType03();"
											        									disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"> 
																					    	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.noGetBack']}"/>
																					    </h:selectOneRadio>
																					    
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnType03" action="#{semmsa002Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnType01,msa002Tab3_rbtDeptReturnType02,msa002Tab3_rbtDeptReturnType03,
																					    msa002tab3_txtDeptReturnType02,msa002tab3_depositReturnAmt" >
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
																       			
																       			<h:inputText id="msa002Tab3_cashDepositAmt" value="#{semmsa002Bean.siteAppDeptCashObj.depositAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
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
																       					<h:inputText value="#{semmsa002Bean.siteAppDeptCashObj.depositAmtNew}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"
																							onchange="doCalDepositAmt();">
																								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																						</h:inputText>
																    			
																    					<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																    					
																       				</h:panelGroup>
																       			
																       				
																       				<rich:spacer width="20"></rich:spacer>
																       				
																       				
																       				<h:panelGroup>
																       				
																       				</h:panelGroup>
																       			</h:panelGrid>
																       			
																    			
																       		</td>
																       	</tr>
																    </table>
					 				</div>
					 			</h:panelGroup>
					 		
					 			<h:panelGroup id="pnlDeptBg" rendered="#{semmsa002Bean.renderedPnlDeptBg}">
					 				<div id="BG" style="width:100%; border:solid 1px ffffff;padding:5px;" >
					 					<h:panelGroup id="msaTab3_pnlBgDepositOld" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01' and
					 					semmsa002Bean.siteAppDeptBgObj.depositAmtOld > 0}">			
					 						<div style="width:100%; border:solid 1px dddddd;padding:5px;">
							 					<table style="width:100%;">
													       				
													<tr>
														<td align="right" width="10%">
															<h:outputText value="#{jspMsg['label.oldBG']} :" styleClass="ms7"></h:outputText>
														</td>
														<td align="left">
															<h:inputText value="#{semmsa002Bean.siteAppDeptBgObj.depositAmtOld}" maxlength="17" 
															onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
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
											        									
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnTypeBG01" value="#{semmsa002Bean.deptReturnType01}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnTypeBG01()"
											        									disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"> 
																					    	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.alreadyget']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnTypeBG01" action="#{semmsa002Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnTypeBG01,msa002Tab3_rbtDeptReturnTypeBG02,msa002tab3_txtDeptReturnTypeBG02,
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
											        									
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnTypeBG02" value="#{semmsa002Bean.deptReturnType02}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnTypeBG02()"
											        									disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"> 
																					    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.noBG']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnTypeBG02" action="#{semmsa002Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnTypeBG01,msa002Tab3_rbtDeptReturnTypeBG02,msa002tab3_txtDeptReturnTypeBG02,
																					    msa002Tab3_rbtDeptReturnTypeBG03">
																					    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																							<a4j:actionparam  name="deptReturnType" value="02"></a4j:actionparam>
																						</a4j:jsFunction>
																					 </h:panelGroup>
																					 <h:panelGroup>
																					    <h:inputText id="msa002tab3_txtDeptReturnTypeBG02" value="#{semmsa002Bean.siteAppDeptBgObj.returnAmt}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsa002Bean.deptReturnType02 != '02'}">
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
																					    
																					    <h:selectOneRadio id="msa002Tab3_rbtDeptReturnTypeBG03" value="#{semmsa002Bean.deptReturnType03}"
											        									styleClass="ms7" onclick="msa002tab3_setDeptReturnTypeBG03()"
											        									disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"> 
																					    	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payWhencancelContract']}"/>
																					    </h:selectOneRadio>
																					   
																					    <a4j:jsFunction name="msa002tab3_setDeptReturnTypeBG03" action="#{semmsa002Action.renderDeptReturnType}" 
																					    reRender="msa002Tab3_rbtDeptReturnTypeBG01,msa002Tab3_rbtDeptReturnTypeBG02,msa002tab3_txtDeptReturnTypeBG02,
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
																       					<h:inputText  value="#{semmsa002Bean.siteAppDeptBgObj.depositAmtNew}" maxlength="17" 
																							onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
														              						onblur="return numberformat.moneyFormat(this);"
														              						onfocus="return numberformat.setCursorPosToEnd(this);"
																							disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"
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
					 					<h:selectOneRadio id="msa002tab3_rntDeptVatType" value="#{semmsa002Bean.siteAppDeptObj.vatType}" 
													style="" styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }">
						                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
						                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
						                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.vatType00']} "/>
						                			</h:selectOneRadio>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td align="right">
					 				 	<h:outputText value="Service :" styleClass="ms7"></h:outputText>
					 				</td>
					 				<td align="left">
					 					<h:selectOneMenu value="#{semmsa002Bean.siteAppDeptObj.serviceId}" styleClass="ms7"
					 					disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }">
					 						<f:selectItems value="#{semmsa002Bean.servTypeList}"/>
					 					</h:selectOneMenu>
					 				</td>
					 			</tr>
					 			<tr>
					 				<td align="right" valign="top">
					 				 	<h:outputText value="#{jspMsg['label.th_remark']} :" styleClass="ms7"> </h:outputText>
					 				</td>
					 				<td align="left">
					 					<h:inputTextarea rows="5" style="width:80%;" value="#{semmsa002Bean.siteAppDeptObj.remark}"
					 					disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit}"></h:inputTextarea>
					 				</td>
					 			</tr>
					 		</table>
					 	</div>
					 	
					 	<div style="width:100%; padding-left:50px;margin:10px;">
					 		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgDeposit}">               
						         <f:facet name="errorMarkerPage">
						         	<h:graphicImage value="images/error.gif" />  
						         </f:facet>
						    </rich:messages>
						    
					 		<a4j:commandButton id="btnAddDPT" action="#{navAction.navi}" styleClass="rich-button" value="#{jspMsg['btn.add']}"
					 		rendered="#{semmsa002Bean.siteAppDeptObj.siteAppDepositId eq '' or semmsa002Bean.siteAppDeptObj.siteAppDepositId eq null}" 
					 		disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit}"
					 		style=" width : 46px;" reRender="msa002Tab3_pnlRentalDeposit">
					 		 
					 		 	<a4j:actionparam name="navModule" value="sa" />
					         	<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					            <a4j:actionparam name="moduleWithNavi" value="sa" />
					            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppDept" />    
                            </a4j:commandButton>
                                            
							<rich:spacer width="10"></rich:spacer>
                                            
                            <a4j:commandButton id="btnSaveDPT" action="#{navAction.navi}" styleClass="rich-button" value="#{jspMsg['btn.save']}" 
                            rendered="#{semmsa002Bean.siteAppDeptObj.siteAppDepositId != '' and semmsa002Bean.siteAppDeptObj.siteAppDepositId != null}"
                            disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }"
                            reRender="msa002Tab3_pnlRentalDeposit">
                            	<a4j:actionparam name="navModule" value="sa" />
					            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					            <a4j:actionparam name="moduleWithNavi" value="sa" />
					            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppDept" />
                            </a4j:commandButton>
                                            
                            <rich:spacer width="10"></rich:spacer>
                                            
                            <a4j:commandButton id="btnClearDPT" action="#{navAction.navi}" styleClass="rich-button" value="#{jspMsg['btn.clear']}" 
                            reRender="msa002Tab3_pnlRentalDeposit"
                            disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit }">
                                <a4j:actionparam name="navModule" value="sa" />
					            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					            <a4j:actionparam name="moduleWithNavi" value="sa" />
					            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppDeposit" />         
                            </a4j:commandButton>
					 	</div>
					 	
					 	<rich:panel >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['label.th_cashDepList']}" style="width: 100%;"/>
							</f:facet>
						
							<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
							
								<rich:dataTable width="100%" id="dtbRentalServDepCash" cellpadding="1" cellspacing="0" border="0"
		                        var="siteAcqSP" value="#{semmsa002Bean.siteAppDeptCashList}" reRender="dtbSiteInfo" 
		                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
		                            
		                            <rich:column>
			                            <f:facet name="header">
			                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
			                            </f:facet>
			                            <div align="center">
				                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
				                            reRender="msa002Tab3_pnlRentalDeposit" rendered="#{semmsa002Bean.disabledModeViewOnly != true}"
				                            disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit 
					 					}">
				                                <a4j:actionparam name="navModule" value="sa" />
				                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
				                                                    
				                                <a4j:actionparam name="moduleWithNavi" value="sa" />
				                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
				                                <a4j:actionparam name="methodWithNavi" value="doEditRentalDeposit" />
				                                <a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
				                                <a4j:actionparam name="depositType" value="02" />
				                            </a4j:commandButton>
			                            </div>
			                        </rich:column>
			                        
			                        <rich:column>
			                            <f:facet name="header">
			                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
			                            </f:facet>
			                            <div align="center">
				                            
				                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
				                            reRender="msa002Tab3_pnlRentalDeposit" rendered="#{siteAcqSP.dataObj.rowId != null and semmsa002Bean.disabledModeViewOnly != true}"
				                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
				                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;"
				                           	disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit 
					 					}">
				                                <a4j:actionparam name="navModule" value="sa" />
				                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
				                                                    
				                                <a4j:actionparam name="moduleWithNavi" value="sa" />
				                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
				                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppDept" />
				                               	<a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
												<a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
												<a4j:actionparam name="expenseType" value="#{siteAcqSP.dataObj.expenseType}" />
												<a4j:actionparam name="serviceId" value="#{siteAcqSP.dataObj.serviceId}" />
				                            </a4j:commandButton>
			                            </div>
			                        </rich:column>
		                            <rich:column sortBy="#{siteAcqSP.dataObj.newStatusName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.column.status']}" styleClass="contentform" />
										</f:facet>
										<div align="center">
											<h:outputText value="#{siteAcqSP.dataObj.newStatusName}" styleClass="contentform"  />
										</div>
									</rich:column>
		                            <rich:column sortBy="#{siteAcqSP.dataObj.effectiveDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.effectiveDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.expireDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}"/>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.expenseTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expenseTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositAmt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100" />
		                                </f:facet>
		                                <div align="right">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositAmt}">
		                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                                    </h:outputText>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositReturnType}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositReturnTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositStatus}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.vatTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.vatTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.remark}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.remark}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.serviceName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.serviceName}" />
		                                </div>
		                      		</rich:column>
		                      		
		                      		
		                      		<f:facet name="footer">
		                                <rich:columnGroup>
		                                    <rich:column colspan="4">
		                                        <h:outputFormat value="#{msg['message.totalRecords']}">
		                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppDeptCashList)}"></f:param>
		                                        </h:outputFormat>
		                                    </rich:column>
		                                    <rich:column colspan="11">
		                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalServOtherinfo"
		                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
		                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
		                                            id="dstRentalServOtherinfo" 
		                                            style="background-color: #cccccc;"
		                                            page="#{semmsa002Bean.scrollerPage}" 
		                                        />
		                                    </rich:column>
		                                </rich:columnGroup>
		                            </f:facet>
		                            
		                   		</rich:dataTable>
							
							</h:panelGroup>
						</rich:panel>
						
						<rich:panel >
							<f:facet name="header">
								<h:outputText value="#{jspMsg['label.th_BGDepList']}" style="width: 100%"/>
							</f:facet>
						
							<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
							
								<rich:dataTable width="100%" id="dtbRentalServDepBG" cellpadding="1" cellspacing="0" border="0"
		                        var="siteAcqSP" value="#{semmsa002Bean.siteAppDeptBGList}" reRender="dtbSiteInfo" 
		                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
		                            
		                            <rich:column>
			                            <f:facet name="header">
			                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
			                            </f:facet>
			                            <div align="center">
				                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
				                            reRender="msa002Tab3_pnlRentalDeposit" rendered="#{semmsa002Bean.disabledModeViewOnly != true}"
				                            disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit 
					 					}">
				                                <a4j:actionparam name="navModule" value="sa" />
				                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
				                                                    
				                                <a4j:actionparam name="moduleWithNavi" value="sa" />
				                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
				                                <a4j:actionparam name="methodWithNavi" value="doEditRentalDeposit" />
				                                <a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
				                                <a4j:actionparam name="depositType" value="01" />
				                            </a4j:commandButton>
			                            </div>
			                        </rich:column>
			                        
			                        <rich:column>
			                            <f:facet name="header">
			                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
			                            </f:facet>
			                            <div align="center">
				                            
				                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
				                            reRender="msa002Tab3_pnlRentalDeposit" 
				                            rendered="#{siteAcqSP.dataObj.rowId != null and semmsa002Bean.disabledModeViewOnly != true}"
				                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
				                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;"
				                           	disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoRentalDeposit}">
				                                <a4j:actionparam name="navModule" value="sa" />
				                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
				                                                    
				                                <a4j:actionparam name="moduleWithNavi" value="sa" />
				                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
				                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppDept" />
				                               	<a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
												<a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
												<a4j:actionparam name="expenseType" value="#{siteAcqSP.dataObj.expenseType}" />
												<a4j:actionparam name="serviceId" value="#{siteAcqSP.dataObj.serviceId}" />
				                            </a4j:commandButton>
			                            </div>
			                        </rich:column>
		                            <rich:column sortBy="#{siteAcqSP.dataObj.newStatusName}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.column.status']}" styleClass="contentform"  style="width: 50"/>
										</f:facet>
										<div align="center">
											<h:outputText value="#{siteAcqSP.dataObj.newStatusName}" styleClass="contentform"  />
										</div>
									</rich:column>
		                            <rich:column sortBy="#{siteAcqSP.dataObj.effectiveDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.effectiveDtStr}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.expireDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.expenseTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expenseTypeName}"  />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositAmt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="right">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositAmt}" >
		                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                                    </h:outputText>
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositReturnType}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositReturnTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositStatus}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.vatTypeName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.vatTypeName}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.remark}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.remark}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.serviceName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.serviceName}" />
		                                </div>
		                      		</rich:column>
		                      		
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgNo}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.BGNo']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgNo}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgBang}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.bank']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgBang}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgAmt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.BGamt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgAmt}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgEffectiveDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.BGstartDate']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgEffectiveDtStr}" />
		                                </div>
		                      		</rich:column>
		                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgExpireDt}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.BGendDate']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgExpireDtStr}" />
		                                </div>
		                      		</rich:column>
		                      		
		                      		<f:facet name="footer">
		                                <rich:columnGroup>
		                                    <rich:column colspan="4">
		                                        <h:outputFormat value="#{msg['message.totalRecords']}">
		                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppDeptBGList)}"></f:param>
		                                        </h:outputFormat>
		                                    </rich:column>
		                                    <rich:column colspan="13">
		                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalServOtherinfo"
		                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
		                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
		                                            id="dstRentalServOtherinfo" 
		                                            style="background-color: #cccccc;"
		                                            page="#{semmsa002Bean.scrollerPage}" />
		                                    </rich:column>
		                                </rich:columnGroup>
		                            </f:facet>
		                            
		                   		</rich:dataTable>
							
							</h:panelGroup>
						</rich:panel>
					</h:panelGroup>
				</rich:panel>
				
				<rich:spacer height="10"></rich:spacer>
				
                
                <a4j:jsFunction name="msa002tab3_calServAmt" reRender="panelTab3, panelTab3_totalRent,
				msa002tab3_rentServAmtOld,msa002tab3_rentServPeriodTypeOld, msa002tab3_rentServAmtAdd, msa002tab3_rentServAmtAddPerc, 
				msa002tab3_rentServiceAmt,msa002tab3_rbtServicePayPeriodType01,msa002tab3_rbtServicePayPeriodType02,
				msa002tab3_rbtServicePayPeriodType03,msa002tab3_rbtServicePayPeriodType04,msa002tab3_rbtServicePayPeriodType05" 
                action="#{semmsa002Action.doCalAmt}">
                    <a4j:actionparam name="paramCalDtm" value="tab2" />
                    <a4j:actionparam name="flagType" value="S" />
                </a4j:jsFunction>
                
				<!-- >> additional -->
				<rich:spacer height="10"></rich:spacer>
				<a4j:commandButton style="" styleClass="rich-button" id="msa002tab3_BtnSave" value="SAVE" rendered="false">
				</a4j:commandButton>
				<!-- << additional -->
			
		</rich:panel>
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
