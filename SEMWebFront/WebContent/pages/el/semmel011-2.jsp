<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid width="100%">

    <rich:panel id="pnlSiteInfo">
    <f:facet name="header">
    <h:outputText id="txtHeader" value="#{jspMsg['tab.header']} #{semmsi004Bean.tabHeader}"/>
    </f:facet>
    <h:panelGrid>
    <a4j:form id="frmSiteInfoError">
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
    
    <h:panelGrid columnClasses="gridContent" width="93%">
            <a4j:form id="frmAddSiteInfo">
            <h:panelGroup id="pnlButton">
                <table width="100%">
                <tr>
                <td width="50%" align="left">
                    
                </td>
                <td width="50%" align="right" valign="bottom">
                    <table id="tblButton">
                    <tr>
                    <td>
                    <a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
                    action="#{navAction.navi}" reRender="oppContent,frmSearchResult" rendered="true">
                    <a4j:actionparam name="navModule" value="el" />
                    <a4j:actionparam name="navProgram" value="SEMMEL011-1" />
                    <a4j:actionparam name="moduleWithNavi" value="el" />
                    <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                    <a4j:actionparam name="methodWithNavi" value="doBackWard" />
                    </a4j:commandButton>
                    </td>
                    <td>
                    <a4j:commandButton id="btnAdd" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
                    action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError,txtOldContractNo" 
                    rendered="#{semmsi004Bean.renderBtnSave}">
                    <a4j:actionparam name="navModule" value="el" />
                    <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                    <a4j:actionparam name="moduleWithNavi" value="el" />
                    <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                    <a4j:actionparam name="methodWithNavi" value="doSaveEditDummy" />
                    </a4j:commandButton>
                    </td>
                    <td>
                   
                    </td>
                    <td>
                   
                    </td>
                    <td>
                  
                    <a4j:commandButton styleClass="rich-button" id="btnTransfer" value="#{jspMsg['btn.transfer']}"
                     action="#{navAction.navi}" reRender="oppContent,pnlSearchCriteria,frmAddSiteInfo,frmSiteInfoError,txtOldContractNo,popupTransferDummyContract"
                     rendered="#{semmsi004Bean.siteInfoData.transferDummy == 'N'}"
                     oncomplete="#{rich:component('popupTransferDummyContract')}.show(); return false;">
                      <a4j:actionparam name="navModule" value="el" />
                      <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                      <a4j:actionparam name="moduleWithNavi" value="common" />
                      <a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
                      <a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
                      <a4j:actionparam name="fromButton" value="oldContractNo" />
                    </a4j:commandButton>
                    
                    </td>
                    
                    <td>
                  
                    <a4j:commandButton styleClass="rich-button" id="btnRollBack" value="#{jspMsg['btn.rollBack']}"
                     action="#{navAction.navi}" reRender="oppContent,pnlSearchCriteria,frmAddSiteInfo,frmSiteInfoError,txtOldContractNo,popupRollBackDummyContract"
                     rendered="#{semmsi004Bean.siteInfoData.transferDummy == 'Y'}"
                     oncomplete="#{rich:component('popupRollBackDummyContract')}.show(); return false;">
                      <a4j:actionparam name="navModule" value="el" />
                      <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                      <a4j:actionparam name="moduleWithNavi" value="common" />
                      <a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
                      <a4j:actionparam name="methodWithNavi" value="doSearchContractForRollBack" />
                      
                      
                    </a4j:commandButton>
                    
                    </td>
                    </tr>
                    </table>
                </td>
                </tr>
                </table>
                </h:panelGroup>
                <!-- start panel tab -->
                <h:panelGrid columnClasses="gridContent" width="100%">
                     <h:panelGrid id="pnlTab1" width="100%">
                            <rich:panel id="pnlSiteInfoContract">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['header.panel.siteInfo']}"/>
                                    </f:facet>
                                    <h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
                                        <h:panelGroup>
                                        <table width="100%">
                                        <tr>
                                            <td colspan="4" align="right">
                                               
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="right" width="35%" valign="top">
                                            <h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
                                            </td>
                                            <td width="65%" colspan="3">
                                            <h:inputText id="txtContractNoDisplay2" value="#{semmsi004Bean.siteInfoData.contractNo}" 
                                             size="16"  readonly="true" styleClass="ms28Blue" disabled="#{semmsi004Bean.disabledModeView}"/>
                                             <rich:spacer width="5"/>
                                            
                                        
                                            </td>
                                         </tr>
                                         
                                         <tr>
                                         <td colspan="4">
                                          <table width="100%">
                                          <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                        <h:inputText id="txtCompany" value="#{semmsi004Bean.siteInfoData.company}" 
                                        size="23" maxlength="20" readonly="true" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        
                                        </td>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtRegion2" value="#{semmsi004Bean.siteInfoData.region}"  
                                        disabled="#{semmsi004Bean.disabledModeView}" size="13" maxlength="10"/> 
                                        
                                        </td>
                                         </tr>
                                         
                                        <tr>
                                        <td align="right" width="20%">
                                        
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                            <h:inputText id="txtSiteName" value="#{semmsi004Bean.siteInfoData.siteName}" 
                                            size="30"  maxlength="200" disabled="#{semmsi004tab1Bean.disabledSiteName or semmsi004Bean.disabledModeView}"/>
                                            <rich:spacer width="10"></rich:spacer>
                                            <h:selectBooleanCheckbox id="chkEditSite"  styleClass="ms7" onclick="onCheckSiteNameJS();" 
                                             value="#{semmsi004tab1Bean.chkEditSite}"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                                 <a4j:jsFunction name="onCheckSiteNameJS" reRender="txtSiteName"
                                                     action="#{semmel011Action.renderedSiteName}"/>
                                             </h:selectBooleanCheckbox>
                                            <h:outputText value="#{jspMsg['label.editSite']}"  styleClass="ms7"/>
                                            <script type="text/javascript">
                                                function renderedSiteName(){
                                                    var chkEditSite = document.getElementById("incContent:frmAddSiteInfo:pnlTab1:chkEditSite").checked;
                                                    var siteName = document.getElementById("incContent:frmAddSiteInfo:pnlTab1:txtSiteName");
                                                    if(chkEditSite){
                                                        siteName.disabled = false;
                                                    }else{
                                                        siteName.disabled = true;
                                                    }
                                                }
                                            </script>
                                        </td>
                                        <td align="right" width="20%">
                                        
                                        </td>
                                        <td width="20%">
                                        <a4j:region>
                                        <h:panelGroup>
                                        
                                        
                                        <a4j:status onstart="#{rich:component('mdpWait')}.show(); doTimer()"
                                            onstop="pageOnLoad(); doClearTimer(); #{rich:component('mdpWait')}.hide()" />
                                        
                                        <rich:modalPanel id="mdpWait" autosized="true" width="180" height="70" 
                                            moveable="false" resizeable="false">
                                            <f:facet name="header">
                                                <h:outputText value="Processing" />
                                            </f:facet>
                                            <f:facet name="controls">
                                                <h:panelGroup>
                                                    <h:graphicImage value="images/ico_close.png"
                                                        id="gpiHidePopUpProgress" style="cursor:pointer" />
                                                    <rich:componentControl for="mdpWait" attachTo="gpiHidePopUpProgress"
                                                        operation="hide" event="onclick" />
                                                </h:panelGroup>
                                            </f:facet>
                                            
                                            <div align="center">
                                                <table width="100%" border="0" cellpadding="1" cellspacing="0">
                                                    <tr>
                                                        <td align="right"><h:graphicImage value="images/loading.gif"/></td>
                                                        <td><h:outputText styleClass="ms7" value="Wait Please..." /></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </rich:modalPanel>
                                        
                                        </h:panelGroup>
                                        </a4j:region>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%" >
                                        <h:selectOneMenu id="ddlSiteType" value="#{semmsi004Bean.siteInfoData.siteType}" 
                                        disabled="#{semmsi004Bean.disabledModeView}"> 
                                            <f:selectItems value="#{semmsi004Bean.siteTypeList}"/>
                                        </h:selectOneMenu>
                                        </td>
                                        <td align="right" width="20%" >
                                        <h:outputText value="#{jspMsg['label.groupRent']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:selectOneMenu id="ddlGroupRent" value="#{semmsi004Bean.siteInfoData.groupRent}" 
                                        disabled="#{semmsi004Bean.disabledModeView}"> 
                                            <f:selectItems value="#{semmsi004Bean.groupRentList}"/>
                                        </h:selectOneMenu>
                                        </td>
                                        </tr>
                                          <tr>
                                            <td align="right" width="20%">
                                           		<h:graphicImage  value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
                                            </td>
                                            <td width="80%" colspan="3">
                                            <table width="100%">
                                            <tr>
                                            <td align="left" width="60%">
                                            	
					                			
						                			<h:inputText id="txtDummyContractNo" value="#{semmsi004Bean.siteInfoData.contractNo}" size="18" 
					            						maxlength="16" 
					            						disabled="#{semmsi004Bean.disabledModeView}">
					            						<a4j:support event="onblur" reRender="txtDummyContractNo,txtContractNoDisplay2"></a4j:support>
					             					</h:inputText>
                                            </td>
                                            <td align="left" width="40%">
                                            <h:selectBooleanCheckbox id="chkDummyContract" value="#{true}" styleClass="ms7"
                                             disabled="true"/>
                                                <h:outputText value="#{jspMsg['label.dummyContract']}" styleClass="ms7" />
                                            <a4j:jsFunction name="RenderDummyContractNoJS" reRender="pnlSiteInfoContract,dummyContractNo,contractNo3" 
                                            action="#{semmsi004tab1Action.renderedContractNo}"/>
                                            <rich:spacer width="5"></rich:spacer>
                                            
                                            </td>
                                            </tr>
                                            </table>
                                            
                                            </td>
                                            </tr>
                                             <tr>
                                            <td align="right" width="20%">
                                            <h:graphicImage value="images/icon_required.gif"/>
                                            <rich:spacer width="5"></rich:spacer>
                                            <h:outputText value="#{jspMsg['labe.firstEffDate']} :" styleClass="ms7"/>
                                            </td>
                                            <td width="80%" colspan="3">
                                            <table width="100%">
                                            <tr>
                                            <td align="left" width="60%">
                                            <rich:calendar id="cldFirstEffDate" locale="th" enableManualInput="true" 
                                            datePattern="dd/MM/yyyy" 
                                            value="#{semmsi004Bean.siteInfoData.fristEffDT}" 
                                            showWeeksBar="false" 
                                            inputSize="13"
                                            oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                            cellWidth="20px" cellHeight="20px"
                                            label="#{jspMsg['labe.firstEffDate']}"
                                            disabled="#{semmsi004Bean.disabledModeView}">
                                            </rich:calendar>
                                            </td>
                                            <td align="left" width="40%">
                                             <h:selectBooleanCheckbox id="chkNoExpireFlag" value="#{semmsi004Bean.chkNoExpireFlag}"
                                             onclick="RenderAgeJS();" styleClass="ms7"
                                             disabled="#{semmsi004Bean.disabledModeView}"/>
                                            <h:outputText value="#{jspMsg['label.noExpireFlag']}" styleClass="ms7" />
                                            <a4j:jsFunction name="RenderAgeJS" reRender="txtAgeYear,txtAgeMonth,txtAgeDay,cldExpDate,imgStarExpDate" 
                                            action="#{semmel011Action.renderAge}"/>
                                            </td>
                                            </tr>
                                            </table>
                                            </td>
                                         </tr>
                                         <tr>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                        <rich:calendar id="cldEffDate" locale="th" enableManualInput="true" 
                                            datePattern="dd/MM/yyyy" 
                                            value="#{semmsi004Bean.siteInfoData.effDate}" 
                                            showWeeksBar="false" 
                                            inputSize="13"
                                            oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                            cellWidth="20px" cellHeight="20px"
                                            label="#{jspMsg['labe.firstEffDate']}"
                                            disabled="#{semmsi004Bean.disabledModeView}"
                                            oninputblur="setFirstEffDate(#{semmsi004Bean.reqTypeParam});"
                                            oncollapse="setFirstEffDate(#{semmsi004Bean.reqTypeParam});"
                                            oninputchange="reRenderDate();"
                                            >
                                        </rich:calendar>
                                        <a4j:jsFunction name="reRenderDate" reRender="cldEffDate,cldFirstEffDate"></a4j:jsFunction>
                                        
                                        <a4j:jsFunction name="calAge" action="#{semmel011Action.calAge}"
                                        reRender="frmSiteInfoError,txtAgeYear,txtAgeMonth,txtAgeDay,cldFirstEffDate, txtTotalAgeRentAmt, txtTotalAgeServiceAmt, txtTotalAgeRentServiceAmtTab1">
                                        </a4j:jsFunction>
                                        <script type="text/javascript" >
                                        function setFirstEffDate(reqType){
                                            var cldEffDate = document.getElementById("incContent:frmAddSiteInfo:cldEffDateInputDate").value;
                                            var cldExpDate = document.getElementById("incContent:frmAddSiteInfo:cldExpDateInputDate").value;
                                            var cldFirstEffDate = document.getElementById("incContent:frmAddSiteInfo:cldFirstEffDateInputDate");
                                          //  var txtOldContractNo = document.getElementById("incContent:frmAddSiteInfo:txtOldContractNo").value;
                                           // alert('test');
                                            if(cldEffDate != '' && cldFirstEffDate.value == ''){
                                                
                                                    cldFirstEffDate.value = cldEffDate;
                                            
                                            }
                                            reRenderDate();
                                        }
                                        </script>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage id="imgStarExpDate" value="images/icon_required.gif" 
                                        rendered="#{semmsi004tab2Bean.renderStarImage}"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.expDate']} :" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <rich:calendar id="cldExpDate" locale="th" enableManualInput="true" 
                                        datePattern="dd/MM/yyyy" 
                                        value="#{semmsi004Bean.siteInfoData.expDate}" 
                                        showWeeksBar="false" 
                                        inputSize="13"
                                        oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                        cellWidth="20px" cellHeight="20px"
                                        label="#{jspMsg['label.expDate']}"
                                        disabled="#{semmsi004Bean.disabledExpDate || semmsi004Bean.disabledModeView}"
                                        oninputblur="checkCalAge();"
                                        oncollapse="checkCalAge();">
                                        </rich:calendar>
                                        <script type="text/javascript">
                                        function checkCalAge(){
                                            var cldEffDate = document.getElementById("incContent:frmAddSiteInfo:cldEffDateInputDate").value;
                                            var cldExpDate = document.getElementById("incContent:frmAddSiteInfo:cldExpDateInputDate").value;
                                            if(cldEffDate != '' && cldExpDate != ''){
                                                calAge();
                                            }else{
                                                var ageYear = document.getElementById("incContent:frmAddSiteInfo:txtAgeYear");
                                                var ageMonth = document.getElementById("incContent:frmAddSiteInfo:txtAgeMonth");
                                                var ageDay = document.getElementById("incContent:frmAddSiteInfo:txtAgeDay");
                                                ageYear.value = '';
                                                ageMonth.value = '';
                                                ageDay.value = '';
                                            }
                                            
                                        }
                                        </script>
                                        </td>
                                     </tr>
                                     <tr>
                                        <td align="right" width="20%">
                                        <h:panelGroup id="pnlImgStar" rendered="#{semmsi004tab2Bean.renderStarImage}">
                                        
                                        </h:panelGroup>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.ageContract']}" styleClass="ms7"/>
                                        </td>
                                        <td width="80%" colspan="3">
                                         <table>
                                         <tr>
                                            <td>
                                                <h:inputText id="txtAgeYear" value="#{semmsi004Bean.siteInfoData.ageYear}" size="3"
                                                styleClass="inputRight" disabled="true"/>
                                                <rich:spacer width="2" />
                                                <h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
                                                <rich:spacer width="2" />
                                                </td>
                                                <td>
                                                <h:inputText id="txtAgeMonth" value="#{semmsi004Bean.siteInfoData.ageMonth}" size="3"
                                            styleClass="inputRight" disabled="true"/>
                                            <rich:spacer width="2"></rich:spacer>
                                            <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
                                            <rich:spacer width="2" />
                                                </td>
                                                <td>
                                                 <h:inputText id="txtAgeDay" value="#{semmsi004Bean.siteInfoData.ageDay}" size="3"
                                             styleClass="inputRight" disabled="true"/>
                                             <rich:spacer width="2"></rich:spacer>
                                             <h:outputText value="#{jspMsg['label.day']}" styleClass="ms7" />
                                             <rich:spacer width="2" />
                                                </td>
                                                </tr>
                                            </table>
                                        </td>
                                     </tr>
                                        
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                        <h:inputText id="txtSiteStatus" value="#{semmsi004Bean.siteInfoData.siteStatusName}" 
                                                     size="60" 
                                                     maxlength="60" 
                                                     disabled="true">
                                        </h:inputText>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:panelGroup rendered="#{semmsi004Bean.reqTypeParam eq '99'}">
                                       
                                        <rich:spacer width="5"></rich:spacer>
                                        </h:panelGroup>
                                        <h:outputText value="#{jspMsg['label.terminateDate']} :" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <rich:calendar id="cldTerminateDate" locale="th" enableManualInput="true"  
                                        datePattern="dd/MM/yyyy" 
                                        value="#{semmsi004Bean.siteInfoData.terminateDate}" 
                                        showWeeksBar="false" 
                                        inputSize="13"
                                        oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                        cellWidth="20px" cellHeight="20px"
                                        label="#{jspMsg['label.terminateDate']}"
                                        disabled="#{semmsi004Bean.disabledModeView}">
                                        </rich:calendar> 
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.pendingStatus']}" styleClass="ms7"/>
                                        </td>
                                        <td  width="40%">
                                        <h:selectBooleanCheckbox id="chkPendingStatus" value="#{semmsi004Bean.siteInfoData.chkPendingStatusBoolean}" 
                                         disabled="#{semmsi004Bean.disabledModeView}"
                                         onclick="renderedPendingDate();"/>
                                        <h:outputText value="#{jspMsg['column.header.pending']}"  styleClass="ms7"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.pendingDate']} :" styleClass="ms7"/>
                                        <rich:spacer width="2"></rich:spacer>
                                        <rich:calendar id="cldPendingDate" locale="th" enableManualInput="true"  
                                        datePattern="dd/MM/yyyy" 
                                        value="#{semmsi004Bean.siteInfoData.pendingDate}" 
                                        showWeeksBar="false" 
                                        inputSize="13"
                                        oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                        cellWidth="20px" cellHeight="20px"
                                        label="#{jspMsg['label.pendingDate']}"
                                        disabled="#{semmsi004Bean.disabledModeView}">
                                        </rich:calendar> 
                                        <script type="text/javascript">
                                                function renderedPendingDate(){
                                                    var chkPendingStatus = document.getElementById("incContent:frmAddSiteInfo:chkPendingStatus").checked;
                                                    var pendingDate = document.getElementById("incContent:frmAddSiteInfo:cldPendingDateInputDate");
                                                    if(chkPendingStatus){
                                                        pendingDate.disabled = false;
                                                    }else{
                                                        pendingDate.disabled = true;
                                                    }
                                                }
                                        </script>
                                        </td>
                                        <td align="right" width="20%">
                                       
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteInfoStatus']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:selectOneMenu id="ddlSiteInfoStatus" value="#{semmsi004Bean.siteInfoData.siteInfoStatus}" 
                                        disabled="#{semmsi004Bean.disabledModeView}"> 
                                            <f:selectItems value="#{semmsi004Bean.siteInfoStatusList}"/>
                                        </h:selectOneMenu> 
                                        </td>
                                        </tr>
                                         <tr>
                                        <td align="right" width="20%" valign="top">
                                        <h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
                                        </td>
                                        <td width="80%" colspan="3">
                                        <h:inputTextarea id="txtRemark" value="#{semmsi004Bean.siteInfoData.remark}" 
                                        cols="100" rows="3" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        
                                        </td>
                                     </tr>
                                        </table>
                                         </td>
                                         </tr>
                                         </table>
                                    </h:panelGroup>
                                    </h:panelGrid>
                            </rich:panel>
                            <rich:spacer height="10"></rich:spacer>
                            <!-- panel search location criteria -->
                            <a4j:region>
                              <rich:panel id="pnlLocation" >
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['header.panel.location']}"/>
                                    </f:facet>
                                    <div align="left">
                                        <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab1Bean.renderedMsgLocation}"/>
                                    </div>
                                    <h:panelGrid id="pnlSearchLocationCriteria" width="90%" border="0" cellpadding="0" cellspacing="1">
                                        <h:panelGroup>
                                        <table width="100%">
                                             <tr>
                                                <td align="right" width="20%">
                                                
                                                <rich:spacer width="5"></rich:spacer>
                                                <h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
                                                </td>
                                                <td width="38%">
                                                <h:panelGroup>
                                                <h:inputText id="txtLocationId" value="#{popupSiteLocationBean.locationId}" onchange="getLocationJS();" 
                                                size="18" maxlength="15" disabled="#{semmsi004Bean.disabledModeView}">
                                                <a4j:jsFunction name="getLocationJS" reRender="pnlSearchLocationCriteria" action="#{popupSiteLocationAction.getSiteLocation}"/>
                                                </h:inputText>
                                                <rich:spacer width="2"></rich:spacer>
                                                <a4j:commandButton id="btnSrchLocation" value="..." action="#{navAction.navi}"
                                                oncomplete="#{rich:component('popupSearchSiteLocation')}.show(); return false" 
                                                reRender="popupSearchSiteLocation,pnlSearchLocationCriteria" 
                                                disabled="#{semmsi004Bean.disabledModeView}">
                                                <a4j:actionparam name="navModule" value="si" />
                                                <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                                                <a4j:actionparam name="moduleWithNavi" value="common" />
                                                <a4j:actionparam name="actionWithNavi" value="PopupSiteLocation" />
                                                <a4j:actionparam name="methodWithNavi" value="initPopupSiteLocation" />
                                                </a4j:commandButton>
                                                </h:panelGroup>
                                                </td>
                                                <td align="right" width="20%">
                                                <h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
                                                </td>
                                                <td width="22%">
                                                <h:inputText id="txtLocationCode" value="#{popupSiteLocationBean.locationCode}" readonly="true" 
												disabled="#{semmsi004Bean.disabledModeView}" 
                                                size="13" maxlength="10"/>
                                                </td>
                                             </tr>
                                             
                                             <tr>
                                                <td align="right" width="20%">
                                                <h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
                                                </td>
                                                <td width="38%">
                                                <h:inputText id="txtLocationName" value="#{popupSiteLocationBean.locationName}" 
                                                size="30" maxlength="255" readonly="true" disabled="#{semmsi004Bean.disabledModeView}"/>
                                                </td>
                                                <td align="right" width="20%">
                                                <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
                                                </td>
                                                <td width="22%">
                                                <h:inputText id="txtRegion1" value="#{popupSiteLocationBean.region}"  size="13" 
                                                maxlength="10" readonly="true" disabled="#{semmsi004Bean.disabledModeView}" /> 
                                                </td>
                                             </tr>
                                             
                                              <tr>
                                                <td align="right" width="20%">
                                                <h:outputText value="#{jspMsg['label.stationType']}" styleClass="ms7"/>
                                                </td>
                                                <td width="38%">
                                                <h:inputText id="txtStationType" value="#{popupSiteLocationBean.stationType}" 
                                                size="18"  readonly="true" disabled="#{semmsi004Bean.disabledModeView}"/>
                                                </td>
                                                <td align="right" width="20%">
                                               
                                                </td>
                                                <td width="23%">
                                                
                                                </td>
                                             </tr>
                                             
                                              <tr>
                                                <td align="left" colspan="2" width="58%">
                                                <h:panelGrid columns="3" id="grdSearchCommand">
                                                <h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
                                                <a4j:commandButton id="btnAddLocation" value="#{jspMsg['btn.add']}" styleClass="rich-button"
                                                action="#{navAction.navi}"   
                                                reRender="pnlSiteInfoContract, pnlLocation,grdSearchCommand,pnlSearchLocationCriteria
                                                ,pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError"
                                                oncomplete="if(#{semmsi004tab1Bean.popupConfirmAdd == 'true'})#{rich:component('mdpConfirmAddDialogLocation')}.show();"
                                                disabled="#{semmsi004Bean.disabledModeView}">
                                                <a4j:actionparam name="navModule" value="si" />
                                                <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
                                                <a4j:actionparam name="moduleWithNavi" value="si" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                                                <a4j:actionparam name="methodWithNavi" value="initAddLocation" />
                                                <a4j:actionparam name="page" value="genDummy" />
                                                <a4j:actionparam name="mode" value="ADD" />
                                                </a4j:commandButton>  
                                                </h:panelGroup>
                                                <h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
                                                <a4j:commandButton id="btnSaveLocation" value="#{jspMsg['btn.save']}" styleClass="rich-button"
                                                action="#{navAction.navi}" 
                                                reRender="pnlSiteInfoContract, pnlLocation,grdSearchCommand,pnlSearchLocationCriteria,
                                                pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError"  
                                                oncomplete="if(#{semmsi004tab1Bean.popupConfirmAdd == 'true'})#{rich:component('mdpConfirmUpdateDialogLocation')}.show();"
                                                disabled="#{semmsi004Bean.disabledModeView}">
                                                <a4j:actionparam name="navModule" value="si" />
                                                <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
                                                <a4j:actionparam name="moduleWithNavi" value="si" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                                                <a4j:actionparam name="methodWithNavi" value="initAddLocation" />
                                                <a4j:actionparam name="mode" value="EDIT" />
                                                <a4j:actionparam name="page" value="genDummy" />
                                                </a4j:commandButton>  
                                                </h:panelGroup>
                                                <h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
                                                <a4j:commandButton id="btnClearLocation" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
                                                action="#{navAction.navi}" disabled="#{semmsi004Bean.disabledModeView}"
                                                reRender="pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation,frmSiteInfoError"
                                                >
                                                <a4j:actionparam name="navModule" value="si" />
                                                <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" />
                                                <a4j:actionparam name="moduleWithNavi" value="si" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                                                <a4j:actionparam name="methodWithNavi" value="doClearLocation" />
                                                <a4j:actionparam name="page" value="genDummy" />
                                                </a4j:commandButton>
                                                </h:panelGroup>
                                                </h:panelGrid>
                                                </td>
                                                <td  width="20%">
                                                </td>
                                                <td width="22%">
                                                <h:selectBooleanCheckbox id="chkMainLocation" value="#{semmsi004tab1Bean.chkMainLocFlag}" 
                                                styleClass="ms7" disabled="#{semmsi004Bean.disabledModeView}"/>
                                                    <h:outputText value="#{jspMsg['label.mainLocation']}" styleClass="ms7" />
                                                </td>
                                             </tr>
                                        </table>
                                        </h:panelGroup>
                                    </h:panelGrid>
                                    </rich:panel>
            
                                    <rich:spacer height="10"></rich:spacer>
                                    <!-- Result Search Location -->
                                    <rich:panel id="pnlResultSearchLocation">
                                    <f:facet name="header" >
                                        <h:outputText value="#{jspMsg['header.panel.location']}" />
                                    </f:facet>
                                        <rich:dataTable id="dtbLocation" width="97%" cellpadding="1" cellspacing="0" border="0"
                                        var="siteInfoMapLocSP" value="#{semmsi004tab1Bean.siteInfoMapLocSPList}" reRender="dtbLocation" 
                                        rows="#{semmsi004tab1Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                                        <a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbLocation">
                                            <a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
                                        </a4j:support>
                                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}" 
                                        rendered="#{semmsi004Bean.renderedModeView}">
                                            <f:facet name="header" >
                                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
                                            </f:facet>
                                            <div align="center">
                                                <a4j:commandButton action="#{navAction.navi}" reRender="pnlLocation"
                                                image="images/edit.png" style="height: 15; width: 15"
                                                disabled="#{semmsi004Bean.disabledModeView}"
                                                rendered="true">
                                                    <a4j:actionparam name="navModule" value="si" />
                                                    <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                                                    <a4j:actionparam name="moduleWithNavi" value="si" />
                                                    <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                                                    <a4j:actionparam name="methodWithNavi" value="initUpdateLocation" />
                                                    <a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
                                                    <a4j:actionparam name="locationId" value="#{siteInfoMapLocSP.locationId}" />
                                                    <a4j:actionparam name="locationCode" value="#{siteInfoMapLocSP.locationCode}" />
                                                    <a4j:actionparam name="locationName" value="#{siteInfoMapLocSP.locationName}" />
                                                    <a4j:actionparam name="region" value="#{siteInfoMapLocSP.region}" />
                                                    <a4j:actionparam name="stationType" value="#{siteInfoMapLocSP.stationType}" />
                                                </a4j:commandButton>                                    
                                            </div>
                                        </rich:column>
                                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}"
                                        rendered="#{semmsi004Bean.renderedModeView}">
                                            <f:facet name="header">
                                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
                                            </f:facet>
                                            <div align="center">
                                                <a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialogLocation')}.show(); return false" 
                                                action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
                                                disabled="#{semmsi004Bean.disabledModeView}"
                                                rendered="true" reRender="mdpConfirmDelDialogLocation">
                                                    <a4j:actionparam name="navModule" value="si" />
                                                    <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                                                    <a4j:actionparam name="moduleWithNavi" value="si" />
                                                    <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                                                    <a4j:actionparam name="methodWithNavi" value="initDeleteLocation" />
                                                    <a4j:actionparam name="rowId" value="#{siteInfoMapLocSP.rowId}" />
                                                </a4j:commandButton>                                    
                                            </div>
                                        </rich:column>
                                        <rich:column sortBy="#{siteInfoMapLocSP.locationId}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.locationId']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="center">
                                                <h:outputText value="#{siteInfoMapLocSP.locationId}" styleClass="contentform"  />
                                            </div>
                                        </rich:column>
                                        <rich:column sortBy="#{siteInfoMapLocSP.locationCode}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.locationCode']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="center">
                                                <h:outputText value="#{siteInfoMapLocSP.locationCode}" styleClass="contentform" ></h:outputText>
                                            </div>
                                        </rich:column>
                                        <rich:column sortBy="#{siteInfoMapLocSP.locationName}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.locationName']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="left">
                                                <h:outputText value="#{siteInfoMapLocSP.locationName}" styleClass="contentform"  />
                                            </div>
                                        </rich:column>
                                        <rich:column sortBy="#{siteInfoMapLocSP.region}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.region']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="center">
                                                <h:outputText value="#{siteInfoMapLocSP.region}" styleClass="contentform"  />
                                            </div>
                                        </rich:column>
                                        <rich:column sortBy="#{siteInfoMapLocSP.stationType}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.stationType']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="center">
                                                <h:outputText value="#{siteInfoMapLocSP.stationType}" styleClass="contentform"  />
                                            </div>
                                        </rich:column>
                                        <rich:column sortBy="#{siteInfoMapLocSP.rentAmt}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.rent']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="right">
                                                <h:outputText value="#{siteInfoMapLocSP.rentAmt}" styleClass="contentform" >
                                                <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                                </h:outputText>
                                            </div>
                                        </rich:column>      
                                        <rich:column sortBy="#{siteInfoMapLocSP.mainLocFlag}" styleClass="#{(semmsi004Bean.tmpRowId==siteInfoMapLocSP.rowId)?'onClick':'unClick'}">
                                            <f:facet name="header">
                                                <h:outputText value="#{jspMsg['column.header.mainLocation']}" styleClass="contentform" />
                                            </f:facet>
                                            <div align="center">
                                                <h:outputText value="#{siteInfoMapLocSP.mainLocFlag}" styleClass="contentform"  />
                                            </div>
                                        </rich:column>                              
                                        <f:facet name="footer">
                                            <rich:columnGroup>
                                                <rich:column colspan="4">
                                                    <h:outputFormat value="#{msg['message.totalRecords']}">
                                                        <f:param value="#{fn:length(semmsi004tab1Bean.siteInfoMapLocSPList)}"></f:param>
                                                    </h:outputFormat>
                                                </rich:column>
                                                <rich:column colspan="12">
                                                    <rich:datascroller immediate="true" rendered="true" align="left" for="dtbLocation"
                                                        maxPages="#{semmsi004tab1Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                                        stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                                        id="dstLocation" 
                                                        style="background-color: #cccccc;"
                                                        page="#{semmsi004tab1Bean.scrollerPage}" 
                                                    />
                                                </rich:column>
                                            </rich:columnGroup>
                                        </f:facet>
                                    </rich:dataTable>
                            </rich:panel>
                            </a4j:region>
                            <!-- panel SiteInfo -->
                            <rich:spacer height="10"></rich:spacer>
                            <rich:panel id="pnlSiteInfo2">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['label.place']}"/>
                                    </f:facet>
                                    <h:panelGrid  width="90%" border="0" cellpadding="0" cellspacing="1">
                                    <h:panelGroup>
                                        <table width="100%">
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.placeType']}" styleClass="ms7"/>
                                        </td>
                                        <td colspan="3" width="80%">
                                        <h:selectOneMenu id="ddlPlaceType" value="#{semmsi004Bean.siteInfoData.placeType}" 
                                        disabled="#{semmsi004Bean.disabledModeView}"> 
                                            <f:selectItems value="#{semmsi004tab1Bean.placeTypeList}"/>
                                        </h:selectOneMenu>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%" valign="top">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteHouseNo']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%" colspan="3">
                                         <h:inputTextarea id="txtSiteHouseNo" value="#{semmsi004Bean.siteInfoData.siteHouseNo}" 
                                         rows="3" cols="100" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteBuilding']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                         <h:inputText id="txtSiteBuilding" value="#{semmsi004Bean.siteInfoData.siteBuilding}" 
                                         size="30" maxlength="100" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteStreet']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtSiteStreet" value="#{semmsi004Bean.siteInfoData.siteStreet}" 
                                        size="30" maxlength="100" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteFloor']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                         <h:inputText id="txtSiteFloor" value="#{semmsi004Bean.siteInfoData.siteFloor}" 
                                         size="13" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteTambon']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtSiteTambon" value="#{semmsi004Bean.siteInfoData.siteTambon}" 
                                        size="30" maxlength="50" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteDeckAreaType']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                            <table>
                                            <tr>
                                            <td>
                                             <h:selectOneMenu id="ddlSiteDeckAreaType" value="#{semmsi004Bean.siteInfoData.deckAreaType}"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:selectItems value="#{semmsi004tab1Bean.deckAreaTypeList}"/>
                                             </h:selectOneMenu>
                                             </td>
                                             <td>
                                             <h:inputText id="txtSiteDeckArea" value="#{semmsi004Bean.siteInfoData.deckArea}" size="18" 
                                                 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
                                                 onblur="return numberformat.moneyFormat(this);"
                                                 onfocus="return numberformat.setCursorPosToEnd(this);"
                                                 maxlength="16" 
                                                 styleClass="inputRight"
                                                 disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                                </h:inputText>
                                             <rich:spacer width="5"></rich:spacer>
                                             <h:outputText value="#{jspMsg['label.siteDeckArea']}" styleClass="ms7"/>
                                             </td>
                                             </tr>
                                             </table>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteAmphur']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                         <h:selectOneMenu id="ddlSiteAmphur" value="#{semmsi004Bean.siteInfoData.siteAmphurId}"
                                         disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:selectItems value="#{semmsi004tab1Bean.siteAmphurList}"/>
                                         </h:selectOneMenu>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteBuildingAreaType']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                            <table>
                                            <tr>
                                            <td>
                                             <h:selectOneMenu id="ddlSiteBuildingAreaType" value="#{semmsi004Bean.siteInfoData.buildingAreaType}"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:selectItems value="#{semmsi004tab1Bean.buildingAreaTypeList}"/>
                                             </h:selectOneMenu>
                                             </td>
                                             <td>
                                             <h:inputText id="txtSiteBuildingArea" value="#{semmsi004Bean.siteInfoData.buildingArea}" size="18"  
                                                 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
                                                 onblur="return numberformat.moneyFormat(this);"
                                                 onfocus="return numberformat.setCursorPosToEnd(this);"
                                                 maxlength="16" 
                                                 styleClass="inputRight"
                                                 disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                                </h:inputText>
                                             <rich:spacer width="5"></rich:spacer>
                                             <h:outputText value="#{jspMsg['label.siteBuildingArea']}" styleClass="ms7"/>
                                             </td>
                                             </tr>
                                             </table>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteProvince']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <a4j:region>
                                         <h:selectOneMenu id="ddlSiteProvince" value="#{semmsi004Bean.siteInfoData.siteProvinceId}" onchange="GetSiteAmphurListJS();"
                                         disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:selectItems value="#{semmsi004Bean.provinceList}"/>
                                         </h:selectOneMenu>
                                         <a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlSiteAmphur" action="#{semmel011Action.getSiteAmphurList}"/>
                                         </a4j:region>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteRoomNo']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                         <h:inputText id="txtSiteRoomNo" value="#{semmsi004Bean.siteInfoData.siteRoomNo}" 
                                         size="13" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.sitePostcode']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtSitePostcode" value="#{semmsi004Bean.siteInfoData.sitePostCode}"  
                                        size="8" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteRoomArea']}" styleClass="ms7"/>
                                        </td>
                                        <td width="80%" colspan="3">
                                         <table>
                                            <tr>
                                            <td>
                                             <h:selectOneMenu id="ddlRoomAreaType" value="#{semmsi004Bean.siteInfoData.roomAreaType}"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                            <f:selectItems value="#{semmsi004tab1Bean.roomAreaTypeList}"/>
                                             </h:selectOneMenu>
                                             </td>
                                             <td>
                                             <h:inputText id="txtSiteRoomArea" value="#{semmsi004Bean.siteInfoData.roomArea}" size="18"  
                                             onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
                                             onblur="return numberformat.moneyFormat(this);"
                                             onfocus="return numberformat.setCursorPosToEnd(this);"
                                             maxlength="16" 
                                             styleClass="inputRight"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                            <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                            </h:inputText>
                                             <rich:spacer width="5"></rich:spacer>
                                             <h:outputText value="#{jspMsg['label.siteBuildingArea']}" styleClass="ms7"/>
                                             </td>
                                             </tr>
                                         </table>
                                        </td>
                                        </tr>
                                        
                                            <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteLandArea']}" styleClass="ms7"/>
                                        </td>
                                        <td width="80%" colspan="3">
                                          <table>
                                            <tr>
                                            <td>
                                             <h:selectOneMenu id="ddlLandAreaType" value="#{semmsi004Bean.siteInfoData.landAreaType}"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:selectItems value="#{semmsi004tab1Bean.landAreaTypeList}"/>
                                             </h:selectOneMenu>
                                             </td>
                                             <td>
                                             <h:inputText id="txtSiteLandArea" value="#{semmsi004Bean.siteInfoData.landArea}" size="18" 
                                             onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
                                             onblur="return numberformat.moneyFormat(this);"
                                             onfocus="return numberformat.setCursorPosToEnd(this);"
                                             maxlength="16" 
                                             styleClass="inputRight"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                            <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                            </h:inputText>
                                             <rich:spacer width="5"></rich:spacer>
                                             <h:selectOneMenu id="ddlSiteLandAreaType" value="#{semmsi004Bean.siteInfoData.landAreaUnitType}"
                                             disabled="#{semmsi004Bean.disabledModeView}">
                                                <f:selectItems value="#{semmsi004tab1Bean.areaUnitTypeList}"/>
                                            </h:selectOneMenu>
                                             </td>
                                             </tr>
                                             </table>
                                        </td>
                                        </tr>
                                        </table>
                                    </h:panelGroup>
                                    </h:panelGrid>
                            </rich:panel>
            
                            <!-- panel right Address -->
                            <rich:spacer height="10"></rich:spacer>
                            <a4j:region id="rgnRightAddress">
                            <rich:panel id="pnlSiteInfo3">
                                    <f:facet name="header">
                                        <h:outputText value="#{jspMsg['header.panel.siteAddress']}"/>
                                    </f:facet>
                                    <h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
                                    <h:panelGroup>
                                        <table width="100%">
                                         <tr>
                                        <td align="left" colspan="4">
                                        <h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
                                        <a4j:commandButton id="btnCopyAddress" value="#{jspMsg['btn.copy']}" styleClass="rich-button" 
                                        style="width:120" onclick="copyAddress();">
                                        </a4j:commandButton>
                                        </h:panelGroup>
                                        <script type="text/javascript">
                                        function copyAddress(){
                                            var siteHouseNo = document.getElementById("incContent:frmAddSiteInfo:txtSiteHouseNo").value;
                                            var siteStreet = document.getElementById("incContent:frmAddSiteInfo:txtSiteStreet").value;
                                            var siteTambon = document.getElementById("incContent:frmAddSiteInfo:txtSiteTambon").value;
                                            var siteAmphurId = document.getElementById("incContent:frmAddSiteInfo:ddlSiteAmphur");
                                            var siteProvinceId = document.getElementById("incContent:frmAddSiteInfo:ddlSiteProvince");
                                            var sitePostcode = document.getElementById("incContent:frmAddSiteInfo:txtSitePostcode").value;
                                            var siteBuilding = document.getElementById("incContent:frmAddSiteInfo:txtSiteBuilding").value;
                                            var siteFloor = document.getElementById("incContent:frmAddSiteInfo:txtSiteFloor").value;
                                            var siteRoomNo = document.getElementById("incContent:frmAddSiteInfo:txtSiteRoomNo").value;
                                            var rightHouseNo = document.getElementById("incContent:frmAddSiteInfo:txtRightHouseNo");
                                            var rightStreet = document.getElementById("incContent:frmAddSiteInfo:txtRightStreet");
                                            var rightTambon = document.getElementById("incContent:frmAddSiteInfo:txtRightTambon");
                                            var rightAmphurId = document.getElementById("incContent:frmAddSiteInfo:txtRightAmphur");
                                            var rightProvinceId = document.getElementById("incContent:frmAddSiteInfo:txtRightProvince");
                                            var rightPostcode = document.getElementById("incContent:frmAddSiteInfo:txtRightPostcode");
                                            var rightBuilding = document.getElementById("incContent:frmAddSiteInfo:txtRightBuilding");
                                            var rightFloor = document.getElementById("incContent:frmAddSiteInfo:txtRightFloor");
                                            var rightRoomNo = document.getElementById("incContent:frmAddSiteInfo:txtRightRoomNo");
            
                                            rightHouseNo.value = siteHouseNo;
                                            rightStreet.value = siteStreet;
                                            rightTambon.value = siteTambon;
                                            rightPostcode.value = sitePostcode;
                                            rightBuilding.value = siteBuilding;
                                            rightFloor.value = siteFloor;
                                            rightRoomNo.value = siteRoomNo;
                                            if(siteAmphurId.value != null){
                                                rightAmphurId.value = siteAmphurId.options[siteAmphurId.selectedIndex].text;
                                            }
                                            if(siteProvinceId.value != null){
                                                rightProvinceId.value = siteProvinceId.options[siteProvinceId.selectedIndex].text;
                                            }
            
                                        }
                                        </script>
                                        </td>
                                        </tr>
                                                        
                                        <tr>
                                        <td align="right" width="20%" valign="top">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteHouseNo']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%" colspan="3">
                                         <h:inputTextarea id="txtRightHouseNo" value="#{semmsi004Bean.siteInfoData.rightHouseNo}" 
                                         rows="3" cols="100" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteBuilding']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                         <h:inputText id="txtRightBuilding" value="#{semmsi004Bean.siteInfoData.rightBuilding}"  
                                         size="30" maxlength="100" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteStreet']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtRightStreet" value="#{semmsi004Bean.siteInfoData.rightStreet}" 
                                        size="30" maxlength="100" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteFloor']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                         <h:inputText id="txtRightFloor" value="#{semmsi004Bean.siteInfoData.rightFloor}" disabled="#{semmsi004Bean.disabledModeView}" />
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteTambon']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtRightTambon" value="#{semmsi004Bean.siteInfoData.rightTambon}" 
                                        size="30" maxlength="50" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.siteRoomNo']}" styleClass="ms7"/>
                                        </td>
                                        <td width="40%">
                                         <h:inputText id="txtRightRoomNo" value="#{semmsi004Bean.siteInfoData.rightRoomNo}"  
                                         size="13" maxlength="10" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteAmphur']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtRightAmphur" value="#{semmsi004Bean.siteInfoData.rightAmphur}" size="30" 
                                        disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        </td>
                                        <td width="40%">
                                        </td>
                                        <td align="right" width="20%">
                                        <h:graphicImage value="images/icon_required.gif"/>
                                        <rich:spacer width="5"></rich:spacer>
                                        <h:outputText value="#{jspMsg['label.siteProvince']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                          <h:inputText id="txtRightProvince" value="#{semmsi004Bean.siteInfoData.rightProvince}" 
                                          size="30" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td align="right" width="20%">
                                        </td>
                                        <td width="40%">
                                        </td>
                                        <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.sitePostcode']}" styleClass="ms7"/>
                                        </td>
                                        <td width="20%">
                                        <h:inputText id="txtRightPostcode" value="#{semmsi004Bean.siteInfoData.rightPostCode}"  
                                        size="8" maxlength="5" disabled="#{semmsi004Bean.disabledModeView}"/>
                                        </td>
                                        </tr>
                                        </table>
                                    </h:panelGroup>
                                    </h:panelGrid>
                            </rich:panel>
                            </a4j:region>
                          
                            <!-- panel electric -->
                            <rich:spacer height="10"></rich:spacer>
                            <a4j:region id="rgnSiteInfoElectric">
                            <rich:panel id="pnlSiteInfo7">
                            <f:facet name="header">
                                <h:outputText value="#{jspMsg['header.panel.electric']}"/>
                            </f:facet>
                            <h:panelGrid  width="90%" border="0" cellpadding="0" cellspacing="1">
                                    <h:panelGroup>
                                        <table width="100%">
                                        <tr>
                                        <td width="20%" align="right" >
                                         <h:outputText value="#{jspMsg['label.electricType']}" styleClass="ms7"/>
                                        </td>
                                        <td width="80%" colspan="3">    
                                            <table width="100%">
                                             <tr>
                                             <td width="23%" align="left">  
                                                 <h:selectBooleanCheckbox id="chkElectricType1" value="#{semmsi004tab1Bean.chkElectricType1}" styleClass="ms7"
 			                                    onclick="RenderElectricType1JS();" disabled="#{semmsi004tab1Bean.disabledElectric||semmsi004tab1Bean.chkNoExpenses}"/>
			                                    <h:outputText value="#{jspMsg['label.electricType1']}" styleClass="ms7" />
			                                    <a4j:jsFunction name="RenderElectricType1JS" 
			                                    reRender="chkElectricType1,chkElectricType2,chkElectricType3,chkElectricType4,
			                                    pnlElectricOwnerTypeTab1,txtSiteContract,btnPopupSearchContractNo2" 
			                                    action="#{semmel011Action.renderElectricType1}"/>
                                            </td>
                                            <td width="87%" align="left">
                                                 <h:selectBooleanCheckbox id="chkMultiElectricTypeFlag" value="#{semmsi004tab1Bean.chkMultiElectricTypeFlag}"
                                     styleClass="ms7" disabled="#{semmsi004tab1Bean.disabledElectric||semmsi004tab1Bean.chkNoExpenses}" onclick="RenderMultiElectricJS();"/>
                                    <h:outputText value="#{jspMsg['label.multiElectricTypeFlag']}" styleClass="ms7" />   
                                    <a4j:jsFunction name="RenderMultiElectricJS" 
			                                    reRender="chkElectricType1,chkElectricType2,chkElectricType3,chkElectricType4,
			                                    pnlElectricOwnerTypeTab1,txtSiteContract,btnPopupSearchContractNo2" 
			                                    action="#{semmel011Action.renderElectricMutiType}"/>
                                            </td>
                                             </tr>
                                            </table>
                                        </td>
                                        </tr>
                                
                                        <tr>
                                        <td width="20%" align="right" >
                                        </td>
                                        <td width="80%" colspan="3">    
                                        <table width="100%">
                                            <tr>
                                            <td width="23%" align="left">
 	                                            <h:selectBooleanCheckbox id="chkElectricType2" value="#{semmsi004tab1Bean.chkElectricType2}" styleClass="ms7"
 			                                    onclick="RenderElectricType2JS();" disabled="#{semmsi004tab1Bean.disabledElectric||semmsi004tab1Bean.chkNoExpenses}"/>
			                                    <h:outputText value="#{jspMsg['label.electricType2']}" styleClass="ms7" />  
			                                    <a4j:jsFunction name="RenderElectricType2JS" 
			                                    reRender="chkElectricType1,chkElectricType2,chkElectricType3,chkElectricType4,
			                                    pnlElectricOwnerTypeTab1,txtSiteContract,btnPopupSearchContractNo2" 
			                                    action="#{semmel011Action.renderElectricType2}"/>
                                            </td>
                                            <td width="87%" align="left">
                                                 <h:selectBooleanCheckbox id="chkNoExpenses" value="#{semmsi004tab1Bean.chkNoExpenses}"
 			                                    styleClass="ms7" disabled="#{semmsi004tab1Bean.disabledElectric}" onclick="renderChkElectricType();"/>
			                                    <h:outputText value="#{jspMsg['label.noExpenses']}" styleClass="ms7" /> 
			                                    <a4j:jsFunction name="renderChkElectricType" 
			                                    reRender="chkElectricType1,chkElectricType2,chkElectricType3,chkElectricType4,
			                                    pnlElectricOwnerTypeTab1,txtSiteContract,btnPopupSearchContractNo2,chkMultiElectricTypeFlag" 
			                                    action="#{semmel011Action.renderChkElectricType}"/>
                                            </td>
                                            </tr>
                                        </table>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td width="20%" align="right">
                                        </td>
                                        <td width="80%">    
                                            <table width="100%">
                                            <tr>
                                            <td>
                                              <h:selectBooleanCheckbox id="chkElectricType3" value="#{semmsi004tab1Bean.chkElectricType3}" styleClass="ms7"
 				                                 onclick="RenderElectricType3JS();" disabled="#{semmsi004tab1Bean.disabledElectric||semmsi004tab1Bean.chkNoExpenses}"/>
				                                <h:outputText value="#{jspMsg['label.electricType3']}" styleClass="ms7" />  
				                                <a4j:jsFunction name="RenderElectricType3JS" 
				                                reRender="chkElectricType1,chkElectricType2,chkElectricType3,chkElectricType4,
				                                pnlElectricOwnerTypeTab1,txtSiteContract,btnPopupSearchContractNo2" 
				                                action="#{semmel011Action.renderElectricType3}"/>
                                            </td>
                                            </tr>
                                        </table>
                                        </td>
                                        </tr>
                                        
                                        <tr>
                                        <td width="20%" align="right" >
                                        </td>
                                        <td width="80%" colspan="3" >
                                            <table width="100%">
                                            <tr>
                                            <td width="23%" align="left">
                                              <h:selectBooleanCheckbox id="chkElectricType4" value="#{semmsi004tab1Bean.chkElectricType4}" styleClass="ms7"
 			                                 onclick="RenderElectricType4JS();" disabled="#{semmsi004tab1Bean.disabledElectric||semmsi004tab1Bean.chkNoExpenses}"/>
			                                <h:outputText value="#{jspMsg['label.electricType4']}" styleClass="ms7" />
			                                <a4j:jsFunction name="RenderElectricType4JS" 
			                                reRender="chkElectricType1,chkElectricType2,chkElectricType3,
			                                chkElectricType4,pnlElectricOwnerTypeTab1,txtSiteContract,btnPopupSearchContractNo2" 
			                                    action="#{semmel011Action.renderElectricType4}"/>     
                                            </td>
                                            <td width="25%" align="left">
                                            <h:outputText value="#{jspMsg['label.siteContract']}" styleClass="ms7"/>
                                            </td>
                                            <td width="45%" align="left">
                                            <h:panelGroup>
                                            <h:inputText id="txtSiteContract" value="#{popupSiteContractBean.siteContractNo}" 
                                            size="10" maxlength="20" disabled="#{semmsi004tab1Bean.disabledSiteContractNo}" 
                                            readonly="#{semmsi004Bean.disabledModeView}" onchange="GetSiteContractNoJS();"
                                            onblur="setFormatContractNo(this)">
                                            <a4j:jsFunction name="GetSiteContractNoJS" reRender="txtSiteContract" 
                                            action="#{popupSiteContractAction.getSiteInfoId}">
                                            <a4j:actionparam  name="fromButton" value="siteContractNo"></a4j:actionparam>
                                            </a4j:jsFunction>
                                            </h:inputText>
                                            <rich:spacer width="2"></rich:spacer>
                                            <a4j:commandButton id="btnPopupSearchContractNo2"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
                                            value="..."  reRender="popupSearchContractNo,popupFrmSearch"
                                            action="#{navAction.navi}" disabled="#{semmsi004tab1Bean.disabledSiteContractNo}">
                                            <a4j:actionparam name="navModule" value="si" />
                                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
                                            <a4j:actionparam name="moduleWithNavi" value="common" />
                                            <a4j:actionparam name="actionWithNavi" value="PopupSiteContract" />
                                            <a4j:actionparam name="methodWithNavi" value="initPopupSearchContractNo" />
                                            <a4j:actionparam name="fromButton" value="siteContractNo" />
                                            </a4j:commandButton>
                                            </h:panelGroup>
                                            </td>
                                            </tr>
                                            </table>
                                        </td>
                                        </tr>
                                        <tr>
                                            <td align="right" width="20%" valign="top">
                                                <h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
                                            </td>
                                            <td width="80%" colspan="3">
                                                <h:inputTextarea id="txtElecticRemark" value="#{semmsi004Bean.siteInfoData.elRemark}" 
                                                    cols="100" rows="3" disabled="#{semmsi004tab1Bean.disabledElectric}"/>
                                            </td>
                                        </tr>
                                        </table>
                                    </h:panelGroup>
                                    </h:panelGrid>
                                    <rich:spacer height="10"></rich:spacer>
                                <h:panelGrid id="pnlElectricOwnerTypeTab1" width="90%" border="0" cellpadding="0" cellspacing="1">
			                        <h:panelGroup rendered="#{semmsi004tab1Bean.renderedElectricOwnerType}">
			                            <table width="100%">
			                            <tr>
			                            <td colspan="3">
			                            <h:outputText value="#{jspMsg['label.header.electricOwnerType']}" styleClass="ms7" style="text-decoration: underline"/>
			                            </td>
			                            </tr>
			                            <tr>
			                            <td width="20%" align="right" valign="top">
			                                <h:outputText value="#{jspMsg['label.ownerElectricType']}" styleClass="ms7" />
			                            </td>
			                            <td width="30%" valign="top">
			                             <h:selectOneRadio id="rbtElectricOwnerType" value="#{semmsi004tab1Bean.siteElectric.electricOwnerType}"  
			                            styleClass="ms7" rendered="true" layout="pageDirection" disabled="#{semmsi004tab1Bean.disabledElectric}"
			                            onclick="RenderElectricOwnerType();">
			                                    <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.electricOwnerType01']}" />
			                                    <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.electricOwnerType02']}" />
			                                    
			                            </h:selectOneRadio>     
			                             <a4j:jsFunction name="RenderElectricOwnerType"  action="#{semmel011Action.renderElectricOwnerType}"  
			                            reRender="txtUnitPriceAmt,txtTakeAllAmt,chkNoUnitPriceFlag, pnlElectricOwnerTypeTab1, pnlVatTypeTab1"/> 
			                            </td>
			                            <td width="50%" valign="top">
			                            <table width="100%" >
			                            <tr>
			                            <td width="20%" align="right">
			                            <h:outputText value="#{jspMsg['label.unitPriceAmt']}" styleClass="ms7"/>
			                            </td>
			                            <td width="80%">
			                            <h:panelGroup>
			                            <h:inputText id="txtUnitPriceAmt" value="#{semmsi004Bean.siteInfoData.unitPriceAmt}" size="5" 
			                             onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                             onblur="return numberformat.moneyFormat(this);"
			                             onfocus="return numberformat.setCursorPosToEnd(this);"
			                             maxlength="16" 
			                             styleClass="inputRight"
			                             disabled="#{semmsi004tab1Bean.chkNoUnitPriceFlag == 'true' or semmsi004tab1Bean.disabledUnitPriceAmt}">
			                            <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                            </h:inputText>
			                            <rich:spacer width="5"></rich:spacer>
			                            <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                            </h:panelGroup>
			                            <rich:spacer width="5"></rich:spacer>
 			                            <h:selectBooleanCheckbox id="chkNoUnitPriceFlag" value="#{semmsi004tab1Bean.chkNoUnitPriceFlag}"
 			                             styleClass="ms7"  onclick="reRenderNoUnitPriceFlag();" disabled="#{semmsi004tab1Bean.disabledChkNoUnitPriceFlag}"/>
			                             <h:outputText value="#{jspMsg['label.noUnitPriceFlag']}" styleClass="ms7" />
			                            
			                             <a4j:jsFunction name="reRenderNoUnitPriceFlag" reRender="txtUnitPriceAmt" 
			                             action="#{semmel011Action.reRenderNoUnitPriceFlag}"/>
			                             
			                            </td>
			                            
			                            </tr>
			                            <tr>
			                            <td width="20%" align="right">
			                            <h:outputText value="#{jspMsg['label.takeAllAmt']}" styleClass="ms7"/>
			                            </td>
			                            <td  width="80%">
			                            <h:panelGroup>
			                            <h:inputText id="txtTakeAllAmt" value="#{semmsi004Bean.siteInfoData.takeAllAmt}" size="5" 
			                            onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                            onblur="return numberformat.moneyFormat(this);"
			                            onfocus="return numberformat.setCursorPosToEnd(this);"
			                            maxlength="16" 
			                            styleClass="inputRight"
			                            disabled="#{semmsi004tab1Bean.disabledTakeAllAmt}">
			                            <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                            </h:inputText>
			                            <rich:spacer width="5"></rich:spacer>
			                            <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
			                            <rich:spacer width="2"></rich:spacer>
			                            <h:outputText value="/" styleClass="ms7"/>
			                            <rich:spacer width="5"></rich:spacer>
			                             <h:selectOneMenu id="ddlTakeAllPeriodTypeTab1" value="#{semmsi004Bean.siteInfoData.takeAllPeriodType}"
			                                disabled="#{semmsi004tab1Bean.disabledTakeAllAmt}" onchange="defaultPayPeriodType();"> 
			                                <f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
			                            </h:selectOneMenu>
			                            </h:panelGroup>
			                            <script type="text/javascript">
			                                function defaultPayPeriodType(){
			                                    var periodType = document.getElementById("incContent:frmAddSiteInfo:ddlTakeAllPeriodTypeTab1").value;
			                                    var payPeriodType01 = document.getElementById("incContent:frmAddSiteInfo:rbtPayPeriodType01Tab1:0");
			                                    var payPeriodType02 = document.getElementById("incContent:frmAddSiteInfo:rbtPayPeriodType02Tab1:0");
			                                    var payPeriodType03 = document.getElementById("incContent:frmAddSiteInfo:rbtPayPeriodType03Tab1:0");
			                                    var payPeriodType04 = document.getElementById("incContent:frmAddSiteInfo:rbtPayPeriodType04Tab1:0");
			                                    var payPeriodType05 = document.getElementById("incContent:frmAddSiteInfo:rbtPayPeriodType05Tab1:0");
			                                    var year = document.getElementById("incContent:frmAddSiteInfo:txtPayPeriodTypeYearTab1");
			                                    var month = document.getElementById("incContent:frmAddSiteInfo:txtPayPeriodTypeMonthTab1");
			                                    if(periodType != '' && periodType == 'Y'){
			                                        payPeriodType02.checked = true;
			                                        payPeriodType01.checked = false;
			                                        payPeriodType05.checked = false;
			                                        
			                                    } else if (periodType != '' && periodType == 'O') {
			                                        payPeriodType01.checked = false;
			                                        payPeriodType02.checked = false;
			                                        payPeriodType05.checked = true;
			                                    } else {
			                                        payPeriodType01.checked = true;
			                                        payPeriodType02.checked = false;
			                                        payPeriodType05.checked = false;
			                                    }
			
			                                    payPeriodType03.checked = false;
			                                    payPeriodType04.checked = false;
			                                    year.value = '';
			                                    month.value = '';
			                                    year.disabled = true;
			                                    month.disabled =true;
			                                }
			                            </script>
			                            </td>
			                            </tr>
			                            </table>
			                            </td>
			                            </tr>
			                            <h:panelGroup id="pnlVatTypeTab1" rendered="#{semmsi004tab1Bean.renderedVatType}">
			                            <tr>
			                            <td width="20%" align="right">
			                            <h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7" />
			                            </td>
			                            <td colspan="2" width="80%">
			                            <h:selectOneRadio id="rbtVatTypeTab1" value="#{semmsi004Bean.siteInfoData.vatType}"  
			                            styleClass="ms7" rendered="true" disabled="#{semmsi004tab1Bean.disabledElectric}">
			                            <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
			                            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
			                            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
			                            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatTypenotFix']} " />
			                            </h:selectOneRadio>
			                            </td>
			                            </tr>
			                            <tr>
			                            <td width="20%" align="right">
			                            <h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"/>
			                            </td>
			                            <td colspan="2" width="80%">
			                            <h:panelGrid  columns="5">
			                            <h:panelGroup>
			                             <h:selectOneRadio id="rbtPayPeriodType01Tab1" value="#{semmsi004tab1Bean.payPeriodType01}"  styleClass="ms7" rendered="true"
			                            onclick="setPayPeriodType01Tab1();" disabled="#{semmsi004tab1Bean.disabledElectric}">
			                            <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
			                             <a4j:jsFunction name="setPayPeriodType01Tab1"  action="#{semmel011Action.renderPayPeriodType}"
			                             reRender="rbtPayPeriodType01Tab1,rbtPayPeriodType02Tab1,rbtPayPeriodType03Tab1,rbtPayPeriodType04Tab1,rbtPayPeriodType05Tab1,txtPayPeriodTypeMonthTab1,txtPayPeriodTypeYearTab1">
			                            <a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
			                            </a4j:jsFunction>
			                            </h:selectOneRadio>
			                            </h:panelGroup>
			                            <h:panelGroup>
			                                <h:selectOneRadio id="rbtPayPeriodType02Tab1" value="#{semmsi004tab1Bean.payPeriodType02}"  styleClass="ms7" rendered="true"
			                                onclick="setPayPeriodType02Tab1();" disabled="#{semmsi004tab1Bean.disabledElectric}">
			                                <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}"/>
			                                <a4j:jsFunction name="setPayPeriodType02Tab1"  action="#{semmel011Action.renderPayPeriodType}"
			                                 reRender="rbtPayPeriodType01Tab1,rbtPayPeriodType02Tab1,rbtPayPeriodType03Tab1,rbtPayPeriodType04Tab1,rbtPayPeriodType05Tab1,txtPayPeriodTypeMonthTab1,txtPayPeriodTypeYearTab1">
			                                <a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
			                                </a4j:jsFunction>
			                                </h:selectOneRadio>
			                            </h:panelGroup>
			                            <h:panelGroup>
			                            <table>
			                                <tr>
			                                <td>
			                                <h:selectOneRadio id="rbtPayPeriodType03Tab1" value="#{semmsi004tab1Bean.payPeriodType03}"  styleClass="ms7" rendered="true"
			                                onclick="setPayPeriodType03Tab1();" disabled="#{semmsi004tab1Bean.disabledElectric}">
			                                <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
			                                <a4j:jsFunction name="setPayPeriodType03Tab1"  action="#{semmel011Action.renderPayPeriodType}"
			                                 reRender="rbtPayPeriodType01Tab1,rbtPayPeriodType02Tab1,rbtPayPeriodType03Tab1,rbtPayPeriodType04Tab1,rbtPayPeriodType05Tab1,txtPayPeriodTypeMonthTab1,txtPayPeriodTypeYearTab1">
			                                <a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
			                                </a4j:jsFunction>
			                                </h:selectOneRadio>
			                                </td>
			                                <td>
			                                <h:inputText id="txtPayPeriodTypeMonthTab1" size="3"  disabled="#{semmsi004tab1Bean.disabledPayPeriod03}"
			                                value="#{semmsi004tab1Bean.payPeriod03}" styleClass="inputRight"
			                                onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
			                                <rich:spacer width="2"></rich:spacer>
			                                <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
			                                </td>
			                                </tr>
			                                </table>
			                            </h:panelGroup>
			                            <h:panelGroup>
			                            <table>
			                                <tr>
			                                <td>
			                                <h:selectOneRadio id="rbtPayPeriodType04Tab1" value="#{semmsi004tab1Bean.payPeriodType04}"  styleClass="ms7" rendered="true"
			                                onclick="setPayPeriodType04Tab1();" disabled="#{semmsi004tab1Bean.disabledElectric}">
			                                <f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
			                                <a4j:jsFunction name="setPayPeriodType04Tab1" action="#{semmel011Action.renderPayPeriodType}" 
			                                 reRender="rbtPayPeriodType01Tab1,rbtPayPeriodType02Tab1,rbtPayPeriodType03Tab1,rbtPayPeriodType04Tab1,rbtPayPeriodType05Tab1,txtPayPeriodTypeMonthTab1,txtPayPeriodTypeYearTab1">
			                                <a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
			                                </a4j:jsFunction>
			                                </h:selectOneRadio>
			                                </td>
			                                <td>
			                                <h:inputText id="txtPayPeriodTypeYearTab1" size="3" disabled="#{semmsi004tab1Bean.disabledPayPeriod04}"
			                                value="#{semmsi004tab1Bean.payPeriod04}" styleClass="inputRight"
			                                onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
			                                <rich:spacer width="2"></rich:spacer>
			                                <h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"></h:outputText>
			                                </td>
			                                </tr>
			                                </table>
			                            </h:panelGroup>
			                            <h:panelGroup>
			                                <h:selectOneRadio id="rbtPayPeriodType05Tab1" value="#{semmsi004tab1Bean.payPeriodType05}"  styleClass="ms7" rendered="true"
			                                onclick="setPayPeriodType05Tab1();" disabled="#{semmsi004tab1Bean.disabledElectric}">
			                                <f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
			                                <a4j:jsFunction name="setPayPeriodType05Tab1" action="#{semmel011Action.renderPayPeriodType}" 
			                                 reRender="rbtPayPeriodType01Tab1,rbtPayPeriodType02Tab1,rbtPayPeriodType03Tab1,rbtPayPeriodType04Tab1,rbtPayPeriodType05Tab1,txtPayPeriodTypeMonthTab1,txtPayPeriodTypeYearTab1">
			                                <a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
			                                </a4j:jsFunction>
			                                </h:selectOneRadio>
			                            </h:panelGroup>
			                            </h:panelGrid>
			                            </td>
			                            </tr>
			                            </h:panelGroup>
			                            </table>
			                            </h:panelGroup>
			                            </h:panelGrid>    
                            </rich:panel>
                            </a4j:region>
                            <rich:spacer height="10"></rich:spacer>
                                <h:panelGrid  width="100%" border="0" cellpadding="0" cellspacing="1">
                                <table id="tblSave" align="right">
                                <tr>
                                <td align="right">
                                <a4j:commandButton id="btnSaveTab1" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
                                action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError" 
                                oncomplete="onTopPage()"  
                                rendered="#{semmsi004Bean.renderBtnSave}">
                                <a4j:actionparam name="navModule" value="el" />
                                <a4j:actionparam name="navProgram" value="SEMMEL011-2" />
                                <a4j:actionparam name="moduleWithNavi" value="el" />
                                <a4j:actionparam name="actionWithNavi" value="SEMMEL011" />
                                <a4j:actionparam name="methodWithNavi" value="doSaveEditDummy" />
                                </a4j:commandButton>
                                </td>
                                </tr>
                                </table>
                                </h:panelGrid>
                            </h:panelGrid>
                    
                        </h:panelGrid>
            <!-- end panel tab -->
                        <h:panelGrid  id="pnlLog" width="90%"  border="0" cellpadding="0" cellspacing="1" >
                            <h:panelGroup rendered="#{semmsi004Bean.renderPanelLog}">
                            <table width="100%">
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtCreateBy" value="#{semmsi004Bean.siteInfoData.createBy}" 
                                    readonly="true" disabled="true" size="30" maxlength="50"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <rich:calendar id="cldCreateDate" locale="th" 
                                     datePattern="dd/MM/yyyy HH:mm:ss" 
                                     value="#{semmsi004Bean.siteInfoData.createDt}" 
                                     showWeeksBar="false"
                                     inputSize="20" 
                                     cellWidth="20px" cellHeight="20px" 
                                     buttonIcon="/images/hide-button.png"
                                     buttonIconDisabled="/images/hide-button.png"
                                     disabled="true"/>
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtUpdateBy" value="#{semmsi004Bean.siteInfoData.updateBy}" 
                                    readonly="true" disabled="true" size="30" maxlength="50"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                      <rich:calendar id="cldUpdateDate" locale="th" 
                                     datePattern="dd/MM/yyyy HH:mm:ss" 
                                     value="#{semmsi004Bean.siteInfoData.updateDt}" 
                                     showWeeksBar="false"
                                     inputSize="20" 
                                     cellWidth="20px" cellHeight="20px" 
                                     buttonIcon="/images/hide-button.png"
                                     buttonIconDisabled="/images/hide-button.png"
                                     disabled="true"/>
                                    </td>
                                 </tr>
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                    
            </a4j:form>
        </h:panelGrid>
        </rich:panel>
        <jsp:include page="../../pages/popup/sitelocation-popup.jsp" />
        <jsp:include page="../../pages/popup/sitecontract-popup.jsp" />
        <jsp:include page="../../pages/popup/closelySite-popup.jsp" />
        <jsp:include page="../../pages/si/semmsi004-4.jsp" />
        
