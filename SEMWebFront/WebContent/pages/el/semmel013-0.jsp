<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel013" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
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
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="bottom">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td colspan="3" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmel013Bean.company}" onchange="GetCompanyJS();" style="width:180px;">
												<f:selectItems value="#{semmel013Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmel013Bean.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="searchRegion" value="#{semmel013Bean.region}" style="width : 180px">
		                						<f:selectItems value="#{semmel013Bean.regionList}" />
		                						<a4j:support event="onchange" action="#{semmel013Action.doChangeRegion}" reRender="searchProvince" />
		                					</h:selectOneMenu>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="searchProvince" value="#{semmel013Bean.province}" style="width : 180px">
			                					<f:selectItems value="#{semmel013Bean.provinceList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea id="txtContractNo" value="#{semmel013Bean.contractNo}" rows="3" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtSiteName" value="#{semmel013Bean.siteName}" style="width:180px;" maxlength="150" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea id="txtLocationId" value="#{semmel013Bean.locationId}" rows="3" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtLocationName" value="#{semmel013Bean.locationCode}" style="width:180px;" maxlength="150" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.typeUseElectric']}" styleClass="ms7" />
										</td>
									<td width="20%">
											<h:selectOneMenu id="ddlTypeUseElectric" value="#{semmel013Bean.typeUseElectric}"  style="width:180px;">
												<f:selectItems value="#{semmel013Bean.typeUseElectricList}" />
												<a4j:support event="onchange" action="#{semmel013Action.doChangeElectricUseType}" reRender="searchReqType, searchProcessStatus" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="10%">
											<h:outputText value="#{jspMsg['label.statusAction']}" styleClass="ms7" />
										</td>
										<td>
											<a4j:region>
											<h:selectOneMenu id="searchReqType" value="#{semmel013Bean.reqType}" style="width : 200px">
			                					<f:selectItems value="#{semmel013Bean.reqTypeList}" />
			                					<a4j:support event="onchange" action="#{semmel013Action.doChangeElAction}" reRender="searchProcessStatus" />
			                				</h:selectOneMenu>
			                				<rich:spacer width="5"/>
			                				</a4j:region>
			                				
										</td>
									</tr>
									<tr>
										<td colspan="3" align="right" width="20%">
										</td>
										<td align="left" width="20%">
										<h:selectOneMenu id="searchProcessStatus" value="#{semmel013Bean.processStatusCode}" style="width : 200px">
		                						<f:selectItems value="#{semmel013Bean.processStatusNameList}" />
		                					</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtBatchNo" value="#{semmel013Bean.batchNo}" style="width:180px;" maxlength="150" />
										
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.supplier']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText id="txtSupplier" value="#{semmel013Bean.supplier}" style="width:200px;" maxlength="150" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.statusPrint']}" styleClass="ms7" />
										</td>
									<td width="20%">
											<h:selectOneMenu id="ddlStatusPrint" value="#{semmel013Bean.statusPrint}"  style="width:180px;">
												<f:selectItems value="#{semmel013Bean.statusPrintList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadFileDt']}" styleClass="ms7" />
										</td>
										<td align="left" width="20%"><rich:calendar id="cldDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel013Bean.uploadFileDtFrom}"
															showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}" />
											<h:outputText value="#{jspMsg['label.dtTo']}" styleClass="ms7" />				
											<rich:calendar id="cldDtTo" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel013Bean.uploadFileDtTo}"
															showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText id="txtFileName" value="#{semmel013Bean.fileName}" style="width:300px;" maxlength="150" />
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="pnlSearchSiteApprove,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch, dtbSiteApprove">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL013-0" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
								<a4j:actionparam name="methodWithNavi" value="doSearchForFirstPage" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL013-0" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					<h:panelGrid columns="2" id="grdActionCommand" width="95%">
				<h:panelGroup>
						<a4j:commandButton id="btnSearchUpload"  value="#{jspMsg['btn.import']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								rendered="#{semmcp002Bean.renderer['btn.upload']}">
								<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL013-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectSearchUploadPage" />
						</a4j:commandButton>
						&nbsp;
						<a4j:commandButton id="btnUpload"  value="#{jspMsg['btn.upload']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								rendered="#{semmcp002Bean.renderer['btn.upload']}">
								<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL013-2" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectUploadPage" />
							<a4j:actionparam name="flagBtnBack" value="001" />
						</a4j:commandButton>
				</h:panelGroup>
				</h:panelGrid>
				<!-- ShowReport Panel -->
                <h:panelGrid id="show_report" style="height:0px;width:0px;" width="0" columns="0">
                    <h:panelGroup id="show_report_in" rendered="#{semmel013Bean.displayBtn}" style="height:0px;width:0px;" >
                        <h:commandButton value="Report" id="btnExportExcel"  style="height:0px;width:0px;display:none;" action="#{semmel013Action.doPrintOut}" >
                         <script>document.getElementById('incContent:frmSearch:btnExportExcel').click();</script>
                        </h:commandButton>
                    </h:panelGroup>                         
                </h:panelGrid>
                <!-- End Code -->
				</a4j:form>
			</h:panelGrid>
			<!-- +++++++++++++++++ end content layout criteria +++++++++++++++++ -->
			
			<!-- +++++++++++++++++ start search result +++++++++++++++++ -->
			<a4j:form id="frmResult">
			
				
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmel013Bean.msgDataNotFoundFirstPage}" rendered="#{semmel013Bean.renderedMsgDataNotFoundFirstPage}" />
                        </div>
                        <div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="upload" value="#{semmel013Bean.uploadFileListForFirstPage}"
							reRender="dtbSiteApprove" rows="#{semmel013Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.printHd']}"/>
									</f:facet>
									<div align="center"  >
		            					 <a4j:commandButton id="btnPrint" action="#{navAction.navi}"
					                        styleClass="rich-button"  value="#{jspMsg['column.result.print']}" 
					                        rendered="#{upload.status == 'Success'}" style="width: 150px"
					                        reRender="frmSearch,pnlSearchResult,dtbSiteApprove,frmError,show_report">
					                        <a4j:actionparam name="navModule" value="el" />
                                            <a4j:actionparam name="navProgram" value="SEMMEL013-0" />
                                            <a4j:actionparam name="moduleWithNavi" value="el" />
                                            <a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
                                            <a4j:actionparam name="methodWithNavi" value="doGenBatch" />
                                            <a4j:actionparam name="rowIndex" value="#{upload.rowId}" />
                                            <a4j:actionparam name="flagPrint" value="Page1" />
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
	            									   reRender="frmError,popupProxyEditPermission" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL013-0" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL013" />
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
										<h:outputText value="#{jspMsg['column.result.areaNamestation']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
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
										<h:outputText value="#{jspMsg['column.result.areaType']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.areaType}" />
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.address}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.address']}" style="width :150px;"/>
									</f:facet>
									<div align="left" style="width :150px;">
										<h:outputText value="#{upload.address}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.tumbon}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.tumbon']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.tumbon}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.amphur}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.amphur']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.amphur}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.province}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.province']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.province}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.batchNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.batchNo']}" style="width :200px;"/>
									</f:facet>
									<div align="left" style="width :200px;">
										<h:outputText value="#{upload.batchNo}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.supplier}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.supplier']}" style="width :200px;"/>
									</f:facet>
									<div align="left" style="width :200px;">
										<h:outputText value="#{upload.supplier}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.electricType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.electricType']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.typeUseElectric}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.statusContract}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.statusContract']}" style="width :100px;"/>
									</f:facet>
									<div align="left" style="width :100px;">
										<h:outputText value="#{upload.statusContract}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.printFlag}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.state']}" style="width :100px;"/>
									</f:facet>
									<div align="left" style="width :100px;">
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
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmel013Bean.uploadFileListForFirstPage)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="15">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove"
                                            maxPages="#{semmel013Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteApprove" 
                                            style="background-color: #cccccc;"
                                            page="#{semmel013Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                               </f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
						</div>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<a4j:include id="mel013_popUpEditProxy"  viewId="../../pages/el/semmel013PopUpEdit.jsp" />