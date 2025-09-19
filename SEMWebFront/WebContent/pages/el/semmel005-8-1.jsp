<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.el.semmel005-1" var="jspMsg"/>
<h:panelGrid width="100%" id="pnlSemmel0051">
	<rich:panel id="pnlSearchFyRate">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.searchFtRate']}"/></f:facet>
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
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.startEffectiveDt']}" styleClass="ms7"/>
										</td><td width="25%">
											<rich:calendar id="cldUploadMeterDtFrom" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.startDt}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUProcessDtTo');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUploadMeterDtFrom','cldUProcessDtTo');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td><td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.endEffectiveDt']}" styleClass="ms7"/>
										</td>
										<td width="25%">
											<rich:calendar id="cldUProcessDtTo" locale="th/TH" enableManualInput="true" 
												datePattern="dd/MM/yyyy" value="#{semmel005Bean.endDt}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','cldUProcessDtTo','cldUploadMeterDtFrom');"
											    oncollapse="validateRichCalendarFromTo('frmSearch','cldUProcessDtTo','cldUploadMeterDtFrom');"
												showWeeksBar="false" inputStyle="width:120px;"/>
										</td>
									</tr>
									
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" 
								reRender="pnlSearchImportTrans,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-8-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doSearchElectricFTRate" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" 
			            	 	reRender="oppContent">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-8-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="calculateFTRateInit" />
			            	</a4j:commandButton>
			            	<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" 
			            	 	reRender="oppContent">
			            		<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL005-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
								<a4j:actionparam name="methodWithNavi" value="doClear8" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
			<a4j:form id="frmResult">
				<h:panelGrid columns="3" id="addNewCommand">
							<a4j:commandButton id="addNew" value="Create FT Rate" styleClass="rich-button" 
								action="#{navAction.navi}" 
								reRender="oppContent"
								>
								<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-8-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005"/>
											<a4j:actionparam name="methodWithNavi" value="intUpdateFtRate" />
										    <a4j:actionparam name="actionType" value="01" />
							</a4j:commandButton>
							
						</h:panelGrid>
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.listFtRateData']}" style="width: 900px"/>
						</f:facet>
						
						<!-- begin dataTable -->
						<rich:dataTable id="dtbFTData" width="100%" cellpadding="1" cellspacing="0" border="0" 
							var="ftRate"  value="#{semmel005Bean.ftRateList}" 
							rows="#{semmel005Bean.rowPerPage}" 
							rowClasses="cur" 
							styleClass="dataTable"
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowKeyVar="row">
											
							
							<!-- begin column -->
							<rich:column id="colEdit" sortBy="#{ftRate.seqNo}" 
							style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="Edit" value="Edit" style="width: 10"
									
									/>
								</f:facet>
								<div align="center">
									
									<a4j:commandLink id="hypEdit" value="Edit" 
									rendered="false"
									action="#{navAction.navi}" 
										reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-8-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005"/>
											<a4j:actionparam name="methodWithNavi" value="init3" />
											<a4j:actionparam name="rowId" value="#{ftRate.serviceRateID}" />
										</a4j:commandLink>
										<a4j:commandButton 
											action="#{navAction.navi}" 
											reRender="oppContent"
	            					    	image="images/edit.png" style="height: 15; width: 15"
	            							>
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL005-8-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL005"/>
											<a4j:actionparam name="methodWithNavi" value="intUpdateFtRate" />
										    <a4j:actionparam name="rowId" value="#{ftRate.serviceRateID}" />
										    <a4j:actionparam name="actionType" value="02" />
										    
	            					</a4j:commandButton>          						
								</div>								
							</rich:column>						
							<rich:column id="colseqNo" sortBy="#{ftRate.seqNo}" 
							style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="seqNo" value="#{jspMsg['column.seqNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputSeqNo" value="#{ftRate.seqNo}"/>
								</div>
							</rich:column>
							<rich:column id="colStratDt" sortBy="#{ftRate.seqNo}" 
							style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="stratDt" value="#{jspMsg['column.strtEffectiveDt']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputStratDt" value="#{ftRate.txtStartTH}"/>
								</div>
							</rich:column>
							<rich:column id="colEndDt" sortBy="#{ftRate.seqNo}" 
							style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="endDt" value="#{jspMsg['column.endEffectiveDt']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputEndDt" value="#{ftRate.txtEndTH}"/>
								</div>
							</rich:column>
							<rich:column id="colsFtRate" sortBy="#{ftRate.seqNo}" 
							style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="ftRate" value="#{jspMsg['column.ftRate']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputFtRate" value="#{ftRate.ftRateType}"/>
								</div>
							</rich:column>
							<rich:column id="colStatus" sortBy="#{ftRate.seqNo}" 
							style="#{(semmel005Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								<f:facet name="header">
									<h:outputText id="status" value="#{jspMsg['column.recordStatus']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText id="outputStatus" value="#{ftRate.recordStatus}"/>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbFTData" 
									maxPages="10" id="dsFtRate" selectedStyleClass="selectScroll" />
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
						reRender="dtFT, frmError" 	>
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
	</a4j:form>
</rich:modalPanel>