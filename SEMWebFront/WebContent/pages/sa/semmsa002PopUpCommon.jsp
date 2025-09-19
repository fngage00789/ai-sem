
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->		
		
	<!-- >> [POPUP_00] -->
	<!-- msa002PopUpCommon_retStatus -->
	<rich:modalPanel id="msa002PopUpCommon_retStatus" autosized="true" width="300" rendered="#{semmsa002Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_retStatus" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_retStatus" attachTo="hide-msa002PopUpCommon_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa002_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="300">
				<!-- /// -->
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue_custom" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgAlert}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" style="margin-right:5px;" />  
                    </f:facet>
	            </rich:messages>
			</h:panelGrid>
			
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					
					<a4j:commandButton id="btnNormal" value="Ok" styleClass="rich-button" immediate="true" 
					rendered="#{semmsa002Bean.disabledButtonPopupResult == false}">
					    <rich:componentControl for="msa002PopUpCommon_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
					
					
					
					<a4j:commandButton id="btnConfirmOk" value="Ok" styleClass="rich-button" immediate="true" 
					rendered="#{semmsa002Bean.disabledButtonPopupResult}" 
					action="#{navAction.navi}" reRender="panelTab, panelTab3">
				        			<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									<a4j:actionparam name="methodWithNavi" value="doInitChangeTab" />
				        			<a4j:actionparam  name="tabNo" value="3"/>
					    <rich:componentControl for="msa002PopUpCommon_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnConfirmCancel" value="cancel" styleClass="rich-button" immediate="true"
					rendered="#{semmsa002Bean.disabledButtonPopupResult}">
					    <rich:componentControl for="msa002PopUpCommon_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- msa002PopUpCommon_retStatus -->
	<!-- << [POPUP_00] -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_01] -->
	<rich:modalPanel id="msa002PopUpCommon_tab7ConfirmDelete" width="300" autosized="true">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Delete"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_tab7ConfirmDelete" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_tab7ConfirmDelete" attachTo="hide-msa002PopUpCommon_tab7ConfirmDelete" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_tab7ConfirmDelete">
		<!-- >> group detail -->
		<center>
			<h:outputText value="#{jspMsg['label.th_confirm_delete']}" styleClass="ms7" />
		</center>
		<!-- << group detail -->

		<div style="clear:both; height:10px;"></div>

		<!-- >> additional button close -->
		<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
			<h:panelGroup style="float:right;">
				<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true" style="margin-right:5px;"
				action="#{semmsa002Action.msa002Tab7_doSaveAddr}" oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;" 
				reRender="oppContent, dataTabMsa002tab7_mailAddr">
					<a4j:actionparam name="paramMailAddrId" value="#{semmsa002Bean.siteAppTab7ObjParam.mailAddrId}" />
					<a4j:actionparam name="paramMode" value="D" />
				</a4j:commandButton>
				
				<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
				    <rich:componentControl for="msa002PopUpCommon_tab7ConfirmDelete" operation="hide" event="onclick" />
				</a4j:commandButton>
			</h:panelGroup>
		</h:panelGrid>
		<!-- << additional button close -->
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_01] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_02] -->
	<!-- msa002PopUpCommon_addrDetailIU -->
	<rich:modalPanel id="msa002PopUpCommon_addrDetailIU" width="400" autosized="true">
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_addrForCourier']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_addrDetailIU" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_addrDetailIU" attachTo="hide-msa002PopUpCommon_addrDetailIU" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_addrDetailIU">
		
			<!-- >> group edit detail -->
			<rich:panel id="msa002tab7_addrDetail">
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px;">
						<tr>
							<td colspan="2" style="background-color:ececec; border:solid dcdcdc 1px; text-align:center;">
								<a4j:commandButton style="margin-right:5px;" styleClass="rich-button" id="msa002tab7_BtnCopy_fromLessor" 
								value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_lessor']}" rendered="true"
								action="#{semmsa002Action.doCopyLocation}" reRender="msa002tab7_mailName, msa002tab7_mailHouseNo,  
								msa002tab7_mailStreet, msa002tab7_mailTambon, msa002tab7_phoneNo,
								msa002tab7_mailAmphur, msa002tab7_mailProvince, msa002tab7_mailPostCode">
									<a4j:actionparam  name="paramLocateFrom" value="tab2_lessor"/>
									<a4j:actionparam  name="paramLocateTo" value="tab7_mail"/>
								</a4j:commandButton>
								
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab7_BtnCopy_fromStation" 
								value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_info_station']}" rendered="true"
								action="#{semmsa002Action.doCopyLocation}" reRender="msa002tab7_mailName, msa002tab7_mailHouseNo, 
								msa002tab7_mailStreet, msa002tab7_mailTambon, msa002tab7_phoneNo,
								msa002tab7_mailAmphur, msa002tab7_mailProvince, msa002tab7_mailPostCode">
									<a4j:actionparam  name="paramLocateFrom" value="tab1_siteStation"/>
									<a4j:actionparam  name="paramLocateTo" value="tab7_mail"/>
								</a4j:commandButton>
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_name']} : " styleClass="ms7" />
							</td>
							<td style="">
								<h:inputText value="#{semmsa002Bean.siteAppTab7ObjParam.mailName}" style="width:80%;" 
								id="msa002tab7_mailName" maxlength="200" styleClass="ms7" />
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;">
								<h:inputTextarea value="#{semmsa002Bean.siteAppTab7ObjParam.mailHouseNo}" 
								id="msa002tab7_mailHouseNo" style="width:80%; height:70px; overflow:visible;" rows="7" cols="20" styleClass="ms7" >
								</h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;" >
								<h:inputText value="#{semmsa002Bean.siteAppTab7ObjParam.mailStreet}" 
								id="msa002tab7_mailStreet" maxlength="200" styleClass="ms7" style="width:80%;" />
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;" >
								<h:inputText value="#{semmsa002Bean.siteAppTab7ObjParam.mailTambon}" 
								id="msa002tab7_mailTambon" maxlength="200" styleClass="ms7" style="width:80%;" />
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;">
								<h:selectOneMenu id="msa002tab7_mailAmphur" value="#{semmsa002Bean.siteAppTab7ObjParam.mailAmphurId}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.msa002Tab7AmphurList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;" >
								<h:selectOneMenu id="msa002tab7_mailProvince" value="#{semmsa002Bean.siteAppTab7ObjParam.mailProvinceId}" onchange="msa002tab7_GetAmphurListJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.msa002Tab7ProvinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="msa002tab7_GetAmphurListJS" reRender="msa002tab7_mailAmphur" action="#{semmsa002Action.getAmphurList}">
									<a4j:actionparam name="paramAmphr" value="M" />
								</a4j:jsFunction>
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;" >
								<h:inputText value="#{semmsa002Bean.siteAppTab7ObjParam.mailPostCode}" style="text-align:right; width:50px;"
								id="msa002tab7_mailPostCode" onkeypress="return numberformat.keyPressIntegerOnly(this, event);" maxlength="5" styleClass="ms7" />
							</td>
						</tr>
						<tr>
							<td style="width:30%; text-align:right;">
								<h:outputText value="#{jspMsg['label.th_phone']} : " styleClass="ms7" />
							</td>
							<td style="width:70%;">
								<h:inputTextarea value="#{semmsa002Bean.siteAppTab7ObjParam.phoneNo}" 
								id="msa002tab7_phoneNo" style="width:80%; height:70px; overflow:visible;" rows="7" cols="20" styleClass="ms7" >
								</h:inputTextarea>
							</td>
						</tr>
					</table>
				</h:panelGroup>
				
			</rich:panel>
			<!-- << group edit detail -->
			
			<div style="clear:both; height:0px;"></div>

			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Save" styleClass="rich-button" style="margin-right:5px;"
					action="#{semmsa002Action.msa002Tab7_doSaveAddr}" id="msa002tab7_saveAddress" 
					oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;"
					reRender="frmAllInitTab, panelTab, panelTab7, dataTabMsa002tab7_mailAddr, msa002tab7_addrDetail, msa002PopUpCommon_addrDetailIU">
					</a4j:commandButton>

					<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msa002PopUpCommon_addrDetailIU" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->

		</a4j:form>

	</rich:modalPanel>
	<!-- msa002PopUpCommon_addrDetailIU -->
	<!-- << [POPUP_02] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_03] -->
	<rich:modalPanel id="msa002PopUpCommon_tab1EditSite" width="300" autosized="true">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Edit Site"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_tab1EditSite" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_tab1EditSite" attachTo="hide-msa002PopUpCommon_tab1EditSite" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_tab1EditSite">
		
			<!-- >> group detail -->
			<rich:panel id="msa002tab1_editType">
				<h:panelGroup style="width:100%;">
					
					<a4j:region>
	           			<h:selectBooleanCheckbox id="msa002tab1_chkINS" value="#{semmsa002Bean.chkEditSiteModeINS}" 
	           			disabled="#{semmsa002Bean.disabledModeINS}" onclick="msa002tab1_siteModeChkINS_JS();">
	           			
	           			</h:selectBooleanCheckbox>
	           			<h:outputText value=" #{jspMsg['label.th_ins_site']}" styleClass="ms7" />
	           			
	           			<div style="clear:both; height:0px;"></div>
	           			
	           			<h:selectBooleanCheckbox id="msa002tab1_chkRMV" value="#{semmsa002Bean.chkEditSiteModeRMV}"
	           			disabled="#{semmsa002Bean.disabledModeRMV}" onclick="msa002tab1_siteModeChkRMV_JS();">
	           			
	           			</h:selectBooleanCheckbox>
	           			<h:outputText value=" #{jspMsg['label.th_rmv_site']}" styleClass="ms7" />
						
						<a4j:jsFunction name="msa002tab1_siteModeChkINS_JS" action="#{semmsa002Action.msa002tab1_siteModeChk}"
	           			reRender="msa002tab1_chkINS, msa002tab1_chkRMV, msa002tab1_siteModeBtnSave">
	           				<a4j:actionparam name="paramSiteMode" value="I" />
	           			</a4j:jsFunction>
	           			
	           			<a4j:jsFunction name="msa002tab1_siteModeChkRMV_JS" action="#{semmsa002Action.msa002tab1_siteModeChk}"
	           			reRender="msa002tab1_chkINS, msa002tab1_chkRMV, msa002tab1_siteModeBtnSave">
	           				<a4j:actionparam name="paramSiteMode" value="D" />
	           			</a4j:jsFunction>
	           		</a4j:region>
							
				</h:panelGroup>
			</rich:panel>
			<!-- << group detail -->
	
			<div style="clear:both; height:10px;"></div>
	
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right; width:100%;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Save" id="msa002tab1_siteModeBtnSave" style="margin-right:5px;"
					action="#{semmsa002Action.msa002Tab1_doSaveEditSite}" styleClass="rich-button" immediate="true"
					oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();" 
					disabled="#{semmsa002Bean.disabledSiteModeBtn}"
					reRender="oppContent, msa002PopUpCommon_tab1EditSite, frmMsa002PopUpCommon_tab1EditSite, dataTabMsa002tab1">
						<a4j:actionparam name="paramSiteMode" value="#{semmsa002Bean.paramSiteMode}" />
						
						<%-- parameter for reload --%>
						<a4j:actionparam name="rowId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
					</a4j:commandButton>
					
					<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msa002PopUpCommon_tab1EditSite" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_03] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_04] -->
	<rich:modalPanel id="msa002PopUpCommon_tab1AddSiteLocation" width="900" autosized="true" top="70">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Add Site Location"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_tab1AddSiteLocation" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_tab1AddSiteLocation" attachTo="hide-msa002PopUpCommon_tab1AddSiteLocation" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_tab1AddSiteLocation">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['label.th_searchCriteria']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="10%" style="white-space:nowrap;">
								<h:outputText value="Location ID :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                				<h:inputText id="tab1AddSite_txtLocationId" value="#{semmsa002Bean.siteLocationObjParam.locationId}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="10%" style="white-space:nowrap;">
								<h:outputText value="Location Code :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                				<h:inputText id="tab1AddSite_txtLocationCode" value="#{semmsa002Bean.siteLocationObjParam.locationCode}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="10%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_name']}#{jspMsg['label.th_site']} :" styleClass="ms7"/>
                			</td>
                			<td width="30%">
                				<h:inputText id="tab1AddSite_siteName" value="#{semmsa002Bean.siteLocationObjParam.siteName}" 
                				size="30" maxlength="20"/>
		                	</td>
						</tr>
						<tr>
							
		                	<td align="right" width="10%">
								<h:outputText value="Site Code :" styleClass="ms7"/>
                			</td>
                			<td colspan="3">
                				<h:inputText id="tab1AddSite_txtSiteCode" value="#{semmsa002Bean.siteLocationObjParam.siteCode}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="10%">
                			</td>
                			<td width="20%">
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
					<a4j:commandButton value="Search" action="#{semmsa002Action.tab1AddSite_doSearchSiteLocation}"
					reRender="frmMsa002PopUpCommon_tab1AddSiteLocation, dataTable_searchSiteLocation" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmsa002Action.tab1AddSite_doClearSiteLocation}"
					reRender="frmMsa002PopUpCommon_tab1AddSiteLocation, dataTable_searchSiteLocation"
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
						<h:outputText value="#{jspMsg['label.th_searchResult']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchSiteLocation" cellpadding="1" cellspacing="0" border="0" 
							var="siteLocationLst"  value="#{semmsa002Bean.siteLocationList}" reRender="dataTable_searchSiteLocation, dataScrll_searchSiteLocation" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								<rich:column title="#{appSiteLst.dataObj.locationId}" >
		                            
		                                <f:facet name="header">
		                                    <h:outputText value="Select" styleClass="contentform" style="width: 20"/>
		                                </f:facet>
		                                <div align="center">
		                                    <a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmsa002Action.msa002Tab1_doAddLocationSite}"
											oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();"
											reRender="msa002PopUpCommon_tab1AddSiteLocation, pnlSearchResult, pnlMsa002tab1Result2">
												<a4j:actionparam name="paramSiteMode" value="I" />
												<a4j:actionparam name="paramSiteAppId" value="#{siteLocationLst.dataObj.siteAppId}" />
												<a4j:actionparam name="paramSiteAppSiteId" value="#{siteLocationLst.dataObj.siteAppSiteId}" />
												<a4j:actionparam name="paramLocationId" value="#{siteLocationLst.dataObj.locationId}" />
												<a4j:actionparam name="paramSiteId" value="#{siteLocationLst.dataObj.siteId}" />
												<a4j:actionparam name="paramSiteCode" value="#{siteLocationLst.dataObj.siteCode}" />
												<a4j:actionparam name="paramLocationCode" value="#{siteLocationLst.dataObj.locationCode}" />
												<a4j:actionparam name="paramLocationName" value="#{siteLocationLst.dataObj.locationName}" />
												<a4j:actionparam name="paramTowerType" value="#{siteLocationLst.dataObj.towerType}" />
												<a4j:actionparam name="paramTowerLocation" value="#{siteLocationLst.dataObj.towerLocation}" />
												<a4j:actionparam name="paramTowerHeight" value="#{siteLocationLst.dataObj.towerHeight}" />
												<a4j:actionparam name="paramServiceId" value="#{siteLocationLst.dataObj.serviceId}" />
												<a4j:actionparam name="paramSiteGroup" value="#{siteLocationLst.dataObj.siteGroup}" />
												<a4j:actionparam name="paramStationType" value="#{siteLocationLst.dataObj.stationType}" />
												<a4j:actionparam name="paramSystem" value="#{siteLocationLst.dataObj.system}" />
												
												<%-- parameter for reload --%>
												<a4j:actionparam name="rowId" value="#{siteLocationLst.dataObj.siteAppId}" />
											</a4j:commandLink>
		                                </div>
		                            </rich:column>
									
									<rich:column sortBy="#{siteLocationLst.dataObj.locationId}" title="#{siteLocationLst.dataObj.locationId}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" style="width: 60"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.locationId}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.locationStatus}" title="#{siteLocationLst.dataObj.locationStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['lable.th_locationstatus']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.locationStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.slimStatus}" title="#{siteLocationLst.dataObj.slimStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.slimsstatus']}" styleClass="contentform" style="width: 60"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.slimStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.liveNetwork}" title="#{siteLocationLst.dataObj.liveNetwork}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.liveNetwork']} Status" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.liveNetwork}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.contractNoInfo}" title="#{siteLocationLst.dataObj.contractInfo}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.th_info_contract']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.contractNoInfo}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.contractStatus}" title="#{siteLocationLst.dataObj.contractStatus}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 60"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.contractStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.siteGroup}" title="#{siteLocationLst.dataObj.siteGroup}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.siteGroup']}" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.siteGroup}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.system}" title="#{siteLocationLst.dataObj.system}">
		                                <f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.system']}" styleClass="contentform" style="width: 60"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.system}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.siteType}" title="#{siteLocationLst.dataObj.siteType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Type" styleClass="contentform" style="width: 60"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.siteType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.stationType}" title="#{siteLocationLst.dataObj.stationType}">
		                                <f:facet name="header">
		                                    <h:outputText value="Station Type" styleClass="contentform" style="width: 60"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.stationType}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.company}" title="#{siteLocationLst.dataObj.company}">
		                                <f:facet name="header">
		                                    <h:outputText value="Company" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.company}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.siteCode}" title="#{siteLocationLst.dataObj.siteCode}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Code" styleClass="contentform" style="width: 50"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.siteCode}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column sortBy="#{siteLocationLst.dataObj.siteName}" title="#{siteLocationLst.dataObj.siteName}">
		                                <f:facet name="header">
		                                    <h:outputText value="Site Name" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{siteLocationLst.dataObj.siteName}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
								
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa002Bean.siteLocationList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="10">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchSiteLocation"
													maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchSiteLocation" style="background-color: #cccccc;"
													page="#{semmsa002Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsa002PopUpCommon_tab1AddSiteLocation"></a4j:support>
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
					    <rich:componentControl for="msa002PopUpCommon_tab1AddSiteLocation" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_04] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_05] -->
	<rich:modalPanel id="msa002PopUpCommon_tab4AddContractElUse" width="900" autosized="true" top="70">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Add Contract"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_tab4AddContractElUse" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_tab4AddContractElUse" attachTo="hide-msa002PopUpCommon_tab4AddContractElUse" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_tab4AddContractElUse">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['label.th_searchCriteria']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
						<td align="right" width="25%" >
								
								<h:outputText value="#{jspMsg['label.th_company']} :" styleClass="ms7"/>
                			</td>           		
					<td colspan="2">
                				<h:selectOneMenu id="tab4AddContractElUse_drpCompany" value="#{semmsa002Bean.contractElUseObjParam.company}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.companyList}"/>
								</h:selectOneMenu>
								
				<rich:spacer width="10"></rich:spacer>				
				<h:outputText value="#{jspMsg['label.warning.company']}" styleClass="ms7Red" rendered="#{semmsa002Bean.msgReqcompanyPopup != null}"/>
		                	</td>
		               </tr>
		               <tr>
		                	<td align="right" width="25%" style="white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:blue;" />
								<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                				<h:inputText id="tab4AddContractElUse_txtContractNo" value="#{semmsa002Bean.contractElUseObjParam.contractNo}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="20%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_name']} Site :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="tab4AddContractElUse_txtLocationName" value="#{semmsa002Bean.contractElUseObjParam.locationName}" 
                				size="30" maxlength="20"/>
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
					<a4j:commandButton value="Search" action="#{semmsa002Action.tab4AddContractElUse_doSearchContractElUse}"
					reRender="frmMsa002PopUpCommon_tab4AddContractElUse, dataTable_searchContractElUse" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmsa002Action.tab4AddContractElUse_doClearContractElUse}"
					reRender="frmMsa002PopUpCommon_tab4AddContractElUse, dataTable_searchContractElUse"
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
						<h:outputText value="#{jspMsg['label.th_searchResult']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchContractElUse" cellpadding="1" cellspacing="0" border="0" 
							var="contractElUseLst"  value="#{semmsa002Bean.contractElUseList}" reRender="dataTable_searchContractElUse, dataScrll_searchContractElUse" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								<!-- header -->
								<f:facet name="header">
					                <rich:columnGroup>
					                    <rich:column style="width:80px; text-align:center;"> 
											<h:outputText value="Select"/>
					                    </rich:column>  
					                    <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']}"/>
                                        </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_name']} Site"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.contstatus']}"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_startDate']}#{jspMsg['column.header.th_contract']}"/>
					                    </rich:column>
					                    <rich:column style="white-space:nowrap;">
					                        <h:outputText value="#{jspMsg['column.header.th_endDate']}#{jspMsg['column.header.th_contract']}"/>
					                    </rich:column>
					                </rich:columnGroup>
					            </f:facet>
					            <!-- header -->
						
								<!-- data -->
								<rich:column>
									<div align="center">
					<a4j:commandLink id="selectLink" value="select" style="height:15px; width:15px;" 
					rendered="#{contractElUseLst.dataObj.terminateOfcontractFlag != 'T'}"									 
										action="#{semmsa002Action.tab4AddContractElUse_doAddContractElUse}"
										reRender="msa002tab4_elUseOthSiteContractNo">
											<a4j:actionparam name="paramContractNo" value="#{contractElUseLst.dataObj.contractNo}" />
											
											<rich:componentControl for="msa002PopUpCommon_tab4AddContractElUse" operation="hide" event="onclick" />
										</a4j:commandLink>
			                        </div>
			                    </rich:column>
			                    <rich:column style="text-align:center;">
                                    <h:outputText value="#{contractElUseLst.dataObj.contractNo}" />
                                </rich:column>
			                    <rich:column>
			                        <h:outputText value="#{contractElUseLst.dataObj.locationName}" />
			                    </rich:column>	                   			                   
			                   <rich:column style="text-align:center">
				                        <h:outputText value="#{contractElUseLst.dataObj.contractStatusName}" rendered="#{contractElUseLst.dataObj.terminateOfcontractFlag != 'T'}"/>					                        
				                        
				                         <h:outputText value="#{contractElUseLst.dataObj.contractStatusName}" rendered="#{contractElUseLst.dataObj.terminateOfcontractFlag == 'T'}" 		
				                         styleClass="ms7Red"/>			       		
				                    </rich:column>
			                    <rich:column style="text-align:center">
			                        <h:outputText value="#{contractElUseLst.dataObj.effectiveDtStr}" />
			                    </rich:column>
			                    <rich:column style="text-align:center">
			                        <h:outputText value="#{contractElUseLst.dataObj.expireDtStr}" />
			                    </rich:column>
					            <!-- data -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="2">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa002Bean.contractElUseList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchContractElUse"
													maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchContractElUse" style="background-color: #cccccc;"
													page="#{semmsa002Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsa002PopUpCommon_tab4AddContractElUse"></a4j:support>
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
					    <rich:componentControl for="msa002PopUpCommon_tab4AddContractElUse" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_05] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->
