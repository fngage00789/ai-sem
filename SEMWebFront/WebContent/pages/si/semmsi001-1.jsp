<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.siteinfo.semmsi001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchSiteApprove">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		
		<h:panelGroup style="width:100%;">
		
		<h:panelGrid>
			<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi001Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
            </rich:messages>
		</h:panelGrid>
		
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="100%">
					<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="10%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</h:panelGroup>
			                			</td>
			                			<td width="30%" valign="bottom">
										<h:selectOneMenu id="ddlCompany" value="#{semmsi001Bean.searchCriteria.company}" onchange="GetCompanyJS();">
											<f:selectItems value="#{semmsi001Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmsi001Bean.searchCriteria.company}" styleClass="ms28"/>
					                	</td>
					                	<td align="right" width="10%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td width="50%">
											<h:selectOneMenu id="ddlRegion" value="#{semmsi001Bean.searchCriteria.region}">
												<f:selectItems value="#{semmsi001Bean.regionList}"/>
											</h:selectOneMenu>
										</td>
				                	</tr>
									<tr>
										<td align="right" width="10%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtDocNo" value="#{semmsi001Bean.searchCriteria.docNo}" 
												size="18" maxlength="20" />
										</td><td align="right" width="10%">
											<h:outputText value="#{jspMsg['label.docDate']}" styleClass="ms7"/>
										</td><td width="50%">
											<rich:calendar id="cldDocDateFrom" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmsi001Bean.searchCriteria.docDateFrom}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','cldDocDateFrom','cldDocDateTo');"
											   	   oncollapse="validateRichCalendarFromTo('frmSearch','cldDocDateFrom','cldDocDateTo');"
											   	   label="#{jspMsg['msg.docDateFrom']}">
											</rich:calendar>
											
											<rich:spacer width="1"></rich:spacer> -
											<rich:calendar id="cldDocDateTo" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmsi001Bean.searchCriteria.docDateTo}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="15px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmSearch','cldDocDateTo','cldDocDateFrom');"
											   	   oncollapse="validateRichCalendarFromTo('frmSearch','cldDocDateTo','cldDocDateFrom');"
											   	   label="#{jspMsg['msg.docDateTo']}">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.reqOfficer']}" styleClass="ms7"/>
										</td><td colspan="3">
											<h:inputText id="txtReqOfficer" value="#{semmsi001Bean.searchCriteria.reqOfficer}" 
												size="30" maxlength="35"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlReqType" value="#{semmsi001Bean.searchCriteria.reqType}">
												<f:selectItems value="#{semmsi001Bean.reqTypeList}"/>
											</h:selectOneMenu>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtTitle" value="#{semmsi001Bean.searchCriteria.title}" 
												size="30" maxlength="35"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtContractNo" value="#{semmsi001Bean.searchCriteria.contractNo}" 
												size="23" maxlength="20"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteApproveStatus']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:selectOneMenu id="ddlSiteApproveStatus" value="#{semmsi001Bean.searchCriteria.siteApproveStatus}">
												<f:selectItems value="#{semmsi001Bean.siteApproveStatusList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtLocationId" value="#{semmsi001Bean.searchCriteria.locationId}" 
												size="15" maxlength="12"/>
										</td><td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationName']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtLocationName" value="#{semmsi001Bean.searchCriteria.locationName}" 
												size="30" maxlength="35"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtBatchNo" value="#{semmsi001Bean.searchCriteria.batchNo}" 
												size="15" maxlength="12"/>
										</td><td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.createByEng']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtCreateBy" value="#{semmsi001Bean.searchCriteria.createBy}" 
												size="15" maxlength="12"/>
										</td>
									</tr>
									<tr>
										<td align="right"></td>
										<td align="left">
										<h:selectBooleanCheckbox id="chkCurrentFlag" value="#{semmsi001Bean.searchCriteria.chkCurrentFlag}"/>
										<rich:spacer width="2px"/>
										<h:outputText value="#{jspMsg['label.currentFlag']}" styleClass="ms7"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.zone']}" styleClass="ms7"/>
										</td>
										<td>
											<h:selectOneMenu id="ddlZone" value="#{semmsi001Bean.searchCriteria.zone}">
												<f:selectItems value="#{semmsi001Bean.zoneList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchSiteApprove,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbSiteApprove">
			            		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
				<!-- end content layout criteria -->
			<!-- begin content layout data grid -->
			<h:panelGrid style="width: 100%">
			<a4j:form id="frmResult">
				<!-- begin content button -->
				<h:panelGrid columns="4" id="grdActionCommand">
					<a4j:commandButton id="btnNew" value="#{jspMsg['btn.new']}" styleClass="rich-button" 
						action="#{navAction.navi}" reRender="oppContent" 
						rendered="#{semmsi001Bean.renderer['btnNew']}">
						<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
						<a4j:actionparam name="methodWithNavi" value="pageLoad" />
						<a4j:actionparam name="mode" value="ADD" />
					</a4j:commandButton>
					<h:commandButton id="btnExport" action="#{semmsi001Action.doExportExcel}"
							styleClass="rich-button" value="#{jspMsg['btn.export']}" 
							disabled="#{semmsi001Bean.disBtnExport}" style="width: 120px" 
							rendered="#{!semmsi001Bean.btnExportFlag}">
							<f:param name="clearBatch" value="N"/>
							<a4j:support  event="onclick"  reRender="frmResult,pnlSearchResult,pnlSearchSiteApprove,frmError,show_report"/>  
					</h:commandButton>
					
					<a4j:commandButton id="btnExport2" action="#{navAction.navi}"
							styleClass="rich-button" value="#{jspMsg['btn.export']}"  
							disabled="#{semmsi001Bean.disBtnExport}" style="width: 120px" 
							rendered="#{semmsi001Bean.btnExportFlag}" 
							reRender="pnlSearchSiteApprove,frmError">
						<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
						<a4j:actionparam name="methodWithNavi" value="chkReRenderExport" />
					</a4j:commandButton>
					
					<a4j:commandButton id="clearBatchNo" action="#{navAction.navi}" 
						styleClass="rich-button" value="#{jspMsg['btn.clearBatchNo']}"
						disabled="#{semmsi001Bean.disBtnExport}"
						reRender="pnlSearchSiteApprove,frmError,pnlSearchResult,btnExport2,btnExport">
						<a4j:actionparam name="navModule" value="si" />
						<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
						<a4j:actionparam name="moduleWithNavi" value="si" />
						<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
						<a4j:actionparam name="methodWithNavi" value="doExportExcel" />
						<f:param name="clearBatch" value="Y"/>
					</a4j:commandButton>
				</h:panelGrid>
				<!-- end content button -->
				
				

					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2000"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmsi001Bean.msgDataNotFound}" rendered="#{semmsi001Bean.renderedMsgDataNotFound}" />
						</div>
						
						<center>				
						
						
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteApprove" cellpadding="1" cellspacing="0" border="0" 
							var="siteApprove"  value="#{semmsi001Bean.siteApproveList}" reRender="dtbSiteApprove" 
							rows="#{semmsi001Bean.rowPerPage}" 
							rowClasses="cur" 
							styleClass="dataTable">
							
							<a4j:support event="onRowClick" action="#{semmsi001Action.getRowIdOnClick}" reRender="dtbSiteApprove">
								<a4j:actionparam name="rowId" value="#{siteApprove.dataObj.rowId}" />
								<a4j:actionparam name="mode" value="SITEAPPROVE" />
							</a4j:support>
							
							<!-- begin column -->
							<rich:column styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmsi001Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmsi001Action.selectAllRow}" reRender="dtbSiteApprove,btnExport,btnExport2,grdActionCommand"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="siteApproveSelected" value="#{siteApprove.checkBox}" 
										rendered="#{siteApprove.dataObj.siteApproveStatus == '01'}">
										<a4j:support event="onclick" action="#{semmsi001Action.onRenderExportButton}" reRender="btnExport2,btnExport,dtbSiteApprove,grdActionCommand">
											<a4j:actionparam name="rowId" value="#{siteApprove.dataObj.rowId}" />
											<a4j:actionparam name="batchNo" value="#{siteApprove.dataObj.batchNo}" />
										</a4j:support>
										
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmsi001Bean.renderer['btnEdit']}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="Edit" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
										action="#{navAction.navi}" reRender="oppContent" title="edit" 
										id="btnEdit" rendered="#{siteApprove.dataObj.editFlag == 'Y'}">
										
										
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="EDIT"/>
										<a4j:actionparam name="siteApproveId" value="#{siteApprove.dataObj.rowId}"/>
										<a4j:actionparam name="cancelFlag" value="#{siteApprove.dataObj.cancelFlag}"/>
										<a4j:actionparam name="closeFlag" value="#{siteApprove.dataObj.closeFlag}"/>
										<a4j:actionparam name="siteInfoStatus" value="#{siteApprove.dataObj.siteInfoStatus}"/>
										<a4j:actionparam name="siteInfoId" value="#{siteApprove.dataObj.siteInfoId}"/>
										
										<%--
										<a4j:actionparam name="navModule" value="sa" />
										<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									
										<a4j:actionparam name="rowId" value="#{siteApprove.dataObj.rowId}" />
										<a4j:actionparam name="paramMode" value="E" />
										
										<a4j:actionparam name="paramBackToMe" value="Y" />
		                                <a4j:actionparam name="paramNavModuleFrom" value="si" />
		                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSI001-1" />
		                                <a4j:actionparam name="paramModuleWithNaviFrom" value="si" />
		                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSI001" />
		                                <a4j:actionparam name="paramMethodWithNaviFrom" value="pageLoad" />
		                                <a4j:actionparam name="mode" value="SEARCH" />
										--%>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmsi001Bean.renderer['btnDelete']}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="Delete" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialogSI001')}.show(); return false" 
     									   action="#{navAction.navi}"  image="images/delete.png" style="height: 15; width: 15;" 
     									   title="delete" id="btnDelete" rendered="#{siteApprove.dataObj.deleteFlag == 'Y'}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI001-1" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
										<a4j:actionparam name="methodWithNavi" value="initDelete" />
										<a4j:actionparam name="siteApproveId" value="#{siteApprove.dataObj.rowId}"/>
										<a4j:actionparam name="cancelFlag" value="#{siteApprove.dataObj.cancelFlag}"/>
										<a4j:actionparam name="closeFlag" value="#{siteApprove.dataObj.closeFlag}"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								rendered="#{semmsi001Bean.renderer['btnView']}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="View" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton  action="#{navAction.navi}" image="images/view.png" style="height: 15; width: 15"
	            					reRender="oppContent,pnlLog" title="view" id="btnView">
	            					
	            						<%--
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="siteApproveId" value="#{siteApprove.dataObj.rowId}"/>
										<a4j:actionparam name="cancelFlag" value="#{siteApprove.dataObj.cancelFlag}"/>
										<a4j:actionparam name="closeFlag" value="#{siteApprove.dataObj.closeFlag}"/>
										<a4j:actionparam name="siteInfoId" value="#{siteApprove.dataObj.siteInfoId}"/>
										<a4j:actionparam name="mode" value="VIEW"/>
										--%>
										
										<a4j:actionparam name="navModule" value="sa" />
										<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										
										<a4j:actionparam name="moduleWithNavi" value="sa" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										<a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									
										<a4j:actionparam name="rowId" value="#{siteApprove.dataObj.rowId}" />
										<a4j:actionparam name="paramMode" value="V" />
										
										<a4j:actionparam name="paramBackToMe" value="Y" />
		                                <a4j:actionparam name="paramNavModuleFrom" value="si" />
		                                <a4j:actionparam name="paramNavProgramFrom" value="SEMMSI001-1" />
		                                <a4j:actionparam name="paramModuleWithNaviFrom" value="si" />
		                                <a4j:actionparam name="paramActionWithNaviFrom" value="SEMMSI001" />
		                                <a4j:actionparam name="paramMethodWithNaviFrom" value="pageLoad" />
		                                <a4j:actionparam name="mode" value="SEARCH" />
		                                
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.regionName}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.dataObj.regionName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.docNo}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docNo']}" style="width: 50"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{siteApprove.dataObj.docNo}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.contractNo}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" style="width: 10"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{siteApprove.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{siteApprove.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.locationName}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationName']}" style="width: 150"/>
								</f:facet>
								<div align="left" style="width: 150px;">
									<h:outputText value="#{siteApprove.dataObj.locationName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.locationId}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}" style="width: 50"/>
								</f:facet>
								<div align="center" style="width: 50px;">
									<h:outputText value="#{siteApprove.dataObj.locationId}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.docDate}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.docDate']}" style="width: 78"/>
								</f:facet>
								<div align="center" style="width: 78px;">
									<h:outputText value="#{siteApprove.dataObj.docDateStr}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{siteApprove.dataObj.reqTypeName}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqTypeName']}" style="width: 100"/>
								</f:facet>
								<div align="center" style="width: 100px;">
									<h:outputText value="#{siteApprove.dataObj.reqTypeName}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{siteApprove.dataObj.reqOfficer}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqOfficer']}" style="width: 100"/>
								</f:facet>
								<div align="left" style="width: 100px;">
									<h:outputText value="#{siteApprove.dataObj.reqOfficer}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.title}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.title']}" style="width: 150"/>
								</f:facet>
								<div align="left" style="width: 150px;">
									<h:outputText value="#{siteApprove.dataObj.title}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.outDt}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.outDate']}" style="width: 78">
									</h:outputText>
								</f:facet>
								<div align="center" style="width: 78px;">
									<h:outputText value="#{siteApprove.dataObj.outDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.siteApproveStatusName}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteApproveStatusName']}" style="width: 150"/>
								</f:facet>
								<div align="center" style="width: 150px;">
									<h:outputText value="#{siteApprove.dataObj.siteApproveStatusName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.siteStatusName}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 50"/>
								</f:facet>
								<div align="center" style="width: 50px;">
									<h:outputText value="#{siteApprove.dataObj.siteStatusName}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{siteApprove.dataObj.flowStatus}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="Flow Status" style="width: 120"/>
								</f:facet>
								<div align="center" style="width: 120px;">
									<h:outputText value="#{siteApprove.dataObj.flowStatus}"/>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{siteApprove.dataObj.batchNo}" 
								styleClass="#{(semmsi001Bean.tmpRowId==siteApprove.dataObj.rowId)?'onClick':'unClick'}" 
								title="#{siteApprove.dataObj.contractNo} #{siteApprove.dataObj.locationName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.batchNo']}" style="width: 100"/>
								</f:facet>
								<div align="center" style="width: 100px;">
									<h:outputText value="#{siteApprove.dataObj.batchNo}"/>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi001Bean.siteApproveList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="14">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteApprove"
											maxPages="#{semmsi001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstBGMaster" 
											style="background-color: #cccccc;"
											page="#{semmsi001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
						
						</center>
						
					</rich:panel>
				
				
			</a4j:form>
			</h:panelGrid>
				<!-- end content layout data grid -->
		</h:panelGrid>
		
		</h:panelGroup>
		
	</rich:panel>
</h:panelGrid>
<!-- ShowReport Panel -->
				<h:panelGrid id="show_report" style="height:50px;width:50px;" width="0" columns="0">
					<h:panelGroup id="show_report_in" rendered="#{semmsi001Bean.displayBtn}" style="height:50px;width:50px;" >
						<script type="text/javascript">
							var ctrl = document.getElementById('incContent:frmSearch:btnSearch');
							ctrl.click();
						</script>
					</h:panelGroup>							
				</h:panelGrid>
				<!-- End Code -->
<rich:modalPanel id="mdpConfirmDelDialogSI001" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="200px">
						<h:outputText value="#{semmsi001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="dtbSiteApprove,frmError" >
							<a4j:actionparam name="navModule" value="si" />
		            		<a4j:actionparam name="navProgram" value="SEMMSI001-1" />	
							<a4j:actionparam name="moduleWithNavi" value="si" />
							<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />							
							<rich:componentControl for="mdpConfirmDelDialogSI001" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialogSI001" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>