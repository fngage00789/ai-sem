<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel003" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.uploadMeterInformation']}" />
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
											<h:selectOneMenu id="ddlCompany" value="#{semmel003Bean.company}" onchange="GetCompanyJS();" style="width:180px;">
												<f:selectItems value="#{semmel003Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmel003Bean.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="searchRegion" value="#{semmel003Bean.region}" style="width : 180px">
		                						<f:selectItems value="#{semmel003Bean.regionList}" />
		                						<a4j:support event="onchange" action="#{semmel003Action.doChangeRegion}" reRender="searchProvince" />
		                					</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="searchProvince" value="#{semmel003Bean.province}" style="width : 180px">
			                					<f:selectItems value="#{semmel003Bean.provinceList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:inputTextarea id="txtContractNo" value="#{semmel003Bean.contractNo}" rows="3" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtSiteName" value="#{semmel003Bean.siteName}" style="width:180px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:inputTextarea id="txtLocationId" value="#{semmel003Bean.locationId}" rows="3" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtLocationName" value="#{semmel003Bean.locationCode}" style="width:180px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.typeUseElectric']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<a4j:region>
												<h:selectOneMenu id="ddlTypeUseElectric" value="#{semmel003Bean.typeUseElectric}"  style="width:180px;">
													<f:selectItems value="#{semmel003Bean.typeUseElectricList}" />
													<a4j:support event="onchange" action="#{semmel003Action.doChangeElectricUseType}" reRender="searchReqType, searchProcessStatus" />
												</h:selectOneMenu>
												
											</a4j:region>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:inputText id="txtMeterId" value="#{semmel003Bean.meterId}" style="width:180px;" maxlength="100" />
										</td>
										
									</tr>
									<tr>
										<td align="right" width="10%">
											<h:outputText value="#{jspMsg['label.statusAction']}" styleClass="ms7" />
										</td>
										<td>
											<a4j:region>
											<h:selectOneMenu id="searchReqType" value="#{semmel003Bean.reqType}" style="width : 200px">
			                					<f:selectItems value="#{semmel003Bean.reqTypeList}" />
			                					<a4j:support event="onchange" action="#{semmel003Action.doChangeElAction}" reRender="searchProcessStatus" />
			                				</h:selectOneMenu>
			                				<rich:spacer width="5"/>
			                				</a4j:region>
			                				
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.supplier']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtSupplier" value="#{semmel003Bean.supplier}" style="width:180px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
										</td>
										<td width="20%">
											<h:selectOneMenu id="searchProcessStatus" value="#{semmel003Bean.processStatusCode}" 
											style="width : 200px">
		                						<f:selectItems value="#{semmel003Bean.processStatusNameList}" />
		                					</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtBatch" value="#{semmel003Bean.batchNo}" style="width:180px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadFileDt']}" styleClass="ms7" />
										</td>
										<td align="left" width="20%"><rich:calendar id="cldDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel003Bean.uploadFileDtFrom}"
															showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}"/>
															&nbsp;
											<h:outputText value="#{jspMsg['label.dtTo']}" styleClass="ms7" />	
											&nbsp;			
											<rich:calendar id="cldDtTo" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel003Bean.uploadFileDtTo}"
															showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<h:inputText id="txtFileName" value="#{semmel003Bean.fileName}" style="width:300px;" maxlength="100" />
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
								<a4j:actionparam name="navProgram" value="SEMMEL003-0" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
								<a4j:actionparam name="methodWithNavi" value="doSearchForFirstPage" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL003-0" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
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
							<a4j:actionparam name="navProgram" value="SEMMEL003-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectSearchUploadPage" />
						</a4j:commandButton>
						&nbsp;
						<a4j:commandButton id="btnUpload"  value="#{jspMsg['btn.upload']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								rendered="#{semmcp002Bean.renderer['btn.upload']}">
								<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL003-2" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
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
			
				
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmel003Bean.msgDataNotFoundFirstPage}" rendered="#{semmel003Bean.renderedMsgDataNotFoundFirstPage}" />
                        </div>
                        <div style="width:1250px; overflow:scroll; border:1px solid e0e0e0;">
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="upload" value="#{semmel003Bean.uploadFileListForFirstPage}"
							reRender="dtbSiteApprove" rows="#{semmel003Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.edit']}" />
									</f:facet>
									<div align="center">
					                   	 	<a4j:commandButton id="btnOpenPopup" oncomplete="#{rich:component('popupEditMeterData')}.show(); return false" 
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="frmError,popupEditMeterData" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL003-0" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
											<a4j:actionparam name="methodWithNavi" value="doSearchByRowIdForEdit" />
											<a4j:actionparam name="rowIndex" value="#{upload.rowId}"/>
											<a4j:actionparam name="flagPage" value="page1"/>
		            					</a4j:commandButton> 
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.contractNo}" title="#{upload.contractNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contractNo']}" />
									</f:facet>
									<div align="center">
										<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{upload.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL003-0" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{upload.siteInfoId}" />
											
										</a4j:commandLink>
									</div>
								</rich:column>
								
								<rich:column sortBy="#{upload.company}" title="#{upload.company}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.company']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.company}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.locationId}" title="#{upload.locationId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationId']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.locationId}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.siteName}" title="#{upload.siteName}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaNamestation']}" style="width :200px;"/>
									</f:facet>
									<div align="left" style="width :200px;">
										<h:outputText value="#{upload.siteName}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.ctStartDtStr}" title="#{upload.ctStartDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.startDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.ctStartDtStr}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.ctFinishDtStr}" title="#{upload.ctFinishDtStr}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.finishDate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{upload.ctFinishDtStr}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								
								<rich:column sortBy="#{upload.amphur}" title="#{upload.amphur}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.region']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.amphur}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.province}" title="#{upload.province}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.province']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.province}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.supplier}" title="#{upload.supplier}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.supplier']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.supplier}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.electricType}" title="#{upload.electricType}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.electricType']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.electricType}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.meterId}" title="#{upload.meterId}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.meterId']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.meterId}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.statusContract}" title="#{upload.statusContract}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.statusContract']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.statusContract}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.batchNo}" title="#{upload.batchNo}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.batch']}" style="width :120px;"/>
									</f:facet>
									<div align="left" style="width :120px;">
										<h:outputText value="#{upload.batchNo}"/>
									</div>
								</rich:column>
								<rich:column sortBy="#{upload.state}" title="#{upload.state}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.state']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{upload.state}"/>
									</div>
								</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmel003Bean.uploadFileListForFirstPage)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="11">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove"
                                            maxPages="#{semmel003Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteApprove" 
                                            style="background-color: #cccccc;"
                                            page="#{semmel003Bean.scrollerPage}" 
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
<a4j:include id="mel003_popUpEdit"  viewId="../../pages/el/semmel003PopUpEdit.jsp" />
<a4j:include id="mel0030_popViewSiteInfo"  viewId="../../pages/popup/editDetailpopup.jsp" />