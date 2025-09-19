<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.el.semmel008-1" var="jspMsg" />

<h:panelGrid width="100%">

	<rich:panel id="pnlSearch">

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
                        <a4j:commandButton id="mel008_BtnBack" value="Back" styleClass="rich-button"
                                    rendered="#{semmel008Bean.renderedOnToDoList}"
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

		<h:panelGrid columnClasses="gridContent">

			<a4j:form id="frmSearch">

				<!-- begin content layout criteria -->
				
				<h:panelGrid style="width: 98%">

					<rich:panel id="pnlSearchCriteria">

						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}" />
						</f:facet>

						<!-- begin content criteria -->
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table width="100%">
									<tr>
										<td align="right" valign="bottom">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7" />
										</td>
										<td colspan="3">
											<a4j:region>
											<h:selectOneMenu value="#{semmel008Bean.searchCriteria.company}" style="width : 160px">
			                					<f:selectItems value="#{semmel008Bean.companyList}" />
			                					<a4j:support event="onchange" action="#{semmel008Action.doChangeCompany}" reRender="bigCompany" />
			                				</h:selectOneMenu>
			                				<rich:spacer width="5"/>
			                				<h:outputText id="bigCompany" value="#{semmel008Bean.companyBigLabel}" styleClass="ms28"/>
			                				</a4j:region>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.contractNo}" size="30" 
											style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.locationid']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.locationId}" size="30" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											
											<h:outputText value="#{jspMsg['label.locationcode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.locationCode}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.sitecode']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.siteCode}" size="30" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										
										<td align="right">
											<h:outputText value="#{jspMsg['label.siteName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.siteName}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											
											<h:outputText value="#{jspMsg['label.service']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel008Bean.searchCriteria.serviceType}" style=" height : 19px;">
												<f:selectItems value="#{semmel008Bean.serviceList}"/>
											</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.electricUseType']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel008Bean.searchCriteria.electricUseType}" 
											style="width : 160px" onchange="renderedCondSubType">
		                						<f:selectItems value="#{semmel008Bean.electricUseTypeList}" />
		                					</h:selectOneMenu>
		                					<a4j:jsFunction name="renderedCondSubType" reRender="mel008_condSubType"></a4j:jsFunction>
		                					<rich:spacer width="5"></rich:spacer>	                					
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel008Bean.searchCriteria.region}" style="width : 160px">
		                						<f:selectItems value="#{semmel008Bean.regionList}" />
		                					</h:selectOneMenu>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.vendorId']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.vendorId}" 
											size="30" style="width : 160px; margin-right:5px;"/>
											
											<!-- >> fixed by.. YUT 2015/10/18 -->
				                			<a4j:commandButton id="btnAddVendor" value="..." styleClass="rich-button" 
								            action="#{semmel008Action.initAddVendor}" reRender="oppContent"
								            oncomplete="#{rich:component('mel008PopUp_addVendor')}.show(); return false">
											</a4j:commandButton>
				                			<!-- << -->	
										</td>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.vendorName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.vendorName}" size="30" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.payeeName}" size="30" style="width : 160px"/>
										</td>
										<td align="right"><h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
															<rich:spacer width="5"></rich:spacer>
															<h:outputText value="#{jspMsg['label.docNo']}" styleClass="ms7" /></td>
										<td><h:inputText value="#{semmel008Bean.searchCriteria.docNo}" size="30" style="width : 160px"/></td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel008Bean.searchCriteria.expenseType}" style="width : 160px">
		                						<f:selectItems value="#{semmel008Bean.expenseTypeList}" />
		                					</h:selectOneMenu>
										</td>
										<td align="right">
											<h:graphicImage value="images/icon_required.gif" />
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="ddlPaymentStatus" value="#{semmel008Bean.searchCriteria.paymentStatus}" style="width : 160px"
											onchange="reRenderRcptPayChkBox();">
		                						<f:selectItems value="#{semmel008Bean.paymentStatusList}" />
		                					</h:selectOneMenu>
		                					
		                					<!-- fixed by.. YUT 2014/09/16 >> -->
											<a4j:jsFunction name="reRenderRcptPayChkBox" reRender="rcptPayChkBox" oncomplete="rcptChk();"></a4j:jsFunction>
											<script type="text/javascript">
												function rcptChk(){
													jQuery(function($) {
														var payStat = $('#incContent\\:frmSearch\\:ddlPaymentStatus');
														var payChk = $('#incContent\\:frmSearch\\:rcptPayChkBox');
			
														if(payStat.val() != '13') {
															payChk.attr('checked', false);
														} 
													});
												}
											</script>
											<rich:spacer width="10"/>
											<h:selectBooleanCheckbox id="rcptPayChkBox" value="#{semmel008Bean.chkRcptPay}"   
											disabled="#{semmel008Bean.searchCriteria.paymentStatus == '13' ? false : true}"/>
											<rich:spacer width="5"/>
											<h:outputText value="#{jspMsg['label.paySome']}" styleClass="ms7"/>
											<!-- fixed by.. YUT 2014/09/16 << -->
		                					
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu value="#{semmel008Bean.searchCriteria.paymentType}" style="width : 160px">
		                						<f:selectItems value="#{semmel008Bean.paymentTypeList}" />
		                					</h:selectOneMenu>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7" />
										</td>
										<td>
											<rich:calendar 
												locale="th/TH" enableManualInput="true"
												datePattern="dd/MM/yyyy"
												value="#{semmel008Bean.searchCriteria.transferDt}"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												showWeeksBar="false" inputStyle="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.chqPostingDt']}" styleClass="ms7" />
										</td>
										<td>
											<rich:calendar 
												locale="th/TH" enableManualInput="true"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												datePattern="dd/MM/yyyy"
												value="#{semmel008Bean.searchCriteria.chqPostingDt}"
												showWeeksBar="false" inputStyle="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.chqReceivedDt']}" styleClass="ms7" />
										</td>
										<td>
											<rich:calendar 
												locale="th/TH" enableManualInput="true"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												datePattern="dd/MM/yyyy"
												value="#{semmel008Bean.searchCriteria.chqReceivedDt}"
												showWeeksBar="false" inputStyle="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.createdBy']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.createBy}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.createDt']}" styleClass="ms7" />
										</td>
										<td>
											<rich:calendar 
												locale="th/TH" enableManualInput="true"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												datePattern="dd/MM/yyyy"
												value="#{semmel008Bean.searchCriteria.createDt}"
												showWeeksBar="false" inputStyle="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.sentDt']}" styleClass="ms7" />
										</td>
										<td>
											<rich:calendar 
												locale="th/TH" enableManualInput="true"
												oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
												datePattern="dd/MM/yyyy"
												value="#{semmel008Bean.searchCriteria.sentPaymentDt}"
												showWeeksBar="false" inputStyle="width : 160px"/>
										</td>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.batchNo']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.batchNo}" size="30" style="width : 160px"/>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.doc92']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.doc92}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.doc68']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.doc68}" size="30" style="width : 160px"/>
										</td>		                					
									</tr>
									<tr>
										<td align="right">
											<h:outputLabel style="color:blue;size:20px;text-valign:baseline;" value="*"  />
											<rich:spacer width="5"></rich:spacer>
											<h:outputText value="#{jspMsg['label.chqNo']}" styleClass="ms7" />
										</td>
										<td>
											<h:inputText value="#{semmel008Bean.searchCriteria.chqNo}" size="30" style="width : 160px"/>
										</td>
										<td align="right">
											
										</td>
										<td>
											
										</td>		                					
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.picoCell']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectBooleanCheckbox value="#{semmel008Bean.siteType}"/>
										</td>
										<td align="right">
											<h:outputText value="#{jspMsg['label.orderBy']}" styleClass="ms7" />
										</td>
										<td>
											<h:selectOneMenu id="orderById" value="#{semmel008Bean.searchCriteria.orderBy}" style="width : 160px">
		                						<f:selectItems value="#{semmel008Bean.orderByList}" />
		                					</h:selectOneMenu>
										</td>		                					
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.dueDtFrom']} " styleClass="ms7" />
										</td>
										<td>
											<a4j:region>
															<!-- begin date -->
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmel008Bean.searchCriteria.periodStartDt}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   label=""
															   	   styleClass="ms7">
															</rich:calendar>
															
															<rich:spacer width="50"></rich:spacer>
															<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7" />
															<!-- end date -->
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmel008Bean.searchCriteria.periodEndDt}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   label=""
															   	   styleClass="ms7">
															</rich:calendar>
														</a4j:region>
										</td>
										<td align="right">
											
										</td>
										<td>
											
										</td>		                					
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<!-- end content criteria -->
						
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="#{jspMsg['btn.seach']}" styleClass="rich-button" action="#{navAction.navi}" reRender="pnlSearchResultHeader, frmError, grdActionCommand, pnlSearchResult, pngCount">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:region>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button" action="#{navAction.navi}" reRender="pnlSearchCriteria, frmError, grdActionCommand, pnlSearchResult">
								<a4j:actionparam name="navModule" value="el" />
								<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
								<a4j:actionparam name="moduleWithNavi" value="el" />
								<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />
							</a4j:commandButton>
							</a4j:region>
						</h:panelGrid>
					</rich:panel>
					<a4j:region>
					<rich:panel>

						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.count.name']}" />
						</f:facet>
						
						<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1" id="pngCount">
							
							<h:panelGroup>
							
								<table width="100%">
									<tr>
										<td width="15%" align="right">
											<h:outputText value="#{jspMsg['label.totalPayment']}" styleClass="ms7" />
										</td>
										<td>
											<h:outputText value="#{semmel008Bean.payment0102Count}" styleClass="ms7" />
										</td>
										<td  width="15%" align="right">
											<h:outputText value="#{jspMsg['label.totalStatus02']}" styleClass="ms7" />
										</td>
										<td>
											<h:outputText value="#{semmel008Bean.payment02Count}" styleClass="ms7" />
										</td>
										<td  width="15%" align="right">
											<h:outputText value="#{jspMsg['label.totalStatus01']}" styleClass="ms7" />
										</td>
										<td>
											<h:outputText value="#{semmel008Bean.payment01Count}" styleClass="ms7" />
										</td>
									</tr>
								</table>
								
							</h:panelGroup>
							
						</h:panelGrid>
						
					</rich:panel>
					</a4j:region>
				</h:panelGrid>
				
				<!-- end content layout criteria -->
				
			</a4j:form>
			<a4j:region>
			<a4j:form id="frmResult" >
			
				<!-- begin content button -->
				
				
					
					           		<table style="vertical-align: bottom;" border="0" > 
										<tr>
											<td>
												
											</td>
											
											<td>
												<h:panelGrid id="mel008_btnPanel3">
													<h:panelGroup>
														<a4j:commandButton id ="btnExport" rendered="false"
															           		 styleClass="rich-button" value="Export"
															           		 reRender="frmError" >
													            			</a4j:commandButton>
														
														
													            			
													    <a4j:commandButton id ="btnExportRemark" value="#{jspMsg['btn.exportRemark']}" 
													    styleClass="rich-button" 
														rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
														action="#{semmel008Action.doOpenAlertMessage}" 
														oncomplete="#{rich:component('alertMessage')}.show(); return false" 
														disabled="#{!semmel008Bean.commandButtonEnable}" 
														style="width:110px"
														reRender="alertMessage">
														
															<a4j:actionparam name="msgFor" value="EXPORT_RE" />
														
														</a4j:commandButton>
													            			
													            			
													     <a4j:commandButton id="btnExportLetterId" value="Export Letter" styleClass="rich-button" 
										                     disabled="#{!semmel008Bean.commandButtonEnable}"
										                     rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
										                     action="#{navAction.navi}" reRender="frmError,pnlShowReportEpt"
										                     style=" width : 100px;">
										                      <a4j:actionparam name="navModule" value="el" />
										                      <a4j:actionparam name="navProgram" value="SEMMEL008-1" />
										                      <a4j:actionparam name="moduleWithNavi" value="el" />
										                      <a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
										                      <a4j:actionparam name="methodWithNavi" value="doExportLetter" />
										                    </a4j:commandButton>
													</h:panelGroup>
												</h:panelGrid>
											</td>
										</tr>
										<tr style="vertical-align: bottom;">
											<td>
											
												<h:panelGrid id="mel008_btnPanel">
													<h:panelGroup>
														<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" 
												action="#{semmel008Action.doOpenAlertMessage}" 
												oncomplete="#{rich:component('alertMessage')}.show(); return false" 
												disabled="#{!semmel008Bean.commandButtonEnable}" reRender="alertMessage"
												rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}" style="width:110px">
													<a4j:actionparam name="msgFor" value="CANCEL" />
												</a4j:commandButton>
												
												<rich:spacer width="5"></rich:spacer>
												
												<a4j:commandButton style="width:65px" value="#{jspMsg['btn.collective']}" styleClass="rich-button" 
												action="#{semmel008Action.doOpenAlertMessage}" 
												oncomplete="#{rich:component('alertMessage')}.show(); return false" 
												disabled="#{!semmel008Bean.commandButtonEnable}" reRender="alertMessage"
												rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}">
													<a4j:actionparam name="msgFor" value="COLLECTIVE" />
												</a4j:commandButton>
												
												<rich:spacer width="5"></rich:spacer>
												
												<a4j:commandButton value="#{jspMsg['btn.cancelCollective']}" 
												rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
												styleClass="rich-button" action="#{semmel008Action.doOpenAlertMessage}" 
												style="width:100px;"
												oncomplete="#{rich:component('alertMessage')}.show(); return false" disabled="#{!semmel008Bean.commandButtonEnable}" reRender="alertMessage">
													<a4j:actionparam name="msgFor" value="CANCEL_COLLECTIVE" />
												</a4j:commandButton>
												
												<rich:spacer width="5"></rich:spacer>
												
												<a4j:commandButton value="#{jspMsg['btn.sent']}" style="width:60px" styleClass="rich-button" 
												rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
												action="#{semmel008Action.doOpenAlertMessage}" oncomplete="#{rich:component('alertMessage')}.show(); return false" disabled="#{!semmel008Bean.commandButtonEnable}" reRender="alertMessage">
													<a4j:actionparam name="msgFor" value="SEND" />
												</a4j:commandButton>
												
												
												<a4j:commandButton style="width:95px;" value="#{jspMsg['btn.cancelSent']}" styleClass="rich-button" 
												rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
												action="#{semmel008Action.doOpenAlertMessage}" oncomplete="#{rich:component('alertMessage')}.show(); return false" disabled="#{!semmel008Bean.commandButtonEnable}" reRender="alertMessage">
													<a4j:actionparam name="msgFor" value="CANCEL_SEND" />
												</a4j:commandButton>
												
												<rich:spacer width="5"></rich:spacer>
												
												<a4j:commandButton value="#{jspMsg['btn.export']}" styleClass="rich-button" 
												rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
												action="#{semmel008Action.doOpenAlertMessage}" 
												oncomplete="#{rich:component('alertMessage')}.show(); return false" 
												disabled="#{!semmel008Bean.commandButtonEnable}" 
												style="width:110px"
												reRender="alertMessage">
												<a4j:actionparam name="msgFor" value="EXPORT" />
												</a4j:commandButton>
												
												
												<h:commandButton value="#{jspMsg['btn.printChq']}" styleClass="rich-button" 
												rendered="false"
												action="#{semmel008Action.doPrintChq}" disabled="#{!semmel008Bean.commandButtonEnable}"/>
												<h:commandButton value="#{jspMsg['btn.printTransfer']}" styleClass="rich-button" 
												rendered="false"
												action="#{semmel008Action.doPrintTransfer}" disabled="#{!semmel008Bean.commandButtonEnable}"/>
												<a4j:commandButton value="#{jspMsg['btn.accept']}" styleClass="rich-button" 
												rendered="#{semmel008Bean.rendererSSO['btnSMBAP001']}"
												style="width:95px"
												action="#{semmel008Action.doOpenAlertMessage}" oncomplete="#{rich:component('alertMessage')}.show(); return false" disabled="#{!semmel008Bean.commandButtonEnable}" reRender="alertMessage">
													<a4j:actionparam name="msgFor" value="ACCEPT" />
												</a4j:commandButton>
												<a4j:commandButton value="#{jspMsg['btn.notAccept']}" 
												style="width:105px"
												rendered="#{semmel008Bean.rendererSSO['btnSMBAP001']}"
												styleClass="rich-button" action="#{semmel008Action.doOpenReject}" oncomplete="#{rich:component('reject')}.show(); return false" disabled="#{!semmel008Bean.commandButtonEnable}" reRender="reject"/>
												
												<rich:spacer width="5"/>
												           		
												           		<a4j:commandButton id="btnCopyDate" value="#{jspMsg['btn.copyDate']}" styleClass="rich-button" 
												           		 style="width:125" action="#{navAction.navi}">
												           		 				
												           		 				<a4j:actionparam name="navModule" value="rt" />
																				<a4j:actionparam name="navProgram" value="SEMMRT003-1" />
																				<a4j:actionparam name="moduleWithNavi" value="rt" />
																				<a4j:actionparam name="actionWithNavi" value="SEMMRT003" />
																				<a4j:actionparam name="methodWithNavi" value="initCoppyDate" />
												           		</a4j:commandButton>
													</h:panelGroup>
												</h:panelGrid>
						           			</td>
						           			
						           			<td>
						           				<h:panelGrid id="mel008_btnPanel2">
						           					<h:panelGroup>
						           						<a4j:commandButton id="btnPrint" style="width:60px" styleClass="rich-button"
											           	reRender="frmError,frmResult"
											           	value="#{jspMsg['btn.print']}" 
											           	action="#{navAction.navi}" 
											           	disabled="#{!semmel008Bean.commandButtonEnable}"
											           	rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}">
																	
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
															<a4j:actionparam name="moduleWithNavi" value="report" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL008RPT" />
															<a4j:actionparam name="methodWithNavi" value="doRunReport" />
																		
															<a4j:support event="oncomplete" reRender="frmError,frmResult,pnlShowReportDoc" />
														</a4j:commandButton>
																	
														<a4j:commandButton value="#{jspMsg['btn.exportchq']}" 
														action="#{navAction.navi}"
														reRender="frmError,pnlShowReportChq"
														styleClass="rich-button" style="width:80">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
															<a4j:actionparam name="methodWithNavi" value="doRunExportCheque" />	
														</a4j:commandButton>
																	
																	
																	
																	<a4j:commandButton id="btnPrintTest" style="width:60px" styleClass="rich-button"
										                                       value="#{jspMsg['btn.print']}test" 
										                                       action="#{navAction.navi}" 
										                                       disabled="#{!semmel008Bean.commandButtonEnable}"
										                                       rendered="false">
										                            
										                                <a4j:actionparam name="navModule" value="el" />
										                                <a4j:actionparam name="navProgram" value="SEMMEL008-1" />
										                                <a4j:actionparam name="moduleWithNavi" value="report" />
										                                <a4j:actionparam name="actionWithNavi" value="SEMMEL008RPT" />
										                                <a4j:actionparam name="methodWithNavi" value="doRunReportTest" />
										                                
										                                <a4j:support event="oncomplete" reRender="frmError,frmResult,pnlShowReportDoc" />
										                            </a4j:commandButton>
																	
															<a4j:commandButton id="btnSMS" style="width:85px" value="#{jspMsg['btn.sms']}" styleClass="rich-button"
															action="#{navAction.navi}" reRender="frmError,pnlSearchResult" disabled="#{!semmel008Bean.commandButtonEnable}"
															rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}">
																<a4j:actionparam name="navModule" value="el" />
																<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
																<a4j:actionparam name="moduleWithNavi" value="el" />
																<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
																<a4j:actionparam name="methodWithNavi" value="doSendSMS" />
															</a4j:commandButton>
															
															<!-- Update send EMAIL button BY NEW 24/10/2014 -->
															<a4j:commandButton id="btnEMAIL" style="width:87px" value="#{jspMsg['btn.email']}" styleClass="rich-button"
																	action="#{navAction.navi}" reRender="frmError,pnlSearchResult"
																	disabled="#{!semmel008Bean.commandButtonEnable}"
																	rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}">
																		<a4j:actionparam name="navModule" value="el" />
																		<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
																		<a4j:actionparam name="moduleWithNavi" value="el" />
																		<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
																		<a4j:actionparam name="methodWithNavi" value="doSendEmail" />
															</a4j:commandButton>
															
														<!-- end content button -->
						           					</h:panelGroup>
						           				</h:panelGrid>
						           				
						           			</td>
										</tr>
										<tr style="vertical-align: bottom;">
											<td>
												<h:panelGrid id="mel008_btnPanel4">
													<h:panelGroup>
														<a4j:commandButton id="btnSendSmsOs" value="#{jspMsg['btn.sendSmsos']}"
														styleClass="rich-button" action="#{navAction.navi}" disabled="#{!semmel008Bean.commandButtonEnable}"
														rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
														reRender="pnlSearchOutstanding" style="width:140px;">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
															<a4j:actionparam name="methodWithNavi" value="doSendSMSOS" />
														</a4j:commandButton>
														
														<rich:spacer width="5"></rich:spacer>
														
														<a4j:commandButton id="btnSendEmailOs" value="#{jspMsg['btn.sendEmailos']}"
														styleClass="rich-button" action="#{navAction.navi}" disabled="#{!semmel008Bean.commandButtonEnable}"
														rendered="#{semmel008Bean.rendererSSO['btnSMBPY001']}"
														reRender="pnlSearchOutstanding" style="width:140px;">
															<a4j:actionparam name="navModule" value="el" />
															<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
															<a4j:actionparam name="moduleWithNavi" value="el" />
															<a4j:actionparam name="actionWithNavi" value="SEMMEL008" />
															<a4j:actionparam name="methodWithNavi" value="doSendEmailOS" />
														</a4j:commandButton>
													</h:panelGroup>
												</h:panelGrid>
											</td>
										</tr>
									</table>
								
				
				<h:panelGrid id="pnlShowReportDoc" style="height:0px;width:0px;" width="0px" columns="0" >
					<h:panelGroup id="pnlInShowReport" rendered="#{semmel008RPTBean.displayShowReport}" style="height:0px;width:0px;" >
						<h:commandButton value="Report" id="btnShowReport" style="height:0px;width:0px;display:none;" action="#{semmel008RPTAction.showReport}">
						<script>document.getElementById('incContent:frmResult:btnShowReport').click();</script>
						</h:commandButton>								
					</h:panelGroup>							
				</h:panelGrid>
				
				<!-- begin content layout data grid -->
				<h:panelGrid style="width: 95%">
				
					<rich:panel id="pnlSearchResultHeader" styleClass="sem_autoScrollbar">
					
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.resultTable.name']}"/>
						</f:facet>
						
						<rich:panel id="pnlSearchResult"  >
					
							<!-- begin dataTable -->
							
							<rich:dataTable id="dtbSearchResult" cellpadding="1"
								cellspacing="0" border="0" var="wrapper" reRender="dtbSearchResult"
								value="#{semmel008Bean.paymentWrapperList}"
								rows="#{semmel008Bean.rowPerPage}"
								rowClasses="cur" styleClass="contentform" rowKeyVar="row">
								
								<!-- begin header -->
								
								<f:facet name="header">
									<rich:columnGroup>
										<rich:column id="column0">
											<h:selectBooleanCheckbox value="#{semmel008Bean.chkSelAll}">
												<a4j:support event="onclick" action="#{semmel008Action.selectAllRow}" 
												reRender="grdActionCommand,pnlSearchResult, dtbSearchResult, mel008_btnPanel, mel008_btnPanel2, mel008_btnPanel3,mel008_btnPanel4" />
											</h:selectBooleanCheckbox>
										</rich:column>
							    		<rich:column id="column1" rendered="false"><h:outputText value="#{jspMsg['column.header.saveExpense']}"  /></rich:column>
							    		<rich:column id="column2"><h:outputText value="#{jspMsg['column.header.edit']}" /></rich:column>
							    		<rich:column id="column3"><h:outputText value="#{jspMsg['column.header.view']}" /></rich:column>
							    		<rich:column id="column4"><h:outputText value="#{jspMsg['column.header.contractNo']}" /></rich:column>
							    		<rich:column id="column5"><h:outputText value="#{jspMsg['column.header.previousContractId']}" /></rich:column>
							    		<rich:column id="column6"><h:outputText value="#{jspMsg['column.header.company']}" /></rich:column>
							    		<rich:column id="column7"><h:outputText value="#{jspMsg['column.header.locationid']}" /></rich:column>
							    		<rich:column id="column8"><h:outputText value="#{jspMsg['column.header.locationcode']}" /></rich:column>
							    		<rich:column id="column9"><h:outputText value="#{jspMsg['column.header.sitecode']}" /></rich:column>
							    		<rich:column id="column10" ><h:outputText value="#{jspMsg['column.header.siteName']}" /></rich:column>
							    		<rich:column id="column11"><h:outputText value="#{jspMsg['column.header.service']}" /></rich:column>
							    		<rich:column id="column12" ><h:outputText value="#{jspMsg['column.header.effectDt']}" /></rich:column>
							    		<rich:column id="column13" ><h:outputText value="#{jspMsg['column.header.expireDt']}" /></rich:column>
							    		<rich:column id="column14"><h:outputText value="#{jspMsg['column.header.contractStatus']}" /></rich:column>
							    		<rich:column id="column15"><h:outputText value="#{jspMsg['column.header.networkStatus']}" /></rich:column>
							    		<rich:column id="column16"><h:outputText value="#{jspMsg['column.header.expenseType']}" /></rich:column>
							    		<rich:column id="column17"><h:outputText value="#{jspMsg['column.header.paymentStatus']}" /></rich:column>
							    		<rich:column id="column18"><h:outputText value="#{jspMsg['column.header.docType']}" /></rich:column>
							    		<rich:column id="column19"><h:outputText value="#{jspMsg['column.header.docNo']}" /></rich:column>
							    		<rich:column id="column20"><h:outputText value="#{jspMsg['column.header.docDt']}" /></rich:column>
							    		<rich:column id="column21"><h:outputText value="#{jspMsg['column.header.vendorId']}" /></rich:column>
							    		<rich:column id="column22"><h:outputText value="#{jspMsg['column.header.vendorName']}" /></rich:column>
							    		<rich:column id="column23"><h:outputText value="#{jspMsg['column.header.payeeId']}" /></rich:column>
							    		<rich:column id="column24"><h:outputText value="#{jspMsg['column.header.payeeName']}" /></rich:column>
							    		<rich:column id="column25">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h:outputText value="#{jspMsg['column.header.paymentPeriod']}" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</rich:column>
							    		<rich:column id="column26"><h:outputText value="#{jspMsg['column.header.payAmt']}" /></rich:column>
							    		<rich:column id="column27"><h:outputText value="#{jspMsg['column.header.vatType']}" /></rich:column>
							    		<rich:column id="column28"><h:outputText value="#{jspMsg['column.header.excludeVatAmt']}" /></rich:column>
							    		<rich:column id="column29"><h:outputText value="#{jspMsg['column.header.vatAmt']}" /></rich:column>
							    		<rich:column id="column30"><h:outputText value="#{jspMsg['column.header.includeVatAmt']}" /></rich:column>
							    		<rich:column id="column31"><h:outputText value="#{jspMsg['column.header.whtAmt']}" /></rich:column>
							    		<rich:column id="column32"><h:outputText value="#{jspMsg['column.header.chqAmt']}" /></rich:column>
							    		<rich:column id="column33"><h:outputText value="#{jspMsg['column.header.paymentMethod']}" /></rich:column>
							    		<rich:column id="column34"><h:outputText value="#{jspMsg['column.header.paymentType']}" /></rich:column>
							    		<rich:column id="column35"><h:outputText value="#{jspMsg['column.header.bankName']}" /></rich:column>
							    		<rich:column id="column36"><h:outputText value="#{jspMsg['column.header.bankAccount']}" /></rich:column>
							    		<rich:column id="column37"><h:outputText value="#{jspMsg['column.header.chqPostingDt']}" /></rich:column>
							    		<rich:column id="column38"><h:outputText value="#{jspMsg['column.header.chqReceivedDt']}" /></rich:column>
							    		<rich:column id="column39"><h:outputText value="#{jspMsg['column.header.transferDt']}" /></rich:column>
							    		<rich:column id="column40"><h:outputText value="#{jspMsg['column.header.remark']}" /></rich:column>
							    		<rich:column id="column41"><h:outputText value="#{jspMsg['column.header.batchNo']}" /></rich:column>
							    		<rich:column id="column42"><h:outputText value="#{jspMsg['column.header.rejectReason']}" /></rich:column>
							    		<rich:column id="column43"><h:outputText value="#{jspMsg['column.header.chqNo']}" /></rich:column>
							    		<rich:column id="column44"><h:outputText value="#{jspMsg['column.header.clearingChqDate']}" /></rich:column>
							    		<rich:column id="column45"><h:outputText value="#{jspMsg['column.header.doc68']}" /></rich:column>
							    		<rich:column id="column46"><h:outputText value="#{jspMsg['column.header.doc92']}" /></rich:column>
							    		<rich:column id="column47" ><h:outputText value="#{jspMsg['column.header.doc69']}" /></rich:column>
							    		<rich:column id="column52" ><h:outputText value="#{jspMsg['column.header.receiptno']}" /></rich:column>
							    		<rich:column id="column53" ><h:outputText value="#{jspMsg['column.header.contflowstatus']}" /></rich:column>
							    		<rich:column id="column48"><h:outputText value="#{jspMsg['column.header.paymentChannel']}" /></rich:column>
							    		<rich:column id="column49"><h:outputText value="#{jspMsg['column.sendInfoStatus']}" /></rich:column>
							    		<rich:column id="column50"><h:outputText value="#{jspMsg['column.notDisbursed']}" /></rich:column>
							    		<rich:column id="column51"><h:outputText value="#{jspMsg['column.attachFile']}" style="color:000;"/></rich:column>
							        </rich:columnGroup>
							    </f:facet>
								
								<!-- begin column -->
								
								<rich:subTable value="#{wrapper.paymentList}" var="payment" rowKeyVar="rowKey"
									onRowMouseOver="this.style.backgroundColor='#FFE4E1'"
									onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'"
									rowClasses="cur">						
									
									<a4j:support event="onRowClick" action="#{semmel008Action.doSelectRow}" 
									reRender="pnlSearchResultHeader,grdActionCommand">
									<a4j:actionparam name="row" value="#{row}" />
									</a4j:support>
									
							        <rich:column rowspan="#{wrapper.size}" rendered="#{rowKey eq 0}" style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}"
							        			 title="#{payment.contractNo} : #{payment.siteName}"> 
							        	<div align="left">
								        	<h:selectBooleanCheckbox value="#{wrapper.selected}">
												<a4j:support event="onclick" action="#{semmel008Action.selectRow}" 
												reRender="dtbSearchResult,mel008_btnPanel, mel008_btnPanel2, mel008_btnPanel3,mel008_btnPanel4"/>
											</h:selectBooleanCheckbox>
										</div>
							        </rich:column>
							        <rich:column rowspan="#{wrapper.size}" rendered="false" style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}"
							        			 title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
								        	<a4j:commandLink value="#{jspMsg['column.header.saveExpense']}" oncomplete="#{rich:component('expenseDialog1')}.show(); return false" 
								        		action="#{semmel008Action.doOpenExpensePopup1}" reRender="expenseDialog1" rendered="#{wrapper.visibleSaveExpenseButton1}">
												<a4j:actionparam name="row" value="#{row}" />
											</a4j:commandLink>
											<a4j:commandLink value="#{jspMsg['column.header.saveExpense']}" oncomplete="#{rich:component('expenseDialog2')}.show(); return false" 
												action="#{semmel008Action.doOpenExpensePopup2}" reRender="expenseDialog2" rendered="#{wrapper.visibleSaveExpenseButton2}">
												<a4j:actionparam name="row" value="#{row}" />
											</a4j:commandLink>
										</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<a4j:commandButton value="#{jspMsg['column.header.edit']}" oncomplete="#{rich:component('alertMessage')}.show(); return false" 
											action="#{semmel008Action.doOpenAlertMessage}" reRender="alertMessage" 
											rendered="#{payment.enableEditButton}"
											title="edit" image="images/edit.png" 
											style="height: 15; width: 15;">
											<a4j:actionparam name="msgFor" value="EDIT" />
											<a4j:actionparam name="wrapperRow" value="#{row}" />
											<a4j:actionparam name="paymentRow" value="#{rowKey}" />
										</a4j:commandButton>
										<h:panelGroup rendered="#{!payment.enableEditButton}">
											<img src="images/edit.png" style="filter: Gray"/>
										</h:panelGroup>
							        </rich:column>
							          <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='EL_BILL'}"
							        	action="#{navAction.navi}" reRender="oppContent">
							        		<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="doEditFromMenu8"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='EL_POSTPAID' or payment.expenseTypeCode=='EL_DEBIT' }"
										action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initialEdit3"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="actionFrom" value="SEMMEL008-1"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='EL_TEMP'}" 
										action="#{navAction.navi}" reRender="oppContent">
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initailEdit4"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>										
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='PR_POSTPAID' or payment.expenseTypeCode=='PR_DEBIT'}" 
										action="#{navAction.navi}" reRender="oppContent" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initailEdit5"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='PR_PREPAID'}" 
										action="#{navAction.navi}" reRender="oppContent" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initialEdit6"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='FEE'}" 
										action="#{navAction.navi}" reRender="oppContent" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
											<a4j:actionparam name="page" value="12"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='DEPOSIT' and (payment.electricUseType=='MEA' or payment.electricUseType=='PEA')}" 
										action="#{navAction.navi}" reRender="oppContent" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-7" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
											<a4j:actionparam name="page" value="7"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='DEPOSIT' and payment.electricUseType=='PRIVATE' and payment.specialFlag!='Y'}" 
										action="#{navAction.navi}" reRender="oppContent" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
											<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
											<a4j:actionparam name="page" value="9"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										<a4j:commandButton  image="images/view.png" rendered="#{payment.expenseTypeCode=='PR_CREDIT' or payment.electricUseType=='EL_CREDIT'}" 
										action="#{navAction.navi}" reRender="oppContent" >
											<a4j:actionparam name="navModule" value="el" />
											<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
											<a4j:actionparam name="moduleWithNavi" value="el" />
											<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
											<a4j:actionparam name="methodWithNavi" value="initialEditPage7"/>
											<a4j:actionparam name="targetPayment" value="#{payment.rowId}"/>
											<a4j:actionparam name="modeView" value="view"/>
										</a4j:commandButton>
										
										
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.contractNo}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.oldContractNo}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.company}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.locationId}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.locationCode}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.siteCode}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.siteName}" style="width: 200" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.service}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="center">
							        		<h:outputText value="#{payment.effDtTH}" style="width: 100">
							        			<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="center">
							        		<h:outputText value="#{payment.expDtTH}" style="width: 100">
							        			<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="th" dateStyle="medium" />
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.siteStatusShow}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.netWorkStatusShow}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.expenseTypeShow}" style="width: 100"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.paymentStatusShow}" style="width: 150"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.docTypeShow}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.docNo}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{wrapper.docDtLabel}"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.vendorId}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.vendorName}"  style="width: 200"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.payeeId}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.payeeName}" style="width: 150"/>
							        	</div>
							        </rich:column>
							         <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.monthDetailDisplay}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.payAmt}">
							        			<f:convertNumber type="currency" currencySymbol=""/>
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.vatTypeShow}" style="width: 100"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.excludeVatAmt}">
							        			<f:convertNumber type="currency" currencySymbol=""/>
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.vatAmt}" >
							        			<f:convertNumber type="currency" currencySymbol=""/>
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.includeVatAmt}">
							        			<f:convertNumber type="currency" currencySymbol=""/>
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.whtAmt}">
							        			<f:convertNumber type="currency" currencySymbol=""/>
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.chqAmt}">
							        			<f:convertNumber type="currency" currencySymbol=""/>
							        		</h:outputText>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.paymentTypeShow}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.paymentMethodShow}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.bankName}" style="width: 150"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.bankAccount}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{wrapper.chqPostingDtLabel}"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{wrapper.chqReceivedDtLabel}"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{wrapper.transferDtLabel}"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.remark}" style="width: 100"/>
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.batchNo}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.rejectReason}" />
							        	</div>
							        </rich:column>
							         <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.chqNo}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.chqClearingDtTH}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.doc68}" />
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		
							        		<!-- fixed by.. YUT 2014/09/16 >> -->
											<a4j:commandLink id="hlkCutting" value="#{payment.doc92}" action="#{navAction.navi}" 
												reRender="common_popupCuttingFormSave, frmError-common_popupCutting"
											 	oncomplete="#{rich:component('common_popupCuttingForm')}.show(); return false" >
		
													<a4j:actionparam name="navModule" value="el" />
													<a4j:actionparam name="navProgram" value="SEMMEL008-1" />
													
													<a4j:actionparam name="moduleWithNavi" value="common" />
													<a4j:actionparam name="actionWithNavi" value="CommonPopupCutting"/>
													<a4j:actionparam name="methodWithNavi" value="initPopup" />
													<a4j:actionparam name="paramPaymentId" value="#{payment.paymentId}" />
													<a4j:actionparam name="paramPaymentStatus" value="#{payment.paymentStatus}" />
													<a4j:actionparam name="paramPaymentRemark" value="#{payment.remark}" />
													<a4j:actionparam name="paramRcptPayCutAmount" value="#{payment.rcptPayCutAmount}" />
													
													<a4j:actionparam name="paramFwdNavModule" value="el" />
													<a4j:actionparam name="paramFwdNavAction" value="SEMMEL008" />
													<a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
											</a4j:commandLink>
											<!-- fixed by.. YUT 2014/09/16 << -->
											
							        	</div>
							        </rich:column>
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.doc69}" />
							        	</div>
							        </rich:column>
							        
							         <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.receiptNo}" />
							        	</div>
							        </rich:column>
							         <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.contFlowStatus}" />
							        	</div>
							        </rich:column>
							        
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
							        		<h:outputText value="#{payment.payment_channel}" />
							        	</div>
							        </rich:column>
							        
							        <!-- fixed by.. YUT 2014/09/30 >> -->
									<rich:column  style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}">
										<div align="center">
											<h:outputText value="#{payment.sendInfoStatus}" styleClass="contentform" />
										</div>
									</rich:column>
									<!-- fixed by.. YUT 2014/09/30 << -->
									
									<!-- fixed by.. YUT 2014/09/30 >> -->
                                    <rich:column  style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}">
                                        <div align="center">
                                            <a4j:commandButton id="mel008_notDisbursedBtn"
	                                        disabled="#{!(semmel008Bean.searchCriteria.paymentStatus eq '01' or semmel008Bean.searchCriteria.paymentStatus eq '14')}"
	                                        action="#{navAction.navi}" 
	                                        reRender="ddlDisbursedStatusList,    common_popupFrmNotDisbursed, frmError-common_popupNotDisbursed"
	                                        value="#{jspMsg['btn.notDisbursed']}" styleClass="rich-button" style="width:110px;"
	                                        oncomplete="#{rich:component('common_popupNotDisbursedForm')}.show(); return false" >
	                                        
	                                            <a4j:actionparam name="navModule" value="el" />
	                                            <a4j:actionparam name="navProgram" value="SEMMEL008-1" />
	                                            
	                                            <a4j:actionparam name="moduleWithNavi" value="common" />
	                                            <a4j:actionparam name="actionWithNavi" value="CommonPopupCutting" />
	                                            <a4j:actionparam name="methodWithNavi" value="initPopupNotDisbursed" />
	                                            <a4j:actionparam name="paramPaymentId" value="#{payment.rowId}" />
	                                            <a4j:actionparam name="paramPaymentStatus" value="#{semmel008Bean.searchCriteria.paymentStatus}" />
	                                            <a4j:actionparam name="paramPaymentRemark" value="#{payment.remark}" />
	                                            
	                                            <a4j:actionparam name="paramFwdNavModule" value="el" />
	                                            <a4j:actionparam name="paramFwdNavAction" value="SEMMEL008" />
	                                            <a4j:actionparam name="paramFwdNavMethod" value="doSearch" />
	                                    </a4j:commandButton>
                                        </div>
                                    </rich:column>
                                    <!-- fixed by.. YUT 2014/09/30 << -->
							        
							        <rich:column style="#{(wrapper.rowSelected)?'background-color: #FFE4E1':''}" title="#{payment.contractNo} : #{payment.siteName}">
							        	<div align="left">
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
												<a4j:actionparam name="module" value="EL"/>
												<a4j:actionparam name="contractNo" value="#{payment.contractNo}"/>
												<a4j:actionparam name="viewMode" value="N"/>
											</a4j:commandButton>
							        	</div>
							        </rich:column>
							    </rich:subTable>
								
								<!-- end column -->
								
								<f:facet name="footer">
									<rich:columnGroup>
										<rich:column colspan="5">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel008Bean.paymentWrapperList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<rich:column colspan="42">
											<rich:datascroller immediate="true" rendered="true"
												align="left" maxPages="10" for="dtbSearchResult" id="ds"
												selectedStyleClass="selectScroll" page="#{semmel008Bean.scrollerPage}"/>
										</rich:column>
									</rich:columnGroup>
								</f:facet>
							</rich:dataTable>
							
							<!-- end dataTable -->
							<script type="text/javascript">
								document.getElementById('incContent:frmResult:dtbSearchResult:ds').parentNode.colSpan=47;
								document.getElementById('incContent:frmResult:dtbSearchResult:column0').parentNode.className='rich-table-subheader';
								for(i=0;i<47;i++){
									try{
										document.getElementById('incContent:frmResult:dtbSearchResult:column'+i).className='rich-table-subheadercell';
									}catch (Exception){}
								}
							</script>
							
						</rich:panel>
						
					</rich:panel>
					
				</h:panelGrid>
				
				<!-- end content layout data grid -->
				
			</a4j:form>
			
			</a4j:region>
		</h:panelGrid>
		
	</rich:panel>
	
