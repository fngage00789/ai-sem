<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.construction.semmcp002-2" var="jspMsg"/>
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
						<a4j:commandButton id="btnBackTopage1"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmcp002Bean.renderedBackButtonToPage1}">
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP002-0" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
							<a4j:actionparam name="methodWithNavi" value="dobackToPage1FromPage3" />
						</a4j:commandButton>
						
						<a4j:commandButton id="btnBackTopage2"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmcp002Bean.renderedBackButtonToPage2}">
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP002-1" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
							<a4j:actionparam name="methodWithNavi" value="doback" />
						</a4j:commandButton>
				&nbsp;
						<a4j:commandButton id="btnClearPageUpload"  value="#{jspMsg['btn.clear']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmcp002Bean.renderedBackButtonToPage1}">
							<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP002-2" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
							<a4j:actionparam name="methodWithNavi" value="doClearPageUpload" />
						</a4j:commandButton>
			</div>
			</a4j:form>
		</h:panelGrid>	
		<h:panelGrid columnClasses="gridContent" style="width: 65%" border="0">
				<!-- begin content layout criteria -->
				<a4j:form id="frmSearch">
				
				<h:panelGrid  border="0">
					
						
						
						<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="0" rendered="#{semmcp002Bean.renderedSelectFile}">
							<h:panelGroup>
								<table width="100%" align="right">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<rich:fileUpload id="btnBrowse" fileUploadListener="#{semmcp002Action.listener}"
											              maxFilesQuantity="1"
											              listHeight="58"
														  listWidth="265px"
											              addControlLabel="Browse..."
											              onfileuploadcomplete="onuploadcomplete();"
											              rendered="#{semmcp002Bean.renderer['btnBrowse']}">
								         </rich:fileUpload>
								         <a4j:jsFunction name="onuploadcomplete" action="#{semmcp002Action.onRenderUploadFile}" reRender="btnBrowse,frmError,pnlImportResult,pnlUploadMeter,pnlExport"/>
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
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText id="txtTotalSiteMeter" value="#{semmcp002Bean.uploadPermissionFile.fileName}" 
												styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.allRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" value="#{semmcp002Bean.uploadPermissionFile.totalNo}" style="font-size:11px;" reRender="pnlUploadMeter,frmError,pnlExport">
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchAll" />
											<a4j:actionparam name="rowIndex" value="#{semmcp002Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>											
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.passRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" value="#{semmcp002Bean.uploadPermissionFile.successNo}"  style="font-size:11px;" reRender="pnlUploadMeter,frmError,pnlExport">
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchInCaseSuccess" />
											<a4j:actionparam name="rowIndex" value="#{semmcp002Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.failedRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" value="#{semmcp002Bean.uploadPermissionFile.failedNo}" style="font-size:11px;" reRender="pnlUploadMeter,frmError,pnlExport">
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchInCaseFailed" />
											<a4j:actionparam name="rowIndex" value="#{semmcp002Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid>
				<h:panelGrid id="pnlShowReportDoc" style="height:0px;width:0px;" width="0px" columns="0" >
	                    <h:panelGroup id="pnlInShowReport" rendered="#{semmcp002Bean.showReport}" style="height:0px;width:0px;" >
	                        <h:commandButton value="Report" id="btnShowReport" style="height:0px;width:0px;display:none;" action="#{semmcp002Action.doDownloadContractFile}">
	                        <script>document.getElementById('incContent:frmSearch:btnShowReport').click();</script>
	                        </h:commandButton>                              
	                    </h:panelGroup>                         
	                </h:panelGrid>
				
				<h:panelGrid width="100%" border="0" cellspacing="4" >
					<h:panelGroup id="pnlExport">
					
						<h:commandButton id="btnExportError" value="#{jspMsg['btn.exportError']}" style="float:right;" 
								rendered="#{semmcp002Bean.renderedExportErrorButton}"
								styleClass="rich-button" action="#{semmcp002Action.doExportError}" >
							</h:commandButton>
						
						
					</h:panelGroup>
				</h:panelGrid>
				<h:panelGrid width="95%" border="0" cellspacing="0" >	
					<rich:panel id="pnlUploadMeter" styleClass="sem_autoScrollbar"  >
						<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.detailData']}"></h:outputText>
						</f:facet>
					<center>
					<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmcp002Bean.msgDataNotFound}" rendered="#{semmcp002Bean.renderedMsgDataNotFound}" />
                        </div>				
						<div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
					<rich:dataTable id="dtbUploadMeter" width="100%" cellpadding="1" cellspacing="0" border="0" 
								var="upload"  value="#{semmcp002Bean.uploadElPerList}" 
								reRender="dtbUploadMeter" 
								rowKeyVar="rowIndex"
								rows="#{semmcp002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.printHeader']}" />
									</f:facet>
									<div align="center">
		            					
		            					<a4j:commandButton id="btnPrint"
				                                action="#{navAction.navi}"
				                                reRender="oppContent"
				                                rendered="#{upload.status == 'Success'}"
				                                value="#{jspMsg['column.result.print']}" styleClass="rich-button" style="width:150px"  >
				                                <a4j:actionparam name="navModule" value="cp" />
				                                <a4j:actionparam name="navProgram" value="SEMMCP002-2" />
				                                <a4j:actionparam name="moduleWithNavi" value="cp" />
				                                <a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
				                                <a4j:actionparam name="methodWithNavi" value="doRunReport" />
				                                 <a4j:actionparam name="rowId" value="#{upload.rowId}" />
				                                 <a4j:actionparam name="rowLogIdForSearch" value="#{semmcp002Bean.logId}"/>
				                                 <a4j:actionparam name="flagPrint" value="Page3" />
				                                 <a4j:support event="oncomplete" reRender="frmError,pnlSearchResultHeader,pnlShowReportDoc" />
				                            </a4j:commandButton>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.edit']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnOpenPopup" oncomplete="#{rich:component('popupEditImportWarrantConStruc')}.show(); return false" 
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="frmError,popupEditImportWarrantConStruc,pnlUploadMeter" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchByRowIdForEdit" />
											<a4j:actionparam name="rowIndex" value="#{upload.rowId}"/>
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
	            									   image="images/delete.png" style="height: 15; width: 15" 
	            									     oncomplete="#{rich:component('mdpConfirmDelDataDialog')}.show(); return false"
	            									   >
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="initDelDataByRecord" />
											<a4j:actionparam name="rowLogIdForDel" value="#{semmcp002Bean.logId}"/>
											<a4j:actionparam name="rowIndexForDel" value="#{upload.rowId}"/>
		            					</a4j:commandButton> 
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.lineNo}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.item']}" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{upload.lineNo}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.company}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.company']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.company}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contractNo']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.contractNo}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.locationId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationId']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.locationId}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.siteName}"> 
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaNamestation']}" style="width :200px;"/>
									</f:facet>
									<div align="center" style="width :200px;">
										<h:outputText value="#{upload.siteName}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.ctStartDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.startDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.ctStartDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.ctFinishDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.finishDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.ctFinishDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.areaType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaType']}" style="width: 120px;"/>
									</f:facet>
									<div align="left" style="width: 120px;">
										<h:outputText value="#{upload.areaType}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.address}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.address']}" style="width: 150px;"/>
									</f:facet>
									<div align="left" style="width: 150px;">
										<h:outputText value="#{upload.address}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.tumbon}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.tumbon']}" style="width: 120px;"/>
									</f:facet>
									<div align="left" style="width: 120px;">
										<h:outputText value="#{upload.tumbon}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.amphur}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.amphur']}" style="width: 120px;"/>
									</f:facet>
									<div align="left" style="width: 120px;">
										<h:outputText value="#{upload.amphur}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.province}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.province']}" style="width: 120px;"/>
									</f:facet>
									<div align="left" style="width: 120px;">
										<h:outputText value="#{upload.province}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.printFlag}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.state']}" style="width: 150px;"/>
									</f:facet>
									<div align="left" style="width :150px;">
										<h:outputText value="#{upload.printFlag}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.status}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.status']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.status}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.errMsg}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.msg']}" style="width: 300px;"/>
									</f:facet>
									<div align="left" style="width: 300px;">
										<h:outputText value="#{upload.errMsg}"/>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmcp002Bean.uploadElPerList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="15">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadMeter"
                                            maxPages="#{semmcp002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstUploadMeter" 
                                            style="background-color: #cccccc;"
                                            page="#{semmcp002Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
								</f:facet>
							</rich:dataTable>
							</div>
							</center>
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
					<h:outputText value="#{semmcp002Bean.uploadMeterFile.failedLine}" styleClass="ms7" />					
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
<a4j:include id="mcp02_popUpEdit"  viewId="../../pages/cp/semmcp002PopUpEdit.jsp" />

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
                            					<a4j:actionparam name="navModule" value="cp" />
				            					<a4j:actionparam name="navProgram" value="SEMMCP002-2" />	
												<a4j:actionparam name="moduleWithNavi" value="cp" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
					                            <a4j:actionparam name="methodWithNavi" value="doDeleteByRecord" />
												<a4j:actionparam name="rowIndex" value="#{semmcp002Bean.rowIdFordelete}"/>
												<a4j:actionparam name="rowLogId" value="#{semmcp002Bean.logIdFordelete}"/>
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