<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel004" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}" /></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<!-- begin content layout criteria -->
			<h:panelGrid width="90%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="baseline">
											<h:panelGroup>
												<h:graphicImage value="images/icon_required.gif" /><rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
											</h:panelGroup>
										</td>
										<td width="80%" colspan="3" valign="bottom">
											<h:selectOneMenu id="ddlCompany" value="#{semmel004Bean.company}" onchange="GetCompanyJS();" style="width:220px;">
												<f:selectItems value="#{semmel004Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay" /><rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmel004Bean.company}" styleClass="ms28" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtContractNo" value="#{semmel004Bean.contractNo}" style="width:220px;" maxlength="15" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtSiteName" value="#{semmel004Bean.siteName}" style="width:220px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" /> <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="ddlElectricUseType" value="#{semmel004Bean.electricUseType}" style="width:220px;">
												<f:selectItems value="#{semmel004Bean.electricUseTypeList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.meterOwnerName']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtMeterOwnerName" value="#{semmel004Bean.pMeterOwnerName}" style="width:220px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtLocationId"	value="#{semmel004Bean.locationId}" style="width:220px;" maxlength="15" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText id="txtLocationName" value="#{semmel004Bean.locationCode}" style="width:220px;" maxlength="15" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadMeterDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="cldUploadMeterDtFrom" locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy" value="#{semmel004Bean.uploadMeterDtFrom}"
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');"
											   	oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUploadMeterDtTo');"
												showWeeksBar="false" inputStyle="width:80px;" />
											&nbsp;<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
											<rich:calendar id="cldUploadMeterDtTo" locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy" value="#{semmel004Bean.uploadMeterDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtTo','cldUploadMeterDtFrom');"
											   	oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtTo','cldUploadMeterDtFrom');"
												showWeeksBar="false" inputStyle="width:80px;" />	
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.oneBillDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="cldOneBillDtFrom"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel004Bean.eOneBillDtFrom}" showWeeksBar="false"
												inputStyle="width:80px;" />
											&nbsp;<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
											<rich:calendar id="cldOneBillDtTo"
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel004Bean.eOneBillDtTo}" showWeeksBar="false"
												inputStyle="width:80px;" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif" /> <rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.oneBillStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlOneBillAddFlag" value="#{semmel004Bean.oneBillAddFlag}" style="width:220px;">
												<f:selectItems value="#{semmel004Bean.oneBillAddFlagList}" />
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											&nbsp;
										</td>
										<td width="30%">
											&nbsp;
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
								<a4j:actionparam name="navProgram" value="SEMMEL004-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL004" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}"
								styleClass="rich-button" action="#{navAction.navi}"
								reRender="frmError,pnlSearchCriteria,panSearchResult">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL004-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL004" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</a4j:form>
			</h:panelGrid>
			<!-- end content layout criteria -->
			
			<a4j:form id="frmResult">
				<h:panelGrid columns="2" id="grdActionCommand">
					<h:commandButton id="btnExport"
						action="#{semmel004Action.doExportExcel}" styleClass="rich-button"
						value="#{jspMsg['btn.export']}"
						disabled="#{semmel004Bean.disabledBtnExport}"
						rendered="#{semmel004Bean.renderer['btnExport']}"/>
				</h:panelGrid>
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1620" />
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="meterInfo"
							value="#{semmel004Bean.meterInfoList}" reRender="dtbSiteApprove"
							rows="#{semmel004Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<a4j:support event="onRowClick"	action="#{semmel004Action.getRowIdOnClick}" reRender="dtbSiteApprove">
								<a4j:actionparam name="rowId" value="#{meterInfo.rowId}" />
							</a4j:support>
							<!-- begin column -->
							<rich:column styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel004Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel004Action.selectAllRow}" reRender="dtbSiteApprove,btnExport" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="managementSelected" onclick="onRenderButton()" value="#{meterInfo.selected}">
									<a4j:jsFunction name="onRenderButton" action="#{semmel004Action.onRenderExportButton}" reRender="btnExport"/>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.electricId.contractNo}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 50" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInfo.electricId.contractNo}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.electricId.company}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.company']}" style="width: 78" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInfo.electricId.company}"/></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.electricId.siteName}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 100" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInfo.electricId.siteName}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.electricId.electricUseType}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.electricUseType']}" style="width: 100" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInfo.elecTricUstTypeDisplay}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.meterId}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterNo']}" style="width: 140" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInfo.meterId}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.meterOwnerName}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterOwnerName']}" style="width: 50" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInfo.pMeterOwnerName}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.eAreaName}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 100" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInfo.areaName}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.uploadMeterDt}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.uploadMeterDt']}" style="width: 78"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{meterInfo.uploadMeterDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.eOnMeterDt}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.eOnMeterDt']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{meterInfo.eOnMeterDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.eOneBillDt}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.eOneBillDt']}" style="width: 15"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{meterInfo.eOneBillDtStr}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.oneBillFlag}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.oneBillStatus']}" style="width: 50" />
								</f:facet>
								<div align="center"><h:outputText value="#{meterInfo.oneBillAddFlagDisplay}" /></div>
							</rich:column>
							<rich:column sortBy="#{meterInfo.oneBillRemark}" styleClass="#{(semmel004Bean.tmpRowId==meterInfo.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" style="width: 100" />
								</f:facet>
								<div align="left"><h:outputText value="#{meterInfo.oneBillRemark}" /></div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true"
									align="center" for="dtbSiteApprove" maxPages="10"
									id="dstSiteApprove" selectedStyleClass="selectScroll" />
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