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
												<a4j:commandLink value="#{jspMsg['link.electricInsurance']}" action="#{navAction.navi}"
												reRender="oppContent,txtNavProgram">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-4DEP" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doInitVerifyELDeposit" />
												</a4j:commandLink>
												<rich:spacer width="40"></rich:spacer>	
												
												<h:outputText value="#{jspMsg['link.checkElectricPeriod']}"></h:outputText>
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
							<h:outputText value="#{jspMsg['label.el_payment_list_info']}" />
						</f:facet>
						
						<table>
							<tr>
								<td align="right" width="25%">
											
								</td>
								<td width="25%">
									<h:selectOneMenu>
										<f:selectItem itemLabel="-- Select --"/>
									</h:selectOneMenu>
								</td>
								<td align="right" width="20%">
										
								</td>
								<td width="30%">
											
								</td>
							</tr>
						</table>
						
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
	                                    <h:outputText value="Period" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.el_payment_type']}" styleClass="contentform" style="width: 100"/>
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
	                                    <h:outputText value="Period" styleClass="contentform" style="width: 100"/>
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
	                                    <h:outputText value="#{jspMsg['column.perUnit']}" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="EXG Amt" styleClass="contentform" style="width: 100"/>
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
	                                    <h:outputText value="WHT" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="INC Amt" styleClass="contentform" style="width: 100"/>
	                                </f:facet>
	                                <div align="center">
	                                    <h:outputText  styleClass="contentform"  />
	                                </div>
	                            </rich:column>
	                            <rich:column >
	                                <f:facet name="header">
	                                    <h:outputText value="#{jspMsg['column.elpaymentstatus']}" styleClass="contentform" style="width: 100"/>
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
											<rich:column colspan="13">
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

