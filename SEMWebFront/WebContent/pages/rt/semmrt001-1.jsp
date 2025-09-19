<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.rental.semmrt001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchVerifyRental">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmrt001Bean.renderedMsgFormSearch}">
					<f:facet name="header">
						<h:outputText value="Entered Data Status:"></h:outputText>
					</f:facet>
					<f:facet name="errorMarker">
						<h:graphicImage value="images/error.gif" />  
					</f:facet>
				</rich:messages>
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid>
          <h:form id="frmAllInitTab">
            <table>
                <tr>
                    <td align="right">
                        <a4j:commandButton id="mrt001_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmrt001Bean.renderedOnToDoList}"
                                    action="#{navAction.navi}" reRender="oppContent">
                              <a4j:actionparam name="navModule" value="rt" />
                              <a4j:actionparam name="navProgram" value="SEMMRT001-0" />
                              
                              <a4j:actionparam name="moduleWithNavi" value="rt" />
                              <a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
                              <a4j:actionparam name="methodWithNavi" value="doInitTodoList" />
                              <a4j:actionparam name="backWard" value="Y" />                        
                          </a4j:commandButton>
                    </td>
                </tr>
            </table>
              
          </h:form>
        </h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="96%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="20%" valign="baseline">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</h:panelGroup>
			                			</td>
			                			<td width="80%" colspan="3" valign="bottom">
				                			<a4j:region>
												<h:selectOneMenu id="ddlCompany" value="#{semmrt001Bean.criteria.company}" onchange="GetCompanyJS();">
													<f:selectItems value="#{semmrt001Bean.companyList}"/>
												</h:selectOneMenu>
												<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
												<rich:spacer width="10"></rich:spacer>
												<h:outputText id="companyDisplay" value="#{semmrt001Bean.criteria.company}" styleClass="ms28"/>
						                	</a4j:region>
					                	</td>
				                	</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
										</td><td width="30%">
											<h:inputText id="txtContractNo" value="#{semmrt001Bean.criteria.contractNo}"></h:inputText>
										</td><td align="right" width="15%">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
										</td><td width="35%">
											<h:inputText id="txtSiteName" value="#{semmrt001Bean.criteria.siteName}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtRegion" value="#{semmrt001Bean.criteria.region}"></h:inputText>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
										</td><td>
											<h:inputText id="txtTitle" value="#{semmrt001Bean.criteria.title}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7"/>
										</td><td>
											<h:selectOneMenu id="ddlSiteType" value="#{semmrt001Bean.criteria.siteType}">
												<f:selectItems value="#{semmrt001Bean.siteTypeList}"/>
											</h:selectOneMenu>
											<rich:spacer width="10"/>
											<h:selectBooleanCheckbox id="picoSelect" value="#{semmrt001Bean.criteria.chkPico}"/>
											<rich:spacer width="5"/>
											<h:outputText value="PICO" styleClass="ms7"/>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7" />
										</td><td>
											<h:selectOneMenu id="ddlReqType" value="#{semmrt001Bean.criteria.reqType}">
												<f:selectItems value="#{semmrt001Bean.reqTypeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"></h:outputText>
										</td><td>
											<h:inputText id="txtVendorCode" value="#{semmrt001Bean.criteria.vendorCode}"
											style="margin-right:5px;" />
											
											<!-- >> fixed by.. YUT 2015/10/18 -->
				                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
								            action="#{semmrt001Action.initAddVendor}" reRender="oppContent"
								            oncomplete="#{rich:component('mrt001PopUp_addVendor')}.show(); return false">
											</a4j:commandButton>
				                			<!-- << -->	
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7"></h:outputText>
										</td><td>
											<h:inputText id="txtVendorName" value="#{semmrt001Bean.criteria.vendorName}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td></td>
										<td align="left">
											<h:selectBooleanCheckbox id="noVendorIdSelect" value="#{semmrt001Bean.criteria.chkNoVendorId}"/><rich:spacer width="5"/><h:outputText 
												value="#{jspMsg['label.noVendorId']}" styleClass="ms7"/>
										</td><td align="right">
											<h:outputText value="#{jspMsg['label.verifyStatus']}" styleClass="ms7"/>
										</td><td>
											<h:selectOneMenu id="ddlVerifyStatus" value="#{semmrt001Bean.criteria.verifyStatus}">
												<f:selectItems value="#{semmrt001Bean.verifyStatusList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right"><h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7"></h:outputText> </td>
										<td > <h:inputText id="txtLocationId" value="#{semmrt001Bean.criteria.locationId}"></h:inputText></td>
										<td ></td>
										<td align="left">
											<h:selectBooleanCheckbox id="chkCurrentFlag" value="#{semmrt001Bean.chkCurrentFlg}" 
                								styleClass="ms7"/>
                							<h:outputText value="#{jspMsg['label.currentFlag2']}" styleClass="ms7" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.search']}" styleClass="rich-button" 
								action="#{navAction.navi}" reRender="pnlSearchVerifyRental,frmError,pnlSearchCriteria,pnlSearchResult,frmSearch">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            	 	action="#{navAction.navi}" reRender="frmError,pnlSearchCriteria,pnlSearchResult,dtbVerifyRental">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
			<a4j:form id="frmBtnExport">
			<!-- begin content button -->
				<h:panelGrid columns="2" id="grdActionCommand">
					<h:commandButton id ="btnExport" value="Export" action="#{semmrt001Action.doExportExcel}" styleClass="rich-button" 
					 disabled="#{!semmrt001Bean.renderedBtnExport}"
					 rendered="#{semmrt001Bean.renderer['btnExport'] or semmrt001Bean.renderedOnToDoList}">
							<a4j:support event="onclick" reRender="frmResult"/>
					</h:commandButton>
				</h:panelGrid>
				<!-- end content button -->
			</a4j:form>
			<a4j:form id="frmResult">
				
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 2300"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmrt001Bean.msgDataNotFound}" rendered="#{semmrt001Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbVerifyRental" cellpadding="1" cellspacing="0" border="0" 
							var="verifyRental"  value="#{semmrt001Bean.resultList}" reRender="dtbVerifyRental" 
							rows="#{semmrt001Bean.rowPerPage}" rowClasses="cur" styleClass="contentform">
							<!-- begin column -->
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								rendered="#{semmrt001Bean.renderer['hlkSaveDetail'] or semmrt001Bean.renderedOnToDoList}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="" style="width: 100px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink value="#{jspMsg['column.link.add']}" 
										action="#{navAction.navi}" reRender="oppContent"
										rendered="#{verifyRental.dataObj.renderSave or semmrt001Bean.renderedOnToDoList}" 
										id="hypSaveDetail"> 
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="mode" value="RENTAL_SETUP" />
										<a4j:actionparam name="param1" value="NORMAL" />
										<a4j:actionparam name="company" value="#{verifyRental.dataObj.company}" />
										<a4j:actionparam name="rentalMasterId" value="#{verifyRental.dataObj.rentalMasterId}" />
										<a4j:actionparam name="contractNo" value="#{verifyRental.dataObj.contractNo}" />
										<a4j:actionparam name="siteName" value="#{verifyRental.dataObj.siteName}" />
										<a4j:actionparam name="reqType" value="#{verifyRental.dataObj.reqType}" />
										<a4j:actionparam name="reqTypeName" value="#{verifyRental.dataObj.reqTypeName}" />
										<a4j:actionparam name="title" value="#{verifyRental.dataObj.title}" />
										<a4j:actionparam name="rentalJobStatus" value="#{verifyRental.dataObj.rentalJobStatus}" />
										<a4j:actionparam name="verifyStatus" value="#{verifyRental.dataObj.verifyStatus}" />
										<a4j:actionparam name="siteInfoId" value="#{verifyRental.dataObj.siteInfoId}" />
										<a4j:actionparam name="rentCondType" value="#{verifyRental.dataObj.rentCondType}" />
										<a4j:actionparam name="depositCondType" value="#{verifyRental.dataObj.depositCondType}" />
										<a4j:actionparam name="createBy" value="#{verifyRental.dataObj.createBy}" />
										<a4j:actionparam name="createDt" value="#{verifyRental.dataObj.createDtStr}" />
										<a4j:actionparam name="updateBy" value="#{verifyRental.dataObj.updateBy}" />
										<a4j:actionparam name="updateDt" value="#{verifyRental.dataObj.updateDtStr}" />
										<a4j:actionparam name="pendingDt" value="#{verifyRental.dataObj.pendingDateStr}" />
										<a4j:actionparam name="condType" value="#{verifyRental.dataObj.condType}" />
										<a4j:actionparam name="viewFlag" value="#{verifyRental.dataObj.viewFlag}" />
										<a4j:actionparam name="effDate" value="#{verifyRental.dataObj.strEffDate}" />
										<a4j:actionparam name="expireDate" value="#{verifyRental.dataObj.strExpireDate}" />
										<a4j:actionparam name="remark" value="#{verifyRental.dataObj.remark}" />
										<a4j:actionparam name="specialFlag" value="#{verifyRental.dataObj.specialFlagStr}" />
										<a4j:actionparam name="terminateDt" value="#{verifyRental.dataObj.terminateDtStr}" />
										<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{verifyRental.dataObj.contractNo}" 
								styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{verifyRental.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100" 
										rendered="#{verifyRental.dataObj.renderColumn}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}"  
								sortBy="#{verifyRental.dataObj.oldContractNo}" >
								
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.oldContract']}" style="width: 60"/>
								</f:facet>
								<div align="center">
								<a4j:commandLink id="hypView2" value="#{verifyRental.dataObj.oldContractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100" 
										rendered="#{verifyRental.dataObj.renderColumn}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.siteName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" style="width: 180"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{verifyRental.dataObj.siteName}" 
										rendered="#{verifyRental.dataObj.renderColumn}"/>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.effDate}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.beginDt']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.effDateStr}" 
										rendered="#{verifyRental.dataObj.renderColumn}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.expireDate}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.endDt']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.expireDateStr}" 
										rendered="#{verifyRental.dataObj.renderColumn}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.round']}" style="width: 25"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.cycleNo}">
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.seq']}" style="width: 25"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.seqNo}">
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.reqTypeName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.reqType']}" style="width: 150"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypPopApproveType" value= "#{verifyRental.dataObj.reqTypeName}" 
										oncomplete="#{rich:component('popupEditDetailHistory')}.show(); return false"
										 action="#{navAction.navi}" style="width:100" reRender="popupFrmEditPeriod" 
										 rendered="#{verifyRental.dataObj.renderColumn}">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupEditHistory"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="sIdHistory" value="#{verifyRental.dataObj.siteInfoId}"  />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.title}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.title']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{verifyRental.dataObj.title}" 
										rendered="#{verifyRental.dataObj.renderColumn}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.rentalJobStatusName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rentStatus']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.rentalJobStatusName}" 
										rendered="#{verifyRental.dataObj.renderColumn}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.verifyStatusName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.verifyStatus']}" style="width: 12"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.verifyStatusName}" 
										rendered="#{verifyRental.dataObj.renderColumn}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.progressStatus}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="Site Progress" style="width: 25"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.progressStatus}" 
										rendered="#{verifyRental.dataObj.renderColumn}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.siteStatusName}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" style="width: 25"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.networkStatus}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<f:facet name="header">
									<a4j:region>
										<h:selectBooleanCheckbox value="#{semmrt001Bean.chkSelAll}" style="width: 20">
											<a4j:support event="onclick" action="#{semmrt001Action.selectAllRow}" reRender="dtbVerifyRental,btnExport"/>
										</h:selectBooleanCheckbox>
									</a4j:region>
								</f:facet>
								<div align="center">
									<a4j:region>
										<h:selectBooleanCheckbox id="verifyRentalSelected" value="#{verifyRental.checkBox}" >
											<a4j:actionparam name="checkBox" value="#{verifyRental.checkBox}"/>	
											<a4j:support event="onclick" action="#{semmrt001Action.selectRow}" reRender="dtbVerifyRental,btnExport" />								
										</h:selectBooleanCheckbox>
									</a4j:region>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								rendered="#{semmrt001Bean.renderer['hlkAddVendor'] or semmrt001Bean.renderedOnToDoList}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="" style="width: 72"/>
								</f:facet>
								<div align="center">
									<h:panelGroup rendered="#{verifyRental.dataObj.vendorMasterId == null || verifyRental.dataObj.vendorMasterId == ''}">
										<a4j:commandLink id="hypAddVendor" value="#{jspMsg['column.link.addVendor']}" 
											reRender="txtNavProgram, oppContent" action="#{navAction.navi}" oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doSaveVendorByOtherPage" />
											<a4j:actionparam name="mode" value="Edit" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="lessorId" value="#{verifyRental.dataObj.siteLessorId}" />
											<a4j:actionparam name="contractNoParam" value="#{verifyRental.dataObj.contractNo}" />
											<a4j:actionparam name="expenseType" value="#{verifyRental.dataObj.expenseType}" />
											<a4j:actionparam name="vendorIdParam" value="#{verifyRental.dataObj.vendorMasterId}" />
											<a4j:actionparam name="expenseTypeIdParam" value="#{verifyRental.dataObj.expenseType}" />
											<a4j:actionparam name="isPageFrom" value="true" />
											
											<a4j:actionparam name="navModuleBack" value="rt" />
											<a4j:actionparam name="navProgramBack" value="SEMMRT001-1" />
											<a4j:actionparam name="actionWithNaviBack" value="SEMMRT001"/>
											<a4j:actionparam name="methodWithNaviBack" value="doBackPage" />
											<a4j:actionparam name="backOtherPageFlag" value="Y" />
											<a4j:actionparam name="todoManagerFlag" value="N" />
											<a4j:actionparam name="btnActionType" value="N" />
											<a4j:actionparam name="verifyFlag" value="Y" />
											<a4j:actionparam name="actionId" value="PAGE_VERIFY_NEW" />
										</a4j:commandLink>
									</h:panelGroup>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.vendorCode}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorCode']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{verifyRental.dataObj.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.vendorName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 100px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{verifyRental.dataObj.vendorName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.payeeName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.altPayee']}" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{verifyRental.dataObj.payeeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								sortBy="#{verifyRental.dataObj.vendorStatusName}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<a4j:support event="onclick"   action="#{semmrt001Action.getRowIdOnClick}" reRender="dtbVerifyRental">
								<a4j:actionparam name="rowId" value="#{verifyRental.dataObj.siteInfoId}" />
								</a4j:support>
								<f:facet name="header">
									<h:outputText value="Vendor Status" style="width: 50px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{verifyRental.dataObj.vendorStatusName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmrt001Bean.tmpRowId==verifyRental.dataObj.siteInfoId)?'onClick':'unClick'}" 
								rendered="#{semmrt001Bean.renderer['hlkAddVendor'] or semmrt001Bean.renderedOnToDoList}" 
								title="#{verifyRental.dataObj.contractNo} #{verifyRental.dataObj.siteName}">
								<f:facet name="header">
									<h:outputText value="" style="width: 72"/>
								</f:facet>
								<div align="center">
									<h:panelGroup rendered="#{verifyRental.dataObj.vendorMasterId != null}">
									<a4j:commandLink id="hypAddVendorEdit" value="#{jspMsg['column.link.addVendor']}" 
										reRender="txtNavProgram, oppContent" action="#{navAction.navi}" oncomplete="onTopPage();">
											<a4j:actionparam name="navModule" value="mm" />
											<a4j:actionparam name="navProgram" value="SEMMMM001-2" />
											<a4j:actionparam name="moduleWithNavi" value="mm" />
											<a4j:actionparam name="actionWithNavi" value="SEMMMM001"/>
											<a4j:actionparam name="methodWithNavi" value="doSaveVendorByOtherPage" />
											<a4j:actionparam name="mode" value="Edit" />
											<a4j:actionparam name="headType" value="Vendor" />
											<a4j:actionparam name="lessorId" value="#{verifyRental.dataObj.siteLessorId}" />
											<a4j:actionparam name="contractNoParam" value="#{verifyRental.dataObj.contractNo}" />
											<a4j:actionparam name="expenseType" value="#{verifyRental.dataObj.expenseType}" />
											<a4j:actionparam name="vendorIdParam" value="#{verifyRental.dataObj.vendorMasterId}" />
											<a4j:actionparam name="expenseTypeIdParam" value="#{verifyRental.dataObj.expenseType}" />
											<a4j:actionparam name="isPageFrom" value="true" />
											
											<a4j:actionparam name="navModuleBack" value="rt" />
											<a4j:actionparam name="navProgramBack" value="SEMMRT001-1" />
											<a4j:actionparam name="actionWithNaviBack" value="SEMMRT001"/>
											<a4j:actionparam name="methodWithNaviBack" value="doBackPage" />
											<a4j:actionparam name="backOtherPageFlag" value="Y" />
											<a4j:actionparam name="todoManagerFlag" value="N" />
											<a4j:actionparam name="verifyFlag" value="Y" />
											<a4j:actionparam name="actionId" value="PAGE_VERIFY_EDIT" />
									</a4j:commandLink>
									</h:panelGroup>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmrt001Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="18">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVerifyRental"
											maxPages="#{semmrt001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstVerifyRental" 
											style="background-color: #cccccc;"
											page="#{semmrt001Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>
