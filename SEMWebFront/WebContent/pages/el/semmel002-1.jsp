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
												<h:graphicImage value="images/icon_required.gif" />
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td colspan="3" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmel002Bean.company}" onchange="GetCompanyJS();" style="width:180px;">
												<f:selectItems value="#{semmel002Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer> 
											<h:outputText id="companyDisplay" value="#{semmel002Bean.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td width="20%">
											<h:selectOneMenu id="searchRegion" value="#{semmel002Bean.region}" style="width : 180px">
		                						<f:selectItems value="#{semmel002Bean.regionList}" />
		                						<a4j:support event="onchange" action="#{semmel002Action.doChangeRegion}" reRender="searchProvince" />
		                					</h:selectOneMenu>
										</td>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="searchProvince" value="#{semmel002Bean.province}" style="width : 180px">
			                					<f:selectItems value="#{semmel002Bean.provinceList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea id="txtContractNo" value="#{semmel002Bean.contractNo}" rows="3" />
										</td>
										<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtSiteName" value="#{semmel002Bean.siteName}" style="width:180px;" maxlength="150" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputTextarea id="txtLocationId" value="#{semmel002Bean.locationId}" rows="3" />
										</td>
										<td align="right" width="20%">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
                                    <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtLocationName" value="#{semmel002Bean.locationCode}" style="width:180px;" maxlength="150" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.warrantType']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="ddlWarrantType" value="#{semmel002Bean.warrantType}" style="width:220px;">
												<f:selectItems value="#{semmel002Bean.warrantTypeList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.exportFlag']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="ddlExportFlag" value="#{semmel002Bean.exportFlag}" style="width:180px;">
												<f:selectItems value="#{semmel002Bean.exportFlagList}" />
											</h:selectOneMenu>
											&nbsp;											
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.warrantStatus']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="ddlWarrantStatus" value="#{semmel002Bean.warrantStatus}" style="width:220px;">
												<f:selectItems value="#{semmel002Bean.warrantStatusList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.printDt']}" styleClass="ms7" /></td>
										<td><rich:calendar id="cldUploadMeterDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.printDtFrom}"
															  showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.UploadMeterDt']}"/>
															<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
														<rich:calendar id="cldUploadMeterDtTo"
															locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.printDtTo}"
															  showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.UploadMeterDt']}"/></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.sighDt']}" styleClass="ms7" /></td>
										<td><rich:calendar id="cldSighDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.sighDtFrom}"
															  showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldSighDtFrom','cldSighDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldSighDtFrom','cldSighDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.sighDt']}" />
															<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
														<rich:calendar id="cldSighDtTo"
															locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.sighDtTo}"
															  showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldSighDtFrom','cldSighDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldSighDtFrom','cldSighDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.sighDt']}" /></td>
					                	<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.sentWarrantDt']}" styleClass="ms7" />
										</td>
										<td><rich:calendar id="cldSentWarrantDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.sentWarrantDtFrom}"
														  showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldSentWarrantDtFrom','cldSentWarrantDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldSentWarrantDtFrom','cldSentWarrantDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.sentWarrantDt']}" />
															<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
														<rich:calendar id="cldSentWarrantDtTo"
															locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.sentWarrantDtTo}"
															 showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldSentWarrantDtFrom','cldSentWarrantDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldSentWarrantDtFrom','cldSentWarrantDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.sentWarrantDt']}" /></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.sentContractDt']}" styleClass="ms7" /></td>
										<td><rich:calendar id="cldSentContractDtFrom" locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.sentContractDtFrom}"
															 showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldSentContractDtFrom','cldSentContractDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldSentContractDtFrom','cldSentContractDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.SentContractDt']}" />
															<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
														<rich:calendar id="cldSentContractDtTo"
															locale="th/TH" enableManualInput="true"
															datePattern="dd/MM/yyyy" value="#{semmel002Bean.sentContractDtTo}"
																 showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldSentContractDtFrom','cldSentContractDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldSentContractDtFrom','cldSentContractDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.SentContractDt']}"/></td>
					                                       
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.compleateDt']}" styleClass="ms7" /></td>
										<td><rich:calendar id="cldCompleateDtFrom"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel002Bean.compleateDtFrom}"
												 showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldCompleateDtFrom','cldCompleateDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldCompleateDtFrom','cldCompleateDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.compleateDt']}" />
												<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
												<rich:calendar id="cldCompleateDtTo"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel002Bean.compleateDtTo}" showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldCompleateDtFrom','cldCompleateDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldCompleateDtFrom','cldCompleateDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.compleateDt']}" /></td>
									</tr>
									<tr>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.exportDt']}" styleClass="ms7" /></td>
										<td width="30%"><rich:calendar id="cldExportDtFrom"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel002Bean.exportDtFrom}"
												showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldExportDtFrom','cldExportDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldExportDtFrom','cldExportDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.exportDt']}"  />
												<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
												<rich:calendar id="cldExportDtTo"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel002Bean.exportDtTo}" showWeeksBar="false" 
					                                       inputSize="13" 
					                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
					                                       cellWidth="20px" cellHeight="20px"
					                                       oninputblur="validateRichCalendarFromTo('frmSearch','cldExportDtFrom','cldExportDtTo');"
					                                       oncollapse="validateRichCalendarFromTo('frmSearch','cldExportDtFrom','cldExportDtTo');" 
					                                       inputStyle="width:70px;" 
					                                       label="#{jspMsg['column.header.exportDt']}"  /></td>
										<td align="right" width="20%">&nbsp;</td>
										<td><h:selectBooleanCheckbox id="maxPrintTimesSelected" value="#{semmel002Bean.maxPrintTimes}" />
											<h:outputText value="#{jspMsg['label.maxPrintTimes']}" styleClass="ms7" /></td>
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
								<a4j:actionparam name="navProgram" value="SEMMEL002-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,pnlSearchResult">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL002-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					<h:panelGrid columns="2" id="grdActionCommand" width="95%">
				<h:panelGroup>
					<h:commandButton id="btnExport" action="#{semmel002Action.doExportExcel}" styleClass="rich-button"
						value="#{jspMsg['btn.export']}" disabled="#{semmel002Bean.disabledBtnExport}" 
						rendered="#{semmel002Bean.renderer['btnExport']}"/>
					&nbsp;
					<a4j:commandButton id="btnUpdateStatus" value="#{jspMsg['btn.groupReceive']}" styleClass="rich-button" 
						action="#{navAction.navi}" oncomplete="#{'showGroupReceivePopup();'}" style="width: 170px"
						 disabled="#{semmel002Bean.disabledBtnUpdateStatusWarrant}" reRender="oppContent"
						 rendered="#{semmel002Bean.renderer['btnUpdateStatus']}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL002-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
						<a4j:actionparam name="methodWithNavi" value="doInitPopupUpdateStatusWarrant" />
					</a4j:commandButton>
					
					<a4j:commandButton id="btnSearchUpload"  value="#{jspMsg['btn.import']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								rendered="false">
								<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL002-2" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectSearchUploadPage" />
						</a4j:commandButton>
						&nbsp;
						<a4j:commandButton id="btnUpload"  value="#{jspMsg['btn.upload']}" action="#{navAction.navi}" 
								styleClass="rich-button" reRender="oppContent"
								>
								<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL002-3" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL002" />
							<a4j:actionparam name="methodWithNavi" value="doRedirectUploadPage" />
							<a4j:actionparam name="flagBtnBack" value="001" />
						</a4j:commandButton>
					<a4j:jsFunction name="showGroupReceivePopup" reRender="mdpUpdateStatus" oncomplete="#{rich:component('mdpUpdateStatus')}.show(); return false"/>
					<a4j:jsFunction name="hideUpdateStatus" oncomplete="#{rich:component('mdpUpdateStatus')}.hide(); return false"/>
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
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width:2300px;"/>
						</f:facet>
								
						<div align="center">
                            <h:outputLabel style="color:red;size:20px" value="#{semmel002Bean.msgDataNotFoundFirstPage}" rendered="#{semmel002Bean.renderedMsgDataNotFoundFirstPage}" />
                        </div>	
						
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%"  cellpadding="1" cellspacing="0" border="0"
							 var="warrantDetail" value="#{semmel002Bean.warrantDetailSPList}"
							reRender="dtbSiteApprove" rows="#{semmel002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">

							<rich:column styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel002Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel002Action.selectAllRow}" reRender="dtbSiteApprove,btnExport, btnUpdateStatus" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="managementSelected" onclick="onRenderButton()" value="#{warrantDetail.selected}">
										<a4j:jsFunction name="onRenderButton" action="#{semmel002Action.onRenderExportButton}" reRender="btnExport, btnUpdateStatus"/>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>		
							<rich:column sortBy="#{warrantDetail.contractNo}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.contractNo}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.company}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" style="width: 78" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.company}"/></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.siteName}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}"  style="width: 200px;"/>
								</f:facet>
								<div align="left" style="width: 200px;"><h:outputText value="#{warrantDetail.siteName}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.locationId}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" style="width: 70" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.locationId}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.locationCode}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationCode']}" style="width: 70" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.locationCode}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.region}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 10" />
								</f:facet>
								<div align="left"><h:outputText value="#{warrantDetail.region}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.province}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.province']}" style="width: 120px;" />
								</f:facet>
								<div align="left"  style="width:120px;"><h:outputText value="#{warrantDetail.province}"  /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.electricUseType}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elUserType']}" style="width: 120px;" />
								</f:facet>
								<div align="left"  style="width:120px;"><h:outputText value="#{warrantDetail.electricUseType}"  /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.warrantType}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.warrantType']}" style="width: 10" />
								</f:facet>
								<div align="left"><h:outputText value="#{warrantDetail.warrantType}" /></div>
							</rich:column>							
							<rich:column sortBy="#{warrantDetail.warrantProcess}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.warrantStatus']}" style="width: 10" />
								</f:facet>
								<div align="left"><h:outputText value="#{warrantDetail.warrantProcess}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.receivedDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.receivedDt']}" style="width: 10" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{warrantDetail.receivedDtStr}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.printDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.print.date']}" style="width: 10" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.printDtStr}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.printTimes}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.printTimes']}" style="width: 10" />
								</f:facet>
								<div align="right"><h:outputText value="#{warrantDetail.printTimes}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.sentSignDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}"
							rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sentSighDt']}" style="width: 10" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{warrantDetail.sentSignDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.signDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.signDt']}" style="width: 10" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{warrantDetail.signDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.sentWarrantDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sentWarrantDt']}" style="width: 10" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{warrantDetail.sentWarrantDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.sentContractDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sentContractDt']}" style="width: 10" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{warrantDetail.sentContractDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.sentSamuserDt}" 
							styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sentSamuserDt']}" style="width: 10" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{warrantDetail.sentSamuserDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.samuserName}" 
							styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.samuserName']}" style="width: 200" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{warrantDetail.samuserName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.samuserTel}" 
							styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.samuserTel']}" style="width: 10" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{warrantDetail.samuserTel}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.remark}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" style="width: 200px;" />
								</f:facet>
								<div align="left" style="width: 200px;"><h:outputText value="#{warrantDetail.remark}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.updateBy}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.updateby']}" style="width: 50" />
								</f:facet>
								<div align="left"><h:outputText value="#{warrantDetail.updateBy}" /></div>
							</rich:column>
							<rich:column sortBy="#{warrantDetail.updateDt}" styleClass="#{(semmel002Bean.tmpRowId==warrantDetail.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.update.date']}" />
								</f:facet>
								<div align="center"><h:outputText value="#{warrantDetail.updateDtStr}" /></div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                            <f:param value="#{fn:length(semmel002Bean.warrantDetailSPList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="22">
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
								<h:outputText value="#{jspMsg['column.elUserType']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{warrantDetail.electricUseType}"/>
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
						<rich:column rendered="false">
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
									<h:outputText value="#{jspMsg['column.samuserName']}" style="width: 200" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{warrantDetail.samuserName}"/>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.samuserTel']}" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{warrantDetail.samuserTel}"/>
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
					<h:outputText value="#{jspMsg['popup.label.sighDt']}" styleClass="ms7"/></td>
					
				<td width="15%"><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSighDt}" disabled="#{semmel002Bean.disablePopupSighDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '02'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/>
				</td>
				<td width="20%" align="right">
					<h:outputText value="#{jspMsg['popup.label.sentWarrantDt']}" styleClass="ms7"/>
				</td>
				<td width="15%"><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSentWarrantDt}" disabled="#{semmel002Bean.disablePopupSentWarrantDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '03'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/>
				</td>
				<td width="20%" align="right">
					<h:outputText value="#{jspMsg['popup.label.sentContractDt']}" styleClass="ms7"/>
				</td>
				<td><rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel002Bean.popupSentContractDt}" disabled="#{semmel002Bean.disablePopupSentContractDt}"
						showWeeksBar="false" inputStyle="#{semmel002Bean.warrantStatus == '04'?'width : 120px;background-color: #FFFF66' : 'width : 120px;'}"/>
				</td>
			</tr>
			<tr>
				<td align="right">
				</td>
				<td><rich:spacer width="5"/>
					
				</td>
				<td align="right">
					
				<td><rich:spacer width="5"/>
				</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				
			</tr>
			<tr>
				<td align="right" valign="top">
					<h:outputText value="#{jspMsg['column.samuserName']}" styleClass="ms7"/>
					
				<td valign="top"><rich:spacer width="5"/>
					<h:inputText id="popupSamUsername" value="#{semmel002Bean.popupSamUsername}"> </h:inputText>
				</td>
				<td align="right" valign="top">
					<h:outputText value="#{jspMsg['column.samuserTel']}" styleClass="ms7"/>
					
				<td valign="top"><rich:spacer width="5"/>
					<h:inputText id="popupSamuserPhone" value="#{semmel002Bean.popupSamuserPhone}"> </h:inputText>
				</td>	
				<td align="right" valign="top">
					<h:outputText value="#{jspMsg['popup.label.remark']}" styleClass="ms7"/>
				</td>		
				<td>
					<h:inputTextarea id="txtRemarkPopup" value="#{semmel002Bean.popupRemark}" rows="3" cols="30"/>
				</td>				
			</tr>
			<tr>
				<td colspan="6"><rich:spacer width="10"/></td>
			</tr>
			<tr>
				<td colspan="6">
					<a4j:commandButton value="#{jspMsg['popup.btn.save']}" 
					styleClass="rich-button" oncomplete="#{!semmel002Bean.displayPopupUpdateStatus?'hideUpdateStatus();' : ''}" 
					action="#{semmel002Action.doUpdateStatusWarrant}" 
					reRender="messagePopupUpdateStatus, dtbSiteApprove, btnExport, btnUpdateStatus, oppContent"/>
					<rich:spacer width="10"/>
					<a4j:commandButton value="#{jspMsg['popup.btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
					    <rich:componentControl for="mdpUpdateStatus" operation="hide" event="onclick"/>
					</a4j:commandButton>
				</td>
			</tr>
		</table>
	
	</a4j:form>
	
</rich:modalPanel>
