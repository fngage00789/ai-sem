<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid width="100%">

    <rich:panel>
        <f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>   
            <h:panelGrid>
            <a4j:form id="frmError">
                <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004Bean.renderedMsgFormSearch}">
                        <f:facet name="header">
                            <h:outputText value="Entered Data Status:"></h:outputText>
                        </f:facet>
                        <f:facet name="errorMarker">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
            </a4j:form>
        </h:panelGrid>  
        <h:panelGrid columnClasses="gridContent" width="100%">
                <!-- begin content layout criteria -->
                <h:panelGrid width="96%">
                <a4j:form id="frmSearchCriteria">
                    <rich:panel id="pnlSearchCriteria">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg['header.criteria.name']}"/>
                        </f:facet>
                        <!-- begin content criteria -->
                        <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                            <tr>
                                    <td align="right" width="25%" valign="baseline">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                                    </td>
                                    <td width="25%" valign="bottom">
                                        <h:selectOneMenu id="ddlCompany" value="#{semmsi004Bean.siteInfoSP.company}" onchange="GetCompanyJS();">
                                        <f:selectItems value="#{semmsi004Bean.companyList}"/>
                                        </h:selectOneMenu>
                                        <a4j:jsFunction name="GetCompanyJS" action="#{semmel011Action.doCheckGenDummy}" reRender="pnlSearchCriteria,companyDisplay,btnGenDummy"/>
                                        <rich:spacer width="10"></rich:spacer>
                                        <h:outputText id="companyDisplay" value="#{semmsi004Bean.siteInfoSP.company}" styleClass="ms28"/>
                                    </td>
                                    <td align="right" width="25%" valign="bottom">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
                                    </td>
                                    <td width="25%" valign="bottom">
                                    <h:selectOneMenu id="ddlRegion" value="#{semmsi004Bean.siteInfoSP.region}" onchange="GetCompanyJS();"> 
                                        <f:selectItems value="#{semmsi004Bean.regionList}"/>
                                    </h:selectOneMenu>
                                    </td>
                                 </tr>
                                  <tr>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtLocationId" value="#{semmsi004Bean.siteInfoSP.locationId}" onchange="GetCompanyJS();" size="18" maxlength="15">
                                       
                                    </h:inputText>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtLocationCode" value="#{semmsi004Bean.siteInfoSP.locationCode}" size="13" maxlength="10"/>
                                    </td>
                                 </tr>
                                 
                                  <tr>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtLocationName" value="#{semmsi004Bean.siteInfoSP.locationName}" size="30" maxlength="255"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.contractStatus']} :" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                     <h:selectOneMenu id="ddlSiteStatus" value="#{semmsi004Bean.siteInfoSP.siteStatus}"> 
                                        <f:selectItems value="#{semmsi004Bean.siteStatusList}"/>
                                    </h:selectOneMenu>
                                    </td>
                                 </tr>
                                 
                                  <tr>
                                    <td align="right" width="20%">
                                     <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputTextarea id="txtContractNo" value="#{semmsi004Bean.siteInfoSP.contractNo}" rows="3"
                                     onblur="setFormatContractNo(this)"/>
                                    </td>
                                    <td align="right" valign="top" width="20%">
                                    
                                    </td>
                                    <td width="30%" valign="top">
                                    
                                    </td>
                                 </tr>
                                 
                               <tr>
                                <td align="right" width="25%">
                                <h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
                                </td>
                                <td width="25%">
                                    <table width="100%">
                                    <tr>
                                    <td>
                                     <rich:calendar id="cldEffDateFrom" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsi004Bean.siteInfoSP.effDateFrom}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateFrom','cldEffDateTo');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateFrom','cldEffDateTo');"
                                       label="#{jspMsg['column.header.effDate']}"
                                       >
                                    </rich:calendar> 
                                    </td>
                                    <td><h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/></td>
                                    <td>
                                     <rich:calendar id="cldEffDateTo" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsi004Bean.siteInfoSP.effDateTo}"
                                       showWeeksBar="false"
                                       inputSize="13"
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateTo','cldEffDateFrom');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateTo','cldEffDateFrom');"
                                       label="#{jspMsg['column.header.effDate']}">
                                </rich:calendar>
                                    </td>
                                    </tr>
                                    </table>
                                </td>
                                <td align="right" width="25%">
                                <h:outputText value="#{jspMsg['label.expDate']} :" styleClass="ms7"/>
                                </td>
                                <td width="25%">
                                    <table width="100%">
                                    <tr>
                                    <td>
                                      <rich:calendar id="cldExpDateFrom" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsi004Bean.siteInfoSP.expDateFrom}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateFrom','cldExpDateTo');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateFrom','cldExpDateTo');"
                                       label="#{jspMsg['column.header.expDate']}"
                                       >
                                    </rich:calendar> 
                                    </td>
                                    <td><h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/></td>
                                    <td>
                                      <rich:calendar id="cldExpDateTo" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsi004Bean.siteInfoSP.expDateTo}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateTo','cldExpDateFrom');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateTo','cldExpDateFrom');"
                                       label="#{jspMsg['column.header.expDate']}"
                                       >
                                       
                                    </rich:calendar> 
                                    </td>
                                    </tr>
                                    </table>
                                </td>
                             </tr>
                             
                             <tr>
                                <td align="right" width="20%">
                                
                                <td width="30%">
                                
                                </td>
                                <td width="20%"></td>
                                <td width="30%">
                                <h:selectBooleanCheckbox id="chkNoExpireFlag" value="#{semmsi004Bean.chkNoExpireFlagSP}" 
                                styleClass="ms7"/>
                                <h:outputText value="#{jspMsg['label.noExpireFlag']}" styleClass="ms7" />
                                </td>
                             </tr>
                             
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                        <!-- end content criteria -->
                        <h:panelGrid columns="2" id="grdSearchCommand">
                            <a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchResult,dtbSiteInfo" >
                            <a4j:actionparam name="navModule" value="el" />
                            <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                            <a4j:actionparam name="moduleWithNavi" value="el" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                            <a4j:actionparam name="methodWithNavi" value="doSearch" />
                            </a4j:commandButton>
                            <a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbSiteInfo,btnExport,btnRun">
                            <a4j:actionparam name="navModule" value="el" />
                            <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                            <a4j:actionparam name="moduleWithNavi" value="el" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                            <a4j:actionparam name="methodWithNavi" value="doClear" />
                            </a4j:commandButton>
                        </h:panelGrid>
                    </rich:panel>
                    
                    <h:panelGrid>
                        <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    
                                    <td align="right">
                                        <a4j:commandButton id="btnGenDummy" styleClass="rich-button"
                                                           value="#{jspMsg['btn.genDummy']}"
                                                           action="#{navAction.navi}"
                                                           disabled="#{semmsi004Bean.disabledBtnGenDummy}"
                                                           reRender="frmError" oncomplete="doAutoLink()">
                                            <a4j:actionparam name="navModule" value="el" />
                                            <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                                            <a4j:actionparam name="moduleWithNavi" value="el" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                                            <a4j:actionparam name="methodWithNavi" value="doGenDummy" />
                                        </a4j:commandButton>
                                        
                                        <a4j:jsFunction name="doAutoLink" action="#{navAction.navi}" reRender="oppContent">
                                        <a4j:actionparam name="navModule" value="el" />
                                        <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                                        <a4j:actionparam name="moduleWithNavi" value="el" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                                        <a4j:actionparam name="methodWithNavi" value="initAddSiteInfo" />
                                        <a4j:actionparam name="genDummyFlag" value="Y" />
		                                <a4j:actionparam name="mode" value="EDIT" />
		                                <a4j:actionparam name="page" value="SITEINFO" />
		                            </a4j:jsFunction>
                                    </td>
                                </tr>
                            </table>
                        </h:panelGroup>
                    </h:panelGrid>
                    </a4j:form>
                </h:panelGrid>
            
                <!-- end content layout criteria -->
                <a4j:form id="frmSearchResult"> 
                <!-- begin content layout data grid -->
                <h:panelGrid  width="90%">
                    <rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
                        <f:facet name="header" >
                            <h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1400"/>
                        </f:facet>
                        <div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmsi004Bean.msgDataNotFound}" rendered="#{semmsi004Bean.renderedMsgDataNotFound}" />
                        </div>
                          <rich:dataTable width="100%" id="dtbSiteInfo" cellpadding="1" cellspacing="0" border="0"
                            var="siteInfoSP" value="#{semmsi004Bean.siteInfoSPList}" reRender="dtbSiteInfo" 
                            rows="#{semmsi004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            
                            <rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            rendered="false"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <f:facet name="header">
                                <h:outputText value="" style="width: 120"/>
                            </f:facet>
                            <div align="center">
                            <a4j:commandLink id="hlkEdit" value="#{jspMsg['label.saveSiteInfo']}" action="#{navAction.navi}" 
                            reRender="frmSearchResult,mdpConfirmSiteinfo,frmConfirmSiteInfo,changePage,dtbSiteInfo"
                            oncomplete="if(#{semmsi004Bean.popupConfirmSiteInfo == 'false'})#{rich:component('mdpConfirmSiteinfo')}.show();if(#{semmsi004Bean.popupConfirmSiteInfo == 'true'})changePage();"
                            rendered="#{siteInfoSP.dataObj.editableFlag == 'Y'}" disabled="#{semmsi004Bean.disabledLink}">
                            <a4j:actionparam name="navModule" value="el" />
                            <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                            <a4j:actionparam name="moduleWithNavi" value="el" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                            <a4j:actionparam name="methodWithNavi" value="checkSiteInfo" />
                            <a4j:actionparam name="docApproveId" value="#{siteInfoSP.dataObj.docApproveId}" />
                            <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}"/>
                            </a4j:commandLink>
                            <a4j:jsFunction name="changePage" action="#{navAction.navi}" reRender="oppContent">
                                <a4j:actionparam name="navModule" value="el" />
                                <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                                <a4j:actionparam name="moduleWithNavi" value="el" />
                                <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                                <a4j:actionparam name="methodWithNavi" value="initAddSiteInfo" />
                                
                                <a4j:actionparam name="company" value="#{siteInfoSP.dataObj.company}" />
                                <a4j:actionparam name="region" value="#{siteInfoSP.dataObj.region}" />
                                <a4j:actionparam name="locationId" value="#{siteInfoSP.dataObj.locationId}" />
                                <a4j:actionparam name="locationCode" value="#{siteInfoSP.dataObj.locationCode}" />
                                <a4j:actionparam name="siteName" value="#{siteInfoSP.dataObj.siteName}" />
                                <a4j:actionparam name="siteStatus" value="#{siteInfoSP.dataObj.siteStatus}"/>
                                <a4j:actionparam name="contractNo" value="#{siteInfoSP.dataObj.contractNo}" />
                                <a4j:actionparam name="effDate" value="#{siteInfoSP.dataObj.effDateStr}" />
                                <a4j:actionparam name="expDate" value="#{siteInfoSP.dataObj.expDateStr}" />
                                <a4j:actionparam name="noExpireFlag" value="#{siteInfoSP.dataObj.noExpireFlag}"/>
                                <a4j:actionparam name="mode" value="EDIT" />
                                <a4j:actionparam name="page" value="SITEINFO" />
                            </a4j:jsFunction>
                            </div>
                        </rich:column>
                        
                        
                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                        title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <f:facet name="header">
                                <h:outputText value="View" styleClass="contentform" style="width: 40"/>
                            </f:facet>
                            <div align="center">
                            <a4j:commandButton id="btnView"  action="#{navAction.navi}" image="images/view.png" style="height: 15; width: 15"
                            reRender="oppContent" rendered="#{siteInfoSP.dataObj.siteInfoId != null}">
                                <a4j:actionparam name="navModule" value="el" />
                                        <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                                        <a4j:actionparam name="moduleWithNavi" value="el" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                                        <a4j:actionparam name="methodWithNavi" value="initAddSiteInfo" />
                                        
                                        <a4j:actionparam name="company" value="#{siteInfoSP.dataObj.company}" />
		                                <a4j:actionparam name="region" value="#{siteInfoSP.dataObj.region}" />
		                                <a4j:actionparam name="locationId" value="#{siteInfoSP.dataObj.locationId}" />
		                                <a4j:actionparam name="locationCode" value="#{siteInfoSP.dataObj.locationCode}" />
		                                <a4j:actionparam name="siteName" value="#{siteInfoSP.dataObj.siteName}" />
		                                <a4j:actionparam name="siteStatus" value="#{siteInfoSP.dataObj.siteStatus}"/>
		                                <a4j:actionparam name="contractNo" value="#{siteInfoSP.dataObj.contractNo}" />
		                                <a4j:actionparam name="effDate" value="#{siteInfoSP.dataObj.effDateStr}" />
		                                <a4j:actionparam name="expDate" value="#{siteInfoSP.dataObj.expDateStr}" />
		                                <a4j:actionparam name="noExpireFlag" value="#{siteInfoSP.dataObj.noExpireFlag}"/>
		                                <a4j:actionparam name="siteInfoId" value="#{siteInfoSP.dataObj.siteInfoId}"/>
                                        
                                        <a4j:actionparam name="mode" value="VIEW" />
                                        <a4j:actionparam name="page" value="SITEINFO" />
                            </a4j:commandButton>
                            </div>
                        </rich:column>
                        
                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                        title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <f:facet name="header">
                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
                            </f:facet>
                            <div align="center">
                            <a4j:commandButton id="btnEdit"  action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
                            reRender="oppContent" rendered="#{siteInfoSP.dataObj.siteInfoId != null}">
                                <a4j:actionparam name="navModule" value="el" />
                                        <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                                        <a4j:actionparam name="moduleWithNavi" value="el" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                                        <a4j:actionparam name="methodWithNavi" value="initAddSiteInfo" />
                                        
                                        <a4j:actionparam name="company" value="#{siteInfoSP.dataObj.company}" />
		                                <a4j:actionparam name="region" value="#{siteInfoSP.dataObj.region}" />
		                                <a4j:actionparam name="locationId" value="#{siteInfoSP.dataObj.locationId}" />
		                                <a4j:actionparam name="locationCode" value="#{siteInfoSP.dataObj.locationCode}" />
		                                <a4j:actionparam name="siteName" value="#{siteInfoSP.dataObj.siteName}" />
		                                <a4j:actionparam name="siteStatus" value="#{siteInfoSP.dataObj.siteStatus}"/>
		                                <a4j:actionparam name="contractNo" value="#{siteInfoSP.dataObj.contractNo}" />
		                                <a4j:actionparam name="effDate" value="#{siteInfoSP.dataObj.effDateStr}" />
		                                <a4j:actionparam name="expDate" value="#{siteInfoSP.dataObj.expDateStr}" />
		                                <a4j:actionparam name="noExpireFlag" value="#{siteInfoSP.dataObj.noExpireFlag}"/>
		                                <a4j:actionparam name="siteInfoId" value="#{siteInfoSP.dataObj.siteInfoId}"/>
                                        
                                        <a4j:actionparam name="mode" value="EDIT" />
                                        <a4j:actionparam name="page" value="SITEINFO" />
                            </a4j:commandButton>
                            </div>
                        </rich:column>
                        
                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                        title="#{siteAcqSP.dataObj.p_contract_no}">
                            <f:facet name="header">
                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
                            </f:facet>
                            <div align="center">
	                            <a4j:commandButton id="btnDelete"  action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15" 
	                            reRender="oppContent,frmSearchResult" rendered="#{siteInfoSP.dataObj.siteInfoId != null}"
	                            oncomplete="#{rich:component('mdpConfirmDelDialogDummy')}.show(); return false">
		                             <a4j:actionparam name="navModule" value="el" />
			                         <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
			                         <a4j:actionparam name="moduleWithNavi" value="el" />
			                         <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
			                         <a4j:actionparam name="methodWithNavi" value="initDeleteDummy" />
			                                            
			                         <a4j:actionparam name="siteInfoId" value="#{siteInfoSP.dataObj.siteInfoId}"/>
	                            </a4j:commandButton>
                            </div>
                        </rich:column>
                        
                            
                            <rich:column  sortBy="#{siteInfoSP.dataObj.contractNo}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <a4j:commandLink id="hlkViewPopupSiteInfo" value="#{siteInfoSP.dataObj.contractNo}" 
                                    oncomplete="showViewSiteInfoPopup()"
                                    action="#{navAction.navi}" >
                                    <a4j:actionparam name="navModule" value="el" />
                                    <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                                    <a4j:actionparam name="moduleWithNavi" value="common" />
                                    <a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
                                    <a4j:actionparam name="methodWithNavi" value="initPopup" />
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.siteInfoId}" />
                                    </a4j:commandLink>
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{siteInfoSP.dataObj.oldContractNo}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.oldContractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.headerl.oldContract']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <a4j:commandLink id="hlkViewPopupSiteInfo2" value="#{siteInfoSP.dataObj.oldContractNo}" 
                                    oncomplete="showViewSiteInfoPopup()"
                                    action="#{navAction.navi}" >
                                        <a4j:actionparam name="navModule" value="si" />
                                        <a4j:actionparam name="navProgram" value="SEMMSI004-1" />
                                        <a4j:actionparam name="moduleWithNavi" value="common" />
                                        <a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
                                        <a4j:actionparam name="methodWithNavi" value="initPopup" />
                                        <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.oldSiteInfoId}" />
                                        
                                    </a4j:commandLink>
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{siteInfoSP.dataObj.siteName}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.siteName']}" styleClass="contentform" style="width: 200"/>
                                </f:facet>
                                <div align="left">
                                    <h:outputText value="#{siteInfoSP.dataObj.siteName}" styleClass="contentform"  />
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{siteInfoSP.dataObj.locationId}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                            <f:facet name="header">
                                <h:outputText value="Location ID" styleClass="contentform" style="width: 100"/>
                            </f:facet>
                            <div align="center">
                                <h:outputText value="#{siteInfoSP.dataObj.locationId}" styleClass="contentform"  />
                            </div>
                        </rich:column>  
                            
                            <rich:column sortBy="#{siteInfoSP.dataObj.siteTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.siteType']}" styleClass="contentform" style="width: 150"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteInfoSP.dataObj.siteTypeName}" styleClass="contentform"  />
                                </div>
                            </rich:column>      
                            <rich:column  sortBy="#{siteInfoSP.dataObj.effDate}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.effDate']}" styleClass="contentform" style="width: 100"/>
                                    
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteInfoSP.dataObj.effDateStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>  
                            <rich:column sortBy="#{siteInfoSP.dataObj.expDate}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.expDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteInfoSP.dataObj.expDateStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{siteInfoSP.dataObj.siteStatus}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.contractStatus']}" styleClass="contentform" style="width: 50"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteInfoSP.dataObj.siteStatus}" styleClass="contentform"  />
                                </div>
                            </rich:column>  
                            
                            <rich:column  sortBy="#{siteInfoSP.dataObj.networkStatus}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteInfoSP.dataObj.contractNo} #{siteInfoSP.dataObj.siteName}">
                            <a4j:support event="onclick" action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteInfoSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.networkStatus']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteInfoSP.dataObj.networkStatus}" styleClass="contentform"  />
                                </div>
                            </rich:column>  
                            <f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmsi004Bean.siteInfoSPList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="16">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
                                            maxPages="#{semmsi004Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsi004Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                        </rich:dataTable>
                    </rich:panel>
                </h:panelGrid>
                <!-- end content layout data grid -->
                </a4j:form>
                </h:panelGrid>
            </rich:panel>
        </h:panelGrid>
        
