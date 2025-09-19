<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.construction.semmcp002" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.cp.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" >
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<!-- +++++++++++++++++ begin content layout criteria +++++++++++++++++ -->
			<h:panelGrid width="100%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.cp.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="bottom">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.cp.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td colspan="3" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmcp002Bean.company}" onchange="GetCompanyJS();" style="width:180px;">
												<f:selectItems value="#{semmcp002Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmcp002Bean.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.cp.region']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="searchRegion" value="#{semmcp002Bean.region}" style="width : 180px">
		                						<f:selectItems value="#{semmcp002Bean.regionList}" />
		                						<a4j:support event="onchange" action="#{semmcp002Action.doChangeRegion}" reRender="searchProvince" />
		                					</h:selectOneMenu>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.cp.province']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="searchProvince" value="#{semmcp002Bean.province}" style="width : 180px">
			                					<f:selectItems value="#{semmcp002Bean.provinceList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.contractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea id="txtContractNo" value="#{semmcp002Bean.contractNo}" rows="3" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.siteName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtSiteName" value="#{semmcp002Bean.siteName}" style="width:180px;" maxlength="150" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.locationId']}" styleClass="ms7" />
										</td>
										
										<td width="30%">
											<h:inputTextarea id="txtLocationId" value="#{semmcp002Bean.locationId}" rows="3" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.locationCode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtLocationName" value="#{semmcp002Bean.locationCode}" style="width:180px;" maxlength="50" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.supplier']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtSuplier" value="#{semmcp002Bean.supplier}" style="width:180px;" maxlength="50" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.statusPrint']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="ddlStatusPrint" value="#{semmcp002Bean.statusPrint}"  style="width:180px;">
												<f:selectItems value="#{semmcp002Bean.statusPrintList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.cp.uploadFileDt']}" styleClass="ms7" />
										</td>
										<td align="left" width="20%"><rich:calendar id="cldDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmcp002Bean.uploadFileDtFrom}"
					                                       showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}"
					                                       />
															&nbsp;	
											<h:outputText value="#{jspMsg['label.cp.dtTo']}" styleClass="ms7" />
											&nbsp;					
											<rich:calendar id="cldDtTo" locale="th/TH" enableManualInput="true"
																datePattern="dd/MM/yyyy" value="#{semmcp002Bean.uploadFileDtTo}"
					                                       showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}"
					                                       />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText id="txtFileName" value="#{semmcp002Bean.fileName}" style="width:300px;" maxlength="150" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.cp.search']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="pnlSearchSiteApprove,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch, dtbSiteApprove">
								<a4j:actionparam name="navModule" value="cp" />
								<a4j:actionparam name="navProgram" value="SEMMCP002-0" />
								<a4j:actionparam name="moduleWithNavi" value="cp" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
								<a4j:actionparam name="methodWithNavi" value="doSearchForFirstPage" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.ClearBtn']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="cp" />
								<a4j:actionparam name="navProgram" value="SEMMCP002-0" />
								<a4j:actionparam name="moduleWithNavi" value="cp" />
								<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					<h:panelGrid columns="2" id="grdActionCommand" width="95%">
				<h:panelGroup>
					<a4j:commandButton id="btnSearchUpload"  value="#{jspMsg['btn.cp.import']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								rendered="#{semmcp002Bean.renderer['btn.upload']}">
								<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP002-1" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectSearchUploadPage" />
						</a4j:commandButton>
						&nbsp;
					<a4j:commandButton id="btnUpload"  value="#{jspMsg['btn.cp.upload']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								rendered="#{semmcp002Bean.renderer['btn.upload']}">
								<a4j:actionparam name="navModule" value="cp" />
							<a4j:actionparam name="navProgram" value="SEMMCP002-2" />
							<a4j:actionparam name="moduleWithNavi" value="cp" />
							<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectUploadPage" />
							<a4j:actionparam name="flagBtnBack" value="001" />
						</a4j:commandButton>
				</h:panelGroup>
				</h:panelGrid>
				</a4j:form>
			</h:panelGrid>
			<!-- +++++++++++++++++ end content layout criteria +++++++++++++++++ -->
			
			<!-- +++++++++++++++++ start search result +++++++++++++++++ -->
			<a4j:form id="frmResult">
			
				<h:panelGrid id="pnlShowReportDoc" style="height:0px;width:0px;" width="0px" columns="0" >
                    <h:panelGroup id="pnlInShowReport" rendered="#{semmcp002Bean.showReport}" style="height:0px;width:0px;" >
                        <h:commandButton value="Report" id="btnShowReport" style="height:0px;width:0px;display:none;" action="#{semmcp002Action.doDownloadContractFile}">
                        <script>document.getElementById('incContent:frmResult:btnShowReport').click();</script>
                        </h:commandButton>                              
                    </h:panelGroup>                         
                </h:panelGrid>
                
				
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.cp.resultTable.name']}"/>
						</f:facet>
						<!-- begin dataTable -->
						<center>
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmcp002Bean.msgDataNotFoundFirstPage}" rendered="#{semmcp002Bean.renderedMsgDataNotFoundFirstPage}" />
                        </div>
						<div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="upload" value="#{semmcp002Bean.uploadFileListForFirstPage}"
							reRender="dtbSiteApprove" rows="#{semmcp002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.printHeader']}" />
									</f:facet>
									<div align="center">
		            					
										<a4j:commandButton id="btnPrint"
				                                action="#{navAction.navi}"
				                                reRender="oppContent"
				                                rendered="true"
				                                value="#{jspMsg['column.result.print']}" styleClass="rich-button" style="width:150px"  >
				                                <a4j:actionparam name="navModule" value="cp" />
				                                <a4j:actionparam name="navProgram" value="SEMMCP002-0" />
				                                <a4j:actionparam name="moduleWithNavi" value="cp" />
				                                <a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
				                                <a4j:actionparam name="methodWithNavi" value="doRunReport" />
				                                <a4j:actionparam name="rowId" value="#{upload.rowId}" />
				                                <a4j:actionparam name="flagPrint" value="Page1" />
				                                <a4j:support event="oncomplete" reRender="frmError,frmResult,pnlShowReportDoc" />
				                            </a4j:commandButton>
									</div>
								</rich:column>
								<rich:column >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.edit']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnOpenPopup" oncomplete="#{rich:component('popupEditImportWarrantConStruc')}.show(); return false" 
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="frmError,popupEditImportWarrantConStruc" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="cp" />
			            					<a4j:actionparam name="navProgram" value="SEMMCP002-0" />	
											<a4j:actionparam name="moduleWithNavi" value="cp" />
											<a4j:actionparam name="actionWithNavi" value="SEMMCP002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchByRowIdForEdit" />
											<a4j:actionparam name="rowIndex" value="#{upload.rowId}"/>
											<a4j:actionparam name="flagPage" value="page0"/>
		            					</a4j:commandButton> 
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
										<h:outputText value="#{jspMsg['column.result.areaNamestation']}" style="width: 200px;"/>
									</f:facet>
									<div align="left" style="width: 200px;">
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
										<h:outputText value="#{jspMsg['column.result.areaType']}" style="width: 200px;"/>
									</f:facet>
									<div align="left" style="width: 200px;">
										<h:outputText value="#{upload.areaType}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.address}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.address']}"  style="width :200px;" />
									</f:facet>
									<div align="left"  style="width :200px;" >
										<h:outputText value="#{upload.address}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.tumbon}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.tumbon']}" style="width: 120px;" />
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
								<rich:column sortBy="#{upload.supplier}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.supplier']}" style="width: 200px;"/>
									</f:facet>
									<div align="left" style="width: 200px">
										<h:outputText value="#{upload.supplier}"/>
									</div>
								</rich:column>
								
								<rich:column sortBy="#{upload.printFlag}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.state']}" style="width :100px;" />
									</f:facet>
									<div align="left"  style="width :200px;">
										<h:outputText value="#{upload.printFlag}"/>
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
								<rich:column sortBy="#{upload.statusContract}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.statusContract']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.statusContract}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.fileName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.fileName']}"  style="width :150px;" />
									</f:facet>
									<div align="left"  style="width :150px;" >
										<h:outputText value="#{upload.fileName}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.importFileDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.importDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.importFileDtStr}">
										</h:outputText>
									</div>
								</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmcp002Bean.uploadFileListForFirstPage)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="15">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove"
                                            maxPages="#{semmcp002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteApprove" 
                                            style="background-color: #cccccc;"
                                            page="#{semmcp002Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						</div>
						</center>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:include id="mcp02_popUpEdit1"  viewId="../../pages/cp/semmcp002PopUpEdit.jsp" />