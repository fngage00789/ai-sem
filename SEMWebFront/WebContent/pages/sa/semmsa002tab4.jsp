
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab4" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_info_electrict_bill']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 0 -->
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px; text-align:right;">
						<tr>
							<td style="background-color:ececec; border:solid dcdcdc 1px;">
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab4_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_electrict_bill']}"
								action="#{semmsa002Action.doShowPopupHistory}" reRender="oppContent,popupDisplay4"
								oncomplete="#{rich:component('tab4_panel_popupModalRetStatus')}.show(); return false;">
								<f:param name="tabNo" value="4"/>
								</a4j:commandButton>
								<a4j:include id="popUpTab4"  viewId="../../pages/sa/semmsa002PopUpTab4.jsp" />
							</td>
						</tr>
					</table>
				</h:panelGroup>
				<!-- << group 0 -->

				<div style="clear:both; height:5px;"></div>
	
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
				<!-- >> group 2 -->
				<rich:panel>
				<h:panelGroup style="width:100%;"> 
					<table width="100%">
						<tr>
							<td align="center">
								<div id="msa002tab3Service" style="width:600px; overflow:scroll; border:1px solid e0e0e0;padding:0px;margin:0 auto;"> 
						
									<rich:dataTable align="center" style="width:100%;" id="dataService1tab1" cellpadding="1" cellspacing="0" border="0" 
									var="appServObj"  value="#{semmsa002Bean.siteAppServList}" reRender="dataService1tab1" 
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
						                                    <h:outputText value="#{appServObj.dataObj.servName}" />
						                                </rich:column>
									    <rich:column>
									    	<h:outputText value="#{appServObj.dataObj.action}" />
									    </rich:column>
									    <rich:column style="text-align:center">
									    	<h:outputText value="#{appServObj.dataObj.seq}" />
									    </rich:column>
										<!-- data -->
											            
										<!-- footer -->
														
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
				
				<div style="clear:both; height:10px;"></div>
				
				<h:panelGroup>
                	<div>
                		
                		<h:outputText value="#{jspMsg['label.changeelectricInfo']}" rendered="flase"
                		 styleClass="ms7" />
                		<a4j:jsFunction name="reRenderTab4" reRender="panelTab4" action="#{semmsa002Action.checkEdit}"></a4j:jsFunction>
                	</div>
                </h:panelGroup>
      
                <div style="clear:both; height:10px;" >
                	<h:selectBooleanCheckbox value="#{semmsa002Bean.chkEditElExistingList}" 
                	rendered="false" onclick="reRenderTab4();">
                	</h:selectBooleanCheckbox>
                </div>
        		<!-- >> group 3 -->        
               
                <rich:panel id="pnlMsa002Tab4_ElCont">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_electricInfoList']} (Existing)" style="width: 100%;"/>
					</f:facet>
				
					<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
					
						<rich:dataTable width="100%" id="dtbSiteInfo" cellpadding="1" cellspacing="0" border="0"
                        var="obj" value="#{semmsa002Bean.siteAppELCondExistingList}" reRender="dtbSiteInfo" 
                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
                            
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
                                    <h:outputText value="#{obj.dataObj.effectiveDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.expireDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.expireDtStr}" styleClass="contentform"  />
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
                                    <h:outputText value="#{obj.dataObj.periodStartDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodEndDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodEndDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.elType}">
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
                                    <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricPeriodTypeName}" />
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
                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppELCondExistingList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="11">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbSiteInfo"
                                            maxPages="#{semmsa001Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsa001Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                </rich:columnGroup>
                            </f:facet>
                            
                   		</rich:dataTable>
					
					</h:panelGroup>
				</rich:panel>
				 <rich:spacer height="10"></rich:spacer>
				
				<h:panelGrid id="msgMidTab4">
				<rich:messages id="msgPnlTab4_mid" layout="list" errorClass="ms7red" warnClass="ms7blue" 
					infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgFormChkExpire}">
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                </rich:messages>
				</h:panelGrid>
				
			<h:panelGroup> <!-- PLY -->
		<div>			
						
						<a4j:commandButton id="msa002tab4_BtnUndoEL" value="#{jspMsg['label.th_undo']}#{jspMsg['label.th_el']}" 
						disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab4_changeElComfirm();"
						styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:120px;">
						</a4j:commandButton>
						
                		<a4j:jsFunction name="fnMsa002tab4_changeElComfirm"
                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
                		action="#{semmsa002Action.doSetParamConfirmNotChangeEl}"
                		 reRender="pnlMsa002Tab4_ElCont, panelTab4, btnAddOther,btnSave1,btnNew,msa002tab4_wrapper1,
                		msa002PopUpCommon_commonConfirm,msa002tab4_pnlElDetail"></a4j:jsFunction>
                		
                		<a4j:jsFunction name="fnMsa002tab4_changeInsurance" reRender="pnlMsa002Tab4_ElCont, panelTab4, 
                		btnSaveDptEl, btnSaveDptEl,msa002tab4_pnlElDetail"></a4j:jsFunction>
   </div>
