<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel001-13" var="jspMsg" />
<h:panelGrid width="100%">

	<rich:panel id="pnlUpdateMeterInfo">

		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<h:panelGrid columnClasses="gridContent" width="90%">
		
			<a4j:form id="frmUpdateMeterInfo">
			
				<h:panelGrid columnClasses="gridContent" width="100%">
				
					<h:panelGroup>
					
						<table width="100%">
							<tr>
								<td width="50%" align="left">
									<h:panelGrid id="frmError">
										<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
									</h:panelGrid>
								</td>
								<td align="right">
									<table>
										<tr>
											<td>
												<a4j:commandButton id="btnBack" value="Back"
													styleClass="rich-button" action="#{navAction.navi}"
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doBack7" />
													<a4j:actionparam name="page" value="13" />
												</a4j:commandButton>
											</td>
											<td>
												<a4j:commandButton id="btnSave" value="Save"
													styleClass="rich-button" action="#{navAction.navi}"
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-7" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
													<a4j:actionparam name="page" value="13" />
												</a4j:commandButton>
											</td>
											<td></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						
					</h:panelGroup>
					
					<!-- contract detail info -->
					<rich:panel id="contractInfo">
						
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractInfo']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.company }" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.previousContractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.oldContractNo }" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
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
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.siteName }" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.siteStatusLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.locationId }" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.locationCode }" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricUseTypeLabel}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processStatusName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.processStatusName}" styleClass="ms7" />
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
		
					<!-- document info 1 -->
					<h:panelGroup>
					
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td width="50%">
									<rich:panel id="pnlApprove">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.approve']}" />
										</f:facet>
									
										<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								
											<h:panelGroup>
											
												<table width="100%" height="70px">
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.newRecieveDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<h:outputText value="#{semmel001Bean.wrapper.newReceivedDtLabel}" styleClass="ms7"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.newPrintDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<h:outputText value="#{semmel001Bean.wrapper.newPrintDtLabel}" styleClass="ms7"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<rich:spacer width="5" />
														</td>
														<td width="60%" align="left">
															<rich:spacer width="5" />
														</td>
													</tr>
												</table>
												
											</h:panelGroup>
											
										</h:panelGrid>
										
									</rich:panel>
								</td>
								<td style="width: 5px"></td>
								<td>
									<rich:panel id="pnlCancel">
							
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.cancel']}" />
										</f:facet>
										
										<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								
											<h:panelGroup>
											
												<table width="100%"  height="70px">
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.terminateReceivedDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<h:outputText value="#{semmel001Bean.wrapper.terminatedReceivedDtLabel}" styleClass="ms7" />
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.terminatePrintDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<h:outputText value="#{semmel001Bean.wrapper.terminatePrintDtLabel}" styleClass="ms7" />
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.terminateCutoffDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="false"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.terminateCutoffDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
														</td>
													</tr>
												</table>
										
										</h:panelGroup>
									
									</h:panelGrid>
										
									</rich:panel>
								</td>
							</tr>
						</table>
						
					</h:panelGroup>
					
					<!-- document info 2 -->
					<h:panelGroup>
						
						<table width="100%" cellpadding="0" cellspacing="0" border="0">
							<tr>
								<td width="50%">
								
									<rich:panel id="pnlExpand">
									
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.expand']}" />
										</f:facet>
										
										<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								
											<h:panelGroup>
											
												<table width="100%" height="100px" border="0">
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandReceivedDt']}" styleClass="ms7" />
														</td>
														<td width="60%">
															<h:outputText value="#{semmel001Bean.wrapper.expandReceivedDtLabel}" styleClass="ms7"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandPrintDt']}" styleClass="ms7"/>
														</td>
														<td width="60%">
															<h:outputLabel value="#{semmel001Bean.wrapper.expandPrintDtLabel}" styleClass="ms7"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandOldCutoffDT']}" styleClass="ms7" />
														</td>
														<td width="60%">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="false"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandOldCutoffDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandNewOnmeterDt']}" styleClass="ms7" />
														</td>
														<td width="60%">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="false"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandNewOnmeterDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
														</td>
													</tr>
												</table>
												
											</h:panelGroup>
										
										</h:panelGrid>
										
									</rich:panel>
									
								</td>
								<td style="width: 5px"></td>
								<td>
								
									<rich:panel id="pnlTransfer">
										
										<f:facet name="header">
											<h:outputText value="#{jspMsg['header.transfer']}" />
										</f:facet>
										
										<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								
											<h:panelGroup>
										
												<table width="100%" height="100px" border="0">
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferReceivedDt']}" styleClass="ms7" />
														</td>
														<td>
															<h:outputText value="#{semmel001Bean.wrapper.transferReceivedDtLabel}" styleClass="ms7"/>
														</td>
														<td width="30%">
															<h:selectBooleanCheckbox value="#{semmel001Bean.wrapper.electricManage.transferFlagBoolean}" disabled="true" styleClass="ms7" /> 
															<h:outputText value="#{jspMsg['label.transferFlagCheck']}" styleClass="ms7" />
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferPrintDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<h:outputText value="#{semmel001Bean.wrapper.transferPrintDtLabel}" styleClass="ms7" />
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferMeterDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="false"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferMeterDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferCutoffDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="false"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferCutoffDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
														</td>
													</tr>
												</table>
												
											</h:panelGroup>
											
										</h:panelGrid>
											
									</rich:panel>
									
								</td>
							</tr>
						</table>
						
					</h:panelGroup>
					
					<!-- MWA/PEA meter management -->
					<rich:panel id="pnlmeterInfoPEA">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.MeterInfoMEA']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
							
								<table width="100%" border="0" >
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eAreaCode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eAreaCode }" disabled="#{semmel001Bean.wrapper.disableMeaPea }"/>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eAreaName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eAreaName }" disabled="#{semmel001Bean.wrapper.disableMeaPea }"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disableMeaPea}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disableMeaPea}"/>
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.meterId}" disabled="#{semmel001Bean.wrapper.disableMeaPea}"/>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterRate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterRate}" style="width:160px" disabled="#{semmel001Bean.wrapper.disableMeaPea}">
												<f:selectItems value="#{semmel001Bean.elMeterTypeList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterSize']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterSize}" disabled="#{semmel001Bean.wrapper.disableMeaPea}"/>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterWire']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterWire }" disabled="#{semmel001Bean.wrapper.disableMeaPea}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disableMeaPea}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disableMeaPea}"/>
											<h:outputText value="#{jspMsg['label.eOnMeterDt']}" styleClass="ms7" />
										</td>
										<td>
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eOnMeterDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disableMeaPea}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eOneBillDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.meterInfoMeaPea.eOneBillDtLabel}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerLabel']}" styleClass="ms7" />
										</td>
										
										<td >
											<h:panelGrid columns="2"> 
											<h:inputText size="18" maxlength="15" style="width: 160px"  value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerLabel }" disabled="#{semmel001Bean.wrapper.disableMeaPea}"/>
											
											<h:selectOneRadio id="rbteTransformer" layout="lineDirection" 
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerType}" 
												styleClass="ms7"
												disabled="true">
												<f:selectItem itemValue="HV" itemLabel="High Volt" />
												<f:selectItem itemValue="LV" itemLabel="Low Volt" />
											</h:selectOneRadio>											
											</h:panelGrid>
										

										</td>
										
										
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerSize']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerSize }" disabled="#{semmel001Bean.wrapper.disableMeaPea}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerSerial']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerSerial }" disabled="#{semmel001Bean.wrapper.disableMeaPea}"/>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disableMeaPea}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eCheckArea']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu disabled="#{semmel001Bean.wrapper.disableMeaPea}"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eCheckArea}"
												style="width:160px">
												<f:selectItems value="#{semmel001Bean.elCheckAreaList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterType }" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<a4j:commandButton id="btnAdd" value="Add"
												styleClass="rich-button" action="#{navAction.navi}"
												disabled="#{semmel001Bean.wrapper.disableMeaPeaAddButton}"
												reRender="pnlmeterInfoPEA,pnlmeterInfoMEAPEAList,frmError">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doAdd13" />
											</a4j:commandButton>
											<rich:spacer width="5" />
											<a4j:commandButton id="btnUpdate"
												value="Update" styleClass="rich-button"
												action="#{navAction.navi}"
												reRender="oppContent,pnlmeterInfoPEA,pnlmeterInfoMEAPEAList,frmError"
												disabled="#{semmel001Bean.wrapper.disableMeaPeaUpdateButton}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doUpdate13" />
											</a4j:commandButton>
											<rich:spacer width="5" />
											<a4j:commandButton id="btnClear"
												value="Clear" styleClass="rich-button"
												action="#{navAction.navi}"
												disabled="#{semmel001Bean.wrapper.disableMeaPea}"
												reRender="oppContent,pnlmeterInfoPEA">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doClear13" />
											</a4j:commandButton>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<!-- MEA/PEA meter list -->
					<rich:panel>
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterInfoMEAPEA']}" />
						</f:facet>
							
						<rich:panel id="pnlmeterInfoMEAPEAList" styleClass="sem_autoScrollbar" style="width: 1100px">
	
							<!-- dataTable -->
							<rich:dataTable id="dtbmeterInfoMEAPEA" width="100%"
								cellpadding="1" cellspacing="0" border="0" var="meterInfo"
								value="#{semmel001Bean.meterInfoMeaPeaList}"
								reRender="dtbmeterInfoMEAPEA"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
	
								<!-- columns -->
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="Edit" style="width: 40px" />
									</f:facet>
									<div align="center">
										<a4j:commandButton
											oncomplete="#{rich:component('mdpConfirmEditDialogMEAPEA')}.show(); return false"
											rendered="#{!semmel001Bean.wrapper.disableMeaPea && !meterInfo.firstPaid }"
											image="images/edit.png" style="height: 15; width: 15;"
											action="#{navAction.navi}"
											reRender="mdpConfirmEditDialogMEAPEA"
											title="edit">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="meterId" value="#{meterInfo.rowId}" />
											<a4j:actionparam name="methodWithNavi" value="doInitEdit13" />
										</a4j:commandButton>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.index']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{row+1}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.meterId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterId']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.meterId}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eAreaCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.MEARegionCode']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eAreaCode}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eAreaName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.MEARegion']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eAreaName}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterRate}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterRate']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterRate}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterSize}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterSize']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterSize}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterWire}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterWise']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterWire}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eOnMeterDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterOnDT']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eOnMeterDtLabel}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerLabel}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerLabel']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerSize}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerSize']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerSize}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerSerial}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerSerial']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerSerial}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerDT']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.transformerDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerType']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerType}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterType}">
									<f:facet name="header">
										<h:outputText value="Meter Type" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterType}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eOneBillDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.eOneBillDt']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eOneBillDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eCheckAreaLabel}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.eCheckArea']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eCheckAreaLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.createBy}">
									<f:facet name="header">
										<h:outputText value="Created By" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.createBy}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.createDt}" sortOrder="DESCENDING">
									<f:facet name="header">
										<h:outputText value="Created Date" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.createDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.updateBy}">
									<f:facet name="header">
										<h:outputText value="Updated By" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.updateBy}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.updateDt}">
									<f:facet name="header">
										<h:outputText value="Updated Date" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.updateDtLabel}"/>
									</div>
								</rich:column>
	
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbmeterInfoMEAPEA" 
										maxPages="10" id="dstmeterInfoMEAPEA" selectedStyleClass="selectScroll" />
								</f:facet>
								
							</rich:dataTable>
							
						</rich:panel>
						
					</rich:panel>
		
					<rich:panel id="pnlMeterInfoPrivate">
						
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.MeterInfoPrivate']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
	
							<h:panelGroup>
							
								<table width="100%" border="0" >
									<tr>
										<td align="right" width="20%">
										</td>
										<td colspan="3" align="left">
											<h:selectBooleanCheckbox value="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean}" styleClass="ms7" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}">
												<a4j:support event="onclick" action="#{semmel001Action.changeCreateBill}" reRender="pnlMeterInfoPrivate,frmError"/>
											</h:selectBooleanCheckbox>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.createBill']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<rich:spacer width="5" rendered="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoPrivate.meterId }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<rich:spacer width="5" rendered="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<h:outputText value="#{jspMsg['label.pMeterOwnerName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoPrivate.pMeterOwnerName }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<rich:spacer width="5" rendered="#{semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<h:outputText value="#{jspMsg['label.pAreaName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoPrivate.pAreaName }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.pMeterAddress']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="18" maxlength="50" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoPrivate.pMeterAddress }" disabled="#{semmel001Bean.wrapper.disablePrivate}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<h:outputText value="#{jspMsg['label.pMeterUnitPrice']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtChqAmt" value="#{semmel001Bean.wrapper.meterInfoPrivate.pMeterUnitPrice}"
												disabled="#{semmel001Bean.wrapper.disablePrivate || (semmel001Bean.wrapper.disablePrivateEditMode && semmel001Bean.wrapper.firstPaidFlag)}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												size="20"
												maxlength="18"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>											
										
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate &&!semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.meterInfoPrivate.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
											<h:outputText value="#{jspMsg['label.pMeterVatType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneRadio value="#{semmel001Bean.wrapper.meterInfoPrivate.pMeterVatType}" 
												styleClass="ms7" rendered="true" layout="lineDirection"
												disabled="#{semmel001Bean.wrapper.disablePrivate || (semmel001Bean.wrapper.disablePrivateEditMode && semmel001Bean.wrapper.firstPaidFlag)}">
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />
												<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />
												<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
											</h:selectOneRadio>
										</td>
									</tr>
	
									<tr>
										<td align="right" width="20%">
											
											
											<h:outputText value="#{jspMsg['label.pFirstKwh']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:inputText size="18" maxlength="15" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoPrivate.pFirstKwh }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disablePrivate}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disablePrivate}"/>
											<h:outputText value="#{jspMsg['label.pMeterStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu value="#{semmel001Bean.wrapper.meterInfoPrivate.pMeterStatus}" style="width:160px" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.meterInfoPrivate.pMeterStatus eq 'OFF'}">
												<f:selectItems value="#{semmel001Bean.elMeterStatusList}" />
												<a4j:support event="onchange" action="#{semmel001Action.changePMeterStatus}" reRender="pnlMeterInfoPrivate"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.pOnMeterDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoPrivate.pOnMeterDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disablePOffMeterDt}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disablePOffMeterDt}"/>
											<h:outputText value="#{jspMsg['label.pOffMeterDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoPrivate.pOffMeterDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePOffMeterDt}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.pMeterRemark']}" styleClass="ms7" />
										</td>
										<td colspan="3" align="left">
											<h:inputTextarea value="#{semmel001Bean.wrapper.meterInfoPrivate.pMeterRemark}" cols="40" rows="4" disabled="#{semmel001Bean.wrapper.disablePrivate}"/>
										</td>
									</tr>
									<tr>
										<td>
											<a4j:commandButton id="btnAddPrivate" value="Add"
												styleClass="rich-button" action="#{navAction.navi}"
												disabled="#{semmel001Bean.wrapper.disablePrivateAddButton}"
												reRender="pnlMeterInfoPrivate,pnlmeterInfoPrivateList,frmError">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doAdd13" />
											</a4j:commandButton>
											<rich:spacer width="5" />
											<a4j:commandButton
												id="btnUpdatePrivate" value="Update" styleClass="rich-button"
												action="#{navAction.navi}"
												reRender="pnlMeterInfoPrivate,pnlmeterInfoPrivateList,frmError"
												disabled="#{semmel001Bean.wrapper.disablePrivateUpdateButton}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doUpdate13" />
											</a4j:commandButton>
											<rich:spacer width="5" />
											<a4j:commandButton
												id="btnClearPrivate" value="Clear" styleClass="rich-button"
												action="#{navAction.navi}"
												disabled="#{semmel001Bean.wrapper.disablePrivate}"
												reRender="oppContent,pnlMeterInfoPrivate">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doClear13" />
											</a4j:commandButton>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel>
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterInfoPrivate']}" />
						</f:facet>
					
						<rich:panel id="pnlmeterInfoPrivateList" styleClass="sem_autoScrollbar" style="width: 1100px">
						
							<rich:dataTable id="dtbmeterInfoPrivate" width="100%"
								cellpadding="1" cellspacing="0" border="0" var="meterInfo"
								value="#{semmel001Bean.meterInfoPrivateList}"
								reRender="dtbmeterInfoPrivate,pnlMeterInfoPrivate,pnlmeterInfoPrivateList,frmError"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
	
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="Edit" style="width: 40px" />
									</f:facet>
									<div align="center">
										<a4j:commandButton
											oncomplete="#{rich:component('mdpConfirmEditDialogPrivate')}.show(); return false"
											rendered="#{!semmel001Bean.wrapper.disablePrivate && meterInfo.editButtonVisible}"
											image="images/edit.png" style="height: 15; width: 15;"
											action="#{navAction.navi}"
											reRender="mdpConfirmEditDialogPrivate"
											title="edit">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="meterId" value="#{meterInfo.rowId}" />
											<a4j:actionparam name="methodWithNavi" value="doInitEdit13" />
										</a4j:commandButton>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.index']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{row+1}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.meterId}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterId']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.meterId}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.referMeterId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.referMeterId']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.referMeterId}" />
									</div>
								</rich:column>	
								
								
								
								<rich:column sortBy="#{meterInfo.pMeterOwnerName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pMeterOwnerName']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pMeterOwnerName}" />
									</div>
								</rich:column>																
								<rich:column sortBy="#{meterInfo.pAreaName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.MEARegion']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pAreaName}" />
									</div>
								</rich:column>								
								
								<rich:column sortBy="#{meterInfo.pMeterAddress}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pMeterAddress']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pMeterAddress}" />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{meterInfo.pMeterUnitPrice}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pMeterUnitPrice']}">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pMeterUnitPrice}" />
									</div>
								</rich:column>								
								<rich:column sortBy="#{meterInfo.pMeterVatType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pMeterVatType']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pMeterVatTypeLabel}" />
									</div>
								</rich:column>			
								<rich:column sortBy="#{meterInfo.pFirstKwh}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pFirstKwh']}">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pFirstKwh}" />
									</div>
								</rich:column>																							
								<rich:column sortBy="#{meterInfo.pMeterStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pMeterStatus']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pMeterStatus}" />
									</div>
								</rich:column>																	
								<rich:column sortBy="#{meterInfo.pOnMeterDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pOnMeterDt']}">
										
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pOnMeterDtLabel}" >
										
										</h:outputText>
									</div>
								</rich:column>																	
								<rich:column sortBy="#{meterInfo.pOffMeterDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pOffMeterDt']}">
										
										</h:outputText>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pOffMeterDtLabel}" >
										
										</h:outputText>
									</div>
								</rich:column>									
								
									<rich:column sortBy="#{meterInfo.pMeterRemark}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pMeterRemark']}" style="width: 200px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.pMeterRemark}" style="width: 200px"/>
									</div>
								</rich:column>									
								<rich:column sortBy="#{meterInfo.createBy}">
									<f:facet name="header">
										<h:outputText value="Created By" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.createBy}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.createDt}" sortOrder="DESCENDING">
									<f:facet name="header">
										<h:outputText value="Created Date" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.createDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.updateBy}">
									<f:facet name="header">
										<h:outputText value="Updated By" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.updateBy}" >
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.updateDt}">
									<f:facet name="header">
										<h:outputText value="Updated Date" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.updateDtLabel}">
										
										</h:outputText>
									</div>
								</rich:column>
							
								
								
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbmeterInfoPrivate" 
										maxPages="10" id="dstmeterInfoPrivate" selectedStyleClass="selectScroll" />
								</f:facet>
								
							</rich:dataTable>
							
						</rich:panel>
						
					</rich:panel>
					
					<rich:panel id="pnlInsurance">
						
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.insuranceInfo']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
								
								<table width="100%">
									<tr>
										<td align="center">
											<h:selectOneRadio id="rbtDepositType" value="#{semmel001Bean.wrapper.electricManage.depositType}" 
												disabled="true" styleClass="ms7" rendered="true">
												<f:selectItem itemValue="MAIN BG" itemLabel="#{jspMsg['label.radio.mainBG']}" />
												<f:selectItem itemValue="BG" itemLabel="#{jspMsg['label.radio.BG']}" />
												<f:selectItem itemValue="Cash" itemLabel="#{jspMsg['label.radio.Cash']}" />
												<f:selectItem itemValue="BGCash" itemLabel="#{jspMsg['label.radio.BGCash']}" />
											</h:selectOneRadio>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
	
					<rich:panel id="pnlBalance">
						
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.balance']}" />
						</f:facet>
						
						<h:panelGrid width="80%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
								
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.electricDepositType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.lastPayAmt}" styleClass="ms7">
												<f:convertNumber type="currency" currencySymbol=""/> 
											</h:outputText>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.lastTermOfPaymentDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.lastTermOfPaymentDtLabel }" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.lastKwhTotal']}" styleClass="ms7" />
										</td>
										<td colspan="3" align="left">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.lastKwhTotal }" styleClass="ms7" />
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
		
					<rich:panel id="pnlElectricStatus">
						
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.electricStatus']}" />
						</f:facet>
						
						<h:panelGrid width="80%" border="0" cellpadding="0" cellspacing="1">
							
							<h:panelGroup>
								
								<table width="100%">
									<tr>
										<td width="30%" align="center">
											<sem:radioButton
												id="rbtelectricStatus2" name="Active"
												onClick="changeElectricStatusRadio('Active');"
												overrideName="true"
												value="#{semmel001Bean.wrapper.electricManage.electricStatus}"
												itemValue="Active" />
											<rich:spacer width="5" />
											<h:outputText value="#{jspMsg['label.radio.Active']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<sem:radioButton id="rbtelectricStatus1"
												name="Terminate"
												onClick="changeElectricStatusRadio('Terminate');"
												overrideName="true"
												value="#{semmel001Bean.wrapper.electricManage.electricStatus}"
												itemValue="Terminate" /> <rich:spacer width="5" /> <h:outputText
												value="#{jspMsg['label.radio.Terminate']}" styleClass="ms7" />
											<rich:spacer width="5" />
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												disabled="#{semmel001Bean.wrapper.disableElectricTerminateDt}"
												value="#{semmel001Bean.wrapper.electricManage.electricTerminateDt}"
												inputSize="18" style="width: 160px"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td width="30%">
											<sem:radioButton id="rbtelectricStatus3"
												name="Close" onClick="changeElectricStatusRadio('Close');"
												overrideName="true"
												value="#{semmel001Bean.wrapper.electricManage.electricStatus}"
												itemValue="Close" />
											<rich:spacer width="5" /> 
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disableElectricCloseDt}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disableElectricCloseDt}"/>
											<h:outputText value="#{jspMsg['label.radio.Close']}" styleClass="ms7" /> 
											<rich:spacer width="5" />
											<rich:calendar
												showWeeksBar="false" locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												disabled="#{semmel001Bean.wrapper.disableElectricCloseDt}"
												value="#{semmel001Bean.wrapper.electricManage.electricCloseDt}"
												inputSize="18" style="width: 160px"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<a4j:jsFunction name="changeElectricStatusRadio"
											reRender="pnlElectricStatus"
											action="#{semmel001Action.changeElectricStatusRadio}">
											<a4j:actionparam name="param1" assignTo="#{semmel001Bean.wrapper.electricManage.electricStatus}" />
										</a4j:jsFunction>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<rich:panel id="elPaymentBillFooter">
				
					<h:panelGrid width="90%">
					
						<h:panelGroup>
					
						<table width="100%">
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7" />
								</td>
								<td width="25%">
									<h:outputText value="#{semmel001Bean.wrapper.createBy}" styleClass="ms7"/>
								</td>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7" />
								</td>
								<td width="25%">
									<h:outputText value="#{semmel001Bean.wrapper.createDt}" styleClass="ms7">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</td>
							</tr>
							<tr>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7" />
								</td>
								<td width="25%">
										<h:outputText value="#{semmel001Bean.wrapper.updateBy}" styleClass="ms7"/>
								</td>
								<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7" />
								</td>
								<td width="25%">
									<h:outputText value="#{semmel001Bean.wrapper.updateDt}" styleClass="ms7">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
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
<rich:modalPanel id="mdpConfirmEditDialogMEAPEA" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Edit"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmEditDialogMEAPEA">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel001Bean.popupMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="pnlelectMeterDetail,pnlmeterInfoPEA,pnlmeterInfoMEAPEAList,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doEdit13" />
						<a4j:actionparam name="page" value="13" />
						<rich:componentControl for="mdpConfirmEditDialogMEAPEA" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmEditDialogMEAPEA" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
<rich:modalPanel id="mdpConfirmEditDialogPrivate" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Edit"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmEditDialogPrivate">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel001Bean.popupMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="pnlMeterInfoPrivate,pnlmeterInfoPrivateList,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doEdit13" />
						<a4j:actionparam name="page" value="13" />
						<rich:componentControl for="mdpConfirmEditDialogPrivate" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmEditDialogPrivate" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>