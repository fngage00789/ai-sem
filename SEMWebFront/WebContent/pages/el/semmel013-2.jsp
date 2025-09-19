<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel013-2" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.uploadPremissionInformation']}"/>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columns="4" id="grdSearchCommand2" width="98%">
			<a4j:form id="frmBack">
			<div align="right">
						<a4j:commandButton id="btnBackToPage1"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmel013Bean.renderedBackButtonToPage1}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL013-0" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
							<a4j:actionparam name="methodWithNavi" value="dobackToPage1FromPage3" />
						</a4j:commandButton>
						<a4j:commandButton id="btnBackToPage2"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmel013Bean.renderedBackButtonToPage2}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL013-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
							<a4j:actionparam name="methodWithNavi" value="doback" />
						</a4j:commandButton>
			&nbsp;
						<a4j:commandButton id="btnClearPageUpload"  value="#{jspMsg['btn.clear']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmel013Bean.renderedBackButtonToPage1}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL013-2" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
							<a4j:actionparam name="methodWithNavi" value="doClearPageUpload" />
						</a4j:commandButton>
			</div>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid style="width: 98%">
		<div align="center">
			
		</div>    
		
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" style="width: 95%" border="0">
				<!-- begin content layout criteria -->
				<a4j:form id="frmSearch">
				
				<h:panelGrid  border="0">
					
						
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="0" rendered="#{semmel013Bean.renderedSelectFile}">
							<h:panelGroup>
								<table width="100%" align="right">
									<tr>
										<td align="right" width="20%">
										</td>
										<td width="30%">
								       	 	<h:selectOneMenu id="warranTypeDdl" value="#{semmel013Bean.warrantTypeForFile}" style="width : 180px">
											     <f:selectItems value="#{semmel013Bean.warrantTypeList}" />
										    	<a4j:support event="onchange" action="#{semmel013Action.doChangeSite}" />
										    </h:selectOneMenu>
										</td>
									</tr>	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<rich:fileUpload id="btnBrowse" fileUploadListener="#{semmel013Action.listener}"
											              maxFilesQuantity="1"
											              listHeight="58"
														  listWidth="265px"
											              addControlLabel="Browse..."
											              onfileuploadcomplete="onuploadcomplete();"
											              rendered="#{semmel013Bean.renderer['btnBrowse']}">
								         </rich:fileUpload>
								         <a4j:jsFunction name="onuploadcomplete" action="#{semmel013Action.onRenderUploadFile}" reRender="btnBrowse,frmError,pnlImportResult,pnlUploadMeter,pnlExport"/>
								         
								         
										</td>
									</tr>	
								</table>
							</h:panelGroup>
						</h:panelGrid>
				
				<h:panelGrid  border="0" cellpadding="0" cellspacing="0" width="100%">
					<rich:panel id="pnlImportResult">								
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.importDetail']}"/>
						</f:facet>						
						<!-- begin content criteria -->
						<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText id="txtTotalSiteMeter" value="#{semmel013Bean.uploadPermissionFile.fileName}" 
												styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.allRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}"  value="#{semmel013Bean.uploadPermissionFile.totalNo}" style="font-size:11px;"  reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL013-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
											<a4j:actionparam name="methodWithNavi" value="doSearchAll" />
											<a4j:actionparam name="rowIndex" value="#{semmel013Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>								
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.passRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" value="#{semmel013Bean.uploadPermissionFile.successNo}"  style="font-size:11px;"  reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL013-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
											<a4j:actionparam name="methodWithNavi" value="doSearchInCaseSuccess" />
											<a4j:actionparam name="rowIndex" value="#{semmel013Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.failedRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" value="#{semmel013Bean.uploadPermissionFile.failedNo}"  style="font-size:11px;"  reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL013-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
											<a4j:actionparam name="methodWithNavi" value="doSearchInCaseFailed" />
											<a4j:actionparam name="rowIndex" value="#{semmel013Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid>
				
				
				
				<h:panelGrid width="100%" border="0" cellspacing="4" >
					<h:panelGroup id="pnlExport">
						<a4j:commandButton id="btnGenDummy" value="#{jspMsg['btn.genDummy']}"
						 disabled="#{semmel013Bean.disabledBtnGenDummy}"
								styleClass="rich-button" action="#{navAction.navi}" >
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL013-2" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
								<a4j:actionparam name="methodWithNavi" value="doGendummy" />
								 <a4j:actionparam name="rowLogIdForSeach" value="#{semmel013Bean.logId}"/>
							</a4j:commandButton>
						<h:commandButton id="btnExportError" value="#{jspMsg['btn.exportError']}" style="float:right;" 
								rendered="#{semmel013Bean.renderedExportErrorButton}"
								styleClass="rich-button" action="#{semmel013Action.doExportError}" >
							</h:commandButton>
					
					
					</h:panelGroup>
				</h:panelGrid>
				
				<!-- ShowReport Panel -->
                <h:panelGrid id="show_report" style="height:0px;width:0px;" width="0" columns="0">
                    <h:panelGroup id="show_report_in" rendered="#{semmel013Bean.displayBtn}" style="height:0px;width:0px;" >
                        <h:commandButton value="Report" id="btnExportExcel" style="height:0px;width:0px;display:none;" action="#{semmel013Action.doPrintOut}">
                         <script>document.getElementById('incContent:frmSearch:btnExportExcel').click();</script>
                        </h:commandButton>
                    </h:panelGroup>                         
                </h:panelGrid>
                <!-- End Code -->
				<h:panelGrid width="95%" border="0" cellspacing="0" >	
					<rich:panel id="pnlUploadMeter" styleClass="sem_autoScrollbar"  >
						<f:facet name="header">
						    	<h:outputText value="#{jspMsg['header.detailData']}"></h:outputText>
						</f:facet>
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmel013Bean.msgDataNotFound}" rendered="#{semmel013Bean.renderedMsgDataNotFound}" />
                        </div>
                        <div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
					<rich:dataTable id="dtbUploadMeter" width="100%" cellpadding="1" cellspacing="0" border="0" 
								var="upload"  value="#{semmel013Bean.uploadElPerList}" 
								reRender="dtbUploadMeter" 
								rowKeyVar="rowIndex"
								rows="#{semmel013Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								
								<rich:column styleClass="#{(semmel013Bean.tmpRowId==upload.dataObj.rowId)?'onClick':'unClick'}" 
                                rendered="true">
                                <f:facet name="header">
                                <h:selectBooleanCheckbox value="#{semmel013Bean.chkSelAll}">
                                        <a4j:support event="onclick" action="#{semmel013Action.selectAllRow}" 
                                            reRender="pnlUploadMeter,btnGenDummy,pnlExport"/>
                                </h:selectBooleanCheckbox>
                                </f:facet>
                                <div align="center">
                                    <h:selectBooleanCheckbox id="siteAcqSelected" value="#{upload.checkBox}" 
                                        rendered="#{(upload.dataObj.contractNo == '' or upload.dataObj.contractNo== null) and upload.dataObj.status!='Error'}">
                                        <a4j:support event="onclick" action="#{semmel013Action.onRenderButton}" 
                                        reRender="pnlUploadMeter,btnGenDummy,pnlExport">
                                        <a4j:actionparam name="rowId" value="#{upload.dataObj.rowId}" />
                                    </a4j:support>
                                    </h:selectBooleanCheckbox>
                                </div>
                            </rich:column>
								
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.printHd']}" />
									</f:facet>
									<div align="center">
		            					
		            					
									 <a4j:commandButton id="btnPrint" action="#{navAction.navi}"
					                        styleClass="rich-button" value="#{jspMsg['column.result.print']}" 
					                        rendered="#{upload.dataObj.status == 'Success' and upload.dataObj.electricType!='PRIVATE'}" style="width: 150px"
					                        reRender="frmSearch,pnlImportResult,dtbUploadMeter,frmError,show_report">
					                        <a4j:actionparam name="navModule" value="el" />
                                            <a4j:actionparam name="navProgram" value="SEMMEL013-2" />
                                            <a4j:actionparam name="moduleWithNavi" value="el" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
                                            <a4j:actionparam name="methodWithNavi" value="doGenBatch" />
                                            <a4j:actionparam name="rowIndex" value="#{upload.dataObj.rowId}" />
                                            <a4j:actionparam name="rowLogIdForSeach" value="#{semmel013Bean.logId}"/>
                                            <a4j:actionparam name="flagPrint" value="Page3" />
					                    </a4j:commandButton>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.edit']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnOpenPopup" oncomplete="#{rich:component('popupProxyEditPermission')}.show(); return false" 
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="frmError,popupProxyEditPermission,pnlUploadMeter" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL013-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
											<a4j:actionparam name="methodWithNavi" value="doSearchByRowIdForEdit" />
											<a4j:actionparam name="rowIndex" value="#{upload.dataObj.rowId}"/>
											<a4j:actionparam name="flagPage" value="page2"/>
		            					</a4j:commandButton> 
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.delete']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnDelete"   action="#{navAction.navi}"   reRender="oppContent" 
	            									   image="images/delete.png" style="height: 15; width : 15px;"
	            									     oncomplete="#{rich:component('mdpConfirmDelDataDialog')}.show(); return false"
	            									   >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL013-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
											<a4j:actionparam name="methodWithNavi" value="initDelDataByRecord" />
											<a4j:actionparam name="rowLogIdForDel" value="#{semmel013Bean.logId}"/>
											<a4j:actionparam name="rowIndexForDel" value="#{upload.dataObj.rowId}"/>
		            					</a4j:commandButton> 
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.lineNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.item']}" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{upload.dataObj.lineNo}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.company}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.company']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.dataObj.company}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contractNo']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.dataObj.contractNo}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.locationId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationId']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.dataObj.locationId}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.siteName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaNamestation']}" style="width :200px;"/>
									</f:facet>
									<div align="left" style="width :200px;">
										<h:outputText value="#{upload.dataObj.siteName}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.ctStartDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.startDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.dataObj.ctStartDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.ctFinishDt}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.finishDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.dataObj.ctFinishDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.areaType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaType']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.dataObj.areaType}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.address}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.address']}" style="width :200px;"/>
									</f:facet>
									<div align="left" style="width :200px;">
										<h:outputText value="#{upload.dataObj.address}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.tumbon}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.tumbon']}" style="width :120px;" />
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.dataObj.tumbon}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.amphur}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.amphur']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.dataObj.amphur}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.province}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.province']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;" >
										<h:outputText value="#{upload.dataObj.province}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.electricType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.electricType']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.dataObj.electricType}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.remark}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.remark']}" style="width :150px;"/>
									</f:facet>
									<div align="left" style="width :150px;">
										<h:outputText value="#{upload.dataObj.remark}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.printFlag}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.state']}" style="width :150px;"/>
									</f:facet>
									<div align="left" style="width :150px;">
										<h:outputText value="#{upload.dataObj.printFlag}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.dataObj.status}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.status']}" />
									</f:facet>
									<div align="left" >
										<h:outputText value="#{upload.dataObj.status}"/>
									</div>
								</rich:column>
								
								<rich:column sortBy="#{upload.dataObj.errMsg}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.errMsg']}" style="width :300px;"/>
									</f:facet>
									<div align="left" style="width :300px;">
										<h:outputText value="#{upload.dataObj.errMsg}"/>
									</div>
								</rich:column>
								
								<f:facet name="footer">
									<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmel013Bean.uploadElPerList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="17">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadMeter"
                                            maxPages="#{semmel013Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstUploadMeter" 
                                            style="background-color: #cccccc;"
                                            page="#{semmel013Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
								</f:facet>
							</rich:dataTable>
							</div>
							</rich:panel>
							
						</h:panelGrid>
					
					</h:panelGrid>
					</a4j:form>
				
				<!-- end content layout criteria -->
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<rich:modalPanel id="popupViewFailedRecord" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['popup.header.failedLine']}"></h:outputText>
    </f:facet>

	<h:panelGrid>
		</h:panelGrid>
	
		<table width="200px" border="0" cellspacing="" cellpadding="2">			
			
			<tr>
				<td align="left">
					<h:outputText value="#{jspMsg['popup.label.itemNo']}" styleClass="ms7"></h:outputText>&nbsp;
					<h:outputText value="#{semmel013Bean.uploadMeterFile.failedLine}" styleClass="ms7" />					
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<a4j:commandButton value="#{jspMsg['popup.btn.close']}" styleClass="rich-button" action="#{navAction.navi}" >
					    <rich:componentControl for="popupViewFailedRecord" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
