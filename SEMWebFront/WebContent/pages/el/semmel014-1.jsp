<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<f:loadBundle basename="resources.el.semmel014" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel id="pnlEl">
		<f:facet name="header"><h:outputText value="#{jspMsg['header.frmVerify']}" /></f:facet>
		<h:panelGrid columnClasses="gridContent" width="90%">
			
			<a4j:form id="frmElVerify">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="true">
                        
                        <f:facet name="errorMarkerSub">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
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
													<a4j:commandLink value="#{jspMsg['link.el']}" style="font-size:12px;">
													</a4j:commandLink>
												</td>
												<td width="7%" align="left">
													<a4j:commandLink value="#{jspMsg['link.bail']}" action="#{navAction.navi}" 
													reRender="oppContent" style="font-size:12px;">
														<a4j:actionparam name="navModule" value="el" />
														<a4j:actionparam name="navProgram" value="SEMMEL014-2" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="initBail" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
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
														<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
														<a4j:actionparam name="moduleWithNavi" value="el" />
														<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
														<a4j:actionparam name="methodWithNavi" value="doELPrivateVerify" />
														<a4j:actionparam name="mode" value="SEARCH" />
														<a4j:actionparam name="electricId" value="#{semmel014Bean.verMaster.electricId}"/>
														<a4j:actionparam name="pageNo" value="1"/>
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
					<rich:panel id="pnlExpenses">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.expenses']}"/>
						</f:facet> 
						
						<rich:dataTable id="dtbVerExpenses" width="95%" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel014Bean.verifyCondList}"
								rows="#{semmel014Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" >
								
									<f:facet name="header">
									</f:facet>
									
									<div align="center" style="">
										<h:selectBooleanCheckbox id="verCondSelected" value="#{wrapper.selected}"
										disabled="#{wrapper.verifyCondSP.verFlag != 'Y'}">
										<a4j:support event="onclick" reRender="pnlExpenses,pnlAddDetail" 
											action="#{semmel014Action.doSelectedVerSetup}">
											<a4j:actionparam name="rowId" value="#{wrapper.verifyCondSP.rowId}"/>
											<a4j:actionparam name="siteInfoId" value="#{wrapper.verifyCondSP.siteInfoId}"/>
											<a4j:actionparam name="payPeriodType" value="#{wrapper.verifyCondSP.payPeriodType}"/>
										</a4j:support>
									</h:selectBooleanCheckbox>
									</div>
								</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.electricUseType']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.electricUseTypeDesc}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.electricOwnerType']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.electricOwnerTypeDesc}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.service']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.serviceName}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.payPeriodType']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.payPeriodTypeDesc}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.periodAmt']}" />
											
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.takeAllAmt}" >
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    		</h:outputText>
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.unitPrice']}" />
											
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.unitPriceAmt}" >
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                   			 </h:outputText>
										</div>
											
									</rich:column>
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.vat']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.vatTypeDesc}" />
										</div>
											
									</rich:column>
									
									
									
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.effectiveDt']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.effectiveDtStr}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.expireDt']}" />
										</f:facet>
										
										<div align="center">
											<h:outputText value="#{wrapper.verifyCondSP.expireDtStr}" />
										</div>
											
									</rich:column>
									
									<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
								
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.remark']}" />
										</f:facet>
										
										<div align="left">
											<h:outputText value="#{wrapper.verifyCondSP.remark}" />
										</div>
											
									</rich:column>
									
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmel014Bean.verifyCondList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<rich:column colspan="18">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVerExpenses"
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
							<h:outputText value="#{jspMsg['header.addDetail']}"/>
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
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.meterNo']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputText id="meterNoTxt" value="#{semmel014Bean.verifySP.meterId}" size="30" style="width : 160px"/>
										</td>
										
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.actionDate']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<rich:calendar id="verEffectiveDt"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy"
												value="#{semmel014Bean.verifySP.effectiveDt}" 
												oninputblur="validateRichPeriodFromTo('frmElVerify','verEffectiveDt','verExpireDt','verExpireDt');"
									 			oncollapse="validateRichPeriodFromTo('frmElVerify','verEffectiveDt','verExpireDt','verExpireDt');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar> 
											<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
											<rich:calendar id="verExpireDt"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.date']}"
												value="#{semmel014Bean.verifySP.expireDt}"
												oninputblur="validateRichCalendarFromTo('frmElVerify','verExpireDt','verEffectiveDt');"
									 			oncollapse="validateRichCalendarFromTo('frmElVerify','verExpireDt','verEffectiveDt');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
										
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.electricOwnerType']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputText id="elOwnerTypeTxt" value="#{semmel014Bean.verifySP.electricOwnerTypeDesc}" size="30" style="width : 160px"/>
										</td>
										
					                </tr>
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.unitPrice']} :" styleClass="ms7" />
										</td>
										<td width="35%">
											<h:inputText id="unitPriceTxt" value="#{semmel014Bean.verifySP.unitPriceAmt}" 
											size="30" style="width : 160px" disabled="false"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.bath']}" styleClass="ms7" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.noUnitPrice']} :" styleClass="ms7" />
											<h:selectBooleanCheckbox id="chkCurrentFlag" value="#{semmel014Bean.verifySP.chkNoUnitPrice}" 
											onclick="clickNoUnitPrice();"/>
											<a4j:jsFunction name="clickNoUnitPrice" action="#{semmel014Action.clickNoUnitPrice}"
											reRender="unitPriceTxt,unitPriceAmtTemp"></a4j:jsFunction>
										</td>

										<td align="right" width="25%">
											
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentPrice']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText id="sumPriceTxt" value="#{semmel014Bean.verifySP.takeAllAmt}" size="10" style="width : 80px"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.bath']} /" styleClass="ms7" />
											<rich:spacer width="5"/>
											<h:selectOneMenu id="ddlPeriodType1" value="#{semmel014Bean.verifySP.takeAllPeriodType}"  >										
												<f:selectItems value="#{semmel014Bean.periodTypeList}" />											
											</h:selectOneMenu>											
										</td>
					                </tr>
					                
					                <tr>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
										</td>
										<td >
											<h:selectOneRadio id="rbtSpecialWhtType1" styleClass="ms7" layout="pageDirection" 
												value="#{semmel014Bean.verifySP.whtType}" >
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']}" />
									            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}" />
									            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']}" />
											</h:selectOneRadio>
										</td>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.whtRate']} :" styleClass="ms7" />
										</td>
										<td  valign="top">
											<h:inputText size="5" value="#{semmel014Bean.verifySP.whtRate}"/>
											<h:outputText value="#{jspMsg['label.percent']}" styleClass="ms7"/>
										</td>
									</tr>
					                
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.vat']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:selectOneRadio id="vatTypeRbt" 
										 	 value="#{semmel014Bean.verifySP.vatType}"
										 	 layout="lineDirection"	styleClass="ms7" rendered="true" >
												<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.includeVat']}"  />
												<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.notIncludeVat']}" />
												<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
												<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.exceptVat']}" />	
											</h:selectOneRadio>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.vatRate']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText id="vatRateTxt" value="#{semmel014Bean.verifySP.vatRate}" size="10" style="width : 80px"/>
											<rich:spacer width="5"/>
											<h:outputText value="%" styleClass="ms7" />
										</td>
					                </tr>
					                <tr>
					                 	<td align="right" width="25%">
						                 	<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.payPeriodType']} :" styleClass="ms7" />
										</td>
										<td colspan="3" align="left">
											
						                		<h:panelGrid columns="5" style="padding: 0 ; margin:0;">
						                			<h:panelGroup style="padding: 0 ; margin:0;">
						                						<h:selectOneRadio id="rbtPayPeriodType" styleClass="ms7" 
						                						value="#{semmel014Bean.verifySP.payPeriodType}" onclick="chkPayPeriodJS();" >
						                						<a4j:jsFunction name="chkPayPeriodJS" 
						                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
						                							action="#{semmel014Action.chkPayPeriodType}">
						                							<a4j:actionparam name="type" value="1" />
						              							</a4j:jsFunction>
																<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']}" />
													            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}" />
													            <f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']}" />
											            		<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']}" />
													            <f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']}" />
															</h:selectOneRadio>
						                				</h:panelGroup>
						                				<h:panelGroup>
						                					<h:selectOneRadio id="rbtPayPeriodType3" styleClass="ms7" 
						                						value="#{semmel014Bean.verifySP.period3}" onclick="chkPayPeriodJS3();">
						                						<a4j:jsFunction name="chkPayPeriodJS3" 
						                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
						                							action="#{semmel014Action.chkPayPeriodType}">
						                							<a4j:actionparam name="type" value="2" />
						              							</a4j:jsFunction>
																<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.rai']}" />
															</h:selectOneRadio>
						                				</h:panelGroup>
						                				<h:panelGroup>
						                					<h:inputText id="month" size="2" value="#{semmel014Bean.verifySP.payPeriodMonth}" 
						                						disabled="#{semmel014Bean.verifySP.period3 != '03'}" 
						                						maxlength="4" style="text-align: center;"
						                						onchange="chkPayPeriodJS5();"
						                						onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
						                						<a4j:jsFunction name="chkPayPeriodJS5" 
						                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
						                							action="#{semmel014Action.chkPayPeriodType}">
						                							<a4j:actionparam name="type" value="2" />
						              							</a4j:jsFunction>
						                						</h:inputText>
						                						<rich:spacer 
						                						width="2"/><h:outputText value="#{jspMsg['label.month']}" styleClass="ms7" />
						                				</h:panelGroup>
						                				<h:panelGroup>
						                					<h:selectOneRadio id="rbtPayPeriodType4" styleClass="ms7" 
						                						value="#{semmel014Bean.verifySP.period4}" onclick="chkPayPeriodJS4();" >
						                						<a4j:jsFunction name="chkPayPeriodJS4" 
						                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2,year" 
						                							action="#{semmel014Action.chkPayPeriodType}">
						                							<a4j:actionparam name="type" value="3" />
						              							</a4j:jsFunction>
																<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.rai']}" />
															</h:selectOneRadio>
						                				</h:panelGroup>
						                				<h:panelGroup>
						                					<h:inputText id="year" size="2" value="#{semmel014Bean.verifySP.payPeriodYear}" 
						                						disabled="#{semmel014Bean.verifySP.period4 != '04'}" 
						                						maxlength="2" style="text-align: center;"
						                						onchange="chkPayPeriodJS6();"
						                						onkeypress="return numberformat.keyPressIntegerOnly(this, event);">
						                						<a4j:jsFunction name="chkPayPeriodJS6" 
						                							reRender="rbtPayPeriodType,rbtPayPeriodType3,month,rbtPayPeriodType4,year,txtTotPeriodNo,txtPeriodAmt,txtPeriodAmt2" 
						                							action="#{semmel014Action.chkPayPeriodType}">
						                							<a4j:actionparam name="type" value="3" />
						              							</a4j:jsFunction>
						                						</h:inputText>
						                						<rich:spacer 
						                						width="2"/><h:outputText value="#{jspMsg['label.year']}" styleClass="ms7" />
						                					</h:panelGroup>
						                					
						                		</h:panelGrid>
										</td>
									</tr>
									<tr>
										<td align="right" width="25%">
											<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.startPeriodDt']} :" styleClass="ms7" />
										</td>
										<td width="25%" >
											<rich:calendar id="verPeriodStartDt"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy"
												value="#{semmel014Bean.verifySP.periodStartDt}" 
												oninputblur="validateRichPeriodFromTo('frmElVerify','verPeriodStartDt','verPeriodEndDt','verExpireDt');"
									 			oncollapse="validateRichPeriodFromTo('frmElVerify','verPeriodStartDt','verPeriodEndDt','verExpireDt');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar> 
										</td>
										<td align="right" width="25%">
											<!--<h:graphicImage value="images/icon_required.gif"/> -->
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.endPeriodDt']} :" styleClass="ms7" />
										</td>
										<td width="25%" >	
											<rich:calendar id="verPeriodEndDt"
												locale="th/TH" enableManualInput="TRUE"
												datePattern="dd/MM/yyyy" converterMessage="#{jspMsg['msg.invalid.date']}"
												value="#{semmel014Bean.verifySP.periodEndDt}"
												oninputblur="validateRichCalendarFromTo('frmElVerify','verPeriodEndDt','verPeriodStartDt');"
									 			oncollapse="validateRichCalendarFromTo('frmElVerify','verPeriodEndDt','verPeriodStartDt');"
												showWeeksBar="false" inputStyle="width : 80px">
											</rich:calendar>
										</td>
									</tr>
									
									<tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.periodAmt']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputText id="periodAmtTxt" value="#{semmel014Bean.verifySP.totPeriodNo}" size="30" style="width : 160px"/>
										</td>
										
					                </tr>
					                
					                <tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.service']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">					
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
					                </tr>
					                
					                <tr>
						                <td align="right" width="25%">
						                	<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.periodPrice']} :" styleClass="ms7" />
										</td>
										<td width="25%" >
											<h:inputText id="periodPriceAmtTxt" value="#{semmel014Bean.verifySP.periodAmt}" size="30" style="width : 160px"/>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.unitPriceAmt']} :" styleClass="ms7" />
										</td>
										<td width="25%" >
											<h:inputText id="unitPriceAmtTxt" value="#{semmel014Bean.verifySP.unitPriceAmtTemp}" size="30" style="width : 160px"/>
											<rich:spacer width="5"/>
											<a4j:commandButton id="btnCalculate" value="Calculate" styleClass="rich-button"
												action="#{navAction.navi}" 
												reRender="pnlAddDetail">
							            		<a4j:actionparam name="navModule" value="el" />
												<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
												<a4j:actionparam name="moduleWithNavi" value="el" />
												<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
												<a4j:actionparam name="methodWithNavi" value="doCalculate" />
							            	</a4j:commandButton>
										</td>
					                </tr>
					                
					                <tr>
						                <td align="right" width="25%">
						                	<h:graphicImage value="images/icon_required.gif"/>
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.vendor']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:selectOneMenu id="ddlVendor" value="#{semmel014Bean.verifySP.vendorMasterId}" 
											onchange="onChangeDdlVendorJS()">
												<a4j:jsFunction name="onChangeDdlVendorJS" reRender="pnlAddDetail" 
					                				action="#{semmel014Action.onChangeVendor}">
					                			</a4j:jsFunction>
												<f:selectItems value="#{semmel014Bean.vendorList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeName']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:selectOneMenu id="ddlPayee" value="#{semmel014Bean.verifySP.payeeMasterId}" >
												<f:selectItems value="#{semmel014Bean.payeeList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									
									<tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeBookBank']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText id="payeeBookBankTxt" value="#{semmel014Bean.verifySP.bankAccNo}" size="30" style="width : 160px"/>
										</td>
										<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.payeeBookBankName']} :" styleClass="ms7" />
										</td>
										<td width="25%">
											<h:inputText id="payeeBookBankNameTxt" value="#{semmel014Bean.verifySP.bankName}" size="30" style="width : 160px"/>
										</td>
									</tr>
									
									<tr>
						                <td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.remark']} :" styleClass="ms7" />
										</td>
										<td width="25%" colspan="3">
											<h:inputTextarea id="remarkTxt" value="#{semmel014Bean.verifySP.remark}" rows="5" cols="120"/>
										</td>
									</tr>
									<tr>
										<td width="25%">
										</td>
										<td width="25%" colspan="3">
											<h:panelGrid columns="3" id="grdCommand">
												<a4j:commandButton id="btnAdd" value="Add" styleClass="rich-button" 
													action="#{navAction.navi}" rendered="#{semmel014Bean.verifySP.mode == 'ADD'}"
													reRender="pnlPaymentInfo,pnlAddDetail, pnlExpenses">
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
													<a4j:actionparam name="methodWithNavi" value="doAddEditVerify" />
												</a4j:commandButton>
												<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button" 
													action="#{navAction.navi}" rendered="#{semmel014Bean.verifySP.mode == 'EDIT'}"
								            	 	reRender="pnlPaymentInfo,pnlAddDetail,dtbVerPaymentInfo, pnlExpenses"> 
								            		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
													<a4j:actionparam name="methodWithNavi" value="doAddEditVerify" />
								            	</a4j:commandButton>
								            	<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" 
								            		action="#{navAction.navi}" 
								            	 	reRender="pnlAddDetail,frmServiceCalSaveDialog,servicePercent, pnlExpenses">
								            		<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
													<a4j:actionparam name="moduleWithNavi" value="el" />
													<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
													<a4j:actionparam name="methodWithNavi" value="doClear" />
								            	</a4j:commandButton>
								            </h:panelGrid>
										</td>
									</tr>
					             </table>
					         </h:panelGroup>
					     </h:panelGrid>
						
					</rich:panel>
					
					<!-- Payment Info Panel -->
					<rich:panel id="pnlPaymentInfo">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.paymentInfo']}"/>
						</f:facet> 
						
						<rich:dataTable id="dtbVerPaymentInfo" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel014Bean.verifyDtlList}"
								rows="#{semmel014Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column >
									<f:facet name="header">
										<h:outputText value="Edit" style="width: 40"/>
									</f:facet>
									<div align="center">
										<a4j:commandButton image="images/edit.png" style="height: 15; width: 15;" 
											action="#{navAction.navi}"
											reRender="pnlAddDetail,frmServiceCalSaveDialog,servicePercent, pnlExpenses" title="edit" 
											id="btnEdit">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL014-1" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
											<a4j:actionparam name="methodWithNavi" value="initEdit" />
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
			            					<a4j:actionparam name="navProgram" value="SEMMEL014-1" />	
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
											<a4j:actionparam name="methodWithNavi" value="getVerDel" />
											<a4j:actionparam name="selectedRow" value="#{row}"/>
											<a4j:actionparam name="mode" value="DELETE"/>
										</a4j:commandButton>
									</div>
								</rich:column>
									
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterNo']}" style="width: 130"/>
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.meterId}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.electricOwnerType']}" style="width: 80"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.electricOwnerTypeDesc}" />
									</div>
										
								</rich:column>
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.service']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.serviceName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.serviceCalType']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.electricCalDesc}" />
									</div>
										
								</rich:column>	
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.periodAmt']}" />
									</f:facet>
									
									<div align="right">
										<h:outputText value="#{wrapper.verifyCondSP.periodAmt}" >
											<f:convertNumber pattern="#,##0.00"/>
										</h:outputText>
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payPeriodType']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.payPeriodTypeDesc}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.wht']}" style="width: 40"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.whtTypeName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 40"/>
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.vatTypeDesc}" />
									</div>
										
								</rich:column>
						
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.vendorName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeeName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.payeeName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.effectiveDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.effectiveDtStr}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expireDt']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.expireDtStr}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.remark}" />
									</div>
										
								</rich:column>
									
									
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel014Bean.verifyDtlList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="18">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVerPaymentInfo"
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
					
					<!-- History Panel -->
					<rich:panel id="pnlHistory">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.history']}"/>
						</f:facet> 
						
						<rich:dataTable id="dtbVerHist" cellpadding="0"
								cellspacing="0" border="0" var="wrapper"
								value="#{semmel014Bean.verifyHistList}"
								rows="#{semmel014Bean.rowPerPage}"
								onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
								onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<rich:column style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}" rendered="false">
								
									<f:facet name="header">
									</f:facet>
									
									<div align="center" style="">
										<h:selectBooleanCheckbox id="electricManageSelected" value="#{wrapper.selected}">
											<a4j:support event="onclick" action="#{semmel014Action.selectRow}" reRender="grdActionCommand,btnReceiveGroup" />
										</h:selectBooleanCheckbox>
									</div>
								</rich:column>
									
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.meterNo']}" style="width: 130"/>
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.meterId}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.electricOwnerType']}" style="width: 80"/>
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.electricOwnerTypeDesc}" />
									</div>
										
								</rich:column>
							<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.service']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.serviceName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.serviceCalType']}" />
									</f:facet>
									
									<div align="center">
										<h:outputText value="#{wrapper.verifyCondSP.electricCalDesc}" />
									</div>
										
								</rich:column>		
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.periodAmt']}" />
									</f:facet>
									
									<div align="left"> 
										<h:outputText value="#{wrapper.verifyCondSP.periodAmt}" >
											<f:convertNumber pattern="#,##0.00"/>
										</h:outputText>
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payPeriodType']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.payPeriodType}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vat']}" style="width: 40"/>
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.vatTypeDesc}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.service']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.service}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.vendor']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.vendorName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.payeeName']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.payeeName}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.effectiveDt']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.effectiveDtStr}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.expireDt']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.expireDtStr}" />
									</div>
										
								</rich:column>
								
								<rich:column  style="#{(semmel014Bean.selectedRowIndex==row)?'background-color: #FFE4E1':''}">
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['column.header.remark']}" />
									</f:facet>
									
									<div align="left">
										<h:outputText value="#{wrapper.verifyCondSP.remark}" />
									</div>
										
								</rich:column>
									
									
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="4">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel014Bean.verifyHistList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="18">
											<rich:datascroller immediate="true" rendered="true" align="left" for="dtbVerHist"
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
									<td align="right" width="25%">
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
							reRender="pnlPaymentInfo,pnlAddDetail, pnlExpenses" >
							<a4j:actionparam name="navModule" value="el" />
		            		<a4j:actionparam name="navProgram" value="SEMMEL014-1" />	
							<a4j:actionparam name="moduleWithNavi" value="el" />
							<a4j:actionparam name="actionWithNavi" value="SEMMEL014" />
							<a4j:actionparam name="methodWithNavi" value="doDelete" />							
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

