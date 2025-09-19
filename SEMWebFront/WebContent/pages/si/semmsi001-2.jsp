<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>

<f:loadBundle basename="resources.siteinfo.semmsi001" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlAddSiteApprove">
		<f:facet name="header">
			<h:outputText
				value="#{jspMsg['header.name']} - #{semmsi001Bean.pageStatus}" />
		</f:facet>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmAddSiteApprove">
				<!-- begin content layout -->
				<h:panelGrid width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td width="50%" align="left">
								<table id="tblMessage">
									<tr>
										<td><rich:messages layout="list" errorClass="ms7red"
											warnClass="ms7blue" infoClass="ms7green"
											rendered="#{semmsi001Bean.renderedMsgFormSearch}">
											<f:facet name="header">
												<h:outputText value="Entered Data Status:"></h:outputText>
											</f:facet>
											<f:facet name="errorMarker">
												<h:graphicImage value="images/error.gif" />
											</f:facet>
										</rich:messages></td>
									</tr>
								</table>
								</td>
								<td width="50%" align="right" valign="baseline">
								<table id="tblButton">
									<tr>
										<td><a4j:commandButton id="btnBack"
											value="#{jspMsg['btn.back']}" styleClass="rich-button"
											action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI001-1" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
											<a4j:actionparam name="methodWithNavi" value="pageLoad" />
											<a4j:actionparam name="mode" value="SEARCH" />
										</a4j:commandButton></td>
										<td><a4j:commandButton id="btnSave"
											value="#{jspMsg['btn.save']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlAddSiteApprove,pnlLog,frmAddSiteApprove"
											rendered="#{semmsi001Bean.visibleBtnModeView}">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
											<a4j:actionparam name="methodWithNavi" value="doSave" />
										</a4j:commandButton></td>
										<!-- <td>
											<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
												action="#{navAction.navi}" reRender="pnlSiteApprove,pnlSiteApproveMapLoc,pnlSiteMapLocResult" 
												disabled="#{semmsi001Bean.visibleBtnModeView}">
												<a4j:actionparam name="navModule" value="si" />
												<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
												<a4j:actionparam name="moduleWithNavi" value="si" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
												<a4j:actionparam name="methodWithNavi" value="doCancel" />
											</a4j:commandButton>
										</td> -->
										<td><a4j:commandButton id="btnNew" value="New"
											styleClass="rich-button"
											oncomplete="#{rich:component('mdpConfirmResetDialog')}.show(); return false"
											rendered="#{semmsi001Bean.visibleBtnModeView}">
										</a4j:commandButton></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					<rich:panel id="pnlSiteApprove">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.frmAdd']}" />
						</f:facet>
						<!-- begin content -->
						<h:panelGrid width="90%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.reqType']}"
											styleClass="ms7" /></td>
										<td width="25%"><h:selectOneMenu id="ddlReqType"
											value="#{semmsi001Bean.siteSP.reqType}"
											disabled="#{semmsi001Bean.visibleModeView}"
											onchange="getLovVal2JS()">
											<f:selectItems value="#{semmsi001Bean.reqTypeList}" />
											<a4j:jsFunction name="getLovVal2JS"
												action="#{semmsi001Action.getLovVal2ByTypeAndCode}"
												reRender="pnlSiteApprove,pnlSiteApproveMapLoc,ddlCompany,txtEffDt,txtExpDt,frmAddSiteApprove" oncomplete="GetCompanyJS();"/>
										</h:selectOneMenu></td>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.reqDocType']}"
											styleClass="ms7" /></td>
										<td width="30%"><h:selectOneMenu id="ddlReqDocType"
											value="#{semmsi001Bean.siteSP.reqDocType}"
											disabled="#{semmsi001Bean.visibleModeView}">
											<f:selectItems value="#{semmsi001Bean.reqDocTypeList}" />
										</h:selectOneMenu></td>
									</tr>
									<tr>

										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.title']}"
											styleClass="ms7" /></td>
										<td width="25%"><h:inputText id="txtTitle"
											value="#{semmsi001Bean.siteSP.title}" size="30"
											readonly="#{semmsi001Bean.visibleModeView}"
											disabled="#{semmsi001Bean.visibleModeView}" /></td>
										<h:panelGroup
											rendered="#{semmsi001Bean.siteSP.reqType != '01' && semmsi001Bean.siteSP.reqType != ''}">
											<td align="right" width="20%"><h:graphicImage
												value="images/icon_required.gif"
												rendered="#{!(semmsi001Bean.siteSP.reqType == '01' || semmsi001Bean.siteSP.reqType == '' || semmsi001Bean.siteSP.reqType == null || semmsi001Bean.siteSP.reqType == '07')}" /><rich:spacer
												width="5" /><h:outputText
												value="#{jspMsg['label.contractNo']}" styleClass="ms7" /></td>
											<td width="30%"><h:inputText id="txtContractNo"
												value="#{popupSiteContractBean.contractNo}"
												readonly="#{semmsi001Bean.visibleModeView}"
												disabled="#{semmsi001Bean.visibleModeView}"
												onchange="chkBlankContract();" size="17" maxlength="20"
												onblur="setFormatContractNo(this)">
												<a4j:jsFunction name="chkBlankContract"
													reRender="frmAddSiteApprove,txtContractNo,ddlCompany"
													action="#{semmsi001Action.chkBlankContract}" oncomplete="#{popupSiteContractBean.jsName}"/>
												<a4j:jsFunction name="getContractNoJS"
													reRender="frmAddSiteApprove,txtContractNo"
													action="#{popupSiteContractAction.getSiteInfoIdPsi005}" oncomplete="#{popupSiteContractBean.jsCheckDataNotFound}"/>
												<a4j:jsFunction name="getCompany"
													reRender="frmAddSiteApprove,txtContractNo"
													action="#{semmsi001Action.getCompany}"  />
												<a4j:jsFunction name="doInitPopupContractNo"
													reRender="popupSearchContractNo"
													action="#{semmsi001Action.doSearchPopupContractNo}"  oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false" />
											</h:inputText> <rich:spacer width="2" /> <a4j:commandButton
												id="btnContractNo" value="..." action="#{navAction.navi}"
												oncomplete="#{rich:component('popupSearchContractNo')}.show(); return false"
												reRender="popupSearchContractNo"
												disabled="#{semmsi001Bean.visibleModeView}">
												<a4j:actionparam name="navModule" value="si" />
												<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi"
													value="PopupSiteContract" />
												<a4j:actionparam name="methodWithNavi"
													value="initPopupSearchContractNoPsi005" />
												<a4j:actionparam name="company"
													value="#{semmsi001Bean.siteSP.company}" />
											</a4j:commandButton></td>
										</h:panelGroup>

									</tr>
									
																		
									<h:panelGroup
											rendered="#{semmsi001Bean.siteSP.reqType != '01' && semmsi001Bean.siteSP.reqType != ''}">
									<tr>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.effDt']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="txtEffDt"
											value="#{popupSiteContractBean.effDt}" size="10"
											disabled="true"/>
											
										</td>
										<td align="right" >
												<h:outputText value="#{jspMsg['label.expDt']}" styleClass="ms7"   />
											</td>
											<td>
												<h:inputText id="txtExpDt"
												value="#{popupSiteContractBean.expDt}" size="10"
												disabled="true"/>
											</td>
									</tr>
									</h:panelGroup>
									
									<tr>
										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.reqOfficer']}"
											styleClass="ms7" /></td>
										<td colspan="3"><h:panelGroup id="groupTest">
											<a4j:region>
												<h:selectOneMenu id="ddlReqOfficer"
													value="#{semmsi001Bean.siteSP.reqOfficer}"
													disabled="#{semmsi001Bean.visibleModeView}"
													onchange="ChkTxtReqOfficer();">
													<a4j:jsFunction name="ChkTxtReqOfficer"
														action="#{semmsi001Action.chkTxtReqOfficer}"
														reRender="groupTest" />
													<f:selectItems value="#{semmsi001Bean.reqOfficerList}" />
												</h:selectOneMenu>
											</a4j:region>
											<rich:spacer width="5" />
											<h:inputText id="txtReqOfficer"
												value="#{semmsi001Bean.otherReqOfficer}" size="30"
												rendered="#{semmsi001Bean.disTxtReqOfficer}"
												readonly="#{semmsi001Bean.visibleModeView}"
												disabled="#{semmsi001Bean.visibleModeView}" />
										</h:panelGroup></td>
									</tr>
									<tr>
										<td align="right" valign="baseline"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.company']}"
											styleClass="ms7" /></td>
										<td valign="bottom" align="left">
										<a4j:region>
											<h:selectOneMenu id="ddlCompany"
												value="#{semmsi001Bean.siteSP.company}"												
												onchange="GetCompanyJS();"
												disabled="#{semmsi001Bean.visibleModeView}">
												<a4j:jsFunction name="GetCompanyJS" action="#{semmsi001Action.checkCompany}"
													reRender="companyDisplay,btnContractNo,frmAddSiteApprove" />
												<f:selectItems value="#{semmsi001Bean.companyList}" />
											</h:selectOneMenu>
										</a4j:region> <rich:spacer width="5" /> <h:outputLabel id="companyDisplay"
											value="#{semmsi001Bean.siteSP.company}" styleClass="ms28"></h:outputLabel>
										</td>
										<!-- <td colspan="2" align="left" valign="bottom">
				                		
				                	</td> -->
									</tr>
									<tr>
										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.docNo']}"
											styleClass="ms7" /></td>
										<td width="25%">
											<h:inputText id="txtDocNo"
											value="#{semmsi001Bean.siteSP.docNo}"
											readonly="#{semmsi001Bean.visibleModeView}"
											disabled="#{semmsi001Bean.visibleModeView}" size="18"
											maxlength="20" onblur="setFormatDocNo(this)" />
											<rich:spacer width="5px"/>
											<a4j:commandButton id="btnGenDocNo"
											value="#{jspMsg['btn.genDocNo']}" styleClass="rich-button"
											action="#{navAction.navi}"
											reRender="pnlAddSiteApprove,pnlLog,frmAddSiteApprove"
											rendered="#{semmsi001Bean.visibleBtnModeView}">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
											<a4j:actionparam name="methodWithNavi" value="doGenDocNo" />
										</a4j:commandButton>
										</td>
										<td align="right" width="20%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.docDate']}"
											styleClass="ms7" /></td>
										<td width="30%"><rich:calendar id="cldDocDate"
											locale="en/US" enableManualInput="true"
											datePattern="dd/MM/yyyy"
											value="#{semmsi001Bean.siteSP.docDt}"
											readonly="#{semmsi001Bean.visibleModeView}"
											disabled="#{semmsi001Bean.visibleModeView}"
											showWeeksBar="false" inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											/>
										</td>
									</tr>
									<tr>
										<td colspan="2">
										</td>
										<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.approveDate']}"
											styleClass="ms7" /></td>
										<td width="30%"><rich:calendar id="cldApproveDate"
											locale="en/US" enableManualInput="true"
											datePattern="dd/MM/yyyy"
											value="#{semmsi001Bean.siteSP.approveDt}"
											readonly="#{semmsi001Bean.visibleModeView}"
											disabled="#{semmsi001Bean.visibleModeView}"
											showWeeksBar="false" inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											/>
										</td>
									</tr>
									
									
									<tr>
										<td align="right" valign="top" width="25%"><h:outputText
											value="#{jspMsg['label.detail']}" styleClass="ms7" /></td>
										<td colspan="4"><h:inputTextarea id="txtDetail" cols="85"
											rows="3" readonly="#{semmsi001Bean.visibleModeView}"
											disabled="#{semmsi001Bean.visibleModeView}"
											value="#{semmsi001Bean.siteSP.detail}">
										</h:inputTextarea></td>
									</tr>
									

									<h:panelGroup
										rendered="#{semmsi001Bean.siteSP.reqType == '98'}">
										<tr>
											<td align="right" width="25%"><h:graphicImage
												value="images/icon_required.gif" /><rich:spacer width="5" />
											<h:outputText value="#{jspMsg['label.invalidDt']}"
												styleClass="ms7" /></td>
											<td><rich:calendar id="cldInvalidDt" locale="th"
												enableManualInput="true" datePattern="dd/MM/yyyy"
												value="#{semmsi001Bean.siteSP.invalidDt}"
												showWeeksBar="false" inputSize="13"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												cellWidth="20px" cellHeight="20px"
												label="#{jspMsg['msg.invalidDt']}">
											</rich:calendar></td>
										</tr>
									</h:panelGroup>
									<tr>
										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.inDt']}" styleClass="ms7" />
										</td>
										<td><rich:calendar id="cldInDt" locale="th"
											enableManualInput="true" datePattern="dd/MM/yyyy"
											value="#{semmsi001Bean.siteSP.inDt}" showWeeksBar="false"
											inputSize="13"
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['msg.invalidDt']}"
											disabled="#{semmsi001Bean.visibleModeView}">
										</rich:calendar></td>
									</tr>
									<tr>
										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.siteApproveStatus']}"
											styleClass="ms7" /></td>
										<td><h:selectOneMenu id="ddlApproveStatus"
											value="#{semmsi001Bean.siteSP.siteApproveStatus}"
											disabled="#{semmsi001Bean.visibleApproveStatus}">
											<f:selectItems value="#{semmsi001Bean.siteApproveStatusList}" />
										</h:selectOneMenu></td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content -->
					</rich:panel>
					<rich:panel id="pnlSiteApproveMapLoc">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.frmAddMapLoc']}" />
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="left" colspan="6"><h:message
											for="txtLocationId" errorClass="ms7red" warnClass="ms7blue"
											infoClass="ms7green" /></td>
									</tr>
									<tr>
										<td align="right" width="25%"><h:graphicImage
											value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.locationId']}"
											styleClass="ms7" /></td>
										<td width="25%"><h:inputText id="txtLocationId"
											value="#{popupSiteLocationBean.locationId}"
											readonly="#{semmsi001Bean.visibleModeView}"
											disabled="#{semmsi001Bean.visibleModeView}"
											onchange="getLocationJS();" size="15" maxlength="12">
											<a4j:jsFunction name="getLocationJS"
												reRender="pnlSiteApproveMapLoc,frmAddSiteApprove"
												action="#{popupSiteLocationAction.getSiteLocation}">
												<a4j:actionparam name="isPage" value="SEMMSI001-2" />
											</a4j:jsFunction>
										</h:inputText> <rich:spacer width="2" /> <a4j:commandButton
											id="btnSrchLocation" value="..." action="#{navAction.navi}"
											disabled="#{semmsi001Bean.visibleModeView}"
											reRender="popupSearchSiteLocation,frmShowPopup">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
											<a4j:actionparam name="moduleWithNavi" value="common" />
											<a4j:actionparam name="actionWithNavi"
												value="PopupSiteLocation" />
											<a4j:actionparam name="methodWithNavi"
												value="initPopupSiteLocation" />
											<a4j:actionparam name="isPage" value="SEMMSI001-2" />
										</a4j:commandButton></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.locationName']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtLocationName"
											readonly="true" value="#{popupSiteLocationBean.locationName}"
											size="30" /></td>
									</tr>
									<tr>
										<td align="right" width="25%"><h:outputText
											value="#{jspMsg['label.region']}" styleClass="ms7" /></td>
										<td width="25%"><h:inputText id="txtRegion"
											readonly="true" value="#{popupSiteLocationBean.region}"
											size="15" /></td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.networkType']}" styleClass="ms7" /></td>
										<td width="30%"><h:inputText id="txtStationType"
											readonly="true" value="#{popupSiteLocationBean.networkStatus}"
											size="30" /></td>
									</tr>
									<tr>
										<td colspan="6"><a4j:commandButton id="btnCopyLocation"
											value="#{jspMsg['btn.copyLocation']}"
											styleClass="rich-button" action="#{navAction.navi}"
											reRender="pnlSiteMapLocResult,dtbSiteMapLoc,pnlSiteApproveMapLoc,pnlAddSiteApprove,pnlLog,frmAddSiteApprove"
											style="width: 170px;"
											rendered="#{semmsi001Bean.siteSP.reqType != '01' && semmsi001Bean.siteSP.reqType != '' && semmsi001Bean.visibleBtnModeView}">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
											<a4j:actionparam name="methodWithNavi" value="copyLocation" />
										</a4j:commandButton> <rich:spacer width="5"></rich:spacer> <a4j:commandButton
											id="btnAddLocation" value="#{jspMsg['btn.addLocation']}"
											styleClass="rich-button" action="#{navAction.navi}"
											reRender="pnlSiteMapLocResult,dtbSiteMapLoc,pnlSiteApproveMapLoc,pnlAddSiteApprove,pnlLog,frmAddSiteApprove"
											rendered="#{semmsi001Bean.visibleBtnModeView && !(semmsi001Bean.visibleModeView)}">
											<a4j:actionparam name="navModule" value="si" />
											<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
											<a4j:actionparam name="moduleWithNavi" value="si" />
											<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
											<a4j:actionparam name="methodWithNavi"
												value="onAddSiteLocation" />
										</a4j:commandButton></td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
					<!-- begin content layout data grid -->
					<rich:panel id="pnlSiteMapLocResult">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTableLoc.name']}" />
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbSiteMapLoc" cellpadding="1" cellspacing="0"
							border="0" var="siteMapLoc"
							value="#{semmsi001Bean.siteMapLocList}" reRender="dtbSiteMapLoc"
							rows="#{semmsi001Bean.rowPerPage}" rowClasses="cur"
							styleClass="dataTable">

							<a4j:support event="onRowClick"
								action="#{semmsi001Action.getRowIdOnClick}"
								reRender="dtbSiteMapLoc">
								<a4j:actionparam name="rowId" value="#{siteMapLoc.mapLocId}" />
								<a4j:actionparam name="mode" value="SITEMAPLOC" />
							</a4j:support>

							<!-- begin column -->
							<rich:column
								styleClass="#{(semmsi001Bean.tmpRowId==siteMapLoc.mapLocId)?'onClick':'unClick'}"
								rendered="#{semmsi001Bean.visibleBtnModeView && !(semmsi001Bean.visibleModeView)}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.delete']}"
										style="width: 40" />
								</f:facet>
								<div align="center"><a4j:commandButton
									oncomplete="#{rich:component('mdpConfirmDelDialog2')}.show(); return false"
									action="#{navAction.navi}" image="images/delete.png"
									style="height: 15; width: 15;" id="btnDelete"
									reRender="mdpConfirmDelDialog2">
									<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
									<a4j:actionparam name="methodWithNavi"
										value="initDeleteSiteMapLoc" />
									<a4j:actionparam name="siteMapLocId"
										value="#{siteMapLoc.mapLocId}" />
								</a4j:commandButton></div>
							</rich:column>
							<rich:column
								styleClass="#{(semmsi001Bean.tmpRowId==siteMapLoc.mapLocId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}"
										style="width: 150" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{siteMapLoc.locationId}" /></div>
							</rich:column>
							<rich:column
								styleClass="#{(semmsi001Bean.tmpRowId==siteMapLoc.mapLocId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationName']}"
										style="width: 200" />
								</f:facet>
								<div align="left"><h:outputText
									value="#{siteMapLoc.locationName}" /></div>
							</rich:column>
							<rich:column
								styleClass="#{(semmsi001Bean.tmpRowId==siteMapLoc.mapLocId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}"
										style="width: 100" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{siteMapLoc.region}" /></div>
							</rich:column>
							<rich:column
								styleClass="#{(semmsi001Bean.tmpRowId==siteMapLoc.mapLocId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkType']}"
										style="width: 200" />
								</f:facet>
								<div align="center"><h:outputText
									value="#{siteMapLoc.networkStatus}" /></div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left"
									for="dtbSiteMapLoc" maxPages="10" id="dstSiteMapLoc"
									selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<!-- end content layout data grid -->
					<rich:panel id="pnlLog">
						<h:panelGrid width="90%" border="0" cellpadding="0"
							cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" width="25%"><h:outputText
											value="#{jspMsg['label.createBy']}" styleClass="ms7" /></td>
										<td width="25%"><h:inputText id="txtCreateBy"
											value="#{semmsi001Bean.siteSP.createBy}" disabled="true" />
										</td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.createDate']}" styleClass="ms7" /></td>
										<td width="30%"><rich:calendar id="cldCreateDate"
											locale="th" datePattern="dd/MM/yyyy HH:mm:ss"
											value="#{semmsi001Bean.siteSP.createDt}" inputSize="20"
											cellWidth="20px" cellHeight="20px"
											buttonIcon="/images/hide-button.png"
											buttonIconDisabled="/images/hide-button.png" disabled="true" />
										</td>
									</tr>
									<tr>
										<td align="right" width="25%"><h:outputText
											value="#{jspMsg['label.updateBy']}" styleClass="ms7" /></td>
										<td width="25%"><h:inputText id="txtUpdateBy"
											value="#{semmsi001Bean.siteSP.updateBy}" disabled="true" />
										</td>
										<td align="right" width="20%"><h:outputText
											value="#{jspMsg['label.updateDate']}" styleClass="ms7" /></td>
										<td width="30%"><rich:calendar id="cldUpdateDate"
											locale="th" datePattern="dd/MM/yyyy HH:mm:ss"
											value="#{semmsi001Bean.siteSP.updateDt}" showWeeksBar="false"
											inputSize="20" cellWidth="20px" cellHeight="20px"
											buttonIcon="/images/hide-button.png"
											buttonIconDisabled="/images/hide-button.png" disabled="true" />
										</td>
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout criteria -->
			</a4j:form>
		</h:panelGrid>
		<jsp:include page="../../pages/popup/sitecontractPsi005-popup.jsp" />
		<jsp:include page="../../pages/popup/sitelocation-popup.jsp" />
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog2" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm Delete"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmDelDialog2">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="170px">
					<h:outputText value="#{semmsi001Bean.msgDoDelete}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td>
				<div align="center"><a4j:commandButton value="Yes"
					styleClass="rich-button" action="#{navAction.navi}"
					immediate="true" reRender="dtbSiteMapLoc,pnlSiteApproveMapLoc"
					rendered="#{semmsi001Bean.modeDelPopup == 'DEL'}">
					<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
					<a4j:actionparam name="methodWithNavi" value="doDeleteSiteMapLoc" />
					<rich:componentControl for="mdpConfirmDelDialog2" operation="hide"
						event="onclick" />
				</a4j:commandButton> <rich:spacer width="5"></rich:spacer> <a4j:commandButton value="No"
					styleClass="rich-button" immediate="true"
					rendered="#{semmsi001Bean.modeDelPopup == 'DEL'}">
					<rich:componentControl for="mdpConfirmDelDialog2" operation="hide"
						event="onclick" />
				</a4j:commandButton> <a4j:commandButton value="OK" styleClass="rich-button"
					immediate="true"
					rendered="#{semmsi001Bean.modeDelPopup == 'ALERT'}">
					<rich:componentControl for="mdpConfirmDelDialog2" operation="hide"
						event="onclick" />
				</a4j:commandButton></div>
				</td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmResetDialog" autosized="true">
	<f:facet name="header">
		<h:outputText value="Confirm"></h:outputText>
	</f:facet>
	<a4j:form id="frmConfirmResetDialog">
		<table width="240px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><h:panelGrid columns="1" styleClass="contentlabelform"
					width="240px">
					<h:outputText value="#{semmsi001Bean.txtContent2}" styleClass="ms7" />
				</h:panelGrid></td>
			</tr>
			<tr>
				<td>
				<div align="center"><a4j:commandButton value="Yes"
					styleClass="rich-button" action="#{navAction.navi}"
					immediate="true"
					reRender="dtbSiteMapLoc,pnlSiteApproveMapLoc,pnlAddSiteApprove,pnlSiteApprove,pnlSiteMapLocResult">
					<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI001-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI001" />
					<a4j:actionparam name="methodWithNavi" value="doReset" />
					<rich:componentControl for="mdpConfirmResetDialog" operation="hide"
						event="onclick" />
				</a4j:commandButton> <rich:spacer width="5"></rich:spacer> <a4j:commandButton value="No"
					styleClass="rich-button" immediate="true">
					<rich:componentControl for="mdpConfirmResetDialog" operation="hide"
						event="onclick" />
				</a4j:commandButton></div>
				</td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>

<a4j:form id="frmShowPopup">
<h:panelGrid id="pnlShowPopup" style="height:0px;width:0px;" width="0px" columns="0" >
	<h:panelGroup id="pnlInShowReport" rendered="#{popupSiteLocationBean.renderPopup}" style="height:0px;width:0px;" >
		<a4j:commandButton id="bthPopup" style="height:0px;width:0px;display:none;" oncomplete="#{rich:component('popupSearchSiteLocation')}.show(); return false" action="#{popupSiteLocationAction.setRenderPopup}"  />	
		<script>document.getElementById('incContent:frmShowPopup:bthPopup').click();</script>
	</h:panelGroup>							
</h:panelGrid>
</a4j:form>