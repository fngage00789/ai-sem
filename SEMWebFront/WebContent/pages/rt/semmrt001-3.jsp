<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.rental.semmrt001" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlAddDeposit">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmDepositAdd']}" /></f:facet>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmAddDeposit">
				<!-- begin content layout -->
				<h:panelGrid width="100%">
					<h:panelGroup>
						<table width="100%">
							<tr><td colspan="2">
									<table id="menuLink" width="100%">
										<tr>
											<td width="13%" align="left">
												<a4j:commandLink value="#{jspMsg['link.rentalAndService']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
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
												<a4j:commandLink value="#{jspMsg['link.bail']}" style="font-size:12px;">
												</a4j:commandLink>
											</td>
											<td width="10%" align="left">
												<a4j:commandLink value="#{jspMsg['link.checkPremium']}" action="#{navAction.navi}" 
												style="font-size:12px;"	reRender="oppContent">
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
													reRender="frmAddDeposit" style="font-size:12px;">
													<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001Pay" />
													<a4j:actionparam name="methodWithNavi" value="pageLoad" />
													<a4j:actionparam name="contractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}" />
													<a4j:actionparam name="mode" value="RENTALPAYMENT" />
												</a4j:commandLink>
											</td>
											</h:panelGroup>
											<td width="70%" align="right">
												<a4j:commandLink value="#{jspMsg['link.detailStation']}" 
													oncomplete="showViewSiteInfoPopup()"
									           		action="#{navAction.navi}" style="width:100;font-size:12px;">
									           		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="common" />
													<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
													<a4j:actionparam name="methodWithNavi" value="initPopup" />
													<a4j:actionparam name="rowId" value="#{semmrt001Bean.displayFrmRental.siteInfoId}" />
												</a4j:commandLink>
											</td>
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
											<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
												action="#{navAction.navi}" reRender="pnlAddDeposit,frmAddDeposit,pnlLog,frmWarningSaveDialog" 
												oncomplete="if(#{semmrt001Bean.popupWarning == 'true'})#{rich:component('mdpWarningSaveDialog')}.show(); return false" 
												rendered="#{!semmrt001Bean.viewMode}">
												<a4j:actionparam name="navModule" value="rt" />
												<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
												<a4j:actionparam name="moduleWithNavi" value="rt" />
												<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
												<a4j:actionparam name="methodWithNavi" value="doUpdateRentalMaster" />
											</a4j:commandButton>
										</td></tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					<rich:panel id="pnlDeposit">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.subRentalAdd']}"/>
						</f:facet>
						<!-- begin content -->
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1"><h:panelGroup>
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
									</td><td width="30%">
										<h:inputText id="txtContractNo" value="#{semmrt001Bean.displayFrmRental.contractNo}" 
											disabled="true"></h:inputText>
									</td><td align="right" width="15%">
										<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7"/>
									</td><td width="35%">
										<h:inputText id="txtSiteName" value="#{semmrt001Bean.displayFrmRental.siteName}"   size="45"
											disabled="true"></h:inputText>
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
										<h:selectOneMenu id="ddlReqType" value="#{semmrt001Bean.displayFrmRental.reqType}" 
											disabled="true">
											<f:selectItems value="#{semmrt001Bean.reqTypeList}"/>
										</h:selectOneMenu>
									</td><td align="right">
										<h:outputText value="#{jspMsg['label.title']}" styleClass="ms7"/>
									</td><td>
										<h:inputText id="txtTitle" value="#{semmrt001Bean.displayFrmRental.title}"  size="45"
											disabled="true"></h:inputText>
									</td>
								</tr>
								<tr>
									<td align="right">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.rentalStatus']}" styleClass="ms7"/>
									</td><td align="left">
										<h:selectOneMenu id="ddlRentalStatus" value="#{semmrt001Bean.displayFrmRental.rentalJobStatus}"
											onchange="mrt003Dep_checkRentalStatus()" 
											disabled="#{(semmrt001Bean.disApprove || (semmrt001Bean.displayFrmRental.reqType != '05' && 
												semmrt001Bean.displayFrmRental.reqType != '99')) || semmrt001Bean.viewMode }">
											<f:selectItems value="#{semmrt001Bean.rentalStatusList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="mrt003Dep_checkRentalStatus" action="#{semmrt001Action.doCheckRentalStatus}" 
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
							</table>
						</h:panelGroup></h:panelGrid>
						<!-- end content -->
					<!-- begin content layout data grid -->
					</rich:panel>
						
					<rich:panel id="pnlSearchResult" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable2.name']}" />
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbDepositCond" cellpadding="1" cellspacing="0" border="0" 
							var="dpstCond"  value="#{semmrt001Bean.dpstCondList}" reRender="dtbDepositCond" 
							rows="#{semmrt001Bean.rowPerPage}" 
							onRowMouseOver="this.style.backgroundColor='#FFE4E1'"  
							onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'" rowClasses="cur" 
							styleClass="contentform">
							<!-- begin column -->
							<rich:column rendered="#{!semmrt001Bean.viewMode}">
								<f:facet name="header">
									<h:outputText value="" style="width: 20"/>
								</f:facet>
								<div align="center">
									<h:selectBooleanCheckbox id="dpstCondSelected" 
										value="#{dpstCond.selected}" 
										rendered="#{dpstCond.newStatus == 'Y'}" 
										disabled="#{dpstCond.disSelect or semmrt001Bean.disabledVerify}">
										<a4j:support event="onclick" reRender="pnlDepositDetail,frmAddDeposit,dtbDepositCond,pnlAddDeposit" 
											action="#{semmrt001Action.doSelectedDpstSetup}">
											<a4j:actionparam name="siteDpstCondId" value="#{dpstCond.siteDepositId}"/>
										</a4j:support>
									</h:selectBooleanCheckbox>
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.expenseTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseName']}" style="width: 88"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstCond.expenseTypeName}"></h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.depositTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositType']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstCond.depositTypeName}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.remark}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" style="width: 70"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{dpstCond.remark}" />
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.condDepositAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.condDepositAmt']}" style="width: 60"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{dpstCond.condDepositAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.vatTypeName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 40"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{dpstCond.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.vatRate}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstCond.vatRate}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtType']}" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtRate']}" style="width: 40"/>
								</f:facet>
								<div align="center">
									<h:outputText value="">
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column sortBy="#{dpstCond.newStatusName}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.newStatus']}" style="width: 50"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{dpstCond.newStatusName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.sumDepositAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.sumDepositAmt']}" style="width: 6"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{dpstCond.sumDepositAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{dpstCond.condBalanceAmt}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.condBalanceAmt']}" 
										style="width: 12"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{dpstCond.condBalanceAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositCond" 
									maxPages="10" id="dstDepositCond" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
					</rich:panel>
					
					<!-- Special -->
					<h:panelGroup >
					<rich:simpleTogglePanel id="pnlSpecial"  switchType="client" label="#{jspMsg['header.resultTable2.nameSpecial']}" opened="#{semmrt001Bean.dpstCondSpecialBG != null or semmrt001Bean.dpstCondSpecial != null}" width="100%">
						<rich:panel id="pnlSpecialBGDeposit" rendered="#{semmrt001Bean.dpstCondSpecialBG != null && semmrt001Bean.dpstCondSpecialBG.detail != null}">
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td align="right" width="20%">
												<h:selectBooleanCheckbox value="#{semmrt001Bean.selectedBGSpecial}" 
													rendered="#{semmrt001Bean.disChkSpecial && !semmrt001Bean.viewMode}">
													<a4j:support event="onclick" reRender="pnlDepositDetail,pnlSpecialDeposit,pnlSpecialBGDeposit,pnlSearchResult" 
														action="#{semmrt001Action.onClickChkBoxSpecial}">
														<a4j:actionparam name="type" value="BG"/>
													</a4j:support>
												</h:selectBooleanCheckbox>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.depositType']}" styleClass="ms7"/>
							                </td>
							                <td width="80%" colspan="2">
							                	<h:selectOneMenu id="ddlSpecialBGDpstType" disabled="true"
							                		value="#{semmrt001Bean.dpstCondSpecialBG.depositType}">
													<f:selectItems value="#{semmrt001Bean.depositTypeList}"/>
												</h:selectOneMenu>
							                </td>
										</tr>
										<tr>
											<td align="right" valign="top" width="20%">
												<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
											</td>
											<td width="80%" colspan="2">
												<h:inputTextarea rows="4" cols="100" disabled="true"
													value="#{semmrt001Bean.dpstCondSpecialBG.detail}">
												</h:inputTextarea>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:panel>
						<rich:panel id="pnlSpecialDeposit" rendered="#{semmrt001Bean.dpstCondSpecial != null && semmrt001Bean.dpstCondSpecial.detail != null}">
							<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<table width="100%">
										<tr>
											<td align="right" width="20%">
												<h:selectBooleanCheckbox value="#{semmrt001Bean.selectedCashSpecial}" 
													rendered="#{semmrt001Bean.disChkSpecial && !semmrt001Bean.viewMode}">
													<a4j:support event="onclick" reRender="pnlDepositDetail,pnlSpecialDeposit,pnlSpecialBGDeposit,pnlSearchResult" 
														action="#{semmrt001Action.onClickChkBoxSpecial}">
														<a4j:actionparam name="type" value="CASH"/>
													</a4j:support>
												</h:selectBooleanCheckbox>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.depositType']}" styleClass="ms7"/>
							                </td>
							                <td width="80%" colspan="2">
							                	<h:selectOneMenu id="ddlSpecialDpstType" disabled="true"
							                		value="#{semmrt001Bean.dpstCondSpecial.depositType}">
													<f:selectItems value="#{semmrt001Bean.depositTypeList}"/>
												</h:selectOneMenu>
							                </td>
										</tr>
										<tr>
											<td align="right" valign="top" width="20%">
												<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
											</td>
											<td width="80%" colspan="2">
												<h:inputTextarea rows="4" cols="100" disabled="true"
													value="#{semmrt001Bean.dpstCondSpecial.detail}">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td align="right" width="20%">
												<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
											</td>
											<td width="80%" colspan="2">
												<h:selectOneRadio id="rbtSpecialVatType2" styleClass="ms7" 
													value="#{semmrt001Bean.dpstCondSpecial.vatType}" 
													disabled="true">
													<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
										            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
										            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
										            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} " />
												</h:selectOneRadio>
											</td>
										</tr>
									</table>
								</h:panelGroup>
							</h:panelGrid>
						</rich:panel>
					</rich:simpleTogglePanel>
					</h:panelGroup>
					
					<rich:panel id="pnlDepositDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.frmDeposit']}"/>
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
									<td align="right">
										<a4j:commandButton id="btnNew" value="#{jspMsg['btn.addNewDpst']}" styleClass="rich-button" 
										action="#{navAction.navi}"
										reRender="pnlDpstDetailResult,pnlDepositDetail,pnlSearchResult,pnlSpecialDeposit,pnlLog,pnlSpecialBGDeposit,pnlSpecialDeposit">
											<a4j:actionparam name="navModule" value="rt" />
											<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
											<a4j:actionparam name="moduleWithNavi" value="rt" />
											<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
											<a4j:actionparam name="methodWithNavi" value="doNewDepositDetail" />
										</a4j:commandButton>
									</td>
								</tr>
								<tr>
									<td align="right" width="20%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
			                		<td width="35%">
										<h:selectOneMenu id="ddlExpenseType" value="#{semmrt001Bean.dpstDetail.expenseType}" 
											 onchange="onChangeDdlExpenseTypeJS();" 
											 disabled="#{(semmrt001Bean.modeDpstDetail == 'EDIT') || semmrt001Bean.viewMode}" >
											 <a4j:jsFunction name="onChangeDdlExpenseTypeJS" reRender="txtWhtRate,txtVatRate,pnlDepositDetail" 
												action="#{semmrt001Action.onChangeDdlExpenseType}"/>
											<f:selectItems value="#{semmrt001Bean.expenseTypeList}"/>
										</h:selectOneMenu>
					                </td>
					                <td align="right" width="15%">
					                	<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.depositType']}" styleClass="ms7"/>
					                </td>
					                <td width="30%">
					                	<h:selectOneMenu id="ddlDepositType" value="#{semmrt001Bean.dpstDetail.depositType}" 
											 disabled="#{semmrt001Bean.disDepositDetail}" 
											 onchange="onChangeDdlDepositTypeJS();">
											 <a4j:jsFunction name="onChangeDdlDepositTypeJS" action="#{semmrt001Action.calculateVat}" 
											 	reRender="pnlDepositDetail"/>
											<f:selectItems value="#{semmrt001Bean.depositTypeList}"/>
										</h:selectOneMenu>
					                </td>
				                </tr>
				                <h:panelGroup rendered="#{semmrt001Bean.modePage == 'NORMAL'}">
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.amt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="85%" colspan="3">
				                		<h:inputText id="txtVerifyAmt" value="#{semmrt001Bean.dpstDetail.depositRentAmt}" 
				                			disabled="#{(semmrt001Bean.disDpstAmt && semmrt001Bean.modePage == 'NORMAL') || semmrt001Bean.viewMode}"
				                			
				                			styleClass="inputRight" 
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                	</td>
				                </tr>
				                </h:panelGroup>
				                <h:panelGroup rendered="#{semmrt001Bean.modePage == 'SPECIAL'}">
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.periodStDt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="3">
				                		<a4j:region>
				                		<rich:calendar id="cldPeriodStDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt001Bean.dpstDetail.periodStDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.periodStDt']}" 
											   	   disabled="#{semmrt001Bean.viewMode}">
											   <a4j:support event="oninputblur" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldPeriodEndDt">
											   		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDateDpst" />
											   </a4j:support>
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldPeriodEndDt">
											   		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDateDpst" />
											   </a4j:support>
										</rich:calendar>
										</a4j:region>
										<rich:spacer width="30"></rich:spacer><h:graphicImage 
											value="images/icon_required.gif"/><rich:spacer width="5"></rich:spacer><h:outputText 
											value="#{jspMsg['label.periodEndDt']}" styleClass="ms7"></h:outputText><rich:spacer 
											width="5"></rich:spacer>
										<a4j:region>
										<rich:calendar id="cldPeriodEndDt" locale="th" enableManualInput="true" 
												   datePattern="dd/MM/yyyy" 
												   value="#{semmrt001Bean.dpstDetail.periodEndDt}"
												   showWeeksBar="false"
												   inputSize="10"
												   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   	   cellWidth="20px" cellHeight="20px"
											   	   label="#{jspMsg['label.periodEndDt']}" 
											   	   disabled="#{semmrt001Bean.viewMode}">
											   <a4j:support event="oninputblur" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldPeriodStDt">
											   		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDateDpst" />
											   </a4j:support>
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="frmError,cldPeriodStDt">
											   		<a4j:actionparam name="navModule" value="rt" />
													<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
													<a4j:actionparam name="moduleWithNavi" value="rt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultDateDpst" />
											   </a4j:support>
										</rich:calendar>
										</a4j:region>
				                	</td>
				                </tr>
				                </h:panelGroup>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5" />
				                		<h:outputText value="#{jspMsg['label.depositAmt']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="3">
				                		<h:inputText id="txtDepositAmt" value="#{semmrt001Bean.dpstDetail.depositAmt}" 
				                			styleClass="inputRight" 
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="onblurVatTypeJS();return numberformat.moneyFormat(this);"
		                					onfocus="return numberformat.setCursorPosToEnd(this);"
		                					maxlength="16" 
		                					disabled="#{semmrt001Bean.viewMode}" 
		                					>
		                					<a4j:jsFunction name="onblurVatTypeJS" reRender="rbtVatType,pnlDepositDetail" 
				                				action="#{semmrt001Action.calculateVat}" />
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                		</h:inputText>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="30%" valign="top">
				                		<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="30%" valign="top">
										<h:selectOneRadio id="rbtWhtType" styleClass="ms7" 
											value="#{semmrt001Bean.dpstDetail.whtType}">
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
										</h:selectOneRadio>
					                </td>
					                <td width="40%" valign="top" colspan="2">
					                <a4j:region>
										<h:outputText value="#{jspMsg['label.whtRate']}" styleClass="ms7"/>
										<h:inputText id="txtWhtRate" disabled="#{!semmrt001Bean.disWhtRate}" 
											value="#{semmrt001Bean.dpstDetail.whtRate}" 
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
				                <h:panelGroup rendered="true">
				                <tr>
				                	<td align="right" width="20%" >
				                		<h:graphicImage rendered="#{semmrt001Bean.dpstDetail.depositType == '02' && semmrt001Bean.dpstDetail.expenseType == '05'}"  value="images/icon_required.gif"/>
										<rich:spacer width="5" />
				                		<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="35%">
										<h:selectOneRadio id="rbtVatType" styleClass="ms7" 
											value="#{semmrt001Bean.dpstDetail.vatType}">
											<a4j:jsFunction name="onChangeVatTypeJS" reRender="rbtVatType,pnlDepositDetail" 
				                				action="#{semmrt001Action.calculateVat}" />
											<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
								            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
								            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
								            <f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} " />
										</h:selectOneRadio>
					                </td>
					                <h:panelGroup>
					                <td width="45%" colspan="2">
					                	<h:outputText value="#{jspMsg['label.vatRate']}" styleClass="ms7" />
					                	<h:inputText id="txtVatRate" 
											size="5" value="#{semmrt001Bean.dpstDetail.vatRate}" 
											onkeypress="return numberformat.keyPressDecimalOnly(this, event);">
		                					<a4j:jsFunction name="onblurVatTypeJS2" reRender="rbtVatType,pnlDepositDetail" 
				                				action="#{semmrt001Action.calculateVat}" />
										</h:inputText>
										<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
					                </td>
					                </h:panelGroup>
				                </tr>
				                </h:panelGroup>
				                
				                <tr>
				                	<td align="right" width="20%">
				                		<h:graphicImage id="vendorReq" value="images/icon_required.gif" 
				                			rendered="#{semmrt001Bean.dpstDetail.depositType == '02'}"/>
										<rich:spacer width="5"></rich:spacer>
				                		<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="3">
				                		<h:selectOneMenu id="ddlVendor" value="#{semmrt001Bean.dpstDetail.vendorMasterId}" 
				                			onchange="onChangeDdlVendorJS();" 
				                			disabled="#{semmrt001Bean.viewMode}">
				                			<a4j:jsFunction name="onChangeDdlVendorJS" reRender="ddlPayee,txtBookBank,txtBankName" 
				                				action="#{semmrt001Action.onChangeDdlVendor}" >
				                				<a4j:actionparam name="modeDdl" value="DEPOSIT" />
				                			</a4j:jsFunction>
											<f:selectItems value="#{semmrt001Bean.vendorList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.payee']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="3">
				                		<h:selectOneMenu id="ddlPayee" value="#{semmrt001Bean.dpstDetail.payeeMasterId}" 
				                			onchange="onChangeDdlPayeeJS();" 
				                			disabled="#{semmrt001Bean.viewMode}">
				                			<a4j:jsFunction name="onChangeDdlPayeeJS" reRender="txtBookBank,txtBankName" 
				                				action="#{semmrt001Action.onChangeDdlPayee}">
				                				<a4j:actionparam name="modeDdl" value="DEPOSIT" />
				                			</a4j:jsFunction>
											<f:selectItems value="#{semmrt001Bean.payeeList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%">
				                		<h:outputText value="#{jspMsg['label.bookBank']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="3">
				                		<h:inputText id="txtBookBank" disabled="#{semmrt001Bean.disDepositDetail}" value="#{semmrt001Bean.mrt001BookBank.bankAccNo}" 
				                			style="width: 200px"/>
				                		<rich:spacer width="109" />
				                		<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
				                		<rich:spacer width="5" />
				                		<h:inputText id="txtBankName" disabled="#{semmrt001Bean.disDepositDetail}" value="#{semmrt001Bean.mrt001BookBank.bankName}" 
				                			style="width: 250px"/>
				                	</td>
				                </tr>
				                <tr>
				                	<td align="right" width="20%" valign="top">
				                		<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"></h:outputText>
				                	</td>
				                	<td width="80%" colspan="3">
				                		<h:inputTextarea cols="80" rows="5" value="#{semmrt001Bean.dpstDetail.remark}" 
				                			disabled="#{semmrt001Bean.viewMode}"></h:inputTextarea>
				                	</td>
				                </tr>
				                </table>
							</h:panelGroup>
						</h:panelGrid>
						<h:panelGrid columns="3" id="grdSearchCommand">
							<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" 
								rendered="#{semmrt001Bean.modeDpstDetail == 'ADD' && !semmrt001Bean.viewMode}" 
								action="#{navAction.navi}"
								reRender="pnlDpstDetailResult,pnlDepositDetail,pnlSearchResult,pnlSpecialDeposit,pnlLog,pnlSpecialBGDeposit,pnlSpecialDeposit">
								<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doAddDpstDetail" />
							</a4j:commandButton>
							<a4j:commandButton id="btnSaveDpstDetail" value="Save" styleClass="rich-button" 
								rendered="#{semmrt001Bean.modeDpstDetail == 'EDIT' && !semmrt001Bean.viewMode}"
								action="#{navAction.navi}"
			            	 	reRender="pnlDpstDetailResult,pnlDepositDetail,pnlSearchResult,pnlSpecialDeposit,pnlLog,pnlSpecialBGDeposit,pnlSpecialDeposit">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doAddDpstDetail" />
			            	</a4j:commandButton>
			            	<a4j:commandButton id="btnClearDpstDetail" value="Clear" styleClass="rich-button" 
			            		action="#{navAction.navi}" 
			            	 	reRender="pnlDepositDetail,dtbDepositCond,frmAddDeposit,pnlSpecialBGDeposit,pnlSpecialDeposit">
			            		<a4j:actionparam name="navModule" value="rt" />
								<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
								<a4j:actionparam name="moduleWithNavi" value="rt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
								<a4j:actionparam name="methodWithNavi" value="doClearDpstDetail" />
			            	</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					
					<rich:panel id="pnlDpstDetailResult" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.dataFrmList']}" style="width: 1650"/>
						</f:facet>
						<!-- begin dataTable -->
						<rich:dataTable id="dtbDpstDetail" cellpadding="1" cellspacing="0" border="0" 
							var="dpstDetailList" value="#{semmrt001Bean.dpstDetailList}" reRender="dtbDpstDetail" 
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
										action="#{navAction.navi}" id="btnEdit"
										reRender="pnlDepositDetail,pnlSearchResult,pnlSpecial" title="edit">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="getDpstDetailById" />
										<a4j:actionparam name="rowId" value="#{dpstDetailList.depositDetailId}"/>
										<a4j:actionparam name="dpstVerifyAmt" value="#{dpstDetailList.dpstVerifyAmt}"/>
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
     									   image="images/delete.png" style="height: 15; width: 15;" 
     									   action="#{navAction.navi}" title="delete" id="btnDelete">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="getDpstDetailById" />
										<a4j:actionparam name="rowId" value="#{dpstDetailList.depositDetailId}"/>
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
										action="#{navAction.navi}" id="btnView"
										reRender="pnlDepositDetail" title="view">
										<a4j:actionparam name="navModule" value="rt" />
										<a4j:actionparam name="navProgram" value="SEMMRT001-3" />
										<a4j:actionparam name="moduleWithNavi" value="rt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
										<a4j:actionparam name="methodWithNavi" value="getDpstDetailById" />
										<a4j:actionparam name="rowId" value="#{dpstDetailList.depositDetailId}"/>
										<a4j:actionparam name="dpstVerifyAmt" value="#{dpstDetailList.dpstVerifyAmt}"/>
										<a4j:actionparam name="mode" value="EDIT"/>
									</a4j:commandButton>
								</div>
							</rich:column>
							<rich:column rendered="#{!semmrt001Bean.viewMode}">
								<f:facet name="header">
									<h:outputText value="BG" style="width: 88"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink value="#{jspMsg['column.link.addBG']}" 
										reRender="oppContent" id="hypAddBG" 
										action="#{navAction.navi}" title="BGID :#{dpstDetailList.bgMasterId}" 
										rendered="#{dpstDetailList.depositType == '01'}">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="navModuleFrom" value="rt" />
										<a4j:actionparam name="navProgramFrom" value="SEMMRT001-3" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMRT001" />
										<a4j:actionparam name="depositDetailId" value="#{dpstDetailList.depositDetailId}" />
										<a4j:actionparam name="rowId" value="#{dpstDetailList.bgMasterId}" />
										<a4j:actionparam name="isPageFrom" value="true" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.expenseName']}" style="width: 100"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.expenseTypeName}" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.depositType']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.depositTypeName}" />
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorId']}" style="width: 60"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.vendorCode}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vendorName']}" style="width: 60"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{dpstDetailList.vendorName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.altPayee']}" style="width: 60"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{dpstDetailList.payeeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.condDepositAmt']}" style="width: 100"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{dpstDetailList.depositAmt}">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtType']}" style="width: 72"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.whtTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.whtRate']}" style="width: 22"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.whtRate}">
									<f:convertNumber pattern="#,##0"/>
									</h:outputText>
								</div>
							</rich:column>
							
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 72"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.vatTypeName}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.vatType']}" style="width: 22"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.vatRate}"/>
								</div>
							</rich:column>
							<rich:column rendered="#{semmrt001Bean.modePage == 'SPECIAL'}"> 
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodStDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.periodStDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column rendered="#{semmrt001Bean.modePage == 'SPECIAL'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.periodEndDt']}" style="width: 50px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.periodEndDtStr}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.remark']}" 
										style="width: 200px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{dpstDetailList.remark}">
									</h:outputText>
								</div>
							</rich:column>
							<rich:column>
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.header.dpstStatus']}" 
										style="width: 100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{dpstDetailList.dpstStatus}">
									</h:outputText>
								</div>
							</rich:column>
							
							<!-- end column -->
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDpstDetail" 
									maxPages="10" id="dstDpstDetail" selectedStyleClass="selectScroll" />
							</f:facet>
						</rich:dataTable>
						<!-- end dataTable -->
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
							reRender="dtbDpstDetail,pnlDpstDetailResult,pnlDepositDetail,dtbDepositCond,pnlSearchResult" >
							<a4j:actionparam name="navModule" value="rt" />
		            		<a4j:actionparam name="navProgram" value="SEMMRT001-3" />	
							<a4j:actionparam name="moduleWithNavi" value="rt" />
							<a4j:actionparam name="actionWithNavi" value="SEMMRT001" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDpstDetail" />							
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
							reRender="dtbDpstDetail,pnlDpstDetailResult,pnlDepositDetail,dtbDepositCond" >
							<a4j:actionparam name="navModule" value="rt" />
		            		<a4j:actionparam name="navProgram" value="SEMMRT001-3" />	
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