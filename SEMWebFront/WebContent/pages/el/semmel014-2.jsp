<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel014" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlEl">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmBail']}" /></f:facet>
		<h:panelGrid columnClasses="gridContent" width="90%">
			<a4j:form id="frmElVerify">
				<h:panelGrid width="100%">
				
					<!-- Tab and button Panel -->
					<h:panelGroup>
						<table width="100%" style="border: 1px">
							<tr>
								<td >
									<table id="menuLink" width="100%">
										<tr>
											<h:panelGroup >
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.el']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="initVerify" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
													</a4j:commandLink>
												</td>
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.bail']}" style="font-size:12px;">
													</a4j:commandLink>
												</td>
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.checkPremium']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-3" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="initCheckPremium" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
													</a4j:commandLink>
												</td>
												<td width="74%" align="right">
													<a4j:commandButton id="btnVerify" value="#{jspMsg['btn.verify']}" styleClass="rich-button" 
														action="#{navAction.navi}" reRender="oppContent">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="doELPrivateVerify" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
														<a4j:actionparam name="pageNo" value="2"/>
													</a4j:commandButton>
													<rich:spacer width="5"></rich:spacer>
													<a4j:commandButton id="btnCancel" value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
														action="#{navAction.navi}" reRender="oppContent">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL001-1" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
														<a4j:actionparam name="methodWithNavi" value="doCancel" />
														<a4j:actionparam name="page" value="13" />
													</a4j:commandButton>
												</td>
											</h:panelGroup>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</h:panelGroup>
					
					<!-- Contract Panel -->
					<rich:panel id="pnlContract">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.contractDetail']}"/>
						</f:facet>
						
						<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.company']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.company}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.previousContractId']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.oldContractNo}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractId']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.region']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.region}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.siteName']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.siteName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationId']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.locationId}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.locationCode']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.locationCode}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.locationStatus']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.locationStatus}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.firstEffectiveDt']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.firstEffectiveDtStr}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.effectiveDt']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.effectiveDtStr}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.expireDt']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.expireDtStr}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.contractStatus']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.siteStatusName}" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.processStatus']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:outputText value="#{semmel014Bean.verMaster.processStatusName}" styleClass="ms7" />
										</td>
										<td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.actionDt']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:outputText value="#{semmel014Bean.verMaster.actionDtStr}" styleClass="ms7" />
										</td>
					                </tr>
					             </table>
				         	</h:panelGroup>
				         </h:panelGrid>
					</rich:panel>
					
					<!-- Exoenses Panel -->
					<rich:panel id="pnlDpstCond" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.depositInfomation']}"/>
						</f:facet> 
						
						<rich:dataTable id="dtbDpstCond" width="100%" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel014Bean.dpstCondList}"
								rows="#{semmel014Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" >
								
									<f:facet name="header">
									</f:facet>
									
									<div align="center" style="">
										<h:selectBooleanCheckbox id="verCondSelected" value="#{wrapper.selected}"
										disabled="#{wrapper.dpstCondSP.verFlag != 'Y'}">
										<a4j:support event="onclick" reRender="pnlDpstCond,pnlAddDetail" 
											action="#{semmel014Action.doSelectedVerDPSSetup}">
											<a4j:actionparam name="siteElectricId" value="#{wrapper.dpstCondSP.electricId}"/>
											<a4j:actionparam name="siteInfoId" value="#{wrapper.dpstCondSP.siteInfoId}"/>
											<a4j:actionparam name="siteDepositId" value="#{wrapper.dpstCondSP.siteDepositId}"/>
										</a4j:support>
									</h:selectBooleanCheckbox>
									</div>
								</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.depositType']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.dpstCondSP.depositTypeName}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.remark']}" />
										</f:facet>
										
										<div align="left">
											<h:outputText value="#{wrapper.dpstCondSP.remark}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.wht']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.dpstCondSP.whtTypeName}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.vat']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.dpstCondSP.vatTypeName}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.effectiveDt']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.dpstCondSP.periodStartDtStr}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.condDepositAmt']}" />
										</f:facet>
										
										<div align="right">
											<h:outputText value="#{wrapper.dpstCondSP.condDepositAmt}" >
												<f:convertNumber pattern="#,##0.00"/>
											</h:outputText>
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.status']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.dpstCondSP.newStatusName}" />
										</div>
											
									</rich:column>
									
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmel014Bean.dpstCondList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<rich:column colspan="18">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDpstCond"
													maxPages="#{semmel014Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dstVerExpenses" 
													style="background-color: #cccccc;"
													page="#{semmel014Bean.scrollerPage}" 
												/>
											</rich:column>
										</rich:columnGroup>
									</f:facet>	
									
						</rich:dataTable>
						
					</rich:panel>
					
					<!-- Add Panel -->
					<rich:panel id="pnlAddDetail">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.depositDetail']}"/>
						</f:facet> 
						
						<h:panelGrid width="97%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="left" colspan="3">
											<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" 
												rendered="#{semmel014Bean.renderedMsgFormMiddle}">
												<f:facet name="header">
									            	<h:outputText value="Entered Data Status:"></h:outputText>
									            </f:facet>
												<f:facet name="errorMarker">
													<h:graphicImage value="images/error.gif" />  
										        </f:facet>
									        </rich:messages>
										</td>
									</tr>
									<tr>
						                <td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.depositType']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneMenu id="ddlDepositType" value="#{semmel014Bean.dpstConSP.expenseType}">
												<f:selectItem itemValue="08" itemLabel="#{jspMsg['label.electricDeposit']}"  />
											</h:selectOneMenu>
										</td>
										
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.bailType']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectOneMenu id="ddlBailType" value="#{semmel014Bean.dpstConSP.depositTypeName}">  
												<f:selectItem itemValue="Cash" itemLabel="Cash"  />
												<f:selectItem itemValue="BG" itemLabel="BG"  />
											</h:selectOneMenu>
										</td>
					                </tr>
					                <tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.startPeriodDt']} :" styleClass="ms7" />
										</td>
										<td >
											<rich:calendar id="verPeriodStartDt"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy"
												value="#{semmel014Bean.dpstConSP.periodStartDt}" 
												oninputblur="validateRichCalendarFromTo('frmElVerify','verPeriodStartDt','verPeriodEndDt');"
									 			oncollapse="validateRichCalendarFromTo('frmElVerify','verPeriodStartDt','verPeriodEndDt');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar> 
										</td>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.endPeriodDt']} :" styleClass="ms7" />
										</td>
										<td >	
											<rich:calendar id="verPeriodEndDt"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.date']}"
												value="#{semmel014Bean.dpstConSP.periodEndDt}"
												oninputblur="validateRichCalendarFromTo('frmElVerify','verPeriodEndDt','verPeriodStartDt');"
									 			oncollapse="validateRichCalendarFromTo('frmElVerify','verPeriodEndDt','verPeriodStartDt');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
									</tr>
					                
					                <tr>
						                <td align="right">
											<h:outputText value="#{jspMsg['label.amount']} :" styleClass="ms7" />
										</td>
										<td >
											<h:inputText id="TxtDepoistAmt" value="#{semmel014Bean.dpstConSP.depositAmt}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.bgNo']} :" styleClass="ms7" />
										</td>
										<td >
											<h:inputText id="TxtBgNo" value="#{semmel014Bean.dpstConSP.bgNo}" size="30" style="width : 160px"/>
										</td>
					                </tr>
					                
					                <tr>
						                <td align="right" width="20%">
											<h:outputText value="#{jspMsg['label.vat']} :" styleClass="ms7" />
										</td>
										<td width="30%">
											<h:selectOneRadio id="vatTypeRbt" 
										 	 value="#{semmel014Bean.dpstConSP.vatType}"
										 	 layout="lineDirection"	styleClass="ms7" rendered="true" >
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.includeVat']}"  />
												<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.notIncludeVat']}" />
												<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
												<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.exceptVat']}" />	
											</h:selectOneRadio>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.vatRate']} :" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="vatRateTxt" value="#{semmel014Bean.dpstConSP.vatRate}" size="10" style="width : 80px"/>
											<rich:spacer width="5"/>
											<h:outputText value="%" styleClass="ms7" />
										</td>
					                </tr>
					                
					                <tr>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
										</td>
										<td >
											<h:selectOneRadio id="rbtSpecialWhtType1" styleClass="ms7" layout="pageDirection" 
												value="#{semmel014Bean.dpstConSP.whtType}" >
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
									            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
									            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
											</h:selectOneRadio>
										</td>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.whtRate']} :" styleClass="ms7" />
										</td>
										<td  valign="top">
											<h:inputText size="5" value="#{semmel014Bean.dpstConSP.whtRate}"/>
											<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
										</td>
									</tr>
					                
					           
							 			<td align="right">
											<h:outputText value="#{jspMsg['label.service']} :" styleClass="ms7" />
										</td>
										<td colspan="3">					
										<h:selectOneMenu id="ddlService" value="#{semmel014Bean.serviceCalTypeId}" onchange="doChangeValueService();"> 
											<f:selectItems value="#{semmel014Bean.serviceNameList}"/>
										</h:selectOneMenu>
									<a4j:jsFunction name="doChangeValueService" action="#{semmel014Action.doChangeValueService}" ></a4j:jsFunction>
									
									<h:outputText value=" #{jspMsg['label.calBy']}" styleClass="ms7"></h:outputText>
										<h:outputText id="showCalType" value="  #{semmel014Bean.serviceCalTypeIdToCalName} " styleClass="ms7"></h:outputText>
										<rich:spacer  style="height : 1px; width : 8px;"/>
										<a4j:commandButton value="..." styleClass="rich-button"  reRender="frmServiceCalSaveDialog,servicePercent"
										 oncomplete="#{rich:component('serviceCalDialog')}.show();" 
										 >
									 
										</a4j:commandButton>
										</td>
					                <tr>
						                <td align="right">
						                	<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.vendor']} :" styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:selectOneMenu id="ddlVendor" value="#{semmel014Bean.dpstConSP.vendorMasterId}" 
											onchange="onChangeDdlVendorJS()">
												<a4j:jsFunction name="onChangeDdlVendorJS" reRender="pnlAddDetail" 
					                				action="#{semmel014Action.onChangeVendor}">
					                			</a4j:jsFunction>
												<f:selectItems value="#{semmel014Bean.vendorList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
						                <td align="right">
											<h:outputText value="#{jspMsg['label.payeeName']} :" styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:selectOneMenu id="ddlPayee" value="#{semmel014Bean.dpstConSP.payeeMasterId}" >
												<f:selectItems value="#{semmel014Bean.payeeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
						                <td align="right">
											<h:outputText value="#{jspMsg['label.payeeBookBank']} :" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="payeeBookBankTxt" value="#{semmel014Bean.dpstConSP.bankAccNo}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.payeeBookBankName']} :" styleClass="ms7" />
										</td>
										<td>
											<h:inputText id="payeeBookBankNameTxt" value="#{semmel014Bean.dpstConSP.bankName}" size="30" style="width : 160px"/>
										</td>
									</tr>
									
									<tr>
						                <td align="right">
											<h:outputText value="#{jspMsg['label.remark']} :" styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:inputTextarea id="remarkTxt" value="#{semmel014Bean.dpstConSP.remark}" rows="5" cols="120"/>
										</td>
									</tr>
									<tr>
										<td>
										</td>
										<td colspan="3">
											<h:panelGrid columns="3" id="grdCommand">
												<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" 
													action="#{navAction.navi}" rendered="#{semmel014Bean.dpstConSP.mode == 'ADD'}"
													reRender="pnlDepositDtl,pnlAddDetail,pnlDpstCond">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
													<a4j:actionparam name="methodWithNavi" value="doAddEditDpst" />
												</a4j:commandButton>
												<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
													action="#{navAction.navi}" rendered="#{semmel014Bean.dpstConSP.mode == 'EDIT'}"
								            	 	reRender="pnlDepositDtl,pnlAddDetail,pnlDpstCond"> 
								            		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
													<a4j:actionparam name="methodWithNavi" value="doAddEditDpst" />
								            	</a4j:commandButton>
								            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
								            		action="#{navAction.navi}" 
								            	 	reRender="pnlAddDetail,pnlDpstCond">
								            		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
													<a4j:actionparam name="methodWithNavi" value="doClearDpst" />
								            	</a4j:commandButton>
								            </h:panelGrid>
										</td>
									</tr>
					             </table>
					         </h:panelGroup>
					     </h:panelGrid>
						
					</rich:panel>
					
					<!-- Payment Info Panel -->
					<rich:panel id="pnlDepositDtl" styleClass="sem_autoScrollbar">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.depositPayment']}"/>
						</f:facet> 
						
						<rich:dataTable id="dtbDpstDtl" width="100%" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel014Bean.dpstDtlList}"
								rows="#{semmel014Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column width="5%" >
									<f:facet name="header">
										<h:outputText value="Edit" style="width: 40"/>
									</f:facet>
									<div align="center">
										<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
											action="#{navAction.navi}"
											reRender="pnlAddDetail" title="edit" 
											id="btnEdit">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
											<a4j:actionparam name="methodWithNavi" value="initEditDpst" />
											<a4j:actionparam name="selectedRow" value="#{row}" />
											<a4j:actionparam name="mode" value="EDIT"/>
										</a4j:commandButton>
									</div>
								</rich:column>
								<rich:column width="5%" >
									<f:facet name="header">
										<h:outputText value="Delete" style="width: 40"/>
									</f:facet>
									<div align="center">
										<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDialog')}.show(); return false" 
	     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15;" 
	     									   title="delete" id="btnDelelte">
											<a4j:actionparam name="navModule" value="el" />
			            					<a4j:actionparam name="navProgram" value="SEMMEL014-2" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
											<a4j:actionparam name="methodWithNavi" value="getDpstDel" />
											<a4j:actionparam name="selectedRow" value="#{row}"/>
											<a4j:actionparam name="mode" value="DELETE"/>
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
										action="#{navAction.navi}" title="BGID :#{wrapper.dpstCondSP.bgMasterId}" 
										rendered="#{wrapper.dpstCondSP.depositType == 'BG'}">
										<a4j:actionparam name="navModule" value="gm" />
										<a4j:actionparam name="navProgram" value="SEMMCT002-2" />
										<a4j:actionparam name="moduleWithNavi" value="gm" />
										<a4j:actionparam name="actionWithNavi" value="SEMMCT002" />
										<a4j:actionparam name="methodWithNavi" value="pageLoad" />
										<a4j:actionparam name="navModuleFrom" value="el" />
										<a4j:actionparam name="navProgramFrom" value="SEMMEL014-2" />
										<a4j:actionparam name="actionWithNaviFrom" value="SEMMEL014" />
										<a4j:actionparam name="depositDetailId" value="#{wrapper.dpstCondSP.depositDetailId}" />
										<a4j:actionparam name="rowId" value="#{wrapper.dpstCondSP.bgMasterId}" />
										<a4j:actionparam name="isPageFrom" value="true" />
									</a4j:commandLink>
								</div>
							</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.depositType']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.dpstCondSP.depositType}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor']} ID" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.dpstCondSP.vendorCode}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor']} Name" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.dpstCondSP.vendorName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="Payee ID" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.dpstCondSP.payeeCode}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeeName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.dpstCondSP.payeeName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.periodAmt']}" />
									</f:facet>
									
									<div align="right">
										<h:outputText value="#{wrapper.dpstCondSP.depositAmt}" >
											<f:convertNumber pattern="#,##0.00"/>
										</h:outputText>
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vat']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.vatTypeName}" />
									</div>
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vat']} Rate" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.vatRate}" />
									</div>
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.wht']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.whtTypeName}" />
									</div>
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.wht']} Rate" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.whtRate}" />
									</div>
								</rich:column>
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.periodStartDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.periodStartDtStr}" />
									</div>
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.periodEndDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.periodEndDtStr}" />
									</div>
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.bailStatus']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.newFlag}" />
									</div>
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.dpstCondSP.remark}" />
									</div>
								</rich:column>
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel014Bean.dpstDtlList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="18">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDpstDtl"
												maxPages="#{semmel014Bean.rowPerPage}"  selectedStyleClass="selectScroll"
												stepControls="hide" fastControls="auto" boundaryControls="auto" 
												id="dstVerPaymentInfo" 
												style="background-color: #cccccc;"
												page="#{semmel014Bean.scrollerPage}" 
											/>
										</rich:column>
									</rich:columnGroup>
								</f:facet>	
						</rich:dataTable>
					</rich:panel>
					
					<rich:panel id="pnlLog">
						<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
			                	<tr>
									<td align="right">
										<h:outputText value="#{jspMsg['label.createBy']}" styleClass="ms7"/>
		                			</td><td width="25%">
		                				<h:inputText id="txtCreateBy" value="#{semmel014Bean.verMaster.createBy}" 
		                					readonly="true" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.createDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldCreateDate" locale="th" 
											datePattern="dd/MM/yyyy HH:mm:ss" 
										    value="#{semmel014Bean.verMaster.createDt}"
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
			                			<h:inputText id="txtUpdateBy" value="#{semmel014Bean.verMaster.updateBy}" 
			                				readonly="true" disabled="true" />
				                	</td><td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.updateDate']}" styleClass="ms7"/>
		                			</td><td width="30%">
			                			<rich:calendar id="cldUpdateDate" locale="th" 
											datePattern="dd/MM/yyyy HH:mm:ss" 
										    value="#{semmel014Bean.verMaster.updateDt}"
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

