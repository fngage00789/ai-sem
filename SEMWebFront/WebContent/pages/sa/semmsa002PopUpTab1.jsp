
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_01] -->
	<!-- popupModalRetStatus -->
	<rich:modalPanel id="tab1_panel_popupModalRetStatus" width="1000" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_edit_history']}#{jspMsg['label.th_info']} (#{jspMsg['label.th_info_station']})"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-tab1_panel_popupModalRetStatus" style="cursor:pointer" />
					<rich:componentControl for="tab1_panel_popupModalRetStatus" attachTo="hide-tab1_panel_popupModalRetStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<!-- h:form id="tab1_frmTest" -->
			<!-- >> group repeat -->
	   <h:panelGrid width="100%" id="popupDisplay1">
	      <h:panelGroup >
	        <rich:panel  style="width:100%; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
	            <div align="center">
	                    <h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.dataNotFound']}" rendered="#{semmsa002Bean.chkDataNotFound}" />
	            </div>
	            <rich:dataTable style="width:98%;" cellpadding="1" cellspacing="0" border="0" 
	            var="item_"  value="#{semmsa002Bean.siteAppPopupHistoryList}" reRender="" 
	            rows="" rowClasses="cur" styleClass="dataTable">
	                <rich:column>
	                    <div align="center">
							<!-- top >> -->
							<table style="width:100%; background-color:cada30; border:2px solid e0e0e0;">
								<tr>
									<td style="width:25%; text-align:center;">
									    <h:selectBooleanCheckbox id="siteInfoHistorySelected" value="#{item_.checkBox}" 
                                        rendered="#{semmsa002Bean.chkCopySiteInfo}">
                                            <a4j:support event="onclick" action="#{semmsi004Action.onSelected}" 
                                            reRender="popupDisplay1, siteInfoRentalService, siteInfoHistorySelected, btnCopy">
                                                <a4j:actionparam name="rowId" value="#{item_.dataObj.rowId}" />
                                                <a4j:actionparam name="checkBox" value="#{item_.checkBox}" />
                                            </a4j:support>
                                        </h:selectBooleanCheckbox>
									
									    <rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.th_approveNumber']} : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputText value="#{item_.dataObj.docNo}" style="font-style: italic;" styleClass="ms7" />
									</td>
									<td style="width:25%; text-align:center;">
										<h:outputText value="#{jspMsg['label.th_contractNumber']} : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputText value="#{item_.dataObj.contractNo}" style="font-style: italic;" styleClass="ms7" />
									</td>
									<td style="width:25%; text-align:center;">
										<h:outputText value="#{jspMsg['label.th_type']} : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputText value="#{item_.dataObj.reqType}" style="font-style: italic;" styleClass="ms7" />
									</td>
									<td style="width:25%; text-align:center;">
										<h:outputText value="#{jspMsg['label.th_lastUpdateDate']} : " style="font-weight:bold;" styleClass="ms7" />
										<h:outputText value="#{item_.dataObj.updateDTStr}" style="font-style: italic;" styleClass="ms7" />
									</td>
								</tr>
							</table>
							<!-- top << -->
							
							<!-- detail >> -->
							<table style="width:100%; border:0px solid e0e0e0;" border="0" >
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_name']}#{jspMsg['label.th_site']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.locationName}" style="" styleClass="#{item_.dataObj.locationNameBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value=" Co-Locate #{jspMsg['label.th_with']} #{jspMsg['label.th_company']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.coLocateCompany}" style="" styleClass="#{item_.dataObj.coLocateCompanyBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_contractNumber']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.coContractNo}" style="" styleClass="#{item_.dataObj.coContractNoBG}" />
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_phase']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.phase}" style="" styleClass="#{item_.dataObj.phaseBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_location']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.region}" style="" styleClass="ms7" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_type']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.stationType}" style="" styleClass="#{item_.dataObj.stationTypeBG}" />
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_landOn']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="text-align:left;" colspan="5">
										<h:outputText value="#{item_.dataObj.locationType}" style="" styleClass="#{item_.dataObj.locationTypeBG}" />
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_number']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.locationAddressNo}" style="" styleClass="#{item_.dataObj.locationAddressNoBG}" />
									</td>
									<td valign="top" style="width:12%; text-align:right;">
									
									</td>
									<td valign="top" style="width:18%; text-align:left;">
									
									</td>
									<td valign="top" style="width:12%; text-align:right;">
										
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_floor']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="text-align:left;" colspan="2">
										<table style="width:100%;" border="0">
                                          <tr>
                                              <td valign="top" style="width:25%;text-align:left;"><h:outputText value="#{item_.dataObj.locationFloor}" style="" styleClass="#{item_.dataObj.locationFloorBG}" /></td>
                                              <td valign="bottom" style="width:25%;text-align:right;"><h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="" styleClass="ms7" /></td>
                                              <td valign="top" style="width:25%;text-align:left;"><h:outputText value="#{item_.dataObj.locationRoomNo}" style="" styleClass="#{item_.dataObj.locationRoomNoBG}" /></td>
                                              <td valign="bottom" style="width:25%;text-align:right;"><h:outputText value="#{jspMsg['label.th_street']} : " style="" styleClass="ms7" /></td>
                                          </tr>
                                        </table>
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.locationStreet}" style="" styleClass="#{item_.dataObj.locationStreetBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_tambol']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.locationTambon}" style="" styleClass="#{item_.dataObj.locationTambonBG}" />
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_district']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.amphurName}" style="" styleClass="#{item_.dataObj.amphurNameBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_province']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.provinceName}" style="" styleClass="#{item_.dataObj.provinceNameBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_postCode']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.locationPostCode}" style="" styleClass="#{item_.dataObj.locationPostCodeBG}" />
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_landArea']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.landArea}" style="" styleClass="#{item_.dataObj.landAreaBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_terraceArea']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.deckArea}" style="" styleClass="#{item_.dataObj.deckAreaBG}" />
									</td>
									<td valign="top" style="width:12%; text-align:right;">
										
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										
									</td>
								</tr>
								<tr>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_someOfBuildingArea']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.buildingArea}" style="" styleClass="#{item_.dataObj.buildingAreaBG}" />
									</td>
									<td valign="bottom" style="width:12%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_roomArea']} : " style="" styleClass="ms7" />
									</td>
									<td valign="top" style="width:18%; text-align:left;">
										<h:outputText value="#{item_.dataObj.roomArea}" style="" styleClass="#{item_.dataObj.roomAreaBG}" />
									</td>
									<td valign="top" style="width:12%; text-align:right;">
										
									</td>
									<td valign="top" style="width:18%; text-align:left;">
									</td>
								</tr>
								<tr>
                                    <td valign="bottom" style="width:12%; text-align:right;">
                                        <h:outputText value="#{jspMsg['label.th_otherArea']} : " style="" styleClass="ms7" />
                                    </td>
                                    <td valign="top" style="text-align:left;" colspan="5">
                                        <h:outputText value="#{item_.dataObj.areaRemark}" style="" styleClass="#{item_.dataObj.areaRemarkBG}" />
                                    </td>
                                    
                                </tr>
							</table>
						</div>	
							
							
							<!-- sub detail << -->
						<div id="msa002tableSub" style="width:100%; overflow:scroll; border:1px solid e0e0e0;text-align:center;"> 
							<rich:dataTable style="width:100%;" id="dataTabMsa002tab1" cellpadding="1" cellspacing="0" border="0" 
                            var="sub_item"  value="#{item_.dataObj.siteAppSiteList}" reRender="dataTabMsa002tab1" 
                            rows="" rowClasses="cur" styleClass="dataTable">
                            
                                <!-- header -->
                                <f:facet name="header">
                                    <rich:columnGroup>
                                       
                                        <rich:column breakBefore="true" style="white-space:nowrap;"> 
                                            <h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>  
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.locationCode']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.locationName']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                       
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.siteCode']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.siteGroup']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.system']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.siteType']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.stationType']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.company']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                    </rich:columnGroup>
                                </f:facet>
                                <!-- header -->
                        
                                <!-- data -->
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.locationId}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.locationCode}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.locationName}" styleClass="contentform"  />
                                </rich:column>
                                
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.siteCode}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.siteGroup}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.system}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.siteType}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.stationType}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.company}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{sub_item.dataObj.siteName}" styleClass="contentform"  />
                                </rich:column>
                                <!-- data -->
                                
                                <!-- footer -->
                                
                                <!-- footer -->
                                
                            </rich:dataTable>
								
                          </div>
                         </rich:column>
                     
                        </rich:dataTable>
                    </rich:panel>
                    <rich:panel style="float:right;background-color:none;border-style:none;">
                            <a4j:commandButton value="Ok" styleClass="rich-button" immediate="true" rendered="#{semmsa002Bean.chkCopySiteInfo == false}">
                                <rich:componentControl for="tab1_panel_popupModalRetStatus" operation="hide" event="onclick" />
                            </a4j:commandButton>
                            
                            <rich:spacer width="5"/>
                            
                            <a4j:commandButton id="btnCopy" value="Copy Site Info" styleClass="rich-button"
                            action="#{navAction.navi}" rendered="#{semmsa002Bean.chkCopySiteInfo}" reRender="oppContent"
                            disabled="#{semmsa002Bean.disabledBtnCopySiteInfo}">
                                <a4j:actionparam name="navModule" value="si" />
                                <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                                <a4j:actionparam name="moduleWithNavi" value="si" />
                                <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                                <a4j:actionparam name="methodWithNavi" value="doCopySiteInfo" />
                            </a4j:commandButton>
                           
                            <rich:spacer width="5"/>
                            
                            <a4j:commandButton id="btnClose" value="Close" styleClass="rich-button" immediate="true" rendered="#{semmsa002Bean.chkCopySiteInfo}">
                                <rich:componentControl for="tab1_panel_popupModalRetStatus" operation="hide" event="onclick" />
                            </a4j:commandButton>
                        </rich:panel>
                </h:panelGroup>
            </h:panelGrid>
						
			<!-- << group repeat -->

		<!-- /h:form --> 
	</rich:modalPanel>
	<!-- popupModalRetStatus -->
	<!-- << [POPUP_01] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

		<!-- >> [POPUP_02] -->
		
		<!-- << [POPUP_02] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

		<!-- >> [POPUP_03] -->
		
		<!-- << [POPUP_03] -->
<!-- =================================================================================== -->
<!-- =================================================================================== -->
