<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:view>
    <f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

    <h:inputHidden id="myParamMode" value="#{semmsa002Bean.paramMode}" />

    <!-- Wrapper Panel -->
    <rich:panel style="height:100%; border:1px solid #ececec;">

        <!-- Content Panel -->
        <rich:panel style="border:1px solid #e0e0e0;">

            <!-- Header Content -->
            <f:facet name="header">
                <h:outputText value="#{jspMsg['label.saveApproveDocNo']}" />
            </f:facet>

            <!-- Messages -->
            <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgAlert}">
                <f:facet name="errorMarkerPage">
                    <h:graphicImage value="images/error.gif" />
                </f:facet>
            </rich:messages>

            <!-- Form Group -->
            <h:panelGroup style="width:100%;">
                <h:form id="frmAllInitTab">

                    <!-- Top Bar Table -->
                    <table style="width:100%; background-color:#d0d0d0; border:2px solid #e0e0e0;">
                        <tr>
                            <td style="width:30%; text-align:left; white-space:nowrap;">
                                <h:outputText value="#{jspMsg['label.approveNumber']} : " style="font-weight:bold;" />
                                <h:outputText id="msa002-1_docNo" value="#{semmsa002Bean.siteAppObjParam.docNo}" style="font-style:italic;" />
                                <h:outputText value="#{jspMsg['label.th_number']}#{jspMsg['label.th_contract']} : " style="font-weight:bold;" />
                                <h:outputText id="msa002-1_contractNo" value="#{semmsa002Bean.siteAppObjParam.contractNo}" style="font-style:italic;" />
                            </td>

                            <!-- Copy Vendor Info and Vendor Group Type Radio -->
                            <td style="text-align:right;">
                                <h:commandButton id="copyVendorBtn" value="Copy Vendor's Info from SAP" styleClass="rich-button"
                                                 action="#{vendorBean.copyVendorInfoFromSAP}" />
                                <rich:spacer width="5px" />

                                <!-- Vendor Group Type Radio Buttons -->
                                <h:selectOneRadio value="#{semmsa002Bean.vendorGroupType}">
                                    <f:selectItem itemValue="external" itemLabel="LL ไม่ใช่กลุ่มบริษัทในเครือ" />
                                    <f:selectItem itemValue="internal" itemLabel="LL กลุ่มบริษัทในเครือ" />
                                </h:selectOneRadio>

                                <!-- Back Button -->
                                <a4j:commandButton id="msa002_BtnBack" value="Back" styleClass="rich-button"
                                                   rendered="#{semmsa002Bean.renderedBtnBack}" action="#{navAction.navi}" reRender="oppContent">
                                    <a4j:actionparam name="navModule" value="sa" />
                                    <a4j:actionparam name="navProgram" value="SEMMSA001-0" />
                                    <a4j:actionparam name="moduleWithNavi" value="sa" />
                                    <a4j:actionparam name="actionWithNavi" value="SEMMSA001" />
                                    <a4j:actionparam name="methodWithNavi" value="treeSwapPage" />
                                    <a4j:actionparam name="paramUrl" value="#{semmsa002Bean.panelDisplay}" />
                                    <a4j:actionparam name="paramMenuGroup" value="#{semmsa002Bean.menuGroupDisplay}" />
                                    <a4j:actionparam name="paramMenuType" value="#{semmsa002Bean.menuGroupType}" />
                                </a4j:commandButton>
                            </td>
                        </tr>
                    </table>

                    <!-- Vendor Information Section -->
                    <h:panelGrid columns="3" style="width:100%; margin-top:10px;">
                        <h:outputLabel for="vendorCode" value="Vendor Code:" />
                        <h:selectOneMenu id="vendorCode" value="#{semmsa002Bean.vendorCode}">
                            <f:selectItem itemValue="" itemLabel="Select" />
                            <!-- Populate vendor code options here -->
                        </h:selectOneMenu>
                        <h:outputText value="ชื่อ Vendor 1 / First Name:" />
                        <h:outputText id="vendorName1" value="#{semmsa002Bean.siteAppObjParam.vendorName1}" style="font-style:italic;" />
                    </h:panelGrid>

                    <!-- Check Vendor Button -->
                    <h:panelGrid columns="3" style="margin-top:10px;">
                        <h:outputText value="" />
                        <h:commandButton id="checkVendorBtn" value="Check Vendor" action="#{vendorBean.checkVendor}" styleClass="rich-button" />
                        <h:outputText value="" />
                    </h:panelGrid>

                    <!-- Buttons for Save, Print, Send Approve -->
                    <h:panelGrid columns="3" style="margin-top:20px;">
                        <a4j:commandButton id="msa002_BtnSave" value="Save" styleClass="rich-button"
                                           action="#{navAction.navi}" reRender="oppContent, frmAllInitTab, panelTab"
                                           oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;"
                                           rendered="#{semmsa002Bean.disabledModeViewOnly != true &&
                                           (semmsa002Bean.siteAppObjParam.reqType != '04' && semmsa002Bean.siteAppObjParam.reqType != '05')}">
                            <a4j:actionparam name="navModule" value="sa" />
                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
                            <a4j:actionparam name="methodWithNavi" value="doUpdateAll" />
                            <a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
                            <a4j:actionparam name="saveFlag" value="Y" />
                        </a4j:commandButton>

                        <rich:spacer width="5px" />

                        <a4j:commandButton id="msa002_BtnSndApprve" value="Send Approve" styleClass="rich-button"
                                           rendered="#{semmsa002Bean.chkUserFlag && semmsa002Bean.disabledModeViewOnly != true &&
                                           (semmsa002Bean.siteAppObjParam.reqType != '04' && semmsa002Bean.siteAppObjParam.reqType != '05')}"
                                           action="#{semmsa001Action.doApproveToLeader}"
                                           reRender="frmError,oppContent, frmAllInitTab, panelTab"
                                           oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
                            <a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
                            <a4j:actionparam name="paramPage" value="msa002-1" />
                            <a4j:actionparam name="saveApproveFlag" value="Y" />
                        </a4j:commandButton>
                    </h:panelGrid>

                </h:form>
            </h:panelGroup>

        </rich:panel>
        <!-- Content Panel End -->

    </rich:panel>
    <!-- Wrapper Panel End -->

    <!-- Popups and Additional Includes -->
    <a4j:include id="msa002-1_popUpload" viewId="../../pages/popup/uploadFile-popup.jsp" />
    <a4j:include id="msa002-1_popCom" viewId="../../pages/sa/semmsa002PopUpCommon.jsp" />
</f:view>