<!-- >> [POPUP_06] -->
	<rich:modalPanel id="msa002PopUpCommon_tab1ChangeRequestName" width="900" autosized="true" top="70">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.header.chgreqname']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_tab1ChangeRequestName" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_tab1ChangeRequestName" attachTo="hide-msa002PopUpCommon_tab1ChangeRequestName" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_tab1ChangeRequestName">
		
			<div style="width:900px;height:500px; overflow:scroll; border:1px solid e0e0e0;"> 
				
				<!-- >> group contract request name info -->
				<rich:panel>
					<f:facet name="header">
						<h:panelGroup>
							<h:outputText value="#{jspMsg['label.header.contreqnamedetail']}"></h:outputText>
						</h:panelGroup>
					</f:facet>
				
					<h:panelGroup style="width:100%;">
						<table width="100%" align="center" border="0">
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.contractNo']}" ></h:outputText>
								</td>
								<td align="left">
									<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractNo}"></h:inputText>
								</td>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.startdt']} :" ></h:outputText>
								</td>
								<td align="left">
									<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteAppObjParam.effectiveDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            		</rich:calendar>
								</td>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.enddt']} :" ></h:outputText>
								</td>
								<td align="left">
									<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteAppObjParam.expireDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            		</rich:calendar>
								</td>
							</tr>
							
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['column.header.locationId']} :" ></h:outputText>
								</td>
								<td align="left">
									<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.locationId}"></h:inputText>
								</td>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['column.header.locationCode']} :" ></h:outputText>
								</td>
								<td align="left">
									<h:inputText disabled="true" value="#{semmsa002Bean.siteAppObjParam.locationCode}" styleClass="ms7"></h:inputText>
								</td>
								<td align="right">
									
								</td>
								<td align="left">
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.th_oldcontreqname']} :" ></h:outputText>
								</td>
								<td align="left">
									<h:inputText disabled="true" value="#{semmsa002Bean.siteAppObjParam.reqOfficer}" styleClass="ms7"></h:inputText>
								</td>
								<td align="right">
								</td>
								<td align="left">
								</td>
								<td align="right">
								</td>
								<td align="left">
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.th_contreqteam']} :" ></h:outputText>
								</td>
								<td align="left">
									<a4j:region>
										<h:selectOneMenu style="width:100%;" id="msa002Tab1_team" value="#{semmsa002Bean.chgReqObjParam.toTeam}" 
										onchange="msa002Tab1_GetMemberListJS();" styleClass="ms7">
											<f:selectItems value="#{semmsa002Bean.teamList}"/>
										</h:selectOneMenu>
										
										<a4j:jsFunction name="msa002Tab1_GetMemberListJS" action="#{semmsa002Action.getMemberList}" 
										reRender="msa002Tab1_member" />
									</a4j:region>
								</td>
								<td align="right">
								</td>
								<td align="left">
									
								</td>
								<td align="right">
								</td>
								<td align="left">
									
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.th_contreqname']} :" ></h:outputText>
								</td>
								<td align="left">
									<a4j:region>
										<h:selectOneMenu id="msa002Tab1_member" value="#{semmsa002Bean.chgReqObjParam.reqOfficer}" styleClass="ms7">
											<f:selectItems value="#{semmsa002Bean.memberList}"/>
										</h:selectOneMenu>
										
									</a4j:region>
								</td>
								<td align="right">
									<h:selectBooleanCheckbox id="msa002tab1_popupChgReq_chkReqOfficerManual" value="#{semmsa002Bean.chkReqOfficerManualPopup}"
									onclick="msa002tab1_doChkReqOfficerPopupJS();" style="margin:0 0 0 10px;" />
									
									<a4j:jsFunction name="msa002tab1_doChkReqOfficerPopupJS" reRender="msa002Tab1_member, msa002tab1_popupChgReq_reqOfficerManual" 
									action="#{semmsa002Action.doChkReqOfficerPopup}"/>
									
								</td>
								<td align="left">
									<h:inputText id="msa002tab1_popupChgReq_reqOfficerManual" value="#{semmsa002Bean.chgReqObjParam.reqOfficerManual}"  
	                            	disabled="#{!semmsa002Bean.chkReqOfficerManualPopup || semmsa002Bean.disabledModeViewOnly}"
									maxlength="200" styleClass="ms7" />
								</td>
								<td align="right">
									
								</td>
								<td align="left">
									
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.th_updateby']} :" ></h:outputText>
								</td>
								<td align="left">
									<h:inputText id="msa002tab1_popupChgReq_acqCreator" value="#{semmsa002Bean.chgReqObjParam.reqKey}" 
									maxlength="200" styleClass="ms7" disabled="true" />
								</td>
								<td align="right">
								</td>
								<td align="left">
								</td>
								<td align="right">
								</td>
								<td align="left">
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText styleClass="ms7" value="#{jspMsg['label.th_updatedt']} :" ></h:outputText>
								</td>
								<td align="left">
									<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.chgReqObjParam.updateDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            		</rich:calendar>
								</td>
								<td align="right">
								</td>
								<td align="left">
								</td>
								<td align="right">
								</td>
								<td align="left">
								</td>
							</tr>
							<tr>
								<td align="right">
									<h:outputText value="* " style="font-style:bold; color:red;" />
									<h:outputText styleClass="ms7" value="#{jspMsg['labal.th_changecontreqnameremark']} :" ></h:outputText>
								</td>
								<td align="left" colspan="5">
									<h:inputTextarea rows="5" style="width:80%;" value="#{semmsa002Bean.chgReqObjParam.remark}">
									
									</h:inputTextarea>
								</td>
								
							</tr>
							<tr>
								<td colspan="6">
									<a4j:commandButton value="Save" styleClass="rich-button" action="#{navAction.navi}" reRender="msa002PopUpCommon_tab1ChangeRequestName">
			            		
					            		<a4j:actionparam name="navModule" value="sa" />
										<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										<a4j:actionparam name="methodWithNavi" value="doSaveNewDocReq" />
									</a4j:commandButton>
									
									<rich:spacer width="10"></rich:spacer>
									
									<a4j:commandButton value="Clear" styleClass="rich-button" reRender="msa002PopUpCommon_tab1ChangeRequestName" action="#{semmsa002Action.doClearPopupChgReqDoc}">
									</a4j:commandButton>
								</td>
							</tr>
						</table>
					</h:panelGroup>
				</rich:panel>
				<!-- >> group contract request name info -->
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group outstanding work -->
				<rich:panel>
					<f:facet name="header">
						<h:panelGroup>
							<h:outputText value="#{jspMsg['label.th_osw']}"></h:outputText>
						</h:panelGroup>
					</f:facet>
				
					<h:panelGroup style="width:100%;">
						<!-- >> table result -->
						<center>
						<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
								<rich:dataTable style="width:100%;" id="dataTable_outstandingwork" cellpadding="1" cellspacing="0" border="0" 
								var="dataObj"  value="#{semmsa002Bean.siteAppDocRemainList}"
								reRender="dataTable_outstandingworke, dataScrll_outstandingwork" 
								rows="10" rowClasses="cur" styleClass="dataTable">
									
			                        <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_list']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.item}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_detail']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.detail}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
						            
						            <!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="2">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value=""></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="3">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_outstandingwork"
													maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_outstandingwork" style="background-color: #cccccc;"
													page="#{semmsa002Bean.scrollerPage}">
													
														<a4j:support event="onclick"  reRender="frmMsa002PopUpCommon_tab1ChangeRequestName"></a4j:support>
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
				<!-- >> group outstanding work -->
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group contract change request name history -->
				<rich:panel>
					<f:facet name="header">
						<h:panelGroup>
							<h:outputText value="#{jspMsg['label.header.contreqchghistlist']}"></h:outputText>
						</h:panelGroup>
					</f:facet>
				
					<h:panelGroup style="width:100%;">
						<!-- >> table result -->
						<center>
						<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
								<rich:dataTable style="width:100%;" id="dataTable_contchgreqnamehist" cellpadding="1" cellspacing="0" border="0" 
								var="dataObj"  value="#{semmsa002Bean.siteAppRegHistList}"
								reRender="dataTable_contchgreqnamehist, dataScrll_contchgreqnamehist" 
								rows="10" rowClasses="cur" styleClass="dataTable">
									
									
			                        
			                        <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.contractNo}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contstartdt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.effectiveDtStr}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                           	<rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contexpiredt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.expireDtStr}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_oldcontreqname']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.reqOfficerOld}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_contreqname']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.reqOfficerNew}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['labal.th_changecontreqnameremark']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.remark}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_updateby']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.modifyByStr}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['label.th_updatedt']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.modifyDtStr}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.contstatus']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.contractStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.slimsstatus']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.slimsStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
		                            <rich:column >
		                            	<f:facet name="header">
		                                    <h:outputText value="#{jspMsg['column.header.networkstatus']}" styleClass="contentform" style="width: 100"/>
		                                </f:facet>
		                                <div align="center">
		                                    <h:outputText value="#{dataObj.dataObj.networkStatus}" styleClass="contentform" />
		                                </div>
		                            </rich:column>
		                            
						            
						            <!-- footer -->
									<f:facet name="footer">
										<rich:columnGroup>
											<!-- > 1 -->
											<rich:column colspan="2">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value=""></f:param>
												</h:outputFormat>
											</rich:column>
											<!-- > 2 -->
											<rich:column colspan="9">
													<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_contchgreqnamehist"
													maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_contchgreqnamehist" style="background-color: #cccccc;"
													page="#{semmsa002Bean.scrollerPage}">
													
														<a4j:support event="onclick"  reRender="frmMsa002PopUpCommon_tab1ChangeRequestName"></a4j:support>
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
				<!-- >> group contract change request name history -->
				
				<div style="clear:both; height:10px;"></div>
				
			</div>
			
			
				<!-- >> additional button close -->
				<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
					<h:panelGroup style="float:right;">
						<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="msa002PopUpCommon_tab1ChangeRequestName" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << additional button close -->
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_06] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_07] -->
	<rich:modalPanel id="msa002PopUpCommon_tab1OldContract" width="900" autosized="true" top="70">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.header.popupcont']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_tab1OldContract" style="cursor:pointer" />
					<rich:componentControl for="msa002PopUpCommon_tab1OldContract" attachTo="hide-msa002PopUpCommon_tab1OldContract" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_tab1OldContract">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="#{jspMsg['label.th_searchCriteria']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
		                	<td align="right" width="25%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} :" styleClass="ms7"/>
                			</td>
                			<td width="20%">
                				<h:inputText id="tab4AddContractElUse_txtContractNo" value="#{semmsa002Bean.contractElUseObjParam.contractNo}" 
                				size="20" maxlength="20"/>
		                	</td>
		                	<td align="right" width="20%" style="white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_name']} Site :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="tab4AddContractElUse_txtLocationName" value="#{semmsa002Bean.contractElUseObjParam.locationName}" 
                				size="30" maxlength="20"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_company']} :" styleClass="ms7"/>
                			</td>
                			<td colspan="3">
                				<h:selectOneMenu id="tab4AddContractElUse_drpCompany" value="#{semmsa002Bean.contractElUseObjParam.company}" styleClass="ms7">
									<f:selectItems value="#{semmsa002Bean.companyList}"/>
								</h:selectOneMenu>
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
					<a4j:commandButton value="Search" action="#{semmsa002Action.tab4AddContractElUse_doSearchContractElUse}"
					reRender="frmMsa002PopUpCommon_tab4AddContractElUse, dataTable_searchContractElUse" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmsa002Action.tab4AddContractElUse_doClearContractElUse}"
					reRender="frmMsa002PopUpCommon_tab4AddContractElUse, dataTable_searchContractElUse"
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
						<h:outputText value="#{jspMsg['label.th_searchResult']}"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGrid>
					<rich:panel>
						<f:facet name="header">
							<h:panelGroup>
								<h:outputText value="#{jspMsg['label.header.contractinfolist']}"></h:outputText>
							</h:panelGroup>
						</f:facet>
						
						
						<h:panelGroup style="width:100%;">
							<!-- >> table result -->
							<center>
								<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
									
									<rich:dataTable style="width:100%;" id="dataTable_contInfoResultList" cellpadding="1" cellspacing="0" border="0" 
									var="dataObj"  value="" reRender="dataTable_contInfoResultList, dataScrll_contInfoResultList" 
									rows="10" rowClasses="cur" styleClass="dataTable">
										<rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="Select" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.networkstatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.sitename']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contstartdt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contexpiredt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
							            
							            <!-- footer -->
										<f:facet name="footer">
											<rich:columnGroup>
												<!-- > 1 -->
												<rich:column colspan="2">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmsa002Bean.contractElUseList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<!-- > 2 -->
												<rich:column colspan="3">
														<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_contInfoResultList"
															maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrll_contInfoResultList" style="background-color: #cccccc;"
															page="#{semmsa002Bean.scrollerPage}">
														<a4j:support event="onclick"  reRender="frmMsa002PopUpCommon_tab1OldContract"></a4j:support>
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
				</h:panelGrid>
				
				
				<h:panelGrid>
					<rich:panel>
						<f:facet name="header">
							<h:panelGroup>
								<h:outputText value="#{jspMsg['label.header.contSelectedList']}"></h:outputText>
							</h:panelGroup>
						</f:facet>
						
						
						<h:panelGroup style="width:100%;">
							<!-- >> table result -->
							<center>
								<div style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
									
									<rich:dataTable style="width:100%;" id="dataTable_contSelectedResultList" cellpadding="1" cellspacing="0" border="0" 
									var="dataObj"  value="" reRender="dataTable_contSelectedResultList, dataScrll_contSelectedResultList" 
									rows="10" rowClasses="cur" styleClass="dataTable">
										<rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="Remove" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.networkstatus']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.sitename']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contstartdt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
			                            <rich:column >
			                            	<f:facet name="header">
			                                    <h:outputText value="#{jspMsg['column.header.contexpiredt']}" styleClass="contentform" style="width: 100"/>
			                                </f:facet>
			                                <div align="center">
			                                    <h:outputText value="" styleClass="contentform" />
			                                </div>
			                            </rich:column>
							            
							            <!-- footer -->
										<f:facet name="footer">
											<rich:columnGroup>
												<!-- > 1 -->
												<rich:column colspan="2">
													<h:outputFormat value="#{msg['message.totalRecords']}">
														<f:param value="#{fn:length(semmsa002Bean.contractElUseList)}"></f:param>
													</h:outputFormat>
												</rich:column>
												<!-- > 2 -->
												<rich:column colspan="3">
														<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_contSelectedResultList"
															maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
															stepControls="hide" fastControls="auto" boundaryControls="auto" 
															id="dataScrll_contSelectedResultList" style="background-color: #cccccc;"
															page="#{semmsa002Bean.scrollerPage}">
														<a4j:support event="onclick"  reRender="frmMsa002PopUpCommon_tab1OldContract"></a4j:support>
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
				</h:panelGrid>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msa002PopUpCommon_tab1OldContract" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
			
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_07] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->
<!-- >> [POPUP_08] -->

