<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.el.semmel001-13" var="jspMsg" />
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
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
											
											
												<a4j:commandButton id="btnBackPayment" value="Back" styleClass="rich-button" 
												rendered="#{semmel001Bean.comeFromVieMeterInfo && !semmel001Bean.comeFromOtherPage}"
								            	action="#{navAction.navi}"  reRender="oppContent,pnlNoPaymentSite"   >
												    <a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="#{semmel001Bean.fromPage}" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
													<a4j:actionparam name="methodWithNavi" value="backFromViewMeterInfo" />
												</a4j:commandButton>
												
												
												<a4j:commandButton id="btnBack" value="Back"
													styleClass="rich-button" action="#{navAction.navi}"
													rendered="#{!semmel001Bean.comeFromVieMeterInfo && !semmel001Bean.comeFromPage5 && !semmel001Bean.comeFromOtherPage}"
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doCancel" />
													<a4j:actionparam name="page" value="13" />
												</a4j:commandButton>
												
												<a4j:commandButton id="btnBack3" value="Back"
													styleClass="rich-button" action="#{navAction.navi}"
													rendered="#{semmel001Bean.comeFromPage5 && !semmel001Bean.comeFromOtherPage}"
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="init4" />
													<a4j:actionparam name="rowId" value="#{semmel001Bean.wrapper.electricManage.rowId}" />
												</a4j:commandButton>
												<a4j:commandButton id="btnBack4" value="Back"
													styleClass="rich-button" action="#{navAction.navi}"
													rendered="#{semmel001Bean.comeFromOtherPage}"
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="#{semmel001Bean.navModuleFrom}" />
													<a4j:actionparam name="navProgram" value="#{semmel001Bean.navProgramFrom}" />
													<a4j:actionparam name="moduleWithNavi" value="#{semmel001Bean.navModuleFrom}" />
													<a4j:actionparam name="actionWithNavi" value="#{semmel001Bean.actionWithNaviFrom}" />
													<a4j:actionparam name="methodWithNavi" value="#{semmel001Bean.methodWithNaviFrom}" />
												</a4j:commandButton>
																									
											</td>
											<td>
												<a4j:commandButton id="btnSave" value="Save"
												rendered="#{!semmel001Bean.comeFromVieMeterInfo}"
													styleClass="rich-button" action="#{navAction.navi}"
													reRender="oppContent,pnlSearchElectricMeterManagement" 
													>
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
													<a4j:actionparam name="page" value="13" />
													
													
												</a4j:commandButton>
												
												<a4j:commandButton id="btnSave1" value="Save"
												rendered="#{semmel001Bean.comeFromOtherPage5_5}"
													styleClass="rich-button" action="#{navAction.navi}"
													reRender="oppContent" 
													>
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doSave" />
												</a4j:commandButton>															
											</td>
											<td>
												<a4j:commandButton id="btnNew" value="Cancel"
												rendered="#{!semmel001Bean.comeFromVieMeterInfo && !semmel001Bean.comeFromPage5}"
													styleClass="rich-button" action="#{navAction.navi}"
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doInit" />
													<a4j:actionparam name="selectedRow" value="#{semmel001Bean.rowIndex}" />
													<a4j:actionparam name="page" value="13" />
												</a4j:commandButton>
												<script>												
												function clickBackButton(){													
													if(document.getElementById('incContent:frmUpdateMeterInfo:btnBack4')!=null){
														document.getElementById('incContent:frmUpdateMeterInfo:btnBack4').click();
													}
													if(document.getElementById('incContent:frmUpdateMeterInfo:btnBack3')!=null){
														document.getElementById('incContent:frmUpdateMeterInfo:btnBack3').click();
													}
													if(document.getElementById('incContent:frmUpdateMeterInfo:btnBack')!=null){
														document.getElementById('incContent:frmUpdateMeterInfo:btnBack').click();
													}
													if(document.getElementById('incContent:frmUpdateMeterInfo:btnBackPayment')!=null){
														document.getElementById('incContent:frmUpdateMeterInfo:btnBackPayment').click();
													}													
												}
												</script>
											</td>
											<td>
												<a4j:commandButton id="btnUploadPicture"
													action="#{navAction.navi}"
													reRender="oppContent,popupUploadPictureCriteria"
													rendered="#{semmel001Bean.wrapper.electricManage.contractNo != null}"
													value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
													oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
													<a4j:actionparam name="navModule" value="common" />
													<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
													<a4j:actionparam name="moduleWithNavi" value="common" />
													<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
													<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
													<a4j:actionparam name="refId" value="" />
													<a4j:actionparam name="module" value="ELM"/>
													<a4j:actionparam name="contractNo" value="#{semmel001Bean.wrapper.electricManage.contractNo}"/>
													<a4j:actionparam name="viewMode" value="N"/>
												</a4j:commandButton>
											</td>
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
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms14" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.company }" styleClass="ms14" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.previousContractNo']}" styleClass="ms14" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.oldContractNo }" styleClass="ms14" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms14"/>
										</td>
										<td width="30%">
											<a4j:commandLink id="hypEdit" value="#{semmel001Bean.wrapper.electricManage.contractNo}" 
											action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup()" styleClass="ms10blue">
												<a4j:actionparam name="navModule" value="si" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
												<a4j:actionparam name="methodWithNavi" value="initPopup" />
												<a4j:actionparam name="rowId" value="#{semmel001Bean.wrapper.electricManage.siteInfoId}" />
											</a4j:commandLink>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms14" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.regionLabel}" styleClass="ms14" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractStartDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.formatContractStartDt }" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractEndDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.formatContractEndDt }" styleClass="ms7" />
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
											<h:outputText value="#{jspMsg['label.address']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.siteAddressNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.thumbon']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.siteTumbon}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.amphurLabel}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.provinceLabel}" styleClass="ms7" />
										</td>								
									
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.contractStatus}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.SiteStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.siteStatusLabel}" styleClass="ms7" />
										</td>								
									
									</tr>								
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms14" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricUseTypeLabel}" styleClass="ms14" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processStatusName']}" styleClass="ms14" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.electricManage.processStatusName}" styleClass="ms14" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.elOwnerGroup']}" styleClass="ms14" />
										</td>
										<td width="30%">
											<h:selectOneMenu value= "#{semmel001Bean.wrapper.electricManage.elOwnerGroup}" >
												<f:selectItems value="#{semmel001Bean.elOwnerGroupList}"/>
											</h:selectOneMenu>
										</td>
									</tr>									
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
		
					<!-- document info 1 -->
					<h:panelGroup>
					
						<table width="100%" cellpadding="0" cellspacing="0" border="0" >
							<tr>
								<td width="50%" >
									<rich:panel id="pnlApprove" rendered="#{semmel001Bean.wrapper.electricManage.electricUseType ne 'PRIVATE'}">
								
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
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.newReceivedDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.newPrintDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.newPrintDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.newSentWarrantDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.newSentWarrantDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>													
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.newSentContractDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.newSentContractDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
												</table>
												
											</h:panelGroup>
											
										</h:panelGrid>
										
									</rich:panel>
								</td>
								<td style="width: 5px"></td>
								<td>
									<rich:panel id="pnlCancel" rendered="#{semmel001Bean.wrapper.electricManage.electricUseType ne 'PRIVATE'}">
							
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
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.terminateReceivedDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.terminatePrintDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.terminatePrintDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.terminateSentWarrantDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.terminateSentWarrantDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.terminateCutoffDt']}" styleClass="ms7" />
														</td>
														<td width="60%" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.terminateCutoffDt}"
																disabled="#{semmel001Bean.wrapper.disableTerminateCutoffDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
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
								
									<rich:panel id="pnlExpand" rendered="#{semmel001Bean.wrapper.electricManage.electricUseType ne 'PRIVATE'}">
									
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
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandReceivedDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandPrintDt']}" styleClass="ms7"/>
														</td>
														<td width="60%">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandPrintDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandSentWarrantDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<rich:calendar
																showWeeksBar="false" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandSentWarrantDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>	
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandOldCutoffDT']}" styleClass="ms7" />
														</td>
														<td width="60%">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandOldCutoffDt}"
																disabled="#{semmel001Bean.wrapper.disableExpandOldCutoffDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.expandNewOnmeterDt']}" styleClass="ms7" />
														</td>
														<td width="60%">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.expandNewOnmeterDt}"
																disabled="#{semmel001Bean.wrapper.disableExpandNewOnmeterDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
												
													
												</table>
												
											</h:panelGroup>
										
										</h:panelGrid>
										
									</rich:panel>
									
								</td>
								<td style="width: 5px"></td>
								<td>
								
									<rich:panel id="pnlTransfer" rendered="#{semmel001Bean.wrapper.electricManage.electricUseType ne 'PRIVATE'}">
										
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
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferReceivedDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
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
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferPrintDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferSentWarrantDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferSentWarrantDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>													
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferMeterDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferMeterDt}"
																disabled="#{semmel001Bean.wrapper.disableTransferMeterDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
														</td>
													</tr>
													<tr>
														<td align="right" width="40%">
															<h:outputText value="#{jspMsg['label.transferCutoffDt']}" styleClass="ms7" />
														</td>
														<td colspan="2" align="left">
															<rich:calendar showWeeksBar="false"
																locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy"
																value="#{semmel001Bean.wrapper.electricManage.transferCutoffDt}"
																disabled="#{semmel001Bean.wrapper.disableTransferCutoffDt}"
																inputSize="18" style="width: 160px"
																oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																oninputblur="return dateformat.checkDate(this);"/>
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
					
					<rich:panel rendered="#{semmel001Bean.wrapper.disablePrivate}">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.historyUpdate']}" />
						</f:facet>
							
						<rich:panel id="pnlmeterInfoHistory" styleClass="sem_autoScrollbar" style="width: 1100px">
	
							<!-- dataTable -->
							<rich:dataTable id="dtbmeterInfoHistory" width="100%"
								cellpadding="1" cellspacing="0" border="0" var="meterHistory" 
								value="#{semmel001Bean.meterHistory}" reRender="dtbmeterInfoHistory"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
	
								<!-- columns -->
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="Warrant Type" style="width: 40px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.warrantType}" />
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.receivedDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.receivedDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.printDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.printDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.sentWarrantDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.sentWarrantDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.sentContractDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.sentContractDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>	
								
															<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['message.terminateCutoffDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.terminateCutoffDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.expandCutoffDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.expandCutoffDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.expandNewOnmeterDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.expandNewOnmeterDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.transferMeterDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.transferMeterDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column width="5%">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.transfercutoffDt']}" style="width: 50px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterHistory.transfercutoffDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
										</h:outputText>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbmeterInfoHistory" 
										maxPages="10" id="dstmeterInfoHistory" selectedStyleClass="selectScroll" />
								</f:facet>
								
							</rich:dataTable>
							
						</rich:panel>
						
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
											<h:outputText value="#{jspMsg['label.bgTotalRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bgNo']}" styleClass="ms7" />
										</td>
										<td width="75%" colspan="3">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgNo}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.coverageMoney']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgAmt}" styleClass="ms7">
												<f:convertNumber type="currency" currencySymbol=""/>
											</h:outputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bankNameLabel}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.startDate']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgStartDtLabel}" styleClass="ms7"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.endDate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.bgEndDtLabel}" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.totalSite']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.totalSiteBg}" styleClass="ms7">
												<f:convertNumber type="number"/>
											</h:outputText>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalRemainSite']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel001Bean.wrapper.bgMaster.totalSiteRemain}" styleClass="ms7">
												<f:convertNumber type="number"/>
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="left" colspan="4">
											<h:outputText value="#{jspMsg['label.bgDetailRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<rich:panel id="pnlBGDetailResult">
												<rich:dataTable id="dtbBGDetail" width="95%" cellpadding="1" cellspacing="0" border="0" 
													var="bgDetail" value="#{semmel001Bean.wrapper.bgDepositDetailList}" reRender="dtbBGDetail" 
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
													styleClass="contentform" >
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.bgNo']}" />
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgDetail.bgNo}" />
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.bankName']}" />
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgDetail.bankNameLabel}" />
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.coverageMoney']}"/>
														</f:facet>
														<div align="right">
															<h:outputText value="#{bgDetail.bgAmt}">
																<f:convertNumber type="currency" currencySymbol=""/>
															</h:outputText>
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.remark']}"/>
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgDetail.remark}"/>
														</div>
													</rich:column>
												</rich:dataTable>
											</rich:panel>
										</td>
									</tr>
									<tr>
										<td align="left" colspan="4">
											<h:outputText value="#{jspMsg['label.bgCashRecords']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td colspan="4">
											<rich:panel id="pnlBGCashResult">
												<rich:dataTable id="dtbBGCash" width="95%" cellpadding="1" cellspacing="0" border="0" 
													var="bgCash" value="#{semmel001Bean.wrapper.cashDepositDetailList}" reRender="dtbBGCash" 
													onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
													onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
													styleClass="contentform" >
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.coverageMoney']}" />
														</f:facet>
														<div align="right">
															<h:outputText value="#{bgCash.depositAmt}" >
																<f:convertNumber type="currency" currencySymbol=""/>
															</h:outputText>
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.vatType']}" />
														</f:facet>
														<div align="center">
															<h:outputText value="#{bgCash.vatTypeLabel}" />
														</div>
													</rich:column>
													<rich:column>
														<f:facet name="header">
															<h:outputText value="#{jspMsg['column.header.remark']}"/>
														</f:facet>
														<div align="left">
															<h:outputText value="#{bgCash.remark}" />
														</div>
													</rich:column>
												</rich:dataTable>
											</rich:panel>
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
												itemValue="Active" 
												disabled="#{semmel001Bean.disableElectricStatusDisplay}"
												/>
											<rich:spacer width="5" />
											<h:outputText value="#{jspMsg['label.radio.Active']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<sem:radioButton id="rbtelectricStatus1" 
												disabled="#{semmel001Bean.disableElectricStatusDisplay}"
												name="Terminate"
												onClick="changeElectricStatusRadio('Terminate');"
												overrideName="true"
												value="#{semmel001Bean.wrapper.electricManage.electricStatus}"
												itemValue="Terminate" /> <rich:spacer width="5" /> 
												<h:outputText
												value="#{jspMsg['label.radio.Terminate']}" styleClass="ms7" 
												/>
											<rich:spacer width="5" />
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="false"
												datePattern="dd/MM/yyyy"
												disabled="#{semmel001Bean.wrapper.disableElectricTerminateDt}"
												value="#{semmel001Bean.wrapper.electricManage.siteTerminateDt}"
												inputSize="18" style="width: 160px"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td width="30%" background="black">
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
									<tr>
										<td width="30%" align="center">
											<h:outputText value="#{jspMsg['label.BGELPaymentDetail']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectBooleanCheckbox value="#{semmel001Bean.wrapper.electricManage.bgPaymentFlag}" disabled="true"/>
											<rich:spacer width="5" />
											<h:outputText value="#{jspMsg['label.BGPayment']}" styleClass="ms7" /> 
										</td>
										<td width="30%" background="black">
											<h:selectBooleanCheckbox value="#{semmel001Bean.wrapper.electricManage.elPaymentFlag}" disabled="true"/>
											<rich:spacer width="5" />
											<h:outputText value="#{jspMsg['label.nonPayment']}" styleClass="ms7" /> 
											
											
										</td>
									</tr>
									<tr>
									<td colspan="3">  
									</td>
									</tr>
									 <tr>
										<td width="30%" align="center">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea value="#{semmel001Bean.wrapper.electricManage.remark}" 
											cols="40" rows="4" 
										/>
										</td>
										<td width="30%" background="black">
											
										</td>
									</tr>
									
									<tr>
										<td width="30%" align="center">
											<h:outputText value="#{jspMsg['label.paymentChanel']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea value="#{semmel001Bean.wrapper.electricManage.paymentChannel}" 
											cols="40" rows="4" 
										/>
										</td>
										<td width="30%" background="black">
											
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					
					<!-- MWA/PEA meter management -->
					<rich:panel id="pnlmeterInfoPEA" rendered="#{semmel001Bean.wrapper.disablePrivate}">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.MeterInfoMEA']}" />
						</f:facet>
						
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
							
								<table width="100%" border="0" >
									<tr>
										<td colspan="4">
											<h:panelGrid id="frmMidError">
													<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" rendered="#{semmel001Bean.renderedMsgFormMiddle}"/>
											</h:panelGrid>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eAreaCode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eAreaCode }" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
										</td>
										<td align="right" width="15%"></td>
										<td width="30%"></td>
									</tr>
									<tr>
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.eAreaName']}" styleClass="ms7" /></td>
										<td><h:inputText size="30" maxlength="50" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eAreaName }" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/></td>										
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.eAreaDistrict']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eAreaDistrict }" disabled="true"/></td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disableMeaPea}"/>
											<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disableMeaPea}"/>
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.meterId}" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
										</td>
										<td align="right" width="15%">
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.eMeterType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="meterType" size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterType }" disabled="#{semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}" >
												<a4j:support event="onchange" reRender="pnlmeterInfoPEA,rbteTransformer,meterRateId,rbteTransformer" action="#{navAction.navi}" >
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="getMeterRateAct" />
													<a4j:actionparam name="meterTypeFlag" value="N" />
												</a4j:support>
											</h:inputText>
											<a4j:jsFunction name="getMeterRate" action="#{semmel001Action.getMeterRateAct}" reRender="pnlmeterInfoPEA,rbteTransformer,meterRateId"></a4j:jsFunction>
										</td>
										
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterSize']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterSize}" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterRate']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="meterRateId" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterRate}" style="width:160px" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}">
												<f:selectItems value="#{semmel001Bean.elMeterTypeList}" />
												
												<a4j:support event="onchange" reRender="pnlmeterInfoPEA,rbteTransformer,meterRateId,meterType" action="#{navAction.navi}" >
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="getMeterRateAct" />
													<a4j:actionparam name="meterTypeFlag" value="Y" />
												</a4j:support>
											</h:selectOneMenu>
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
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eOnMeterDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eMeterWire']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eMeterWire }" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerLabel']}" styleClass="ms7" />
										</td>
										
										<td >
											<h:panelGrid columns="2"> 
											<h:inputText size="30" maxlength="30" style="width: 160px"  value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerLabel }" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
											
											<h:selectOneRadio id="rbteTransformer" layout="lineDirection" 
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerType}" 
												styleClass="ms7" disabled="#{semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}">
												<f:selectItem itemValue="HV" itemLabel="High Volt" />
												<f:selectItem itemValue="LV" itemLabel="Low Volt" />
												
												<a4j:support event="onclick" reRender="pnlmeterInfoPEA,rbteTransformer,meterRateId,meterType" action="#{navAction.navi}" >
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="getMeterRateAct" />
													<a4j:actionparam name="meterTypeFlag" value="Y" />
												</a4j:support>
											</h:selectOneRadio>											
											</h:panelGrid>
										

										</td>
										
										
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eOneBillDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eOneBillDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerSerial']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerSerial }" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerSize']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText size="30" maxlength="30" style="width: 160px" value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerSize }" disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eCheckArea']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eCheckArea}"
												style="width:160px">
												<f:selectItems value="#{semmel001Bean.elCheckAreaList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.eTransformerDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar showWeeksBar="false"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.wrapper.meterInfoMeaPea.eTransformerDt}"
												inputSize="18" style="width: 160px"
												disabled="#{semmel001Bean.wrapper.disableMeaPea || semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
										</td>
									</tr>
									<tr>
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" /></td>
										<td><h:inputTextarea value="#{semmel001Bean.wrapper.meterInfoMeaPea.pMeterRemark}" cols="40" rows="4" disabled="#{semmel001Bean.wrapper.meterInfoMeaPea.recordStatus=='N'}"/></td>
										
										<td align="right" width="15%"><h:outputText value="#{jspMsg['column.header.meterStatus']} : " styleClass="ms7" /></td>
										<td width="30%">
										  <h:selectOneRadio id="meterStatus" layout="lineDirection" 
                                                value="#{semmel001Bean.wrapper.meterInfoMeaPea.recordStatus}" 
                                                styleClass="ms7">
                                                <f:selectItem itemValue="Y" itemLabel="Active" />
                                                <f:selectItem itemValue="N" itemLabel="Inactive" />
                                                
                                                <a4j:support event="onclick" reRender="pnlmeterInfoPEA,rbteTransformer,meterRateId,meterType"  >
                                                   
                                                </a4j:support>
                                            </h:selectOneRadio> 
										</td>
									</tr>
									<tr>
										<td colspan="4" align="left"><h:outputText value="#{jspMsg['header.balance']}" styleClass="ms7u" /></td>
									</tr>
									<tr>
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.paymentPeriod']}" styleClass="ms7" /></td>
										<td><h:inputText value="#{semmel001Bean.wrapper.meterInfoMeaPea.lastTermOfPaymentDtLabel}" disabled="true" maxlength="30" style="width: 160px"/></td>
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.lastInvAmt']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText value="#{semmel001Bean.wrapper.meterInfoMeaPea.lastInvAmt}" maxlength="30" style="width: 160px" disabled="true"/></td>
									</tr>
									<tr>
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.KwhTotal']}" styleClass="ms7" /></td>
										<td><h:inputText maxlength="30" style="width: 160px" disabled="true" value="#{semmel001Bean.wrapper.meterInfoMeaPea.lastKWHTotal}"/></td>
										<td align="right" width="15%"><h:outputText value="#{jspMsg['label.lastLKwhTotal']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText value="#{semmel001Bean.wrapper.meterInfoMeaPea.lastLKwh}" maxlength="30" style="width: 160px" disabled="true"/></td>
									</tr>									
									<tr>
										<td colspan="4">
											<a4j:commandButton id="btnAdd" value="Add"
												styleClass="rich-button" action="#{navAction.navi}"
												disabled="#{semmel001Bean.wrapper.disableMeaPeaAddButton}"
												reRender="pnlmeterInfoPEA,pnlmeterInfoMEAPEAList,frmError,frmMidError">
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
												reRender="oppContent,pnlmeterInfoPEA,pnlmeterInfoMEAPEAList,frmError,frmMidError"
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
					<rich:panel rendered="#{semmel001Bean.wrapper.disablePrivate}">
					
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
								rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
	
								<!-- columns -->
								<rich:column width="5%" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="Edit" style="width: 40px" />
									</f:facet>
									<div align="center">
										<a4j:commandButton
											oncomplete="#{rich:component('mdpConfirmEditDialogMEAPEA')}.show(); return false"
											rendered="#{!semmel001Bean.wrapper.disableMeaPea && !meterInfo.firstPaid}"
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
								<rich:column styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.index']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{row+1}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.meterId}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterId']}" style="width: 50px" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.meterId}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eAreaCode}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.MEARegionCode']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eAreaCode}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eAreaName}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.MEARegion']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eAreaName}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterRate}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterRate']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterRate}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterSize}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterSize']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterSize}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterWire}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterWise']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterWire}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eOnMeterDt}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterOnDT']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eOnMeterDtLabel}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eMeterType}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="Meter Type" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eMeterType}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.meterStatus}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.meterStatus}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerLabel}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerLabel']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerSize}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerSize']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerSize}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerSerial}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerSerial']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerSerial}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerDt}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerDT']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.transformerDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eTransformerType}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.transformerType']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eTransformerType}" />
									</div>
								</rich:column>								
								<rich:column sortBy="#{meterInfo.lastTermOfPaymentDt}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.lastTermOfPaymentDt']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.lastTermOfPaymentDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.lastInvAmt}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.lastInvAmt']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.lastInvAmt}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.lastKWHTotal}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.lastKwhTotal']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.lastKWHTotal}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.lastLKwh}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.lastLKwh']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.lastLKwh}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eOneBillDt}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.eOneBillDt']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eOneBillDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.eCheckAreaLabel}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.eCheckArea']}" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.eCheckAreaLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.createBy}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="Created By" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.createBy}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.createDt}" sortOrder="DESCENDING" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="Created Date" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.createDtLabel}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.updateBy}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
									<f:facet name="header">
										<h:outputText value="Updated By" style="width: 100px"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{meterInfo.updateBy}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{meterInfo.updateDt}" styleClass="#{(meterInfo.recordStatus=='N')?'inactive':''}">
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
		
					<rich:panel id="pnlMeterInfoPrivate" rendered="#{!semmel001Bean.wrapper.disablePrivate}">
						
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
												disabled="#{semmel001Bean.wrapper.disablePOnMeterDt}"
												inputSize="18" style="width: 160px"
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
												disabled="#{semmel001Bean.wrapper.disablePOffMeterDt}"
												inputSize="18" style="width: 160px"
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
												action="#{navAction.navi}" rendered="false"
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
					
					<rich:panel rendered="#{!semmel001Bean.wrapper.disablePrivate}">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterInfoPrivate']}" />
						</f:facet>
					
						<rich:panel id="pnlmeterInfoPrivateList" styleClass="sem_autoScrollbar" style="width: 1100px; height:800px">
						
							<rich:dataTable id="dtbmeterInfoPrivate" width="100%"
								cellpadding="1" cellspacing="0" border="0" var="meterInfo"
								value="#{semmel001Bean.meterInfoPrivateList}"
								reRender="dtbmeterInfoPrivate,pnlMeterInfoPrivate,pnlmeterInfoPrivateList,frmError"
								rowKeyVar="row">
	
								<rich:column width="5%" style="background-color:#f2f2f2">
									<table width="100%" border="0" >
										<tr>
											<td align="right" width="20%"><h:outputText value="#{meterInfo.referMeterId}" styleClass="ms7u" /></td>
											<td colspan="3" align="left">&nbsp;</td>
										</tr>
										<tr>
											<td align="right" width="20%">
											</td>
											<td colspan="3" align="left">
												<h:selectBooleanCheckbox value="#{meterInfo.oneBillFlagBoolean}" styleClass="ms7" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<rich:spacer width="5"/>
												<h:outputText value="#{jspMsg['label.createBill']}" styleClass="ms7" />
											</td>
										</tr>
										<tr>
											<td align="right" width="20%">
												<h:graphicImage value="images/icon_required.gif" rendered="#{meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<rich:spacer width="5" rendered="#{meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:inputText size="18" maxlength="15" style="width: 160px" value="#{meterInfo.meterId }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
											</td>
											<td align="right" width="20%">
												<h:graphicImage value="images/icon_required.gif" rendered="#{meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<rich:spacer width="5" rendered="#{meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<h:outputText value="#{jspMsg['label.pMeterOwnerName']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:inputText size="18" maxlength="15" style="width: 160px" value="#{meterInfo.pMeterOwnerName }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
											</td>
										</tr>
										<tr>
											<td align="right" width="20%">
												<h:graphicImage value="images/icon_required.gif" rendered="#{meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<rich:spacer width="5" rendered="#{meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<h:outputText value="#{jspMsg['label.pAreaName']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:inputText size="18" maxlength="15" style="width: 160px" value="#{meterInfo.pAreaName }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
											</td>
											<td align="right" width="20%">
												<h:outputText value="#{jspMsg['label.pMeterAddress']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:inputText size="18" maxlength="50" style="width: 160px" value="#{meterInfo.pMeterAddress }" disabled="#{semmel001Bean.wrapper.disablePrivate}"/>
											</td>
										</tr>
										<tr>
											<td align="right" width="20%">
												<h:graphicImage value="images/icon_required.gif" rendered="#{!meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<rich:spacer width="5" rendered="#{!meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<h:outputText value="#{jspMsg['label.pMeterUnitPrice']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:inputText id="txtChqAmt" value="#{meterInfo.pMeterUnitPrice}"
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
												<h:graphicImage value="images/icon_required.gif" rendered="#{!meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate &&!semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<rich:spacer width="5" rendered="#{!meterInfo.oneBillFlagBoolean && !semmel001Bean.wrapper.disablePrivate && !semmel001Bean.wrapper.disablePrivateEditMode}"/>
												<h:outputText value="#{jspMsg['label.pMeterVatType']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:selectOneRadio value="#{meterInfo.pMeterVatType}" 
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
												<h:inputText size="18" maxlength="15" style="width: 160px" value="#{meterInfo.pFirstKwh }" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePrivateEditMode}"/>
											</td>
											<td align="right" width="20%">
												<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel001Bean.wrapper.disablePrivate}"/>
												<rich:spacer width="5" rendered="#{!semmel001Bean.wrapper.disablePrivate}"/>
												<h:outputText value="#{jspMsg['label.pMeterStatus']}" styleClass="ms7" />
											</td>
											<td width="30%">
												<h:selectOneMenu value="#{meterInfo.pMeterStatus}" style="width:160px" disabled="#{semmel001Bean.wrapper.disablePrivate || meterInfo.pMeterStatus eq 'OFF'}">
													<f:selectItems value="#{semmel001Bean.elMeterStatusList}" />
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
													value="#{meterInfo.pOnMeterDt}"
													inputSize="18" style="width: 160px"
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
													value="#{meterInfo.pOffMeterDt}"
													inputSize="18" style="width: 160px"
													oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" />
											</td>
										</tr>
										<tr>
											<td align="right" width="20%">
												<h:outputText value="#{jspMsg['label.pMeterRemark']}" styleClass="ms7" />
											</td>
											<td colspan="3" align="left">
												<h:inputTextarea value="#{meterInfo.pMeterRemark}" cols="40" rows="4" disabled="#{semmel001Bean.wrapper.disablePrivate}"/>
											</td>
										</tr>
										<tr>
											<td colspan="4" align="left"><h:outputText value="#{jspMsg['header.balance']}" styleClass="ms7u" /></td>
										</tr>
										<tr>
											<td align="right" width="15%"><h:outputText value="#{jspMsg['label.paymentPeriod']}" styleClass="ms7" /></td>
											<td><h:inputText value="#{meterInfo.lastTermOfPaymentDtLabel}" disabled="true" maxlength="15" style="width: 160px"/></td>
											<td align="right" width="15%"><h:outputText value="#{jspMsg['label.lastInvAmt']}" styleClass="ms7" /></td>
											<td width="30%"><h:inputText value="#{meterInfo.lastInvAmt}" maxlength="15" style="width: 160px" disabled="true"/></td>
										</tr>
										<tr>
											<td align="right" width="15%"><h:outputText value="#{jspMsg['label.KwhTotal']}" styleClass="ms7" /></td>
											<td><h:inputText maxlength="15" style="width: 160px" disabled="true" value="#{meterInfo.lastKWHTotal}"/></td>
											<td align="right" width="15%"><h:outputText value="#{jspMsg['label.lastLKwhTotal']}" styleClass="ms7" /></td>
											<td width="30%"><h:inputText value="#{meterInfo.lastLKwh}" maxlength="15" style="width: 160px" disabled="true"/></td>
										</tr>
										<tr>
											<td align="right" width="15%"><h:outputText value="#{jspMsg['label.pMeterUnitPrice']}" styleClass="ms7" /></td>
											<td><h:inputText maxlength="15" style="width: 160px" disabled="true" value="#{meterInfo.lastUnitAmt}"/></td>
											<td align="right" width="15%"><h:outputText value="#{jspMsg['label.unitVatType']}" styleClass="ms7" /></td>
											<td width="30%"><h:selectOneRadio value="#{meterInfo.lastUnitVatType}" disabled="#{semmel001Bean.wrapper.disablePrivate || semmel001Bean.wrapper.disablePOffMeterDt}"
																 styleClass="ms7" rendered="true"
																 onclick="doChangeVATTypeELTempPage63();"
											                layout="lineDirection">
									                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />		
									                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />			                	
									                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
									                		</h:selectOneRadio>		
					                						<a4j:jsFunction name="doChangeVATTypeELTempPage63" reRender="paymentDetail" action="#{semmel006Action.doChangeVATTypeELTempPage63}"/></td>
										</tr>
										<tr>
											<td>
												<a4j:commandButton id="btnUpdate"
													oncomplete="#{rich:component('mdpConfirmUpdateDialogPrivate')}.show(); return false"
													value="#{jspMsg['btn.update']}" styleClass="rich-button"
													action="#{navAction.navi}"
													disabled="#{meterInfo.pMeterStatus=='OFF'}"
													reRender="oppContent,pnlmeterInfoPEA,pnlmeterInfoMEAPEAList,frmError">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="initUpdate13" />
													<a4j:actionparam name="rowIndex" value="#{row}" />
												</a4j:commandButton>
												<rich:spacer width="5" />
												<a4j:commandButton
													oncomplete="#{rich:component('mdpConfirmDeleteDialogPrivate')}.show(); return false"
													id="btnDeletePrivate" value="#{jspMsg['btn.delete']}" styleClass="rich-button"
													action="#{navAction.navi}"
													disabled="#{meterInfo.lastInvAmt!=null}"
													reRender="mdpConfirmDeleteDialogPrivate, frmError">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="rowIndex" value="#{row}" />
													<a4j:actionparam name="methodWithNavi" value="initDelete13" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
								</rich:column>								
							</rich:dataTable>
							
						</rich:panel>
						
					</rich:panel>
	
					<rich:panel id="pnlInsurance" rendered="false">
						
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
			
	
					<rich:panel id="pnlBalance" rendered="false">
						
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
<rich:modalPanel id="mdpConfirmDeleteDialogPrivate" autosized="true">
	<f:facet name="header">
		<h:outputText value="#{jspMsg['msg.confirmDelete']}"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDeleteDialogPrivate">
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
						<a4j:actionparam name="methodWithNavi" value="doDelete13New" />
						<a4j:actionparam name="page" value="13" />
						<rich:componentControl for="mdpConfirmDeleteDialogPrivate" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmDeleteDialogPrivate" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
<rich:modalPanel id="mdpConfirmUpdateDialogPrivate" autosized="true">
	<f:facet name="header">
		<h:outputText value="#{jspMsg['msg.confirmUpdate']}"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmUpdateDialogPrivate">
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
						<a4j:actionparam name="methodWithNavi" value="doUpdate13New" />
						<a4j:actionparam name="page" value="13" />
						<rich:componentControl for="mdpConfirmUpdateDialogPrivate" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmUpdateDialogPrivate" operation="hide"
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

<rich:modalPanel id="mdpPopupPrivateMeterinfo" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Edit"></h:outputText>
	</f:facet>
	<a4j:form id="frmPopupPrivateMeterinfo">
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
	</a4j:form>
</rich:modalPanel>
<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>