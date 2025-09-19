<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

<h:panelGrid width="100%">
	<rich:panel>
	<f:facet name="header"><h:outputText value="#{jspMsg['header.bookbank.payee.master.name']}"/></f:facet>	
	
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
		
		<a4j:form id="frmBookbankPayeeInfo">
			
			<h:panelGrid id="pnlPayeeBBConfirm" width="95%" style="border:solid 1px gray;" 
			rendered="#{semmmm001Bean.bookbankPayeeInfo.confirmTxt != null}">
			
				
				<h:panelGrid id="groupPayeeBBConfirm" width="100%">
					<h:outputText value="#{semmmm001Bean.bookbankPayeeInfo.confirmTxt}" styleClass="ms7red"></h:outputText>
					
					<a4j:commandButton id="btnViewPayeeConfirm" value="View Change Of Data" styleClass="rich-button" 
						action="#{navAction.navi}" reRender="txtNavProgram, oppContent"
						oncomplete="#{rich:component('mmm001PopUpCommon_confirmDetail')}.show(); return false;" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="doViewBBPayeeConfirm" />
							
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
							<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						</a4j:commandButton>
						
						
				</h:panelGrid>
			</h:panelGrid>
		
			<table width="98%">
				<tr>
					<td width="100%" align="right">
						
						<a4j:commandButton id="btnSaveBookbankPayeeInfoTop" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
							panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
							value="#{jspMsg['btn.save']}" styleClass="rich-button"
							disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}" 
							action="#{semmmm001Action.doValidateBBPayeeSaveDraft}"
							oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;">	
												
						</a4j:commandButton>
						
						<rich:spacer width="5"/>
						
						<a4j:commandButton id="btnCancelPayeeBookbankDetail_top" reRender="txtNavProgram, oppContent"
						value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
						disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N'}" action="#{navAction.navi}" >
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
							<a4j:actionparam name="methodWithNavi" value="doBBPayeeCancel" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPB}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPB}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPB}" />
							<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.bookbankPayeeIdPB}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPB}" />
							<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
						</a4j:commandButton>
						
						<rich:spacer width="5"/>
						
						<a4j:commandButton id="btnCancelPayeeBookbankDetailBack_top" reRender="txtNavProgram, oppContent"
						value="#{jspMsg['btn.back']}" styleClass="rich-button" title="BC"
						rendered="#{semmmm001Bean.disableBtnSaveBookbankPayee == false and semmmm001Bean.bookbankPayeeInfo.saveFlag != 'N'}"
						disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}" action="#{semmmm001Action.doInitValidateBack}" 
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
							<a4j:actionparam name="methodWithNavi" value="doBBPayeeCancel" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPB}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPB}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPB}" />
							<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.bookbankPayeeIdPB}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPB}" />
							<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBack_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B1"
		           	 	rendered="#{(semmmm001Bean.fromVendorFlag and semmmm001Bean.fromPayeeFlag == false)  
		           	 	and (semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N')}"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackPayee_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B2"
		           	 	rendered="#{semmmm001Bean.fromPayeeFlag
		           	 	and (semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N')}"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTodo_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B3"
						action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" 
						rendered="#{(semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.fromPayeeFlag == false) 
						and (semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N')}"
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
							<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
							<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
							<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackOth_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B4"
		           	 	rendered="false"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B5"
		           	 	rendered="false"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
							
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackPayeeInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B6"
		           	 	rendered="false"
		           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
							
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTodoInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B7"
						rendered="false"
						oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
						#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
						if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
							
							<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
							<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
							<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
							<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
							<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackOthInit_top" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
		           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B8"
		           	 	rendered="false">
						
							<a4j:actionparam name="navModule" value="mm" />
							<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
							<a4j:actionparam name="moduleWithNavi" value="mm" />
							<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
							<a4j:actionparam name="methodWithNavi" value="pageLoad" />
							<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
							<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
							<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
							<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:commandButton>
						
						<a4j:jsFunction name="changePagePB" action="#{navAction.navi}" reRender="txtNavProgram, oppContent" >
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
							<a4j:actionparam name="moduleType" value="PB" />
						</a4j:jsFunction>
					</td>
				</tr>
			</table>
			
			<rich:spacer />
		
			<!-- group[1] >> -->
			<h:panelGrid id="pnlContractInfo" width="98%" style="border:solid 1px gray;">
				<rich:panel rendered="#{semmmm001Bean.visiblePnlContractInfo}">
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
								<tr style="display: none;">
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
								<tr style="display: none;">
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
								<tr style="display: none;">
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
								<tr style="display: none;">
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
								<tr style="display: none;">
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
								<tr style="display: none;">
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
								<tr style="display: none;">
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
										<a4j:commandButton id="btnContractHistory" value="Contract History" 
										styleClass="rich-button" disabled="false" rendered="false"
										action="#{navAction.navi}" reRender="txtNavProgram, oppContent" 
										oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY1" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doContractHistory" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.contractInfo.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.vendorInfo.contractNo}" />
										</a4j:commandButton>
										<rich:spacer width="5"/>
										<a4j:commandButton id="btnInfo" value="#{jspMsg['btn.site.info']}" styleClass="rich-button"
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{semmmm001Bean.contractInfo.siteInfoId}" />
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
								<tr style="display: none;">
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.company']}"/>
									</td>
									<td colspan="3" style="">
										<h:selectOneMenu id="vendorInfoCompany" value="#{semmmm001Bean.vendorInfo.company}" style="width:100px;"
										disabled="true" >
		                					<f:selectItems value="#{semmmm001Bean.companyList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
								<tr style="display: none;">
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
										<h:outputText value="#{jspMsg['label.block.flag']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoBlockFlag" value="#{semmmm001Bean.vendorInfo.vendorBlockStatus}" 
										disabled="true" style="width:100px;">
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
										disabled="true" maxlength="50" style="width:26%;" styleClass="ms7" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Black List : " rendered="false"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoBlackListStatus" value="#{semmmm001Bean.vendorInfo.vendorBlackListStatus}" 
										disabled="true" style="width:100px;" rendered="false">
		                					<f:selectItems value="#{semmmm001Bean.vendorBlackListStatusList}" />
		                				</h:selectOneMenu>
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
								<tr style="display: none;">
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
								<tr style="display: none;">
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.hq.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoHqBranch" value="#{semmmm001Bean.vendorInfo.hqFlag}" 
										disabled="true" style="width:120px;">
		                					<f:selectItems value="#{semmmm001Bean.hqBranchList}" />
		                				</h:selectOneMenu>
		                				&nbsp;
		                				<h:outputText value="#{jspMsg['label.branch.code']}" styleClass="" />
		                				<h:inputText id="vendorInfoBranchNo" value="#{semmmm001Bean.vendorInfo.branchNo}" 
										disabled="true" style="width:50px;" styleClass="" />
									</td>
								</tr>
								<tr style="display: none;">
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
		                				<h:outputText value="W/H Type : " styleClass="ms7" />
		                				<h:inputText id="vendorInfoWhtType" value="#{semmmm001Bean.vendorInfo.whtType}" 
										disabled="true"  
										maxlength="20" style="width:30px; text-align:center;" styleClass="" />
										&nbsp;
		                				<h:outputText value="W/H Code : " styleClass="ms7" />
		                				<h:inputText id="vendorInfoWhtCode" value="#{semmmm001Bean.vendorInfo.whtCode}" 
										disabled="true"  
										maxlength="20" style="width:30px; text-align:center;" styleClass="" />
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
								<tr style="display: none;">
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value=""/>
									</td>
									<td style="width:30%;">
										<h:selectBooleanCheckbox id="chkVAT" 
										value="#{semmmm001Bean.vendorInfo.chkVAT}" style="vertical-align:bottom; margin-left:-3px;" 
										disabled="true" />
				                		<h:outputText value="#{jspMsg['label.vendor.vat.registration']}" styleClass="ms7" style="padding-left:2px;" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.vendor.flow.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="vendorInfoVendorFlowStatus" value="#{semmmm001Bean.vendorInfo.vendorFlowStatus}" 
										disabled="true" style="">
		                					<f:selectItems value="#{semmmm001Bean.vendorFlowStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				
				<!-- payee info panel >> -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.payee.info']}"/></f:facet>
					
					<!-- payee info -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.expense.type']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="payeeExpenseType" value="#{semmmm001Bean.payeeInfo.expenseType}" 
										 style="width:150px;" 
										 disabled="true">
		                					<f:selectItems value="#{semmmm001Bean.expenseTypeList}" />
		                				</h:selectOneMenu>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Expense Effective Date : "/>
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
									   	   disabled="true"
									   	   styleClass="ms7">
										</rich:calendar>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Payee Code : "/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInPayeeCode" value="#{semmmm001Bean.payeeInfo.payeeCode}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="Payee Type : "/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="payeeInfoPayeeType" value="#{semmmm001Bean.payeeInfo.payeeType}" 
										disabled="true" style="width:120px;">
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
										disabled="true" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.citizen.id']} :"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoIdCard" value="#{semmmm001Bean.payeeInfo.idCard}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.personl.tax.id']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoTaxId" value="#{semmmm001Bean.payeeInfo.taxId}" 
										disabled="true"  
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.address1']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoAddress1" value="#{semmmm001Bean.payeeInfo.payeeAddress1}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.address2']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoAddress2" value="#{semmmm001Bean.payeeInfo.payeeAddress2}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_tambol']}"/>
									</td>
									<td style="width:30%;">
										<a4j:region>
										<h:panelGroup id="payeeInfo_addrGroup1">
											<h:selectOneMenu id="payeeInfoTambol" value="#{semmmm001Bean.payeeInfo.tambol}" 
											disabled="true" 
											rendered="#{semmmm001Bean.payeeInfo.chkTambolOther == 'false'}" 
											styleClass="" style="width:120px;">
												<f:selectItems value="#{semmmm001Bean.payeeInfo.tambolList}"/>
											</h:selectOneMenu>
											
											<h:inputText id="payeeInfoTambolOther" value="#{semmmm001Bean.payeeInfo.tambolName}" 
											rendered="#{semmmm001Bean.payeeInfo.chkTambolOther}"
											disabled="true"
											maxlength="150" style="width:200px;" styleClass="" />
											
											<h:selectBooleanCheckbox id="payeeInfo_chkTambolOther" 
											value="#{semmmm001Bean.payeeInfo.chkTambolOther}"
											disabled="true"
											onclick="payeeInfo_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
											<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
											
											<a4j:jsFunction name="payeeInfo_RenderTambolNameJS" 
											reRender="payeeInfo_addrGroup1, payeeInfoTambol, payeeInfoTambolOther" 
											action="#{semmmm001Action.renderedTextFieldAddress}">
												<a4j:actionparam  name="fieldAddrParam" value="PY_TAMBOL"/>
											</a4j:jsFunction>
										</h:panelGroup>
										</a4j:region>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_amphur']}"/>
									</td>
									<td style="width:30%;">
										<a4j:region>
										<h:panelGroup id="payeeInfo_addrGroup2">
											<h:selectOneMenu id="payeeInfoAmphur" value="#{semmmm001Bean.payeeInfo.amphur}" 
											disabled="true" 
											rendered="#{semmmm001Bean.payeeInfo.chkAmphurOther == 'false'}" 
											onchange="payeeInfo_GetTambolListJS();" styleClass="" style="width:120px;">
												<f:selectItems value="#{semmmm001Bean.payeeInfo.amphurList}"/>
											</h:selectOneMenu>
											
											<a4j:jsFunction name="payeeInfo_GetTambolListJS" reRender="payeeInfoTambol" 
											action="#{semmmm001Action.doSetPayeeLocation}">
											</a4j:jsFunction>
											
											<h:inputText id="payeeInfoAmphurOther" value="#{semmmm001Bean.payeeInfo.amphurName}" 
											rendered="#{semmmm001Bean.payeeInfo.chkAmphurOther}"
											disabled="true"
											maxlength="150" style="width:200px;" styleClass="" />
											
											<h:selectBooleanCheckbox id="payeeInfo_chkAmphurOther" 
											value="#{semmmm001Bean.payeeInfo.chkAmphurOther}"
											disabled="true"
											onclick="payeeInfo_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
											<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
											
											<a4j:jsFunction name="payeeInfo_RenderAmphurNameJS" 
											reRender="payeeInfo_addrGroup1, payeeInfo_addrGroup2, payeeInfoAmphur, 
											payeeInfoAmphurOther, payeeInfoTambol, payeeInfoTambolOther" 
											action="#{semmmm001Action.renderedTextFieldAddress}">
												<a4j:actionparam  name="fieldAddrParam" value="PY_AMPHUR"/>
											</a4j:jsFunction>
										</h:panelGroup>
										</a4j:region>
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
		                				<a4j:region>
											<h:selectOneMenu id="payeeInfoProvince" value="#{semmmm001Bean.payeeInfo.province}" 
											disabled="true" 
											onchange="payeeInfo_GetAmphurListJS();" styleClass="" style="width:120px;">
												<f:selectItems value="#{semmmm001Bean.payeeInfo.provinceList}"/>
											</h:selectOneMenu>
											
											<a4j:jsFunction name="payeeInfo_GetAmphurListJS" reRender="payeeInfoAmphur, payeeInfoTambol" 
											action="#{semmmm001Action.doSetPayeeLocation}">
											</a4j:jsFunction>
											
											<h:selectBooleanCheckbox id="payeeInfo_chkLocalDepartment" 
											value="#{semmmm001Bean.payeeInfo.chkLocalDepartment}"
											disabled="true"
											onclick="" style="margin:0px 5px 0px 5px; vertical-align:top;" />
											<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
										</a4j:region>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_post.code']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoPostCode" value="#{semmmm001Bean.payeeInfo.postCode}" 
										disabled="true" 
										maxlength="5" style="width:116px;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.contact.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoContractName" value="#{semmmm001Bean.payeeInfo.contactName}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.telephone']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoTelephone" value="#{semmmm001Bean.payeeInfo.telephone}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.mobile']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoMobile" value="#{semmmm001Bean.payeeInfo.mobileNo}" 
										disabled="true" 
										maxlength="13" style="width:70%; height : 21px;" styleClass="" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.fax']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoFax" value="#{semmmm001Bean.payeeInfo.fax}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td colspan="3" style="text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.email']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="payeeInfoEmail" value="#{semmmm001Bean.payeeInfo.email}" 
										disabled="true" 
										maxlength="13" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="payeeInfoRemark" value="#{semmmm001Bean.payeeInfo.remark}" 
										disabled="true" style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
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
										disabled="true">
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['desc.pay.type.check']}" 
												itemDisabled="true" />
											<f:selectItem itemValue="02" itemLabel="#{jspMsg['desc.pay.type.transfer']}" 
												itemDisabled="true" />
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
				</rich:panel>
				<!-- payee info panel << -->
				
			</h:panelGrid>
			<!-- group[1] << -->
			
			<rich:spacer rendered="#{semmmm001Bean.visiblePnlContractInfo}" />
			
			<!-- group[2] >> -->
			<h:panelGrid id="bookbankPayeeInfo" width="98%" style="border:solid 1px gray;">
			
				<!-- button bookbankPayeeInfo -->
				<h:panelGrid id="groupBookbankPayeeInfoButton" width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td style="width:70%;">
									<a4j:commandButton id="btnNewBookbankPayee" value="New Bookbank Payee" 
									disabled="#{semmmm001Bean.disableBtnNewAllPB}"
									rendered="#{semmmm001Bean.renderedBtnNewAllPB}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="oppContent" 
									style="padding-left: 3px;width:120px;">
										<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doNewBBPayee" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="" />
										<a4j:actionparam name="btnActionType" value="N" />
									</a4j:commandButton>
									
									<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnNewAllPB}"/>
									
									<a4j:commandButton id="btnEdtBookbankPayeeData" value="Edit Data" 
									disabled="#{semmmm001Bean.disableBtnEditDataPayeeBB}" 
									rendered="#{semmmm001Bean.renderedBtnEditDataPayeeBB}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="oppContent"
					           	 	style="padding-left: 3px;width:110px;">
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doEditPayeeBBData" />
										<a4j:actionparam name="btnActionType" value="ED" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5" rendered="#{semmmm001Bean.renderedBtnEditDataPayeeBB}"/>
									
									<a4j:commandButton id="btnEdtBookbankPayee" value="Edit Bookbank Payee" 
									disabled="#{semmmm001Bean.disableBtnEditBookbankPayee}" 
									rendered="#{semmmm001Bean.renderedBtnEditBookbankPayee}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="oppContent"
					           	 	style="padding-left: 3px;width:110px;">
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doEditBBPayeeByBookbankPayeeId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
										<a4j:actionparam name="btnActionType" value="E" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
					           		<a4j:commandButton id="btnChngeBookbankPayee" value="Change Bookbank Payee" 
					           		disabled="#{semmmm001Bean.disableBtnChangePB}" 
					           		rendered="#{semmmm001Bean.renderedBtnChangePB}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="oppContent"
					           	 	style="padding-left: 3px;width:135px;">
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doChangeBBPayee" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
										<a4j:actionparam name="btnActionType" value="C" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
					           		<a4j:commandButton id="btnSndToMng" value="Send To Manager" 
					           		disabled="#{semmmm001Bean.disableBtnSendManagerPB}" 
					           		rendered="#{semmmm001Bean.renderedBtnSendManagerPB}"
					           	 	action="#{navAction.navi}" styleClass="rich-button" 
									onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
					           	 	reRender="oppContent, dtbContractList" 
									oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
									style="padding-left: 5px;width:110px;">
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doSendToMNGByBookbankPayeeId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
					           		</a4j:commandButton>
					           		
					           		<rich:spacer width="5"/>
						           		
						           		<a4j:commandButton id="btnExpBtchVD" value="Export Batch" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableExportBatchPB}" 
						           	 	rendered="#{semmmm001Bean.renderedExportBatchPB}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="frmBookbankPayeeInfo, pnlShowReportPayeeBookbankToLeaderExcel"
						           	 	style="padding-left: 5px; width:85px;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="EXPORT_BATCH_PB" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5"/>
						           		
						           		<a4j:commandButton id="btnClearBatch" value="#{jspMsg['btn.clearBatch']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableClearBatchPB}" 
						           	 	rendered="#{semmmm001Bean.renderedClearBatchPB}"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
						           	 	style="padding-left: 5px;width:90px;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CLEAR_BATCH" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
											<a4j:actionparam name="bookbankPayeeId" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="false" />
						           		
						           		<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']} #{jspMsg['btn.payeeBookbank']}" styleClass="rich-button" 
						           	 	action="#{navAction.navi}" disabled="#{semmmm001Bean.disableCancelPB}" 
						           	 	rendered="false"
						           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						           	 	reRender="oppContent, frmResultSearch, dtbResultList"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
						           	 	style="padding-left: 5px;width:180px;">
							           		<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
											<a4j:actionparam name="btnEvent" value="CANCEL" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
											<a4j:actionparam name="bookbankPayeeId" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
						           		</a4j:commandButton>
						           		
						           		<rich:spacer width="5" rendered="#{semmmm001Bean.disableCancel}"/>
					           		
					           		<a4j:commandButton id="btnConfirm" value="#{jspMsg['btn.confirm']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}"
					           	 	rendered="#{semmmm001Bean.renderedConfirmPB}"
					           	 	onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
					           	 	reRender="oppContent, frmResultSearch, dtbResultList"
					           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
						           		<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doManageBtn" />
										<a4j:actionparam name="btnEvent" value="CONFIRM" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
										<a4j:actionparam name="vendorId" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="typeFlag" value="PB" />
					           		</a4j:commandButton>
					           	</td>
					           	<td style="width:30%; text-align:right;">
					           		<a4j:commandButton id="btnDltePayee" value="Delete Bookbank #{jspMsg['btn.out.of']} Payee" 
					           		disabled="#{semmmm001Bean.disableDeletePB}" 
					           		rendered="#{semmmm001Bean.renderedDeletePB}"
					           	 	action="#{navAction.navi}" styleClass="rich-button" 
									onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
					           	 	reRender="oppContent, dtbContractList" 
									oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
									style="padding-left: 5px;width:190px;">
					           			<a4j:actionparam name="navModule" value="mm" />
										<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
										<a4j:actionparam name="moduleWithNavi" value="mm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
										<a4j:actionparam name="methodWithNavi" value="doDeleteBBPayeeByBookbankPayeeId" />
										<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
										<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
										<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
										<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
										<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
										<a4j:actionparam name="vendorMapPayeeId" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
					           		</a4j:commandButton>
					           	</td>
					        </tr>
					    </table>
					</h:panelGroup>
				</h:panelGrid>
			
				<!-- bookbank payee list panel >> -->
				<rich:panel id="bookbankpayeeInfoPanel">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.info']} Bookbank Payee"/></f:facet>
					
					<!-- bookbank payee info panel -->
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="bookbankPayeeInfoAccountType" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}"
										value="#{semmmm001Bean.bookbankPayeeInfo.accountType}" style="width:100px;">
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
										<h:inputText id="bookbankPayeeInfoBankCode" value="#{semmmm001Bean.bookbankPayeeInfo.bankCode}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}"
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
										onblur="callFillinBookbankPayeeInfoJS();"  style="width:96px;" />
										
										<a4j:jsFunction name="callFillinBookbankPayeeInfoJS" action="#{semmmm001Action.doFillinBookbankPayeeInfo}" 
										reRender="bookbankpayeeInfoPanel, bookbankPayeeInfoBankName, bookbankPayeeInfoBankBranch, bookbankPayeeInfoProvince" >
										</a4j:jsFunction>
										
										<rich:spacer width="2"></rich:spacer>
	                                    <a4j:commandButton id="btnPopupSearchBankCode" 
	                                    oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
	                                    value="..." styleClass="rich-button"
	                                    action="#{navAction.navi}" reRender="popupFrmSelectBank, frmSelectBank" 
	                                    disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}">
		                                    <a4j:actionparam name="navModule" value="mm" />
		                                    <a4j:actionparam name="navProgram" value="SEMMMM001-5" />
		                                    <a4j:actionparam name="moduleWithNavi" value="mm" />
		                                    <a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
		                                    <a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
	                                    </a4j:commandButton>
	                                    
	                                    <rich:spacer width="2"></rich:spacer>
	                                    
	                                    <a4j:commandButton id="btnNew" value="New" styleClass="rich-button"
										 action="#{navAction.navi}" reRender="panel_popupNewOrUpdateBankMaster" 
										 oncomplete="#{rich:component('panel_popupNewOrUpdateBankMaster')}.show(); return false; "
										 disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}">
										 	<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
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
										<%--
										<h:selectOneMenu id="bookbankPayeeInfoBankName" value="#{semmmm001Bean.bookbankPayeeInfo.bankId}" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}" 
										style="">
		                					<f:selectItems value="#{semmmm001Bean.bankList}" />
		                				</h:selectOneMenu>
		                				--%>
		                				<h:inputText id="bookbankPayeeInfoBankName" value="#{semmmm001Bean.bookbankPayeeInfo.bankName}" 
										disabled="true" maxlength="250" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bookbankPayeeInfoBankBranch" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}"
										value="#{semmmm001Bean.bookbankPayeeInfo.bankBranch}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bookbankPayeeInfoProvince" 
										disabled="true"
										value="#{semmmm001Bean.bookbankPayeeInfo.province}" style="width:120px;">
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
										<h:inputText id="bookbankPayeeInfoAccountNo"
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}"
										onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
										value="#{semmmm001Bean.bookbankPayeeInfo.accountNo}" 
										style="width:70%;" maxlength="#{semmmm001Bean.accountNoMaxLengthPayee}"/>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bookbankPayeeInfoAccountName" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}"
										value="#{semmmm001Bean.bookbankPayeeInfo.accountName}" style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bookbankPayeeInfoRemark" 
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}"
										value="#{semmmm001Bean.bookbankPayeeInfo.remark}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bookbankPayeeInfoBookbankStatus" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankStatus}" 
										disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent) or 
										semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId == null}" style="">
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
										<a4j:commandButton id="btnChkBookbank" value="Check BookBank Payee" styleClass="rich-button" 
										rendered="false"
										disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditBookbankPayeeContent}" 
										style="margin-left:5px;" 
	           	 						oncomplete="#{rich:component('mmm001PopUpCommon_semSapBookbankList')}.show(); return false;"
										action="#{semmmm001Action.doChkBookbank}" reRender="oppContent"> 
											<a4j:actionparam name="panelParam" value="BOOKBANK_PAYEE"/>
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bookbankPayeeInfoBookbankFlowStatus" 
										value="#{semmmm001Bean.bookbankPayeeInfo.bookbankFlowStatus}" 
										disabled="true" style="">
		                					<f:selectItems value="#{semmmm001Bean.bookbankFlowStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
					
					<!-- button info -->
					<h:panelGrid columns="3" width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
											<h:outputText value="#{jspMsg['label.payeebookbankbatch']}" styleClass="contentform"
											style="vertical-align:top;"/>
									</td>
									<td style="width:30%;" class="ms7" >
											<h:outputText value="#{semmmm001Bean.bookbankPayeeInfo.payeeBookbankBatch}"
											style="vertical-align:top;"/>
										</td>
									<td style="width:100%; text-align:right;">
										<a4j:commandButton id="btnBookbankPayeeHistoryPopup" 
										value="Bookbank Payee History" styleClass="rich-button"
										action="#{semmmm001Action.doBookbankPayeeHistory}" 
										disabled="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId == null}" 
										reRender="txtNavProgram, oppContent"  rendered="false"
										oncomplete="#{rich:component('mmm001PopUpHistory5')}.show();onTopPage();">
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
											<a4j:actionparam name="historyPage" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnPayeeHistory" value="Bookbank Payee History" 
											styleClass="rich-button" disabled="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId == null}"
											action="#{navAction.navi}" reRender="txtNavProgram, oppContent">
												<a4j:actionparam name="navModule" value="mm" />
												<a4j:actionparam name="navProgram" value="SEMMMM001HISTORY5" />
												<a4j:actionparam name="moduleWithNavi" value="mm" />
												<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
												<a4j:actionparam name="methodWithNavi" value="doBookbankPayeeHistory" />
												<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
												<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
												<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
												<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.bookbankPayeeInfo.bookbankPayeeId}" />
												<a4j:actionparam name="historyPage" value="PB" />
											</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>	
				
				<!-- bookbank payee list panel (compare content) >> -->
				<rich:panel id="bookbankPayeeInfo_compareContent" style="background-color:#FFFFCC;" 
				rendered="#{semmmm001Bean.renderedPnlCmpBookbankPayeeInfo and semmmm001Bean.bookbankPayeeInfo.saveFlag == 'C'}">
					<f:facet name="header"><h:outputText value="#{jspMsg['header.info']} Bookbank Payee (Draft)"/></f:facet>
					
					<h:panelGrid width="100%"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.type']}"/>
									</td>
									<td colspan="3">
										<h:selectOneMenu id="bookbankPayeeInfoCmpAccountType" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.accountType}" 
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
										<h:inputText id="bookbankPayeeInfoCmpBankCode" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.bankCode}" 
										onblur="callFillinBookbankPayeeInfoCmpJS();"  style="width:96px;" />
										
										<a4j:jsFunction name="callFillinBookbankPayeeInfoCmpJS" action="#{semmmm001Action.doFillinBookbankPayeeInfoCmp}" 
										reRender="bookbankPayeeInfoCmpBankName, bookbankPayeeInfoCmpBankBranch, bookbankPayeeInfoCmpProvince, bookbankPayeeInfoCmpAccountNo" >
										</a4j:jsFunction>
										
										<rich:spacer width="2"></rich:spacer>
	                                    <a4j:commandButton id="btnPopupSearchBankCodeCmp" 
	                                    oncomplete="#{rich:component('popupFrmSelectBank')}.show(); return false"
	                                    value="..." styleClass="rich-button"
	                                    action="#{navAction.navi}" reRender="popupFrmSelectBank, frmSelectBank" >
		                                    <a4j:actionparam name="navModule" value="mm" />
		                                    <a4j:actionparam name="navProgram" value="SEMMMM001-5" />
		                                    <a4j:actionparam name="moduleWithNavi" value="mm" />
		                                    <a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
		                                    <a4j:actionparam name="methodWithNavi" value="initSearchBankCode" />
	                                    </a4j:commandButton>
	                                    
	                                    <rich:spacer width="2"></rich:spacer>
	                                    
	                                    <a4j:commandButton id="btnNewCmp" value="New" styleClass="rich-button"
										 action="#{navAction.navi}" reRender="frmError, pnlSearchCriteria, pnlSearchResult, panel_popupNewOrUpdateBankMaster" 
										 oncomplete="#{rich:component('panel_popupNewOrUpdateBankMaster')}.show(); return false; ">
										 	<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
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
										
		                				<h:inputText id="bookbankPayeeInfoCmpBankName" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.bankName}" 
										disabled="true" maxlength="250" style="width:70%;" styleClass="" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bank.branch']}"/>
									</td>
									<td style="width:30%;">
										<h:inputTextarea id="bookbankPayeeInfoCmpBankBranch" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.bankBranch}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.th_province']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bookbankPayeeInfoCmpProvince" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.province}" 
										style="width:120px;" disabled="true">
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
										<h:inputText id="bookbankPayeeInfoCmpAccountNo" 
										value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.accountNo}"
										style="width:70%;" maxlength="#{semmmm001Bean.accountNoMaxLengthPayeeCmp}" />
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="* " style="font-style:bold; color:red;" />
										<h:outputText value="#{jspMsg['label.account.name']}"/>
									</td>
									<td style="width:30%;">
										<h:inputText id="bookbankPayeeInfoCmpAccountName" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.accountName}" 
										style="width:70%;" />
									</td>
								</tr>
								<tr>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.remark']}"/>
									</td>
									<td width="30%;">
										<h:inputTextarea id="bookbankPayeeInfoCmpRemark" value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.remark}" 
										style="width:70%; font-size:13px; font-family: Arial, Verdana, sans-serif;"></h:inputTextarea>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bookbankPayeeInfoCmpBookbankStatus" 
										value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.bookbankStatus}" 
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
										
										<a4j:commandButton id="btnChkBookbankCmp" value="..." styleClass="rich-button" 
										style="margin-left:5px;" 
	           	 						oncomplete="#{rich:component('mmm001PopUpCommon_semSapBookbankList')}.show(); return false;"
										action="#{semmmm001Action.doChkBookbank}" reRender="oppContent"
										rendered="false"> 
											<a4j:actionparam name="panelParam" value="BOOKBANK_PAYEE"/>
										</a4j:commandButton>
									</td>
									<td style="width:20%; text-align:right;" class="ms7">
										<h:outputText value="#{jspMsg['label.bookbank.flow.status']}"/>
									</td>
									<td style="width:30%;">
										<h:selectOneMenu id="bookbankPayeeInfoCmpBookbankFlowStatus" 
										value="#{semmmm001Bean.bookbankPayeeInfoCmpObj.bookbankFlowStatus}" 
										disabled="true" style="">
		                					<f:selectItems value="#{semmmm001Bean.bookbankFlowStatusList}" />
		                				</h:selectOneMenu>
									</td>
								</tr>
							</table>
						</h:panelGroup>
					</h:panelGrid>
				</rich:panel>
				
				<!-- button info -->
					<h:panelGrid columns="3" width="100%">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td style="width:100%;">
										<a4j:commandButton id="btnSaveBookbankPayeeInfo" reRender="voppContent, mmm001PopUpCommon_retStatus, dtbContractList, vendorInfo, vendorInfo_compareContent, 
								        panelTab, panelTabAddrCmp, btnPayee, pnlExpense, pnlContractList, bankInfo,mmm001PopUpCommon_controllerBtnSave"
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}" 
										action="#{semmmm001Action.doValidateBBPayeeSaveDraft}"
										oncomplete="#{rich:component('mmm001PopUpCommon_controllerBtnSave')}.show(); return false;">	
												
										</a4j:commandButton>
										<rich:spacer width="5"/>		
									
										<%-- 2017/08/10 .. callback function request >> --%>
																				
										<a4j:commandButton id="btnCancelPayeeBookbankDetail" reRender="txtNavProgram, oppContent"
										value="#{jspMsg['btn.cancel']}" styleClass="rich-button"
										disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N'}" action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doBBPayeeCancel" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPB}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPB}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPB}" />
											<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.bookbankPayeeIdPB}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPB}" />
											<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
										</a4j:commandButton>
										
										<a4j:jsFunction name="callValidateBBPayeeJS" 
										action="#{semmmm001Action.doValidateBBPayeeSaveDraft}"
										oncomplete="if(confirm('#{semmmm001Bean.retResultObj.resultMessage}'))
													{ callSaveBBPayeeJS(); } else { return false; }">
										</a4j:jsFunction>
										
										<a4j:jsFunction name="callSaveBBPayeeJS" 
										action="#{navAction.navi}"
						           	 	oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;"
						           	 	reRender="txtNavProgram, oppContent">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doSaveBBPayeeInfo" />
										</a4j:jsFunction>
										<%-- 2017/08/10 .. callback function request << --%>
										
										<%-- 2017/08/10 --%>
										<%--
										<a4j:commandButton id="btnSaveBookbankPayeeInfo" 
										value="#{jspMsg['btn.save']}" styleClass="rich-button"
										action="#{navAction.navi}" disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}"
										onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
					           	 		reRender="txtNavProgram, oppContent" oncomplete="#{rich:component('mmm001PopUpCommon_retStatus')}.show(); return false;">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="doSaveBBPayeeInfo" />
										</a4j:commandButton>
										--%>
										
										<rich:spacer width="5"/>
										
										<a4j:commandButton id="btnCancelPayeeBookbankDetailBack" reRender="txtNavProgram, oppContent"
										value="#{jspMsg['btn.back']}" styleClass="rich-button" title="BC"
										rendered="#{semmmm001Bean.disableBtnSaveBookbankPayee == false and semmmm001Bean.bookbankPayeeInfo.saveFlag != 'N'}"
										disabled="#{semmmm001Bean.disableBtnSaveBookbankPayee}" action="#{semmmm001Action.doInitValidateBack}" 
										oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-5" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doBBPayeeCancel" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.semmmm001ReqParam.contractNoPB}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorIdPB}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.payeeIdPB}" />
											<a4j:actionparam name="bookbankPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.bookbankPayeeIdPB}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.semmmm001ReqParam.vendorMapPayeeIdPB}" />
											<a4j:actionparam name="actionIdBackAfterSave" value="CANCEL_VENDOR" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B1"
						           	 	rendered="#{(semmmm001Bean.fromVendorFlag and semmmm001Bean.fromPayeeFlag == false)  
						           	 	and (semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N')}"
						           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackPayee" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B2"
						           	 	rendered="#{semmmm001Bean.fromPayeeFlag
						           	 	and (semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N')}"
						           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackTodo" value="#{jspMsg['btn.back']}" styleClass="rich-button" title="B3"
										action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" 
										rendered="#{(semmmm001Bean.renderedBtnTodoBack and semmmm001Bean.fromPayeeFlag == false) 
										and (semmmm001Bean.disableBtnSaveBookbankPayee or semmmm001Bean.bookbankPayeeInfo.saveFlag eq 'N')}"
										oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackVD == 'false'})changePagePB();">
											<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
											<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
											<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
											<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
											<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
											<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackOth" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B4"
						           	 	rendered="false"
						           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B5"
						           	 	rendered="false"
						           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
											
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackPayeeInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B6"
						           	 	rendered="false"
						           	 	oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
											
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-4" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="payeeIdParam" value="#{semmmm001Bean.payeeInfo.payeeId}" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackTodoInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
										action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B7"
										rendered="false"
										oncomplete="if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'true'})
										#{rich:component('mmm001PopUpCommon_controllerBtnBack')}.show();
										if(#{semmmm001Bean.renderedPopupConfirmBackPB == 'false'})changePagePB();">
											
											<a4j:actionparam name="navModule" value="#{semmmm001Bean.navModuleBack}" />
											<a4j:actionparam name="navProgram" value="#{semmmm001Bean.navProgramBack}" />
											<a4j:actionparam name="moduleWithNavi" value="#{semmmm001Bean.navModuleBack}" />
											<a4j:actionparam name="actionWithNavi" value="#{semmmm001Bean.actionWithNaviBack}" />
											<a4j:actionparam name="methodWithNavi" value="#{semmmm001Bean.methodWithNaviBack}" />
											<a4j:actionparam name="todoManagerFlag" value="#{semmmm001Bean.todoManagerFlag}" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="moduleType" value="PB" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnBackOthInit" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
						           	 	action="#{semmmm001Action.doInitValidateBack}" reRender="txtNavProgram, oppContent" title="B8"
						           	 	rendered="false">
										
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="contractNoParam" value="#{semmmm001Bean.contractInfo.contractNo}" />
											<a4j:actionparam name="vendorIdParam" value="#{semmmm001Bean.vendorInfo.vendorId}" />
											<a4j:actionparam name="actionId" value="BACK_FROM_BOOKBANK_PAYEE" />
											<a4j:actionparam name="vendorMapPayeeIdParam" value="#{semmmm001Bean.vendorInfo.vendorMapPayeeId}" />
											<a4j:actionparam name="moduleType" value="PB" />
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
			<!-- group[2] << -->
			
			<rich:spacer />
			
			<!-- group[3] >> -->
			<h:panelGrid id="contractInfo" width="98%" style="border:solid 1px gray;" rendered="false">
				<!-- contact list panel >> -->
				<rich:panel>
					<f:facet name="header"><h:outputText value="#{jspMsg['header.contract.list']}"/></f:facet>
					
					<center>
					<div id="tabContact" style="width:1200px; overflow:scroll; border:1px solid e0e0e0;"> 
						
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
							
							<rich:column style="" title="" sortBy="#{contractObj.dataObj.effectiveDtStr}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effective.date']}" styleClass="contentform"/>
								</f:facet>
								
								<div align="center">
									<h:outputText value="#{contractObj.dataObj.effectiveDtStr}" styleClass="contentform"  />
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
									<rich:column colspan="8">
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
					</div>
					</center>
				</rich:panel>
				<!-- contract list panel << -->
			</h:panelGrid>
			<!-- group[3] << -->
			
			<!-- end panel tab -->
					<h:panelGrid  id="pnlPayeebookbankLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
						<h:panelGroup rendered="true">
							<table width="100%">
								<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtCreateBy" value="#{semmmm001Bean.bookbankPayeeInfo.createBy}" 
										readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldCreateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
										value="#{semmmm001Bean.bookbankPayeeInfo.createDt}" 
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
										<h:inputText id="txtUpdateBy" value="#{semmmm001Bean.bookbankPayeeInfo.updateBy}" 
										readonly="true" disabled="true" size="30" maxlength="50"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldUpdateDate" locale="th" 
										datePattern="dd/MM/yyyy HH:mm:ss" 
										value="#{semmmm001Bean.bookbankPayeeInfo.updateDt}" 
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
	<a4j:form id="frmShowReportExcelPayeeBookbankDetail_">
					
					
					<h:panelGrid id="pnlShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowReportPayeeBookbankToLeaderExcel" rendered="#{semmmm001Bean.displayReport}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowReportPayeeBookbankToLeaderExcel" style="height:0px;width:0px;display:none;" action="#{semmmm001Action.doExportPayeeBookbankToLeader}"  />								
							<script>document.getElementById('incContent:frmShowReportExcelPayeeBookbankDetail_:bthShowReportPayeeBookbankToLeaderExcel').click();</script>
						</h:panelGroup>							
					</h:panelGrid>
		
	</a4j:form>
</h:panelGrid>

<a4j:include viewId="../../pages/mm/semmmm001PopUpCommon.jsp"/>