<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.propertyTax.semmpt004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt004Bean.renderedMsgFormTop}">
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
                        <a4j:commandButton id="mpt004_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmpt004Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent,txtNavProgram">
                              <a4j:actionparam name="navModule" value="pt" />
                              <a4j:actionparam name="navProgram" value="SEMMPT001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="pt" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMPT001" />
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
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td colspan="3" width="80%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmpt004Bean.mpt004Srch.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmpt004Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmpt004Bean.mpt004Srch.company}" styleClass="ms28"/>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.pTaxYearFrom']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlYearFrom" value="#{semmpt004Bean.mpt004Srch.pTaxYearFrom}" onchange="renderPtaxYearTo();">
											<a4j:jsFunction name="renderPtaxYearTo" reRender="ddlYearTo" action="#{semmpt004Action.doDefaultPtaxYearFrom}"/>
											<f:selectItems value="#{semmpt004Bean.pTaxYearFromList}"/>
										</h:selectOneMenu>
		                				<rich:spacer width="5"/>
		                				<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<h:selectOneMenu id="ddlYearTo" value="#{semmpt004Bean.mpt004Srch.pTaxYearTo}">
											<f:selectItems value="#{semmpt004Bean.pTaxYearToList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.periodFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPeriodNoFrom" value="#{semmpt004Bean.mpt004Srch.periodNoFrom}">
											<f:selectItems value="#{semmpt004Bean.periodFromList}"/>
										</h:selectOneMenu>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.periodTo']}" styleClass="ms7"/>
										<rich:spacer width="5"></rich:spacer>
										<h:selectOneMenu id="ddlPeriodNoTo" value="#{semmpt004Bean.mpt004Srch.periodNoTo}">
											<f:selectItems value="#{semmpt004Bean.periodToList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<%-- <h:inputText id="txtContractNo" value="#{semmpt004Bean.mpt004Srch.contractNo}" size="15" maxlength="12"/> --%>
										<h:inputText id="txtContractNo" value="#{semmpt004Bean.mpt004Srch.contractNo}" size="23" maxlength="20"/>
										
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.picoFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox id="chkPicoFlag" value="#{semmpt004Bean.chkPayGovtFlag}"></h:selectBooleanCheckbox>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPTaxPayType" value="#{semmpt004Bean.mpt004Srch.pTaxPayType}">
											<f:selectItems value="#{semmpt004Bean.pTaxPayTypeList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlExpenseType" value="#{semmpt004Bean.mpt004Srch.expenseType}">
											<f:selectItems value="#{semmpt004Bean.expenseTypeList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%" valign="baseline">
										<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
									</td>
									<td width="30%" valign="bottom">
										<h:selectOneMenu id="ddlRegion" 
														 value="#{semmpt004Bean.mpt004Srch.region}"
														 onchange="GetRegionJS();">
											<a4j:jsFunction name="GetRegionJS" reRender="ddlProvince" action="#{semmpt004Action.renderProvinceList}"/>
											<f:selectItems value="#{semmpt004Bean.regionList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlProvince" 
														 value="#{semmpt004Bean.mpt004Srch.province}" 
														 onchange="GetSiteAmphurListJS(),GetGovtJS();">
											
											<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlAmphur" action="#{semmpt004Action.renderAmphurList}"/>
											<a4j:jsFunction name="GetGovtJS" reRender="ddlGovt" action="#{semmpt004Action.renderGovtList}"/>
											<f:selectItems value="#{semmpt004Bean.provinceList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%" valign="baseline">
										<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7"/>
									</td>
									<td width="30%" valign="bottom">
										<h:selectOneMenu id="ddlAmphur" value="#{semmpt004Bean.mpt004Srch.amphur}">
											<f:selectItems value="#{semmpt004Bean.amphurList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.govtName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlGovt" value="#{semmpt004Bean.mpt004Srch.govtName}" >
											<f:selectItems value="#{semmpt004Bean.govtList}"/>	
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.estimateFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="optPTaxStatus" value="#{semmpt004Bean.mpt004Srch.estimateFlag}">
											<f:selectItem itemLabel="#{jspMsg['label.selectItem']}" itemValue="" />
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus1']}" itemValue="01" />
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus2']}" itemValue="02" />											
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paygovtFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox value="#{semmpt004Bean.tmpPayGovtFlag}"></h:selectBooleanCheckbox>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.vendorCode']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorCode" value="#{semmpt004Bean.mpt004Srch.vendorCode}"
										style="margin-right:5px;" />
										
										<!-- >> fixed by.. YUT 2015/10/18 -->
			                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
							            action="#{semmpt004Action.initAddVendor}" reRender="oppContent"
							            oncomplete="#{rich:component('mpt004PopUp_addVendor')}.show(); return false">
										</a4j:commandButton>
			                			<!-- << -->	
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorName" value="#{semmpt004Bean.mpt004Srch.vendorName}" size="30" maxlength="255"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayeeName" value="#{semmpt004Bean.mpt004Srch.payeeName}" size="30" maxlength="255"/>
									</td>
							</tr>
							<tr>
							<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentStatus" value="#{semmpt004Bean.mpt004Srch.paymentStatus}"
										onchange="reRenderRcptPayChkBox();">
											<f:selectItems value="#{semmpt004Bean.paymentStatusList}"/>
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
										<h:selectBooleanCheckbox id="rcptPayChkBox" value="#{semmpt004Bean.mpt004Srch.chkRcptPay}"   
										disabled="#{semmpt004Bean.mpt004Srch.paymentStatus == '13' ? false : true}"/>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.paySome']}" styleClass="ms7"/>
										<!-- fixed by.. YUT 2014/09/16 << -->
										
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentType" value="#{semmpt004Bean.mpt004Srch.paymentType}">
											<f:selectItems value="#{semmpt004Bean.paymentTypeList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
							 reRender="frmError,pnlSearchResult,btnCancleMenu,btnTotalAmt,btnCancleTotalAmt,btnSendReam,
							 btnCancleSendReam,btnExport,btnApprove,btnReject,btnSavePay">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}"
							 reRender="pnlSearchCriteria,pnlSearchResult,btnCancleMenu,btnTotalAmt,btnCancleTotalAmt,btnSendReam,
							 btnCancleSendReam,btnExport,btnApprove,btnReject,btnSavePay">
							 	<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doClearSession" />			 		 
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
				<div align="left">
					<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt004Bean.renderedMsgFormBottom}"/>
				</div>
				<table width="88%">
				<tr>
				<td align="right">
				<a4j:commandButton id="btnSavePay" value="#{jspMsg['btn.savePay']}" styleClass="rich-button" rendered="#{semmpt004Bean.renderer['btnSavePay']}"
				 style="width: 90" action="#{navAction.navi}" reRender="oppContent">
				 		<a4j:actionparam name="navModule" value="pt" />
						<a4j:actionparam name="navProgram" value="SEMMPT004-2" />
						<a4j:actionparam name="moduleWithNavi" value="pt" />
						<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="ADD" />
				</a4j:commandButton>
				</td>
				</tr>
				<tr>
				<td>
				<h:panelGrid columns="15" id="grdAddNewCommand">
						<a4j:commandButton id="btnCancleMenu" value="#{jspMsg['btn.cancle']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}" 
						 style="width: 99" action="#{navAction.navi}" rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}" reRender="frmError,pnlSearchResult">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateAct" />
								<a4j:actionparam name="btnStatus" value="CC" />
						</a4j:commandButton>
						<a4j:commandButton id="btnTotalAmt" value="#{jspMsg['btn.totalAmt']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}"
						 style="width: 70" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateAct" />
								<a4j:actionparam name="btnStatus" value="AG" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancleTotalAmt" value="#{jspMsg['btn.cancleTotalAmt']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}"
						 style="width: 99" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateAct" />
								<a4j:actionparam name="btnStatus" value="CG" />
						</a4j:commandButton>
						<a4j:commandButton id="btnSendReam" value="#{jspMsg['btn.send']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}"
						 style="width: 60" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateAct" />
								<a4j:actionparam name="btnStatus" value="AP" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancleSendReam" value="#{jspMsg['btn.cancleSend']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}"
						 style="width: 90" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
						 rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateAct" />
								<a4j:actionparam name="btnStatus" value="CP" />
						</a4j:commandButton>
						<rich:spacer width="15"/>
						<a4j:commandButton id="btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}"
						 style="width: 60" action="#{navAction.navi}"
						 oncomplete="#{rich:component('popupApprovePropertyTax')}.show(); return false"
						 reRender="popupApprovePropertyTax"
						 rendered="#{semmpt004Bean.rendererSSO['btnSMBAP001']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnStatus" value="AA" />
						</a4j:commandButton>
						<a4j:commandButton id="btnReject" value="#{jspMsg['btn.reject']}" styleClass="rich-button" disabled="#{semmpt004Bean.disabledBtnExport}"
						 style="width: 70" action="#{navAction.navi}"
						 oncomplete="#{rich:component('popupApprovePropertyTax')}.show(); return false"
						 rendered="#{semmpt004Bean.rendererSSO['btnSMBAP001']}">
						 		<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								<a4j:actionparam name="methodWithNavi" value="initApprove" />
								<a4j:actionparam name="btnStatus" value="CA" />
						</a4j:commandButton>
						<rich:spacer width="15"/>
	            		
	            		<a4j:commandButton id ="btnExport" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 action="#{semmpt004Action.initExportExcel}"
			           		 style="width:70" 
			           		 disabled="#{semmpt004Bean.disabledBtnExport}"
			           		 rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001'] and semmpt004Bean.renderedBtnHExport}"
			           		 reRender="frmError">
			           		 <a4j:support event="oncomplete" reRender="frmError, pnlShowExcel,pnlSearchResult" rendered="#{semmpt004Bean.displayShowExcel}"/>
	            		</a4j:commandButton>
	            		<a4j:commandButton id ="btnExport3" 
			           		 styleClass="rich-button" value="#{jspMsg['btn.export']}"
			           		 action="#{navAction.navi}"
			           		 style="width:70" 
			           		 disabled="#{semmpt004Bean.disabledBtnExport}"
			           		 rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001'] and semmpt004Bean.renderedBtnExportShowError}"
			           		 reRender="frmError,frmSearchResult">
			           		 	<a4j:actionparam name="navModule" value="pt" />
								 <a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								 <a4j:actionparam name="moduleWithNavi" value="pt" />
								 <a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
								 <a4j:actionparam name="methodWithNavi" value="onRenderMsgErrorExoprt" />
	            		</a4j:commandButton>
	            		
	            		
						<a4j:commandButton id="btnPrint" style="width:60px" styleClass="rich-button"
	           						   reRender="frmError, frmSearchResult"
	           						   value="Print" 
	           						   rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}"
	           						   action="#{navAction.navi}">
							
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
								<a4j:actionparam name="moduleWithNavi" value="report" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT004RPT" />
								<a4j:actionparam name="methodWithNavi" value="doRunReport" />
								
								<a4j:support event="oncomplete" reRender="frmError, frmSearchResult, pnlShowReport,pnlSearchResult" rendered="#{semmrt003RPTBean.displayShowReport}"/>
							</a4j:commandButton>
							<rich:spacer width="10"/>
						<a4j:commandButton id="btnCopyDate" value="#{jspMsg['btn.coppy']}" styleClass="rich-button"
						 style="width: 120" action="#{navAction.navi}"  reRender="frmConfirmCoppyDateDialog,mdpConfirmCoppyDateDialog1,mdpConfirmCoppyDateDialog2"
						 rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}"
						 oncomplete="if(#{semmpt004Bean.popupClose == 'true' && semmpt004Bean.popupName == 'mdpConfirmCoppyDateDialog1'}){
			           		 				#{rich:component('mdpConfirmCoppyDateDialog1')}.show(); return false}
			           		 			 if(#{semmpt004Bean.popupClose == 'true' && semmpt004Bean.popupName == 'mdpConfirmCoppyDateDialog2'}){
			           		 				#{rich:component('mdpConfirmCoppyDateDialog2')}.show(); return false}">
			           		 				
			           		 				<a4j:actionparam name="navModule" value="pt" />
											<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
											<a4j:actionparam name="moduleWithNavi" value="pt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
											<a4j:actionparam name="methodWithNavi" value="initCoppyDate" />
						</a4j:commandButton>
						
						<!-- added by.. YUT 2014/09/30 >> -->
						<a4j:commandButton id="btnSMS" value="#{jspMsg['btn.sms']}" styleClass="rich-button" style="width: 85;"
						action="#{navAction.navi}" reRender="frmError,pnlSearchResult" disabled="#{semmpt004Bean.disabledBtnExport}"
						rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}">
							<a4j:actionparam name="navModule" value="pt" />
							<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="pt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
							<a4j:actionparam name="methodWithNavi" value="doSendSMS" />
						</a4j:commandButton>
						<!-- added by.. YUT 2014/09/30 << -->
						
						<!-- Update send EMAIL button BY NEW 24/10/2014 -->
						<a4j:commandButton id="btnEMAIL" value="#{jspMsg['btn.email']}" styleClass="rich-button"
								style="width:85px; text-indent: -7px;" action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
								disabled="#{semmpt004Bean.disabledBtnExport}" rendered="#{semmpt004Bean.rendererSSO['btnSMBPY001']}">
									<a4j:actionparam name="navModule" value="pt" />
									<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
									<a4j:actionparam name="moduleWithNavi" value="pt" />
									<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
									<a4j:actionparam name="methodWithNavi" value="doSendEmail" />
						</a4j:commandButton>
						
						<h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReport" rendered="#{semmrt003RPTBean.displayShowReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmrt003RPTAction.showReport}"  />								
							<script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
						</h:panelGroup>							
						</h:panelGrid>
						
						<h:panelGrid id="pnlShowExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExcel" rendered="#{semmpt004Bean.displayShowExcel}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id ="btnExcel" action="#{semmpt004Action.doExportExcel}" 
			           		 style="height:0px;width:0px;display:none;" rendered="#{semmpt004Bean.displayShowExcel}">
	            			</h:commandButton>
							<script>document.getElementById('incContent:frmSearchResult:btnExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
				</h:panelGrid>
				</td>
				</tr>
				<!-- end content button -->
				<tr>
				<td>
				<!-- begin content layout data grid-->
				<h:panelGrid  width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 3842"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt004Bean.renderedMsgFormMiddle}"/>
						</div>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmpt004Bean.msgDataNotFound}" rendered="#{semmpt004Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbMpt004Srch" cellpadding="1" cellspacing="0" border="0"
							var="mpt004SrchSP" value="#{semmpt004Bean.mpt004SrchList}" reRender="dstMpt004Srch" 
							rows="#{semmpt004Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmpt004Action.getRowIdOnClick}" reRender="dtbMpt004Srch">
								<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.rowId}" />
							</a4j:support> 
							<rich:column styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<a4j:region>
									<h:selectBooleanCheckbox style="width: 20" value="#{semmpt004Bean.chkSelAll}">
										<a4j:support event="onclick" action="#{semmpt004Action.selectAllRow}" reRender="pnlSearchResult,dtbMpt004Srch,btnCancleMenu,btnTotalAmt,btnCancleTotalAmt,btnSendReam,
																  btnCancleSendReam,btnExport,btnApprove,btnReject,btnSavePay"/>
									</h:selectBooleanCheckbox>
									</a4j:region>
								</f:facet>
								<div align="center">
									<a4j:region>
									<h:selectBooleanCheckbox id="chkSelect"  value="#{mpt004SrchSP.checkBox}" rendered="#{mpt004SrchSP.dataObj.renderCheckBox}">
										<a4j:support event="onclick" action="#{semmpt004Action.onRenderExportButton}" reRender="frmSearchResult,dtbMpt004Srch,btnCancleMenu,btnTotalAmt,btnCancleTotalAmt,btnSendReam,
																  btnCancleSendReam,btnExport,btnApprove,btnReject,btnSavePay,btnExport3">
											<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.rowId}" />
										</a4j:support>
									</h:selectBooleanCheckbox>  
									</a4j:region>
								</div>
							</rich:column>
							<rich:column id="btnSavePay" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}" rendered="#{semmpt004Bean.renderer['btnSavePay']}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.save']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkInitSavePay" value="#{jspMsg['column.save']}" action="#{navAction.navi}" reRender="popupPropertyTaxPayForm,pnlPropertyTaxPayForm"
									 oncomplete="#{rich:component('popupPropertyTaxPayForm')}.show(); return false"
									 rendered="#{mpt004SrchSP.dataObj.renderCommandLink}">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
										<a4j:actionparam name="methodWithNavi" value="initEdit" />
										<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.rowId}" />
										<a4j:actionparam name="paymentGroupNo" value="#{mpt004SrchSP.dataObj.paymentGroupNo}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="btnEdit" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"  rendered="#{semmpt004Bean.renderer['btnEdit']}">
								<f:facet name="header">
									<h:outputText value="Edit" styleClass="contentform" style="width:40px"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnInitEdit" image="images/edit.png" style="height: 15; width: 15;"
									 action="#{navAction.navi}" reRender="oppContent" >
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT004-2" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="EDIT" />
										<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.rowId}" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.contractNo}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hlkView" value="#{mpt004SrchSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.siteName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.siteName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.pTaxYear}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxYear']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.pTaxYear}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.paymentStatus}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.paymentStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.periodNo}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform" style="width:12px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.periodNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.expenseType}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.expenseType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.serviceName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.service']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.serviceName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.vendorCode}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.vendorCode}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.vendorName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.vendorName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.payeeName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.excAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.excAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.excAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.whtAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.whtAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.vatAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.vatAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.chqAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.chqAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.diffAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.diffAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.paymentTypeDesc}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.paymentTypeDesc}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.bankName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.bankName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.bankAccNo}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.bankAccNo}" styleClass="contentform"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{mpt004SrchSP.dataObj.chqDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.chqDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.chqReceiveDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.chqReceiveDtStr}" styleClass="contentform">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.transferDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.transferDtStr}" styleClass="contentform">
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.diffRemark}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffRemark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.diffRemark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.remark}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.exportFlag}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.exportFlag']}" styleClass="contentform"  style="width:6px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.exportFlag}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.exportDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.exportDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.exportDtStr}" styleClass="contentform">
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.docType}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docType']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.docTypeDesc}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.doc68}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc68']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.doc68}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.doc92}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc92']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
								
									<!-- fixed by.. YUT 2014/09/16 >> -->
									<a4j:commandLink id="hlkCutting" value="#{mpt004SrchSP.dataObj.doc92}" action="#{navAction.navi}" 
										reRender="common_popupCuttingFormSave, frmError-common_popupCutting" styleClass="contentform"
									 	oncomplete="#{rich:component('common_popupCuttingForm')}.show(); return false" >

											<a4j:actionparam name="navModule" value="pt" />
											<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
											
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="paramPaymentId" value="#{mpt004SrchSP.dataObj.rowId}" />
											<a4j:actionparam name="paramPaymentStatus" value="#{mpt004SrchSP.dataObj.paymentStatusId}" />
											<a4j:actionparam name="paramPaymentRemark" value="#{mpt004SrchSP.dataObj.remark}" />
											<a4j:actionparam name="paramRcptPayCutAmount" value="#{mpt004SrchSP.dataObj.rcptPayCutAmount}" />
											
											<a4j:actionparam name="paramFwdNavModule" value="pt" />
											<a4j:actionparam name="paramFwdNavAction" value="SEMMPT004" />
											<a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
									</a4j:commandLink>
									<!-- fixed by.. YUT 2014/09/16 << -->
										
								</div>
							</rich:column>
							
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.doc69}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc69']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.doc69}" styleClass="contentform"/>
								</div>
							</rich:column>
							
							<!-- fixed by.. YUT 2014/09/30 >> -->
							<rich:column styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sendInfoStatus']}" styleClass="contentform"  style="width:100px;"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.sendInfoStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<!-- fixed by.. YUT 2014/09/30 << -->
							
							<!-- fixed by.. YUT 2014/09/30 >> -->
                            <rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.notDisbursed']}" styleClass="contentform"  style="width:100px;"/>
                                </f:facet>
                                <div align="center">
                                    <a4j:commandButton id="notDisbursedBtn"
                                        disabled="#{!(semmpt004Bean.mpt004Srch.paymentStatus eq '01' or semmpt004Bean.mpt004Srch.paymentStatus eq '14')}"
                                        action="#{navAction.navi}" 
                                        reRender="ddlDisbursedStatusList,    common_popupFrmNotDisbursed, frmError-common_popupNotDisbursed"
                                        value="#{jspMsg['btn.notDisbursed']}" styleClass="rich-button" style="width:110px;"
                                        oncomplete="#{rich:component('common_popupNotDisbursedForm')}.show(); return false" >
                                        
                                            <a4j:actionparam name="navModule" value="pt" />
                                            <a4j:actionparam name="navProgram" value="SEMMPT004-1" />
                                            
                                            <a4j:actionparam name="moduleWithNavi" value="common" />
                                            <a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
                                            <a4j:actionparam name="methodWithNavi" value="initPopupNotDisbursed" />
                                            <a4j:actionparam name="paramPaymentId" value="#{mpt004SrchSP.dataObj.rowId}" />
                                            <a4j:actionparam name="paramPaymentStatus" value="#{semmpt004Bean.mpt004Srch.paymentStatus}" />
                                            <a4j:actionparam name="paramPaymentRemark" value="#{mpt004SrchSP.dataObj.remark}" />
                                            
                                            <a4j:actionparam name="paramFwdNavModule" value="pt" />
                                            <a4j:actionparam name="paramFwdNavAction" value="SEMMPT004" />
                                            <a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
                                    </a4j:commandButton>
                                </div>
                            </rich:column>
                            <!-- fixed by.. YUT 2014/09/30 << -->
							
							<rich:column  styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}"
								title="#{mpt004SrchSP.dataObj.contractNo} #{mpt004SrchSP.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.attachFile']}" styleClass="contentform"  style="width:90px"/>
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
										<a4j:actionparam name="module" value="PT"/>
										<a4j:actionparam name="contractNo" value="#{mpt004SrchSP.dataObj.contractNo}"/>
										<a4j:actionparam name="viewMode" value="N"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmpt004Bean.mpt004SrchList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="29">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt004Srch" 
										maxPages="10" id="dstMpt004Srch" selectedStyleClass="selectScroll" 
										page="#{semmpt004Bean.scrollerPage}"/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				</td>
				</tr>
				</table>
				<!-- end content layout data grid -->
			</a4j:form>
			<a4j:include id="contentPopupPropertyTaxSave" viewId="../../pages/pt/semmpt004-popupPropertyTaxSave.jsp"/>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:form id="frmConfirmCoppyDateDialog">
<rich:modalPanel id="mdpConfirmCoppyDateDialog1" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
		<table width="270px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" >
						<h:outputText value="#{semmpt004Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,pnlSearchResult">						
							<a4j:actionparam name="navModule" value="pt" />
							<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="pt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
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
		<table width="270px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform">
						<h:outputText value="#{semmpt004Bean.confirmCoppyDateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="5" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,pnlSearchResult">						
							<a4j:actionparam name="navModule" value="pt" />
							<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="pt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
							<a4j:actionparam name="methodWithNavi" value="doCoppyDate" />
							<a4j:actionparam name="confirmStatus" value="Y" />						
							<rich:componentControl for="mdpConfirmCoppyDateDialog2" operation="hide" event="oncomplete"  />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,pnlSearchResult">						
							<a4j:actionparam name="navModule" value="pt" />
							<a4j:actionparam name="navProgram" value="SEMMPT004-1" />
							<a4j:actionparam name="moduleWithNavi" value="pt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMPT004" />
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

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>


<jsp:include page="../../pages/popup/common-popupCutting.jsp"/>