</h:panelGrid>

<!-- Delete Location (tab1) -->
<rich:modalPanel id="mdpConfirmDelDialogLocation" autosized="true"> 
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDialogLocation">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
                        <h:outputText value="#{semmsi004tab1Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td>
                    </tr>
                    <tr>
                    <td>
                    <div align="center">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation" 
                        rendered="#{semmsi004tab1Bean.modeDelPopup == 'DEL'}">
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteLocation" />                          
                            <rich:componentControl for="mdpConfirmDelDialogLocation" operation="hide" event="onclick"  />
                        </a4j:commandButton>        
                        <rich:spacer width="5"></rich:spacer>   
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true"
                        rendered="#{semmsi004tab1Bean.modeDelPopup == 'DEL'}">
                            <rich:componentControl for="mdpConfirmDelDialogLocation" operation="hide" event="onclick" />
                        </a4j:commandButton>                                    
                        <a4j:commandButton value="OK" styleClass="rich-button" immediate="true" 
                            rendered="#{semmsi004tab1Bean.modeDelPopup == 'ALERT'}">
                            <rich:componentControl for="mdpConfirmDelDialogLocation" operation="hide" event="onclick" />
                        </a4j:commandButton>    
                        </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- Add Location (tab1) -->
<rich:modalPanel id="mdpConfirmAddDialogLocation" autosized="true"> 
    <f:facet name="header">
        <h:outputText value="Confirm Add"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmAddDialogLocation">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
                        <h:outputText value="#{semmsi004tab1Bean.confirmAddMsg}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,
                        pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                            <a4j:actionparam name="methodWithNavi" value="doAddLocation" /> 
                            <a4j:actionparam name="flag" value="Y" />                       
                            <rich:componentControl for="mdpConfirmAddDialogLocation" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,
                        pnlResultSearchLocation,dtbLocation,pnlSiteInfo2,frmSiteInfoError" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                            <a4j:actionparam name="methodWithNavi" value="doAddLocation" />
                            <a4j:actionparam name="flag" value="N" />                           
                            <rich:componentControl for="mdpConfirmAddDialogLocation" operation="hide" event="onclick"  />
                        </a4j:commandButton>    
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- Update Location (tab1) -->
<rich:modalPanel id="mdpConfirmUpdateDialogLocation" autosized="true">  
    <f:facet name="header">
        <h:outputText value="Confirm Update"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmUpdateDialogLocation">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
                        <h:outputText value="#{semmsi004tab1Bean.confirmAddMsg}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation,pnlSiteInfo2" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                            <a4j:actionparam name="methodWithNavi" value="doUpdateLocation" />  
                            <a4j:actionparam name="flag" value="Y" />                       
                            <rich:componentControl for="mdpConfirmUpdateDialogLocation" operation="hide" event="onclick"  />
                        </a4j:commandButton>
                        <a4j:commandButton value="No" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlSiteInfoContract, pnlLocation,pnlSearchLocationCriteria,pnlResultSearchLocation,dtbLocation,pnlSiteInfo2" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                            <a4j:actionparam name="methodWithNavi" value="doUpdateLocation" />
                            <a4j:actionparam name="flag" value="N" />                               
                            <rich:componentControl for="mdpConfirmUpdateDialogLocation" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                    
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- Delete Lessor (tab2) -->
<rich:modalPanel id="mdpConfirmDelLessorDialog" autosized="true">   
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelLessorDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlLessorName,dtbLessor, frmSiteInfoError, mdpConfirmDelLessorDialog" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB2" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteContractLessor" />                            
                            <rich:componentControl for="mdpConfirmDelLessorDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelLessorDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- delete RentCond (tab3)  -->
