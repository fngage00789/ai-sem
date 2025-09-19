<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.insurance.semmir010" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir010Bean.renderedMsgFormTop}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mir001_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmir010Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
                              <a4j:actionparam name="navModule" value="ir" />
                              <a4j:actionparam name="navProgram" value="SEMMIR001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="ir" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMIR001" />
                              <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
                              <a4j:actionparam name="backWard" value="Y" />                        
                          </a4j:commandButton>
                    </td>
                </tr>
            </table>
              
          </h:form>
        </h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
							<td align="right" width="20%" valign="baseline">
									<h:panelGroup>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmir010Bean.policySP.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmir010Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmir010Bean.policySP.company}" styleClass="ms28"/>
				                	</td>
				                	
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.docType']}" styleClass="ms7"/>
									</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlDocType" value="#{semmir010Bean.policySP.docType}">
											<f:selectItems value="#{semmir010Bean.docTypeList}"/>
										</h:selectOneMenu>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlJobType" value="#{semmir010Bean.policySP.networkType}">
											<f:selectItems value="#{semmir010Bean.networkTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlTransferType" value="#{semmir010Bean.policySP.transferType}">
											<f:selectItems value="#{semmir010Bean.transferTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.policyType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPolicyType" value="#{semmir010Bean.policySP.policyType}">
											<f:selectItems value="#{semmir010Bean.policyTypeList}"/>
										</h:selectOneMenu>
		                			</td>
		                			<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.policyNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtPolicyNo" value="#{semmir010Bean.policySP.policyNo}"/>
		                				<rich:spacer width="15"></rich:spacer>
		                				<h:selectBooleanCheckbox id="insurancePay" value="#{semmir010Bean.payFlag}"></h:selectBooleanCheckbox>
		                				<rich:spacer width="2"></rich:spacer>
		                				<h:outputText value="#{jspMsg['label.payInsurence']}" styleClass="ms7"></h:outputText>
		                			</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="20%">				
										<h:panelGroup>
											<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
										</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentStatus" value="#{semmir010Bean.policySP.paymentStatus}"
		                				onchange="reRenderRcptPayChkBox();">
											<f:selectItems value="#{semmir010Bean.paymentStatusList}"/>
										</h:selectOneMenu>
										
										<!-- fixed by.. YUT 2014/09/16 >> -->
										<a4j:jsFunction name="reRenderRcptPayChkBox" reRender="rcptPayChkBox" oncomplete="rcptChk();"></a4j:jsFunction>
										<script type="text/javascript">
											function rcptChk(){
												jQuery(function($) {
													var payStat = $('#incContent\\:frmSearch\\:ddlPaymentStatus');
													var payChk = $('#incContent\\:frmSearch\\:rcptPayChkBox');
		
													if(payStat.val() != '13') {
														payChk.attr('checked', false);
													} 
												});
											}
										</script>
										<rich:spacer width="10"/>
										<h:selectBooleanCheckbox id="rcptPayChkBox" value="#{semmir010Bean.policySP.chkRcptPay}"   
										disabled="#{semmir010Bean.policySP.paymentStatus == '13' ? false : true}"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paySome']}" styleClass="ms7"/>
										<!-- fixed by.. YUT 2014/09/16 << -->
										
		                			</td>
		                			<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtBatchNo" value="#{semmir010Bean.policySP.batchNo}" />
		                			</td>
			                	 </tr>
			                	 <tr>
				                	<td align="right" width="20%">
				                	<h:outputText value="#{jspMsg['label.dueDate']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldDueDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmir010Bean.policySP.dueDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.dueDate']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   >
										</rich:calendar>
		                			 	<rich:spacer width="10"/>
		                			 
		                			 	<rich:calendar id="cldDueDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmir010Bean.policySP.dueDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['label.dueDate']}"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
											   >
										</rich:calendar>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
			                			<h:selectOneMenu id="ddlPayType" value="#{semmir010Bean.policySP.payType}">
											<f:selectItems value="#{semmir010Bean.payTypeList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.vendorCode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtVendorCode" value="#{semmir010Bean.policySP.vendorCode}" 
		                				style="margin-right:5px;" />
		                				
		                				<!-- >> fixed by.. YUT 2015/10/18 -->
			                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
							            action="#{semmir010Action.initAddVendor}" reRender="oppContent,txtNavProgram"
							            oncomplete="#{rich:component('mir010PopUp_addVendor')}.show();">
										</a4j:commandButton>
			                			<!-- << -->
				                	</td>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtVendorName" value="#{semmir010Bean.policySP.vendorName}" />	
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtContrctNo" value="#{semmir010Bean.policySP.contractNo}" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtLocationCode" value="#{semmir010Bean.policySP.locationCode}" />
									</td>
				                </tr>
			                	 <tr>
			                	 	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtLocationId" value="#{semmir010Bean.policySP.locationId}" />
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputText id="txtLocationName" value="#{semmir010Bean.policySP.locationName}" />
									</td>
				                </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchResult">
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="pnlSearchResult,pnlSearchCriteria,btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,
										btnApprove,btnReject,btnExport,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,frmSearchResult">
			           			<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir010Bean.renderedMsgFormBottom}"/>
				</div>
				<h:panelGrid columns="18" id="grdSearchCommand">
							<a4j:commandButton id="btnTotalAmt" value="#{jspMsg['btn.totalDisbursement']}" styleClass="rich-button" disabled="#{semmir010Bean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:72"
							 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="AG" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancleTotalAmt" value="#{jspMsg['btn.cancleTotalDisbursement']}" styleClass="rich-button" disabled="#{semmir010Bean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:100"
							 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
							 	<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="CG" />
			           		</a4j:commandButton>
			           		<rich:spacer width="15"/>
			           		
			           		<a4j:commandButton id="btnSendReam" value="#{jspMsg['btn.sendReam']}" styleClass="rich-button" disabled="#{semmir010Bean.disabledBtnExport}"
			           		 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:62"
			           		 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="AP" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancleSendReam" value="#{jspMsg['btn.cancleSendReam']}" styleClass="rich-button" disabled="#{semmir010Bean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:100"
							 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
							 	<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="CP" />
			           		</a4j:commandButton>
			           		<rich:spacer width="15"/>
			           		
			           		<a4j:commandButton id="btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmir010Bean.disabledBtnExport}"
			           		 oncomplete="#{rich:component('popupApproveInsurancePay')}.show(); return false" 
			           		  action="#{navAction.navi}" reRender="popupApproveInsurancePay,pnlSearchResult,frmError,frmSearchResult" rendered="#{semmir010Bean.rendererSSO['btnSMBAP001']}">
			           		  	<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="AA" />			           		 
							</a4j:commandButton>
							
							<a4j:commandButton id="btnReject" value="#{jspMsg['btn.reject']}" styleClass="rich-button" disabled="#{semmir010Bean.disabledBtnExport}"
							 oncomplete="#{rich:component('popupApproveInsurancePay')}.show(); return false" 
			           		  action="#{navAction.navi}" reRender="popupApproveInsurancePay,pnlSearchResult,frmError" rendered="#{semmir010Bean.rendererSSO['btnSMBAP001']}">
			           		  	<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="CA" />	
			           		</a4j:commandButton>
			           		
			           		<rich:spacer width="15"/>
   	
   							<a4j:commandButton id ="btnExport" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 action="#{semmir010Action.initExportExcel}"
			           		 style="width:130" 
			           		 disabled="#{semmir010Bean.disabledBtnExport}"
			           		 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001'] and semmir010Bean.renderedBtnHExport}"
			           		 reRender="frmError">
			           		 <a4j:support event="oncomplete" reRender="frmError,pnlShowExcel" rendered="#{semmir010Bean.displayShowExcel}"/>
	            			</a4j:commandButton>
	            			<a4j:commandButton id ="btnExport3" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 action="#{navAction.navi}"
			           		 style="width:130" 
			           		 disabled="#{semmir010Bean.disabledBtnExport}"
			           		 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001'] and semmir010Bean.renderedBtnExportShowError}"
			           		 reRender="frmError">
			           		 <a4j:actionparam name="navModule" value="ir" />
							 <a4j:actionparam name="navProgram" value="SEMMIR010-1" />
							 <a4j:actionparam name="moduleWithNavi" value="ir" />
							 <a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
							 <a4j:actionparam name="methodWithNavi" value="onRenderMsgErrorExoprt" />
	            			</a4j:commandButton>
	            			
			           		<a4j:commandButton id ="btnExpor2" action="#{navAction.navi}"
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 rendered="#{semmir010Bean.renderedBtnA4JExport}"
			           		 reRender="frmError">
			           		 <a4j:support reRender="txtError"></a4j:support>
          		 			 <a4j:actionparam name="navModule" value="ir" />
							 <a4j:actionparam name="navProgram" value="SEMMIR010-1" />
							 <a4j:actionparam name="moduleWithNavi" value="ir" />
							 <a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
							 <a4j:actionparam name="methodWithNavi" value="onRenderMsgExoprt" />
	            			</a4j:commandButton>
							
							<a4j:commandButton id="btnPrint" style="width:130px" styleClass="rich-button"
	           						   reRender="frmError, frmSearchResult"
	           						   disabled="#{semmir010Bean.disabledBtnExport}"
	           						   value="#{jspMsg['btn.print']}" 
	           						   action="#{navAction.navi}"
	           						   rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
							
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR010RPT" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearchResult, pnlShowReport" rendered="#{semmir010RPTBean.displayShowReport}"/>
							</a4j:commandButton>
										           		
			           		<a4j:commandButton id="btnCopyDate" value="#{jspMsg['btn.copyDate']}" styleClass="rich-button"  style="width:125" action="#{navAction.navi}"
			           		 reRender="frmConfirmCoppyDateDialog,mdpConfirmCoppyDateDialog1,mdpConfirmCoppyDateDialog2,pnlSearchResult"
			           		 disabled="#{semmir010Bean.disabledBtnExport}"
			           		 rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}"
			           		 oncomplete="if(#{semmir010Bean.popupClose == 'true' && semmir010Bean.popupName == 'mdpConfirmCoppyDateDialog1'}){
			           		 				#{rich:component('mdpConfirmCoppyDateDialog1')}.show(); return false}
			           		 			 if(#{semmir010Bean.popupClose == 'true' && semmir010Bean.popupName == 'mdpConfirmCoppyDateDialog2'}){
			           		 				#{rich:component('mdpConfirmCoppyDateDialog2')}.show(); return false}">
			           		 				
			           		 				<a4j:actionparam name="navModule" value="ir" />
											<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
											<a4j:actionparam name="moduleWithNavi" value="ir" />
											<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
											<a4j:actionparam name="methodWithNavi" value="initCoppyDate" />
			           		</a4j:commandButton>
			           		
			           		<!-- Update send SMS button BY NEW 11/05/2015 -->
			           		<a4j:commandButton id="mir010_btnSMS" style="width:85px" value="#{jspMsg['btn.sms']}" styleClass="rich-button"
		                    action="#{navAction.navi}" reRender="frmError,pnlSearchResult" disabled="#{semmir010Bean.commandButtonEnable}"
		                    rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
		                        <a4j:actionparam name="navModule" value="ir" />
		                        <a4j:actionparam name="navProgram" value="SEMMIR010-1" />
		                        <a4j:actionparam name="moduleWithNavi" value="ir" />
		                        <a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
		                        <a4j:actionparam name="methodWithNavi" value="doSendSMS" />
		                    </a4j:commandButton>
                    
		                    <!-- Update send EMAIL button BY NEW 11/05/2015 -->
		                    <a4j:commandButton id="mir010_btnEMAIL" style="width:87px" value="#{jspMsg['btn.email']}" styleClass="rich-button"
		                            action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
		                            disabled="#{semmir010Bean.commandButtonEnable}"
		                            rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}">
		                                <a4j:actionparam name="navModule" value="ir" />
		                                <a4j:actionparam name="navProgram" value="SEMMIR010-1" />
		                                <a4j:actionparam name="moduleWithNavi" value="ir" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
		                                <a4j:actionparam name="methodWithNavi" value="doSendEmail" />
		                    </a4j:commandButton>
		                    
		                    <!-- Update BY NEW 11/05/2015 -->
		                    <a4j:commandButton id="mir010_btnExportLetterId" value="#{jspMsg['btn.exportletter']}" styleClass="rich-button" 
		                     disabled="#{semmir010Bean.commandButtonEnable}"
		                     rendered="#{semmir010Bean.rendererSSO['btnSMBPY001']}"
		                     action="#{navAction.navi}" reRender="oppContent,frmError,mir010_pnlInShowReportEpt"
		                     style=" width : 100px;">
		                      <a4j:actionparam name="navModule" value="ir" />
		                      <a4j:actionparam name="navProgram" value="SEMMIR010-1" />
		                      <a4j:actionparam name="moduleWithNavi" value="ir" />
		                      <a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
		                      <a4j:actionparam name="methodWithNavi" value="doExportLetter" />
		                    </a4j:commandButton>
						</h:panelGrid>
						
				<!-- ShowReport Panel -->
				<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
					<h:panelGroup id="pnlInShowReport" rendered="#{semmir010RPTBean.displayShowReport}" style="height:0px;width:0px;" >
						<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmir010RPTAction.showReport}"  />								
						<script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
					</h:panelGroup>							
				</h:panelGrid>
				
				<h:panelGrid id="pnlShowExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExcel" rendered="#{semmir010Bean.displayShowExcel}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id ="btnExcel" action="#{semmir010Action.doExportExcel}"
			           		 style="height:0px;width:0px;display:none;" rendered="#{semmir010Bean.displayShowExcel}">
	            			</h:commandButton>								
							<script>document.getElementById('incContent:frmSearchResult:btnExcel').click();</script>
						</h:panelGroup>							
				</h:panelGrid>
						
						<h:panelGrid id="mir010_pnlShowReportEpt" style="height:0px;width:0px;" width="0px" columns="0" >
				            <h:panelGroup id="mir010_pnlInShowReportEpt" rendered="#{semmir010Bean.displayReportFlag}" style="height:0px;width:0px;" >
				                <h:commandButton value="Report" id="mir010_bthShowReport" style="height:0px;width:0px;display:none;" 
				                action="#{semmir010Action.doExportExcelLetter}" onclick="mir010_reRender();"/>                              
				                <script>document.getElementById('incContent:frmSearchResult:mir010_bthShowReport').click();</script>
				                <a4j:jsFunction name="mir010_reRender" reRender="oppContent,mir010_pnlInShowReportEpt"></a4j:jsFunction>
				            </h:panelGroup>                         
				        </h:panelGrid>
						
						<!-- End Code -->					
				
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 3060"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir010Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir010Bean.msgDataNotFound}" rendered="#{semmir010Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbRentalPayNormalSrch" cellpadding="1" cellspacing="0" border="0"
							var="insuranceValueSP" value="#{semmir010Bean.policySPList}" reRender="dstRentalPayNormalSrch" 
							rows="#{semmir010Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							
							<rich:column >
								<f:facet name="header">
									<a4j:region>
									<h:selectBooleanCheckbox style="width: 20" value="#{semmir010Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmir010Action.selectAllRow}" reRender="frmSearchResult,dtbRentalPayNormalSrch,btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,
										btnApprove,btnReject,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,btnExpor2, mir010_btnSMS, 
										mir010_btnEMAIL, mir010_btnExportLetterId"/>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</f:facet>
								<div align="center">
									<a4j:region>
									<h:selectBooleanCheckbox id="chkSelect"  value="#{insuranceValueSP.checkBox}" rendered="#{insuranceValueSP.dataObj.renderColumn}">
										<a4j:support event="onclick" action="#{semmir010Action.onRenderExportButton}" reRender="btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,
										btnApprove,btnReject,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,btnExpor2,frmSearchResult, mir010_btnSMS, 
										mir010_btnEMAIL, mir010_btnExportLetterId">
											<a4j:actionparam name="rowId" value="#{insuranceValueSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</div>
							</rich:column>
							<rich:column id="hlkSavePay" >
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width:75px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkInitSavePay" value="#{jspMsg['column.edit']}" 
									 reRender="oppContent,popupEditInsurancePay,popupFrmEdit,pnlEditInsurancePay,btnSearchVendor" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR010-2" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{insuranceValueSP.dataObj.rowId}"/>
										<a4j:actionparam name="contractNo" value="#{insuranceValueSP.dataObj.contractNo}"/>	
										<a4j:actionparam name="navModuleFrom" value="ir" />
										<a4j:actionparam name="navProgramFrom" value="SEMMIR010-1" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMIR010" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{insuranceValueSP.dataObj.docType}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docType']}" styleClass="ms7" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.docTypeDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.networkType}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkType']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.networkTypeDesc}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.serviceName}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.service']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.serviceName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column width="210" sortBy="#{insuranceValueSP.dataObj.company}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" styleClass="contentform" style = "width : 60px " />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.company}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.transferTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferType']}"   styleClass="contentform" style = "width : 80px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.transferTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.policyTypeDesc}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyType']}" styleClass="contentform" style = "width : 60px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.policyTypeDesc}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.policyNo}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.policyNo']}" styleClass="contentform"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.policyNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.vendorCode}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.vendorCode}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.vendorName}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform" style = "width : 100px " />
								</f:facet>
								<div align="left">
									<h:outputText value="#{insuranceValueSP.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{insuranceValueSP.dataObj.payeeName}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform" style = "width : 100px "/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{insuranceValueSP.dataObj.excAmt}" 
								>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.amount']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.excAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{insuranceValueSP.dataObj.vatAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vat']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.vatAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.whtAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.wht']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.whtAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.dutyAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.duty']}" styleClass="contentform" style = "width : 60px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.dutyAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.totalPayAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmount']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.totalPayAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.totalAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalSystem']}" styleClass="contentform" style = "width : 90px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.totalAmt}" styleClass="contentform"  >
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{insuranceValueSP.dataObj.diffAmt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diff']}" styleClass="contentform" style = "width : 60px" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{insuranceValueSP.dataObj.diffAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{insuranceValueSP.dataObj.invoiceNo}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invoiceNo']}" styleClass="contentform"  />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.invoiceNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>								
							<rich:column  sortBy="#{insuranceValueSP.dataObj.paymentDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentDt']}" styleClass="contentform" style = "width : 80px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.paymentDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{insuranceValueSP.dataObj.paymentStatusDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style = "width : 150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.paymentStatusDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.paymentTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.paymentTypeDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{insuranceValueSP.dataObj.paymentMethodDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bank']}" styleClass="contentform" style = "width : 150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{insuranceValueSP.dataObj.paymentMethodDesc}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>	
							
							<!--  -->
							<rich:column  sortBy="#{insuranceValueSP.dataObj.invoiceNo}" styleClass=""
								title="#{insuranceValueSP.dataObj.contractNo} #{insuranceValueSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docCut']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									
									<!-- fixed by.. YUT 2014/09/16 >> -->
									<a4j:commandLink id="hlkCutting" value="#{insuranceValueSP.dataObj.doc92}" action="#{navAction.navi}" 
										reRender="common_popupCuttingFormSave, frmError-common_popupCutting"
									 	oncomplete="#{rich:component('common_popupCuttingForm')}.show(); return false" >

											<a4j:actionparam name="navModule" value="ir" />
											<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="paramPaymentId" value="#{insuranceValueSP.dataObj.rowId}" />
											<a4j:actionparam name="paramPaymentStatus" value="#{insuranceValueSP.dataObj.paymentStatus}" />
											<a4j:actionparam name="paramPaymentRemark" value="#{insuranceValueSP.dataObj.remark}" />
											<a4j:actionparam name="paramRcptPayCutAmount" value="#{insuranceValueSP.dataObj.rcptPayCutAmount}" />
											
											<a4j:actionparam name="paramFwdNavModule" value="ir" />
											<a4j:actionparam name="paramFwdNavAction" value="SEMMIR010" />
											<a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
									</a4j:commandLink>
									<!-- fixed by.. YUT 2014/09/16 << -->
									
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{insuranceValueSP.dataObj.remark}" styleClass=""
								title="#{insuranceValueSP.dataObj.contractNo} #{insuranceValueSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{insuranceValueSP.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<!--  -->
							
							<rich:column  sortBy="#{insuranceValueSP.dataObj.chqDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.chqDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{insuranceValueSP.dataObj.chqReceiveDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform" style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.chqReceiveDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.transferDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style = "width : 80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.transferDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.updateBy}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" styleClass="contentform" style = "width : 100px" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.updateBy}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{insuranceValueSP.dataObj.updateDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDt']}" styleClass="contentform" style = "width : 80px" />
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{insuranceValueSP.dataObj.updateDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{insuranceValueSP.dataObj.sendInfoStatus}" >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform" style = "width : 80px" />
                                    
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{insuranceValueSP.dataObj.sendInfoStatus}" styleClass="contentform">
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            <rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.notDisbursed']}" styleClass="contentform" style = "width : 80px" />
                                    
                                </f:facet>
                                <div align="center">
                                    <a4j:commandButton id="notDisbursedBtn"
                                        disabled="#{!(semmir010Bean.policySP.paymentStatus eq '01' or semmir010Bean.policySP.paymentStatus eq '14')}"
                                        action="#{navAction.navi}" 
                                        reRender="ddlDisbursedStatusList,    common_popupFrmNotDisbursed, frmError-common_popupNotDisbursed"
                                        value="#{jspMsg['btn.notDisbursed']}" styleClass="rich-button" style="width:110px;"
                                        oncomplete="#{rich:component('common_popupNotDisbursedForm')}.show(); return false" >
                                        
                                            <a4j:actionparam name="navModule" value="ir" />
                                            <a4j:actionparam name="navProgram" value="SEMMIR010-1" />
                                            
                                            <a4j:actionparam name="moduleWithNavi" value="common" />
                                            <a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
                                            <a4j:actionparam name="methodWithNavi" value="initPopupNotDisbursed" />
                                            <a4j:actionparam name="paramPaymentId" value="#{insuranceValueSP.dataObj.rowId}" />
                                            <a4j:actionparam name="paramPaymentStatus" value="#{semmir010Bean.policySP.paymentStatus}" />
                                            <a4j:actionparam name="paramPaymentRemark" value="#{insuranceValueSP.dataObj.remark}" />
                                            
                                            <a4j:actionparam name="paramFwdNavModule" value="ir" />
                                            <a4j:actionparam name="paramFwdNavAction" value="SEMMIR010" />
                                            <a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
                                    </a4j:commandButton>
                                </div>
                            </rich:column>
							
							<rich:column   >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.attachFile']}" styleClass="contentform" style = "width : 80px" />
									
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnUploadPicture"
										action="#{navAction.navi}"
										reRender="oppContent,popupUploadPictureCriteria"
										value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
										oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
										<a4j:actionparam name="navModule" value="common" />
										<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
										<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
										<a4j:actionparam name="refId" value="" />
										<a4j:actionparam name="module" value="IR"/>
										<a4j:actionparam name="contractNo" value="#{semmco004Bean.contractNoParam}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							
							<f:facet name="footer">
							<a4j:region>
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir010Bean.policySPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="34">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPayNormalSrch"
											maxPages="#{semmir010Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRentalPayNormalSrch" 
											style="background-color: #cccccc;"
											page="#{semmir010Bean.scrollerPage}">
										<a4j:support event="onclick"  reRender="frmSearchResult"></a4j:support>
										</rich:datascroller>
										
									</rich:column>
								</rich:columnGroup>		
							</a4j:region>			
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:form id="frmConfirmCoppyDateDialog">
<rich:modalPanel id="mdpConfirmCoppyDateDialog1" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmir010Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch">						
							<a4j:actionparam name="navModule" value="ir" />
							<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="Y" />
							<rich:componentControl for="mdpConfirmCoppyDateDialog1" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" >
						    <rich:componentControl for="mdpConfirmCoppyDateDialog1" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmCoppyDateDialog2" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmir010Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="5" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch">						
							<a4j:actionparam name="navModule" value="ir" />
							<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="Y" />						
							<rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch">						
							<a4j:actionparam name="navModule" value="ir" />
							<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="N" />
						    <rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>
						<rich:spacer width="5"/>	
						<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
</a4j:form>

<rich:modalPanel id="popupApproveInsurancePay" width="470" minWidth="250" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popUpApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidepopupApproveInsurancePay" style="cursor:pointer"/>
					<rich:componentControl for="popupApproveInsurancePay" attachTo="hidepopupApproveInsurancePay" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorPopupApproveSave">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmir010Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="popupFrmAct">
			<rich:panel id="pnlEditInsurancePay">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popUpApprove']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td align="right" valign="top" colspan="3" width="50%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="25%">
		                			<h:inputTextarea id="txtremark" value="#{semmir010Bean.remark}" rows="3" cols="60"/>
				                	</td>
				                	<td>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td colspan="3" width="50%"></td>
			                	 	<td width="25%">
			                	 	<a4j:commandButton id="btnPopupApproveSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError" 
									oncomplete="if(#{semmir010Bean.popupClose == 'true'})#{rich:component('popupApproveInsurancePay')}.hide();">
										<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
										<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
									 reRender="frmErrorPopupApproveSave,dtbRentalPayNormalSrch,frmError">
									 	<a4j:actionparam name="navModule" value="ir" />
										<a4j:actionparam name="navProgram" value="SEMMIR010-1" />
										<a4j:actionparam name="moduleWithNavi" value="ir" />
										<a4j:actionparam name="actionWithNavi" value="SEMMIR010" />
										<a4j:actionparam name="methodWithNavi" value="doClearApproveStatus" />
										<rich:componentControl for="popupApproveInsurancePay" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>
	<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
	
	<jsp:include page="../../pages/popup/common-popupCutting.jsp"/>
	
	
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mir010PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mir010PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mir010PopUp_addVendor" attachTo="hide-mir010PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMir010PopUp_addVendor">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="เงื่อนไขการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorCode" value="#{semmir010Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmir010Bean.vendorMasterPopupObjParam.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmir010Action.doSearchPopupAddVendor}"
					reRender="frmMir010PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmir010Action.doClearPopupAddVendor}"
					reRender="frmMir010PopUp_addVendor, dataTable_searchVendor"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="ผลการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchVendor" cellpadding="1" cellspacing="0" border="0" 
							var="vendorLst"  value="#{semmir010Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmir010Action.doSelectPopupAddVendor}"
											reRender="oppContent,txtNavProgram">
												<a4j:actionparam name="paramVendorCode" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="paramVendorName" value="#{vendorLst.dataObj.vendorName}" />
											</a4j:commandLink>
									</div>	
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code ใหม่" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mir010_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mir010_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mir010_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mir010_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmir010Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmir010Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmir010Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMir010PopUp_addVendor"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mir010PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->