</h:panelGrid>
<a4j:region>
<rich:modalPanel id="expenseDialog1" width="600" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.expense.name']}"/>
    </f:facet>
    
	<a4j:form id="frmExpense1">
	
		<table width="100%" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="4">
					<h:panelGrid id="message1">
						<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" />
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
				</td>
				<td>
					<h:selectOneMenu value="#{semmel008Bean.selectedPayment.paymentType}" style="width : 160px">
  						<f:selectItems value="#{semmel008Bean.paymentTypeList}" />
  						<a4j:support event="onchange" oncomplete="#{rich:component('expenseDialog1')}.show(); return false" action="#{semmel008Action.doChangePaymentType}" reRender="expenseDialog1"/>
  					</h:selectOneMenu>
				</td>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" />
					<rich:spacer width="5"/>
					<h:outputText value="#{jspMsg['label.paymentMethod']}" styleClass="ms7"/>
				</td>
				<td>
					<h:selectOneMenu value="#{semmel008Bean.selectedPayment.paymentMethod}" style="width : 160px" disabled="#{semmel008Bean.disablePaymentMethodList}">
  						<f:selectItems value="#{semmel008Bean.paymentMethodList}" />
  					</h:selectOneMenu>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" rendered="#{semmel008Bean.transferRequired}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.transferRequired}"/>
					<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7"/>
				</td>
				<td>
					<h:outputText value="#{semmel008Bean.selectedPayment.bankName}" styleClass="ms7"/>
				</td>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" rendered="#{semmel008Bean.transferRequired}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.transferRequired}"/>
					<h:outputText value="#{jspMsg['label.bankAccount']}" styleClass="ms7"/>
				</td>
				<td>
					<h:outputText value="#{semmel008Bean.selectedPayment.bankAccount}" styleClass="ms7"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" rendered="#{semmel008Bean.chqRequired}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.chqRequired}"/>
					<h:outputText value="#{jspMsg['label.chqPostingDt']}" styleClass="ms7"/>
				</td>
				<td>
					<rich:calendar 
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" disabled="#{!semmel008Bean.chqRequired}"
						value="#{semmel008Bean.selectedPayment.chqPostingDt}"
						showWeeksBar="false" inputStyle="width : 160px"/>
				</td>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" rendered="#{semmel008Bean.chqRequired}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.chqRequired}"/>
					<h:outputText value="#{jspMsg['label.chqReceivedDt']}" styleClass="ms7"/>
				</td>
				<td>
					<rich:calendar 
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" disabled="#{!semmel008Bean.chqRequired}"
						value="#{semmel008Bean.selectedPayment.chqReceivedDt}"
						showWeeksBar="false" inputStyle="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" rendered="#{semmel008Bean.transferRequired}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.transferRequired}"/>
					<h:outputText value="#{jspMsg['label.transferDt']}" styleClass="ms7"/>
				</td>
				<td>
					<rich:calendar 
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy" disabled="#{!semmel008Bean.transferRequired}"
						value="#{semmel008Bean.selectedPayment.transferDt}"
						showWeeksBar="false" inputStyle="width : 160px"/>
				</td>
				<td align="right">
					<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
				</td>
				<td>
					<h:inputTextarea rows="4" cols="30" value="#{semmel008Bean.selectedPayment.remark}"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" oncomplete="#{rich:component('expenseDialog1')}.show(); return false" action="#{semmel008Action.doSaveExpense1}" reRender="expenseDialog1,message1"/>
					<rich:spacer width="5"/>
					<a4j:commandButton value="#{jspMsg['btn.expenseCancel']}" styleClass="rich-button" action="#{semmel008Action.doUpdateResultTable}" reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult">
						<rich:componentControl for="expenseDialog1" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="expenseDialog2" width="350" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.creditNote.name']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmExpense2">
	
		<table width="100%" border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:panelGrid id="message2">
						<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true" />
					</h:panelGrid>
				</td>
			</tr>
			<tr>
				<td>
					<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel008Bean.selectedPayment.crPayInFlagBoolean}"/>
					<rich:spacer width="5" rendered="#{!semmel008Bean.selectedPayment.crPayInFlagBoolean}"/>
					<h:outputText value="#{jspMsg['label.bankName']}" styleClass="ms7" />
				</td>
				<td>
					<h:selectOneMenu value="#{semmel008Bean.selectedPayment.crBankName}" disabled="#{semmel008Bean.selectedPayment.crPayInFlagBoolean}" style="width : 160px">
	   					<f:selectItems value="#{semmel008Bean.bankNameList}" />
	   				</h:selectOneMenu>
				</td>
			</tr>
			<tr>
				<td>
					<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel008Bean.selectedPayment.crPayInFlagBoolean}"/>
					<rich:spacer width="5" rendered="#{!semmel008Bean.selectedPayment.crPayInFlagBoolean}"/>
					<h:outputText value="#{jspMsg['label.payinDt']}" styleClass="ms7" />
				</td>
				<td>
					<rich:calendar 
						locale="th/TH" enableManualInput="false"
						datePattern="dd/MM/yyyy"
						disabled="#{semmel008Bean.selectedPayment.crPayInFlagBoolean}"
						value="#{semmel008Bean.selectedPayment.crPayInDt}"
						showWeeksBar="false" inputStyle="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td>
					<h:outputText value="#{jspMsg['label.waitPayin']}" styleClass="ms7" />
				</td>
				<td>
					<h:selectBooleanCheckbox value="#{semmel008Bean.selectedPayment.crPayInFlagBoolean}">
						<a4j:support event="onclick" action="#{semmel008Action.doChangePayInFlag}" oncomplete="#{rich:component('expenseDialog2')}.show(); return false" reRender="frmExpense2"/>
					</h:selectBooleanCheckbox>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left">
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" oncomplete="#{rich:component('expenseDialog2')}.show(); return false" action="#{semmel008Action.doSaveExpense2}" reRender="expenseDialog2,message2"/>
					<rich:spacer width="5"/>
					<a4j:commandButton value="#{jspMsg['btn.expenseCancel']}" styleClass="rich-button" action="#{semmel008Action.doUpdateResultTable}"  reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult">
						<rich:componentControl for="expenseDialog2" operation="hide" event="onclick"/>
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="alertMessage" width="300" autosized="true">
    
    <f:facet name="header">
    	<h:outputText value="#{jspMsg['msg.header.alert']}"></h:outputText>
    </f:facet>
    
	<a4j:form id="frmAlert">
	
		<table border="0" cellspacing="" cellpadding="2">
			<tr>
				<td>
					<h:outputText value="#{semmel008Bean.message}" styleClass="#{semmel008Bean.styleClassName}" />
					<br/>
					<h:outputText value="#{semmel008Bean.message2}" styleClass="#{semmel008Bean.styleClassName}" />
				</td>
			</tr>
			<tr>
				<td align="center">
					<!-- for edit button -->
					
					
					<!--  DEPOSIT AND (ELECTRIC_TYPE_MEA OR ELECTRIC_TYPE_PEA) -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{navAction.navi}" reRender="oppContent" 
					rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForDepositMeaPea}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="7"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- ELECTRIC_TYPE_PRIVATE AND PAYMENT_SPECIAL_FLAG_Y is Y -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForDepositPrivate}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-9" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="9"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- ELECTRIC_TYPE_PRIVATE -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForDepositPrivate10}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-10" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="10"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- ALL FEE -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForFee}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL001-12" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL001" />
						<a4j:actionparam name="methodWithNavi" value="doInitPaymentForEdit"/>
						<a4j:actionparam name="page" value="12"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- EL_BIL	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForElBill}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-2" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="doEditFromMenu8"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- EL_POSTPAID or EL_DEBIT	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForElPostPaid}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-3" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initialEdit3"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
						<a4j:actionparam name="actionFrom" value="SEMMEL008-1"/>
					</a4j:commandButton>
					
					<!-- EL_TEMP	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" 
					styleClass="rich-button" action="#{navAction.navi}" 
					reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForElTemp}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initailEdit4"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- PR_POSTPAID or PR_DEBIT	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForPrPostPaid}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-5" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initailEdit5"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- PR_PREPAID	-->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent" rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForPrPrePaid}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-6" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initialEdit6"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					
					<!-- EL_CREDIT or PR_CREDIT -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" 
					action="#{navAction.navi}" reRender="oppContent" 
					rendered="#{semmel008Bean.visibleEditYesBtn && semmel008Bean.visibleEditYesBtnForCredit}">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL006-7" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL006" />
						<a4j:actionparam name="methodWithNavi" value="initialEditPage7"/>
						<a4j:actionparam name="targetPayment" value="#{semmel008Bean.targetPaymentId}"/>
					</a4j:commandButton>
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleEditYesBtn}"/>
					
					<!-- for cancel payment button -->
					<a4j:commandButton value="#{jspMsg['btn.yes']}" styleClass="rich-button" action="#{semmel008Action.doSaveCancelPayment}" reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult,alertMessage" rendered="#{semmel008Bean.visibleCancelPaymentYesBtn}">
						<rich:componentControl for="alertMessage" operation="hide" event="onComplete" />
					</a4j:commandButton>
					
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleCancelPaymentYesBtn}"/>
					
					<!-- for export -->
					<h:commandButton value="#{jspMsg['btn.export']}" styleClass="rich-button" 
					action="#{semmel008Action.export}" rendered="#{semmel008Bean.visibleExportBtn}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleExportBtn}"/>
					
					<!-- for export Remark -->
					<h:commandButton value="#{jspMsg['btn.export']}" styleClass="rich-button" 
					action="#{semmel008Action.exportRemark}" rendered="#{semmel008Bean.visibleExportRemarkBtn}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleExportRemarkBtn}"/>
					
					<!-- close dialog -->
					<a4j:commandButton value="#{jspMsg['btn.no']}" styleClass="rich-button" 
					reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult" rendered="#{semmel008Bean.visibleNoBtn}">
						<rich:componentControl for="alertMessage" operation="hide" event="onclick" />
					</a4j:commandButton>
					
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleNoBtn}"/>
					<a4j:commandButton value="#{jspMsg['btn.ok']}" styleClass="rich-button" 
					action="#{semmel008Action.doUpdateResultTable}" oncomplete="#{rich:component('alertMessage')}.hide(); return false" reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult" rendered="#{semmel008Bean.visibleOkBtn}"/>
					
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleOkBtn}"/>
					
					<a4j:commandButton value="#{jspMsg['btn.cancelExport']}" styleClass="rich-button" 
					action="#{semmel008Action.doUpdateResultTable}" 
					oncomplete="#{rich:component('alertMessage')}.hide(); return false" 
					reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult" 
					rendered="#{semmel008Bean.visibleCancelExportBtn}"/>
					
					<a4j:commandButton value="#{jspMsg['btn.no']}" styleClass="rich-button" 
					reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult" rendered="#{semmel008Bean.visibleCancelExportRemarkBtn}">
						<rich:componentControl for="alertMessage" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	