<rich:modalPanel id="mdpConfirmDelRentCondDialog" autosized="true"> 
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelRentCondDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlRentCond, dtbRentCond, mdpConfirmDelRentCondDialog,pnlSumRent,ddlRentDepositExpenseType" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB3" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteRentCond" />                          
                            <rich:componentControl for="mdpConfirmDelRentCondDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelRentCondDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>

<!-- delete deposit rent BG (tab3)  -->
<rich:modalPanel id="mdpConfirmDelDepositRentBgDialog" autosized="true">    
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDepositRentBgDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlRentDeposit,dtbDepositRentBG, mdpConfirmDelDepositRentBgDialog,pnlDeposit,pnlTotalDepositRent,chkNoRentDeposit" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB3" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteDepositNormal" />                         
                            <rich:componentControl for="mdpConfirmDelDepositRentBgDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDepositRentBgDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- delete deposit rent Cash (tab3)  -->
<rich:modalPanel id="mdpConfirmDelDepositRentCashDialog" autosized="true">  
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDepositRentCashDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="dtbDepositRentCash, frmSiteInfoError, mdpConfirmDelDepositRentCashDialog,pnlTotalDepositRent,chkNoRentDeposit" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB3" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteDepositNormal" />                         
                            <rich:componentControl for="mdpConfirmDelDepositRentCashDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDepositRentCashDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- delete deposit electric BG (tab5)  -->
