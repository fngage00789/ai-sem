<!--[if lt IE 9]>
<script src="//css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->

<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    <style>
        
    </style>

    <f:loadBundle basename="resources.sa.semmsa003" var="jspMsg" />

<!-- =================================================================================== -->
<!-- =================================================================================== -->

    <!-- >> [POPUP_01] -->
    <!-- popupModalRetStatus -->
    <rich:modalPanel id="popupNearestSite" width="1000" autosized="true"> 
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="#{jspMsg['header.nearestSite']}"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hide-popupNearestSite" style="cursor:pointer" />
                    <rich:componentControl for="popupNearestSite" attachTo="hide-popupNearestSite" operation="hide" event="onclick"  />
                </div>
            </h:panelGroup>
        </f:facet>
        
        <!-- h:form id="tab1_frmTest" -->
            <!-- >> group repeat -->
       <h:panelGrid width="100%" id="popupDisplay">
          <h:panelGroup >
            <rich:panel  style="width:100%; height:500px; overflow:auto;" styleClass="sem_autoScrollbar">
                <div align="center">
                        <h:outputLabel style="color:red;size:20px" value="#{jspMsg['label.dataNotFound']}" rendered="#{semmsa002Bean.chkDataNotFound}" />
                </div>
                <!-- top >> -->
                            <table style="width:100%; background-color:cada30; border:2px solid e0e0e0;">
                                <tr>
                                    <td style="width:25%; text-align:center;">
                                        <h:outputText value="#{jspMsg['label.th_approveNumber']} : " style="font-weight:bold;" styleClass="ms7" />
                                        <h:outputText value="#{semmsa003.docNo}" style="font-style: italic;" styleClass="ms7" />
                                    </td>
                                    <td style="width:25%; text-align:center;">
                                        <h:outputText value="#{jspMsg['label.th_contractNumber']} : " style="font-weight:bold;" styleClass="ms7" />
                                        <h:outputText value="#{semmsa003.contractNo}" style="font-style: italic;" styleClass="ms7" />
                                    </td>
                                    <td style="width:25%; text-align:center;">
                                        <h:outputText value="#{jspMsg['label.th_type']} : " style="font-weight:bold;" styleClass="ms7" />
                                        <h:outputText value="#{semmsa003.docTypeText}" style="font-style: italic;" styleClass="ms7" />
                                    </td>
                                    <td style="width:25%; text-align:center;">
                                        <h:outputText value="#{jspMsg['label.th_lastUpdateDate']} : " style="font-weight:bold;" styleClass="ms7" />
                                        <h:outputText value="#{semmsa003.updateDT}" style="font-style: italic;" styleClass="ms7" />
                                    </td>
                                </tr>
                            </table>
                   <!-- top << -->
                
		                <rich:dataTable style="width:98%;" cellpadding="1" cellspacing="0" border="0" 
		                var="item_"  value="#{semmsa003Bean.nearestSiteAcqSPList}" reRender="" 
		                rows="" rowClasses="cur" styleClass="dataTable">
                            <!-- header -->
                                <f:facet name="header">
                                    <rich:columnGroup>
                                       
                                        <rich:column breakBefore="true" style="white-space:nowrap;"> 
                                            <h:outputText value="#{jspMsg['header.region']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>  
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['header.company']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['header.contractNo']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['header.locationId']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['header.locationName']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['header.siteDetail']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['label.effDate']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['label.expDate']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                        <rich:column style="white-space:nowrap;">
                                            <h:outputText value="#{jspMsg['header.rentPerYear']}" styleClass="contentform" style="width: 100"/>
                                        </rich:column>
                                    </rich:columnGroup>
                                </f:facet>
                                <!-- header -->
                        
                                <!-- data -->
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.region}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.company}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.contractNo}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.locationId}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.locationName}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.siteDetail}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.effectiveDtStr}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.expireDtStr}" styleClass="contentform"  />
                                </rich:column>
                                <rich:column style="text-align:center">
                                    <h:outputText value="#{item_.dataObj.rentAmtPerYear}" styleClass="contentform"  />
                                </rich:column>
                                
                                <!-- data -->
                     
                        </rich:dataTable>
                    </rich:panel>
                    <rich:panel style="float:right;background-color:none;border-style:none;">
                            <a4j:commandButton value="Ok" styleClass="rich-button" immediate="true">
                                <rich:componentControl for="popupNearestSite" operation="hide" event="onclick" />
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
