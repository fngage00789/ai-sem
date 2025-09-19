<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel003-1" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.uploadMeterInformation']}"/>
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" style="width: 95%" border="0">
				<!-- begin content layout criteria -->
				<a4j:form id="frmSearch">
				
				<h:panelGrid  border="0">
					
					<rich:panel id="pnlSearchCriteria" >
						
						<h:panelGrid id="grdSearchCommand" style="width: 95%" border ="0">
							<h:panelGroup>
							<table  align="right" border="0">
							<tr>
							<td align="right">
							<a4j:commandButton id="btnContinue" value="#{jspMsg['btn.continute']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel003Bean.renderer['btnContinue']}">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL003-2" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
								<a4j:actionparam name="methodWithNavi" value="doContinute" />
							</a4j:commandButton>
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="oppContent">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL003-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
			            	</td>
			            	</tr>	
						</table>
						</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="0">
							<h:panelGroup>
								<table width="100%" align="right">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td width="30%">
											<rich:fileUpload id="btnBrowse" fileUploadListener="#{semmel003Action.listener}"
											              maxFilesQuantity="1"
											              listHeight="58"
														  listWidth="265px"
											              addControlLabel="Browse..."
											              acceptedTypes="xls,xlsx"
											              rendered="#{semmel003Bean.renderer['btnBrowse']}">
											              <a4j:support event="onuploadcomplete" reRender="pnlImportResult,pnlUploadMeter" />
								         </rich:fileUpload>
										</td>
									</tr>	
								</table>
							</h:panelGroup>
						</h:panelGrid>
				
				<h:panelGrid  border="0" cellpadding="0" cellspacing="0" width="95%">
					<rich:panel id="pnlImportResult">								
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.meterImportDetail']}"/>
						</f:facet>						
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fileName']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText id="txtTotalSiteMeter" value="#{semmel003Bean.uploadMeterFile.fileName}" 
												styleClass="ms7"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.allRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText id="txtTotalSiteBG" value="#{semmel003Bean.uploadMeterFile.totalNo}" 
												styleClass="ms7"/>
										</td>
									</tr>									
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.passRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText id="txtTotalSiteDecrease" value="#{semmel003Bean.uploadMeterFile.successNo}" 
												styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['column.failedRecordAmt']}" styleClass="ms7"/>
										</td>
										<td colspan="3">
											<h:outputText value="#{semmel003Bean.uploadMeterFile.failedNo}" styleClass="ms7" rendered="#{!semmel003Bean.uploadMeterFile.error}"/>
											<a4j:commandLink id="hypShowFail" value="#{semmel003Bean.uploadMeterFile.failedNo}" rendered="#{semmel003Bean.uploadMeterFile.error}" action="#{navAction.navi}" 
											reRender="popupViewFailedRecord" oncomplete="#{rich:component('popupViewFailedRecord')}.show(); return false" >
												
											</a4j:commandLink>
										</td>
									</tr>
									<tr>
										
									</tr>
									<tr>
										
									</tr>
									<tr>
										
									</tr>										
									<tr>
										
									</tr>	
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						
					</rich:panel>
					
				</h:panelGrid>
				<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="0">
				<rich:panel id="pnlSearchResultHeader">
				
				<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.meerImportPass']}"></h:outputText>
				</f:facet>
					
					<rich:panel id="pnlUploadMeter" styleClass="sem_autoScrollbar"  >
					
					<rich:dataTable id="dtbUploadMeter"  cellpadding="0" cellspacing="0" border="3" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterFile.uploadMeterList}" 
								reRender="dtbUploadMeter" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}" />
									</f:facet>
									<div align="left">
										<h:outputText value="#{uploadMeter.itemNo}"/>
									</div>
								</rich:column>
									<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.contractNo']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.contractNo}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationID']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.locationId}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.locationCode']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.locationCode}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.siteName']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.siteName}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.supSendDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.supSendDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>	
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.supplier']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.supplier}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.transformerLabel']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.transformerLabel}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.transformerSize']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.transformerSize}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.transformerSerial']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.transformerSerial}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.transformerDt']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.transformerDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.meterSize']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.meterSize}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.meterWire']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.meterWire}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.onMeterDt']}" />
											
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.onMeterDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
										</h:outputText>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaCode']}"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.areaCode}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.meterId']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.meterId}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.areaName']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.areaName}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.touDemand']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.meterType}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.rate']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.rate}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.remark']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.remark}"/>
									</div>
								</rich:column>
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.siteCode']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.siteCode}"/>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeter" 
										maxPages="10" id="dstSiteApprove" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>
							</rich:panel>
							
							</rich:panel>
						</h:panelGrid>
					
					</rich:panel>
					</h:panelGrid>
					</a4j:form>
				
				<!-- end content layout criteria -->
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<rich:modalPanel id="popupViewFailedRecord" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['popup.header.failedLine']}"></h:outputText>
    </f:facet>

	<h:panelGrid>
		</h:panelGrid>
	
		<table width="200px" border="0" cellspacing="" cellpadding="2">			
			
			<tr>
				<td align="left">
					<h:outputText value="#{jspMsg['popup.label.itemNo']}" styleClass="ms7"></h:outputText>&nbsp;
					<h:outputText value="#{semmel003Bean.uploadMeterFile.failedLine}" styleClass="ms7" />					
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<a4j:commandButton value="#{jspMsg['popup.btn.close']}" styleClass="rich-button" action="#{navAction.navi}" >
					    <rich:componentControl for="popupViewFailedRecord" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
</rich:modalPanel>
