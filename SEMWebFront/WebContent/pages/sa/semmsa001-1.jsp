
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->
	
		<rich:panel id="panelWrapper001-1" style="height:100%; border:1 ececec solid;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa02'}">
			<!-- >> content panel 1 -->
			
				<!-- >> header content 1 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.leadAssignNew']} / #{jspMsg['label.assignSummary']} [semmsa001-1]"/>
					</f:facet>
				<!-- << header content 1 -->
				
				<!-- >> table result -->
				<rich:panel id="tabResult_001-1" styleClass="sem_autoScrollbarInTodoSA">
					<a4j:form id="frmSearchResult_001-1">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabLeadAssign_001-1" cellpadding="1" cellspacing="0" border="0" 
						var="leadAssignLst"  value="#{semmsa001Bean.siteAppList}" reRender="dataTabLeadAssign_001-1, dataScrllLeadAssign_001-1" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							
							<!-- detail -->
		                    <rich:column style="text-align:center;">
			                    <f:facet name="header">
			                    	<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;"
			                    	rendered="false">
										<a4j:support event="onclick" action="#{semmsa001Action.selectAllRow}" 
										reRender="dataTabLeadAssign_001-1, msa001panel1_asgnRe, msa001panel1_except">
											<a4j:actionparam name="paramObjectType" value="siteAppr" />
										</a4j:support>
									</h:selectBooleanCheckbox>
		                    	</f:facet>
	                        	<h:selectBooleanCheckbox id="chkSelect" value="#{leadAssignLst.checkBox}">
									<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
									reRender="dataTabLeadAssign_001-1, msa001panel1_asgnRe, msa001panel1_except">
										<a4j:actionparam name="paramObjectType" value="siteAppr" />
									</a4j:support>
								</h:selectBooleanCheckbox>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.region}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.region}" filterEvent="onkeyup">
								<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_location']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.region}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteZone}" headerClass="headerWidth_150"
		                    filterBy="#{leadAssignLst.dataObj.siteZone}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="Zone" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteZone}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.company}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.company}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.th_company']}" style="white-space:nowrap" />
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.company}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.locationId}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.locationId}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationId']}"/>
		                    	</f:facet>
		                    	<h:outputText value="#{leadAssignLst.dataObj.locationId}"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.locationCode}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.locationCode}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationCode']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.locationCode}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{leadAssignLst.dataObj.locationNameTh}" headerClass=""
		                    filterBy="#{leadAssignLst.dataObj.locationNameTh}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationName']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.locationNameTh}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteCode}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteCode}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteCode']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteCode}" />
		                        <h:inputHidden value="#{leadAssignLst.dataObj.siteId}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteGroup}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteGroup}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteGroup']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteGroup}"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.system}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.system}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.system']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.system}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteType}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteType}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteType']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteType}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.stationType}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.stationType}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.stationType']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.stationType}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{leadAssignLst.dataObj.siteNameTh}" 
		                    filterBy="#{leadAssignLst.dataObj.siteNameTh}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteName']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteNameTh}" style="width:200px;"/>
		                    </rich:column>
		                   
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteDetail}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationSite']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteDetail}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.status}" headerClass=""
		                    filterBy="#{leadAssignLst.dataObj.status}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.status']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.status}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.teamName}" headerClass=""
		                    filterBy="#{leadAssignLst.dataObj.teamName}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.team']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.teamName}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.userId}" headerClass=""
		                    filterBy="#{leadAssignLst.dataObj.userId}" filterEvent="onkeyup">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.user']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.userId}" />
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
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabLeadAssign_001-1"
											maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllLeadAssign_001-1" style="background-color: #cccccc;"
											page="#{semmsa001Bean.scrollerPage}">
										<a4j:support event="onclick"  reRender="frmSearchResult_001-1"></a4j:support>
										</rich:datascroller>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
							
						</rich:dataTable>
					</a4j:region>
					</a4j:form>
				</rich:panel>
				
				<!-- << table result -->
				
				<a4j:form id="frmMsa001panel1_sendAsgn">

				<table style="width:98%; background-color:d0d0d0; border:2px solid e0e0e0;">
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="Team : " style="font-weight:bold;" styleClass="ms7" />
						</td>
						<td style="width:20%; text-align:left;">
							<a4j:region>
								<h:selectOneMenu style="width:100%;" id="msa001panel1_team" value="#{semmsa001Bean.siteAppObjParam.toTeam}" 
								onchange="msa001panel1_GetMemberListJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.teamList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa001panel1_GetMemberListJS" action="#{semmsa001Action.getMemberList}" 
								reRender="msa001panel1_member, msa001panel1_asgnRe, msa001panel1_except" />
							</a4j:region>
						</td>
						<td style="width:10%; text-align:right;">
							<h:outputText value="User : " style="font-weight:bold;" styleClass="ms7" />
						</td>
						<td style="width:20%; text-align:left;">
							<a4j:region>
								<h:selectOneMenu style="" id="msa001panel1_member" value="#{semmsa001Bean.siteAppObjParam.toUser}" 
								onchange="msa001panel1_GetMemberSelectedJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.memberList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa001panel1_GetMemberSelectedJS" action="#{semmsa001Action.getMemberSelected}" 
								reRender="msa001panel1_member, msa001panel1_asgnRe, msa001panel1_except" />
							</a4j:region>
						</td>
						<td style="width:30%; text-align:left;">
							<a4j:commandButton id="msa001panel1_asgnRe" value="Assign" styleClass="rich-button"
							action="#{semmsa001Action.doAssignUpdate}" disabled="#{semmsa001Bean.disabledChecked or semmsa001Bean.disabledAssignBtn}"
							reRender="panelWrapper_tree, panelWrapper_content, msa001panel1_asgnRe" 
							oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
								<a4j:actionparam name="paramAssignFromPage" value="msa001-1" />
								<a4j:actionparam name="reassignFlag" value="F" />
							</a4j:commandButton>
							
							<rich:spacer width="5"></rich:spacer>
							
							<a4j:commandButton id="msa001panel1_except" value="#{jspMsg['label.th_except']}" styleClass="rich-button"
							disabled="#{semmsa001Bean.disabledChecked or semmsa001Bean.disabledExceptBtn}"
							action="#{semmsa001Action.clearReasonNotProcess}" reRender="popupConfirmDoExceptUpdate"
							oncomplete="#{rich:component('popupConfirmDoExceptUpdate')}.show();"/>
						</td>
					</tr>
				</table>
				
				<rich:modalPanel id="popupConfirmDoExceptUpdate" autosized="true" domElementAttachment="parent">
					<f:facet name="header">
						<h:panelGroup>
							<h:outputText value="#{jspMsg['label.specifyReasonNotProcess']}"/>
						</h:panelGroup>
					</f:facet>
					<table style="width: 500px;">
						<tr>
							<td valign="top">
								<h:outputText value="#{jspMsg['label.th_remark']} :" styleClass="ms7"/>
							</td>
							<td>
								<h:inputTextarea id="reasonNotProcess" value="#{semmsa001Bean.reasonOfNotProcess}" cols="60" rows="5" onkeypress="if(this.value.length > 300) return false;"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a4j:commandButton id="msa001panel1_except_confirm" value="#{jspMsg['column.header.th_save']}" styleClass="rich-button" 
									action="#{semmsa001Action.doExceptUpdate}"
									reRender="panelWrapper_tree, panelWrapper_content, msa001panel1_except">
									
									<rich:componentControl for="msa001panel1_except_confirm" operation="hide" event="oncomplete" />
									<rich:componentControl for="msa001PopUpCommon_retStatus" operation="show" event="oncomplete" />
								</a4j:commandButton>
									&nbsp; &nbsp;  
								<a4j:commandButton value="#{jspMsg['column.header.th_cancel']}" styleClass="rich-button" immediate="true">
									<rich:componentControl for="popupConfirmDoExceptUpdate" operation="hide" event="onclick" />
								</a4j:commandButton>
							</td>
						</tr>
					</table>
				</rich:modalPanel>
				
				</a4j:form>
				
				
				<!-- >> table summary -->
				<div id="tabSummary_001-1" style="width:900px; overflow:scroll; border:1px solid e0e0e0;"> 
					<a4j:form id="frmSummary_001-1">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabSummary_001-1" cellpadding="1" cellspacing="0" border="0" 
						var="asgnSummaryLst"  value="#{semmsa001Bean.assignSummaryList}" reRender="dataTabSummary_001-1" 
						rowClasses="cur" styleClass="dataTable">
					
							<!-- header -->
							<f:facet name="header">
				                <rich:columnGroup>
				                	<rich:column colspan="8" style="text-align:left;">
					                	<h:outputText value="#{jspMsg['label.assignSummary']}"/>
					                </rich:column>
				                    <rich:column breakBefore="true" style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.team']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.user']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.th_new']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.th_reNew']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.th_editContract']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.waitForTerminate']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.terminate']}"/>
				                    </rich:column>
				                    <rich:column style="white-space:nowrap;">
				                        <h:outputText value="#{jspMsg['column.header.th_sum']}"/>
				                    </rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- header -->
							
							<!-- data -->
							<rich:column>
		                        <h:outputText id="msa001panel1_teamName" value="#{asgnSummaryLst.dataObj.teamName}" />
		                    </rich:column>
		                    <rich:column>
			                    <div align="center">
									<h:outputText id="msa001panel1_userId" value="#{asgnSummaryLst.dataObj.userId}" />
								</div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel1_sumNewSite" value="#{asgnSummaryLst.dataObj.sumNewSite}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel1_sumReNewSite" value="#{asgnSummaryLst.dataObj.sumReNewSite}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel1_sumEditSite" value="#{asgnSummaryLst.dataObj.sumEditSite}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel1_sumWaitTerminate" value="#{asgnSummaryLst.dataObj.sumWaitTerminate}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel1_sumterminate" value="#{asgnSummaryLst.dataObj.sumterminate}" />
		                       </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel1_sumTotal" value="#{asgnSummaryLst.dataObj.sumTotal}" />
		                        </div>
		                    </rich:column>
							<!-- data -->
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="8">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsa001Bean.assignSummaryList)}"></f:param>
										</h:outputFormat>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- footer -->
						</rich:dataTable>
					</a4j:region>
					</a4j:form>
				</div>
				<!-- << table summary -->
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->
	
	