<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel003-2" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.uploadMeterInformation']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<div align="right">
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.confirm']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="oppContent">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL003-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
								<a4j:actionparam name="methodWithNavi" value="doConfirm" />
							</a4j:commandButton>
							
							<h:commandButton id ="btnExport" action="#{semmel003Action.exportError}"  
	            			styleClass="rich-button" value="#{jspMsg['btn.export']}"
	            			rendered="true"
	            			/>			
	            			
							
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.Cancel']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="oppContent">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL003-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL003" />
								<a4j:actionparam name="methodWithNavi" value="doCancel" />
			            	</a4j:commandButton>
						</h:panelGrid>
						</div>

				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlUploadMeter" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.success']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterSuccess"  cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterSuccessList}" reRender="dtbUploadMeterSuccess" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterSuccess" 
										maxPages="10" id="dstUploadMeterSuccess" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
							
											
							</rich:panel>
							<rich:panel id="pnlUploadMeterELMTR06" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR06']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR06" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR06List}" reRender="dtbUploadMeterELMTR06" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
								</rich:column>								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR06" 
										maxPages="10" id="dstUploadMeterELMTR06" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>								
											
							</rich:panel>
							<rich:panel id="pnlUploadMeterFailMandatory" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR01']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterFailMandatory" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR01List}" reRender="dtbUploadMeterFailMandatory" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
								</rich:column>								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterFailMandatory" 
										maxPages="10" id="dstUploadMeterFailMandatory" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
							
											
							</rich:panel>
							
							<rich:panel id="pnlUploadMeterELMTR02" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR02']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR02" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR02List}" reRender="dtbUploadMeterELMTR02" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR02" 
										maxPages="10" id="dstUploadMeterELMTR02" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
							
											
							</rich:panel>
							
					<rich:panel id="pnlUploadMeterELMTR03" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR03']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR03" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR03List}" reRender="dtbUploadMeterELMTR03" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR03" 
										maxPages="10" id="dstUploadMeterELMTR03" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
							
											
							</rich:panel>
							
					<rich:panel id="pnlUploadMeterELMTR04" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR04']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR04" width="95%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR04List}" reRender="dtbUploadMeterELMTR04" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.processStatus']}" />
									</f:facet>
									<div align="center">
										<h:outputText value="#{uploadMeter.processStatusDesc}"/>
									</div>
								</rich:column>
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR04" 
										maxPages="10" id="dstUploadMeterELMTR04" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
							
											
							</rich:panel>
							
					<rich:panel id="pnlUploadMeterELMTR05" styleClass="sem_autoScrollbar" rendered="false">
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR05']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR05" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR05List}" reRender="dtbUploadMeterELMTR05" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR05" 
										maxPages="10" id="dstUploadMeterELMTR05" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>								
											
							</rich:panel>
							
					
							
					<rich:panel id="pnlUploadMeterELMTR07" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR07']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR07" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR07List}" reRender="dtbUploadMeterELMTR07" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
								</rich:column>								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR07" 
										maxPages="10" id="dstUploadMeterELMTR07" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>								
											
							</rich:panel>
							
					<rich:panel id="pnlUploadMeterELMTR08" styleClass="sem_autoScrollbar" >
					<f:facet name="header">
				    	<h:outputText value="#{jspMsg['header.ELMTR08']}"></h:outputText>
				    </f:facet>
					<rich:dataTable id="dtbUploadMeterELMTR08" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR08List}" reRender="dtbUploadMeterELMTR08" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR08" 
										maxPages="10" id="dstUploadMeterELMTR08" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>								
				
							</rich:panel>
							
							<rich:panel id="pnlUploadMeterELMTR09" styleClass="sem_autoScrollbar" >
							<f:facet name="header">
				    		<h:outputText value="#{jspMsg['header.ELMTR09']}"></h:outputText>
				    </f:facet>
				    <rich:dataTable id="dtbUploadMeterELMTR09" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR09List}" reRender="dtbUploadMeterELMTR09" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR09" 
										maxPages="10" id="dstUploadMeterELMTR09" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
				    
				    
					</rich:panel>	
					
							<rich:panel id="pnlUploadMeterELMTR10" styleClass="sem_autoScrollbar" >
							<f:facet name="header">
				    		<h:outputText value="#{jspMsg['header.ELMTR10']}"></h:outputText>
				    </f:facet>
				    <rich:dataTable id="dtbUploadMeterELMTR10" width="90%" cellpadding="1" cellspacing="0" border="0" 
								var="uploadMeter"  value="#{semmel003Bean.uploadMeterELMTR10List}" reRender="dtbUploadMeterELMTR10" 
								rowKeyVar="rowIndex"
								rows="#{semmel010_2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								<rich:column>
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.result.lineNo']}"/>
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
									<rich:datascroller immediate="true" rendered="true" align="center" for="dtbUploadMeterELMTR10" 
										maxPages="10" id="dstUploadMeterELMTR10" selectedStyleClass="selectScroll" />
								</f:facet>
							</rich:dataTable>	
				    
				    
					</rich:panel>	
				</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
			
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