<jsp:include page="../../pages/popup/editDetailpopup.jsp"/>



<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mrt001PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mrt001PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mrt001PopUp_addVendor" attachTo="hide-mrt001PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMrt001PopUp_addVendor">
		
			<!-- >> group criteria -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="เงื่อนไขการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<table width="100%" align="center" border="0">
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Code :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorCode" value="#{semmrt001Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmrt001Bean.vendorMasterPopupObjParam.vendorName}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
					</table>		
				</h:panelGroup>
			</rich:panel>
			<!-- << group criteria -->
			
			<div style="clear:both; height:10px;"></div>

			<!-- >> button search/clear -->
			<h:panelGrid columns="1">
				<h:panelGroup style="">
					<a4j:commandButton value="Search" action="#{semmrt001Action.doSearchPopupAddVendor}"
					reRender="frmMrt001PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmrt001Action.doClearPopupAddVendor}"
					reRender="frmMrt001PopUp_addVendor, dataTable_searchVendor"
					styleClass="rich-button">
						
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << button search/clear -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> group result -->
			<rich:panel>
				<f:facet name="header">
					<h:panelGroup>
						<h:outputText value="ผลการค้นหา"></h:outputText>
					</h:panelGroup>
				</f:facet>
			
				<h:panelGroup style="width:100%;">
					<!-- >> table result -->
					<center>
					<div style="width:900px; overflow-y:scroll; border:1px solid e0e0e0;"> 
							<rich:dataTable style="width:100%;" id="dataTable_searchVendor" cellpadding="1" cellspacing="0" border="0" 
							var="vendorLst"  value="#{semmrt001Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmrt001Action.doSelectPopupAddVendor}"
											reRender="oppContent">
												<a4j:actionparam name="paramVendorCode" value="#{vendorLst.dataObj.vendorCode}" />
												<a4j:actionparam name="paramVendorName" value="#{vendorLst.dataObj.vendorName}" />
											</a4j:commandLink>
									</div>	
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code ใหม่" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mrt001_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mrt001_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mrt001_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mrt001_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmrt001Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmrt001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmrt001Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMrt001PopUp_addVendor"></a4j:support>
												</rich:datascroller>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
								<!-- footer -->
							</rich:dataTable>
					</div>
					</center>
					<!-- << table result -->
				</h:panelGroup>
			</rich:panel>
			<!-- << group result -->
			
			<div style="clear:both; height:10px;"></div>
			
			<!-- >> additional button close -->
			<h:panelGrid columns="1" cellpadding="0" cellspacing="1" style="float:right;">
				<h:panelGroup style="float:right;">
					<a4j:commandButton value="Exit" styleClass="rich-button" immediate="true">
					    <rich:componentControl for="mrt001PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->