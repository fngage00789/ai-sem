<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:loadBundle basename="resources.el.semmel001-2" var="jspMsg" />
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<h:panelGrid width="100%">

	<rich:panel id="pnlReceiveJob">

		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<h:panelGrid columnClasses="gridContent" width="90%">

			<a4j:form id="frmReceiveJob">

				<!-- begin content layout -->

				<h:panelGrid width="100%">

					<h:panelGroup>

						<table width="100%">
							<tr>
								<td width="50%" align="left">
									<table id="tblMessage">
										<tr>
											<td>
												<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
												<h:message errorClass="ms7red" for="dtNewReceiveDt" />
												<h:message errorClass="ms7red" for="dtTerminateReceivedDt" />
											</td>
										</tr>
									</table>
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td>
												<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
													<a4j:actionparam name="page" value="2" />
												</a4j:commandButton>
											</td>
											<td>
												<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
													<a4j:actionparam name="page" value="2" />
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
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.company}" styleClass="ms7" />
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
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.oldContractNo}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.siteName}" styleClass="ms7" />
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.locationId}" styleClass="ms7" />
										</td>
										
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.locationStatus}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.firstEffectiveDt']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.firstEffectiveDtStr}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.effectiveDt']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.effectDtStr}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.expireDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.expireDtStr}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.contractStatus}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.processStatus']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.processStatusName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.receiveDtStr}" styleClass="ms7" />
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlElectricUseInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.electricUseInfo']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteAddress']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.eAreaCode}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.elJob']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.effectDtStr}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" /> 
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectOneMenu id="dstElectricUseType" value="#{semmel001Bean.wrapper.electricManageSP.electricUseType}" disabled="#{semmel001Bean.wrapper.electricUseTypeSelectDisable}" style="width : 120px">
			                					<f:selectItems value="#{semmel001Bean.electricUseTypeList2}" />
			                					<a4j:support event="onchange" action="#{semmel001Action.doChangeElectricUseType2}" reRender="pnlCoverageInfo" />
			                				</h:selectOneMenu>
			                				<rich:spacer width="5"/>
										</td>
										<td align="right" width="20%">
											<rich:spacer width="1"/>
										</td>
										<td width="30%">
											<h:selectBooleanCheckbox title="chkTransferFlag" value="#{semmel001Bean.wrapper.electricManageSP.transferFlagBoolean}" disabled="#{semmel001Bean.wrapper.transferFlagCheckboxDisable}"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.transferFlag']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.wrapper.newReceivedDtCalendarMandatory}"/> 
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.newReceivedDt']}" styleClass="ms7" />
										</td>
										<td width="25%">
											
											<rich:calendar id="dtNewReceiveDt" locale="th" enableManualInput="true" 
										  	datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.receivedDt']}"
										   	value="#{semmel001Bean.wrapper.electricManageSP.newReceivedDt}"
										   	showWeeksBar="false"
										   	inputSize="10"
										   	oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   	cellWidth="15px" cellHeight="20px"
									   	   	styleClass="ms7"
									   	   	disabled="#{semmel001Bean.wrapper.newReceivedDtCalendarDisable}">
											</rich:calendar>
											<rich:spacer width="5"/>
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.wrapper.terminateReceivedDtCalendarMandatory}"/> 
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.terminateReceivedDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="dtTerminateReceivedDt" locale="th" enableManualInput="true" 
										  	datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cancelDt']}"
										   	value="#{semmel001Bean.wrapper.electricManageSP.terminateReceivedDt}"
										   	showWeeksBar="false"
										   	inputSize="10"
										   	oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   	cellWidth="15px" cellHeight="20px"
									   	   	styleClass="ms7"
									   	   	disabled="#{semmel001Bean.wrapper.terminateReceivedDtCalendarDisable}">
											</rich:calendar>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="pnlCoverageInfo">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.coverageInfo']}" />
							<rich:spacer width="2" />
							<a4j:commandButton id="btnBGDetail" styleClass="rich-button" value="#{jspMsg['btn.bgDetail']}" action="#{navAction.navi}">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doInitBGDetail" />
							</a4j:commandButton>
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="left" colspan="4">
											<h:outputText value="#{jspMsg['label.bgRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7" />
										</td>
										<td width="75%" colspan="3">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.bgNo}" styleClass="ms7" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.full']}" rendered="#{semmel001Bean.wrapper.bgNoFullVisible}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.coverageMoney']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.bgAmt}" styleClass="ms7">
												<f:convertNumber type="currency"  currencySymbol=""/>
											</h:outputText>
											<rich:spacer width="3"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.bankNameLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.startDate']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.bgStartDtLabel}" styleClass="ms7"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.endDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.bgEndDtLabel}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalSite']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.totalSiteBg}" styleClass="ms7" >
												<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalRemainSite']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMasterSP.totalSiteRemain}" styleClass="ms7">
												<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					
					<rich:panel id="pnlLog">
					
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.createBy}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.createDt}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManageSP.updateBy}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.updateDt}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
											</h:outputText>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
				</h:panelGrid>
				
			</a4j:form>
			
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>

