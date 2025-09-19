
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



	<f:loadBundle basename="resources.sa.semmsa002" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab2" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- >> header content -->
			<f:facet name="header">
				<h:outputText value="#{jspMsg['label.th_info_contract']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 0 -->
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px; text-align:right;">
						<tr>
							<td style="background-color:ececec; border:solid dcdcdc 1px;">
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab2_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info_contract']}"
								action="#{semmsa002Action.doShowPopupHistory}" reRender="oppContent,tab2_panel_popupModalRetStatus,popupDisplay2"
								oncomplete="#{rich:component('tab2_panel_popupModalRetStatus')}.show(); return false;">
								<f:param name="tabNo" value="2"/>
								</a4j:commandButton>
								<a4j:include id="popUpTab2"  viewId="../../pages/sa/semmsa002PopUpTab2.jsp" />
							</td>
						</tr>
					</table>
				</h:panelGroup>
				<!-- << group 0 -->

				<div style="clear:both; height:10px;"></div>
	
				<!-- >> group 1 -->
				<h:panelGrid id="msgTopTab2">
					<rich:messages id="msgPnlTab2" layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsa002Bean.renderedMsgFormChkExpire}">
                        
                        <f:facet name="errorMarkerPage">
                             <h:graphicImage value="images/error.gif" />  
                        </f:facet>
                	</rich:messages>
				</h:panelGrid>
                
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
				
                <h:panelGroup>
                	
                	<a4j:commandButton id="msa002tab2_BtnUndoContract" value="#{jspMsg['label.th_undo']}#{jspMsg['label.th_info_contract']}" 
					disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab2_changeContractInfoComfirm();"
					styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:140;" >
					</a4j:commandButton>
                	
                	
                	<a4j:jsFunction name="fnMsa002tab2_changeContractInfoComfirm"
                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
                		action="#{semmsa002Action.doSetParamConfirmNotChangeContractInfo}"
                		reRender="panelTab2, msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
                </h:panelGroup>
				
				<rich:panel>
				<h:panelGroup style="width:100%;"> 
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['lable.th_rentalType']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:90%; text-align:left;">
								<h:selectOneMenu id="msa002tab1_siteType" value="#{semmsa002Bean.siteAppObjParam.siteType}" 
								styleClass="ms7" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
									<f:selectItems value="#{semmsa002Bean.siteTypeList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="white-space:nowrap; width:90%; text-align:left;">
								<h:selectBooleanCheckbox value="#{semmsa002Bean.leaseHoldRights}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}"
								onclick="checkLeaseHoldRights();"></h:selectBooleanCheckbox>
								
								<a4j:jsFunction name="checkLeaseHoldRights" action="#{semmsa002Action.doCheckLeaseHoldRights}"
								reRender="msgTopTab2"></a4j:jsFunction>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.th_leasehold_rights']}" styleClass="ms7"></h:outputText>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
							</td>
							<td style="white-space:nowrap; width:90%; text-align:left;">
								<a4j:region>
									<!-- begin date -->
									<rich:calendar id="msa002tab2_dateFrom" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppObjParam.effectiveDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="msa002tab2_calDtmJS();"
									   	   oncollapse="msa002tab2_calDtmJS();"
									   	   label=""
									   	   styleClass="ms7"
									   	   oninputchange="msa002tab2_calDtmJS();"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly }">
									</rich:calendar>
									
									&nbsp;
									<h:outputText value="#{jspMsg['label.th_to']} " styleClass="ms7" />
									<!-- end date -->
									<rich:calendar id="msa002tab2_dateTo" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppObjParam.expireDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   oninputblur="msa002tab2_calDtmJS();"
									   	   oncollapse="msa002tab2_calDtmJS();"
									   	   label=""
									   	   styleClass="ms7"
									   	   oninputchange="msa002tab2_calDtmJS();"
									   	   disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly }">
									</rich:calendar>
									
									<h:outputText value="#{jspMsg['label.th_contractPeriod']} : " style="margin-left:20px;" styleClass="ms7" />
									<h:inputText value="#{semmsa002Bean.siteAppObjParam.ageYear}" id="msa002tab2_ageYear" maxlength="2"
									style="width:50px; text-align:right;" readonly="true" styleClass="ms7" 
									disabled="#{semmsa002Bean.disabledModeViewOnly }">
										<f:convertNumber pattern="#,##0" maxIntegerDigits="3" maxFractionDigits="0" />
									</h:inputText>
									<h:outputText value="#{jspMsg['label.th_year']}" style="margin:0 10px 0 5px;" styleClass="ms7" />
									
									<h:inputText value="#{semmsa002Bean.siteAppObjParam.ageMonth}" id="msa002tab2_ageMonth" maxlength="2"
									style="width:50px; text-align:right;" readonly="true" styleClass="ms7" 
									disabled="#{semmsa002Bean.disabledModeViewOnly }">
										<f:convertNumber pattern="#,##0" maxIntegerDigits="3" maxFractionDigits="0" />
									</h:inputText> 
									<h:outputText value="#{jspMsg['label.th_month']}" style="margin:0 10px 0 5px;" styleClass="ms7" />
									
									<h:inputText value="#{semmsa002Bean.siteAppObjParam.ageDay}" id="msa002tab2_ageDay" maxlength="2"
									style="width:50px; text-align:right;" readonly="true" styleClass="ms7" 
									disabled="#{semmsa002Bean.disabledModeViewOnly }">
										<f:convertNumber pattern="#,##0" maxIntegerDigits="3" maxFractionDigits="0" />
									</h:inputText>
									<h:outputText value="#{jspMsg['label.th_day']}" style="margin:0 5px 0 5px;" styleClass="ms7" />
									
									
									<h:selectBooleanCheckbox id="msa002tab2_chkContractNeverExpire" value="#{semmsa002Bean.chkContractNeverExpire}" 
									disabled="#{semmsa002Bean.disabledModeViewOnly }"
									style="margin-left:100px;" onclick="setContractNoExpire();">
									</h:selectBooleanCheckbox>
									
									<a4j:jsFunction name="reRenderContractExpier" reRender="msa002tab2_dateTo, msa002tab2_rentPromise, msa002tab2_rentPromiseTime, 
									msa002tab2_rentPromiseType,msa002tab2_promiseType" oncomplete="msa002tab2_calDtmJSForContNoExpier();"></a4j:jsFunction>
									
									<h:outputText style="white-space:nowrap;" value="#{jspMsg['label.th_contractNeverExpire']}" styleClass="ms7"/>
									
									<script type="text/javascript">
                                                function setContractNoExpire(){
                                                	// alert('test1');
                                                	// var cldEffDate = document.getElementById("incContent:frmAddSiteInfo:cldEffDateInputDate").value;
                                                     var cldExpDate = document.getElementById("incContent:frmAllInitTab:msa002_incTab2:msa002tab2_dateToInputDate");
                                                     var chkContractNoExp = document.getElementById("incContent:frmAllInitTab:msa002_incTab2:msa002tab2_chkContractNeverExpire").checked;
                                                     var rentPromise = document.getElementById("incContent:frmAllInitTab:msa002_incTab2:msa002tab2_rentPromise").value;
                                                     var rentPromiseTime = document.getElementById("incContent:frmAllInitTab:msa002_incTab2:msa002tab2_rentPromiseTime").value;
                                                    
                                                     if(chkContractNoExp){
                                                    	 cldExpDate.value = '';
                                                    	 rentPromise = '';
                                                    	 rentPromiseTime = '';
                                                     }
                                                     reRenderContractExpier();
                                                }

                                                function calAmtAfterCalDmt(){
                                                	var cldExpDate = document.getElementById("incContent:frmAllInitTab:msa002_incTab2:msa002tab2_dateToInputDate").value;
                                                	//alert(cldExpDate);
                                                	if(cldExpDate!=''){
                                                		msa002tab2_doCalAmt();
                                                	}

                                                }
                                            </script>
									<a4j:jsFunction name="msa002tab2_calDtmJS" reRender="msgTopTab2,msa002tab2_dateFrom, msa002tab2_dateTo, 
									msa002tab2_ageYear, msa002tab2_ageMonth, msa002tab2_ageDay" 
									action="#{semmsa002Action.msa002_calDtm}" oncomplete="calAmtAfterCalDmt();">
										<a4j:actionparam name="paramCalDtm" value="tab2" />
									</a4j:jsFunction>
									
									<a4j:jsFunction name="msa002tab2_calDtmJSForContNoExpier" reRender="msgPnlTab2,msa002tab2_dateFrom, msa002tab2_dateTo, 
                                    msa002tab2_ageYear, msa002tab2_ageMonth, msa002tab2_ageDay, panelTab3_totalRent, msa002tab3_revenue" 
                                    action="#{semmsa002Action.msa002_calDtm}" oncomplete="calAmtAfterCalDmt();">
                                        <a4j:actionparam name="paramCalDtm" value="tab2" />
                                        <a4j:actionparam name="paramContNoExpier" value="Y" />
                                    </a4j:jsFunction>
									
									<a4j:jsFunction name="msa002tab2_doCalAmt" reRender="msa002tab2_dateFrom, msa002tab2_dateTo, 
                                    msa002tab2_ageYear, msa002tab2_ageMonth, msa002tab2_ageDay, panelTab3_totalRent,msgPnlTab2" 
                                    action="#{semmsa002Action.doCalAmt}">
                                        <a4j:actionparam name="paramCalDtm" value="tab2" />
                                    </a4j:jsFunction>
								</a4j:region>
								
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"/>
								<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"/>
							</td>
							<td style="white-space:nowrap; width:90%; text-align:left;">
								<rich:calendar id="msa002tab2_effDate" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppObjParam.changeContEffDt}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   label=""
									   	   styleClass="ms7"
									   	   rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"
									   	   disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly }">
								</rich:calendar>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
								<h:outputText value="#{jspMsg['label.th_renewCont']}" styleClass="ms7"></h:outputText>
												
								<h:selectBooleanCheckbox id="msa002tab2_chkRentAdd" value="#{semmsa002Bean.chkContRentAdd}" onclick="doChkContRentAdd()"  
								disabled="#{semmsa002Bean.disabledModeViewOnly || semmsa002Bean.chkRentalNoExpenses}">
					       						
						       	</h:selectBooleanCheckbox>
						       	
						       	<a4j:jsFunction name="doChkContRentAdd" reRender="msa002tab2_rentAdj">
						       	</a4j:jsFunction>
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002tab2_rentAdj" value="#{semmsa002Bean.siteAppObjParam.contRentAdj}"
						       	style=" height : 19px;"
						       	disabled="#{!semmsa002Bean.chkContRentAdd }">
						       		<f:selectItems value="#{semmsa002Bean.rentAdjList}" />
						       	</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_rentalAgreement']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputText id="msa002tab2_rentPromise" value="#{semmsa002Bean.siteAppObjParam.promiseRenewTime}" maxlength="5" size="7"
								onkeypress="return numberformat.keyPressIntegerOnly(this, event);" style="text-align:right;" styleClass="ms7"
								disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly }">
									<f:convertNumber pattern="#,##0" maxIntegerDigits="9" />
								</h:inputText> 
								<h:outputText value="#{jspMsg['label.th_periodBy']}" style="margin:0 5px 0 5px;" styleClass="ms7" />
								
								<h:inputText id="msa002tab2_rentPromiseTime" value="#{semmsa002Bean.siteAppObjParam.promiseRenewPeriod}" maxlength="2" size="5"
								onkeypress="return numberformat.keyPressIntegerOnly(this, event);" style="text-align:right;" styleClass="ms7"
								disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly }">
									<f:convertNumber pattern="#,##0" maxIntegerDigits="7" />
								</h:inputText> 
								<h:selectOneMenu id="msa002tab2_promiseType" value="#{semmsa002Bean.siteAppObjParam.promiseRenewPeriodType}" styleClass="ms7"
								disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.promiseRenewPeriodTypeList}"/>
								</h:selectOneMenu>
								
								
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
								<h:outputText value="#{jspMsg['label.th_promiseRenewRemark']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea id="msa002tab2_PromiseRenewRemark" value="#{semmsa002Bean.siteAppObjParam.promiseRenewRemark}"
                                rows="3" style="width:80%;" styleClass="ms7"  
                                disabled="#{semmsa002Bean.chkContractNeverExpire || semmsa002Bean.disabledModeViewOnly 
                                }">
                                
                                </h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
							<a4j:region>
								<h:selectBooleanCheckbox id="msa002tab2_chkContractWanted" value="#{semmsa002Bean.chkContractWanted}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}" style="margin-left:100px;" onclick="msa002tab2_doChkContractWantedJS();"/>
								
								<a4j:jsFunction name="msa002tab2_doChkContractWantedJS" reRender="msa002tab2_contractWantedRemark" 
								action="#{semmsa002Action.doChkContractWanted}"/>
								
								<h:outputText style="white-space:nowrap;" value="#{jspMsg['label.th_contractNotMustBe']}" styleClass="ms7" />
								
								<rich:spacer width="10"></rich:spacer>
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_because']} : " styleClass="ms7" />
							</a4j:region>
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea id="msa002tab2_contractWantedRemark" value="#{semmsa002Bean.siteAppObjParam.contractWantedRemark}"
                                rows="3" style="width:80%;" styleClass="ms7"  disabled="#{!semmsa002Bean.chkContractWanted || semmsa002Bean.disabledModeViewOnly }">
                                
                                </h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneRadio styleClass="ms7" value="#{semmsa002Bean.siteAppObjParam.license}" 
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItem itemLabel="#{jspMsg['label.th_license']}" itemValue="01"/>
									<f:selectItem itemLabel="#{jspMsg['label.th_no_license']}" itemValue="02"/>
									<f:selectItem itemLabel="#{jspMsg['label.th_noSave']}" itemValue=""/>
								</h:selectOneRadio>
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;">
								
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectBooleanCheckbox value="#{semmsa002Bean.llRentalAgreement}"
								disabled="#{semmsa002Bean.disabledModeViewOnly }"></h:selectBooleanCheckbox>
								<rich:spacer width="5"></rich:spacer>
								<h:outputText value="#{jspMsg['label.owner_create_contract']} " styleClass="ms7" />
							</td>
						</tr>
						<tr>
							<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
								<h:outputText value="#{jspMsg['label.th_special_condition']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.remarkSpecial}" id="msa002tab2_special_cond"
                                rows="3" style="width:80%;" styleClass="ms7"  disabled="#{semmsa002Bean.disabledModeViewOnly }">
                                </h:inputTextarea>
							</td>
						</tr>
					</table>
				</h:panelGroup>
				</rich:panel>
				<!-- << group 1 -->
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 2 -->
				<rich:panel>
				<h:panelGroup style="width:100%;">
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.owner_info']}" styleClass="ms7" style="text-decoration:underline;" />
							</td>
							<td style="width:90%; text-align:left;">
							
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_owner_category']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002tab2_owner_cate" value="#{semmsa002Bean.siteAppObjParam.ownerCategory}"
								
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.ownerCategoryList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="getSubCat" action="#{semmsa002Action.getSubCategoryList}" reRender="msa002tab2_owner_sub_cate" ></a4j:jsFunction>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_owner_sub_category']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002tab2_owner_sub_cate" value="#{semmsa002Bean.siteAppObjParam.ownerSubCategory}"
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.ownerSubCategoryList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002tab2_title" value="#{semmsa002Bean.siteAppObjParam.ownerTitleName}"
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.titleList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_ownername']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea value="#{semmsa002Bean.siteAppObjParam.ownerName}" id="msa002tab2_ownerName"
                                rows="3" style="width:80%;" 
                                disabled="#{semmsa002Bean.disabledModeViewOnly }"></h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<a4j:commandButton style="" id="msa002tab2_BtnCopy1" value="Copy #{jspMsg['label.th_from']}#{jspMsg['label.th_ownername']}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly}"
											styleClass="rich-button" action="#{semmsa002Action.doCopyLocation}" reRender="msa002Tab2_lessorTitleName, 
											msa002Tab2_lessorName" rendered="true">
												<a4j:actionparam  name="paramLocateFrom" value="tab2_ownerName"/>
												<a4j:actionparam  name="paramLocateTo" value="tab2_lessorName"/>
								</a4j:commandButton>
							</td>
							<td style="width:90%; text-align:left;">
								
							</td>
						</tr>
						
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002Tab2_lessorTitleName" value="#{semmsa002Bean.siteAppObjParam.lessorTitleName}"
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.titleList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_contractName']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea id="msa002Tab2_lessorName" value="#{semmsa002Bean.siteAppObjParam.lessorName}" 
								rows="2" style="width:50%; height:50px; overflow:visible;" 
								disabled="#{semmsa002Bean.disabledModeViewOnly}">
								</h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								<h:outputText value="#{jspMsg['label.th_personalandtaxid']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputText id="msa002Tab2_lessorId" value="#{semmsa002Bean.siteAppObjParam.lessorTaxId}"
								onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
								disabled="#{semmsa002Bean.disabledModeViewOnly }"
								style="width:70%;" maxlength="13"></h:inputText>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								<h:outputText value="#{jspMsg['label.birthday']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<rich:calendar locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppObjParam.lessorBirthday}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   label=""
									   	   styleClass="ms7"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly }">
								</rich:calendar>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_contractAddr']}" styleClass="ms7" style="text-decoration:underline;"/>
							</td>
							<td>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;" colspan="2">
							
								<table style="width:100%; border:solid ececec 1px;">
									<tr>
										<td colspan="6" style="background-color:ececec; border:solid dcdcdc 1px;">
											<a4j:commandButton style="" id="msa002tab2_BtnCopy" value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_info_station']}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											styleClass="rich-button" action="#{semmsa002Action.doCopyLocation}" reRender="msa002tab2_lessorHouseNo, msa002tab2_lessorBuilding, 
											msa002tab2_lessorFloor, msa002tab2_lessorRoomNo, msa002tab2_lessorStreet, msa002tab2_lessorTambon, msa002tab2_lessorAmphur, 
											msa002tab2_lessorProvince, msa002tab2_lessorPostCode, msa002tab2_lessorTaxId, msa002tab2_contactName, msa002tab2_lessorTel, 
											msa002tab2_lessorMobile, msa002tab2_lessorFax, msa002tab2_lessorEmail" rendered="true">
												<a4j:actionparam  name="paramLocateFrom" value="tab1_siteStation"/>
												<a4j:actionparam  name="paramLocateTo" value="tab2_lessor"/>
											</a4j:commandButton>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
											<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
										</td>
										<td colspan="5">
											<h:inputTextarea id="msa002tab2_lessorHouseNo" value="#{semmsa002Bean.siteAppObjParam.lessorHouseNo}"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
                               	 			rows="3" style="width:80%;" styleClass="ms7"></h:inputTextarea>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
										</td>
										<td style="">
											<h:inputText id="msa002tab2_lessorBuilding" value="#{semmsa002Bean.siteAppObjParam.lessorBuilding}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }" 
											maxlength="500" style="width:80%;" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
										</td>
										<td style="white-space:nowrap;">
											<h:inputText id="msa002tab2_lessorFloor" value="#{semmsa002Bean.siteAppObjParam.lessorFloor}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											style="text-align:right; width:150px;" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
										</td>
										<td style="width:30%; white-space:nowrap;">
											<h:inputText id="msa002tab2_lessorRoomNo" value="#{semmsa002Bean.siteAppObjParam.lessorRoomNo}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											style="text-align:right;" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
										</td>
										<td style="" >
											<h:inputText id="msa002tab2_lessorStreet" value="#{semmsa002Bean.siteAppObjParam.lessorStreet}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											style="width:80%;" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:inputText id="msa002tab2_lessorTambon" value="#{semmsa002Bean.siteAppObjParam.lessorTambon}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											style="width:40%;" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
										</td>
										<td style="">
											<h:selectOneMenu id="msa002tab2_lessorAmphur" value="#{semmsa002Bean.siteAppObjParam.lessorAmphurId}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											styleClass="ms7">
												<f:selectItems value="#{semmsa002Bean.msa002Tab2AmphurLessorList}"/>
											</h:selectOneMenu>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
										</td>
										<td style="" >
											<a4j:region>
												<h:selectOneMenu id="msa002tab2_lessorProvince" value="#{semmsa002Bean.siteAppObjParam.lessorProvinceId}" 
												disabled="#{semmsa002Bean.disabledModeViewOnly }"
												 onchange="msa002tab2_GetSiteAmphurListJS();" styleClass="ms7">
													<f:selectItems value="#{semmsa002Bean.msa002Tab2ProvinceLessorList}"/>
												</h:selectOneMenu>
												
												<a4j:jsFunction name="msa002tab2_GetSiteAmphurListJS" reRender="msa002tab2_lessorAmphur" action="#{semmsa002Action.getAmphurTab2List}">
													<a4j:actionparam name="paramAmphr" value="L" />
												</a4j:jsFunction>
											</a4j:region>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
										</td>
										<td style="width:30%;" >
											<h:inputText id="msa002tab2_lessorPostCode" value="#{semmsa002Bean.siteAppObjParam.lessorPostCode}" 
											style="text-align:right;" maxlength="5" styleClass="ms7" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
									</tr>
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_localPhone']} : " styleClass="ms7" />
										</td>
										<td style="" colspan="5">
											<h:inputText id="msa002tab2_lessorTel" value="#{semmsa002Bean.siteAppObjParam.lessorTel}" 
											style="width:300px;" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										
											<h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="padding-left:110px;" styleClass="ms7" />
											<h:inputText id="msa002tab2_lessorMobile" value="#{semmsa002Bean.siteAppObjParam.lessorMobile}" 
											style="width:300px;" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.en_fax']} : " styleClass="ms7" />
										</td>
										<td style="" colspan="5">
											<h:inputText id="msa002tab2_lessorFax" value="#{semmsa002Bean.siteAppObjParam.lessorFax}" 
											style="width:300px;" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										
											<h:outputText value="#{jspMsg['label.en_email']} : " style="padding-left:114px;" styleClass="ms7" />
											<h:inputText id="msa002tab2_lessorEmail" value="#{semmsa002Bean.siteAppObjParam.lessorEmail}" 
											style="width:300px;" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											
										</td>
										<td style="" colspan="5">
											<h:commandButton id="btnAdd" action="#{navAction.navi}" 
                                            styleClass="rich-button" value="#{jspMsg['btn.add']}" rendered="false">
                                            
                                            </h:commandButton>
                                            
                                            <rich:spacer width="10"></rich:spacer>
                                            
                                            <h:commandButton id="btnSave" action="#{navAction.navi}" 
                                            styleClass="rich-button" value="#{jspMsg['btn.save']}" rendered="false">
                                            
                                            </h:commandButton>
                                            
                                            <rich:spacer width="10"></rich:spacer>
                                            
                                            <h:commandButton id="btnClear" action="#{navAction.navi}" 
                                            styleClass="rich-button" value="#{jspMsg['btn.clear']}" rendered="false">
                                            
                                            </h:commandButton>
										</td>
										<td colspan="2"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</h:panelGroup>
				</rich:panel>
				
				<div style="clear:both; height:10px;"></div>
				
				<!-- >> group 2 -->
				<rich:panel>
				<h:panelGroup style="width:100%;">
				
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td colspan="2" style="text-align:left;">
								<a4j:commandButton style="" id="msa002tab2_BtnCopy2" value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_nameAddrCont']}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											styleClass="rich-button" action="#{semmsa002Action.doCopyLocation}" reRender="msa002tab2_contactHouseNo, msa002tab2_contactBuilding, 
											msa002tab2_contactFloor, msa002tab2_contactRoomNo, msa002tab2_contactStreet, msa002tab2_contactTambon, msa002tab2_contactAmphur, 
											msa002tab2_contactProvince, msa002tab2_contactPostCode, msa002tab2_contactTel, 
											msa002tab2_contactMobile, msa002tab2_contactFax, msa002tab2_contactEmail,
											msa002Tab2_contact_title,msa002Tab2_contact_name,msa002Tab2_contact_personalId,msa002Tab2_contact_birthDay" rendered="true">
												<a4j:actionparam  name="paramLocateFrom" value="tab2_lessor"/>
												<a4j:actionparam  name="paramLocateTo" value="tab2_contact"/>
											</a4j:commandButton>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_contractNameAddr']}" styleClass="ms7" style="text-decoration:underline;" />
							</td>
							<td style="width:90%; text-align:left;">
							
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002Tab2_contact_title" value="#{semmsa002Bean.siteAppObjParam.contactTitleName}"
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.titleList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_contactName']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea id="msa002Tab2_contact_name" value="#{semmsa002Bean.siteAppObjParam.contactName}" 
								rows="2" style="width:50%; height:50px; overflow:visible;" 
								disabled="#{semmsa002Bean.disabledModeViewOnly }"
								styleClass="ms7">
								</h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								<h:outputText value="#{jspMsg['label.th_personalId']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputText id="msa002Tab2_contact_personalId" value="#{semmsa002Bean.siteAppObjParam.contactIdCard}"
								onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
								disabled="#{semmsa002Bean.disabledModeViewOnly }"
								style="width:70%;" maxlength="13"></h:inputText>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								<h:outputText value="#{jspMsg['label.birthday']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<rich:calendar id="msa002Tab2_contact_birthDay" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppObjParam.contactBirthday}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   label=""
									   	   styleClass="ms7"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly }">
								</rich:calendar>
							</td>
						</tr>
						
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;" colspan="2">
							
								<table style="width:100%; border:solid ececec 1px;">
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
											<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
										</td>
										<td colspan="5">
											<h:inputTextarea id="msa002tab2_contactHouseNo" value="#{semmsa002Bean.siteAppObjParam.contactHouseNo}"
                               	 			rows="3" style="width:80%;" styleClass="ms7"
                               	 			disabled="#{semmsa002Bean.disabledModeViewOnly }"></h:inputTextarea>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
										</td>
										<td style="">
											<h:inputText id="msa002tab2_contactBuilding" value="#{semmsa002Bean.siteAppObjParam.contactBuilding}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }" 
											maxlength="500" style="width:80%;" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
										</td>
										<td style="white-space:nowrap;">
											<h:inputText id="msa002tab2_contactFloor" value="#{semmsa002Bean.siteAppObjParam.contactFloor}"
											style="text-align:right; width:150px;" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
										</td>
										<td style="width:30%; white-space:nowrap;">
											<h:inputText id="msa002tab2_contactRoomNo"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											value="#{semmsa002Bean.siteAppObjParam.contactRoomNo}" style="text-align:right;" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
										</td>
										<td style="" >
											<h:inputText id="msa002tab2_contactStreet" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											value="#{semmsa002Bean.siteAppObjParam.contactStreet}" style="width:80%;" styleClass="ms7" />
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
										</td>
										<td colspan="3">
											<h:inputText id="msa002tab2_contactTambon" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											value="#{semmsa002Bean.siteAppObjParam.contactTambon}" style="width:40%;" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
										</td>
										<td style="">
											<h:selectOneMenu id="msa002tab2_contactAmphur" value="#{semmsa002Bean.siteAppObjParam.contactAmphurId}" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }">
												<f:selectItems value="#{semmsa002Bean.msa002Tab2AmphurContactList}"/>
											</h:selectOneMenu>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
										</td>
										<td style="" >
											<a4j:region>
												<h:selectOneMenu id="msa002tab2_contactProvince" onchange="msa002tab2_GetContactAmphurListJS();" 
												disabled="#{semmsa002Bean.disabledModeViewOnly }"
												value="#{semmsa002Bean.siteAppObjParam.contactProvinceId}" styleClass="ms7">
													<f:selectItems value="#{semmsa002Bean.msa002Tab2ProvinceContactList}"/>
												</h:selectOneMenu>
												
												<a4j:jsFunction name="msa002tab2_GetContactAmphurListJS" reRender="msa002tab2_contactAmphur" action="#{semmsa002Action.getAmphurTab2List}">
													<a4j:actionparam name="paramAmphr" value="C" />
												</a4j:jsFunction>
												
											</a4j:region>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
										</td>
										<td style="width:30%;" >
											<h:inputText id="msa002tab2_contactPostCode" style="text-align:right;" value="#{semmsa002Bean.siteAppObjParam.contactPostCode}"
											maxlength="5" styleClass="ms7" 
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
									</tr>
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_localPhone']} : " styleClass="ms7" />
										</td>
										<td style="" colspan="5">
											<h:inputText id="msa002tab2_contactTel" style="width:300px;" styleClass="ms7" value="#{semmsa002Bean.siteAppObjParam.contactTel}"
											 disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										
											<h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="padding-left:110px;" styleClass="ms7" />
											<h:inputText id="msa002tab2_contactMobile" style="width:300px;" styleClass="ms7" value="#{semmsa002Bean.siteAppObjParam.contactMobile}"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.en_fax']} : " styleClass="ms7" />
										</td>
										<td style="" colspan="5">
											<h:inputText id="msa002tab2_contactFax" value="#{semmsa002Bean.siteAppObjParam.contactFax}" 
											style="width:300px;" styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										
											<h:outputText value="#{jspMsg['label.en_email']} : " style="padding-left:114px;" styleClass="ms7" />
											<h:inputText id="msa002tab2_contactEmail" value="#{semmsa002Bean.siteAppObjParam.contactEmail}" style="width:300px;"
											styleClass="ms7" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											
										</td>
										<td style="" colspan="5">
											<h:commandButton styleClass="rich-button" value="#{jspMsg['btn.add']}" rendered="false">
                                            
                                            </h:commandButton>
                                            
                                            <rich:spacer width="10"></rich:spacer>
                                            
                                            <h:commandButton styleClass="rich-button" value="#{jspMsg['btn.save']}" rendered="false">
                                            
                                            </h:commandButton>
                                            
                                            <rich:spacer width="10"></rich:spacer>
                                            
                                            <h:commandButton styleClass="rich-button" value="#{jspMsg['btn.clear']}" rendered="false">
                                            
                                            </h:commandButton>
										</td>
										<td colspan="2"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
			<!-- << group 2 -->
			<div style="clear:both; height:10px;"></div>
			<!-- << group 3 Emergentcy -->
			<rich:panel>
				<h:panelGroup style="width:100%;">
				
					<!-- table column: 10:90 -->
					<table style="width:100%; border:solid 1px;">
						<tr>
							<td colspan="2" style="text-align:left;">
								<a4j:commandButton style="" id="msa002tab2_BtnCopy3" value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_nameAddrCont']}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											styleClass="rich-button" action="#{semmsa002Action.doCopyLocation}" reRender="msa002tab2_emContactHouseNo, msa002tab2_emContactBuilding, 
											msa002tab2_emContactFloor, msa002tab2_emContactRoomNo, msa002tab2_emContactStreet, msa002tab2_emContactTambon, msa002tab2_emContactAmphur, 
											msa002tab2_emContactProvince, msa002tab2_emContactPostCode, msa002tab2_emContactTel, 
											msa002tab2_emContactMobile, msa002tab2_emContactFax, msa002tab2_emContactEmail,
											msa002Tab2_emContact_title,msa002Tab2_emContact_name,msa002Tab2_emContact_personalId,msa002Tab2_emContact_birthDay" rendered="true">
												<a4j:actionparam  name="paramLocateFrom" value="tab2_lessor"/>
												<a4j:actionparam  name="paramLocateTo" value="tab2_emContact"/>
											</a4j:commandButton>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_contractNameAddr']} #{jspMsg['label.th_emergency']}" styleClass="ms7" style="text-decoration:underline;" />
							</td>
							<td style="width:90%; text-align:left;">
							
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" rendered="false"/>
							</td>
							<td style="width:90%; text-align:left;">
								<h:selectOneMenu id="msa002Tab2_emContact_title" value="#{semmsa002Bean.siteAppObjParam.emerContactTitleName}"
								rendered="false"
								disabled="#{semmsa002Bean.disabledModeViewOnly }">
									<f:selectItems value="#{semmsa002Bean.titleList}"/>
								</h:selectOneMenu>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="* " style="font-style:bold; color:red;" />
								<h:outputText value="#{jspMsg['label.th_contactName']} #{jspMsg['label.th_emergency']} : " styleClass="ms7" />
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputTextarea id="msa002Tab2_emContact_name" value="#{semmsa002Bean.siteAppObjParam.emerContactName}" 
								rows="2" style="width:50%; height:50px; overflow:visible;" 
								disabled="#{semmsa002Bean.disabledModeViewOnly }"
								styleClass="ms7">
								</h:inputTextarea>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								<h:outputText value="#{jspMsg['label.th_emerPhoneNo']} : " styleClass="ms7" />
							</td>
							<td style="" colspan="5">
								<h:inputText id="msa002tab2_emContactTel" style="width:300px;" styleClass="ms7" value="#{semmsa002Bean.siteAppObjParam.emerContactTel}"
								disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
									
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								<h:outputText value="#{jspMsg['label.th_personalId']} : " styleClass="ms7" rendered="false"/>
							</td>
							<td style="width:90%; text-align:left;">
								<h:inputText id="msa002Tab2_emContact_personalId" value="#{semmsa002Bean.siteAppObjParam.emerContactIdCard}"
								onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
								disabled="#{semmsa002Bean.disabledModeViewOnly }"
								style="width:70%;" maxlength="13" rendered="false"></h:inputText>
							</td>
						</tr>
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
								
								<h:outputText value="#{jspMsg['label.birthday']} : " styleClass="ms7" rendered="false"/>
							</td>
							<td style="width:90%; text-align:left;">
								<rich:calendar id="msa002Tab2_emContact_birthDay" locale="th" enableManualInput="true" 
										   datePattern="dd/MM/yyyy" 
										   value="#{semmsa002Bean.siteAppObjParam.emerContactBirthday}"
										   showWeeksBar="false"
										   inputSize="10"
										   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									   	   cellWidth="15px" cellHeight="20px"
									   	   label=""
									   	   styleClass="ms7"
									   	   rendered="false"
									   	   disabled="#{semmsa002Bean.disabledModeViewOnly }">
								</rich:calendar>
							</td>
						</tr>
						
						<tr>
							<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;" colspan="2">
							
								<table style="width:100%; border:solid ececec 1px;">
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
											<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td colspan="5">
											<h:inputTextarea id="msa002tab2_emContactHouseNo" value="#{semmsa002Bean.siteAppObjParam.emerContactHouseNo}"
                               	 			rows="3" style="width:80%;" styleClass="ms7" rendered="false"
                               	 			disabled="#{semmsa002Bean.disabledModeViewOnly }"></h:inputTextarea>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="">
											<h:inputText id="msa002tab2_emContactBuilding" value="#{semmsa002Bean.siteAppObjParam.emerContactBuilding}" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }" 
											maxlength="500" style="width:80%;" styleClass="ms7" rendered="false"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="white-space:nowrap;">
											<h:inputText id="msa002tab2_emContactFloor" value="#{semmsa002Bean.siteAppObjParam.emerContactFloor}"
											style="text-align:right; width:150px;" styleClass="ms7" rendered="false"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" rendered="false"/>
										</td>
										<td style="width:30%; white-space:nowrap;">
											<h:inputText id="msa002tab2_emContactRoomNo" rendered="false"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											value="#{semmsa002Bean.siteAppObjParam.emerContactRoomNo}" style="text-align:right;" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="" >
											<h:inputText id="msa002tab2_emContactStreet" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											value="#{semmsa002Bean.siteAppObjParam.emerContactStreet}" style="width:80%;" styleClass="ms7" rendered="false"/>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" rendered="false" />
										</td>
										<td colspan="3">
											<h:inputText id="msa002tab2_emContactTambon" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"
											value="#{semmsa002Bean.siteAppObjParam.emerContactTambon}" style="width:40%;" styleClass="ms7" rendered="false"/>
										</td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="">
											<h:selectOneMenu id="msa002tab2_emContactAmphur" value="#{semmsa002Bean.siteAppObjParam.emerContactAmphurId}" styleClass="ms7" rendered="false"
											disabled="#{semmsa002Bean.disabledModeViewOnly }">
												<f:selectItems value="#{semmsa002Bean.msa002Tab2AmphurContactList}"/>
											</h:selectOneMenu>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="" >
											<a4j:region>
												<h:selectOneMenu id="msa002tab2_emContactProvince" onchange="msa002tab2_GetContactAmphurListJS();" 
												disabled="#{semmsa002Bean.disabledModeViewOnly }"
												value="#{semmsa002Bean.siteAppObjParam.emerContactProvinceId}" styleClass="ms7" rendered="false">
													<f:selectItems value="#{semmsa002Bean.msa002Tab2ProvinceContactList}"/>
												</h:selectOneMenu>
												
												<a4j:jsFunction name="msa002tab2_GetEmerContactAmphurListJS" reRender="msa002tab2_contractAmphur" 
												action="#{semmsa002Action.getAmphurTab2List}" rendered="false">
													<a4j:actionparam name="paramAmphr" value="C" />
												</a4j:jsFunction>
												
											</a4j:region>
										</td>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="width:30%;" >
											<h:inputText id="msa002tab2_emContactPostCode" style="text-align:right;" value="#{semmsa002Bean.siteAppObjParam.emerContactPostCode}"
											maxlength="5" styleClass="ms7" rendered="false"
											onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
									</tr>
									
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.th_localPhone']} : " styleClass="ms7" rendered="false"/>
										</td>
										<td style="" colspan="5">
											<h:inputText id="msa002tab2_emContactTelOld" style="width:300px;" styleClass="ms7" value="#{semmsa002Bean.siteAppObjParam.emerContactTel}"
											 rendered="false"
											 disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										
											<h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="padding-left:110px;" styleClass="ms7" rendered="false"/>
											<h:inputText id="msa002tab2_emContactMobile" style="width:300px;" styleClass="ms7" value="#{semmsa002Bean.siteAppObjParam.emerContactMobile}"
											rendered="false"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.en_fax']} : " styleClass="ms7" rendered="false" />
										</td>
										<td style="" colspan="5">
											<h:inputText id="msa002tab2_emContactFax" value="#{semmsa002Bean.siteAppObjParam.emerContactFax}" 
											style="width:300px;" styleClass="ms7" rendered="false"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										
											<h:outputText value="#{jspMsg['label.en_email']} : " style="padding-left:114px;" styleClass="ms7" rendered="false"/>
											<h:inputText id="msa002tab2_emContactEmail" value="#{semmsa002Bean.siteAppObjParam.emerContactEmail}" style="width:300px;"
											styleClass="ms7" rendered="false"
											disabled="#{semmsa002Bean.disabledModeViewOnly }"/>
										</td>
										<td colspan="2"></td>
									</tr>
									<tr>
										<td style="width:10%; text-align:right; white-space:nowrap;">
											
										</td>
										<td style="" colspan="5">
											<h:commandButton styleClass="rich-button" value="#{jspMsg['btn.add']}" rendered="false">
                                            
                                            </h:commandButton>
                                            
                                            <rich:spacer width="10"></rich:spacer>
                                            
                                            <h:commandButton styleClass="rich-button" value="#{jspMsg['btn.save']}" rendered="false">
                                            
                                            </h:commandButton>
                                            
                                            <rich:spacer width="10"></rich:spacer>
                                            
                                            <h:commandButton styleClass="rich-button" value="#{jspMsg['btn.clear']}" rendered="false">
                                            
                                            </h:commandButton>
										</td>
										<td colspan="2"></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</h:panelGroup>
			</rich:panel>
			<!-- group 3 END -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
