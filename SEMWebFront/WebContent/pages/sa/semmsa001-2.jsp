
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->

		<rich:panel id="panelWrapper001-2" style="border:1 e0e0e0 solid; height:100%;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa14'}">
				<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_waitingForApproveNewSite']} [semmsa001-2]"/>
					</f:facet>
				<!-- << header content 2 -->
				
				<!-- >> table result -->
				
				<rich:panel id="tabResult_001-2" styleClass="sem_autoScrollbarInTodoSA">
					<a4j:form id="frmSearchResult_001-2">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabLeadAssign_001-2" cellpadding="1" cellspacing="0" border="0" 
						var="waitingApprLst"  value="#{semmsa001Bean.siteAppList}" reRender="dataTabLeadAssign_001-2, dataScrllLeadAssign_001-2" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
						
							<!-- detail -->
		                    <rich:column style="text-align:center;">
		                    	<f:facet name="header">
			                    	<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;"
			                    	rendered="false">
										<a4j:support event="onclick" action="#{semmsa001Action.selectAllRow}" 
										reRender="dataTabLeadAssign_001-2, msa001-2_btnClrBtch, msa001-2_apprLeader,btnExport,msa001-2_asgnRe,
										msa001-2_managerName">
											<a4j:actionparam name="paramPage" value="msa001-2" />
											<a4j:actionparam name="paramObjectType" value="siteAppr" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</f:facet>
	                        	<h:selectBooleanCheckbox id="chkSelect" value="#{waitingApprLst.checkBox}">
									<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
									reRender="dataTabLeadAssign_001-2, msa001-2_btnClrBtch, msa001-2_apprLeader,btnExport,msa001-2_asgnRe,
									msa001-2_managerName">
										<a4j:actionparam name="paramObjectType" value="siteAppr" />
									</a4j:support>
								</h:selectBooleanCheckbox>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_save']}" style="white-space:nowrap"/>
		                    	</f:facet>
		                        <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height:15px; width:15px;" 
								reRender="oppContent, show_popup">
									<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									
									<a4j:actionparam name="navProgramTo" value="SEMMSA002-1" />
									<a4j:actionparam name="rowId" value="#{waitingApprLst.dataObj.rowId}" />
									<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
									<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
									<a4j:actionparam name="paramMenuType" value="#{semmsa001Bean.menuGroupType}" />
									<a4j:actionparam name="paramMode" value="E" />
								</a4j:commandButton>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.batchNo}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.batchNo}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_number']} Batch" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.batchNo}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.docNo}" headerClass="headerFilterWidth_100"
		                    filterBy="#{waitingApprLst.dataObj.docNo}" filterEvent="onkeyup" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_approveNumber']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        
		                        <a4j:commandLink value="#{waitingApprLst.dataObj.docNo}" action="#{navAction.navi}"
		                        reRender="oppContent">
		                        	<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									
									<a4j:actionparam name="rowId" value="#{waitingApprLst.dataObj.rowId}" />
									<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
									<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
									<a4j:actionparam name="paramMenuType" value="#{semmsa001Bean.menuGroupType}" />
									<a4j:actionparam name="paramMode" value="V" />
								</a4j:commandLink>
		                        
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.region}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.region}" filterEvent="onkeyup">
								<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_location']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.region}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.locationZone}"
		                    filterBy="#{waitingApprLst.dataObj.locationZone}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Zone" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.locationZone}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.company}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.company}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_company']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.company}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.locationId}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.locationId}" filterEvent="onkeyup" >
		                    	<f:facet name="header">
		                    		<h:outputText value="Location ID" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.locationId}" />
		                    </rich:column>
		                    		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.contractNo}" headerClass="headerFilterWidth_100"
		                    filterBy="#{waitingApprLst.dataObj.contractNo}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_contractNumber']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.contractNo}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.effectiveDt}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.effectiveDtStr}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_beginDtm']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.effectiveDtStr}">
		                        	<f:convertDateTime pattern="dd/MM/yyyy" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.expireDt}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.expireDtStr}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_endDtm']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.expireDtStr}">
		                        	<f:convertDateTime pattern="dd/MM/yyyy" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.locationNameTh}" 
		                    filterBy="#{waitingApprLst.dataObj.locationNameTh}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Location Name" style="white-space:nowrap; white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.locationNameTh}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.siteCode}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.siteCode}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Site Code" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.siteCode}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.siteGroup}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.siteGroup}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Site Group" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.siteGroup}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.system}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.system}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="System" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.system}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.siteType}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.siteType}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Site Type" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.siteType}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.stationType}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.stationType}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Station Type" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.stationType}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.siteDetail}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Site Name/Site Code/Site Type/ Station Type" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.siteDetail}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.docStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.docStatus}" filterEvent="onkeyup" rendered="false">
		                    	<f:facet name="header">
		                    		<h:outputText value="Status #{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.docStatus}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.statusDt}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.statusDtStr}"  rendered="false">
		                    	<f:facet name="header">
		                    		<h:outputText value="Status Date" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.statusDtStr}">
		                        	<f:convertDateTime pattern="dd/MM/yyyy" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.networkStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.networkStatus}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="Network Status" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.networkStatus}" />
		                    </rich:column>
		                    		                   	                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.approveDt}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.approveDtStr}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_date']} Approve" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.approveDtStr}">
		                        	<f:convertDateTime pattern="dd/MM/yyyy" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.approveBy}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.approveBy}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="Approve By" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.approveBy}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.reqDocType}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.reqDocType}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_type']}#{jspMsg['column.header.th_apprDoc']}/#{jspMsg['column.header.th_type_subject']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.reqDocType}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.reqOfficer}" 
		                    filterBy="#{waitingApprLst.dataObj.reqOfficer}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_from']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.reqOfficer}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.costPerYear}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.costPerYear}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_cost_per_year']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        
		                        <a4j:commandLink id="msa001-2_popupRentSpecial" action="#{semmsa001Action.doShowPopupRentSpecial}" value="#{waitingApprLst.dataObj.costPerYear}" 
                               	reRender="popupRentSpecial" oncomplete="#{rich:component('popupRentSpecial')}.show();" >
                                   <f:param name="paramSiteAppId" value="#{waitingApprLst.dataObj.rowId}"/>
                                </a4j:commandLink>
		                    </rich:column>
		                    
		                    <%-- 
		                    <rich:column sortBy="#{waitingApprLst.dataObj.modifiedDetail}" 
		                    filterBy="#{waitingApprLst.dataObj.modifiedDetail}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_modified_detail']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.modifiedDetail}" />
		                    </rich:column>
		                    --%>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.nearSiteCost}" headerClass=""
		                    filterBy="#{waitingApprLst.dataObj.nearSiteCost}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_near_site_cost']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <a4j:commandLink id="msa001-2_popNearestSite" action="#{semmsa001Action.doShowPopupNearestSite}" value="#{waitingApprLst.dataObj.nearSiteCost}" 
                               	reRender="msa001PopUpCommon_NearestSite" oncomplete="#{rich:component('msa001PopUpCommon_NearestSite')}.show();">
                                   <f:param name="paramSiteAppId" value="#{waitingApprLst.dataObj.rowId}"/>
                                </a4j:commandLink>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.growingCost}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.growingCost}" 
		                    rendered="#{semmsa001Bean.renderColumnDiffNearSite == 'false'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_growing_cost']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.growingCost}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.growingCost}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.growingCost}" 
		                    rendered="#{semmsa001Bean.renderColumnDiffNearSite}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_rentDiffNearSite']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.growingCost}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.flowStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.flowStatus}" >
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_status']}#{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.flowStatus}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.flowRemark}"
		                    filterBy="#{waitingApprLst.dataObj.flowRemark}"  headerClass="headerWidth_400">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_remark']}" style="white-space:nowrap;" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.flowRemark}" style="width:300px;"/>
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
									<rich:column colspan="21">
										<a4j:region>
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabLeadAssign_001-2"
												maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllLeadAssign_001-2" style="background-color: #cccccc;"
												page="#{semmsa001Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmSearchResult_001-2"></a4j:support>
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
				
				<a4j:form id="frm_msa001-2_Btn">
					<table style="width:95%; background-color:d0d0d0;">
						<tr>
							<td colspan="2">
								<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa001Bean.renderedMsgFormSearch}">
                        
		                        <f:facet name="errorMarker">
		                             <h:graphicImage value="images/error.gif" />  
		                        </f:facet>
		                		</rich:messages>
							</td>
						</tr>
						<tr>
							<td style="width:100%; border:1px solid e0e0e0;" colspan="2">
								<a4j:commandButton  value="#{jspMsg['label.th_export_worker']}"  styleClass="rich-button"
								reRender="panelWrapper_tree, panelWrapper_content" disabled=""  rendered="false"
								action="#{semmsa001Action.doExportWorker}">
								</a4j:commandButton>
								
								
								<a4j:commandButton id="btnExport" action="#{semmsa001Action.doExportWorker}"
                                styleClass="rich-button" value="#{jspMsg['label.th_export_worker']}" 
                                disabled="#{semmsa001Bean.disabledBtnExport}" style="width: 120px"
                                reRender="panelWrapper_tree, panelWrapper_content, show_report,frmError">
                                	<a4j:actionparam name="paramPage" value="msa001-2" />
                               </a4j:commandButton>
								
								<a4j:commandButton id="msa001-2_btnClrBtch" value="Clear Batch No." styleClass="rich-button"
								action="#{semmsa001Action.doClearBatch}" disabled="#{semmsa001Bean.disabledChecked}"
								reRender="panelWrapper_tree, panelWrapper_content" 
								oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
									<a4j:actionparam name="paramPage" value="msa001-2" />
								</a4j:commandButton>
								
								
								
								<a4j:commandButton id="msa001-2_asgnRe" value="Restatus" styleClass="rich-button"
								action="#{semmsa001Action.doAssignUpdate}" disabled="#{semmsa001Bean.disabledChecked}"
								reRender="panelWrapper_tree, panelWrapper_content" 
								oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
									<a4j:actionparam name="paramAssignFromPage" value="msa001-2" />
									<a4j:actionparam name="reassignFlag" value="T" />
								</a4j:commandButton>
							</td>
						</tr>
						<tr>
							<td style="width:14%; text-align:left;">
								<h:outputText value="#{jspMsg['label.th_manager_name']} : " styleClass="ms7" />
							</td>
							<td>
								<h:selectOneMenu id="msa001-2_managerName" value="#{semmsa001Bean.siteAppObjParam.managerName}" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.managerNameList}" />
								</h:selectOneMenu>
								
								<rich:spacer width="10"></rich:spacer>
								
								<a4j:commandButton id="msa001-2_apprLeader" value="Approve to Leader" styleClass="rich-button"
								action="#{semmsa001Action.doApproveToLeader}" disabled="#{semmsa001Bean.disabledChecked}" 
								reRender="panelWrapper_tree, panelWrapper_content" 
								oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
									<a4j:actionparam name="paramPage" value="msa001-2" />
								</a4j:commandButton>
							</td>
						</tr>
					</table>
					
				</a4j:form>
				
				<!-- << table result -->
				
			</rich:panel>
			<!-- << content panel 1 -->
            
	<!-- << wrapper panel -->