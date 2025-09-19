<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.master.name']}"/></f:facet>	
	
		<!-- response message panel -->
		<h:panelGrid>
			<a4j:form id="frmError">
					 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
		
		<a4j:form id="frmPayeeInfo">
			<h:panelGrid id="pnlPayeeConfirm" width="95%" style="border:solid 1px gray;" 
			rendered="#{semmmm001Bean.payeeInfo.confirmTxt != null}">
			
				
				<h:panelGrid id="groupPayeeConfirm" width="100%">
					<h:outputText value="#{semmmm001Bean.payeeInfo.confirmTxt}" styleClass="ms7red"></h:outputText>
					
					<a4j:commandButton id="btnViewPayeeConfirm" value="View Change Of Data" styleClass="rich-button" 
						action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
						oncomplete="#{rich:component('mmm001PopUpCommon_confirmDetail')}.show(); return false;" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="doViewPayeeConfirm" />
							
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						</a4j:commandButton>
						
						
				</h:panelGrid>
			</h:panelGrid>
		
			<table width="98%">
				<tr>
					<td width="100%" align="right">
						<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.contractInfo.siteInfoId == null}"
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfo.siteInfoId}" />
										</a4j:commandButton>
						
						<rich:spacer width="5"></rich:spacer>
						
						
						<a4j:commandButton id="btnSavePayeeInfoTop" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
							panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
							value="#{jspMsg['btn.save']}" styleClass="rich-button"
							disabled="#{semmmm001Bean.disableBtnSavePayee}" 
							action="#{semmmm001Action.doValidatePayeeSaveDraft}"
							oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;" style=" width : 53px;">	
												
						</a4j:commandButton>
						
						<rich:spacer width="5"/>
										
						<%-- 2017/08/10 .. callback function request >> --%>
											
						<a4j:commandButton id="btnCancelPayeeDetail_top" reRender="txtNavProgram, oppContent"
						value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
						disabled="#{semmmm001Bean.disableBtnSavePayee or semmmm001Bean.payeeInfo.saveFlag eq 'N'}" action="#{navAction.navi}" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
							<a4j:actionparam name="methodWithNavi" value="doViewPayeeByPayeeId" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPY}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPY}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPY}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPY}" />
							<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
						</a4j:commandButton>
											
						<rich:spacer width="5"/>
											
						<a4j:commandButton id="btnCancelPayeeDetailBack_top" reRender="txtNavProgram, oppContent"
						value="#{jspMsg['btn.back']}" styleClass="rich-button" title="BC"
						rendered="#{semmmm001Bean.disableBtnSavePayee == false and semmmm001Bean.payeeInfo.saveFlag != 'N'}"
						disabled="#{semmmm001Bean.disableBtnSavePayee}" action="#{semmmm001Action.doInitValidateBack}" 
						style=" width : 52px;"
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
							<a4j:actionparam name="methodWithNavi" value="doViewPayeeByPayeeId" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPY}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPY}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPY}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPY}" />
							<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBack_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B1"
		           	 	rendered="#{semmmm001Bean.fromVendorFlag 
		           	 	and (semmmm001Bean.disableBtnSavePayee or semmmm001Bean.payeeInfo.saveFlag eq 'N')}"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTodo_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B2"
						rendered="#{(semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.fromVendorFlag == false)
						and (semmmm001Bean.disableBtnSavePayee or semmmm001Bean.payeeInfo.saveFlag eq 'N')}"
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
							<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
							<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
							<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackOth_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B3"
		           	 	rendered="false"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'false'})changePagePY();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B4"
		           	 	rendered="false"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
		           	 		
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTodoInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B5" 
						rendered="false"
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
							
							<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
							<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
							<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackOthInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B6"
		           	 	rendered="false"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'false'})changePagePY();">
							
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:commandButton>
						
						<a4j:jsFunction name="changePagePY" action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
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
							<a4j:actionparam name="moduleType" value="PY" />
						</a4j:jsFunction>
											
					</td>
				</tr>
			</table>
			
			<rich:spacer />
		
			<!-- group[1] >> -->
			<h:panelGrid id="pnlContractInfo" width="98%" style="border:solid 1px gray;">
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.info']}"/></f:facet>
					
					<!-- contract info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
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
										rendered="false">
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
					
				</rich:panel>
				
				<rich:panel id="vendorInfo">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.vendor.info']}"/></f:facet>
				
					<!-- vendor info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td>
										<h:outputText value="#{semmmm001Bean.vendorInfo.vendorInfoTxt1}" styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td>
										<h:outputText value="#{semmmm001Bean.vendorInfo.vendorInfoTxt2}" styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td>
										<h:outputText value="#{semmmm001Bean.vendorInfo.vendorInfoTxt3}" styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td>
										<h:outputText value="#{semmmm001Bean.vendorInfo.vendorInfoTxt4}" styleClass="ms7"></h:outputText>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1" rendered="false">
						<h:panelGroup>
							<table width="95%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.info.from.sap']}" rendered="false"/>
									</td>
									<td style="width:30%;">
										<a4j:commandButton id="btnCopyInfoFromSAP" value="Copy Vendor's Info from SAP" styleClass="rich-button"
										 action="#{semmmm001Action.doCopyVendorInfoFromSAP}" reRender="vendorInfo, panelTab0" rendered="false"
										 disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent) or semmmm001Bean.vendorInfo.vendorId == null}">
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.saprole']}" styleClass="ms7"/>
									</td>
									<td style="width:30%;">
										<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.role}" styleClass="ms7"></h:outputText>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.company']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoCompany" value="#{semmmm001Bean.vendorInfo.company}" style="width:100px;"
										disabled="true" >
		                					<f:selectItems value="#{semmmm001Bean.companyList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoVendorType" value="#{semmmm001Bean.vendorInfo.vendorType}" 
										disabled="true"  
										>
		                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
		                				</h:selectOneMenu>
		                				
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorType}" 
										rendered="false"
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
										rendered="false"
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
		                				disabled="true" style="width:70%;" />
		                				
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName1}" 
										rendered="false"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName2" value="#{semmmm001Bean.vendorInfo.vendorName2}" 
										disabled="true" style="width:70%;" />
										
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName2}" 
										rendered="false"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName3" value="#{semmmm001Bean.vendorInfo.vendorName3}" 
										disabled="true" style="width:70%;"/>
										
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName3}" 
										rendered="false"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName4" value="#{semmmm001Bean.vendorInfo.vendorName4}" 
										disabled="true" style="width:70%;" />
										
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.vendorName4}" 
										rendered="false"
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
										disabled="true" 
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
										onblur="if(this.value.length > 0 && this.value.length != 13) {
													alert('Personal Card ID required 13 digit.'); this.focus(); }"
										style="width:70%;" maxlength="13" />
										
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.idCard}" 
										rendered="false"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoTaxId" value="#{semmmm001Bean.vendorInfo.taxId}" 
										disabled="true" 
										onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
										onblur="if(this.value.length > 0 && this.value.length != 13) {
													alert('Personal Tax ID required 13 digit.'); this.focus(); }" 
										style="width:70%;" maxlength="13"  />
										
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.taxId}" 
										rendered="false"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%;" class="">
										<h:outputText value=""/>
									</td>
									<td style="width:30%;">
										<h:outputText value="#{jspMsg['btn.check.vendor.info']}" style="color:red;" styleClass="ms7" rendered="false"/>
										<a4j:commandButton id="btnChkVendor" value="..." styleClass="rich-button" 
										disabled="true" 
										rendered="false"
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
										disabled="true" 
										style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
		                				</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
		                				<h:inputText id="vendorInfoBranchNo" value="#{semmmm001Bean.vendorInfo.branchNo}" 
										disabled="true"  
										onkeypress="return numberformat.keyPressDecimalOnly('vendorInfoBranchNo', event);" 
										maxlength="5" style="width:50px;" />
										
		                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.branchNo}" 
										rendered="false"
										style="color:red; padding-left:188px; display:block;" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" rendered="false"/>
										<h:outputText value="Withhold :" rendered="false"/>
									</td>
									<td style="width:30%;">
		                				<a4j:region>
											<h:selectOneMenu id="vendorInfoWhtId" value="#{semmmm001Bean.vendorInfo.whtId}" 
											disabled="true" 
											rendered="false"
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
									<td style="width:30%;" colspan="4">
										
										<table>
											<tr>
												<td>
													<h:selectBooleanCheckbox id="chkVAT" 
														value="#{semmmm001Bean.vendorInfo.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" 
														disabled="true"/>
								                		<h:outputText value="#{jspMsg['label.vendor.vat.registration']}" styleClass="ms7" style="padding-left:2px;" />
								                		
						                				<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.includeVAT}" 
														rendered="false"
														style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
												</td>
												<td>
													<h:selectBooleanCheckbox id="vendorInfoVendorBlockStatus" 
													value="#{semmmm001Bean.vendorBlockStatus}" style="vertical-align:bottom; margin-left:-3px;" 
													disabled="true"/>
							                		
							                		<h:outputText value="Block" styleClass="ms7" style="padding-left:2px;" />
							                		<rich:spacer width="5"></rich:spacer>
												</td>
												<td>
													<h:selectBooleanCheckbox id="vendorInfoNotPayeeFlag" 
													value="#{semmmm001Bean.notPayeeFlag}" style="vertical-align:bottom; margin-left:-3px;" 
													disabled="true"/>
							                		<h:outputText value="#{jspMsg['label.vendor.notpayee']}" styleClass="ms7" style="padding-left:2px;" />
													<rich:spacer width="5"></rich:spacer>
												</td>
												<td>
													<h:selectBooleanCheckbox id="vendorInfOtherExpenseFlag" 
													value="#{semmmm001Bean.otherExpenseFlag}" style="vertical-align:bottom; margin-left:-3px;" 
													disabled="true"/>
							                		<h:outputText value="#{jspMsg['label.vendor.vendornocontract']}" styleClass="ms7" style="padding-left:2px;" />
													<rich:spacer width="5"></rich:spacer>
												</td>
												<td>
													<h:selectBooleanCheckbox id="vendorInfoBlackListStatus" 
													value="#{semmmm001Bean.vendorBlackListStatus}" style="vertical-align:bottom; margin-left:-3px;" 
													disabled="true"/>
							                		<h:outputText value="Black List" styleClass="ms7" style="padding-left:2px;" />
													<rich:spacer width="5"></rich:spacer>
													
												</td>
												<td>
													<h:selectBooleanCheckbox id="mmm001tab0_chkLocalDepartment" 
													value="#{semmmm001Bean.vendorAddrObj.chkLocalDepartment}"
													disabled="true"
													onclick="" style="margin:0px 5px 0px 0px;" />
													<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
												</td>
												
										
											</tr>
											
											<tr>
												<td>
													<h:selectBooleanCheckbox id="vendorInfoVendorBlockStatusSAP" 
													value="#{semmmm001Bean.vendorBlockStatusSAP}" style="vertical-align:bottom; margin-left:-3px;" 
													rendered="false" disabled="true"/>
							                		
							                		<h:outputText value="Block" styleClass="ms7" style="color:red; padding-left:4px; " rendered="false"/>
							                		<rich:spacer width="5" rendered="false"></rich:spacer>
												
												</td>
												<td>
													<h:selectBooleanCheckbox id="vendorInfoNotPayeeFlagSAP" 
													value="#{semmmm001Bean.notPayeeFlag}" style="vertical-align:bottom; margin-left:-3px;" 
													rendered="false" disabled="true"/>
							                		<h:outputText value="#{jspMsg['label.vendor.notpayee']}" style="color:red; padding-left:4px; " rendered="false"/>
													
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
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="contentform"
										style="vertical-align:top;"/>
									</td>
									<td style="width:30%;" rowspan="2"  class="ms7" >
										<h:inputTextarea id="vendorInfoRemark" 
										value="#{semmmm001Bean.vendorInfo.vendorRemark}"
										disabled="true"
										style="width:500px; height:70px; font-size:13px; font-family: Arial, Verdana, sans-serif;">
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
										<h:outputText value="#{semmmm001Bean.vendorInfo.vendorBatch}"
										style="vertical-align:top;"/>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
			
				<!-- contact list panel >> -->
				<rich:panel id="pnlPayeecontact" styleClass="sem_autoScrollbarInMM" >
					<f:facet name="header">
		            	<h:outputText value="#{jspMsg['header.contract.of.vendor.list']}" style="width: 3200"/>
		            </f:facet>
		            
		            <rich:dataTable id="dtbContractList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractList}" var="contractObj"
						reRender="dtbContractList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.expenseType}" styleClass="contentform"  />
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.vendorFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.status']} #{jspMsg['column.header.vendor.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
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
									<h:outputText value="#{jspMsg['column.header.status']} #{jspMsg['column.header.bookbank.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.status']} #{jspMsg['column.header.payee.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.accountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.vendorEffectiveDt}" rendered="false">
								<f:facet name="header">
									<h:outputText value="Effective Date" styleClass="contentform"/>
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
									<rich:column colspan="11">
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
				
				<!-- contract of vendor list panel << -->
			</h:panelGrid>
			<!-- group[2] << -->
			
			<rich:spacer />
			
			<!-- group[3] >> -->
			<%--rich:panel id="pnlPayeeInfo" rendered="true"--%>
			
				<h:panelGrid id="payeeInfo" width="98%" style="border:solid 1px gray;">
				
					<!-- button payeeInfo -->
					<h:panelGrid id="groupPayeeInfoButton" width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:70%;">
										<a4j:commandButton id="btnNewPayeeCntrct" value="New Payee" styleClass="rich-button"
										action="#{navAction.navi}" reRender="oppContent, txtNavProgram"
										rendered="#{semmmm001Bean.renderedBtnNewPYDetail}"
										disabled="#{semmmm001Bean.disableBtnNewPYDetail}"
										style="padding-left: 5px; width:69px;">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doNewPayeeByContract" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="changeType" value="N" />
											<a4j:actionparam name="btnActionType" value="C" />
										</a4j:commandButton>
										
										<rich:spacer width="5"/>
										
										<a4j:commandButton id="btnSelPayeeContract" value="Select Payee" styleClass="rich-button"
										oncomplete="#{rich:component('mmm001PopUpCommon_changePayee')}.show(); return false;"
										action="#{semmmm001Action.initChangePayee}" reRender="mmm001PopUpCommon_changePayee"
										rendered="#{semmmm001Bean.renderedBtnSelectPY}"
										disabled="#{semmmm001Bean.disableBtnSelectPY}"
										style="padding-left: 2px; width:71px;">
										</a4j:commandButton>
										
										<rich:spacer width="5"/>
									
										<a4j:commandButton id="btnNewPayee" value="New Payee" styleClass="rich-button"
										action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnNewAllPY}"
										rendered="#{semmmm001Bean.renderedBtnNewAllPY}" 
										reRender="txtNavProgram, oppContent" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doNewPayee" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="" />
											<a4j:actionparam name="btnActionType" value="N" />
										</a4j:commandButton>
										
										<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNewAllPY}" />
										
										<a4j:commandButton id="btnEdtPayeeData" value="Edit Data" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnEditDataPayee}"
						           	 	rendered="#{semmmm001Bean.renderedBtnEditDataPayee}" 
						           	 	reRender="oppContent">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doEditPayeeData" />
											<a4j:actionparam name="btnActionType" value="ED" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnEditDataPayee}"/>
										
										<a4j:commandButton id="btnEdtPayee" value="Edit Payee" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnEditPayee}"
						           	 	rendered="#{semmmm001Bean.renderedBtnEditPayee}" 
						           	 	reRender="oppContent">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doEditPayeeByPayeeId" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="btnActionType" value="E" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"/>
						           		<a4j:commandButton id="btnChngePayee" value="Change Payee" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnChangePY}" 
						           	 	rendered="#{semmmm001Bean.renderedBtnChangePY}"
						           	 	reRender="oppContent">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doChangePayee" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="btnActionType" value="C" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"/>
						           		<a4j:commandButton id="btnSndToMng" value="Send To Manager" 
						           	 	disabled="#{semmmm001Bean.disableBtnSendManagerPY}"
						           	 	rendered="#{semmmm001Bean.renderedBtnSendManagerPY}"
						           	 	action="#{navAction.navi}" styleClass="rich-button"  
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
						           	 	reRender="dtbContractList, txtNavProgram, oppContent" 
										oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doSendToMNGByPayeeId" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"/>
						           		
						           		<a4j:commandButton id="btnExpBtchVD" value="Export Batch" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableExportBatchPY}" 
						           	 	rendered="#{semmmm001Bean.renderedExportBatchPY}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="frmPayeeInfo, pnlShowReportPayeeToLeaderExcel"
						           	 	style="padding-left: 5px; width:85px;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_PY" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"/>
						           		
						           		<a4j:commandButton id="btnClearBatch" value="#{jspMsg['btn.clearBatch']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableClearBatchPY}" 
						           	 	rendered="#{semmmm001Bean.renderedClearBatchPY}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CLEAR_BATCH" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.vendorInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="payeeId" value="#{semmmm001Bean.payeeInfo.payeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="false" />
						           		
						           		<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']} #{jspMsg['btn.payee']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableCancelPY}" 
						           	 	rendered="false"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CANCEL" />
											<a4j:actionparam name="payeeId" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.vendorInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.disableCancel}"/>
					           		
					           		<a4j:commandButton id="btnConfirm" value="#{jspMsg['btn.confirm']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}"
					           	 	rendered="#{semmmm001Bean.renderedConfirmPY}"
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
					           	 	reRender="oppContent, frmResultSearch, dtbResultList"
					           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
										<a4j:actionparam name="btnEvent" value="CONFIRM" />
										<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.vendorInfo.payeeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="typeFlag" value="P" />
					           		</a4j:commandButton>
						           	</td>
						           	<td style="width:30%; text-align:right;">
						           		<a4j:commandButton id="btnDltePayee" value="Delete Payee" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableDeletePY}"
						           	 	rendered="#{semmmm001Bean.renderedDeletePY}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
						           	 	reRender="dtbContractList, txtNavProgram, oppContent" 
										oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
						           			<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doDeletePayeeMaster" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						           		</a4j:commandButton>
						           	</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				
					<!-- payee info panel >> -->
					<rich:panel id="payeeDetail">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.info']}"/></f:facet>
						
						<!-- payee info -->
						<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.expense.type']}" rendered="false"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="payeeExpenseType" value="#{semmmm001Bean.payeeInfo.expenseType}" 
											 style="width:150px;"  rendered="false"
											 disabled="true">
			                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
			                				</h:selectOneMenu>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="Effective Date : " rendered="false" />
										</td>
										<td style="width:30%;">
											<rich:calendar id="payeeExpenseEffectiveDt" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmmm001Bean.payeeInfo.expenseEffectiveDt}"
											   showWeeksBar="false"
											   inputSize="10"
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	   cellWidth="15px" cellHeight="20px"
										   	   oninputblur="return dateformat.submitFomatDate(this);"
										   	   label=""
										   	   disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
										   	   styleClass="ms7" rendered="false">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="Payee Code : "/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInPayeeCode" value="#{semmmm001Bean.payeeInfo.payeeCode}" 
											disabled="true" maxlength="50" style="width:70%;" styleClass="" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="Payee Type : "/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="payeeInfoPayeeType" value="#{semmmm001Bean.payeeInfo.payeeType}" 
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" >
			                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.payee.name']}"/>
										</td>
										<td colspan="3">
											<h:inputText id="payeeInfoPayeeName" value="#{semmmm001Bean.payeeInfo.payeeName}" 
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
											maxlength="250" style="width:70%;" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoIdCard" value="#{semmmm001Bean.payeeInfo.idCard}" 
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
											maxlength="13" style="width:70%;" styleClass="" />
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
										</td>
										<td style="width:30%;">
											<h:inputText id="payeeInfoTaxId" value="#{semmmm001Bean.payeeInfo.taxId}" 
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
											maxlength="13" style="width:70%;" styleClass="" />
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value=""/>
										</td>
										<td colspan="3">
											<a4j:commandButton id="btnChkPayee" value="Check Payee" styleClass="rich-button"
											process="payeeDetail"
											action="#{semmmm001Action.doSearchPayee}" reRender="oppContent"
											oncomplete="#{rich:component('mmm001PopUpCommon_searchPayee')}.show();"
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" >
											</a4j:commandButton>
											
											<div style="clear:both; height:5px;"></div>
											
											
										</td>
									</tr>
									
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.remark']}"/>
										</td>
										<td style="width:30%;">
											<h:inputTextarea id="payeeInfoRemark" value="#{semmmm001Bean.payeeInfo.remark}" 
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
											style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="* " style="font-style:bold; color:red;" />
											<h:outputText value="#{jspMsg['label.payee.status']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="payeeInfoPayeeStatus" value="#{semmmm001Bean.payeeInfo.payeeStatus}" 
											disabled="true" style="width:120px;">
			                					<f:selectItems value="#{semmmm001Bean.payeeStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.pay.type']}"/>
										</td>
										<td style="width:30%;">
						                	<h:selectOneRadio id="payeeInfoPayType" label="#{jspMsg['desc.pay.type.check']}"
											value="#{semmmm001Bean.payeeInfo.payType}" styleClass="ms7"
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}">
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['desc.pay.type.check']}" 
													itemDisabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" />
												<f:selectItem itemValue="02" itemLabel="#{jspMsg['desc.pay.type.transfer']}" 
													itemDisabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" />
											</h:selectOneRadio>
										</td>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.payee.flow.status']}"/>
										</td>
										<td style="width:30%;">
											<h:selectOneMenu id="payeeInfoPayeeFlowStatus" value="#{semmmm001Bean.payeeInfo.payeeFlowStatus}" 
											disabled="true" style="">
			                					<f:selectItems value="#{semmmm001Bean.payeeFlowStatusList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<!-- button payee info -->
						<h:panelGrid id="groupPayeeHistoryButton" width="100%">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.payeebatch']}" styleClass="contentform"
											style="vertical-align:top;"/>
										</td>
										<td style="width:30%;" class="ms7" >
											<h:outputText id="payeeBatchTxt" value="#{semmmm001Bean.payeeInfo.payeeBatch}"
											style="vertical-align:top;" />
										</td>
										<td style="text-align:right;">
											<a4j:commandButton id="btnPayeeHistoryPopup" 
											value="Payee History" styleClass="rich-button"
											action="#{semmmm001Action.doPayeeHistory}" 
											disabled="#{semmmm001Bean.payeeInfo.payeeId == null}" rendered="false"
											reRender="txtNavProgram, oppContent" 
											oncomplete="#{rich:component('mmm001PopUpHistory4')}.show();onTopPage();">
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
												<a4j:actionparam name="historyPage" value="PY" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnPayeeHistory" value="Payee History" 
											styleClass="rich-button" disabled="#{semmmm001Bean.payeeInfo.payeeId == null}"
											action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY4" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="doPayeeHistory" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
												<a4j:actionparam name="historyPage" value="PY" />
											</a4j:commandButton>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						
						<!-- >> tab panel -->
						<h:panelGrid style="width:97%;">
							<rich:tabPanel id="panelPayeeTab" selectedTab="#{semmmm001Bean.payeeSelectedTab}" switchType="client" style="width:100%;">
								<rich:tab label="#{jspMsg['header.payee.address']}" id="tabP0" onlabelclick="setTabNoP0();">
									<a4j:jsFunction name="setTabNoP0" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP0">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP0"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab0Payee"  viewId="../../pages/mm/semmmm001tab0Payee.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.rentor.address']}" id="tabP1" onlabelclick="setTabNoP1();">
									<a4j:jsFunction name="setTabNoP1" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP1">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP1"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab1Payee"  viewId="../../pages/mm/semmmm001tab1Payee.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.elector.address']}" id="tabP2" onlabelclick="setTabNoP2();">
									<a4j:jsFunction name="setTabNoP2" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP2">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP2"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab2Payee"  viewId="../../pages/mm/semmmm001tab2Payee.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.property.address']}" id="tabP3" onlabelclick="setTabNoP3();">
									<a4j:jsFunction name="setTabNoP3" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP3">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP3"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab3Payee" viewId="../../pages/mm/semmmm001tab3Payee.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.insure.address']}" id="tabP4" onlabelclick="setTabNoP4();">
									<a4j:jsFunction name="setTabNoP4" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP4">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP4"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab4Payee" viewId="../../pages/mm/semmmm001tab4Payee.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.construct.address']}" id="tabP5" onlabelclick="setTabNoP5();">
									<a4j:jsFunction name="setTabNoP5" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP5">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP5"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab5Payee" viewId="../../pages/mm/semmmm001tab5Payee.jsp" />
								</rich:tab>
								<rich:tab label="#{jspMsg['header.withholder.address']}" id="tabP6" onlabelclick="setTabNoP6();" rendered="false">
									<a4j:jsFunction name="setTabNoP6" action="#{navAction.navi}" 
							         reRender="panelPayeeTab, tabP6">
					        			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doInitPayeeChangeTab" />
					        			<a4j:actionparam  name="tabNo" value="tabP6"/>
							        </a4j:jsFunction>
						           	<a4j:include id="mmm001_incTab6Payee" viewId="../../pages/mm/semmmm001tab6Payee.jsp" />
								</rich:tab>
							</rich:tabPanel>
						</h:panelGrid>
					</rich:panel>
					<!-- bank info panel << -->
					
					<!-- button payee info -->
						<h:panelGrid id="groupPayeeButton" width="100%">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td style="width:100%;">
											<a4j:commandButton id="btnSavePayeeInfo" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
								           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
												value="#{jspMsg['btn.save']}" styleClass="rich-button"
												disabled="#{semmmm001Bean.disableBtnSavePayee}" 
												action="#{semmmm001Action.doValidatePayeeSaveDraft}"
												oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;" style=" width : 53px;">	
												
											</a4j:commandButton>
											<rich:spacer width="5"/>
										
											<%-- 2017/08/10 .. callback function request >> --%>
											
											<a4j:commandButton id="btnCancelPayeeDetail" reRender="txtNavProgram, oppContent"
												value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
												disabled="#{semmmm001Bean.disableBtnSavePayee or semmmm001Bean.payeeInfo.saveFlag eq 'N'}" action="#{navAction.navi}" >
													<a4j:actionparam name="navModule" value="mm" />
													<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
													<a4j:actionparam name="moduleWithNavi" value="mm" />
													<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
													<a4j:actionparam name="methodWithNavi" value="doViewPayeeByPayeeId" />
													<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPY}" />
													<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPY}" />
													<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPY}" />
													<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPY}" />
													<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
											</a4j:commandButton>
											
											<rich:spacer width="5"/>
											
											<a4j:commandButton id="btnCancelPayeeDetailBack" reRender="txtNavProgram, oppContent"
											value="#{jspMsg['btn.back']}" styleClass="rich-button" title="BC"
											rendered="#{semmmm001Bean.disableBtnSavePayee == false and semmmm001Bean.payeeInfo.saveFlag != 'N'}"
											disabled="#{semmmm001Bean.disableBtnSavePayee}" action="#{semmmm001Action.doInitValidateBack}" 
											style=" width : 52px;"
											oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
												<a4j:actionparam name="methodWithNavi" value="doViewPayeeByPayeeId" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPY}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPY}" />
												<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPY}" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPY}" />
												<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
												<a4j:actionparam name="moduleType" value="PY" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
							           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B1"
							           	 	rendered="#{semmmm001Bean.fromVendorFlag 
							           	 	and (semmmm001Bean.disableBtnSavePayee or semmmm001Bean.payeeInfo.saveFlag eq 'N')}"
							           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
												<a4j:actionparam name="moduleType" value="PY" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackTodo" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
											action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B2"
											rendered="#{(semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.fromVendorFlag == false)
											and (semmmm001Bean.disableBtnSavePayee or semmmm001Bean.payeeInfo.saveFlag eq 'N')}"
											oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
												<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
												<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
												<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
												<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
												<a4j:actionparam name="moduleType" value="PY" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackOth" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
							           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B3"
							           	 	rendered="false"
							           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'false'})changePagePY();">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
							           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B4"
							           	 	rendered="false"
							           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
							           	 		
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
												<a4j:actionparam name="moduleType" value="PY" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackTodoInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
											action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B5" 
											rendered="false"
											oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePY();">
												
												<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
												<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
												<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
												<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
												<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
												<a4j:actionparam name="moduleType" value="PY" />
											</a4j:commandButton>
											
											<a4j:commandButton id="btnBackOthInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
							           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B6"
							           	 	rendered="false"
							           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'true'})
											#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
											if(#{semmmm001Bean.renderedPopupConfirmBackPY == 'false'})changePagePY();">
												
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="actionId" value="BACK_FROM_PAYEE" />
												<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
												<a4j:actionparam name="moduleType" value="PY" />
											</a4j:commandButton>
											
											
											<rich:spacer width="5"/>
											<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" 
											infoClass="ms7green" rendered="#{semmmm001Bean.renderedMsgFormSearch}" >
											</rich:messages>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					
				</h:panelGrid>
				<!-- group[3] << -->
				
				<rich:spacer />
				
				<!-- group[4] >> -->
				<h:panelGrid id="bookbankPayeeInfo" width="98%" style="border:solid 1px gray;">
					<!-- contact list panel >> -->
					<rich:panel styleClass="">
						<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.of.payee.list']}" style=""/></f:facet>
						
						<!-- button -->
						<h:panelGrid columns="2" id="groupBookbankPayeeButton">
							<a4j:commandButton id="btnBookbankPayee" value="New Bookbank Payee" 
			           		style="float:right;" styleClass="rich-button"
			           		disabled="#{semmmm001Bean.payeeInfo.payeeId == null}"
							action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
								<a4j:actionparam name="navModule" value="mm" />
								<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
								<a4j:actionparam name="moduleWithNavi" value="mm" />
								<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
								<a4j:actionparam name="methodWithNavi" value="doNewBBPayeeFromPayee" />
								<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
								<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
								<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
								<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
								<a4j:actionparam name="bookbankPayeeIdParam" value="" />
								<a4j:actionparam name="btnActionType" value="N" />
								<a4j:actionparam name="payeePageFlag" value="Y" />
							</a4j:commandButton>
						</h:panelGrid>
						
							<!-- bookbank active info panel << -->
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="0" >
								<rich:panel id="pnlBookbankActiveVendorList" styleClass="sem_autoScrollbarInMM" >
									<f:facet name="header">
						            	<h:outputText value="#{jspMsg['header.bookbank.of.payee.active']}" style="width: 3200"/>
						            </f:facet>
						            
						            <rich:dataTable id="dtbBookbankPayeeActiveList" width="100%" 
										cellpadding="0" cellspacing="0" border="0" 
										value="#{semmmm001Bean.bookbankPayeeActiveList}" var="bookbankPayeeObj"
										reRender="oppContent, dtbBookbankPayeeActiveList" rows="#{semmmm001Bean.rowPerPage}"
										rowClasses="cur" styleClass="contentform" rowKeyVar="row">
										
											<rich:column rendered="false">
												<f:facet name="header">
													<h:outputText value="Send To Manager" styleClass="ms7" rendered="false"/>
												</f:facet>
												
												<div align="center" style="width:40px;" title="Send To Manager">
													<a4j:commandButton id="payeeBookbankActiveSTMRow" image="images/pay.gif" style="height:15px; width:15px;"
													disabled="false" rendered="#{payeeObj.dataObj.sendManagerFlag eq 'Y'}"
													action="#{navAction.navi}" reRender="dtbPayeeList"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
													oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
														<a4j:actionparam name="methodWithNavi" value="doSendToMNGByBookbankPayeeId" />
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
														<a4j:actionparam name="payeeIdParam" value="#{bookbankPayeeObj.dataObj.payeeId}" />
														<a4j:actionparam name="bookbankPayeeIdParam" value="#{bookbankPayeeObj.dataObj.bookbankPayeeId}" />
													</a4j:commandButton>
												</div>
											</rich:column>
										
											<rich:column rendered="false">
												<f:facet name="header">
													<h:outputText value="Delete" styleClass="ms7" rendered="false"/>
												</f:facet>
												
												<div align="center" style="width:40px;" title="Delete">
													<a4j:commandButton id="payeeBookbankActiveDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
													disabled="false" rendered="#{payeeObj.dataObj.deleteFlag eq 'Y'}"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
									           	 	action="#{navAction.navi}" reRender="dtbBookbankPayeeActiveList, mmm001PopUpCommon_retStatus"
									           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
														<a4j:actionparam name="methodWithNavi" value="doDeleteBBPayeeMaster" />
									           	 		<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
														<a4j:actionparam name="payeeIdParam" value="#{bookbankPayeeObj.dataObj.payeeId}" />
										           		<a4j:actionparam name="bookbankPayeeIdParam" value="#{bookbankPayeeObj.dataObj.bookbankPayeeId}" />
													</a4j:commandButton>
												</div>
											</rich:column>
										
											<rich:column>
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.view']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center" style="">
													<a4j:commandLink id="hlkPayeeDetailActive" value="view" 
													action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
													oncomplete="onTopPage();">
														<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
														<a4j:actionparam name="methodWithNavi" value="doViewBBPayeeFromPayee" />
														<a4j:actionparam name="payeeIdParam" value="#{bookbankPayeeObj.dataObj.payeeId}" />
														<a4j:actionparam name="bookbankPayeeIdParam" value="#{bookbankPayeeObj.dataObj.bookbankPayeeId}" />
														
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{bookbankPayeeObj.dataObj.vendorMapPayeeId}" />
														<a4j:actionparam name="payeePageFlag" value="Y" />
													</a4j:commandLink>
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.accountName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.accountName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.accountNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.accountNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.accountType}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{bookbankPayeeObj.dataObj.accountType}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bankCode}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bank.code']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bankCode}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bankName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bankName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bankBranch}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bankBranch}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.province}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{bookbankPayeeObj.dataObj.province}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.remark}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.remark}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bookbankPayeeFlowStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bookbankPayeeStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.active']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<!-- footer -->
											<f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													<rich:column colspan="4">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmmm001Bean.bookbankPayeeActiveList)}"></f:param>
														</h:outputFormat>
													</rich:column>
													<!-- > 2 -->
													<rich:column colspan="9">
														<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBookbankPayeeActiveList"
															maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrllBookbankPayeeActiveList" style="background-color: #cccccc;"
															page="#{semmmm001Bean.scrollerPage}">
														<a4j:support event="onclick" reRender="dtbBookbankPayeeActiveList"></a4j:support>
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
							<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="0" >
								<rich:panel id="pnlBookbankInactiveVendorList" styleClass="sem_autoScrollbarInMM" >
									<f:facet name="header">
						            	<h:outputText value="#{jspMsg['header.bookbank.of.payee.inactive']}" style="width: 3200"/>
						            </f:facet>
						            
						            <rich:dataTable id="dtbBookbankPayeeInactiveList" width="100%" 
										cellpadding="0" cellspacing="0" border="0" 
										value="#{semmmm001Bean.bookbankPayeeInactiveList}" var="bookbankPayeeObj"
										reRender="oppContent, dtbBookbankPayeeInactiveList" rows="#{semmmm001Bean.rowPerPage}"
										rowClasses="cur" styleClass="contentform" rowKeyVar="row">
										
											<rich:column style="width:80px;" rendered="false">
												<f:facet name="header">
													<h:outputText value="Send To Manager" styleClass="ms7" rendered="false"/>
												</f:facet>
												
												<div align="center" style="width:40px;" title="Send To Manager">
													<a4j:commandButton id="payeeBookbankInactiveSTMRow" image="images/pay.gif" style="height:15px; width:15px;"
													disabled="false" rendered="#{payeeObj.dataObj.sendManagerFlag eq 'Y'}"
													action="#{navAction.navi}" reRender="dtbPayeeList"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
													oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
														<a4j:actionparam name="methodWithNavi" value="doSendToMNGByBookbankPayeeId" />
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
														<a4j:actionparam name="payeeIdParam" value="#{bookbankPayeeObj.dataObj.payeeId}" />
														<a4j:actionparam name="bookbankPayeeIdParam" value="#{bookbankPayeeObj.dataObj.bookbankPayeeId}" />
													</a4j:commandButton>
												</div>
											</rich:column>
											
											<rich:column style="width:40px;" rendered="false">
												<f:facet name="header">
													
													<h:outputText value="Delete" styleClass="ms7" rendered="false"/>
												</f:facet>
												
												<div align="center" style="width:40px;" title="Delete">
													<a4j:commandButton id="payeeBookbankInactiveDeleteRow" image="images/delete.png" style="height:15px; width:15px;"
													disabled="false" rendered="#{payeeObj.dataObj.deleteFlag eq 'Y'}"
													onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
									           	 	action="#{navAction.navi}" reRender="dtbBookbankPayeeInactiveList, mmm001PopUpCommon_retStatus"
									           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
									           	 		<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
														<a4j:actionparam name="methodWithNavi" value="doDeleteBBPayeeMaster" />
									           	 		<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
														<a4j:actionparam name="payeeIdParam" value="#{bookbankPayeeObj.dataObj.payeeId}" />
										           		<a4j:actionparam name="bookbankPayeeIdParam" value="#{bookbankPayeeObj.dataObj.bookbankPayeeId}" />
													</a4j:commandButton>
												</div>
											</rich:column>
										
											<rich:column style="" title="">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.view']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center" style="">
													<a4j:commandLink id="hlkPayeeDetailInactive" value="view" 
													action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
													oncomplete="onTopPage();">
														<a4j:actionparam name="navModule" value="mm" />
														<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
														<a4j:actionparam name="moduleWithNavi" value="mm" />
														<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
														<a4j:actionparam name="methodWithNavi" value="doViewBBPayeeFromPayee" />
														<a4j:actionparam name="payeeIdParam" value="#{bookbankPayeeObj.dataObj.payeeId}" />
														<a4j:actionparam name="bookbankPayeeIdParam" value="#{bookbankPayeeObj.dataObj.bookbankPayeeId}" />
														
														<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
														<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
														<a4j:actionparam name="vendorMapPayeeIdParam" value="#{bookbankPayeeObj.dataObj.vendorMapPayeeId}" />
														<a4j:actionparam name="payeePageFlag" value="Y" />
													</a4j:commandLink>
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.accountName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.accountName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.accountNo}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.accountNo}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.accountType}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.account.type']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{bookbankPayeeObj.dataObj.accountType}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bankCode}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bank.code']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bankCode}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bankName}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bank.name']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bankName}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bankBranch}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.branch']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bankBranch}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.province}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.province']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="left" style="width:120px;">
													<h:outputText value="#{bookbankPayeeObj.dataObj.province}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.remark}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.remark']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.remark}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bookbankPayeeFlowStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow.status']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<rich:column style="" title="" sortBy="#{bookbankPayeeObj.dataObj.bookbankPayeeStatus}">
												<f:facet name="header">
													<h:outputText value="#{jspMsg['column.header.active']}" styleClass="contentform"/>
												</f:facet>
												
												<div align="center">
													<h:outputText value="#{bookbankPayeeObj.dataObj.bookbankPayeeStatus}" styleClass="contentform"  />
												</div>
											</rich:column>
											
											<!-- footer -->
											<f:facet name="footer">
												<rich:columnGroup>
													<!-- > 1 -->
													<rich:column colspan="4">
														<h:outputFormat value="#{msg['message.totalRecords']}">
															<f:param value="#{fn:length(semmmm001Bean.bookbankPayeeInactiveList)}"></f:param>
														</h:outputFormat>
													</rich:column>
													<!-- > 2 -->
													<rich:column colspan="9">
														<rich:datascroller immediate="true" rendered="true" align="left" for="dtbBookbankPayeeInactiveList"
															maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrllBookbankPayeeInactiveList" style="background-color: #cccccc;"
															page="#{semmmm001Bean.scrollerPage}">
														<a4j:support event="onclick" reRender="dtbBookbankPayeeInactiveList"></a4j:support>
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
					<!-- bookbank of payee list panel << -->
				</h:panelGrid>
				<!-- group[4] << -->
				
				<rich:spacer />
				
				<!-- group[5] >> -->
				<h:panelGrid id="contractPayeeInfo" width="98%" style="border:solid 1px gray;">
					<!-- contact list panel >> -->
					
					<rich:panel styleClass="">
						
						<rich:panel id="pnlContractPayeeInfoList" styleClass="sem_autoScrollbarInMM" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contract.of.payee.list']}" style="width: 3200"/>
						</f:facet>
						
						<rich:dataTable id="dtbContractPayeeList" width="100%" 
							cellpadding="0" cellspacing="0" border="0" 
							value="#{semmmm001Bean.contractOfPayeeList}" var="contractPayeeObj"
							reRender="dtbContractPayeeList" rows="#{semmmm001Bean.rowPerPage}"
							rowClasses="cur" styleClass="contentform" rowKeyVar="row">
							
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.contractNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.contractOldNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contract.number.old.new']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.contractOldNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.expenseType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expense.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.expenseType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.vendorName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{contractPayeeObj.dataObj.vendorName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.vendorStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.vendorStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.vendorFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor.flow.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.vendorFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.accountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.accountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.bookbankFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.flow.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.bookbankFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.payeeName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.name']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="left" style="width:120px;">
										<h:outputText value="#{contractPayeeObj.dataObj.payeeName}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.payeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.flow.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.payeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.payeeAccountNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.bookbankPayeeFlowStatus}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bookbank.payee.flow.status']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.payType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.pay.type']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.payType}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.effectiveDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.expireDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expire.date']}" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.expireDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<rich:column style="" title="" sortBy="#{contractPayeeObj.dataObj.vendorEffectiveDtStr}" rendered="false">
									<f:facet name="header">
										<h:outputText value="Effective Date" styleClass="contentform"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{contractPayeeObj.dataObj.vendorEffectiveDtStr}" styleClass="contentform"  />
									</div>
								</rich:column>
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmmm001Bean.contractOfPayeeList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="12">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbContractPayeeList"
												maxPages="#{semmmm001Bean.rowPerPage}" selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllContractList" style="background-color: #cccccc;"
												page="#{semmmm001Bean.scrollerPage}">
											<a4j:support event="onclick" reRender="dtbContractPayeeList"></a4j:support>
											</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
								
							</rich:dataTable>
					</rich:panel>
					</rich:panel>
					
					
					<!-- contract of payee list panel << -->
				</h:panelGrid>
			<%--/rich:panel--%>
			<!-- group[5] << -->
			
			
			<!-- end panel tab -->
					<h:panelGrid  id="pnlbookbankLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
						<h:panelGroup rendered="true">
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtCreateBy" value="#{semmmm001Bean.payeeInfo.createBy}" 
										readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldCreateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
										value="#{semmmm001Bean.payeeInfo.createDt}" 
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
										<h:inputText id="txtUpdateBy" value="#{semmmm001Bean.payeeInfo.updateBy}" 
										readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldUpdateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
										value="#{semmmm001Bean.payeeInfo.updateDt}" 
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
		</a4j:form>
	
	</rich:panel>
	
	<a4j:form id="frmShowReportExcelPayeeDetail_">
							
				
					
					<h:panelGrid id="pnlShowReportPayeeToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportPayeeToLeaderExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportPayeeToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportPayeeToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcelPayeeDetail_:bthShowReportPayeeToLeaderExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
				
	</a4j:form>
</h:panelGrid>

<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>