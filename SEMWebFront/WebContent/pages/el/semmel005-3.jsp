<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.el.semmel005-3" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.textFileSuccess']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>			
		</h:panelGrid>		
		<h:panelGrid columns="4" id="grdSearchCommand2" width="95%">
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
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.fileData']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
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
													<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.processDt']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtProcessDt" value="#{semmel005Bean.importTransaction.processDtFormat}" disabled="true"
												style="width:180px;" maxlength="15">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" />
											</h:inputText>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.validateSuccess']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtValidateSuccess" value="#{semmel005Bean.importTransaction.validateSuccess}" disabled="true"
												style="width:180px;" maxlength="15">
												<f:convertNumber pattern="#,##0"/>
												</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.successPaid']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtSuccessPaid" value="#{semmel005Bean.importTransaction.successPaid}" disabled="true"
											 style="width:180px;" maxlength="15">
												<f:convertNumber pattern="#,##0"/>
											</h:inputText>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.successNoPaid']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<h:inputText id="txtSuccessNoPaid" value="#{semmel005Bean.importTransaction.successNoPaid}" disabled="true"
												style="width:180px;" maxlength="15">
											<f:convertNumber pattern="#,##0"/>	
											</h:inputText>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<h:panelGrid width="95%">
					<rich:panel id="pnlSumError">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.errorCode']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">	
									<tr>
										<td width="20%">&nbsp;</td>
										<td width="30%" align="center">
											<h:outputText value="#{jspMsg['label.all']}" styleClass="ms7"/>&nbsp;
											<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/>
										</td>
										<td align="center" width="20%"><h:outputText value="#{jspMsg['label.close']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/></td>
										<td align="center" width="30%"><h:outputText value="#{jspMsg['label.unClose']}" styleClass="ms7"/>&nbsp;<h:outputText value="#{jspMsg['header.list']}" styleClass="ms7"/></td>
									</tr>								
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ELPAY00']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.elPay00Size}"  styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay00PaidSize}"  styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay00NoPaidSize}"  styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.ELPAY08']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText id="txtELPay02Size" value="#{semmel005Bean.elPay08Size}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.elPay08PaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.elPay08NoPaidSize}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText></td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.sum']}" styleClass="ms7"/>
										</td>
										<td width="30%" align="center">
											<h:outputText value="#{semmel005Bean.sumSuccess}" styleClass="ms7">
											<f:convertNumber pattern="#,##0"/>
											</h:outputText>
										</td>
										<td align="center" width="20%"><h:outputText value="#{semmel005Bean.sumSuccessPaid}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText></td>
										<td width="30%" align="center"><h:outputText value="#{semmel005Bean.sumSuccessNoPaid}" styleClass="ms7">
										<f:convertNumber pattern="#,##0"/>
										</h:outputText></td>
									</tr>							
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
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
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlRegion" value="#{semmel005Bean.region}" style="width:180px;">
												<f:selectItems value="#{semmel005Bean.regionList}"/>
											</h:selectOneMenu>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.paidFlag']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlPaidFlag" value="#{semmel005Bean.successPaidFlag}" style="width:180px;">
												<f:selectItems value="#{semmel005Bean.paidFlagList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.errorCode']}" styleClass="ms7"/>
										</td>
										<td>
											<h:selectOneMenu id="ddlErrorCode" value="#{semmel005Bean.errorCode}" style="width:180px;">
												<f:selectItems value="#{semmel005Bean.errorCodeList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%"><h:outputText value="#{jspMsg['label.jobStatus']}" styleClass="ms7"/></td>
										<td width="30%"><h:selectOneMenu id="ddlClearingFlag" value="#{semmel005Bean.clearingFlag}" 
										style="width:180px;">
															<f:selectItem itemLabel="-- Select --" itemValue=""/>
															<f:selectItem itemLabel="#{jspMsg['item.closeJob']}" itemValue="Y"/>
															<f:selectItem itemLabel="#{jspMsg['item.noneCloseJob']}" itemValue="N"/>
														</h:selectOneMenu></td>
									</tr>
									<tr>
										
										<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paidStatus']}" styleClass="ms7" rendered=" flase"/>
										</td>
										<td width="30%"><h:selectOneMenu id="paidFlag" value="#{semmel005Bean.successPaidFlag}" 
										style="width:120px;" rendered=" flase">
															<f:selectItem itemLabel="-- Select --" itemValue=""/>
															<f:selectItem itemLabel="#{jspMsg['item.paid']}" itemValue="Y"/>
															<f:selectItem itemLabel="#{jspMsg['item.unpaid']}" itemValue="N"/>
														</h:selectOneMenu>
									</td>
									<td></td> 
									<td></td> 
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.invNo']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtInvNo" value="#{semmel005Bean.invNo}" 
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtMeterId" value="#{semmel005Bean.meterId}" 
												style="width:180px;" maxlength="15"/>
									</tr>
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td>
										<td>
											<h:inputText id="txtContractNo" value="#{semmel005Bean.contractNo}" 
												style="width:180px;" maxlength="15"/>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.percentGrowth']}" styleClass="ms7"/>
										</td>
										<td width="30%">
										<h:selectOneMenu id="ddlMonth" value="#{semmel005Bean.month}" style="width:100px;">
												<f:selectItems value="#{semmel005Bean.monthList}"/>
											</h:selectOneMenu>
											<rich:spacer width="5px" /> 
											<h:selectOneMenu id="ddlType" value="#{semmel005Bean.type}" style="width:100px;">
												<f:selectItems value="#{semmel005Bean.typeList}"/>
											</h:selectOneMenu>
											<rich:spacer width="5px" /> 
											<h:inputText id="txtPercentGrowth" value="#{semmel005Bean.percentGrowth}" style="width:60px;" maxlength="15"/>
										</td>
											
									</tr>				
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlSumError,dtbUploadTextAll">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-3" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doSearch3" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria">
			            	 	<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-3" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doClear3" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				
				<a4j:jsFunction name="onRenderButton" action="#{semmel005Action.renderDependOnChkValidate}" 
				reRender="btnCloseJob,btnCloseJob1,btnCloseJob2,btnunpaid,btnValidate"/>
				<a4j:form id="frmUploadText">
				<h:panelGrid columns="9" id="grdSearchCommand2">
	            	
	            	<a4j:commandButton id="btnCloseJob" value="#{jspMsg['btn.closeJob']}" 
						oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
						styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn||semmel005Bean.showCloseJob}"
						action="#{navAction.navi}" reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="initCloseJobValidate" />
						<a4j:actionparam name="processAction" value="001" />
					</a4j:commandButton>	
					<rich:spacer width="5"/>
					<a4j:commandButton id="btnCloseJob1" value="#{jspMsg['btn.closeJob1']}" 
						oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
						styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn||semmel005Bean.showCloseJob}"
						action="#{navAction.navi}" reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="initCloseJobValidate" />
						<a4j:actionparam name="processAction" value="002" />
					</a4j:commandButton>	
					<rich:spacer width="5"/>
					<a4j:commandButton id="btnCloseJob2" value="#{jspMsg['btn.closeJob2']}" 
						oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
						styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn||semmel005Bean.showCloseJob}"
						action="#{navAction.navi}" reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="initCloseJobValidate" />
						<a4j:actionparam name="processAction" value="003" />
					</a4j:commandButton>
					<rich:spacer width="5"/>
					<a4j:commandButton id="btnunpaid" value="#{jspMsg['btn.unpaid']}" 
						oncomplete="#{rich:component('mdpConfirmCloseJobDialog')}.show(); return false"
						styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn||semmel005Bean.showCloseJob}" rendered="flase"
						action="#{navAction.navi}" reRender="oppContent"
						>
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="initCloseJobValidate" />
						<a4j:actionparam name="processAction" value="003" />
					</a4j:commandButton>
					
					<h:commandButton id ="btnExportSuccss" action="#{semmel005Action.exportSuccessSP}"  
	            					 styleClass="rich-button" value="#{jspMsg['btn.export']}"/>			
	            	<rich:spacer width="5"/>
	            	<a4j:commandButton id="btnValidate" value="#{jspMsg['column.notVerify']}" 
						styleClass="rich-button" disabled="#{semmel005Bean.disableCloseJobValidateBtn||semmel005Bean.showCloseJob}"
						action="#{navAction.navi}" reRender="oppContent,errorMiddle">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="doVerify" />
					</a4j:commandButton>
				</h:panelGrid>
				<h:panelGrid id="errorMiddle">
				<rich:spacer height="15"></rich:spacer>
								<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmel005Bean.renderedMsgFormMiddle}">
									<f:facet name="header">
										<h:outputText value="Entered Data Status:"></h:outputText>
									</f:facet>
									<f:facet name="errorMarker">
										<h:graphicImage value="images/error.gif" />  
									</f:facet>
								</rich:messages>
				</h:panelGrid>
				<h:panelGrid style="width: 95%" id="pnlSearchResult">
					<!-- Start dataTable Use -->
					
					<rich:panel id="pnlSearchResultAll" styleClass="sem_autoScrollbar" >
						<f:facet name="header">
							<h:outputText value="#{semmel005Bean.headerResultSuccessNoPaid}" style="width: 3200px"/>
						</f:facet>
						
						<!-- begin dataTable -->
						<rich:dataTable id="dtbUploadTextAll" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="uploadText"  value="#{semmel005Bean.uploadTextSPList}" reRender="dtbUploadTextAll" 
							rows="#{semmel005Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable"
							rowKeyVar="RowInd">
							
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel005Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel005Action.selectAllRowValidate}" 
										reRender="btnCloseJob,btnCloseJob1,btnCloseJob2,btnunpaid,pnlSearchResult" />
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox
									id="iuploadTextSelected" value="#{uploadText.selected}" onclick="onRenderButton()">
									</h:selectBooleanCheckbox>
									<h:inputHidden value="#{uploadText.rowId}"></h:inputHidden>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.seqNo}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.seqNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.contractNo}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" style="width: 80"/>
								</f:facet>
								<div align="center"><h:outputText value="#{uploadText.contractNo}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.oldContractNo}" 
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.oldContractNo']}" style="width: 80"/>
								</f:facet>
								<div align="center">
								<h:outputText  value="#{uploadText.oldContractNo}"/></div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.siteName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.siteName']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.siteName}"/></div>
							</rich:column>
							
							
							<rich:column sortBy="#{uploadText.effDate}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.effDateStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.expDate}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.expDateStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.siteStats2}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.siteStats2}"/></div>
							</rich:column>
							<rich:column sortBy="#{uploadText.networkStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 100"/>
								</f:facet>
								<div align="left"><h:outputText value="#{uploadText.networkStatus}"/></div>
							</rich:column>
							
							
							
							<rich:column sortBy="#{uploadText.region}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.region']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.region}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{uploadText.meterId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterId']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.meterId}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.meterStatus}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterStatus']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{uploadText.meterStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{uploadText.locationId}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.locationId']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.locationId}"/>
								</div>
							</rich:column>	
							<rich:column sortBy="#{uploadText.areaCode}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaCode']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaCode}"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{uploadText.areaName}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.areaName']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.areaName}"/>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.meterRate}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterRate']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterRate}"/>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.meterType}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.meterType']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.meterType}"/>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.kwhTotal}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.kwhTotal']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:inputHidden value="#{uploadText.kwhTotal}"/>
									<h:outputText value="#{uploadText.kwhTotalNumber}">
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>								
							</rich:column>		
							<rich:column sortBy="#{uploadText.billperiodPDt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.billPeriod']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.billperiodPDtStr}">
									</h:outputText>
									
									<h:inputHidden value="#{uploadText.billPeriodFromPDtStr}">
									</h:inputHidden>
									
								</div>								
							</rich:column>	
							
							<rich:column sortBy="#{uploadText.invVatAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invVatAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:inputHidden value="#{uploadText.invVatAmt}" />
									<h:outputText value="#{uploadText.invVatAmtNumber}" >
									<f:convertNumber pattern="#,##0.00" />
									</h:outputText>
								</div>								
							</rich:column>	
							<rich:column sortBy="#{uploadText.invAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.invAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:inputHidden value="#{uploadText.invAmt}"/>
									<h:outputText value="#{uploadText.invAmtNumber}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.sysAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.sysAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:inputHidden value="#{uploadText.sysAmt}"/>
									<h:outputText value="#{uploadText.sysAmtNumber}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.diffAmt}" styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffAmt']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:inputHidden value="#{uploadText.diffAmt}"/>
									<h:outputText value="#{uploadText.diffAmtNumber}">
									<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>								
							</rich:column>
							<rich:column sortBy="#{uploadText.paidStatus}" rendered="true"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paidStatus']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.paidStatus}"/>
								</div>								
							</rich:column>	
							
							<rich:column sortBy="#{uploadText.ownerGroupName}" rendered="true"
							styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.elGroup']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{uploadText.ownerGroupName}"/>
									<h:inputHidden value="#{uploadText.ownerGroup}"></h:inputHidden>
								</div>								
							</rich:column>	
							
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}" 
							rendered="flase">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payment']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnPay" value="#{jspMsg['btn.pay']}" styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" rendered="#{uploadText.paidFlag=='N'}">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPaymentUploadText"/>
										<a4j:actionparam name="targetPayment" value="#{uploadText.textFileId.paymentId.rowId}"/>
										<a4j:actionparam name="isComeFromOtherPage" value="Y"/>
										<a4j:actionparam name="navProgramFrom" value="SEMMEL005-3" />
										<a4j:actionparam name="navModuleFrom" value="el" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
										<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="rowId" value="#{RowInd}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.update']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn100011" value="#{jspMsg['btn.update']}" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel005Bean.errorCode!='ELPAY00'}">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-3" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.view']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btn1000222" value="View" styleClass="rich-button"
									     	action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateError" />
											<a4j:actionparam name="rowId" value="#{uploadText.rowId}" />
											<a4j:actionparam name="viewFlag" value="Y" />
											<a4j:actionparam name="isDefineBackAction" value="Y"/>
											<a4j:actionparam name="navProgramFrom" value="SEMMEL005-3" />
											<a4j:actionparam name="navModuleFrom" value="el" />
											<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
											<a4j:actionparam name="methodWithNaviFrom" value="doBack"/>
											<a4j:actionparam name="isDefineRefreshMethod" value="Y"/>
											<a4j:actionparam name="methodB4Refresh" value="doUpdateELPAY07NRefreshData"/>
											<a4j:actionparam name="methodToRefresh" value="doSearch3"/>
									 </a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}" rendered="flase">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.credit']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnCredit" value="#{jspMsg['btn.credit']}" styleClass="rich-button" 
					            	action="#{navAction.navi}" reRender="oppContent,dtbPercentGrowth,pnlPercentGrowth"   style="width:75px" rendered="#{uploadText.paidFlag=='Y'}">
									    <a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initEditPayment7" />
										<a4j:actionparam name="targetPayment" value="#{uploadText.textFileId.paymentId.rowId}"/>
										<a4j:actionparam name="electricId" value="#{uploadText.electricId.rowId}"/>
										<a4j:actionparam name="company" value="#{uploadText.textFileId.company}"/>
										
										<a4j:actionparam name="isFromAction" value="Y"/>
										<a4j:actionparam name="navModuleFrom" value="el" />
										<a4j:actionparam name="navProgramFrom" value="SEMMEL005-3" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL005" />
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}" rendered="true">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.percentGrowth']}" style="width: 50"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="btnPercentGrowth" style=" width : 70px;" value="View"  styleClass="rich-button" 
										action="#{navAction.navi}" reRender="oppContent" oncomplete="#{rich:component('popupPercentGrowth')}.show();">									
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL005-3" />
										<a4j:actionparam name="moduleWithNavi" value="el" />
										<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
										<a4j:actionparam name="methodWithNavi" value="initPopupPercentGrowth"/>
										<a4j:actionparam name="fromPage" value="semmel005Page"/>
										<a4j:actionparam name="percentExpenseType" value="EL_POSTPAID"/>
										<a4j:actionparam name="percentcontractNo" value="#{uploadText.contractNo}"/>
										<a4j:actionparam name="percentPayDate" value="#{uploadText.billPeriodFromPDtStr}"/>
										<a4j:actionparam name="percentKwhNew" value="#{uploadText.kwhTotal}"/>
										<a4j:actionparam name="percentUnitNew" value="0"/>
										<a4j:actionparam name="percentAmtNew" value="#{uploadText.invAmt}"/>
										<a4j:actionparam name="percentType" value="UP"/>
										<a4j:actionparam name="percentTransId" value="#{uploadText.rowId}"/>
										<a4j:actionparam name="percentRecStatus" value="Y"/>
										<a4j:actionparam name="percentErrCode" value="#{semmel005Bean.errorCode}"/>
									</a4j:commandButton>
								
								
								
									<!--<a4j:commandButton value="View" onclick="#{rich:component('popupPercentGrowth')}.show();" styleClass="rich-button"/>
								--></div>								
							</rich:column>
							<rich:column styleClass="#{(semmel005Bean.tmpRowId==uploadText.rowId)?'onClick':'unClick'}" rendered="true">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.recentlyElMeter']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton id="btnRecentElGroup" style=" width : 70px;" value="View" styleClass="rich-button" 
											action="#{navAction.navi}" reRender="oppContent,frmErrorPopupRecentGrpMeter,frmPopupRecentGrpMeter,pnlRecentGrpMeter"  
							           		oncomplete="#{rich:component('popupRecentGrpMeter')}.show();">									
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-3" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initPopupGroupMeter"/>
											<a4j:actionparam name="fromPage" value="semmel006Page"/>
											<a4j:actionparam name="groupExpenseType" value="EL_POSTPAID"/>
											<a4j:actionparam name="groupOwnerGroup" value="#{uploadText.ownerGroup}"/>
											<a4j:actionparam name="groupFlagType" value="UP"/>
											<a4j:actionparam name="groupContractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<rich:column rendered="true">
								<f:facet name="header">
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.btnViewExpenseHis']}"  styleClass="rich-button" style="width:100px;" 
									oncomplete="#{rich:component('popupPaymentHistory')}.show(); return false"
									reRender="popupPaymentHistory"
									action="#{semmel005Action.doGetPaymentHist}">
										<a4j:actionparam name="contractNo" value="#{uploadText.contractNo}"/>
									</a4j:commandButton>
								</div>								
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel005Bean.uploadTextSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="29">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbUploadTextAll"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstUploadTextAll" 
											style="background-color: #cccccc;" />
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable Use -->
					</rich:panel>
				</h:panelGrid>
				</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/el/semmel005_popup.jsp"/>
<rich:modalPanel id="mdpConfirmCloseJobDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirmed Message"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmCloseJobDialog">
		<table width="150px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="150px">						
						<h:outputText value="#{semmel005Bean.confirmCloseJobValidateMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
						reRender="pnlSearchResult, frmError,pnlSumError" 	>
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL005-3" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
							<a4j:actionparam name="methodWithNavi" value="closeJobValidate" />							
							<rich:componentControl for="mdpConfirmCloseJobDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmCloseJobDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
	<jsp:include page="../../pages/el/semmel006percentGrowth-popup.jsp" />
	<jsp:include page="../../pages/el/semmel006ElGrpMeter-popup.jsp" />
</rich:modalPanel>