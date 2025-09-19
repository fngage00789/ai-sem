
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
	<rich:modalPanel id="tab5_panel_popupModalRetStatus" width="1000" autosized="true">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_edit_history']}#{jspMsg['label.th_info']} (#{jspMsg['label.th_info_deposit_electrict_bill']})"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-tab5_panel_popupModalRetStatus" style="cursor:pointer" />
					<rich:componentControl for="tab5_panel_popupModalRetStatus" attachTo="hide-tab5_panel_popupModalRetStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<!-- h:form id="tab5_frmTest" -->
			<h:panelGrid width="100%" id="popupDisplay5">
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
					<!-- >> group repeat -->
			 
							<!-- top >> -->
							<table style="width:100%; background-color:cada30; border:2px solid e0e0e0;">
                                <tr>
                                    <td style="width:25%; text-align:center;">
                                    	<h:selectBooleanCheckbox id="siteInfoDepositElectric" value="#{item_.checkBox}" 
                                        rendered="#{semmsa002Bean.chkCopySiteInfo}">
                                            <a4j:support event="onclick" action="#{semmsi004Action.onSelected}" 
                                            reRender="popupDisplay5,siteInfoDepositElectric, siteInfoHistorySelected, btnCopy">
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
                                    <td style="width:17%;text-align:right;">
                                        <h:outputText value="#{jspMsg['label.th_insure_money']}#{jspMsg['label.th_cost_electrict']} : " style="" styleClass="ms7" />
                                    </td>
                                    <td style="width:7%;text-align:left;" >
                                        <h:outputText value="#{item_.dataObj.depositFlagDesc}" style="" styleClass="#{item_.dataObj.depositFlagDescBG}">
                                            <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </td>
                                     <td style="text-align:left;">
                                        <h:outputText value="#{item_.dataObj.bgDepositDesc}" style="" styleClass="#{item_.dataObj.bgDepositDescBG}" />
                                    </td>
                                     <td style="text-align:left;">
                                       
                                    </td>
                                     <td style="text-align:left;">
                                        <h:outputText value="#{item_.dataObj.bgDepositVatDesc}" style="" styleClass="#{item_.dataObj.bgDepositVatDescBG}" />
                                    </td>
                                     <td style="text-align:left;">
                                        <h:outputText value="#{item_.dataObj.cashDepositDesc}" style="" styleClass="#{item_.dataObj.cashDepositDescBG}" />
                                    </td>
                                    <td style="text-align:left;">
                                        <h:outputText value="#{item_.dataObj.cashDepositVatDesc}" style="" styleClass="#{item_.dataObj.cashDepositVatDescBG}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align:right;">
                                        <h:outputText value="#{jspMsg['label.th_remark']} : " style="" styleClass="ms7" />
                                    </td>
                                     <td colspan="6" style="text-align:left;">
                                        <h:outputText value="#{item_.dataObj.elUseDesc}" style="" styleClass="#{item_.dataObj.elUseDescBG}" />
                                    </td>
                                </tr>
                            </table>
							<!-- detail << -->
                          </div>
                        </rich:column>
                    </rich:dataTable>
                </rich:panel>
              
                <rich:panel style="float:right;background-color:none;border-style:none;">
                	<a4j:commandButton value="Copy Deposit Electric" styleClass="rich-button"
	                reRender="oppContent" action="#{navAction.navi}" rendered="#{semmsa002Bean.chkCopySiteInfo}"
	                disabled="#{semmsa002Bean.disabledBtnCopySiteInfo}">
	                    <a4j:actionparam name="navModule" value="si" />
	                    <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
	                    <a4j:actionparam name="moduleWithNavi" value="si" />
	                    <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
	                    <a4j:actionparam name="methodWithNavi" value="doCopyDepositElectric" />
	                                
	                </a4j:commandButton>
	                <rich:spacer width="5"/>
                
	                <a4j:commandButton value="Close" styleClass="rich-button" immediate="true">
                        <rich:componentControl for="tab5_panel_popupModalRetStatus" operation="hide" event="onclick" />
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
