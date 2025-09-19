
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
	<rich:modalPanel id="tab3_panel_popupModalRetStatus" width="1000" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_edit_history']}#{jspMsg['label.th_info']} (#{jspMsg['label.th_info_rental']})"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-tab3_panel_popupModalRetStatus" style="cursor:pointer" />
					<rich:componentControl for="tab3_panel_popupModalRetStatus" attachTo="hide-tab3_panel_popupModalRetStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<!-- h:form id="tab3_frmTest" -->
			<!-- >> group repeat -->
		<h:panelGrid width="100%" id="popupDisplay3">
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
                                        <h:selectBooleanCheckbox id="siteInfoRentalService" value="#{item_.checkBox}" 
                                        rendered="#{semmsa002Bean.chkCopySiteInfo}">
                                            <a4j:support event="onclick" action="#{semmsi004Action.onSelected}" 
                                            reRender="popupDisplay3,siteInfoRentalService, siteInfoHistorySelected, btnCopy">
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
                            <table style="width:100%; border:0px solid e0e0e0;">
                                <tr>
		                            <td style="width:50%; border:solid dcdcdc 1px; vertical-align:top;">
		                                <!-- rate of rental (left) -->
		                                <table style="width:100%; border:solid 0px;">
		                                    <tr>
		                                        <td style="width:20%; text-align:right;">
		                                            <h:outputText value="#{jspMsg['label.th_rate_rental']} : " styleClass="ms7" /> 
		                                        </td>
		                                        <td style="width:80%; white-space:nowrap;">
		                                             <h:outputText value="#{item_.dataObj.rentAmt}" styleClass="#{item_.dataObj.rentAmtBG}">
		                                                  <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2"/>
		                                             </h:outputText>
		                                             <h:outputText value="#{jspMsg['label.th_unit_baht']} #{jspMsg['label.th_per']} " style="margin:0 5px 0 5px;" styleClass="ms7" />
		                                             
		                                        </td>
		                                    </tr>
		                                    <tr>
		                                        <td style="width:20%; text-align:right; vertical-align:top; white-space:nowrap;">
		                                            <h:outputText value="#{jspMsg['label.th_detail']} : " styleClass="ms7" />
		                                        </td>
		                                        <td style="width:80%;">
		                                            <h:outputText value="#{item_.dataObj.rentDetail}" styleClass="#{item_.dataObj.rentDetailBG}" style="width:100%;height:60px;border:solid dcdcdc 1px; vertical-align:top;"/>
		                                        </td>
		                                    </tr>
		                                    <tr>
		                                        <td colspan="2" style="text-align:left;">
		                                            <h:outputText value="#{jspMsg['label.tax']}" styleClass="ms7" />
		                                            <h:outputText value="#{item_.dataObj.rentWhtDetail}" styleClass="#{item_.dataObj.rentWhtDetailBG}" />
		                                        </td>
		                                    </tr>
		                                </table>
		                            </td>
		                            <td style="width:50%; border:solid dcdcdc 1px; vertical-align:top;">
		                                <!-- rate of service (right) -->
		                                <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="width:20%; text-align:right;">
                                                    <h:outputText value="#{jspMsg['label.th_rate_service']} : " styleClass="ms7" />
                                                </td>
                                                <td style="width:80%; white-space:nowrap;">
                                                     <h:outputText value="#{item_.dataObj.rentServiceAmt}" styleClass="#{item_.dataObj.rentServiceAmtBG}">
                                                        <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2"/>
                                                     </h:outputText>
                                                     <h:outputText value="#{jspMsg['label.th_unit_baht']} #{jspMsg['label.th_per']} " style="margin:0 5px 0 5px;" styleClass="ms7" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="width:20%; text-align:right; vertical-align:top; white-space:nowrap;">
                                                    <h:outputText value="#{jspMsg['label.th_detail']} : " styleClass="ms7" />
                                                </td>
                                                <td style="width:80%;">
                                                     <h:outputText value="#{item_.dataObj.rentServiceDetail}" styleClass="#{item_.dataObj.rentServiceDetailBG}" style="width:100%;height:60px;border:solid dcdcdc 1px; vertical-align:top;"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2"  style="width:20%; text-align:left;">
                                                    <h:outputText value="#{jspMsg['label.vat']} : " styleClass="ms7" />
                                                    <h:outputText value="#{item_.dataObj.rentServiceVatType}" styleClass="#{item_.dataObj.rentServiceVatTypeBG}" />
                                                    <rich:spacer width="10"/>
                                                    <h:outputText value="#{jspMsg['label.tax']} " styleClass="ms7" />
                                                    <h:outputText value="#{item_.dataObj.rentServiceWht}" styleClass="#{item_.dataObj.rentServiceWhtBG}" />
                                                </td>
                                            </tr>
                                        </table>
		                            </td>
		                        </tr>
		                        <tr>
                                    <td style="width:50%;height:60px; border:solid dcdcdc 1px; vertical-align:top;">
                                        <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="background-color:ececec;">
                                                    <h:outputText value="#{jspMsg['label.th_cost_rental']}#{jspMsg['label.th_area']}" styleClass="ms7" />
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:left;heigth:100px;">  
                                                    <h:outputText value="#{item_.dataObj.rentAreaAmtMemo}" styleClass="#{item_.dataObj.rentAreaAmtMemoBG}" escape="false"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td style="width:50%;height:60px; border:solid dcdcdc 1px; vertical-align:top;">
                                        <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="background-color:ececec;">
                                                    <h:outputText value="#{jspMsg['label.th_cost_rental']}#{jspMsg['label.th_area']}" styleClass="ms7"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:leftt;">
                                                    <h:outputText value="#{item_.dataObj.rentServiceAmtMemo}" styleClass="#{item_.dataObj.rentServiceAmtMemoBG}" escape="false"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width:50%;height:60px; border:solid dcdcdc 1px; vertical-align:top;">
                                        <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="background-color:ececec;">
                                                    <h:outputText value="#{jspMsg['label.th_cost_service']}#{jspMsg['label.th_setup']}#{jspMsg['label.th_hardware']}" styleClass="ms7"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:left;">  
                                                    <h:outputText value="#{item_.dataObj.rentSetupAmtMemo}" styleClass="#{item_.dataObj.rentSetupAmtMemoBG}" escape="false"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <td style="width:50%;height:60px; border:solid dcdcdc 1px; vertical-align:top;">
                                        <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="background-color:ececec;">
                                                    <h:outputText value="#{jspMsg['label.th_cost_']}#{jspMsg['label.th_other']}" styleClass="ms7"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:leftt;">
                                                    <h:outputText value="#{item_.dataObj.rentOtherAmtMemo}" styleClass="#{item_.dataObj.rentOtherAmtMemoBG}" escape="false"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="height:60px;border:solid dcdcdc 1px; vertical-align:top;">
                                        <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="background-color:ececec;">
                                                    <h:outputText value="#{jspMsg['label.specialDetail']}" styleClass="ms7"/>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:left;">  
                                                    <h:outputText value="#{item_.dataObj.rentSpecialAmtMemo}" styleClass="#{item_.dataObj.rentSpecialAmtMemoBG}" escape="false"/>
                                                </td>
                                            </tr>
                                        </table>
                                    </td>
                                    <tr>
                                    <td colspan="2" style="border:solid dcdcdc 1px; vertical-align:top;">
                                        <table style="width:100%; border:solid 0px;">
                                            <tr>
                                                <td style="width:50%;text-align:left;" align="left">
                                                    <h:outputText value="#{jspMsg['label.rentalAll']}" styleClass="ms7"/>
                                                    <rich:spacer width="10"/>
                                                    <h:outputText value="#{item_.dataObj.totalRentService}" styleClass="#{item_.dataObj.totalRentServiceBG}">
                                                        <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2"/>
                                                    </h:outputText>
                                                    <rich:spacer width="10"/>
                                                    <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                                                </td>
				                                <td style="width:50%;text-align:left;" align="left">
				                                    <h:outputText value="#{jspMsg['label.payCon']}" styleClass="ms7"/>
				                                    <rich:spacer width="10"/>
				                                    <h:outputText value="#{item_.dataObj.rentPaymentPeriod}" styleClass="#{item_.dataObj.rentPaymentPeriodBG}"/>
				                                </td>
                                            </tr>
                                        </table>
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
                    <rich:componentControl for="tab3_panel_popupModalRetStatus" operation="hide" event="onclick" />
                </a4j:commandButton>
                            
                <rich:spacer width="5"/>
                            
                <a4j:commandButton value="Copy Contract" styleClass="rich-button"
                reRender="oppContent" action="#{navAction.navi}" rendered="#{semmsa002Bean.chkCopySiteInfo}"
                disabled="#{semmsa002Bean.disabledBtnCopySiteInfo}">
                    <a4j:actionparam name="navModule" value="si" />
                    <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                    <a4j:actionparam name="moduleWithNavi" value="si" />
                    <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                    <a4j:actionparam name="methodWithNavi" value="doCopyRentalService" />
                                
                </a4j:commandButton>
                <rich:spacer width="5"/>
                            
                <a4j:commandButton value="Close" styleClass="rich-button" immediate="true" rendered="#{semmsa002Bean.chkCopySiteInfo}">
                    <rich:componentControl for="tab3_panel_popupModalRetStatus" operation="hide" event="onclick" />
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
	<rich:modalPanel id="tab3_panel_popupHistoryRental" width="1000" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info']} (#{jspMsg['label.th_info_rental']})"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-tab3_panel_popupHistoryRental" style="cursor:pointer" />
					<rich:componentControl for="tab3_panel_popupHistoryRental" attachTo="hide-tab3_panel_popupHistoryRental" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<!-- h:form id="tab3_frmTest" -->
			<!-- >> group repeat -->
		<h:panelGrid width="100%" id="popupHistory3">
        <h:panelGroup >
        <rich:panel  style="width:100%;" styleClass="sem_autoScrollbar">
        <!-- h:form id="tab2_frmTest" -->
            <!-- >> group repeat -->
            
            <div align="center">
                    <h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.dataNotFound']}" rendered="#{semmsa002Bean.chkDataNotFound}" />
            </div>
            <rich:dataTable style="width:98%;" cellpadding="1" cellspacing="0" border="0" 
            var="item_"  value="#{semmsa002Bean.siteAppPopupHistoryList}" reRender="" 
            rows="" rowClasses="cur" styleClass="dataTable">
                
                <rich:column >
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.contractNo}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column >
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['column.header.reqType']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.reqType}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column >
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.th_changeDate']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.effectiveDtStr}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column >
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.expire_Dt']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.expireDtStr}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column >
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['column.header.th_expenseType']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.expenseType}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column>
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.th_cost_rental']} / #{jspMsg['label.th_cost_service']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.rentAmt}" styleClass="contentform"  >
                			<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                		</h:outputText>
                	</div>
                </rich:column>
                
                <rich:column>
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['column.header.period']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.rentPeriod}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column>
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.th_withHolding_tax']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.rentWhtType}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column>
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.th_withHolding_tax_rate']}" styleClass="contentform" style="width: 100">
                			<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                		</h:outputText>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.rentWhtRate}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column>
              		<f:facet name="header">
                		<h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.rentVatType}" styleClass="contentform"  />
                	</div>
                </rich:column>
                
                <rich:column>
              		<f:facet name="header">
                		<h:outputText value="#{jspMsg['label.th_condition_ofPayment']}" styleClass="contentform" style="width: 100"/>
                	</f:facet>
                	<div align="center">
                		<h:outputText value="#{item_.dataObj.rentPaymentPeriod}" styleClass="contentform"  />
                	</div>
                </rich:column>
           
            </rich:dataTable>
            </rich:panel>
            <rich:panel style="float:right;background-color:none;border-style:none;">
              
                            
                <a4j:commandButton value="Close" styleClass="rich-button" immediate="true" >
                    <rich:componentControl for="tab3_panel_popupHistoryRental" operation="hide" event="onclick" />
                </a4j:commandButton>
            </rich:panel>
            
        </h:panelGroup>
    </h:panelGrid>	 
			<!-- << group repeat -->
        		
		<!-- /h:form --> 
	</rich:modalPanel>	
		
	<!-- << [POPUP_02] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

		<!-- >> [POPUP_03] -->
		
		<!-- << [POPUP_03] -->
<!-- =================================================================================== -->
<!-- =================================================================================== -->
