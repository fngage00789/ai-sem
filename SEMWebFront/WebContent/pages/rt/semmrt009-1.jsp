<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.rental.semmrt003" var="jspMsg"/>
<h:panelGrid width="100%">
    <rich:panel>
        <f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
        
        <h:panelGroup style="width:100%;">
        
        <h:panelGrid>
            <table width="100%" border="0">
            <tr><td></td>
            <td>
            <a4j:form id="frmError">
                 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormTop}">
                        <f:facet name="header">
                            <h:outputText value="Entered Data Status:"></h:outputText>
                        </f:facet>
                        <f:facet name="errorMarker">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
            </a4j:form>
            </td></tr>
            </table>
        </h:panelGrid>
        <h:panelGrid>
		  <h:form id="frmAllInitTab">
		      <table width="100%">
		          <tr>
		              <td align="right">
		                  <a4j:commandButton id="msi004_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmrt003Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
			                  <a4j:actionparam name="navModule" value="rt" />
			                  <a4j:actionparam name="navProgram" value="SEMMRT001-0" />
			                  
			                  <a4j:actionparam name="moduleWithNavi" value="rt" />
			                  <a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
			                  <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
			                  
			                  <a4j:actionparam name="backWard" value="Y"/>                 
			              </a4j:commandButton>
		              </td>
		          </tr>
		      </table>
			  
          </h:form>
		</h:panelGrid>
        <h:panelGrid columnClasses="gridContent" width="100%">
                <!-- begin content layout criteria -->
                <h:panelGrid width="100%">
                <a4j:form id="frmSearch">
                    <rich:panel id="mrt009_pnlSearchCriteria">
                        <f:facet name="header">
                            <h:outputText value="#{jspMsg['header.criteria.name']}"/>
                        </f:facet>
                        
                        <!-- begin content criteria -->
                        <center>
                        <h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
                            <h:panelGroup>
                        
                            <table width="100%">
                                <tr>
                                    <td align="right" width="20%" valign="baseline">
                                        <h:panelGroup>
                                            <h:graphicImage value="images/icon_required.gif"/>
                                            <rich:spacer width="5"></rich:spacer>
                                            <h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
                                        </h:panelGroup>
                                    </td>
                                    <td width="30%">
                                        <h:selectOneMenu id="mrt009_ddlCompany" value="#{semmrt003Bean.rentalPayNormalSearchSP.company}" 
                                         onchange="GetCompanyJS();">
                                            <f:selectItems value="#{semmrt003Bean.companyList}"/>
                                        </h:selectOneMenu>
                                        <a4j:jsFunction name="GetCompanyJS" reRender="mrt009_companyDisplay"/>
                                        <rich:spacer width="10"></rich:spacer>
                                        <h:outputText id="mrt009_companyDisplay" value="#{semmrt003Bean.rentalPayNormalSearchSP.company}" styleClass="ms28"/>
                                    </td>
                                    <td align="right" width="20%">
                                         <h:panelGroup>
                                            <h:graphicImage value="images/icon_required.gif"/>
                                                <rich:spacer width="5"></rich:spacer>
                                            <h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
                                        </h:panelGroup>
                                    </td>
                                    <td width="30%">
                                       <h:selectOneMenu id="mrt009_ddlRegion" value="#{semmrt003Bean.rentalPayNormalSearchSP.region}">
                                            <f:selectItems value="#{semmrt003Bean.regionList}"/>
                                        </h:selectOneMenu>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right" width="20%">
                                        <h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                        <h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/> 
                                    </td>
                                    <td width="30%">
                                        <a4j:region>
                                            <h:inputText id="mrt009_txtBatchNo" value="#{semmrt003Bean.rentalPayNormalSearchSP.batchNo}"/>                                         
                                        </a4j:region>
                                    </td>
                                    <td align="right" width="20%">
                                        <h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
                                    </td>
                                    <td width="30%">
                                        <h:selectOneMenu id="mrt009_ddlPaymentType" value="#{semmrt003Bean.rentalPayNormalSearchSP.paymentType}">
                                            <f:selectItems value="#{semmrt003Bean.paymentTypeList}"/>
                                        </h:selectOneMenu> 
                                    </td>
                                 </tr>
                                 
                            </table>
                            </h:panelGroup>
                        </h:panelGrid>
                        </center>
                        <!-- end content criteria -->
                        
                        <div style="clear:both; height:10px;"></div>
                        
                        <center>
                        <h:panelGroup id="grdSearchCommand" style="width:96%;">
                            <table width="100%">
                                <tr>
                                    <td>
                                        <a4j:commandButton id="mrt009_btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button"
                                        action="#{navAction.navi}" reRender="frmError,mrt009_pnlSearchResult,mrt009_pnlInitSearchResult">
                                            <a4j:actionparam name="navModule" value="rt" />
                                            <a4j:actionparam name="navProgram" value="SEMMRT009-1" />
                                            <a4j:actionparam name="moduleWithNavi" value="rt" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMRT009" />
                                            <a4j:actionparam name="methodWithNavi" value="doSearch" />
                                            </a4j:commandButton>
                                        <rich:spacer width="5" />
                                        <a4j:commandButton id="mrt009_btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button"
                                         action="#{navAction.navi}" reRender="mrt009_pnlSearchResult,mrt009_pnlSearchCriteria,
                                                    mrt009_btnApprove,mrt009_btnReject">
                                            <a4j:actionparam name="navModule" value="rt" />
                                            <a4j:actionparam name="navProgram" value="SEMMRT009-1" />
                                            <a4j:actionparam name="moduleWithNavi" value="rt" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMRT009" />
                                            <a4j:actionparam name="methodWithNavi" value="doClearSession" />
                                        </a4j:commandButton>
                                    </td>
                                    <td align="right">
                                        <h:panelGrid id="pnlShowExcelReport" style="height:0px;width:0px;" width="0px" columns="0" >
                                            <h:panelGroup id="pnlInShowExcelReport" rendered="#{semmrt003Bean.displayShowExcelReport}" style="height:0px;width:0px;" >
                                                <h:commandButton value="Report" id ="btnExcelReport" action="#{semrrt024Action.runReport}"
                                                 style="height:0px;width:0px;display:none;" rendered="#{semmrt003Bean.displayShowExcelReport}">
                                                </h:commandButton>                              
                                                <script>document.getElementById('incContent:frmSearch:btnExcelReport').click();</script>
                                            </h:panelGroup>                         
                                        </h:panelGrid>
                                    </td>
                                </tr>
                            </table>
                        </h:panelGroup>
                        </center>
                        
                    </rich:panel>
                    </a4j:form>
                </h:panelGrid>
            
            <a4j:form id="frmSearchResult"> 
                <!-- end content layout criteria -->
                <!-- begin content button -->
                <div align="left">
                    <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormBottom}"/>
                </div>
                
                <table style="vertical-align: bottom;">
                            <tr>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                    
                                </td>
                            </tr>
                            <tr style="vertical-align: bottom;">
                                <td>
                                    
                                    <a4j:commandButton id="mrt009_btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
                                     oncomplete="#{rich:component('popupApproveRentalPayNormal')}.show(); return false" 
                                      action="#{navAction.navi}" reRender="popupApproveRentalPayNormal" 
                                      rendered="#{semmrt003Bean.renderer['btnApprove'] or semmrt003Bean.renderedOnToDoList}">
                                        <a4j:actionparam name="navModule" value="rt" />
                                        <a4j:actionparam name="navProgram" value="SEMMRT009-1" />
                                        <a4j:actionparam name="moduleWithNavi" value="rt" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMRT009" />
                                        <a4j:actionparam name="methodWithNavi" value="initApprove" />
                                        <a4j:actionparam name="btnApproveStatus" value="AA" />                           
                                    </a4j:commandButton>
                                    <rich:spacer width="5"/>
                                    
                                    <a4j:commandButton id="mrt009_btnReject" value="#{jspMsg['btn.reject']}" styleClass="rich-button" disabled="#{semmrt003Bean.disabledBtnExport}"
                                     style="width:75px;" oncomplete="#{rich:component('popupApproveRentalPayNormal')}.show(); return false" 
                                      action="#{navAction.navi}" reRender="popupApproveRentalPayNormal" 
                                      rendered="#{semmrt003Bean.renderer['btnReject'] or semmrt003Bean.renderedOnToDoList}">
                                        <a4j:actionparam name="navModule" value="rt" />
                                        <a4j:actionparam name="navProgram" value="SEMMRT003-1" />
                                        <a4j:actionparam name="moduleWithNavi" value="rt" />
                                        <a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
                                        <a4j:actionparam name="methodWithNavi" value="initApprove" />
                                        <a4j:actionparam name="btnApproveStatus" value="CA" />  
                                    </a4j:commandButton>
                                    <rich:spacer width="15"/>
                                    
                                   
                                </td>
                                <td>
                                   
                                </td>
                                <td>
                                    
                                </td>
                            </tr>
                        </table>
                
                <!-- ShowReport Panel -->
                    <h:panelGrid id="pnlShowReport" style="height:0px;width:0px;" width="0px" columns="0" >
                        <h:panelGroup id="pnlInShowReport" rendered="#{semmrt003RPTBean.displayShowReport}" style="height:0px;width:0px;" >
                            <h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmrt003RPTAction.showReport}"  />                                
                            <script>document.getElementById('incContent:frmSearchResult:bthShowReport').click();</script>
                        </h:panelGroup>                         
                    </h:panelGrid>
                
                    <h:panelGrid id="pnlShowExcel" style="height:0px;width:0px;" width="0px" columns="0" >
                        <h:panelGroup id="pnlInShowExcel" rendered="#{semmrt003Bean.displayShowExcel}" style="height:0px;width:0px;" >
                            <h:commandButton value="Report" id ="btnExcel" action="#{semmrt003Action.doExportExcel}"
                             style="height:0px;width:0px;display:none;" rendered="#{semmrt003Bean.displayShowExcel}">
                            </h:commandButton>                              
                            <script>document.getElementById('incContent:frmSearchResult:btnExcel').click();</script>
                        </h:panelGroup>                         
                    </h:panelGrid>
                    
                    <h:panelGrid id="pnlShowReportEpt" style="height:0px;width:0px;" width="0px" columns="0" >
                        <h:panelGroup id="pnlInShowReportEpt" rendered="#{semmrt003Bean.displayReportFlag}" style="height:0px;width:0px;" >
                            <h:commandButton value="Report" id="bthShowReportEpt" style="height:0px;width:0px;display:none;" action="#{semmrt003Action.doExportExcelLetter}"  />                              
                            <script>document.getElementById('incContent:frmSearchResult:bthShowReportEpt').click();</script>
                        </h:panelGroup>                         
                    </h:panelGrid>
                <!-- End Code -->                   
                
                <!-- end content button -->
                
                <!-- begin content layout data grid-->
                <h:panelGrid  width="100%">
                    <rich:panel id="mrt009_pnlSearchResult">
                        <f:facet name="header" >
                            <h:outputText value="#{jspMsg['header.resultTable.name']}" />
                        </f:facet>
                        <div align="left">
                            <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt003Bean.renderedMsgFormMiddle}"/>
                        </div>
                        <div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmrt003Bean.msgDataNotFound}" rendered="#{semmrt003Bean.renderedMsgDataNotFound}" />
                        </div>
                        
                        <center>                
                        <div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
                        
                         <rich:dataTable  id="mrt009_dtbRentalPayNormalSrch" cellpadding="1" cellspacing="0" border="0"
                            var="rentalPayNormalSP" value="#{semmrt003Bean.rentalPayNormalSearchSPList}" reRender="mrt009_dstRentalPayNormalSrch" 
                            rows="#{semmrt003Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
                            
                            <rich:column styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <a4j:region>
                                    <h:selectBooleanCheckbox style="width: 20" value="#{semmrt003Bean.chkSelAll}">
                                        <a4j:support event="onclick" action="#{semmrt009Action.selectAllRow}" reRender="frmSearchResult,mrt009_dtbRentalPayNormalSrch,
                                        mrt009_btnApprove,mrt009_btnReject"/>
                                    </h:selectBooleanCheckbox>
                                    </a4j:region>
                                </f:facet>
                                <div align="center">
                                    <a4j:region>
                                    <h:selectBooleanCheckbox id="chkSelect"  value="#{rentalPayNormalSP.checkBox}" rendered="true">
                                        <a4j:support event="onclick" action="#{semmrt009Action.onRenderExportButton}" reRender="mrt009_btnApprove,mrt009_btnReject,frmSearchResult">
                                            <a4j:actionparam name="rowId" value="#{rentalPayNormalSP.dataObj.rowId}" />
                                        </a4j:support>
                                    </h:selectBooleanCheckbox>
                                    </a4j:region>
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.rowId}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.batchNo']}" styleClass="contentform" style="width:50px"/>
                                </f:facet>
                                <div align="center">
                                    <a4j:commandLink id="mrt009_hypView" value="#{rentalPayNormalSP.dataObj.rowId}" 
                                        action="#{navAction.navi}" style="width:100"
                                        reRender="oppContent,mrt009_pnlSearchResult,mrt009_pnlSearchCriteria">
                                        <a4j:actionparam name="navModule" value="rt" />
                                        <a4j:actionparam name="navProgram" value="SEMMRT003-1" />
                                        <a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
										<a4j:actionparam name="methodWithNavi" value="doSearch" />
										<a4j:actionparam name="batchNo" value="#{rentalPayNormalSP.dataObj.rowId}" />
                                    
                                    </a4j:commandLink>
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.company}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.company']}" styleClass="contentform" style="width:60"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.company}"></h:outputText>
                                </div>
                            </rich:column>
                            <rich:column sortBy="#{rentalPayNormalSP.dataObj.region}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.region']}" styleClass="contentform"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.region}" styleClass="contentform"></h:outputText>
                                    
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.totalRec}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.total']}"   styleClass="contentform" style="width:60px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.totalRec}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.extraRec}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
                                title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.payExtra']}" styleClass="contentform" style="width:60px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.extraRec}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.pendingRec}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.pendingRec']}" styleClass="contentform"  style="width:60px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.pendingRec}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.networkRec}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.networkRec']}" styleClass="contentform"  style="width:24px"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.networkRec}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.paymentStatusDesc1']}" styleClass="contentform"  style="width:120px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.paymentStatusDesc}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentTypeDesc}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.paymentTypeDesc']}" styleClass="contentform"  style="width:60px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.paymentTypeDesc}"></h:outputText>
                                    
                                </div>
                            </rich:column>          
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.paymentMethod}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.paymentMethod']}" styleClass="contentform"  style="width:20px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.paymentMethod}" styleClass="contentform"  />
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqDtDisplayStr}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform" />
                                </f:facet>
                                <div align="left">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.chqDtDisplayStr}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.chqReceiveDtDisplayStr}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform" />
                                </f:facet>
                                <div align="left">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.chqReceiveDtDisplayStr}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPayNormalSP.dataObj.transferDtDisplayStr}" styleClass="#{(semmrt003Bean.tmpRowId==rentalPayNormalSP.dataObj.rowId)?'onClick':'unClick'}"
                                title="#{rentalPayNormalSP.dataObj.contractNo} #{rentalPayNormalSP.dataObj.siteName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform" />
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPayNormalSP.dataObj.transferDtDisplayStr}" styleClass="contentform"  />
                                </div>
                            </rich:column>
                            
                            <f:facet name="footer">
                            
                                <rich:columnGroup>
                                    <rich:column colspan="5">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmrt003Bean.rentalPayNormalSearchSPList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="42">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="mrt009_dtbRentalPayNormalSrch"
                                            maxPages="#{semmrt003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="mrt009_dstRentalPayNormalSrch" 
                                            style="background-color: #cccccc;"
                                            page="#{semmrt003Bean.scrollerPage}">
                                        <a4j:support event="onclick"  reRender="frmSearchResult"></a4j:support>
                                        </rich:datascroller>
                                        
                                    </rich:column>
                                </rich:columnGroup>     
                                        
                            </f:facet>
                        </rich:dataTable>
                        
                        </div>
                        </center>
                        
                    </rich:panel>
                </h:panelGrid>
                
                <!-- end content layout data grid -->
                
                <!-- begin content layout data grid-->
                <h:panelGrid  width="96%" style="display:none;">
                    <rich:panel id="mrt009_pnlInitSearchResult">
                        <f:facet name="header" >
                            <h:outputText value="#{jspMsg['header.resultTable.name']}"/>
                        </f:facet>
                             <!--<rich:messages id="errorMsgMid" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt002Bean.renderedMsgFormMiddle}">
                                    <f:facet name="header">
                                        <h:outputText value="Entered Data Status:"></h:outputText>
                                    </f:facet>
                                    <f:facet name="errorMarker">
                                         <h:graphicImage value="images/error.gif" />  
                                    </f:facet>
                            </rich:messages>
                        
                         -->
                         <div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmrt003Bean.msgDataNotFound}" rendered="#{semmrt003Bean.renderedMsgDataNotFound2}" />
                        </div>
                         <rich:dataTable id="mrt009_dtbRentalPaySSrch" cellpadding="1" cellspacing="0" border="0"
                            reRender="mrt009_dstRentalPaySSrch" rows="5"
                            onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
                            onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
                            var="rentalPaySSP" value="#{semmrt003Bean.rentalPaySSearchSpList}">
                            <rich:column  sortBy="#{rentalPaySSP.jobType}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.jobType']}" style="width:72px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPaySSP.jobType}" />
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{rentalPaySSP.company}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.company']}"  style="width:30px"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{rentalPaySSP.company}" />
                                </div>
                            </rich:column>  
                            <rich:column  sortBy="#{rentalPaySSP.regionName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.regionName']}" style="width:150px"/>
                                </f:facet>
                                <div align="left">
                                    <h:outputText value="#{rentalPaySSP.regionName}"/>
                                </div>
                            </rich:column>  
                            
                            <rich:column  sortBy="#{rentalPaySSP.payTotal}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.paytotal']}" style="width:36px"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText value="#{rentalPaySSP.payTotal}"  />
                                </div>
                            </rich:column>              
                            <rich:column  sortBy="#{rentalPaySSP.noPayTotal}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.nonPayTotal']}" style="width:36px"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText value="#{rentalPaySSP.noPayTotal}" />
                                </div>
                            </rich:column>
                            <rich:column  sortBy="#{rentalPaySSP.grandTotal}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.grandTotal']}" style="width:36px"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText value="#{rentalPaySSP.grandTotal}" />
                                </div>
                            </rich:column>
                            
                            <f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmrt003Bean.rentalPaySSearchSpList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="4">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="mrt009_dtbRentalPaySSrch"
                                            maxPages="#{semmrt003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="mrt009_dstRentalPaySSrch" 
                                            style="background-color: #cccccc;"
                                            page="#{semmrt003Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>                 
                            </f:facet>
                            </rich:dataTable>
                    </rich:panel>
                </h:panelGrid>
            </a4j:form>
        </h:panelGrid>
        
        </h:panelGroup>
        
    </rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/rt/semmrt009-popup.jsp"/>