<rich:modalPanel id="popupSearchContractNo" width="500"  height="600" autosized="true" minWidth="220" moveable="false">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popup.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSearchContractNo" style="cursor:pointer"/>
				<rich:componentControl for="popupSearchContractNo" attachTo="hidePopupSearchContractNo" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{popupSiteContractBean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
				<h:form id="popupFrmSearch"> 
				<h:panelGrid width="800" id="grdPopupSearchCriteria">
					<rich:panel id="pnlPopupSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPopupContractNo" value="#{popupSiteContractBean.popupContractCriteria.contractNo}"/>
				                	</td>
				                	<td align="right" width="20%">
									<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                			<h:inputText id="txtPopupSiteName" value="#{popupSiteContractBean.popupContractCriteria.siteName}"
		                			size="30"/>
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneMenu id="ddlPopupCompany" value="#{popupSiteContractBean.popupContractCriteria.company}">
										<f:selectItems value="#{popupSiteContractBean.companyList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
		                			<h:selectOneRadio id="rbtCurrentFlag" value="#{popupSiteContractBean.popupContractCriteria.currentFlag}"  styleClass="ms7" rendered="true">
		                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_curr_info']}" />
		                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_hist_info']} "/>
		                			</h:selectOneRadio>
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="dtbPopupContractNo,pnlPopupSearchResult,popupFrmError" >
									<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="PopupSiteContract" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
									<a4j:actionparam name="methodWithNavi" value="doSearchPopupContractNo" />
									</a4j:commandButton>
									<rich:spacer width="10"></rich:spacer>
									<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
					           	 	action="#{navAction.navi}" reRender="ddlPopupCompany,dtbPopupContractNo,pnlPopupSearchResult,pnlPopupSearchCriteria,popupFrmError">
					           		<a4j:actionparam name="navModule" value="common" />
									<a4j:actionparam name="navProgram" value="PopupSiteContract" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
									<a4j:actionparam name="methodWithNavi" value="doClearPopupContractNo" />
					           		</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
				
					</rich:panel>
				</h:panelGrid>
				
				<div style="overflow:auto; height:400px">
					<rich:panel id="pnlPopupSearchResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.resultTable.name']}" />
						</f:facet>
						<rich:dataTable id="dtbPopupContractNo" width="97%"
						value="#{popupSiteContractBean.contractList}" 
						rowKeyVar="RegInd" var="contractSP" 
						rows="#{popupSiteContractBean.rowPerPage}"
						rowClasses="cur" styleClass="dataTable">
						<a4j:support event="onRowClick"  action="#{popupSiteContractAction.getRowIdOnClick}" reRender="dtbPopupContractNo">
								<a4j:actionparam name="rowId" value="#{contractSP.rowId}" />
						</a4j:support>
				
						<rich:column id="ContractNoSelect" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="" />
							</f:facet>
							<div align="center">
							<a4j:commandLink id="cmlSelect" value="Select" action="#{navAction.navi}" 
							reRender="popupSearchContractNo,msa002tab1_contractNo_old,msgTopTab1">
							<a4j:actionparam name="navModule" value="sa" />
							<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							<a4j:actionparam name="moduleWithNavi" value="sa" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							<a4j:actionparam name="methodWithNavi" value="doSelectContractNo" />
							<a4j:actionparam name="siteInfoId" value="#{contractSP.siteInfoId}"/>
							<a4j:actionparam name="siteName" value="#{contractSP.siteName}"/>
							<a4j:actionparam name="contractNo" value="#{contractSP.contractNo}"/>
							<a4j:actionparam name="region" value="#{contractSP.region}"/>
							<a4j:actionparam name="remark" value="#{contractSP.remark}"/>
							<a4j:actionparam name="sendRenewId" value="EMPTY" />
							</a4j:commandLink>
							</div>
						</rich:column>
						<rich:column id="colContractNo" sortBy="#{contractSP.contractNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.popup.header.contractNo']}" styleClass="contentform" style="width: 100"/>
							</f:facet>
							<div align="center">
								<h:outputText value="#{contractSP.contractNo}" styleClass="contentform"   />
							</div>
						</rich:column>
						
						<rich:column id="colSiteName" sortBy="#{contractSP.siteName}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.popup.header.siteName']}" styleClass="contentform" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{contractSP.siteName}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column id="colEffDate" sortBy="#{contractSP.effDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.popup.effDate']}" styleClass="contentform"  style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.effDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colExpDate" sortBy="#{contractSP.expDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.popup.expDate']}" styleClass="contentform"  style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{contractSP.expDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbPopupContractNo" 
									maxPages="10" id="dstPopupContractNo" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</div>
				</h:form>
</rich:modalPanel>

<!-- >> [POPUP_08] -->
<!-- =================================================================================== -->
<!-- =================================================================================== -->


<!-- >> [POPUP_09] -->
	<!-- frmMsa002PopUpCommon_commonConfirm -->
	<rich:modalPanel id="msa002PopUpCommon_commonConfirm" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Confirm Popup"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa002PopUpCommon_commonConfirm" style="cursor:pointer" rendered="#{!semmsa002Bean.retResultObj.resultType eq '01'}" />
					<rich:componentControl for="msa002PopUpCommon_commonConfirm" attachTo="hide-msa002PopUpCommon_commonConfirm" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMsa002PopUpCommon_commonConfirm">
		
			<rich:panel id="pnlCommonConfirm">
                
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="1" style="margin:0 auto;width:100%;">
                
                	<h:panelGroup>
                		<table width="100%" border="0">
							<tr>
								<td align="center">
			                		
			                		<h:outputText value="#{semmsa002Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmsa002Bean.renderedMsgPopup}" styleClass="ms7red"></h:outputText>
			                		
			                		<h:outputText value="#{semmsa002Bean.retResultObj.resultMessage}" 
			                		rendered="#{semmsa002Bean.renderedMsgPopup == false}" styleClass="ms7"></h:outputText>
			         			</td>
			         		</tr>
			         	</table>
			         </h:panelGroup>
                    
                </h:panelGrid>        	
			
				<div style="clear:both; height:10px;"></div>
	
				<!-- >> button search/clear -->
				<h:panelGrid columns="1" style="margin:0 auto;width:100%;">
					<h:panelGroup >
						<table width="100%" border="0">
							<tr>
								<td align="center">
									
									<a4j:commandButton value="#{semmsa002Bean.retResultObj.okBtnLabel}" action="#{navAction.navi}"
									reRender="#{semmsa002Bean.retResultObj.val1},frmMsa002PopUpCommon_commonConfirm" 
									styleClass="rich-button" >
										<a4j:actionparam name="navModule" value="sa" />
										<a4j:actionparam name="navProgram" value="#{semmsa002Bean.retResultObj.navProgram}" />
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										<a4j:actionparam name="methodWithNavi" value="#{semmsa002Bean.retResultObj.methodWithNavi}" />
										<rich:componentControl for="msa002PopUpCommon_commonConfirm" operation="hide" event="onclick" />
									</a4j:commandButton>
									
									<rich:spacer width="5" />
									
									<a4j:commandButton value="#{semmsa002Bean.retResultObj.cancelBtnLabel}" styleClass="rich-button" 
									rendered="true"
									immediate="true" >
								    	<rich:componentControl for="msa002PopUpCommon_commonConfirm" operation="hide" event="onclick" />
									</a4j:commandButton>
								</td>
							</tr>
						</table>
							
						</div>
					</h:panelGroup>
				</h:panelGrid>
				<!-- << button search/clear -->
			</rich:panel>
		</a4j:form>
	
	</rich:modalPanel>
	<!-- frmMsa002PopUpCommon_commonConfirm -->
	<!-- << [POPUP_09] -->
	
	
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->