</h:panelGroup>

				
				<!-- >> group 4 -->
				<div style="clear:both; height:10px;"></div>
				
				<rich:panel id="msa002tab4_wrapper1">
					<div style="width:100%; border:solid 1px;padding:5px;">
					
						<h:panelGroup style="width:100%;">
							<!-- table column: 20:80 -->
							<rich:messages id="msgPnlTab4_elType" layout="list" errorClass="ms7red" warnClass="ms7blue" 
								infoClass="ms7green" >
			                        <f:facet name="errorMarkerPage">
			                             <h:graphicImage value="images/error.gif" />  
			                        </f:facet>
			                </rich:messages>
							<table style="width:100%; ">
									<tr>
									<%-- <a4j:region> --%>
										<td style="width:15%; text-align:right; white-space:nowrap; vertical-align:top;">
											<h:outputText value="#{jspMsg['label.th_type_electrictUsed']} : " styleClass="ms7" />
										</td>
										<td style="width:80%; white-space:nowrap;">
											<table style="width:100%; border:solid ececec 1px;">
											    <tr>
											        <td>
											            <h:selectBooleanCheckbox id="msa002tab4_chkElUseOldMeterBK" value="#{semmsa002Bean.chkElUseOldMeter}" 
	                                                    onclick="msa002tab4_chkElctTypeOldJS();" 
	                                                    disabled="#{semmsa002Bean.disabledModeViewOnly
														|| (semmsa002Bean.siteAppObjParam.elEditFlag != 'Y' && semmsa002Bean.siteAppObjParam.reqType != '01')}" 
	                                                    rendered="false">
	                                                    </h:selectBooleanCheckbox>
	                                                    <h:outputText value="#{jspMsg['label.th_use_electrict_old']}" style="margin-left:5px;" styleClass="ms7"
	                                                     rendered="false"/>
											        </td>
											        <td></td>
											        <td></td>
											    </tr> 
											 
											    <tr>
											        <td>
											        	<h:selectBooleanCheckbox  id="msa002tab4_chkMultiElectricTypeFlag" value="#{semmsa002Bean.chkMultiElectricTypeFlag}" 
												             styleClass="ms7"  disabled="true"
														 />
										                	<h:outputText value="#{jspMsg['label.multiElectricTypeFlag']}" styleClass="ms7" />	
											        		<rich:spacer width="20"></rich:spacer>
											        		<h:outputText value=" #{semmsa002Bean.pRemark}" rendered="true" styleClass="ms7Red"></h:outputText>
											        
											        </td>
											        
											   							   	
											        <td>
											        
											        </td>
											    </tr>
											 
											    <tr> <!-- checkbox -->
											        <td colspan="2">
											        	
											        	<h:selectBooleanCheckbox id="msa002tab4_chkElUseOldMeter" value="#{semmsa002Bean.chkElUseOldMeter}" 
	                                                    onclick="if(#{semmsa002Bean.chkElUseOldMeter }){
														if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.th_use_electrict_old']} #{jspMsg['msg.th_trueornot']}'))
														{reRenderCheckBox(); msa002tab4_chkElctTypeOldJS();}
														else{return false;}}else{msa002tab4_chkElctTypeOldJS();}" 
	                                                    disabled="#{semmsa002Bean.disabledModeViewOnly}" 
	                                                    rendered="#{semmsa002Bean.chkElUseOldMeter}">
	                                                    </h:selectBooleanCheckbox>
	                                                    <h:outputText value="#{jspMsg['label.th_use_electrict_old']}" style="margin-left:5px;" styleClass="ms7"
	                                                     rendered="#{semmsa002Bean.chkElUseOldMeter}"/>
											        
											        
											        
											        	<h:selectBooleanCheckbox id="msa002tab4_chkElUseNewMeter" value="#{semmsa002Bean.chkElUseNewMeter}"  
														onclick="if(#{semmsa002Bean.chkElUseNewMeter }){
														if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.th_use_electrict_new']} #{jspMsg['msg.th_trueornot']}'))
														{reRenderCheckBox(); msa002tab4_chkElctTypeNewJS();}
														else{return false;}}else{msa002tab4_chkElctTypeNewJS();}"
														disabled="#{semmsa002Bean.disabledModeViewOnly}"
														rendered="#{!semmsa002Bean.chkElUseOldMeter}" >
														</h:selectBooleanCheckbox>
														<h:outputText rendered="#{!semmsa002Bean.chkElUseOldMeter}" value="#{jspMsg['label.th_use_electrict_new']}" style="margin-left:5px;" styleClass="ms7" />
													
														
													
														<rich:spacer width="50px;"></rich:spacer>
														
														
														<a4j:jsFunction name="reRenderCheckBox" reRender="msa002tab4_wrapper1"></a4j:jsFunction>
													
														<h:selectBooleanCheckbox id="msa002tab4_chkElUseOwner" value="#{semmsa002Bean.chkElUseOwner}" 
														onclick="if(#{semmsa002Bean.chkElUseOwner }){
														if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.th_use_electrict_landlord']} #{jspMsg['msg.th_trueornot']}'))
														{reRenderCheckBox(); msa002tab4_chkElctTypeOwnerJS();}
														else{return false;}}else{msa002tab4_chkElctTypeOwnerJS();}" 
														disabled="#{semmsa002Bean.disabledModeViewOnly}">
														</h:selectBooleanCheckbox>
														<h:outputText value="#{jspMsg['label.th_use_electrict_landlord']}" style="margin-left:5px;" styleClass="ms7" />
														
														<rich:spacer width="15"></rich:spacer>
														
														<h:selectBooleanCheckbox id="msa002tab4_chkElUseOthSite" value="#{semmsa002Bean.chkElUseOthSite}" 
														disabled="#{semmsa002Bean.disabledModeViewOnly}"
														 onclick="if(#{semmsa002Bean.chkElUseOthSite }){
														if(confirm('#{jspMsg['msg.th_cancelUserEL']} #{jspMsg['label.th_use_electrict_otherSite']} #{jspMsg['msg.th_trueornot']}'))
														{reRenderCheckBox(); chkElUseOthSite();}
														else{return false;}}else{chkElUseOthSite();}" />
														<h:outputText value="#{jspMsg['label.th_use_electrict_otherSite']}" style="margin-left:5px;" styleClass="ms7" />
														
														<rich:spacer width="15"></rich:spacer>
														<h:selectBooleanCheckbox id="msa002tab4_chkElUseOth" value="#{semmsa002Bean.chkElUseOth}" 
														onclick="if(#{semmsa002Bean.chkElUseOth }){
														if(confirm('#{jspMsg['msg.th_cancelUserELOth']} #{jspMsg['msg.th_trueornot']}'))
														{reRenderCheckBox(); elUseOth();}
														else{return false;}}else{elUseOth();}" 
														disabled="#{semmsa002Bean.disabledModeViewOnly}" />
														<h:outputText value="#{jspMsg['label.th_other']}  " style="margin-left:5px;" styleClass="ms7" />
														<rich:spacer width="5"></rich:spacer>
														
											        </td>
											        
											    </tr>
											</table>
											
												<a4j:jsFunction name="msa002tab4_chkElctTypeNewJS" reRender="msa002tab4_chkElUseNewMeter, msa002tab4_chkElUseOwner,
												msa002tab4_chkElUseOldMeter, msa002tab4_elPayOnPackageAmt, msa002tab4_chkElUseOthSite,
												msa002tab4_elPkgPeriodType, msa002tab4_elUnitPrice, msa002tab4_chkElUseOth, msa002tab4_pnlElUseOwner, groElUseOthTxt,
												msa002tab4_pnlElDetail,msa002tab4_chkMultiElectricTypeFlag,btnNew,btnAddOther,btnCancel1,msgPnlTab4_elType,
												pnlMsa002Tab4_ElContDetail" 
												action="#{semmsa002Action.msa002tab4_doChkElctType}">
														<a4j:actionparam name="paramChkElType" value="NEW" />
														<a4j:actionparam name="elType" value="01" />                
							                        <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
												</a4j:jsFunction>
												
												<a4j:jsFunction name="msa002tab4_addElctTypeNewJS"
							       				action="#{navAction.navi}" 
							       				reRender="pnlMsa002Tab4_ElContDetail,msa002tab4_pnlElDetail,pnlMsa002Tab4_ElContDetail,
							       				btnAddOther,msa002tab4_chkElUseOth,groElUseOthTxt,txtOth,msa002tab4_wrapper1">
							       					<a4j:actionparam name="navModule" value="sa" />
							                   		<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                        <a4j:actionparam name="moduleWithNavi" value="sa" />
							                        <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                        <a4j:actionparam name="methodWithNavi" value="doInitAddSiteAppELCond" />
							                        <a4j:actionparam name="elType" value="01" />                
							                        <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                        <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />    
							       				</a4j:jsFunction>
												
												<a4j:jsFunction name="chkElUseOthSite" reRender="msa002tab4_chkElUseNewMeter, msa002tab4_chkElUseOwner,
												msa002tab4_chkElUseOldMeter, msa002tab4_elPayOnPackageAmt, msa002tab4_chkElUseOthSite,
												msa002tab4_elPkgPeriodType, msa002tab4_elUnitPrice, msa002tab4_chkElUseOth, msa002tab4_pnlElUseOwner, groElUseOthTxt,
												msa002tab4_pnlElDetail,msa002tab4_chkMultiElectricTypeFlag,btnAddOther,btnCancel1,msgPnlTab4_elType" 
                                                action="#{semmsa002Action.msa002tab4_doChkElctType}">
                                                    <a4j:actionparam name="paramChkElType" value="OTHER" />
                                                </a4j:jsFunction>
												
												<a4j:jsFunction name="msa002tab4_chkElctTypeOwnerJS" reRender="msa002tab4_chkElUseNewMeter, msa002tab4_chkElUseOwner,
												msa002tab4_chkElUseOldMeter, msa002tab4_elPayOnPackageAmt, msa002tab4_chkElUseOthSite,
												msa002tab4_elPkgPeriodType, msa002tab4_elUnitPrice, msa002tab4_chkElUseOth, msa002tab4_pnlElUseOwner, groElUseOthTxt,
												msa002tab4_pnlElDetail,msa002tab4_chkMultiElectricTypeFlag,btnAddOther,btnCancel1,msgPnlTab4_elType" 
												action="#{semmsa002Action.msa002tab4_doChkElctType}">
													<a4j:actionparam name="paramChkElType" value="OWNER" />
												</a4j:jsFunction>
												
												
												<a4j:jsFunction name="msa002tab4_chkElctTypeOldJS" reRender="msa002tab4_chkElUseNewMeter, msa002tab4_chkElUseOwner,
												msa002tab4_chkElUseOldMeter, msa002tab4_elPayOnPackageAmt, msa002tab4_chkElUseOthSite,
												msa002tab4_elPkgPeriodType, msa002tab4_elUnitPrice, msa002tab4_chkElUseOth, msa002tab4_pnlElUseOwner, groElUseOthTxt,
												msa002tab4_pnlElDetail,msa002tab4_chkMultiElectricTypeFlag,msgPnlTab4_elType,pnlMsa002Tab4_ElContDetail" 
												action="#{semmsa002Action.msa002tab4_doChkElctType}">
													<a4j:actionparam name="paramChkElType" value="OLD" />
													 <a4j:actionparam name="elType" value="02" />                
							                        <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" /> 
												</a4j:jsFunction>
												
												<a4j:jsFunction name="msa002tab4_addElctTypeOldJS"
							       				action="#{navAction.navi}" 
							       				reRender="pnlMsa002Tab4_ElContDetail,msa002tab4_pnlElDetail,pnlMsa002Tab4_ElContDetail,
							       				btnAddOther,msa002tab4_chkElUseOth,groElUseOthTxt,txtOth,msa002tab4_wrapper1">
							       					<a4j:actionparam name="navModule" value="sa" />
							                   		<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                        <a4j:actionparam name="moduleWithNavi" value="sa" />
							                        <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                        <a4j:actionparam name="methodWithNavi" value="doInitAddSiteAppELCond" />
							                        <a4j:actionparam name="elType" value="02" />                
							                        <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                        <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />    
							       				</a4j:jsFunction>
												
												<a4j:jsFunction name="elUseOth" reRender="msa002tab4_chkElUseNewMeter, msa002tab4_chkElUseOwner,service,msa002tab4_service
												msa002tab4_chkElUseOldMeter, msa002tab4_elPayOnPackageAmt, msa002tab4_chkElUseOthSite,
												msa002tab4_elPkgPeriodType, msa002tab4_elUnitPrice, msa002tab4_chkElUseOth, msa002tab4_pnlElUseOwner, groElUseOthTxt,
												msa002tab4_pnlElDetail,msa002tab4_chkMultiElectricTypeFlag,btnAddOther,btnCancel1,msgPnlTab4_elType" 
												action="#{semmsa002Action.msa002tab4_doChkElctType}">
													<a4j:actionparam name="paramChkElType" value="OTH" />
												</a4j:jsFunction>
											        
										
										</td>
									<%-- </a4j:region> --%>
									</tr>
									
									<tr>
										<td align="right">
											<h:outputText id="service" value="#{jspMsg['lable.th_service']} : " styleClass="ms7" />
										</td>
										<td align="left">
											<h:selectOneMenu id="msa002tab4_service"  value="#{semmsa002Bean.siteAppELObjParam.serviceId}" 
											 styleClass="ms7" disabled="#{semmsa002Bean.disabledModeViewOnly}">
												<f:selectItems value="#{semmsa002Bean.servTypeList}"/>
											</h:selectOneMenu>
										</td>
										
									</tr>
									
									
							</table>
							
							
							<div style="margin:5px;" id="btnNew">
												<h:panelGroup rendered="false">
												
												<!-- Add3 -->
													<a4j:commandButton value="Add" styleClass="rich-button"  id="btnAddOther"
							       					action="#{navAction.navi}" reRender="pnlMsa002Tab4_ElContDetail,msa002tab4_pnlElDetail,pnlMsa002Tab4_ElContDetail,btnAddOther,msa002tab4_chkElUseOth,groElUseOthTxt,txtOth,msa002tab4_wrapper1" 
							       					disabled="false"
							       					rendered="#{semmsa002Bean.siteAppELObjParam.siteAppELContId == null || semmsa002Bean.siteAppELObjParam.siteAppELContId == ''}"
							       					style=" width : 46px;">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="01" />                
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							                            
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					<!-- Save5 -->
							       					<a4j:commandButton value="Save" styleClass="rich-button" id="btnSave1" 
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,dtbElDepCash,dtbRentalServDepBG,pnlMsa002Tab4_ElContDetail,msa002tab4_wrapper1,msa002tab4_pnlElDetail,pnlMsa002Tab4_ElContDetail,btnAddOther,msa002tab4_chkElUseOth,groElUseOthTxt,txtOth"
							       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
							       					rendered="#{semmsa002Bean.siteAppELObjParam.siteAppELContId != null && semmsa002Bean.siteAppELObjParam.siteAppELContId != ''}">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
							                             <a4j:actionparam name="elType" value="01" />         
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						<a4j:actionparam name="serviceId" value="#{semmsa002Bean.siteAppELObjParam.serviceId}" />
							       					</a4j:commandButton>
							       					
							       					
							       					<rich:spacer width="10"></rich:spacer>
							       					
							       					<a4j:commandButton value="Cancel" styleClass="rich-button" id="btnCancel1" 
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,msa002tab4_wrapper1"
							       					disabled="false">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppEl" />
							       					</a4j:commandButton>
												</h:panelGroup>
												<rich:spacer width="5"></rich:spacer>
												<h:outputLabel value="sss" rendered="false"></h:outputLabel>
											</div>
											
						</h:panelGroup>	
						
						
						
						<h:panelGrid id="msa002tab4_pnlElDetail" style="width:100%;" >
							<h:panelGroup id="msa002tab4_pnlElUseOwner" style="width:100%;" rendered="#{semmsa002Bean.chkElUseOwner}">
								<div style="width:100%; border:solid 1px ;ping:5px;">
						
								<h:panelGroup style="width:100%;">
									<div>
										<h:outputText value="#{jspMsg['label.infoforELuseOwner']}" styleClass="ms7" style="text-decoration:underline;"></h:outputText>
									
									</div>
									<div style="width:50%;ping:0;margin:0 auto;" >
										<table width="100%">
											<tr>
												<td align="right">
													<h:outputText value="#{jspMsg['label.ELcond']} : " styleClass="ms7" />
												</td>
												<td align="left">
													<h:selectOneMenu value="#{semmsa002Bean.siteAppELObjParam.elCondType}" style=" height : 19px;"
													onchange="doSelectELUseCond()" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														<f:selectItems value="#{semmsa002Bean.elCondTypeList}"/>
														<a4j:jsFunction name="doSelectELUseCond" action="#{semmsa002Action.doSelectELUseCond}"
														reRender="msa002tab4_pnlElUseOwner"></a4j:jsFunction>
													</h:selectOneMenu>
													
												</td>
												<td align="right">
													<h:outputText value="#{jspMsg['label.ELcondOth']} : " styleClass="ms7" />
												</td>
												<td align="left">
													<h:selectOneMenu value="#{semmsa002Bean.siteAppELObjParam.elCondSubType}" 
													disabled="#{semmsa002Bean.siteAppELObjParam.elCondType ne '01'}"
													onchange="renderELUnitTakeAll();">
														<f:selectItems value="#{semmsa002Bean.elCondSubTypeList}"/>
													</h:selectOneMenu>
													
													<a4j:jsFunction name="renderELUnitTakeAll" action="#{semmsa002Action.doSetDefaultEl}" reRender="msa002tab4_pnlUnit,msa002tab4_pnlTakeAll,msa002tab4_wrapper1">
													
													</a4j:jsFunction>
												</td>
											</tr>
											
										</table>
									</div>
									
									<rich:panel id="msa002tab4_pnlUnit" style="width:100%;" rendered="#{semmsa002Bean.siteAppELObjParam.elCondSubType eq '01'}">
										<div style="width:100%; border:solid 1px fff;ping:5px;">
											<table>
												<tr>
													<td align="right" width="20%">
														<h:outputText value="#{jspMsg['label.th_perUnit']} :" styleClass="ms7" ></h:outputText>
													</td>
													<td align="left">
														<h:inputText value="#{semmsa002Bean.siteAppELObjParam.elUnitPrice}" id="msa002tab4_elUnitPrice" maxlength="15" 
														onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
					                		 			onblur="numberformat.moneyFormat(this);"
					                		 			onfocus="return numberformat.setCursorPosToEnd(this);" 
														style="text-align:right; height : 18px;" styleClass="ms7"
														disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoUtilPrice}">
															<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
														</h:inputText>
														
														<rich:spacer width="50"></rich:spacer>
														<h:selectBooleanCheckbox id="msa002tab4_chkNoUtilPrice" value="#{semmsa002Bean.chkNoUtilPrice}" 
														onclick="noUnitPrice();" disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.siteAppELObjParam.elCondType != '01'}">
														</h:selectBooleanCheckbox>
														
														<a4j:jsFunction name="noUnitPrice" action="#{semmsa002Action.doChkNoUnitPrice}" reRender="msa002tab4_elUnitPrice, msa002tab4_wrapper1">
														
														</a4j:jsFunction>
														<h:outputText value="#{jspMsg['label.th_noutilprice']}" styleClass="ms7" ></h:outputText>
														
													</td>
												</tr>
												
												<tr>
													<td align="right">
														<h:outputText value="Vat : "  styleClass="ms7" ></h:outputText>
													</td>
													<td align="left">
														<h:selectOneRadio  id="msa002tab3_ELVatType2" value="#{semmsa002Bean.siteAppELObjParam.elVatType}" 
														style="" styleClass="ms7" >
								                			<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
								                			<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
								                			<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
								                			<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
								                		</h:selectOneRadio>
													</td>
												</tr>
												<tr>
													<td align="right">
														<h:outputText value="W/T :" styleClass="ms7"></h:outputText>
													</td>
													<td align="left">
														<h:selectOneRadio id="msa002tab4_elUnitWHT" value="#{semmsa002Bean.siteAppELObjParam.whtType}" 
			                                            styleClass="ms7">
			                                                <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']}#{jspMsg['label.th_tax']}" />
			                                                <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']}#{jspMsg['label.th_tax']}"/>
			                                                <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_free']}#{jspMsg['label.th_tax']}" />
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
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType01_act" value="#{semmsa002Bean.elPayPeriodType01}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType01_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType01_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
												        	<h:panelGroup>
										       					
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType06_act" value="#{semmsa002Bean.elPayPeriodType06}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType06_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType06_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="06"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
												        	<h:panelGroup>
										       					
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType07_act" value="#{semmsa002Bean.elPayPeriodType07}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType07_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType07_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="07"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
												        	<h:panelGroup>
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType02_act" value="#{semmsa002Bean.elPayPeriodType02}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType02_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType02_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
														   	</h:panelGroup>
												        	<h:panelGroup>     
														        
												                <h:selectOneRadio id="msa002tab4_elPayPeriodType03_act" value="#{semmsa002Bean.elPayPeriodType03}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType03_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType03_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												           	</h:panelGroup>
												        	<h:panelGroup>     
												                
												                <h:inputText id="msa002tab4_txtElPayPeriodTypeMonth_act" size="5"  disabled="#{semmsa002Bean.disabledModeViewOnly 
												                || semmsa002Bean.elPayPeriodType03 != '03'}"
										                				value="#{semmsa002Bean.elPayPeriod03}" styleClass="inputRight" onblur="msa002tab4_setElPayPeriodType03_act();"
										                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
												                
												                <rich:spacer width="5"></rich:spacer>
												                <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
												           	</h:panelGroup>
												        	<h:panelGroup>     
												                
												                <h:selectOneRadio id="msa002tab4_elPayPeriodType04_act" value="#{semmsa002Bean.elPayPeriodType04}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType04_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType04_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												            </h:panelGroup>
												        	<h:panelGroup>				
												                <h:inputText id="msa002tab4_txtElPayPeriodTypeYear_act" size="5" disabled="#{semmsa002Bean.disabledModeViewOnly 
												                || semmsa002Bean.elPayPeriodType04 != '04'}"
										                				value="#{semmsa002Bean.elPayPeriod04}" styleClass="inputRight"
										                				onblur="msa002tab4_setElPayPeriodType04_act();"
										                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
										                				
												                <rich:spacer width="5"></rich:spacer>
												                <h:outputText value="#{jspMsg['label.th_year']}" styleClass="ms7"></h:outputText>
												            
											                </h:panelGroup>
											                <h:panelGroup>
											                	
												                <h:selectOneRadio id="msa002tab4_elPayPeriodType05_act" value="#{semmsa002Bean.elPayPeriodType05}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType05_act();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType05_act" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01_act,msa002tab4_elPayPeriodType02_act,msa002tab4_elPayPeriodType03_act,
																    msa002tab4_elPayPeriodType04_act,msa002tab4_elPayPeriodType05_act,msa002tab4_txtElPayPeriodTypeMonth_act,
																    msa002tab4_txtElPayPeriodTypeYear_act,msa002tab4_elPayPeriodType06_act,msa002tab4_elPayPeriodType07_act">
																		<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
											           	</h:panelGrid> 
													</td>
												</tr>
												<tr>
													<td style="text-align:right;" valign="top">
														<h:outputText value="#{jspMsg['column.header.startPeriodDate']} : " styleClass="ms7" />
								       				</td>
								       				<td style="text-align:left;" valign="top" colspan="5">
								       					<a4j:region>
															<!-- begin date -->
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmsa002Bean.siteAppELObjParam.periodStartDt}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   label=""
															   	   styleClass="ms7"
															   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
															</rich:calendar>
															
															<rich:spacer width="50"></rich:spacer>
															<h:outputText value="#{jspMsg['column.header.endPeriodDate']} :  " styleClass="ms7" />
															<!-- end date -->
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmsa002Bean.siteAppELObjParam.periodEndDt}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   label=""
															   	   styleClass="ms7"
															   	   disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly}">
															</rich:calendar>
														</a4j:region>
								       				</td>
												</tr>
											</table>
										</div>
									</rich:panel>
									
									<rich:panel id="msa002tab4_pnlTakeAll" style="width:100%;" rendered="#{semmsa002Bean.siteAppELObjParam.elCondSubType eq '02'}">
										<div style="width:100%; border:solid 1px fff;ping:5px;">
											<table>
												<tr>
													<td align="right" width="15%">
														<h:outputText value="#{jspMsg['column.header.amt']} :" styleClass="ms7" ></h:outputText>
													</td>
													<td align="left">
														<h:inputText value="#{semmsa002Bean.siteAppELObjParam.takeAllAmt}" id="msa002tab4_elPayOnPackageAmt" maxlength="15" 
														onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
							                		 	onblur="numberformat.moneyFormat(this);"
							                		 	onfocus="return numberformat.setCursorPosToEnd(this);" 
														style="text-align:right;" styleClass="ms7"
														disabled="#{semmsa002Bean.disabledModeViewOnly}">
															<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
														</h:inputText>
														
														<rich:spacer width="50"></rich:spacer>
														
														<h:outputText value="#{jspMsg['column.header.perPeriod']} : " styleClass="ms7" ></h:outputText>
														
														<h:selectOneMenu style="" id="msa002tab4_elPkgPeriodType" value="#{semmsa002Bean.siteAppELObjParam.takeAllPeriodType}" styleClass="ms7"
														disabled="#{semmsa002Bean.disabledModeViewOnly}" onchange="setDefaultElPayPeriod();">
															<f:selectItems value="#{semmsa002Bean.promiseRenewPeriodTypeList}"/>
														</h:selectOneMenu>
														
														<a4j:jsFunction name="setDefaultElPayPeriod" action="#{semmsa002Action.doSetDefaultElPayPeriod}" 
														reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07,msa002tab4_elPkgPeriodType">
														</a4j:jsFunction>
													</td>
												</tr>
												<tr>
													<td align="right" valign="top">
														<h:outputText value="Detail : " styleClass="ms7" ></h:outputText>
													</td>
													<td align="left">
														<h:inputTextarea value="#{semmsa002Bean.siteAppELObjParam.detail03}" 
														rows="5" style="width:80%;" styleClass="ms7"
														disabled="#{semmsa002Bean.disabledModeViewOnly}">
														</h:inputTextarea>
													</td>
												</tr>
												<tr>
													<td align="right">
														<h:outputText value="Vat : " styleClass="ms7" ></h:outputText>
													</td>
													<td align="left">
														<h:selectOneRadio id="msa002tab3_ELVatType" value="#{semmsa002Bean.siteAppELObjParam.elVatType}" 
														style="" styleClass="ms7" >
								                			<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']} VAT" />
								                			<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']} VAT"/>
								                			<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.th_notHave']} VAT" />
								                			<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_except']} VAT" />
								                		</h:selectOneRadio>
													</td>
												</tr>
												<tr>
													<td align="right">
														<h:outputText value="W/T :" styleClass="ms7"></h:outputText>
													</td>
													<td align="left">
														<h:selectOneRadio id="msa002tab4_elTAWHT" value="#{semmsa002Bean.siteAppELObjParam.whtType}" 
			                                            styleClass="ms7">
			                                                <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.th_include']}#{jspMsg['label.th_tax']}" />
			                                                <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.th_exclude']}#{jspMsg['label.th_tax']}"/>
			                                                <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.th_free']}#{jspMsg['label.th_tax']}" />
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
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType01" value="#{semmsa002Bean.elPayPeriodType01}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType01();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType01" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
												        	<h:panelGroup>
										       					
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType06" value="#{semmsa002Bean.elPayPeriodType06}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType06();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType06" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="06"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
												        	<h:panelGroup>
										       					
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType07" value="#{semmsa002Bean.elPayPeriodType07}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType07();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType07" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="07"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
												        	<h:panelGroup>
														        <h:selectOneRadio id="msa002tab4_elPayPeriodType02" value="#{semmsa002Bean.elPayPeriodType02}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType02();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType02" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
														   	</h:panelGroup>
												        	<h:panelGroup>     
														        
												                <h:selectOneRadio id="msa002tab4_elPayPeriodType03" value="#{semmsa002Bean.elPayPeriodType03}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType03();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType03" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												           	</h:panelGroup>
												        	<h:panelGroup>     
												                
												                <h:inputText id="msa002tab4_txtElPayPeriodTypeMonth" size="5"  disabled="#{semmsa002Bean.disabledModeViewOnly 
												                || semmsa002Bean.elPayPeriodType03 != '03'}"
										                				value="#{semmsa002Bean.elPayPeriod03}" styleClass="inputRight" onblur="msa002tab4_setElPayPeriodType03();"
										                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
												                
												                <rich:spacer width="5"></rich:spacer>
												                <h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
												           	</h:panelGroup>
												        	<h:panelGroup>     
												                
												                <h:selectOneRadio id="msa002tab4_elPayPeriodType04" value="#{semmsa002Bean.elPayPeriodType04}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType04();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType04" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												            </h:panelGroup>
												        	<h:panelGroup>				
												                <h:inputText id="msa002tab4_txtElPayPeriodTypeYear" size="5" disabled="#{semmsa002Bean.disabledModeViewOnly 
												                || semmsa002Bean.elPayPeriodType04 != '04'}"
										                				value="#{semmsa002Bean.elPayPeriod04}" styleClass="inputRight"
										                				onblur="msa002tab4_setElPayPeriodType04();"
										                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
										                				
												                <rich:spacer width="5"></rich:spacer>
												                <h:outputText value="#{jspMsg['label.th_year']}" styleClass="ms7"></h:outputText>
												            
											                </h:panelGroup>
											                <h:panelGroup>
											                	
												                <h:selectOneRadio id="msa002tab4_elPayPeriodType05" value="#{semmsa002Bean.elPayPeriodType05}"  styleClass="ms7" rendered="true"
															    onclick="msa002tab4_setElPayPeriodType05();" disabled="#{semmsa002Bean.disabledModeViewOnly}">
														                				
														        	<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
														                				 
																    <a4j:jsFunction name="msa002tab4_setElPayPeriodType05" action="#{semmsa002Action.renderElPayPeriodType}" 
																    reRender="msa002tab4_elPayPeriodType01,msa002tab4_elPayPeriodType02,msa002tab4_elPayPeriodType03,
																    msa002tab4_elPayPeriodType04,msa002tab4_elPayPeriodType05,msa002tab4_txtElPayPeriodTypeMonth,
																    msa002tab4_txtElPayPeriodTypeYear,msa002tab4_elPayPeriodType06,msa002tab4_elPayPeriodType07">
																		<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
																	</a4j:jsFunction>
														        </h:selectOneRadio>
												        	</h:panelGroup>
											           	</h:panelGrid> 
													</td>
												</tr>
												<tr>
													<td style="text-align:right;" valign="top">
														<h:outputText value="#{jspMsg['column.header.startPeriodDate']} : " styleClass="ms7" />
								       				</td>
								       				<td style="text-align:left;" valign="top" colspan="5">
								       					<a4j:region>
															<!-- begin date -->
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmsa002Bean.siteAppELObjParam.periodStartDt}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   label=""
															   	   styleClass="ms7"
															   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
															</rich:calendar>
															
															<rich:spacer width="50"></rich:spacer>
															<h:outputText value="#{jspMsg['column.header.endPeriodDate']} :  " styleClass="ms7" />
															<!-- end date -->
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmsa002Bean.siteAppELObjParam.periodEndDt}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   label=""
															   	   styleClass="ms7"
															   	   disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly}">
															</rich:calendar>
														</a4j:region>
								       				</td>
												</tr>
											</table>
										</div>
									</rich:panel>
									
									
									<div style="width:100%; border:solid 0px;padding:5px;" >
												<h:panelGroup>
													<h:outputText value="#{jspMsg['label.th_eff_dt']}  : " styleClass="ms7" rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"></h:outputText>
													<rich:calendar locale="th" enableManualInput="true" 
														datePattern="dd/MM/yyyy" 
														value="#{semmsa002Bean.siteAppELObjParam.elEffectiveDt03}"
														showWeeksBar="false"
														inputSize="10"
														oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														cellWidth="15px" cellHeight="20px"
														styleClass="ms7"
														rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"
														disabled="#{semmsa002Bean.disabledModeViewOnly}">
													</rich:calendar>
												</h:panelGroup>
												
											</div>
											<div style="margin:5px;">
												<h:panelGroup>

												<!-- add1 -->
													<a4j:commandButton value="Add" styleClass="rich-button" 
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,pnlMsa002Tab4_ElContDetail,msa002tab4_wrapper1" 
							       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
							       					rendered="#{semmsa002Bean.siteAppELObjParam.siteAppELContId eq '' or semmsa002Bean.siteAppELObjParam.siteAppELContId eq null}"
							       					style=" width : 46px;">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="03" />
							                            <a4j:actionparam name="elTypeSub" value="#{semmsa002Bean.siteAppELObjParam.elCondSubType}" />
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						<a4j:actionparam name="serviceId" value="#{semmsa002Bean.siteAppELObjParam.serviceId}" />
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					
							       					<a4j:commandButton id="msa002tab4_btnSaveEl" value="Save" styleClass="rich-button" 
							       					action="#{navAction.navi}" reRender="pnlMsa002Tab4_ElContDetail,msa002tab4_pnlElDetail,msa002tab4_wrapper1"
							       					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.siteAppELObjParam.pSaElectricType != '03'}"
							       					rendered="#{semmsa002Bean.siteAppELObjParam.siteAppELContId != '' and semmsa002Bean.siteAppELObjParam.siteAppELContId != null}">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="03" />
							                            <a4j:actionparam name="elTypeSub" value="#{semmsa002Bean.siteAppELObjParam.elCondSubType}" />
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						
							       						
							       						
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					
							       					<a4j:commandButton value="Cancel" styleClass="rich-button" 
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,msa002tab4_wrapper1"
							       					disabled="#{semmsa002Bean.disabledModeViewOnly}">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppEl" />
							       					</a4j:commandButton>
												</h:panelGroup>
												
											</div>
											
											<div style="width:100%;">
												<rich:panel id="msa002tab4_pnlElUnitDtb" rendered="false">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['label.elnfolist']} #{jspMsg['label.eluserelowner']} #{jspMsg['label.unit']}" style="width: 100%;"/>
													</f:facet>
												
													<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
													
														<rich:dataTable width="100%" id="dtbEl" cellpadding="1" cellspacing="0" border="0"
								                        var="elObj" value="#{semmsa002Bean.siteAppELCondUnitList}" reRender="dtbSiteInfo" 
								                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								                            
								                            <rich:column>
									                            <f:facet name="header">
									                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
									                            </f:facet>
									                            <div align="center">
										                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
										                            reRender="msa002tab4_pnlElDetail">
										                                <a4j:actionparam name="navModule" value="sa" />
										                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										                                                    
										                                <a4j:actionparam name="moduleWithNavi" value="sa" />
										                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										                                <a4j:actionparam name="methodWithNavi" value="doEditEL" />
										                                <a4j:actionparam name="siteAppELContId" value="#{elObj.dataObj.siteAppELContId}" />
										                                <a4j:actionparam name="elType" value="U" />
										                            </a4j:commandButton>
									                            </div>
									                        </rich:column>
									                        
									                        <rich:column>
									                            <f:facet name="header">
									                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
									                            </f:facet>
									                            <div align="center">
										                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
										                            reRender="msa002tab4_pnlElDetail" rendered="#{elObj.dataObj.siteAppELContId != null}"
										                            disabled="#{semmsa002Bean.disabledModeViewOnly}"
										                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
										                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
										                                <a4j:actionparam name="navModule" value="sa" />
										                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										                                                    
										                                <a4j:actionparam name="moduleWithNavi" value="sa" />
										                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppELCond" />
										                                <a4j:actionparam name="siteAppELContId" value="#{elObj.dataObj.siteAppELContId}" />
																		<a4j:actionparam name="siteAppId" value="#{elObj.dataObj.siteAppId}" />
																		<a4j:actionparam name="expenseType" value="#{elObj.dataObj.expenseType}" />
																		<a4j:actionparam name="serviceId" value="#{elObj.dataObj.serviceId}" />
																		 <a4j:actionparam name="elType" value="U" />
										                            </a4j:commandButton>
									                            </div>
									                        </rich:column>
								                            
								                            <rich:column sortBy="#{elObj.dataObj.effectiveDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.effectiveDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.expireDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.expireDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.chgEffectiveDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.chgEffectiveDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.periodStartDt}" rendered="false">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.periodStartDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.periodEndDt}"  rendered="false">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.periodEndDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.elType}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['label.electricType']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText value="#{elObj.dataObj.elType}" styleClass="contentform"  />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.takeAllAmt}"  rendered="false">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.takeAllAmt}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.elPeriodType}"  rendered="false">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform"  value="#{elObj.dataObj.elPeriodType}"/>
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.detail}">
								                                <f:facet name="header">
								                                    <h:outputText value="Detail" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.detail}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.vatType}" rendered="false">
								                                <f:facet name="header">
								                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform"  value="#{elObj.dataObj.vatType}"/>
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.payPeriodType}" rendered="false">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['label.pay']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform"  value="#{elObj.dataObj.payPeriodTypeName}"/>
								                                </div>
								                      		</rich:column>
								                      		
								                      		
								                      		
								                      		<f:facet name="footer">
								                                <rich:columnGroup>
								                                    <rich:column colspan="4">
								                                        <h:outputFormat value="#{msg['message.totalRecords']}">
								                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppELCondUnitList)}"></f:param>
								                                        </h:outputFormat>
								                                    </rich:column>
								                                    <rich:column colspan="11">
								                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbEl"
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
											
												<rich:panel id="msa002tab4_pnlElTakeAllDtb" rendered="false">
													<f:facet name="header">
														<h:outputText value="#{jspMsg['label.elnfolist']} #{jspMsg['label.eluserelowner']} #{jspMsg['label.prepaid']}" style="width: 100%;"/>
													</f:facet>
												
													<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
													
														<rich:dataTable width="100%" id="dtbElTakeAll" cellpadding="1" cellspacing="0" border="0"
								                        var="elObj" value="#{semmsa002Bean.siteAppELCondTakeAllList}" reRender="dtbSiteInfo" 
								                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
								                            
								                            <rich:column>
									                            <f:facet name="header">
									                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
									                            </f:facet>
									                            <div align="center">
										                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="width : 15px; height : 15px;"
										                            reRender="msa002tab4_pnlElDetail"
										                            disabled="#{semmsa002Bean.disabledModeViewOnly}">
										                                <a4j:actionparam name="navModule" value="sa" />
										                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										                                                    
										                                <a4j:actionparam name="moduleWithNavi" value="sa" />
										                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										                                <a4j:actionparam name="methodWithNavi" value="doEditEL" />
										                                <a4j:actionparam name="siteAppELContId" value="#{elObj.dataObj.siteAppELContId}" />
										                                <a4j:actionparam name="elType" value="T" />
										                                
										                            </a4j:commandButton>
									                            </div>
									                        </rich:column>
									                        
									                        <rich:column>
									                            <f:facet name="header">
									                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
									                            </f:facet>
									                            <div align="center">
										                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
										                            reRender="msa002tab4_pnlElDetail" rendered="#{elObj.dataObj.siteAppELContId != null}"
										                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
										                            disabled="#{semmsa002Bean.disabledModeViewOnly}"
										                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
										                                <a4j:actionparam name="navModule" value="sa" />
										                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
										                                                    
										                                <a4j:actionparam name="moduleWithNavi" value="sa" />
										                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppELCond" />
										                                <a4j:actionparam name="siteAppELContId" value="#{elObj.dataObj.siteAppELContId}" />
																		<a4j:actionparam name="siteAppId" value="#{elObj.dataObj.siteAppId}" />
																		<a4j:actionparam name="expenseType" value="#{elObj.dataObj.expenseType}" />
																		<a4j:actionparam name="serviceId" value="#{elObj.dataObj.serviceId}" />
																		<a4j:actionparam name="elType" value="T" />
										                            </a4j:commandButton>
									                            </div>
									                        </rich:column>
								                            
								                            <rich:column sortBy="#{elObj.dataObj.effectiveDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.effectiveDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.expireDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.expireDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.chgEffectiveDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.chgEffectiveDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.periodStartDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.periodStartDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.periodEndDt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.periodEndDtStr}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.takeAllAmt}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.takeAllAmt}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.elPeriodType}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform"  value="#{elObj.dataObj.takeAllPeriodTypeName}"/>
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.detail}">
								                                <f:facet name="header">
								                                    <h:outputText value="Detail" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform" value="#{elObj.dataObj.detail}" />
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.vatType}">
								                                <f:facet name="header">
								                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform"  value="#{elObj.dataObj.elVatTypeName}"/>
								                                </div>
								                      		</rich:column>
								                      		<rich:column sortBy="#{elObj.dataObj.payPeriodType}">
								                                <f:facet name="header">
								                                    <h:outputText value="#{jspMsg['label.pay']}" styleClass="contentform" style="width: 100"/>
								                                </f:facet>
								                                <div align="center">
								                                    <h:outputText styleClass="contentform"  value="#{elObj.dataObj.payPeriodType}"/>
								                                </div>
								                      		</rich:column>
								                      		
								                      		
								                      		
								                      		<f:facet name="footer">
								                                <rich:columnGroup>
								                                    <rich:column colspan="4">
								                                        <h:outputFormat value="#{msg['message.totalRecords']}">
								                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppELCondTakeAllList)}"></f:param>
								                                        </h:outputFormat>
								                                    </rich:column>
								                                    <rich:column colspan="11">
								                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbEl"
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
												
												
											</div>
								</h:panelGroup>
								
								</div>
							</h:panelGroup>
							
							<rich:spacer height="10" style=" width : 1px; height : 10px;"></rich:spacer>
							
							<h:panelGroup id="msa002tab4_elUseOthSite" style="width:100%;" rendered="#{semmsa002Bean.chkElUseOthSite}">
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
														
														<h:inputText value="#{semmsa002Bean.siteAppELObjParam.elUseOthSiteContractNo}" id="msa002tab4_elUseOthSiteContractNo" maxlength="20" 
														style="padding-left:5px;" styleClass="ms7" onblur="msa002tab4_chkContractElUseJS();" 
														disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
														
														<a4j:jsFunction name="msa002tab4_chkContractElUseJS" reRender="oppContent, msa002tab4_elUseOthSiteContractNo" 
														action="#{semmsa002Action.msa002tab4_doChkContractElUse}" 
														oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show();">
														</a4j:jsFunction>
														
														<a4j:commandButton style="margin-left:5px; height:20px;" id="msa002tab4_BtnCntrctNoOthSite" styleClass="rich-button"
														action="#{semmsa002Action.tab4AddContractElUse_doClearContractElUse}"
														oncomplete="#{rich:component('msa002PopUpCommon_tab4AddContractElUse')}.show();"
														value="..." reRender="msa002tab4_pnlElDetail"
														disabled="#{semmsa002Bean.disabledModeViewOnly}">
															<a4j:actionparam name="paramSiteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
														</a4j:commandButton>
													</td>
													
												</tr>
												<tr>
													<td align="right" width="20%">
														<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
													</td>
													<td align="left">
														<h:inputTextarea rows="5" style="width:60%;"
														value="#{semmsa002Bean.siteAppELObjParam.detail04}"></h:inputTextarea>
													</td>
													
												</tr>
											</table>
											<div style="width:100%; border:solid 0px;padding:5px;">
											<h:panelGroup>
												<table width="100%">
													<tr>
														<td align="right" width="20%">
															<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7"
															rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"></h:outputText>
														</td>
														<td align="left">
															<rich:calendar locale="th" enableManualInput="true" 
																   datePattern="dd/MM/yyyy" 
																   value="#{semmsa002Bean.siteAppELObjParam.elEffectiveDt04}"
																   showWeeksBar="false"
																   inputSize="10"
																   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
															   	   cellWidth="15px" cellHeight="20px"
															   	   styleClass="ms7"
															   	   rendered="#{semmsa002Bean.siteAppObjParam.reqType == '03'}"
															   	   disabled="#{semmsa002Bean.disabledModeViewOnly}">
															</rich:calendar>
														</td>
													</tr>
												</table>
												
											
											</h:panelGroup>
											
								
											
										</div>
										<!-- add2 -->
										<div style="margin:5px;">
											<h:panelGroup> 
												<a4j:commandButton value="Add" styleClass="rich-button" 
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,msa002tab4_wrapper1,msa002tab4_elUseOthSite,pnlMsa002Tab4_ElContDetail"
							       					 disabled="#{semmsa002Bean.disabledModeViewOnly}"
							       					rendered="#{(semmsa002Bean.siteAppELObjParam.siteAppELContId eq '' or semmsa002Bean.siteAppELObjParam.siteAppELContId eq null) and semmsa002Bean.chkElUseOthSite}" 
							       					style=" width : 46px;">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="04" />
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						<a4j:actionparam name="serviceId" value="#{semmsa002Bean.siteAppELObjParam.serviceId}" />
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					<!-- Save 7 -->
							       					<a4j:commandButton value="Save" styleClass="rich-button" 
							       					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.siteAppELObjParam.pSaElectricType != '04'}"
							       					rendered="#{(semmsa002Bean.siteAppELObjParam.siteAppELContId != ''
							       					 and semmsa002Bean.siteAppELObjParam.siteAppELContId != null) and semmsa002Bean.chkElUseOthSite}"
							       					action="#{navAction.navi}" reRender="pnlMsa002Tab4_ElContDetail,msa002tab4_wrapper1,msa002tab4_pnlElDetail,msa002tab4_pnlElUnitDtb,dtbEl">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="04" />
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						<a4j:actionparam name="serviceId" value="#{semmsa002Bean.siteAppELObjParam.serviceId}" />
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					
							       					<a4j:commandButton value="Cancel" styleClass="rich-button" 
							       					 disabled="#{semmsa002Bean.disabledModeViewOnly}"
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,msa002tab4_pnlElUnitDtb,dtbEl,msa002tab4_wrapper1">
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
							
							
							<h:panelGroup id="msa002tab4_elUseOth123" style="width:100%;" rendered="#{semmsa002Bean.chkElUseOth}" >
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
														<h:inputTextarea rows="3" style="width:30%;"
														value="#{semmsa002Bean.siteAppELObjParam.detail05}"></h:inputTextarea>
													</td>
													
												</tr>
											</table>
											
										<!-- add2 -->
										<div style="margin:5px;">
											<h:panelGroup> 
												<a4j:commandButton value="Add" styleClass="rich-button" 
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,msa002tab4_elUseOthSite,pnlMsa002Tab4_ElContDetail,msa002tab4_wrapper1"
							       					 disabled="#{semmsa002Bean.disabledModeViewOnly}"
							       					rendered="#{(semmsa002Bean.siteAppELObjParam.siteAppELContId eq '' or semmsa002Bean.siteAppELObjParam.siteAppELContId eq null) and semmsa002Bean.chkElUseOth}" 
							       					style=" width : 46px;">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="05" />
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						<a4j:actionparam name="serviceId" value="#{semmsa002Bean.siteAppELObjParam.serviceId}" />
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					<!-- Save 7 -->
							       					<a4j:commandButton value="Save" styleClass="rich-button" 
							       					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.siteAppELObjParam.pSaElectricType != '05'}"
							       					rendered="#{(semmsa002Bean.siteAppELObjParam.siteAppELContId != ''
							       					 and semmsa002Bean.siteAppELObjParam.siteAppELContId != null) and semmsa002Bean.chkElUseOth}"
							       					action="#{navAction.navi}" reRender="pnlMsa002Tab4_ElContDetail,msa002tab4_wrapper1,msa002tab4_pnlElDetail,msa002tab4_pnlElUnitDtb,dtbEl">
							       						<a4j:actionparam name="navModule" value="sa" />
							                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							                            <a4j:actionparam name="moduleWithNavi" value="sa" />
							                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							                            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppELCond" />
							                            <a4j:actionparam name="elType" value="05" />
							                            <a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
							                            <a4j:actionparam name="siteAppELContId" value="#{semmsa002Bean.siteAppELObjParam.siteAppELContId}" />
							       						<a4j:actionparam name="serviceId" value="#{semmsa002Bean.siteAppELObjParam.serviceId}" />
							       					</a4j:commandButton>
							       					
							       					<rich:spacer width="5"></rich:spacer>
							       					
							       					<a4j:commandButton value="Cancel" styleClass="rich-button" 
							       					 disabled="#{semmsa002Bean.disabledModeViewOnly}"
							       					action="#{navAction.navi}" reRender="msa002tab4_pnlElDetail,msa002tab4_pnlElUnitDtb,dtbEl,msa002tab4_wrapper1" >
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
							
							
						</h:panelGrid>
					</div>
				</rich:panel>
				<!-- << group 1 -->
				 <!-- MMMMM -->
				 <rich:panel id="pnlMsa002Tab4_ElContDetail">
					<f:facet name="header">
						<h:outputText value="#{jspMsg['label.th_info_electrict_bill']} "  style="width: 100%;"/>
					</f:facet>
				
					<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
					
						<rich:dataTable width="100%" id="dtbElContInfo" cellpadding="1" cellspacing="0" border="0"
                        var="obj" value="#{semmsa002Bean.siteAppELCondAllList}" reRender="dtbSiteInfo" 
                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable" style=" width : 2712px;">
                            
                            <rich:column >
	                            <f:facet name="header">
	                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="width : 15px; height : 15px;"
									reRender="msa002tab4_pnlElDetail" disabled="#{semmsa002Bean.disabledModeViewOnly}" rendered="#{obj.dataObj.canEdit eq 'Y'}">
										                              
										                                <a4j:actionparam name="navModule" value="sa" />
										                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />        
										                                <a4j:actionparam name="moduleWithNavi" value="sa" />
										                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
										                                <a4j:actionparam name="methodWithNavi" value="doEditEL" />
										                                <a4j:actionparam name="siteAppELContId" value="#{obj.dataObj.siteAppELContId}" />
										                                <a4j:actionparam name="elType" value="#{obj.dataObj.pSaElectricType}" />	
										                                <a4j:actionparam name="pSa" value="#{obj.dataObj.pSaElectricType}" />
										                                <a4j:actionparam name="electricCondSubtype" value="#{obj.dataObj.electricCondSubtype}"  />
									 </a4j:commandButton> 
									 
									 		                        
	                            </div>
	                        </rich:column>
	                        
	                        <rich:column >
	                            <f:facet name="header">
	                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
	                            </f:facet>
	                            <div align="center">
		                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
		                            reRender="msa002tab4_pnlElDetail,pnlMsa002Tab4_ElContDetail" 
		                            rendered="#{obj.dataObj.recordStatus == 'Y' && obj.dataObj.canEdit == 'Y'}"
		                            onclick="if(!confirm('#{jspMsg['label.th_del_conf']} #{jspMsg['label.process_confirm']}')) return false;"
		                           	disabled="#{semmsa002Bean.disabledModeViewOnly}" >
		                                <a4j:actionparam name="navModule" value="sa" />
		                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
		                                                    
		                                <a4j:actionparam name="moduleWithNavi" value="sa" />
		                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
		                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppELCond" />
		                                <a4j:actionparam name="siteAppELContId" value="#{obj.dataObj.siteAppELContId}" />
										<a4j:actionparam name="siteAppId" value="#{obj.dataObj.siteAppId}" />
										<a4j:actionparam name="expenseType" value="#{obj.dataObj.expenseType}" />
										<a4j:actionparam name="serviceId" value="#{obj.dataObj.serviceId}" />
										<a4j:actionparam name="elType" value="#{obj.dataObj.electricType}"  />
										
		                            </a4j:commandButton>
	                            </div>
	                        </rich:column>
	                        
	                          <rich:column >
                                <f:facet name="header">
                                    <h:outputText value="Status" styleClass="contentform" style="width: 40"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="Delete" styleClass="ms7Red" rendered="#{obj.dataObj.recordStatus eq 'N'}" />
                                </div>
                      		</rich:column>
                            
                            <rich:column sortBy="#{obj.dataObj.effectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.effectiveDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.expireDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.expireDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.chgEffectiveDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['label.th_eff_dt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.changeEffectiveDt}" styleClass="contentform"  >
                                    <f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodStartDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.startPeriodDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodStartDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.periodEndDt}">
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.endPeriodDate']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText value="#{obj.dataObj.periodEndDtStr}" styleClass="contentform"  />
                                </div>
                      		</rich:column>
                      		<rich:column sortBy="#{obj.dataObj.electricTypeName}">
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
                                    <h:outputText value="#{jspMsg['label.th_old_2']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricOldAmt}" >
                                     <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.th_add']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricAddAmt}">
                                     <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.amt']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="right">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricAmt}" >
                                    <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                                    </h:outputText>
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="#{jspMsg['column.header.perPeriod']}" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.electricPeriodTypeName}" />
                                </div>
                      		</rich:column>
                      		<rich:column>
                                <f:facet name="header">
                                    <h:outputText value="" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform" value="#{obj.dataObj.noUnitPriceFlag}" />
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
                                    <h:outputText value="Wth" styleClass="contentform" style="width: 100"/>
                                </f:facet>
                                <div align="center">
                                    <h:outputText styleClass="contentform"  value="#{obj.dataObj.whtTypeName}" />
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
                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppELCondAllList)}"></f:param>
                                        </h:outputFormat>
                                    </rich:column>
                                    <rich:column colspan="24">
                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbElContInfo"
                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
                                            id="dstSiteElDetailInfo" 
                                            style="background-color: #cccccc;"
                                            page="#{semmsa002Bean.scrollerPage}" 
                                        />
                                    </rich:column>
                                    
                               
                                </rich:columnGroup>
                            </f:facet>
                            
                   		</rich:dataTable>
					
					</h:panelGroup>
				</rich:panel>
				<div style="clear:both; height:10px;"></div>
			
				<!-- >> group 2 -->
				<rich:panel>

	                <div style="clear:both; height:10px;"></div>
					<!-- PLY -->
					<h:panelGroup>
                	<div>
                		<h:selectBooleanCheckbox id="chkElDepositPayOneCond" value="#{semmsa002Bean.chkInsurancePayOneCond}" 
						disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.disabledModeEditFromLG}" 
						onclick="msa002tab4_chkInsuranceOneCond();" rendered="false"/>
							<a4j:jsFunction name="msa002tab4_chkInsuranceOneCond" reRender="" 
			                action="#{semmsa002Action.msa002_chkInsurancePayConditions}" >
						<a4j:actionparam name="paramInsuranceType" value="O" />
						</a4j:jsFunction>
						
						<a4j:commandButton id="msa002tab4_BtnUndoELDeposit" value="#{jspMsg['label.th_undo']}#{jspMsg['label.th_elDeposit']}" 
						disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab4_changeElDepositConfirm();"
						styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:160px;">
						</a4j:commandButton>
						
                		<a4j:jsFunction name="fnMsa002tab4_changeElDepositConfirm"
                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
                		action="#{semmsa002Action.doSetParamConfirmNotChangeElDeposit}"
                		 reRender="pnlMsa002Tab4_rentCont, panelTab4, 
                		btnSaveDptElDeposit, btnSaveDptElDeposit,msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
                		
                		<a4j:jsFunction name="fnMsa002tab4_changeElDeposit" reRender="dtbElDepCash,dtbElDepBg,pnlMsa002Tab4_rentCont, panelTab4, 
                		btnSaveDptElDeposit, btnSaveDptElDeposit"></a4j:jsFunction>

                		
                	</div>
                </h:panelGroup>

	                <rich:panel id="msa002Tab3_pnlELDeposit">
				
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.elDep']}" style="width: 100%;"/>
						</f:facet>
					
						<h:panelGroup style="width:100%;">
							<h:panelGroup>
			                	<div>
			                		<h:selectBooleanCheckbox id="msa002Tab4_chkNoELDeposit" value="#{semmsa002Bean.chkNoELDeposit}"
			               
			                		disabled="#{semmsa002Bean.disabledModeViewOnly}"
			                		
			                		onclick="chkNoELDeposit();"></h:selectBooleanCheckbox>
			                		
			                		<h:outputText value="#{jspMsg['label.th_noElDep']}" styleClass="ms7" />
			                		
			                		<a4j:jsFunction name="chkNoELDeposit" action="#{navAction.navi}" reRender="msa002Tab3_pnlELDeposit"> 
								    	<a4j:actionparam name="navModule" value="sa" />
							            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							            <a4j:actionparam name="moduleWithNavi" value="sa" />
							            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppDepositEl" />
									</a4j:jsFunction>
			                	</div>
			                </h:panelGroup>
			               
			                
			                <h:panelGroup id="msa002tab4_pnlElDeposit">
			                	<div style="width:100%; border:solid 0px;padding:5px;">
							 		<table style="width:100%; " >
										<tr>
											<td align="right" style="width:20%">
									       			<h:outputText value="* " style="font-style:bold; color:red;" />       
												    <h:outputText value="#{jspMsg['lable.th_elDepType']} :" styleClass="ms7"></h:outputText>
									       		</td>
									       		<td align="left">
									       			<h:selectOneMenu id="depTypeEl" value="#{semmsa002Bean.siteAppDeptElObj.depositType}"
									       			onchange="renderDeptBgElCash();" style=" height : 18px;"
									       			disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}">
									       				<f:selectItem itemLabel=" -- Select -- " itemValue=""/>
									       				<f:selectItem itemLabel=" BG " itemValue="01"/>
									       				<f:selectItem itemLabel=" Cash " itemValue="02"/>
									       				
									       			</h:selectOneMenu>
									       			
									       			<a4j:jsFunction name="renderDeptBgElCash" action="#{semmsa002Action.doRenderDeptBgCashEl}" 
									       			reRender="msa002tab4_pnlElDeposit,pnlDeptBg"></a4j:jsFunction>
									       			
									       		</td>
									       		<td align="right" style="width:20%">
									       			 <h:outputText value="* " style="font-style:bold; color:red;" />      
												    <h:outputText value="#{jspMsg['column.header.rantalPayment']} :" styleClass="ms7"></h:outputText>
									       		</td>
									       		<td align="left">
									       			<h:selectOneMenu value="#{semmsa002Bean.siteAppDeptElObj.expenseType}" 
									       			disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}">
									       				<f:selectItems value="#{semmsa002Bean.expenseTypeDepositElList}"/>
									       			</h:selectOneMenu>
									       		</td>
									       	</tr>
									   </table>
								
									