<rich:modalPanel id="mdpConfirmDelDepositElectricBgDialog" autosized="true">    
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDepositElectricBgDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlDepositElectric, dtbDepositElectricBG,pnlAddDepositElectric, 
                        mdpConfirmDelDepositElectricBgDialog,pnlResultDepositElectricNormal,pnlSumDepositElectric" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB5" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteDepositElectricNormal" />                         
                            <rich:componentControl for="mdpConfirmDelDepositElectricBgDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDepositElectricBgDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- delete deposit electric Cash (tab5)  -->
<rich:modalPanel id="mdpConfirmDelDepositElectricCashDialog" autosized="true">  
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDepositElectricCashDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="dtbDepositElectricCash, frmSiteInfoError, mdpConfirmDelDepositElectricCashDialog,pnlResultDepositElectricNormal" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB5" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteDepositElectricNormal" />                         
                            <rich:componentControl for="mdpConfirmDelDepositElectricCashDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDepositElectricCashDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<!-- delete subRent (tab7)  -->
<rich:modalPanel id="mdpConfirmDelDialogSubRent" autosized="true">  
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDepositSubRentDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="180px">
                        <h:outputText value="#{semmsi004Bean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="dtbSubRent, pnlSubRentCriteria, mdpConfirmDelDialogSubRent" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB7" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab7" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteSubRent" />                           
                            <rich:componentControl for="mdpConfirmDelDialogSubRent" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDialogSubRent" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>

