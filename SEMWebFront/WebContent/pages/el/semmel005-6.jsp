<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel005-6" var="jspMsg"/>
<h:panelGrid width="100%" id="pnlSemmel0056">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.textFileFail']}"/></f:facet>
		<h:panelGrid id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue"/>
		</h:panelGrid>		
		<h:panelGrid columns="4" id="grdSearchCommand2" width="90%">
			<a4j:form id="frmBack">
			<div align="right">
			<a4j:commandButton id="btnSearch2" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent">
				<a4j:actionparam name="navModule" value="el" />
				<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
				<a4j:actionparam name="moduleWithNavi" value="el" />
				<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
				<a4j:actionparam name="methodWithNavi" value="doBack" />
			</a4j:commandButton>
			</div>
			</a4j:form>
		</h:panelGrid>		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.fileData']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtCompany" value="#{semmel005Bean.importTransaction.company}" disabled="true" style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">&nbsp;</td>
										<td width="30%">&nbsp;</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileType']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtFileType" value="#{semmel005Bean.importTransaction.fileTypeDisplay}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtFileName" value="#{semmel005Bean.importTransaction.fileName}" disabled="true"
												style="width:180px;" maxlength="15"/>
									</tr>									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.refDocId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtRefDocId" value="#{semmel005Bean.importTransaction.refDocId}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.uploadDt']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtUploadDt" value="#{semmel005Bean.importTransaction.uploadDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDt']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtProcessDt" value="#{semmel005Bean.importTransaction.processDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">
											</h:inputText>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.loadFailedFromFile']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtValidateSuccess" value="#{semmel005Bean.importTransaction.uploadFailed}" disabled="true"
												style="width:180px;" maxlength="15"/>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<a4j:form id="frmResult">
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.dataList']}" style="width: 100%"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="importDataLog"  value="#{semmel005Bean.importDataLogList}" reRender="dtbSiteApprove" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<!-- begin column -->
							
							<rich:column sortBy="#{importDataLog.lineNo}" styleClass="#{(semmel005Bean.tmpRowId==importDataLog.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{importDataLog.lineNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{importDataLog.meterId}" styleClass="#{(semmel005Bean.tmpRowId==importDataLog.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 78"/>
								</f:facet>
								<div align="center"><h:outputText value="#{importDataLog.meterId}"/></div>
							</rich:column>
							<rich:column sortBy="#{importDataLog.processDetail}" styleClass="#{(semmel005Bean.tmpRowId==importDataLog.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorDetail']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{importDataLog.processDetail}"/></div>
							</rich:column>
							<rich:column sortBy="#{importDataLog.errorCode}" styleClass="#{(semmel005Bean.tmpRowId==importDataLog.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorCode']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{importDataLog.errorCode}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{importDataLog.errorDesc}" styleClass="#{(semmel005Bean.tmpRowId==importDataLog.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.errorDesc']}" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{importDataLog.errorDesc}"/>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove" 
									maxPages="10" id="dstSiteApprove" selectedStyleClass="selectScroll" />
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

