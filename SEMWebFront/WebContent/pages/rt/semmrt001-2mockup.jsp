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
										<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '05' && semmrt001Bean.displayFrmRental.reqType != '99'}">
											<td width="13%" align="left">
												<a4j:commandLink value="#{jspMsg['link.rentalAndService']}" action="#{navAction.navi}" 
													reRender="oppContent">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="mode" value="RENTAL" />
													<a4j:actionparam name="param1" value="" />
												</a4j:commandLink>
											</td>
											<td width="7%" align="left">
												<a4j:commandLink value="#{jspMsg['link.bail']}" action="#{navAction.navi}" 
													reRender="oppContent">
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
													reRender="oppContent">
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
													reRender="oppContent">
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
												<a4j:commandLink value="#{jspMsg['link.expenseSend']}" >
												</a4j:commandLink>
											</td>
											</h:panelGroup>
											<td width="13%" align="left">
												<a4j:commandLink value="#{jspMsg['link.rentalAndService']} Mock Up" >
												</a4j:commandLink>
											</td>
											<td width="70%" align="right">
												<a4j:commandLink value="#{jspMsg['link.detailStation']}" 
													oncomplete="showViewSiteInfoPopup()"
									           		action="#{navAction.navi}" style="width:100">
									           		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="common" />
													<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
													<a4j:actionparam name="methodWithNavi" value="initPopup" />
													<a4j:actionparam name="rowId" value="#{semmrt001Bean.displayFrmRental.siteInfoId}" />
												</a4j:commandLink>
											</td>
											</h:panelGroup>
											<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType == '05' || semmrt001Bean.displayFrmRental.reqType == '99'}">
											<td align="right">
												<a4j:commandLink value="#{jspMsg['link.detailStation']}" 
													oncomplete="showViewSiteInfoPopup()"
									           		action="#{navAction.navi}" style="width:100">
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
							                        	<h:outputText value="Entered Data Status:"></h:outputText>
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
										<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
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
										<h:inputText id="txtReqType" value="#{semmrt001Bean.displayFrmRental.reqTypeName}" 
											disabled="true"></h:inputText>
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
											disabled="#{(semmrt001Bean.disApprove || (semmrt001Bean.displayFrmRental.reqType != '05' && semmrt001Bean.displayFrmRental.reqType != '99')) || semmrt001Bean.viewMode}">
											<f:selectItems value="#{semmrt001Bean.rentalStatusList}"/>
										</h:selectOneMenu>
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
									<td colspan="3"></td>
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
				<h:panelGroup rendered="#{semmrt001Bean.displayFrmRental.reqType != '05' && semmrt001Bean.displayFrmRental.reqType != '99'}">		
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
										disabled="#{rentCond.disSelect}">
										<a4j:support event="onclick" reRender="pnlRentalDetail,frmAddRental,dtbRentCond" 
											action="#{semmrt001Action.doSelectedRentSetup}">
											<a4j:actionparam name="siteRentCondId" value="#{rentCond.siteRentCondId}"/>
											<a4j:actionparam name="siteInfoId" value="#{rentCond.siteInfoId}"/>
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCond.expenseTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseName']}" style="width: 88"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentCond.expenseTypeName}"></h:outputText>
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
									<h:outputText value="#{rentCond.effectiveDtTh}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
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
					<rich:simpleTogglePanel id="pnlSpecialService"  switchType="client" label="#{jspMsg['header.resultTable.nameSpecial']}" opened="true" width="100%">
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" valign="top" width="30%">
											<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
										</td>
										<td width="70%" colspan="2">
											<h:inputTextarea rows="4" cols="100" disabled="true"
												value="#{semmrt001Bean.rentCondSpecial.detail}">
											</h:inputTextarea>
										</td>
									</tr>
									<tr>
										<td align="right" width="30%">
											<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
										</td>
										<td width="48%">
											<h:selectOneRadio id="rbtSpecialWhtType2" styleClass="ms7" layout="lineDirection" 
												value="#{semmrt001Bean.rentCondSpecial.whtType}" 
												disabled="true">
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
									            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
									            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
											</h:selectOneRadio>
										</td>
										<td width="22%">
						                	<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7" /><h:inputText 
						                		disabled="true" 
												size="5" value="#{semmrt001Bean.rentCondSpecial.whtRate}"/><h:outputText 
												value="#{jspMsg['label.percent']}" styleClass="ms7"/>
					                	</td>
									</tr>
									<tr>
										<td align="right" width="30%">
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
										</td>
										<td width="70%" colspan="2">
											<h:selectOneRadio id="rbtSpecialVatType2" styleClass="ms7" 
												value="#{semmrt001Bean.rentCondSpecial.vatType}" 
												disabled="true">
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
									            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
									            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
											</h:selectOneRadio>
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
				                	<td align="right" width="30%">
				                		<h:outputText value="#{jspMsg['label.effDate']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
				                		<rich:calendar id="cldEffDate" locale="en/US" enableManualInput="true" 
											datePattern="dd/MM/yyyy" showWeeksBar="false" inputSize="13" 
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											value="#{semmrt001Bean.rentDetail.effectiveDt}" 
											/>
										<rich:spacer width="10" />
										<h:outputText value="-" />
										<rich:spacer width="10" />
										<rich:calendar id="cldExpDate" locale="en/US" enableManualInput="true" 
											datePattern="dd/MM/yyyy" showWeeksBar="false" inputSize="13" 
											oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);" 
											value="#{semmrt001Bean.rentDetail.expiredDt}" 
											/>
				                	</td>
				                </tr>
				                </h:panelGroup>
								<tr>
									<td align="right" width="30%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
			                		<td width="70%" colspan="2">
										<h:selectOneMenu id="ddlExpenseType" value="#{semmrt001Bean.rentDetail.expenseType}" 
											disabled="#{semmrt001Bean.viewMode}"
											onchange="onChangeDdlExpenseTypeJS();">
											<a4j:jsFunction name="onChangeDdlExpenseTypeJS" reRender="txtWhtRate,txtVatRate,pnlRentalDetail,rbtVatType,btnAdd" 
												action="#{semmrt001Action.onChangeDdlExpenseType}"/> 
											<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
										</h:selectOneMenu>
					                </td>
				                </tr>
				                <tr>
				                	<td align="right" width="30%" valign="top">
				                		<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="30%" valign="top">
										<h:selectOneRadio id="rbtWhtType" styleClass="ms7" layout="pageDirection" 
											value="#{semmrt001Bean.rentDetail.whtType}">
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
										</h:selectOneRadio>
					                </td>	
					                <td width="40%" valign="top">
					                <a4j:region>
										<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7"/>
										<h:inputText id="txtWhtRate" disabled="#{!semmrt001Bean.disWhtRate}" 
											value="#{semmrt001Bean.rentDetail.whtRate}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="onblurVatTypeJS();return numberformat.moneyFormat(this);"
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
				                <h:panelGroup rendered="#{semmrt001Bean.rentDetail.expenseType != '01'}">
				                <tr>
				                	<td align="right" width="30%">
				                		<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="30%">
										<h:selectOneRadio id="rbtVatType" styleClass="ms7" 
											value="#{semmrt001Bean.rentDetail.vatType}" 
											disabled="#{semmrt001Bean.viewMode}">
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
										</h:selectOneRadio>
					                </td>
					                <td width="40%">
					                	<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7" />
					                	<h:inputText id="txtVatRate" disabled="true" 
											size="5" value="#{semmrt001Bean.rentDetail.vatRate}"/>
										<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
					                </td>
				                </tr>
				                </h:panelGroup>
				                <tr>
				                	<td align="right" width="30%">
				                		<h:outputText value="#{jspMsg['label.amt']}" styleClass="ms7">
				                		</h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
				                		<h:inputText id="txtSpecialAmt" value="#{semmrt001Bean.rentDetail.rentalAmt}" 
				                			disabled="#{semmrt001Bean.viewMode}" 
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" 
		                					styleClass="inputRight">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                		<rich:spacer width="7"/>
				                		<h:outputText value="#{jspMsg['label.bath']} / " styleClass="ms7"/>
				                		<rich:spacer width="10"/>
				                		<h:selectOneMenu id="ddlPeriodType" value="#{semmrt001Bean.rentDetail.rentPeriodType}" 
											disabled="#{semmrt001Bean.viewMode}">
											<f:selectItems value="#{semmrt001Bean.periodTypeList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="30%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
				                	<!-- begin radio custom -->
				                	<a4j:region>
				                		<table width="85%" cellpadding="0" cellspacing="0">
				                			<tr>
				                				<td width="235px">
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
											            <f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']}" />
													</h:selectOneRadio>
				                				</td>
				                				<td width="49px" align="left">
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
				                				<td width="75px" align="left">
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
				                				<td width="49px">
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
				                				<td align="left" width="80px">
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
				                	<td align="right" width="30%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodStDt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
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
											value="images/icon_required.gif"/><rich:spacer width="5"></rich:spacer><h:outputText 
											value="#{jspMsg['label.periodEndDt']}" styleClass="ms7"></h:outputText><rich:spacer 
											width="5"></rich:spacer>
										<rich:calendar id="cldPeriodEndDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt001Bean.rentDetail.periodEndDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   oninputblur="validateRichCalendarFromTo('frmAddRental','cldPeriodStDt','cldPeriodEndDt');"
											   	   oncollapse="validateRichCalendarFromTo('frmAddRental','cldPeriodStDt','cldPeriodEndDt');"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.periodEndDt']}" 
											   	   disabled="#{semmrt001Bean.viewMode}">
										</rich:calendar>
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
				                	<td align="right" width="30%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.totPeriodNo']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
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
				                	<td align="right" width="30%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodAmt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
				                		<h:inputText id="txtPeriodAmt" value="#{semmrt001Bean.rentDetail.periodAmt}" 
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" 
		                					styleClass="inputRight" 
		                					disabled="#{semmrt001Bean.viewMode}" >
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                	</td>
				                </tr>
				                <tr>
				                	<h:panelGroup >	
					                	<td align="right" width="30%" >
												
										</td>
										<td width="70%" colspan="2">
												<a4j:commandButton id="btnCalculate2" value="Calculate" styleClass="rich-button"
												action="#{navAction.navi}" 
												reRender="txtBalance">
								            		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-2" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doCalculateBalance" />
							            		</a4j:commandButton>
							            		<rich:spacer width="70" />
												<h:outputText value="#{jspMsg['label.balance']}" styleClass="ms7" />
												<rich:spacer width="10" />
												<h:inputText id="txtBalance" 
													value="#{semmrt001Bean.rentDetail.balanceAmt}" 
													onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			                						onblur="return numberformat.moneyFormat(this);"
			                						onfocus="return numberformat.setCursorPosToEnd(this);"
													disabled="true">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
												</h:inputText>
											
					                	</td>
				                	</h:panelGroup>
				                </tr>
				                
				                <tr>
				                	<td align="right" width="30%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
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
				                	<td align="right" width="30%">
				                		<h:outputText value="#{jspMsg['label.payee']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
				                		<h:selectOneMenu id="ddlPayee" value="#{semmrt001Bean.rentDetail.payeeMasterId}"
				                			onchange="onChangeDdlPayeeJS();" 
				                			disabled="#{semmrt001Bean.viewMode}">
				                			<a4j:jsFunction name="onChangeDdlPayeeJS" reRender="txtBookBank,txtBankName" 
				                				action="#{semmrt001Action.onChangeDdlPayee}">
				                				<a4j:actionparam name="modeDdl" value="RENTAL" />
				                			</a4j:jsFunction>
											<f:selectItems value="#{semmrt001Bean.payeeList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="30%">
				                		<h:outputText value="#{jspMsg['label.bookBank']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
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
				                	<td align="right" width="30%" valign="top">
				                		<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="70%" colspan="2">
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
								action="#{navAction.navi}" disabled="#{semmrt001Bean.disBtnAdd || semmrt001Bean.chkBtnAddSpecial}"
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
			            	 	reRender="pnlRentalDetail,dtbRentCond">
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
										reRender="pnlRentalDetail,dtbRentCond" title="edit" 
										id="btnEdit">
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
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 100"/>
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
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 12"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 72"/>
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
									<h:outputText value="#{rentDetail.periodStartDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodEndDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentDetail.periodEndDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
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
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 60"/>
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
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 12"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 72"/>
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
									<h:outputText value="#{rentHist.periodStartDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column >
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodEndDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentHist.periodEndDt}">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th"/>
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
							reRender="dtbRentDetail,pnlRentDetailResult,pnlRentalDetail,pnlSearchResult,dtbRentCond" >
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