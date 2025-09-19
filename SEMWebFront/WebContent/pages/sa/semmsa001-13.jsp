
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->

		<rich:panel id="panelWrapper001-13" style="border:1 e0e0e0 solid; height:100%;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa16'}">
				<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_waitingForApproveTerminate']} [semmsa001-13]"/>
					</f:facet>
				<!-- << header content 2 -->
				
				<!-- >> table result -->
				
				<rich:panel id="tabResult_001-13" styleClass="sem_autoScrollbarInTodoSA">
					<a4j:form id="frmSearchResult_001-13">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabLeadAssign_001-13" cellpadding="1" cellspacing="0" border="0" 
						var="waitingApprLst"  value="#{semmsa001Bean.siteAppList}" reRender="dataTabLeadAssign_001-13, dataScrllLeadAssign_001-13" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
						
							<!-- detail -->
							<rich:column style="text-align:center;">
								<f:facet name="header">
									<a4j:region>
										<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;" rendered="false">
											<a4j:support event="onclick" action="#{semmsa001Action.selectAllRow}" 
											reRender="dataTabLeadAssign_001-13, msa001-13_btnClrBtch, msa001-13_apprLeader">
												<a4j:actionparam name="paramPage" value="msa001-13" />
												<a4j:actionparam name="paramObjectType" value="siteAppr" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</a4j:region>
								</f:facet>
								<a4j:region>
									<h:selectBooleanCheckbox id="chkSelect" value="#{waitingApprLst.checkBox}">
										<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
										reRender="dataTabLeadAssign_001-13, msa001-13_btnClrBtch, msa001-13_apprLeader">
											<a4j:actionparam name="paramObjectType" value="siteAppr" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</a4j:region>
							</rich:column>
							
							<rich:column style="text-align:center;">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_save']}"/>
								</f:facet>
								<a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height:15px; width:15px;" 
								reRender="oppContent">
									<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									
									<a4j:actionparam name="rowId" value="#{waitingApprLst.dataObj.rowId}" />
									<a4j:actionparam name="paramFwdUrl" value="#{item.menuUrl}" />
									<a4j:actionparam name="paramMode" value="E" />
								</a4j:commandButton>
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_location']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.region}" />
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_company']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.company}" />
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_approveNumber']}/#{jspMsg['column.header.th_cancel']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.docNo}" />
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth_100">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_contractNumber']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.contractNo}" />
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.locationId}" />
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationName']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.locationNameTh}" style="width:200px;"/>
							</rich:column>
							
							<rich:column headerClass="headerFilterWidth">
								<f:facet name="header">
									<h:outputText value="Site Name/Site Code/Site Type/Station Type" style="white-space:nowrap" />
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.siteDetail}" escape="false" />
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth_120">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_number']} Batch"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.batchNo}" />
							</rich:column>
							
							<rich:column style="text-align:center;" headerClass="headerFilterWidth">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_type_approve']}/#{jspMsg['column.header.th_type_subject']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.reqDocType}" />
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_from']}"/>
								</f:facet>
								<h:outputText value="#{waitingApprLst.dataObj.reqOfficer}" style="width:200px;"/>
							</rich:column>
		                    <!-- detail -->
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsa001Bean.siteAppList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="9">
										<a4j:region>
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabLeadAssign_001-13"
												maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllLeadAssign_001-13" style="background-color: #cccccc;"
												page="#{semmsa001Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmSearchResult_001-13"></a4j:support>
											</rich:datascroller>
										</a4j:region>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
						</rich:dataTable>
					</a4j:region>
					</a4j:form>
				</rich:panel>
				
				<a4j:form id="frm_msa001-13_Btn">
	
					<table style="width:98%; background-color:d0d0d0;">
						<tr>
							<td style="width:100%; border:1px solid e0e0e0;">
								<a4j:commandButton  value="#{jspMsg['label.th_export_worker']}" 
								reRender="panelWrapper_tree, panelWrapper_content, show_report"
								disabled="#{semmsa001Bean.disabledBtnExport}" action="#{semmsa001Action.doExportWorker}" styleClass="rich-button">
									<a4j:actionparam name="paramPage" value="msa001-13" />
								</a4j:commandButton>
								
								<a4j:commandButton id="msa001-13_btnClrBtch" value="Clear Batch No." 
								reRender="panelWrapper_tree, panelWrapper_content" 
								action="#{semmsa001Action.doClearBatch}" disabled="#{semmsa001Bean.disabledChecked}" styleClass="rich-button"
								oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
									<a4j:actionparam name="paramPage" value="msa001-13" />
								</a4j:commandButton>
								
								<a4j:commandButton id="msa001-13_apprLeader" value="Approve to Leader" 
								reRender="panelWrapper_tree, panelWrapper_content" 
								action="#{semmsa001Action.doApproveToLeader}" disabled="#{semmsa001Bean.disabledChecked}" styleClass="rich-button"
								oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
									<a4j:actionparam name="paramPage" value="msa001-13" />
								</a4j:commandButton>
							</td>
						</tr>
					</table>
				</a4j:form>
				
				<!-- << table result -->
				
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->