
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->
	
		<rich:panel id="panelWrapper001-12" style="height:100%; border:1 ececec solid;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa03'}">
			<!-- >> content panel 1 -->
			
				<!-- >> header content 1 -->
					<f:facet name="header">
						<h:outputText value="Leader Assign - ReNew Location / #{jspMsg['label.assignSummary']} [semmsa001-12]"/>
					</f:facet>
				<!-- << header content 1 -->
				
				<!-- >> table result -->
				
				<rich:panel id="tabResult_001-12" styleClass="sem_autoScrollbarInTodoSA">
					<a4j:form id="frmSearchResult_001-12">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabLeadAssign_001-12" cellpadding="1" cellspacing="0" border="0" 
						var="leadAssignReNewLst"  value="#{semmsa001Bean.siteAppList}" reRender="dataTabLeadAssign_001-12, dataScrllLeadAssign_001-12" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
						
							<!-- detail -->
							<rich:column style="text-align:center;">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;" rendered="false">
										<a4j:support event="onclick" action="#{semmsa001Action.selectAllRow}" 
										reRender="dataTabLeadAssign_001-12, msa001panel12_asgnRe, msa001panel12_except">
											<a4j:actionparam name="paramObjectType" value="siteAppr" />
										</a4j:support>
									</h:selectBooleanCheckbox>
								</f:facet>
								<h:selectBooleanCheckbox id="chkSelect" value="#{leadAssignReNewLst.checkBox}">
									<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
									reRender="dataTabLeadAssign_001-12, msa001panel12_asgnRe, msa001panel12_except">
										<a4j:actionparam name="paramObjectType" value="siteAppr" />
									</a4j:support>
								</h:selectBooleanCheckbox>
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.region}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.region}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_location']}"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.region}"/>
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.locationZone}" headerClass="headerWidth_150"
		                    filterBy="#{leadAssignReNewLst.dataObj.locationZone}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Zone"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.locationZone}" style="width:200px;"/>
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.company}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.company}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_company']}"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.company}" />
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.docNo}" headerClass="headerFilterWidth_100"
		                    filterBy="#{leadAssignReNewLst.dataObj.docNo}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_approveNumber']}" style="white-space:nowrap;" />
								</f:facet>
								<a4j:commandLink value="#{leadAssignReNewLst.dataObj.docNo}" action="#{navAction.navi}"
		                        reRender="oppContent">
		                        	<a4j:actionparam name="navModule" value="sa" />
									<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									
									<a4j:actionparam name="moduleWithNavi" value="sa" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									
									<a4j:actionparam name="rowId" value="#{leadAssignReNewLst.dataObj.rowId}" />
									<a4j:actionparam name="paramUrl" value="#{semmsa001Bean.panelDisplay}" />
									<a4j:actionparam name="paramMenuGroup" value="#{semmsa001Bean.menuGroupDisplay}" />
									<a4j:actionparam name="paramMenuType" value="#{semmsa001Bean.menuGroupType}" />
									<a4j:actionparam name="paramMode" value="V" />
									<a4j:actionparam name="paramLeaderFlag" value="Y" />
								</a4j:commandLink>
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.contractNo}" headerClass="headerFilterWidth_100"
		                    filterBy="#{leadAssignReNewLst.dataObj.contractNo}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_contractNumber']}"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.contractNo}" />
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.locationId}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.locationId}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Location ID"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.locationId}" />
							</rich:column>
							
							<rich:column sortBy="#{leadAssignReNewLst.dataObj.locationName}" 
		                    filterBy="#{leadAssignReNewLst.dataObj.locationName}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Location Name"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.locationName}" style="width:200px;"/>
							</rich:column>
							
							<rich:column sortBy="#{leadAssignReNewLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.siteDetail}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Site Name/Site Code/Site Type/ Station Type" style="white-space:nowrap;" />
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.siteDetail}" />
							</rich:column>
							
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.effectiveDt}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.effectiveDtStr}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_beginDtm']}"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.effectiveDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" />
								</h:outputText>
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.expireDt}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.expireDtStr}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_endDtm']}"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.expireDtStr}">
									<f:convertDateTime pattern="dd/MM/yyyy" />
								</h:outputText>
							</rich:column>
							
							<rich:column sortBy="#{leadAssignReNewLst.dataObj.expireDetail}" headerClass=""
		                    filterBy="#{leadAssignReNewLst.dataObj.expireDetail}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Expire Detail"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.expireDetail}" />
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.networkStatus}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.networkStatus}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Network Status"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.networkStatus}" />
							</rich:column>
							
							<rich:column sortBy="#{leadAssignReNewLst.dataObj.reqDocType}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.reqDocType}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_type']}#{jspMsg['column.header.th_apprDoc']}/#{jspMsg['column.header.th_type_subject']}" style="white-space:nowrap" />
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.reqDocType}" />
							</rich:column>
							
							<rich:column sortBy="#{leadAssignReNewLst.dataObj.reqOfficer}" 
		                    filterBy="#{leadAssignReNewLst.dataObj.reqOfficer}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_from']}" style="white-space:nowrap;" />
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.reqOfficer}" style="width:200px;"/>
							</rich:column>
							
							<rich:column style="text-align:right;" sortBy="#{leadAssignReNewLst.dataObj.costPerYear}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.costPerYear}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_cost_per_year']}" style="white-space:nowrap" />
								</f:facet>
								
	                    		  <a4j:commandLink id="msa001-2_popupRentSpecial" action="#{semmsa001Action.doShowPopupRentSpecial}" value="#{waitingApprLst.dataObj.costPerYear}" 
                               	reRender="popupRentSpecial" oncomplete="#{rich:component('popupRentSpecial')}.show();" >
                                   <f:param name="paramSiteAppId" value="#{waitingApprLst.dataObj.rowId}"/>
                                </a4j:commandLink>
							</rich:column>
							
							<%-- 
							<rich:column sortBy="#{leadAssignReNewLst.dataObj.modifiedDetail}" 
		                    filterBy="#{leadAssignReNewLst.dataObj.modifiedDetail}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_modified_detail']}" style="white-space:nowrap" />
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.modifiedDetail}" />
							</rich:column>
							--%>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.nearSiteCost}" headerClass=""
		                    filterBy="#{leadAssignReNewLst.dataObj.nearSiteCost}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_near_site_cost']}" style="white-space:nowrap;" />
								</f:facet>
								<a4j:commandLink id="msa001-12_popNearestSite" action="#{semmsa001Action.doShowPopupNearestSite}" value="#{leadAssignReNewLst.dataObj.nearSiteCost}" 
                               	reRender="msa001PopUpCommon_NearestSite" oncomplete="#{rich:component('msa001PopUpCommon_NearestSite')}.show();">
                                   <f:param name="paramSiteAppId" value="#{leadAssignReNewLst.dataObj.rowId}"/>
                                </a4j:commandLink>
							</rich:column>
							
							<rich:column style="text-align:right;" sortBy="#{leadAssignReNewLst.dataObj.growingCost}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.growingCost}" filterEvent="onkeyup"
		                    rendered="#{semmsa001Bean.renderColumnDiffNearSite == 'false'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_growing_cost']}" style="white-space:nowrap;" />
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.growingCost}" />
							</rich:column>
							
							<rich:column style="text-align:right;" sortBy="#{leadAssignReNewLst.dataObj.growingCost}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.growingCost}" filterEvent="onkeyup"
		                    rendered="#{semmsa001Bean.renderColumnDiffNearSite}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.th_rentDiffNearSite']}" style="white-space:nowrap;" />
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.growingCost}" />
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.updateBy}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.updateBy}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Update By"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.updateBy}" />
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.teamName}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.teamName}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Assign to Team"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.teamName}" />
							</rich:column>
							
							<rich:column style="text-align:center;" sortBy="#{leadAssignReNewLst.dataObj.userId}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignReNewLst.dataObj.userId}" filterEvent="onkeyup">
								<f:facet name="header">
									<h:outputText value="Assign to User"/>
								</f:facet>
								<h:outputText value="#{leadAssignReNewLst.dataObj.userId}" />
							</rich:column>
							<!-- detail -->
							
							<!-- footer -->
							<f:facet name="footer">
								<rich:columnGroup>
									<!-- > 1 -->
									<rich:column colspan="5">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsa001Bean.siteAppList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<!-- > 2 -->
									<rich:column colspan="17">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabLeadAssign_001-12"
											maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dataScrllLeadAssign_001-12" style="background-color: #cccccc;"
											page="#{semmsa001Bean.scrollerPage}">
										<a4j:support event="onclick"  reRender="frmSearchResult_001-12"></a4j:support>
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
				
				
				<a4j:form id="frmMsa001panel12_sendAsgn">

				<table style="width:98%; background-color:d0d0d0; border:2px solid e0e0e0;">
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="Team : " style="font-weight:bold;" styleClass="ms7" />
						</td>
						<td style="width:20%; text-align:left;">
							<a4j:region>
								<h:selectOneMenu style="width:100%;" id="msa001panel12_team" value="#{semmsa001Bean.siteAppObjParam.toTeam}" 
								onchange="msa001panel12_GetMemberListJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.teamList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa001panel12_GetMemberListJS" action="#{semmsa001Action.getMemberList}" 
								reRender="msa001panel12_member, msa001panel12_asgnRe, msa001panel12_except" />
							</a4j:region>
						</td>
						<td style="width:10%; text-align:right;">
							<h:outputText value="User : " style="font-weight:bold;" styleClass="ms7" />
						</td>
						<td style="width:20%; text-align:left;">
							<a4j:region>
								<h:selectOneMenu style="" id="msa001panel12_member" value="#{semmsa001Bean.siteAppObjParam.toUser}" 
								onchange="msa001panel12_GetMemberSelectedJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.memberList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa001panel12_GetMemberSelectedJS" action="#{semmsa001Action.getMemberSelected}" 
								reRender="msa001panel12_member, msa001panel12_asgnRe, msa001panel12_except" />
							</a4j:region>
						</td>
						<td style="width:30%; text-align:right;">
							<a4j:commandButton id="msa001panel12_asgnRe" value="Assign" styleClass="rich-button"
							action="#{semmsa001Action.doAssignUpdate}" disabled="#{semmsa001Bean.disabledChecked or semmsa001Bean.disabledAssignBtn}"
							reRender="panelWrapper_tree, panelWrapper_content, msa001panel1_asgnRe" 
							oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
								<a4j:actionparam name="paramAssignFromPage" value="msa001-12" />
								<a4j:actionparam name="reassignFlag" value="F" />
							</a4j:commandButton>
						</td>
					</tr>
				</table>
				
				</a4j:form>
				
				
				<!-- >> table summary -->
				
				<div id="tabSummary_001-12" style="width:98%; overflow:scroll; border:1px solid e0e0e0;"> 
					<a4j:form id="frmSummary_001-12">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabSummary_001-12" cellpadding="1" cellspacing="0" border="0" 
						var="asgnSummaryLst"  value="#{semmsa001Bean.assignSummaryList}" reRender="dataTabSummary_001-12" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
					
							<!-- header -->
							<f:facet name="header">
				                <rich:columnGroup>
				                	<rich:column colspan="8" style="text-align:left;">
					                	<h:outputText value="#{jspMsg['label.assignSummary']}"/>
					                </rich:column>
				                    <rich:column breakBefore="true">
				                        <h:outputText value="#{jspMsg['column.header.team']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.user']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.th_new']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.th_reNew']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.th_editContract']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.waitForTerminate']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.terminate']}"/>
				                    </rich:column>
				                    <rich:column>
				                        <h:outputText value="#{jspMsg['column.header.th_sum']}"/>
				                    </rich:column>
								</rich:columnGroup>
							</f:facet>
							<!-- header -->
							
							<!-- data -->
							<rich:column>
		                        <h:outputText id="msa001panel12_teamName" value="#{asgnSummaryLst.dataObj.teamName}" />
		                    </rich:column>
		                    <rich:column>
			                    <div align="center">
									<h:outputText id="msa001panel12_userId" value="#{asgnSummaryLst.dataObj.userId}" />
								</div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel12_sumNewSite" value="#{asgnSummaryLst.dataObj.sumNewSite}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel12_sumReNewSite" value="#{asgnSummaryLst.dataObj.sumReNewSite}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel12_sumEditSite" value="#{asgnSummaryLst.dataObj.sumEditSite}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel12_sumWaitTerminate" value="#{asgnSummaryLst.dataObj.sumWaitTerminate}" />
		                        </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel12_sumterminate" value="#{asgnSummaryLst.dataObj.sumterminate}" />
		                       </div>
		                    </rich:column>
		                    <rich:column>
			                    <div align="right">
			                        <h:outputText id="msa001panel12_sumTotal" value="#{asgnSummaryLst.dataObj.sumTotal}" />
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
	
	