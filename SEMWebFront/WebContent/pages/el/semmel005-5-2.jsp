<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.el.semmel005-5" var="jspMsg"/>
<a4j:form id="frm5-5">
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.updateTextFile']}"/></f:facet>
		<h:panelGrid>
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			
		</h:panelGrid>
			
			<h:panelGrid width="90%">
				
					<h:panelGroup id="pnlBtHead">
						<table width="100%">
							<tr>
								<td width="50%" align="left">
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td align="right">
												<a4j:commandButton id="btnCancel"
													value="#{jspMsg['btn.back']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													rendered="#{!semmel005Bean.defineBackPage}">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="backToPage4" />
												</a4j:commandButton>
												<a4j:commandButton id="btnBack"
													value="#{jspMsg['btn.back']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													rendered="#{semmel005Bean.defineBackPage}">
													<a4j:actionparam name="navModule" value="#{semmel005Bean.navModuleFrom}" />
													<a4j:actionparam name="navProgram" value="#{semmel005Bean.navProgramFrom}" />
													<a4j:actionparam name="moduleWithNavi" value="#{semmel005Bean.navModuleFrom}" />
													<a4j:actionparam name="actionWithNavi" value="#{semmel005Bean.actionWithNaviFrom}" />
													<a4j:actionparam name="methodWithNavi" value="#{semmel005Bean.methodWithNaviFrom}" />												
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnSave"
													value="#{jspMsg['btn.save']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent" disabled="#{semmel005Bean.viewFlag}"
													rendered="#{!semmel005Bean.defineRefreshMethod}">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doUpdateELPAY07" />
												</a4j:commandButton>
												<a4j:commandButton id="btnSave2"
													value="#{jspMsg['btn.save']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent"
													rendered="#{semmel005Bean.defineRefreshMethod}" disabled="#{semmel005Bean.viewFlag}">
													<a4j:actionparam name="navModule" value="#{semmel005Bean.navModuleFrom}" />
													<a4j:actionparam name="navProgram" value="#{semmel005Bean.navProgramFrom}" />
													<a4j:actionparam name="moduleWithNavi" value="#{semmel005Bean.navModuleFrom}" />
													<a4j:actionparam name="actionWithNavi" value="#{semmel005Bean.actionWithNaviFrom}" />
													<a4j:actionparam name="methodWithNavi" value="#{semmel005Bean.methodB4Refresh}" />
													<a4j:actionparam name="methodToRefresh" value="#{semmel005Bean.methodToRefresh}" />
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnAllCancel"
													value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent" rendered="false">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doClear5" />
													<a4j:actionparam name="rowId" value="#{semmel005Bean.uploadText.rowId}" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					
				</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.fileData']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtCompany" value="#{semmel005Bean.importTransaction.company}" disabled="true" style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">&nbsp;</td>
										<td width="30%">&nbsp;</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileType']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtFileType" value="#{semmel005Bean.importTransaction.fileTypeDisplay}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtFileName" value="#{semmel005Bean.importTransaction.fileName}" disabled="true"
												style="width:180px;" maxlength="15"/>
									</tr>									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.refDocId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtRefDocId" value="#{semmel005Bean.importTransaction.refDocId}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadDt']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtUploadDt" value="#{semmel005Bean.importTransaction.uploadDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDt']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtProcessDt" value="#{semmel005Bean.importTransaction.processDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">
											</h:inputText>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.validateFailed']}" styleClass="ms7" rendered="#{semmel005Bean.navProgramFrom != 'SEMMEL005-3'}"/>
											<h:outputText value="#{jspMsg['label.validateSuccess']}" styleClass="ms7" rendered="#{semmel005Bean.navProgramFrom == 'SEMMEL005-3'}"/>
										</td>
										<td width="30%">
											<h:inputText id="txtValidateSuccess" value="#{semmel005Bean.importTransaction.validateFailed}" disabled="true"
												style="width:180px;" maxlength="15" rendered="#{semmel005Bean.navProgramFrom != 'SEMMEL005-3'}">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
											<h:inputText id="txtValidateEL0053" value="#{semmel005Bean.importTransaction.validateSuccess}" disabled="true"
												style="width:180px;" maxlength="15" rendered="#{semmel005Bean.navProgramFrom == 'SEMMEL005-3'}">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.failedPaid']}" styleClass="ms7" rendered="#{semmel005Bean.navProgramFrom != 'SEMMEL005-3'}"/>
											<h:outputText value="#{jspMsg['label.successPaid']}" styleClass="ms7" rendered="#{semmel005Bean.navProgramFrom == 'SEMMEL005-3'}"/>
										</td><td width="30%">
											<h:inputText id="txtSuccessPaid" value="#{semmel005Bean.importTransaction.failedPaid}" disabled="true"
												style="width:180px;" maxlength="15" rendered="#{semmel005Bean.navProgramFrom != 'SEMMEL005-3'}">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
											<h:inputText id="txtSuccessPaidEL0053" value="#{semmel005Bean.importTransaction.successPaid}" disabled="true"
												style="width:180px;" maxlength="15" rendered="#{semmel005Bean.navProgramFrom == 'SEMMEL005-3'}">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>	
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.successNoPaid']}" styleClass="ms7" rendered="#{semmel005Bean.navProgramFrom == 'SEMMEL005-3'}"/>
											<h:outputText value="#{jspMsg['label.failedNoPaid']}" styleClass="ms7" rendered="#{semmel005Bean.navProgramFrom != 'SEMMEL005-3'}"/>
										</td>
										<td width="30%">
											<h:inputText id="txtSuccessNoPaid" value="#{semmel005Bean.importTransaction.failedNoPaid}" disabled="true"
												style="width:180px;" maxlength="15" rendered="#{semmel005Bean.navProgramFrom != 'SEMMEL005-3'}">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
											<h:inputText id="txtSuccessEL0053" value="#{semmel005Bean.importTransaction.successNoPaid}" disabled="true"
												style="width:180px;" maxlength="15" rendered="#{semmel005Bean.navProgramFrom == 'SEMMEL005-3'}">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchCriteria2">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterDetail']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtmeterId" value="#{semmel005Bean.uploadText.meterId}" 
												style="width:180px;" maxlength="15" disabled="true"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.areaCode']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtareaCode" value="#{semmel005Bean.uploadText.areaCode}" 
												style="width:180px;" maxlength="15" disabled="true"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.areaName']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtInvNo" value="#{semmel005Bean.uploadText.areaName}" 
												style="width:180px;" maxlength="15" disabled="true"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtMeterId" value="#{semmel005Bean.uploadText.region.rowId}" 
												style="width:180px;" maxlength="15" disabled="true"/>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtprovince" value="#{semmel005Bean.uploadText.province.thaiName}" 
												style="width:180px;" maxlength="15" disabled="true"/>
										</td>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7"/></td>
										<td width="30%"><h:inputText id="txtamphur" value="#{semmel005Bean.uploadText.amphur.thaiName}" 
												style="width:180px;" maxlength="15" disabled="true"/></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.billperiod']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtbillperiod" value="#{semmel005Bean.uploadText.billPeriodTH}" 
												style="width:180px;" maxlength="15" disabled="true">
											</h:inputText>
										</td>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.invAmt']}" styleClass="ms7"/></td>
										<td width="30%">
											<h:inputText id="txtinvAmt" value="#{semmel005Bean.uploadText.invAmt}" 
											style="width:180px;" maxlength="15" disabled="true">
											<f:convertNumber pattern="#,##0.00"/>
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.invVatAmt']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtinvVatAmt" value="#{semmel005Bean.uploadText.invVatAmt}" 
												style="width:180px;" maxlength="15" disabled="true">
												<f:convertNumber pattern="#,##0.00"/>
											</h:inputText>
										</td>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.errorCode']}" styleClass="ms7"/></td>
										<td width="30%"><h:inputText id="txterrorCode" value="#{semmel005Bean.uploadText.errorDesc}" 
												style="width:180px;" maxlength="15" disabled="true"/></td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="90%">
					<rich:panel id="pnlInvalidCompanyName">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.invalidCompanyName']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											&nbsp;
										</td><td>
											<h:selectBooleanCheckbox value="#{semmel005Bean.companyFlag}" style="width: 20px">
												
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="90%">
					<rich:panel id="pnlInvalidMeterType">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.invalidMeterType']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											&nbsp;
										</td><td>
											<h:selectBooleanCheckbox value="#{semmel005Bean.meterTypeFlag}" style="width: 20px">
												
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
											<a4j:commandButton id="btnSearch2" value="#{jspMsg['btn.meterInfo']}" styleClass="rich-button" 
											 disabled="#{semmel005Bean.meterInfoDisplayFlag or semmel005Bean.viewFlag}"
											 action="#{navAction.navi}" reRender="oppContent">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
												<a4j:actionparam name="methodWithNavi" value="initUpdateMeterInfo" />
												<a4j:actionparam name="electricId" value="#{semmel005Bean.uploadText.electricId.rowId}" />
												<a4j:actionparam name="contractNo" value="#{semmel005Bean.uploadText.contractNo}" />
												<a4j:actionparam name="isComeFromOtherPage" value="Y"/>
												<a4j:actionparam name="navProgramFrom" value="SEMMEL005-5" />
												<a4j:actionparam name="navModuleFrom" value="el" />
												<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
												<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											</a4j:commandButton>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="90%">
					<rich:panel id="pnlInvalidTOD">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.invalidTODTOU']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											&nbsp;
										</td><td>
										    <h:selectBooleanCheckbox value="#{semmel005Bean.todtouFlag}" style="width: 20px">
												
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
											<a4j:commandButton id="btnSearch22" value="#{jspMsg['btn.meterInfo']}" styleClass="rich-button"
											                    disabled="#{semmel005Bean.meterInfoDisplayFlag or semmel005Bean.viewFlag}" 
																action="#{navAction.navi}" reRender="oppContent">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
												<a4j:actionparam name="methodWithNavi" value="initUpdateMeterInfo" />
												<a4j:actionparam name="electricId" value="#{semmel005Bean.uploadText.electricId.rowId}" />
												<a4j:actionparam name="contractNo" value="#{semmel005Bean.uploadText.contractNo}" />
												<a4j:actionparam name="isComeFromOtherPage" value="Y"/>
												<a4j:actionparam name="navProgramFrom" value="SEMMEL005-5" />
												<a4j:actionparam name="navModuleFrom" value="el" />
												<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
												<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											</a4j:commandButton>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlInvalidCT">
						<f:facet name="header">
							<h:outputText value="432421" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%"></td><td width="30%">
											<h:selectBooleanCheckbox value="#{semmel005Bean.ctFlag}" style="width: 20px">
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
										</td><td align="right" width="20%"></td><td width="30%"></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ct']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtpCtFlag" value="#{semmel005Bean.uploadText.ct}" 
												style="width:180px;" maxlength="15"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"/>
										</td>
										<td align="right" width="20%">&nbsp;</td><td width="30%">&nbsp;</td></tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				
				<h:panelGrid width="90%">
					<rich:panel id="pnlInvalidKwh">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.invalidKWH']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%"  border="0">									
									<tr>
										<td align="right" width="20%" >
										</td>
										<td width="30%">
											<h:selectBooleanCheckbox value="#{semmel005Bean.kwhFlag}" style="width: 20px">
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
										</td>
										<td align="right" width="20%">
										</td>
                                        <td width="30%">
                                       </td>
									</tr>
									
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.pRead']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtpRead" value="#{semmel005Bean.uploadText.pRead}" 
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" >
											<h:outputText value="#{jspMsg['label.lRead']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtlRead" value="#{semmel005Bean.uploadText.lRead}" 
												style="width:180px;" maxlength="15"/>
									</tr>	
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.kwhTotal']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtkwhTotal" value="#{semmel005Bean.uploadText.kwhTotal}" 
												style="width:180px;" maxlength="15">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>
										<td align="right" ></td>
										<td>&nbsp;</td>
									</tr>
								   <tr>
										<td align="right" >
											<h:outputText value="#{jspMsg['label.pDt']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtpDt" value="#{semmel005Bean.uploadText.txtPDtTH}" 
											   disabled="true" style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" >
											<h:outputText value="#{jspMsg['label.lDt']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtlDt" value="#{semmel005Bean.uploadText.txtLDtTH}" 
												disabled="true" style="width:180px;" maxlength="15"/>
									</tr>
									 <tr >
										<td align="right" >
											<h:outputText value="#{jspMsg['label.termOfPayment']}" styleClass="ms7"/>
										</td>
										<td>
										<h:selectOneRadio value="#{semmel005Bean.uploadText.termOfPayment}"
										
										styleClass="ms7" disabled="flase" rendered="#{semmel005Bean.billPreriodFlag}"
							                layout="lineDirection"
							                onclick="doTermOfPayment();">
					                				<f:selectItem itemValue="01" itemLabel="#{semmel005Bean.uploadText.txtBillPDtTH}"  />
					                				<f:selectItem itemValue="02" itemLabel="#{semmel005Bean.uploadText.txtBillLDtTH}"
					                				/>	
					                	</h:selectOneRadio>
					                	<h:selectOneRadio value="#{semmel005Bean.uploadText.termOfPayment}"
										
										styleClass="ms7" disabled="flase" 
										rendered="#{semmel005Bean.oneBillPreriodFlag}"
							                layout="lineDirection"
							                onclick="doTermOfPayment();">
					                				<f:selectItem itemValue="01" itemLabel="#{semmel005Bean.uploadText.txtBillPDtTH}"  />
					                	
					                	</h:selectOneRadio>		
					                	</td>
								
					                	<td  align="right">
					                	   <h:outputText value="#{jspMsg['label.termOfPaymentDetail']}" styleClass="ms7"/>
					                	   
					                	<h:inputText id="txtBillPreriodDt" value="#{semmel005Bean.uploadText.billPeriodTH}" 
										 rendered="flase" disabled="true" style="width:180px;" maxlength="15"/>
												
										<a4j:jsFunction name="doTermOfPayment" 
										reRender="frmError,txtBillPreriodDt,txtBillPreriodDt1,txtAreaTermOfPayment" 
										action="#{semmel005Action.selectTermOfPayment}"/>	
										
										</td>
								        <td>
								        <h:inputTextarea id= "txtAreaTermOfPayment" 
								        value="#{semmel005Bean.uploadText.termOfPaymentDetail}" 
											cols="40" rows="8"  disabled="flase"/>
								        </td>
										
									</tr>
									
									
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				
				<h:panelGrid width="90%">
					<rich:panel id="pnlOnlyServiceAmount">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.onlyServiceAmount']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											&nbsp;
										</td>
										<td>
										    <h:selectBooleanCheckbox value="#{semmel005Bean.serviceFlag}" style="width: 20px">
												
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="90%">
					
					<rich:panel id="pnlUpdateCal">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.updateDataFoCal']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%"></td><td width="30%">
											<h:selectBooleanCheckbox value="#{semmel005Bean.dataFlag}" style="width: 20px">
											</h:selectBooleanCheckbox>
											<h:outputText value="#{jspMsg['label.notChcek']}" styleClass="ms7"/>
										</td><td align="right" width="20%"></td><td width="30%"></td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.invAmt']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.invAmt}" style="width : 160px">
											<f:convertNumber pattern="#,##0.00"/>
											</h:inputText>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.invVatAmt']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.invVatAmt}" style="width : 160px">
											<f:convertNumber pattern="#,##0.00"/>
											</h:inputText>
										</td>
									</tr>	
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.unit']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.unit}" style="width : 160px">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.electOnpeak']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.electOnpeak}" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.electOffpeak']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.electOffpeak}" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.electDemandOn']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.electDemandOn}" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.electDemandPart']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.electDemandPart}" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.electDemandOff']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.electDemandOff}" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.reactive']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.reactive}" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.kwhTotal']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.kwhTotal}" style="width : 160px">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.kwhOn']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.kwhOn}" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.popup.kwhOff']}" styleClass="ms7" />					
										</td>
										<td align="left">
											<h:inputText value="#{semmel005Bean.uploadText.kwhOff}" style="width : 160px"/>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid>
				
			
		</h:panelGrid>
		<h:panelGrid width="90%" rendered="false">
				
					<h:panelGroup id="pnlBtHead2">
						<table width="100%">
							<tr>
								<td width="50%" align="left">
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr>
											<td align="right">
												<a4j:commandButton id="btnCancel29"
													value="#{jspMsg['btn.back']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="backToPage4" />
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnSave29"
													value="#{jspMsg['btn.save']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doUpdateELPAY07" />
												</a4j:commandButton>
											</td>
											<td align="right">
												<a4j:commandButton id="btnAllCancel29"
													value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
													action="#{navAction.navi}" reRender="oppContent" rendered="false">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
													<a4j:actionparam name="methodWithNavi" value="doClear5" />
													<a4j:actionparam name="rowId" value="#{semmel005Bean.uploadText.rowId}" />
												</a4j:commandButton>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					
				</h:panelGrid>
	</rich:panel>
</h:panelGrid>
</a4j:form>
