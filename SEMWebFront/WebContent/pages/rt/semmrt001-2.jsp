<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semmrt001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlAddRenatal">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmRentalAdd']}" /></f:facet>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmAddRental">
				<!-- begin content layout -->
				<h:panelGrid width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr><td colspan="2">
									<table id="menuLink" width="100%">
										<tr>
										<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '05'}">
											<td width="12%" align="left">
												<a4j:commandLink value="#{jspMsg['link.rentalAndService']}" style="font-size:12px;">
												</a4j:commandLink>
											</td>
											<td width="7%" align="left">
												<a4j:commandLink value="#{jspMsg['link.bail']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="DEPOSIT" />
												</a4j:commandLink>
											</td>
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.checkPremium']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-5" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doLoadCheckPremium" />
													<a4j:actionparam name="rentalMasterId" value="#{semmrt001Bean.displayFrmRental.rentalMasterId}" />
												</a4j:commandLink>
											</td>
											<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.verifyStatus == '02'}">
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.expenseSend']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-4" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="contractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}" />
													<a4j:actionparam name="mode" value="RENTALPAYMENT" />
												</a4j:commandLink>
											</td>
											</h:panelGroup>
											<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.verifyStatus != '02'}">
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.expenseSend']}" action="#{navAction.navi}" 
													reRender="frmAddRental" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="contractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}" />
													<a4j:actionparam name="mode" value="RENTALPAYMENT" />
												</a4j:commandLink>
											</td>
											</h:panelGroup>
												<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '05' && semmrt001Bean.displayFrmRental.reqType != '99'}">
												<td width="70%" align="right">
													<a4j:commandLink value="#{jspMsg['link.detailStation']}" 
														oncomplete="showViewSiteInfoPopup()"
										           		action="#{navAction.navi}" style="font-size:12px;">
										           		<a4j:actionparam name="navModule" value="rt" />
														<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
														<a4j:actionparam name="moduleWithNavi" value="common" />
														<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
														<a4j:actionparam name="methodWithNavi" value="initPopup" />
														<a4j:actionparam name="rowId" value="#{semmrt001Bean.displayFrmRental.siteInfoId}" />
													</a4j:commandLink>
												</td>
												</h:panelGroup>
											</h:panelGroup>
											<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType == '05' || semmrt001Bean.displayFrmRental.reqType == '99'}">
											<td align="right">
												<a4j:commandLink value="#{jspMsg['link.detailStation']}" 
													oncomplete="showViewSiteInfoPopup()" styleClass="ms7"
									           		action="#{navAction.navi}" style="width:100;font-size:12px;">
									           		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="common" />
													<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
													<a4j:actionparam name="methodWithNavi" value="initPopup" />
													<a4j:actionparam name="rowId" value="#{semmrt001Bean.displayFrmRental.siteInfoId}" />
												</a4j:commandLink>
											</td>
											</h:panelGroup>
										</tr>
									</table>
							</td></tr>
							<tr>
								<td width="50%" align="left">
									<table id="tblMessage">
										<tr><td>
											<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
												rendered="#{semmrt001Bean.renderedMsgFormSearch}">
											 		<f:facet name="header">
							                        	<h:outputText value="Entered Data Status:" />
							                    	</f:facet>
										 			<f:facet name="errorMarker">
										 				 <h:graphicImage value="images/error.gif" />  
								                    </f:facet>
							                </rich:messages>
										</td></tr>
									</table>
								</td>
								<td width="50%" align="right" valign="baseline">
									<table id="tblButton">
										<tr><td>
											<a4j:commandButton id="btnBack" value="#{jspMsg['btn.back']}" styleClass="rich-button" 
												action="#{navAction.navi}" reRender="oppContent">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-1" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="pageLoad" />
												<a4j:actionparam name="mode" value="SEARCH" />
											</a4j:commandButton>
										</td><td>
											<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType == '05' || semmrt001Bean.displayFrmRental.reqType == '99'}">
											<a4j:commandButton id="btnSavePending" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
												oncomplete="if(#{semmrt001Bean.popupWarning == 'true'})#{rich:component('mdpConfirmSaveDialog')}.show(); return false" 
												rendered="#{!semmrt001Bean.viewMode}" 
												disabled="#{semmrt001Bean.disableBtnSave }" 
												onclick="this.disabled=true;"
												action="#{navAction.navi}" reRender="pnlRental,frmAddRental,pnlLog,frmWarningSaveDialog" >
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="doCheckBeforeSaveRentalMaster" />
											</a4j:commandButton>
											</h:panelGroup>
											<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '05' && semmrt001Bean.displayFrmRental.reqType != '99'}">
											<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
												action="#{navAction.navi}" reRender="pnlRental,frmAddRental,pnlLog,frmWarningSaveDialog"
												disabled="#{semmrt001Bean.disableBtnSave }" 
												onclick="this.disabled=true;"
												oncomplete="if(#{semmrt001Bean.popupWarning == 'true'})#{rich:component('mdpWarningSaveDialog')}.show(); return false" 
												rendered="#{semmrt001Bean.renderedModeApprove && !semmrt001Bean.viewMode}">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="doUpdateRentalMaster" />
											</a4j:commandButton>
											</h:panelGroup>
										</td><td>
											<a4j:commandButton id="btnApprove" value="#{jspMsg['btn.approve']}" styleClass="rich-button" 
												action="#{navAction.navi}" rendered="#{semmrt001Bean.disApprove && !semmrt001Bean.viewMode}" 
												reRender="pnlRental,frmAddRental,pnlLog">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="doApprove" />
											</a4j:commandButton>
										</td>
										<td>
											<a4j:commandButton id="btnUploadPicture"
												action="#{navAction.navi}"
												reRender="oppContent,popupUploadPictureCriteria"
												value="#{jspMsg['btn.attachFile']}" styleClass="rich-button" style="width:110"
												oncomplete="#{rich:component('popupUploadPictureCriteria')}.show(); return false" >
												<a4j:actionparam name="navModule" value="common" />
												<a4j:actionparam name="navProgram" value="#{userSession.navProgram}" />
												<a4j:actionparam name="moduleWithNavi" value="common" />
												<a4j:actionparam name="actionWithNavi" value="PopupUploadFilePicture" />
												<a4j:actionparam name="methodWithNavi" value="initUploadCriteria" />
												<a4j:actionparam name="refId" value="" />
												<a4j:actionparam name="module" value="RTV"/>
												<a4j:actionparam name="contractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}"/>
												<a4j:actionparam name="viewMode" value="N"/>
											</a4j:commandButton>
										</td></tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					<rich:panel id="pnlRental">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.subRentalAdd']}"/>
						</f:facet>
						<!-- begin content -->
						<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="20%" valign="baseline">
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</td>
			                		<td width="80%" colspan="3" valign="bottom">
										<h:selectOneMenu id="ddlCompany" value="#{semmrt001Bean.displayFrmRental.company}" 
											onchange="GetCompanyJS();" disabled="true">
											<f:selectItems value="#{semmrt001Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmrt001Bean.displayFrmRental.company}" styleClass="ms28"/>
					                </td>
				                </tr>
								<tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td><td width="20%">
										<h:inputText id="txtContractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}" 
											disabled="true"></h:inputText>
									</td><td align="right" width="15%">
										<!--<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/> -->
										<h:outputText value="#{semmrt001Bean.disableBtnSave }" styleClass="ms7"/>
									</td><td width="35%">
										<h:inputText id="txtSiteName" value="#{semmrt001Bean.displayFrmRental.siteName}" 
											disabled="true" size="45"></h:inputText>
									</td>
								</tr>
								<tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.beginDt']}" styleClass="ms7"/>
									</td>
									<td>
										<rich:calendar id="cldFirstEffDate" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
			                			value="#{semmrt001Bean.displayFrmRental.effDate}" 
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.beginDt']}"
										disabled="true">
										</rich:calendar>
									</td>
									<td align="right">
										<h:outputText value="#{jspMsg['label.endDt']}" styleClass="ms7"/>
									</td>
									<td>
										<rich:calendar id="cldExpireDate" locale="th" enableManualInput="true" 
			                			datePattern="dd/MM/yyyy" 
			                			value="#{semmrt001Bean.displayFrmRental.expireDate}" 
			                			showWeeksBar="false" 
			                			inputSize="13"
			                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										cellWidth="20px" cellHeight="20px"
										label="#{jspMsg['label.endDt']}"
										disabled="true">
										</rich:calendar>
									</td>
								</tr>
								<tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.reqType']}" styleClass="ms7" />
									</td><td>
										<h:selectOneMenu id="ddlsReqType1" value="#{semmrt001Bean.displayFrmRental.reqType}" 
											disabled="true">
											<f:selectItems value="#{semmrt001Bean.reqTypeList}"/>
										</h:selectOneMenu>
									</td><td align="right">
										<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
									</td><td>
										<h:inputText id="txtTitle" value="#{semmrt001Bean.displayFrmRental.title}" 
											disabled="true" size="45"></h:inputText>
									</td>
								</tr>
								<tr>
									<td align="right">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.rentalStatus']}" styleClass="ms7"/>
									</td><td align="left">
										<h:selectOneMenu id="ddlRentalStatus" 
											value="#{semmrt001Bean.displayFrmRental.rentalJobStatus}" 
											onchange="mrt003RentalServ_checkRentalStatus()"
											disabled="#{(semmrt001Bean.disApprove || (semmrt001Bean.displayFrmRental.reqType != '05' && semmrt001Bean.displayFrmRental.reqType != '99')) || semmrt001Bean.viewMode}">
											<f:selectItems value="#{semmrt001Bean.rentalStatusList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="mrt003RentalServ_checkRentalStatus" action="#{semmrt001Action.doCheckRentalStatus}" 
										reRender="pnlSearchResult"></a4j:jsFunction>
									</td><td align="right">
										<h:panelGroup>
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.verifyStatus']}" styleClass="ms7"/>
										</h:panelGroup>
									</td><td>
											<h:selectOneMenu id="ddlVerifyStatusNormal" 
												value="#{semmrt001Bean.displayFrmRental.verifyStatus}" 
												disabled="#{semmrt001Bean.disApprove || semmrt001Bean.viewMode}">
												<f:selectItems value="#{semmrt001Bean.verifyStatusList}"/>
											</h:selectOneMenu>
									</td>
								</tr>
								<tr>
									<td align="right">
										<h:selectBooleanCheckbox id="selPendingDt" value="#{semmrt001Bean.disPendingDt}" 
											onclick="reRenderPending()" />
										<a4j:jsFunction name="reRenderPending" action="#{semmrt001Action.checkPendingDt}" reRender="pnlRental"/>
										<rich:spacer width="5"/>
										<h:outputText value="Pending :" styleClass="ms7"/>
									</td>
									<td>
										<rich:calendar id="cldPendingDt" locale="th" enableManualInput="true" 
									  	 datePattern="dd/MM/yyyy" 
									   	 value="#{semmrt001Bean.displayFrmRental.pendingDate}"
									   	 showWeeksBar="false" 
									   	 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	 inputSize="13" 
									   	 oninputblur="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
										 oncollapse="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
									   	 cellWidth="20px" cellHeight="20px" label="Pending Date" 
									   	 disabled="#{!semmrt001Bean.disPendingDt}">
										</rich:calendar>
									</td>
									<td align="right" width="15%">
										<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
									</td><td width="35%">
										<h:inputText id="txtRemark" value="#{semmrt001Bean.displayFrmRental.remark}" size="45"></h:inputText>
									</td>
								</tr>
								<tr>
									<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType == '99'}">
										<td align="right">
											<h:outputText value="Terminate :" styleClass="ms7"/>
										</td>
										<td>
											<rich:calendar id="cldTerminateDt" locale="th" enableManualInput="true" 
										  	 datePattern="dd/MM/yyyy" 
										   	 value="#{semmrt001Bean.displayFrmRental.terminateDt}"
										   	 showWeeksBar="false" 
										   	 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										   	 inputSize="13" 
										   	 oninputblur="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
											 oncollapse="validateRichCalendarFromTo('frmSaveBG002_2','cldStartDt','cldEndDt');"
										   	 cellWidth="20px" cellHeight="20px" label="Terminate Date">
											</rich:calendar>
										</td>
										<td ></td>
									</h:panelGroup>
									<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '99'}">
										<td colspan="3"></td>
									</h:panelGroup>
									<td>
										<h:selectBooleanCheckbox id="selSplSite" value="#{semmrt001Bean.displayFrmRental.specialFlag}"/>
										<rich:spacer width="5"/>
										<h:outputText value="Special Site" styleClass="ms7"/>
									</td>
								</tr>
							</table>
						</h:panelGroup></h:panelGrid>
						<!-- end content -->
					<!-- begin content layout data grid -->
					</rich:panel>
				<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '05'}">		
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar_5Rows" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.nameNormal']}" style="width: 1550"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbRentCond" cellpadding="1" cellspacing="0" border="0" 
							var="rentCond"  value="#{semmrt001Bean.rentCondList}" reRender="dtbRentCond" 
							rows="#{semmrt001Bean.rowPerPage}" 
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<!-- begin column -->
							<rich:column rendered="#{!semmrt001Bean.viewMode}">
								<div align="center">
									<h:selectBooleanCheckbox id="rentCondSelected" value="#{rentCond.selected}"	
										disabled="#{rentCond.disSelect or semmrt001Bean.disabledVerify}">
										<a4j:support event="onclick" reRender="pnlRentalDetail,frmAddRental,dtbRentCond" 
											action="#{semmrt001Action.doSelectedRentSetup}">
											<a4j:actionparam name="siteRentCondId" value="#{rentCond.siteRentCondId}"/>
											<a4j:actionparam name="siteInfoId" value="#{rentCond.siteInfoId}"/>
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.expenseType}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expenseType']}" style="width: 88"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentCond.expenseTypeName}"></h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.expenseDesc}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expenseDesc']}" style="width: 88"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentCond.expenseDesc}"></h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.placeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.placeName']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.placeName}" />
								</div>
							</rich:column>							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Service" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.serviceName}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{rentCond.detail}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.detail']}" style="width: 180"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentCond.detail}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.rentOldAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rentOldAmt']}" style="width: 60"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCond.rentOldAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.rentAddPercent}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rentAddPercent']}" style="width: 60"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCond.rentAddPercent}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.rentAddAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rentAddAmt']}" style="width: 60"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCond.rentAddAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.rentAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.rentAmt']}" style="width: 70"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCond.rentAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.rentPeriodTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodType']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.rentPeriodTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.whtTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtType']}" style="width: 12"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.whtTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.whtRate}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtRate']}" style="width: 30"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.whtRate}"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.vateTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.vateTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.vatRate}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.vatRate}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.payPeriodTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodType']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.payPeriodTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{rentCond.setupPeriodAmt}" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCond.setupPeriodAmt}">
										<f:convertNumber pattern="#,##0.00" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.balanceAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.balanceAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCond.balanceAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.effectiveDtTh}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDt']}" style="width: 88"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCond.effectiveDtThStr}">
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCond" 
									id="dstRentCond" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					
					<!-- Special -->
					<h:panelGroup >
					<rich:simpleTogglePanel id="pnlSpecialServiceRent" rendered="false" switchType="client" label="#{jspMsg['header.resultTable.nameSpecial']}" opened="#{semmrt001Bean.rentCondSpecial.detail != null || semmrt001Bean.servCondSpecial.detail != null}" width="100%">
						<h:panelGrid width="100%" border="0" cellpadding="0" cellspacing="1">
									<h:panelGroup id="pnlRentCondSpecial" >
									   <table style="width:100%; border:solid 1px;" id="tableRentCondSpecial">
									       <tr>
                                                <td style="width:50%; border:solid dcdcdc 0px; vertical-align:top;">
                                                    <rich:panel style="width:100%; text-align:center">
				                                        <!-- >> header -->
				                                        <f:facet name="header">
				                                            <h:outputText value="#{jspMsg['label.th_cost_rental']}#{jspMsg['label.th_area']}" />
			                                           </f:facet>
			                                           <!-- << header -->
			                                           <table width="90%">
														<tr>
															<td align="right">
																<h:selectBooleanCheckbox id="specialRentChk" value="#{semmrt001Bean.specialChk1}" disabled="#{semmrt001Bean.rentCondSpecial.detail == null}">
									                				<a4j:support event="onclick" action="#{semmrt001Action.clickSpecialChk}" reRender="pnlRentalDetail,pnlSearchResult,pnlSpecialServiceRent">
									                					<f:param name="expenseType" value="01"/>
									                				</a4j:support>
																</h:selectBooleanCheckbox>
															</td>
															<td colspan="2">
																<h:outputText value="#{jspMsg['label.rentSpecial']}" styleClass="ms7"/>
															</td>
														</tr>
														<tr>
															
															<td align="right" >
																<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
															</td>
															<td  colspan="2">
																<h:selectOneMenu id="ddlSpecialExpenseType1" value="#{semmrt001Bean.rentCondSpecial.expenseType}" 
																	disabled="true">
																	<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
																</h:selectOneMenu>
															</td>
														</tr>
														<tr>
															<td align="right" valign="top"  >
																<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
															</td>
															<td  colspan="2">
																<h:inputTextarea rows="4" cols="60" disabled="true"
																	value="#{semmrt001Bean.rentCondSpecial.detail}">
																</h:inputTextarea>
															</td>
														</tr>
														<tr>
															<td align="right" >
																<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
															</td>
															<td colspan="2">
																<h:selectOneRadio id="rbtSpecialWhtType1" styleClass="ms7" layout="lineDirection" 
																	value="#{semmrt001Bean.rentCondSpecial.whtType}" 
																	disabled="true">
																	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
														            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
														            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
																</h:selectOneRadio>
															</td>
														</tr>
														<tr>
															<td align="right" >
																<h:outputText value="#{jspMsg['label.whtRate']} :" styleClass="ms7" />
															</td>
															<td colspan="2">
																<h:inputText disabled="true" size="5" value="#{semmrt001Bean.rentCondSpecial.whtRate}"/>
																<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
															</td>
														</tr>
														<tr>
															<td align="right">
																<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
															</td>
															<td colspan="2">
																<h:selectOneRadio id="rbtSpecial1VatType" styleClass="ms7" 
																	value="#{semmrt001Bean.rentCondSpecial.vatType}" 
																	disabled="true">
																	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
														            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
														            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
														            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} " />
																</h:selectOneRadio>
															</td>
														</tr>
													</table>
			                                        </rich:panel>
                                                </td>
                                           
                                                <td style="width:50%; border:solid dcdcdc 0px; vertical-align:top;">
				                                    <rich:panel style="text-align:center">
				                                        <!-- >> header -->
				                                        <f:facet name="header">
				                                            <h:outputText value="#{jspMsg['label.th_cost_service']}" />
				                                        </f:facet>
				                                        <!-- << header -->
				                                        
				                                        <table width="90%">
															<tr>
																<td align="right">
																	<h:selectBooleanCheckbox id="specialServiceChk" value="#{semmrt001Bean.specialChk2}" disabled="#{semmrt001Bean.servCondSpecial.detail == null}">
										                				<a4j:support event="onclick" action="#{semmrt001Action.clickSpecialChk}" reRender="pnlRentalDetail,pnlSearchResult,pnlSpecialServiceRent,pnlSpecialRental,pnlRentalDetail">
										                					<f:param name="expenseType" value="02"/>
										                					<f:param name="subExpenseType" value="01"/>
										                				</a4j:support>
																	</h:selectBooleanCheckbox>
																</td>
																<td colspan="2">
																	<h:outputText value="#{jspMsg['label.serSpecial']}" styleClass="ms7"/>
																</td>
															</tr>
															<tr>
																	
																<td align="right" >
																	<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneMenu id="ddlSpecialExpenseType2" value="#{semmrt001Bean.servCondSpecial.expenseType}" 
																		disabled="true">
																		<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
																	</h:selectOneMenu>
																</td>
															</tr>
															<tr>
																<td align="right" valign="top" >
																	<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:inputTextarea rows="4" cols="60" disabled="true"
																		value="#{semmrt001Bean.servCondSpecial.detail}">
																	</h:inputTextarea>
																</td>
															</tr>
															<tr>
																<td align="right" >
																	<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneRadio id="rbtSpecialWhtType2" styleClass="ms7" layout="lineDirection" 
																		value="#{semmrt001Bean.servCondSpecial.whtType}" 
																		disabled="true">
																		<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
															            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
															            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
																	</h:selectOneRadio>
																</td>
																
															</tr>
															<tr>
																<td align="right" >
																	<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7" />
																</td>
																<td colspan="2">
																	<h:inputText disabled="true" size="5" value="#{semmrt001Bean.servCondSpecial.whtRate}"/>
																	<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
																</td>
															</tr>
															<tr>
																<td align="right" >
																	<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneRadio id="rbtSpecialVatType2" styleClass="ms7" 
																		value="#{semmrt001Bean.servCondSpecial.vatType}" 
																		disabled="true">
																		<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
															            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
															            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
															            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} " />
																	</h:selectOneRadio>
																</td>
															</tr>
														</table> 
				                                     </rich:panel>
				                                 </td>
                                           </tr>
                                           <tr>
				                                <td style="width:50%; border:solid dcdcdc 0px; vertical-align:top;">
				                                    <rich:panel style="text-align:center">
				                                        <!-- >> header -->
				                                        <f:facet name="header">
				                                            <h:outputText value="#{jspMsg['label.th_cost_service']}#{jspMsg['label.th_setup']}#{jspMsg['label.th_hardware']}" />
				                                        </f:facet>
				                                        
				                                        <table width="90%">
															<tr>
																<td align="right">
																	<h:selectBooleanCheckbox id="specialServiceChk2" value="#{semmrt001Bean.specialChk3}" disabled="#{semmrt001Bean.servCondSpecial2.detail == null}">
										                				<a4j:support event="onclick" action="#{semmrt001Action.clickSpecialChk}" reRender="pnlRentalDetail,pnlSearchResult,pnlSpecialServiceRent,pnlSpecialRental,pnlRentalDetail">
										                					<f:param name="expenseType" value="02"/>
										                					<f:param name="subExpenseType" value="02"/>
										                				</a4j:support>
																	</h:selectBooleanCheckbox>
																</td>
																<td colspan="2">
																	<h:outputText value="#{jspMsg['label.th_cost_service']}#{jspMsg['label.th_setup']}#{jspMsg['label.th_hardware']}" styleClass="ms7"/>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneMenu id="ddlSpecialExpenseType3" value="#{semmrt001Bean.servCondSpecial2.expenseType}" 
																		disabled="true">
																		<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
																	</h:selectOneMenu>
																</td>
															</tr>
															<tr>
																
																<td align="right" valign="top" >
																	<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:inputTextarea rows="4" cols="60" disabled="true"
																		value="#{semmrt001Bean.servCondSpecial2.detail}">
																	</h:inputTextarea>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneRadio id="rbtSpecialWhtType3" styleClass="ms7" layout="lineDirection" 
																		value="#{semmrt001Bean.servCondSpecial2.whtType}" 
																		disabled="true">
																		<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
															            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
															            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
																	</h:selectOneRadio>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7" />
																</td>
																<td colspan="2">
																	<h:inputText disabled="true" size="5" value="#{semmrt001Bean.servCondSpecial2.whtRate}"/>
																	<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
																</td>
															</tr>
															<tr>
																<td align="right" >
																	<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneRadio id="rbtSpecialVatType3" styleClass="ms7" 
																		value="#{semmrt001Bean.servCondSpecial2.vatType}" 
																		disabled="true">
																		<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
															            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
															            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
															            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} " />
																	</h:selectOneRadio>
																</td>
															</tr>
														</table>
				                                    </rich:panel>
				                                </td>
				                                <td style="width:50%; border:solid dcdcdc 0px; vertical-align:top;">
				                                    <rich:panel style="text-align:center">
				                                        <!-- >> header -->
				                                        <f:facet name="header">
				                                            <h:outputText value="#{jspMsg['label.th_cost_']}#{jspMsg['label.th_other']}" />
				                                        </f:facet>
				                                        <!-- << header -->
				                                        
				                                        <table width="90%">
															<tr>
																<td align="right">
																	<h:selectBooleanCheckbox id="specialServiceChk3" value="#{semmrt001Bean.specialChk4}" disabled="#{semmrt001Bean.servCondSpecial3.detail == null}">
										                				<a4j:support event="onclick" action="#{semmrt001Action.clickSpecialChk}" reRender="pnlRentalDetail,pnlSearchResult,pnlSpecialServiceRent,pnlSpecialRental,pnlRentalDetail">
										                					<f:param name="expenseType" value="02"/>
										                					<f:param name="subExpenseType" value="03"/>
										                				</a4j:support>
																	</h:selectBooleanCheckbox>
																</td>
																<td colspan="2">
																	<h:outputText value="#{jspMsg['label.th_cost_']}#{jspMsg['label.th_other']}"
																	 styleClass="ms7"/>
																</td>
															</tr>
															<tr>	
																<td align="right">
																	<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneMenu id="ddlSpecialExpenseType4" value="#{semmrt001Bean.servCondSpecial3.expenseType}" 
																		disabled="true">
																		<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
																	</h:selectOneMenu>
																</td>
															</tr>
															<tr>
																<td align="right" valign="top">
																	<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:inputTextarea rows="4" cols="60" disabled="true"
																		value="#{semmrt001Bean.servCondSpecial3.detail}">
																	</h:inputTextarea>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneRadio id="rbtSpecialWhtType4" styleClass="ms7" layout="lineDirection" 
																		value="#{semmrt001Bean.servCondSpecial3.whtType}" 
																		disabled="true">
																		<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
															            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
															            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
																	</h:selectOneRadio>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7" />
																</td>
																<td colspan="2">
																	<h:inputText disabled="true" size="5" value="#{semmrt001Bean.servCondSpecial3.whtRate}"/>
																	<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
																</td>
																<td colspan="2">
																	<h:selectOneRadio id="rbtSpecialVatType4" styleClass="ms7" 
																		value="#{semmrt001Bean.servCondSpecial3.vatType}" 
																		disabled="true">
																		<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
															            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
															            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
															            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} " />
																	</h:selectOneRadio>
																</td>
															</tr>
														</table>
				                                    </rich:panel>
				                                </td>
				                           </tr>
									   </table>
									 </h:panelGroup>
								</h:panelGrid>
					</rich:simpleTogglePanel>
					</h:panelGroup>
					<!-- Special -->
					
					<rich:panel id="pnlRentalDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.frmRentDetail']}"/>
						</f:facet>
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
								<tr>
									<td align="left" colspan="3">
										<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
											rendered="#{semmrt001Bean.renderedMsgFormMiddle}">
											<f:facet name="header">
								            	<h:outputText value="Entered Data Status:"></h:outputText>
								            </f:facet>
											<f:facet name="errorMarker">
												<h:graphicImage value="images/error.gif" />  
									        </f:facet>
								        </rich:messages>
									</td>
								</tr>
								<h:panelGroup >
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<rich:calendar id="cldEffDate" locale="th" enableManualInput="true" 
											datePattern="dd/MM/yyyy" showWeeksBar="false" inputSize="13" 
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											value="#{semmrt001Bean.rentDetail.effectiveDt}" 
											/>
										<rich:spacer width="10" />
										<h:outputText value="-" />
										<rich:spacer width="10" />
										<rich:calendar id="cldExpDate" locale="th" enableManualInput="true" 
											datePattern="dd/MM/yyyy" showWeeksBar="false" inputSize="13" 
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											value="#{semmrt001Bean.rentDetail.expiredDt}" 
											/>
				                	</td>
				                </tr>
				                </h:panelGroup>
								<tr>
									<td align="right" width="20%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
			                		<td width="15%" >
										<h:selectOneMenu id="ddlExpenseType" value="#{semmrt001Bean.rentDetail.expenseType}" 
											disabled="#{semmrt001Bean.disabledExpenseType}"
											onchange="onChangeDdlExpenseTypeJS();">
											<a4j:jsFunction name="onChangeDdlExpenseTypeJS" reRender="txtWhtRate,txtVatRate,pnlRentalDetail,rbtVatType,btnAdd" 
												action="#{semmrt001Action.onChangeDdlExpenseType}"/> 
											<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
										</h:selectOneMenu>
					                </td>
					                <td width="65%">
					                	<table>
					                		<tr>
						                		<td width="15%" align="right">
												<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value=" #{jspMsg['label.expenseDesc']} :" style="margin:0 0 0 0;" styleClass="ms7" />
												</td>
												<td width="55%"align="left">
													<h:inputTextarea id="semmrt001Bean_expenseDesc" style="width:90%;" rows="2" 
							       					value="#{semmrt001Bean.rentDetail.expenseDesc}" 
							       					disabled="#{semmrt001Bean.disabledExpenseDesc }">
							       					</h:inputTextarea>
											    </td>		
					                			
					                			<td align="right">
					                				<h:outputText value="Pending :" styleClass="ms7"/>
					                			</td>
					                			<td>
					                				<rich:calendar id="mrt001_pendingDt" locale="th" enableManualInput="true" 
													datePattern="dd/MM/yyyy" 
													value="#{semmrt001Bean.rentDetail.pendingDt}"
													showWeeksBar="false"
													inputSize="10"
													oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												   	cellWidth="15px" cellHeight="20px"
												   	styleClass="ms7">
													</rich:calendar>
					                			</td>
					                		</tr>
					                	</table>
					                </td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%" valign="top">
				                		<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="15%" valign="top">
										<h:selectOneRadio id="rbtWhtType" styleClass="ms7" layout="pageDirection" 
											value="#{semmrt001Bean.rentDetail.whtType}" onclick="changeDefaultWht();" >
											<a4j:jsFunction name="changeDefaultWht" 
				                							reRender="rbtWhtType,txtWhtRate" 
				                							action="#{semmrt001Action.setChangeWht}">
				              				</a4j:jsFunction>
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
										</h:selectOneRadio>
					                </td>	
					                <td  valign="top">
					                <a4j:region>
										<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7"/>
										<h:inputText id="txtWhtRate" disabled="#{!semmrt001Bean.disWhtRate}" 
											value="#{semmrt001Bean.rentDetail.whtRate}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="chkVisibleWhtRateJS();return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" size="3">
		                					<f:convertNumber pattern="#,##0"  maxIntegerDigits="13" />
		                				</h:inputText>
										<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
										<rich:spacer width="5"/>
										<h:selectBooleanCheckbox id="editWhtRateSelected" value="#{semmrt001Bean.disWhtRate}" 
											onclick="chkVisibleWhtRateJS();" disabled="#{semmrt001Bean.viewMode}">
											<a4j:jsFunction name="chkVisibleWhtRateJS" 
												action="#{semmrt001Action.checkValueWhtRate}"
												reRender="txtWhtRate"></a4j:jsFunction>
										</h:selectBooleanCheckbox>
						                <rich:spacer width="2"/>
						                <h:outputText value="#{jspMsg['label.edit']}" styleClass="ms7"/>
						            </a4j:region>
					                </td>
				                </tr>
				                <h:panelGroup rendered="true">
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="15%">
										<h:selectOneRadio id="rbtVatType" styleClass="ms7" 
											value="#{semmrt001Bean.rentDetail.vatType}" 
											disabled="#{semmrt001Bean.viewMode}" onclick="changeDefaultVat();">
											<a4j:jsFunction name="changeDefaultVat" 
				                							reRender="rbtVatType,txtVatRate" 
				                							action="#{semmrt001Action.setChangeVat}">
				              				</a4j:jsFunction>
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
										</h:selectOneRadio>
					                </td>
					                <td >
					                	<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7" />
					                	<h:inputText id="txtVatRate" disabled="true" 
											size="5" value="#{semmrt001Bean.rentDetail.vatRate}"/>
										<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
					                </td>
				                </tr>
				                </h:panelGroup>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.amt']}" styleClass="ms7">
				                		</h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:inputText id="txtSpecialAmt" value="#{semmrt001Bean.rentDetail.rentalAmt}" 
				                			disabled="#{semmrt001Bean.disabledSpacialChk || semmrt001Bean.viewMode}" 
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" onchange="jsSetRentAmtValue();"
		                					styleClass="inputRight">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                		<a4j:jsFunction name="jsSetRentAmtValue" action="#{semmrt001Action.setRentAmtValue}" reRender="txtSpecialAmt,ddlPeriodType,txtPeriodAmt" />
				                		<rich:spacer width="7"/>
				                		<h:outputText value="#{jspMsg['label.bath']} / " styleClass="ms7"/>
				                		<rich:spacer width="10"/>
				                		<h:selectOneMenu id="ddlPeriodType" value="#{semmrt001Bean.rentDetail.rentPeriodType}" onchange="jsSetRentAmtValue();"
											disabled="#{semmrt001Bean.disabledSpacialChk || semmrt001Bean.viewMode}">
											<f:selectItems value="#{semmrt001Bean.periodTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                	<!-- begin radio custom -->
				                	<a4j:region>
				                		<table width="95%" cellpadding="0" cellspacing="0">
				                			<tr>
				                				<td width="600px">
				                					<h:selectOneRadio id="rbtPayPeriodType" styleClass="ms7" 
				                						value="#{semmrt001Bean.period}" onclick="chkPayPeriodJS();" 
				                						disabled="#{semmrt001Bean.viewMode}">
				                						<a4j:jsFunction name="chkPayPeriodJS" 
				                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
				                							action="#{semmrt001Action.chkPayPeriodType}">
				                							<a4j:actionparam name="type" value="1" />
				              							</a4j:jsFunction>
														<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']}" />
											            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}" />
											            <f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']}" />
											            <f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']}" />
											            <f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']}" />
													</h:selectOneRadio>
				                				</td>
				                				<td width="70px" align="left">
				                					<h:selectOneRadio id="rbtPayPeriodType3" styleClass="ms7" 
				                						value="#{semmrt001Bean.period3}" onclick="chkPayPeriodJS3();" 
				                						disabled="#{semmrt001Bean.viewMode}">
				                						<a4j:jsFunction name="chkPayPeriodJS3" 
				                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
				                							action="#{semmrt001Action.chkPayPeriodType}">
				                							<a4j:actionparam name="type" value="2" />
				              							</a4j:jsFunction>
														<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.rai']}" />
													</h:selectOneRadio>
				                				</td>
				                				<td width="100px" align="left">
				                					<h:inputText id="month" size="2" value="#{semmrt001Bean.payPeriodMonth}" 
				                						disabled="#{semmrt001Bean.viewMode || semmrt001Bean.period3 != '03'}" 
				                						maxlength="4" style="text-align: center;"
				                						onchange="chkPayPeriodJS5();"
				                						onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
				                						<a4j:jsFunction name="chkPayPeriodJS5" 
				                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
				                							action="#{semmrt001Action.chkPayPeriodType}">
				                							<a4j:actionparam name="type" value="2" />
				              							</a4j:jsFunction>
				                						</h:inputText>
				                						<rich:spacer 
				                						width="2"/><h:outputText value="#{jspMsg['label.month']}" styleClass="ms7" />
				                				</td>
				                				<td width="70px">
				                					<h:selectOneRadio id="rbtPayPeriodType4" styleClass="ms7" 
				                						value="#{semmrt001Bean.period4}" onclick="chkPayPeriodJS4();" 
				                						disabled="#{semmrt001Bean.viewMode}" >
				                						<a4j:jsFunction name="chkPayPeriodJS4" 
				                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2,year" 
				                							action="#{semmrt001Action.chkPayPeriodType}">
				                							<a4j:actionparam name="type" value="3" />
				              							</a4j:jsFunction>
														<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.rai']}" />
													</h:selectOneRadio>
				                				</td>
				                				<td align="left" width="70px">
				                					<h:inputText id="year" size="2" value="#{semmrt001Bean.payPeriodYear}" 
				                						disabled="#{semmrt001Bean.viewMode || semmrt001Bean.period4 != '04'}" 
				                						maxlength="2" style="text-align: center;"
				                						onchange="chkPayPeriodJS6();"
				                						onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
				                						<a4j:jsFunction name="chkPayPeriodJS6" 
				                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
				                							action="#{semmrt001Action.chkPayPeriodType}">
				                							<a4j:actionparam name="type" value="3" />
				              							</a4j:jsFunction>
				                						</h:inputText>
				                						<rich:spacer 
				                						width="2"/><h:outputText value="#{jspMsg['label.year']}" styleClass="ms7" />
				                				</td>
				                			</tr>
				                		</table>
				                		</a4j:region>
					                </td>
				                </tr>
				                
				                
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodStDt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<rich:calendar id="cldPeriodStDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt001Bean.rentDetail.periodStartDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   oninputblur="validateRichCalendarFromTo('frmAddRental','cldPeriodStDt','cldPeriodEndDt');"
											   	   oncollapse="validateRichCalendarFromTo('frmAddRental','cldPeriodStDt','cldPeriodEndDt');"
											   	   label="#{jspMsg['label.periodStDt']}" 
											   	   disabled="#{semmrt001Bean.viewMode}">
										</rich:calendar>
										<rich:spacer width="30"></rich:spacer><h:graphicImage 
											value="images/icon_required.gif" rendered="#{semmrt001Bean.requireFlag}"/><rich:spacer width="5"></rich:spacer><h:outputText 
											value="#{jspMsg['label.periodEndDt']}" styleClass="ms7"></h:outputText><rich:spacer 
											width="5"></rich:spacer>
											
											
										<rich:calendar id="cldPeriodEndDt" locale="th" enableManualInput="true"  
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt001Bean.rentDetail.periodEndDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.periodEndDt']}" 
											   	   disabled="#{semmrt001Bean.viewMode}">
										</rich:calendar>
										<a4j:jsFunction name="changeDatePeriodEnd" reRender="cldPeriodEndDt"/>
										<rich:spacer width="10" />
										<h:panelGroup >
											<a4j:commandButton id="btnCalculate" value="Calculate" styleClass="rich-button"
												action="#{navAction.navi}" 
												reRender="txtYear,txtMonth,txtDay,txtTotPeriodNo,txtPeriodAmt2,pnlRentalDetail">
							            		<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="doCalculate" />
							            	</a4j:commandButton>
						            	</h:panelGroup>
				                	</td>
				                </tr>
				                <h:panelGroup >
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.totPeriodNo']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:inputText id="txtTotPeriodNo" value="#{semmrt001Bean.rentDetail.totPeriodNo}"
				                			onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
		                					styleClass="inputRight" size="5" 
		                					disabled="#{semmrt001Bean.rentDetail.payPeriodType == '05' || semmrt001Bean.viewMode}">
				                		</h:inputText>
				                		<rich:spacer width="80" />
				                		<h:inputText id="txtYear" value="#{semmrt001Bean.rentDetail.periodYear}" 
				                			size="2" disabled="true" style="text-align: center;"/>
				                		<rich:spacer width="2" />
				                		<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"/>
				                		<rich:spacer width="2" />
				                		<h:inputText id="txtMonth" value="#{semmrt001Bean.rentDetail.periodMonth}" 
				                			size="2" disabled="true" style="text-align: center;"/>
				                		<rich:spacer width="2" />
				                		<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"/>
				                		<rich:spacer width="2" />
				                		<h:inputText id="txtDay" value="#{semmrt001Bean.rentDetail.periodDay}" 
				                			size="2" disabled="true" style="text-align: center;"/>
				                		<rich:spacer width="2" />
				                		<h:outputText value="#{jspMsg['label.day']}" styleClass="ms7"/>
				                	</td>
				                </tr>
				                </h:panelGroup>
				                
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodAmt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:inputText id="txtPeriodAmt" value="#{semmrt001Bean.rentDetail.periodAmt}" 
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" styleClass="inputRight" 
		                					disabled="#{semmrt001Bean.viewMode}">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                	</td>
				                </tr>
				                <tr>
					                	<td align="right" width="20%" >
											<h:outputText value="#{jspMsg['label.balance']}" styleClass="ms7" />
										</td>
										<td >
												<h:inputText id="txtBalance" 
													value="#{semmrt001Bean.rentDetail.balanceAmt}" 
													onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						onblur="return numberformat.moneyFormat(this);"
			                						onfocus="return numberformat.setCursorPosToEnd(this);"
													disabled="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:inputText>
											
					                	</td>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:selectOneMenu id="ddlVendor" value="#{semmrt001Bean.rentDetail.vendorMasterId}" 
				                			onchange="onChangeDdlVendorJS();" 
				                			disabled="#{semmrt001Bean.viewMode}">
				                			<a4j:jsFunction name="onChangeDdlVendorJS" reRender="ddlPayee,txtBookBank,txtBankName" 
				                				action="#{semmrt001Action.onChangeDdlVendor}">
				                				<a4j:actionparam name="modeDdl" value="RENTAL" />
				                			</a4j:jsFunction>
											<f:selectItems value="#{semmrt001Bean.vendorList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.payee']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:selectOneMenu id="ddlPayee" value="#{semmrt001Bean.rentDetail.payeeMasterId}"
				                			onchange="onChangeDdlPayeeJS();" 
				                			disabled="#{semmrt001Bean.viewMode}">
				                			<a4j:jsFunction name="onChangeDdlPayeeJS" reRender="txtBookBank,txtBankName" 
				                				action="#{semmrt001Action.onChangeDdlPayee}">
				                				<a4j:actionparam name="modeDdl" value="RENTAL" />
				                			</a4j:jsFunction>
											<f:selectItems value="#{semmrt001Bean.payeeList}"/>
										</h:selectOneMenu>
				                		<rich:spacer  style="height : 1px; width : 182px;"/> 
				                		<h:outputText value="#{jspMsg['label.service']}" styleClass="ms7" ></h:outputText>
				   						<rich:spacer  style="height : 1px; width : 3px;"/>
		   						
				                		<h:selectOneMenu id="service" value="#{semmrt001Bean.serviceCalTypeId}" onchange="doChangeValueService();"> 
											<f:selectItems value="#{semmrt001Bean.serviceNameList}"/>
										</h:selectOneMenu>
							 <a4j:jsFunction name="doChangeValueService" action="#{semmrt001Action.doChangeValueService}" reRender="frmServiceCalSaveDialog,servicePercent,pnlRentalDetail,showCalType" ></a4j:jsFunction>

										<h:outputText value=" #{jspMsg['label.calBy']}" styleClass="ms7"></h:outputText>
										<h:outputText id="showCalType" value="  #{semmrt001Bean.serviceCalTypeIdToCalName} " styleClass="ms7"></h:outputText>
										<rich:spacer  style="height : 1px; width : 8px;"/>
										<a4j:commandButton value="..." styleClass="rich-button"  reRender="frmServiceCalSaveDialog,servicePercent,inputAmout,inputPercent"
										 oncomplete="#{rich:component('serviceCalDialog')}.show();" 
										 onbeforedomupdate="doViewValuebyEdit();" >
									 
										</a4j:commandButton>
									<a4j:jsFunction name="doViewValuebyEdit" action="#{semmrt001Action.doViewValuebyEdit}" reRender="frmServiceCalSaveDialog,servicePercent,massage" >
         							</a4j:jsFunction>
										
				                	</td>
				                </tr>
				          
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.bookBank']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:inputText id="txtBookBank" disabled="true" value="#{semmrt001Bean.mrt001BookBank.bankAccNo}" 
				                			style="width: 200px"/>
				                		<rich:spacer width="70" />
				                		<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
				                		<rich:spacer width="5" />
				                		<h:inputText id="txtBankName" disabled="true" value="#{semmrt001Bean.mrt001BookBank.bankName}" 
				                			style="width: 250px"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%" valign="top">
				                		<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="2">
				                		<h:inputTextarea cols="80" rows="5" value="#{semmrt001Bean.rentDetail.remark}" 
				                			disabled="#{semmrt001Bean.viewMode}"></h:inputTextarea>
				                	</td>
				                </tr>
				                
				                </table>
							</h:panelGroup>
						</h:panelGrid>
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" 
								rendered="#{semmrt001Bean.modeRentalDetail == 'ADD' && !semmrt001Bean.viewMode}" 
								action="#{navAction.navi}" disabled="#{semmrt001Bean.disBtnAdd }"
								reRender="pnlRentDetailResult,pnlRentalDetail,pnlSearchResult,
									fieldRentalDetail,frmAddRental,dtbRentCond">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doAddRentalDetail" />
							</a4j:commandButton>
							<a4j:commandButton id="btnSaveRentDetail" value="Save" styleClass="rich-button" 
								rendered="#{semmrt001Bean.modeRentalDetail == 'EDIT' && !semmrt001Bean.viewMode}" 
								action="#{navAction.navi}" disabled="#{semmrt001Bean.disBtnAdd}" 
			            	 	reRender="pnlRentDetailResult,pnlRentalDetail,pnlSearchResult,
			            	 		fieldRentalDetail,frmAddRental,dtbRentCond">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doAddRentalDetail" />
			            	</a4j:commandButton>
			            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
			            		action="#{navAction.navi}" 
			            	 	reRender="pnlRentalDetail,dtbRentCond,specialServiceChk,specialRentChk">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doClearRentalDetail" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					
					<rich:panel id="pnlRentDetailResult" styleClass="sem_autoScrollbar_5Rows">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.dataFrmList']}" style="width: 1400"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbRentDetail" cellpadding="1" cellspacing="0" border="0" 
							var="rentDetail"  value="#{semmrt001Bean.rentDetailList}" reRender="dtbRentDetail" 
							rows="#{semmrt001Bean.rowPerPage}" 
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<!-- begin column -->
							<rich:column width="5%" rendered="#{!semmrt001Bean.viewMode}">
								<f:facet name="header">
									<h:outputText value="Edit" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
										action="#{navAction.navi}"
										reRender="pnlRentalDetail,dtbRentCond,frmServiceCalSaveDialog,servicePercent" title="edit" 
										id="btnEdit">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="getRentalDetailById" />
										<a4j:actionparam name="rowId" value="#{rentDetail.rowId}"/>
										<a4j:actionparam name="amtPerYear" value="#{rentDetail.amtPerYear}"/>
										<a4j:actionparam name="amtPerMonth" value="#{rentDetail.amtPerMonth}"/>
										<a4j:actionparam name="amtOneTime" value="#{rentDetail.amtOneTime}"/>
										<a4j:actionparam name="cntVendor" value="#{rentDetail.cntVendor}"/>
										<a4j:actionparam name="mode" value="EDIT"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column width="5%" rendered="#{!semmrt001Bean.viewMode}">
								<f:facet name="header">
									<h:outputText value="Delete" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15;" 
     									   title="delete" id="btnDelelte">
										<a4j:actionparam name="navModule" value="rt" />
		            					<a4j:actionparam name="navProgram" value="SEMMRT001-2" />	
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="getRentalDetailById" />
										<a4j:actionparam name="rowId" value="#{rentDetail.rowId}"/>
										<a4j:actionparam name="mode" value="DELETE"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column width="5%" rendered="#{semmrt001Bean.viewMode}">
								<f:facet name="header">
									<h:outputText value="View" style="width: 40"/>
								</f:facet>
								<div align="center">
									<a4j:commandButton image="images/view.png" style="height: 15; width: 15;" 
										action="#{navAction.navi}"
										reRender="pnlRentalDetail,dtbRentCond" title="view" 
										id="btnView">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="getRentalDetailById" />
										<a4j:actionparam name="rowId" value="#{rentDetail.rowId}"/>
										<a4j:actionparam name="mode" value="EDIT"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseName']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.expenseTypeName}" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expenseDesc']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.expenseDesc}" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Service" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.serviceName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentDetail.vendorName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.altPayee']}" style="width: 60"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentDetail.payeeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtType']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentDetail.whtTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.taxRate']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.whtRate}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.vatRate}"/>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodType']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.payPeriodTypeAName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentDetail.periodAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodStDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.periodStartDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodEndDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.periodEndDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" 
										style="width: 250px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentDetail.remark}">
									</h:outputText>
									
									
									<h:inputHidden value="#{rentDetail.amtPerYear}"/>
									<h:inputHidden value="#{rentDetail.amtPerMonth}"/>
									<h:inputHidden value="#{rentDetail.amtOneTime}"/>
									<h:inputHidden value="#{rentDetail.cntVendor}"/>									
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.rentalCalculateType']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.serviceCalType}">
									</h:outputText>
								</div>
							</rich:column>

							
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentDetail" 
									maxPages="10" id="dstRentDetail" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					<rich:spacer height="10px"></rich:spacer>
					<rich:panel id="pnlHistory" styleClass="sem_autoScrollbar_5Rows">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.history']}"/>
						</f:facet>
						
						<rich:dataTable id="dtbRentHist" cellpadding="1" cellspacing="0" border="0" 
							var="rentHist"  value="#{semmrt001Bean.rentHistList}" reRender="dtbRentHist" 
							rows="#{semmrt001Bean.rowPerPage}" 
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseName']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.expenseTypeName}" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.expenseDesc']}" style="width: 150"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.expenseDesc}" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="Service" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.serviceName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 150"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentHist.vendorName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.altPayee']}" style="width: 60"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentHist.payeeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtType']}" style="width: 100"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentHist.whtTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.taxRate']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.whtRate}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 80"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 6"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.vatRate}"/>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodType']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.payPeriodTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.payPeriodAmt']}" style="width: 50px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentHist.periodAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodStDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.periodStartDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodEndDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.periodEndDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" 
										style="width: 250px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentHist.remark}">
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentHist" 
									maxPages="10" id="dstRentHist" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
					</rich:panel>
						
					<rich:panel id="pnlLog">
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
		                				<h:inputText id="txtCreateBy" value="#{semmrt001Bean.displayFrmRental.createBy}" 
		                					readonly="true" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldCreateDate" locale="th" 
											datePattern="dd/MM/yyyy HH:mm:ss" 
										    value="#{semmrt001Bean.displayFrmRental.createDt}"
										    inputSize="20" 
										    cellWidth="20px" cellHeight="20px" 
										    buttonIcon="/images/hide-button.png"
										    buttonIconDisabled="/images/hide-button.png"
										    disabled="true" />
									</td>
			                	 </tr><tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.updateBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
			                			<h:inputText id="txtUpdateBy" value="#{semmrt001Bean.displayFrmRental.updateBy}" 
			                				readonly="true" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldUpdateDate" locale="th" 
											datePattern="dd/MM/yyyy HH:mm:ss" 
										    value="#{semmrt001Bean.displayFrmRental.updateDt}"
										    showWeeksBar="false" 
										    inputSize="20" 
										    cellWidth="20px" cellHeight="20px" 
										    buttonIcon="/images/hide-button.png"
										    buttonIconDisabled="/images/hide-button.png"
										    disabled="true" />
				                	</td>
			                	 </tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
				</h:panelGroup>
				</h:panelGrid>
				
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

