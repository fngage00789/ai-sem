<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel014" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlEl">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmVerify']}" /></f:facet>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmElVerify">
				<h:panelGrid width="100%">
				
					<!-- Tab and button Panel -->
					<h:panelGroup>
						<table width="100%" style="border: 1px">
							<tr>
								<td >
									<table id="menuLink" width="100%">
										<tr>
											<h:panelGroup >
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.el']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="initVerify" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
													</a4j:commandLink>
												</td>
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.bail']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="initBail" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
													</a4j:commandLink>
												</td>
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.checkPremium']}" style="font-size:12px;">
													</a4j:commandLink>
												</td>
												<td width="74%" align="right">
													<a4j:commandButton id="btnVerify" value="#{jspMsg['btn.verify']}" styleClass="rich-button" 
													action="#{navAction.navi}" reRender="oppContent">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-3" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="doELPrivateVerify" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
														<a4j:actionparam name="pageNo" value="3"/>
													</a4j:commandButton>
													<rich:spacer width="5"></rich:spacer>
													<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
														action="#{navAction.navi}" reRender="oppContent">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
														<a4j:actionparam name="methodWithNavi" value="doCancel" />
														<a4j:actionparam name="page" value="13" />
													</a4j:commandButton>
												</td>
											</h:panelGroup>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					
					<!-- Contract Panel -->
					<rich:panel id="pnlContract">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractDetail']}"/>
						</f:facet>
						
						<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.company}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.previousContractId']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.oldContractNo}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractId']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.region}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.siteName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.locationId}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationCode']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.locationCode}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationStatus']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.locationStatus}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.firstEffectiveDt']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.firstEffectiveDtStr}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.effectiveDt']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.effectiveDtStr}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.expireDt']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.expireDtStr}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractStatus']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.siteStatusName}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.processStatus']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.processStatusName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.actionDt']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.actionDtStr}" styleClass="ms7" />
										</td>
					                </tr>
					             </table>
				         	</h:panelGroup>
				         </h:panelGrid>
					</rich:panel>
					
					<!-- Expenses Panel -->
					<rich:panel id="pnlExpensePeriod" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expensePeriod']}"/>
						</f:facet> 
						
						<h:panelGrid width="97%" border="0" cellpadding="3" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
						                <td align="left" width="25%">
											<h:selectOneMenu  id="ddlExpenseType" value="#{semmel014Bean.verifySP.meterId}"   immediate="true" onchange="checkMeterIdFormDD();">
												<f:selectItems id="ddmeterId"  value="#{semmel014Bean.meterList}" />	
											</h:selectOneMenu>
											<a4j:jsFunction  name="checkMeterIdFormDD" action="#{semmel014Action.checkMeterIdFormDD}" reRender="pnlExpensePeriod"/>
											
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						
						
						<rich:dataTable id="dtbExpensePeriod" width="100%" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel014Bean.dpstCondList}"
								rows="#{semmel014Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								

									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.expenseType']}" />
										</f:facet>
										
										<div align="left">
											<h:outputText value="#{wrapper.verifyCondSP.pElectricPayType}" />
										</div>
											
									</rich:column>
									
									<rich:column >
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.edit']}" styleClass="contentform"/>
										</f:facet>
										<div align="center">
											<a4j:commandButton id="btnInitEdit" image="images/edit.png" style="height: 15; width: 15;" 
											oncomplete="#{rich:component('popupEditPeriod')}.show(); return false"
											 action="#{navAction.navi}" reRender="popupEditPeriod" >
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL014-3" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
												<a4j:actionparam name="methodWithNavi" value="initEditPeriod" />	
												<a4j:actionparam name="paymentId" value="#{wrapper.verifyCondSP.paymentId}"/>
												<a4j:actionparam name="termOfPaymentDt" value="#{wrapper.verifyCondSP.termOfPaymentDtStr}"/>
												<a4j:actionparam name="fromTermOfPaymentDt" value="#{wrapper.verifyCondSP.fromTermOfPaymentDtStr}"/>
												<a4j:actionparam name="toTermOfPaymentDt" value="#{wrapper.verifyCondSP.toTermOfPaymentDtStr}"/>
												<a4j:actionparam name="meterId" value="#{wrapper.verifyCondSP.meterId}"/>
												<a4j:actionparam name="periodNoStart" value="#{wrapper.verifyCondSP.periodNo}"/>
												
											</a4j:commandButton>
										</div>
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.period']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.periodNo}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.meterNo']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.meterId}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.service']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.service}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.tfpd']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.termOfPaymentDt}" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.periodStartDt']}" 
											
											/>
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.fromTermOfPaymentDt}" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.periodEndDt']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.toTermOfPaymentDt}" >
											<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.vendor']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.vendorName}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.payeeName']}" />
										</f:facet>
										
										<div align="right">
											<h:outputText value="#{wrapper.verifyCondSP.payeeName}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.pkwh']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.pKwh}" />
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.lkwh']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.lKwh}" />
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.totalkwh']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.totalKwh}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.unitPrice']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.pUnitPrice}" />
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.excAmt']}" />
										</f:facet>
										
										<div align="right">
											<h:outputText value="#{wrapper.verifyCondSP.excludeVatAmt}" >
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
											</h:outputText>
										</div>
											
									</rich:column>	
									

									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.vat']} Amt" />
										</f:facet>
										
										<div align="right">
											<h:outputText value="#{wrapper.verifyCondSP.vatAmt}" >
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
											</h:outputText>
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.IncAmt']}" />
										</f:facet>
										
										<div align="right">
											<h:outputText value="#{wrapper.verifyCondSP.includeVatAmt}" >
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
											</h:outputText>
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.paymentStatusDesc']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.paymentStatusDesc}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.remark']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.remark}" />
										</div>
											
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmel014Bean.dpstCondList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<rich:column colspan="18">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbExpensePeriod"
													maxPages="#{semmel014Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dstVerExpenses" 
													style="background-color: #cccccc;"
													page="#{semmel014Bean.scrollerPage}" 
												/>
											</rich:column>
										</rich:columnGroup>
									</f:facet>	
									
						</rich:dataTable>
						
					</rich:panel>
					
					<rich:panel id="pnlLog">
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
		                				<h:inputText id="txtCreateBy" value="#{semmel014Bean.verMaster.createBy}" 
		                					readonly="true" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldCreateDate" locale="th" 
											datePattern="dd/MM/yyyy HH:mm:ss" 
										    value="#{semmel014Bean.verMaster.createDt}"
										    inputSize="20" 
										    cellWidth="20px" cellHeight="20px" 
										    buttonIcon="/images/hide-button.png"
										    buttonIconDisabled="/images/hide-button.png"
										    disabled="true" />
									</td>
			                	 </tr><tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
			                			<h:inputText id="txtUpdateBy" value="#{semmel014Bean.verMaster.updateBy}" 
			                				readonly="true" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldUpdateDate" locale="th" 
											datePattern="dd/MM/yyyy HH:mm:ss" 
										    value="#{semmel014Bean.verMaster.updateDt}"
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
			</a4j:form>
			
			<jsp:include page="../../pages/el/semmel014-popupEditPeriodNo.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<!-- Dialog -->

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmrt001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="pnlDepositDtl,pnlAddDetail" >
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL014-2" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDpst" />							
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>