<h:panelGrid width="100%">
 <h:panelGroup id="pnlDeptCashEl" rendered="#{semmsa002Bean.renderedPnlDeptCashEl}">
        <div id="cash" style="width:100%; border:solid 1px fff;padding:5px;">
            <h:panelGroup id="msaTab4_pnlCashDepositOld" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01' and
							 			semmsa002Bean.siteAppDeptCashElObj.depositAmtOld > 0}">
                <div style="width:100%; border:solid 1px dddddd;padding:5px;">
                    <table style="width:100%;">
                        <tr>
                            <td align="right" width="15%">
                                <h:outputText value="#{jspMsg['label.th_old_insure_money']} :" styleClass="ms7"></h:outputText>
                            </td>
                            <td align="left">
                                <h:inputText value="#{semmsa002Bean.siteAppDeptCashElObj.depositAmtOld}" maxlength="17" 
                                onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" 
                                styleClass="ms7" onblur="return numberformat.moneyFormat(this);" 
                                onfocus="return numberformat.setCursorPosToEnd(this);" readonly="true">
                                    <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                                </h:inputText>
                                <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
                            </td>
                            <td align="left">
                                <h:panelGrid columns="1">
                                    <h:panelGroup>
                                        <h:selectOneRadio id="msa002Tab4_rbtDeptReturnType01" value="#{semmsa002Bean.deptReturnTypeEl01}" styleClass="ms7" onclick="msa002tab4_setDeptReturnTypeEl01();" 
                                        disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit}">
                                            <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.fullGetBackDep']}" />
                                        </h:selectOneRadio>

                                        <a4j:jsFunction name="msa002tab4_setDeptReturnTypeEl01" action="#{semmsa002Action.renderDeptReturnTypeEl}" reRender="msa002Tab4_rbtDeptReturnType01,msa002Tab4_rbtDeptReturnType02,msa002tab4_txtDeptReturnType02,
																							    msa002tab4_depositReturnAmt,msa002Tab4_rbtDeptReturnType03">
                                            <a4j:actionparam name="deptType" value="01"></a4j:actionparam>
                                            <a4j:actionparam name="deptReturnType" value="01"></a4j:actionparam>
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
                                        <h:selectOneRadio id="msa002Tab4_rbtDeptReturnType02" value="#{semmsa002Bean.deptReturnTypeEl02}" styleClass="ms7" onclick="msa002tab4_setDeptReturnType02();" 
                                        disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit}">
                                            <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.someGetBackDep']}" />

                                        </h:selectOneRadio>

                                        <a4j:jsFunction name="msa002tab4_setDeptReturnType02" action="#{semmsa002Action.renderDeptReturnTypeEl}" reRender="msa002Tab4_rbtDeptReturnType01,msa002Tab4_rbtDeptReturnType02,msa002tab4_txtDeptReturnType02,
																							    msa002tab4_depositReturnAmt,msa002Tab4_rbtDeptReturnType03">
                                            <a4j:actionparam name="deptType" value="01"></a4j:actionparam>
                                            <a4j:actionparam name="deptReturnType" value="02"></a4j:actionparam>
                                        </a4j:jsFunction>
                                    </h:panelGroup>
                                    <h:panelGroup>

                                        <h:inputText id="msa002tab4_txtDeptReturnType02" value="#{semmsa002Bean.siteAppDeptCashElObj.returnAmt}" maxlength="17" onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
                                        style="text-align:right;" styleClass="ms7" onblur="return numberformat.moneyFormat(this);" 
                                        onfocus="return numberformat.setCursorPosToEnd(this);" 
                                        disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit
										 || semmsa002Bean.deptReturnTypeEl02 != '02'}" onchange="doCalDepositElReturnAmt();">
                                            <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                                        </h:inputText>

                                        <a4j:jsFunction name="doCalDepositElReturnAmt" action="#{semmsa002Action.doCalDepositElReturnAmt}" reRender="msa002tab4_depositReturnAmt">

                                        </a4j:jsFunction>
                                    </h:panelGroup>
                                    <h:panelGroup>
                                        <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>

                                    </h:panelGroup>
                                </h:panelGrid>

                            </td>
                            <td>
                                <h:outputText value="#{jspMsg['label.balance']} : " styleClass="ms7" />
                                <h:inputText id="msa002tab4_depositReturnAmt" value="#{semmsa002Bean.siteAppDeptCashElObj.depositReturnAmt}" maxlength="17" onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7" onblur="return numberformat.moneyFormat(this);" onfocus="return numberformat.setCursorPosToEnd(this);" readonly="true">
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
                                        <h:selectOneRadio id="msa002Tab4_rbtDeptReturnType03" value="#{semmsa002Bean.deptReturnTypeEl03}" styleClass="ms7" onclick="msa002tab4_setDeptReturnType03();" disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit}">
                                            <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.noGetBack']}" />
                                        </h:selectOneRadio>

                                        <a4j:jsFunction name="msa002tab4_setDeptReturnType03" action="#{semmsa002Action.renderDeptReturnTypeEl}" reRender="msa002Tab4_rbtDeptReturnType01,msa002Tab4_rbtDeptReturnType02,msa002tab4_txtDeptReturnType02,
																							    msa002tab4_depositReturnAmt,msa002Tab4_rbtDeptReturnType03">
                                            <a4j:actionparam name="deptType" value="01"></a4j:actionparam>
                                            <a4j:actionparam name="deptReturnType" value="03"></a4j:actionparam>
                                        </a4j:jsFunction>
                                    </h:panelGroup>
                                </h:panelGrid>

                            </td>
                            <td>

                            </td>
                        </tr>
                    </table>

                </div>
            </h:panelGroup>

           <table style="width:100%; border:solid 0px;">
    	<tr>
        <td align="right">
            <h:outputText value="#{jspMsg['label.th_all_rentalDep']} : " styleClass="ms7"></h:outputText>
        </td>
        <td align="left" >
            <h:inputText id="msa002Tab4_cashDepositAmt" value="#{semmsa002Bean.siteAppDeptCashElObj.depositAmt}" 
			maxlength="17" onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
			style="text-align:right;" styleClass="ms7" 
			onblur="return numberformat.moneyFormat(this);" 
			onfocus="return numberformat.setCursorPosToEnd(this);" 
			readonly="true" >
                <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
            </h:inputText>
            <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
        </td>
        <td align="right" >
            <h:outputText value="#{jspMsg['label.th_new_insure']} :" styleClass="ms7"></h:outputText>
        </td>
        <td align="left" width="35%">
			<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
				<h:panelGroup>
		           <h:inputText  value="#{semmsa002Bean.siteAppDeptCashElObj.depositAmtNew}" 
		           maxlength="17" onkeypress="return numberformat.keyPressDecimalOnly(this, event);" 
		           style="text-align:right;" 
		           styleClass="ms7" onblur="return numberformat.moneyFormat(this);" 
		           onfocus="return numberformat.setCursorPosToEnd(this);" onchange="doCalDepositElAmt();"
		           disabled="#{semmsa002Bean.disabledModeViewOnly}">
						<f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
					</h:inputText>	
					<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
        		</h:panelGroup>
				
				<rich:spacer width="20"></rich:spacer>
				<a4j:jsFunction name="doCalDepositElAmt" action="#{semmsa002Action.doCalDepositElAmt}"
							       			reRender="msa002Tab4_cashDepositAmt,msa002Tab4_bgDepositAmt">
				</a4j:jsFunction>
                <h:panelGroup>

                </h:panelGroup>
            </h:panelGrid>

        </td>
    </tr>
