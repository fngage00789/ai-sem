
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
	<rich:modalPanel id="tab2_panel_popupModalRetStatus" width="1000" height="600" >	
	   <f:facet name="header">
                   <h:outputText value="#{jspMsg['label.th_edit_history']}#{jspMsg['label.th_info']} (#{jspMsg['label.th_info_contract']})" style="width: 100%"/>
       </f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-tab2_panel_popupModalRetStatus" style="cursor:pointer" />
					<rich:componentControl for="tab2_panel_popupModalRetStatus" attachTo="hide-tab2_panel_popupModalRetStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<h:panelGrid width="100%" id="popupDisplay2">
		<h:panelGroup >
        <rich:panel  style="width:100%; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
		<!-- h:form id="tab2_frmTest" -->
			<!-- >> group repeat -->
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
			                                         <h:selectBooleanCheckbox id="siteInfoContractSelected" value="#{item_.checkBox}" 
				                                        rendered="#{semmsa002Bean.chkCopySiteInfo}">
				                                            <a4j:support event="onclick" action="#{semmsi004Action.onSelected}" 
				                                            reRender="popupDisplay2, siteInfoRentalService, siteInfoHistorySelected, btnCopy">
				                                                <a4j:actionparam name="rowId" value="#{item_.dataObj.rowId}" />
				                                                <a4j:actionparam name="checkBox" value="#{item_.checkBox}" />
				                                                <a4j:actionparam name="tab" value="01" />
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
			                            <table style="width:100%;">
			                                <tr>
			                                    <td style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_landlordName']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorName}" style="" styleClass="#{item_.dataObj.lessorNameBG}" />
			                                    </td>
			                                </tr>
			                            </table>
			                            
			                            <table style="width:100%; border:1px solid e0e0e0;" border="0">
			                                <tr>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_number']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:40%; text-align:left;" colspan="3">
			                                        <h:outputText value="#{item_.dataObj.lessorHouseNo}" style="" styleClass="#{item_.dataObj.lessorHouseNoBG}" />
			                                    </td>
			                                    
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_building']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:20%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorBuilding}" style="" styleClass="#{item_.dataObj.lessorBuildingBG}" />
			                                    </td>
			                                </tr>
			                                <tr>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_floor']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:10%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorFloor}" style="" styleClass="#{item_.dataObj.lessorFloorBG}" />
			                                    </td>
			                                    <td valign="bottom" style="width:10%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_street']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:20%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorStreet}" style="" styleClass="#{item_.dataObj.lessorStreetBG}" />
			                                    </td>
			                                    <td valign="bottom" style="width:10%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_tambol']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:25%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorTambon}" style="" styleClass="#{item_.dataObj.lessorTambonBG}" />
			                                    </td>
			                                </tr>
			                                <tr>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_district']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:10%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.amphurName}" style="" styleClass="#{item_.dataObj.amphurNameBG}" />
			                                    </td>
			                                    <td valign="bottom" style="width:10%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_province']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:25%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.provinceName}" style="" styleClass="#{item_.dataObj.provinceNameBG}" />
			                                    </td>
			                                    <td valign="bottom" style="width:10%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_postCode']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:25%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorPostCode}" style="" styleClass="#{item_.dataObj.lessorPostCodeBG}" />
			                                    </td>
			                                </tr>
			                                <tr>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_personalTaxId']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:10%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.lessorTaxId}" style="" styleClass="#{item_.dataObj.lessorTaxIdBG}" />
			                                    </td>
			                                    <td style="">
			                                       
			                                    </td>
			                                    <td style="">
			                                        
			                                    </td>
			                                    <td style="">
			                                        
			                                    </td>
			                                    <td style="">
			                                       
			                                    </td>
			                                </tr>
			                                 <tr>
                                                <td valign="bottom" style="width:20%; text-align:right;">
                                                     <h:outputText value="#{jspMsg['label.th_contactName']} : " style="" styleClass="ms7" />
                                                </td>
                                                <td valign="top" style="width:40%; text-align:left;" colspan="3">
                                                    <h:outputText value="#{item_.dataObj.contactName}" style="" styleClass="#{item_.dataObj.contactNameBG}" />
                                                </td>
                                                
                                                <td valign="bottom" style="width:20%; text-align:right;">
                                                    <h:outputText value="#{jspMsg['label.th_localPhone']} : " style="" styleClass="ms7" />
                                                </td>
                                                <td valign="top" style="width:20%; text-align:left;">
                                                    <h:outputText value="#{item_.dataObj.contactTel}" style="" styleClass="#{item_.dataObj.contactTelBG}" />
                                                </td>
                                            </tr>
			                                <tr>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:10%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.contactMobile}" style="" styleClass="#{item_.dataObj.contactMobileBG}" />
			                                    </td>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.en_fax']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:10%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.contactFax}" style="" styleClass="#{item_.dataObj.contactFaxBG}" />
			                                    </td>
			                                    <td valign="bottom" style="width:20%; text-align:right;">
			                                        <h:outputText value="#{jspMsg['label.en_email']} : " style="" styleClass="ms7" />
			                                    </td>
			                                    <td valign="top" style="width:20%; text-align:left;">
			                                        <h:outputText value="#{item_.dataObj.contactEmail}" style="" styleClass="#{item_.dataObj.contactEmailBG}" />
			                                    </td>
			                                </tr>
			                            </table>
			                            <!-- detail << -->
                                    </div>
                                </rich:column>
            </rich:dataTable>
            </rich:panel>
            <rich:panel style="float:right;background-color:none;border-style:none;">
                <a4j:commandButton value="Ok" styleClass="rich-button" immediate="true" rendered="#{semmsa002Bean.chkCopySiteInfo == false}">
                    <rich:componentControl for="tab2_panel_popupModalRetStatus" operation="hide" event="onclick" />
                </a4j:commandButton>
                            
                <rich:spacer width="5"/>
                            
                <a4j:commandButton value="Copy Contract" styleClass="rich-button"
                reRender="oppContent" action="#{navAction.navi}" rendered="#{semmsa002Bean.chkCopySiteInfo}"
                disabled="#{semmsa002Bean.disabledBtnCopySiteInfo}">
                    <a4j:actionparam name="navModule" value="si" />
                    <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                    <a4j:actionparam name="moduleWithNavi" value="si" />
                    <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                    <a4j:actionparam name="methodWithNavi" value="doCopyContract" />
                                
                </a4j:commandButton>
                <rich:spacer width="5"/>
                            
                <a4j:commandButton value="Close" styleClass="rich-button" immediate="true" rendered="#{semmsa002Bean.chkCopySiteInfo}">
                    <rich:componentControl for="tab2_panel_popupModalRetStatus" operation="hide" event="onclick" />
                </a4j:commandButton>
            </rich:panel>
            
        </h:panelGroup>
	</h:panelGrid>

			
			
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
