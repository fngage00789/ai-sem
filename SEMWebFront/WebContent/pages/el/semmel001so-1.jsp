<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>


<f:loadBundle basename="resources.el.semmel001so-1" var="jspMsg" />  
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchElectricMeterManagement">

		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>

		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>

		<h:panelGrid columnClasses="gridContent"  >

			<a4j:form id="frmSearch">

				<!-- begin content layout criteria -->
				
				<h:panelGrid style=" width : 100 %;" border="1">

					<rich:panel id="pnlSearchCriteria" style=" width : 100%;">

						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>

						<!-- begin content criteria -->
						
						<h:panelGrid style=" width : 98%;" border="0" cellpadding="0"  cellspacing="0">
							<h:panelGroup>
								<table width="100%" border="0">
									<tr>
										<td align="right" width="18%" valign="bottom">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td colspan="5">
										<a4j:region>
											<h:selectOneMenu id="searchCompany" value="#{semmel001Bean.searchCriteria.company}" style="width : 160px">
			                					<f:selectItems value="#{semmel001Bean.companyList}" />
			                					<a4j:support event="onchange" action="#{semmel001SOAction.doChangeCompany}" reRender="bigCompany" />
			                				</h:selectOneMenu>
			                			</a4j:region>
			                				<rich:spacer width="5"/>
			                				<h:outputText id="bigCompany" value="#{semmel001Bean.companyBigLabel}" styleClass="ms28"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="18%">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="searchContractNo" value="#{semmel001Bean.searchCriteria.contractNo}" size="30" style="width : 160px"/>
										</td>
										<td align="right" width="16%">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td>
											<a4j:region>
											<h:selectOneMenu id="searchRegion" value="#{semmel001Bean.searchCriteria.region}" 
											style="width : 160px">
		                						<f:selectItems value="#{semmel001Bean.regionList}" />
		                						<a4j:support event="onchange" action="#{semmel001SOAction.doChangeRegion}" reRender="searchProvince,ddlLessorZone" />
		                					</h:selectOneMenu>
		                					</a4j:region>
										</td>
										<td align="right" width="19%">
											<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="searchProvince" value="#{semmel001Bean.searchCriteria.province}" style="width : 160px"
											onchange="GetSiteAmphurListJS();">
			                					<f:selectItems value="#{semmel001Bean.provinceList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="searchSiteName" value="#{semmel001Bean.searchCriteria.siteName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.contractStatus']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="searchSiteStatus" value="#{semmel001Bean.searchCriteria.siteStatus}" style="width : 160px">
		                						<f:selectItems value="#{semmel001Bean.siteStatusList}" />
		                					</h:selectOneMenu>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td>
											<a4j:region>
											<h:selectOneMenu id="searchElectricType" value="#{semmel001Bean.searchCriteria.electricUseType}" style="width : 160px">
		                						<f:selectItems value="#{semmel001Bean.electricUseTypeList}" />
		                						<a4j:support event="onchange" action="#{semmel001SOAction.doChangeElectricUseType}" reRender="searchELAction, searchProcessStatus" />
		                					</h:selectOneMenu>
		                					</a4j:region>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchLocationId" value="#{semmel001Bean.searchCriteria.locationId}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchLocationCode" value="#{semmel001Bean.searchCriteria.locationCode}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.processStatusName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<a4j:region>
											<h:selectOneMenu id="searchELAction" value="#{semmel001Bean.searchCriteria.elAction}" style="width : 80px">
		                						<f:selectItems value="#{semmel001Bean.elActionList}" />
		                						<a4j:support event="onchange" action="#{semmel001SOAction.doChangeElAction}" reRender="searchProcessStatus" />
		                					</h:selectOneMenu>
		                					</a4j:region>
		                					<rich:spacer width="5"/>
											<h:selectOneMenu id="searchProcessStatus" value="#{semmel001Bean.searchCriteria.processStatusCode}" style="width : 120px">
		                						<f:selectItems value="#{semmel001Bean.processStatusNameList}" />
		                					</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.ownerName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchOwnerName" value="#{semmel001Bean.searchCriteria.ownerName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.contractPersonName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchContractPersonName" value="#{semmel001Bean.searchCriteria.lessorName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="meterId" value="#{semmel001Bean.searchCriteria.meterId}" size="30" style="width : 160px"/>
										</td>
									</tr>
									
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.areaCode']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchAreaCode" 
											value="#{semmel001Bean.areaCode}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.areaName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchAreaName" 
											value="#{semmel001Bean.areaName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.meterStatus']}" styleClass="ms7" />
										</td>
										<td width="18%"> 
											<h:selectOneRadio value="#{semmel001Bean.meterStatus}"  
											disabled="#{semmel006Bean.viewMode}"
											styleClass="ms7" rendered="true"
							                layout="lineDirection">
					                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.radio.All']}" />
					                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.radio.Active']}" />
					                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.radio.InActive']}" />
					                		</h:selectOneRadio>									
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchVendorName" 
											value="#{semmel001Bean.searchCriteria.vendorName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchPayeeName" 
											value="#{semmel001Bean.searchCriteria.payeeName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											
										</td>
										<td width="18%">
											
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.workTransferDate']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<rich:calendar id="searchWorkTransferDateFrom"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy"
												value="#{semmel001Bean.searchCriteria.newReceivedDtFrom}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','searchWorkTransferDateFrom','searchWorkTransferDateTo999');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','searchWorkTransferDateFrom','searchWorkTransferDateTo999');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar> 
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
											<rich:calendar id="searchWorkTransferDateTo999"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cancelDt']}"
												value="#{semmel001Bean.searchCriteria.newReceivedDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','searchWorkTransferDateTo999','searchWorkTransferDateFrom');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','searchWorkTransferDateTo999','searchWorkTransferDateFrom');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.cancelDate']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<rich:calendar id="searchCancelDateFrom"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cancelDt']}"
												value="#{semmel001Bean.searchCriteria.terminateReceivedDtFrom}"
												oninputblur="validateRichCalendarFromTo('frmSearch','searchCancelDateFrom','searchCancelDateTo');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','searchCancelDateFrom','searchCancelDateTo');"
												showWeeksBar="false" inputStyle="width : 80px">											
											</rich:calendar>   
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
											<rich:calendar id="searchCancelDateTo"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cancelDt']}"
												value="#{semmel001Bean.searchCriteria.terminateReceivedDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','searchCancelDateTo','searchCancelDateFrom');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','searchCancelDateTo','searchCancelDateFrom');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
										<td align="right" colspan="2">
											<h:outputText value="#{jspMsg['label.terminateCutoffDt']}" styleClass="ms7" />
										
											<rich:calendar id="terminateCutoffDtFrom"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.terminateCutoffDtFrom}"
												oninputblur="validateRichCalendarFromTo('frmSearch','terminateCutoffDtFrom','terminateCutoffDtTo');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','terminateCutoffDtFrom','terminateCutoffDtTo');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
											<rich:calendar id="terminateCutoffDtTo"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.terminateCutoffDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','terminateCutoffDtTo','terminateCutoffDtFrom');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','terminateCutoffDtTo','terminateCutoffDtFrom');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.transferDate']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<rich:calendar id="transferDateFrom"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.transferDt']}"
												value="#{semmel001Bean.searchCriteria.transferReceivedDtFrom}" 
												oninputblur="validateRichCalendarFromTo('frmSearch','transferDateFrom','transferDateTo');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','transferDateFrom','transferDateTo');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
											<rich:calendar id="transferDateTo"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.transferReceivedDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','transferDateTo','transferDateFrom');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','transferDateTo','transferDateFrom');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.serviceModifyDate']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<rich:calendar id="serviceModifyDateFrom"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cancelDt']}"
												value="#{semmel001Bean.searchCriteria.transferCutoffDtFrom}"
												oninputblur="validateRichCalendarFromTo('frmSearch','serviceModifyDateFrom','serviceModifyDateTo');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','serviceModifyDateFrom','serviceModifyDateTo');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
											<rich:calendar id="serviceModifyDateTo"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.transferCutoffDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','serviceModifyDateTo','serviceModifyDateFrom');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','serviceModifyDateTo','serviceModifyDateFrom');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
										<td align="right" colspan="2">
											<h:outputText value="#{jspMsg['label.expandOldCutoffDt']}" styleClass="ms7" />
										
											<rich:calendar id="expandOldCutoffDtFrom"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.expandOldCutoffDtFrom}"
												oninputblur="validateRichCalendarFromTo('frmSearch','expandOldCutoffDtFrom','expandOldCutoffDtTo');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','expandOldCutoffDtFrom','expandOldCutoffDtTo');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
											<rich:calendar id="expandOldCutoffDtTo"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.expandOldCutoffDtTo}"
												oninputblur="validateRichCalendarFromTo('frmSearch','expandOldCutoffDtTo','expandOldCutoffDtFrom');"
									 			oncollapse="validateRichCalendarFromTo('frmSearch','expandOldCutoffDtTo','expandOldCutoffDtFrom');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.contractStartDtTo']}" styleClass="ms7" />
										</td>
										<td><rich:calendar id="contractStartDtTo"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.contractStartDtTo}"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar></td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.printDT']}" styleClass="ms7" rendered="flase"/>
										</td>
										<td><rich:calendar id="printDT" rendered="flase"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.printDT}"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar></td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td colspan="6" align="left">&nbsp;</td>
									</tr>
									<tr>
										<td colspan="6" align="left"><h:outputText value="#{jspMsg['label.siteAddress']}" styleClass="ms7u" /></td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteHouseNo']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="siteHouseNo" value="#{semmel001Bean.searchCriteria.siteHouseNo}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteBuilding']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="siteBuilding" value="#{semmel001Bean.searchCriteria.siteBuilding}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteStreet']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="siteStreet" value="#{semmel001Bean.searchCriteria.siteStreet}" size="30" style="width : 200px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteTumbon']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="siteTumbon" value="#{semmel001Bean.searchCriteria.siteTumbon}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteAmphur']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:selectOneMenu id="ddlLessorAmphur" value="#{semmel001Bean.searchCriteria.siteAmphur}" style="width : 160px">
			                					<f:selectItems value="#{semmel001Bean.amphurList}" />
			                				</h:selectOneMenu>
			                				<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlLessorAmphur" action="#{semmel001SOAction.getSiteAmphurList}"/>
										</td>
										<td align="right">
										    <h:outputText value="Zone:" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:selectOneMenu id="ddlLessorZone" value="#{semmel001Bean.searchCriteria.zone}" style="width : 200px">
			                					<f:selectItems value="#{semmel001Bean.zoneList}" />
			                				</h:selectOneMenu>
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<!-- end content criteria -->
						
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" 
							styleClass="rich-button" action="#{navAction.navi}" 
							reRender="pnlSearchElectricMeterManagement,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,btnExport">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="semmel001so-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001SO" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:region>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}" reRender="pnlSearchElectricMeterManagement,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,btnExport">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="semmel001so-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001SO" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
							</a4j:region>

						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout criteria -->
				
			</a4j:form>
			
				
			
			<a4j:region>
			<a4j:form id="frmResult" >
				
				<h:panelGrid columns="1" id="grdActionCommand">
					
				<a4j:commandButton id="btnExport" value="#{jspMsg['btn.export']}" styleClass="rich-button" 
				 action="#{navAction.navi}" reRender="frmError,frmShowReportExcel,pnlShowReportExcel" 
				 disabled="#{!semmel001Bean.exportButtonEnable}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="semmel001so-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001SO" />
						<a4j:actionparam name="methodWithNavi" value="initExportExcel" />
				</a4j:commandButton>
				
	           
					
		</h:panelGrid>
				<a4j:jsFunction name="showGroupReceivePopup" reRender="mdpGroupReceive" oncomplete="#{rich:component('mdpGroupReceive')}.show(); return false"/>
				<a4j:jsFunction name="hideGroupReceivePopup" oncomplete="#{rich:component('mdpGroupReceive')}.hide(); return false"/>
				
				<!-- end content button -->
				
				<!-- begin content layout data grid -->
				<a4j:outputPanel id="MeterInfoSearchResults">
				 
			 			
				<h:panelGrid style="width: 100%">
				  
					<rich:panel id="pnlSearchResultHeader" style="width: 100%">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						
						<rich:panel id="pnlSearchResult" styleClass="sem_el_autoScrollbar">
					
							<!-- begin dataTable -->
							
							<rich:dataTable id="dtbElectricMeterManagement" width="100%" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel001Bean.manageWrapperList}"
								reRender="dtbElectricMeterManagement" rows="#{semmel001Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
																
								<!-- begin column -->						
								<rich:column style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" 
								title="#{wrapper.electricManage.contractNo} : #{wrapper.electricManage.siteName}">
								
									<f:facet name="header">
										<h:selectBooleanCheckbox value="#{semmel001Bean.chkSelAll}" style="width: 20px">
											<a4j:support event="onclick" 
											action="#{semmel001Action.selectAllRow}" 
											reRender="dtbElectricMeterManagement,grdActionCommand,btnReceiveGroup" />
										</h:selectBooleanCheckbox>
									</f:facet>
									
									<div align="center" style="">
										<h:selectBooleanCheckbox id="electricManageSelected" value="#{wrapper.selected}">
											<a4j:support event="onclick" action="#{semmel001Action.selectRow}" reRender="grdActionCommand,btnReceiveGroup" />
										</h:selectBooleanCheckbox>
									</div>
									
								</rich:column>
								<rich:column sortBy="#{wrapper.electricManageSO.contractNo}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractNo']}" />
									</f:facet>
									
									<div align="left">
										<%--<h:outputText value="#{wrapper.electricManageSO.contractNo}" />
										h:outputLink value="#{wrapper.contractNoUrl}">
											<h:outputText value="#{wrapper.electricManageSO.contractNo}"/>
										</h:outputLink--%>
										<a4j:commandLink id="hypEdit" value="#{wrapper.electricManageSO.contractNo}" 
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup()" >
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{wrapper.electricManageSO.siteInfoId}" />
										</a4j:commandLink>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.oldContractNo}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.oldContractNo']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.oldContractNo}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.company}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.company']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.company}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.region}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.region']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.regionLabel}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.siteName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.siteName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.siteName}" style="width: 120" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.locationId}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.locationId']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.locationId}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.locationCode}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.locationCode']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.locationCode}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.siteAddressNo}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.siteAddressNo']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.siteAddressNo}" style="width: 220"/>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.siteTumbon}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.siteTumbon']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.siteTumbon}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.siteAmphur}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.siteAmphur']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.amphurDisplay}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.province}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.province']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.provinceLabel}" style="width: 100"/>
									</div>
										
								</rich:column>			
								<rich:column title="#{wrapper.electricManage.contractNo} : #{wrapper.electricManage.siteName}" 
								sortBy="#{wrapper.electricManageSO.zone}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="Zone" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.zoneLabel}" style="width: 150" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManage.contractNo} : #{wrapper.electricManage.siteName}" 
								sortBy="#{wrapper.electricManageSO.electricUseType}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.electricUseType']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricUseTypeLabel}" />
									</div>
										
								</rich:column>
								<rich:column title="#{wrapper.electricManage.contractNo} : #{wrapper.electricManage.siteName}" 
								sortBy="#{wrapper.electricManageSO.processStatusName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.processStatusName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.processStatusLabel}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManage.contractNo} : #{wrapper.electricManage.siteName}" 
								sortBy="#{wrapper.electricManageSO.actionDt}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.actionDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.electricManageSO.actionDtStr}"/>
									</div>
										
								</rich:column>
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.ownerName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.ownerName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.ownerName}" style="width: 150"/>
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.lessorName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.lessorName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.lessorName}" style="width: 200"/>
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.vendorName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendorName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.vendorName}" style="width: 200"/>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.electricManageSO.payeeName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeeName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSO.payeeName}" style="width: 200"/>
									</div>
										
								</rich:column>		
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.meterIdDisplay}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterId']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.meterIdDisplay}" />
									</div>
										
								</rich:column>				
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.meterRefIdDisplay}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.RefMeterId']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.meterRefIdDisplay}" />
									</div>
										
								</rich:column>		
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.eAreaCodeDisplay}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.eAreaCode']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.eAreaCodeDisplay}" />
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.eAreaNameDisplay}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.eAreaName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.eAreaNameDisplay}" />
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSO.contractNo} : #{wrapper.electricManageSO.siteName}" 
								sortBy="#{wrapper.recordStatusDisplay}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.MeterStatus']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.recordStatusDisplay}" />
									</div>
										
								</rich:column>	
								<!-- end column -->
								
								<f:facet name="footer">
									<rich:datascroller immediate="true" rendered="true"
										align="center" for="dtbElectricMeterManagement" maxPages="10"
										id="dstElectricMeterManagement" selectedStyleClass="selectScroll" page="#{semmel001Bean.scrollerPage}"/>
								</f:facet>
								
							</rich:dataTable>
							
							<!-- end dataTable -->
							
						</rich:panel>
						
					</rich:panel>
					
				</h:panelGrid>
				</a4j:outputPanel>
				
				<!-- end content layout data grid -->
				
			</a4j:form>
			</a4j:region>
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>