</table>
        </div>
</h:panelGroup>
					 			
					 			
<h:panelGroup id="pnlDeptBg" rendered="#{semmsa002Bean.renderedPnlDeptBgEl}">
    <div id="BG" style="width:100%; border:solid 1px ffffff;padding:5px;">
        <h:panelGroup id="msaTab3_pnlBgDepositOld" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01' and
							 			semmsa002Bean.siteAppDeptBgObj.depositAmtOld > 0}">

            <div style="width:100%; border:solid 1px dddddd;padding:5px;">
                <table style="width:100%;">

                    <tr>
                        <td align="right" width="10%">
                            <h:outputText value="#{jspMsg['label.oldBG']} :" styleClass="ms7"></h:outputText>
                        </td>
                        <td align="left">
                            <h:inputText value="#{semmsa002Bean.siteAppDeptBgObj.depositAmtOld}" maxlength="17" 
                            onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" 
                            styleClass="ms7" onblur="return numberformat.moneyFormat(this);" 
                            onfocus="return numberformat.setCursorPosToEnd(this);" readonly="true">
                                <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                            </h:inputText>
                            <h:outputText value=" #{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
                        </td>
                        <td align="left">
                            <h:panelGrid columns="1">
                                <h:panelGroup>

                                    <h:selectOneRadio id="msa002Tab4_rbtDeptReturnTypeBG01" value="#{semmsa002Bean.deptReturnType01}" styleClass="ms7" onclick="msa002tab4_setDeptReturnTypeBG01()" disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit }">
                                        <f:selectItem itemValue="01" itemLabel="#{jspMsg['label.alreadyget']}" />
                                    </h:selectOneRadio>

                                    <a4j:jsFunction name="msa002tab4_setDeptReturnTypeBG01" action="#{semmsa002Action.renderDeptReturnType}" reRender="msa002Tab4_rbtDeptReturnTypeBG01,msa002Tab4_rbtDeptReturnTypeBG02,msa002tab4_txtDeptReturnTypeBG02,
																							    msa002Tab4_rbtDeptReturnTypeBG03">
                                        <a4j:actionparam name="deptType" value="02"></a4j:actionparam>
                                        <a4j:actionparam name="deptReturnType" value="01"></a4j:actionparam>
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

                                    <h:selectOneRadio id="msa002Tab4_rbtDeptReturnTypeBG02" value="#{semmsa002Bean.deptReturnType02}" styleClass="ms7" onclick="msa002tab4_setDeptReturnTypeBG02()" disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit}">
                                        <f:selectItem itemValue="02" itemLabel="#{jspMsg['label.noBG']}" />
                                    </h:selectOneRadio>

                                    <a4j:jsFunction name="msa002tab4_setDeptReturnTypeBG02" action="#{semmsa002Action.renderDeptReturnType}" reRender="msa002Tab4_rbtDeptReturnTypeBG01,msa002Tab4_rbtDeptReturnTypeBG02,msa002tab4_txtDeptReturnTypeBG02,
																							    msa002Tab4_rbtDeptReturnTypeBG03">
                                        <a4j:actionparam name="deptType" value="02"></a4j:actionparam>
                                        <a4j:actionparam name="deptReturnType" value="02"></a4j:actionparam>
                                    </a4j:jsFunction>
                                </h:panelGroup>

                                <h:panelGroup>
                                    <h:inputText id="msa002tab4_txtDeptReturnTypeBG02" value="#{semmsa002Bean.siteAppDeptBgObj.returnAmt}" maxlength="17" onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7" onblur="return numberformat.moneyFormat(this);" onfocus="return numberformat.setCursorPosToEnd(this);" 
                                    disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit || semmsa002Bean.deptReturnTypeEl02 != '02'}">
                                        <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                                    </h:inputText>
                                </h:panelGroup>

                                <h:panelGroup>
                                    <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>

                                </h:panelGroup>
                            </h:panelGrid>

                        </td>
                        <td>

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

                                    <h:selectOneRadio id="msa002Tab4_rbtDeptReturnTypeBG03" value="#{semmsa002Bean.deptReturnType03}" styleClass="ms7" onclick="msa002tab4_setDeptReturnTypeBG03()" 
                                    disabled="#{semmsa002Bean.disabledModeViewOnly  || semmsa002Bean.chkNoELDeposit}">
                                        <f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payWhencancelContract']}" />
                                    </h:selectOneRadio>

                                    <a4j:jsFunction name="msa002tab4_setDeptReturnTypeBG03" action="#{semmsa002Action.renderDeptReturnType}" reRender="msa002Tab4_rbtDeptReturnTypeBG01,msa002Tab4_rbtDeptReturnTypeBG02,msa002tab4_txtDeptReturnTypeBG02,
																							    msa002Tab4_rbtDeptReturnTypeBG03">
                                        <a4j:actionparam name="deptType" value="02"></a4j:actionparam>
                                        <a4j:actionparam name="deptReturnType" value="03"></a4j:actionparam>
                                    </a4j:jsFunction>
                                </h:panelGroup>
                            </h:panelGrid>

                        </td>
                        <td>

                        </td>
                    </tr>
                </table>
            </div>
