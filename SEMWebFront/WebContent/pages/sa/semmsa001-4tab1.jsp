
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->

		<rich:panel id="panelWrapper001-4tab1" style="border:1 e0e0e0 solid; height:100%;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa06'}">
				<!-- >> header content 2 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_waitingForManagerApprove']} [semmsa001-4] All Record"/>
					</f:facet>
				<!-- << header content 2 -->


				
				<rich:panel  styleClass="sem_autoScrollbarInTodoSASub">
					<!-- >> table hd -->
				
				<!-- << table hd -->
				
				<!-- >> table dt -->
				<h:panelGroup id="msa001-4_tab1" rendered="true"> 
					<a4j:form id="frmMsa001-4_tab1">
						<a4j:region>
							<rich:dataTable style="width:100%;" id="dataTab_msa001-4_tab1" 
							cellpadding="1" cellspacing="0" border="0" 
							var="mngApprDtLst"  value="#{semmsa001Bean.managerApprDtList}" reRender="dataTab_msa001-4_tab1, dataScrll_msa001-4_tab1" 
							rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
	
			                    <!-- detail -->		                    
			                    <rich:column style="text-align:center;">
			                    	<f:facet name="header">
				                    	<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;" rendered="false">
											<a4j:support event="onclick" action="#{semmsa001Action.selectManagerAllRow}" 
											reRender="dataTab_msa001-4_tab1, msa001-4_sendAppr1,msa001-4tab1_btnExportExcel,msa001-4_sendApprTab1">
												<a4j:actionparam name="paramManagerType" value="DT" />
												<a4j:actionparam name="paramObjectType" value="mngApprDT" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</f:facet>
		                        	<h:selectBooleanCheckbox id="chkSelect" value="#{mngApprDtLst.checkBox}">
										<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
										reRender="dataTab_msa001-4_tab1, msa001-4_sendAppr1,msa001-4tab1_btnExportExcel,msa001-4_sendApprTab1">
											<a4j:actionparam name="paramObjectType" value="mngApprDT" />
										</a4j:support>
									</h:selectBooleanCheckbox>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.batchNo}" headerClass="headerFilterWidth_120"
			                    filterBy="#{mngApprDtLst.dataObj.batchNo}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_number']} Batch" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.batchNo}" />
			                    </rich:column>
			                    
			                    <rich:column  style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.docNo}" headerClass="headerFilterWidth_100"
			                    filterBy="#{mngApprDtLst.dataObj.docNo}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_approveNumber']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        
			                        <a4j:commandLink value="#{mngApprDtLst.dataObj.docNo}" action="#{navAction.navi}"
			                        reRender="oppContent">
			                        	<a4j:actionparam name="navModule" value="sa" />
										<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
										
										<a4j:actionparam name="rowId" value="#{mngApprDtLst.dataObj.rowId}" />
										<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
										<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
										<a4j:actionparam name="paramMenuType" value="#{semmsa001Bean.menuGroupType}" />
										<a4j:actionparam name="paramMode" value="E" />
										<a4j:actionparam name="paramLeaderFlag" value="Y" />
									</a4j:commandLink>
			                        
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.region}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.region}" filterEvent="onkeyup">
									<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_code']}#{jspMsg['column.header.th_location']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.region}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.locationZone}" headerClass="headerWidth_150"
			                    filterBy="#{mngApprDtLst.dataObj.locationZone}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Zone" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.locationZone}" style="width:200px;"/>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.company}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.company}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_code']}#{jspMsg['column.header.th_company']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.company}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.locationId}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.locationId}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Location ID" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.locationId}" />
			                    </rich:column>
			                    		                    
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.contractNo}" headerClass="headerFilterWidth_100"
			                    filterBy="#{mngApprDtLst.dataObj.contractNo}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_contractNumber']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.contractNo}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.effectiveDt}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.effectiveDtStr}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_beginDtm']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.effectiveDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.expireDt}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.expireDtStr}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_endDtm']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.expireDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    		                    
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.locationNameTh}" 
			                    filterBy="#{mngApprDtLst.dataObj.locationNameTh}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Location Name" style="white-space:nowrap; white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.locationNameTh}" style="width:200px;"/>
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.siteDetail}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Site Name/Site Code/Site Type/ Station Type" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.siteDetail}" escape="false" />
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.docStatus}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.docStatus}"  rendered="false">
			                    	<f:facet name="header">
			                    		<h:outputText value="Status #{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.docStatus}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.networkStatus}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.networkStatus}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Network Status" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.networkStatus}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.approveDt}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.approveDtStr}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_date']} Approve" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.approveDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.approveBy}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.approveBy}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Approve By" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.approveBy}" />
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.reqDocType}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.reqDocType}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_type']}#{jspMsg['column.header.th_apprDoc']}/#{jspMsg['column.header.th_type_subject']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.reqDocType}" />
			                    </rich:column>
			                    
			                    <rich:column  style="white-space:nowrap;" sortBy="#{mngApprDtLst.dataObj.reqOfficer}" headerClass=""
			                    filterBy="#{mngApprDtLst.dataObj.reqOfficer}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_from']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.reqOfficer}" style="width:200px;"/>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{mngApprDtLst.dataObj.costPerYear}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.costPerYear}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_cost_per_year']}" style="white-space:nowrap">
			                    			
			                    		</h:outputText>
			                    	</f:facet>
			                        <a4j:commandLink id="msa001-2_popupRentSpecial" action="#{semmsa001Action.doShowPopupRentSpecial}" value="#{mngApprDtLst.dataObj.costPerYear}" 
	                               	reRender="popupRentSpecial" oncomplete="#{rich:component('popupRentSpecial')}.show();" >
	                                   <f:param name="paramSiteAppId" value="#{mngApprDtLst.dataObj.rowId}"/>
	                                  </a4j:commandLink>
			                    </rich:column>
			                    
			                    <%-- 
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.modifiedDetail}" 
			                    filterBy="#{mngApprDtLst.dataObj.modifiedDetail}" >
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_modified_detail']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.modifiedDetail}" />
			                    </rich:column>
			                    --%>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.nearSiteCost}" headerClass=""
			                    filterBy="#{mngApprDtLst.dataObj.nearSiteCost}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_near_site_cost']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <a4j:commandLink id="msa001-4_popNearestSite" action="#{semmsa001Action.doShowPopupNearestSite}" value="#{mngApprDtLst.dataObj.nearSiteCost}" 
	                               	reRender="msa001PopUpCommon_NearestSite" oncomplete="#{rich:component('msa001PopUpCommon_NearestSite')}.show();">
	                                   <f:param name="paramSiteAppId" value="#{mngApprDtLst.dataObj.rowId}"/>
	                                </a4j:commandLink>
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{mngApprDtLst.dataObj.growingCost}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.growingCost}" 
			                    rendered="#{semmsa001Bean.renderColumnDiffNearSite == 'false'}">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_growing_cost']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.growingCost}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{mngApprDtLst.dataObj.growingCost}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.growingCost}" filterEvent="onkeyup"
			                    rendered="#{semmsa001Bean.renderColumnDiffNearSite}">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_rentDiffNearSite']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.growingCost}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:right;" sortBy="#{mngApprDtLst.dataObj.revenue}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.revenue}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="Revenue" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.revenue}" >
			                        	<f:convertNumber pattern="#,##0.00" maxIntegerDigits="20" maxFractionDigits="2" />
			                        </h:outputText>
			                    </rich:column>
			                    		                    
			                    <rich:column id="msa001-4tab1_remarkRisk" style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.remarkRisk}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.remarkRisk}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_remarkRisk']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.remarkRisk}" />
			                    </rich:column>
			                    		                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.flowStatus}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.flowStatus}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_status']}#{jspMsg['column.header.th_apprDoc']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.flowStatus}" />
			                    </rich:column>
			                    
			                    <rich:column style="text-align:center;" sortBy="#{mngApprDtLst.dataObj.statusDt}" headerClass="headerFilterWidth"
			                    filterBy="#{mngApprDtLst.dataObj.statusDtStr}"  rendered="false">
			                    	<f:facet name="header">
			                    		<h:outputText value="Status Date" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.statusDtStr}">
			                        	<f:convertDateTime pattern="dd/MM/yyyy" />
			                        </h:outputText>
			                    </rich:column>
			                    
			                    <rich:column sortBy="#{mngApprDtLst.dataObj.flowRemark}" 
			                    filterBy="#{mngApprDtLst.dataObj.flowRemark}" filterEvent="onkeyup">
			                    	<f:facet name="header">
			                    		<h:outputText value="#{jspMsg['column.header.th_remark']}" style="white-space:nowrap" />
			                    	</f:facet>
			                        <h:outputText value="#{mngApprDtLst.dataObj.flowRemark}" style="width:300px;"/>
			                    </rich:column>
			                    <!-- detail -->
								
								<!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmsa001Bean.managerApprDtList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="22">
											<a4j:region>
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTab_msa001-4_tab1"
													maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_msa001-4_tab1" style="background-color: #cccccc;"
													page="#{semmsa001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMsa001-4_tab1"></a4j:support>
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
				<!-- << button export -->
				
					<a4j:form id="msa001-4tab1_frmButton">
						<table style="width:98%; text-align:left;">
							<tr>
								<td>
									<h:commandButton id="msa001-4tab1_btnExportExcel" value="#{jspMsg['label.exportExcel']}" 
									styleClass="rich-button" action="#{semmsa001Action.doManagerExportExcel}"
									disabled="#{semmsa001Bean.disabledChecked}"></h:commandButton>
								</td>
							</tr>
						</table>
						
					</a4j:form>
				
				
                <!-- >> end button export -->
				<!-- >> group 2 -->
				
				<a4j:form id="frmLeadAppr_001-4tab1">
				<rich:panel style="width:98%; text-align:left;" rendered="#{semmsa001Bean.rendererSSO['scrSMMSA003']}">
					
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
										<h:selectOneMenu id="msa001-4_apprResultTab1" value="#{semmsa001Bean.siteAppObjParam.managerApproveStatus}" styleClass="ms7">
											<f:selectItems value="#{semmsa001Bean.approveStatusList}"/>
										</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td style="width:30%; text-align:right; vertical-align:top;">
										<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
									</td>
									<td style="width:70%;">
										<h:inputTextarea id="msa001-4_apprRemarkTab1" value="#{semmsa001Bean.siteAppObjParam.managerApproveRemark}" rows="4" cols="30" style="width:70%;" styleClass="ms7">
										</h:inputTextarea>
									</td>
								</tr>
								<tr>
									<td style="text-align:center;" colspan="2">
																				
										<a4j:commandButton style="margin-top:20px;" styleClass="rich-button" id="msa001-4_sendApprTab1" value="#{jspMsg['label.th_ok']}"
										rendered="true" action="#{semmsa001Action.doManagerApprove}" reRender="panelWrapper_tree, panelWrapper_content, dataTab_msa001-4_tab1, frmMsa001-4_tab1, 
										msa001-4_apprResultTab1, msa001-4_apprRemarkTab1" disabled="#{semmsa001Bean.disabledChecked}"
										oncomplete="#{rich:component('popUpMsa001-4_retStatus')}.show();">
											<a4j:actionparam name="paramManagerType" value="DT" />
											
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
				
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->
	
	
	<!-- >> [POPUP_00] -->
	<!-- popUpMsa001-4_retStatus -->
	<rich:modalPanel id="popUpMsa001-4_retStatus" autosized="true" rendered="#{semmsa001Bean.renderedMsgAlert}">	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['label.th_process_status']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-popUpMsa001-4_retStatus" style="cursor:pointer" />
					<rich:componentControl for="popUpMsa001-4_retStatus" attachTo="hide-popUpMsa001-4_retStatus" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		
		<a4j:form id="msa001-4_frmRetStatusDialog">
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
					    <rich:componentControl for="popUpMsa001-4_retStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
		</a4j:form>
	</rich:modalPanel>
	<!-- popUpMsa001-4_retStatus -->
	<!-- << [POPUP_00] -->