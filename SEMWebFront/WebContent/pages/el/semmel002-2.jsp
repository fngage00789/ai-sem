<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel002" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name2']}" />
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
		<h:panelGrid columns="4" id="grdSearchCommand2" width="98%">
			<a4j:form id="frmBack">
			<div align="right">
						<a4j:commandButton id="btnImport"  value="#{jspMsg['btn.back']}" action="#{navAction.navi}" 
							styleClass="rich-button" reRender="oppContent"
							rendered="#{semmel002Bean.renderer['btnImport']}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL002-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
							<a4j:actionparam name="methodWithNavi" value="dobackToFirstPage" />
						</a4j:commandButton>
			
			</div>
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
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="bottom">
											<h:panelGroup>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td  valign="bottom" width="20%">
											<h:selectOneMenu id="ddlCompany" value="#{semmel002Bean.companyPage2}" onchange="GetCompanyJS();" style="width:180px;">
												<f:selectItems value="#{semmel002Bean.companyListPage2}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmel002Bean.companyPage2}" styleClass="ms28" />
										</td>
										<td align="right" width="20%">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<h:selectOneMenu id="searchRegion" value="#{semmel002Bean.regionPage2}" style="width : 180px">
		                						<f:selectItems value="#{semmel002Bean.regionListPage2}" />
		                					</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.typeUseElectric']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="ddlTypeUseElectric" value="#{semmel002Bean.typeUseElectricPage2}"  style="width:180px;">
												<f:selectItems value="#{semmel002Bean.typeUseElectricListPage2}" />
												<a4j:support event="onchange" action="#{semmel002Action.doChangeElectricUseTypePage2}" reRender="searchReqType, searchProcessStatus" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.statusAction']}" styleClass="ms7" />
										</td>
										<td width="40%">
											<a4j:region>
											<h:selectOneMenu id="searchReqType" value="#{semmel002Bean.reqTypePage2}" style="width : 200px">
			                					<f:selectItems value="#{semmel002Bean.reqTypeListPage2}" />
			                					<a4j:support event="onchange" action="#{semmel002Action.doChangeElActionPage2}" reRender="searchProcessStatus" />
			                				</h:selectOneMenu>
			                				<rich:spacer width="5"/>
			                				</a4j:region>
			                				
										</td>
									</tr>
									<tr>
									<td align="right" width="20%" colspan="3"></td>
									<td align="left" width="20%">
											<h:selectOneMenu id="searchProcessStatus" value="#{semmel002Bean.processStatusCodePage2}" 
											style="width : 200px">
		                						<f:selectItems value="#{semmel002Bean.processStatusNameListPage2}" />
		                					</h:selectOneMenu>
		                					</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadFileDt']}" styleClass="ms7" />
										</td>
										<td align="left" width="20%"><rich:calendar id="cldDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.uploadFileDtFromPage2}"
															showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldDtFrom','cldDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.upDate']}" />
															&nbsp;
											<h:outputText value="#{jspMsg['label.dtTo']}" styleClass="ms7" />	
											&nbsp;			
											<rich:calendar id="cldDtTo" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.uploadFileDtToPage2}"
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
											<h:inputText id="txtFileName" value="#{semmel002Bean.fileNamePage2}" style="width:300px;" maxlength="150" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="pnlSearchSiteApprove,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL002-2" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
								<a4j:actionparam name="methodWithNavi" value="doSearchUploadFile" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL002-2" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
								<a4j:actionparam name="methodWithNavi" value="doClearPage2" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					<h:panelGrid columns="2" id="grdRedirectCommand" width="95%">
						<h:panelGroup>
							
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
                            <h:outputLabel style="color:red;size:20px" value="#{semmel002Bean.msgDataNotFoundSecondPage}" rendered="#{semmel002Bean.renderedMsgDataNotFoundSecondPage}" />
                        </div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="warrantDetail" value="#{semmel002Bean.uploadFileList}"
							reRender="dtbSiteApprove" rows="#{semmel002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.edit']}" />
									</f:facet>
									<div align="center">
		            					
										<a4j:commandButton id="btnEdit"   action="#{navAction.navi}"   reRender="oppContent" 
	            									   image="images/edit.png" style="height: 15; width: 15" >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doView" />
											<a4j:actionparam name="rowIndex" value="#{warrantDetail.rowId}"/>
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
	            									   rendered="#{warrantDetail.recordTotal!=warrantDetail.recordSuccess}"
	            									    oncomplete="#{rich:component('mdpConfirmDelDataDialogPage2')}.show(); return false"
	            									   >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="initDelData" />
											<a4j:actionparam name="rowLogIdForDel" value="#{warrantDetail.rowId}"/>
		            					</a4j:commandButton> 
									</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.company}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" style="width: 50" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.company}" /></div>
							</rich:column>				
							<rich:column sortBy="#{warrantDetail.fileName}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.fileName']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.fileName}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.recordTotal}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allRecord']}" style="width: 10" />
								</f:facet>
								<div align="center">
								
								
								
								<a4j:commandLink action="#{navAction.navi}"  reRender="oppContent" value="#{warrantDetail.recordTotal}">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchFromDtb" />
											<a4j:actionparam name="rowIndexDtb" value="#{warrantDetail.rowId}"/>
											<a4j:actionparam name="type" value="A" />
											</a4j:commandLink>
								
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.recordSuccess}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allSuccess']}" style="width: 10" />
								</f:facet>
								<div align="center">
								<a4j:commandLink action="#{navAction.navi}"  reRender="oppContent" value="#{warrantDetail.recordSuccess}">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchFromDtb" />
											<a4j:actionparam name="type" value="S" />
											<a4j:actionparam name="rowIndexDtb" value="#{warrantDetail.rowId}"/>
											</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.recordfail}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.allFailed']}" style="width: 10" />
								</f:facet>
								<div align="center">
								
								<a4j:commandLink action="#{navAction.navi}"  reRender="oppContent" value="#{warrantDetail.recordfail}"  >
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL002-3" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
											<a4j:actionparam name="methodWithNavi" value="doSearchFromDtb" />
											<a4j:actionparam name="type" value="E" />
											<a4j:actionparam name="rowIndexDtb" value="#{warrantDetail.rowId}"/>
											</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.updateBy}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateBy']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.uploadBy}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.updateDt}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateDate']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.uploadDtStr}" >
								</h:outputText></div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmel002Bean.uploadFileList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="6">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove"
                                            maxPages="#{semmel002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteApprove" 
                                            style="background-color: #cccccc;"
                                            page="#{semmel002Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpUpdateStatus" autosized="true" >	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['popup.header.updateStatusWarrant']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmGroupReceiveDialog">
		
		<table width="200px" border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td colspan="6">
					<h:panelGrid id="messagePopupUpdateStatus">
						<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="center">
					<rich:dataTable id="dtbGroupReceivePopup" width="95%" cellpadding="1" cellspacing="0" border="0" 
						var="warrantDetail" value="#{semmel002Bean.popupWarrantDetailSPList}" 
						reRender="dtbMeterInfoPopup" 
						rows="5"
					     
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
						styleClass="contentform" >
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.contractNo']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.contractNo}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.siteName']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.siteName}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.warrantType']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.warrantType}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.sentSighDt']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.sentSignDtStr}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.signDt']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.signDtStr}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.sentWarrantDt']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.sentWarrantDtStr}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.sentContractDt']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.sentContractDtStr}"/>
							</div>
						</rich:column>						
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['popup.column.sentSamuserDt']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.sentSamuserDtStr}"/>
							</div>
						</rich:column>
						<f:facet name="footer">
							<rich:datascroller immediate="true" rendered="true"
								align="center" for="dtbGroupReceivePopup" maxPages="10"
								id="dtbGroupReceivePopupPaging" selectedStyleClass="selectScroll" />
						</f:facet>
					</rich:dataTable>
				</td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="6">&nbsp;</td>
			</tr>
			<tr>
				<td width="20%" align="right">
					<h:outputText value="#{jspMsg['popup.label.sentSighDt']}" styleClass="ms7"/></td>
				<td width="15%"><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSentSighDt}" disabled="#{semmel002Bean.disablePopupSentSighDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '01'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/>
				</td>
				<td width="15%" align="right">
					<h:outputText value="#{jspMsg['popup.label.sighDt']}" styleClass="ms7"/></td>
				<td width="15%"><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSighDt}" disabled="#{semmel002Bean.disablePopupSighDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '02'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/></td>
				<td width="20%" align="right">
					<h:outputText value="#{jspMsg['popup.label.sentWarrantDt']}" styleClass="ms7"/></td>
				<td><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSentWarrantDt}" disabled="#{semmel002Bean.disablePopupSentWarrantDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '03'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/></td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['popup.label.sentContractDt']}" styleClass="ms7"/></td>
				<td><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSentContractDt}" disabled="#{semmel002Bean.disablePopupSentContractDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '04'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/>
				</td>
				<td align="right">
					<h:outputText value="#{jspMsg['popup.label.sentSamuserDt']}" styleClass="ms7"/></td>
				<td><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSentSamuserDt}" disabled="#{semmel002Bean.disablePopupSentSamuserDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '05'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				
			</tr>
			<tr>
				<td align="right" valign="top">
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['popup.label.samuserName']}" styleClass="ms7"/></td>
				<td valign="top"><rich:spacer width="5"/>
					<h:inputText value="#{semmel002Bean.popupSamUsername}" /></td>
				<td align="right" valign="top">
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['popup.label.samuserPhone']}" styleClass="ms7"/></td>
				<td valign="top"><rich:spacer width="5"/>
					<h:inputText value="#{semmel002Bean.popupSamuserPhone}" /></td>
				<td align="right" valign="top">
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['popup.label.remark']}" styleClass="ms7"/></td>		
				<td>
					<rich:spacer width="5"/>
					<h:inputTextarea id="txtRemarkPopup" value="#{semmel002Bean.popupRemark}" rows="3" cols="30"/></td>				
			</tr>
			<tr>
				<td colspan="6"><rich:spacer width="10"/></td>
			</tr>
			<tr>
				<td colspan="6">
					<a4j:commandButton value="#{jspMsg['popup.btn.save']}" styleClass="rich-button" oncomplete="#{!semmel002Bean.displayPopupUpdateStatus?'hideUpdateStatus();' : ''}" action="#{semmel002Action.doUpdateStatusWarrant}" reRender="messagePopupUpdateStatus, dtbSiteApprove"/>
					<rich:spacer width="10"/>
					<a4j:commandButton value="#{jspMsg['popup.btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
					    <rich:componentControl for="mdpUpdateStatus" operation="hide" event="onclick"/>
					</a4j:commandButton>
				</td>
			</tr>
		</table>
	
	</a4j:form>
	
</rich:modalPanel>


<rich:modalPanel id="mdpConfirmDelDataDialogPage2" autosized="true">   
    <f:facet name="header">
        <h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
    <a4j:form id="frmConfirmDelDataDialogPage2">
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
				            					<a4j:actionparam name="navProgram" value="SEMMEL002-2" />	
												<a4j:actionparam name="moduleWithNavi" value="el" />
                                                <a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
					                            <a4j:actionparam name="methodWithNavi" value="doDelete" />
					                            <a4j:actionparam name="rowIndex" value="#{semmel002Bean.rowIdFordelete}"/>
					         <rich:componentControl for="mdpConfirmDelDataDialogPage2" operation="hide" event="onclick"  />
                        </a4j:commandButton>                                                
                        <a4j:commandButton value="No" styleClass="rich-button" immediate="true">
                            <rich:componentControl for="mdpConfirmDelDataDialogPage2" operation="hide" event="onclick" />
                        </a4j:commandButton>
                    </h:panelGrid>
                </td>
            </tr>
        </table>    
    </a4j:form>
</rich:modalPanel>