<a4j:include id="mel013_popUpEditProxy"  viewId="../../pages/el/semmel013PopUpEdit.jsp" />

<rich:modalPanel id="mdpConfirmDelDataDialog" autosized="true">   
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDataDialog">
        <table width="200px" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform" width="170px">
                        <h:outputText value="#{popupUploadFilePictureBean.msgDoDelete}" styleClass="ms7" />
                    </h:panelGrid>
                </td>
            </tr>
            <tr>
            <td align="center">
                    <h:panelGrid columns="2" styleClass="contentlabelform">
                        <a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" 
                                           immediate="true" reRender="oppContent" >
                            					<a4j:actionparam name="navModule" value="el" />
				            					<a4j:actionparam name="navProgram" value="SEMMEL013-2" />	
												<a4j:actionparam name="moduleWithNavi" value="el" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
					                            <a4j:actionparam name="methodWithNavi" value="doDeleteByRecord" />
												<a4j:actionparam name="rowIndex" value="#{semmel013Bean.rowIdFordelete}"/>
												<a4j:actionparam name="rowLogId" value="#{semmel013Bean.logIdFordelete}"/>
					         <rich:componentControl for="mdpConfirmDelDataDialog" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDataDialog" operation="hide" event="onclick" />
                        </a4j:commandButton>
                    </h:panelGrid>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>