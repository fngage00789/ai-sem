
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->

		<rich:panel id="panelWrapper001-6" style="border:1 e0e0e0 solid; height:100%;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa08'}">
				<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_waitingForAvpApprove']} [semmsa001-6]"/>
					</f:facet>
				<!-- << header content 2 -->

				<rich:panel id="tabResult_001-6" styleClass="sem_autoScrollbarInTodoSA">
					<!-- >> table hd -->
					<h:panelGroup id="msa001-6_tabHd" rendered="#{semmsa001Bean.renderDisplay01}"> 
						<a4j:form id="frmMsa001-6_tabHd">
							<a4j:region>
								<rich:dataTable style="width:100%;" id="dataTab_msa001-6_tabHd" cellpadding="1" cellspacing="0" border="0" 
								var="avpApprHdLst" value="#{semmsa001Bean.avpApprHdList}" reRender="dataTab_msa001-6_tabHd, dataScrll_msa001-6_tabHd" 
								rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								
			                    <!-- detail -->
								<rich:column style="text-align:center;">
									<f:facet name="header">
			                    		 <h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;" rendered="false">
											<a4j:support event="onclick" action="#{semmsa001Action.selectAvpAllRow}" 
											reRender="dataTab_msa001-6_tabHd, msa001-6_sendApprHd" >
												<a4j:actionparam name="paramAvpType" value="HD" />
												<a4j:actionparam name="paramObjectType" value="avpApprHD" />
											</a4j:support>
										</h:selectBooleanCheckbox>
			                    	</f:facet>
									<h:selectBooleanCheckbox id="chkSelect" value="#{avpApprHdLst.checkBox}">
										<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
										reRender="dataTab_msa001-6_tabHd, msa001-6_sendApprHd">
											<a4j:actionparam name="paramObjectType" value="avpApprHD" />
										</a4j:support>
									</h:selectBooleanCheckbox>
			                    </rich:column>
								
			                    <rich:column style="text-align:center;" sortBy="#{avpApprHdLst.dataObj.batchNo}" headerClass="headerFilterWidth_120"
			                    filterBy="#{avpApprHdLst.dataObj.batchNo}" filterEvent="onkeyup">
									<f:facet name="header">
			                    		<h:outputText value="Batch" style="white-space:nowrap" />
			                    	</f:facet>
			                        <a4j:commandLink value="#{avpApprHdLst.dataObj.batchNo}" 
									action="#{semmsa001Action.doGetAvpDt}" 
									reRender="panelWrapper_tree, panelWrapper_content, msa001-6_tabHd, msa001-6_tabDt, dataTab_msa001-6_tabHd, dataTab_msa001-6_tabDt">
										<a4j:actionparam name="rowId" value="#{avpApprHdLst.dataObj.rowId}" />
										<a4j:actionparam name="paramBatchNo" value="#{avpApprHdLst.dataObj.rowId}" />
										<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
										<a4j:actionparam name="paramMenuType" value="#{semmsa001Bean.menuGroupType}" />
									</a4j:commandLink>
			                    </rich:column>
								
			                    <rich:column style="text-align:center;" sortBy="#{avpApprHdLst.dataObj.assignToTeam}" headerClass="headerFilterWidth_120"
			                    filterBy="#{avpApprHdLst.dataObj.assignToTeam}" filterEvent="onkeyup">
									<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_team']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprHdLst.dataObj.assignToTeam}" />
			                    </rich:column>
								
			                    <rich:column style="text-align:center;" sortBy="#{avpApprHdLst.dataObj.assignToUser}" headerClass="headerFilterWidth_120"
			                    filterBy="#{avpApprHdLst.dataObj.assignToUser}" filterEvent="onkeyup">
			                        <f:facet name="header">
			                    		<h:outputText value="Leader" style="white-space:nowrap" />
			                    	</f:facet>
									<h:outputText value="#{avpApprHdLst.dataObj.assignToUser}" />
			                    </rich:column>
								
			                    <rich:column style="text-align:right;" sortBy="#{avpApprHdLst.dataObj.batchSum}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprHdLst.dataObj.batchSum}" filterEvent="onkeyup">
			                        <f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_sum_apprDoc']}" style="white-space:nowrap" />
			                    	</f:facet>
									<h:outputText value="#{avpApprHdLst.dataObj.batchSum}" />
			                    </rich:column>
								
			                    <rich:column style="text-align:right;" sortBy="#{avpApprHdLst.dataObj.growingCost}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprHdLst.dataObj.growingCost}" filterEvent="onkeyup">
			                        <f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_rent_costOver']}" style="white-space:nowrap" />
			                    	</f:facet>
									<h:outputText value="#{avpApprHdLst.dataObj.growingCost}" />
			                    </rich:column>
								
			                    <rich:column style="text-align:right;" sortBy="#{avpApprHdLst.dataObj.nearSiteCost}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprHdLst.dataObj.nearSiteCost}" filterEvent="onkeyup">
			                        <f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_rent_expence_moreThan_CloseUpSite']}" style="white-space:nowrap" />
			                    	</f:facet>
									<h:outputText value="#{avpApprHdLst.dataObj.nearSiteCost}" />
			                    </rich:column>
			                    <!-- detail -->
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa001Bean.avpApprHdList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="4">
											<a4j:region>
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTab_msa001-6_tabHd"
													maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_msa001-6_tabHd" style="background-color: #cccccc;"
													page="#{semmsa001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsa001-6_tabHd"></a4j:support>
												</rich:datascroller>
											</a4j:region>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							
							</rich:dataTable>
						</a4j:region>
						</a4j:form>
					</h:panelGroup>
					<!-- << table hd -->
					
					<!-- >> table dt -->
					<h:panelGroup id="msa001-6_tabDt" rendered="#{semmsa001Bean.renderDisplay02}"> 
						<a4j:form id="frmMsa001-6_tabDt">
						<a4j:region>
						
							<rich:dataTable style="width:100%;" id="dataTab_msa001-6_tabDt" 
							cellpadding="1" cellspacing="0" border="0" 
							var="avpApprDtLst"  value="#{semmsa001Bean.avpApprDtList}" reRender="dataTab_msa001-6_tabDt, dataScrll_msa001-6_tabDt" 
							rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
			                    <!-- detail -->		                    
			                    <rich:column style="text-align:center;">
			                    	<f:facet name="header">
				                    	<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;" rendered="false">
											<a4j:support event="onclick" action="#{semmsa001Action.selectAvpAllRow}" 
											reRender="dataTab_msa001-6_tabDt, msa001-6_sendApprDt">
												<a4j:actionparam name="paramAvpType" value="DT" />
												<a4j:actionparam name="paramObjectType" value="avpApprDT" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</f:facet>
		                        	<h:selectBooleanCheckbox id="chkSelect" value="#{avpApprDtLst.checkBox}">
										<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
										reRender="dataTab_msa001-6_tabDt, msa001-6_sendApprDt">
											<a4j:actionparam name="paramObjectType" value="avpApprDT" />
										</a4j:support>
									</h:selectBooleanCheckbox>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.batchNo}" headerClass="headerFilterWidth_120"
			                    filterBy="#{avpApprDtLst.dataObj.batchNo}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_number']} Batch" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.batchNo}" />
			                    </rich:column>
			                    
			                    <rich:column  style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.docNo}" headerClass="headerFilterWidth_100"
			                    filterBy="#{avpApprDtLst.dataObj.docNo}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_approveNumber']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        
			                        <a4j:commandLink value="#{avpApprDtLst.dataObj.docNo}" action="#{navAction.navi}"
			                        reRender="oppContent">
			                        	<a4j:actionparam name="navModule" value="sa" />
										<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
										
										<a4j:actionparam name="rowId" value="#{avpApprDtLst.dataObj.rowId}" />
										<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
										<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
										<a4j:actionparam name="paramMenuType" value="#{semmsa001Bean.menuGroupType}" />
										<a4j:actionparam name="paramMode" value="V" />
										<a4j:actionparam name="paramLeaderFlag" value="Y" />
									</a4j:commandLink>
			                        
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.region}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.region}" filterEvent="onkeyup">
									<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_location']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.region}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.locationZone}" headerClass="headerWidth_150"
			                    filterBy="#{avpApprDtLst.dataObj.locationZone}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Zone" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.locationZone}" style="width:200px;"/>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.company}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.company}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_company']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.company}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.locationId}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.locationId}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Location ID" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.locationId}" />
			                    </rich:column>
			                    	                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.contractNo}" headerClass="headerFilterWidth_100"
			                    filterBy="#{avpApprDtLst.dataObj.contractNo}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_contractNumber']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.contractNo}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.effectiveDt}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.effectiveDtStr}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_beginDtm']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.effectiveDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.expireDt}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.expireDtStr}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_endDtm']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.expireDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    		                    
			                    <rich:column sortBy="#{avpApprDtLst.dataObj.locationNameTh}" 
			                    filterBy="#{avpApprDtLst.dataObj.locationNameTh}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Location Name" style="white-space:nowrap; white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.locationNameTh}" style="width:200px;"/>
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{avpApprDtLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.siteDetail}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Site Name/Site Code/Site Type/ Station Type" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.siteDetail}" escape="false" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.docStatus}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.docStatus}"  rendered="false">
			                    	<f:facet name="header">
			                    		<h:outputText value="Status #{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.docStatus}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.statusDt}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.statusDtStr}"  rendered="false">
			                    	<f:facet name="header">
			                    		<h:outputText value="Status Date" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.statusDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    		                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.networkStatus}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.networkStatus}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Network Status" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.networkStatus}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.approveDt}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.approveDtStr}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_date']} Approve" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.approveDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.approveBy}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.approveBy}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Approve By" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.approveBy}" />
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{avpApprDtLst.dataObj.reqDocType}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.reqDocType}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_type']}#{jspMsg['column.header.th_apprDoc']}/#{jspMsg['column.header.th_type_subject']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.reqDocType}" />
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{avpApprDtLst.dataObj.reqOfficer}" 
			                    filterBy="#{avpApprDtLst.dataObj.reqOfficer}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_from']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.reqOfficer}" style="width:200px;"/>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{avpApprDtLst.dataObj.costPerYear}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.costPerYear}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_cost_per_year']}" style="white-space:nowrap" />
			                    	</f:facet>
			                          <a4j:commandLink id="msa001-2_popupRentSpecial" action="#{semmsa001Action.doShowPopupRentSpecial}" value="#{waitingApprLst.dataObj.costPerYear}" 
	                               	reRender="popupRentSpecial" oncomplete="#{rich:component('popupRentSpecial')}.show();" >
	                                   <f:param name="paramSiteAppId" value="#{waitingApprLst.dataObj.rowId}"/>
	                                </a4j:commandLink>
			                    </rich:column>
			                    
			                    <%-- 
			                    <rich:column sortBy="#{avpApprDtLst.dataObj.modifiedDetail}" 
			                    filterBy="#{avpApprDtLst.dataObj.modifiedDetail}" >
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_modified_detail']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.modifiedDetail}" />
			                    </rich:column>
			                    --%>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.nearSiteCost}" headerClass=""
			                    filterBy="#{avpApprDtLst.dataObj.nearSiteCost}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_near_site_cost']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <a4j:commandLink id="msa001-6_popNearestSite" action="#{semmsa001Action.doShowPopupNearestSite}" value="#{avpApprDtLst.dataObj.nearSiteCost}" 
	                               	reRender="msa001PopUpCommon_NearestSite" oncomplete="#{rich:component('msa001PopUpCommon_NearestSite')}.show();">
	                                   <f:param name="paramSiteAppId" value="#{avpApprDtLst.dataObj.rowId}"/>
	                                </a4j:commandLink>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{avpApprDtLst.dataObj.growingCost}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.growingCost}" 
			                    rendered="#{semmsa001Bean.renderColumnDiffNearSite == 'false'}">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_growing_cost']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.growingCost}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{avpApprDtLst.dataObj.growingCost}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.growingCost}" 
			                    rendered="#{semmsa001Bean.renderColumnDiffNearSite}">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_rentDiffNearSite']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.growingCost}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{avpApprDtLst.dataObj.revenue}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.revenue}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Revenue" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.revenue}" >
			                        	<f:convertNumber pattern="#,##0.00" maxIntegerDigits="20" maxFractionDigits="2" />
			                        </h:outputText>
			                    </rich:column>
			                    
			                    <rich:column id="msa001-6_remarkRisk" style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.remarkRisk}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.remarkRisk}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_remarkRisk']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.remarkRisk}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{avpApprDtLst.dataObj.flowStatus}" headerClass="headerFilterWidth"
			                    filterBy="#{avpApprDtLst.dataObj.flowStatus}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_status']}#{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.flowStatus}" />
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{avpApprDtLst.dataObj.flowRemark}" 
			                    filterBy="#{avpApprDtLst.dataObj.flowRemark}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_remark']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{avpApprDtLst.dataObj.flowRemark}" style="width:300px;"/>
			                    </rich:column>
			                    <!-- detail -->
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa001Bean.avpApprDtList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="21">
											<a4j:region>
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTab_msa001-6_tabDt"
													maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_msa001-6_tabDt" style="background-color: #cccccc;"
													page="#{semmsa001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsa001-6_tabDt"></a4j:support>
												</rich:datascroller>
											</a4j:region>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
							
						</a4j:region>
						</a4j:form>
					</h:panelGroup>
				</rich:panel>
				
				<!-- << table dt -->
				
				<!-- >> group 2 -->
				<center>
				<a4j:form id="frmLeadAppr_001-6">
				<rich:panel style="width:900px; text-align:left;" rendered="#{semmsa001Bean.rendererSSO['scrSMMSA004']}">
					
						<!-- >> header content -->
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_specify_leadAppr_result']}" />
						</f:facet>
						<!-- << header content -->

						<h:panelGroup style="width:100%;">
							<!-- table column: 10:20, 10:20, 40 -->
							<table style="width:100%; border:solid 1px;">
								<tr>
									<td style="width:30%; text-align:right;">
										<h:outputText value="#{jspMsg['label.th_approve_result']} : " styleClass="ms7" />
									</td>
									<td style="width:70%;">
										<h:selectOneMenu id="msa001-6_apprResult" value="#{semmsa001Bean.siteAppObjParam.avpApproveStatus}" styleClass="ms7">
											<f:selectItems value="#{semmsa001Bean.approveStatusAList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:30%; text-align:right; vertical-align:top;">
										<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
									</td>
									<td style="width:70%;">
										<h:inputTextarea id="msa001-6_apprRemark" value="#{semmsa001Bean.siteAppObjParam.avpApproveRemark}" rows="4" cols="30" style="width:70%;" styleClass="ms7">
										</h:inputTextarea>
									</td>
								</tr>
								<tr>
									<td style="text-align:center;" colspan="2">
										<a4j:commandButton style="margin-top:20px;" styleClass="rich-button" id="msa001-6_sendApprHd" value="#{jspMsg['label.th_ok']}"
										rendered="#{semmsa001Bean.renderDisplay01}" action="#{semmsa001Action.doAvpApprove}" disabled="#{semmsa001Bean.disabledChecked}" 
										reRender="panelWrapper_tree, panelWrapper_content, dataTab_msa001-6_tabHd, frmMsa001-6_tabHd, msa001-6_apprResult, msa001-6_apprRemark"
										oncomplete="#{rich:component('popUpMsa001-6_retStatus')}.show();">
											<a4j:actionparam name="paramAvpType" value="HD" />
										</a4j:commandButton>
										
										<a4j:commandButton style="margin-top:20px;" styleClass="rich-button" id="msa001-6_sendApprDt" value="#{jspMsg['label.th_ok']}"
										rendered="#{semmsa001Bean.renderDisplay02}" action="#{semmsa001Action.doAvpApprove}" disabled="#{semmsa001Bean.disabledChecked}"
										reRender="panelWrapper_tree, panelWrapper_content, dataTab_msa001-6_tabDt, frmMsa001-6_tabDt, msa001-6_apprResult, msa001-6_apprRemark"
										oncomplete="#{rich:component('popUpMsa001-6_retStatus')}.show();">
											<a4j:actionparam name="paramAvpType" value="DT" />
											
											<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
											<a4j:actionparam name="strBatchNo" value="#{semmsa001Bean.siteAppObjParam.batchNo}" />
										</a4j:commandButton>
									</td>
								</tr>
							</table>
						</h:panelGroup>
						<!-- << group 2 -->
				</rich:panel>
				</a4j:form>
				</center>
				
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->
	
	
	<!-- >> [POPUP_00] -->
	<!-- popUpMsa001-6_retStatus -->
	<rich:modalPanel id="popUpMsa001-6_retStatus" autosized="true" rendered="#{semmsa001Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-popUpMsa001-6_retStatus" style="cursor:pointer" />
					<rich:componentControl for="popUpMsa001-6_retStatus" attachTo="hide-popUpMsa001-6_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa001-6_frmRetStatusDialog">
			<h:panelGrid columns="1" styleClass="contentlabelform" style="text-align:center;" width="200">
				<!-- /// -->
				<rich:messages style="" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa001Bean.renderedMsgAlert}">
			 		<f:facet name="header">
                       	<h:outputText value="Entered Data Status:"></h:outputText>
                   	</f:facet>
		 			<f:facet name="errorMarker">
		 				 <h:graphicImage value="images/error.gif" style="margin-right:5px;" />  
                    </f:facet>
	            </rich:messages>
			</h:panelGrid>

			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Ok" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="popUpMsa001-6_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- popUpMsa001-6_retStatus -->
	<!-- << [POPUP_00] -->