<rich:modalPanel id="mdpConfirmDelDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Delete"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmDelDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="170px">
						<h:outputText value="#{semmrt001Bean.msgDoDelete}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="dtbRentDetail,pnlRentDetailResult,pnlRentalDetail,pnlSearchResult,dtbRentCond,specialServiceChk,specialRentChk" >
							<a4j:actionparam name="navModule" value="rt" />
		            		<a4j:actionparam name="navProgram" value="SEMMRT001-2" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteRentalDetail" />							
							<rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmDelDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpConfirmSaveDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="Confirm Save"></h:outputText>
    </f:facet>
	<a4j:form id="frmConfirmSaveDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="190px">
						<h:outputText value="#{semmrt001Bean.txtSavePending}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="pnlRental,frmAddRental,pnlLog,frmWarningSaveDialog" >
							<a4j:actionparam name="navModule" value="rt" />
		            		<a4j:actionparam name="navProgram" value="SEMMRT001-2" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateRentalMaster" />							
							<rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpConfirmSaveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="mdpWarningSaveDialog" autosized="true">	
	<f:facet name="header">
    	<h:outputText value="WARNING"></h:outputText>
    </f:facet>
	<a4j:form id="frmWarningSaveDialog">
		<table width="200px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="1" styleClass="contentlabelform" width="190px">
						<h:outputText value="#{semmrt001Bean.txtWarning}" styleClass="ms7" />
					</h:panelGrid></td></tr><tr><td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
						<a4j:commandButton value="Yes" styleClass="rich-button" action="#{navAction.navi}" immediate="true" 
							reRender="dtbRentDetail,pnlRentDetailResult,pnlRentalDetail,pnlSearchResult,dtbRentCond" >
							<a4j:actionparam name="navModule" value="rt" />
		            		<a4j:actionparam name="navProgram" value="SEMMRT001-2" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
							<a4j:actionparam name="methodWithNavi" value="doUpdateAfterWarning" />							
							<rich:componentControl for="mdpWarningSaveDialog" operation="hide" event="onclick"  />
						</a4j:commandButton>												
						<a4j:commandButton value="No" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="mdpWarningSaveDialog" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
		</table>	
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="serviceCalDialog" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['label.rentalCalculateType']}"></h:outputText>
    </f:facet>
	<a4j:form id="frmServiceCalSaveDialog">
		<table width="350px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
					<h:outputText value="#{jspMsg['link.rentalCalculate']}" styleClass="ms7" />
				<h:selectOneMenu id="serviceTypeId" value="#{semmrt001Bean.serviceCalTypeIdToCal}" 
                      onchange="doChangeValue();">     
                    <f:selectItems value="#{semmrt001Bean.serviceTypeToCalList}"/>
                </h:selectOneMenu> 
                
         <a4j:jsFunction name="doChangeValue" action="#{semmrt001Action.doChangeValue}" reRender="frmServiceCalSaveDialog,servicePercent,massage" >
         </a4j:jsFunction>
					<rich:dataTable id="servicePercent" value="#{semmrt001Bean.serviceNameListShowTbl}"
						var="serviceTbl" rows="5" border="2">
						<rich:column width="100" rendered="#{semmrt001Bean.serviceCalTypeIdToCal eq '02' || semmrt001Bean.serviceCalTypeIdToCal eq '03' || semmrt001Bean.serviceCalTypeIdToCal eq '04'}">					
							<h:outputText value="#{serviceTbl.serviceName}" styleClass="ms7" />
						</rich:column>				
						<h:inputText value="#{serviceTbl.inputPercent}"></h:inputText>
						<rich:column width="80" rendered="#{semmrt001Bean.serviceCalTypeIdToCal eq '02'}"  >
							<h:inputText id="inputPercent" value="#{serviceTbl.inputPercent}"   maxlength="3" 
								styleClass="ms7"  onblur="test();"/><h:outputText value="%" styleClass="ms7"  />
								<a4j:jsFunction name="test" reRender="frmServiceCalSaveDialog,servicePercent"> </a4j:jsFunction>
								
						</rich:column>
						<rich:column width="80" rendered="#{semmrt001Bean.serviceCalTypeIdToCal eq '03'}" >
							<h:inputText value="#{serviceTbl.inputAmt}" id="inputAmout"
								styleClass="ms7" onblur="test();"/>
								<a4j:jsFunction name="test" reRender="frmServiceCalSaveDialog,servicePercent"> </a4j:jsFunction>
						</rich:column>	
						<rich:column width="80" rendered="#{semmrt001Bean.serviceCalTypeIdToCal eq '04'}" >
							<h:inputText value="#{serviceTbl.configRate}" styleClass="ms7" disabled="true" />
						</rich:column>				
					</rich:dataTable>	
					
								
						<a4j:commandButton value="Ok" styleClass="rich-button" action="#{semmrt001Action.doSaveServiceCal}" immediate="true" 
							reRender="frmServiceCalSaveDialog,showCalType,massage" oncomplete="if(#{semmrt001Bean.vMessage eq null})#{rich:component('serviceCalDialog')}.hide();">
							
						</a4j:commandButton>
					
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="serviceCalDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
			
			<h:outputText id="massage" value="#{semmrt001Bean.vMessage}" rendered="#{semmrt001Bean.vMessage ne null}" styleClass="ms8red"  />
			
		</table>
	</a4j:form>
</rich:modalPanel>

<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>