<!-- Dialog -->

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
							reRender="pnlDepositDtl,pnlAddDetail,pnlDpstCond" >
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL014-2" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
							<a4j:actionparam name="methodWithNavi" value="doDeleteDpst" />							
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

<rich:modalPanel id="serviceCalDialog" autosized="true" >	
	<f:facet name="header">
    	<h:outputText value="#{jspMsg['label.serviceCalType']}"></h:outputText>
    </f:facet>
	<a4j:form id="frmServiceCalSaveDialog">
		<table width="350px" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<h:panelGrid columns="2" styleClass="contentlabelform">
					<h:outputText value="#{jspMsg['link.rentalCalculate']}" styleClass="ms7" />
				<h:selectOneMenu id="serviceTypeId" value="#{semmel014Bean.serviceCalTypeIdToCal}" 
                      onchange="doChangeValue();">     
                    <f:selectItems value="#{semmel014Bean.serviceTypeToCalList}"/>
                </h:selectOneMenu> 
                
         <a4j:jsFunction name="doChangeValue" action="#{semmel014Action.doChangeValue}" reRender="frmServiceCalSaveDialog,servicePercent,massage" >
         </a4j:jsFunction>
					<rich:dataTable id="servicePercent" value="#{semmel014Bean.serviceNameListShowTbl}"
						var="serviceTbl" rows="5" border="2">
						<rich:column width="100" rendered="#{semmel014Bean.serviceCalTypeIdToCal eq '02' || semmel014Bean.serviceCalTypeIdToCal eq '03' || semmel014Bean.serviceCalTypeIdToCal eq '04'}">					
							<h:outputText value="#{serviceTbl.serviceName}" styleClass="ms7" />
						</rich:column>				
						<h:inputText value="#{serviceTbl.inputPercent}"></h:inputText>
						<rich:column width="80" rendered="#{semmel014Bean.serviceCalTypeIdToCal eq '02'}"  >
							<h:inputText id="inputPercent" value="#{serviceTbl.inputPercent}"   maxlength="3" 
								styleClass="ms7"  onblur="test();"/><h:outputText value="%" styleClass="ms7"  />
								<a4j:jsFunction name="test" reRender="frmServiceCalSaveDialog,servicePercent"> </a4j:jsFunction>
								
						</rich:column>
						<rich:column width="80" rendered="#{semmel014Bean.serviceCalTypeIdToCal eq '03'}" >
							<h:inputText value="#{serviceTbl.inputAmt}" id="inputAmout"
								styleClass="ms7" onblur="test();"/>
								<a4j:jsFunction name="test" reRender="frmServiceCalSaveDialog,servicePercent"> </a4j:jsFunction>
						</rich:column>	
						<rich:column width="80" rendered="#{semmel014Bean.serviceCalTypeIdToCal eq '04'}" >
							<h:inputText value="#{serviceTbl.configRate}" styleClass="ms7" disabled="true" />
						</rich:column>				
					</rich:dataTable>		
					
								
						<a4j:commandButton value="Ok" styleClass="rich-button" action="#{semmel014Action.doSaveServiceCal}" immediate="true" 
							reRender="frmServiceCalSaveDialog,showCalType,massage" oncomplete="if(#{semmel014Bean.vMessage eq null})#{rich:component('serviceCalDialog')}.hide();">
							
						</a4j:commandButton>
					
							<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true">
						    <rich:componentControl for="serviceCalDialog" operation="hide" event="onclick" />
							</a4j:commandButton>
					</h:panelGrid>
				</td>
			</tr>
			
			<h:outputText id="massage" value="#{semmel014Bean.vMessage}" rendered="#{semmel014Bean.vMessage ne null}" styleClass="ms8red"  />
			
		</table>
	</a4j:form>
</rich:modalPanel>