<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid id="pnlTab5" width="95%">
		<a4j:region id="rgnElectricTab">
			<rich:panel id="pnlElectricTab" >
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.panel.conditionElectric']}"/>
				</f:facet>
				
				<h:panelGrid id="pnlElectricType" width="90%" border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="100%">
							<tr>
							     <td align="right" width="35%" valign="top" colspan="4">
							         <a4j:commandButton style="" styleClass="rich-button" id="msi004tab5_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_electrict_bill']}"
		                                action="#{semmsi004Action.doShowPopupHistory}" reRender="oppContent,popupDisplay4"
		                                oncomplete="#{rich:component('tab4_panel_popupModalRetStatus')}.show(); return false;">
		                                <f:param name="tabNo" value="4"/>
		                             </a4j:commandButton>
		                             <a4j:include id="popUpTab4"  viewId="../../pages/sa/semmsa002PopUpTab4.jsp" />
							     </td>
							</tr>
						</table>
						
						<rich:spacer height="10"></rich:spacer>
						
						<table width="100%">
								<tr>
									<td align="right" style="width:20%">
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</td>
									<td align="left">
										<h:inputText value="#{semmsi004tab1Bean.siteInfo.company}" size="16"  readonly="true" styleClass="ms7"/>
									</td>
									<td align="right" style="width:20%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
									</td>
									<td align="left">
										<h:inputText value="#{semmsi004tab2Bean.siteContract.contractNo}" 
                			 			size="16"  readonly="true" styleClass="ms28Blue"/>
									</td>
								</tr>
								<tr>
									<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td >
			                			<rich:calendar id="cldEffDateDisplay" locale="th" enableManualInput="true" 
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab2Bean.siteContract.effectiveDt}" 
							showWeeksBar="false" 
							inputSize="13"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.effDate']}"
							disabled="true">
							</rich:calendar>
				                	</td>
				                	<td align="right" width="25%">
										<h:outputText value="#{jspMsg['label.expDate']} :" styleClass="ms7"/>
									</td>
									<td >
										<rich:calendar id="cldExpDateDisplay" locale="th" enableManualInput="true" 
							datePattern="dd/MM/yyyy" 
							value="#{semmsi004tab2Bean.siteContract.expireDt}" 
							showWeeksBar="false" 
							inputSize="13"
							cellWidth="20px" cellHeight="20px"
							label="#{jspMsg['label.expDate']}"
							disabled="true">
							</rich:calendar>
		                			</td>
			                	 </tr>
							</table>	
					</h:panelGroup>
				</h:panelGrid>
							
				<rich:spacer height="10"></rich:spacer>
							
				<rich:panel>
					<h:panelGroup style="width:100%;">
					
						<table width="100%">
							<tr>
								<td align="center">
									<div id="msi004tab4Service" style="width:600px; overflow:scroll; border:1px solid e0e0e0;padding:0px;margin:0 auto;"> 
										
										<rich:dataTable align="center" style="width:100%;" id="dataService1tab3" cellpadding="1" cellspacing="0" border="0" 
												var="appSiteService"  value="#{semmsi004tab1Bean.siteAppServList}" reRender="dataService1tab3" 
												rows="" rowClasses="cur" styleClass="dataTable">
																
													<!-- header -->
													<f:facet name="header">
										                <rich:columnGroup>
											                <rich:column colspan="3" style="text-align:left;">
											                	<h:outputText value="#{jspMsg['column.header.serviceList']}"/>
											                </rich:column>
										                    <rich:column breakBefore="true" > 
																<h:outputText value="Service"/>
										                    </rich:column>  
										                    <rich:column style="white-space:nowrap;width:120px;">
					                                            <h:outputText value="Action"/>
					                                        </rich:column>
										                    <rich:column style="white-space:nowrap;width:70px;">
										                        <h:outputText value="Seq"/>
										                    </rich:column>
										                </rich:columnGroup>
										            </f:facet>
										            <!-- header -->
											
													<!-- data -->
													
								                    <rich:column style="text-align:center;">
					                                    <h:outputText value="#{appSiteService.dataObj.servName}" />
					                                </rich:column>
								                    <rich:column>
								                        <h:outputText value="#{appSiteService.dataObj.action}" />
								                    </rich:column>
								                    <rich:column style="text-align:center">
								                        <h:outputText value="#{appSiteService.dataObj.seq}" />
								                    </rich:column>
										            <!-- data -->
														
													<!-- footer -->
													<f:facet name="footer">
														<rich:columnGroup>
															<!-- > 1 -->
															<rich:column colspan="1">
						                                        <h:outputFormat value="#{msg['message.totalRecords']}">
						                                        	<f:param value="#{fn:length(semmsi004tab1Bean.siteAppServList)}"></f:param>
						                                        </h:outputFormat>
						                                    </rich:column>
															<!-- > 2 -->
															<rich:column colspan="2">
																	<rich:datascroller immediate="true" rendered="true" align="left" for="dataService1tab3"
																		maxPages="#{semmsi004tab1Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																		stepControls="hide" fastControls="auto" boundaryControls="auto" 
																		id="scrllDataService1tab3" style="background-color: #cccccc;"
																		page="#{semmsi004tab1Bean.scrollerPage}">
																	<a4j:support event="onclick"  reRender="frmAllInitTab"></a4j:support>
																	</rich:datascroller>
															</rich:column>
														</rich:columnGroup>
													</f:facet>
													<!-- footer -->            
												</rich:dataTable>
																    	
																	</div> 
								</td>
							</tr>
						</table> 
						<!-- table column: 10:90 -->
						
					</h:panelGroup>				
				</rich:panel>
							<!-- >> group 2 -->
							<rich:spacer height="10"></rich:spacer>
							<!-- << group 3 -->
							<h:panelGrid>
								<h:panelGroup>
				                	<div>
				                		<h:selectBooleanCheckbox rendered="false"></h:selectBooleanCheckbox>
				                		<h:outputText value="#{jspMsg['label.changeelectricInfo']}" styleClass="ms7" rendered="false"/>
				                	</div>
				                </h:panelGroup>
							</h:panelGrid>
							<!-- >> group 3 -->
							<rich:spacer height="10"></rich:spacer>
							<!-- <<	group 4 -->
							<rich:panel id="pnlMsa002Tab4_ElCont">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_electricInfoList']} #{jspMsg['label.th.datafromsiteacq']}" style="width: 100%;"/>
					</f:facet>
				
					<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
					
						<rich:dataTable id="dtbSiteInfo" cellpadding="1" cellspacing="0" border="0"
                        var="obj" value="#{semmsi004tab5Bean.siteAppELCondExistingList}" reRender="dtbSiteInfo" 
                        rows="#{semmsi004tab5Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            
                            <rich:column rendered="false">
	                            <f:facet name="header">
	                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton id="btnEdit"  action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
		                            reRender="oppContent">
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
		                                <a4j:actionparam name="siteAppELContId" value="#{obj.dataObj.siteAppELContId}" />
		                                <a4j:actionparam name="siteAppElCondType" value="E" />
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
	                        
	                        <rich:column rendered="false">
	                            <f:facet name="header">
	                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
		                            reRender="oppContent" rendered="#{obj.dataObj.siteAppELContId != null}"
		                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
		                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppELCond" />
		                                <a4j:actionparam name="siteAppRentContId" value="#{obj.dataObj.siteAppELContId}" />
										<a4j:actionparam name="siteAppId" value="#{obj.dataObj.siteAppId}" />
										<a4j:actionparam name="expenseType" value="#{obj.dataObj.expenseType}" />
										<a4j:actionparam name="serviceId" value="#{obj.dataObj.serviceId}" />
										<a4j:actionparam name="siteAppRentContMode" value="H" />
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
                            
                            <rich:column sortBy="#{obj.dataObj.effectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.effectiveDtStr}"  styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.expireDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.expireDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.chgEffectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.chgEffectiveDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodStartDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 100"/>     
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodStartDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodEndDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodEndDtStr}" styleClass="contentform" >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.elType}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.electricType']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.electricTypeName}" styleClass="contentform"  >
                                    <f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.sitecontractNo']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.contractNo}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.calElectric']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricCondSubtypeName}" />
                                </div>
                      		</rich:column>
                      		
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricAmt}" >
                                    <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
									</h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['lable.th_service']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.serviceName}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.takeAllPeriodTypeName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Detail" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.detail}"/>
                                </div>
                      		</rich:column>
                      		
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.elVatTypeName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.pay']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.payPeriodTypeName}"/>
                                </div>
                      		</rich:column>
                      		
                      		<f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                        	<f:param value="#{fn:length(semmsi004tab5Bean.siteAppELCondExistingList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="11">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
                                            maxPages="#{semmsi004tab5Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsi004tab5Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            
                   		</rich:dataTable>
					
					</h:panelGroup>
				</rich:panel>
				 <rich:spacer height="10"></rich:spacer>
							<!-- >> group 4 -->
							
							<rich:spacer height="10"></rich:spacer>
							
							
							
							<!-- << group 5 -->
							<rich:panel id="msi004tab4_wrapper1">
								
							<h:selectOneRadio id="rbtMsa002tab4_changeEl" value="#{semmsi004tab5Bean.elEditFlag}" styleClass="ms7" 
								rendered="#{semmsi004Bean.reqTypeParam != '01'}"
								disabled="#{semmsi004tab5Bean.disabledModeViewOnly}" onclick="fnMsi004tab5_changeElComfirm();">
                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_noChangeEL']}" />
                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_changeEL']}" />
                		</h:selectOneRadio>
                		
                			 <div style="clear:both; height:px;"></div>
                		
                			<a4j:jsFunction name="fnMsi004tab5_changeElComfirm"
	                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
	                		action="#{semmsi004tab5Action.doSetParamConfirmNotChangeEl}"
                		 	reRender="pnlMsi004Tab5_ElCont, panelTab5, btnAddOther,btnSave1,btnNew,msi004tab5_wrapper1,
                			msi004PopUpCommon_commonConfirm,msi004tab5_pnlElDetail"></a4j:jsFunction>
                		
						<div style="width:100%; border:solid 1px;padding:5px;">
								
									<h:panelGroup style="width:100%;">
										
										<rich:messages id="msgPnlTab5_elType" layout="list" errorClass="ms7red" warnClass="ms7blue" 
											infoClass="ms7green" >
						                        <f:facet name="errorMarkerPage">
						                             <h:graphicImage value="images/error.gif" />  
						                        </f:facet>
						                </rich:messages>
										<!-- table column: 20:80 -->
										<table style="width:100%; ">
												<tr>
												<%-- <a4j:region> --%>
													<td style="width:20%; text-align:right; white-space:nowrap; vertical-align:top;">
														<table style="width:100%; border:solid ececec 0px;">
														    <tr>
														        <td valign="top" align="right">
														        	<h:outputText value="#{jspMsg['label.th_type_electrictUsed']} : " styleClass="ms7" />
														        </td>
															</tr>
														</table>
														        
														
													</td>
													<td style="width:80%; white-space:nowrap;" valign="top">
														<table style="width:100%; border:solid ececec 0px;">

														    <tr>
														        <td width="12%" >
														        	<h:selectBooleanCheckbox id="chkMultiElectricTypeFlagTab5" value="#{semmsi004tab5Bean.chkMultiElectricTypeFlag}" 
														            styleClass="ms7" disabled="true"/>
												                	<h:outputText value="#{jspMsg['label.multiElectricTypeFlag']}" styleClass="ms7" />	
														        </td>
														        
														        <rich:spacer width=""></rich:spacer>
											        		<h:outputText value=" #{semmsi004tab5Bean.pRemark}" rendered="true" styleClass="ms7Red"></h:outputText>
														        
														        
														    </tr>
														    <tr>
														        <td colspan="2"><a4j:jsFunction name="reRenderCheckBox" reRender="pnlElectricTab"></a4j:jsFunction>
														        	<h:selectBooleanCheckbox id="chkElectricType1Tab5" value="#{semmsi004tab5Bean.chkElectricType1}" styleClass="ms7"
													                onclick="if(#{semmsi004tab5Bean.chkElectricType1 }){
																	if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.electricType1']} #{jspMsg['msg.th_trueornot']}'))
																	{reRenderCheckBox(); RenderElectricType1Tab5JS();msi004tab5_chkElctTypeMEA();}
																	else{return false;}}else{RenderElectricType1Tab5JS();msi004tab5_chkElctTypeMEA();}"
													                disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
													                semmsi004tab5Bean.chkElectricType2}"/>
												                	<h:outputText value="#{jspMsg['label.electricType1']}" styleClass="ms7" />
												                	<a4j:jsFunction name="RenderElectricType1Tab5JS" 
												                	reRender="chkElectricType1Tab5,chkElectricType2Tab5,chkElectricType3Tab5,
												                	chkElectricType4Tab5,pnlDepositElectric" 
												                	action="#{semmsi004tab5Action.renderElectricType1}"/>
																
																	<rich:spacer width="20px;"></rich:spacer>
																
																	<h:selectBooleanCheckbox id="chkElectricType2Tab5" value="#{semmsi004tab5Bean.chkElectricType2}" styleClass="ms7"
													                onclick="if(#{semmsi004tab5Bean.chkElectricType2 }){
																	if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.electricType2']} #{jspMsg['msg.th_trueornot']}'))
																	{reRenderCheckBox(); RenderElectricType2Tab5JS();msi004tab5_chkElctTypePEA();}
																	else{return false;}}else{RenderElectricType2Tab5JS();msi004tab5_chkElctTypePEA();}" 
													                disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
													                semmsi004tab5Bean.chkElectricType1}"/>
													                <h:outputText value="#{jspMsg['label.electricType2']}" styleClass="ms7" />	
													                <a4j:jsFunction name="RenderElectricType2Tab5JS" 
													                reRender="chkElectricType1Tab5,chkElectricType2Tab5,chkElectricType3Tab5,
													                chkElectricType4Tab5,pnlDepositElectric" 
													                	action="#{semmsi004tab5Action.renderElectricType2}"/>
													                	
																	<rich:spacer width="20px;"></rich:spacer>
																
																	<h:selectBooleanCheckbox id="chkElectricType3Tab5" value="#{semmsi004tab5Bean.chkElectricType3}" styleClass="ms7"
													                onclick="if(#{semmsi004tab5Bean.chkElectricType3 }){
																	if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.electricType3']} #{jspMsg['msg.th_trueornot']}'))
																	{reRenderCheckBox(); RenderElectricType3Tab5JS();msi004tab5_chkElctTypeOwnerJS();}
																	else{return false;}}else{RenderElectricType3Tab5JS();msi004tab5_chkElctTypeOwnerJS();}"  
													                disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}"/>
													                <h:outputText value="#{jspMsg['label.electricType3']}" styleClass="ms7" />	
													                <a4j:jsFunction name="RenderElectricType3Tab5JS" 
													                reRender="chkElectricType1Tab5,chkElectricType2Tab5,chkElectricType3Tab5,
													                chkElectricType4Tab5,pnlDepositElectric,
													                btnPopupSearchContractNoTab5,pnlElectricOwnerType" 
													                action="#{semmsi004tab5Action.renderElectricType3}"/>
																	
																	<rich:spacer width="20px;"></rich:spacer>
																	
																	<h:selectBooleanCheckbox id="chkElectricType4Tab5" value="#{semmsi004tab5Bean.chkElectricType4}" styleClass="ms7"
													                onclick="if(#{semmsi004tab5Bean.chkElectricType4 }){
																	if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.electricType4']} #{jspMsg['msg.th_trueornot']}'))
																	{reRenderCheckBox(); RenderElectricType4Tab5JS();chkElUseOthSite();}
																	else{return false;}}else{RenderElectricType4Tab5JS();chkElUseOthSite();}"  
													                 disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}"/>
													                <h:outputText value="#{jspMsg['label.electricType4']}" styleClass="ms7" />
													                <a4j:jsFunction name="RenderElectricType4Tab5JS" 
													                reRender="chkElectricType1Tab5,chkElectricType2Tab5,chkElectricType3Tab5,chkElectricType4Tab5,
													                pnlDepositElectric" 
													                	action="#{semmsi004tab5Action.renderElectricType4}"/>	
													                	
													               	<rich:spacer width="20px;"></rich:spacer>
																
																	<h:selectBooleanCheckbox id="msi004tab5_chkElUseOth" value="#{semmsi004tab5Bean.chkElectricType5}" 
																	disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}" 
																	onclick="if(#{semmsi004tab5Bean.chkElectricType5 }){
																	if(confirm('#{jspMsg['msg.th_cancelUserELOth']} #{jspMsg['msg.th_trueornot']}'))
																	{reRenderCheckBox(); elUseOth();renderedElUseOthTxt();}
																	else{return false;}}else{elUseOth();renderedElUseOthTxt();}"  />
																	<a4j:jsFunction name="renderedElUseOthTxt" reRender="msi004tab5_elUseOthTxt,msi004tab4_wrapper1"></a4j:jsFunction>
																	
																	<h:outputText value="#{jspMsg['label.th_other']}  " style="margin-left:5px;" styleClass="ms7" />
																	
																	
																	<a4j:jsFunction name="msi004tab5_chkElctTypeNewJS" reRender="msi004tab4_wrapper1" 
																	action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
																			<a4j:actionparam name="paramChkElType" value="NEW" />
																	</a4j:jsFunction>
																	
																	<a4j:jsFunction name="msi004tab5_chkElctTypePEA" reRender="msi004tab4_wrapper1" 
																	action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
																			<a4j:actionparam name="paramChkElType" value="PEA" />
																			<a4j:actionparam name="elType" value="02" />                
							                        						<a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" /> 
																	</a4j:jsFunction>
																	
																	<a4j:jsFunction name="msi004tab5_chkElctTypeMEA" reRender="msi004tab4_wrapper1" 
																	action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
																			<a4j:actionparam name="paramChkElType" value="MEA" />
																			<a4j:actionparam name="elType" value="01" />                
							                        						<a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" /> 
																	</a4j:jsFunction>
																	
																	<a4j:jsFunction name="chkElUseOthSite" reRender="msi004tab4_wrapper1" 
					                                                action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
					                                                    <a4j:actionparam name="paramChkElType" value="OTHER" />
					                                                </a4j:jsFunction>
																	
																	<a4j:jsFunction name="msi004tab5_chkElctTypeOwnerJS" reRender="msi004tab4_wrapper1" 
																	action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
																		<a4j:actionparam name="paramChkElType" value="OWNER" />
																	</a4j:jsFunction>
																	
																	
																	<a4j:jsFunction name="msi004tab5_chkElctTypeOldJS" reRender="msi004tab4_wrapper1" 
																	action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
																		<a4j:actionparam name="paramChkElType" value="OLD" />
																	</a4j:jsFunction>
																	
																	<a4j:jsFunction name="elUseOth" reRender="msi004tab4_wrapper1" 
																	action="#{semmsi004tab5Action.msi04tab5_doChkElctType}">
																		<a4j:actionparam name="paramChkElType" value="OTH" />
																	</a4j:jsFunction>
														        </td>
														        
														    </tr>
														</table>
														    
													</td>
												<%-- </a4j:region> --%>
												</tr>
												<tr>
													<td align="right">
														<h:outputText value="#{jspMsg['lable.th_service']} : " styleClass="ms7" />
													</td>
													<td align="left">
														<h:selectOneMenu id="msi004tab5_service" value="#{semmsi004tab5Bean.siteInfoObjELParam.serviceId}" 
														disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}" 
														styleClass="ms7">
															<f:selectItems value="#{semmsi004tab1Bean.servTypeList}"/>
														</h:selectOneMenu>
													</td>
												</tr>
												
										</table>
										
										<div style="margin:5px;" id="btnNew">
												<h:panelGroup rendered="false">
												
												<!-- Add3 -->
													<a4j:commandButton value="Add" styleClass="rich-button"  id="btnAddOther"
							       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail" 
							       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '04' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' )}"
							       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId == null || semmsi004tab5Bean.siteInfoObjELParam.electricType == '' || semmsi004tab5Bean.siteInfoObjELParam.electricType == null
							       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '04'|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'}"
							       					style=" width : 46px;">
							       						<a4j:actionparam name="navModule" value="si" />
							                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
							                            <a4j:actionparam name="moduleWithNavi" value="si" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
							                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />

							                            <a4j:actionparam name="elType" value="01" />                
										              
							                           <a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" />
							                           
							                                
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					<!-- Save5 -->
							       					<a4j:commandButton value="Save" styleClass="rich-button" id="btnSave1" 
							       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail"
							       					
							       					rendered="#{(semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId != null)
							       					&& (semmsi004tab5Bean.siteInfoObjELParam.electricType == '01' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' ||
							       					semmsi004tab5Bean.siteInfoObjELParam.electricType == '')}">
							       					<a4j:actionparam name="navModule" value="si" />
										                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                            <a4j:actionparam name="moduleWithNavi" value="si" />
										                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
										                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
										                            <a4j:actionparam name="elType" value="01" />        						                          
							       						<a4j:actionparam name="serviceId" value="#{semmsi004tab5Bean.siteInfoObjELParam.serviceId}" />
										               <a4j:actionparam name="elTypeSub" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType}" />
							                           <a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" />
							                           <a4j:actionparam name="siteInfoELContId" value="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId}" />
							                            
							                     
							       					</a4j:commandButton>
							       					
							       					
							       					<rich:spacer width="10"></rich:spacer>
							       					
							       					<a4j:commandButton value="Cancel" styleClass="rich-button" id="btnCancel1" 
							       					action="#{navAction.navi}" reRender="btnAddOther,btnSave1,msa002tab4_wrapper1"
							       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '04' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' )}">
							       						<a4j:actionparam name="navModule" value="si" />
							                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                <a4j:actionparam name="moduleWithNavi" value="si" />
										                <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
										               <a4j:actionparam name="methodWithNavi" value="doClearSiteAppEl" />
							                            
							       					</a4j:commandButton>
												</h:panelGroup>
												<rich:spacer width="5"></rich:spacer>
												<h:outputLabel value="sss" rendered="false"></h:outputLabel>
											</div>
									</h:panelGroup>	
									
									
									<h:panelGroup id="msi004tab5_pnlElUseOwner" style="width:100%;"  rendered="#{semmsi004tab5Bean.chkElectricType3}">
										<div style="width:100%; border:solid 1px ;padding:5px;" >
									
											<h:panelGroup style="width:100%;" id="aa" >
												<div>
													<h:outputText value="#{jspMsg['label.infoforELuseOwner']}" styleClass="ms7" style="text-decoration:underline;"></h:outputText>
												
												</div>
												<div style="width:50%;padding:0;margin:0 auto;" >
													<table width="100%">
														<tr>
															<td align="right">
																<h:outputText value="#{jspMsg['label.ELcond']} : " styleClass="ms7" />
															</td>
															<td align="left">
																<h:selectOneMenu id="elCondTypeDD" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondType}" style=" height : 19px;"
																onchange="doSelectELUseCond()" disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}"   >
																	<f:selectItems value="#{semmsi004tab5Bean.elCondTypeList}"/>
																	<a4j:jsFunction name="doSelectELUseCond" action="#{semmsi004tab5Action.doSelectELUseCond}"
																	reRender="msi004tab5_pnlElUseOwner"></a4j:jsFunction>
																</h:selectOneMenu>
															</td>
															<td align="right">
																<h:outputText value="#{jspMsg['label.ELcondOth']} : " styleClass="ms7" />
															</td>
															<td align="left">
																<h:selectOneMenu id="msi004tab5_elCondSubType" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType}" 
																disabled="#{semmsi004tab5Bean.siteInfoObjELParam.elCondType ne '01'}"
																onchange="renderELUnitTakeAll();">
																	<f:selectItems value="#{semmsi004tab5Bean.elCondSubTypeList}"/>
																</h:selectOneMenu>
																
																<a4j:jsFunction name="renderELUnitTakeAll" action="#{semmsi004tab5Action.doSetDefaultEl}" reRender="msi004tab5_pnlUnit,msi004tab5_pnlTakeAll,msi004tab5_pnlElUseOwner">
																
																</a4j:jsFunction>
															</td>
														</tr>
													</table>
												</div>
												
												<rich:panel id="msi004tab5_pnlUnit" style="width:100%;" rendered="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType eq '01'}">
													<div style="width:100%; border:solid 1px fff;padding:5px;">
														<table>
															<tr>
																<td align="right" width="20%">
																	<h:outputText value="#{jspMsg['label.th_perUnit']} :" styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:inputText value="#{semmsi004tab5Bean.siteInfoObjELParam.elUnitPrice}" id="msi004tab5_elUnitPrice" maxlength="15" 
																	onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
								                		 			onblur="numberformat.moneyFormat(this);"
								                		 			onfocus="return numberformat.setCursorPosToEnd(this);" 
																	style="text-align:right; height : 18px;" styleClass="ms7"
																	disabled="#{(semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoUtilPrice)}">
																		<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																	</h:inputText>
																	
																	<rich:spacer width="50"></rich:spacer>
																	<h:selectBooleanCheckbox id="msi004tab5_chkNoUtilPrice" value="#{semmsi004tab5Bean.chkNoUtilPrice}" 
																	onclick="noUnitPrice();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	</h:selectBooleanCheckbox>
																	
																	<a4j:jsFunction name="noUnitPrice" action="#{semmsi004tab5Action.doChkNoUnitPrice}" reRender="msi004tab5_elUnitPrice, msi004tab5_pnlUnit">
																	
																	</a4j:jsFunction>
																	<h:outputText value="#{jspMsg['label.th_noutilprice']}" styleClass="ms7" ></h:outputText>
																	
																</td>
															</tr>
															
															<tr>
																<td align="right">
																	<h:outputText value="Vat : " styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:selectOneRadio id="msa002tab3_ELVatType_act" value="#{semmsi004tab5Bean.siteInfoObjELParam.elVatType}" 
																	style="" styleClass="ms7" disabled="#{semmsi004tab1Bean.disabledElectric}">
											                			<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
											                			<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
											                			<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
											                			<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
											                		</h:selectOneRadio>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.th_condition_ofPayment']} : " styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:panelGrid columns="9">
															        	<h:panelGroup>
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType01_act" value="#{semmsi004tab5Bean.elPayPeriodType01}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType01();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType01" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
															        	<h:panelGroup>
													       					
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType06_act" value="#{semmsi004tab5Bean.elPayPeriodType06}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType06();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType06" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="06"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
															        	<h:panelGroup>
													       					
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType07_act" value="#{semmsi004tab5Bean.elPayPeriodType07}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType07();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType07" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="07"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
															        	<h:panelGroup>
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType02_act" value="#{semmsi004tab5Bean.elPayPeriodType02}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType02();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType02" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
																	   	</h:panelGroup>
															        	<h:panelGroup>     
																	        
															                <h:selectOneRadio id="msi004tab5_elPayPeriodType03_act" value="#{semmsi004tab5Bean.elPayPeriodType03}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType03();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType03" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															           	</h:panelGroup>
															        	<h:panelGroup>     
															                
															                <h:inputText id="msi004tab5_txtElPayPeriodTypeMonth_act" size="5"  disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.elPayPeriodType03 != '03'}"
													                				value="#{semmsi004tab5Bean.elPayPeriod03}" styleClass="inputRight" onblur="msi004tab5_setElPayPeriodType03();"
													                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
															                
															                <rich:spacer width="2"></rich:spacer>
															                <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
															           	</h:panelGroup>
															        	<h:panelGroup>     
															                
															                <h:selectOneRadio id="msi004tab5_elPayPeriodType04_act" value="#{semmsi004tab5Bean.elPayPeriodType04}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType04();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType04" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															            </h:panelGroup>
															        	<h:panelGroup>				
															                <h:inputText id="msi004tab5_txtElPayPeriodTypeYear_act" size="5" disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.elPayPeriodType04 != '04'}"
													                				value="#{semmsi004tab5Bean.elPayPeriod04}" styleClass="inputRight"
													                				onblur="msi004tab5_setElPayPeriodType04();"
													                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
													                				
															                <rich:spacer width="2"></rich:spacer>
															                <h:outputText value="#{jspMsg['label.th_year']}" styleClass="ms7"></h:outputText>
															            
														                </h:panelGroup>
														                <h:panelGroup>
														                	
															                <h:selectOneRadio id="msi004tab5_elPayPeriodType05_act" value="#{semmsi004tab5Bean.elPayPeriodType05}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType05();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType05" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01_act,msi004tab5_elPayPeriodType02_act,msi004tab5_elPayPeriodType03_act,
																			    msi004tab5_elPayPeriodType04_act,msi004tab5_elPayPeriodType05_act,msi004tab5_txtElPayPeriodTypeMonth_act,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06_act,msi004tab5_elPayPeriodType07_act">
																					<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
														           	</h:panelGrid> 
																</td>
															</tr>
															<tr>
																<td style="text-align:right;" valign="top">
											       					<h:outputText value="* " style="font-style:bold; color:red;" />
																	<h:outputText value="#{jspMsg['column.header.startPeriodDate']} : " styleClass="ms7" />
											       				</td>
											       				<td style="text-align:left;" valign="top" colspan="5">
											       					<a4j:region>
																		<!-- begin date -->
																		<rich:calendar locale="th" enableManualInput="true" 
																			   datePattern="dd/MM/yyyy" 
																			   value="#{semmsi004tab5Bean.siteInfoObjELParam.periodStartDt}"
																			   showWeeksBar="false"
																			   inputSize="10"
																			   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																		   	   cellWidth="15px" cellHeight="20px"
																		   	   label=""
																		   	   styleClass="ms7"
																		   	   disabled="#{semmsi004tab1Bean.disabledElectric}">
																		</rich:calendar>
																		
																		<rich:spacer width="50"></rich:spacer>
																		<h:outputText value="#{jspMsg['column.header.endPeriodDate']} :  " styleClass="ms7" />
																		<!-- end date -->
																		<rich:calendar locale="th" enableManualInput="true" 
																			   datePattern="dd/MM/yyyy" 
																			   value="#{semmsi004tab5Bean.siteInfoObjELParam.periodEndDt}"
																			   showWeeksBar="false"
																			   inputSize="10"
																			   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																		   	   cellWidth="15px" cellHeight="20px"
																		   	   label=""
																		   	   styleClass="ms7"
																		   	   disabled="#{semmsi004tab1Bean.disabledElectric}">
																		</rich:calendar>
																	</a4j:region>
											       				</td>
															</tr>
															
														</table>
													</div>
												</rich:panel>
												
												<rich:panel id="msi004tab5_pnlTakeAll" style="width:100%;" rendered="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType eq '02'}">
													<div style="width:100%; border:solid 1px fff;padding:5px;">
														<table>
															<tr>
																<td align="right" width="15%">
																	<h:outputText value="#{jspMsg['column.header.amt']} :" styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:inputText value="#{semmsi004tab5Bean.siteInfoObjELParam.electricAmt}" id="msi004tab5_elPayOnPackageAmt" maxlength="15" 
																	onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
										                		 	onblur="numberformat.moneyFormat(this);"
										                		 	onfocus="return numberformat.setCursorPosToEnd(this);" 
																	style="text-align:right;" styleClass="ms7"
																	disabled="#{semmsi004tab1Bean.disabledElectric}">
																		<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																	</h:inputText>
																	
																	<rich:spacer width="50"></rich:spacer>
																	
																	<h:outputText value="#{jspMsg['column.header.perPeriod']} : " styleClass="ms7" ></h:outputText>
																	
																	<h:selectOneMenu style="" id="msi004tab5_elPkgPeriodType" value="#{semmsi004tab5Bean.siteInfoObjELParam.takeAllPeriodType}" styleClass="ms7"
																	disabled="#{semmsi004tab1Bean.disabledElectric}" onchange="defaultElPayPeriodType();">
																		<f:selectItems value="#{semmsi004tab5Bean.promiseRenewPeriodTypeList}"/>
																	</h:selectOneMenu>
																	
																		<script type="text/javascript">
																			function defaultElPayPeriodType(){
																				
																			var periodType = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_elPkgPeriodType").value;
																			var payPeriodType01 = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_elPayPeriodType01:0");
																			var payPeriodType02 = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_elPayPeriodType02:0");
																			var payPeriodType03 = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_elPayPeriodType03:0");
																			var payPeriodType04 = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_elPayPeriodType04:0");
																			var payPeriodType05 = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_elPayPeriodType05:0");
																			var year = document.getElementById("incContent:frmAddSiteInfo:incTab5:msa002tab5_txtElPayPeriodTypeYear");
																			var month = document.getElementById("incContent:frmAddSiteInfo:incTab5:msi004tab5_txtElPayPeriodTypeMonth");
																			if(periodType != '' && periodType == 'Y'){
																				payPeriodType02.checked = true;
																				payPeriodType01.checked = false;
																				payPeriodType05.checked = false;
																				
																			} else if (periodType != '' && periodType == 'O') {
																				payPeriodType01.checked = false;
																				payPeriodType02.checked = false;
																				payPeriodType05.checked = true;
																			} else {
																				payPeriodType01.checked = true;
																				payPeriodType02.checked = false;
																				payPeriodType05.checked = false;
																			}
										
																			payPeriodType03.checked = false;
																			payPeriodType04.checked = false;
																			
																			year.value = '';
																			month.value = '';
																			year.disabled = true;
																			month.disabled =true;
																		}
																	</script>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="Detail : " styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:inputTextarea value="#{semmsi004tab5Bean.siteInfoObjELParam.detail03}" 
																	rows="5" style="width:80%;" styleClass="ms7"
																	disabled="#{semmsi004tab1Bean.disabledElectric}">
																	</h:inputTextarea>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="Vat : " styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:selectOneRadio id="msa002tab3_ELVatType" value="#{semmsi004tab5Bean.siteInfoObjELParam.elVatType}" 
																	style="" styleClass="ms7" disabled="#{semmsi004tab1Bean.disabledElectric}">
											                			<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
											                			<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
											                			<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
											                			<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
											                		</h:selectOneRadio>
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
																</td>
																<td align="left">
																	<h:selectOneRadio id="rbtWhtTypeNormalEL" value="#{semmsi004tab5Bean.siteInfoObjELParam.wthType}"  
										                			 styleClass="ms7" rendered="true" 
										                			 disabled="#{semmsi004tab1Bean.disabledElectric}" 
										                			 onclick="ClearWhtRateELJS();">
										                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']} " />
										                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}"/>
										                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']} " />
									                				</h:selectOneRadio>
									                				<a4j:jsFunction name="ClearWhtRateELJS"  action="#{semmsi004tab5Action.clearWhtRate}"  reRender="txtWhtRateNormalEL,chkWhtRateNormalEL"/>
																
																	<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
																	
																	<rich:spacer width="2"></rich:spacer>
										                			
										                			<h:inputText id="txtWhtRateNormalEL" value="#{semmsi004tab5Bean.siteInfoObjELParam.whtRate}" 
										                			disabled="#{semmsi004tab5Bean.chkWhtRateNormal || semmsi004tab1Bean.disabledElectric}" >
										                				<f:convertNumber pattern="#,##0.00" maxIntegerDigits="7" maxFractionDigits="2" />
										                			</h:inputText>
										                			
										                			<rich:spacer width="2"></rich:spacer>
										                			
										                			<h:outputText value="%" styleClass="ms7"/>
										                			
										                			<rich:spacer width="2"></rich:spacer>
										                			
										                			<h:selectBooleanCheckbox id="chkWhtRateNormalEL"  styleClass="ms7" onclick="RenderWhtRateNormalELJS();" 
										                			value="#{semmsi004tab5Bean.chkWhtRateNormal}" 
										                			disabled="#{semmsi004tab1Bean.disabledElectric}"/>
									                				
									                				<h:outputText value="#{jspMsg['label.edit']}"  styleClass="ms7"/>
									                				
									                				<a4j:jsFunction name="RenderWhtRateNormalELJS" reRender="txtWhtRateNormalEL" />
																</td>
															</tr>
															<tr>
																<td align="right">
																	<h:outputText value="#{jspMsg['label.th_condition_ofPayment']} : " styleClass="ms7" ></h:outputText>
																</td>
																<td align="left">
																	<h:panelGrid columns="9">
															        	<h:panelGroup>
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType01" value="#{semmsi004tab5Bean.elPayPeriodType01}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType01();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType01" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
															        	<h:panelGroup>
													       					
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType06" value="#{semmsi004tab5Bean.elPayPeriodType06}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType06();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType06" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="06"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
															        	<h:panelGroup>
													       					
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType07" value="#{semmsi004tab5Bean.elPayPeriodType07}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType07();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType07" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="07"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
															        	<h:panelGroup>
																	        <h:selectOneRadio id="msi004tab5_elPayPeriodType02" value="#{semmsi004tab5Bean.elPayPeriodType02}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType02();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType02" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
																	   	</h:panelGroup>
															        	<h:panelGroup>     
																	        
															                <h:selectOneRadio id="msi004tab5_elPayPeriodType03" value="#{semmsi004tab5Bean.elPayPeriodType03}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType03();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType03" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															           	</h:panelGroup>
															        	<h:panelGroup>     
															                
															                <h:inputText id="msi004tab5_txtElPayPeriodTypeMonth" size="5"  disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.elPayPeriodType03 != '03'}"
													                				value="#{semmsi004tab5Bean.elPayPeriod03}" styleClass="inputRight" onblur="msi004tab5_setElPayPeriodType03();"
													                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
															                
															                <rich:spacer width="2"></rich:spacer>
															                <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
															           	</h:panelGroup>
															        	<h:panelGroup>     
															                
															                <h:selectOneRadio id="msi004tab5_elPayPeriodType04" value="#{semmsi004tab5Bean.elPayPeriodType04}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType04();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType04" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															            </h:panelGroup>
															        	<h:panelGroup>				
															                <h:inputText id="msi004tab5_txtElPayPeriodTypeYear" size="5" disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.elPayPeriodType04 != '04'}"
													                				value="#{semmsi004tab5Bean.elPayPeriod04}" styleClass="inputRight"
													                				onblur="msi004tab5_setElPayPeriodType04();"
													                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
													                				
															                <rich:spacer width="2"></rich:spacer>
															                <h:outputText value="#{jspMsg['label.th_year']}" styleClass="ms7"></h:outputText>
															            
														                </h:panelGroup>
														                <h:panelGroup>
														                	
															                <h:selectOneRadio id="msi004tab5_elPayPeriodType05" value="#{semmsi004tab5Bean.elPayPeriodType05}"  styleClass="ms7" rendered="true"
																		    onclick="msi004tab5_setElPayPeriodType05();" disabled="#{semmsi004tab1Bean.disabledElectric}">
																	                				
																	        	<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
																	                				 
																			    <a4j:jsFunction name="msi004tab5_setElPayPeriodType05" action="#{semmsi004tab5Action.renderElPayPeriodType}" 
																			    reRender="msi004tab5_elPayPeriodType01,msi004tab5_elPayPeriodType02,msi004tab5_elPayPeriodType03,
																			    msi004tab5_elPayPeriodType04,msi004tab5_elPayPeriodType05,msi004tab5_txtElPayPeriodTypeMonth,
																			    msa002tab5_txtElPayPeriodTypeYear,msi004tab5_elPayPeriodType06,msi004tab5_elPayPeriodType07">
																					<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
																				</a4j:jsFunction>
																	        </h:selectOneRadio>
															        	</h:panelGroup>
														           	</h:panelGrid> 
																</td>
															</tr>
															<tr>
																<td style="text-align:right;" valign="top">
											       					<h:outputText value="* " style="font-style:bold; color:red;" />
																	<h:outputText value="#{jspMsg['column.header.startPeriodDate']} : " styleClass="ms7" />
											       				</td>
											       				<td style="text-align:left;" valign="top" colspan="5">
											       					<a4j:region>
																		<!-- begin date -->
																		<rich:calendar locale="th" enableManualInput="true" 
																			   datePattern="dd/MM/yyyy" 
																			   value="#{semmsi004tab5Bean.siteInfoObjELParam.periodStartDt}"
																			   showWeeksBar="false"
																			   inputSize="10"
																			   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																		   	   cellWidth="15px" cellHeight="20px"
																		   	   label=""
																		   	   styleClass="ms7"
																		   	   disabled="#{semmsi004tab1Bean.disabledElectric}">
																		</rich:calendar>
																		
																		<rich:spacer width="50"></rich:spacer>
																		<h:outputText value="#{jspMsg['column.header.endPeriodDate']} :  " styleClass="ms7" />
																		<!-- end date -->
																		<rich:calendar locale="th" enableManualInput="true" 
																			   datePattern="dd/MM/yyyy" 
																			   value="#{semmsi004tab5Bean.siteInfoObjELParam.periodEndDt}"
																			   showWeeksBar="false"
																			   inputSize="10"
																			   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																		   	   cellWidth="15px" cellHeight="20px"
																		   	   label=""
																		   	   styleClass="ms7"
																		   	   disabled="#{semmsi004tab1Bean.disabledElectric}">
																		</rich:calendar>
																	</a4j:region>
											       				</td>
															</tr>
														</table>
													</div>
												</rich:panel>
												
												
												
															<h:panelGroup rendered="#{semmsi004tab5Bean.elEditFlag != 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}">
																<h:outputText value="#{jspMsg['label.th_eff_dt']}  : " styleClass="ms7"
																rendered="#{semmsi004tab5Bean.elEditFlag != 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}"></h:outputText>
																<rich:calendar locale="th" enableManualInput="true" 
																	datePattern="dd/MM/yyyy" 
																	value="#{semmsi004tab5Bean.siteInfoObjELParam.elEffectiveDt03}"
																	showWeeksBar="false"
																	inputSize="10"
																	oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																	cellWidth="15px" cellHeight="20px"
																	styleClass="ms7"
																	rendered="#{semmsi004tab5Bean.elEditFlag != 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}">
																</rich:calendar>
															</h:panelGroup>
														
														<div style="margin:5px;">
															<h:panelGroup>
																<a4j:commandButton value="Add" styleClass="rich-button" 
										       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail" 
										       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '04' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}"
										       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId == null || semmsi004tab5Bean.siteInfoObjELParam.electricType == '' || semmsi004tab5Bean.siteInfoObjELParam.electricType == null
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType != '03'}"
										       					style=" width : 46px;">
										       						<a4j:actionparam name="navModule" value="si" />
										                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                            <a4j:actionparam name="moduleWithNavi" value="si" />
										                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
										                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
										                            <a4j:actionparam name="elType" value="03" />
										                            <a4j:actionparam name="elTypeSub" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType}" />
							                            			<a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" />
							                            			<a4j:actionparam name="siteInfoELContId" value="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId}" />
										       					</a4j:commandButton>
										       					
										       					<rich:spacer width="5"></rich:spacer>
										       					
										       					<a4j:commandButton value="Save" styleClass="rich-button" 
										       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail"
										       					
										       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId != null && semmsi004tab5Bean.siteInfoObjELParam.electricType == '03'}">
										       						<a4j:actionparam name="navModule" value="si" />
										                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                            <a4j:actionparam name="moduleWithNavi" value="si" />
										                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
										                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
										                            <a4j:actionparam name="elType" value="03" />
										                            <a4j:actionparam name="elTypeSub" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType}" />
							                            			<a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" />
							                            			<a4j:actionparam name="siteInfoELContId" value="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId}" />
										       					
										       					</a4j:commandButton>
										       					
										       					<rich:spacer width="5"></rich:spacer>
										       					
										       					<a4j:commandButton value="Cancel" styleClass="rich-button" 
										       					reRender="msi004tab4_wrapper1" action="#{navAction.navi}"
										       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '04' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}">
										       						<a4j:actionparam name="navModule" value="si" />
										                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                            <a4j:actionparam name="moduleWithNavi" value="si" />
										                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
										                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppEl" />
										       					</a4j:commandButton>
															</h:panelGroup>
															
														</div>
														
														<div style="width:100%;">
															
														
															
															
														</div>
											</h:panelGroup>
											
										</div>
									</h:panelGroup>
						
									<rich:spacer height="10"></rich:spacer>
									
								<h:panelGroup id="msi004tab5_elUseOthSite" style="width:100%;" rendered="#{semmsi004tab5Bean.chkElectricType4}">
									<div style="width:100%; border:solid 1px;padding:5px;">
								
										<h:panelGroup style="width:100%;">
											<div>
												<h:outputText value="#{jspMsg['label.infoforELuseohtSite']}" styleClass="ms7" style="text-decoration:underline;"></h:outputText>
											
											</div>
											<div style="width:100%;padding:0;margin:0 auto;" >
												<table width="100%">
													<tr>
														<td align="right" width="20%">
															<h:outputText value="#{jspMsg['label.conNo_siteuseel']} : " styleClass="ms7" />
														</td>
														<td align="left">
															
															<h:inputText value="#{semmsi004tab5Bean.siteInfoObjELParam.elUseOthSiteContractNo}" id="msi004tab5_elUseOthSiteContractNo" maxlength="20" 
															style="padding-left:5px;" styleClass="ms7" onblur="msi004tab5_chkContractElUseJS();" 
															disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}"/>
															
															<a4j:jsFunction name="msi004tab5_chkContractElUseJS" reRender="oppContent,msi004tab5_elUseOthSiteContractNo" 
															action="#{semmsi004tab5Action.msi004tab5_doChkContractElUse}" 
															oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();">
															</a4j:jsFunction>
															
															<a4j:commandButton style="margin-left:5px; height:20px; width : 30px;" id="msi004tab5_BtnCntrctNoOthSite" styleClass="rich-button"
															action="#{semmsi004tab5Action.tab5AddContractElUse_doClearContractElUse}"
															oncomplete="#{rich:component('msi004PopUpCommon_tab5AddContractElUse')}.show();"
															value="..." reRender="msi004tab5_elUseOthSite"
															disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}">
																<a4j:actionparam name="paramSiteAppId" value="#{semmsi004tab5Bean.siteInfoId}" />
															</a4j:commandButton>
															
													
														
														</td>
														
													</tr>
													<tr>
														<td align="right" width="20%">
															<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
														</td>
														<td align="left">
															<h:inputTextarea rows="5" style="width:60%;" id="msi004tab5_elUseOthSiteContractNoArea"
															value="#{semmsi004tab5Bean.siteInfoObjELParam.detail04}"
															disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}"></h:inputTextarea>
														</td>
														
													</tr>
												</table>
												
												<h:panelGroup rendered="#{semmsi004tab5Bean.elEditFlag != 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}">
													<table width="100%">
														<tr>
															<td align="right" width="20%">
																<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7"></h:outputText>
															</td>
															<td align="left">
																<rich:calendar locale="th" enableManualInput="true" 
																	   datePattern="dd/MM/yyyy" 
																	   value="#{semmsi004tab5Bean.siteInfoObjELParam.elEffectiveDt04}"
																	   showWeeksBar="false"
																	   inputSize="10"
																	   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																   	   cellWidth="15px" cellHeight="20px"
																   	   styleClass="ms7"
																   	   disabled="#{semmsi004tab5Bean.elEditFlag == 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}">
																</rich:calendar>
															</td>
														</tr>
													</table>
													
												
												</h:panelGroup>
											
											
											<div style="margin:5px;">
												<h:panelGroup>
													<a4j:commandButton value="Add" styleClass="rich-button" 
								       					action="#{navAction.navi}" reRender="pnlMsi004Tab5_ElContDetail,msi004tab5_elUseOthSiteContractNo,msi004tab5_elUseOthSiteContractNoArea"
								       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}"
								       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId == null || semmsi004tab5Bean.siteInfoObjELParam.electricType == '' || semmsi004tab5Bean.siteInfoObjELParam.electricType == null
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType != '04'}"
								       					style=" width : 46px;">
								       						<a4j:actionparam name="navModule" value="si" />
										                    <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                    <a4j:actionparam name="moduleWithNavi" value="si" />
										                    <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
										                    <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
								                            <a4j:actionparam name="elType" value="04" />
								       					</a4j:commandButton>
								       					
								       					<rich:spacer width="5"></rich:spacer>
								       					
								       					<a4j:commandButton value="Save" styleClass="rich-button" 
								       					disabled="#{semmsi004tab5Bean.siteInfoObjELParam.electricType != '04' && semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId != null}"
								       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId != null && semmsi004tab5Bean.siteInfoObjELParam.electricType == '04'}"
								       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail">
								       						<a4j:actionparam name="navModule" value="si" />
								                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
								                            <a4j:actionparam name="moduleWithNavi" value="si" />
								                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
								                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
								                            <a4j:actionparam name="elType" value="04" />
								       					</a4j:commandButton>
								       					
								       					<rich:spacer width="5"></rich:spacer>
								       					
								       					<a4j:commandButton value="Cancel" styleClass="rich-button" 
								       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1"
								       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}">
								       						<a4j:actionparam name="navModule" value="si" />
								                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
								                            <a4j:actionparam name="moduleWithNavi" value="si" />
								                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
								                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppEl" />
								       					</a4j:commandButton>
												</h:panelGroup>
												
											</div>
											</div>
											
											
										</h:panelGroup>

									</div>
								</h:panelGroup>
								<rich:spacer height="10"></rich:spacer>
								<h:panelGroup id="msa002tab4_elUseOth123" style="width:100%;"  rendered="#{semmsi004tab5Bean.chkElectricType5}">
								<div style="width:100%; border:solid 1px;padding:5px;">
							
									<h:panelGroup style="width:100%;">
										<div>
											<h:outputText value="#{jspMsg['label.infoforELuseOth']} :" styleClass="ms7" style="text-decoration:underline;"></h:outputText>
										
										</div>
										<div style="width:100%;padding:0;margin:0 auto;" >
											<table width="100%">
												
												<tr>
													<td align="left" width="5%">
														<h:outputText value="#{jspMsg['label.th_other']} : " styleClass="ms7" />
													</td>
													<td align="left">
														<h:inputTextarea rows="3" style="width:30%;" id="textDetail"
														value="#{semmsi004tab5Bean.siteElectric.remark}" 
														></h:inputTextarea>
													</td>
													
												</tr>
											</table>
											
										<!-- add2 -->
										<div style="margin:5px;">
											<h:panelGroup> 
												<a4j:commandButton value="Add" styleClass="rich-button" 
							       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail,textDetail" 
							       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '04'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}"
							       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId == null || semmsi004tab5Bean.siteInfoObjELParam.electricType == '' || semmsi004tab5Bean.siteInfoObjELParam.electricType == null
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType != '05'}"
							       					style=" width : 46px;">
										       						<a4j:actionparam name="navModule" value="si" />
										                            <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                            <a4j:actionparam name="moduleWithNavi" value="si" />
										                            <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
							                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="05" />
							                            
							                          <a4j:actionparam name="elTypeSub" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType}" />
							                          <a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" />
							                          <a4j:actionparam name="siteInfoELContId" value="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId}" />
							                           
							       						
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					<!-- Save 7 -->
							       					<a4j:commandButton value="Save" styleClass="rich-button" 
							       					disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '04'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}"
							       					rendered="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId != null && semmsi004tab5Bean.siteInfoObjELParam.electricType == '05'}"
							       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail" >
							       						<a4j:actionparam name="navModule" value="si" />
										                <a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										                 <a4j:actionparam name="moduleWithNavi" value="si" />
										                 <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
							                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="05" />
							                        <a4j:actionparam name="elTypeSub" value="#{semmsi004tab5Bean.siteInfoObjELParam.elCondSubType}" />
							                          <a4j:actionparam name="siteInfoId" value="#{semmsi004tab5Bean.siteInfoId}" />
							                          <a4j:actionparam name="siteInfoELContId" value="#{semmsi004tab5Bean.siteInfoObjELParam.siteInfoELContId}" />
	
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					
							       					<a4j:commandButton value="Cancel" styleClass="rich-button" 
							       					 disabled="#{(semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || (semmsi004tab5Bean.siteInfoObjELParam.electricType == '04'
										       					|| semmsi004tab5Bean.siteInfoObjELParam.electricType == '03' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '02' || semmsi004tab5Bean.siteInfoObjELParam.electricType == '01')}"
							       					action="#{navAction.navi}" reRender="msi004tab4_wrapper1,pnlMsi004Tab5_ElContDetail"  >
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppEl" />
							       					</a4j:commandButton>
											</h:panelGroup>
											
										</div>
										</div>		
									</h:panelGroup>
									
								</div>
							</h:panelGroup>
						
							</div>
					<rich:spacer height="10"></rich:spacer>
							
					<rich:panel id="pnlMsi004Tab5_ElContDetail">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_info_electrict_bill']} "  style="width: 100%;"/>
					</f:facet>
				
					<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
					
						<rich:dataTable id="dtbElContInfo" cellpadding="1" cellspacing="0" border="0"
                        var="obj" value="#{semmsi004tab5Bean.siteInfoELCondAllList}" reRender="dtbElContInfo" 
                        rows="#{semmsi004tab5Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable" >
                            
                            <rich:column width="2%">
	                            <f:facet name="header">
	                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
		                            disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}"
		                            rendered="#{obj.dataObj.electricType != '01' && obj.dataObj.electricType != '02'}"
									reRender="msi004tab4_wrapper1" >
										                            
										                            <a4j:actionparam name="navModule" value="si" />
											                       <a4j:actionparam name="navProgram" value="SEMMSI004-2" />                    
											                        <a4j:actionparam name="moduleWithNavi" value="si" />
											                        <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
											                         <a4j:actionparam name="methodWithNavi" value="doEditEL" />
										                      
										                                <a4j:actionparam name="siteInfoELContId" value="#{obj.dataObj.siteInfoELContId}" />
										                                <a4j:actionparam name="elType" value="#{obj.dataObj.electricType}"  />					                                
										                                <a4j:actionparam name="electricCondSubtype" value="#{obj.dataObj.electricCondSubtype}"  />
									 </a4j:commandButton>
									 
									 		                        
	                            </div>
	                        </rich:column>
	                        
	                        <rich:column width="2%">
	                            <f:facet name="header">
	                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton disabled="#{semmsi004tab5Bean.elEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}" 
		                            action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
		                            reRender="msi004tab4_wrapper1"	                             
		                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;" 
		                            rendered="#{obj.dataObj.recordStatus == 'Y'}">
                   
		                               <a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
		                                
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
		                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppELCond" />
		                                <a4j:actionparam name="siteInfoELContId" value="#{obj.dataObj.siteInfoELContId}" />
										<a4j:actionparam name="siteInfoId" value="#{obj.dataObj.siteInfoId}" />
										<a4j:actionparam name="expenseType" value="#{obj.dataObj.expenseType}" />
										<a4j:actionparam name="serviceId" value="#{obj.dataObj.serviceId}" />
										<a4j:actionparam name="elType" value="#{obj.dataObj.electricType}"  />
										
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
	                        
	                          <rich:column width="2%" sortBy="#{obj.dataObj.status}">
                                <f:facet name="header">
                                    <h:outputText value="Status" styleClass="contentform" style="width: 40"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.status}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                            
                            <rich:column sortBy="#{obj.dataObj.effectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" />
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.effectiveDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column  sortBy="#{obj.dataObj.expireDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.expireDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.chgEffectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" />
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.chgEffectiveDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodStartDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" />
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodStartDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodEndDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodEndDtStr}" styleClass="contentform"  >
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column  sortBy="#{obj.dataObj.electricTypeName}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.electricType']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.electricTypeName}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.sitecontractNo']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.contractNo}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		
                      		<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.calElectric']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricCondSubtypeName}" />
                                </div>
                      		</rich:column>
                      		
                      		<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricAmt}" >
                                    <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      			<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['lable.th_service']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.serviceName}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricPeriodTypeName}" />
                                </div>
                      		</rich:column>
                      		<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="Detail" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.detail}"/>
                                </div>
                      		</rich:column>
                      		
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.elVatTypeName}" />
                                </div>
                      		</rich:column>
                      		<rich:column >
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.pay']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.payPeriodTypeName}"/>
                                </div>
                      		</rich:column>
                      		
                      		<f:facet name="footer">
                                <rich:columnGroup>
                                    <rich:column colspan="4">
                                        <h:outputFormat value="#{msg['message.totalRecords']}">
                                        	<f:param value="#{fn:length(semmsi004tab5Bean.siteInfoELCondAllList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="11">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbElContInfo"
                                            maxPages="#{semmsi004tab5Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteElDetailInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsi004tab5Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            
                   		</rich:dataTable>
					
					</h:panelGroup>
					
				</rich:panel>
							
							</rich:panel>
							<!-- >> group 5 -->
							
							
					
							<rich:spacer height="15"></rich:spacer>
							
							
							
							<!-- << group 6 -->
							<rich:panel id="pnlDepositElectric">
								<h:panelGroup style="width:100%;" rendered="false">
									<table style="width:100%; border:solid ececec 1px; text-align:right;">
										<tr>
											<td style="background-color:ececec; border:solid dcdcdc 1px;">
							                    
											</td>
										</tr>
									</table>
									<rich:spacer height="15"></rich:spacer>
				                </h:panelGroup>
				                
				               
							
								<h:panelGroup>
				                	<div>
				                		<h:selectBooleanCheckbox rendered="false"></h:selectBooleanCheckbox>
				                		<h:outputText value="#{jspMsg['label.th_changeRentalDepInfo']}" styleClass="ms7" rendered="false" />
				                	</div>
				                </h:panelGroup>
				                
				                
				                <h:selectOneRadio id="rbtMsi004tab2_changeElDeposit" value="#{semmsi004tab5Bean.elDepositEditFlag}" styleClass="ms7" 
									rendered="#{semmsi004Bean.reqTypeParam != '01'}"
									disabled="#{semmsi004tab5Bean.disabledModeViewOnly}" onclick="fnMsi004tab5_changeElDepositConfirm();">
			                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_noChange_el_deposit']}" />
			                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_change_el_deposit']}"/>
			                		</h:selectOneRadio>
			                		
			                	<a4j:jsFunction name="fnMsi004tab5_changeElDepositConfirm"
		                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
		                		action="#{semmsi004tab5Action.doSetParamConfirmNotChangeElDeposit}"
		                		 reRender="pnlMsi004Tab5_rentCont, panelTab4, 
		                		btnSaveDptElDeposit, btnSaveDptElDeposit,msi004PopUpCommon_commonConfirm"></a4j:jsFunction>
                		
		                		<a4j:jsFunction name="fnMsi004tab5_changeElDeposit" reRender="dtbElDepCash,dtbElDepBg,pnlMsi004Tab5_rentCont, panelTab4, 
		                		btnSaveDptElDeposit, btnSaveDptElDeposit"></a4j:jsFunction>
			                		
			                <div style="clear:both; height:5px;"></div>
				                <rich:panel>
							
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.elDep']}" style="width: 100%;"/>
									</f:facet>
								
									<h:panelGroup style="width:100%;" id="msi004tab5_pnlElDeposit">
										<h:panelGroup>
						                	<div>
						                		
						                		<h:selectBooleanCheckbox id="chkNoDepositElectric" value="#{semmsi004tab5Bean.chkNoDepositElectric}" styleClass="ms7"
												 onclick="RenderNoDepositElectricJS();"/>
							                	<h:outputText value="#{jspMsg['label.th_noElDep']}" styleClass="ms7" />
							                	<a4j:jsFunction name="RenderNoDepositElectricJS" reRender="pnlDepositElectric,pnlSumDepositElectric" 
										                	action="#{semmsi004tab5Action.renderedNoDepositElectric}"/>
						                	</div>
						                </h:panelGroup>
						               
						                
						                <h:panelGroup>
						                	<div style="width:100%; border:solid 0px;padding:5px;">
										 		<table style="width:100%; " >
													<tr>
														<td align="right" style="width:20%">
												       			<h:outputText value="* " style="font-style:bold; color:red;" />       
															    <h:outputText value="#{jspMsg['label.rentalDepType']} :" styleClass="ms7"></h:outputText>
												       		</td>
												       		<td align="left">
												       			<h:selectOneMenu id="depTypeEl" value="#{semmsi004tab5Bean.electricDepositNormal.depositType}"
												       			onchange="renderDeptBgElCash();" style=" height : 18px;"
												       			disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
												       			semmsi004tab5Bean.chkNoDepositElectric}" >
												       				<f:selectItem itemLabel=" -- Select -- " itemValue=""/>
												       				<f:selectItem itemLabel=" BG " itemValue="01"/>
												       				<f:selectItem itemLabel=" Cash " itemValue="02"/>
												       			</h:selectOneMenu>
												       			
												       			<a4j:jsFunction name="renderDeptBgElCash" action="#{semmsi004tab5Action.doRenderDeptBgCashEl}" reRender="msi004tab5_pnlElDeposit"></a4j:jsFunction>
												       			
												       		</td>
												       		<td align="right" style="width:20%">
												       			 <h:outputText value="* " style="font-style:bold; color:red;" />      
															    <h:outputText value="#{jspMsg['column.header.rantalPayment']} :" styleClass="ms7"></h:outputText>
												       		</td>
												       		<td align="left">
												       			<h:selectOneMenu id="msi004tab5_expenseType" value="#{semmsi004tab5Bean.electricDepositNormal.expenseType}" 
												       			disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
												       			semmsi004tab5Bean.chkNoDepositElectric}">
												       				<f:selectItems value="#{semmsi004tab5Bean.expenseTypeDepositElList}"/>
												       			</h:selectOneMenu>
												       		</td>
												       	</tr>
												   </table>
											<h:panelGrid width="100%">	 
												<h:panelGroup id="pnlDeptCashEl" rendered="#{semmsi004tab5Bean.renderedPnlDeptCashEl}">
													<div id="cash" style="width:100%;" >
									 			<div style="width:100%;" >
									 				<table style="width:100%;">
									 				
									 					<h:panelGroup id="msi004Tab3_pnlCashDepositOld" rendered="#{semmsi004Bean.reqTypeParam != '01' and
					 										semmsi004tab5Bean.electricDepositNormal.depositAmtOld > 0}">
															       				
														<tr>
															<td align="right" width="15%">
																<h:outputText value="#{jspMsg['label.th_old_insure_money']} :" styleClass="ms7"></h:outputText>
															</td>
															<td align="left">
																<h:inputText  value="#{semmsi004tab5Bean.electricDepositNormal.depositAmtOld}" maxlength="17" 
																onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
																onblur="return numberformat.moneyFormat(this);"
																onfocus="return numberformat.setCursorPosToEnd(this);"
																disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"
																 readonly="true">
																	<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																</h:inputText>
																<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
															</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="1">
													        								<h:panelGroup>
													        									<h:selectOneRadio id="msi004Tab5_rbtDeptReturnType01" value="#{semmsi004tab5Bean.deptReturnTypeEl01}"
													        									styleClass="ms7" onclick="msi004Tab5_setDeptReturnTypeEl01();"
													        									disabled="#{semmsi004tab5Bean.elDepositEditFlag == 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}" > 
																							    	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.fullGetBackDep']}"/>
																							    </h:selectOneRadio>
																							   
																							    <a4j:jsFunction name="msi004Tab5_setDeptReturnTypeEl01" action="#{semmsi004tab5Action.renderDeptReturnTypeEl}" 
																							    reRender="msi004Tab5_rbtDeptReturnType01,msi004Tab5_rbtDeptReturnType02,msi004Tab5_txtDeptReturnType02,
																							    msi004Tab5_depositReturnAmt,msi004Tab5_rbtDeptReturnType03">
																							    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																									<a4j:actionparam  name="deptReturnType" value="01"></a4j:actionparam>
																								</a4j:jsFunction>
													        								</h:panelGroup>
													        							</h:panelGrid>   
																		       		</td>
																		       		<td>
																		       		
																		       		</td>
															       				</tr>
															       				<tr>
															       					<td align="left">
															       			       
																					</td>
																		       		<td align="left">
																		       			
																		       		</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="3">
													        								<h:panelGroup>
													        									<h:selectOneRadio id="msi004Tab5_rbtDeptReturnType02" value="#{semmsi004tab5Bean.deptReturnTypeEl02}"
													        									styleClass="ms7" onclick="msi004Tab5_setDeptReturnType02();"
													        									disabled="#{semmsi004tab5Bean.elDepositEditFlag == 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}" > 
																							    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.someGetBackDep']}"/>
																							    	
																							    </h:selectOneRadio>
																							    
																							    <a4j:jsFunction name="msi004Tab5_setDeptReturnType02" action="#{semmsi004tab5Action.renderDeptReturnTypeEl}" 
																							    reRender="msi004Tab5_rbtDeptReturnType01,msi004Tab5_rbtDeptReturnType02,msi004Tab5_txtDeptReturnType02,
																							    msi004Tab5_depositReturnAmt,msi004Tab5_rbtDeptReturnType03">
																							    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																									<a4j:actionparam  name="deptReturnType" value="02"></a4j:actionparam>
																								</a4j:jsFunction>
																							 </h:panelGroup>
																							 <h:panelGroup>
																							    
																							    <h:inputText id="msi004Tab5_txtDeptReturnType02" value="#{semmsi004tab5Bean.electricDepositNormal.returnAmt}" maxlength="17" 
																								onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
															              						onblur="return numberformat.moneyFormat(this);"
															              						onfocus="return numberformat.setCursorPosToEnd(this);"
																								disabled="#{semmsi004tab1Bean.disabledElectric or semmsi004tab5Bean.chkNoDepositElectric or 
																								semmsi004tab5Bean.deptReturnTypeEl02 != '02'}"
																								onchange="doCalDepositElReturnAmt();">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																							 
																							 	<a4j:jsFunction name="doCalDepositElReturnAmt" action="#{semmsi004tab5Action.doCalDepositElReturnAmt}"
																							 	 reRender="msi004Tab5_depositReturnAmt, oppContent, pnlDeptCash">
																							 	
																							 	</a4j:jsFunction>
																							 </h:panelGroup>
																							 <h:panelGroup>
																				       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
													        								
													        								</h:panelGroup>
																		       			</h:panelGrid>       
																					    
																		       		</td>
																		       		<td >
																		       			<h:outputText value="#{jspMsg['label.balance']} : " styleClass="ms7"/>
																		       			<h:inputText id="msi004Tab5_depositReturnAmt" value="#{semmsi004tab5Bean.electricDepositNormal.depositReturnAmt}" maxlength="17" 
																									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
																              						onblur="return numberformat.moneyFormat(this);"
																              						onfocus="return numberformat.setCursorPosToEnd(this);"
																									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"
																									readonly="true">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																		       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																		       		</td>
															       				</tr>
															       				<tr>
															       					<td align="right">
															       			       
																		       		</td>
																		       		<td align="left">
																		       		</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="1">
													        								<h:panelGroup>       
																							    <h:selectOneRadio id="msi004Tab5_rbtDeptReturnType03" value="#{semmsi004tab5Bean.deptReturnTypeEl03}"
													        									styleClass="ms7" onclick="msi004Tab5_setDeptReturnType03();"
													        									disabled="#{semmsi004tab5Bean.elDepositEditFlag == 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}"  > 
																							    	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.noGetBack']}"/>
																							    </h:selectOneRadio>
																							    
																							    <a4j:jsFunction name="msi004Tab5_setDeptReturnType03" action="#{semmsi004tab5Action.renderDeptReturnTypeEl}" 
																							    reRender="msi004Tab5_rbtDeptReturnType01,msi004Tab5_rbtDeptReturnType02,msi004Tab5_txtDeptReturnType02,
																							    msi004Tab5_depositReturnAmt,msi004Tab5_rbtDeptReturnType03" >
																							    	<a4j:actionparam  name="deptType" value="01"></a4j:actionparam>
																									<a4j:actionparam  name="deptReturnType" value="03"></a4j:actionparam>
																								</a4j:jsFunction>
																							 </h:panelGroup>
																						</h:panelGrid>
																		       		
																		       		</td>
																		       		<td>
																		       		
																		       		</td>
															       				</tr>
															       				</h:panelGroup>	
															       			</table>
									 				
									 			</div>
									 			
									 			<table style="width:100%; border:solid 0px;">
															       				
													<tr>
															       					
																		       		<td align=left></td>
																		       		
																		       		<td align="right">
															       			       
																					   	<h:outputText value="#{jspMsg['label.th_all_rentalDep']} : " styleClass="ms7"></h:outputText>
																		       		</td>
																		       		<td align="left">
																		       			<h:inputText id="msi004Tab5_cashDepositAmt" value="#{semmsi004tab5Bean.electricDepositNormal.depositAmt}" maxlength="17" 
																									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
																              						onblur="return numberformat.moneyFormat(this);"
																              						onfocus="return numberformat.setCursorPosToEnd(this);"
																									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"
																									readonly="true">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																		    			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																		       		</td>
																		       		
																		       		</td>
																		       		<td align="right">
															       			       
																					   	<h:outputText value="#{jspMsg['label.th_new_insure']} :" styleClass="ms7"></h:outputText>
																		       		</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
																		       				<h:panelGroup>
																		       					<h:inputText value="#{semmsi004tab5Bean.electricDepositNormal.depositAmtNew}" maxlength="17" 
																									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
																              						onblur="return numberformat.moneyFormat(this);"
																              						onfocus="return numberformat.setCursorPosToEnd(this);"
																									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"
																									onchange="doCalDepositElAmt();">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																		    			
																		    					<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																		    					
																		    					<a4j:jsFunction name="doCalDepositElAmt" action="#{semmsi004tab5Action.doCalDepositElAmt}"
							       																reRender="msi004Tab5_cashDepositAmt,msi004Tab5_bgDepositAmt">
							       																</a4j:jsFunction>
																		    					
																		       				</h:panelGroup>
																		       			
																		       				
																		       				<rich:spacer width="20"></rich:spacer>
																		       				
																		       				
																		       				
																		       			</h:panelGrid>
																		       			
																		    			
																		       		</td>
																		       	</tr>
																		       	<tr>
															       					<td align="right">
															       			       
																					</td>
																		       		<td align="left">
																		       			
																		       		</td>
																		       		
																		       	</tr>
																		    </table>
							 						</div>
												
												</h:panelGroup>	
												
												<h:panelGroup id="pnlDeptBgEl" rendered="#{semmsi004tab5Bean.renderedPnlDeptBgEl}">
													<div id="BG" style="width:100%; border:solid 1px ffffff;padding:5px;" >
									 			<div style="width:100%;">
									 				<table style="width:100%;">
															<h:panelGroup id="msi004Tab5_pnlBgDepositOld" rendered="#{semmsi004Bean.reqTypeParam != '01' and
					 											semmsi004tab5Bean.electricDepositNormal.depositAmtOld > 0}">	
														<tr>
															<td align="right" width="10%">
																<h:outputText value="#{jspMsg['label.oldBG']} :" styleClass="ms7"></h:outputText>
															</td>
															<td align="left">
																<h:inputText value="#{semmsi004tab5Bean.electricDepositNormal.depositAmtOld}" maxlength="17" 
																onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
							              						onblur="return numberformat.moneyFormat(this);"
							              						onfocus="return numberformat.setCursorPosToEnd(this);"
																disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"
																readonly="true">
																	<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																</h:inputText>
																
																<h:outputText value=" #{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
															</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="1">
													        								<h:panelGroup>
													        									
																							    <h:selectOneRadio id="msi004Tab5_rbtDeptReturnTypeBG01" value="#{semmsi004tab5Bean.deptReturnTypeEl01}"
													        									styleClass="ms7" onclick="msi004Tab5_setDeptReturnTypeBG01()"
													        									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"> 
																							    	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.alreadyget']}"/>
																							    </h:selectOneRadio>
																							   
																							    <a4j:jsFunction name="msi004Tab5_setDeptReturnTypeBG01" action="#{semmsi004tab5Action.renderDeptReturnTypeEl}" 
																							    reRender="msi004Tab5_rbtDeptReturnTypeBG01,msi004Tab5_rbtDeptReturnTypeBG02,msi004Tab5_txtDeptReturnTypeBG02,
																							   	msi004Tab5_rbtDeptReturnTypeBG03">
																							    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																									<a4j:actionparam  name="deptReturnType" value="01"></a4j:actionparam>
																								</a4j:jsFunction>
													        								</h:panelGroup>
													        							</h:panelGrid>   
																		       		</td>
																		       		<td>
																		       		
																		       		</td>
															       				</tr>
															       				<tr>
															       					<td align="left">
															       			       
																					</td>
																		       		<td align="left">
																		       			
																		       		</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="3">
													        								<h:panelGroup>
													        									
																							    <h:selectOneRadio id="msi004Tab5_rbtDeptReturnTypeBG02" value="#{semmsi004tab5Bean.deptReturnTypeEl02}"
													        									styleClass="ms7" onclick="msi004Tab5_setDeptReturnTypeBG02()"
													        									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"> 
																							    	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.noBG']}"/>
																							    </h:selectOneRadio>
																							   
																							    <a4j:jsFunction name="msi004Tab5_setDeptReturnTypeBG02" action="#{semmsi004tab5Action.renderDeptReturnTypeEl}" 
																							    reRender="msi004Tab5_rbtDeptReturnTypeBG01,msi004Tab5_rbtDeptReturnTypeBG02,msi004Tab5_txtDeptReturnTypeBG02,
																							   	msi004Tab5_rbtDeptReturnTypeBG03">
																							    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																									<a4j:actionparam  name="deptReturnType" value="02"></a4j:actionparam>
																								</a4j:jsFunction>
																							 </h:panelGroup>
																							 <h:panelGroup>
																							    <h:inputText id="msi004Tab5_txtDeptReturnTypeBG02" value="#{semmsi004tab5Bean.electricDepositNormal.returnAmt}" maxlength="17" 
																								onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
															              						onblur="return numberformat.moneyFormat(this);"
															              						onfocus="return numberformat.setCursorPosToEnd(this);"
																									disabled="#{semmsi004tab1Bean.disabledElectric or semmsi004tab5Bean.chkNoDepositElectric or semmsi004tab5Bean.deptReturnTypeEl02 != '02'}">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																							 </h:panelGroup>
																							 <h:panelGroup>
																				       			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
													        								
													        								</h:panelGroup>
																		       			</h:panelGrid>       
																					    
																		       		</td>
																		       		<td >
																		       			
																		       		</td>
															       				</tr>
															       				<tr>
															       					<td align="right">
															       			       
																		       		</td>
																		       		<td align="left">
																		       		</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="1">
													        								<h:panelGroup>       
																							    
																							    <h:selectOneRadio id="msi004Tab5_rbtDeptReturnTypeBG03" value="#{semmsi004tab5Bean.deptReturnTypeEl03}"
													        									styleClass="ms7" onclick="msi004Tab5_setDeptReturnTypeBG03()"
													        									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"> 
																							    	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payWhencancelContract']}"/>
																							    </h:selectOneRadio>
																							   
																							    <a4j:jsFunction name="msi004Tab5_setDeptReturnTypeBG03" action="#{semmsi004tab5Action.renderDeptReturnTypeEl}" 
																							    reRender="msi004Tab5_rbtDeptReturnTypeBG01,msi004Tab5_rbtDeptReturnTypeBG02,msi004Tab5_txtDeptReturnTypeBG02,
																							   	msi004Tab5_rbtDeptReturnTypeBG03">
																							    	<a4j:actionparam  name="deptType" value="02"></a4j:actionparam>
																									<a4j:actionparam  name="deptReturnType" value="03"></a4j:actionparam>
																								</a4j:jsFunction>
																							 </h:panelGroup>
																						</h:panelGrid>
																		       		
																		       		</td>
																		       		<td>
																		       		
																		       		</td>
															       				</tr>
															       				</h:panelGroup>
															       			</table>
									 				
									 			</div>
							 			
									 				<table style="width:100%; border:solid 0px;">
															       				
													<tr>
															       					<td align="right" width="40%">
															       			       
																					 </td>
																		       		<td align="left">
																		       			</td>
																		       		<td align="right">
															       			       
																					   	<h:outputText value="#{jspMsg['label.newBG']} :" styleClass="ms7"></h:outputText>
																		       		</td>
																		       		<td align="left">
																		       			<h:panelGrid columns="5">
																		       				<h:panelGroup>
																		       					<h:inputText  value="#{semmsi004tab5Bean.electricDepositNormal.depositAmtNew}" maxlength="17" 
																									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
																              						onblur="return numberformat.moneyFormat(this);"
																              						onfocus="return numberformat.setCursorPosToEnd(this);"
																									disabled="#{semmsi004tab1Bean.disabledElectric }"
																									onchange="doCalDepositElAmt();">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																		       				</h:panelGroup>
																		       				
																		       				<h:panelGroup>
																		       					<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																		       				</h:panelGroup>
																		       				
																		       				<rich:spacer width="20"></rich:spacer>
																		       				
																		       				<h:panelGroup>
																		       				
																		       					<a4j:jsFunction name="doCalDepositElAmt" action="#{semmsi004tab5Action.doCalDepositElAmt}"
							       																reRender="msi004Tab5_cashDepositAmt,msi004Tab5_bgDepositAmt" />
																		       				</h:panelGroup>
																		       				
																		       				<h:panelGroup>
																		       				
																		       				</h:panelGroup>
																		       			</h:panelGrid>
																		       			
																		    			
																		       		</td>
																		       	</tr>
																		       	<tr>
															       					<td align="right">
															       			       
																					</td>
																		       		<td align="left">
																		       			
																		       		</td>
																		       		<td align="right">
															       			       
																					   	<h:outputText value="#{jspMsg['label.th_all_rentalDep']} :" styleClass="ms7"></h:outputText>
																		       		</td>
																		       		<td align="left">
																		       			<h:inputText id="msi004Tab5_bgDepositAmt" value="#{semmsi004tab5Bean.electricDepositNormal.depositAmt}" maxlength="17" 
																									onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7"
																              						onblur="return numberformat.moneyFormat(this);"
																              						onfocus="return numberformat.setCursorPosToEnd(this);"
																									disabled="#{semmsi004tab1Bean.disabledElectric || semmsi004tab5Bean.chkNoDepositElectric}"
																									readonly="true">
																										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
																								</h:inputText>
																		    			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
																		       		</td>
																</tr>
																
															</table>
									 					</div>
												</h:panelGroup>
											</h:panelGrid>   
										 		
										 		<table width="100%">
										 			<tr>
										 				<td align="right" width="15%">
										 					<h:outputText value="Vat :" styleClass="ms7"></h:outputText>
										 				</td>
										 				<td align="left">
										 					<h:selectOneRadio id="msi004tab5_rnsdepVatType" value="#{semmsi004tab5Bean.electricDepositNormal.vatType}" 
																		styleClass="ms7" disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
												       			semmsi004tab5Bean.chkNoDepositElectric}" >
											                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
											                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
											                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
											                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
											                			</h:selectOneRadio>
										 				</td>
										 			</tr>
										 			<tr>
										 				<td align="right">
										 				 	<h:outputText value="Service :" styleClass="ms7"></h:outputText>
										 				</td>
										 				<td align="left">
										 					<h:selectOneMenu id="msi004_serviceDepositEl" value="#{semmsi004tab5Bean.electricDepositNormal.serviceId}"
										 					disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
												       			semmsi004tab5Bean.chkNoDepositElectric}" >
										 						<f:selectItems value="#{semmsi004tab1Bean.servTypeList}"/>
										 					</h:selectOneMenu>
										 				</td>
										 			</tr>
										 			<tr>
										 				<td align="right" valign="top">
										 				 	<h:outputText value="#{jspMsg['label.th_remark']} :" styleClass="ms7"> </h:outputText>
										 				</td>
										 				<td align="left">
										 					<h:inputTextarea value="#{semmsi004tab5Bean.electricDepositNormal.remark}" rows="5" style="width:80%;"
										 					disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
												       			semmsi004tab5Bean.chkNoDepositElectric}" ></h:inputTextarea>
										 				</td>
										 			</tr>
										 			
										 		</table>
										 	</div>
										 	
										 	<div style="width:100%; padding-left:50px;margin:10px;">
										 		<h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
							                	<a4j:commandButton id="btnAddDepositElectric" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
								           		action="#{navAction.navi}" reRender="pnlDepositElectric,frmSiteInfoError" 
								           		disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')
								           		 || semmsi004tab5Bean.chkNoDepositElectric}"
								           		 rendered="#{semmsi004tab5Bean.electricDepositNormal.rowId == null}">
								           		<a4j:actionparam name="navModule" value="si" />
												<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />
												<a4j:actionparam name="moduleWithNavi" value="si" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
												<a4j:actionparam name="methodWithNavi" value="doAddDepositElectricNormal" />
								           		</a4j:commandButton>
								           		<rich:spacer width="5"></rich:spacer>
								           		<a4j:commandButton id="btnSaveDepositElectric" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
								           		action="#{navAction.navi}" reRender="pnlDepositElectric,frmSiteInfoError" 
								           		disabled="#{(semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01') || 
												       			semmsi004tab5Bean.chkNoDepositElectric}"
												rendered="#{semmsi004tab5Bean.electricDepositNormal.rowId != null}">
									           		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
													<a4j:actionparam name="methodWithNavi" value="doUpdateDepositElectricNormal" />
								           		</a4j:commandButton>
								           		<rich:spacer width="5"></rich:spacer>
							                	 <a4j:commandButton id="btnCancelDepositElectric" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
								           		action="#{navAction.navi}" reRender="pnlDepositElectric,frmSiteInfoError" 
								           		disabled="#{semmsi004tab5Bean.elDepositEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01'}">
									           		<a4j:actionparam name="navModule" value="si" />
													<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />
													<a4j:actionparam name="moduleWithNavi" value="si" />
													<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
													<a4j:actionparam name="methodWithNavi" value="doClearDepositElectricNormal" />
								           		</a4j:commandButton>
								           		</h:panelGroup>
										 	</div>
										 	
											<!-- BG DEPosit -->
											<rich:panel >
												<f:facet name="header">
													<h:outputText value="#{jspMsg['label.th_BGDepList']}" style="width: 100%;"/>
												</f:facet>
											
												<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
												
													<rich:dataTable width="97%" id="dtbDepositElectricBG"  cellpadding="1" cellspacing="0" border="0"
													var="depositElectricBgSP" value="#{semmsi004tab5Bean.depositElectricBgSPList}" reRender="dtbDepositElectricBG" 
													rows="#{semmsi004tab5Bean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
													<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbDepositElectricBG">
														<a4j:actionparam name="rowId" value="#{depositElectricBgSP.rowId}" />
													</a4j:support>
							                            
							                            <rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositElectricBgSP.rowId)?'onClick':'unClick'}"
														rendered="#{semmsi004Bean.renderedModeView}">
															<f:facet name="header" >
																<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
															</f:facet>
															<div align="center">
								            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlDepositElectric"
								            					image="images/edit.png" style="height: 15; width: 15"
								            					disabled="#{semmsi004tab5Bean.elDepositEditFlag == 'N' && semmsi004Bean.reqTypeParam != '01'}" >
																	<a4j:actionparam name="navModule" value="si" />
									            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />	
																	<a4j:actionparam name="moduleWithNavi" value="si" />
																	<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
																	<a4j:actionparam name="methodWithNavi" value="initUpdateDepositElectricNormal" />
																	<a4j:actionparam name="rowId" value="#{depositElectricBgSP.rowId}" />
								            					</a4j:commandButton>          							
															</div>
														</rich:column>
								                        
								                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositElectricBgSP.rowId)?'onClick':'unClick'}"
														rendered="#{semmsi004Bean.renderedModeView}">
															<f:facet name="header">
																<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
															</f:facet>
															<div align="center">
								            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDepositElectricBgDialog')}.show(); return false" 
							  									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
							  									   disabled="#{semmsi004tab5Bean.elDepositEditFlag == 'N' && semmsi004Bean.reqTypeParam != '01'}" 
								            					>
																	<a4j:actionparam name="navModule" value="si" />
									            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />	
																	<a4j:actionparam name="moduleWithNavi" value="si" />
																	<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
																	<a4j:actionparam name="methodWithNavi" value="initDeleteDepositElectricNormal" />
																	<a4j:actionparam name="rowId" value="#{depositElectricBgSP.rowId}" />
								            					</a4j:commandButton>          							
															</div>
														</rich:column>
							                            
							                            <rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.contStartDtStr}" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform"  value="#{depositElectricBgSP.contEndDtStr}"/>
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricBgSP.expenseTypeName}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="right">
							                                    <h:outputText value="#{depositElectricBgSP.depositAmtNew}" styleClass="contentform" >
																<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
																</h:outputText>
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.depositReturnTypeName}" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricBgSP.newStatusName}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="VAT" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricBgSP.vatTypeName}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricBgSP.remark}" styleClass="contentform" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.serviceId}" />
							                                </div>
							                      		</rich:column>
							                      		
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.BGNo']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.bgNo}" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.bank']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.bankName}" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.BGamt']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.BGstartDate']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.bgStratDtStr}" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.BGendDate']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricBgSP.bgEndDtStr}" />
							                                </div>
							                      		</rich:column>
							                      		
							                      		
							                      		<f:facet name="footer">
															<rich:columnGroup>
																<rich:column colspan="4">
																	<h:outputFormat value="#{msg['message.totalRecords']}">
																		<f:param value="#{fn:length(semmsi004tab5Bean.depositElectricBgSPList)}"></f:param>
																	</h:outputFormat>
																</rich:column>
																<rich:column colspan="12">
																	<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositElectricBG"
																		maxPages="#{semmsi004tab5Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																		stepControls="hide" fastControls="auto" boundaryControls="auto" 
																		id="dstDepositElectricBG" 
																		style="background-color: #cccccc;"
																		page="#{semmsi004tab5Bean.scrollerPage}" 
																	/>
																</rich:column>
															</rich:columnGroup>
														</f:facet>
							                            
							                   		</rich:dataTable>
												
												</h:panelGroup>
											</rich:panel>
											
											<rich:panel >
												<f:facet name="header">
													<h:outputText value="#{jspMsg['label.th_cashDepList']}" style="width: 100%;"/>
												</f:facet>
											
												<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
												
													<rich:dataTable width="97%" id="dtbDepositElectricCash"  cellpadding="1" cellspacing="0" border="0"
													var="depositElectricCashSP" value="#{semmsi004tab5Bean.depositElectricCashSPList}" reRender="dtbDepositElectricCash" 
													rows="#{semmsi004tab3Bean.rowPerPage}"	 rowClasses="cur" 	styleClass="dataTable">
													<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbDepositElectricCash">
														<a4j:actionparam name="rowId" value="#{depositElectricCashSP.rowId}" />
													</a4j:support>
							                            
							                            <rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositElectricCashSP.rowId)?'onClick':'unClick'}"
														rendered="#{semmsi004Bean.renderedModeView}">
															<f:facet name="header" >
																<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
															</f:facet>
															<div align="center">
								            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlDepositElectric"
								            					image="images/edit.png" style="height: 15; width: 15"
								            					disabled="#{semmsi004tab5Bean.editableDepositElectricFlag == 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}" 
								            					rendered="#{semmsi004tab5Bean.editableDepositElectricFlag == 'Y' and depositElectricCashSP.editableFlag == 'Y'
								            					or semmsi004tab5Bean.siteInfoObjParam.reqType == '01'}">
																	<a4j:actionparam name="navModule" value="si" />
									            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />	
																	<a4j:actionparam name="moduleWithNavi" value="si" />
																	<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
																	<a4j:actionparam name="methodWithNavi" value="initUpdateDepositElectricNormal" />
																	<a4j:actionparam name="rowId" value="#{depositElectricCashSP.rowId}" />
								            					</a4j:commandButton>          							
															</div>
														</rich:column>
								                        
								                        <rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositElectricCashSP.rowId)?'onClick':'unClick'}"
														rendered="#{semmsi004Bean.renderedModeView}">
															<f:facet name="header">
																<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
															</f:facet>
															<div align="center">
								            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDepositElectricCashDialog')}.show(); return false" 
							     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
							     									   reRender="pnlDepositElectric"
							     									   disabled="#{semmsi004tab5Bean.editableDepositElectricFlag == 'N' && semmsi004tab5Bean.siteInfoObjParam.reqType != '01'}" 
							     									   rendered="#{semmsi004tab5Bean.editableDepositElectricFlag == 'Y' and depositElectricCashSP.deleteableFlag == 'Y'
							     									   or semmsi004tab5Bean.siteInfoObjParam.reqType == '01'}">
																	<a4j:actionparam name="navModule" value="si" />
									            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB5" />	
																	<a4j:actionparam name="moduleWithNavi" value="si" />
																	<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab5" />
																	<a4j:actionparam name="methodWithNavi" value="initDeleteDepositElectricNormal" />
																	<a4j:actionparam name="rowId" value="#{depositElectricCashSP.rowId}" />
								            					</a4j:commandButton>          							
															</div>
														</rich:column>
							                            
							                            <rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform"  value="#{depositElectricCashSP.contStartDtStr}"/>
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform" value="#{depositElectricCashSP.contEndDtStr}" />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricCashSP.expenseTypeName}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="right">
							                                    <h:outputText value="#{depositElectricCashSP.depositAmtNew}" styleClass="contentform" >
																<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
																</h:outputText>
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform"  value="#{depositElectricCashSP.depositReturnTypeName}"/>
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricCashSP.newStatusName}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="VAT" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricCashSP.vatTypeName}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText value="#{depositElectricCashSP.remark}" styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform"  value="#{depositElectricCashSP.serviceName}" />
							                                </div>
							                      		</rich:column>
							                      		
							                      		
							                      		<f:facet name="footer">
															<rich:columnGroup>
																<rich:column colspan="4">
																	<h:outputFormat value="#{msg['message.totalRecords']}">
																		<f:param value="#{fn:length(semmsi004tab5Bean.depositElectricCashSPList)}"></f:param>
																	</h:outputFormat>
																</rich:column>
																<rich:column colspan="7">
																	<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositElectricCash"
																		maxPages="#{semmsi004tab5Bean.rowPerPage}"  selectedStyleClass="selectScroll"
																		stepControls="hide" fastControls="auto" boundaryControls="auto" 
																		id="dstDepositElectricCash" 
																		style="background-color: #cccccc;"
																		page="#{semmsi004tab5Bean.scrollerPage}" 
																	/>
																</rich:column>
															</rich:columnGroup>
														</f:facet>
							                            
							                   		</rich:dataTable>
												
												</h:panelGroup>
											</rich:panel>
										</h:panelGroup>
									</h:panelGroup>
									
								</rich:panel>
								
				                  
				                <div style="clear:both; height:10px;"></div>
				                
								
							</rich:panel>
							<!-- >> group 6 -->		
					
			</rich:panel>
		</a4j:region>
						
	</h:panelGrid>
</h:panelGrid>