<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel009" var="jspMsg" />
<h:panelGrid width="100%">
	<rich:panel id="pnlSearchOutstanding">
		<f:facet name="header">
			<h:outputText value="#{jspMsg['header.name']}" />
		</f:facet>
		<h:panelGrid>
			<a4j:form id="frmError">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
			</a4j:form>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
			<!-- Search  -->
			<a4j:form id="frmSearch">
				<!-- begin content layout criteria -->
				<h:panelGrid width="95%">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria']}" />
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<!-- first row -->
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" valign="bottom" width="20%"><h:graphicImage value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" /></td>
										<td width="30%">
											<h:selectOneMenu value="#{semmel009Bean.criteria.company}" onchange="GetCompanyJS();" style="width : 160px">
												<f:selectItems value="#{semmel009Bean.companyList}" />
											</h:selectOneMenu>
											<a4j:jsFunction name="GetCompanyJS" reRender="pnlSearchCriteria" /> <rich:spacer width="10"></rich:spacer>
											<h:outputText id="companyDisplay" value="#{semmel009Bean.criteria.company}" styleClass="ms28" />
										</td>
										<td align="right" ><h:graphicImage value="images/icon_required.gif" /><rich:spacer width="5" />
										<h:outputText value="#{jspMsg['label.region']}"	styleClass="ms7" /></td>
										<td>
											<h:selectOneMenu value="#{semmel009Bean.criteria.regionTxt}" style="width : 160px">
												<f:selectItems value="#{semmel009Bean.regionList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.contractNo']}"	styleClass="ms7" /></td>
										<td>
											<h:inputText value="#{semmel009Bean.criteria.contractNo}" ></h:inputText>
										</td>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.siteName']} : " styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText value="#{semmel009Bean.criteria.siteName}" ></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right">
										<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
										<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.meterId']}" styleClass="ms7" /></td>
										<td>
											<h:inputText value="#{semmel009Bean.criteria.meterId}"></h:inputText>
										</td>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlelectricUseType" value="#{semmel009Bean.criteria.electricUseType}" style="width : 160px">
												<f:selectItems value="#{semmel009Bean.electricUseTypeList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.locationId']}" styleClass="ms7" /></td>
										<td>
											<h:inputText value="#{semmel009Bean.criteria.locationId}"></h:inputText>
										</td>
										<td align="right" width="20%">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer><h:outputText value="#{jspMsg['label.locationCode']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:inputText value="#{semmel009Bean.criteria.locationCode}"></h:inputText>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.fromTermOfPaymentDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="termOfPaymentDtFrom" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmel009Bean.criteria.termOfPaymentDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px">
											</rich:calendar> 
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.toTermOfPaymentDt']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<rich:calendar id="termOfPaymentDtTo" locale="th" enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmel009Bean.criteria.termOfPaymentDtTo}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px">
											</rich:calendar>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.accureStatus']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlAccureStatus" value="#{semmel009Bean.criteria.accureStatus}" style="width : 160px">
												<f:selectItems value="#{semmel009Bean.accureStatusList}" />
											</h:selectOneMenu>								
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.siteType']}" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlSiteType" value="#{semmel009Bean.criteria.siteTypeCri}" style="width : 160px">
												<f:selectItems value="#{semmel009Bean.siteTypeList}" />
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right" width="20%">
											
										</td>
										<td width="30%">
											<h:selectBooleanCheckbox value="#{semmel009Bean.criteria.chkPico}" >
											</h:selectBooleanCheckbox>
											
											<rich:spacer width="5"></rich:spacer>
											
											<h:outputText value="PICO" styleClass="ms7"></h:outputText>							
										</td>
										<td align="right" width="20%">
											
										</td>
										<td width="30%">
											
										</td>
									</tr>
								</table>
							</h:panelGroup>
							<h:panelGrid columns="4" id="grdSearchCommand">
								<a4j:commandButton id="btnSearch" value="Search"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="pnlSearchCriteria,frmError,frmSearch,pnlSearchCriteria,pnlSearchResult">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
									<a4j:actionparam name="methodWithNavi" value="doSearch" />
								</a4j:commandButton>
								<a4j:commandButton id="btnClear" value="Clear"
									styleClass="rich-button" action="#{navAction.navi}"
									reRender="pnlSearchCriteria,frmError,pnlSearchCriteria,pnlSearchResult,grdAccure,btnReturnAccure,btnClearAccure">
									<a4j:actionparam name="navModule" value="el" />
									<a4j:actionparam name="navProgram" value="SEMMEL009" />
									<a4j:actionparam name="moduleWithNavi" value="el" />
									<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
									<a4j:actionparam name="methodWithNavi" value="doClear" />
								</a4j:commandButton>
							</h:panelGrid>
							<!-- end content criteria -->
						</h:panelGrid>
					</rich:panel>
					
					<h:panelGrid id="accurePanel">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td>
									<h:panelGrid columns="4" id="grdAccure">
										<h:panelGroup>
											<a4j:commandButton id="btnClearAccure" value="#{jspMsg['btn.label.clearAccure']}"
												styleClass="rich-button" action="#{navAction.navi}" disabled="#{semmel009Bean.disableBtn}"
												reRender="pnlSearchCriteria,frmError,frmSearch,pnlSearchCriteria,pnlSearchResult,dtboutstanding,btnClearAccure,btnReturnAccure">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
												<a4j:actionparam name="methodWithNavi" value="doClearAccure" />
											</a4j:commandButton>
											<rich:spacer width="5"></rich:spacer>
											<a4j:commandButton id="btnReturnAccure" value="#{jspMsg['btn.label.return']}"
												styleClass="rich-button" action="#{navAction.navi}" disabled="#{semmel009Bean.disableBtn}"
												reRender="pnlSearchCriteria,frmError,frmSearch,pnlSearchCriteria,pnlSearchResult,dtboutstanding,btnReturnAccure,btnClearAccure">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL009" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
												<a4j:actionparam name="methodWithNavi" value="doReturnAccure" />
											</a4j:commandButton>
										</h:panelGroup>
										
										<rich:spacer width="10"></rich:spacer>
										
										<h:panelGroup>
											<a4j:commandButton id="btnExport" value="#{jspMsg['btn.export']}"
												styleClass="rich-button" action="#{navAction.navi}" disabled="#{semmel009Bean.disableBtn}"
												reRender="pnlShowExportExcel">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
												<a4j:actionparam name="methodWithNavi" value="initExportExcel" />
											</a4j:commandButton>
											
											<rich:spacer width="5"></rich:spacer>
											
											<a4j:commandButton id="btnSendSms" value="#{jspMsg['btn.sendSms']}"
												styleClass="rich-button" action="#{navAction.navi}" disabled="#{semmel009Bean.disableBtn}"
												reRender="pnlSearchOutstanding">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
												<a4j:actionparam name="methodWithNavi" value="doSendSMS" />
											</a4j:commandButton>
											
											<rich:spacer width="5"></rich:spacer>
											
											<a4j:commandButton id="btnSendEmail" value="#{jspMsg['btn.sendEmail']}"
												styleClass="rich-button" action="#{navAction.navi}" disabled="#{semmel009Bean.disableBtn}"
												reRender="pnlSearchOutstanding">
												<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL009" />
												<a4j:actionparam name="methodWithNavi" value="doSendEmail" />
											</a4j:commandButton>
										</h:panelGroup>
										
									</h:panelGrid>
								</td>
							</tr>	
						</table>
					
					
					</h:panelGroup>
				</h:panelGrid>
				</h:panelGrid>
				
				
				<!-- end content layout criteria -->
				
				<h:panelGrid id="pnlShowExportExcel" style="height:0px;width:0px;" width="0px" columns="0" >
					<h:panelGroup id="pnlInShowExportExcel" rendered="#{semmel009Bean.displayExportExcel}" style="height:0px;width:0px;" >
						<h:commandButton value="Report" id="bthShowExportExcel" style="height:0px;width:0px;display:none;" action="#{semmel009Action.doExportExcel}" />								
						<script>document.getElementById('incContent:frmSearch:bthShowExportExcel').click();</script>
					</h:panelGroup>							
				</h:panelGrid>	
			</a4j:form>
			
			<!-- Start  Search Result  -->
			<a4j:form id="frmResult">
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 95%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{semmel009Bean.headerSearchResult}" style="width: 2300"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmel009Bean.msgDataNotFound}" rendered="#{semmel009Bean.renderedMsgDataNotFound}" />
						</div>
						<!-- begin dataTable -->
						<rich:dataTable id="dtboutstanding" width="100%" cellpadding="1"
							cellspacing="0" border="0" var="outstanding" value="#{semmel009Bean.resultList}" reRender="dtboutstanding"
							rows="#{semmel009Bean.rowPerPage}" rowClasses="cur"	styleClass="dataTable" rowKeyVar="rowIndex">
							<!-- begin column -->
							<rich:column>
								<f:facet name="header">
									<h:selectBooleanCheckbox value="#{semmel009Bean.chkSelAll}" style="width: 20px">
										<a4j:support event="onclick" action="#{semmel009Action.selectAllRow}" 
										reRender="pnlSearchResult,grdAccure,btnClearAccure,btnReturnAccure,btnExport,btnSendSms,btnSendEmail"/>
									</h:selectBooleanCheckbox>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="checkSelected" value="#{outstanding.selected}" >
										<a4j:support event="onclick" action="#{semmel009Action.onRenderExportButton}" 
										reRender="accurePanel,btnClearAccure,btnReturnAccure,btnExport,btnSendSms,btnSendEmail">
											<a4j:actionparam name="rowId" value="#{outstanding.rowId}" />
										</a4j:support>
										
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									
								</f:facet>
								<div align="center">
									<a4j:commandButton value="#{jspMsg['btn.savePayment']}" 
									oncomplete="#{rich:component('alertMessage')}.show(); return false" 
									action="#{semmel009Action.doOpenAlertMessage}" reRender="alertMessage" 
									styleClass="rich-button" title="edit"
									style="width:67px;padding-left:3px;">
										<a4j:actionparam name="msgFor" value="EDIT" />
										<a4j:actionparam name="expenseType" value="#{outstanding.expenseType}" />
										<a4j:actionparam name="paymentId" value="#{outstanding.paymentId}" />
										<a4j:actionparam name="electricUseType" value="#{outstanding.electricUseType}" />
										<a4j:actionparam name="specialFlag" value="#{outstanding.specialFlag}" />
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.contractNo}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractNo']}" />
								</f:facet>
								<div align="center">
									
								 	<a4j:commandLink id="hlkViewPopupSiteInfo" value="#{outstanding.contractNo}" 
									oncomplete="showViewSiteInfoPopup()"
									action="#{navAction.navi}" >
										<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL009-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{outstanding.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.company}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.company']}" 
									/>
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.company}" 
								 style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.siteName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.siteName']}" 
									/>
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.siteName}" 
								 style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.effectiveDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.effDate']}"/>
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.effectiveDtDisplay}" 
								 style="width : 100px">
								 <f:convertDateTime pattern="dd/MM/yyyy"/>
								 </h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.expireDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expDate']}"/>
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.expireDtDisplay}" 
								 style="width : 100px">
								 <f:convertDateTime pattern="dd/MM/yyyy"/>
								 </h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.region.rowId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.region']}"	
									/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.region.rowId}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.locationId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationId']}"	
									/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.locationId}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.locationCode}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.locationCode']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.locationCode}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.service}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.service']}" 
									 />
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.service}" 
								 style="width : 150px" />
								 </div>
							</rich:column>
							<rich:column sortBy="#{outstanding.electricUseTypeDisplay}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.electricUseType']}" 
									 />
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.electricUseTypeDisplay}" 
								 style="width : 150px" />
								 </div>
							</rich:column>
							<rich:column sortBy="#{outstanding.meterId}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.meterId']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.meterId}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.contractStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.contractStatus']}"  />
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.contractStatus}" />
								 </div>
							</rich:column>
							<rich:column sortBy="#{outstanding.networkStatus}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.networkStatus']}" 
									 />
								</f:facet>
								<div align="center">
								<h:outputText value="#{outstanding.networkStatus}" 
								 style="width : 150px" />
								 </div>
							</rich:column>
							<rich:column sortBy="#{outstanding.accureStatusName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.accureStatus']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.accureStatusName}" 
								style="width : 100px" />
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.termOfPaymentDt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.term.of.payment.dt']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.termOfPaymentDtDisplay}" 
								style="width : 100px" >
								<f:convertDateTime pattern="dd/MM/yyyy"/>
								</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.amount}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodAmt']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.amount}" 
								style="width : 100px" >
								<f:convertNumber pattern="#,##0.00"/>
								</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{outstanding.emailFlag}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.email']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.emailFlag}" 
								style="width : 100px" >
								</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{outstanding.smsFlag}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.sms']}"/>
								</f:facet>
								<div align="center"">
								<h:outputText value="#{outstanding.smsFlag}" 
								style="width : 100px" >
								</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.paymentHistory']}"/>
								</f:facet>
								<div align="center">
								<a4j:commandButton id="viewHistoryId"  oncomplete="#{rich:component('popupSearchHistory')}.show(); return false"
										value="View" styleClass="rich-button"  reRender="popupFrmError,pnlSearchResult,popupSearchHistory"
					            		action="#{navAction.navi}" style="width:80px;">
					            		<a4j:actionparam name="navModule" value="el" />
										<a4j:actionparam name="navProgram" value="SEMMEL009" />
										<a4j:actionparam name="moduleWithNavi" value="el" />	
										<a4j:actionparam name="actionWithNavi" value="SEMMEL009"/>									
										<a4j:actionparam name="methodWithNavi" value="initPopupSearchHistory" />
										<a4j:actionparam name="contractNo" value="#{outstanding.contractNo}" />
			            				</a4j:commandButton>
								</div>
							</rich:column>
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="4">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmel009Bean.resultList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="17">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtboutstanding"
											maxPages="10"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstdtboutstanding" 
											style="background-color: #cccccc;"
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
			<!-- End Search Result -->
		</h:panelGrid>
	</rich:panel>
	<jsp:include page="../../pages/el/semmel009-popupSearchHistory.jsp" />
