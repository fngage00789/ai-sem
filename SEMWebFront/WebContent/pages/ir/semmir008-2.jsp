<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmir008" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.info.name']}"/>
		</f:facet>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearchIR008">
				<h:panelGrid width="95%">
					<rich:panel id="panDetail1">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.policyInfo.name']}" />
						</f:facet>
		                <h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
		                <table width="100%">
			            	 <tr>
			                 	<td align="right" width="40%">
			                 		<h:outputText id="lblPolicyDraftID" value="#{jspMsg['label.policyDraftID']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtPolicyDraftID" value="#{semmir008Bean.policyInfo.draftNo}" />
								</td>
			                 </tr>	 
			                  <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtNetworkType" value="#{semmir008Bean.policyInfo.networkTypeDesc}" />
								</td>
			                 </tr>	    
			                  <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblTransferType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtTransgerType" value="#{semmir008Bean.policyInfo.transferTypeDesc}" />
								</td>
			                 </tr>	 
			                  <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblInsuranceType" value="#{jspMsg['label.insuranceType']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtInsuranceType" value="#{semmir008Bean.policyInfo.policyTypeDesc}" />
								</td>
			                 </tr>	     
			                 <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblCompany" value="#{jspMsg['label.company']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtCompany" value="#{semmir008Bean.policyInfo.companyDesc}" />
								</td>
			                 </tr>	
			                 <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblAddress" value="#{jspMsg['label.address']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtAddress" value="#{semmir008Bean.policyInfo.address}" />
								</td>
			                 </tr>	
			                 <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblTotalLocation" value="#{jspMsg['label.totalLocation']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtTotalLocation" value="#{semmir008Bean.policyInfo.totalLoacation}" />
								</td>
			                 </tr>	   
		                  
		                </table>
		                </h:panelGroup></h:panelGrid>
		                 
		            </rich:panel>
				</h:panelGrid>
				<h:panelGrid width="95%">
					<rich:panel id="panDetail2">
					  <h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
							<table width="100%">
								<tr>
				                 	<td align="right" width="40%">
				                 		<h:outputText id="lblPeriodOfInsurance" value="#{jspMsg['label.insuredDt']}" styleClass="ms7"/>
									</td>
									<td>
				                 		<h:inputText id="txtPeriodOfInsurance" size="5" value="#{semmir008Bean.policyInfo.daydiff}" disabled="true"/>
				                 		<rich:spacer width="20"/>
				                 		<h:outputText id="lblText" value="#{jspMsg['label.day']}" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td align="right">
										<h:outputText id="lblPolicyStartDt" value="#{jspMsg['label.startDate']}" styleClass="ms7" />
									</td>
									<td>
										<rich:calendar id="cldPolicyStartDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir008Bean.policyInfo.policyStartDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['labe.startDate']}"
										disabled="false">
											<a4j:support event="onchanged" reRender="txtPeriodOfInsurance" action="#{semmir008Action.calDiffDate}" />
										</rich:calendar>
										<rich:spacer width="20"/>
										<h:outputText id="lblPolicyStartTM" value="#{jspMsg['label.time']}"  styleClass="ms7"/>
										<rich:spacer width="20"/>
										<h:selectOneMenu id="ddlPolicyStartTM1" value="#{semmir008Bean.policyInfo.policyStartTM1}">
											<f:selectItems value="#{semmir008Bean.hourList}" />
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:outputText value=":" />
										<rich:spacer width="10"/>
										<h:selectOneMenu id="ddlPolicyStartTM2" value="#{semmir008Bean.policyInfo.policyStartTM2}">
											<f:selectItems value="#{semmir008Bean.minuteList}" />
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:outputText value="#{jspMsg['label.timeMin']}" styleClass="ms7"/>
									</td>
				                </tr>
				                <tr>
									<td align="right">
										<h:outputText id="lblPolicyEndDt" value="#{jspMsg['label.endDate']}" styleClass="ms7" />
									</td>
									<td>
										<rich:calendar id="cldPolicyEndDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
			                			value="#{semmir008Bean.policyInfo.policyEndDt}" 
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.endDate']}"
										disabled="false">
											<a4j:support event="onchanged" reRender="txtPeriodOfInsurance" action="#{semmir008Action.calDiffDate}" />
										</rich:calendar>
										<rich:spacer width="20"/>
										<h:outputText id="lblPolicyEndTM" value="#{jspMsg['label.time']}" styleClass="ms7"/>
										<rich:spacer width="20"/>
										<h:selectOneMenu id="ddlPolicyEndTM1" value="#{semmir008Bean.policyInfo.policyEndTM1}">
											<f:selectItems value="#{semmir008Bean.hourList}" />
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:outputText value=":" />
										<rich:spacer width="10"/>
										<h:selectOneMenu id="ddlPolicyEndTM2" value="#{semmir008Bean.policyInfo.policyEndTM2}">
											<f:selectItems value="#{semmir008Bean.minuteList}" />
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:outputText id="lbltime2" value="#{jspMsg['label.timeMin']}" styleClass="ms7"/>
									</td>
				                </tr>	
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblInsuranceAmt" value="#{jspMsg['label.insuranceAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtInsuranceAmt" value="#{semmir008Bean.policyInfo.insuredAmt}" >
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="10"/>
				                		<h:outputText value="#{jspMsg['label.bath']}"/>
				                		<rich:spacer width="20"/>
				                		<h:selectBooleanCheckbox id="limitLostCheckBox" value="#{semmir008Bean.policyInfo.limitLostFlag}" >
				                			<a4j:support event="onclick" reRender="txtLimitLost"/>
										</h:selectBooleanCheckbox>
										<h:outputText id="lblLimitLost" value="#{jspMsg['label.limitLost']}" styleClass="ms7"/>
										<rich:spacer width="20"/>
										<h:inputText id="txtLimitLost" value="#{semmir008Bean.policyInfo.limitLostAmt}" disabled="#{!semmir008Bean.policyInfo.limitLostFlag}"
										onkeypress="return numberformat.keyPressDecimalCustomize(15, this, event);" 
										onblur="return numberformat.moneyFormat(this);"
										onfocus="return numberformat.setCursorPosToEnd(this);"
										maxlength="18">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="3" maxFractionDigits="2" />
										</h:inputText>
										<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblDeductAmt" value="#{jspMsg['label.deductAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtDeductAmt" value="#{semmir008Bean.policyInfo.deductAmt}">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblPremiumRate" value="#{jspMsg['label.premiumRate']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtPremiumRate" value="#{semmir008Bean.policyInfo.premiumRate}"/>
				                	</td>
				                </tr>
				                 <tr>
				                	<td align="right">
				                		<h:outputText id="lblPremiumAmt" value="#{jspMsg['label.premiumAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtPremiumAmt" value="#{semmir008Bean.policyInfo.premiumAmt}">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblDutyAmt" value="#{jspMsg['label.dutyAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtDutyAmt" value="#{semmir008Bean.policyInfo.dutyAmt}">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblVatAmt" value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtVatAmt" value="#{semmir008Bean.policyInfo.vatAmt}">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblTotalPremiumAmt" value="#{jspMsg['label.totalPremiumAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtTotalPremiumAmt" value="#{semmir008Bean.policyInfo.totalPremiumAmt}">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblInsuredName" value="#{jspMsg['label.insuredName']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:inputText id="txtInsuredName" value="#{semmir008Bean.policyInfo.insuredName}" size="60"
				                		disabled="#{semmir008Bean.policyInfo.disableInsured}"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblDocDt" value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<rich:calendar id="cldDocDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir008Bean.policyInfo.docDate}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['labe.docDt']}"
										disabled="false">
										</rich:calendar>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblPolicyDt" value="#{jspMsg['label.policyDt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<rich:calendar id="cldPolicyDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir008Bean.policyInfo.policyDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.policyDt']}"
										disabled="false">
										</rich:calendar>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" valign="top">
				                		<h:outputText id="lblRemark" value="#{jspMsg['label.remark']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:inputTextarea id="txtRemark" cols="60" value="#{semmir008Bean.policyInfo.remark}"/>
				                	</td>
				                </tr>
				            </table>
			            </h:panelGroup></h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="95%">
					<rich:panel id="panDetail3">
						 <h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
						 <table width="100%">
							<tr>
								<td align="right" width="40%" >
									<h:outputText id="lblForMonth" value="#{jspMsg['label.forMonth']}" styleClass="ms7"/>
								</td>
								<td >
									<h:selectOneMenu id="lblMonth" value="#{semmir008Bean.policyInfo.forMonth}">
										<f:selectItems value="#{semmir008Bean.monthList}"  />
									</h:selectOneMenu>
									<rich:spacer width="10"/>
									<h:selectOneMenu id="lblYear" value="#{semmir008Bean.policyInfo.forYear}">
										<f:selectItems value="#{semmir008Bean.yearList}" />
									</h:selectOneMenu>
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText id="lblRefNo" value="#{jspMsg['label.refNo']}" styleClass="ms7"/>
								</td>
								<td>
									<h:inputText id="txtRefNo" value="#{semmir008Bean.policyInfo.refPolicyNo}"/>
									<rich:spacer width="40"/>
									<h:outputText id="lblRefDt" value="#{jspMsg['label.refDt']}" styleClass="ms7"/>
									<rich:spacer width="10"/>
									<rich:calendar id="cldRefDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir008Bean.policyInfo.refDate}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.refDt']}"
										disabled="false">
									</rich:calendar>
							</tr>						 
						 </table>
						 </h:panelGroup></h:panelGrid>
		                  		
				            	
					</rich:panel>
				</h:panelGrid>
				<br></br>
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir013Bean.renderedMsgFormTop}"/>
				</div>
				<h:panelGrid columns="13" id="grdSearchCommand">
					<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmSearchIR008" >
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMMIR008-2" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
						<a4j:actionparam name="methodWithNavi" value="doSave" />
					</a4j:commandButton><rich:spacer width="10"/>	
	            	<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
	            		action="#{navAction.navi}" reRender="frmSearchIR008,frmResult,oppContent">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMMIR008-1" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
						<a4j:actionparam name="methodWithNavi" value="doBack" />
	            	</a4j:commandButton><rich:spacer width="10"/>	
	            	<a4j:commandButton id="btnPrintDraft" value="#{jspMsg['btn.printDraft']}" styleClass="rich-button" 
	            		action="#{navAction.navi}" reRender="frmSearchIR008,pnlShowReport">
	            		<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMMIR008-2" />
						<a4j:actionparam name="moduleWithNavi" value="report" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR008RPT" />
						<a4j:actionparam name="methodWithNavi" value="doRunReport" />
	            		
	            		<a4j:support event="oncomplete" reRender="frmError, frmSearchIR008, pnlShowReport" rendered="#{semmir008RPTBean.displayShowReport}"/>
					
	            	</a4j:commandButton> 
	            	
	            	<rich:spacer width="10"/>
	            	
	            		
	            	
	            	 <h:commandButton id ="btnExport" action="#{semmir008Action.doExportExcel}" value="#{jspMsg['btn.exportDetail']}"
						styleClass="rich-button"  ><rich:spacer width="10"/>	
					</h:commandButton><rich:spacer width="10"/>
	            	
	            	<a4j:commandButton id="btnImportFile"
					reRender="oppContent"
					value="#{jspMsg['btn.uploadInfo']}" styleClass="rich-button"
					style="width:110"
					oncomplete="#{rich:component('popupImportFile')}.show(); return false" >
					</a4j:commandButton><rich:spacer width="10"/>	
	            	
	            	<a4j:commandButton id="btnUploadPicture"
					action="#{navAction.navi}"
					reRender="oppContent,popupUploadPic"
					value="#{jspMsg['btn.uploadPicture']}" styleClass="rich-button"
					style="width:110"
					oncomplete="#{rich:component('popupUploadPic')}.show(); return false" >
						<a4j:actionparam name="navModule" value="common" />
						<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
						<a4j:actionparam name="moduleWithNavi" value="common" />
						<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
						<a4j:actionparam name="methodWithNavi" value="init" />
						<a4j:actionparam name="refId" value="#{semmir008Bean.policyInfo.draftNo}" />
						<a4j:actionparam name="attachModule" value="IR_DRAFT"/>
					</a4j:commandButton>
					<rich:spacer width="10"/>	
					<a4j:commandButton id="btnDeleteDraft" value="#{jspMsg['btn.deleteDraft']}" styleClass="rich-button" action="#{navAction.navi}"
						reRender="frmSearchIR008" >
						<a4j:actionparam name="navModule" value="ir" />
						<a4j:actionparam name="navProgram" value="SEMMIR008-2" />
						<a4j:actionparam name="moduleWithNavi" value="ir" />
						<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
						<a4j:actionparam name="methodWithNavi" value="doSave" />
						<a4j:actionparam name="deleteFlag" value="Y" />
					</a4j:commandButton>
				</h:panelGrid>
					
					
			</a4j:form>
			<jsp:include page="../../pages/popup/uploadpic-popup.jsp"/>
        </h:panelGrid>
        
    </rich:panel>
