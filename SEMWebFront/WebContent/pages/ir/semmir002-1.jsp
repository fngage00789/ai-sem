<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../../pages/popup/multiProvince-popup.jsp" />

<f:loadBundle basename="resources.insurance.semmir002" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSrchAcquisitionDetail">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorDetail">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
						rendered="#{semmir002Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
				</rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearchDetail">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="65%" border="0" cellpadding="0" cellspacing="1">
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
			                			<td width="80%" valign="bottom" colspan="3">
			                			<a4j:region>
											<h:selectOneMenu id="ddlCompany" value="#{semmir002Bean.criteria.company}" onchange="GetCompany2JS();">
												<f:selectItems value="#{semmir002Bean.companyList}"/>
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompany2JS" reRender="companyDisplay"/>
											<rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmir002Bean.criteria.company}" styleClass="ms28"/>
										</a4j:region>
					                	</td>
				                	</tr>
									<tr>
										<td align="right" width="20%">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
										</h:panelGroup>
										</td><td width="30%">
											<h:selectOneMenu id="ddlNetworkType" value="#{semmir002Bean.criteria.networkType}">
												<f:selectItems value="#{semmir002Bean.networkTypeList}"/>
											</h:selectOneMenu>
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.transferType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlTransferType" value="#{semmir002Bean.criteria.transferType}">
												<f:selectItems value="#{semmir002Bean.transferTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr style="vertical-align:text-top;">
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText value="#{popupMultiProvinceBean.region}" />
										</td>
										<td align="right" width="20%">										
						               		<h:outputText id="lblProvince" value="#{jspMsg['label.province']} " styleClass="ms7"/>
						             	</td>
										<td align="left" width="30%">
											<rich:spacer width="7px"></rich:spacer>			
											<h:panelGrid id="criMultiProvince" 
														 columns="2" columnClasses="ms7">
												<a4j:region>
												<h:selectManyListbox id="criProvince" 
																	 size="#{popupMultiProvinceBean.delListSize/7}" styleClass="ms7"
																	 value="#{popupMultiProvinceBean.delList}" onchange="renderProvince();">
																	 
									        		<f:selectItems value="#{popupMultiProvinceBean.selectedList}"/>
									        		<a4j:jsFunction name="renderProvince" reRender="criProvince,pnlSearchCriteria"/>
									    		</h:selectManyListbox>
									    		</a4j:region>
												<h:panelGroup>
													<a4j:commandButton id="btnAddPolicyMultiProvince" styleClass="rich-button"
																	   value="..." action="#{navAction.navi}"
																	   reRender="popupMultiProvince" 
																	   oncomplete="#{rich:component('popupMultiProvince')}.show(); return false" >
									            		
									            		<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="multiProvince-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
														<a4j:actionparam name="methodWithNavi" value="initPopup" />
														<a4j:actionparam name="region" value="#{semmir002Bean.criteria.region}" />
												    </a4j:commandButton>&nbsp;
													<a4j:commandButton id="btnDelPolicyMultiProvince" styleClass="rich-button"
																	   value=" - " action="#{navAction.navi}"
																	   reRender="criMultiProvince, btnDelPolicyMultiProvince" 
																	   disabled="#{popupMultiProvinceBean.disabledDeleteProvinceMulti}" >
													  	
													  	<a4j:actionparam name="navModule" value="common" />
														<a4j:actionparam name="navProgram" value="multiProvince-popup" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupMultiProvince" />
														<a4j:actionparam name="methodWithNavi" value="doUpdateList" />
													</a4j:commandButton>
												</h:panelGroup>
											</h:panelGrid>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText value="#{semmir002Bean.criteria.locationId}" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText value="#{semmir002Bean.criteria.locationCode}" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText value="#{semmir002Bean.criteria.locationName}" />
										</td>
									</tr>
									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.asOfMonth']}" styleClass="ms7"/>
										</td><td width="80%" colspan="3">
											<h:inputText value="#{semmir002Bean.effMY}" onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
												onkeyup="addSlashForDate(this)" onblur="autoAddYear(this)" maxlength="7" size="7" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="frmErrorDetail,frmSearchDetail,frmResultDetail">
								<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR002-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmErrorDetail,frmSearchDetail,frmResultDetail">
			            		<a4j:actionparam name="navModule" value="ir" />
								<a4j:actionparam name="navProgram" value="SEMMIR002-1" />
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
			<a4j:form id="frmResultDetail">
				<table width="95%" cellpadding="0" cellspacing="0" border="0">
						<tr>
							<td align="right" width="25%">
				            	<a4j:commandButton id="btnImportFile"
								reRender="oppContent"
								value="#{jspMsg['btn.load']}" styleClass="rich-button"
								style="width:110"
								oncomplete="#{rich:component('popupImportFile')}.show(); return false" 
								action="#{navAction.navi}">
									<a4j:actionparam name="navModule" value="ir" />
									<a4j:actionparam name="navProgram" value="SEMMIR002-1" />
									<a4j:actionparam name="moduleWithNavi" value="ir" />
									<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
									<a4j:actionparam name="methodWithNavi" value="initPopupLoadExcel" />
								</a4j:commandButton><rich:spacer width="10"/>	
							</td>
						</tr>
					</table>
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 1000"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmir002Bean.msgDataNotFound}" rendered="#{semmir002Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbAcqDetail" cellpadding="1" cellspacing="0" border="0" 
							var="acqDetail"  value="#{semmir002Bean.resultList}" reRender="dtbAcqDetail" 
							rows="#{semmir002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmir002Action.getRowIdOnClick}" reRender="dtbAcqDetail">
								<a4j:actionparam name="rowId" value="#{acqDetail.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.networkTypeDesc}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkType']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.networkTypeDesc}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.company']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.company}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.transferTypeDesc}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.transferType']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.transferTypeDesc}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.region}" >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.region}" />
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.province}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.province']}" style="width: 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{acqDetail.province}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.locationId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.locationId}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.locationCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationCode']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.locationCode}" />
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationName']}" style="width: 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{acqDetail.locationName}" />
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.acqAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.acqCost']}" style="width: 100px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{acqDetail.acqAmt}">
										<f:convertNumber pattern="#,##0.000"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmir002Bean.tmpRowId==acqDetail.rowId)?'onClick':'unClick'}" 
								sortBy="#{acqDetail.asOfMonth}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.asOfMonth']}" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{acqDetail.asOfMonth}" />
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmir002Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="8">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbAcqDetail"
											maxPages="#{semmir002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											style="background-color: #cccccc;" 
											page="#{semmir002Bean.scrollerPage}" 
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