</rich:modalPanel>

<rich:modalPanel id="reject" width="450" autosized="true">
    
    <f:facet name="header">
    	<h:outputText value="#{jspMsg['msg.header.alert']}"/>
    </f:facet>
    
	<a4j:form id="frmReject">
	
		<table border="0" cellspacing="" cellpadding="2">
			<tr>
				<td colspan="2">
					<h:outputText value="#{semmel008Bean.message}" styleClass="ms7" />
				</td>
			</tr>   
			<tr>
				<td align="right">
					<h:graphicImage value="images/icon_required.gif" rendered="#{!semmel008Bean.visibleOkBtn}"/>
					<rich:spacer width="5" rendered="#{!semmel008Bean.visibleOkBtn}"/>
					<h:outputText value="#{jspMsg['label.rejectReason']}" styleClass="ms7" rendered="#{!semmel008Bean.visibleOkBtn}"/>
				</td>
				<td>
					<h:inputTextarea value="#{semmel008Bean.selectedPayment.rejectReason}" cols="40" rows="4" rendered="#{!semmel008Bean.visibleOkBtn}"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left" style="padding: 15px 0 0 0">
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{semmel008Action.doSaveReject}" reRender="oppContent" rendered="#{semmel008Bean.visibleSaveBtn}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleSaveBtn}"/>
					
					<!-- close dialog -->
					<a4j:commandButton value="#{jspMsg['btn.expenseCancel']}" styleClass="rich-button" 
					action="#{semmel008Action.doUpdateResultTable}" 
					oncomplete="#{rich:component('reject')}.hide(); return false" 
					reRender="dtbSearchResult,frmError,grdActionCommand,pnlSearchResult" 
					rendered="#{semmel008Bean.visibleCancelBtn}"/>
					<rich:spacer width="5" rendered="#{semmel008Bean.visibleCancelBtn}"/>
					<a4j:commandButton value="#{jspMsg['btn.ok']}" styleClass="rich-button" 
					reRender="gridContent,frmError,grdActionCommand,pnlSearchResult" 
					rendered="#{semmel008Bean.visibleOkBtn}">
						<rich:componentControl for="reject" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	</a4j:form>
	<a4j:form id="mel008_frmShowReportEpt">
        <h:panelGrid id="pnlShowReportEpt" style="height:0px;width:0px;" width="0px" columns="0" >
		    <h:panelGroup id="pnlInShowReportEpt" rendered="#{semmel008Bean.displayReportFlag}" style="height:0px;width:0px;" >
		        <h:commandButton value="Report" id="bthShowReport" style="height:0px;width:0px;display:none;" action="#{semmel008Action.doExportExcelLetter}"  />                              
		        <script>document.getElementById('incContent:mel008_frmShowReportEpt:bthShowReport').click();</script>
		    </h:panelGroup>                         
		</h:panelGrid>
		
		<h:panelGrid id="pnlShowReportChq" style="height:0px;width:0px;" width="0px" columns="0" >
		    <h:panelGroup id="pnlInShowReportChq" rendered="#{semmel008Bean.displayReportChqFlag}" style="height:0px;width:0px;" >
		        <h:commandButton value="Report" id="bthShowReportChq" style="height:0px;width:0px;display:none;" action="#{semmel008Action.doExportCheque}"  />                              
		        <script>document.getElementById('incContent:mel008_frmShowReportEpt:bthShowReportChq').click();</script>
		    </h:panelGroup>                         
		</h:panelGrid>