</h:panelGrid>
<a4j:form id="frmShowReport">
<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReport" rendered="#{semmir008RPTBean.displayShowReport}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmir008RPTAction.showReport}"  />								
		<script>document.getElementById('incContent:frmShowReport:bthShowReport').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>
<rich:modalPanel id="popupImportFile" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Upload Info"></h:outputText>
    </f:facet>
	<a4j:form id="frmUploadInfo">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left">
					<rich:fileUpload id="txtPicFileUpload" fileUploadListener="#{fileUploadBean.listener}"
								listHeight="50" listWidth="300"
								addControlLabel="Browse..."
								immediate="true"
								immediateUpload="true" uploadButtonClassDisabled="true" cleanButtonClassDisabled="true"
								autoclear="true" acceptedTypes="xls,xlsx" >
									<a4j:support event="onuploadcomplete" reRender="frmSearchIR008" action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR008" />
										<a4j:actionparam name="methodWithNavi" value="doUploadInfo" />
									</a4j:support>
									<a4j:support event="oncomplete" reRender="frmSearchIR008"/>
									<rich:componentControl for="popupImportFile" operation="hide" event="oncomplete"/>
										
					</rich:fileUpload>
					
				</td>
			</tr>
			<tr>
				<td align="left">
					<h:panelGrid columns="1" styleClass="contentlabelform">
						<a4j:commandButton id="btnPopupBack" value="Close" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="popupImportFile" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>