</h:panelGrid>
<!-- +++++++++++ modal popup ++++++++++++ -->
<rich:modalPanel id="mdpDetail" autosized="true"  width="700">
	<f:facet name="header">
		<h:outputText value="#{jspMsg['popup.unpaylist']}"></h:outputText>
	</f:facet>
	<a4j:form id="frmExpandFlagDialog">
		<rich:dataTable id="dtboutstanding" width="100%" cellpadding="1"
			cellspacing="0" border="0" var="meterInstallment"
			value="#{semmel009Bean.meterInstallmentList}"
			reRender="dtboutstanding" rows="10"
			rowClasses="cur" styleClass="dataTable" rowKeyVar="rowIndex">
			<!-- begin column -->
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.electricUseType']}"  />
				</f:facet>
				<div align="left">
				<h:outputText value="#{meterInstallment.electricUseTypeDisplay}" style="width : 200px" /></div>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.contractNo']}"  />
				</f:facet>
				<div align="left">
					<a4j:commandLink id="btnDoc" style="width : 120px"
						value="#{meterInstallment.contractNo}"
						action="#{navAction.navi}" reRender="mdpDetail"
						oncomplete="#{rich:component('mdpDetail')}.show(); return false">
					</a4j:commandLink>
				</div>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.siteName']}" />
				</f:facet>
				<div align="left"><h:outputText value="#{meterInstallment.siteName}"
				style="width : 200px" /></div>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.meterId']}" />
				</f:facet>
				<div align="left">
				<h:outputText value="#{meterInstallment.meterId}"
				style="width : 120px"/>
				</div>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.refMeterId']}" />
				</f:facet>
				<div align="left"><h:outputText value="#{meterInstallment.referMeterId}" 
				style="width : 120px"/></div>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.term.of.payment.dt']}"  />
				</f:facet>
				<div align="center">
					<h:outputText value="#{meterInstallment.termOfPaymentDtStr}" 
					style="width : 120px"/>
					
				</div>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="#{jspMsg['column.header.periodAmt']}"  />
				</f:facet>
				<div align="right">
					<h:outputText value="#{meterInstallment.accureAmt}" 
					style="width : 120px">
						<f:convertNumber type="number" pattern="#,##0.00"  />
					</h:outputText>
				</div>
			</rich:column>
			<!-- end column -->
			<f:facet name="footer">
				<rich:datascroller immediate="true" rendered="true" align="center"
					for="dtboutstanding" maxPages="10" id="dstdtboutstanding"
					selectedStyleClass="selectScroll" />
			</f:facet>
		</rich:dataTable>
		<table>
			<tr>
				<td align="left">
				<a4j:commandButton value="Close"
					styleClass="rich-button" immediate="true">
					<rich:componentControl for="mdpDetail" operation="hide"
						event="onclick" />
				</a4j:commandButton></td>
			</tr>
		</table>
	</a4j:form>
