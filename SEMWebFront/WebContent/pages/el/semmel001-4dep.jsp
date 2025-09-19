<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<f:loadBundle basename="resources.el.semmel001-4" var="jspMsg" />
<h:panelGrid width="100%">

	<rich:panel id="pnlVerifyPrivateJob">

		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<h:panelGrid columnClasses="gridContent" width="98%">

			<a4j:form id="frmVerifyPrivateJob">

				<!-- begin content layout -->

				<h:panelGrid width="100%">

					<h:panelGroup>

						<table width="100%">
							<tr>
								<td width="50%" align="left">
									<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
								</td>
								<td width="50%" align="right" valign="baseline">
									
								</td>
							</tr>
							<tr>
								<td width="50%" align="left">
									<table>
										<tr>
											<td>
												<rich:spacer width="30"></rich:spacer>	
												<a4j:commandLink value="#{jspMsg['link.electrical']}" action="#{navAction.navi}"
												reRender="oppContent,txtNavProgram">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-4" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doInitVerifyEL" />
												</a4j:commandLink>
												<rich:spacer width="40"></rich:spacer>	
												
												<h:outputText value="#{jspMsg['link.electricInsurance']}"></h:outputText>
												<rich:spacer width="40"></rich:spacer>	
												<a4j:commandLink value="#{jspMsg['link.checkElectricPeriod']}" action="#{navAction.navi}"
												reRender="oppContent,txtNavProgram">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-4CPD" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doInitCheckELPayment" />
												</a4j:commandLink>
											</td>
										</tr>
									</table>
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td>
												<a4j:commandButton id="btnVerify" value="#{jspMsg['btn.verify']}" styleClass="rich-button" action="#{navAction.navi}" 
												reRender="oppContent" immediate="true">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doVerify" />
												</a4j:commandButton>
											</td>
											<td>
												<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" immediate="true">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
													<a4j:actionparam name="page" value="4" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						
					</h:panelGroup>
					
					<rich:panel id="pnlContractInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractInfo']}" />
						</f:facet>
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.company}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.oldContractNo}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.regionLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.siteName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.locationId}" styleClass="ms7" />
											
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.locationCode}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="Location Status : " styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.firstEffDate']} : " styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
										</td>
										<td width="30%">
											
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.effDate']} : " styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.endDate']} : " styleClass="ms7" />
											
										</td>
										<td width="30%">
											<h:outputText value="" styleClass="ms7" />
											<rich:spacer width="50"> </rich:spacer>
											<h:selectBooleanCheckbox label=""></h:selectBooleanCheckbox>
											<rich:spacer width="10"> </rich:spacer>
											<h:outputText value="#{jspMsg['label.noneEndDate']} : " styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="Contract Status : " styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											
										</td>
										<td width="30%">
											
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.flowStatus']} : " styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText></h:outputText>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.proceedDate']} : " styleClass="ms7" />
										</td>
										<td width="30%">
											
										</td>
									</tr>
																																																
									
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlElectricPaymentInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.el_insu_pm_info']}" />
						</f:facet>
						
						<rich:dataTable width="98%" id="dtbELPaymentInfo" cellpadding="1" cellspacing="0" border="0"
                            var="elPaymentSP"  reRender="dtbELPaymentInfo" 
                            rows="#{semmel001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            <rich:column rendered="true">
                                <f:facet name="header">
                               
                                </f:facet>
                                <div align="center">
                                    <h:selectBooleanCheckbox id="siteAcqSelected" 
                                        rendered="true">
                                        <a4j:support event="onclick" 
                                        reRender="btnApprove, clearBatchNo, btnExport, btnNew, dtbSiteInfo, popupRequestType, btnReassign">
                                        <a4j:actionparam name="rowId" />
                                    </a4j:support>
                                    </h:selectBooleanCheckbox>
                                </div>
                            </rich:column>
                        
                        	<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.insuType']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.remark']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.bg']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.wht']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.vat']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.effdate']}" styleClass="contentform" />
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.totalinsuAmt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.status']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elinsupay.balance']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <!-- data -->
                            
                            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
											
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="6">
												<rich:datascroller immediate="true" rendered="true" align="left" 
													maxPages="#{semmel001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													style="background-color: #cccccc;"
													page="#{semmel001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender=""></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->	
						</rich:dataTable>
					</rich:panel>
					
					<rich:panel id="pnlElectricPaymentDetail">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.el_insu_detail']}" />
						</f:facet>
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%" border="0">
									<tr>
										<td colspan="3">
										
										</td>
										<td>
											
											<h:commandButton styleClass="rich-button" value="#{jspMsg['btn.bgrequest']}"></h:commandButton>
											<rich:spacer width="10"></rich:spacer>
											<h:commandButton styleClass="rich-button" value="#{jspMsg['btn.returndeposit']}"></h:commandButton>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%" >
											<h:outputText value="#{jspMsg['label.eldepreqtype']} : " styleClass="ms7" />
										</td>
										<td width="40%" >
											<h:inputText disabled="true">  </h:inputText>							
										</td>
										<td align="right" width="15%" >
											<h:outputText value="#{jspMsg['label.eldeptype']} : " styleClass="ms7" />
										</td>
										<td width="40%" >
											<h:inputText disabled="true"></h:inputText>							
										</td>
										
									</tr>
									<tr>
										<td align="right" width="15%" >
											<h:outputText value="#{jspMsg['label.startperioddt']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<rich:calendar locale="th" enableManualInput="true" 
					                        	datePattern="dd/MM/yyyy" 
					                            value=""
					                            showWeeksBar="false" 
					                            inputSize="13" 
					                            oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                            cellWidth="20px" cellHeight="20px">
											</rich:calendar> 
										</td>
										<td align="right" width="15%" >
											<h:outputText value="#{jspMsg['label.endperioddt']} : " styleClass="ms7"/>
										</td>
										<td width="40%">
											<rich:calendar locale="th" enableManualInput="true" 
					                                       datePattern="dd/MM/yyyy" 
					                                       value=""
					                                       showWeeksBar="false"
					                                       inputSize="13"
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateTo','cldEffDateFrom');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateTo','cldEffDateFrom');"
					                                       label="#{jspMsg003['column.header.effDate']}">
				                                		</rich:calendar>
										</td>
										
									</tr>
									<tr>
										<td align="right" width="15%" >
											<h:outputText value="#{jspMsg['column.elpaymentlist.meterno']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:selectOneMenu>
												<f:selectItem itemLabel=" All Meter "/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="15%" >
											
										</td>
										<td width="40%">
											
										</td>
										
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['column.elpaymentlist.paymentAmt']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText></h:inputText>
					                												
										</td>
										<td align="right" width="20%" valign="top">
											<h:outputText value="#{jspMsg['column.elinsupay.bg']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText ></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" valign="middle">
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7" />
										</td>
										<td colspan="3" valign="top">
											<table width="100%">
												<tr>
													<td width="40%" valign="top">
														<h:selectOneRadio id="rbtVatType" styleClass="ms7" 
														value="" 
												 		disabled="#{semmel001Bean.disableVat}" rendered="#{semmel001Bean.renderedVat}">
															<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.includeVat']}" />
															<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.excludeVat']}"/>
															<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.cancelVat']}"/>
															<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.noVat']}" />
															<a4j:support event="onclick" 
								                			action="#{semmel001Action.doChangeVat}" 
								                			reRender="pnlElectricUseInfo,rbtVatType,txtVatAmt"/> 
														</h:selectOneRadio>
														<h:selectOneRadio id="rbtVatType2" styleClass="ms7"  
														value="" 
														 disabled="false" rendered="#{!semmel001Bean.renderedVat}">
															<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.includeVat']}" />
															<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.excludeVat']}"/>
															<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.cancelVat']}"/>
															<a4j:support event="onclick" 
								                			action="#{semmel001Action.doChangeVat}" 
								                			reRender="pnlElectricUseInfo,rbtVatType2,txtVatAmt"/> 
														</h:selectOneRadio>
													</td>
													<td valign="top" width="20%" align="right">
														<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7" />
													</td> 
													<td valign="top">
														<h:inputText id="txtVatAmt" style="text-align:right" 
															rendered="true" 
															onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
															onblur="return numberformat.moneyFormat(this);"
															onfocus="return numberformat.setCursorPosToEnd(this);"
															value="" size="5" 
															disabled="#{semmel001Bean.elUseSp.pVatType eq '03' or semmel001Bean.elUseSp.pVatType eq '04'}" >
															<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
														</h:inputText>
														<h:outputText value="%" styleClass="ms7" />
													</td>
												</tr>
											</table>
										</td>
											
									</tr>
										
									<tr>
										
										<td align="right">
											<h:outputText value="Wth : " styleClass="ms7" />
										</td>
										<td colspan="3">	
											<h:panelGrid id="pnlVatType" columns="5">
												<h:panelGroup>
													<h:selectOneRadio id="rbtpayPeriod1" 
													value=""  
		                							styleClass="ms7" rendered="true" layout="lineDirection">
						                			<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.incwht']}" />
						               				 
						               				</h:selectOneRadio>
												</h:panelGroup>
												<h:panelGroup>
													<h:selectOneRadio id="rbtpayPeriod2" 
													value=""  
		                							styleClass="ms7" rendered="true" layout="lineDirection">
						                			<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.notincwht']}" />
						               				 
						               				</h:selectOneRadio>
												</h:panelGroup>
												
												<h:panelGroup>
												     <table>
					               					<tr>
					               					<td>
													<h:selectOneRadio id="rbtpayPeriod3" 
													value=""  
		                							styleClass="ms7" rendered="true" >
						                			<f:selectItem itemValue="03" itemLabel="#{jspMsg['btn.nowht']}" />
						               				 
						               				</h:selectOneRadio>
												</td>
	                							<td>
													
											    </td>
	                							</tr>
	                							</table>
											    </h:panelGroup>
											    
											    <h:panelGroup>
													
												
												</h:panelGroup>
											    <h:panelGroup>
												  
													<h:selectOneRadio id="rbtpayPeriod5New" 
													value=""  
		                							styleClass="ms7" rendered="true" onclick="doChangePreriodType05();">
						                			
						                				<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.oneTime']}" />
						               					
						               					<a4j:jsFunction name="doChangePreriodType05New"  
						               				 		action="#{semmel001Action.doChangePreriodType}"
						               						reRender="rbtpayPeriod1,rbtpayPeriod2,rbtpayPeriod3,rbtpayPeriod4,rbtpayPeriod5,
						               						txtPayPeriodMonth,txtPayPeriodYear,ddlTakeAllPeriodType,cldtest,txtAreaRemark,pnlElectricUseInfo">
										            
										            		<a4j:actionparam  name="payPeriodTypeNew" value="05"></a4j:actionparam>
										        	
										        		</a4j:jsFunction>
										        	
											        	<a4j:jsFunction name="doChangePreriodType10New" action="#{semmel001Action.doChangeData}"
							               				reRender="effectDTFrom,effectDTTo">
											            	<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
											        	</a4j:jsFunction>
						               				
						               				</h:selectOneRadio>
											    </h:panelGroup>
											</h:panelGrid>
										</td>
									        
									</tr>
									
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.service']}" styleClass="ms7" rendered="true"/>
										</td>
					               	  	<td align="left" colspan="3">
											<h:selectOneMenu>
												<f:selectItem itemLabel="-- Select --"/>
											</h:selectOneMenu>
											<h:outputText value=" #{jspMsg['label.calProcess']}"></h:outputText>	
										</td>
	                				</tr>
									
									<tr>
										<td align="right" width="15%">
											<h:outputText value="Vendor : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText ></h:inputText>
											<rich:spacer width="10"></rich:spacer>
											<h:commandButton styleClass="rich-button" value="..."></h:commandButton>									
										</td>
										<td align="right" width="20%" valign="top">
											
										</td>
										<td width="25%">
											
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.receiver']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText ></h:inputText>
											<rich:spacer width="10"></rich:spacer>								
										</td>
										<td align="right" width="20%" valign="top">
											
										</td>
										<td width="25%">
											
										</td>
									</tr>
									
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.accountno']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText ></h:inputText>
											<rich:spacer width="10"></rich:spacer>								
										</td>
										<td align="right" width="20%" valign="top">
											<h:outputText value="#{jspMsg['label.bank']} : " styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText ></h:inputText>
											<rich:spacer width="10"></rich:spacer>			
										</td>
									</tr>
									<tr>
										<td align="right" width="15%" valign="top">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:inputTextarea style="width:100%;" rows="5"></h:inputTextarea>						
										</td>
										
									</tr>
									
									<tr>
										<td></td>
										<td align="left" colspan="3">
											<h:commandButton styleClass="rich-button" value="Add"></h:commandButton>
											<rich:spacer width="10"></rich:spacer>
											<h:commandButton styleClass="rich-button" value="Cancel"></h:commandButton>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					
					
					<rich:panel id="pnlElectricPaymentList" >
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.elDeposit_payment_list']}" />
						</f:facet>
						
						<h:panelGrid  width="90%">
                    		<rich:panel id="pnlSearchResult" style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
                    			<rich:dataTable width="98%" id="dtbELPaymentList" cellpadding="1" cellspacing="0" border="0"
	                            var="elPaymentSP"  reRender="dtbELPaymentList" 
	                            rows="#{semmel001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
	                            
	                            <rich:column rendered="true">
	                                <f:facet name="header">
	                               
	                                </f:facet>
	                                <div align="center">
	                                    <a4j:commandButton id="btnEdit"  action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
			                            reRender="oppContent" rendered="#{siteAcqSP.dataObj.can_edit == 'Y'}">
			                                <a4j:actionparam name="navModule" value="sa" />
			                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
			                                                    
			                                <a4j:actionparam name="moduleWithNavi" value="sa" />
			                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
			                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
			                            </a4j:commandButton>
	                                </div>
	                            </rich:column>
	                            
	                            <rich:column rendered="true">
	                                <f:facet name="header">
	                               
	                                </f:facet>
	                                <div align="center">
	                                    <a4j:commandButton id="btnDelete"  action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
			                            reRender="oppContent" rendered="#{siteAcqSP.dataObj.can_edit == 'Y'}">
			                                <a4j:actionparam name="navModule" value="sa" />
			                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
			                                                    
			                                <a4j:actionparam name="moduleWithNavi" value="sa" />
			                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
			                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
			                            </a4j:commandButton>
	                                </div>
	                            </rich:column>
	                        
	                        	<rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.eldeptype']}" styleClass="ms7" />
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.elpaymentlist.meterno']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText  styleClass="contentform"  />
		                                </div>
		                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.service']}" styleClass="ms7" />
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.elpaymentlist.Vendor']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.elpaymentlist.receiver']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.elinsupay.bg']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.elpaymentlist.paymentAmt']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="Wth" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.startperioddt']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['label.endperioddt']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.depositstatus']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                     <h:outputText value="#{jspMsg['column.elpayment.remark']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <!-- data -->
	                            
	                            <!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="11">
													<rich:datascroller immediate="true" rendered="true" align="left" 
														maxPages="#{semmel001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														style="background-color: #cccccc;"
														page="#{semmel001Bean.scrollerPage}">
													<a4j:support event="onclick"  reRender="dtbELPaymentList"></a4j:support>
													</rich:datascroller>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
									<!-- footer -->	
								</rich:dataTable>
                    		</rich:panel>
                    	</h:panelGrid>
						
						
					</rich:panel>
					
				</h:panelGrid>
					
			</a4j:form>
			
		</h:panelGrid>
		
		
		<h:panelGrid  id="pnlLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
			<h:panelGroup >
							<table width="100%">
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtCreateBy" value="" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<rich:calendar id="cldCreateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
									</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtUpdateBy" value="" 
		                			readonly="true" disabled="true" size="30" maxlength="50"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			  <rich:calendar id="cldUpdateDate" locale="th" 
									 datePattern="dd/MM/yyyy HH:mm:ss" 
									 value="" 
									 showWeeksBar="false"
									 inputSize="20" 
								     cellWidth="20px" cellHeight="20px" 
								     buttonIcon="/images/hide-button.png"
								     buttonIconDisabled="/images/hide-button.png"
									 disabled="true"/>
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
	</rich:panel>
	
</h:panelGrid>

