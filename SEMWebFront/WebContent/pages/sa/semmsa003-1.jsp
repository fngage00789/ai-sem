<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.sa.semmsa003" var="jspMsg003"/>
<h:panelGrid width="100%">
    <script>
        function myFunction() {
           
            var element = document.getElementById("incContent:frmSearchCriteria");
            element.parentNode.removeChild(element);
        
         // alert('test');
        }
    </script>
    <rich:panel>
        <f:facet name="header"><h:outputText value="#{jspMsg003['header.name']}"/></f:facet>   
            <h:panelGrid>
            <a4j:form id="frmError">
                
            </a4j:form>
        </h:panelGrid>  
        <h:panelGrid columnClasses="gridContent" width="100%">
                <!-- begin content layout criteria -->
                <h:panelGrid width="96%">
                <a4j:form id="frmSearchCriteria">
                    <rich:panel id="pnlSearchCriteria">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg003['header.criteria.name']}"/>
                        </f:facet>
                        <!-- begin content criteria -->
                        <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                            <table width="100%">
                            <tr>
                                    <td align="right" width="20%" valign="baseline">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.company']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%" valign="bottom">
                                        <h:selectOneMenu id="ddlCompany" value="#{semmsa003Bean.siteAcqSP.p_company}" onchange="GetCompanyJS();">
                                        <f:selectItems value="#{semmsa003Bean.companyList}"/>
                                        </h:selectOneMenu>
                                        <a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay,btnGenDummy"/>
                                        <rich:spacer width="10"></rich:spacer>
                                        <h:outputText id="companyDisplay" value="#{semmsa003Bean.siteAcqSP.p_company}" styleClass="ms28"/>
                                    </td>
                                    <td align="right" width="20%" valign="bottom">
                                    <h:graphicImage value="images/icon_required.gif"/>
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.region']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%" valign="bottom">
                                    <h:selectOneMenu id="ddlRegion" value="#{semmsa003Bean.siteAcqSP.p_region}"> 
                                        <f:selectItems value="#{semmsa003Bean.regionList}"/>
                                    </h:selectOneMenu>
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.docNo']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtDocNo" value="#{semmsa003Bean.siteAcqSP.docNo}" size="23" maxlength="20"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:panelGroup>
                                        <h:outputText value="#{jspMsg003['label.reqType']}" styleClass="ms7"/>
                                    </h:panelGroup>
                                    </td>
                                    <td width="30%">
                                    <h:selectOneMenu id="ddlReqType" value="#{semmsa003Bean.siteAcqSP.p_req_type}"> 
                                        <f:selectItems value="#{semmsa003Bean.reqTypeList}"/>
                                    </h:selectOneMenu>
                                    
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    	<h:outputText value="#{jspMsg003['label.title']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    	<h:inputText id="txtTitle" value="#{semmsa003Bean.siteAcqSP.p_title}" size="30" maxlength="35"/>
                                    </td>
                                    <td align="right" width="20%">
	                                    <h:panelGroup>
	                                        <h:outputText value="#{jspMsg003['label.docStatus']}" styleClass="ms7"/>
	                                    </h:panelGroup>
                                    </td>
                                    <td width="30%">
	                                    <h:selectOneMenu id="ddlDocStatus" value="#{semmsa003Bean.siteAcqSP.p_docStatus}"> 
	                                        <f:selectItems value="#{semmsa003Bean.docStatusList}"/>
	                                    </h:selectOneMenu>
                                    </td>
                                 </tr>
                                  <tr>
                                    <td align="right" width="20%">
	                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
	                                    <rich:spacer width="5"></rich:spacer>
	                                    <h:outputText value="#{jspMsg003['label.locationId']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    	<h:inputText id="txtLocationId" value="#{semmsa003Bean.siteAcqSP.p_location_id}" size="18" maxlength="15"/>
                                    </td>
                                    <td align="right" width="20%">
	                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
	                                    <rich:spacer width="5"></rich:spacer>
	                                    <h:outputText value="#{jspMsg003['label.locationCode']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    	<h:inputText id="txtLocationCode" value="#{semmsa003Bean.siteAcqSP.p_location_code}" size="13" maxlength="10"/>
                                    </td>
                                 </tr>
                                 
                                  <tr>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.locationName']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtLocationName" value="#{semmsa003Bean.siteAcqSP.p_location_name}" size="30" maxlength="255"/>
                                    </td>
                                    <td align="right" width="20%">
                                    
                                    <h:outputText value="#{jspMsg003['label.siteType']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:selectOneMenu id="ddlSiteType" value="#{semmsa003Bean.siteAcqSP.p_location_type}"> 
                                        <f:selectItems value="#{semmsa003Bean.siteTypeList}"/>
                                    </h:selectOneMenu>
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg003['label.locationZone']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                        <h:inputText id="txtLocationZone" value="#{semmsa003Bean.siteAcqSP.p_location_zone}" size="30" maxlength="255"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
	                                <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.siteCode']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                        <h:inputText id="txtSiteCode" value="#{semmsa003Bean.siteAcqSP.p_site_code}" size="30" maxlength="255"/>
                                    </td>
                                 </tr>
                                 
                                 <tr>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.contractNo']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                        <h:inputText id="txtContractNo" value="#{semmsa003Bean.siteAcqSP.p_contract_no}" size="18" maxlength="15"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.lessorName2']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                    <h:inputText id="txtLessorName" value="#{semmsa003Bean.siteAcqSP.p_lessor_name}" size="13" maxlength="10"/>
                                    </td>
                                 </tr>
                                  
                               <tr>
                                <td align="right" width="20%">
                                <h:outputText value="#{jspMsg003['label.effDate']} :" styleClass="ms7"/>
                                </td>
                                <td width="30%">
                                    <table width="25%">
                                    <tr>
                                    <td>
                                     <rich:calendar id="cldEffDateFrom" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa003Bean.siteAcqSP.p_effective_dt_from}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateFrom','cldEffDateTo');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateFrom','cldEffDateTo');"
                                       label="#{jspMsg003['column.header.effDate']}"
                                       >
                                    </rich:calendar> 
                                    </td>
                                    <td><h:outputText value="#{jspMsg003['label.to']}" styleClass="ms7"/></td>
                                    <td>
                                     <rich:calendar id="cldEffDateTo" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa003Bean.siteAcqSP.p_effective_dt_to}"
                                       showWeeksBar="false"
                                       inputSize="13"
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateTo','cldEffDateFrom');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldEffDateTo','cldEffDateFrom');"
                                       label="#{jspMsg003['column.header.effDate']}">
                                </rich:calendar>
                                    </td>
                                    </tr>
                                    </table>
                                </td>
                                <td align="right" width="20%">
                                <h:outputText value="#{jspMsg003['label.expDate']} :" styleClass="ms7"/>
                                </td>
                                <td width="30%">
                                    <table width="25%">
                                    <tr>
                                    <td>
                                      <rich:calendar id="cldExpDateFrom" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa003Bean.siteAcqSP.p_expire_dt_from}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateFrom','cldExpDateTo');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateFrom','cldExpDateTo');"
                                       label="#{jspMsg003['column.header.expDate']}">
                                    </rich:calendar> 
                                    </td>
                                    <td><h:outputText value="#{jspMsg003['label.to']}" styleClass="ms7"/></td>
                                    <td>
                                      <rich:calendar id="cldExpDateTo" locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa003Bean.siteAcqSP.p_expire_dt_to}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px"
                                       oninputblur="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateTo','cldExpDateFrom');"
                                       oncollapse="validateRichCalendarFromTo('frmSearchCriteria','cldExpDateTo','cldExpDateFrom');"
                                       label="#{jspMsg003['column.header.expDate']}"
                                       >
                                       
                                    </rich:calendar> 
                                    </td>
                                    </tr>
                                    </table>
                                </td>
                             </tr>
                             
                             <tr>
                                    <td align="right" width="20%">
                                    <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
	                                <rich:spacer width="5"></rich:spacer>
                                    <h:outputText value="#{jspMsg003['label.batchNo2']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                        <h:inputText id="txtBatchNo" value="#{semmsa003Bean.siteAcqSP.p_batch_no}" size="30" maxlength="255"/>
                                    </td>
                                    <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg003['label.user']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                        <h:inputText id="txtUser" value="#{semmsa003Bean.siteAcqSP.p_user}" size="30" maxlength="255"/>
                                    </td>
                              </tr>
                             
                            <tr>
                               <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg003['label.location']}" styleClass="ms7"/>
                                </td>
                                <td width="30%">
                                    <h:inputText id="txtAddress" value="#{semmsa003Bean.siteAcqSP.p_address}" size="30" maxlength="100"/>
                                </td>
                                <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg003['label.siteProvince']}" styleClass="ms7"/>
                                </td>
                                <td width="30%">
                                    <h:selectOneMenu id="ddlProvince" value="#{semmsa003Bean.siteAcqSP.p_province_id}" onchange="GetSiteAmphurListJS()"> 
                                        <f:selectItems value="#{semmsa003Bean.provinceList}"/>
                                    </h:selectOneMenu>
                      
                                </td>
                            </tr>
                            
                            <tr>
                                <td align="right" width="20%">
                                    <h:outputText value="#{jspMsg003['label.phone']}" styleClass="ms7"/>
                                </td>
                                <td width="80%" colspan="3">
                                    <h:inputText id="txtPhone" value="#{semmsa003Bean.siteAcqSP.p_phone}" size="30" maxlength="100"/>
                                </td>
                            </tr>
                           </table>
                          </h:panelGroup>
                        </h:panelGrid>
                        <!-- end content criteria -->
                        <h:panelGrid columns="2" id="grdSearchCommand">
                            <a4j:commandButton id="btnSearch" value="#{jspMsg003['btn.search']}" styleClass="rich-button"
                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,frmSearchResult,dtbSiteInfo,btnApprove, clearBatchNo, btnExport, btnNew, btnReassign" >
                            <a4j:actionparam name="navModule" value="sa" />
                            <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                            <a4j:actionparam name="methodWithNavi" value="doSearch" />
                            </a4j:commandButton>
                            <a4j:commandButton id="btnClear" value="#{jspMsg003['btn.clear']}" styleClass="rich-button" 
                            action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbSiteInfo,btnRun,btnApprove, clearBatchNo, btnExport, btnNew, btnReassign">
                            <a4j:actionparam name="navModule" value="sa" />
                            <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                            <a4j:actionparam name="methodWithNavi" value="doClear" />
                            </a4j:commandButton>
                        </h:panelGrid>
                    </rich:panel>
                    <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa003Bean.renderedMsgFormSearch}">
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
                    <h:panelGrid>
                        <h:panelGroup>
                            <table width="100%">
                                <tr>
                                    <td>
                                        <a4j:commandButton style="" styleClass="rich-button" id="btnNew" value="#{jspMsg003['btn.new']}"
                                           action="#{semmsa003Action.initPopupNew}" disabled="#{semmsa003Bean.disabledBtnPopupNew}"
                                           reRender="frmError,btnRun, pnlSearchResult, dtbSiteInfo, popupRequestType, pnlRentalPayNormal"
                                           oncomplete="if(#{semmsa003Bean.displayShowPopup == 'true'})#{rich:component('popupRequestType')}.show();">
                                        </a4j:commandButton>
                                        
                                        
                                        <rich:spacer width="5"/>
                                       
                                        <a4j:commandButton id="btnExport" action="#{navAction.navi}"
					                        styleClass="rich-button" value="#{jspMsg003['btn.export']}" 
					                        disabled="#{semmsa003Bean.disabledBtnExport}" style="width: 120px"
					                        reRender="frmSearchResult,frmSearchCriteria,pnlSearchResult,frmError,show_report">
					                        <a4j:actionparam name="navModule" value="sa" />
                                            <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                                            <a4j:actionparam name="methodWithNavi" value="doGenBatch" />
					                        <f:param name="clearBatch" value="N"/>
					                    </a4j:commandButton>
					                    
                                        <rich:spacer width="5"/>
                                        
                                        <a4j:commandButton id="clearBatchNo" action="#{navAction.navi}" 
					                        styleClass="rich-button" value="#{jspMsg003['btn.clearBatchNo']}"
					                        disabled="#{semmsa003Bean.disabledBtnClearBatch}"
					                        reRender="frmSearchCriteria,frmError,pnlSearchResult,btnExport,frmSearchResult">
					                        <a4j:actionparam name="navModule" value="sa" />
					                        <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
					                        <a4j:actionparam name="moduleWithNavi" value="sa" />
					                        <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
					                        <a4j:actionparam name="methodWithNavi" value="doGenBatch" />
					                        <f:param name="clearBatch" value="Y"/>
					                    </a4j:commandButton>
					                    
					                    <rich:spacer width="5"/>
					                    
					                    <a4j:commandButton id="btnApprove" action="#{navAction.navi}" 
                                            styleClass="rich-button" value="#{jspMsg003['btn.approve']}"
                                            disabled="#{semmsa003Bean.disabledBtnSendToApprove}"
                                            reRender="frmSearchCriteria,frmError,pnlSearchResult,btnExport,frmSearchResult">
                                            <a4j:actionparam name="navModule" value="sa" />
                                            <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                                            <a4j:actionparam name="methodWithNavi" value="doApproveToLeader" />
                                        </a4j:commandButton>
                                        
                                        <rich:spacer width="5"></rich:spacer>
                                        
                                        <a4j:commandButton style="" styleClass="rich-button" id="btnReassign" value="#{jspMsg003['btn.reassign']}"
                                           action="#{semmsa003Action.initPopupReAssign}" disabled="#{semmsa003Bean.disabledBtnReassign}"
                                           reRender="frmError,btnRun, pnlSearchResult, dtbSiteInfo, popupRequestType, pnlRentalPayNormal, popupReassign"
                                           rendered="#{semmsa003Action.rendererSSO['scrSMMSA002']}"
                                           oncomplete="#{rich:component('popupReassign')}.show();">
                                        </a4j:commandButton>
                                        <rich:spacer width="5"/>
                                        <a4j:commandButton style="" styleClass="rich-button" id="btnGenLTO" value="GenLTO"
                                           action="#{semmsa003Action.testGenfileLTO}" disabled="false"
                                           rendered="false">
                                        </a4j:commandButton>
                                    </td>
                                    <td align="right">
                                       
                                    </td>
                                </tr>
                            </table>
                        </h:panelGroup>
                    </h:panelGrid>
                    </a4j:form>
                </h:panelGrid>
            
                <!-- end content layout criteria -->
                
                <a4j:form id="frmSearchResult"> 
                <h:panelGrid id="pnlShowReportDoc" style="height:0px;width:0px;" width="0px" columns="0" >
                    <h:panelGroup id="pnlInShowReport" rendered="#{semmsa003Bean.showReport}" style="height:0px;width:0px;" >
                        <h:commandButton value="Report" id="btnShowReport" style="height:0px;width:0px;display:none;" action="#{semmsa003Action.doDownloadContractFile}">
                        <script>document.getElementById('incContent:frmSearchResult:btnShowReport').click();</script>
                        </h:commandButton>                              
                    </h:panelGroup>                         
                </h:panelGrid>
                
                <!-- ShowReport Panel -->
                <h:panelGrid id="show_report" style="height:0px;width:0px;" width="0" columns="0">
                    <h:panelGroup id="show_report_in" rendered="#{semmsa003Bean.displayBtn}" style="height:0px;width:0px;" >
                        <h:commandButton value="Report" id="btnExportExcel" style="height:0px;width:0px;display:none;" action="#{semmsa003Action.doExportExcel}">
                         <script>document.getElementById('incContent:frmSearchResult:btnExportExcel').click();</script>
                        </h:commandButton>
                    </h:panelGroup>                         
                </h:panelGrid>
                <!-- End Code -->
                
                <h:panelGrid id="pnlRedirect" style="height:0px;width:0px;" width="0px" columns="0" >
                            <h:panelGroup id="pnlInRedirect" rendered="#{semmsa003Bean.redirectFlag}" style="height:0px;width:0px;" >
                                 <a4j:commandButton id="btnPopupRedirect" style="height:0px;width:0px;display:none;" onclick="myFunction();" 
                                 reRender="oppContent"  action="#{navAction.navi}" >
                                        <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
		                                                    
		                                <a4j:actionparam name="rowId" value="#{semmsa003Bean.siteAppSP.siteAppId}" />
		                                <a4j:actionparam name="paramMode" value="E" />
		                                       
		                                <a4j:actionparam name="mode" value="VIEW" />
		                                <a4j:actionparam name="paramMenuGroup" value="#{semmsa003Bean.popupMenuGroup}" /> 
		                                <a4j:actionparam name="paramMenuType" value="#{semmsa003Bean.popupMenuGroup}" />      
		                                <a4j:actionparam name="paramBackToMe" value="Y" />
		                                <a4j:actionparam name="paramNavModuleFrom" value="sa" />
		                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSA003-1" />
		                                <a4j:actionparam name="paramModuleWithNaviFrom" value="sa" />
		                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSA003" />
		                                <a4j:actionparam name="paramMethodWithNaviFrom" value="doSearch" />
                                        <script>document.getElementById('incContent:frmSearchResult:btnPopupRedirect').click();</script>
                                    </a4j:commandButton>                      
                            </h:panelGroup>                         
                        </h:panelGrid>
                
                
                <!-- begin content layout data grid -->
                <h:panelGrid  width="90%">
                    <rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar" >
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg003['header.resultTable.name']}" style="width: 3200"/>
                        </f:facet>
                        <div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmsa003Bean.msgDataNotFound}" rendered="#{semmsa003Bean.renderedMsgDataNotFound}" />
                        </div>
                          <rich:dataTable width="100%" id="dtbSiteInfo" cellpadding="1" cellspacing="0" border="0"
                            var="siteAcqSP" value="#{semmsa003Bean.siteAcqSPList}" reRender="dtbSiteInfo" 
                            rows="#{semmsa003Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            <rich:column styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}" 
                                rendered="true">
                                <f:facet name="header">
                                <h:selectBooleanCheckbox value="#{semmsa003Bean.chkSelAll}">
                                        <a4j:support event="onclick" action="#{semmsa003Action.selectAllRow}" 
                                            reRender="btnApprove, clearBatchNo, btnExport, btnNew, dtbSiteInfo, popupRequestType, btnReassign"/>
                                </h:selectBooleanCheckbox>
                                </f:facet>
                                <div align="center">
                                    <h:selectBooleanCheckbox id="siteAcqSelected" value="#{siteAcqSP.checkBox}" 
                                        rendered="true">
                                        <a4j:support event="onclick" action="#{semmsa003Action.onRenderButton}" 
                                        reRender="btnApprove, clearBatchNo, btnExport, btnNew, dtbSiteInfo, popupRequestType, btnReassign">
                                        <a4j:actionparam name="rowId" value="#{siteAcqSP.dataObj.rowId}" />
                                    </a4j:support>
                                    </h:selectBooleanCheckbox>
                                </div>
                            </rich:column>
                            
                        <rich:column styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                        title="#{siteAcqSP.dataObj.p_contract_no}">
                            <f:facet name="header">
                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
                            </f:facet>
                            <div align="center">
                            <a4j:commandButton id="btnEdit"  action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
                            onclick="myFunction();" reRender="oppContent,txtNavProgram" rendered="#{siteAcqSP.dataObj.can_edit == 'Y'}">
                                <a4j:actionparam name="navModule" value="sa" />
                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
                                                    
                                <a4j:actionparam name="moduleWithNavi" value="sa" />
                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
                                                    
                                <a4j:actionparam name="rowId" value="#{siteAcqSP.dataObj.rowId}" />
                                <a4j:actionparam name="paramMenuGroup" value="#{siteAcqSP.dataObj.menuGroupDisplay}" />
                                <a4j:actionparam name="paramMenuType" value="#{siteAcqSP.dataObj.menuGroupDisplay}" /> 
                                <a4j:actionparam name="paramMode" value="E" />
                                       
                                <a4j:actionparam name="mode" value="VIEW" />
                                       
                                <a4j:actionparam name="paramBackToMe" value="Y" />
                                <a4j:actionparam name="paramNavModuleFrom" value="sa" />
                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSA003-1" />
                                <a4j:actionparam name="paramModuleWithNaviFrom" value="sa" />
                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSA003" />
                                <a4j:actionparam name="paramMethodWithNaviFrom" value="doSearch" />
                            </a4j:commandButton>
                            </div>
                        </rich:column>
                        
                        <rich:column styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                        title="#{siteAcqSP.dataObj.p_contract_no}">
                            <f:facet name="header">
                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
                            </f:facet>
                            <div align="center">
                            <a4j:commandButton id="btnDelete"  action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15" 
                            reRender="btnApprove, clearBatchNo, btnExport, btnNew, pnlSearchResult" rendered="#{siteAcqSP.dataObj.can_delete == 'Y'}">
                            <a4j:actionparam name="navModule" value="sa" />
                            <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                                        
                            <a4j:actionparam name="moduleWithNavi" value="sa" />
                            <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                            <a4j:actionparam name="methodWithNavi" value="doDeleteSiteAcq" />
                                        
                            <a4j:actionparam name="rowId" value="#{siteAcqSP.dataObj.rowId}" />
                            <a4j:actionparam name="paramFwdUrl" value="SEMMSA003-1" />
                            <a4j:actionparam name="paramMode" value="E" />
                           	<a4j:actionparam name="paramMenuType" value="#{siteAcqSP.dataObj.menuGroupDisplay}" /> 
                            <a4j:actionparam name="mode" value="VIEW" />
                            </a4j:commandButton>
                            </div>
                        </rich:column>
                        
                        <rich:column styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                            <f:facet name="header">
                                <h:outputText value="Print" styleClass="contentform" style="width: 30"/>
                            </f:facet>
                            <div align="center">
                            <a4j:commandButton id="btnPrint"
                                action="#{navAction.navi}"
                                reRender="oppContent"
                                rendered="#{siteAcqSP.dataObj.can_print == 'Y'}"
                                value="#{jspMsg003['btn.Print']}" styleClass="rich-button" style="width:50" >
                                <a4j:actionparam name="navModule" value="sa" />
                                <a4j:actionparam name="navProgram" value="SEMMSA003-1" />
                                <a4j:actionparam name="moduleWithNavi" value="sa" />
                                <a4j:actionparam name="actionWithNavi" value="SEMMSA003" />
                                <a4j:actionparam name="methodWithNavi" value="doRunReport" />
                                 <a4j:actionparam name="rowId" value="#{siteAcqSP.dataObj.rowId}" />
                                 
                                 <a4j:support event="oncomplete" reRender="frmError,frmResult,pnlShowReportDoc" />
                            </a4j:commandButton>
                            </div>
                        </rich:column>
                        
                        <rich:column  sortBy="#{siteAcqSP.dataObj.p_region}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                            <a4j:support event="onclick" reRender="dtbSiteInfo">
                                    <a4j:actionparam name="rowId" value="#{siteAcqSP.dataObj.rowId}" />
                                </a4j:support>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.region']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_region}" styleClass="contentform" />
                                </div>
                            </rich:column>
                            
                             <rich:column  sortBy="#{siteAcqSP.dataObj.p_company}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                            
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.company']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_company}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                        
                        <rich:column  sortBy="#{siteAcqSP.dataObj.docNo}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.docNo']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                   <a4j:commandLink id="cmlView2"  action="#{navAction.navi}" value="#{siteAcqSP.dataObj.docNo}" 
                                    onclick="myFunction();" reRender="oppContent">
                                        <a4j:actionparam name="navModule" value="sa" />
                                        <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
                                                    
                                        <a4j:actionparam name="moduleWithNavi" value="sa" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMSA002" /> 
                                        <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
                                                    
                                        <a4j:actionparam name="rowId" value="#{siteAcqSP.dataObj.rowId}" />
                                        <a4j:actionparam name="paramMode" value="V" />
                                       
                                        <a4j:actionparam name="mode" value="VIEW" />
                                        <a4j:actionparam name="paramMenuType" value="#{siteAcqSP.dataObj.menuGroupDisplay}" />       
		                                <a4j:actionparam name="paramBackToMe" value="Y" />
		                                <a4j:actionparam name="paramNavModuleFrom" value="sa" />
		                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSA003-1" />
		                                <a4j:actionparam name="paramModuleWithNaviFrom" value="sa" />
		                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSA003" />
		                                <a4j:actionparam name="paramMethodWithNaviFrom" value="doSearch" />
                                     </a4j:commandLink>
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{siteAcqSP.dataObj.p_req_type}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.reqDocType']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_req_type}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{siteAcqSP.dataObj.reqOfficer}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.reqOfficer']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.reqOfficer}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{siteAcqSP.dataObj.p_contract_no}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_contract_no}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                             <rich:column  sortBy="#{siteAcqSP.dataObj.p_location_id}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.locationId']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_location_id}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{siteAcqSP.dataObj.p_location_name}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.locationName']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_location_name}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{siteAcqSP.dataObj.siteDetail}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.siteDetail']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.siteDetail}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{siteAcqSP.dataObj.p_location_zone}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                           
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.locationZone']}" styleClass="contentform" style="width: 40"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_location_zone}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.effDateStr}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.effDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.effDateStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>  
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.expDateStr}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.expDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.expDateStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>  
                            
                             <rich:column sortBy="#{siteAcqSP.dataObj.networkStatus}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.networkStatus']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.networkStatus}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column> 
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.flowStatus}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.flowStatus']}" styleClass="contentform" style="width: 230"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.flowStatus}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column> 
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.statusDTStr}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.statusDT']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.statusDTStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column> 
                            
                             <rich:column sortBy="#{siteAcqSP.dataObj.p_batch_no}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.batchNo']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_batch_no}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column> 
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.approveDTStr}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.approveDT']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.approveDTStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.approveBy}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.approveBy']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.approveBy}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.costPerYear}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.costPerYear']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText value="#{siteAcqSP.dataObj.costPerYear}" style="white-space:nowrap" >
                                    	<f:convertNumber pattern="#,##0.00" maxIntegerDigits="20" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.modifiedDetail}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}" rendered="false">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.modifiedDetail']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.modifiedDetail}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.nearSiteCost}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.nearSiteCost']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <a4j:commandLink id="msa003_popNearest" action="#{semmsa003Action.doShowPopupNearestSite}" value="#{siteAcqSP.dataObj.nearSiteCost}" 
                                    reRender="oppContent,msa001PopUpCommon_NearestSite,popupDisplay"
                                    oncomplete="#{rich:component('msa001PopUpCommon_NearestSite')}.show(); return false;">
                                        <f:param name="rowId" value="#{siteAcqSP.dataObj.rowId}"/>
                                     </a4j:commandLink>
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.growingCost}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}" rendered="false">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.growingCost']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.growingCost}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                             <rich:column sortBy="#{siteAcqSP.dataObj.flowRemark}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}" rendered="false">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.flowRemark']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.flowRemark}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            <rich:column sortBy="#{siteAcqSP.dataObj.p_user}" styleClass="#{(semmsa003Bean.tmpRowId==siteAcqSP.dataObj.rowId)?'onClick':'unClick'}"
                            title="#{siteAcqSP.dataObj.p_contract_no}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg003['column.header.user']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{siteAcqSP.dataObj.p_user}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            
                            
                            <f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmsa003Bean.siteAcqSPList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="24">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
                                            maxPages="#{semmsa003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsa003Bean.scrollerPage}" 
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
                    </td></tr><tr><td>
                    <div align="center">
                    
                    </div>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>
<a4j:include id="msa003_popUpNew"  viewId="../../pages/sa/semmsa003PopUpNew.jsp" />
<a4j:include id="msa003_popupCom" viewId="../../pages/sa/semmsa001PopUpCommon.jsp"/>
<!--<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>-->
