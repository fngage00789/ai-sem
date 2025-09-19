
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
				<h:outputText value="#{jspMsg['label.insu']}" />
			</f:facet>
			<!-- << header content -->
	
				<!-- >> group 0 -->
				<h:panelGroup style="width:100%;">
					<table style="width:100%; border:solid ececec 1px; text-align:right;">
						<tr>
							<td style="background-color:ececec; border:solid dcdcdc 1px;">
								<a4j:commandButton style="" styleClass="rich-button" id="msa002tab7_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info']}#{jspMsg['label.insu']}"
								action="#{semmsa002Action.doShowPopupHistory}" reRender="popupDisplay7"
								oncomplete="#{rich:component('tab7_panel_popupModalRetStatus')}.show(); return false;">
								<f:param name="tabNo" value="7"/>
								</a4j:commandButton>
								<a4j:include id="popUpTab7"  viewId="../../pages/sa/semmsa002PopUpTab7.jsp" />
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
							<h:outputText value="#{jspMsg['label.InsNewCond']}" />
						</f:facet>
						<!-- << header content -->
				
							<!-- >> group 0 -->
							<h:panelGroup style="width:100%;">
								<table style="width:100%; border:solid 1px;">
									<tr>
										<td align="right" width="15%">
											<h:outputText value="#{jspMsg['column.header.th_number']}#{jspMsg['column.header.th_contract']} : " styleClass="ms7" />
										</td>
										<td align="left" width="25%">
											<h:outputText value="#{semmsa002Bean.siteAppInsuranceObj.contractNo}" styleClass="ms7" />
										</td>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText value="#{semmsa002Bean.siteAppInsuranceObj.effectiveDtStr}" styleClass="ms7" />
										</td>
										<td align="right" width="15%">
											
											<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
										</td>
										<td align="left" >
											<h:outputText value="#{semmsa002Bean.siteAppInsuranceObj.expireDtStr}" styleClass="ms7" />
										</td>
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.insType']} : " styleClass="ms7" />
										</td>
										<td align="left" colspan="5">
											<h:outputText styleClass="ms7" value="#{semmsa002Bean.siteAppInsuranceObj.insuranceTypeName}"></h:outputText>
										</td>
										
									</tr>
									<tr>
										<td align="right">
											<h:outputText value="#{jspMsg['label.detail']} : " styleClass="ms7" />
										</td>
										<td align="left" colspan="5">
											<h:outputText styleClass="ms7" value="#{semmsa002Bean.siteAppInsuranceObj.detail}"></h:outputText>
										</td>
										
									</tr>
									<tr>
										<td align="right" valign="top">
											<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" style="vertical-align:top;"/>
										</td>
										<td align="left" colspan="5">
											
											<h:inputTextarea id="msa002tab6_optIRremark" value="#{semmsa002Bean.siteAppInsuranceObj.remark}"
											style="width:1000px;" disabled="true" rows="5"></h:inputTextarea>
										</td>
										
									</tr>
								</table>
							</h:panelGroup>
					</rich:panel>
				</h:panelGrid>
				
				 <div style="clear:both; height:10px;"></div>
				
				<h:panelGroup>
	                	<div>
	                		<a4j:commandButton id="msa002tab6_BtnUndoInsurance" value="#{jspMsg['label.th_undo']}#{jspMsg['label.changeinsInfo']}" 
							disabled="#{semmsa002Bean.disabledModeViewOnly}" onclick="fnMsa002tab6_changeInsuranceComfirm();"
							styleClass="rich-button" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}" style="width:175px;">
							</a4j:commandButton>
	                		
	                		<a4j:jsFunction name="fnMsa002tab6_changeInsuranceComfirm"
	                		oncomplete="#{rich:component('msa002PopUpCommon_commonConfirm')}.show(); return false;"
	                		action="#{semmsa002Action.doSetParamConfirmNotChangeIR}"
	                		 reRender="panelTab6,msa002PopUpCommon_commonConfirm"></a4j:jsFunction>
	                		
	                		<a4j:jsFunction name="doInitEditIR" action="#{navAction.navi}" reRender="oppContent">
	                			<a4j:actionparam name="navModule" value="sa" />
								<a4j:actionparam name="navProgram" value="SEMMSA002-1" />
						                                                    
						        <a4j:actionparam name="moduleWithNavi" value="sa" />
						        <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
						        <a4j:actionparam name="methodWithNavi" value="doInitEditIR" />
	                		</a4j:jsFunction>
	                	</div>
	            </h:panelGroup>
				
				<div style="clear:both; height:10px;"></div>
	                
	                <rich:panel id="pnlInsuranceParam">
				
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.inscond']}" style="width: 100%;"/>
						</f:facet>
					
						<h:panelGroup style="width:100%;">
							<h:panelGroup>
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
			                		<table style="width:100%;">
			                			<tr>
			                				<td align="right" width="20%">
			                					<h:outputText value="#{jspMsg['label.insType']} : " styleClass="ms7" />
			                				</td>
			                				<td align="left">
			                					<h:selectOneMenu onchange="RenderInsuranceType();" styleClass="ms7"
			                					value="#{semmsa002Bean.siteAppInsuranceObjParam.insuranceType}"
			                					disabled="#{semmsa002Bean.disabledModeViewOnly}">
			                						<f:selectItems value="#{semmsa002Bean.insuranceTypeList}"/>
						                				
						                			<a4j:jsFunction name="RenderInsuranceType"  action="#{semmsa002Action.renderInsuranceType}"
               				 						reRender="msa002tab6_pnlPLX, msa002Tab6_pnlInsuranceOwner, pnlInsuranceParam"/>
									       		</h:selectOneMenu>
									       		
									       		
			                				</td>
			                			</tr>
			                			<tr>
			                				<td align="right" valign="top">
			                					<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
			                				</td>
			                				<td align="left">
			                					<h:inputTextarea rows="5" style="width:80%;"
			                					value="#{semmsa002Bean.siteAppInsuranceObjParam.remark}"
			                					disabled="#{semmsa002Bean.disabledModeViewOnly}"></h:inputTextarea>
			                				</td>
			                			</tr>
			                		</table>
			                	</div>
			                	
			                	<div style="clear:both; height:10px;" ></div>
			                	
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
				                	<!-- panel PLX -->
				                	<h:panelGrid id="msa002tab6_pnlPLX" width="90%" border="0" cellpadding="0" cellspacing="1" 
				                	rendered="#{semmsa002Bean.renderedPLX}">
										<h:panelGroup rendered="true">
										<table width="100%">
				                		<tr>
					                		<td align="left" colspan="4">
					                		 <h:outputText value="#{semmsa002Bean.irHeaderLabel}" styleClass="ms7" style="text-decoration: underline"/>
					                		</td>
				                		</tr>
			                		 	<tr style="display:none;">
					                		<td width="20%" align="right">
					                	  		<h:outputText value="#{jspMsg['labe.plxOldAmt']}" styleClass="ms7"/>
					                		</td>
					                	  	<td width="30%" >
					                	 		<h:panelGroup>
						                			<h:inputText id="txtPlxOldAmt" value="#{semmsa002Bean.siteAppInsuranceObjParam.plxOldAmt}" size="18" 
					       						 	onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
						       						 onblur="return numberformat.moneyFormat(this);"
						       						 onfocus="return numberformat.setCursorPosToEnd(this);"
						       						 maxlength="16" 
						       						 styleClass="inputRight">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						                			</h:inputText>
													<rich:spacer width="5"></rich:spacer>
													<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
												</h:panelGroup>
					                	  	</td>
					                	 	<td width="20%" align="right">
					                	  		<h:outputText value="#{jspMsg['label.plxAddAmt']}" styleClass="ms7"/>
					                	  	</td>
					                	 	<td width="30%" >
					                	  		<h:panelGroup>
			                						<h:inputText id="txtPlxAddAmt" value="#{semmsa002Bean.siteAppInsuranceObjParam.plxAddAmt}" size="18" 
					       							 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
					       							 onblur="return numberformat.moneyFormat(this);"
					       							 onfocus="return numberformat.setCursorPosToEnd(this);"
					       							 maxlength="16" 
					       							 styleClass="inputRight">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                						</h:inputText>
												
													<rich:spacer width="5"></rich:spacer>
													<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
												</h:panelGroup>
					                	 	</td>
					                	 </tr>
					                	 <tr>
					                		<td width="20%" align="right">
					                		 	<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.th_beneficiary']}" styleClass="ms7"/>
					                		</td>
					                		<td width="80%" colspan="3">
					                			<h:panelGroup>
					                			<h:inputText id="txtPlxBeneficiary" value="#{semmsa002Bean.siteAppInsuranceObjParam.plxBeneficiary}" 
					       						 style="width:80%;"
					       						 disabled="#{semmsa002Bean.disabledModeViewOnly}"/>
												</h:panelGroup>
					                		</td>
				                		</tr>
					                	 <tr>
					                		<td width="20%" align="right">
					                		 	<h:graphicImage value="images/icon_required.gif"/>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.plxAmt']}" styleClass="ms7"/>
					                		</td>
					                		<td width="80%" colspan="3">
					                			<h:panelGroup>
					                			<h:inputText id="txtPlxAmt" value="#{semmsa002Bean.siteAppInsuranceObjParam.plxAmt}" size="18" 
					       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
					       						 onblur="return numberformat.moneyFormat(this);"
					       						 onfocus="return numberformat.setCursorPosToEnd(this);"
					       						 maxlength="16" 
					       						 styleClass="inputRight"
					       						 disabled="#{semmsa002Bean.disabledModeViewOnly}">
												<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
					                			</h:inputText>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
												</h:panelGroup>
					                		</td>
				                		</tr>
				                		<tr>
					                	  <td width="20%" align="right">
					                	  <h:outputText value="#{jspMsg['label.startDate']} :" styleClass="ms7"/>
					                	  </td>
					                	  <td width="30%" >
					                	  <rich:calendar id="cldPlxEffDate" locale="th" enableManualInput="true" 
				                			datePattern="dd/MM/yyyy" 
				                			value="#{semmsa002Bean.siteAppInsuranceObjParam.plxEffectiveDt}" 
				                			showWeeksBar="false" 
				                			inputSize="13"
				                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											cellWidth="20px" cellHeight="20px"
											label="#{jspMsg['label.startDate']}"
											disabled="#{semmsa002Bean.disabledModeViewOnly}">
											</rich:calendar>
					                	  </td>
					                	   <td width="20%" align="right">
					                	  <h:outputText value="#{jspMsg['label.endDate']} :" styleClass="ms7"/>
					                	  </td>
					                	   <td width="30%" >
					                	   <rich:calendar id="cldPlxExpDate" locale="th" enableManualInput="true" 
				                			datePattern="dd/MM/yyyy" 
				                			value="#{semmsa002Bean.siteAppInsuranceObjParam.plxExpireDt}"
				                			showWeeksBar="false" 
				                			inputSize="13"
				                			label="#{jspMsg['label.endDate']}"
				                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
				                			disabled="#{semmsa002Bean.disabledModeViewOnly}">
					                	   </rich:calendar>
					                	  </td>
				                		</tr>
										</table>
										</h:panelGroup>
									</h:panelGrid>
							
									<!-- panel owner period -->
									<rich:spacer height="10" rendered="#{semmsa002Bean.renderedPLX}"></rich:spacer>
							
									<h:panelGrid id="msa002Tab6_pnlInsuranceOwner" width="90%" border="0" cellpadding="0" cellspacing="1" 
									rendered="#{semmsa002Bean.renderedInsuranceOwner}">
										<h:panelGroup rendered="true">
										<table width="100%">
										<tr>
				                		<td align="left" colspan="2">
				                		 <h:outputText value="#{semmsa002Bean.irHeaderLabel}" styleClass="ms7" style="text-decoration: underline"/>
				                		</td>
				                		</tr>
				                		<tr>
				                		<td width="20%" align="right">
				                		 <h:graphicImage value="images/icon_required.gif"/>
										 <rich:spacer width="5"></rich:spacer>
										 <h:outputText value="#{jspMsg['label.ownerAmt']}" styleClass="ms7"/>
				                		</td>
										<td width="80%">
										<h:panelGroup>
			                			<h:inputText id="txtOwnerAmt" value="#{semmsa002Bean.siteAppInsuranceObjParam.ownerAmt}" size="18" 
			       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
			       						 onblur="return numberformat.moneyFormat(this);"
			       						 onfocus="return numberformat.setCursorPosToEnd(this);"
			       						 maxlength="16" 
			       						 styleClass="inputRight"
			       						 disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly}">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
			                			</h:inputText>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
										<rich:spacer width="2"></rich:spacer>
			                			<h:outputText value="/" styleClass="ms7"/>
			                			<rich:spacer width="2"></rich:spacer>
			              				<h:selectOneMenu id="ddlOwnerAmtPeriodType" value="#{semmsa002Bean.siteAppInsuranceObjParam.ownerPeriodType}"
			              				onchange="setDefaultIrPayPeriod();" disabled="#{semmsa002Bean.noOwnerAmtFlag ||semmsa002Bean.disabledModeViewOnly }"> 
											<f:selectItems value="#{semmsa002Bean.periodTypeList}"/>
										</h:selectOneMenu>
										
										<a4j:jsFunction name="setDefaultIrPayPeriod" action="#{semmsa002Action.doSetDefaultIRPayPeriod}" 
														reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,
														rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,txtOwnerPayPeriodTypeMonth,
														txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
										</a4j:jsFunction>
										<rich:spacer width="20"></rich:spacer>
										
										<h:selectBooleanCheckbox id="msa002tab6_noOwnerAmt" value="#{semmsa002Bean.noOwnerAmtFlag}"
										onclick="msa002tab6_noOwnerAmtFunc();">
										</h:selectBooleanCheckbox>
										
										<a4j:jsFunction name="msa002tab6_noOwnerAmtFunc" action="#{semmsa002Action.doNoInsurancePay}"
										reRender="txtOwnerAmt, ddlOwnerAmtPeriodType, rbtOwnerVatType, rbtOwnerPayPeriodType01, 
										rbtOwnerPayPeriodType06, rbtOwnerPayPeriodType07, rbtOwnerPayPeriodType02, rbtOwnerPayPeriodType03, 
										txtOwnerPayPeriodTypeMonth, rbtOwnerPayPeriodType04, txtOwnerPayPeriodTypeYear, rbtOwnerPayPeriodType05">
										</a4j:jsFunction>
										
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.noOwnerAmt']}" styleClass="ms7"></h:outputText>
										
										</h:panelGroup>
										
					                	</td>
				                		</tr>
				                		<tr>
					                	  <td width="20%" align="right" >
					                	  <h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
					                	  </td>
					                	  <td width="80%" >
					                	  <h:selectOneRadio id="rbtOwnerVatType" value="#{semmsa002Bean.siteAppInsuranceObjParam.ownerVatType}"  
					                	  styleClass="ms7" rendered="true" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly}">
				               				  	<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
						                		<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
						                		<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
						                		<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.vatType00']} "/>
			               				  </h:selectOneRadio>
					                	  </td>
					                	  </tr>
					                	   <tr>
					                	  <td width="20%" align="right" >
					                	  <h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"/>
					                	  </td>
					                	  <td width="80%" >
					                	  <h:panelGrid columns="7">
				                			<h:panelGroup>
					                			
				                				<h:selectOneRadio id="rbtOwnerPayPeriodType01" value="#{semmsa002Bean.payPeriodTypeIns01}"  styleClass="ms7" rendered="true"
					                			onclick="setOwnerPayPeriodType01();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }">
				                					<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
					                				 
					                				 <a4j:jsFunction name="setOwnerPayPeriodType01" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
					                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
										        		<a4j:actionparam  name="ownerPayPeriodType" value="01"></a4j:actionparam>
										        	</a4j:jsFunction>
				                				</h:selectOneRadio>
			                				</h:panelGroup>
			                				<h:panelGroup>
					                			
				                				<h:selectOneRadio id="rbtOwnerPayPeriodType06" value="#{semmsa002Bean.payPeriodTypeIns06}"  styleClass="ms7" rendered="true"
					                			onclick="setOwnerPayPeriodType06();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }">
				                					<f:selectItem itemValue="06" itemLabel="#{jspMsg['label.payPeriodType06']} " />
					                				 
					                				 <a4j:jsFunction name="setOwnerPayPeriodType06" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
					                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
										        		<a4j:actionparam  name="ownerPayPeriodType" value="06"></a4j:actionparam>
										        	</a4j:jsFunction>
				                				</h:selectOneRadio>
			                				</h:panelGroup>
			                				<h:panelGroup>
					                			
				                				<h:selectOneRadio id="rbtOwnerPayPeriodType07" value="#{semmsa002Bean.payPeriodTypeIns07}"  styleClass="ms7" rendered="true"
					                			onclick="setOwnerPayPeriodType07();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }">
				                					<f:selectItem itemValue="07" itemLabel="#{jspMsg['label.payPeriodType07']} " />
					                				 
					                				 <a4j:jsFunction name="setOwnerPayPeriodType07" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
					                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
										        		<a4j:actionparam  name="ownerPayPeriodType" value="07"></a4j:actionparam>
										        	</a4j:jsFunction>
				                				</h:selectOneRadio>
			                				</h:panelGroup>
			                				<h:panelGroup>
					                			
					                			<h:selectOneRadio id="rbtOwnerPayPeriodType02" value="#{semmsa002Bean.payPeriodTypeIns02}"  styleClass="ms7" rendered="true"
					                			onclick="setOwnerPayPeriodType02();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly}">
				                					<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']} " />
					                				 
					                				 <a4j:jsFunction name="setOwnerPayPeriodType02" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
					                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
										        		<a4j:actionparam  name="ownerPayPeriodType" value="02"></a4j:actionparam>
										        	</a4j:jsFunction>
				                				</h:selectOneRadio>
			                				</h:panelGroup>
				                			<h:panelGroup>
				                				<table>
				                					<tr> 
				                						<td>
						                					<h:selectOneRadio id="rbtOwnerPayPeriodType03" value="#{semmsa002Bean.payPeriodTypeIns03}"  styleClass="ms7" rendered="true"
								                			onclick="setOwnerPayPeriodType03();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }">
							                					<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
								                				 
								                				<a4j:jsFunction name="setOwnerPayPeriodType03" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
								                				reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 			txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
													        		<a4j:actionparam  name="ownerPayPeriodType" value="03"></a4j:actionparam>
													        	</a4j:jsFunction>
							                				</h:selectOneRadio>
					                					</td>
					                					<td>
							                				<h:inputText id="txtOwnerPayPeriodTypeMonth" size="5" styleClass="inputRight" 
							                				value="#{semmsa002Bean.payPeriodIns03}"
							                				disabled="#{semmsa002Bean.disabledPayPeriodIns03 || semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }"
							                				onblur="setOwnerPayPeriodType03();"
							                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
							                				<rich:spacer width="5"></rich:spacer>
							                				<h:outputText value="#{jspMsg['label.month']}" styleClass="ms7"></h:outputText>
					                					</td>
					                				</tr>
					                				</table>
					                			</h:panelGroup>
					                			<h:panelGroup>
						                			<table>
					                					<tr>
						                					<td>
							                					<h:selectOneRadio id="rbtOwnerPayPeriodType04" value="#{semmsa002Bean.payPeriodTypeIns04}"  styleClass="ms7" rendered="true"
									                			onclick="setOwnerPayPeriodType04();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }">
								                					<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
									                				 
									                				<a4j:jsFunction name="setOwnerPayPeriodType04" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
									                				reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 				txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
														        		<a4j:actionparam  name="ownerPayPeriodType" value="04"></a4j:actionparam>
														        	</a4j:jsFunction>
								                				</h:selectOneRadio>
							                				</td>
							                				<td>
								                				<h:inputText id="txtOwnerPayPeriodTypeYear" size="5" styleClass="inputRight"
								                				value="#{semmsa002Bean.payPeriodIns04}"
								                				disabled="#{semmsa002Bean.disabledPayPeriodIns04 || semmsa002Bean.noOwnerAmtFlag || 
								                				semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly}"
								                				onblur="setOwnerPayPeriodType04();"
								                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
								                				<rich:spacer width="5"></rich:spacer>
								                				<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"></h:outputText>
							                				</td>
						                				</tr>
						                			</table>
					                			</h:panelGroup>
					                			<h:panelGroup>
				                					<h:selectOneRadio id="rbtOwnerPayPeriodType05" value="#{semmsa002Bean.payPeriodTypeIns05}"  styleClass="ms7" rendered="true"
									                onclick="setOwnerPayPeriodType05();" disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly}">
								                		<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
									                				 
									                	<a4j:jsFunction name="setOwnerPayPeriodType05" action="#{semmsa002Action.renderPayPeriodTypeIns}" 
									                	reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,
					                				 	txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear,rbtOwnerPayPeriodType06,rbtOwnerPayPeriodType07">
															<a4j:actionparam  name="ownerPayPeriodType" value="05"></a4j:actionparam>
														</a4j:jsFunction>
								                	</h:selectOneRadio>
					                			</h:panelGroup>
				                				
				                				</h:panelGrid>
					                	  </td>
					                	  </tr>
				                		</table>
				                		</h:panelGroup>
			                		</h:panelGrid>
	                			</div>
			                	<rich:spacer height="10"></rich:spacer>
			                	<div style="width:100%; border:solid 1px fff;padding:5px;">
										<h:panelGroup>
											<table width="100%">
												<tr>
													<td align="right" width="18%">
														<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7" rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"></h:outputText>
													</td>
													<td align="left">
														<rich:calendar locale="th" enableManualInput="true" 
															   datePattern="dd/MM/yyyy" 
															   value="#{semmsa002Bean.siteAppInsuranceObjParam.effectiveDt}"
															   showWeeksBar="falSEMMEL005Actionse"
															   inputSize="10"
															   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														   	   cellWidth="15px" cellHeight="20px"
														   	   label=""
														   	   styleClass="ms7"
														   	   rendered="#{semmsa002Bean.siteAppObjParam.reqType != '01'}"
														   	   disabled="#{semmsa002Bean.noOwnerAmtFlag || semmsa002Bean.disabledModeViewOnly }">
														</rich:calendar>
													</td>
												</tr>
											</table>
										</h:panelGroup>
										
									</div>
									
									<div style="margin:5px;">
										<h:panelGroup>
											<a4j:commandButton id="msa002tab6_btnAddIR" value="Add" styleClass="rich-button" 
					       					rendered="#{semmsa002Bean.siteAppInsuranceObj.siteAppInsuranceId eq '' 
					       					or semmsa002Bean.siteAppInsuranceObj.siteAppInsuranceId eq null}"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
					       					action="#{navAction.navi}" 
					       					reRender="panelTab6" style=" width : 46px;">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doSiteAppIRIns" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab6_btnSaveIR" value="Save" styleClass="rich-button" 
					       					rendered="#{(semmsa002Bean.siteAppInsuranceObj.siteAppInsuranceId != '' 
					       					and semmsa002Bean.siteAppInsuranceObj.siteAppInsuranceId != null)}"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
					       					action="#{navAction.navi}" reRender="panelTab6">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doSiteAppIRUpd" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab6_btnDelIR" value="Delete" styleClass="rich-button" 
					       					rendered="#{semmsa002Bean.siteAppInsuranceObjParam.siteAppInsuranceId != '' 
					       					and semmsa002Bean.siteAppInsuranceObjParam.siteAppInsuranceId != null}"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
					       					onclick="if(!confirm('#{jspMsg['label.process_confirm']}')) return false;"
		                           			oncomplete="#{rich:component('msa002PopUpCommon_retStatus')}.show(); return false;"
					       					action="#{navAction.navi}" reRender="oppContent">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doDetSiteAppIR" />
					       					</a4j:commandButton>
					       					
					       					<rich:spacer width="5"></rich:spacer>
					       					
					       					<a4j:commandButton id="msa002tab6_btnClearIR" value="Clear" styleClass="rich-button" rendered="true"
					       					disabled="#{semmsa002Bean.disabledModeViewOnly}"
					       					action="#{navAction.navi}" reRender="pnlInsuranceParam">
					       						<a4j:actionparam name="navModule" value="sa" />
					                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
					                            <a4j:actionparam name="moduleWithNavi" value="sa" />
					                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
					                            <a4j:actionparam name="methodWithNavi" value="doClearSiteAppIR" />
					       					</a4j:commandButton>
										</h:panelGroup>
										
									</div>
			               	</h:panelGroup>
			               		<rich:panel >
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.inshist']}" style="width: 100%;"/>
									</f:facet>
								
									<h:panelGroup style="width:1150px; overflow:scroll; border:1px solid e0e0e0;">
									
										<rich:dataTable width="100%" id="dtbPTHist" cellpadding="1" cellspacing="0" border="0"
				                        var="siteAcqSP" value="#{semmsa002Bean.siteAppInsuranceList}" reRender="dtbPTHist" 
				                        rows="#{semmsa002Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
				                            
				                            <rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.contractNo']}" styleClass="contentform" style="width: 80"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.contractNo}" />
				                                </div>
				                      		</rich:column>
				                            <rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.startContDate']}" styleClass="contentform" style="width: 80"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.effectiveDtStr}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.endContDate']}" styleClass="contentform" style="width: 80"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.expireDtStr}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
						                                <f:facet name="header">
						                                    <h:outputText value="#{jspMsg['label.insType']}" styleClass="contentform" style="width: 100"/>
						                                </f:facet>
						                                <div align="center">
						                                    <h:outputText styleClass="contentform"  value="#{siteAcqSP.dataObj.insuranceTypeName}" />
						                                </div>
						                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.detail']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.detail}"  />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['label.th_remark']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.remark}"  />
				                                </div>
				                      		</rich:column>
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.updateby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.updateBy}"  />
				                                </div>
				                      		</rich:column>
				                      		
				                      		<rich:column>
				                                <f:facet name="header">
				                                    <h:outputText value="#{jspMsg['column.header.createby']}" styleClass="contentform" style="width: 100"/>
				                                </f:facet>
				                                <div align="center">
				                                    <h:outputText styleClass="contentform" value="#{siteAcqSP.dataObj.createBy}"  />
				                                </div>
				                      		</rich:column>
				                      		
				                      		
				                      		<f:facet name="footer">
				                                <rich:columnGroup>
				                                    <rich:column colspan="4">
				                                        <h:outputFormat value="#{msg['message.totalRecords']}">
				                                        	<f:param value="#{fn:length(semmsa002Bean.siteAppInsuranceList)}"></f:param>
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
			               	<h:panelGroup>
			               		
			               	</h:panelGroup>
			            </h:panelGroup>
			        </rich:panel>	
			            
				
				
				
				
				<div style="clear:both; height:50px;"></div>
				
				
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