</rich:modalPanel>

<rich:modalPanel id="alertMessage" width="300" autosized="true">
    
    <f:facet name="header">
    	<h:outputText value="#{jspMsg['msg.header.alert']}" styleClass="ms7"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmAlert">
	
		<table border="0" cellspacing="" cellpadding="2">
			<tr>
				<td>
					<h:outputText value="#{semmel009Bean.message}" styleClass="ms7"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<!-- for edit button -->
					
					
					<!--  DEPOSIT AND (ELECTRIC_TYPE_MEA OR ELECTRIC_TYPE_PEA) -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{navAction.navi}" reRender="oppContent" 
					rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForDepositMeaPea}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="7"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- ELECTRIC_TYPE_PRIVATE AND PAYMENT_SPECIAL_FLAG_Y is Y -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForDepositPrivate}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="9"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- ELECTRIC_TYPE_PRIVATE -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForDepositPrivate10}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-10" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="10"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- ALL FEE -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForFee}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="12"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- EL_BIL	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForElBill}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doEditFromMenu8"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- EL_POSTPAID or EL_DEBIT	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForElPostPaid}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initialEdit3"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="actionFrom" value="SEMMEL009-1"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- EL_TEMP	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" 
					styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForElTemp}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initailEdit4"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- PR_POSTPAID or PR_DEBIT	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForPrPostPaid}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initailEdit5"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- PR_PREPAID	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForPrPrePaid}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initialEdit6"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					
					<!-- EL_CREDIT or PR_CREDIT -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{navAction.navi}" reRender="oppContent" 
					rendered="#{semmel009Bean.visibleEditYesBtn && semmel009Bean.visibleEditYesBtnForCredit}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initialEditPage7"/>
						<a4j:actionparam name="targetPayment" value="#{semmel009Bean.targetPaymentId}"/>
						<a4j:actionparam name="outstandingFlag" value="Y"/>
					</a4j:commandButton>
					<rich:spacer width="5" rendered="#{semmel009Bean.visibleEditYesBtn}"/>
					
					<!-- for cancel payment button -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{semmel009Action.doSaveCancelPayment}" 
					reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult,alertMessage" 
					rendered="#{semmel009Bean.visibleCancelPaymentYesBtn}">
						<rich:componentControl for="alertMessage" operation="hide" event="onComplete" />
					</a4j:commandButton>
					
					<rich:spacer width="5" rendered="#{semmel009Bean.visibleCancelPaymentYesBtn}"/>
					
					<!-- for export -->
					
					
					<!-- close dialog -->
					<a4j:commandButton value="#{jspMsg['btn.no']}" styleClass="rich-button" 
					reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult" rendered="#{semmel009Bean.visibleNoBtn}">
						<rich:componentControl for="alertMessage" operation="hide" event="onclick" />
					</a4j:commandButton>
					<rich:spacer width="5" rendered="#{semmel009Bean.visibleNoBtn}"/>
					
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>