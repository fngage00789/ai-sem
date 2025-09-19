<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semmrt004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt004Bean.renderedMsgFormTop}">
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
									<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td colspan="3" width="80%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmrt004Bean.rentalPayNormalSearchSP.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmrt004Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
									<rich:spacer width="10"></rich:spacer>
									<h:outputText id="companyDisplay" value="#{semmrt004Bean.rentalPayNormalSearchSP.company}" styleClass="ms28"/>
				                	</td>
							</tr>
							<tr>
									<td align="right" width="20%">
									<h:panelGroup>
									<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.jobType']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlJobType" value="#{semmrt004Bean.rentalPayNormalSearchSP.jobType}">
											<f:selectItems value="#{semmrt004Bean.jobTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
				                		<h:panelGroup>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlRegion" value="#{semmrt004Bean.rentalPayNormalSearchSP.region}">
											<f:selectItems value="#{semmrt004Bean.regionList}"/>
										</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentStatus" value="#{semmrt004Bean.rentalPayNormalSearchSP.paymentStatus}">
											<f:selectItems value="#{semmrt004Bean.paymentStatusList}"/>
										</h:selectOneMenu>
		                			</td>
		                			<td align="right" width="20%">						
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPaymentType" value="#{semmrt004Bean.rentalPayNormalSearchSP.paymentType}">
											<f:selectItems value="#{semmrt004Bean.paymentTypeList}"/>
										</h:selectOneMenu>
		                			</td>
			                	 </tr>
			                	 <tr>
				                	<td align="right" width="20%">
				                	<h:outputText value="#{jspMsg['label.dueDtFrom']}" styleClass="ms7"/>
									
		                			</td>
		                			<td colspan="3" width="80%">
		                				<rich:calendar id="cldDueDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt004Bean.rentalPayNormalSearchSP.dueDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											  oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtFrom','cldDueDtTo');"
											   label="#{jspMsg['column.header.dueDtFrom']}">
										</rich:calendar>
		                			 <rich:spacer width="5"/>
		                			 <h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                			 <rich:spacer width="5"/>
		                			 <rich:calendar id="cldDueDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmrt004Bean.rentalPayNormalSearchSP.dueDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											  oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   oninputblur="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
											   oncollapse="validateRichCalendarFromTo('frmSearch','cldDueDtTo','cldDueDtFrom');"
											   label="#{jspMsg['column.header.dueDtTo']}">
										</rich:calendar>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtContractNo" value="#{semmrt004Bean.rentalPayNormalSearchSP.contractNo}"
		                			 size="23" maxlength="20"/>
				                	</td>
				                	<td align="right" width="20%">
				                	<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
									
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtSiteName" value="#{semmrt004Bean.rentalPayNormalSearchSP.siteName}" size="30" maxlength="200"/>	
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 		<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
									
		                			</td>
		                			<td colspan="3"  width="80%">
		                				<h:selectOneMenu id="ddlSiteType" value="#{semmrt004Bean.rentalPayNormalSearchSP.siteType}">
											<f:selectItems value="#{semmrt004Bean.siteTypeList}"/>
										</h:selectOneMenu>
										<rich:spacer width="10"/>
										<h:selectBooleanCheckbox id="picoSelect" value="#{semmrt004Bean.rentalPayNormalSearchSP.chkPico}"/>
										<rich:spacer width="5"/>
										<h:outputText value="PICO" styleClass="ms7"/>
									</td>
				                </tr>
			                </table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
							action="#{navAction.navi}" reRender="frmError,pnlSearchResult">
								<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
							 action="#{navAction.navi}" reRender="pnlSearchResult,btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,pnlSearchCriteria,
										btnApprove,btnReject,btnExport,btnPrint,btnCoppyDate,btnTotalAmt,btnCancleTotalAmt,btnApproveExpire">
			           			<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />
			           		</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button -->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt004Bean.renderedMsgFormBottom}"/>
				</div>
				<h:panelGrid columns="15" id="grdSearchCommand">
							<a4j:commandButton id="btnTotalAmt" value="#{jspMsg['btn.totalDisbursement']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:72"
							 rendered="#{semmrt004Bean.renderer['btnTotalAmt']}">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="AG" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancleTotalAmt" value="#{jspMsg['btn.cancleTotalDisbursement']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:100"
							 rendered="#{semmrt004Bean.renderer['btnCancleTotalAmt']}">
							 	<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="CG" />
			           		</a4j:commandButton>
			           		<rich:spacer width="15"/>
			           		
			           		<a4j:commandButton id="btnSendReam" value="#{jspMsg['btn.sendReam']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
			           		 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:62"
			           		 rendered="#{semmrt004Bean.renderer['btnSendReam']}">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="AP" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnCancleSendReam" value="#{jspMsg['btn.cancleSendReam']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
							 action="#{navAction.navi}" reRender="pnlSearchResult,frmError" style="width:100"
							 rendered="#{semmrt004Bean.renderer['btnCancleSendReam']}">
							 	<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="doSaveAct" />
								<a4j:actionparam name="btnStatus" value="CP" />
			           		</a4j:commandButton>
			           		<rich:spacer width="15"/>
							
			           		<a4j:commandButton id="btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
			           		 oncomplete="#{rich:component('popupApproveRentalPayNormal')}.show(); return false" 
			           		  action="#{navAction.navi}" reRender="popupApproveRentalPayNormal"
			           		  rendered="#{semmrt004Bean.renderer['btnApprove']}">
			           		  	<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="AA" />			           		 
							</a4j:commandButton>
							
							<a4j:commandButton id="btnReject" value="#{jspMsg['btn.reject']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
							 oncomplete="#{rich:component('popupApproveRentalPayNormal')}.show(); return false" 
			           		  action="#{navAction.navi}" reRender="popupApproveRentalPayNormal"
			           		  rendered="#{semmrt004Bean.renderer['btnReject']}">
			           		  	<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnApproveStatus" value="CA" />	
			           		</a4j:commandButton>
			           		<rich:spacer width="15"/>
			           		
							<a4j:commandButton id ="btnExport" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 action="#{semmrt004Action.initExportExcel}"
			           		 disabled="#{semmrt004Bean.disabledBtnExport}"
			           		 rendered="#{semmrt004Bean.renderer['btnExport'] and semmrt004Bean.renderedBtnHExport}"
			           		 reRender="frmError">
			           		 <a4j:support event="oncomplete" reRender="frmError, pnlShowExcel, dtbRentalPayNormalSrch" rendered="#{semmrt004Bean.displayShowExcel}"/>
	            			</a4j:commandButton>
	            			
	            			<a4j:commandButton id ="btnExport3" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 action="#{navAction.navi}"
			           		 disabled="#{semmrt004Bean.disabledBtnExport}"
			           		 rendered="#{semmrt004Bean.renderer['btnExport'] and semmrt004Bean.renderedBtnExportShowError}"
			           		 reRender="frmError">
			           		 <a4j:actionparam name="navModule" value="rt" />
							 <a4j:actionparam name="navProgram" value="SEMMRT004-1" />
							 <a4j:actionparam name="moduleWithNavi" value="rt" />
							 <a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
							 <a4j:actionparam name="methodWithNavi" value="onRenderMsgErrorExoprt" />
	            			</a4j:commandButton>
							
							<a4j:commandButton id ="btnExpor2" action="#{navAction.navi}"
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 rendered="#{semmrt004Bean.renderedBtnA4JExport}"
			           		 reRender="frmError">
			           		 <a4j:support reRender="txtError"></a4j:support>
          		 			 <a4j:actionparam name="navModule" value="rt" />
							 <a4j:actionparam name="navProgram" value="SEMMRT004-1" />
							 <a4j:actionparam name="moduleWithNavi" value="rt" />
							 <a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
							 <a4j:actionparam name="methodWithNavi" value="onRenderMsgExoprt" />
	            			</a4j:commandButton>
							
							<a4j:commandButton id="btnPrint" value="#{jspMsg['btn.print']}" styleClass="rich-button" disabled="#{semmrt004Bean.disabledBtnExport}"
	           						   action="#{navAction.navi}"
							 		   rendered="#{semmrt004Bean.renderer['btnPrint']}">
							 	 <a4j:actionparam name="navModule" value="co" />
								<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT004RPT" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								<a4j:support event="oncomplete" reRender="frmError, frmSearchResult, pnlShowReport" rendered="#{semmrt003RPTBean.displayShowReport}"/>
			           		</a4j:commandButton>
			           		
			           		<a4j:commandButton id="btnCopyDate" value="#{jspMsg['btn.copyDate']}" styleClass="rich-button"  style="width:125" action="#{navAction.navi}"
			           		 reRender="frmConfirmCoppyDateDialog,mdpConfirmCoppyDateDialog1,mdpConfirmCoppyDateDialog2" 
			           		 oncomplete="if(#{semmrt004Bean.popupClose == 'true' && semmrt004Bean.popupName == 'mdpConfirmCoppyDateDialog1'}){
			           		 				#{rich:component('mdpConfirmCoppyDateDialog1')}.show(); return false}
			           		 			 if(#{semmrt004Bean.popupClose == 'true' && semmrt004Bean.popupName == 'mdpConfirmCoppyDateDialog2'}){
			           		 				#{rich:component('mdpConfirmCoppyDateDialog2')}.show(); return false}"
			           		 rendered="#{semmrt004Bean.renderer['btnCopyDate']}">
			           		 				
			           		 				<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
											<a4j:actionparam name="methodWithNavi" value="initCoppyDate" />
			           		</a4j:commandButton>
						</h:panelGrid>
				
					<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReport" rendered="#{semmrt003RPTBean.displayShowReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmrt003RPTAction.showReport}"  />								
							<script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
					<h:panelGrid id="pnlShowExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExcel" rendered="#{semmrt004Bean.displayShowExcel}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id ="btnExcel" action="#{semmrt004Action.doExportExcel}"
			           		 style="height:0px;width:0px;display:none;" rendered="#{semmrt004Bean.displayShowExcel}">
	            			</h:commandButton>								
							<script>document.getElementById('incContent:frmSearchResult:btnExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 4773"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt004Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt004Bean.msgDataNotFound}" rendered="#{semmrt004Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable width="100%" id="dtbRentalPayNormalSrch" cellpadding="1" cellspacing="0" border="0"
							var="rentalPayNormalSP" value="#{semmrt004Bean.rentalPayNormalSearchSPList}" reRender="dstRentalPayNormalSrch" 
							rows="#{semmrt004Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:region>
							<a4j:support event="onRowClick"   action="#{semmrt004Action.getRowIdOnClick}" reRender="dtbRentalPayNormalSrch" >
								<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
							</a4j:support> 
							</a4j:region>
							<rich:column styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<a4j:region>
									<h:selectBooleanCheckbox style="width: 20" value="#{semmrt004Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmrt004Action.selectAllRow}" reRender="frmSearchResult,dtbRentalPayNormalSrch,btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,btnExpor2,
										btnApprove,btnReject,btnExport,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,btnApproveExpire,pnlSearchResult"/>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</f:facet>
								<div align="center">
									<a4j:region>
									<h:selectBooleanCheckbox id="chkSelect"  value="#{rentalPayNormalSP.checkBox}" rendered="#{rentalPayNormalSP.dataObj.renderColumn}">
										<a4j:support event="onclick" action="#{semmrt004Action.onRenderExportButton}" reRender="frmSearchResult,dtbRentalPayNormalSrch,btnExport,
										btnTotalDisbursement,btnCancleTotalDisbursement,btnSendReam,btnCancleSendReam,btnExpor2,
										btnApprove,btnReject,btnExport,btnPrint,btnCopyDate,btnTotalAmt,btnCancleTotalAmt,btnApproveExpire">
											<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</div>
							</rich:column>
							<rich:column id="hlkSavePay" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmrt004Bean.renderer['hlkSavePay']}">
								<f:facet name="header">
									<h:outputText value="" styleClass="contentform" style="width:75px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkInitSavePay" value="#{jspMsg['label.cLink']}" oncomplete="#{rich:component('popupRentalPayNormal')}.show(); return false"
									 reRender="popupFrmSave,frmErrorPopupSave" action="#{navAction.navi}">
									 	<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>	
										<a4j:actionparam name="paymentGroupNo" value="#{rentalPayNormalSP.dataObj.paymentGroupNo}"/>
										<a4j:actionparam name="statusEdit" value="savePay"/>
										<a4j:actionparam name="vendorMasterId" value="#{rentalPayNormalSP.dataObj.vendorMasterId}"/>
										<a4j:actionparam name="payeeId" value="#{rentalPayNormalSP.dataObj.payeeId}"/>
										<a4j:actionparam name="expenseType" value="#{rentalPayNormalSP.dataObj.expenseType}"/>
										<a4j:actionparam name="contractNo" value="#{rentalPayNormalSP.dataObj.contractNo}"/>
										<a4j:actionparam name="periodNo" value="#{rentalPayNormalSP.dataObj.periodNo}"/>
										<a4j:actionparam name="pageStatus" value="SavePay"/>			
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="btnEdit" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmrt004Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.edit']}" styleClass="ms7" />
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnIniEdit" image="images/edit.png" style="height: 15; width: 15;" oncomplete="#{rich:component('popupEditRentalPayNormal')}.show(); return false"
									 action="#{navAction.navi}" reRender="popupFrmEdit" >
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />	
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}"/>
										<a4j:actionparam name="pageStatus" value="initEdit"/>	
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.contractNo}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{rentalPayNormalSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentalPayNormalSP.dataObj.siteName}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
									title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.siteName}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.effDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.effDt']}"   styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.effDtStr}" styleClass="contentform"  >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expDt']}" styleClass="contentform" style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.dueDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.dueDtStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodNo}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform"  style="width:24px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodNo}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expenseTypeDesc}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:180px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expenseTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vendorCode}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.verdorId']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vendorCode}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vendorName}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vendorName}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.payeeName}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:200px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payeeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.payPeriodType}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodType']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.payPeriodType}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodY}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodY']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodY}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodM}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodM']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodM}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.periodD}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payPeriodD']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.periodD}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.dueAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.dueAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.dueAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.vatAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.vatAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.whtRate}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtRate']}" styleClass="contentform"  style="width:48px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.whtRate}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.whtAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.whtAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.siteStatus}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractStatus']}" styleClass="contentform"  style="width:132px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.siteStatus}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.networkStatus}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.networkStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.networkStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expStatus}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.expApprove}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expApprove']}" styleClass="contentform"  style="width:60px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.expApprove}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentRequestDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentRequestDt']}" styleClass="contentform"  style="width:100px"/>
									
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentRequestDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentTypeDesc}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.paymentTypeDesc}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.bankName}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.bankName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqDtDisplayStr}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqReceiveDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.chqReceiveDtDisplayStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.transferDt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.transferDtDisplayStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.depositAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.depositAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.depositAmt}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.pettyAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pettyAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.pettyAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.totalAmt}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.totalAmt']}" styleClass="contentform"  style="width:20px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentalPayNormalSP.dataObj.totalAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.bankAccNo}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentalPayNormalSP.dataObj.bankAccNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column  sortBy="#{rentalPayNormalSP.dataObj.remark}" styleClass="#{(semmrt004Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentalPayNormalSP.dataObj.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalPayNormalSrch" 
									maxPages="10" id="dstRentalPayNormalSrch" selectedStyleClass="selectScroll" 
									page="#{semmrt004Bean.scrollerPage}">
									<a4j:support event="onclick"  reRender="frmSearchResult"></a4j:support>
								</rich:datascroller>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout data grid -->
			</a4j:form>
			<jsp:include page="../../pages/rt/semmrt004-popup.jsp"/>
			<jsp:include page="../../pages/rt/semmrt004-popupSavePay.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:form id="frmConfirmCoppyDateDialog">
<rich:modalPanel id="mdpConfirmCoppyDateDialog1" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmrt004Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch">						
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
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
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
		<table width="240px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
						<h:outputText value="#{semmrt004Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="5" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch">						
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="Y" />						
							<rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,dtbRentalPayNormalSrch">						
							<a4j:actionparam name="navModule" value="rt" />
							<a4j:actionparam name="navProgram" value="SEMMRT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT004" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="N" />
						    <rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>
						<rich:spacer width="5"/>	
						<a4j:commandButton value="Cancle" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
</a4j:form>