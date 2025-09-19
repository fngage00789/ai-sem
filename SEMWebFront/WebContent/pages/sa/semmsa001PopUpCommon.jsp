
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

<!-- =================================================================================== -->
<!-- =================================================================================== -->

<!-- =================================================================================== -->
<!-- =================================================================================== -->		
		
	<!-- >> [POPUP_00] -->
	<!-- msa001PopUpCommon_retStatus -->
	<rich:modalPanel id="msa001PopUpCommon_retStatus" autosized="true" rendered="#{semmsa001Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-msa001PopUpCommon_retStatus" style="cursor:pointer" />
					<rich:componentControl for="msa001PopUpCommon_retStatus" attachTo="hide-msa001PopUpCommon_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa001_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="200">
				<!-- /// -->
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa001Bean.renderedMsgAlert}">
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
					<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="msa001PopUpCommon_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- msa001PopUpCommon_retStatus -->
	<!-- << [POPUP_00] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_03] -->
	<!-- msa001PopUpCommon_NearestSite -->
    <rich:modalPanel id="msa001PopUpCommon_NearestSite" autosized="true"> 
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="#{jspMsg['label.th_nearSiteCost']}"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hide-msa001PopUpCommon_NearestSite" style="cursor:pointer" />
                    <rich:componentControl for="msa001PopUpCommon_NearestSite" attachTo="hide-msa001PopUpCommon_NearestSite" operation="hide" event="onclick"  />
                </div>
            </h:panelGroup>
        </f:facet>
        
		<!-- h:form id="tab1_frmTest" -->
        <!-- >> group repeat -->
       	<h:panelGrid width="1000" id="popupDisplay">
          	<h:panelGroup >
	            <rich:panel  style="width:1000px; height:350px; overflow:auto; text-align:center;" styleClass="sem_autoScrollbar">
	                <div align="center">
	                        <h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.dataNotFound']}" rendered="#{fn:length(semmsa001Bean.nearestSiteList) == 0}" />
	                </div>
	                
	                <!-- top >> -->
	                <table width="100%" style="background-color:cada30; border:2px solid e0e0e0;">
	                    <tr>
	                        <td style="width:20%; text-align:center;">
	                            <h:outputText value="#{jspMsg['label.th_approveNumber']} : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="#{semmsa001Bean.siteAppObjTmp.docNo}" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:25%; text-align:center;">
	                            <h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="#{semmsa001Bean.siteAppObjTmp.contractNo}" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:20%; text-align:center;">
	                            <h:outputText value="#{jspMsg['label.th_type']} : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="#{semmsa001Bean.siteAppObjTmp.docTypeText}" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                        <td style="width:35%; text-align:center;">
	                            <h:outputText value="#{jspMsg['label.th_lastUpdateDate']} : " style="font-weight:bold;" styleClass="ms7" />
	                            <h:outputText value="#{semmsa001Bean.siteAppObjTmp.updateDTStr}" style="font-style: italic;" styleClass="ms7" />
	                        </td>
	                    </tr>
	                </table>
	           		<!-- top << -->
	           		
	           		<div style="clear:both; height:0px;"></div>
	                
	                <rich:dataTable style="width:960px;" cellpadding="1" cellspacing="0" border="0" 
	                var="item_"  value="#{semmsa001Bean.nearestSiteList}" reRender="" 
	                rows="" rowClasses="cur" styleClass="dataTable">
	                
				       	<!-- header -->
			           	<f:facet name="header">
			               <rich:columnGroup>
			                   <rich:column breakBefore="true" style="white-space:nowrap;"> 
			                       <h:outputText value="#{jspMsg['column.header.th_location']}" styleClass="contentform" style="width: 40"/>
			                   </rich:column>  
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="#{jspMsg['column.header.th_company']}" styleClass="contentform" style="width: 35"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="#{jspMsg['column.header.th_contractNumber']}" styleClass="contentform" style="width: 60"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="Location ID" styleClass="contentform" style="width: 60"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="Location Name" styleClass="contentform" style="width: 100"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="Site ID/ Site Code/ Site Type/ Station" styleClass="contentform" style="width: 100"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="#{jspMsg['column.header.th_locationArea']}" styleClass="contentform" style="width: 75"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="#{jspMsg['column.header.th_beginDtm']}" styleClass="contentform" style="width: 90"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="#{jspMsg['column.header.th_endDtm']}" styleClass="contentform" style="width: 90"/>
			                   </rich:column>
			                   <rich:column style="white-space:nowrap;">
			                       <h:outputText value="#{jspMsg['column.header.th_rentPerYear']}" styleClass="contentform" style="width: 75"/>
			                   </rich:column>
			               </rich:columnGroup>
			           </f:facet>
			           <!-- header -->
			                       
					   <!-- data -->
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.region}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.company}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.contractNo}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.locationId}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.locationName}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.siteDetail}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.locationArea}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.effectiveDtStr}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:center;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.expireDtStr}" styleClass="contentform"  />
					   </rich:column>
					   <rich:column style="text-align:right;" styleClass="#{item_.dataObj.styleClassName}">
					       <h:outputText value="#{item_.dataObj.rentAmtPerYear}" styleClass="contentform">
					       		<f:convertNumber pattern="#,##0.00" maxIntegerDigits="20" maxFractionDigits="2" />
					       </h:outputText>
					   </rich:column>
					   <!-- data -->
	                     
					</rich:dataTable>
				</rich:panel>
          
				<div style="clear:both; height:0px;"></div>
					
				<table border="0" align="right">
					<tr>
						<td width="25%" align="right">
							<h:outputText id="msa001_PopupNearest_minRent_label" value="#{jspMsg['label.minRent']}" styleClass="ms7"></h:outputText>
							
							<h:inputText value="#{semmsa001Bean.minRent}" id="msa001_PopupNearest_minRent" 
								maxlength="15" style="text-align:right;" styleClass="ms7" disabled="true">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
							</h:inputText>
						</td>
						<td width="25%" align="right">
							<h:outputText id="msa001_PopupNearest_maxRent_label" value="#{jspMsg['label.maxRent']}" styleClass="ms7"></h:outputText>
							
							<h:inputText value="#{semmsa001Bean.maxRent}" id="msa001_PopupNearest_maxRent" 
								maxlength="15" style="text-align:right;" styleClass="ms7" disabled="true">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
							</h:inputText>
						</td>
						<td width="22%" align="right">
							<h:outputText id="msa001_PopupNearest_avgRent_label" value="#{jspMsg['label.avgRent']}" styleClass="ms7"></h:outputText>
							
							<h:inputText value="#{semmsa001Bean.avgRent}" id="msa001_PopupNearest_avgRent" 
								maxlength="15" style="text-align:right;" styleClass="ms7" disabled="true">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
							</h:inputText>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<a4j:commandButton value="Close" styleClass="rich-button" immediate="true" style="float:right;">
								<rich:componentControl for="msa001PopUpCommon_NearestSite" operation="hide" event="onclick" />
							</a4j:commandButton>	
						</td>
					</tr>
				</table>
				          
			</h:panelGroup>
		</h:panelGrid>
		<!-- << group repeat -->

    <!-- /h:form --> 
    </rich:modalPanel>
    <!-- popupModalRetStatus -->
    <!-- << [POPUP_01] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_03] -->
	
	<!-- << [POPUP_03] -->
		
<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_04] -->
	
	<!-- << [POPUP_04] -->
			
<!-- =================================================================================== -->
<!-- =================================================================================== -->
