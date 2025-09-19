<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.gm.semmct005" var="jspMsg"/>
<h:panelGrid width="100%">
    <rich:panel id="pnlGlAcc">
        <f:facet name="header">
            <h:outputText id="outTxtDisplayMode" value="#{jspMsg['header.pageName']}" />
        </f:facet>
        
        <h:panelGrid columnClasses="gridContent" width="90%"> 
            
            <a4j:form id="frmCreate" >
                <h:panelGrid width="100%">
                <h:panelGroup>
                        <table width="100%" border="0">
                        <tr>
                        <td width="50%" align="left">
                        <h:panelGrid>
                            <table width="100%" border="0">
                                    <tr>
                                    <td width="50%" align="left">
                                    <rich:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
                                                   rendered="#{semmct005Bean.renderedMsgFormCreate}" 
                                                   style="width : 822px; height : 21px;">
                                            <f:facet name="errorMarker">
                                                 <h:graphicImage value="images/error.gif" />  
                                            </f:facet>
                                    </rich:messages>
                                    </td>
                                    <td width="50%" align="right" valign="bottom">
                                    </td>
                                    </tr>
                            </table>
                        </h:panelGrid>
                        </td>
                        <td width="50%" align="right" valign="bottom">
                            <table id="tblButton">
                            <tr>
                            <td>
                            <a4j:commandButton id="btnBack" value="#{jspMsg['btn.label.back']}" styleClass="rich-button"
                                            action="#{navAction.navi}" reRender="oppContent">
                                                <a4j:actionparam name="navModule" value="gm" />
                                                <a4j:actionparam name="navProgram" value="SEMMCT005-1" />
                                                <a4j:actionparam name="moduleWithNavi" value="gm" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
                                                <a4j:actionparam name="methodWithNavi" value="doBack" />
                                            </a4j:commandButton>
                            </td>
                            <td>
                            <a4j:commandButton id="btnSave" value="#{jspMsg['btn.label.save']}" styleClass="rich-button"
                                            action="#{navAction.navi}" reRender="frmError,pnlCreateCriteria,pnlSearchResult,frmUser,frmCreate"
                                             rendered="#{not semmct005Bean.viewMode}">
                                                <a4j:actionparam name="navModule" value="gm" />
                                                <a4j:actionparam name="navProgram" value="SEMMCT005-2" />
                                                <a4j:actionparam name="moduleWithNavi" value="gm" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
                                                <a4j:actionparam name="methodWithNavi" value="doSave" />
                                            </a4j:commandButton>
                            </td>
                            <td>
                            <a4j:commandButton id="btnNew" value="#{jspMsg['btn.label.new']}" styleClass="rich-button" rendered="#{not semmct005Bean.viewMode}"
                                    oncomplete="#{rich:component('mdpConfirmResetDialog')}.show(); return false" >
                            </a4j:commandButton>
                            </td>
                            </tr>
                            </table>
                        </td>
                        </tr>
                        </table>
                    </h:panelGroup>
                
                <rich:panel id="pnlCreateCriteria">
                            <f:facet name="header">
                                <h:outputText value="#{jspMsg['header.pageName']}" />
                            </f:facet>
                        
                            <h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    <td align="right" width="25%">
                                    <h:panelGroup>
                                    <h:graphicImage value="images/icon_required.gif" />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7" />
                                    </h:panelGroup>
                                    </td>
                                    <td colspan="3">
                                    <h:selectOneMenu label="#{jspMsg['label.All']}" id="ddlCompany" 
                                                     value="#{semmct005Bean.glAccount.company}" 
                                                     disabled="#{semmct005Bean.viewMode or semmct005Bean.editMode}"
                                                     onchange="setRequireValidate();"> 
                                        <f:selectItems value="#{semmct005Bean.companyList}"/>
                                    </h:selectOneMenu>
                                    <a4j:jsFunction name="setRequireValidate" reRender="companyDisplay">
                                        
                                    </a4j:jsFunction>
                                    <rich:spacer width="10"></rich:spacer>
                                    <h:outputText id="companyDisplay" value="#{semmct005Bean.glAccount.company}" styleClass="ms28"/>
                                    </td>
                                 </tr>
                                
                                <tr>
                                    <td align="right">
                                    <h:panelGroup>
                                    <h:graphicImage value="images/icon_required.gif" />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.glAccount']} :" styleClass="ms7" />
                                    </h:panelGroup>
                                    </td>
                                    <td colspan="3">
                                    <h:inputText id="txtGlAccount" value="#{semmct005Bean.glAccount.glAccount}" 
                                                 disabled="#{semmct005Bean.viewMode}" 
                                                 size="30" maxlength="50" ></h:inputText>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td align="right" width="25%">
                                    <h:panelGroup>
                                    <h:outputText value="#{jspMsg['label.glDesc']} :" styleClass="ms7" />
                                    </h:panelGroup>
                                    </td>
                                    <td width="25%" colspan="3">
                                        <h:inputText id="txtGlDesc" value="#{semmct005Bean.glAccount.glAccDesc}"
                                                                 disabled="#{semmct005Bean.viewMode}" 
                                                                 size="100" maxlength="250"/>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td align="right" width="25%">
                                    <h:panelGroup>
                                    <h:graphicImage value="images/icon_required.gif" />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.exType']} :" styleClass="ms7" />
                                    </h:panelGroup>
                                    </td>
                                    <td width="25%">
                                    <h:selectOneMenu label="#{jspMsg['label.All']}" id="ddlExType" 
                                                     value="#{semmct005Bean.glAccount.expenseType}" 
                                                     disabled="#{semmct005Bean.viewMode}"> 
                                        <f:selectItems value="#{semmct005Bean.expenseList}"/>
                                    </h:selectOneMenu>                           
                                    </td>
                                    <td align="right" width="25%">
                                        <h:outputText value="#{jspMsg['label.placeType']} :" styleClass="ms7" />
                                    </td>
                                    <td width="25%">
                                        <h:selectOneMenu label="#{jspMsg['label.All']}" id="ddlPlaceType" 
                                                     value="#{semmct005Bean.glAccount.placeType}" 
                                                     disabled="#{semmct005Bean.viewMode}"> 
                                        <f:selectItems value="#{semmct005Bean.placeTypeList}"/>
                                        </h:selectOneMenu>  
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td align="right" width="25%">
                                    <h:panelGroup>
                                    <h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7" />
                                    </h:panelGroup>
                                    </td>
                                    <td width="25%">
                                        <rich:calendar id="exDt" locale="th" enableManualInput="true" 
                                               datePattern="dd/MM/yyyy" 
                                               value="#{semmct005Bean.glAccount.effectiveDate}"
                                               showWeeksBar="false" 
                                               inputSize="13" 
                                               onchanged="setRequireEffDate();"
                                               oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                               disabled="#{semmct005Bean.viewMode}"
                                               cellWidth="20px" cellHeight="20px"
                                               label="#{jspMsg['label.eff_Date']}">
                                        </rich:calendar>
                                    </td>
                                    <td align="right" width="25%">
                                        <h:outputText value="#{jspMsg['label.glType']} :" styleClass="ms7" />
                                    </td>
                                    <td width="25%">
                                        <h:selectOneRadio id="glType" value="#{semmct005Bean.glAccount.glType}" styleClass="ms7"
                                                      disabled="#{semmct005Bean.viewMode}" >
                                        <f:selectItems value="#{semmct005Bean.statusListForGL}" />
                                        </h:selectOneRadio>
                                    </td>
                                </tr>
                                <tr style=" height : 28px;">
                                    <td align="right">
                                    <h:graphicImage value="images/icon_required.gif" />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.recStatus']} :" styleClass="ms7"/>
                                    </td>
                                    <td colspan="3"> 
                                    <h:selectOneRadio id="glRecStatus" value="#{semmct005Bean.glAccount.recordStatus}" styleClass="ms7"
                                                      disabled="#{semmct005Bean.viewMode}" >
                                        <f:selectItems value="#{semmct005Bean.statusListForCreate}" />
                                    </h:selectOneRadio>
                                    </td>
                                 </tr>
                            </table>
                                </h:panelGroup>
                            </h:panelGrid>
                        
                    </rich:panel>
                    
                    
                    <rich:panel id="pnlLog">
                    <h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
                        <h:panelGroup>
                        <table width="100%">
                            <tr>
                                <td align="right" width="25%">
                                    <h:outputText value="#{jspMsg['label.CreateBy']} :" styleClass="ms7"/>
                                </td><td width="25%">
                                    <h:inputText id="txtCreateBy" value="#{semmct005Bean.glAccount.createBy}" disabled="#{semmct005Bean.disableUser}" />
                                </td><td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.CreateDt']} :" styleClass="ms7"/>
                                </td><td width="30%">
                                    <rich:calendar id="cldCreateDate" locale="th" 
                                    datePattern="dd/MM/yyyy hh:mm:ss" 
                                    value="#{semmct005Bean.glAccount.createDt}"
                                    inputSize="20" 
                                    cellWidth="20px" cellHeight="20px" 
                                    buttonIcon="/images/hide-button.png"
                                    buttonIconDisabled="/images/hide-button.png"
                                    disabled="#{semmct005Bean.disableUser}" />
                                </td>
                             </tr><tr>
                                <td align="right" width="25%">
                                    <h:outputText value="#{jspMsg['label.UpdateBy']} :" styleClass="ms7"/>
                                </td><td width="25%">
                                    <h:inputText id="txtUpdateBy" value="#{semmct005Bean.glAccount.updateBy}" disabled="#{semmct005Bean.disableUser}" />
                                </td><td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.UpdateDt']} :" styleClass="ms7"/>
                                </td><td width="30%">
                                    <rich:calendar id="cldUpdateDate" locale="th" 
                                    datePattern="dd/MM/yyyy hh:mm:ss" 
                                    value="#{semmct005Bean.glAccount.updateDt}"
                                    showWeeksBar="false" 
                                    inputSize="20" 
                                    cellWidth="20px" cellHeight="20px" 
                                    buttonIcon="/images/hide-button.png"
                                    buttonIconDisabled="/images/hide-button.png"
                                    disabled="#{semmct005Bean.disableUser}"
                                    />
                                </td>
                             </tr>
                        </table>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:panel> 
                    
                    
                </h:panelGrid>
            </a4j:form>     
        </h:panelGrid>
        </rich:panel>
</h:panelGrid>
<rich:modalPanel id="mdpConfirmResetDialog" autosized="true">   
    <f:facet name="header">
        <h:outputText value="Confirm"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmResetDialog">
        <table width="240px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="240px">
                        <h:outputText value="#{semmct005Action.comfirmMsg}" styleClass="ms7" />
                    </h:panelGrid>
                </td>
            </tr>
            <tr>
                <td>
                    <div align="center">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
                            reRender="frmError,pnlCreateCriteria,pnlSearchResult,frmSearch,frmUser">
                            <a4j:actionparam name="navModule" value="gm" />
                            <a4j:actionparam name="navProgram" value="SEMMCT005-2" />
                            <a4j:actionparam name="moduleWithNavi" value="gm" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMCT005" />
                            <a4j:actionparam name="methodWithNavi" value="doCreate" />                      
                            <rich:componentControl for="mdpConfirmResetDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>    
                        <rich:spacer width="5"></rich:spacer>                                           
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmResetDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>