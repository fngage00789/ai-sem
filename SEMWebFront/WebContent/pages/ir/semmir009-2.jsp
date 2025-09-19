<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.insurance.semmir009" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.info.name']}"/>
		</f:facet>
		<h:panelGrid id="panelError">
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir009Bean.renderedMsgFormSearch}">
		 		<f:facet name="header">
                      	<h:outputText value="Entered Data Status:"></h:outputText>
                  	</f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                   </f:facet>
            </rich:messages>
		</h:panelGrid>
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
			                 		<h:outputText id="lblPolicyID" value="#{jspMsg['label.policyID']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtPolicyDraftID" value="#{semmir009Bean.policyInfo.policyNo}" />
								</td>
			                 </tr>	 
			                  <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblNetworkType" value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtNetworkType" value="#{semmir009Bean.policyInfo.networkTypeDesc}" />
								</td>
			                 </tr>	    
			                  <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblTransferType" value="#{jspMsg['label.transferType']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtTransgerType" value="#{semmir009Bean.policyInfo.transferTypeDesc}" />
								</td>
			                 </tr>	 
			                  <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblInsuranceType" value="#{jspMsg['label.insuranceType']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtInsuranceType" value="#{semmir009Bean.policyInfo.policyTypeDesc}" />
								</td>
			                 </tr>	     
			                 <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblCompany" value="#{jspMsg['label.company']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtCompany" value="#{semmir009Bean.policyInfo.companyDesc}" />
								</td>
			                 </tr>	
			                 <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblAddress" value="#{jspMsg['label.address']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtAddress" value="#{semmir009Bean.policyInfo.address}" />
								</td>
			                 </tr>	
			                 <tr>
			                 	<td align="right">
			                 		<h:outputText id="lblTotalLocation" value="#{jspMsg['label.totalLocation']}" styleClass="ms7"/>
								</td>
								<td>
									<h:outputText id="txtTotalLocation" value="#{semmir009Bean.policyInfo.totalLoacation}" />
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
				                 		<h:inputText id="txtPeriodOfInsurance" size="5" value="#{semmir009Bean.policyInfo.daydiff}" disabled="true"/>
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
										value="#{semmir009Bean.policyInfo.policyStartDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['labe.startDate']}"
										disabled="true">
											<a4j:support event="onchanged" reRender="txtPeriodOfInsurance" action="#{semmir009Action.calDiffDate}" />
										</rich:calendar>
										<rich:spacer width="20"/>
										<h:outputText id="lblPolicyStartTM" value="#{jspMsg['label.time']}"  styleClass="ms7"/>
										<rich:spacer width="20"/>
										<h:selectOneMenu id="ddlPolicyStartTM1" value="#{semmir009Bean.policyInfo.policyStartTM1}" disabled="true">
											<f:selectItems value="#{semmir009Bean.hourList}" />
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:outputText value=":" />
										<rich:spacer width="10"/>
										<h:selectOneMenu id="ddlPolicyStartTM2" value="#{semmir009Bean.policyInfo.policyStartTM2}" disabled="true">
											<f:selectItems value="#{semmir009Bean.minuteList}" />
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
			                			value="#{semmir009Bean.policyInfo.policyEndDt}" 
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.endDate']}"
										disabled="true">
											<a4j:support event="onchanged" reRender="txtPeriodOfInsurance" action="#{semmir009Action.calDiffDate}" />
										</rich:calendar>
										<rich:spacer width="20"/>
										<h:outputText id="lblPolicyEndTM" value="#{jspMsg['label.time']}" styleClass="ms7"/>
										<rich:spacer width="20"/>
										<h:selectOneMenu id="ddlPolicyEndTM1" value="#{semmir009Bean.policyInfo.policyEndTM1}" disabled="true">
											<f:selectItems value="#{semmir009Bean.hourList}" />
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:outputText value=":" />
										<rich:spacer width="10"/>
										<h:selectOneMenu id="ddlPolicyEndTM2" value="#{semmir009Bean.policyInfo.policyEndTM2}" disabled="true">
											<f:selectItems value="#{semmir009Bean.minuteList}" />
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
				                		<h:outputText id="txtInsuranceAmt" value="#{semmir009Bean.policyInfo.insuredAmt}" >
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                				</h:outputText>
				                		<rich:spacer width="10"/>
				                		<h:outputText value="#{jspMsg['label.bath']}"/>
				                		<rich:spacer width="20"/>
				                		<h:selectBooleanCheckbox id="limitLostCheckBox" value="#{semmir009Bean.policyInfo.limitLostFlag}" disabled="true">
				                			<a4j:support event="onclick" reRender="txtLimitLost"/>
										</h:selectBooleanCheckbox>
										<h:outputText id="lblLimitLost" value="#{jspMsg['label.limitLost']}" styleClass="ms7"/>
										<rich:spacer width="20"/>
										<h:inputText id="txtLimitLost" value="#{semmir009Bean.policyInfo.limitLostAmt}" disabled="true"/>
										<rich:spacer width="20"/>
										<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblDeductAmt" value="#{jspMsg['label.deductAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtDeductAmt" value="#{semmir009Bean.policyInfo.deductAmt}">
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
				                		<h:outputText id="txtPremiumRate" value="#{semmir009Bean.policyInfo.premiumRate}"/>
				                	</td>
				                </tr>
				                 <tr>
				                	<td align="right">
				                		<h:outputText id="lblPremiumAmt" value="#{jspMsg['label.premiumAmt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:outputText id="txtPremiumAmt" value="#{semmir009Bean.policyInfo.premiumAmt}">
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
				                		<h:outputText id="txtDutyAmt" value="#{semmir009Bean.policyInfo.dutyAmt}">
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
				                		<h:outputText id="txtVatAmt" value="#{semmir009Bean.policyInfo.vatAmt}">
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
				                		<h:outputText id="txtTotalPremiumAmt" value="#{semmir009Bean.policyInfo.totalPremiumAmt}">
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
				                		<h:inputText id="txtInsuredName" value="#{semmir009Bean.policyInfo.insuredName}" 
				                		disabled="true"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right">
				                		<h:outputText id="lblDocDt" value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<rich:calendar id="cldDocDt" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
										value="#{semmir009Bean.policyInfo.docDate}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['labe.docDt']}"
										disabled="true">
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
										value="#{semmir009Bean.policyInfo.policyDt}"
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.policyDt']}"
										disabled="true">
										</rich:calendar>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" valign="top">
				                		<h:outputText id="lblRemark" value="#{jspMsg['label.remark']}" styleClass="ms7"/>
				                	</td>
				                	<td>
				                		<h:inputTextarea id="txtRemark" cols="60" value="#{semmir009Bean.policyInfo.remark}" disabled="true"/>
				                	</td>
				                </tr>
				            </table>
				            	<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
				            		action="#{navAction.navi}" reRender="frmSearchIR008,frmResult,oppContent">
				            		<a4j:actionparam name="navModule" value="#{semmir009Bean.navModuleFrom}" />
									<a4j:actionparam name="navProgram" value="#{semmir009Bean.navProgramFrom}" />
									<a4j:actionparam name="moduleWithNavi" value="#{semmir009Bean.navModuleFrom}" />
									<a4j:actionparam name="actionWithNavi" value="#{semmir009Bean.actionWithNaviFrom}" />
									<a4j:actionparam name="methodWithNavi" value="doBack" />
				            	</a4j:commandButton>
				            	<rich:spacer width="10"/>
				            	
				            	 <h:commandButton id ="btnExport" action="#{semmir009Action.doExportExcel}" value="#{jspMsg['btn.exportDetail']}"
									styleClass="rich-button"  >
								</h:commandButton>
				            	
				            	
				            	<rich:spacer width="10"/>
				            	
				            	<a4j:commandButton id="btnUploadPicture"
								action="#{navAction.navi}"
								reRender="oppContent"
								value="#{jspMsg['btn.viewPicture']}" styleClass="rich-button"
								style="width:110"
								oncomplete="#{rich:component('popupUploadPic')}.show(); return false" >
								<a4j:actionparam name="navModule" value="common" />
								<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
								<a4j:actionparam name="moduleWithNavi" value="common" />
								<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
								<a4j:actionparam name="methodWithNavi" value="init" />
								<a4j:actionparam name="refId" value="#{semmir009Bean.policyInfo.draftNo}" />
								</a4j:commandButton>
			            </h:panelGroup></h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			</a4j:form>
			<jsp:include page="../../pages/popup/uploadpic-popup.jsp"/>
        </h:panelGrid>
    </rich:panel>
</h:panelGrid>