<rich:modalPanel id="popupImportFile" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Upload Info"></h:outputText>
    </f:facet>
	<a4j:form id="frmUploadInfo">
		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
				rendered="#{semmir002Bean.renderMsgFromImport}">
		 		<f:facet name="header">
                     <h:outputText value="Entered Data Status:"></h:outputText>
                </f:facet>
	 			<f:facet name="errorMarker">
	 				 <h:graphicImage value="images/error.gif" />  
                </f:facet>
		</rich:messages>
		<rich:panel>
			<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<h:panelGrid>
			  		<h:panelGroup>
			  		<table width="100%">
				<tr>
					<td align="left">
						<h:selectOneRadio styleClass="ms7" value="#{semmir002Bean.criteria.actionType}">
							<f:selectItem itemValue="U" itemLabel="#{jspMsg['label.radio1']}" />
				            <f:selectItem itemValue="A" itemLabel="#{jspMsg['label.radio2']}" />
						</h:selectOneRadio>
					</td>
					<td align="left">
						<h:selectBooleanCheckbox id="chkReNewFlag" value="#{semmir002Bean.criteria.reNewFlag}" />
						<h:outputText value="#{jspMsg['label.renewFlag']}" styleClass="ms7"/>
					</td>
				</tr>
				<tr>
					<td>
						<h:outputText value="#{jspMsg['label.networkType']}" styleClass="ms7"/>
						<rich:spacer width="5"/>
						<h:selectOneMenu id="ddlNetworkType" value="#{semmir002Bean.criteria.networkTypeExcel}">
							<f:selectItems value="#{semmir002Bean.networkTypeExcelList}"/>
						</h:selectOneMenu>
					</td>
				</tr>
				<tr>
					<td align="left">
						<h:outputText value="#{jspMsg['label.asOfMonth']}" styleClass="ms7"/>
						<rich:spacer width="5"/>
						<h:inputText value="#{semmir002Bean.criteria.asOfMonth}" onkeypress="return numberformat.keyPressFormatDateOnly(this,event)"
							onkeyup="addSlashForDate(this)" onblur="autoAddYear(this)" maxlength="7" size="7" />
					</td>
				</tr>
				<tr>
					<td align="left" colspan="4">
						<rich:fileUpload id="txtPicFileUpload" fileUploadListener="#{fileUploadBean.listenerNotChangeName}"
									listHeight="50" listWidth="300"
									addControlLabel="Browse..."
									immediate="true"
									immediateUpload="true" uploadButtonClassDisabled="true" cleanButtonClassDisabled="true"
									autoclear="true" acceptedTypes="xls,xlsx">
										<a4j:support event="onuploadcomplete" reRender="frmSearchIR008,frmConfirmDialog,frmUploadInfo" action="#{navAction.navi}" >
											<a4j:actionparam name="navModule" value="ir" />
											<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
											<a4j:actionparam name="moduleWithNavi" value="ir" />
											<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
											<a4j:actionparam name="methodWithNavi" value="initloadExcel" />
										</a4j:support>
										<a4j:support event="oncomplete" reRender="frmConfirmDialog"/>
										<rich:componentControl for="pnlConfirmDialog" operation="show" event="oncomplete" rendered="#{semmir002Bean.renderConfirm}"/>
										
										
											
						</rich:fileUpload>
						
					</td>
				</tr>
				<tr>
					<td align="left">
						<h:panelGrid columns="1" styleClass="contentlabelform">
							<a4j:commandButton id="btnPopupBack" value="Close" styleClass="rich-button" immediate="true">
							    <rich:componentControl for="popupImportFile" operation="hide" event="onclick" />
							</a4j:commandButton>
						</h:panelGrid>
					</td>
				</tr>
			</table>	
			</h:panelGroup></h:panelGrid></table>
		</rich:panel>
	</a4j:form>
