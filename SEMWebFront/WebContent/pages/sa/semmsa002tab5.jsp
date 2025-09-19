
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab6" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_propTax']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 0 -->
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px; text-align:right;">
						<tr>
							<td style="background-color:ececec; border:solid dcdcdc 1px;">
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab6_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info']}#{jspMsg['label.th_tax']}#{jspMsg['label.th_property']}"
								action="#{semmsa002Action.doShowPopupHistory}" reRender="popupDisplay6"
								oncomplete="#{rich:component('tab6_panel_popupModalRetStatus')}.show(); return false;">
								<f:param name="tabNo" value="6"/>
								</a4j:commandButton>
								<a4j:include id="popUpTab6"  viewId="../../pages/sa/semmsa002PopUpTab6.jsp" />
							</td>
						</tr>
					</table>
				</h:panelGroup>
				<!-- << group 0 -->
				
				<div style="clear:both; height:0px;"></div>

				<!-- >> group 1 -->
				<!-- >> group 1 -->
				<rich:panel rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}">
				<h:panelGroup style="width:100%;"> 
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractNo}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.contract_status']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.contractStatus}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.pnextcont']} : " styleClass="ms7" ></h:outputText>
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.pNextContract}"></h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_firstStartContractDate']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar  locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.firstEffDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.effDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<rich:calendar locale="th" enableManualInput="true" 
                                       datePattern="dd/MM/yyyy" 
                                       value="#{semmsa002Bean.siteContInfo.expireDt}"
                                       showWeeksBar="false" 
                                       inputSize="13" 
                                       oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
                                       cellWidth="20px" cellHeight="20px" disabled="true">
                            	</rich:calendar>
                            	<rich:spacer width="20"></rich:spacer>
                            	<h:selectBooleanCheckbox label="#{jspMsg['label.th_contractNeverExpireDt']}" 
								value="#{semmsa002Bean.noExpFlag}" disabled="true"></h:selectBooleanCheckbox>
								<h:outputText value="#{jspMsg['label.th_contractNeverExpireDt']}" styleClass="ms7" />
							</td>
							
						</tr>
						<tr>
							<td align="right">
								<h:outputText value="#{jspMsg['column.header.locationId']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.locationId}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['column.header.locationName']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText style="width:300px;" disabled="true" value="#{semmsa002Bean.siteContInfo.locationThName}"></h:inputText>
							</td>
							<td align="right">
								
								<h:outputText value="#{jspMsg['lable.th_locationstatus']} : " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText disabled="true" value="#{semmsa002Bean.siteContInfo.status}"></h:inputText>
							</td>
						</tr>
					</table>
				</h:panelGroup>					
				</rich:panel>
				<!-- >> group 1 -->
				
				<div style="clear:both; height:5px;"></div>
				
				<h:panelGrid style="width:100%;" columns="1">
	
					<rich:panel style="height:100%; border:1 ececec solid;">
			
						<!-- >> header content -->
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.propertyTaxNewcond']}" />
						</f:facet>
						<!-- << header content -->
				
							<!-- >> group 0 -->
							<h:panelGroup style="width:100%;">
								<table style="width:100%; border:solid 1px;" border="0">
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
										</td>
										<td align="left" width="25%">
											<h:outputText styleClass="ms7" value="#{semmsa002Bean.siteAppPTObj.contractNo}">  </h:outputText>
										</td>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsa002Bean.siteAppPTObj.effectiveDtStr}"></h:outputText>
										</td>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsa002Bean.siteAppPTObj.expireDtStr}"></h:outputText>
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.ptpayer']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText styleClass="ms7" value="#{semmsa002Bean.siteAppPTObj.ptTaxPayTypeName}"></h:outputText>
										</td>
										<td align="right">
											
											
										</td>
										<td align="left" >
										
										</td>
										<td align="right">
											
										</td>
										<td align="left" >
											
										</td>
									</tr>
									<tr>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" style="vertical-align:top;"/>
										</td>
										<td align="left" colspan="5">
											<h:inputTextarea id="msa002tab5_optPtremark" value="#{semmsa002Bean.siteAppPTObj.ptRemark}"
											style="width:1000px;" disabled="true" rows="5">
											
											</h:inputTextarea>
											
										</td>
										
									</tr>
								</table>
							</h:panelGroup>
					</rich:panel>
				</h:panelGrid>
				
				 <div style="clear:both; height:10px;"></div>
				
				<h:panelGroup>
	                	<div>
	                		
	                		<a4j:commandButton id="msa002tab5_BtnUndoPT" value="#{jspMsg['label.th_undo']}#{jspMsg['label.th_changeptinfo']}" 
							disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab5_changePTConfirm();"
							styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:185px;">
							</a4j:commandButton>
	                		
	                		<a4j:jsFunction name="fnMsa002tab5_changePTConfirm"
	                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
	                		action="#{semmsa002Action.doSetParamConfirmNotChangePT}"
	                		reRender="panelTab6,msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
	                		
	                		<a4j:jsFunction name="doInitEditPT" action="#{navAction.navi}" reRender="msa002Tab5_pnlPTParam">
	                			<a4j:actionparam name="navModule" value="sa" />
								<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						        <a4j:actionparam name="moduleWithNavi" value="sa" />
						        <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						        <a4j:actionparam name="methodWithNavi" value="doInitEditPT" />
						        <a4j:actionparam name="ptTaxPayType" value="#{semmsa002Bean.siteAppPTObj.ptTaxPayType}"/>
						        <a4j:actionparam name="ptRemark" value="#{semmsa002Bean.siteAppPTObj.ptRemark}"/>
	                		</a4j:jsFunction>
	                	</div>
	            </h:panelGroup>
				
				<div style="clear:both; height:10px;"></div>
	                
	                <rich:panel id="msa002Tab5_pnlPTParam">
				
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.th_ptCond']}" style="width: 100%;"/>
						</f:facet>
					
						<h:panelGroup style="width:90%;">
							<h:panelGroup>
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
			                		<table style="width:100%;">
			                			<tr>
			                				<td align="right" width="20%">
			                					<h:outputText value="#{jspMsg['label.ptpayer']} : " styleClass="ms7" />
			                				</td>
			                				<td align="left">
			                					<h:selectOneMenu value="#{semmsa002Bean.siteAppPTObjParam.ptTaxPayType}"
			                					disabled="#{semmsa002Bean.disabledModeViewOnly}">
			                					<f:selectItem itemLabel=" -- Select -- " itemValue=""/>
									       				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.propertyTaxPayType02']}"/>
						                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.propertyTaxPayType01']} " />
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.propertyTaxPayType03']} " />
						                				<f:selectItem itemValue="00" itemLabel="#{jspMsg['label.propertyTaxPayType00']}"/>
									       		</h:selectOneMenu>
			                				</td>
			                			</tr>
			                			<tr>
			                				<td align="right" valign="top">
			                					<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
			                				</td>
			                				<td align="left">
			                					<h:inputTextarea rows="5" style="width:100%;" value="#{semmsa002Bean.siteAppPTObjParam.ptRemark}" 
			                					styleClass="ms7"
			                					disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputTextarea>
			                				</td>
			                			</tr>
			                		</table>
			                	</div>
			                	
			                	<div style="clear:both; height:10px;"></div>
			                	
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
										<h:panelGroup>
											<table width="100%">
												<tr>
													<td align="right" width="20%">
														<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7" 
														rendered="#{semmsa002Bean.siteAppObjParam.reqType eq '03'}"></h:outputText>
													</td>
													<td align="left">
														<rich:calendar locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmsa002Bean.siteAppPTObjParam.ptEffectiveDt}"
															   showWeeksBar="false"
															   inputSize="10"
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														   	   cellWidth="15px" cellHeight="20px"
														   	   styleClass="ms7"
														   	   rendered="#{semmsa002Bean.siteAppObjParam.reqType eq '03'}"
														   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
														</rich:calendar>
													</td>
												</tr>
											</table>
										</h:panelGroup>
										
									</div>
									
									<div style="margin:5px;">
										<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgAlert}">               
									         <f:facet name="errorMarkerPage">
									         	<h:graphicImage value="images/error.gif" />  
									         </f:facet>
									    </rich:messages>
										<h:panelGroup>
					       					
					       					<a4j:commandButton id="msa002tab5_btnAddPt" value="Add" styleClass="rich-button" 
					       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
					       					rendered="#{semmsa002Bean.siteAppPTObj.ptTaxPayTypeName eq '' or semmsa002Bean.siteAppPTObj.ptTaxPayTypeName == null}" 
					       					action="#{navAction.navi}" reRender="oppContent">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppPT" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab5_btnSavePt" value="Save" styleClass="rich-button" 
					       					disabled="#{semmsa002Bean.disabledModeViewOnly }"
					       					rendered="#{semmsa002Bean.siteAppPTObj.ptTaxPayTypeName != '' and semmsa002Bean.siteAppPTObj.ptTaxPayTypeName != null}" 
					       					action="#{navAction.navi}" reRender="oppContent">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppPT" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab5_btnClearPt" value="Clear" styleClass="rich-button" rendered="true"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
					       					action="#{navAction.navi}" reRender="oppContent">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppPT" />
					                            <a4j:actionparam name="siteAppRentContMode" value="#{semmsa002Bean.siteAppRentObjParam.rentContMode}" />
					       					</a4j:commandButton>
										</h:panelGroup>
										
									</div>
			               	</h:panelGroup>
			               		<rich:panel >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.th_pthist']}" style="width: 110%;"/>
									</f:facet>
								
									<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
									
										<rich:dataTable width="100%" id="dtbPTHist" cellpadding="1" cellspacing="0" border="0"
				                        var="siteAcqSP" value="#{semmsa002Bean.siteAppPTHistList}" reRender="dtbPTHist" 
				                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
				                            
				                            <rich:column rendered="false">
					                            <f:facet name="header">
					                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
					                            </f:facet>
					                            <div align="center">
						                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
						                            reRender="msa002Tab5_pnlPTParam, oppContent">
						                                <a4j:actionparam name="navModule" value="sa" />
						                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						                                <a4j:actionparam name="moduleWithNavi" value="sa" />
						                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						                                <a4j:actionparam name="methodWithNavi" value="doInitEditPT" />
						                                <a4j:actionparam name="ptTaxPayType" value="#{siteAcqSP.dataObj.pTaxPaymentId}"/>
						                                <a4j:actionparam name="ptRemark" value="#{siteAcqSP.dataObj.ptRemark}"/>
						                                <a4j:actionparam name="ptEffectiveDt" value="#{siteAcqSP.dataObj.ptEffectiveDt}"/>
						                            </a4j:commandButton>
					                            </div>
					                        </rich:column>
					                        
				                            <rich:column sortBy="#{siteAcqSP.dataObj.contractNo}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.contractNo}"/>
				                                </div>
				                      		</rich:column>
				                            <rich:column sortBy="#{siteAcqSP.dataObj.effectiveDt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.effectiveDtStr}"/>
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.expireDt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.ptTaxPayType}">
						                                <f:facet name="header">
						                                    <h:outputText value="#{jspMsg['label.ptpayer']}" styleClass="contentform" style="width: 100"/>
						                                </f:facet>
						                                <div align="center">
						                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.ptTaxPayType}" />
						                                </div>
						                    </rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.TPpaymentYear']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.pTaxYear}"/>
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.PTAmt']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="right">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.periodAmt}" >
				                                    	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                                    </h:outputText>
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.ptRemark}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.ptRemark}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.updateBy}" />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.updatedate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.updateDtStr}" />
				                                </div>
				                      		</rich:column>
				                      		
				                      		
				                      		<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="4">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppPTHistList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
				                                    <rich:column colspan="11">
				                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbPTHist"
				                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
				                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
				                                            id="dstRentalServOtherinfo" 
				                                            style="background-color: #cccccc;"
				                                            page="#{semmsa002Bean.scrollerPage}" 
				                                        />
				                                    </rich:column>
				                                </rich:columnGroup>
				                            </f:facet>
				                            
				                   		</rich:dataTable>
									
									</h:panelGroup>
								</rich:panel>
			               	
			               		
			               	</h:panelGroup>
			        </rich:panel>	
			        
				<div style="clear:both;"></div>
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