<rich:modalPanel id="mdpSaveDepositDialog" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.saveDepositPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmSaveDepositDialog">
	
		<table width="300px" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:graphicImage value="images/icon_required.gif" /> 
					<h:outputText value="#{jspMsg['label.depositType']}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<h:selectOneMenu id="ddlDepositType" value="#{semmel001Bean.depositType}" style="width : 100px">
         				<f:selectItems value="#{semmel001Bean.depositTypeList}" />
        			</h:selectOneMenu>
				</td>
			</tr>
			<tr>
				<td width="1px">
					<a4j:commandButton id="btnSaveDepositPopup" value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doSaveDepositPopup" />
					</a4j:commandButton>
				</td>
				<td>
					<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mdpSaveDepositDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="mdpPrivateCaseFlagDialog" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.privateCaseFlagPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmPrivateCaseFlagDialog">
	
		<table width="300px" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:outputText value="#{semmel001Bean.privateCaseFlagAlertMessage}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td width="1px">
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doPrivateCaseFlagYes" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
						<rich:componentControl for="mdpPrivateCaseFlagDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
				<td>
					<a4j:commandButton value="#{jspMsg['btn.no']}" styleClass="rich-button" action="#{navAction.navi}" reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doPrivateCaseFlagNo" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
					    <rich:componentControl for="mdpPrivateCaseFlagDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="mdpExpandFlagDialog" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.expandFlagPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmExpandFlagDialog">
	
		<table width="300px" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:outputText value="#{semmel001Bean.expandFlagAlertMessage}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td width="1px">
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doExpandFlagYes" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
						<rich:componentControl for="mdpExpandFlagDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
				<td>
					<a4j:commandButton value="#{jspMsg['btn.no']}" styleClass="rich-button" action="#{navAction.navi}" reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doExpandFlagNo" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
					    <rich:componentControl for="mdpExpandFlagDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="mdpUpdateStatus" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.updateStatusPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmUpdateStatusDialog">
	
		<table width="500px" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td align="right" width="50%">
					<h:graphicImage value="images/icon_required.gif" />
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
				</td>
				<td align="left" width="50%">
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.contractNo}" styleClass="ms7" style="width : 100px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
				
				</td>
				<td align="left">
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.siteName}" styleClass="ms7" style="width : 100px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
				
				</td>
				<td align="left">
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.locationId}" styleClass="ms7" style="width : 100px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
					
				</td>
				<td align="left">
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.locationCode}" styleClass="ms7" style="width : 100px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.receivedDt']}" styleClass="ms7" />
				
				</td>
				<td align="left">
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.receivedDt}" styleClass="ms7" style="width : 100px">
						<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
					</h:outputText>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.printDt']}" styleClass="ms7" />
				
				</td>
				<td align="left">
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.printDt}" styleClass="ms7" >
						<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
					</h:outputText>&nbsp;&nbsp;
					<h:outputText value="#{jspMsg['label.printTime']}" styleClass="ms7" />
					<h:outputText value="#{semmel001Bean.wrapper.warrantDatail.printTimes}" styleClass="ms7" />
				</td>
			</tr>
			
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.sentSignDt']}" styleClass="ms7" />
			
				</td>
				<td align="left">
					<rich:calendar locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						value="#{semmel001Bean.wrapper.warrantDatail.sentSighDt}" 
						showWeeksBar="false" inputSize="18"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.signDt']}" styleClass="ms7" />
				
				</td>
				<td align="left">
					<rich:calendar locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						value="#{semmel001Bean.wrapper.warrantDatail.signDt}" 
						showWeeksBar="false" inputSize="18"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.sentWarrantDt']}" styleClass="ms7" />
			
				</td>
				<td align="left">
					<rich:calendar locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						value="#{semmel001Bean.wrapper.warrantDatail.sentWarrantDt}" style="width : 100px"
						showWeeksBar="false" inputSize="18"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.sentContractDt']}" styleClass="ms7" />
					
				</td>
				<td align="left">
					<rich:calendar locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						value="#{semmel001Bean.wrapper.warrantDatail.sentContractDt}"
						showWeeksBar="false" inputSize="18"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.sentSAMUserDt']}" styleClass="ms7" />
			
				</td>
				<td align="left">
					<rich:calendar locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
						value="#{semmel001Bean.wrapper.warrantDatail.sentSamuserDt}" 
						showWeeksBar="false" inputSize="18"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.SAMUserName']}" styleClass="ms7" />
			
				</td>
				<td align="left">
					<h:inputText value="#{semmel001Bean.wrapper.warrantDatail.samuserName}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.SAMUserTel']}" styleClass="ms7" />
					
				</td>
				<td align="left">
					<h:inputText value="#{semmel001Bean.wrapper.warrantDatail.samuserTel}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7" />
				
				</td>
				<td align="left">
					<h:inputTextarea value="#{semmel001Bean.wrapper.warrantDatail.remark}" styleClass="ms7" cols="50" rows="4"/>
				</td>
			</tr>
			<tr>
				<td align="left" colspan="2">
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doSaveStatus" />
					</a4j:commandButton>
					<rich:spacer width="10"/>
					<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" action="#{navAction.navi}" >
					    <rich:componentControl for="mdpUpdateStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="mdpGroupReceive" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.groupReceivePopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmGroupReceiveDialog">
		
		<table width="300px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid id="message2">
						<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td>
					<rich:dataTable id="dtbGroupReceivePopup" width="95%" cellpadding="1" cellspacing="0" border="0" 
						var="wrapper" value="#{semmel001Bean.groupReceiveList}" reRender="dtbMeterInfoPopup" 
						rows="10"
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
						styleClass="contentform" >
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contractNo']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSO.contractNo}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.oldContractNo']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSO.oldContractNo}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.company']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSO.company}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.siteName']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSO.siteName}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.region']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSO.region}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.electricUseType']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricUseTypeLabel}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.processStatusName']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.processStatusLabel}"/>
							</div>
						</rich:column>
						
						<f:facet name="footer">
							<rich:datascroller immediate="true" rendered="true"
								align="center" for="dtbGroupReceivePopup" maxPages="10"
								id="dtbGroupReceivePopupPaging" selectedStyleClass="selectScroll" />
						</f:facet>
					</rich:dataTable>
				</td>
			</tr>
			<tr>
				<td><rich:spacer width="10"/></td>
			</tr>
			<tr>
				<td>
					<h:graphicImage value="images/icon_required.gif" />
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['label.groupReceiveDt']}" styleClass="ms7"/>
					<rich:spacer width="5"/>
					<rich:calendar
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.groupReceiveDt']}"
						value="#{semmel001Bean.groupReceiveDt}"
						showWeeksBar="false" inputStyle="width : 120px"/>
				</td>
			</tr>
			<tr>
				<td><rich:spacer width="10"/></td>
			</tr>
			<tr>
				<td>
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" 
					oncomplete="#{!semmel001Bean.displayGroupReceivePopup?'hideGroupReceivePopup();' : ''}" 
					action="#{semmel001SOAction.doSaveGroupReceive}" reRender="frmError, message2,pnlSearchResult"/>
					<rich:spacer width="10"/>
					<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
					action="#{navAction.navi}" reRender="oppContent">
					    <rich:componentControl for="mdpGroupReceive" operation="hide" event="onclick"/>
					</a4j:commandButton>
				</td>
			</tr>
		</table>
	
	</a4j:form>
	
</rich:modalPanel>

<a4j:form id="frmShowReportExcel">
<h:panelGrid id="pnlShowReportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReportExcel" rendered="#{semmel001Bean.displayReport}" style="height:0px;width:0px;" >
		<h:commandButton value="Report" id="bthShowReportExcel" style="height:0px;width:0px;display:none;" action="#{semmel001SOAction.exportMeterInfo}"  />								
		<script>document.getElementById('incContent:frmShowReportExcel:bthShowReportExcel').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>