</h:panelGroup>

<table style="width:100%; border:solid 0px;">

    <tr>
        <td align="right" colspan="3" width="65%">

            <h:outputText value="#{jspMsg['label.newBG']} :" styleClass="ms7"></h:outputText>
        </td>

        <td align="left">
            <h:panelGrid columns="5">
                <h:panelGroup>
                    <h:inputText value="#{semmsa002Bean.siteAppDeptBgElObj.depositAmtNew}" maxlength="17" onkeypress="return numberformat.keyPressDecimalOnly(this, event);" style="text-align:right;" styleClass="ms7" onblur="return numberformat.moneyFormat(this);" onfocus="return numberformat.setCursorPosToEnd(this);" 
                    
                   disabled="#{semmsa002Bean.disabledModeViewOnly }" 
					onchange="doCalDepositElAmt();">
                        <f:convertNumber pattern="#,##0.00" maxIntegerDigits="17" maxFractionDigits="2" />
                    </h:inputText>
                </h:panelGroup>

                <h:panelGroup>
                    <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"></h:outputText>
                </h:panelGroup>

                <rich:spacer width="20"></rich:spacer>

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

        </td>
        <td align="left">

        </td>
    </tr>
</table>
</div>
</h:panelGroup>
</h:panelGrid>
		
								
							
							
							 		<table width="100%">
							 			<tr>
							 				<td align="right">
							 					<h:outputText value="Vat :" styleClass="ms7"></h:outputText>
							 				</td>
							 				<td align="left">
							 					<h:selectOneRadio id="msa002tab3_rnsdepVatType" value="#{semmsa002Bean.siteAppDeptElObj.vatType}" styleClass="ms7" 
							 					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}">
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
							 					<h:selectOneMenu value="#{semmsa002Bean.siteAppDeptElObj.serviceId}" styleClass="ms7"
							 					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}">
							 						<f:selectItems value="#{semmsa002Bean.servTypeList}"/>
							 					</h:selectOneMenu>
							 				</td>
							 			</tr>
							 			<tr>
							 				<td align="right" valign="top">
							 				 	<h:outputText value="#{jspMsg['label.th_remark']} :" styleClass="ms7"> </h:outputText>
							 				</td>
							 				<td align="left">
							 					<h:inputTextarea rows="5" style="width:80%;" value="#{semmsa002Bean.siteAppDeptElObj.remark}"
							 					disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}"></h:inputTextarea>
							 				</td>
							 			</tr>
							 		</table>
							 	</div>
							 	
							 	<div style="width:100%; padding-left:50px;margin:10px;">
							 		<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgDeposit}">               
								         <f:facet name="errorMarkerPage">
								         	<h:graphicImage value="images/error.gif" />  
								         </f:facet>
								    </rich:messages>
							 	
							 		<a4j:commandButton id="btnAddDptEl" action="#{navAction.navi}" styleClass="rich-button" value="#{jspMsg['btn.add']}"
							 		rendered="#{semmsa002Bean.siteAppDeptElObj.siteAppDepositId eq '' or semmsa002Bean.siteAppDeptElObj.siteAppDepositId eq null}" 
							 		disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}"
							 		style=" width : 46px;" reRender="msa002tab4_pnlElDeposit,dtbRentalServDepBG,dtbElDepCash">
							 		 
							 		 	<a4j:actionparam name="navModule" value="sa" />
							         	<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							            <a4j:actionparam name="moduleWithNavi" value="sa" />
							            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							            <a4j:actionparam name="methodWithNavi" value="doAddSiteAppDept" />
							            <a4j:actionparam name="depositType" value="08" />     
		                            </a4j:commandButton>
		                                            
									<rich:spacer width="10"></rich:spacer>
		                                            
		                            <a4j:commandButton id="btnSaveDptEl" action="#{navAction.navi}" styleClass="rich-button" value="#{jspMsg['btn.save']}" 
		                            rendered="#{semmsa002Bean.siteAppDeptElObj.siteAppDepositId != '' and semmsa002Bean.siteAppDeptElObj.siteAppDepositId != null}"
		                            disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}"
		                            reRender="msa002tab4_pnlElDeposit,dtbRentalServDepBG,dtbElDepCash">
		                            	<a4j:actionparam name="navModule" value="sa" />
							            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							            <a4j:actionparam name="moduleWithNavi" value="sa" />
							            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							            <a4j:actionparam name="methodWithNavi" value="doUpdateSiteAppDept" />
							            <a4j:actionparam name="depositType" value="08" />
		                            </a4j:commandButton>
		                                            
		                            <rich:spacer width="10"></rich:spacer>
		                                            
		                            <a4j:commandButton id="btnClearDptEl" action="#{navAction.navi}" styleClass="rich-button" value="#{jspMsg['btn.clear']}"
		                            disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkNoELDeposit}"
							 		reRender="msa002tab4_pnlElDeposit,dtbRentalServDepBG,dtbElDepCash">
		                                <a4j:actionparam name="navModule" value="sa" />
							            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
							            <a4j:actionparam name="moduleWithNavi" value="sa" />
							            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
							            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppDepositEl" />         
		                            </a4j:commandButton>
							 	</div>
							 		
							 	<rich:panel >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.th_cashDepList']}" style="width: 100%;"/>
									</f:facet>
								
									<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
									
										<rich:dataTable width="100%" id="dtbElDepCash" cellpadding="1" cellspacing="0" border="0"
				                        var="siteAcqSP" value="#{semmsa002Bean.siteAppDeptCashElList}" reRender="dtbSiteInfo" 
				                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
				                            
				                            <rich:column>
					                            <f:facet name="header">
					                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
					                            </f:facet>
					                            <div align="center">
						                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
						                             disabled="#{semmsa002Bean.disabledModeViewOnly}"
						                            reRender="msa002tab4_pnlElDeposit">
						                                <a4j:actionparam name="navModule" value="sa" />
						                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						                                <a4j:actionparam name="moduleWithNavi" value="sa" />
						                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						                                <a4j:actionparam name="methodWithNavi" value="doEditDepositEl" />
						                                <a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
						                                <a4j:actionparam name="depositType" value="02" />
						                            </a4j:commandButton>
					                            </div>
					                        </rich:column>
					                        
					                        <rich:column>
					                            <f:facet name="header">
					                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
					                            </f:facet>
					                            <div align="center">
						                            
						                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
						                             disabled="#{semmsa002Bean.disabledModeViewOnly}"
						                            reRender="msa002tab4_pnlElDeposit,msa002tab4_pnlElUnitDtb,dtbEl" rendered="#{siteAcqSP.dataObj.rowId != null}"
						                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
						                                <a4j:actionparam name="navModule" value="sa" />
						                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						                                <a4j:actionparam name="moduleWithNavi" value="sa" />
						                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppDept" />
						                               	<a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
														<a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
														<a4j:actionparam name="expenseType" value="#{siteAcqSP.dataObj.expenseType}" />
														<a4j:actionparam name="serviceId" value="#{siteAcqSP.dataObj.serviceId}" />
														<a4j:actionparam name="depositType" value="08" />
						                            </a4j:commandButton>
					                            </div>
					                        </rich:column>
				                            
				                            <rich:column sortBy="#{siteAcqSP.dataObj.effectiveDtStr}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.effectiveDtStr}"/>
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.expireDtStr}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}"/>
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.expenseTypeName}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align=""right"">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expenseTypeName}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositAmt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100">
				                                    <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                                    </h:outputText>
				                                </f:facet>
				                                <div align="right">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositAmt}">
				                                   	<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                                  	  </h:outputText>
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositReturnType}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositReturnTypeName}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositStatus}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositStatus}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.vatTypeName}">
				                                <f:facet name="header">
				                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.vatTypeName}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.remark}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.remark}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.serviceId}">
				                                <f:facet name="header">
				                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.serviceName}" />
				                                </div>
				                      		</rich:column>
				                      		
				                      		
				                      		<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="4">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppDeptCashElList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
				                                    <rich:column colspan="11">
				                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbElDepCash"
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
								
								<!-- BG DEPosit -->
								<rich:panel >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.th_BGDepList']}" style="width: 100%;"/>
									</f:facet>
								
									<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
									
										<rich:dataTable width="100%" id="dtbRentalServDepBG" cellpadding="1" cellspacing="0" border="0"
				                        var="siteAcqSP" value="#{semmsa002Bean.siteAppDeptBGElList}" reRender="dtbSiteInfo" 
				                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
				                            
				                            <rich:column>
					                            <f:facet name="header">
					                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
					                            </f:facet>
					                            <div align="center">
						                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
						                             disabled="#{semmsa002Bean.disabledModeViewOnly}"
						                            reRender="msa002tab4_pnlElDeposit">
						                                <a4j:actionparam name="navModule" value="sa" />
						                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						                                <a4j:actionparam name="moduleWithNavi" value="sa" />
						                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						                                <a4j:actionparam name="methodWithNavi" value="doEditDepositEl" />
						                                <a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
						                                <a4j:actionparam name="depositType" value="01" />
						                            </a4j:commandButton>
					                            </div>
					                        </rich:column>
					                        
					                        <rich:column>
					                            <f:facet name="header">
					                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
					                            </f:facet>
					                            <div align="center">
						                            
						                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width : 15px;"
						                            reRender="msa002tab4_pnlElDeposit" rendered="#{siteAcqSP.dataObj.rowId != null}"
						                             disabled="#{semmsa002Bean.disabledModeViewOnly}"
						                            onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
						                           	oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;">
						                                <a4j:actionparam name="navModule" value="sa" />
						                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						                                <a4j:actionparam name="moduleWithNavi" value="sa" />
						                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						                                <a4j:actionparam name="methodWithNavi" value="doDetSiteAppDept" />
						                               	<a4j:actionparam name="siteAppDepositId" value="#{siteAcqSP.dataObj.siteAppDepositId}" />
														<a4j:actionparam name="siteAppId" value="#{semmsa002Bean.siteAppObjParam.siteAppId}" />
														<a4j:actionparam name="expenseType" value="#{siteAcqSP.dataObj.expenseType}" />
														<a4j:actionparam name="serviceId" value="#{siteAcqSP.dataObj.serviceId}" />
														<a4j:actionparam name="depositType" value="08" />
						                            </a4j:commandButton>
					                            </div>
					                        </rich:column>
				                            
				                            <rich:column sortBy="#{siteAcqSP.dataObj.effectiveDt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.effectiveDtStr}" />
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
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.expenseTypeName}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.rantalPayment']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expenseTypeName}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositAmt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.depAmt']}" styleClass="contentform" style="width: 100"/>
				                                    	
				                                  	  
				                                </f:facet>
				                                <div align="right">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositAmtNew}" >
				                                    <f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                                    </h:outputText>
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositReturnType}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.depgetbackCond']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositReturnTypeName}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.depositStatus}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.processStatus']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.depositStatus}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.vatTypeName}">
				                                <f:facet name="header">
				                                    <h:outputText value="Vat" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.vatTypeName}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.remark}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.remark}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.serviceId}">
				                                <f:facet name="header">
				                                    <h:outputText value="Service" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.serviceName}" />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgNo}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.BGNo']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgNo}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgBang}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.bank']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgBang}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgAmt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.BGamt']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgAmt}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgEffectiveDt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.BGstartDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgEffectiveDtStr}" />
				                                </div>
				                      		</rich:column>
				                      		<rich:column sortBy="#{siteAcqSP.dataObj.bgExpireDt}">
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.BGendDate']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.bgExpireDtStr}" />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="4">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppDeptBGElList)}"></f:param>
				                                        </h:outputFormat>
				                                    </rich:column>
				                                    <rich:column colspan="12">
				                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentalServDepBG"
				                                            maxPages="#{semmsa002Bean.rowPerPage}"  selectedStyleClass="selectScroll"
				                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
				                                            id="dstRentalServOtherinfo" 
				                                            style="background-color: #cccccc;"
				                                            page="#{semmsa002Bean.scrollerPage}" />
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
				<!-- << group 2 -->
				
				<!-- >> additional -->
				<div style="clear:both; height:10px;"></div>
				<a4j:commandButton style="" styleClass="rich-button" id="msa002tab4_BtnSave" value="SAVE" rendered="false">
				</a4j:commandButton>
				<!-- << additional -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	