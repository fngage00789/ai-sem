<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.el.semmel001-1" var="jspMsg" />
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
		
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mel001_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmel001Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
                              <a4j:actionparam name="navModule" value="el" />
                              <a4j:actionparam name="navProgram" value="SEMMEL001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="el" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
                              <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
                              <a4j:actionparam name="backWard" value="Y" />                        
                          </a4j:commandButton>
                    </td>
                </tr> 
            </table>
              
          </h:form>
        </h:panelGrid>

		<h:panelGrid columnClasses="gridContent"  >

			<a4j:form id="frmSearch">

				<!-- begin content layout criteria -->
				
				<h:panelGrid style=" width : 100 %;" border="0">

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
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td colspan="5">
										<a4j:region>
											<h:selectOneMenu id="searchCompany" value="#{semmel001Bean.searchCriteria.company}" style="width : 160px">
			                					<f:selectItems value="#{semmel001Bean.companyList}" />
			                					<a4j:support event="onchange" action="#{semmel001Action.doChangeCompany}" reRender="bigCompany" />
			                				</h:selectOneMenu>
			                			</a4j:region>
			                				<rich:spacer width="5"/>
			                				<h:outputText id="bigCompany" value="#{semmel001Bean.companyBigLabel}" styleClass="ms28"/>
										</td>
									</tr>
									<tr>
										<td align="right" width="18%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
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
		                						<a4j:support event="onchange" action="#{semmel001Action.doChangeRegion}" 
		                						reRender="searchProvince,ddlLessorZone" />
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
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
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
		                						<a4j:support event="onchange" action="#{semmel001Action.doChangeElectricUseType}" reRender="searchELAction, searchProcessStatus" />
		                					</h:selectOneMenu>
		                					</a4j:region>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchLocationId" value="#{semmel001Bean.searchCriteria.locationId}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchLocationCode" value="#{semmel001Bean.searchCriteria.locationCode}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.siteCode']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<h:inputText id="searchSiteCode" value="#{semmel001Bean.searchCriteria.siteCode}" size="30" style="width : 160px"/>
										</td>
										
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.processStatusName']}" styleClass="ms7" />
										</td>
										<td width="18%">
											<a4j:region>
											<h:selectOneMenu id="searchELAction" value="#{semmel001Bean.searchCriteria.elAction}" 
											style="width : 100px">
		                						<f:selectItems value="#{semmel001Bean.elActionList}" />
		                						<a4j:support event="onchange" action="#{semmel001Action.doChangeElAction}" reRender="searchProcessStatus" />
		                					</h:selectOneMenu>
		                					</a4j:region>
		                					<rich:spacer width="5"/>
											<h:selectOneMenu id="searchProcessStatus" value="#{semmel001Bean.searchCriteria.processStatusCode}" 
											style="width : 140px">
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
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" />
										</td>
										<td width="18%">
											
											<h:inputText id="meterId" value="#{semmel001Bean.searchCriteria.meterId}" size="30" style="width : 160px"/>
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
											<h:outputText value="#{jspMsg['label.printDt']}" styleClass="ms7" rendered="true"/>
										</td>
										<td><rich:calendar id="printDT" rendered="true"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.cutOffDt']}"
												value="#{semmel001Bean.searchCriteria.printDT}"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar></td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td align="right">&nbsp;</td>
										<td colspan="2">
											<h:selectBooleanCheckbox id="chkHistoryFlag" value="#{semmel001Bean.searchCriteria.chkHistoryFlag}"/> 
											<rich:spacer width="2px"/>
											<h:outputText value="#{jspMsg['label.historyFlag']}" styleClass="ms7"/>
										</td>
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
			                				<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlLessorAmphur" action="#{semmel001Action.getSiteAmphurList}"/>			                				
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
						
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" action="#{navAction.navi}" 
							reRender="pnlSearchElectricMeterManagement,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,btnExport,pnlSearchResultHeader">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:region>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}" 
							reRender="pnlSearchElectricMeterManagement,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch,btnExport,pnlSearchResultHeader">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
							</a4j:region>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				
				<!-- end content layout criteria -->
				
			</a4j:form>
			<a4j:region>
			<h:panelGrid>
				<a4j:form id="frmErrorMid">
					<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
				</a4j:form>
			</h:panelGrid>
			
			<a4j:form id="frmResult" >
			
				<!-- begin content button -->
				
				<h:panelGrid columns="4" id="grdActionCommand">
					
					
	            	<a4j:commandButton id="btnExport" style="width:90px" styleClass="rich-button"
											   reRender="frmError, frmResult"
											   value="#{jspMsg['btn.export']}" 
											   action="#{navAction.navi}" 
											   disabled="#{!semmel001Bean.exportButtonEnable}"
											   rendered="false"
											   >
							
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="checkProcessStatusCode" />
												    
						<a4j:support event="oncomplete" 
						reRender="frmError,frmResult"
						action="#{navAction.navi}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" />
							<a4j:actionparam name="isActionFromExport" value="Y" />
						</a4j:support>
					</a4j:commandButton>
					
					<a4j:commandButton value="#{jspMsg['btn.export']}" 
					styleClass="rich-button" 
					rendered="#{semmel001Bean.renderer['btnExport']}"
					disabled="#{!semmel001Bean.exportButtonEnable}"
					action="#{semmel001Action.checkProcessStatusCode}" 
					oncomplete="#{rich:component('alertMessageExport')}.show(); return false" 
					style="width:100px"
					reRender="alertMessageExport">
					</a4j:commandButton>
					
					<a4j:commandButton value="Re-Export" 
					styleClass="rich-button" 
					rendered="#{semmel001Bean.renderer['btnExport']}"
					disabled="#{!semmel001Bean.exportButtonEnable}"
					action="#{semmel001Action.checkProcessStatusCodeReExport}" 
					oncomplete="#{rich:component('alertMessageExportReExport')}.show(); return false" 
					style="width:100px"
					reRender="alertMessageExportReExport">
					</a4j:commandButton>
					
					
					
					<a4j:commandButton id="btnReceiveGroup" 
					value="#{jspMsg['btn.groupReceive']}" styleClass="rich-button" 
					action="#{navAction.navi}" oncomplete="#{semmel001Bean.displayGroupReceivePopup?'showGroupReceivePopup();' : ''}" 
					disabled="#{!semmel001Bean.exportButtonEnable}" reRender="oppContent"
					rendered="#{semmel001Bean.renderer['btnReceiveGroup']}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitGroupReceive" />
						
					</a4j:commandButton>
				    
					
				</h:panelGrid>
				
				<h:panelGrid id="pnlShowExcel" style="height:0px;width:0px;" width="0px" columns="0" >
					<h:panelGroup id="pnlInShowExcel" rendered="#{semmel001Bean.displayShowReport}" 
					style="height:0px;width:0px;" >
						<h:commandButton value="Report" id="btnExcel" style="height:0px;width:0px;display:none;" 
						action="#{semmel001Action.export}"  rendered="false" />								
						<script>document.getElementById('incContent:frmResult:btnExcel').click();</script>
					</h:panelGroup>							
				</h:panelGrid>
				
				<a4j:jsFunction name="showGroupReceivePopup" reRender="mdpGroupReceive" 
				oncomplete="#{rich:component('mdpGroupReceive')}.show(); return false"/>
				<a4j:jsFunction name="hideGroupReceivePopup" 
				oncomplete="#{rich:component('mdpGroupReceive')}.hide(); return false"/>
				
				<!-- end content button -->
				
				<!-- begin content layout data grid -->
				
				<h:panelGrid style="width: 100%">
				
					<rich:panel id="pnlSearchResultHeader" style="width: 100%">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						
						<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
					
							<!-- begin dataTable -->
							
							<rich:dataTable id="dtbElectricMeterManagement" width="100%" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel001Bean.manageWrapperList}"
								reRender="dtbElectricMeterManagement" rows="#{semmel001Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
																
								<!-- begin column -->
								
								<rich:column style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}">
								
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
								
								<rich:column sortBy="#{wrapper.electricManageSP.contractNo}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractNo']}" />
									</f:facet>
									
									<div align="left">
										<%--<h:outputText value="#{wrapper.electricManageSP.contractNo}" />
										h:outputLink value="#{wrapper.contractNoUrl}">
											<h:outputText value="#{wrapper.electricManageSP.contractNo}"/>
										</h:outputLink--%>
										<a4j:commandLink id="hypEdit" value="#{wrapper.electricManageSP.contractNo}" 
										action="#{navAction.navi}" oncomplete="showViewSiteInfoPopup()" >
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
											<a4j:actionparam name="methodWithNavi" value="initPopup" />
											<a4j:actionparam name="rowId" value="#{wrapper.electricManageSP.siteInfoId}" />
										</a4j:commandLink>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.oldContractNo}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.oldContractNo']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.oldContractNo}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.company}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.company']}" />
									</f:facet>
									
									<div align="left" >
										<h:outputText value="#{wrapper.electricManageSP.company}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.siteName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.siteName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.siteName}" style="width: 250" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}" />
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.firstEffectiveDt}" 
								sortBy="#{wrapper.electricManageSP.firstEffectiveDt}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.firstEffectiveDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.electricManageSP.firstEffectiveDtStr}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}" />
									</div>
										
								</rich:column>		
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.effectiveDt}" 
								sortBy="#{wrapper.electricManageSP.effectiveDt}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.effectDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.electricManageSP.effectDtStr}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}"/>
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.expireDt}" 
								sortBy="#{wrapper.electricManageSP.expireDt}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expireDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.electricManageSP.expireDtStr}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}"/>
									</div>
										
								</rich:column>	
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.reqTypeDesc}" 
								sortBy="#{wrapper.electricManageSP.reqTypeDesc}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.reqTypeDesc']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.reqTypeDesc}" style="width: 250" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}"/>
									</div>
										
								</rich:column>					
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.region}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.region']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.regionLabel}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}"/>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.province}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.province']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.provinceLabel}" style="width: 100" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}"/>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.zone}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="Zone" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.zoneDesc}" style="width: 150" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.electricUseType}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.electricUseType']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricUseTypeLabel}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.processStatusName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.processStatusName']}"  style="width: 150"  />
									</f:facet>
									
									<div align="left">
										<a4j:commandLink id="hypPopApproveType" value= "#{wrapper.processStatusLabel}" 
										oncomplete="#{rich:component('popupEditDetailHistory')}.show(); return false"
										 action="#{navAction.navi}" style="width:100" reRender="popupFrmEditPeriod" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}">
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupEditHistory"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="sIdHistory" value="#{wrapper.electricManageSP.siteInfoId}" />
									</a4j:commandLink>
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.actionDt}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.actionDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.electricManageSP.actionDtStr}" rendered="#{wrapper.electricManageSP.showRecord == 'Y'}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.changeType']}" />
									</f:facet>
									
									<div align="center">
										<h:selectBooleanCheckbox id="changeTypeFlagSelected" value="#{wrapper.electricManageSP.changeTypeFlagBoolean}" rendered="#{wrapper.electricManageSP.changeTypeFlag!='H'}" disabled="#{wrapper.electricManageSP.changeTypeFlag=='N'}"/>
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.siteName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.remark}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="" style="width: 72"/>
									</f:facet>
									<div align="center">
										<h:panelGroup>
											<a4j:commandLink id="hypAddVendor" value="#{jspMsg['column.link.addVendor']}" 
											rendered="#{wrapper.electricManageSP.verifyFlag!='H' && wrapper.electricManageSP.reVerify !='Y'&& semmel001Bean.renderer['btnVerify']}" 
												reRender="txtNavProgram, oppContent" action="#{navAction.navi}" oncomplete="onTopPage();">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL001-VMP" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
													<a4j:actionparam name="methodWithNavi" value="doGetVendorMaster" />
													<a4j:actionparam name="contractNo" value="#{wrapper.electricManageSP.contractNo}" />
													
													<a4j:actionparam name="navModuleFrom" value="el" />
													<a4j:actionparam name="navProgramFrom" value="SEMMEL001-1" />
													<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL001" />
											</a4j:commandLink>
										</h:panelGroup>
									</div>
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.vendorName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendorname']}" style="width:150px;"/>
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.vendorName}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.payeeName}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeename']}" style="width:150px;"/>
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.payeeName}" />
									</div>
										
								</rich:column>				
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.receiveJob']}" />
									</f:facet>
									
									<div align="center">
										<a4j:commandButton id="btnReceive" value="#{jspMsg['btn.receiveJob']}" styleClass="rich-button" 
										action="#{navAction.navi}" rendered="#{wrapper.electricManageSP.receiveJobFlag!='H' && semmel001Bean.renderer['btnReceive']}" 
										disabled="#{wrapper.electricManageSP.receiveJobFlag=='N'}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInit" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="page" value="2" />
										</a4j:commandButton>
										<a4j:commandButton id="btnVerify" value="#{jspMsg['btn.verify']}" styleClass="rich-button" 
										action="#{navAction.navi}" 
										rendered="#{wrapper.electricManageSP.verifyFlag!='H' && wrapper.electricManageSP.reVerify !='Y'&& semmel001Bean.renderer['btnVerify']}" 
										disabled="false" reRender="oppContent,pnlElectricUseInfo" style="FONT-STYLE: italic;">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
											<a4j:actionparam name="methodWithNavi" value="initVerify" />
											<a4j:actionparam name="electricId" value="#{wrapper.electricManageSP.electricId}" />
										</a4j:commandButton>
										
										<a4j:commandButton id="btnReVerify" value="#{jspMsg['btn.reVerify']}" 
										styleClass="rich-button" 
										action="#{navAction.navi}" rendered="#{wrapper.electricManageSP.reVerifyFlag =='Y'} && #{wrapper.electricManageSP.verifyFlag=='H'}"
										 reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="#{wrapper.verifyNavProgram}" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInit" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="page" value="#{wrapper.verifyPage}" />
										</a4j:commandButton>
									</div>
									
								</rich:column>
								

								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.print']}" />
									</f:facet>
									
									<div align="center">
										<h:commandButton id="btnPrint" value="#{jspMsg['btn.print']}" styleClass="rich-button" 
										actionListener="#{semmel001Action.doPrint}" 
										rendered="#{wrapper.electricManageSP.warrantPrintFlag!='H' && semmel001Bean.renderer['btnPrint']}" 
										disabled="#{wrapper.electricManageSP.warrantPrintFlag=='N'}"
										>
											<f:attribute name="selectedRow" value="#{row}" />
											<f:attribute name="rowId" value="#{wrapper.electricManageSP.rowId}" />
											<a4j:support event="onclick" reRender="oppContent" action="#{navAction.navi}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doSearch" />
											</a4j:support>
										</h:commandButton>
										<h:commandButton id="btnRePrint" value="#{jspMsg['btn.reprint']}" styleClass="rich-button" 
										actionListener="#{semmel001Action.doPrint}" 
										rendered="#{wrapper.electricManageSP.warrantReprintFlag!='H'}" 
										disabled="#{wrapper.electricManageSP.warrantReprintFlag=='N'}">
											<f:attribute name="selectedRow" value="#{row}" />
											<f:attribute name="rowId" value="#{wrapper.electricManageSP.rowId}" />
											<a4j:support event="onclick" reRender="oppContent" action="#{navAction.navi}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doSearch" />
											</a4j:support>
										</h:commandButton>
										
										<h:commandButton id="btnPrint_01" value="#{jspMsg['btn.print']}" styleClass="rich-button" 
										actionListener="#{semmel001Action.doPrintPrivateSpecial}" 
										rendered="#{wrapper.electricManageSP.privateSpecailTypeBoolean =='Y'}" 
										
										>
											<f:attribute name="selectedRow" value="#{row}" />
											<f:attribute name="rowId" value="#{wrapper.electricManageSP.rowId}" />
											<a4j:support event="onclick" reRender="oppContent" action="#{navAction.navi}">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
												<a4j:actionparam name="methodWithNavi" value="doSearch" />
											</a4j:support>
										</h:commandButton>
										
										
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" rendered="false">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.privateCase']}" />
									</f:facet>
									
									<div align="center">
										<h:selectBooleanCheckbox id="chkPrivateSpecial"  value="#{wrapper.electricManageSP.privateCaseFlagBoolean}" 
											rendered="#{wrapper.electricManageSP.privateSpecialFlag!='H' && semmel001Bean.renderer['chkPrivateSpecial']}" 
											disabled="#{wrapper.electricManageSP.privateSpecialFlag=='N'}" >
											<a4j:support event="onclick" action="#{semmel001Action.check}" oncomplete="#{rich:component('mdpPrivateCaseFlagDialog')}.show(); return false" reRender="mdpPrivateCaseFlagDialog">
												<a4j:actionparam name="selectedRow" value="#{row}" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" rendered="false">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.doc']}" />
									</f:facet>
									
									<div align="center">
										<a4j:commandButton id="btnDoc" value="#{jspMsg['btn.doc']}" styleClass="rich-button" 
											rendered="#{wrapper.electricManageSP.warrantDetailFlag!='H'}"
											disabled="#{wrapper.electricManageSP.warrantDetailFlag=='N'}"
									     	action="#{navAction.navi}" reRender="dtbElectricMeterManagement,frmUpdateStatusDialog1"
									     	oncomplete="#{rich:component('mdpUpdateStatus')}.show(); return false">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doUpdateStatus" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
									    </a4j:commandButton>
									    
									   
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expand']}" />
									</f:facet>
									
									<div align="center">
										<h:selectBooleanCheckbox id="chkExpand" value="#{wrapper.electricManageSP.expandFlagBooleanMigrate}"
											rendered="#{wrapper.electricManageSP.expandFlag!='H' && semmel001Bean.renderer['chkExpand']}" 
											disabled="#{wrapper.electricManageSP.expandFlag=='N'}">
											<a4j:support event="onclick" 
											action="#{semmel001Action.check}" 
											oncomplete="#{rich:component('mdpExpandFlagDialog')}.show(); return false" 
											reRender="mdpExpandFlagDialog">
												<a4j:actionparam name="selectedRow" value="#{row}" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.terminate']}" />
									</f:facet>
									
									<div align="center">
										<h:selectBooleanCheckbox id="chkTerminate" 
										   value="#{wrapper.electricManageSP.terminateFlagBoolean}"
											rendered="#{wrapper.electricManageSP.expandFlag!='H' && semmel001Bean.renderer['chkExpand']}" 
											disabled="false">
											<a4j:support event="onclick" 
											action="#{semmel001Action.check}" 
											oncomplete="#{rich:component('mdpTerminateFlagDialog')}.show(); return false" 
											reRender="mdpTerminateFlagDialog">
												<a4j:actionparam name="selectedRow" value="#{row}" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</div>
									
								</rich:column>
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.privateSpecial']}" />
									</f:facet>
									
									<div align="center">
										<h:selectBooleanCheckbox id="chkPrivateSpecail" 
										   	value="#{wrapper.electricManageSP.privateSpecailTypeBooleanMigrate}"
											rendered="#{wrapper.electricManageSP.electricUseType =='PRIVATE' && wrapper.electricManageSP.newReceivedDt != NULL }" 
											disabled="#{wrapper.electricManageSP.privateSpecailType =='Y'}">
											<a4j:support event="onclick" 
											action="#{semmel001Action.check}" 
											oncomplete="#{rich:component('mdpPrivateSpecialDialog')}.show(); return false" 
											reRender="mdpPrivateSpecialDialog">
												<a4j:actionparam name="selectedRow" value="#{row}" />
											</a4j:support>
										</h:selectBooleanCheckbox>
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.withdrawal']}" />
									</f:facet>
									
									<div align="center">
										<a4j:commandButton id="btnFee" value="#{jspMsg['btn.withdrawal']}" styleClass="rich-button" 
										action="#{navAction.navi}" rendered="#{(wrapper.electricManageSP.privateSpecailTypeBoolean || wrapper.electricManageSP.feeFlag!='H') && semmel001Bean.renderer['btnFee']}" 
										disabled="#{wrapper.electricManageSP.feeFlag=='N'}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInit" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="page" value="12" />
										</a4j:commandButton>
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterInfo']}" />
									</f:facet>
									
									<div align="center">
										<a4j:commandButton id="btnUpdateMeterInfo" value="#{jspMsg['btn.meterInfo']}" style="width:120px;" 
										styleClass="rich-button" action="#{navAction.navi}" 
										rendered="#{wrapper.electricManageSP.updateMeterFlag!='H' && semmel001Bean.renderer['btnUpdateMeterInfo']}" disabled="#{wrapper.electricManageSP.updateMeterFlag=='N'}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-13" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInit" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="page" value="13" />
										</a4j:commandButton>
									</div>
									
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.siteStatus}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.contractStatus']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.siteStatusLabel}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.siteName}" 
								sortBy="#{wrapper.electricManageSP.networkStatus}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.networkStatus']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.networkStatusLabel}" />
									</div>
										
								</rich:column>
								
								<rich:column title="#{wrapper.electricManageSP.contractNo} : #{wrapper.electricManageSP.remark}" 
								sortBy="#{wrapper.electricManageSP.remark}" style="#{(semmel001Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remarkChange']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.electricManageSP.remarkChange}" />
									</div>
										
								</rich:column>
								
								<!-- end column -->
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel001Bean.manageWrapperList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="26">
											<rich:datascroller immediate="true" rendered="true"
												align="center" for="dtbElectricMeterManagement" maxPages="10"
												id="dstElectricMeterManagement" selectedStyleClass="selectScroll" page="#{semmel001Bean.scrollerPage}"/>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								
							</rich:dataTable>
							
							<!-- end dataTable -->
							
						</rich:panel>
						
					</rich:panel>
					
				</h:panelGrid>
				
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
    
	<a4j:form id="frmUpdateStatusDialog1">
	
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
    
    <f:facet name="controls">
		<h:panelGroup>
			<div align="left">
				<h:graphicImage value="images/ico_close.png" id="hideMdpGroupReceive" style="cursor:pointer"/>
				<rich:componentControl for="mdpGroupReceive" attachTo="hideMdpGroupReceive" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
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
						rows="5"
						onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
						onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
						styleClass="contentform" >
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.contractNo']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSP.contractNo}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.oldContractNo']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSP.oldContractNo}" />
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.company']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSP.company}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.siteName']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSP.siteName}"/>
							</div>
						</rich:column>
						<rich:column>
							<f:facet name="header">
								<h:outputText value="#{jspMsg['column.header.region']}" />
							</f:facet>
							<div align="center">
								<h:outputText value="#{wrapper.electricManageSP.region}"/>
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
					action="#{semmel001Action.doSaveGroupReceive}" reRender="frmError, message2,pnlSearchResult"/>
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
<rich:modalPanel id="alertMessageExport" width="350" autosized="true">
    
    <f:facet name="header">
    	<h:outputText value="#{jspMsg['lable.exportExcel']}" ></h:outputText>
    </f:facet>
   <a4j:form id="frmAlert1">
	
		<table border="0" cellspacing="" cellpadding="2" align="center">
			<tr>
				<td align="center" >
					<h:outputText value="#{semmel001Bean.exportMsg}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td align="center">
					
					<!-- for export -->
					<h:commandButton id="btnExport" value="#{jspMsg['btn.export']}" 
					styleClass="rich-button" 
					rendered="#{semmel001Bean.displayShowReport}"
					action="#{semmel001Action.export}"
					onblur="document.getElementById('incContent:frmAlert1:btnBack').click();"
					>
					</h:commandButton> 
					<rich:spacer width="5" />
					<!-- close dialog -->
					<a4j:commandButton id="btnBack" value="Back" 
					styleClass="rich-button" 
					oncomplete="#{rich:component('alertMessageExport')}.hide(); return false"
					reRender="frmResult" 
					action="#{navAction.navi}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" /> 
					</a4j:commandButton>
    			</td>
			</tr>
		</table>	
		
	</a4j:form>
