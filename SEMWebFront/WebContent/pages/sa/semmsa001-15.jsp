
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa001" var="jspMsg" />

	<!-- >> wrapper panel -->
	
		<rich:panel id="panelWrapper001-15" style="height:100%; border:1 ececec solid;" rendered="#{semmsa001Bean.panelDisplay == 'semmsa15'}">
			<!-- >> content panel 1 -->
			
				<!-- >> header content 1 -->
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_except']} [semmsa001-15]"/>
					</f:facet>
				<!-- << header content 1 -->
				
				<!-- >> table result -->
				<rich:panel id="tabResult_001-15" styleClass="sem_autoScrollbarInTodoSA">
					<a4j:form id="frmSearchResult_001-15">
					<a4j:region>
						<rich:dataTable style="width:100%;" id="dataTabLeadAssign_001-15" cellpadding="1" cellspacing="0" border="0" 
						var="leadAssignLst"  value="#{semmsa001Bean.siteAppList}" reRender="dataTabLeadAssign_001-15, dataScrllLeadAssign_001-15" 
						rows="#{semmsa001Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
						
							<!-- detail -->
							<rich:column style="text-align:center;" styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}" >
		                    	<f:facet name="header">
		                    		<h:selectBooleanCheckbox value="#{semmsa001Bean.chkSelAll}" style="width:20px;" rendered="false">
										<a4j:support event="onclick" action="#{semmsa001Action.selectAllRow}" 
										reRender="dataTabLeadAssign_001-15, msa001-15_asgnRe">
											<a4j:actionparam name="paramObjectType" value="siteAppr" />
										</a4j:support>
									</h:selectBooleanCheckbox>
		                    	</f:facet>
	                        	<h:selectBooleanCheckbox id="chkSelect" value="#{leadAssignLst.checkBox}">
									<a4j:support event="onclick" action="#{semmsa001Action.doDisabledChecked}" 
									reRender="dataTabLeadAssign_001-15, msa001-15_asgnRe">
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
		                    filterBy="#{leadAssignLst.dataObj.locationId}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationId']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.locationId}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.locationCode}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.locationCode}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationCode']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.locationCode}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{leadAssignLst.dataObj.locationNameTh}"  
		                    filterBy="#{leadAssignLst.dataObj.locationNameTh}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationName']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.locationNameTh}" style="width:200px;"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteCode}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteCode}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteCode']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteCode}" />
		                        <h:inputHidden value="#{leadAssignLst.dataObj.siteId}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteGroup}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteGroup}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteGroup']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteGroup}"/>
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.system}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.system}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.system']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.system}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.siteType}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteType}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteType']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteType}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.stationType}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.stationType}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.stationType']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.stationType}" />
		                    </rich:column>
		                    
		                    <rich:column sortBy="#{leadAssignLst.dataObj.siteNameTh}" 
		                    filterBy="#{leadAssignLst.dataObj.siteNameTh}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.siteName']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteNameTh}" style="width:200px;"/>
		                    </rich:column>
		                    
		              
		                    <rich:column sortBy="#{leadAssignLst.dataObj.siteDetail}" headerClass="headerFilterWidth"
		                    filterBy="#{leadAssignLst.dataObj.siteDetail}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.locationSite']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.siteDetail}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.teamName}" 
		                    filterBy="#{leadAssignLst.dataObj.teamName}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.team']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.teamName}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.userId}" 
		                    filterBy="#{leadAssignLst.dataObj.userId}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['column.header.user']}"/>
		                    	</f:facet>
		                        <h:outputText value="#{leadAssignLst.dataObj.userId}" />
		                    </rich:column>
		                    
		                    <rich:column style="text-align:center;" sortBy="#{leadAssignLst.dataObj.remark}" 
		                    filterBy="#{leadAssignLst.dataObj.remark}" filterEvent="onkeyup"
		                    styleClass="#{(semmsa002Bean.tmpRowId==leadAssignLst.dataObj.rowId)?'onClick':'unClick'}">
		                    	<f:facet name="header">
		                    		<h:outputText value="#{jspMsg['label.th_remark']}"/>
		                    	</f:facet>
	                        	<h:outputText value="#{leadAssignLst.dataObj.remark}" style="width:300px;"/>
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
									<rich:column colspan="12">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dataTabLeadAssign_001-15"
											maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto"
											id="dataScrllLeadAssign_001-15" style="background-color: #cccccc;"
											page="#{semmsa001Bean.scrollerPage}">
										<a4j:support event="onclick" reRender="panelWrapper_content, frmSearchResult_001-15"></a4j:support>
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
				
				<a4j:form id="frmMsa001-15_sendAsgn">
				
				<table style="width:98%; background-color:d0d0d0; border:2px solid e0e0e0;">
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="Team : " style="font-weight:bold;" styleClass="ms7" />
						</td>
						<td style="width:20%; text-align:left;">
							<a4j:region>
								<h:selectOneMenu style="width:100%;" id="msa001-15_team" value="#{semmsa001Bean.siteAppObjParam.toTeam}" 
								onchange="msa001panel15_GetMemberListJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.teamList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa001panel15_GetMemberListJS" reRender="msa001-15_member, msa001-15_asgnRe" 
								action="#{semmsa001Action.getMemberList}"/>
							</a4j:region>
						</td>
						<td style="width:10%; text-align:right;">
							<h:outputText value="User : " style="font-weight:bold;" styleClass="ms7" />
						</td>
						<td style="width:20%; text-align:left;">
							<a4j:region>
								<h:selectOneMenu style="" id="msa001-15_member" value="#{semmsa001Bean.siteAppObjParam.toUser}" 
								onchange="msa001panel15_GetMemberSelectedJS();" styleClass="ms7">
									<f:selectItems value="#{semmsa001Bean.memberList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="msa001panel15_GetMemberSelectedJS" action="#{semmsa001Action.getMemberSelected}" 
								reRender="msa001-15_member, msa001-15_asgnRe" />
							</a4j:region>
						</td>
						<td style="width:30%; text-align:right;">
							<a4j:commandButton id="msa001-15_asgnRe" value="Assign" styleClass="rich-button" action="#{semmsa001Action.doAssignUpdate}" 
							disabled="#{semmsa001Bean.disabledChecked or semmsa001Bean.disabledAssignBtn}"
							reRender="panelWrapper_tree, panelWrapper_content, msa001-15_asgnRe"
							oncomplete="#{rich:component('msa001PopUpCommon_retStatus')}.show();">
								<a4j:actionparam name="paramExcept" value="Y" />
								<a4j:actionparam name="paramAssignFromPage" value="msa001-15" />
							</a4j:commandButton>
						</td>
					</tr>
				</table>
				
				</a4j:form>
				
			</rich:panel>
			<!-- << content panel 1 -->

	<!-- << wrapper panel -->
