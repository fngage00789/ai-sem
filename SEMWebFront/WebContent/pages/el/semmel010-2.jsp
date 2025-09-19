<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel010-2" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSemmel010_2">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.bgMEAPEA']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmErrorRenew">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
					
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<a4j:form id="frmSearchRenew">
				<h:panelGrid id="grdBG" width="95%" columns="2">
				<rich:panel id="pnlSearchCriteria2">
				<div align="right"><a4j:commandButton id="btnSaveDraft" value="#{jspMsg['btn.saveDraft']}" styleClass="rich-button" 
	            	action="#{navAction.navi}"  reRender="pnlSemmel010_2" 
	            	style="width:75" disabled="#{semmel010_2Bean.disableBtnSaveDraft}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL010-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
						<a4j:actionparam name="methodWithNavi" value="doSaveDraft" />
					</a4j:commandButton>
					
					<h:commandButton id ="btnExport" action="#{semmel010Action.doExportExcel}"  
	            					 style="width:75" styleClass="rich-button" 
	            					 value="#{jspMsg['btn.export']}" disabled="#{semmel010_2Bean.disableBtnExport}"/>
					<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
	            	action="#{navAction.navi}" style="width:75" reRender="oppContent" disabled="#{semmel010_2Bean.disableBtnSave}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL010-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
						<a4j:actionparam name="methodWithNavi" value="doSave" />
					</a4j:commandButton>
					<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
	            	action="#{navAction.navi}"   reRender="oppContent"  style="width:75" disabled="#{semmel010_2Bean.disableBtnCancel}">
					    <a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL010-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
						<a4j:actionparam name="methodWithNavi" value="initEL010" />
					</a4j:commandButton></div></rich:panel></h:panelGrid>
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">								
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.bgDetail']}"/>
						</f:facet>						
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="0">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td>&nbsp;</td>
										<td colspan="3"><a4j:commandButton id="btnSiteDetail" value="#{jspMsg['btn.siteDetail']}" styleClass="rich-button" 
											            	action="#{navAction.navi}" style="width:150" 
											            	disabled="#{semmel010_2Bean.disableBtnSiteDetail}" 
											            	oncomplete="#{rich:component('mdpSiteDetail')}.show(); return false" reRender="mdpSiteDetail">
															    <a4j:actionparam name="navModule" value="el" />
																<a4j:actionparam name="navProgram" value="SEMMEL010-1" />
																<a4j:actionparam name="moduleWithNavi" value="el" />
																<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
																<a4j:actionparam name="methodWithNavi" value="doPupupSiteDetail" />
															</a4j:commandButton></td>
									</tr>
									<tr>
										<td align="right" width="20%">
										    <h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.startDt']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldStartDtFrom" 
												locale="th/TH" enableManualInput="false" 
												datePattern="dd/MM/yyyy" value="#{semmel010_2Bean.startDt}" 
												oninputblur="validateRichCalendarFromTo('frmSearchRenew','cldStartDtFrom','cldstartDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearchRenew','cldStartDtFrom','cldstartDtTo');"
												showWeeksBar="false" inputStyle="width:120px;" 
												disabled="#{semmel010_2Bean.disableStartDt}"/>
										</td><td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
										</td><td width="30%">
											<rich:calendar id="cldstartDtTo" locale="th/TH" enableManualInput="false" 
												datePattern="dd/MM/yyyy" value="#{semmel010_2Bean.endDt}" 
												oninputblur="validateRichCalendarFromTo('frmSearchRenew','cldstartDtTo','cldStartDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearchRenew','cldstartDtTo','cldStartDtFrom');"
												showWeeksBar="false" inputStyle="width:120px;" 
												disabled="#{semmel010_2Bean.disableEndDt}"/>
										</td>
									</tr>																	
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.bgAmt']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtBgAmt" value="#{semmel010_2Bean.bgAmt}" style="width:120px;" 
											maxlength="15" disabled="#{semmel010_2Bean.disableBgAmt}" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
											onblur="return numberformat.moneyFormat(this);"
											styleClass="inputRight">
											<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
										</h:inputText>
										</td><td align="right" width="20%">&nbsp;</td>
										<td width="30%">&nbsp;</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.contractorAddress']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputTextarea id="txtReceiveBgRemark" style="width:300px;" value="#{semmel010_2Bean.contractorAddress}" disabled="#{semmel010_2Bean.disableContractorAddress}"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											
											<h:outputText value="#{jspMsg['label.totalSiteMeter']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputText id="txtTotalSiteMeter" value="#{semmel010_2Bean.totalSiteMeter}" 
												style="width:120px;" maxlength="15" disabled="true"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:graphicImage value="images/icon_required.gif"/>
											<h:outputText value="#{jspMsg['label.totalSiteBG']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputText id="txtTotalSiteBG" value="#{semmel010_2Bean.totalSiteBG}" 
												style="width:120px;" maxlength="15" disabled="#{semmel010_2Bean.disableTotalSiteBG}">
												<f:convertNumber pattern="#,##0" maxIntegerDigits="13" maxFractionDigits="2" />
												<a4j:support event="onchange" action="#{navAction.navi}" ajaxSingle="true" 
												reRender="txtTotalSiteChange, txtTotalSiteRemain">
											   		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL010-2" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
													<a4j:actionparam name="methodWithNavi" value="doCalSite" />
													<a4j:actionparam name="inputName" value="totalSiteBG" />
											</a4j:support>
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalSiteAdd']}" styleClass="ms7"
											rendered="false"
											/>
										</td><td width="30%" colspan="3">
											<h:inputText id="txtTotalSiteAdd" value="#{semmel010_2Bean.totalSiteAdd}" 
												style="width:120px;" maxlength="15" disabled="true"
												rendered="false"
												/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalSiteDecrease']}" styleClass="ms7"
											rendered="false"
											/>
										</td><td width="30%" colspan="3">
											<h:inputText id="txtTotalSiteDecrease" value="#{semmel010_2Bean.totalSiteDecrease}" 
												style="width:120px;" maxlength="15" disabled="true"
												rendered="false"
												/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalSiteRemain']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputText id="txtTotalSiteRemain" value="#{semmel010_2Bean.totalSiteRemain}" 
												style="width:120px;" maxlength="15" disabled="true">
												<f:convertNumber pattern="#,##0" maxIntegerDigits="13" maxFractionDigits="2" />
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.totalSiteChange']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputText id="txtTotalSiteChange" value="#{semmel010_2Bean.totalSiteChange}" 
												style="width:120px;" maxlength="15" disabled="#{semmel010_2Bean.disableTotalSiteChange}">
												<f:convertNumber pattern="#,##0" maxIntegerDigits="13" maxFractionDigits="2" />
												<a4j:support event="onchange" action="#{navAction.navi}" ajaxSingle="true" reRender="txtTotalSiteRemain, txtTotalSiteBG">
											   		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL010-2" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
													<a4j:actionparam name="methodWithNavi" value="doCalSite" />
													<a4j:actionparam name="inputName" value="totalSiteChange" />
												</a4j:support>
											</h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputTextarea id="txtRemark" style="width:300px;" value="#{semmel010_2Bean.remark}" disabled="#{semmel010_2Bean.disableRemark}"/>
										</td>
									</tr>										
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.bgStatus']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:selectOneMenu id="ddlBgStatus" value="#{semmel010_2Bean.bgStatus}" style="width:120px;" disabled="true">
												<f:selectItems value="#{semmel010_2Bean.bgStatusList}"/>
											</h:selectOneMenu>
										</td>
									</tr>	
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid></a4j:form>
				<!-- end content layout criteria -->
				<h:panelGrid width="90%">				
					<a4j:form id="frmReceiveBG">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.receiveBG']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.receiveBG.bgNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtBgNo" value="#{semmel010_2Bean.bgNo}" 
												style="width:120px;" maxlength="15" disabled="true"/>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.receiveBG.bankName']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtBankName" value="#{semmel010_2Bean.bankNameDisplay}" 
												style="width:240px;" maxlength="15" disabled="true"/>
										</td>
									</tr>																	
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.receiveBG.remark']}" styleClass="ms7"/>
										</td><td width="30%" colspan="3">
											<h:inputTextarea id="txtReceiveBgRemark" style="width:300px;" value="#{semmel010_2Bean.receiveBgRemark}" disabled="true" />
										</td>
									</tr>							
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<h:panelGrid width="90%">
					<a4j:form id="frmSaveFile">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.saveFile']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%" align="right">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td width="30%">
							              <rich:fileUpload 
							              fileUploadListener="#{semmel010Action.uploadFileListener}" 
							              id="uplFileName" 
							              maxFilesQuantity="5" 
							              listHeight="150px" 
							              autoclear="true" 
							              uploadControlLabel="#{jspMsg['btn.addFile']}" 
							              disabled="#{semmel010_2Bean.disableBtnUploadFile}">
										 <a4j:support event="onuploadcomplete" 
										 reRender="dtbFileList" />
										</rich:fileUpload>
										</td>
									
									
									</tr>
									
										
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					<rich:panel id="pnlFileList">
							
								<table width="100%">
									<tr>
										<td>
											<h:outputText value="#{jspMsg['header.listFile']}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td>
											<rich:dataTable id="dtbFileList" width="95%" cellpadding="1" cellspacing="0" border="0" 
												var="fileInfo" value="#{semmel010_2Bean.bgMasterFileList}" 
												reRender="dtbFileList" 
												rowKeyVar="row"
												onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
												onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
												styleClass="contentform" >
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.action']}" />
													</f:facet>
													<div align="center">
														<a4j:commandLink value="#{jspMsg['label.delete']}" 
														action="#{navAction.navi}" 
														reRender="pnlFileList"
														rendered="#{semmel010_2Bean.disableDeletFile}"
														>
															<a4j:actionparam name="navModule" value="el" />
							            					<a4j:actionparam name="navProgram" value="SEMMEL010-2" />	
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL010" />
															<a4j:actionparam name="methodWithNavi" value="doDeleteFile" />
															<a4j:actionparam name="deleteIndex" value="#{row}" />
														</a4j:commandLink>
													</div>
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.fileName']}" />
													</f:facet>
													<div align="left">
														<h:commandLink action="#{navAction.doDownload}"  
			 									   		value="#{fileInfo.fileName}" 
			 									  		 >
						 								<f:param name="pathName" value="#{fileInfo.filePath}"/>	
						 								<f:param name="fileName" value="#{fileInfo.fileName}"/>
								         			</h:commandLink>     
													</div>
														
													
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.saveName']}" />
													</f:facet>
													<div align="left">
														<h:outputText value="#{fileInfo.createBy}" styleClass="ms7" />
													</div>
												</rich:column>
												<rich:column>
													<f:facet name="header">
														<h:outputText value="#{jspMsg['column.saveDt']}" />
													</f:facet>
													<div align="center">
														<h:outputText value="#{fileInfo.createDt}" styleClass="ms7" />
													</div>
												</rich:column>
											</rich:dataTable>
										</td>
									</tr>
								</table>
								
							</rich:panel>
						<rich:panel id="pnlLog">
					
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
						
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel010_2Bean.bgMaster.createBy}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel010_2Bean.bgMaster.createDt}" styleClass="ms7">
												<f:convertDateTime pattern="dd/MM/yyyy" locale="th//TH"/>
											</h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel010_2Bean.bgMaster.updateBy}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.updateDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel010_2Bean.bgMaster.updateDt}" styleClass="ms7">
												<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th//TH"/>
											</h:outputText>
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpSiteDetail" autosized="true" width="700">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.siteDetail']}"></h:outputText>
    </f:facet>
    <a4j:form id="a4jfSiteDetail">
	<rich:dataTable id="dtbSiteApprove" width="100%" cellpadding="1" cellspacing="0" border="0" 
				var="bgMaster"  value="#{semmel010_2Bean.bgMasterSPELList}" 
				reRender="dtbSiteApprove" 
				rowKeyVar="rowIndex"
				rows="10" 
				rowClasses="cur" 
				styleClass="dataTable">
				<rich:column>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.popup.contractNo']}" style="width: 100"/>
					</f:facet>
					<div align="left">
						<h:outputText value="#{bgMaster.contractNo}"/>
					</div>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.popup.siteName']}" style="width: 100"/>
					</f:facet>
					<div align="center">
						<h:outputText value="#{bgMaster.siteName}"/>
					</div>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.popup.meterId']}" style="width: 150"/>
					</f:facet>
					<div align="center">
						<h:outputText value="#{bgMaster.meterId}"/>
					</div>
				</rich:column>
				<rich:column>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.popup.eAreaCode']}" style="width: 10"/>
					</f:facet>
					<div align="center">
						<h:outputText value="#{bgMaster.eAreaCode}"/>
					</div>
				</rich:column>	
				<rich:column>
					<f:facet name="header">
						<h:outputText value="#{jspMsg['column.popup.eAreaName']}" style="width: 10"/>
					</f:facet>
					<div align="center">
						<h:outputText value="#{bgMaster.eAreaName}"/>
					</div>
				</rich:column>
				<f:facet name="footer">
					<rich:datascroller immediate="true" rendered="true" align="center" for="dtbSiteApprove" 
						maxPages="10" id="dstSiteApprove" selectedStyleClass="selectScroll" />
				</f:facet>
			</rich:dataTable>
			<a4j:commandButton value="#{jspMsg['btn.popup.close']}" styleClass="rich-button" action="#{navAction.navi}" >						
			    <rich:componentControl for="mdpSiteDetail" operation="hide" event="onclick" />
			</a4j:commandButton>
	</a4j:form>
</rich:modalPanel>

