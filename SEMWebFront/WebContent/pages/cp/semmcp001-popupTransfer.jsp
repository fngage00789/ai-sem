<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

 

    <f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsgPopup"/>

<!-- =================================================================================== -->
<!-- =================================================================================== -->

    <!-- >> [POPUP_01] -->
    <!-- popupModalRetStatus -->
    <rich:modalPanel id="popupTransferDummyContract" width="500"  height="600" autosized="true" minWidth="220" moveable="false"> 
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="Transfer Dummy Contract"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <h:panelGrid>
        
	    <a4j:form id="frmSiteInfoError">
	        <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmcp001Bean.renderedMsgFormSearch}">
	        <f:facet name="header">
	                <h:outputText value="Entered Data Status:"></h:outputText>
	        </f:facet>
	        <f:facet name="errorMarker">
	             <h:graphicImage value="images/error.gif" />  
	        </f:facet>
	       </rich:messages>
	    </a4j:form>
	    </h:panelGrid>
	    
        <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hide-popupTransferDummyContract" style="cursor:pointer" />
                    <rich:componentControl for="popupTransferDummyContract" attachTo="hide-popupTransferDummyContract" operation="hide" event="onclick"  />
                </div>
            </h:panelGroup>
        </f:facet>
        <table width="100%">
           <tr>
                <td align="right" width="20%">
                    <h:outputText value="Dummy Contract ID : " styleClass="ms7"/>
                </td>
                <td colspan="3">
                    <h:inputText id="txtDummyContractIdShow" value="#{semmcp001Bean.constructionPermissionSearchSP.contractNo}" disabled="true"/>
                </td>
            </tr>
        </table>
        <h:form id="popupFrmSearch"> 
                <h:panelGrid width="800" id="grdPopupSearchCriteria">
                    <rich:panel id="pnlPopupSearchCriteria">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsgPopup['header.criteria.name2']}"/>
                        </f:facet>
                        <!-- begin content criteria -->
                        <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    <td align="right" width="20%">
                                       
                                    </td>
                                    <td colspan="3">
                                        <h:inputHidden id="txtDummyContractId" value="#{semmcp001Bean.constructionPermissionSearchSP.contractNo}"/>
                                        <h:inputHidden id="txtDummySiteInfoId" value="#{semmcp001Bean.constructionPermissionSearchSP.siteInfoId}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsgPopup['label.contractNo']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtPopupContractNo" value="#{popupSiteContractBean.popupContractCriteria.contractNo}"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsgPopup['label.siteName']}" styleClass="ms7"/>
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
                                        <h:outputText value="#{jspMsgPopup['label.company']}" styleClass="ms7"/>
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
                                    <h:selectOneRadio id="rbtCurrentFlag" value="#{popupSiteContractBean.popupContractCriteria.currentFlag}"  styleClass="ms7" rendered="false">
                                        <f:selectItem itemValue="Y" itemLabel="ข้อมูลปัจจุบัน " />
                                        <f:selectItem itemValue="N" itemLabel="ข้อมูลประวัติ "/>
                                    </h:selectOneRadio>
                                    </td>
                                 </tr>
                                 <tr>
                                 <td colspan="4">
                                        <!-- end content criteria -->
                                <h:panelGroup>
                                    <a4j:commandButton id="btnPopupSearch" value="#{jspMsgPopup['btn.search']}" styleClass="rich-button"
                                    action="#{navAction.navi}" reRender="dtbPopupContractNo,pnlPopupSearchResult,frmSiteInfoError,btnTransferPopup" >
                                    <a4j:actionparam name="navModule" value="cp" />
                                    <a4j:actionparam name="navProgram" value="SEMMCP001-2" />
                                    <a4j:actionparam name="moduleWithNavi" value="cp" />
                                    <a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
                                    <a4j:actionparam name="methodWithNavi" value="doSearchPopupContractNo" />
                                    </a4j:commandButton>
                                    <rich:spacer width="10"></rich:spacer>
                                    <a4j:commandButton id="btnClear" value="#{jspMsgPopup['btn.clear']}" styleClass="rich-button" 
                                    action="#{navAction.navi}" 
                                    reRender="dtbPopupContractNo,pnlPopupSearchResult,pnlPopupSearchCriteria,frmSiteInfoError,btnTransferPopup">
                                    <a4j:actionparam name="navModule" value="cp" />
                                    <a4j:actionparam name="navProgram" value="SEMMCP001-2" />
                                    <a4j:actionparam name="moduleWithNavi" value="cp" />
                                    <a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
                                    <a4j:actionparam name="methodWithNavi" value="doClearPopupContractNo" />
                                    </a4j:commandButton>
                                    <rich:spacer width="10"></rich:spacer>
                                    <a4j:commandButton styleClass="rich-button" id="btnTransferPopup" value="#{jspMsgPopup['btn.transfer']}"
                                    disabled="#{semmcp001Bean.disabledTransfer}"
				                     action="#{navAction.navi}" reRender="oppContent,popupTransferDummyContract">
				                      <a4j:actionparam name="navModule" value="cp" />
				                      <a4j:actionparam name="navProgram" value="SEMMCP001-1" />
				                      <a4j:actionparam name="moduleWithNavi" value="cp" />
				                      <a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
				                      <a4j:actionparam name="methodWithNavi" value="doTransfer" />
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
                            <h:outputText value="#{jspMsgPopup['header.popup.resultTable.name']}" />
                        </f:facet>
                        <rich:dataTable id="dtbPopupContractNo" width="97%"
                        value="#{popupSiteContractBean.contractList}" 
                        rowKeyVar="RegInd" var="contractSP" 
                        rows="#{popupSiteContractBean.rowPerPage}"
                        rowClasses="cur" styleClass="dataTable">
                        
                
                        <rich:column id="ContractNoSelect">
                            <f:facet name="header">
                                <h:outputText value="" />
                            </f:facet>
                            <div align="center">
                            <a4j:commandLink id="cmlSelect" value="Select" action="#{navAction.navi}" 
                            reRender="txtPopupSiteName, txtPopupContractNo, popupFrmSearch, grdPopupSearchCriteria">
                            <a4j:actionparam name="navModule" value="cp" />
                            <a4j:actionparam name="navProgram" value="SEMMCP001" />
                            <a4j:actionparam name="moduleWithNavi" value="cp" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMCP001-2" />
                            <a4j:actionparam name="methodWithNavi" value="doSelectContractNo" />
                            <a4j:actionparam name="siteInfoId" value="#{contractSP.siteInfoId}"/>
                            <a4j:actionparam name="siteName" value="#{contractSP.siteName}"/>
                            <a4j:actionparam name="contractNo" value="#{contractSP.contractNo}"/>
                            <a4j:actionparam name="region" value="#{contractSP.region}"/>
                            <a4j:actionparam name="sendRenewId" value="EMPTY" />
                            </a4j:commandLink>
                            </div>
                        </rich:column>
                        <rich:column id="colContractNo" sortBy="#{contractSP.contractNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                            <f:facet name="header">
                                <h:outputText value="#{jspMsgPopup['column.popup.header.contractNo']}" styleClass="contentform" style="width: 100"/>
                            </f:facet>
                            <div align="center">
                                <h:outputText value="#{contractSP.contractNo}" styleClass="contentform"   />
                            </div>
                        </rich:column>
                        
                        <rich:column id="colSiteName" sortBy="#{contractSP.siteName}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsgPopup['column.popup.header.siteName']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="left">
                                    <h:outputText value="#{contractSP.siteName}" styleClass="contentform" />
                                </div>
                            </rich:column>
                            <rich:column id="colEffDate" sortBy="#{contractSP.effDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsgPopup['column.header.popup.effDate']}" styleClass="contentform"  style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{contractSP.effDate}" styleClass="contentform">
                                    <f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column id="colExpDate" sortBy="#{contractSP.expDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsgPopup['column.header.popup.expDate']}" styleClass="contentform"  style="width: 50"/>
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





  <rich:modalPanel id="popupRollBackDummyContract" width="500"  height="300" autosized="true" minWidth="220" moveable="false"> 
       <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="RollBack Dummy Contract"></h:outputText>
            </h:panelGroup>
        </f:facet>
    <h:panelGrid>    
	    <a4j:form id="frmSiteInfoErrorRollBack">
	        <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" >
	        <f:facet name="header">
	                <h:outputText value="Entered Data Status:"></h:outputText>
	        </f:facet>
	        <f:facet name="errorMarker">
	             <h:graphicImage value="images/error.gif" />  
	        </f:facet>
	       </rich:messages>
	    </a4j:form>
	    </h:panelGrid>     
   <f:facet name="controls">
            <h:panelGroup>
                <div align="left">
                    <h:graphicImage value="images/ico_close.png" id="hide-popupRollBackDummyContract" style="cursor:pointer" />
                    <rich:componentControl for="popupRollBackDummyContract" attachTo="hide-popupRollBackDummyContract" operation="hide" event="onclick"  />
                </div>
            </h:panelGroup>
        </f:facet>  
         <table width="100%">
           <tr>
                <td align="right" width="20%">
                    <h:outputText value="Dummy Contract ID : " styleClass="ms7"/>
                </td>
                <td colspan="3">
                    <h:inputText id="txtDummyContractIdShowRollBack"  value="#{semmcp001Bean.siteInfoData.contractNo}" disabled="true"/>
                </td>
            </tr>
        </table>       
       <h:form id="popupFrmSearchRollBack"> 
                     <h:panelGrid width="800" id="grdPopupSearchCriteria">
                  
                   <rich:panel id="pnlPopupSearchResult">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsgPopup['header.popup.resultTable.name']}" />
                        </f:facet>     
                                     
                        <!-- begin content criteria -->
                        <h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <div align="center">
                            <table width="100%">
                               <rich:dataTable id="dtbPopupContractNoRollBack" width="97%"                 
                        			rowKeyVar="RegInd" var="contractSP" rows="#{popupSiteContractBean.rowPerPage}"            
                        			rowClasses="cur" styleClass="dataTable"
                        			value="#{popupSiteContractBean.contractListForRollBack}" >
             		
                        <rich:column id="colContractNo" sortBy="#{contractSP.contractNo}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                            <f:facet name="header">
                                <h:outputText value="#{jspMsgPopup['column.popup.header.contractNo']}" styleClass="contentform" style="width: 100"/>
                            </f:facet>
                            <div align="center">
                                <h:outputText value="#{contractSP.contractNo}" styleClass="contentform"   />
                            </div>
                        </rich:column>
                        
                        <rich:column id="colSiteName" sortBy="#{contractSP.siteName}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsgPopup['column.popup.header.siteName']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="left">
                                    <h:outputText value="#{contractSP.siteName}" styleClass="contentform" />
                                </div>
                            </rich:column>
                            <rich:column id="colEffDate" sortBy="#{contractSP.effDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsgPopup['column.header.popup.effDate']}" styleClass="contentform"  style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{contractSP.effDate}" styleClass="contentform">
                                    <f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column id="colExpDate" sortBy="#{contractSP.expDate}" styleClass="#{(popupSiteContractBean.tmpRowId==contractSP.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsgPopup['column.header.popup.expDate']}" styleClass="contentform"  style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{contractSP.expDate}" styleClass="contentform">
                                    <f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <f:facet name="footer">
                                <rich:datascroller immediate="true" rendered="true" align="center" for="dtbPopupContractNoRollBack" 
                                    id="dstPopupContractNoRollBack" selectedStyleClass="selectScroll" />
                            </f:facet>             
                        
                         </rich:dataTable>
                                
                            </table></div>
                            </h:panelGroup>
                        </h:panelGrid>
                
                    </rich:panel>
                </h:panelGrid>   
                <br/>
                 <center><div style="align:center">       
                <a4j:commandButton value="#{jspMsgPopup['btn.rollBack']}" styleClass="rich-button"  immediate="true" 
                action="#{navAction.navi}" oncomplete="#{rich:component('popupRollBackDummyContract')}.hide(); return false;">
               
				  <a4j:actionparam name="navModule" value="cp" />
				  <a4j:actionparam name="navProgram" value="SEMMCP001-2" />
				  <a4j:actionparam name="moduleWithNavi" value="cp" />
				  <a4j:actionparam name="actionWithNavi" value="SEMMCP001" />
				  <a4j:actionparam name="methodWithNavi" value="doRollBackContract" />
                 </a4j:commandButton>
				<rich:spacer width="15"></rich:spacer>
				<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
				<rich:componentControl for="popupRollBackDummyContract" operation="hide" event="onclick" />
				</a4j:commandButton>
				</div></center>
                </h:form>
</rich:modalPanel>
   