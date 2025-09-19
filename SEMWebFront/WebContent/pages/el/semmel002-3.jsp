<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel002-3" var="jspMsg"/>
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
							reRender="oppContent" styleClass="rich-button"
							rendered="#{semmel002Bean.renderedBackButtonToPage1}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL002-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
							<a4j:actionparam name="methodWithNavi" value="dobackToPage1FromPage3" />
					</a4j:commandButton>
					<a4j:commandButton id="btnBackToPage2"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							reRender="oppContent" styleClass="rich-button"
							rendered="#{semmel002Bean.renderedBackButtonToPage2}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL002-2" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
							<a4j:actionparam name="methodWithNavi" value="doback" />
					</a4j:commandButton>
					
						&nbsp;
						<a4j:commandButton id="btnClearPageUpload"  value="#{jspMsg['btn.clear']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmel002Bean.renderedBackButtonToPage1}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL002-3" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
							<a4j:actionparam name="methodWithNavi" value="doClearPageUpload" />
						</a4j:commandButton>
			</div>
			</a4j:form>
		</h:panelGrid>	
		<h:panelGrid columnClasses="gridContent" style="width: 95%" border="0">
				<!-- begin content layout criteria -->
				<a4j:form id="frmSearch">
				
				<h:panelGrid  border="0">
					
						
						<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="0" rendered="#{semmel002Bean.renderedSelectFile}">
							<h:panelGroup >
								<table width="100%" align="right">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
											
										</td>
										<td width="30%">
											<rich:fileUpload id="btnBrowse" fileUploadListener="#{semmel002Action.listener}"
											              maxFilesQuantity="1"
											              listHeight="58"
														  listWidth="265px"
											              addControlLabel="Browse..."
											              onfileuploadcomplete="onuploadcomplete();"
											              rendered="#{semmel002Bean.renderer['btnBrowse']}">
								         </rich:fileUpload>
								         <a4j:jsFunction name="onuploadcomplete" action="#{semmel002Action.onRenderUploadFile}" reRender="btnBrowse,frmError,pnlImportResult,pnlUploadMeter,pnlExport"/>
										</td>
									</tr>	
								</table>
							</h:panelGroup>
						</h:panelGrid>
				
				<h:panelGrid  border="0" cellpadding="0" cellspacing="0" width="100%" >
					<rich:panel id="pnlImportResult">								
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.importDetail']}"/>
						</f:facet>						
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1" id="criteriaForDtb">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText id="txtTotalSiteMeter" value="#{semmel002Bean.uploadPermissionFile.fileName}" 
												styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.allRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" style="font-size:11px;" value="#{semmel002Bean.uploadPermissionFile.totalNo}" reRender="pnlUploadMeter,frmError,pnlExport">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchAll" />
											<a4j:actionparam name="rowIndex" value="#{semmel002Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.passRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" style="font-size:11px;" value="#{semmel002Bean.uploadPermissionFile.successNo}"  reRender="pnlUploadMeter,frmError,pnlExport">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchInCaseSuccess" />
											<a4j:actionparam name="rowIndex" value="#{semmel002Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.failedRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<a4j:commandLink action="#{navAction.navi}" style="font-size:11px;" value="#{semmel002Bean.uploadPermissionFile.failedNo}"  reRender="pnlUploadMeter,frmError,pnlExport">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchInCaseFailed" />
											<a4j:actionparam name="rowIndex" value="#{semmel002Bean.logId}"/>
											</a4j:commandLink>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid>
				<h:panelGrid  width="100%" border="0" cellspacing="4">
				<h:panelGroup id="pnlExport">
					
					<h:commandButton id="btnExport" value="#{jspMsg['btn.exportError']}" style="float:right;" 
								rendered="#{semmel002Bean.renderedExportErrorButton}"
								styleClass="rich-button" action="#{semmel002Action.doExportError}" >
							<f:param name="logId" value="#{semmel002Bean.logId}" ></f:param>
							</h:commandButton>
					
					
					</h:panelGroup>
				
					</h:panelGrid>
				
				<h:panelGrid width="95%" border="0" cellspacing="0">
					
							<rich:panel id="pnlUploadMeter" styleClass="sem_autoScrollbar"  >
							
							<f:facet name="header">
							    	<h:outputText value="#{jspMsg['header.detailData']}"></h:outputText>
							</f:facet>
							<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmel002Bean.msgDataNotFound}" rendered="#{semmel002Bean.renderedMsgDataNotFound}" />
                        </div>				
							<center>				
							<div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
								<rich:dataTable id="dtbUploadMeter"   cellpadding="1" cellspacing="0" border="0"
								var="upload"  value="#{semmel002Bean.uploadElPerList}" 
								reRender="dtbUploadMeter" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.edit']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnOpenPopup" oncomplete="#{rich:component('popupEditPermission')}.show(); return false" 
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="frmError,popupEditPermission,pnlUploadMeter" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchByRowIdForEdit" />
											<a4j:actionparam name="rowIndex" value="#{upload.rowId}"/>
											<a4j:actionparam name="flagPage" value="page3"/>
		            					</a4j:commandButton> 
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.delete']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnDelete"   action="#{navAction.navi}"   reRender="oppContent" 
	            									   image="images/delete.png" style="height: 15; width: 15" 
	            									   oncomplete="#{rich:component('mdpConfirmDelDataDialog')}.show(); return false"
	            									   >
											<a4j:actionparam name="navModule" value="common" />
                                               	<a4j:actionparam name="navModule" value="el" />
				            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
												<a4j:actionparam name="moduleWithNavi" value="el" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
                                                <a4j:actionparam name="methodWithNavi" value="initDelDataByRecord" />
												<a4j:actionparam name="rowLogIdForDel" value="#{semmel002Bean.logId}"/>
												<a4j:actionparam name="rowIndexForDel" value="#{upload.rowId}"/>
		            					</a4j:commandButton> 
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.lineNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.item']}" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{upload.lineNo}"/>
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
								<rich:column sortBy="#{upload.siteName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.siteName']}" style="width: 200px;"/>
									</f:facet>
									<div align="left" style="width: 200px;">
										<h:outputText value="#{upload.siteName}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.locationId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationID']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.locationId}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.siteCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationCode']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.locationCode}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.siteCode}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.siteCode']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.siteCode}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.province}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.province']}" style="width :100px;"/>
									</f:facet>
									<div align="left" style="width :100px;">
										<h:outputText value="#{upload.province}"/>
									</div>
								</rich:column>	
								<rich:column sortBy="#{upload.docType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.docType']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.docType}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.docDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.docDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.docDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.printDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.printDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.printDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.printSeq}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.printSeq']}" />
									</f:facet>
									<div align="right">
										<h:outputText value="#{upload.printSeq}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.reqDtStr}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.reqDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.reqDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.responeDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.responeDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.responeDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.sentDocDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.sendDocDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.sentDocDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.contractCopyDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contracCopyDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.contractCopyDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.sentSamUser}" rendered="false">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.sendSamDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.sentSamDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.sentSamUser}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.sendSamUser']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.sentSamUser}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.sentSamTel}" >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.sendSamTel']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.sentSamTel}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.updateBy}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.updateBy']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.updateBy}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.updateDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.updateDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.updateDtStr}">
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.status}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.status']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.status}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.errMsg}">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['column.result.errMsg']}" style="width :300px;" />
									</f:facet>
									<div align="left" style="width :300px;">
										<h:outputText value="#{upload.errMsg}"/>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmel002Bean.uploadElPerList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="20">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadMeter"
                                            maxPages="#{semmel002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstUploadMeter" 
                                            style="background-color: #cccccc;"
                                            page="#{semmel002Bean.scrollerPage}" 
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
					<h:outputText value="#{semmel002Bean.uploadPermissionFile.failedLine}" styleClass="ms7" />					
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
<a4j:include id="mel002_popUpEdit"  viewId="../../pages/el/semmel002PopUpEdit.jsp" />



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
				            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
												<a4j:actionparam name="moduleWithNavi" value="el" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
					                            <a4j:actionparam name="methodWithNavi" value="doDeleteByRecord" />
												<a4j:actionparam name="rowLogId" value="#{semmel002Bean.logIdFordelete}"/>
												<a4j:actionparam name="rowIndex" value="#{semmel002Bean.rowIdFordelete}"/>
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