<!-- Confirm alert  -->
<rich:modalPanel id="mdpConfirmSiteinfo" autosized="true">  
    <f:facet name="header">
        <h:outputText value="Confirm SiteInfo"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmSiteInfo">
        <table width="270px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="270px">
                        <h:outputText value="#{semmsi004Bean.comfirmSiteInfo}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="oppContent" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                            <a4j:actionparam name="methodWithNavi" value="initAddSiteInfo" />
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                            <a4j:actionparam name="methodWithNavi" value="initAddSiteInfo" />
                            <a4j:actionparam name="reqType" value="#{semmsi004Bean.tmpSiteInfoSP.reqType}" />
                            <a4j:actionparam name="docApproveId" value="#{semmsi004Bean.tmpSiteInfoSP.docApproveId}" />
                            <a4j:actionparam name="assignSiteInfoId" value="#{semmsi004Bean.tmpSiteInfoSP.assignSiteInfoId}" />
                            <a4j:actionparam name="siteInfoId" value="#{semmsi004Bean.tmpSiteInfoSP.siteInfoId}" />
                            <a4j:actionparam name="company" value="#{semmsi004Bean.tmpSiteInfoSP.company}" />
                            <a4j:actionparam name="region" value="#{semmsi004Bean.tmpSiteInfoSP.region}" />
                            <a4j:actionparam name="docApproveType" value="#{semmsi004Bean.tmpSiteInfoSP.docApproveType}" />
                            <a4j:actionparam name="assignContractNo" value="#{semmsi004Bean.tmpSiteInfoSP.assignContractNo}" />
                            <a4j:actionparam name="tabHeader" value="#{jspMsg['tab.header.site']}" />
                            <a4j:actionparam name="siteType" value="#{semmsi004Bean.tmpSiteInfoSP.siteType}"/>
                            <a4j:actionparam name="mode" value="EDIT" />
                            <a4j:actionparam name="page" value="SITEINFO" />                            
                            <rich:componentControl for="mdpConfirmSiteinfo" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmSiteinfo" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>


