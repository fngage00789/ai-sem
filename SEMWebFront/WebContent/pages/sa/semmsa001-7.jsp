
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->

		<rich:panel id="panelWrapper001-7" style="border:1 e0e0e0 solid; height:100%;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa09'}">
				<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_legalPass_unComplete_doc']} [semmsa001-7]"/>
					</f:facet>
				<!-- << header content 2 -->
				
				
				
				<!-- >> table result -->
				
				<rich:panel id="tabResult_001-7" styleClass="sem_autoScrollbarInTodoSA">
					<a4j:form id="frmSearchResult_001-7">
						<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabLeadAssign_001-7" cellpadding="1" cellspacing="0" border="0" 
						var="waitingApprLst"  value="#{semmsa001Bean.siteAppList}" reRender="dataTabLeadAssign_001-7, dataScrllLeadAssign_001-7" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
						
							<!-- detail -->		                    
		                    <rich:column style="text-align:center;" rendered="false">
		                    	<f:facet name="header">
		                    		<h:outputText value="Edit" style="white-space:nowrap"/>
								</f:facet>
	                        	<a4j:commandButton id="msa001-7_btnEdit" action="#{navAction.navi}" image="images/edit.png" style="height:15px; width:15px;" 
								oncomplete="" reRender="oppContent, panelWrapper_tree, panelWrapper_content, dataTabLeadAssign_001-7" status="globalAjaxStatus">
									<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA001-16" />
									
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA001" />
									<a4j:actionparam name="methodWithNavi" value="doInitialCoStatus" />
									
									<a4j:actionparam name="rowId" value="#{waitingApprLst.dataObj.rowId}" />
									<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
									<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
									<a4j:actionparam name="paramPage" value="semmsa001-7" />
								</a4j:commandButton>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.batchNo}" headerClass="headerFilterWidth_120"
		                    filterBy="#{waitingApprLst.dataObj.batchNo}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_number']} Batch" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.batchNo}" />
		                    </rich:column>
		                    
		                    <rich:column  style="text-align:center;" sortBy="#{waitingApprLst.dataObj.docNo}" headerClass="headerFilterWidth_100"
		                    filterBy="#{waitingApprLst.dataObj.docNo}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_approveNumber']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        
		                        <a4j:commandLink value="#{waitingApprLst.dataObj.docNo}" action="#{navAction.navi}" status="globalAjaxStatus"
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
									<a4j:actionparam name="paramLeaderFlag" value="Y" />
								</a4j:commandLink>
		                        
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.region}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.region}" filterEvent="onkeyup">
								<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_location']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.region}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.locationZone}" headerClass="headerWidth_150"
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
		                    filterBy="#{waitingApprLst.dataObj.locationId}" filterEvent="onkeyup">
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
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.siteDetail}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Site Name/Site Code/Site Type/ Station Type" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.siteDetail}" escape="false" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.docStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.docStatus}" filterEvent="onkeyup" rendered="false">
		                    	<f:facet name="header">
		                    		<h:outputText value="Status #{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.docStatus}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.statusDt}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.statusDtStr}" filterEvent="onkeyup" rendered="false">
		                    	<f:facet name="header">
		                    		<h:outputText value="Status Date" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.statusDtStr}">
		                        	<f:convertDateTime pattern="dd/MM/yyyy" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.networkStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.networkStatus}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Network Status" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.networkStatus}"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.approveDt}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.approveDtStr}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_date']} Approve" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.approveDtStr}">
		                        	<f:convertDateTime pattern="dd/MM/yyyy" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.approveBy}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.approveBy}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Approve By" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.approveBy}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.reqDocType}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.reqDocType}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_type']}#{jspMsg['column.header.th_apprDoc']}/#{jspMsg['column.header.th_type_subject']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.reqDocType}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.reqOfficer}" 
		                    filterBy="#{waitingApprLst.dataObj.reqOfficer}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_from']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.reqOfficer}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.costPerYear}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.costPerYear}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_cost_per_year']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <a4j:commandLink id="msa001-2_popupRentSpecial" action="#{semmsa001Action.doShowPopupRentSpecial}" value="#{waitingApprLst.dataObj.costPerYear}" 
                               	reRender="popupRentSpecial" oncomplete="#{rich:component('popupRentSpecial')}.show();" >
                                   <f:param name="paramSiteAppId" value="#{waitingApprLst.dataObj.rowId}"/>
                                </a4j:commandLink>
		                    </rich:column>
		                    
		                    <%-- 
		                    <rich:column sortBy="#{waitingApprLst.dataObj.modifiedDetail}" 
		                    filterBy="#{waitingApprLst.dataObj.modifiedDetail}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_modified_detail']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.modifiedDetail}" />
		                    </rich:column>
		                    --%>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.nearSiteCost}" headerClass=""
		                    filterBy="#{waitingApprLst.dataObj.nearSiteCost}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_near_site_cost']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <a4j:commandLink id="msa001-7_popNearestSite" action="#{semmsa001Action.doShowPopupNearestSite}" value="#{waitingApprLst.dataObj.nearSiteCost}" 
                               	reRender="msa001PopUpCommon_NearestSite" oncomplete="#{rich:component('msa001PopUpCommon_NearestSite')}.show();" status="globalAjaxStatus">
                                   <f:param name="paramSiteAppId" value="#{waitingApprLst.dataObj.rowId}"/>
                                </a4j:commandLink>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.growingCost}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.growingCost}" filterEvent="onkeyup"
		                    rendered="#{semmsa001Bean.renderColumnDiffNearSite == 'false'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_growing_cost']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.growingCost}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.growingCost}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.growingCost}" filterEvent="onkeyup"
		                    rendered="#{semmsa001Bean.renderColumnDiffNearSite}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_rentDiffNearSite']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.growingCost}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:right;" sortBy="#{waitingApprLst.dataObj.revenue}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.revenue}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Revenue" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.revenue}" >
		                        	<f:convertNumber pattern="#,##0.00" maxIntegerDigits="20" maxFractionDigits="2" />
		                        </h:outputText>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{waitingApprLst.dataObj.flowStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{waitingApprLst.dataObj.flowStatus}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_status']}#{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{waitingApprLst.dataObj.flowStatus}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{waitingApprLst.dataObj.flowRemark}" 
		                    filterBy="#{waitingApprLst.dataObj.flowRemark}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_remark']}" style="white-space:nowrap" />
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
											<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabLeadAssign_001-7"
												maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dataScrllLeadAssign_001-7" style="background-color: #cccccc;"
												page="#{semmsa001Bean.scrollerPage}">
											<a4j:support event="onclick"  reRender="frmSearchResult_001-7"></a4j:support>
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
				
				<!-- << table result -->
				
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->