<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.master.name']}"/></f:facet>	
	
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
		
		<a4j:form id="frmBookbankInfo">
			<h:panelGrid id="pnlBookbankConfirm" width="95%" style="border:solid 1px gray;" 
			rendered="#{semmmm001Bean.bookbankInfo.confirmTxt != null}">
			
				
				<h:panelGrid id="groupBookbankConfirm" width="100%">
					<h:outputText value="#{semmmm001Bean.bookbankInfo.confirmTxt}" styleClass="ms7red"></h:outputText>
					<a4j:commandButton id="btnViewBookbankConfirm" value="View Change Of Data" styleClass="rich-button" 
						action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
						oncomplete="#{rich:component('mmm001PopUpCommon_confirmDetail')}.show(); return false;" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="doViewBookbankConfirm" />
							
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						</a4j:commandButton>
						
						
				</h:panelGrid>
			</h:panelGrid>
			
			<table width="98%">
				<tr>
					<td width="100%" align="right">
						
						<rich:spacer width="5px" ></rich:spacer>
						
						<a4j:commandButton id="btnSaveBankInfoTop" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
						panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
						value="#{jspMsg['btn.save']}" styleClass="rich-button"
						disabled="#{semmmm001Bean.disableBtnSaveBookbank}" 
						action="#{semmmm001Action.doValidateBookbankSaveDraft}"
						oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;">	
										
						</a4j:commandButton>
						
						<rich:spacer width="5px" ></rich:spacer>
						
						<a4j:commandButton id="btnCancelBookbankDetail_top" reRender="txtNavProgram, oppContent"
						value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
						disabled="#{semmmm001Bean.disableBtnSaveBookbank or semmmm001Bean.bookbankInfo.saveFlag == 'N'}" action="#{navAction.navi}" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
							<a4j:actionparam name="methodWithNavi" value="doCancelBookbankByVendorBookbankId" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoVB}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdVB}" />
							<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorBookbankId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="btnActionType" value="CANCEL" />
							<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
						</a4j:commandButton>
									
						<rich:spacer width="5" />
									
						<a4j:commandButton id="btnCancelBookbankDetailBack_top" reRender="txtNavProgram, oppContent"
						value="#{jspMsg['btn.back']}" styleClass="rich-button" title="BC"
						rendered="#{semmmm001Bean.disableBtnSaveBookbank == false and semmmm001Bean.bookbankInfo.saveFlag != 'N'}"
						disabled="#{semmmm001Bean.disableBtnSaveBookbank}" action="#{semmmm001Action.doInitValidateBack}" 
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVB();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
							<a4j:actionparam name="methodWithNavi" value="doCancelBookbankByVendorBookbankId" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoVB}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdVB}" />
							<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorBookbankId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="btnActionType" value="CANCEL" />
							<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBack_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B1"
		           	 	rendered="#{semmmm001Bean.fromVendorFlag and (semmmm001Bean.disableBtnSaveBookbank or semmmm001Bean.bookbankInfo.saveFlag eq 'N')}"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVB();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTodo_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B2"
						rendered="#{(semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.fromVendorFlag == false)
						and (semmmm001Bean.disableBtnSaveBookbank or semmmm001Bean.bookbankInfo.saveFlag eq 'N')}"
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVB();">
							<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
							<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
							<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackOth_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B3"
		           	 	oncomplete="onTopPage();" rendered="false">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B4"
		           	 	rendered="false">
							
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
							<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTodoInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B5"
						rendered="false" >
							
							<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
							<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
							<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackOthInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent"  title="B6"
		           	 	rendered="false">
							
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
							<a4j:actionparam name="moduleType" value="VB" />
						</a4j:commandButton>
						
						<a4j:jsFunction name="changePageVB" action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
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
			
			<rich:spacer />
			
			<!-- group[1] >> -->
			<h:panelGrid id="pnlContractInfo" width="98%" style="border:solid 1px gray;">
				<rich:panel rendered="false">
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
										<h:inputText id="contractInfoFirstEffectiveDtStr" value="#{semmmm001Bean.contractInfo.firstEffectiveDtStr}" 
										disabled="true" style="width:70%;" />
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
										<h:inputText id="contractInfoEffectiveDtStr" value="#{semmmm001Bean.contractInfo.effectiveDtStr}" 
										disabled="true" style="width:70%;" />
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
										<h:inputText id="contractInfoExpireDtStr" value="#{semmmm001Bean.contractInfo.expireDtStr}" 
										disabled="true" style="width:70%;" />
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
										<h:outputText value="#{jspMsg['label.owner.name']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoOwnerName" value="#{semmmm001Bean.contractInfo.ownerName}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contract.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoContractName" value="#{semmmm001Bean.contractInfo.contractName}" 
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contact.name']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="contractInfoContactName" value="#{semmmm001Bean.contractInfo.contactName}" 
		                				disabled="true" style="width:70%;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.telephone']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="contractInfoTelephone" value="#{semmmm001Bean.contractInfo.telephone}" 
										disabled="true" style="width:70%;" />
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
										<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSiteInfo}" 
										oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfo.siteInfoId}" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnBack_N" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
						           	 	oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						           		</a4j:commandButton>
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
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.company']}"/>
									</td>
									<td style="" colspan="3">
										<h:selectOneMenu id="vendorInfoCompany" value="#{semmmm001Bean.vendorInfo.company}" style="width:100px;"
										disabled="true" >
		                					<f:selectItems value="#{semmmm001Bean.companyList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.vendor.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoVendorType" value="#{semmmm001Bean.vendorInfo.vendorType}" 
										disabled="true" style="width:200px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorTypeList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.block.flag']}" rendered="false"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoBlockFlag" value="#{semmmm001Bean.vendorInfo.vendorBlockStatus}" 
										disabled="true" style="width:100px;" rendered="false">
		                					<f:selectItems value="#{semmmm001Bean.vendorBlockStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.code']}"/>
									</td>
									<td style="width:30%;">
		                				<h:inputText id="vendorInfoVendorCode" value="#{semmmm001Bean.vendorInfo.vendorCode}" 
										disabled="true" maxlength="50" style="width:26%;" styleClass="" />
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
										disabled="true" maxlength="200" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name2']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName2" value="#{semmmm001Bean.vendorInfo.vendorName2}" 
										disabled="true" maxlength="200" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name3']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName3" value="#{semmmm001Bean.vendorInfo.vendorName3}" 
										disabled="true" maxlength="200" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.name4']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoVendorName4" value="#{semmmm001Bean.vendorInfo.vendorName4}" 
										disabled="true" maxlength="200" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoIdCard" value="#{semmmm001Bean.vendorInfo.idCard}" 
										disabled="true" maxlength="13" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="vendorInfoTaxId" value="#{semmmm001Bean.vendorInfo.taxId}" 
										disabled="true" maxlength="13" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.hq.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoHqBranch" value="#{semmmm001Bean.vendorInfo.hqFlag}" 
										disabled="true" style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
		                				</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="ms7" />
		                				<h:inputText id="vendorInfoBranchNo" value="#{semmmm001Bean.vendorInfo.branchNo}" 
										disabled="true" maxlength="20" style="width:50px;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Withhold :"/>
									</td>
									<td style="width:30%;">
		                				<a4j:region>
											<h:selectOneMenu id="vendorInfoWhtId" value="#{semmmm001Bean.vendorInfo.whtId}" 
											disabled="true" 
											onchange="vendorInfo_GetWithholdJS();" styleClass="" style="width:100px;">
												<f:selectItems value="#{semmmm001Bean.withholdList}" />
											</h:selectOneMenu>
											
											<a4j:jsFunction name="vendorInfo_GetWithholdJS" 
											reRender="vendorInfoWhtType, vendorInfoWhtCode" 
											action="#{semmmm001Action.doGetWithhold}">
											</a4j:jsFunction>
										</a4j:region>
		                				&nbsp;
		                				
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoVendorStatus" value="#{semmmm001Bean.vendorInfo.vendorStatus}" 
										disabled="true" style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.vendorStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										
									</td>
									<td style="width:30%;" colspan="3">
										<h:selectBooleanCheckbox id="chkVAT" 
										value="#{semmmm001Bean.vendorInfo.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="true"/>
				                		<h:outputText value="#{jspMsg['label.vendor.vat.registration']}" styleClass="ms7" style="padding-left:2px;" />
				                	&nbsp;
										<h:selectBooleanCheckbox id="vendorInfoVendorBlockStatus" 
										value="#{semmmm001Bean.vendorBlockStatus}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="true"/>
				                		<h:outputText value="Block" styleClass="ms7" style="padding-left:2px;" />
									&nbsp;
										
										<h:selectBooleanCheckbox id="vendorInfoNotPayeeFlag" 
										value="#{semmmm001Bean.notPayeeFlag}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="true"/>
				                		<h:outputText value="#{jspMsg['label.vendor.notpayee']}" styleClass="ms7" style="padding-left:2px;" />
				                		&nbsp;
				                		<h:selectBooleanCheckbox id="vendorInfOtherExpenseFlag" 
										value="#{semmmm001Bean.otherExpenseFlag}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="true"/>
				                		<h:outputText value="#{jspMsg['label.vendor.vendornocontract']}" styleClass="ms7" style="padding-left:2px;" />
										&nbsp;
										<h:selectBooleanCheckbox id="vendorInfoBlackListStatus" 
										value="#{semmmm001Bean.vendorBlackListStatus}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="true"/>
				                		<h:outputText value="Black List" styleClass="ms7" style="padding-left:2px;" />
				                		&nbsp;
				                		
				                		<h:selectBooleanCheckbox id="mmm001tab0_chkLocalDepartment" 
										value="#{semmmm001Bean.vendorAddrObj.chkLocalDepartment}"
										disabled="true"
										onclick="" style="margin:0px 5px 0px 0px;" />
										<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
										
									</td>
								</tr>
								<tr>
									<td style="width:20%;text-align:right;vertical-align: top;" rowspan="2" class="ms7">
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
			</h:panelGrid>
			<!-- group[2] << -->
			
			<rich:spacer />
			
			<!-- group[3] >> -->
			<h:panelGrid id="bankInfo" width="98%" style="border:solid 1px gray;">
				<!-- button bankInfo -->
				<h:panelGrid id="groupBankInfoButton" width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td style="width:70%;">
									<a4j:commandButton id="btnNewBookbank" value="New Bookbank" styleClass="rich-button"
									action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnNewAllVB}" 
									rendered="#{semmmm001Bean.renderedBtnNewAllVB}"
									reRender="txtNavProgram, oppContent"
									style="padding-left: 5px;width:90px;">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doNewBookbank" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="" />
										<a4j:actionparam name="btnActionType" value="N" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNewAllVB}"/>
									
									<a4j:commandButton id="btnEdtBookbankData" value="Edit Data" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" 
					           	 	rendered="#{semmmm001Bean.renderedBtnEditDataBookbank}"
					           	 	reRender="oppContent" disabled="#{semmmm001Bean.disableBtnEditDataBookbank}"
					           	 	style="padding-left: 5px; width:85px;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doEditBookbankData" />
										<a4j:actionparam name="btnActionType" value="ED" />
					           		</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnEditDataBookbank}"/>
									<a4j:commandButton id="btnEdtBookbank" value="Edit Bookbank" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" 
					           	 	rendered="#{semmmm001Bean.renderedBtnEditBookbank}"
					           	 	reRender="oppContent" disabled="#{semmmm001Bean.disableBtnEditBookbank}"
					           	 	style="padding-left: 5px; width:85px;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doEditBookbankByVendorBookbankId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="btnActionType" value="E" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
					           		<a4j:commandButton id="btnChngeBookbank" value="Change Bookbank" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnChangeVB}"
					           	 	rendered="#{semmmm001Bean.renderedBtnChangeVB}" 
					           	 	reRender="oppContent"
					           	 	style="padding-left: 3px; width:100px;">
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doChangeBookbank" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="btnActionType" value="C" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
				          			<a4j:commandButton id="btnSndToMng" value="Send To Manager"
				          			disabled="#{semmmm001Bean.disableBtnSendManagerVB}"
				          			rendered="#{semmmm001Bean.renderedBtnSendManagerVB}"
					           	 	action="#{navAction.navi}" styleClass="rich-button" 
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
									oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
									reRender="txtNavProgram, oppContent"
									style="padding-left: 5px; width:100px;" >
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doSendToMNGByVendorBookbankId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
					           		
					           		<a4j:commandButton id="btnExpBtchVD" value="Export Batch" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableExportBatchVB}"
					           	 	rendered="#{semmmm001Bean.renderedExportBatchVB}" 
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
					           	 	reRender="frmBookbankInfo,pnlShowReportVendorBookbankExcel"
					           	 	style="padding-left: 5px; width:85px;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
										<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_VB" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="bookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
					           		
					           		<a4j:commandButton id="btnClearBatch" value="#{jspMsg['btn.clearBatch']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableClearBatchVB}"
					           	 	rendered="#{semmmm001Bean.renderedClearBatchVB}" 
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
					           	 	reRender="oppContent, frmResultSearch, dtbResultList"
					           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
					           	 	style="padding-left: 5px; width:80px;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
										<a4j:actionparam name="btnEvent" value="CLEAR_BATCH" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="bookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5" rendered="false" />
					           		
					           		<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']} #{jspMsg['btn.bookbank']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableCancelVB}"
					           	 	rendered="false" 
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
					           	 	reRender="oppContent, frmResultSearch, dtbResultList"
					           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
					           	 	style="padding-left: 5px; width:98px;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
										<a4j:actionparam name="btnEvent" value="CANCEL" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="bookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedCancelVB}"/>
					           		
					           		<a4j:commandButton id="btnConfirm" value="#{jspMsg['btn.confirm']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}"
					           	 	rendered="#{semmmm001Bean.renderedConfirmVB}"
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
					           	 	reRender="oppContent, frmResultSearch, dtbResultList"
					           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
					           	 	style="padding-left: 5px; width:98px;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
										<a4j:actionparam name="btnEvent" value="CONFIRM" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="bookbankId" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="typeFlag" value="B" />
					           		</a4j:commandButton>
					           	</td>
					           	<td style="width:30%; text-align:right;">
					           		<a4j:commandButton id="btnDlteBookbank" value="Delete Bookbank #{jspMsg['btn.out.of']} Vendor" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableDeleteVB}"
					           	 	rendered="#{semmmm001Bean.renderedDeleteVB}"
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
									oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
									reRender="dtbContractList, txtNavProgram, oppContent"
									style="padding-left: 5px; width:185px;" >
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doDeleteBookbankMaster" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
					           		</a4j:commandButton>
					           	</td>
					        </tr>
					    </table>
					</h:panelGroup>
				</h:panelGrid>

				<!-- bank info panel >> -->
				<rich:panel id="bookbankInfo">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.info']}"/></f:facet>
					
					<!-- bank info -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.info.from.sap']}"/>
									</td>
									<td colspan="3">
										<a4j:commandButton id="btnCopyInfoFromSAP" value="Copy Bookbank's Info from SAP" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableEditBookbankContent or semmmm001Bean.bookbankInfoMissMatchWithSAPObj.rowId == null}"
										action="#{semmmm001Action.doCopyBookbankInfoFromSAP}" reRender="bookbankInfo">
										</a4j:commandButton>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="bankInfoAccountType" value="#{semmmm001Bean.bookbankInfo.accountType}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
										style="width:100px;">
		                					<f:selectItems value="#{semmmm001Bean.accountTypeList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.bank.code']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoBankCode" value="#{semmmm001Bean.bookbankInfo.bankCode}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
                                        maxlength="7"
										onblur="callFillinBookbankInfoJS();" style="width:96px;" />
										
										<a4j:jsFunction name="callFillinBookbankInfoJS" action="#{semmmm001Action.doFillinBookbankInfo}" 
										reRender="bankInfoBankName, bankInfoBankBranch, bankInfoProvince, bankInfoAccountNo" >
										</a4j:jsFunction>
										
										
	                                    <a4j:commandButton id="btnPopupSearchBankCode" 
	                                    oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
	                                    value="..." action="#{navAction.navi}" reRender="popupFrmSelectBank,frmSelectBank" styleClass="rich-button" 
	                                    style="margin-left:5px; height:22px; vertical-align:top;"
	                                    disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}">
		                                    <a4j:actionparam name="navModule" value="mm" />
		                                    <a4j:actionparam name="navProgram" value="SEMMMM001-3" />
		                                    <a4j:actionparam name="moduleWithNavi" value="mm" />
		                                    <a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
		                                    <a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
	                                    </a4j:commandButton>
	                                    
	                                    <a4j:commandButton id="btnNew" value="New" styleClass="rich-button"
										 action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, panel_popupNewOrUpdateBankMaster" 
										 oncomplete="#{rich:component('panel_popupNewOrUpdateBankMaster')}.show(); return false; "
										 style="margin-left:5px; height:22px; vertical-align:top;"
										 disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}">
										 	<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doInitNewOrUpdate" />
											<a4j:actionparam name="mode" value="NEW" />
										</a4j:commandButton>
										
										<h:outputText value="#{semmmm001Bean.bookbankInfoMissMatchWithSAPObj.bankCode}" 
										rendered="#{semmmm001Bean.bookbankInfoMissMatchWithSAPObj.bankCode != null}"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank']}"/>
									</td>
									<td style="width:30%;">
										<%--
										<h:selectOneMenu id="bankInfoBankName" value="#{semmmm001Bean.bookbankInfo.bankId}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
										style="">
		                					<f:selectItems value="#{semmmm001Bean.bankList}" />
		                				</h:selectOneMenu>
		                				--%>
		                				<h:inputText id="bankInfoBankName" value="#{semmmm001Bean.bookbankInfo.bankName}" 
										disabled="true" maxlength="250" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoBankBranch" value="#{semmmm001Bean.bookbankInfo.bankBranch}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoProvince" value="#{semmmm001Bean.bookbankInfo.province}" 
										disabled="true" style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.provinceBookbankList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.number']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoAccountNo" value="#{semmmm001Bean.bookbankInfo.accountNo}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
										style="width:70%;" maxlength="#{semmmm001Bean.accountNoMaxLength}" />

										<h:outputText value="#{semmmm001Bean.bookbankInfoMissMatchWithSAPObj.accountNo}" 
										rendered="#{semmmm001Bean.bookbankInfoMissMatchWithSAPObj.accountNo != null}"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoAccountName" value="#{semmmm001Bean.bookbankInfo.accountName}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" style="width:70%;" />
										
										<h:outputText value="#{semmmm001Bean.bookbankInfoMissMatchWithSAPObj.accountName}" 
										rendered="#{semmmm001Bean.bookbankInfoMissMatchWithSAPObj.accountName != null}"
										style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoRemark" value="#{semmmm001Bean.bookbankInfo.remark}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoBookbankStatus" value="#{semmmm001Bean.bookbankInfo.bookbankStatus}" 
										disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent) or 
										semmmm001Bean.bookbankInfo.vendorBookbankId == null}" style="">
		                					<f:selectItems value="#{semmmm001Bean.bookbankStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%;" class="">
										<h:outputText value=""/>
									</td>
									<td style="width:30%;">
										<h:outputText value="#{jspMsg['btn.check.bookbank.info']}" style="color:red;" styleClass="ms7" rendered="false"/>
										<a4j:commandButton id="btnChkBookbank" value="Check Bookbank" styleClass="rich-button" style="margin-left:5px;" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankContent}" 
	           	 						oncomplete="#{rich:component('mmm001PopUpCommon_semSapBookbankList')}.show(); return false;"
	           	 						rendered="false"
										action="#{semmmm001Action.doChkBookbank}" reRender="oppContent"> 
											<a4j:actionparam name="panelParam" value="BOOKBANK"/>
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoBookbankFlowStatus" 
										value="#{semmmm001Bean.bookbankInfo.bookbankFlowStatus}" 
										disabled="true" style="">
		                					<f:selectItems value="#{semmmm001Bean.bookbankFlowStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<!-- button bank info -->
					<h:panelGrid id="groupBookbankHistoryButton" width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
								
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbankbatch']}" styleClass="contentform"
										style="vertical-align:top;"/>
									</td>
									<td style="width:30%;" class="ms7" >
										<h:outputText value="#{semmmm001Bean.bookbankInfo.bookbankBatch}"
										style="vertical-align:top;"/>
									</td>
								
									<td style="width:100%; text-align:right;">
										<a4j:commandButton id="btnBookbankHistoryPopup" 
										value="Bookbank History" styleClass="rich-button"
										action="#{semmmm001Action.doBookbankHistory}" 
										disabled="#{semmmm001Bean.bookbankInfo.vendorBookbankId == null}" rendered="false"
										reRender="txtNavProgram, oppContent" 
										oncomplete="#{rich:component('mmm001PopUpHistory3')}.show();onTopPage();">
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="bookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
											<a4j:actionparam name="historyPage" value="VB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBookbankHistory" value="Bookbank History" 
										styleClass="rich-button" disabled="#{semmmm001Bean.bookbankInfo.vendorBookbankId == null}"
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY3" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doBookbankHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="bookbankIdParam" value="#{semmmm001Bean.bookbankInfo.vendorBookbankId}" />
											<a4j:actionparam name="historyPage" value="VB" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
				</rich:panel>
				<!-- bank info panel << -->
				
				
				<!-- bank info panel (compare content) >> -->
				<rich:panel id="bookbankInfo_compareContent" style="background-color:#FFFFCC;" 
				rendered="#{semmmm001Bean.renderedPnlCmpBookbankInfo and semmmm001Bean.bookbankInfo.saveFlag == 'C'}">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.bank.info']} (Draft)"/></f:facet>
					
					<!-- bank info -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="bankInfoCmpAccountType" 
										value="#{semmmm001Bean.bookbankInfoCmpObj.accountType}" 
										style="width:100px;">
		                					<f:selectItems value="#{semmmm001Bean.accountTypeList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.bank.code']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoCmpBankCode" 
										value="#{semmmm001Bean.bookbankInfoCmpObj.bankCode}" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
                                        maxlength="7"
										onblur="callFillinBookbankInfoCmpJS();" style="width:96px;" />
										
										<a4j:jsFunction name="callFillinBookbankInfoCmpJS" 
										action="#{semmmm001Action.doFillinBookbankInfoCmp}" 
										reRender="bankInfoCmpBankName, bankInfoCmpBankBranch, bankInfoCmpProvince, bankInfoCmpAccountNo" >
										</a4j:jsFunction>
										
										
	                                    <a4j:commandButton id="btnPopupSearchBankCodeCmp" 
	                                    oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
	                                    value="..." action="#{navAction.navi}" reRender="popupFrmSelectBank, frmSelectBank" 
	                                    styleClass="rich-button" style="margin-left:5px; height:22px; vertical-align:top;">
		                                    <a4j:actionparam name="navModule" value="mm" />
		                                    <a4j:actionparam name="navProgram" value="SEMMMM001-3" />
		                                    <a4j:actionparam name="moduleWithNavi" value="mm" />
		                                    <a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
		                                    <a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
	                                    </a4j:commandButton>
	                                    
	                                    <a4j:commandButton id="btnNewCmp" value="New" styleClass="rich-button"
										 action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, panel_popupNewOrUpdateBankMaster" 
										 oncomplete="#{rich:component('panel_popupNewOrUpdateBankMaster')}.show(); return false; "
										 style="margin-left:5px; height:22px; vertical-align:top;">
										 	<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doInitNewOrUpdate" />
											<a4j:actionparam name="mode" value="NEW" />
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank']}"/>
									</td>
									<td style="width:30%;">
										
		                				<h:inputText id="bankInfoCmpBankName" value="#{semmmm001Bean.bookbankInfoCmpObj.bankName}" 
										disabled="true" maxlength="250" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoCmpBankBranch" value="#{semmmm001Bean.bookbankInfoCmpObj.bankBranch}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoCmpProvince" value="#{semmmm001Bean.bookbankInfoCmpObj.province}" 
										disabled="true" style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.provinceBookbankList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.number']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoCmpAccountNo" value="#{semmmm001Bean.bookbankInfoCmpObj.accountNo}" 
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
										style="width:70%;" maxlength="#{semmmm001Bean.accountNoMaxLengthCmp}" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bankInfoCmpAccountName" value="#{semmmm001Bean.bookbankInfoCmpObj.accountName}" 
										style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bankInfoCmpRemark" value="#{semmmm001Bean.bookbankInfoCmpObj.remark}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoCmpBookbankStatus" 
										value="#{semmmm001Bean.bookbankInfoCmpObj.bookbankStatus}" 
										disabled="true" style="">
		                					<f:selectItems value="#{semmmm001Bean.bookbankStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:20%;" class="">
										<h:outputText value=""/>
									</td>
									<td style="width:30%;">
										<h:outputText value="#{jspMsg['btn.check.bookbank.info']}" style="color:red;" styleClass="ms7" rendered="false"/>
										<a4j:commandButton id="btnCmpChkBookbank" value="..." styleClass="rich-button" style="margin-left:5px;" 
	           	 						oncomplete="#{rich:component('mmm001PopUpCommon_semSapBookbankList')}.show(); return false;"
										action="#{semmmm001Action.doChkBookbank}" reRender="oppContent" rendered="false"> 
											<a4j:actionparam name="panelParam" value="BOOKBANK"/>
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bankInfoCmpBookbankFlowStatus" 
										value="#{semmmm001Bean.bookbankInfoCmpObj.bookbankFlowStatus}" 
										disabled="true" style="">
		                					<f:selectItems value="#{semmmm001Bean.bookbankFlowStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				<!-- bank info panel (compare content) << -->
				
				
				<!-- button bank info -->
				<h:panelGrid id="groupBookbankInfoButton" width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td style="width:100%;">
								
									<%-- 2017/08/10 .. callback function request >> --%>
									<a4j:commandButton id="btnSaveBankInfo" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
						           	 	panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableBtnSaveBookbank}" 
										action="#{semmmm001Action.doValidateBookbankSaveDraft}"
										oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;">	
										
									</a4j:commandButton>
									<rich:spacer width="5"/>
									
									<a4j:commandButton id="btnCancelBookbankDetail" reRender="txtNavProgram, oppContent"
										value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableBtnSaveBookbank or semmmm001Bean.bookbankInfo.saveFlag == 'N'}" 
										action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doCancelBookbankByVendorBookbankId" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoVB}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdVB}" />
											<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorBookbankId}" />
											<a4j:actionparam name="btnActionType" value="CANCEL" />
											<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
									</a4j:commandButton>
									
									<rich:spacer width="5" />
									
									<a4j:commandButton id="btnCancelBookbankDetailBack" reRender="txtNavProgram, oppContent"
									value="#{jspMsg['btn.back']}" styleClass="rich-button" title="BC"
									rendered="#{semmmm001Bean.disableBtnSaveBookbank == false and semmmm001Bean.bookbankInfo.saveFlag != 'N'}"
									disabled="#{semmmm001Bean.disableBtnSaveBookbank}" action="#{semmmm001Action.doInitValidateBack}" 
									oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
									#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVB();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-3" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
										<a4j:actionparam name="methodWithNavi" value="doCancelBookbankByVendorBookbankId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoVB}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdVB}" />
										<a4j:actionparam name="vendorBookbankIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorBookbankId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="btnActionType" value="CANCEL" />
										<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
										<a4j:actionparam name="moduleType" value="VB" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B1"
					           	 	rendered="#{semmmm001Bean.fromVendorFlag and (semmmm001Bean.disableBtnSaveBookbank or semmmm001Bean.bookbankInfo.saveFlag eq 'N')}"
					           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
									#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVB();">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
										<a4j:actionparam name="moduleType" value="VB" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackTodo" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
									action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B2"
									rendered="#{(semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.fromVendorFlag == false)
									and (semmmm001Bean.disableBtnSaveBookbank or semmmm001Bean.bookbankInfo.saveFlag eq 'N')}"
									oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
									#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
									if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePageVB();">
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
										<a4j:actionparam name="moduleType" value="VB" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackOth" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B3"
					           	 	oncomplete="onTopPage();" rendered="false">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
										<a4j:actionparam name="moduleType" value="VB" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B4"
					           	 	rendered="false">
										
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="moduleType" value="VB" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackTodoInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
									action="#{navAction.navi}" reRender="txtNavProgram, oppContent" title="B5"
									rendered="false" >
										
										<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
										<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
										<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
										<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
										<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
										<a4j:actionparam name="moduleType" value="VB" />
									</a4j:commandButton>
									
									<a4j:commandButton id="btnBackOthInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="txtNavProgram, oppContent"  title="B6"
					           	 	rendered="false">
										
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK" />
										<a4j:actionparam name="moduleType" value="VB" />
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
			
			<!-- group[5] >> -->
			<h:panelGrid id="contractInfo" width="98%" style="border:solid 1px gray;">
				<!-- contact list panel >> -->
				<rich:panel id="pnlcontBookbankList" styleClass="sem_autoScrollbarInMM" >
					<f:facet name="header">
		            	<h:outputText value="#{jspMsg['header.contract.of.bookbank.list']}" style="width: 3200"/>
		            </f:facet>
		            
		            <rich:dataTable id="dtbContractList" width="100%" 
						cellpadding="0" cellspacing="0" border="0" 
						value="#{semmmm001Bean.contractOfBookbankList}" var="contractObj"
						reRender="dtbContractList" rows="#{semmmm001Bean.rowPerPage}"
						rowClasses="cur" styleClass="dataTable" rowKeyVar="row">
						
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contract.number']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.contractNo}" styleClass="contentform"  />
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.bookbankFlowStatus}">
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.payeeAccountNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payee.account.no']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.payeeAccountNo}" styleClass="contentform"  />
								</div>
							</rich:column>
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.bookbankPayeeFlowStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.status']} #{jspMsg['column.header.bookbank.payee.flow']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.bookbankPayeeFlowStatus}" styleClass="contentform"  />
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
											<f:param value="#{fn:length(semmmm001Bean.contractOfBookbankList)}"></f:param>
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
				
				<!-- contract list panel << -->
			</h:panelGrid>
			
			<!-- end panel tab -->
					<h:panelGrid  id="pnlbookbankLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
						<h:panelGroup rendered="true">
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtCreateBy" value="#{semmmm001Bean.bookbankInfo.createBy}" 
										readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldCreateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
										value="#{semmmm001Bean.bookbankInfo.createDt}" 
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
										<h:inputText id="txtUpdateBy" value="#{semmmm001Bean.bookbankInfo.updateBy}" 
										readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldUpdateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
										value="#{semmmm001Bean.bookbankInfo.updateDt}" 
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
			<!-- group[5] << -->
		</a4j:form>
	
	</rich:panel>
	
	<a4j:form id="frmShowReportExcelVendorBookbankDetail_">
					
					<h:panelGrid id="pnlShowReportVendorBookbankExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportVendorBookbankExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportVendorBookbankExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportVendorBookbankToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcelVendorBookbankDetail_:bthShowReportVendorBookbankExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
		
	</a4j:form>
</h:panelGrid>

	

<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>