<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel006" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.PRPostpaid']}"/> 
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<a4j:form id="frmAddPaymentPRPostpaid">
		<h:panelGrid columnClasses="gridContent" width="95%">
			<h:panelGroup>
				<table width="100%">
				<tr>
				<td width="50%" align="left">
					
				</td>
				<td width="50%" align="right" valign="bottom">
					<table id="tblButton">
					<tr>
					<td>
						<a4j:commandButton id="btnBack" value="Back" styleClass="rich-button" 
						rendered="#{!semmel006Bean.comeFromPage8}" action="#{navAction.navi}" reRender="oppContent" >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doBackSearchPage" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancel2"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage8}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
						<a4j:commandButton id="btnCancel9"
							value="Back" styleClass="rich-button"
							action="#{navAction.navi}" reRender="oppContent"
							rendered="#{semmel006Bean.comeFromPage9}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
						</a4j:commandButton>
	           		</td>
	           		<td>

						
						<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
						action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode}" 
						reRender="oppContent,pnlPaymentList,frmAddPaymentPRPostpaid"   >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doSavePRPostpaid" />
						</a4j:commandButton>							
						
						
	           		</td>	           		
	           		<td>
						<a4j:commandButton id="btnCancel" value="Cancel" styleClass="rich-button" 
						action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode  || semmel006Bean.comeFromPage8}" reRender="oppContent,frmAddPaymentPRPostpaid"   >
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initPaymentPRPostpaid" />
						</a4j:commandButton>						
	           		</td>
	           		</tr>
	           		</table>
           		</td>
           		</tr>
				</table>
				</h:panelGroup>
		</h:panelGrid>
		
		
		<!-- 1.   Start Contract Info -->
				
				<h:panelGrid width="95%">
					<rich:panel id="contractInfo">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
							
									<tr>
										<td align="right" width="25%">
											
										</td>
										<td width="25%">
										
				                		<a4j:commandButton id="btnPopupSearchSite"  
				                		oncomplete="#{rich:component('popupSearchSite')}.show(); return false"
										disabled="#{semmel006Bean.viewMode || semmel006Bean.disableSearchSite}"
										value="#{jspMsg['btn.searchSite']}" styleClass="rich-button"  
										reRender="oppContent,meterDetail,popupSearchSite,popupFrmSearch,pnlPopupSearchResult,expenseDetail,btnElGroup"
					            		action="#{navAction.navi}" style="width:150px;">
					            		<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006" />
										<a4j:actionparam name="moduleWithNavi" value="el" />	
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006-5"/>									
										<a4j:actionparam name="methodWithNavi" value="initPopupSearchSitePR" />
			            				</a4j:commandButton>
			            				
										</td>	
										<td align="right" width="25%">											
											
										</td>
										<td width="25%">
											
										</td>																				
									</tr>	

										<tr>
										<td align="right" width="25%">				
																			
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.company}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">					
																	
											<h:outputText value="#{jspMsg['label.oldContractNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.oldContractNo}" styleClass="ms7"/>
										</td>																				
									</tr>										
													
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<a4j:commandLink id="hypPopApproveType" value= "#{semmel006Bean.popupSiteCriteria.contractNo}" 
												oncomplete="#{rich:component('popupEditDetailHistory')}.show(); return false"
												 action="#{navAction.navi}" style="width:100" reRender="popupFrmEditPeriod" 
												 rendered="true">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="#{semmel006Bean.pageFrom}" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupEditHistory"/>
												<a4j:actionparam name="methodWithNavi" value="initPopup" />
												<a4j:actionparam name="sIdHistory" value="#{semmel006Bean.popupSiteCriteria.siteInfoId}"  />
											</a4j:commandLink>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.electricUseTypeDisplay}" styleClass="ms7"/>
										</td>																				
									</tr>
									
																														
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.contractStartDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.contractStartDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>	
										<td align="right" width="25%">										
											<h:outputText value="#{jspMsg['label.contractEndDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.contractEndDtTH}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>																				
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.siteName}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.eAreaCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.eAreaCode}" styleClass="ms7"/>
										</td>																				
									</tr>
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.siteStatusDisplay}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.networkStatus']}" styleClass="#{semmel006Bean.styleClassName}"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.networkStatusDisplay}" styleClass="#{semmel006Bean.styleClassName}"/>
										</td>																				
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.locationId}" styleClass="ms7"/>
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.locationCode}" styleClass="ms7"/>
										</td>																				
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.elGroup']} :" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.popupSiteCriteria.ownerGroupName}" styleClass="ms7"/>
											<h:inputHidden value="#{semmel006Bean.popupSiteCriteria.ownerGroup}"/>
										</td>	
										<td align="right" width="25%">	
											<rich:spacer width="5"></rich:spacer>										
										</td>
										<td width="25%">
											<rich:spacer width="5"></rich:spacer>
										</td>																				
									</tr>	
																	
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
					
		<!--  End Contract Info -->
		
		

		<!--  2.  Start Meter Detail -->
				
				<h:panelGrid width="95%">
					<rich:panel id="meterDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterDetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td width="25%" align="left" colspan="3">
											<h:selectOneMenu id ="meterListId" value="#{semmel006Bean.popupSiteCriteria.meterId}"  
											disabled="#{semmel006Bean.meterIdDisable||semmel006Bean.viewMode}" 
											style="width:120px;">
												<f:selectItems value="#{semmel006Bean.meterIdList}"/>
												<a4j:support event="onchange" action="#{semmel006Action.doChangeMeter}" 
												reRender="meterDetail,expenseDetail,paymentMethodId,paymentTypeId,paymentPostpaidInfo"/>
											</h:selectOneMenu>
										</td>										
									</tr>	
										<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.refMeterId']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.meterInfo.referMeterId}" styleClass="ms7"/>
										</td>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.previousKhw']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.meterInfo.lastKWHTotal}" styleClass="ms7"  disabled="true">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>													
										</td>											
									</tr>	
										<tr>
										<td align="right" width="25%">
											
											<h:outputText value="#{jspMsg['label.pMeterAddress']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.meterInfo.pMeterAddress}" styleClass="ms7"  disabled="true"/>
										</td>		
																
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.previousUnitPrice']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.meterInfo.lastUnitAmt}" styleClass="ms7"  disabled="true">
											<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td>											
									</tr>	
										<tr>
										<td align="right" width="25%">
											
											<h:outputText value="#{jspMsg['label.pMeterStatus']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectOneRadio value="#{semmel006Bean.meterInfo.pMeterStatus}"  styleClass="ms7" disabled="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="ON" itemLabel="ON" />
					                				<f:selectItem itemValue="OFF" itemLabel="OFF" />					                				
					                		</h:selectOneRadio>		
										</td>		
																
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.pMeterVATType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneRadio value="#{semmel006Bean.meterInfo.lastUnitVatType}"  styleClass="ms7" disabled="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />				                				
					                		</h:selectOneRadio>		
										</td>											
									</tr>
									<tr>
										<td align="right" width="25%">
											
											<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.oldPaymentTypeTxt}" styleClass="ms7"  disabled="true"/>
										</td>		
																
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.oldPaymentMethodTxt}" styleClass="ms7"  disabled="true"/>
										</td>											
									</tr>
																															
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>	
						
		<!--  End Meter Detail -->
		
		
		<!-- 3.  Start Expense Info -->
				
				<h:panelGrid width="95%">
					<rich:panel id="paymentPostpaidInfo">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseInfo']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%">
									<tr>
										<td align="right" width="25%">
											
										</td>
										<td width="25%">											
											<a4j:commandButton id="btnViewExpenseHis" value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
											disabled="#{semmel006Bean.viewMode || semmel006Bean.disableViewExpenseHisButton}"
											 oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
											 reRender="frmPaymentHistList,frmErrorPopup"
											action="#{semmel006Action.paymentHistPopupInterfaceByMeter}">
											</a4j:commandButton>
											
											<rich:spacer width="5"/>
										
											<a4j:commandButton id="btnViewMeterInfo"  
											disabled="#{semmel006Bean.viewMode  || semmel006Bean.disableViewMeterInfoButton}"
											value="#{jspMsg['btn.btnViewMeterInfo']}" styleClass="rich-button"  
											reRender="oppContent"
						            		action="#{navAction.navi}" style="width:80px;">
						            		<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
											<a4j:actionparam name="moduleWithNavi" value="el" />	
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001"/>									
											<a4j:actionparam name="methodWithNavi" value="doView13" />
											<a4j:actionparam name="manageRowId" value="#{semmel006Bean.popupSiteCriteria.electricId}"/>
											<a4j:actionparam name="manageContractNo" value="#{semmel006Bean.popupSiteCriteria.contractNo}"/>	
											<a4j:actionparam name="fromPage" value="SEMMEL006-5"/>	
											
				            				</a4j:commandButton>	
										</td>	
										<td>

										</td>											
										<td align="right" width="25%">											
											
										</td>
										<td width="25%">
											
										</td>																				
									</tr>								
							
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectOneMenu id="expenseTypeId" value="#{semmel006Bean.payment.expenseType}"   disabled="#{semmel006Bean.expenseTypeDisable||semmel006Bean.viewMode}" onchange="changeExpenseTypePRPostpaid5();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elExpenseTypeList}"/>
											</h:selectOneMenu>	
												<a4j:jsFunction name="changeExpenseTypePRPostpaid5" 
												reRender="paymentPostpaidInfo" 
												action="#{semmel006Action.changeExpenseTypePRPostpaid5}"/>
											
										</td>		
																
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.docType']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="docTypeId"  value="#{semmel006Bean.payment.docType}" disabled="#{semmel006Bean.docTypeDisable||semmel006Bean.viewMode}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.elDocTypeList}"/>
											</h:selectOneMenu>
										</td>											
									</tr>	
									<tr>
										<td align="right" width="25%">										
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.payment.docNo}" 
											disabled="#{semmel006Bean.docNoDisable||semmel006Bean.viewMode}" 
											style="width:120px;"></h:inputText>
										</td>
										<td align="right" width="25%">										
											<h:outputText value="#{jspMsg['label.docDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
											disabled="#{semmel006Bean.docDtDisable||semmel006Bean.viewMode}"
				                			 value="#{semmel006Bean.payment.docDt}" inputSize="18" 
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>										
									</tr>	
									<tr>
										<td align="right" width="25%">
											<c:if test="${semmel006Bean.refDocNoMandatory eq true}">
												<h:graphicImage value="images/icon_required.gif" rendered="false"/><rich:spacer width="5" />
											</c:if>			
											 
											<h:outputText value="#{jspMsg['label.refDocNo']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.refDocNo}" style="width:120px;"  disabled="#{true}"></h:inputText>
					                		<rich:spacer width="5"/>	
					                		<a4j:commandButton id="btnPopupSearchOldDoc"  oncomplete="#{rich:component('popupSearchOldDoc')}.show(); return false"
											value="#{jspMsg['btn.searchOldDoc']}" styleClass="rich-button"  reRender="popupSearchOldDoc,pnlPopupOldDocSearchResult,popupOldDocFrmError"
						            		action="#{navAction.navi}" style="width:150px;" disabled="#{semmel006Bean.refDocNoDisable||semmel006Bean.viewMode}">
						            		<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006" />
											<a4j:actionparam name="moduleWithNavi" value="el" />	
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>									
											<a4j:actionparam name="methodWithNavi" value="initPopupSearchOldDoc" />
				            				</a4j:commandButton>											
										</td>
										<td align="right" width="25%">
											<c:if test="${semmel006Bean.refDocNoMandatory eq true}">
											<h:graphicImage value="images/icon_required.gif" rendered="false" /><rich:spacer width="5"/>
											</c:if>
											<h:outputText value="#{jspMsg['label.refDocDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
										<h:inputText value="#{semmel006Bean.payment.refDocDtTH}" style="width:120px;"  disabled="#{true}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:inputText>
										</td>										
									</tr>											
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="vendorIdDisplay" value="#{semmel006Bean.payment.vendorId}" onchange="getVendorDetail();">
												<f:selectItems value="#{semmel006Bean.vendorIdList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="getVendorDetail" action="#{semmel006Action.changePaymentTypeELPR}" reRender="paymentPostpaidInfo">
											<a4j:actionparam name="fromChangeVendorMaster" value="Y"></a4j:actionparam>
											</a4j:jsFunction>
											<rich:spacer width="5"/>
											<a4j:commandButton id="btnVendorMaster" value="#{jspMsg['label.vendorMaster']}" 
											styleClass="rich-button" disabled="#{semmel006Bean.viewMode  || semmel006Bean.disableViewMeterInfoButton}"
						            		action="#{navAction.navi}" reRender="oppContent" style="width:100">
											    <a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
												<a4j:actionparam name="contractNo" value="#{semmel006Bean.popupSiteCriteria.contractNo}" />
												
												<a4j:actionparam name="navModuleFrom" value="el" />
												<a4j:actionparam name="navProgramFrom" value="SEMMEL006-5" />
												<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL006" />
											</a4j:commandButton>
										</td>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="vendorNameDisplay" value="#{semmel006Bean.payment.vendorName}" styleClass="ms7"/>	
										</td>
									</tr>																																								
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeId']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="payeeIdDisplay" value="#{semmel006Bean.payment.payeeId}" styleClass="ms7"/>										
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="payeeNameDisplay" value="#{semmel006Bean.payment.payeeName}" styleClass="ms7"/>
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">											
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel006Bean.paymentTypeMandatory}"/><rich:spacer width="5"/>	
											<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7" />
										</td>
										<td width="25%">
											
											<h:selectOneMenu id="paymentTypeId" value="#{semmel006Bean.payment.paymentType}"   disabled="#{semmel006Bean.paymentTypeDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" onchange="changePaymentTypeELPR();" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentTypeList}"/>
											</h:selectOneMenu>	
											<a4j:jsFunction name="changePaymentTypeELPR" reRender="paymentInfo,payment,paymentPostpaidInfo" action="#{semmel006Action.changePaymentTypeELPR}">
												<f:param name="fromChangePaymentType" value="Y"></f:param>
											</a4j:jsFunction>
																								
											
										</td>									
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif" rendered="#{semmel006Bean.paymentTypeMandatory}"/><rich:spacer width="5"/>

											
											<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:selectOneMenu id="paymentMethodId" value="#{semmel006Bean.payment.paymentMethod}"  
											disabled="#{semmel006Bean.paymentMethodDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" style="width:120px;">
												<f:selectItems value="#{semmel006Bean.ctPaymentMethodList}"/>
												<a4j:support event="onchange" reRender="paymentPostpaidInfo"></a4j:support>
											</h:selectOneMenu>
										</td>											
									</tr>										
									<tr>
										<td align="right" width="25%">						
											<c:if test="${semmel006Bean.bankNameMandatory eq true}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>											
											<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="bankNameDisplay" value="#{semmel006Bean.payment.bankName}" styleClass="ms7"/>
										</td>
										<td align="right" width="25%">										
											<c:if test="${semmel006Bean.bankAccountMandatory eq true}">
												<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											</c:if>												
											<h:outputText value="#{jspMsg['label.bankAccount']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputLabel id="bankAccountDisplay" value="#{semmel006Bean.payment.bankAccount}" styleClass="ms7"/>
										</td>
									</tr>									
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.chqPostingDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldchqPostingDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.chqPostingDt}" inputSize="18" 
				                			 disabled="#{semmel006Bean.chqPostingDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 oninputblur="validateCalendarFromToWithPaymentType('frmAddPaymentPRPostpaid','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"
									 		 oncollapse="validateCalendarFromToWithPaymentType('frmAddPaymentPRPostpaid','cldchqPostingDt','cldchqReceivedDt','#{semmel006Bean.payment.paymentMethod}');"/>
										
										</td>
										<a4j:jsFunction name="doChangehqPostDate" 
				                			 reRender="cldchqReceivedDt"
				                			 action="#{semmel006Action.doChangehqPostDate}"/>
				                			 
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.chqReceivedDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldchqReceivedDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.chqReceivedDt}" inputSize="18" disabled="#{semmel006Bean.chqReceivedDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										</td>
									</tr>										

									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldtransferDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 value="#{semmel006Bean.payment.transferDt}" inputSize="18" disabled="#{semmel006Bean.transferDtDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"/>
										
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
										</td>
										<td width="25%">
				                			 <h:inputTextarea id="textAreaRemark" value="#{semmel006Bean.payment.remark}" disabled="#{semmel006Bean.remarkDisable||semmel006Bean.disableMoreThanOneDetail||semmel006Bean.viewMode}" cols="40" rows="3" />				                		
										</td>
									</tr>
																																								
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
		<!--  End Expense Info -->
		
		
		<!-- Start  Expense Detail -->
					
					<h:panelGrid width="95%">
					<rich:panel id="expenseDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseDetail']}"/>
						</f:facet>
						<!-- begin content criteria -->
								<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" />
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%" border="0" >
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.multiVendor']}" styleClass="ms7"/>
									</td>
									<td align="left">
									<h:selectBooleanCheckbox id="chkMultiVendor" value="#{semmel006Bean.paymentDetail.multiVendorCheckBoolean}" 
										disabled="#{semmel006Bean.viewMode}" 
										onclick="doCheckMultiVendor();" />
										<a4j:jsFunction name="doCheckMultiVendor" reRender="frmError,expenseDetail" 
										action="#{semmel006Action.doCheckMultiVendor}"/>
									</td>
									<td align="right">
									
									</td>
									<td align="right" >
									
									</td>
								</tr>
								<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.fromTermOfPaymentDt']}" styleClass="ms7"/>
										</td>
										<td width="35%">
											 <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/><rich:spacer width="3"/>									
											<h:selectOneMenu id="fromTermOfPaymentDtMonthId"  
											value="#{semmel006Bean.paymentDetail.fromTermOfPaymentMonth}"  
											disabled="false"  
											style="width:80px;">
											<f:selectItems value="#{semmel006Bean.monthList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doCheckTermOfPaymentDateTime}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId,termofPayDt"
											/>
											</h:selectOneMenu>
											
											<rich:spacer width="3"/>
											<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/><rich:spacer width="3"/>
											<h:selectOneMenu id="fromTermOfPaymentDtYearId" 
											 value="#{semmel006Bean.paymentDetail.fromTermOfPaymentYear}"  
											 disabled="false"    
											 style="width:80px;">
											<f:selectItems value="#{semmel006Bean.yearList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doCheckTermOfPaymentDateTime}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId,termofPayDt"
											/>
											</h:selectOneMenu>
											
				                			 <rich:spacer width="5"/>
				                			 <rich:calendar  showWeeksBar="false" locale="th/TH" 
											enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 disabled="false"  
				                			 id="paymentDtFrom"
				                			 value="#{semmel006Bean.paymentDetail.fromTermOfPaymentDt}" 
				                			 rendered="true"
				                			 inputSize="18"
				                			 oncollapse="doChangeTermOfPaymentDate()"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 />
				                			 <a4j:jsFunction name="doChangeTermOfPaymentDate" 
				                			 reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId,fromTermOfPaymentDtMonthId,fromTermOfPaymentDtYearId,btnPercentGrowth,termofPayDt"
				                			 action="#{semmel006Action.doChangeTermOfPaymentDate}"/>
				                			 <h:inputHidden id="termofPayDt" value="#{semmel006Bean.paymentDetail.termOfPaymentDateFrom}"></h:inputHidden>
				                			 
										</td>	
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.toTermOfPaymentDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											
				                			 <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/><rich:spacer width="3"/>									
											<h:selectOneMenu id="toTermOfPaymentDtMonthId"  
											value="#{semmel006Bean.paymentDetail.toTermOfPaymentMonth}"  
											disabled="false"    style="width:80px;">
												<f:selectItems value="#{semmel006Bean.monthList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doCheckTermOfPaymentDateTime}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId,termofPayDt"
											/>
											</h:selectOneMenu><rich:spacer width="3"/>
											<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/><rich:spacer width="3"/>
											<h:selectOneMenu id="toTermOfPaymentDtYearId" 
											 value="#{semmel006Bean.paymentDetail.toTermOfPaymentYear}"  
											 disabled="false"    
											 style="width:80px;">
												<f:selectItems value="#{semmel006Bean.yearList}"/>
											<a4j:support event="onchange" 
											 action="#{semmel006Action.doCheckTermOfPaymentDateTime}" 
											reRender="expenseDetail, paymentDtFrom,paymentDtTo,toTermOfPaymentDtMonthId,toTermOfPaymentDtYearId,termofPayDt"
											/>
											</h:selectOneMenu>
										<rich:spacer width="5"/>
										<rich:calendar showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
				                			 disabled="false"  
				                			 id="paymentDtTo"
				                			 value="#{semmel006Bean.paymentDetail.toTermOfPaymentDt}" inputSize="18" 
				                			 rendered="true"
				                			 oncollapse="doChangeTermOfPaymentDate()"
				                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			 />
										</td>											
								</tr>						
									<tr>
										<td align="right" width="15%">											
											<h:outputText value="#{jspMsg['label.pRead']}" styleClass="ms7"/>
										</td>
										<td width="35%">
												<h:inputText value="#{semmel006Bean.paymentDetail.pRead}"
												id ="inputPRead"	
												disabled="#{semmel006Bean.viewMode}" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="doCalculateKwhTotal()"
												styleClass="inputRight" style=" height : 21px;"></h:inputText>
										</td>
										<td align="right" width="15%">											
											<h:outputText value="#{jspMsg['label.lRead']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText  value="#{semmel006Bean.paymentDetail.lRead}"	
											id ="inputLRead"
											disabled="#{semmel006Bean.viewMode}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											onblur="doCalculateKwhTotal()"
											styleClass="inputRight">
											
											</h:inputText>
											
											<a4j:jsFunction name="doCalculateKwhTotal" 
				                			 reRender="inputKwhTotal,inputLRead,inputPRead, txtPayAmt"
				                			 action="#{semmel006Action.doCalculateKwhTotal}">
				                			 <a4j:support event="oncomplete" reRender="frmError,expenseDetail" action="#{semmel006Action.doRecalCulateVATPR}">
											</a4j:support>
				                			 </a4j:jsFunction>				                			 
										</td>
									</tr>	
									<tr>
										<td align="right" width="15%">											
											<h:outputText value="#{jspMsg['label.kwhTotal']}" styleClass="ms7"/>
										</td>
										<td width="35%">
											<h:inputText value="#{semmel006Bean.paymentDetail.kwhTotal}" 
											id ="inputKwhTotal"
											disabled="#{semmel006Bean.viewMode}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
											onblur="doCalculateKwhTotal()"
											styleClass="inputRight"></h:inputText>
											<h:inputHidden value="#{semmel006Bean.paymentDetail.kwhTotalStr}"></h:inputHidden>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.unitPrice']}" styleClass="ms7"/>
										</td>

										<td width="25%">							
											<h:inputText id="txtUnitPrice" value="#{semmel006Bean.paymentDetail.unitPrice}"
											disabled="#{semmel006Bean.viewMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="doCalculateKwhTotal();return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>												
																					
										</td>
									</tr>	


									<tr>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7"/>
										</td>
										<td width="35%">
										
										<h:selectBooleanCheckbox id="chkwhtRate" value="#{semmel006Bean.paymentDetail.whtCheckBoolean}" 
										disabled="#{semmel006Bean.viewMode}" 
										onclick="doChangeWhtELPR();" />
										<a4j:jsFunction name="doChangeWhtELPR" reRender="frmError,expenseDetail" 
										action="#{semmel006Action.doChangeWhtELPR}"/>
									
										
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.whtRatePercent']}" styleClass="ms7"/>
										<rich:spacer width="5"/>
										<h:inputText  value="#{semmel006Bean.paymentDetail.whtRate}" 
										
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"											
											onchange="doRecalCulateVATPR();" 
											maxlength="3"
										disabled="#{semmel006Bean.whtRateDisable||semmel006Bean.viewMode || semmel006Bean.disableMoreThanOneDetail}" size="3"/>
								
											
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.unitVatType']}" styleClass="ms7" rendered="false"/>
											
											
										</td>

										<td width="25%">	
											<h:selectOneRadio value="#{semmel006Bean.paymentDetail.unitVatType}"  
											disabled="#{semmel006Bean.viewMode}"
											styleClass="ms7" rendered="false"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>												
										</td>
									</tr>
										
									
									<tr>
										<td align="right" width="15%">			
										<c:if test="${semmel006Bean.whtTypeMandatory eq true}">			
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>	
										</c:if>				
										
											<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>										
										</td>
										<td width="35%">
											<h:selectOneRadio value="#{semmel006Bean.paymentDetail.whtType}" 
										onclick="doChangeWhtType();" 
										
											disabled="#{semmel006Bean.whtTypeDisable||semmel006Bean.viewMode || semmel006Bean.disableMoreThanOneDetail}"  
											styleClass="ms7" rendered="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.whtType01']}" />
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.whtType02']}" />
					                		</h:selectOneRadio>													
										</td>
										<td align="right" width="15%">											
											<h:outputText value="#{jspMsg['label.whtAmt']}" styleClass="ms7"/>
										</td>
									<a4j:jsFunction name="doChangeWhtType" reRender="frmError,expenseDetail" action="#{semmel006Action.doChangeWhtType}"/>

										<td width="25%">	
				
											<h:inputText id="txtWhtAmt" value="#{semmel006Bean.paymentDetail.whtAmt}"  
											disabled="#{semmel006Bean.whtAmtDisable||semmel006Bean.viewMode}" 
												onchange="doChangeWhtAmt5();" 											
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>												
											<a4j:jsFunction name="doChangeWhtAmt5" 
											reRender="frmError,expenseDetail" action="#{semmel006Action.doChangeWhtAmt5}"/>
									
											
										</td>
									</tr>									

									<tr>
										<td align="right" width="15%">							
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>				
											<h:outputText value="#{jspMsg['label.payAmt']}" styleClass="ms7"/>
										</td>
										<td width="35%">											
											<h:inputText id="txtPayAmt" value="#{semmel006Bean.paymentDetail.payAmt}"
											disabled="#{semmel006Bean.viewMode}"
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onchange="doRecalCulateVATPR();" 
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
																			
											<a4j:jsFunction name="doRecalCulateVATPR" reRender="frmError,expenseDetail" action="#{semmel006Action.doRecalCulateVATPR}"/>                     
								
											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>					
											
											
										</td>
										<td align="right" width="15%">		
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>									
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
										</td>

										<td width="25%">	
												<h:selectOneRadio value="#{semmel006Bean.paymentDetail.vatType}" 
												disabled="#{semmel006Bean.viewMode}" 
												onclick="doRecalCulateVATPR();" 
												styleClass="ms7" rendered="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.includeVat']}" />		
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.excludeVat']}" />				                	
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.notVat']}" />
					                		</h:selectOneRadio>											
											
										</td>
									</tr>	
									
									
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.excludeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="35%">							
				
											<h:inputText value="#{semmel006Bean.paymentDetail.excludeVatAmt}"  styleClass="inputRight" 
											disabled="false" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);">
											
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>                       
												<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>

										</td>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
							
											<h:inputText id="txtVatAmt" value="#{semmel006Bean.paymentDetail.vatAmt}"
											
											disabled="#{semmel006Bean.vatAmtDisable||semmel006Bean.viewMode}" 
												onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
												onblur="return numberformat.moneyFormat(this);"
												onfocus="return numberformat.setCursorPosToEnd(this);"
												onchange="doChangeVatAmtPage65();" 
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>	
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											<a4j:jsFunction name="doChangeVatAmt5" reRender="frmError,expenseDetail" action="#{semmel006Action.doChangeVatAmt5}"/>
											<a4j:jsFunction name="doChangeVatAmtPage65" reRender="frmError,expenseDetail" action="#{semmel006Action.doChangeVatAmtPage65}"/>                      
											
										</td>
									</tr>	
									<tr>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>
										</td>
										<td width="35%">
											<h:inputText id="txtIncludeVatAmt" value="#{semmel006Bean.paymentDetail.includeVatAmt}"	
											disabled="false" onkeypress="return numberformat.keyPressDecimalOnly(this, event);"						
												styleClass="inputRight">
												<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText >											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
										<td align="right" width="15%">
											<h:graphicImage value="images/icon_required.gif"/><rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.chqAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">	
											<h:inputText value="#{semmel006Bean.paymentDetail.chqAmt}"  
											disabled="false" styleClass="inputRight" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>   											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
											
										</td>
									</tr>									
									<tr>
										
										<td colspan="3" >
											<a4j:commandButton id="btnAddELPostpaidToModel" value="Add" styleClass="rich-button" 
											disabled="#{semmel006Bean.disableAddModelButton||semmel006Bean.viewMode}"
											rendered="#{!semmel006Bean.comeFromPage8}"
											action="#{navAction.navi}"  reRender="oppContent,frmAddPaymentPRPostpaid"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doAddPRPostpaidToModel" />
											</a4j:commandButton>										
											<rich:spacer width="5"/>
											<a4j:commandButton id="btnUpdateELPostpaid" value="Update" styleClass="rich-button" 
											disabled="#{semmel006Bean.disableUpdateModelButton||semmel006Bean.viewMode}"
											action="#{navAction.navi}"  reRender="oppContent,frmAddPaymentPRPostpaid"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doUpdatePRPostpaid" />
											</a4j:commandButton>	
											
											<rich:spacer width="5"/>
																	
											<a4j:commandButton id="btnClearELPostpaid" value="Clear" styleClass="rich-button" 
											disabled="#{semmel006Bean.viewMode}" 
											action="#{navAction.navi}"  reRender="oppContent,frmAddPaymentPRPostpaid"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doClearPaymentDetail" />
											</a4j:commandButton>
											<rich:spacer width="5"/>
											<a4j:commandButton id="btnSave1" value="Save" styleClass="rich-button" 
											action="#{navAction.navi}"  disabled="#{semmel006Bean.viewMode}" 
											reRender="oppContent,pnlPaymentList,frmAddPaymentPRPostpaid"   >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doSavePRPostpaid" />
											</a4j:commandButton>													
										</td>
										<td  align="right">
										<a4j:commandButton id="btnElGroup" style=" width : 110px;" value="#{jspMsg['btn.recentlyElGroupMeter']}" 
							           			styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							           			oncomplete="#{rich:component('popupRecentGrpMeter')}.show();" disabled="#{semmel006Bean.popupSiteCriteria.contractNo==null?true:false}">									
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
												<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
												<a4j:actionparam name="fromPage" value="semmel006Page"/>
												<a4j:actionparam name="groupExpenseType" value="PR_POSTPAID"/>
												<a4j:actionparam name="groupOwnerGroup" value="#{semmel006Bean.popupSiteCriteria.ownerGroup}"/>
												<a4j:actionparam name="groupFlagType" value="PR"/>
										</a4j:commandButton>
										<rich:spacer width="5"></rich:spacer>
										<a4j:commandButton id="btnPercentGrowth" style=" width : 130px;" value="Verify Percent Growth" styleClass="rich-button" 
											action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();" disabled="#{semmel006Bean.popupSiteCriteria.contractNo==null?true:false}">									
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
											<a4j:actionparam name="fromPage" value="semmel006Page"/>
											<a4j:actionparam name="percentExpenseType" value="PR_POSTPAID"/>
											<a4j:actionparam name="percentcontractNo" value="#{semmel006Bean.popupSiteCriteria.contractNo}"/>
											<a4j:actionparam name="percentPayDate" value="#{semmel006Bean.paymentDetail.termOfPaymentDateFrom}"/>
											<a4j:actionparam name="percentKwhNew" value="#{semmel006Bean.paymentDetail.kwhTotal}"/>
											<a4j:actionparam name="percentUnitNew" value="#{semmel006Bean.paymentDetail.unitPrice}"/>
											<a4j:actionparam name="percentAmtNew" value="#{semmel006Bean.paymentDetail.payAmt}"/>
											<a4j:actionparam name="percentType" value="PR"/>
											<a4j:actionparam name="percentTransId" value=""/>
											<a4j:actionparam name="percentRecStatus" value=""/>
											<a4j:actionparam name="percentErrCode" value=""/>
									</a4j:commandButton></td>
						           		
									</tr>																						
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
			
		<!--  End Expense Detail -->
		
		<!-- Start Expense Info conclude -->
				<h:panelGrid width="95%">
					<rich:panel id="paymentConclude">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenseInfoConClude']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
							<table width="100%" border= "0" >
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.totalMeterExpense']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.totalExpense}" styleClass="ms7" disabled="true"/>
											<rich:spacer width="5"/>									
											
											<h:outputText value="#{jspMsg['label.from']}" styleClass="ms7"/>
											<rich:spacer width="5"/>
											<h:inputText value="#{semmel006Bean.payment.totalMeterExpense}" styleClass="ms7" disabled="true"/>
											
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.whtAmt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.whtAmt}" styleClass="ms7" disabled="true">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
										</td>																				
									</tr>										
									<tr>
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.vatAmt']}" styleClass="ms7"/>										
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.vatAmt}" styleClass="ms7" disabled="true" >
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
										
										</td>	
										<td align="right" width="25%">											
											<h:outputText value="#{jspMsg['label.includeVatAmt']}" styleClass="ms7"/>										
										</td>
										<td width="25%">
											<h:inputText value="#{semmel006Bean.payment.includeVatAmt}" styleClass="ms7" 
											disabled="true">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
										
										</td>																				
									</tr>																			
							</table>
							</h:panelGroup>								

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
			
	<!--  End Expense Info conclude -->		
			
			
	<!--  Start Payment Model List  -->
				<!-- begin content layout data grid -->
				
				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlPaymentList" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.paymentList']}" style="width: 3000"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbPaymentList" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="paymentDetail"  rowKeyVar="rowIndex" value="#{semmel006Bean.paymentDetailList}" reRender="dtbPaymentList" 	rowClasses="cur" styleClass="dataTable">

							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.edit']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
 
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmEditDialog')}.show(); return false" 
	            							action="#{navAction.navi}" 
	            							disabled="#{semmel006Bean.viewMode}"
	            									   	image="images/edit.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el"/>
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initUPdatePaymentDetailFromModel" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}" />	
	            					</a4j:commandButton>  	            					    							
								</div>									
							</rich:column>
							<rich:column rendered="#{!semmel006Bean.comeFromPage8}">
								<f:facet  name="header">
									<h:outputText  value="#{jspMsg['column.header.delete']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">	
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	            									   action="#{navAction.navi}" 
	            									   disabled="#{semmel006Bean.viewMode}"
	            									   image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL006" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initDeletePaymentDetailFromModel" />
										<a4j:actionparam name="rowIndex" value="#{rowIndex}" />										
	            					</a4j:commandButton>	            					          							
								</div>									
							</rich:column>			
							
								
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['label.meterIdExpense']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.meterId}"/>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['label.referMeterId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.referMeterId}"/>
								</div>
							</rich:column>				
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['label.meterAddress']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.meterAddress}"/>
								</div>
							</rich:column>								
							
																				
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.expenseType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.expenseTypeDisplay}"/>
								</div>
							</rich:column>				
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.docTypeDisplay}"/>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.docNo}"/>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.docDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.docDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.refDocNo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.refDocNo}"/>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.refDocDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.refDocDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>																													
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.vendorId}"/>
								</div>
							</rich:column>		
							
																					<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vendorName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.vendorName}"/>
								</div>
							</rich:column>		
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeId']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.payeeId}"/>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.payeeName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.payeeName}"/>
								</div>
							</rich:column>		
	
	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricFrom']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.fromTermOfPaymentDtTH}"/>
								</div>
							</rich:column>		
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.electricTo']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.toTermOfPaymentDtTH}"/>
								</div>
							</rich:column>		
							
							
																					
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.kwhTotal']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.kwhTotal}">
									<f:convertNumber pattern="#,##0"/>									 
									</h:outputText>
								</div>
							</rich:column>		
							
					
							
	
	
								<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitPrice']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.unitPrice}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							


						 <rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.unitVatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.unitVatTypeTxt}">
									 
									</h:outputText>
								</div>
							</rich:column>							


						 <rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.amount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.payAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
													
						 <rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.vatTypeTxt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>														
														
							
																				
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.excludeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.excludeVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.vatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.vatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.includeVatAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.includeVatAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.whtAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.whtAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>								
							
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqAmt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{paymentDetail.chqAmt}">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							

							
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentMethod']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.paymentTypeTxt}"/>
								</div>
							</rich:column>	
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.paymentType']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
								<h:outputText value="#{semmel006Bean.payment.paymentMethodTxt}"/>
									
								</div>
							</rich:column>								
							
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankName']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.bankName}"/>
								</div>
							</rich:column>								
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.bankAccount']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.bankAccount}"/>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqPostingDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.chqPostingDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.chqReceivedDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.chqReceivedDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.transferDt']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.transferDtTH}">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.remark']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{semmel006Bean.payment.remark}"/>
								</div>
							</rich:column>																																																																																																																																																											
																				
						</rich:dataTable>
						<!-- end dataTable -->						
					</rich:panel>					
				</h:panelGrid>
				
				
				
	<!--  End Payment Model List -->
	

				<h:panelGrid  width="95%">
				<rich:panel id="elPostpaidFooter">
					<h:panelGroup>
						<table width="90%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText  value="#{semmel006Bean.payment.createBy}" styleClass="ms7"></h:outputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText value="#{semmel006Bean.payment.displayCreateDate}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>
									</tr>	
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText   value="#{semmel006Bean.payment.updateBy}" styleClass="ms7">											
											</h:outputText>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<h:outputText   value="#{semmel006Bean.payment.displayUpdateDate}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
											</h:outputText>
										</td>
									</tr>											
						</table>
					</h:panelGroup>
					</rich:panel>
				</h:panelGrid>			
           
			
									
		</a4j:form>
			<jsp:include page="../../pages/el/semmel006-popupSearchSitePR.jsp" />
			<jsp:include page="../../pages/el/semmel006-popupOldDoc.jsp" />	
			<jsp:include page="../../pages/el/semmel006_popup.jsp" />	
			<jsp:include page="../../pages/el/semmel006percentGrowth-popup.jsp" />
			<jsp:include page="../../pages/el/semmel006ElGrpMeter-popup.jsp" />
       </rich:panel>
   </h:panelGrid>
      	
	
<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Delete"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel006Bean.popupDelMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doDeletePaymentDetailFromModel5" />
						<rich:componentControl for="mdpConfirmDelDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmDelDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>


<rich:modalPanel id="mdpConfirmEditDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Edit"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmEditDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170">
					<h:outputText value="#{semmel006Bean.popupEditMsg}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td><h:panelGrid columns="2" styleClass="contentlabelform">
					<a4j:commandButton value="Yes" styleClass="rich-button"
						action="#{navAction.navi}" immediate="true"
						reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006"/>
						<a4j:actionparam name="methodWithNavi" value="doUPdatePaymentDetailFromModel" />
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
					<a4j:commandButton value="No" styleClass="rich-button"
						immediate="true">
						<rich:componentControl for="mdpConfirmEditDialog" operation="hide"
							event="onclick" />
					</a4j:commandButton>
				</h:panelGrid></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>
<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>