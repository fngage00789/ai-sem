<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.sa.semmsa003" var="jspMsg003"/>
    <rich:modalPanel id="popupRequestType" width="650" autosized="true" minWidth="220" moveable="true">
        <f:facet name="header">
                <h:outputText value="#{jspMsg003['label.popup.siteAppNo']} #{semmsa003Bean.siteAcqSelect.docNo} #{jspMsg003['label.popup.contractNo']} #{semmsa003Bean.siteAcqSelect.p_contract_no}"></h:outputText>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hidePopupRequestType" style="cursor:pointer"/>
                    <rich:componentControl for="popupRequestType" attachTo="hidePopupRequestType" operation="hide" event="onclick" />
                </div>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
            <a4j:form id="frmErrorPopupSave">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa003Bean.renderedMsgFormPopup}">
                            <f:facet name="header">
                                <h:outputText value="Entered Data Status:"></h:outputText>
                            </f:facet>
                            <f:facet name="errorMarker">
                                 <h:graphicImage value="images/error.gif" />  
                            </f:facet>
                    </rich:messages>
            </a4j:form>
        </h:panelGrid>
        <a4j:form id="popupFrmSave"> 
                <rich:panel id="pnlRentalPayNormal">
                <f:facet name="header">
                            <h:outputText value=""/>
                </f:facet>
                <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    <td style="width:25%; text-align:center;">
                                        <h:selectOneRadio id="msa003PopupNew_rntSelectMode" value="#{semmsa003Bean.popupSelectMode}" layout="pageDirection" 
                                        styleClass="ms7" rendered="true">
                                        	<f:selectItem itemValue="N" itemLabel="#{jspMsg003['label.con2']}"/> 
                                            <f:selectItem itemValue="E" itemLabel="#{jspMsg003['label.con1']}"/> 
                                            <f:selectItem itemValue="R" itemLabel="#{jspMsg003['label.con4']}" />
                                            <f:selectItem itemValue="T" itemLabel="#{jspMsg003['label.con3']}" />
                                        </h:selectOneRadio>
                                    </td>
                                </tr>
                            
                                 <tr>
                                 <td colspan="4">
                                        <!-- end content criteria -->
                                <h:panelGroup>
                                
                                    <a4j:commandButton id="btnPopupSave" value="Ok" styleClass="rich-button"
                                    action="#{navAction.navi}" reRender="frmErrorPopupSave,pnlSearchCriteria,pnlSearchResult,frmError,pnlRedirect" 
                                    oncomplete="if(#{semmsa003Bean.siteAppSP.retResult == 'Success'})#{rich:component('popupRequestType')}.hide();">
                                        <a4j:actionparam name="navModule" value="sa" />
                                        <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                                        <a4j:actionparam name="moduleWithNavi" value="sa" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                                        <a4j:actionparam name="methodWithNavi" value="doPopupNewProcess" />
                                    </a4j:commandButton>
                                
                                        <rich:spacer width="5"></rich:spacer>
                                        
                                   
                                    <rich:spacer width="10"/>
                                    <a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
                                     reRender="frmErrorPopupSave,pnlSearchCriteria,pnlSearchResult,frmError">
                                        <rich:componentControl for="popupRequestType" operation="hide" event="onclick" />
                                    </a4j:commandButton>
                                </h:panelGroup>
                                 </td>
                                 </tr>
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                </rich:panel>
                <!-- end content criteria -->
        </a4j:form>
    </rich:modalPanel>
    
    
    <rich:modalPanel id="popupReassign" width="650" autosized="true" minWidth="220" moveable="true">
        <f:facet name="header">
                <h:outputText value="#{jspMsg003['btn.reassign']}"></h:outputText>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hidePopupReassign" style="cursor:pointer"/>
                    <rich:componentControl for="popupReassign" attachTo="hidePopupReassign" operation="hide" event="onclick" />
                </div>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
            <a4j:form id="frmErrorPopupReassign">
                     <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa003Bean.renderedMsgFormPopup}">
                            <f:facet name="header">
                                <h:outputText value="Entered Data Status:"></h:outputText>
                            </f:facet>
                            <f:facet name="errorMarker">
                                 <h:graphicImage value="images/error.gif" />  
                            </f:facet>
                    </rich:messages>
            </a4j:form>
        </h:panelGrid>
        <a4j:form id="popupFrmReassign"> 
                <rich:panel id="pnlReassign">
                
                <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    <td style="width:20%; text-align:right;">
			                            <h:outputText value="Team : " style="font-weight:bold;" styleClass="ms7" />
			                        </td>
			                        <td style="width:30%; text-align:left;">
			                            <a4j:region>
			                                <h:selectOneMenu style="width:100%;" id="msa003panel1_team" value="#{semmsa003Bean.siteAppObjParam.toTeam}" 
			                                onchange="msa003panel1_GetMemberListJS();" styleClass="ms7">
			                                    <f:selectItems value="#{semmsa003Bean.teamList}"/>
			                                </h:selectOneMenu>
			                                <a4j:jsFunction name="msa003panel1_GetMemberListJS" action="#{semmsa003Action.getMemberList}" 
			                                reRender="msa003panel1_member, msa003panel1_asgnRe, msa003panel1_except" />
			                            </a4j:region>
			                        </td>
			                        <td style="width:20%; text-align:right;">
			                            <h:outputText value="User : " style="font-weight:bold;" styleClass="ms7" />
			                        </td>
			                        <td style="width:30%; text-align:left;">
			                            <a4j:region>
			                                <h:selectOneMenu style="" id="msa003panel1_member" value="#{semmsa003Bean.siteAppObjParam.toUser}" 
			                                onchange="msa003panel1_GetMemberSelectedJS();" styleClass="ms7">
			                                    <f:selectItems value="#{semmsa003Bean.memberList}"/>
			                                </h:selectOneMenu>
			                                <a4j:jsFunction name="msa003panel1_GetMemberSelectedJS" action="#{semmsa003Action.getMemberSelected}" 
			                                reRender="msa003panel1_member, msa003panel1_asgnRe, msa003panel1_except" />
			                            </a4j:region>
			                        </td>
                                </tr>
                            
                                 <tr>
                                 <td colspan="4">
                                        <!-- end content criteria -->
                                <h:panelGroup>
                                
                                    <a4j:commandButton id="msa003panel1_asgnRe" value="Assign/Re-Assign" styleClass="rich-button"
		                            action="#{semmsa003Action.doAssignUpdate}" disabled="#{semmsa003Bean.disabledAssignBtn}"
		                            reRender="panelWrapper_tree, panelWrapper_content, msa001panel1_asgnRe">
		                                <a4j:actionparam name="paramAssignFromPage" value="msa001-1" />
		                            </a4j:commandButton>
		                            
		                            <rich:spacer width="5"></rich:spacer>
		                            
		                            <a4j:commandButton id="msa003panel1_except" value="Cancel" styleClass="rich-button"
		                            reRender="panelWrapper_tree, panelWrapper_content, msa003panel1_except">
		                              <rich:componentControl for="popupReassign" operation="hide" event="onclick" />
		                            </a4j:commandButton>
                                </h:panelGroup>
                                 </td>
                                 </tr>
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                </rich:panel>
                <!-- end content criteria -->
        </a4j:form>
    </rich:modalPanel>