</rich:modalPanel>

<a4j:form id="frmConfirmDialog">
<rich:modalPanel id="pnlConfirmDialog" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="Confirm Copy"></h:outputText>
    </f:facet>
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="300px">
						<h:outputText value="#{semmir002Bean.confirmLoadExcelMsg}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="3" styleClass="contentlabelform">
						<a4j:commandButton id="btnImportYes" value="Yes" styleClass="rich-button" immediate="true" action="#{navAction.navi}"
						 reRender="frmError,frmSearchIR008"
						 oncomplete="#{rich:component('pnlConfirmDialog')}.hide();
						 				#{rich:component('popupImportFile')}.hide(); return false">						
								<a4j:actionparam name="navModule" value="ir" />
		            			<a4j:actionparam name="navProgram" value="SEMMIR002" />	
								<a4j:actionparam name="moduleWithNavi" value="ir" />
								<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
								<a4j:actionparam name="methodWithNavi" value="loadExcel" />
						</a4j:commandButton>
						<rich:spacer width="5"/>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true" action="#{navAction.navi}" reRender="frmConfirmDialog,txtPicFileUpload">
							<a4j:actionparam name="navModule" value="ir" />
	            			<a4j:actionparam name="navProgram" value="SEMMIR002" />	
							<a4j:actionparam name="moduleWithNavi" value="ir" />
							<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
							<a4j:actionparam name="methodWithNavi" value="doCancelExport" />
						    <rich:componentControl for="pnlConfirmDialog" operation="hide" event="onclick" rendered="txtPicFileUpload"/>
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
<h:panelGrid id="pnlLoadExcel" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlgLoadSave" rendered="#{semmir002Bean.renderLoadExcel}" style="height:0px;width:0px;" >
			<a4j:commandButton id="btnLoadExcel" style="height:0px;width:0px;display:none;" action="#{navAction.navi}" reRender="frmError,frmSearchIR008" 
			oncomplete="#{rich:component('popupImportFile')}.hide(); return false"
			immediate="true">
				<a4j:actionparam name="navModule" value="ir" />
       			<a4j:actionparam name="navProgram" value="SEMMIR002" />	
				<a4j:actionparam name="moduleWithNavi" value="ir" />
				<a4j:actionparam name="actionWithNavi" value="SEMMIR002" />
				<a4j:actionparam name="methodWithNavi" value="doEndExport" />
			</a4j:commandButton>
		<script>document.getElementById('incContent:frmConfirmDialog:btnLoadExcel').click();</script>
	</h:panelGroup>
	<h:panelGroup id="pnlShowConfirm" rendered="#{semmir002Bean.renderConfirm}" style="height:0px;width:0px;" >
		<a4j:commandButton id="btnShowConfirm" style="height:0px;width:0px;display:none;" reRender="frmSearchIR008" 
		oncomplete="#{rich:component('pnlConfirmDialog')}.show(); return false"
		immediate="true">
		</a4j:commandButton>
		<script>document.getElementById('incContent:frmConfirmDialog:btnShowConfirm').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>