<!-- copy old siteInfo (tab1)  -->
<rich:modalPanel id="mdpConfirmCopyOldSiteInfo" autosized="true">   
    <f:facet name="header">
        <h:outputText value="Confirm Copy SiteInfo"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmCopyOldSiteInfoDialog">
        <table width="270px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="270px">
                        <h:outputText value="#{semmsi004tab1Bean.confirmCopyOldSiteInfo}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="pnlSiteInfo,frmAddSiteInfo" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004TAB1" /> 
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab1" />
                            <a4j:actionparam name="methodWithNavi" value="doCopyOldSiteInfo" />                         
                            <rich:componentControl for="mdpConfirmCopyOldSiteInfo" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmCopyOldSiteInfo" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>

<!-- change tab  -->
<rich:modalPanel id="mdpConfirmChangeTab" autosized="true"> 
    <f:facet name="header">
        <h:outputText value="Confirm Change Tab"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmChangeTab">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <h:panelGrid columns="1" styleClass="contentlabelform" width="250px">
                        <h:outputText value="#{semmsi004tab1Bean.confirmChangeTab}" styleClass="ms7" />
                    </h:panelGrid></td></tr><tr><td>
                    <div align="center">
                    <h:panelGrid columns="3" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="frmAddSiteInfo,pnlTab, frmSiteInfoError" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />   
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                            <a4j:actionparam name="methodWithNavi" value="setTabNo" />  
                            <a4j:actionparam name="clickButton" value="Yes" />
                            <a4j:actionparam name="tabNo" value="#{semmsi004Bean.tabNo}" />                         
                            <rich:componentControl for="mdpConfirmChangeTab" operation="hide" event="onclick"  />
                        </a4j:commandButton>
                        <a4j:commandButton value="No" styleClass="rich-button" action="#{navAction.navi}" 
                        immediate="true" reRender="frmAddSiteInfo,pnlTab, frmSiteInfoError" >
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />   
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                            <a4j:actionparam name="methodWithNavi" value="setTabNo" />  
                            <a4j:actionparam name="clickButton" value="No" />       
                            <a4j:actionparam name="tabNo" value="#{semmsi004Bean.tabNo}" />                 
                            <rich:componentControl for="mdpConfirmChangeTab" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
                        action="#{navAction.navi}" reRender="frmAddSiteInfo,pnlTab, frmSiteInfoError">
                            <a4j:actionparam name="navModule" value="si" />
                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />   
                            <a4j:actionparam name="moduleWithNavi" value="si" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
                            <a4j:actionparam name="methodWithNavi" value="setTabNo" />  
                            <a4j:actionparam name="clickButton" value="Cancel" />   
                            <a4j:actionparam name="tabNo" value="#{semmsi004Bean.tabNo}" /> 
                            <rich:componentControl for="mdpConfirmChangeTab" operation="hide" event="onclick" />
                        </a4j:commandButton>
                        </h:panelGrid>
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>
<a4j:include id="popUpTransfer"  viewId="../../pages/el/semmel011PopupTransfer.jsp" />