</rich:modalPanel>
<rich:modalPanel id="alertMessageExportReExport" width="350" autosized="true">
    
    <f:facet name="header">
    	<h:outputText value="#{jspMsg['lable.exportExcel']}" ></h:outputText>
    </f:facet>
   <a4j:form id="frmAlert2">
	
		<table border="0" cellspacing="" cellpadding="2" align="center">
			<tr>
				<td align="center" >
					<h:outputText value="#{semmel001Bean.exportMsg}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td align="center">
					
					<!-- for export -->
					<h:commandButton value="#{jspMsg['btn.export']}" 
					styleClass="rich-button" 
					rendered="true"
					action="#{semmel001Action.reExport}"
					onblur="location.reload();" 
					>
					</h:commandButton> 
					<rich:spacer width="5" />
					<!-- close dialog -->
					<a4j:commandButton value="Back" 
					styleClass="rich-button" 
					oncomplete="#{rich:component('alertMessageExportReExport')}.hide(); return false"
					reRender="frmResult" 
					action="#{navAction.navi}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" /> 
					</a4j:commandButton>
    			</td>
			</tr>
		</table>	
		
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="alertMessageDeleteContract" width="350" autosized="true">
    
    <f:facet name="header">
    	<h:outputText value="#{jspMsg['lable.deleteContract']}" ></h:outputText>
    </f:facet>
   <a4j:form id="frmAlert3">
	
		<table border="0" cellspacing="" cellpadding="2" align="center">
			<tr>
				<td align="center" >
					<h:outputText value="#{semmel001Bean.deleteMsg}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td align="center">
					
					<!-- for Delete -->
					<a4j:commandButton value="OK" 
					styleClass="rich-button" 
					oncomplete="#{rich:component('alertMessageDeleteContract')}.hide(); return false"
					reRender="frmResult,frmError" 
					action="#{navAction.navi}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteContract" /> 
					</a4j:commandButton>
					
					<rich:spacer width="5" />
					<!-- close dialog -->
					<a4j:commandButton value="Back" 
					styleClass="rich-button" 
					oncomplete="#{rich:component('alertMessageDeleteContract')}.hide(); return false"
					reRender="frmResult" 
					action="#{navAction.navi}">
							<a4j:actionparam name="navModule" value="el" />
							<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
							<a4j:actionparam name="methodWithNavi" value="doSearch" /> 
					</a4j:commandButton>
    			</td>
			</tr>
		</table>	
		
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpTerminateFlagDialog" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.terminateFlagPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmTerminateFlagDialog">
	
		<table width="300px" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:outputText value="#{semmel001Bean.terminateFlagAlertMessage}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td width="1px">
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{navAction.navi}" 
					reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doTerminateSite" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
						<rich:componentControl for="mdpTerminateFlagDialog" operation="hide" event="onclick" />
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
					    <rich:componentControl for="mdpTerminateFlagDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="mdpPrivateSpecialDialog" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.PrivateSpecailPopup']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmPrivateSpecailDialog">
	
		<table width="400px" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:outputText value="#{semmel001Bean.privateSpecailAlertMessage}" styleClass="ms7" />
				</td>
			</tr>
			<tr>
				<td width="1px">
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{navAction.navi}" 
					reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doPrivateSpecail" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
						<rich:componentControl for="mdpPrivateSpecialDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
				<td>
					<a4j:commandButton value="#{jspMsg['btn.no']}" styleClass="rich-button" action="#{navAction.navi}" reRender="dtbElectricMeterManagement,frmError">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doSpecialFlagNo" />
						<a4j:support event="onclick" reRender="dtbElectricMeterManagement,frmError"/>
					    <rich:componentControl for="mdpPrivateSpecialDialog" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>