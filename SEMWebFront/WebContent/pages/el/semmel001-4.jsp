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
												<h:outputText value="#{jspMsg['link.electrical']}"></h:outputText>
												<rich:spacer width="40"></rich:spacer>	
												<a4j:commandLink value="#{jspMsg['link.electricInsurance']}" action="#{navAction.navi}"
												 reRender="oppContent,txtNavProgram">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-4DEP" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doInitVerifyELDeposit" />
												</a4j:commandLink>
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
							<h:outputText value="#{jspMsg['label.electrical_payment_info']}" />
						</f:facet>
						
						<rich:dataTable width="98%" id="dtbELPaymentInfo" cellpadding="1" cellspacing="0" border="0"
                            var="elPaymentSP"  reRender="dtbELPaymentInfo" 
                            rows="#{semmel001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            <rich:column styleClass="" 
                                rendered="true">
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
                                    <h:outputText value="#{jspMsg['column.elpayment.elType']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.calEL']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.service']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.oldEL']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.elPlus']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.elTotal']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.elPeriod']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.vat']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.effDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpayment.endDate']}" styleClass="contentform" style="width: 100"/>
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
												<f:param ></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="9">
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
							<h:outputText value="#{jspMsg['header.electricPaymentInfo']}" />
						</f:facet>
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1" >
							
							<h:panelGroup >
							
								<table width="80%" border="0" align="center">
									<tr>
										<td align="right" >
											<h:outputText value="#{jspMsg['column.elpayment.effDate']} : " styleClass="ms7" />
										</td>
										<td colspan="3" >
											<table>
                                    			<tr>
                                    				<td>
					                                    <rich:calendar locale="th" enableManualInput="true" 
					                                       datePattern="dd/MM/yyyy" 
					                                       value=""
					                                       showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                     
					                                       >
					                                    </rich:calendar> 
                                    				</td>
                                    				<td><h:outputText value="#{jspMsg['label.to']} : " styleClass="ms7"/></td>
                                    				<td>
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
                                    		</table>								
										</td>
										
									</tr>
									
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.electricPayType']} : " styleClass="ms7" />
										</td>
										<td>
											<h:inputText disabled="true"></h:inputText>
					                												
										</td>
										<td align="right"  valign="top">
											
										</td>
										<td >
											
										</td>
									</tr>
									
									<tr>
										<td align="right" >
											<h:outputText value="#{jspMsg['label.unitPrice']}" styleClass="ms7" />
										</td>
										<td >
											<h:inputText disabled="true"></h:inputText>
					                		<h:outputText value=" #{jspMsg['label.baht']}"></h:outputText>
					                		<rich:spacer width="40"></rich:spacer>										
										</td>
										<td valign="top" align="right">
											<h:selectBooleanCheckbox></h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.noneUnitPrice']}" styleClass="ms7"  />
											<h:outputText value=" / " styleClass="ms7"  />
											<h:outputText value="#{jspMsg['label.takeAllAmount']}" styleClass="ms7" />
										</td>
										<td align="left">
											<h:inputText ></h:inputText>
											<h:outputText value=" #{jspMsg['label.baht']} / "></h:outputText>
											<h:inputText style="width:50px;"></h:inputText>
					                		<rich:spacer width="3"></rich:spacer>	
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
															
														</h:selectOneRadio>
														<h:selectOneRadio id="rbtVatType2" styleClass="ms7"  
														value="" 
														 disabled="false" rendered="#{!semmel001Bean.renderedVat}">
															<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.includeVat']}" />
															<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.excludeVat']}"/>
															<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.cancelVat']}"/>
															
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
															disabled="" >
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
											<h:outputText value="#{jspMsg['label.payPeriod']}" styleClass="ms7" />
										</td>
										<td colspan="3">	
											<h:panelGrid id="pnlVatType" columns="5">
												<h:panelGroup>
													<h:selectOneRadio id="rbtpayPeriod1" 
													value="#{semmel001Bean.payPeriodType01}"  
		                							styleClass="ms7" rendered="true" layout="lineDirection"
		                							onclick="doChangePreriodType01();"
		                							>
						                			<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.monthly']}" />
						               				 <a4j:jsFunction name="doChangePreriodType01"  
						               				 action="#{semmel001Action.doChangePreriodType}"
						               				 reRender="rbtpayPeriod1,rbtpayPeriod2,rbtpayPeriod3,rbtpayPeriod4,
						               				 rbtpayPeriod5,txtPayPeriodMonth,txtPayPeriodYear,ddlTakeAllPeriodType,pnlElectricUseInfo">
										        	<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
										        	</a4j:jsFunction>
						               				</h:selectOneRadio>
												</h:panelGroup>
												<h:panelGroup>
													<h:selectOneRadio id="rbtpayPeriod2" 
													value="#{semmel001Bean.payPeriodType02}"  
		                							styleClass="ms7" rendered="true" layout="lineDirection"
		                							onclick="doChangePreriodType02();"
		                							>
						                			<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.yearly']}" />
						               				 <a4j:jsFunction name="doChangePreriodType02"  
						               				 action="#{semmel001Action.doChangePreriodType}"
						               				reRender="rbtpayPeriod1,rbtpayPeriod2,rbtpayPeriod3,rbtpayPeriod4,rbtpayPeriod5,
						               				txtPayPeriodMonth,txtPayPeriodYear,ddlTakeAllPeriodType,pnlElectricUseInfo">
										        	<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
										        	</a4j:jsFunction>
						               				</h:selectOneRadio>
												</h:panelGroup>
												
												<h:panelGroup>
												     <table>
					               					<tr>
					               					<td>
													<h:selectOneRadio id="rbtpayPeriod3" 
													value="#{semmel001Bean.payPeriodType03}"  
		                							styleClass="ms7" rendered="true" onclick="doChangePreriodType03();">
						                			<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.per']}" />
						               				 <a4j:jsFunction name="doChangePreriodType03"  
						               				 action="#{semmel001Action.doChangePreriodType}"
						               				reRender="rbtpayPeriod1,rbtpayPeriod2,rbtpayPeriod3,rbtpayPeriod4,
						               				rbtpayPeriod5,txtPayPeriodMonth,txtPayPeriodYear,ddlTakeAllPeriodType,pnlElectricUseInfo">
										        	<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
										        	</a4j:jsFunction>
						               				</h:selectOneRadio>
													</td>
	                								<td>
													<h:inputText id="txtPayPeriodMonth" style="text-align:right" 
													rendered="true" 
													value="#{semmel001Bean.payPeriod03}" size="5" 
													disabled="#{semmel001Bean.disabledPayPeriod03}"
													onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
													onchange="doGetTakeAll();"
													onblur="doGetTakeAll();" >
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
													</h:inputText>
													<rich:spacer width="5"/>
												 	<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7" />
											    </td>
	                							</tr>
	                							</table>
											    </h:panelGroup>
											    
											    <h:panelGroup>
													   <table>
						               						<tr>
						               							<td>
																	<h:selectOneRadio id="rbtpayPeriod4" 
																	value="#{semmel001Bean.payPeriodType04}"  
						                							styleClass="ms7" rendered="true" onclick="doChangePreriodType04();">
										                			<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.per']}" />
										               				 <a4j:jsFunction name="doChangePreriodType04"  
										               				 action="#{semmel001Action.doChangePreriodType}"
										               				reRender="rbtpayPeriod1,rbtpayPeriod2,rbtpayPeriod3,rbtpayPeriod4,rbtpayPeriod5,
										               				txtPayPeriodMonth,txtPayPeriodYear,ddlTakeAllPeriodType,pnlElectricUseInfo">
														        	<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
														        	</a4j:jsFunction>
										               				</h:selectOneRadio>
														</td>
		                								<td>
														<h:inputText id="txtPayPeriodYear" style="text-align:right" 
															rendered="true" 
															value="#{semmel001Bean.payPeriod04}" size="5" 
															disabled="#{semmel001Bean.disabledPayPeriod04}"
															onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
															onchange="doGetTakeAll();"
															onblur="doGetTakeAll();">
														<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="0" />
														</h:inputText>
													 	<rich:spacer width="5"/>
														<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7" />
													 </td>
		                							</tr>
		                							</table>
												
												</h:panelGroup>
											    <h:panelGroup>
												  
													<h:selectOneRadio id="rbtpayPeriod5New" 
													value="#{semmel001Bean.payPeriodType05}"  
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
											<h:outputText value="#{jspMsg['column.elpaymentlist.meterno']} :" styleClass="ms7" style="width: 100"/>
										</td>
					               	  	<td align="left" colspan="3">
											<h:inputText ></h:inputText>
										</td>
	                				</tr>
	                				<tr>
										<td align="right">
										
										</td>
					               	  	<td align="left" colspan="3">
											
										</td>
	                				</tr>
									
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.period']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText disabled="true"></h:inputText>
					                												
										</td>
										<td align="right" width="20%" valign="top">
											
										</td>
										<td width="25%">
											
										</td>
									</tr>
									
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.service']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:selectOneMenu>
												<f:selectItem itemLabel="-- Select --"/>
											</h:selectOneMenu>
											
					                		<h:outputText value=" #{jspMsg['label.calProcess']}"></h:outputText>										
										</td>
										<td align="right" width="20%" valign="top">
											
										</td>
										<td width="25%">
											
										</td>
									</tr>
									
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.paymentperperiod']} : " styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText ></h:inputText>									
										</td>
										<td align="right" width="20%" valign="top">
											<h:outputText value="#{jspMsg['label.paymentperunit']} : " styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText ></h:inputText>
											<rich:spacer width="10"></rich:spacer>
											<h:commandButton styleClass="rich-button" value="#{jspMsg['btn.cal']}"></h:commandButton>
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
					
					
					<rich:panel id="pnlElectricPaymentList">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.electrical_payment_list']}" />
						</f:facet>
						
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
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.meterno']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.electricPayType']}" styleClass="contentform" style="width: 100"/>
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
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.period']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.vat']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.service']}" styleClass="contentform" style="width: 100"/>
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
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.effectivedt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.endperioddt']}" styleClass="contentform" style="width: 100"/>
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
					
					<rich:panel id="pnlElChangeCondHist">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.el_change_con_hist']}" />
						</f:facet>
						
						<rich:dataTable width="98%" id="dtbELChangeCondHist" cellpadding="1" cellspacing="0" border="0"
                            var="elCCHist"  reRender="dtbELChangeCondHist" 
                            rows="#{semmel001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            
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
                                    <h:outputText value="#{jspMsg['label.electricPayType']}" styleClass="contentform" style="width: 100"/>
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
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.period']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.vat']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.service']}" styleClass="contentform" style="width: 100"/>
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
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.effectivedt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText  styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.elpaymentlist.endperioddt']}" styleClass="contentform" style="width: 100"/>
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
										<rich:column colspan="9">
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

	