<!-- Delete Contract File -->
<rich:modalPanel id="mdpConfirmDelDialogDummy" autosized="true">
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDialogContractFile">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td><h:panelGrid columns="1" styleClass="contentlabelform"
                    width="180px">
                    <h:outputText value="#{semmco001Bean.msgDoDelete}" styleClass="ms7" />
                </h:panelGrid></td>
            </tr>
            <tr>
                <td><h:panelGrid columns="2" styleClass="contentlabelform">
                    <a4j:commandButton value="Yes" styleClass="rich-button"
                        action="#{navAction.navi}" immediate="true"
                        reRender="oppContent,frmSearchResult">
                         <a4j:actionparam name="navModule" value="el" />
                         <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                         <a4j:actionparam name="moduleWithNavi" value="el" />
                         <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                         <a4j:actionparam name="methodWithNavi" value="doDeleteDummy" />
                                            
                         <a4j:actionparam name="mode" value="EDIT" />
                         <a4j:actionparam name="page" value="SITEINFO" />
                    </a4j:commandButton>
                    <a4j:commandButton value="No" styleClass="rich-button"
                        immediate="true">
                        <rich:componentControl for="mdpConfirmDelDialogDummy"
                            operation="hide" event="onclick" />
                    </a4j:commandButton>
                </h:panelGrid></td>
            </tr>
        </table>
    </a4j:form>
</rich:modalPanel>
<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>