</a4j:form>
</rich:modalPanel>
</a4j:region>
<jsp:include page="../../pages/popup/uploadPicturePopup-criteria.jsp"/>

<jsp:include page="../../pages/popup/common-popupCutting.jsp"/>


<!-- =================================================================================== -->
<!-- =================================================================================== -->

	<!-- >> [POPUP_XX] -->
	<rich:modalPanel id="mel008PopUp_addVendor" width="900" autosized="true" top="20">	
	
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Select Vandor"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hide-mel008PopUp_addVendor" style="cursor:pointer" />
					<rich:componentControl for="mel008PopUp_addVendor" attachTo="hide-mel008PopUp_addVendor" operation="hide" event="onclick"  />
				</div>
			</h:panelGroup>
		</f:facet>
		<!-- << header -->
		
		<a4j:form id="frmMel008PopUp_addVendor">
		
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
                				<h:inputText id="txtVendorCode" value="#{semmel008Bean.vendorMasterPopupObjParam.vendorCode}" 
                				size="50" maxlength="45"/>
		                	</td>
						</tr>
						<tr>
							<td align="right" width="35%" style="white-space:nowrap;">
								<h:outputText value="Vendor Name :" styleClass="ms7"/>
                			</td>
                			<td>
                				<h:inputText id="txtVendorName" value="#{semmel008Bean.vendorMasterPopupObjParam.vendorName}" 
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
					<a4j:commandButton value="Search" action="#{semmel008Action.doSearchPopupAddVendor}"
					reRender="frmmel008PopUp_addVendor, dataTable_searchVendor" 
					styleClass="rich-button" style="margin-right:10px;">
						
					</a4j:commandButton>
					
					<a4j:commandButton value="Clear" action="#{semmel008Action.doClearPopupAddVendor}"
					reRender="frmMel008PopUp_addVendor, dataTable_searchVendor"
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
							var="vendorLst"  value="#{semmel008Bean.vendorMasterPopupList}" reRender="dataTable_searchVendor, dataScrll_searchVendor" 
							rows="10" rowClasses="cur" styleClass="dataTable">
								
								<!-- >> column -->
								<rich:column style="width:20px;" styleClass="tableFirstCol">
									<f:facet name="header">
										<h:outputText value="Select" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<a4j:commandLink value="select" style="height:15px; width:15px;" 
											action="#{semmel008Action.doSelectPopupAddVendor}"
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
										<h:outputText id="mel008_vendorCode" value="#{vendorLst.dataObj.vendorCode}" />
									</div> 
								</rich:column>
								<rich:column style="width:40px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Code เดิม" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="center">
										<h:outputText id="mel008_vendorCodeOld" value="#{vendorLst.dataObj.vendorCodeOld}" />
									</div> 
								</rich:column>
								<rich:column style="width:300px;" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Vendor Name" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mel008_vendorName" value="#{vendorLst.dataObj.vendorName}" />
									</div> 
								</rich:column>
								<rich:column style="" styleClass=""
								sortBy=""  title="">
									<f:facet name="header">
										<h:outputText value="Address" styleClass="contentform" style="white-space:nowrap;" />
									</f:facet>
									<div align="left">
										<h:outputText id="mel008_address" value="#{vendorLst.dataObj.address}" />
									</div> 
								</rich:column>
								<!-- << column -->
					            
					            <!-- footer -->
								<f:facet name="footer">
									<rich:columnGroup>
										<!-- > 1 -->
										<rich:column colspan="3">
											<h:outputFormat value="#{msg['message.totalRecords']}">
												<f:param value="#{fn:length(semmel008Bean.vendorMasterPopupList)}"></f:param>
											</h:outputFormat>
										</rich:column>
										<!-- > 2 -->
										<rich:column colspan="2">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dataTable_searchVendor"
													maxPages="#{semmel008Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dataScrll_searchVendor" style="background-color: #cccccc;"
													page="#{semmel008Bean.scrollerPage}">
												<a4j:support event="onclick"  reRender="frmMel008PopUp_addVendor"></a4j:support>
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
					    <rich:componentControl for="mel008PopUp_addVendor" operation="hide" event="onclick" />
					</a4j:commandButton>
				</h:panelGroup>
			</h:panelGrid>
			<!-- << additional button close -->
		
		</a4j:form>
	
	</rich:modalPanel>
	<!-- << [POPUP_XX] -->
	
<!-- =================================================================================== -->
<!-- =================================================================================== -->