<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel005-1" var="jspMsg"/>
<h:panelGrid width="100%" id="pnlSemmel0051">
	<rich:panel id="pnlSearchImportTrans">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.searchTextFile']}"/></f:facet>
		<h:panelGrid id="frmError">
			<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue"/>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.searchCriteria']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
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
			                			<td width="80%" colspan="3" valign="bottom">
										<h:selectOneMenu id="ddlCompany" value="#{semmel005Bean.company}" onchange="GetCompanyJS();" style="width:120px;">
											<f:selectItems value="#{semmel005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmel005Bean.company}" styleClass="ms28"/>
					                	</td>
				                	</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.fileType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlFileType" value="#{semmel005Bean.fileType}" style="width:120px;">
												<f:selectItems value="#{semmel005Bean.fileTypeList}"/>
											</h:selectOneMenu>
										</td><td align="right" width="20%">&nbsp;</td><td width="30%">&nbsp;</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processStatus']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlProcessStatus" value="#{semmel005Bean.processStatus}" style="width:120px;">
												<f:selectItems value="#{semmel005Bean.processStatusList}"/>
											</h:selectOneMenu>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtLocationName" value="#{semmel005Bean.fileName}" 
												style="width:150px;" maxlength="100"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadDtFrom']}" styleClass="ms7"/>
										</td>
										<td>
											<rich:calendar id="cldUploadDtFrom" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.uploadDtFrom}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadDtFrom','cldUploadDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadDtFrom','cldUploadDtTo');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadDtTo']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldUploadDtTo" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.uploadDtTo}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadDtTo','cldUploadDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadDtTo','cldUploadDtFrom');"
												showWeeksBar="false" inputStyle="width:120px;"/>
									</tr>									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDtFrom']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldUploadMeterDtFrom" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.processDtFrom}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUProcessDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUProcessDtTo');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDtTo']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<rich:calendar id="cldUProcessDtTo" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.processDtTo}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUProcessDtTo','cldUploadMeterDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUProcessDtTo','cldUploadMeterDtFrom');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td>
									</tr>
									<tr>
										<td align="right">
										<h:panelGroup>
											<h:outputText rendered="false" value="#{jspMsg['label.jobStatus']}" styleClass="ms7" />
										</h:panelGroup>
			                			</td>
			                			<td width="80%" colspan="3" valign="bottom">
										<h:selectOneMenu id="ddlClearingFlag" 
										 rendered="false"
										 value="#{semmel005Bean.clearingFlag}" style="width:120px;">
											<f:selectItem itemLabel="-- Select --" itemValue=""/>
											<f:selectItem itemLabel="#{jspMsg['item.closeJob']}" itemValue="Y"/>
											<f:selectItem itemLabel="#{jspMsg['item.noneCloseJob']}" itemValue="N"/>
										</h:selectOneMenu>
					                	</td>
				                	</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchImportTrans,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,panSearchResult">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
			<a4j:form id="frmResult">
				<!-- begin content button -->
				<h:panelGrid columns="4" id="grdActionCommand" style="width: 20%" border="0">
					<a4j:commandButton id="btnUploadFile" value="#{jspMsg['btn.uploadFile']}" 
								styleClass="rich-button" rendered="#{semmel005Bean.renderer['btnUploadFile']}"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-2" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="initSavePage" />
							</a4j:commandButton>
					<a4j:commandButton id="btnUcalculateEL" value="#{jspMsg['btn.calculateEL']}" 
								styleClass="rich-button" rendered="#{semmel005Bean.renderer['btnUploadFile']}"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-8-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="calculateFTRateInit" />
							</a4j:commandButton>
							
					<a4j:commandButton id="btnCloseJob" value="#{jspMsg['btn.closeJob']}" 
								oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
								styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobBtn}"
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="initCloseJob" />
							</a4j:commandButton>							
				</h:panelGrid>
				
				<!-- end content button -->
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<a4j:jsFunction name="onRenderButton" action="#{semmel005Action.renderDependOnChk}" reRender="btnCloseJob"/>
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.listFileData']}" style="width: 3250px"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbImportTransaction" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="importTransaction"  value="#{semmel005Bean.importTransactionList}" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowKeyVar="row">
							<%-- <a4j:support id="a4jSupportDtbImportTransaction" event="onRowClick" action="#{semmel005Action.doSelectRow}" reRender="dtbImportTransaction">
									<a4j:actionparam name="row" value="#{row}" />
							</a4j:support> --%>							
							
							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRow}" reRender="btnCloseJob, dtbImportTransaction" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="importTransactionSelected" value="#{importTransaction.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>	
							<rich:column>
								<f:facet name="header">
									<h:outputText  value="#{jspMsg['column.header.delete']}"  styleClass="contentform" />
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false"
	            									   action="#{navAction.navi}" 	            									   
	            									   reRender="mdpConfirmDelDialog" 
	            									   image="images/delete.png" style="height: 15; width: 15">
										<a4j:actionparam name="navModule" value="el" />
		            					<a4j:actionparam name="navProgram" value="SEMMEL005" />	
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="rowIndex" value="#{row}"/>
	            					</a4j:commandButton>          							
								</div>									
							</rich:column>						
							<rich:column id="colReprotUsage" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnExportUsage" value="#{jspMsg['btn.reportusage']}" styleClass="rich-button" 
							        action="#{navAction.navi}" style="width:77px;padding-left:2px;"
							        onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
							        reRender="pnlShowExportUsageExcel">
									    <a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
										<a4j:actionparam name="methodWithNavi" value="initReportUsage" />
										<a4j:actionparam name="rowId" value="#{importTransaction.rowId}" />
										<a4j:actionparam name="processId" value="#{importTransaction.processId.rowId}" />
							        </a4j:commandButton>
								</div>
							</rich:column>
							<rich:column id="colCompany" sortBy="#{importTransaction.company}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="resultCompay" value="#{jspMsg['column.compay']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputCompany" value="#{importTransaction.company}"/>
								</div>
							</rich:column>
							<rich:column id="colFileTypeDisplay" sortBy="#{importTransaction.fileTypeDisplay}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="resultFileType" value="#{jspMsg['column.fileType']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText id="outputFileTypeDisplay" value="#{importTransaction.fileTypeDisplay}"/></div>
							</rich:column>
							<rich:column id="colFileName" sortBy="#{importTransaction.fileName}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsFileName" value="#{jspMsg['column.fileName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputFileName" value="#{importTransaction.fileName}"/>
								</div>
							</rich:column>
							<rich:column id="colRefDocId" sortBy="#{importTransaction.refDocId}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsRefDocId" value="#{jspMsg['column.refDocId']}" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText id="outputRefDocId" value="#{importTransaction.refDocId}"/>
								</div>
							</rich:column>
							<rich:column id="colInvTotalSite" sortBy="#{importTransaction.invTotalSite}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsInvTotalSite" value="#{jspMsg['column.invTotalSite']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optInvTotalSite" value="#{importTransaction.invTotalSite}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column id="colDbTotalSite" sortBy="#{importTransaction.dbTotalSite}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsDbTotalSite" value="#{jspMsg['column.dbTotalSite']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optDbTotalsite" value="#{importTransaction.dbTotalSite}">									
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column id="colNoDbTotalSite" sortBy="#{importTransaction.noDbTotalSite}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsNoDbTtotalSite" value="#{jspMsg['column.noDbTotalSite']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optNoDbTotalSite" value="#{importTransaction.noDbTotalSite}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column id="colUploadDt" sortBy="#{importTransaction.uploadDt}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsUploadDt" value="#{jspMsg['column.uploadDt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optUploadDtFormat" value="#{importTransaction.uploadDtFormat}">
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column id="colProcessDt" sortBy="#{importTransaction.processDt}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsProcessDt" value="#{jspMsg['column.processDt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optProcessDtFormat" value="#{importTransaction.processDtFormat}">
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column id="colProcessStatus" sortBy="#{importTransaction.processStatus}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsProcessStatus" value="#{jspMsg['column.processStatus']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optProcessStatus" value="#{importTransaction.processStatusDisplay}">
									</h:outputText>
								</div>								
							</rich:column>		
							<rich:column id="colTotalFileRecord" sortBy="#{importTransaction.totalFileRecord}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsTotalFileRecord" value="#{jspMsg['column.totalFileRecord']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optTotalFileRecord" value="#{importTransaction.totalFileRecord}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column id="colUploadSuccess" sortBy="#{importTransaction.uploadSuccess}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsUploadSuccess" value="#{jspMsg['column.uploadSuccess']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optUploadSuccess" value="#{importTransaction.uploadSuccessNumber}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column id="colUploadFailed" sortBy="#{importTransaction.uploadFailed}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsUploadFailed" value="#{jspMsg['column.uploadFailed']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optUploadFailed" value="#{importTransaction.uploadFailed}" rendered="#{importTransaction.uploadFailed==0}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
									<a4j:commandLink id="hypPage6" value="#{importTransaction.uploadFailedLink}" action="#{navAction.navi}" 
										reRender="oppContent" rendered="#{importTransaction.uploadFailed!=0}">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-6" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005"/>
											<a4j:actionparam name="methodWithNavi" value="init6" />
											<a4j:actionparam name="rowId" value="#{importTransaction.rowId}" />
										</a4j:commandLink>
								</div>								
							</rich:column>
							<rich:column id="colValidateRecord" sortBy="#{importTransaction.validateRecord}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" rendered="false">
								<f:facet name="header">
									<h:outputText id="rsValidateRecord" value="#{jspMsg['column.validateRecord']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optValidateRecord" value="#{importTransaction.validateRecord}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column id="colValidateSuccess" sortBy="#{importTransaction.validateSuccess}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsValidateSuccess" value="#{jspMsg['column.validateSuccess']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optValidateSuccess" value="#{importTransaction.validateSuccess}" rendered="#{importTransaction.validateSuccess==0}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
									<a4j:commandLink id="hypEdit" value="#{importTransaction.validateSuccessLink}" action="#{navAction.navi}" rendered="#{importTransaction.validateSuccess!=0}" 
										reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-3" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005"/>
											<a4j:actionparam name="methodWithNavi" value="init3" />
											<a4j:actionparam name="rowId" value="#{importTransaction.rowId}" />
										</a4j:commandLink>
								</div>								
							</rich:column>
							<rich:column id="colSuccessPaid" sortBy="#{importTransaction.successPaid}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsSuccessPaid" value="#{jspMsg['column.successPaid']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optSuccessPaid" value="#{importTransaction.successPaid}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colSuccessNoPaid" sortBy="#{importTransaction.successNoPaid}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsSuccessNoPaid" value="#{jspMsg['column.successNoPaid']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optSuccessNoPaid" value="#{importTransaction.successNoPaid}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colValidateFailed" sortBy="#{importTransaction.validateFailed}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsValidateFailed" value="#{jspMsg['column.validateFailed']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optValidateFailed" value="#{importTransaction.validateFailed}" rendered="#{importTransaction.validateFailed==0}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
										<a4j:commandLink id="hyp4" value="#{importTransaction.validateFailLink}" action="#{navAction.navi}" 
										reRender="oppContent" rendered="#{importTransaction.validateFailed!=0}">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005"/>
											<a4j:actionparam name="methodWithNavi" value="init4" />
											<a4j:actionparam name="rowId" value="#{importTransaction.rowId}" />
										</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column id="colFailedPaid" sortBy="#{importTransaction.failedPaid}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsFailedPaid" value="#{jspMsg['column.failedPaid']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optFailedPaid" value="#{importTransaction.failedPaid}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colFailedNoPaid" sortBy="#{importTransaction.failedNoPaid}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsFailedNoPaid" value="#{jspMsg['column.failedNoPaid']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optFailedNoPaid" value="#{importTransaction.failedNoPaid}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colProcessDt2" sortBy="#{importTransaction.processDt}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsProcessDt2" value="#{jspMsg['column.processDt2']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optProcessDtFormat2" value="#{importTransaction.processDtFormat}">
										<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column id="colCreateBy" sortBy="#{importTransaction.createBy}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsUploadBy" value="#{jspMsg['column.uploadBy']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="optCreateBy" value="#{importTransaction.createBy}"/>
								</div>
							</rich:column>
							<rich:column id="colUploadDt2" sortBy="#{importTransaction.uploadDt}" style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="rsUploadDate" value="#{jspMsg['column.uploadDate']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="resultUploadDtFormat" value="#{importTransaction.uploadDtFormat}">
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.importTransactionList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="21">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbImportTransaction"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstSiteApprove" 
											style="background-color: #cccccc;" />
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

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirmed Message"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">						
						<h:outputText value="#{semmel005Bean.confirmDeleteMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
						reRender="dtbImportTransaction, frmError" 	>
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL005-1" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />							
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmCloseJobDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirmed Message"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmCloseJobDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">						
						<h:outputText value="#{semmel005Bean.confirmCloseJobMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
						reRender="dtbImportTransaction, frmError" 	>
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL005-1" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
							<a4j:actionparam name="methodWithNavi" value="closeJob" />							
							<rich:componentControl for="mdpConfirmCloseJobDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCloseJobDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>
		
		<h:panelGrid id="pnlShowExportUsageExcel" style="height:0px;width:0px;" width="0px" columns="0" >
						<h:panelGroup id="pnlInShowExportUsageExcel" rendered="#{semmel005Bean.displayExportReportUsage}" style="height:0px;width:0px;" >
							<h:commandButton value="Report" id="bthShowExportUsageExcel" style="height:0px;width:0px;display:none;" action="#{semmel005Action.doExportTextNew}" />								
							<script>document.getElementById('incContent:frmConfirmCloseJobDialog:bthShowExportUsageExcel').click();</script>
						</h:panelGroup>							
		</h:panelGrid>		
	</a4j:form>
</rich:modalPanel>