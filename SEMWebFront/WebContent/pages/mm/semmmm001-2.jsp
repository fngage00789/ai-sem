<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.master.name']}"/></f:facet>	
	
	<h:panelGrid columnClasses="gridContent" width="100%">
		<!-- begin content layout criteria -->
		<h:panelGrid width="98%">
		
			<a4j:form id="frmContractInfo">
				<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
                	<h:panelGroup>
                		<table width="100%">
							<tr>
								<td width="100%" align="right">
									<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" disabled="#{semmmm001Bean.contractInfo.siteInfoId == null}" 
										oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfo.siteInfoId}" />
									</a4j:commandButton>
									
									<rich:spacer width="5px;"></rich:spacer>
									
									<a4j:commandButton id="btnSaveVendorDetailTop" reRender="oppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
									panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
									value="#{jspMsg['btn.save']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.validatePage.saveButton == 'N'}" 
									rendered="#{semmmm001Bean.validatePage.saveButton != 'H'}"
									action="#{semmmm001Action.doValidateVendorSaveDraft}"
									oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;">	
													
									</a4j:commandButton>
													
									<rich:spacer width="5" rendered="#{semmmm001Bean.validatePage.saveButton != 'H'}"/>
									<%-- 2017/08/10 .. callback function request >> --%>
													
									<a4j:commandButton id="btnCancelVendorDetailTop" reRender="txtNavProgram, oppContent"
									value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.validatePage.cancelButton == 'N'}"
									rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"
									action="#{navAction.navi}" style=" width : 63px;">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="mode" value="Edit" />
										<a4j:actionparam name="headType" value="Vendor" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorId}" />
														
										<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseEffectiveDtStrParam}" />
										<a4j:actionparam name="effectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.effectiveDtStrParam}" />
										<a4j:actionparam name="expireDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expireDtStrParam}" />
										<a4j:actionparam name="expenseTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseTypeIdParam}" />
										<a4j:actionparam name="payTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payTypeIdParam}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdParam}" />
										<a4j:actionparam name="cancelFlag" value="Y" />
										<a4j:actionparam name="actionId" value="CANCEL_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"/>
									
									<a4j:commandButton id="btnBackCancelVendorDetail_top" reRender="txtNavProgram, oppContent"
									title="BC"
									value="#{jspMsg['btn.back']}" styleClass="rich-button"
									disabled="#{semmmm001Bean.validatePage.cancelButton == 'N'}"
									rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"
									action="#{semmmm001Action.doInitValidateBack}"
									oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
										<a4j:actionparam name="mode" value="Edit" />
										<a4j:actionparam name="headType" value="Vendor" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorId}" />
														
										<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseEffectiveDtStrParam}" />
										<a4j:actionparam name="effectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.effectiveDtStrParam}" />
										<a4j:actionparam name="expireDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expireDtStrParam}" />
										<a4j:actionparam name="expenseTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseTypeIdParam}" />
										<a4j:actionparam name="payTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payTypeIdParam}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdParam}" />
										<a4j:actionparam name="cancelFlag" value="Y" />
										<a4j:actionparam name="actionId" value="CANCEL_VENDOR" />
										<a4j:actionparam name="moduleType" value="VD" />
									</a4j:commandButton>
									
									
									<a4j:commandButton id="btnBackInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B1"
					           	 	action="#{semmmm001Action.doInitValidateBack}"
					           	 	reRender="txtNavProgram, oppContent, mmm001PopUpCommon_controllerBtnBack" 
					           	 	rendered="#{semmmm001Bean.renderedBtnTodoBack == false and semmmm001Bean.validatePage.cancelButton == 'H'}"
					           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
										
										
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="moduleType" value="VD" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBack_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B2"
					           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" 
					           	 	rendered="false"
					           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="moduleType" value="VD" />
									</a4j:commandButton>
									
									
									<a4j:commandButton id="btnBackTodoInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B3"
									action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent"
									rendered="#{semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.validatePage.cancelButton == 'H'}"
									oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
										
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
										<a4j:actionparam name="moduleType" value="VD" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackTodo_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B4"
									action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" 
									rendered="false"
									oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
										<a4j:actionparam name="moduleType" value="VD" />
									</a4j:commandButton>
							
									<a4j:jsFunction name="changePageVD" action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
											<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBackAfterSave}" />
											<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBackAfterSave}" />
											<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBackAfterSave}" />
											<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBackAfterSave}" />
											<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBackAfterSave}" />
											<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlagBackAfterSave}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractNoParamBackAfterSave}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorIdParamBackAfterSave}" />
											<a4j:actionparam name="actionId" value="#{semmmm001Bean.actionIdBackAfterSave}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorMapPayeeIdParamBackAfterSave}" />
									</a4j:jsFunction>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</h:panelGrid>	
				
				
				<rich:spacer rendered="#{semmmm001Bean.visiblePnlContractInfo}" />
			
				<!-- group[1] >> -->
				<h:panelGrid id="pnlContractInfo" width="100%" style="border:solid 1px gray;" 
				rendered="#{semmmm001Bean.validatePage.contractInfoBox != 'H'}">
					<h:panelGroup>
						<rich:panel style="width:98%;">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}"/></f:facet>
						
						<!-- contract info panel -->
						<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="0">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.number']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoContractNo" value="#{semmmm001Bean.contractInfo.contractNo}" 
											disabled="true" style="width:70%;" />
											
											<a4j:commandButton id="btnSelectVendorContract" value="..." styleClass="rich-button" 
											style="margin-left:5px; height:22px; vertical-align:top;" 
				           	 				oncomplete="#{rich:component('popupSearchSiteContract')}.show(); return false;"
											action="#{semmmm001Action.initPopupSiteContract}" reRender="pnlContractInfo, popupSearchSiteContract"
											disabled="">
												<a4j:actionparam name="vendorContractFlag" value="Y"></a4j:actionparam> 
											</a4j:commandButton>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.number.old']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoContractOldNo" value="#{semmmm001Bean.contractInfo.contractOldNo}"
											disabled="true" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.region']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="region" value="#{semmmm001Bean.contractInfo.region}" 
											disabled="true" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.site.name']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoSiteName" value="#{semmmm001Bean.contractInfo.siteName}" 
											disabled="true" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.site.address']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoSiteLoaction" value="#{semmmm001Bean.contractInfo.siteLocation}" 
											disabled="true" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.first.effective.date']}"/>
										</td>
										<td style="width:30%;">
											<rich:calendar id="contractInfoFirstEffectiveDtStr" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmmm001Bean.contractInfo.firstEffectiveDt}"
											   showWeeksBar="false"
											   inputSize="10"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	   cellWidth="15px" cellHeight="20px"
										   	   oninputblur="return dateformat.submitFomatDate(this);"
										   	   label=""
										   	   disabled="true"
										   	   styleClass="ms7">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.location.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoLocationId" value="#{semmmm001Bean.contractInfo.locationId}" 
											disabled="true" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.effective.date']}"/>
										</td>
										<td style="width:30%;">
											<rich:calendar id="contractInfoEffectiveDtStr" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmmm001Bean.contractInfo.effectiveDt}"
											   showWeeksBar="false"
											   inputSize="10"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	   cellWidth="15px" cellHeight="20px"
										   	   oninputblur="return dateformat.submitFomatDate(this);"
										   	   label=""
										   	   disabled="true"
										   	   styleClass="ms7">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.location.code']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoLocationCode" value="#{semmmm001Bean.contractInfo.locationCode}" 
			                				disabled="true" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.expire.date']}"/>
										</td>
										<td style="width:30%;">
											<rich:calendar id="contractInfoExpireDtStr" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmmm001Bean.contractInfo.expireDt}"
											   showWeeksBar="false"
											   inputSize="10"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	   cellWidth="15px" cellHeight="20px"
										   	   oninputblur="return dateformat.submitFomatDate(this);"
										   	   label=""
										   	   disabled="true"
										   	   styleClass="ms7">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.network.status']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoNetworkStatus" value="#{semmmm001Bean.contractInfo.networkStatus}" 
			                				disabled="true" style="width:70%;" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.status']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoContractStatus" value="#{semmmm001Bean.contractInfo.contractStatus}" 
											disabled="true" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td colspan="2">
											&nbsp;
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.pennding.status']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoPendingStatus" value="#{semmmm001Bean.contractInfo.pendingStatus}" 
											disabled="true" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.owner.name']}" rendered="false"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoOwnerName" value="#{semmmm001Bean.contractInfo.ownerName}" 
			                				disabled="true" style="width:70%;" rendered="false"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contract.name']}" rendered="false"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoContractName" value="#{semmmm001Bean.contractInfo.contractName}" 
											disabled="true" style="width:70%;" rendered="false"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.contact.name']}" rendered="false"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="contractInfoContactName" value="#{semmmm001Bean.contractInfo.contactName}" 
			                				disabled="true" style="width:70%;" rendered="false"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.telephone']}" rendered="false"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="contractInfoTelephone" value="#{semmmm001Bean.contractInfo.telephone}" 
											disabled="true" style="width:70%;" rendered="false"/>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<!-- button info + back -->
						<h:panelGrid id="groupInfoButton" width="100%">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:100%; text-align:right;">
											<a4j:commandButton id="btnContractHistory" value="Contract History" 
											styleClass="rich-button" disabled="#{semmmm001Bean.contractInfo.contractNo == null}"
											action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
											oncomplete="#{rich:component('mmm001PopUpHistory1')}.show();onTopPage();"
											rendered="false">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="doContractHistory" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="historyPage" value="CT" />
											</a4j:commandButton>
											
											
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				
				
					<rich:spacer height="10"></rich:spacer>
				
					<!-- data table panel -->
					<rich:panel id="pnlVendorContResult" styleClass="sem_autoScrollbarInMM" >
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg['header.list.of.vendor.by.contract']}" style="width: 3200"/>
                        </f:facet>
                        
                        <rich:dataTable id="dtbVendorListByContract" width="100%" 
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.vendorContractList}" var="vendorObj"
							reRender="dtbVendorListByContract" rows="#{semmmm001Bean.rowPerPage}"
							rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
								
								<rich:column style="width:40px;" title="">
									<f:facet name="header">
										<h:outputText value="Delete" styleClass="ms7"/>
									</f:facet>
									
									<div align="center" style="">
										<a4j:commandButton id="vendorDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
						           	 	action="#{navAction.navi}" reRender="oppContent, txtNavProgram"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_confirmPopup')}.show(); return false;">
						           	 		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doInitDeleteVendorContract" />
						           	 		<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{vendorObj.dataObj.vendorId}" />
							           		<a4j:actionparam name="vendorMapPayeeIdParam" value="#{vendorObj.dataObj.vendorMapPayeeId}" />
							           		<a4j:actionparam name="confirmMsg" value="#{vendorObj.dataObj.confirmMsg}" />
										</a4j:commandButton>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.vendorCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.code']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<a4j:commandLink id="hlkVendorCode" value="#{vendorObj.dataObj.vendorCode}" 
										action="#{navAction.navi}" reRender="oppContent, expenseContractNo, expenseExpenseEffectiveDt, expenseEffectiveDt, 
													expenseExpireDt, expenseExpenseType, rdoExpensePayType, btnSaveVendorDetail" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{vendorObj.dataObj.vendorId}" />
										</a4j:commandLink>
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorObj.dataObj.vendorName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.idCard}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.citizen.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.idCard}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column sortBy="#{vendorObj.dataObj.taxId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.personal.tax.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.taxId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.expenseType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.expenseType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.siteName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.site.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorObj.dataObj.siteName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.vendorStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.vendorStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.vendorFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.vendorBlockStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.block']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.vendorBlockStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.bankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorObj.dataObj.bankName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.bankBranch}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorObj.dataObj.bankBranch}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.accountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.accountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.accountName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorObj.dataObj.accountName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.bookbankStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.bookbankStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.bookbankFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.id']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.payeeId}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorObj.dataObj.payeeName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.payeeStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeBankName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.bank.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:150px;">
										<h:outputText value="#{vendorObj.dataObj.payeeBankName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeAccountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.payeeAccountName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{vendorObj.dataObj.payeeAccountName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.bookbankPayeeStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{vendorObj.dataObj.bookbankPayeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{vendorObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.vendorContractList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="21">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVendorListByContract"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllVendorListByContract" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dtbVendorListByContract"></a4j:support>
											</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
								
							</rich:dataTable>
                    	</rich:panel>
					</h:panelGroup>
					
				</h:panelGrid>
				<!-- group[1] << -->
				
				<rich:spacer />
				
				<h:panelGrid id="pnlVendorConfirm" width="100%" style="border:solid 1px gray;" 
				rendered="#{semmmm001Bean.vendorInfo.confirmTxt != null}">
				
					
					<h:panelGroup id="groupVendorConfirm">
						<h:outputText value="#{semmmm001Bean.vendorInfo.confirmTxt}" styleClass="ms7red"></h:outputText>
						<a4j:commandButton id="btnViewVendorConfirm" value="View Change Of Data" styleClass="rich-button" 
							action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
							oncomplete="#{rich:component('mmm001PopUpCommon_confirmDetail')}.show(); return false;" >
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doViewVendorConfirm" />
								
								<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
								<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
								<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							</a4j:commandButton>
							
							
					</h:panelGroup>
				</h:panelGrid>
				<!-- group[2] >> -->
				<!-- info data table panel -->
				<h:panelGrid id="pnlVendorInfo" width="100%" style="border:solid 1px gray;" 
				rendered="#{semmmm001Bean.visiblePnlVendorInfo}">
				
					<!-- button vendorInfo -->
					<h:panelGroup id="groupVendorInfoButton">
						<rich:panel>
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}">
						 		<f:facet name="header">
		                        	<h:outputText value="Entered Data Status:"></h:outputText>
		                    	</f:facet>
					 			<f:facet name="errorMarker">
					 				 <h:graphicImage value="images/error.gif" />  
			                    </f:facet>
		                	</rich:messages>
		                	
		                	<table width="95%">
								<tr>
									<td style="width:70%;">
										<a4j:commandButton id="btnNewVendorCntrct" value="New Vendor" styleClass="rich-button"
										action="#{navAction.navi}" reRender="oppContent, txtNavProgram"
										rendered="#{semmmm001Bean.validatePage.newChangeButton != 'H'}"
										disabled="#{semmmm001Bean.validatePage.newChangeButton == 'N'}"
										style="padding-left: 5px; width:77px;">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doNewVendorByContract" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="expenseTypeParam" value="#{semmmm001Bean.expCntrctOfVndObj.expenseType}" />
											<a4j:actionparam name="changeType" value="N" />
											<a4j:actionparam name="btnActionType" value="C" />
											<a4j:actionparam name="actionId" value="CHANGE_NEW_VENDOR" />
										</a4j:commandButton>
										
										<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNewVendorDetail}"/>
										
										<a4j:commandButton id="btnSelVendorContract" value="Select Vendor" styleClass="rich-button"
										oncomplete="#{rich:component('mmm001PopUpCommon_changeVendor')}.show(); return false;"
										action="#{semmmm001Action.initChangeVendor}" reRender="mmm001PopUpCommon_changeVendor"
										rendered="#{semmmm001Bean.validatePage.editChangeButton != 'H'}"
										disabled="#{semmmm001Bean.validatePage.editChangeButton == 'N'}"
										style="padding-left: 2px; width:77px;">
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="expenseTypeParam" value="#{semmmm001Bean.expCntrctOfVndObj.expenseType}" />
											<a4j:actionparam name="btnActionType" value="C" />
											<a4j:actionparam name="actionId" value="CHANGE_SELECT_VENDOR" />
										</a4j:commandButton>
										
										<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnSelectVendor}"/>
										
										<a4j:commandButton id="btnNewVendor" value="New Vendor" styleClass="rich-button"
										action="#{navAction.navi}" disabled="#{semmmm001Bean.validatePage.newVendorButton == 'N'}"
										rendered="#{semmmm001Bean.validatePage.newVendorButton != 'H'}" 
										reRender="oppContent"
										style="padding-left: 5px; width:90px;">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doNewVendorClearContent" />
											<a4j:actionparam name="mode" value="New" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="contractNoParam" value="" />
											<a4j:actionparam name="vendorIdParam" value="" />
											<a4j:actionparam name="newVendorFlag" value="Y"/>
											<a4j:actionparam name="btnActionType" value="N" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="actionId" value="PAGE_VENDOR_DETAIL_NEW" />
										</a4j:commandButton>
										
										<%-- 
										<a4j:commandButton id="btnNewVendor" value="New Vendor" styleClass="rich-button" 
						           		disabled="#{semmmm001Bean.disableBtnNewVendor}"
										action="#{semmmm001Action.initPopupSearchContract}" reRender="mmm001PopUpCommon_searchContract" 
										oncomplete="#{rich:component('mmm001PopUpCommon_searchContract')}.show();">
										</a4j:commandButton>
										--%>
										
										<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNewAllVendor}"/>
										
										<a4j:commandButton id="btnEdtVendorData" value="Edit Data" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.validatePage.editDataButton == 'N'}"
						           	 	rendered="#{semmmm001Bean.validatePage.editDataButton != 'H'}"
						           	 	reRender="oppContent" style="padding-left: 5px; width:77px;">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doEditVendorData" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorFlowStatusParam" value="#{semmmm001Bean.vendorInfo.vendorFlowStatus}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="btnActionType" value="ED" />
											<a4j:actionparam name="actionId" value="EDIT_DATA" />
											
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.validatePage.editDataButton != 'H'}"/>
										
										<a4j:commandButton id="btnEdtVendor" value="Edit Vendor" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.validatePage.editVendorButton == 'N'}"
						           	 	rendered="#{semmmm001Bean.validatePage.editVendorButton != 'H'}"
						           	 	reRender="oppContent" style="padding-left: 5px; width:77px;">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doEditVendorByVendorId" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorFlowStatusParam" value="#{semmmm001Bean.vendorInfo.vendorFlowStatus}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="btnActionType" value="E" />
											<a4j:actionparam name="actionId" value="EDIT" />
											
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnEditVendor}"/>
						           		<a4j:commandButton id="btnChngeVendor" value="Change Vendor" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" rendered="#{semmmm001Bean.validatePage.changeVendorButton != 'H'}"
						           	 	disabled="#{semmmm001Bean.validatePage.changeVendorButton == 'N'}"
						           	 	reRender="oppContent" >
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doChangeVendor" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorFlowStatusParam" value="#{semmmm001Bean.vendorInfo.vendorFlowStatus}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="btnActionType" value="C" />
											<a4j:actionparam name="actionId" value="CHANGE" />
						           		</a4j:commandButton>
						           		
						          		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnChangeVendor}"/>
						          		<a4j:commandButton id="btnSndToMng" value="Send To Manager" 
						          		rendered="#{semmmm001Bean.validatePage.sendMNGButton != 'H'}"
						          		disabled="#{semmmm001Bean.validatePage.sendMNGButton == 'N'}"
						           	 	action="#{navAction.navi}" styleClass="rich-button" 
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
						           	 	reRender="oppContent, dtbVendorListByContract" 
										oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doSendToMNGByVendorId" />
											<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="actionTypeParam" value="#{semmmm001Bean.contractInfo.actionType}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="actionId" value="SEND_TO_MNG" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnSendManagerVD}"/>
						           		
						           		<a4j:commandButton id="btnExpBtchVD" value="Export Batch" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.validatePage.exportBatchButton == 'N'}" 
						           	 	rendered="#{semmmm001Bean.validatePage.exportBatchButton != 'H'}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="frmContractInfo,pnlShowReportVendorExcel"
						           	 	style="padding-left: 5px; width:85px;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_VD" />
											<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="actionId" value="EXP_BATCH" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedExportBatchVD}"/>
						           		<a4j:commandButton id="btnClearBatch" value="#{jspMsg['btn.clearBatch']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.validatePage.clearBatchButton == 'N'}" 
						           	 	rendered="#{semmmm001Bean.validatePage.clearBatchButton != 'H'}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CLEAR_BATCH" />
											<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="actionId" value="CLEAR_BATHC" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnClearBatch}"/>
						           		
						           		<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']} #{jspMsg['btn.vendor']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.validatePage.cancelVendorButton == 'N'}" 
						           	 	rendered="#{semmmm001Bean.validatePage.cancelVendorButton != 'H'}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CANCEL" />
											<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="actionId" value="CENCEL_VENDOR" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.disableCancel}"/>
						           		
						           		<a4j:commandButton id="btnConfirm" value="#{jspMsg['btn.confirm']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" 
						           	 	disabled="#{semmmm001Bean.validatePage.confirmVendorButton == 'N'}" 
						           	 	rendered="#{semmmm001Bean.validatePage.confirmVendorButton != 'H'}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatusDelete')}.show(); return false;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CONFIRM" />
											<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
											<a4j:actionparam name="typeFlag" value="V" />
											<a4j:actionparam name="actionId" value="CONFIRM_VENDOR" />
						           		</a4j:commandButton>
						           		
						           		<%--
						           		<rich:spacer width="5"/>
										<a4j:commandButton id="btnAssignOrAddContract" 
										value="#{jspMsg['btn.assign.or.add.contract']}" styleClass="rich-button"
										action="#{semmmm001Action.initPopupSearchContract}" reRender="mmm001PopUpCommon_searchContract" 
										oncomplete="#{rich:component('mmm001PopUpCommon_searchContract')}.show();"
										disabled="#{semmmm001Bean.vendorInfo.vendorId == null}" >
											<a4j:actionparam name="cntrctFlagParam" value="ASSIGN_CONTRACT" />
										</a4j:commandButton>
										--%>
						          	</td>
						          	<td style="text-align:right;">
						           		<a4j:commandButton id="btnDlteVendor" value="Delete Vendor" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" rendered="#{semmmm001Bean.validatePage.deleteVendorButton != 'H'}"
						           	 	disabled="#{semmmm001Bean.validatePage.deleteVendorButton == 'N'}" 
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
						           	 	reRender="oppContent, dtbVendorListByContract" 
										oncomplete="#{rich:component('mmm001PopUpCommon_retStatusDelete')}.show(); return false;">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doDeleteVendorByVendorId" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="actionId" value="DELETE_VENDOR" />
						           		</a4j:commandButton>
						          	</td>
						       	</tr>
							</table>
						
						</rich:panel>
					
					</h:panelGroup>
					
					<!-- vendor info panel -->
					<h:panelGroup>
						<rich:panel id="vendorInfo" style="width:100%">
							<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}"/></f:facet>
							
							
							<table width="95%" class="ms7">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.info.from.sap']}"/>
										</td>
										<td style="width:30%;">
											<a4j:commandButton id="btnCopyInfoFromSAP" value="Copy Vendor's Info from SAP" styleClass="rich-button"
											 action="#{semmmm001Action.doCopyVendorInfoFromSAP}" reRender="vendorInfo, panelTab0"
											 disabled="#{semmmm001Bean.disableBtnCopyFromSAP}">
											</a4j:commandButton>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.saprole']}"/>
										</td>
										<td style="width:30%;">
											<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.role}"></h:outputText>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.company']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoCompany" value="#{semmmm001Bean.vendorInfo.company}" style="width:100px;"
											disabled="#{semmmm001Bean.validatePage.company == 'N'}" >
			                					<f:selectItems value="#{semmmm001Bean.companyList}" />
			                				</h:selectOneMenu>
			                				
			                				<h:outputText value="#{semmmm001Bean.vendorInfo.vendorCompanySap}" 
											rendered="#{semmmm001Bean.vendorInfo.vendorCompanySap != null}" styleClass="ms7"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.vendor.type']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoVendorType" value="#{semmmm001Bean.vendorInfo.vendorType}" 
											disabled="#{semmmm001Bean.validatePage.vendorType == 'N'}"  
											>
			                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
			                				</h:selectOneMenu>
			                				
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorType}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorType != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.code']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoVendorCode" value="#{semmmm001Bean.vendorInfo.vendorCode}" 
											disabled="true" style="width:200px;" />
											
											<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorCode}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorCode != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											
										</td>
										<td style="width:30%;">
											
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.vendor.name1']}"/>
										</td>
										<td style="width:30%;">
			                				<h:inputText id="vendorInfoVendorName1" value="#{semmmm001Bean.vendorInfo.vendorName1}" 
			                				disabled="#{semmmm001Bean.validatePage.vendorName1 == 'N'}" style="width:70%;" maxlength="35"/>
			                				
			                				<a4j:jsFunction name="copyVendorName" reRender="panelTab6,mmm001tab6_withholdName" action="#{semmmm001Action.doCopyVendorName}">
									           
									        </a4j:jsFunction>
									        
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName1}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName1 != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoVendorName2" value="#{semmmm001Bean.vendorInfo.vendorName2}" 
											disabled="#{semmmm001Bean.validatePage.vendorName2 == 'N'}" style="width:70%;" maxlength="35"/>
											
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName2}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName2 != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoVendorName3" value="#{semmmm001Bean.vendorInfo.vendorName3}" 
											disabled="#{semmmm001Bean.validatePage.vendorName3 == 'N'}" style="width:70%;" maxlength="35"/>
											
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName3}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName3 != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoVendorName4" value="#{semmmm001Bean.vendorInfo.vendorName4}" 
											disabled="#{semmmm001Bean.validatePage.vendorName4 == 'N'}" style="width:70%;" maxlength="35"/>
											
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName4}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName4 != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoIdCard" value="#{semmmm001Bean.vendorInfo.idCard}" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											disabled="#{semmmm001Bean.validatePage.idCard == 'N'}" 
											style="width:70%;" maxlength="13" />
											
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.idCard}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.idCard != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="vendorInfoTaxId" value="#{semmmm001Bean.vendorInfo.taxId}" 
											disabled="#{semmmm001Bean.validatePage.taxId == 'N'}" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											
											style="width:70%;" maxlength="13"  />
											
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.taxId}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.taxId != null}"
											style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%;" class="">
											<h:outputText value=""/>
										</td>
										<td style="width:30%;">
											<h:outputText value="#{jspMsg['btn.check.vendor.info']}" style="color:red;" styleClass="ms7" rendered="false"/>
											<a4j:commandButton id="btnChkVendor" value="Check Vendor" styleClass="rich-button" 
											rendered="#{semmmm001Bean.validatePage.checkVendor != 'H'}"
											disabled="#{semmmm001Bean.validatePage.checkVendor == 'N'}" 
											style="margin-left:5px;" 
		           	 						oncomplete="#{rich:component('mmm001PopUpCommon_semSapVedorInfoList')}.show(); return false;"
											action="#{semmmm001Action.doChkVendor}" reRender="oppContent"> 
											</a4j:commandButton>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.hq.branch']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="vendorInfoHqBranch" value="#{semmmm001Bean.vendorInfo.hqFlag}" 
											disabled="#{semmmm001Bean.validatePage.branch == 'N'}" 
											style="width:120px;" onchange="defaultBranchCode();">
			                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
			                				</h:selectOneMenu>
			                				&nbsp;
			                				<a4j:jsFunction name="defaultBranchCode" action="#{semmmm001Action.doGetDefaultBranchCode}" reRender="vendorInfoBranchNo">
			                				
			                				</a4j:jsFunction>
			                				
			                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
			                				<h:inputText id="vendorInfoBranchNo" value="#{semmmm001Bean.vendorInfo.branchNo}" 
											disabled="#{semmmm001Bean.validatePage.branchNo == 'N'}"  
											onkeypress="return numberformat.keyPressDecimalOnly('vendorInfoBranchNo', event);" 
											maxlength="5" style="width:50px;" />
											
			                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.branchNo}" 
											rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.branchNo != null}"
											style="color:red; padding-left:188px; display:block;" styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" rendered="false"/>
											<h:outputText value="Withhold :" rendered="false"/>
										</td>
										<td style="width:30%;">
			                				<a4j:region rendered="false">
												<h:selectOneMenu id="vendorInfoWhtId" value="#{semmmm001Bean.vendorInfo.whtId}" 
												disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}" 
												onchange="vendorInfo_GetWithholdJS();" styleClass="" style="width:100px;">
													<f:selectItems value="#{semmmm001Bean.withholdList}" />
												</h:selectOneMenu>
												
												<a4j:jsFunction name="vendorInfo_GetWithholdJS" reRender="vendorInfoWhtType, vendorInfoWhtCode" 
												action="#{semmmm001Action.doGetWithhold}">
												</a4j:jsFunction>
											</a4j:region>
			                				
			                				<h:outputText value="W/H Type : " styleClass="ms7" style="padding-left:10px;" rendered="false" />
			                				<h:inputText id="vendorInfoWhtType" value="#{semmmm001Bean.vendorInfo.whtType}" 
											disabled="true" rendered="false"  
											maxlength="20" style="width:30px; text-align:center;" styleClass="" />
											
											<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.whtType}" 
											rendered="false"
											style="color:red; padding-left:4px; display:inline;" styleClass="ms7"/>
											
											
			                				<h:outputText value="W/H Code : " styleClass="ms7" style="padding-left:10px;" rendered="false"/>
			                				<h:inputText id="vendorInfoWhtCode" value="#{semmmm001Bean.vendorInfo.whtCode}" 
											disabled="true"  rendered="false"
											maxlength="20" style="width:30px; text-align:center;" styleClass="" />
											
											<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.whtCode}" 
											rendered="false"
											style="color:red; padding-left:4px; display:inline;" styleClass="ms7"/>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											
										</td>
										<td style="width:30%;">
											
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											
										</td>
										<td style="width:80%;" colspan="3">
											
											<table>
												<tr>
													<td>
														<h:selectBooleanCheckbox id="chkVAT" 
														value="#{semmmm001Bean.vendorInfo.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" 
														disabled="#{semmmm001Bean.validatePage.vat == 'N'}"/>
								                		<h:outputText value="#{jspMsg['label.vendor.vat.registration']}" styleClass="ms7" style="padding-left:2px;" />
								                		
								                		<rich:spacer width="5"></rich:spacer>
													</td>
													<td>
														<h:selectBooleanCheckbox id="vendorInfoVendorBlockStatus" 
														value="#{semmmm001Bean.vendorBlockStatus}" style="vertical-align:bottom; margin-left:-3px;" 
														disabled="#{semmmm001Bean.validatePage.block == 'N'}"/>
								                		
								                		<h:outputText value="Block" styleClass="ms7" style="padding-left:2px;" />
								                		<rich:spacer width="5"></rich:spacer>
													</td>
													<td>
														<h:selectBooleanCheckbox id="vendorInfoNotPayeeFlag" 
														value="#{semmmm001Bean.notPayeeFlag}" style="vertical-align:bottom; margin-left:-3px;" 
														disabled="#{semmmm001Bean.validatePage.notPayee == 'N'}"/>
								                		<h:outputText value="#{jspMsg['label.vendor.notpayee']}" styleClass="ms7" style="padding-left:2px;" />
														<rich:spacer width="5"></rich:spacer>
													</td>
													<td>
														<h:selectBooleanCheckbox id="vendorInfOtherExpenseFlag" 
														value="#{semmmm001Bean.otherExpenseFlag}" style="vertical-align:bottom; margin-left:-3px;" 
														disabled="#{semmmm001Bean.validatePage.noContract == 'N'}" onclick="chkWithoutCont();">
															
														</h:selectBooleanCheckbox>
														<a4j:jsFunction name="chkWithoutCont" action="#{semmmm001Action.doChkWithoutContract}" 
														reRender="oppContent">
															<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
															<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
															<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
															<a4j:actionparam name="actionId" value="VENDOR_WITHOUT_CONTRACT" />
														</a4j:jsFunction>
								                		<h:outputText value="#{jspMsg['label.vendor.vendornocontract']}" styleClass="ms7" style="padding-left:2px;" />
														<rich:spacer width="5"></rich:spacer>
													</td>
													<td>
														<h:selectBooleanCheckbox id="vendorInfoBlackListStatus" 
														value="#{semmmm001Bean.vendorBlackListStatus}" style="vertical-align:bottom; margin-left:-3px;" 
														disabled="#{semmmm001Bean.validatePage.blackList == 'N'}"
														onclick="initConfirmBlackList();" />
								                		<h:outputText value="Blacklist" styleClass="ms7" style="padding-left:2px;" />
								                		
								                		<a4j:jsFunction name="initConfirmBlackList" action="#{navAction.navi}"
								                		reRender="oppContent,mmm001PopUpCommon_confirm"
								                		oncomplete="#{rich:component('mmm001PopUpCommon_confirm')}.show(); return false;">
								                			<a4j:actionparam name="navModule" value="mm" />
															<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
															<a4j:actionparam name="moduleWithNavi" value="mm" />
															<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
															<a4j:actionparam name="methodWithNavi" value="doInitConfirmBlackList" />
								                		</a4j:jsFunction>
														
													</td>
													<td>
														<h:selectBooleanCheckbox id="mmm001tab0_chkLocalDepartment" 
														value="#{semmmm001Bean.vendorAddrObj.chkLocalDepartment}"
														disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent}"
														onclick="" style="vertical-align:bottom; margin-left:3px;" />
														
														<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" style="padding-left:2px;"/>
													</td>
													
												</tr>
												
												<tr>
													<td>
														<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.includeVAT}" 
														rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.includeVAT != null}"
														style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
														<rich:spacer width="5"></rich:spacer>
													</td>
													<td>
														<h:selectBooleanCheckbox id="vendorInfoVendorBlockStatusSAP" 
														value="#{semmmm001Bean.vendorBlockStatusSAP}" style="vertical-align:bottom; margin-left:-3px;" 
														rendered="#{semmmm001Bean.vendorBlockStatusSAP}" disabled="true"/>
								                		
								                		<h:outputText value="Block" styleClass="ms7" style="color:red; padding-left:4px; " rendered="#{semmmm001Bean.vendorBlockStatusSAP}"/>
								                		<rich:spacer width="5" rendered="#{semmmm001Bean.vendorBlockStatusSAP}"></rich:spacer>
													
													</td>
													<td>
														<h:selectBooleanCheckbox id="vendorInfoNotPayeeFlagSAP" 
														value="#{semmmm001Bean.notPayeeFlagSAP}" style="vertical-align:bottom; margin-left:-3px;" 
														rendered="#{semmmm001Bean.notPayeeFlagSAP}" disabled="true"/>
								                		<h:outputText value="#{jspMsg['label.vendor.notpayee']}" style="color:red; padding-left:4px; " rendered="#{semmmm001Bean.notPayeeFlagSAP}"/>
														
													</td>
													<td>
														
													</td>
													<td>
														
													</td>
													<td>
													
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" rowspan="2" class="ms7">
											<h:outputText value="#{jspMsg['label.remarkvendor']}" styleClass="contentform"
											style="vertical-align:top;"/>
										</td>
										<td style="width:30%;" rowspan="2"  class="ms7" >
											<h:inputTextarea id="vendorInfoRemark" 
											value="#{semmmm001Bean.vendorInfo.vendorRemark}"
											disabled="#{semmmm001Bean.validatePage.vendorRemark == 'N'}"
											style="width:500px; height:70px; font-size:13px;">
											</h:inputTextarea>
											
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendor.flow.status']}"/>
										</td>
										<td style="width:30%;" class="ms7" >
											<h:selectOneMenu id="vendorInfoVendorFlowStatus" value="#{semmmm001Bean.vendorInfo.vendorFlowStatus}" 
											disabled="true" style="">
			                					<f:selectItems value="#{semmmm001Bean.vendorFlowStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.vendorbatch']}" styleClass="contentform"
											style="vertical-align:top;"/>
										</td>
										<td style="width:30%;" class="ms7" >
											<h:outputText id="vendorBatchTxt" value="#{semmmm001Bean.vendorInfo.vendorBatch}"
											style="vertical-align:top;"/>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" rendered="#{semmmm001Bean.validatePage.noContractRemark != 'H'}"/>
											<h:outputText id="expenseWithOutCntrctRemarkLabel" value="#{jspMsg['label.remark']}" styleClass="contentform"
											rendered="#{semmmm001Bean.validatePage.noContractRemark != 'H'}"
											style="vertical-align:top;"/>
										</td>
										<td style="" colspan="3" class="ms7">
											<h:inputTextarea id="expenseWithOutCntrctRemark" 
											value="#{semmmm001Bean.vendorInfo.remarkWithoutContract}"
											rendered="#{semmmm001Bean.validatePage.noContractRemark != 'H' or semmmm001Bean.otherExpenseFlag}"
											disabled="#{semmmm001Bean.validatePage.noContractRemark == 'N'}"
											style="width:500px; height:70px; font-size:13px;">
											</h:inputTextarea>
													
										</td>
									</tr>
								</table>
						</rich:panel>
					
						<!-- button history -->
						<h:panelGrid id="groupHistoryButton" width="95%">
								<table width="100%">
									<tr>
										<td style="width:100%; text-align:right;">
											
											<a4j:commandButton id="btnVendorHistoryPopup" value="Vendor History" 
											styleClass="rich-button" disabled="#{semmmm001Bean.vendorInfo.vendorId == null}"
											action="#{semmmm001Action.doVendorHistory}" reRender="txtNavProgram, oppContent" 
											rendered="false"
											oncomplete="#{rich:component('mmm001PopUpHistory2')}.show();onTopPage();">
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="historyPage" value="VD" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnVendorHistory" value="Vendor History" 
											styleClass="rich-button" disabled="#{semmmm001Bean.vendorInfo.vendorId == null}"
											action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
											
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="doVendorHistory" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
												<a4j:actionparam name="historyPage" value="VD" />
											</a4j:commandButton>
										</td>
									</tr>
								</table>
						</h:panelGrid>
						
						
						<!-- >> tab panel -->
						<h:panelGrid style="width:97%;">
							<rich:tabPanel id="panelTab" selectedTab="#{semmmm001Bean.selectedTab}" switchType="client" style="width:100%;">
								<rich:tab label="#{jspMsg['header.vendor.address']}" id="tab0" onlabelclick="setTabNo0();">
									<a4j:jsFunction name="setTabNo0" action="#{navAction.navi}" 
							         reRender="panelTab, tab0">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab0"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab0"  viewId="../../pages/mm/semmmm001tab0.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.rentor.address']}" id="tab1" onlabelclick="setTabNo1();">
									<a4j:jsFunction name="setTabNo1" action="#{navAction.navi}" 
							         reRender="panelTab, tab1">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab1"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab1"  viewId="../../pages/mm/semmmm001tab1.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.elector.address']}" id="tab2" onlabelclick="setTabNo2();">
									<a4j:jsFunction name="setTabNo2" action="#{navAction.navi}" 
							         reRender="panelTab, tab2">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab2"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab2"  viewId="../../pages/mm/semmmm001tab2.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.property.address']}" id="tab3" onlabelclick="setTabNo3();">
									<a4j:jsFunction name="setTabNo3" action="#{navAction.navi}" 
							         reRender="panelTab, tab3">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab3"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab3" viewId="../../pages/mm/semmmm001tab3.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.insure.address']}" id="tab4" onlabelclick="setTabNo4();">
									<a4j:jsFunction name="setTabNo4" action="#{navAction.navi}" 
							         reRender="panelTab, tab4">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab4"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab4" viewId="../../pages/mm/semmmm001tab4.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.construct.address']}" id="tab5" onlabelclick="setTabNo5();">
									<a4j:jsFunction name="setTabNo5" action="#{navAction.navi}" 
							         reRender="panelTab, tab5">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab5"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab5" viewId="../../pages/mm/semmmm001tab5.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.withholder.address']}" id="tab6" onlabelclick="setTabNo6();">
									<a4j:jsFunction name="setTabNo6" action="#{navAction.navi}" 
							         reRender="panelTab, tab6">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tab6"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab6" viewId="../../pages/mm/semmmm001tab6.jsp" />
								</rich:tab>
							</rich:tabPanel>
						</h:panelGrid>
					</h:panelGroup>
					
					<!-- add contract + contract list //2017/07/25 >> -->
					<rich:panel id="pnlExpenseContractOfVendor" rendered="true" >
						<f:facet name="header"><h:outputText value="#{jspMsg['header.expense.of.vendor.info']}"/></f:facet>
						
						<!-- added content -->
						<h:panelGrid width="98%"  border="0" cellpadding="0" cellspacing="0">
							<rich:panel id="pnlExpense" rendered="true">
								<f:facet name="header"><h:outputText value="#{jspMsg['header.expense.detail']}"/></f:facet>
								<h:panelGroup>
									<table width="95%">
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.contract.number']}"/>
											</td>
											<td style="width:30%;" height="20" class="ms7">
							                	<h:inputText id="expenseContractNo" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" 
							                	style="width:150px;" onblur="callFillinExpenseInfoJS();"
							                	disabled="#{semmmm001Bean.validatePage.contractNo == 'N'}"/>
							                	
							                	<a4j:jsFunction name="callFillinExpenseInfoJS" action="#{semmmm001Action.doFillinContractInfo}" 
												reRender="expenseEffectiveDt, expenseExpireDt, expenseExpenseType, btnSaveVendorDetail, 
												rdoExpensePayType, vendorInfoCompany, vendorInfoCmpCompany, btnChngeVendor, btnPayee, btnCancelVendorDetail,
												mmm001tab0_contactName,vendorInfOtherExpenseFlag, groupNewPayeeButton" >
												</a4j:jsFunction>
							                	
							                	<a4j:commandButton id="btnSelectContract" value="..." styleClass="rich-button" 
													style="margin-left:5px; height:22px; vertical-align:top;" 
				           	 						oncomplete="#{rich:component('popupSearchSiteContract')}.show(); return false;"
													action="#{semmmm001Action.initPopupSiteContract}" reRender="pnlExpense, popupSearchSiteContract"
													disabled="#{semmmm001Bean.validatePage.contractNo == 'N'}">
													<a4j:actionparam name="vendorContractFlag" value="N"></a4j:actionparam> 
												</a4j:commandButton>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" rendered="false"/>
												<h:outputText value="Effective Date : " rendered="false"/>
											</td>
											<td style="width:30%;">
												<rich:calendar id="expenseExpenseEffectiveDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmmm001Bean.expCntrctOfVndObj.expenseEffectiveDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="return dateformat.submitFomatDate(this);"
											   	   label=""
											   	   disabled="#{semmmm001Bean.disablePaymentVendorCont}"
											   	   styleClass="ms7"
											   	   rendered="false">
												</rich:calendar>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.effective.date']}"/>
											</td>
											<td style="width:30%;" height="20" class="ms7">
							                	<rich:calendar id="expenseEffectiveDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmmm001Bean.expCntrctOfVndObj.contractEffectiveDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="return dateformat.submitFomatDate(this);"
											   	   label=""
											   	   disabled="true"
											   	   styleClass="ms7">
											</rich:calendar>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.expire.date']}"/>
											</td>
											<td style="width:30%;">
												<rich:calendar id="expenseExpireDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmmm001Bean.expCntrctOfVndObj.contractExpireDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="return dateformat.submitFomatDate(this);"
											   	   label=""
											   	   disabled="true"
											   	   styleClass="ms7">
											</rich:calendar>
											</td>
										</tr>
										<tr>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.expense.type']}"/>
											</td>
											<td style="width:30%;" height="20" class="ms7">
							                	<h:selectOneMenu id="expenseExpenseType" value="#{semmmm001Bean.expCntrctOfVndObj.expenseType}" 
												 style="width:150px;" 
												 disabled="#{semmmm001Bean.validatePage.expenseType == 'N'}">
				                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
				                				</h:selectOneMenu>
											</td>
											<td style="width:20%; text-align:right;" class="ms7">
												<h:outputText value="#{jspMsg['label.pay.type']}"/>
											</td>
											<td style="width:30%;">
							                	<h:selectOneRadio id="rdoExpensePayType" label="#{jspMsg['desc.pay.type.check']}"
												value="#{semmmm001Bean.expCntrctOfVndObj.payType}" styleClass="ms7" 
												disabled="#{semmmm001Bean.validatePage.payType == 'N'}">
													<f:selectItem itemValue="01" itemLabel="#{jspMsg['desc.pay.type.check']}" 
														itemDisabled="#{semmmm001Bean.expCntrctOfVndObj.chkWithoutContract}" />
													<f:selectItem itemValue="02" itemLabel="#{jspMsg['desc.pay.type.transfer']}" 
														itemDisabled="#{semmmm001Bean.expCntrctOfVndObj.chkWithoutContract}" />
												</h:selectOneRadio>
											</td>
										</tr>
									</table>
									
								</h:panelGroup>
							</rich:panel>
						</h:panelGrid>
						<!-- // add contract -->
						
						<!-- button vedor detail -->
						<h:panelGrid id="groupVendorDetailButton" width="100%">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:100%;">
										
											<a4j:commandButton id="btnSaveVendorDetail" reRender="oppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
							           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
											value="#{jspMsg['btn.save']}" styleClass="rich-button"
											disabled="#{semmmm001Bean.validatePage.saveButton == 'N'}" 
											rendered="#{semmmm001Bean.validatePage.saveButton != 'H'}" 
											action="#{semmmm001Action.doValidateVendorSaveDraft}"
											oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;">	
											
											</a4j:commandButton>
											
											<rich:spacer width="5" rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"/>
											<%-- 2017/08/10 .. callback function request >> --%>
											
											<a4j:commandButton id="btnCancelVendorDetail" reRender="txtNavProgram, oppContent"
											value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
											disabled="#{semmmm001Bean.validatePage.cancelButton == 'N'}"
											rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"
											action="#{navAction.navi}" >
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
												<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
												<a4j:actionparam name="mode" value="Edit" />
												<a4j:actionparam name="headType" value="Vendor" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorId}" />
												
												<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseEffectiveDtStrParam}" />
												<a4j:actionparam name="effectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.effectiveDtStrParam}" />
												<a4j:actionparam name="expireDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expireDtStrParam}" />
												<a4j:actionparam name="expenseTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseTypeIdParam}" />
												<a4j:actionparam name="payTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payTypeIdParam}" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdParam}" />
												<a4j:actionparam name="cancelFlag" value="Y" />
												<a4j:actionparam name="actionId" value="CANCEL_VENDOR" />
											</a4j:commandButton>
											
											<rich:spacer width="5"/>
											
											<a4j:commandButton id="btnBackCancelVendorDetail" reRender="txtNavProgram, oppContent"
											title="BC"
											value="#{jspMsg['btn.back']}" styleClass="rich-button"
											disabled="#{semmmm001Bean.validatePage.cancelButton == 'N'}"
											rendered="#{semmmm001Bean.validatePage.cancelButton != 'H'}"
											action="#{semmmm001Action.doInitValidateBack}"
											oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
												<a4j:actionparam name="methodWithNavi" value="doViewVendorByVendorId" />
												<a4j:actionparam name="mode" value="Edit" />
												<a4j:actionparam name="headType" value="Vendor" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorId}" />
																
												<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseEffectiveDtStrParam}" />
												<a4j:actionparam name="effectiveDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.effectiveDtStrParam}" />
												<a4j:actionparam name="expireDtStrParam" value="#{semmmm001Bean.semmmm001ReqParam.expireDtStrParam}" />
												<a4j:actionparam name="expenseTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.expenseTypeIdParam}" />
												<a4j:actionparam name="payTypeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payTypeIdParam}" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdParam}" />
												<a4j:actionparam name="cancelFlag" value="Y" />
												<a4j:actionparam name="actionId" value="CANCEL_VENDOR" />
												<a4j:actionparam name="moduleType" value="VD" />
											</a4j:commandButton>
											
											
											<a4j:commandButton id="btnBackInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B1"
							           	 	action="#{semmmm001Action.doInitValidateBack}"
							           	 	reRender="txtNavProgram, oppContent, mmm001PopUpCommon_controllerBtnBack" 
							           	 	rendered="#{semmmm001Bean.renderedBtnTodoBack == false and semmmm001Bean.validatePage.cancelButton == 'H'}"
							           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
												
												
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="moduleType" value="VD" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B2"
							           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" 
							           	 	rendered="false"
							           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-1" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="moduleType" value="VD" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackTodoInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B3"
											action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent"
											rendered="#{semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.validatePage.cancelButton == 'H'}"
											oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
												
												<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
												<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
												<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
												<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
												<a4j:actionparam name="moduleType" value="VD" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackTodo" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B4"
											action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" 
											rendered="false"
											oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVD();">
												<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
												<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
												<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
												<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
												<a4j:actionparam name="moduleType" value="VD" />
											</a4j:commandButton>
											
											<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnTodoBack}"/>
											
											
											<rich:spacer width="5"/>
											<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" 
											infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}" >
											</rich:messages>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- button vedor detail -->
					
						<!-- // contact list >> -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="0" >
							<rich:panel id="pnlContractList" styleClass="sem_autoScrollbarInMM" >
		                        <f:facet name="header">
		                            <h:outputText value="#{jspMsg['header.contract.of.vendor.list']}" style="width: 3200"/>
		                        </f:facet>
		                        
		                        <rich:dataTable id="dtbContractList" width="100%" 
										cellpadding="0" cellspacing="0" border="0" 
										value="#{semmmm001Bean.contractList}" var="contractObj"
										reRender="dtbContractList" rows="#{semmmm001Bean.rowPerPage}"
										rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
										
											<rich:column  rendered="#{semmmm001Bean.validatePage.expenseType != 'N'}" >
												<f:facet name="header">
													<h:outputText value="Select" styleClass="ms7" />
												</f:facet>
												
												<div align="center" >
													<a4j:commandLink id="contractEditRow" value="Select" 
													rendered="#{contractObj.dataObj.expenseSelectFlag eq 'Y'}" 
													action="#{navAction.navi}" reRender="dtbContractList, txtNavProgram, oppContent">
														<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
														<a4j:actionparam name="methodWithNavi" value="doSelectContractOfExpense" />
														
														<a4j:actionparam name="contractNoParam" value="#{contractObj.dataObj.contractNo}" />
														<a4j:actionparam name="expenseEffectiveDtStrParam" value="#{contractObj.dataObj.vendorEffectiveDtStr}" />
														<a4j:actionparam name="effectiveDtStrParam" value="#{contractObj.dataObj.effectiveDtStr}" />
														<a4j:actionparam name="expireDtStrParam" value="#{contractObj.dataObj.expireDtStr}" />
														<a4j:actionparam name="expenseTypeIdParam" value="#{contractObj.dataObj.expenseTypeId}" />
														<a4j:actionparam name="payTypeIdParam" value="#{contractObj.dataObj.payTypeId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{contractObj.dataObj.vendorMapPayeeId}" />
													</a4j:commandLink>
												</div>
											</rich:column>
											
											<rich:column style="width:40px;" rendered="#{semmmm001Bean.validatePage.expenseType != 'N'}">
												<f:facet name="header">
													<h:outputText value="Delete" styleClass="ms7"/>
												</f:facet>
												
												<div align="center" style="">
													<a4j:commandButton id="contractDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
													rendered="#{contractObj.dataObj.expenseDeleteFlag eq 'Y'}"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
									           	 	action="#{navAction.navi}" reRender="dtbContractList, txtNavProgram, oppContent, mmm001_txtForContract"
									           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
														<a4j:actionparam name="methodWithNavi" value="doDeleteVendorContract" />
									           	 		<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
									           	 		<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										           		<a4j:actionparam name="vendorMapPayeeIdParam" value="#{contractObj.dataObj.vendorMapPayeeId}" />
													</a4j:commandButton>
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractOldNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.contractOldNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.contract.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.contractStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.networkStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.network.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.networkStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.effectiveDt}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.expireDt}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.expire.date']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.expireDtStr}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.expenseType}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.expenseType}" styleClass="contentform" />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.vendorName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{contractObj.dataObj.vendorName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.vendorStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.vendorStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.accountNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.accountNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.bookbankStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.bookbankStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{contractObj.dataObj.payeeName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.payeeStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeAccountNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.bookbankPayeeStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{contractObj.dataObj.payType}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.pay.type']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.payType}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column sortBy="#{contractObj.dataObj.vendorEffectiveDt}" rendered="false">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.effectivedt']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{contractObj.dataObj.vendorEffectiveDtStr}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<!-- footer -->
											<f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													<rich:column colspan="4">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmmm001Bean.contractList)}"></f:param>
														</h:outputFormat>
													</rich:column>
													<!-- > 2 -->
													<rich:column colspan="15">
														<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractList"
															maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrllContractList" style="background-color: #cccccc;"
															page="#{semmmm001Bean.scrollerPage}">
														<a4j:support event="onclick" reRender="dtbContractList"></a4j:support>
														</rich:datascroller>
													</rich:column>
												</rich:columnGroup>
											</f:facet>
											<!-- footer -->
											
										</rich:dataTable>
		                   	</rich:panel>
						
						</h:panelGrid>
					</rich:panel>
					<!-- add contract + contract list //2017/07/25 -->
					
				</h:panelGrid>
				<!-- group[2] << -->
				
				<rich:spacer />
				
				<!-- group[3] >> -->
				<h:panelGrid id="bankInfo" width="100%" style="border:solid 1px gray;" 
				rendered="#{semmmm001Bean.visiblePnlBankListInfo or semmmm001Bean.visiblePnlBookbankPayeeListInfo}">
					<!-- bank info panel >> -->
					<rich:panel styleClass="" rendered="#{semmmm001Bean.visiblePnlBankListInfo}" style="width:100%">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.of.vendor.list']}" style="width:100%;"/></f:facet>
						
						<!-- button new bookbank -->
						<h:panelGrid columns="1" id="groupNewBookbankButton">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" 
							infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}" >
							</rich:messages>
						
							<a4j:commandButton id="btnNewBookbank" value="New Bookbank" styleClass="rich-button"
							disabled="#{semmmm001Bean.validatePage.newBookbank == 'N'}" 
							rendered="#{semmmm001Bean.validatePage.newBookbank != 'H'}"
							action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
							oncomplete="onTopPage();" >
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doNewBookbankFromVendorDetail" />
								<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
								<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
								<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
								<a4j:actionparam name="vendorBookbankIdParam" value="" />
								<a4j:actionparam name="btnActionType" value="N" />
							</a4j:commandButton>
						</h:panelGrid>
						
						<!-- bookbank active info panel << -->
						<h:panelGrid width="78%"  border="0" cellpadding="0" cellspacing="0" >
							<rich:panel id="pnlBookbankActiveVendorList" styleClass="sem_autoScrollbarInMM" >
		                        <f:facet name="header">
		                            <h:outputText value="#{jspMsg['header.bookbank.of.vendor.active']}" style="width: 3200"/>
		                        </f:facet>
		                        
		                        <rich:dataTable id="dtbBookbankActiveList" width="100%" 
									cellpadding="0" cellspacing="0" border="0" 
									value="#{semmmm001Bean.bookbankActiveList}" var="bookbankObj"
									reRender="dtbBookbankActiveList" rows="#{semmmm001Bean.rowPerPage}"
									rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
									
										<rich:column style="width:80px;" rendered="false">
											<f:facet name="header">
												<h:outputText value="Send To Manager" styleClass="ms7" rendered="false"/>
											</f:facet>
												
											<div align="center" style="width:40px;" title="Send Bookbank To Manager">
												
											
												<a4j:commandButton id="bookbankActiveSTMRow" image="images/pay.gif" style="width:15px; height : 16px;"
												disabled="false" rendered="#{bookbankObj.dataObj.sendManagerFlag eq 'Y'}"
												action="#{navAction.navi}" reRender="oppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
							           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_retStatus"
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
												oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 	<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
													<a4j:actionparam name="methodWithNavi" value="doSendToMNGByVendorBookbankId" />
													<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
													<a4j:actionparam name="vendorBookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
													<a4j:actionparam name="actionId" value="BOOKBANK_SEND_MNG" />
												</a4j:commandButton>
											</div>
										</rich:column>
										
										<rich:column style="width:40px;" rendered="false">
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="ms7" rendered="false"/>
											</f:facet>
											
											<div align="center" style="width:40px;" title="Delete">
												<a4j:commandButton id="bookbankActiveDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
												disabled="false" rendered="#{bookbankObj.dataObj.deleteFlag eq 'Y'}"
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
								           	 	action="#{navAction.navi}" reRender="dtbBookbankList,mmm001PopUpCommon_retStatus,oppContent"
								           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
								           	 		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
													<a4j:actionparam name="methodWithNavi" value="doDeleteBookbankMaster" />
								           	 		<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
									           		<a4j:actionparam name="vendorBookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
									           		<a4j:actionparam name="actionId" value="BOOKBANK_DELETE" />
												</a4j:commandButton>
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.accountName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:120px;">
												<h:outputText value="#{bookbankObj.dataObj.accountName}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.accountNo}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<a4j:commandLink id="hlkBookbankActiveAccountNo" value="#{bookbankObj.dataObj.accountNo}" 
												action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
												oncomplete="onTopPage();">
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
													<a4j:actionparam name="methodWithNavi" value="doViewBookbankFromVendor" />
													<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
													<a4j:actionparam name="vendorBookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
												</a4j:commandLink>
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.accountType}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.accountType}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bankCode}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bank.code']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.bankCode}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bankName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.bankName}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bankBranch}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:190px;">
												<h:outputText value="#{bookbankObj.dataObj.bankBranch}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.province}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:120px">
												<h:outputText value="#{bookbankObj.dataObj.province}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.remark}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.remark}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{bookbankObj.dataObj.bookbankFlowStatus}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.bookbankFlowStatus}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{bookbankObj.dataObj.updateDt}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.updatedt']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.updateDtStr}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{bookbankObj.dataObj.updateBy}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.updateBy}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{bookbankObj.dataObj.activeStatus}" rendered="false">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.active']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.activeStatus}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<!-- footer -->
										<f:facet name="footer">
											<rich:columnGroup>
												<!-- > 1 -->
												<rich:column colspan="4">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmmm001Bean.bookbankActiveList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<!-- > 2 -->
												<rich:column colspan="9">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBookbankActiveList"
														maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dataScrllBookbankActiveList" style="background-color: #cccccc;"
														page="#{semmmm001Bean.scrollerPage}">
													<a4j:support event="onclick" reRender="dtbBookbankActiveList"></a4j:support>
													</rich:datascroller>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
										<!-- footer -->
										
									</rich:dataTable>
		                    </rich:panel>
						</h:panelGrid>
						<!-- bookbank active info panel << -->
						
						<rich:spacer height="10"></rich:spacer>
						
						<!-- bookbank inactive info panel << -->
						<h:panelGrid width="78%"  border="0" cellpadding="0" cellspacing="0" >
							<rich:panel id="pnlBookbankInactiveVendorList" styleClass="sem_autoScrollbarInMM" >
		                        <f:facet name="header">
		                            <h:outputText value="#{jspMsg['header.bookbank.of.vendor.inactive']}" style="width: 3200"/>
		                        </f:facet>
		                        
		                        <rich:dataTable id="dtbBookbankInactiveList" width="100%" 
									cellpadding="0" cellspacing="0" border="0" 
									value="#{semmmm001Bean.bookbankInactiveList}" var="bookbankObj"
									reRender="dtbBookbankInactiveList" rows="#{semmmm001Bean.rowPerPage}"
									rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
										
										<rich:column rendered="false">
											<f:facet name="header">
												<h:outputText value="Send To Manager" styleClass="ms7" rendered="false"/>
											</f:facet>
												
											<div align="center" style="width:40px;" title="Send Bookbank To Manager">
												<a4j:commandButton id="bookbankInactiveSTMRow" image="images/pay.gif" style="width:15px; height : 15px;"
												disabled="false" rendered="#{bookbankObj.dataObj.sendManagerFlag eq 'Y'}"
												action="#{navAction.navi}" reRender="dtbPayeeList,oppContent"
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
												oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 	<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
													<a4j:actionparam name="methodWithNavi" value="doSendToMNGByVendorBookbankId" />
													<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
													<a4j:actionparam name="vendorBookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
													<a4j:actionparam name="actionId" value="BOOKBANK_SEND_MNG" />
												</a4j:commandButton>
											</div>
										</rich:column>
											
										<rich:column rendered="false">
											<f:facet name="header">
												<h:outputText value="Delete" styleClass="ms7" rendered="false"/>
											</f:facet>
											
											<div align="center" style="width:40px;" title="false">
												<a4j:commandButton id="bookbankInactiveDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
												disabled="false" rendered="#{bookbankObj.dataObj.deleteFlag eq 'Y'}"
												onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
								           	 	action="#{navAction.navi}" reRender="dtbBookbankInactiveList,mmm001PopUpCommon_retStatus"
								           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
								           	 		<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
													<a4j:actionparam name="methodWithNavi" value="doDeleteBookbankMaster" />
								           	 		<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
									           		<a4j:actionparam name="vendorBookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
									           		<a4j:actionparam name="actionId" value="BOOKBANK_DELETE" />
												</a4j:commandButton>
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.accountName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:120px;">
												<h:outputText value="#{bookbankObj.dataObj.accountName}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.accountNo}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<a4j:commandLink id="hlkBookbankInactiveAccountNo" value="#{bookbankObj.dataObj.accountNo}" 
												action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
												oncomplete="onTopPage();">
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
													<a4j:actionparam name="methodWithNavi" value="doViewBookbankFromVendor" />
													<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
													<a4j:actionparam name="vendorBookbankIdParam" value="#{bookbankObj.dataObj.vendorBookbankId}" />
												</a4j:commandLink>
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.accountType}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.accountType}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bankCode}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bank.code']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.bankCode}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bankName}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.bankName}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bankBranch}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:190px;">
												<h:outputText value="#{bookbankObj.dataObj.bankBranch}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.province}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:120px">
												<h:outputText value="#{bookbankObj.dataObj.province}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.remark}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="left" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.remark}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.bookbankFlowStatus}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.bookbank.status']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.bookbankFlowStatus}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{bookbankObj.dataObj.updateDt}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.updatedt']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.updateDtStr}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{bookbankObj.dataObj.updateBy}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{bookbankObj.dataObj.updateBy}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column style="" title="" sortBy="#{bookbankObj.dataObj.activeStatus}" rendered="false">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.active']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center">
												<h:outputText value="#{bookbankObj.dataObj.activeStatus}" styleClass="contentform"  />
											</div>
										</rich:column>
										
										<!-- footer -->
										<f:facet name="footer">
											<rich:columnGroup>
												<!-- > 1 -->
												<rich:column colspan="4">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmmm001Bean.bookbankInactiveList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<!-- > 2 -->
												<rich:column colspan="9">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBookbankInactiveList"
														maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
														stepControls="hide" fastControls="auto" boundaryControls="auto" 
														id="dataScrllBookbankInactiveList" style="background-color: #cccccc;"
														page="#{semmmm001Bean.scrollerPage}">
													<a4j:support event="onclick" reRender="dtbBookbankInactiveList"></a4j:support>
													</rich:datascroller>
												</rich:column>
											</rich:columnGroup>
										</f:facet>
										<!-- footer -->
										
									</rich:dataTable>
		                    </rich:panel>
						</h:panelGrid>
						<!-- bookbank inactive info panel << -->
						
					</rich:panel>
					
					<!-- bank info panel << -->
					
					<!-- group[3] << -->
					
					<rich:spacer  rendered="#{semmmm001Bean.visiblePnlBankListInfo}" />
					
						<!-- payee and bookbank payee list panel >> -->
						<rich:panel rendered="#{semmmm001Bean.visiblePnlBookbankPayeeListInfo}" style="60%">
							<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.of.vendor.list']}" style="width:70%;"/></f:facet>
							
							<!-- button new Payee -->
							<h:panelGrid id="groupNewPayeeButton" border="0">
								<h:panelGroup>
									<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgNewPayee}">
								 		<f:facet name="header">
				                        	<h:outputText value="Entered Data Status:"></h:outputText>
				                    	</f:facet>
							 			<f:facet name="errorMarker">
							 				 <h:graphicImage value="images/error.gif" />  
					                    </f:facet>
				                	</rich:messages>
								
									<a4j:commandButton id="btnPayee" value="New Payee" styleClass="rich-button"
									disabled="#{semmmm001Bean.validatePage.newPayee == 'N'}" 
									rendered="#{semmmm001Bean.validatePage.newPayee != 'H'}"
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doNewPayeeFromVendorDetail" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="" />
										<a4j:actionparam name="btnActionType" value="N" />
									</a4j:commandButton>
									
									<rich:spacer width="10"></rich:spacer>
									
									<h:outputText id="mmm001_txtForContract" value="For Contract : #{semmmm001Bean.expCntrctOfVndObj.contractNo}" styleClass="ms7"
									rendered="#{semmmm001Bean.expCntrctOfVndObj.contractNo != ''}"></h:outputText>
								</h:panelGroup>
								
							</h:panelGrid>
							
							<h:panelGrid border="0" cellpadding="0" cellspacing="0" style="width:70%;margin:0;padding:0;">
								
								<rich:panel id="pnlVendorPayeeList" styleClass="sem_autoScrollbarInMM" >
			                        <f:facet name="header">
			                        </f:facet>
			                        
			                        <rich:dataTable id="dtbPayeeList" width="90%" 
										cellpadding="0" cellspacing="0" border="0" 
										value="#{semmmm001Bean.payeeList}" var="payeeObj"
										reRender="dtbPayeeList" rows="#{semmmm001Bean.rowPerPage}"
										rowClasses="cur" styleClass="dataTabale" rowKeyVar="row">
										
											<rich:column rendered="false">
												<f:facet name="header">
													<h:outputText value="Send To Manager" styleClass="ms7" rendered="false"/>
												</f:facet>
												
												<div align="center" title="Send Payee To Manager">
													<a4j:commandButton id="payeeSTMRow" image="images/pay.gif" style="height:15px; width:15px;"
													disabled="false" rendered="#{payeeObj.dataObj.sendManagerFlag eq 'Y'}"
													action="#{navAction.navi}" reRender="dtbPayeeList,mmm001PopUpCommon_retStatus"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
													oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
														<a4j:actionparam name="methodWithNavi" value="doSendToMNGByPayeeId" />
															
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
	
										           		<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
										           		<a4j:actionparam name="actionId" value="PAYEE_SEND_MNG" />
													</a4j:commandButton>
												</div>
											</rich:column>
											
											<rich:column rendered="false">
												<f:facet name="header">
													<h:outputText value="Delete" styleClass="ms7" rendered="false"/>
												</f:facet>
												
												<div align="center" title="Delete">
													<a4j:commandButton id="payeeDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
													disabled="false" rendered="#{payeeObj.dataObj.deleteFlag eq 'Y'}"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
									           	 	action="#{navAction.navi}" reRender="dtbPayeeList,mmm001PopUpCommon_retStatus"
									           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
														<a4j:actionparam name="methodWithNavi" value="doDeletePayeeMaster" />
															
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										           		<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
										           		<a4j:actionparam name="actionId" value="PAYEE_DELETE" />
													</a4j:commandButton>
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeCode}">
												<f:facet name="header">
													<h:outputText value="Payee Code" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<a4j:commandLink id="hlkPayeeId" value="#{payeeObj.dataObj.payeeCode}" 
													action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
													oncomplete="onTopPage();">
														<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
														<a4j:actionparam name="methodWithNavi" value="doViewPayeeFromVendorDetail" />
															
														<a4j:actionparam name="contractNoParam" value="#{payeeObj.dataObj.contractNo}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{payeeObj.dataObj.vendorMapPayeeId}" />
														<a4j:actionparam name="vendorIdParam" value="#{payeeObj.dataObj.vendorId}" />
														<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
													</a4j:commandLink>
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{payeeObj.dataObj.payeeName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.contractNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center" style="">
													<h:outputText value="#{payeeObj.dataObj.contractNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.payeeStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.payee.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{payeeObj.dataObj.payeeStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.bankName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{payeeObj.dataObj.bankName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.accountNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<a4j:commandLink id="hlkPayeeAccountNo" value="#{payeeObj.dataObj.accountNo}" 
													action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
													oncomplete="onTopPage();">
														<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
														<a4j:actionparam name="methodWithNavi" value="doViewBBPayeeFromVendor" />
														<a4j:actionparam name="payeeIdParam" value="#{payeeObj.dataObj.payeeId}" />
														<a4j:actionparam name="bookbankPayeeIdParam" value="#{payeeObj.dataObj.bookbankPayeeId}" />
															
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.expCntrctOfVndObj.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
													</a4j:commandLink>
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.accountName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{payeeObj.dataObj.accountName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.bookbankPayeeStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bookbank.payee.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{payeeObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{payeeObj.dataObj.expenseType}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{payeeObj.dataObj.expenseType}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column sortBy="#{payeeObj.dataObj.updateDt}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.updatedt']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{payeeObj.dataObj.updateDtStr}" styleClass="contentform" />
											</div>
										</rich:column>
										
										<rich:column sortBy="#{payeeObj.dataObj.updateBy}">
											<f:facet name="header">
												<h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform"/>
											</f:facet>
											
											<div align="center" style="width:180px;">
												<h:outputText value="#{payeeObj.dataObj.updateBy}" styleClass="contentform" />
											</div>
										</rich:column>
											
											<!-- footer -->
											<f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													<rich:column colspan="4">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmmm001Bean.payeeList)}"></f:param>
														</h:outputFormat>
													</rich:column>
													<!-- > 2 -->
													<rich:column colspan="9">
														<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPayeeList"
															maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrllPayeeList" style="background-color: #cccccc;"
															page="#{semmmm001Bean.scrollerPage}">
														<a4j:support event="onclick" reRender="dtbPayeeList"></a4j:support>
														</rich:datascroller>
													</rich:column>
												</rich:columnGroup>
											</f:facet>
											<!-- footer -->
											
										</rich:dataTable>
			                    </rich:panel>
								
							</h:panelGrid>						
						</rich:panel>
						<!-- payee and bookbank payee list panel << -->
						
					</h:panelGrid>
					<!-- group[4] << -->
				
				
				
				
				<!-- group[4] >> -->
				
				
			</a4j:form>
		
		</h:panelGrid>
	</h:panelGrid>
		
		
	
		<!-- end panel tab -->
		<h:panelGrid  id="pnlLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
			<h:panelGroup rendered="true">
				<table width="100%">
					<tr>
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
						</td>
						<td width="30%">
							<h:inputText id="txtCreateBy" value="#{semmmm001Bean.vendorInfo.createBy}" 
							readonly="true" disabled="true" size="30" maxlength="50"/>
						</td>
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
						</td>
						<td width="30%">
							<rich:calendar id="cldCreateDate" locale="th" 
							datePattern="dd/MM/yyyy HH:mm:ss" 
							value="#{semmmm001Bean.vendorInfo.createDt}" 
							showWeeksBar="false"
							inputSize="20" 
							cellWidth="20px" cellHeight="20px" 
							buttonIcon="/images/hide-button.png"
							buttonIconDisabled="/images/hide-button.png"
							disabled="true"/>
						</td>
					</tr>
			                	 
					<tr>
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
						</td>
						<td width="30%">
							<h:inputText id="txtUpdateBy" value="#{semmmm001Bean.vendorInfo.updateBy}" 
							readonly="true" disabled="true" size="30" maxlength="50"/>
						</td>
						<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
						</td>
						<td width="30%">
							<rich:calendar id="cldUpdateDate" locale="th" 
							datePattern="dd/MM/yyyy HH:mm:ss" 
							value="#{semmmm001Bean.vendorInfo.updateDt}" 
							showWeeksBar="false"
							inputSize="20" 
							cellWidth="20px" cellHeight="20px" 
							buttonIcon="/images/hide-button.png"
							buttonIconDisabled="/images/hide-button.png"
							disabled="true"/>
						</td>
					</tr>
				</table>
			</h:panelGroup>
		</h:panelGrid>
	</rich:panel>
	
	<a4j:form id="frmShowReportExcelVendorDetail_">
							
					<h:panelGrid id="pnlShowReportVendorExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportVendorExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportVendorExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportVendorToLeader}" />								
							<script>document.getElementById('incContent:frmShowReportExcelVendorDetail_:bthShowReportVendorExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
					
		
	</a4j:form>
</h:panelGrid>
<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>