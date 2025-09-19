
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab0" style="width:100%;" columns="1">
		<!-- >> panel 1 -->
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.waitForTeminate']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 1 -->
				<rich:panel>
					<h:panelGroup style="width:100%;">
						<table style="width:100%; border:solid ececec 1px;">
							<tr>
								<td style="width:25%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
								</td>
								<td style="width:75%; white-space:nowrap;">
									<h:inputText id="msa002tab0_docNo" value="#{semmsa002Bean.siteAppTab0ObjParam.docNo}" maxlength="50"
									disabled="#{semmsa002Bean.disabledModeViewOnly}" styleClass="ms7" />
									
									<a4j:commandButton style="margin-left:5px;" id="msa002tab0_BtnGenDocNo" styleClass="rich-button" 
									action="#{semmsa002Action.doGenDocNo}" disabled="#{semmsa002Bean.disabledGenDocNoBtn}"
									value="Gen Doc No." reRender="msa002tab0_docNo, msa002-1_docNo, msa002tab0_BtnGenDocNo">
										<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppTab0ObjParam.siteAppId}" />
									</a4j:commandButton>
								</td>
							</tr>
							<tr>
								<td style="width:25%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['label.th_date']} : " styleClass="ms7" />
								</td>
								<td style="width:75%; white-space:nowrap;">
									<rich:calendar id="semmsa002tab0_dateTrm" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppTab0ObjParam.docDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="return dateformat.submitFomatDate(this);"
									   	   label=""
									   	   styleClass="ms7"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td style="width:10%; text-align:right; white-space:nowrap;">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText value="#{jspMsg['label.th_from']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap;" colspan="4">
								<a4j:region>
									<h:selectOneMenu style="" id="msa002tab0_reqOfficer" value="#{semmsa002Bean.siteAppObjParam.reqOfficer}" 
									disabled="#{semmsa002Bean.chkReqOfficerManual || semmsa002Bean.disabledModeViewOnly}" styleClass="ms7">
										<f:selectItems value="#{semmsa002Bean.reqOfficerList}"/>
									</h:selectOneMenu>
								
									<h:selectBooleanCheckbox id="msa002tab1_chkReqOfficerManual" value="#{semmsa002Bean.chkReqOfficerManual}"
									onclick="msa002tab0_doChkReqOfficerJS();" style="margin:0 0 0 10px;" disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
									<a4j:jsFunction name="msa002tab0_doChkReqOfficerJS" reRender="msa002tab0_reqOfficer, msa002tab0_reqOfficerManual" 
									action="#{semmsa002Action.doChkReqOfficer}"/>
									<h:outputText value=" #{jspMsg['label.th_specify_by_owner']} : " style="vertical-align:middle;" styleClass="ms7" />
									
									<h:inputText id="msa002tab0_reqOfficerManual" value="#{semmsa002Bean.siteAppObjParam.reqOfficerManual}" 
									disabled="#{!semmsa002Bean.chkReqOfficerManual || semmsa002Bean.disabledModeViewOnly}"
									maxlength="200" style="width:270px; margin-left:5px;" styleClass="ms7" />
								</a4j:region>
							</td>
							</tr>
							<tr>
								<td style="width:25%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_subject']} : " styleClass="ms7" />
								</td>
								<td style="width:75%; white-space:nowrap;">
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.title}" style="font-style:italic; width:150px;" styleClass="ms7" />
									
									<h:outputText value="#{jspMsg['label.th_cancelDt_waitForTrm']} :" style="margin:0 5px 0 0;" styleClass="ms7" />
									<rich:calendar id="msa002tab0_trmCancelContractDt" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppTab0ObjParam.terminateCancelContractDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="return dateformat.submitFomatDate(this);"
									   	   label=""
									   	   styleClass="ms7">
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td style="width:25%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_company']} : " styleClass="ms7" />
								</td>
								<td style="width:75%; white-space:nowrap;">
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.company}" style="font-style:italic; width:150px;" styleClass="ms7" />
									
									<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} : " style="margin:0 5px 0 0;" styleClass="ms7" />
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.contractNo}" style="font-style:italic;" styleClass="ms7" />
								</td>
							</tr>
							<tr>
								<td style="white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['label.th_reasonToCancelSite']} : " styleClass="ms7" />
								</td>
							</tr>
							<tr>
								<td style="white-space:nowrap;" colspan="2">
									<h:inputTextarea value="#{semmsa002Bean.siteAppTab0ObjParam.terminateReason}" rows="5" cols="50" style="width:100%;" styleClass="ms7">
									</h:inputTextarea>
								</td>
							</tr>
							<tr>
								<td style="white-space:nowrap;" colspan="2">
									<a4j:region>
										<h:selectBooleanCheckbox id="msa002tab0_chkTRmRmv" value="#{semmsa002Bean.chkTerminateRemoveFlag}" 
										onclick="chkTRmRmvFunc();" disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
										
										
										<a4j:jsFunction name="chkTRmRmvFunc" action="#{semmsa002Action.doChkWaitforTerFunc}"
										reRender="msa002tab0_chkTRmRmv, msa002tab0_removeBeginDt, msa002tab0_removeEndDt, test">
											<a4j:actionparam name="chkType" value="01"></a4j:actionparam>
										</a4j:jsFunction>
										
										<h:outputText value="#{jspMsg['label.th_removeBeginDt_waitForTrm']} :" style="margin:0 5px 0 5px;" styleClass="ms7" />
										<rich:calendar id="msa002tab0_removeBeginDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsa002Bean.siteAppTab0ObjParam.terminateRemoveDt}"
											   showWeeksBar="false"
											   inputSize="10"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	   cellWidth="15px" cellHeight="20px"
										   	   oninputblur="validateRichCalendarFromTo('frmAllInitTab:msa002_incTab0', 'msa002tab0_removeBeginDt', 'msa002tab0_removeEndDt');"
										   	   oncollapse="validateRichCalendarFromTo('frmAllInitTab:msa002_incTab0', 'msa002tab0_removeBeginDt', 'msa002tab0_removeEndDt');"
										   	   label=""
										   	   disabled="#{semmsa002Bean.disabledModeViewOnly || !semmsa002Bean.chkTerminateRemoveFlag}"
										   	   styleClass="ms7">
										</rich:calendar>
										
										<h:outputText value="#{jspMsg['label.th_removeEndDt_waitForTrm']} :" style="margin:0 5px 0 5px;" styleClass="ms7" />
										<rich:calendar id="msa002tab0_removeEndDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmsa002Bean.siteAppTab0ObjParam.terminateRemoveEndDt}"
											   showWeeksBar="false"
											   inputSize="10"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	   cellWidth="15px" cellHeight="20px"
										   	   oninputblur="validateRichCalendarFromTo('frmAllInitTab:msa002_incTab0', 'msa002tab0_removeBeginDt', 'msa002tab0_removeEndDt');"
										   	   oncollapse="validateRichCalendarFromTo('frmAllInitTab:msa002_incTab0', 'msa002tab0_removeBeginDt', 'msa002tab0_removeEndDt');"
										   	   disabled="#{semmsa002Bean.disabledModeViewOnly || !semmsa002Bean.chkTerminateRemoveFlag}"
										   	   styleClass="ms7">
										</rich:calendar>
									</a4j:region>
									
								</td>
							</tr>
							<tr>
								<td style="white-space:nowrap;" colspan="2">
									<h:selectBooleanCheckbox id="msa002tab0_chkTRmCnclData" value="#{semmsa002Bean.chkTerminateCancelRelateData}"
									disabled="#{semmsa002Bean.disabledModeViewOnly}" />
									<h:outputText value="#{jspMsg['label.th_cancelTo_waitForTrm']}" style="margin:0 0 0 5px;" styleClass="ms7" />
								</td>
							</tr>
							<tr>
								<td style="white-space:nowrap;" colspan="2" valign="top">
									<h:selectBooleanCheckbox id="msa002tab0_chkOtherWaitingFlag" value="#{semmsa002Bean.chkOtherWaitingFlag}" 
									onclick="chkOtherWaitingFunc();"
									style="vertical-align:top;"
									disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
									
									<a4j:jsFunction name="chkOtherWaitingFunc" action="#{semmsa002Action.doChkWaitforTerFunc}"
									reRender="msa002tab0_terminateNote">
										<a4j:actionparam name="chkType" value="03"></a4j:actionparam>
									</a4j:jsFunction>
									
									<h:outputText value="#{jspMsg['label.th_other']}" style="margin:0 5px 0 5px;vertical-align:top;" styleClass="ms7" />
									
									<h:inputTextarea id="msa002tab0_terminateNote" value="#{semmsa002Bean.siteAppTab0ObjParam.terminateNote}" 
									rows="4" cols="50" style="width:88%;" styleClass="ms7"
									disabled="#{!semmsa002Bean.chkOtherWaitingFlag}">
									</h:inputTextarea>
								</td>
							</tr>
							<%--
							<tr>
								<td style="white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['label.th_status']} : " style="margin-left:5px;" styleClass="ms7" />
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.docStatusText}" styleClass="ms7" />
								</td>
							</tr>
							--%>
							<tr>
								<td style="white-space:nowrap; text-align:center;" colspan="2">
									
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				
		</rich:panel>	
		
		<rich:spacer height="5"></rich:spacer>
		
		<!-- >> panel 2 -->
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.terminateprocess']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 1 -->
				<rich:panel>
					<h:panelGroup style="width:100%;">
						<table style="width:100%; border:solid ececec 1px;">
							
							<tr>
								<td style="width:1%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_termprocessdt']} : " styleClass="ms7" />
									
								</td>
								<td style="white-space:nowrap;">
									
									<rich:calendar id="semmsa002tab0_terminateProcessDt" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppTab0ObjParam.termProcessDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="return dateformat.submitFomatDate(this);"
									   	   label=""
									   	   styleClass="ms7"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td style="width:1%; text-align:right; white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
								</td>
								<td style="white-space:nowrap;">
									
									<h:inputTextarea id="msa002tab0_terminateProcessNote" value="#{semmsa002Bean.siteAppTab0ObjParam.termProcessRemark}" 
									rows="4" cols="50" style="width:80%;" styleClass="ms7"
									disabled="#{semmsa002Bean.disabledModeViewOnly}">
									</h:inputTextarea>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</rich:panel>
		</rich:panel>
								
		
		<rich:spacer height="5"></rich:spacer>
		
		<!-- >> panel 3 -->
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.terminatesite']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 1 -->
				<rich:panel>
					<h:panelGroup style="width:100%;">
						<table style="width:100%; border:solid ececec 1px;">
							
							<tr>
								<td style="width:1%; text-align:right; white-space:nowrap;">
									
								</td>
								<td style="white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.rentalterminate']} : " styleClass="ms7" />
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.company}" style="font-style:italic; " styleClass="ms7" />
									
									<rich:spacer width="10"></rich:spacer>
									<h:outputText value="#{jspMsg['label.th_rentalTerWhen']} : " styleClass="ms7" />
									<rich:calendar id="semmsa002tab0_terminateRantDt" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppTab0ObjParam.terminateRantDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="return dateformat.submitFomatDate(this);"
									   	   label=""
									   	   styleClass="ms7"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
									</rich:calendar>
								</td>
							</tr>
							<tr>
								<td style="width:1%; text-align:right; white-space:nowrap;">
									<h:selectBooleanCheckbox id="msa002tab0_chkRentalDeposit" value="#{semmsa002Bean.chkReturnDepositFlag}" 
									disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="chkRentalDepositFunc();"/>
									
									<a4j:jsFunction name="chkRentalDepositFunc" action="#{semmsa002Action.doChkTerFunc}"
										reRender="msa002tab0_chkRentalDeposit, msa002tab0_returnDepositAmt,
										 semmsa002tab0_returnDepositDt, msa002tab0_chkNoReturnDeposit">
											<a4j:actionparam name="chkType" value="01"></a4j:actionparam>
									</a4j:jsFunction>
								</td>
								<td style="white-space:nowrap;">
									<h:outputText value="#{jspMsg['label.rentaldepositamt']} :"  styleClass="ms7" />
									<rich:spacer width="5"></rich:spacer>
									<h:inputText id="msa002tab0_returnDepositAmt" value="#{semmsa002Bean.siteAppTab0ObjParam.returnDepositAmt}" maxlength="17" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
												style="text-align:right;"
			              						onblur="return numberformat.moneyFormat(this);"
			              						onfocus="return numberformat.setCursorPosToEnd(this);"
												disabled="#{semmsa002Bean.disabledModeViewOnly || 
												(!semmsa002Bean.chkReturnDepositFlag || semmsa002Bean.chkNoReturnDepositFlag)}">
													<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
									</h:inputText>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.baht']}"  styleClass="ms7" />
									
									<rich:spacer width="10"></rich:spacer>
									<h:outputText value="#{jspMsg['label.th_returndepositDt']} : " styleClass="ms7" />
									
									<rich:calendar id="semmsa002tab0_returnDepositDt" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppTab0ObjParam.returnDepositDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="return dateformat.submitFomatDate(this);"
									   	   label=""
									   	   styleClass="ms7"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly || 
									   	   (!semmsa002Bean.chkReturnDepositFlag || semmsa002Bean.chkNoReturnDepositFlag)}">
									</rich:calendar>
									
									
									<rich:spacer width="20"></rich:spacer>
									
									<h:selectBooleanCheckbox id="msa002tab0_chkNoReturnDeposit" value="#{semmsa002Bean.chkNoReturnDepositFlag}" 
									onclick="noReturnDepositFunc();"
									disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
									
									<a4j:jsFunction name="noReturnDepositFunc" action="#{semmsa002Action.doChkTerFunc}"
									reRender="msa002tab0_returnDepositAmt, semmsa002tab0_returnDepositDt, msa002tab0_chkRentalDeposit">
										<a4j:actionparam name="chkType" value="04"></a4j:actionparam>
									</a4j:jsFunction>
									
									<h:outputText value="#{jspMsg['label.th_noreturndep']}" styleClass="ms7" />
								</td>
								
							</tr>
							<tr>
								<td style="width:1%; text-align:right; white-space:nowrap;">
									<h:selectBooleanCheckbox id="msa002tab0_chkCancelMeterFlag" value="#{semmsa002Bean.chkCancelMeterFlag}" 
									disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
								</td>
								<td style="white-space:nowrap;">
								
									
									<h:outputText value="#{jspMsg['label.th_cancelMeter']} : " styleClass="ms7" />
									
									
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.company}" style="font-style:italic;" styleClass="ms7" />
									
									<rich:spacer width="20"></rich:spacer> 
									<h:selectBooleanCheckbox id="msa002tab0_chkTerminateElFlag" value="#{semmsa002Bean.chkTerminateElFlag}" 
									disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
									
									<h:outputText value="#{jspMsg['label.th_terminateEL']}" styleClass="ms7" />
								</td>
							</tr>
							<tr>
								<td style="width:1%; text-align:right; white-space:nowrap;" valign="top">
									<h:selectBooleanCheckbox id="msa002tab0_chkOtherTerminateFlag" value="#{semmsa002Bean.chkOtherTerminateFlag}" 
									disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="chkOtherTerminateFunc();"/>
									
									<a4j:jsFunction name="chkOtherTerminateFunc" action="#{semmsa002Action.doChkTerFunc}"
										reRender="msa002tab0_chkOtherTerminateFlag, msa002tab0_otherTerminateNote">
											<a4j:actionparam name="chkType" value="03"></a4j:actionparam>
									</a4j:jsFunction>
								</td>
								<td style="white-space:nowrap;" valign="top">
									
									
									<h:outputText value="#{jspMsg['label.th_other']}" style="vertical-align:top;" styleClass="ms7" />
									<rich:spacer width="10"></rich:spacer>
									<h:inputTextarea id="msa002tab0_otherTerminateNote" value="#{semmsa002Bean.siteAppTab0ObjParam.otherTerminateNote}" 
									rows="4" cols="50" style="width:80%;" styleClass="ms7"
									disabled="#{semmsa002Bean.disabledModeViewOnly || !semmsa002Bean.chkOtherTerminateFlag}">
									</h:inputTextarea>
								</td>
							</tr>
							<%--
							<tr>
								<td style="white-space:nowrap;" colspan="2">
									<h:outputText value="#{jspMsg['label.th_status']} : " style="margin-left:5px;" styleClass="ms7" />
									<h:outputText value="#{semmsa002Bean.siteAppTab0ObjParam.docStatusText}" styleClass="ms7" />
								</td>
							</tr>
							--%>
						</table>
					</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				
		</rich:panel>
		
		<h:panelGrid width="100%">
			<table align="center">
				<tr>
					<td style="white-space:nowrap; text-align:center;" >
						<a4j:commandButton style="margin-left:5px;" id="msa002tab0_BtnSave" styleClass="rich-button" 
						action="#{semmsa002Action.doUpdateTsTerminate}" value="SAVE" 
						reRender="oppContent, frmAllInitTab, panelTab, panelTab0"
						oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
										
						</a4j:commandButton>
					</td>
				</tr>
			</table>
		</h:panelGrid>
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
