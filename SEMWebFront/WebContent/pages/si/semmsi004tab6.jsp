<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid id="pnlTab6" width="95%">
		 <a4j:region id="rgnInsurance">
		 	<rich:panel id="pnlInsurance" >
				<f:facet name="header">
					<h:outputText value="#{jspMsg['header.panel.conditionInsurance']}"/>
				</f:facet>
				
				<h:panelGrid id="pnlInsuranceCondition" width="90%" border="0" cellpadding="0" cellspacing="1">
					<h:panelGroup>
						<table width="100%">
							<tr>
								<td align="right" width="100%" valign="top" colspan="4">
							             <a4j:commandButton style="" styleClass="rich-button" id="msi004tab7_popHist" value="#{jspMsg['label.th_history']}#{jspMsg['label.th_info']}#{jspMsg['label.th_insurance']}"
		                                 action="#{semmsi004Action.doShowPopupHistory}" reRender="popupDisplay7"
		                                 oncomplete="#{rich:component('tab7_panel_popupModalRetStatus')}.show(); return false;">
		                                      <f:param name="tabNo" value="7"/>
		                                 </a4j:commandButton>
		                                 <a4j:include id="popUpTab7"  viewId="../../pages/sa/semmsa002PopUpTab7.jsp" />
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
						</table>
							
						<rich:spacer height="10"></rich:spacer>
							
						<!-- << group 2 -->
						<h:panelGrid style="width:100%;" columns="1" rendered="false">
	
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
											<td align="left" >
												<h:outputText >.</h:outputText>
											</td>
											<td align="right" width="15%">
														
												<h:outputText value="#{jspMsg['label.th_beginDateContract']} : " styleClass="ms7" />
											</td>
											<td align="left" >
												<h:outputText ></h:outputText>
											</td>
											<td align="right" width="15%">
														
												<h:outputText value="#{jspMsg['label.th_contractExpDt']} : " styleClass="ms7" />
											</td>
											<td align="left" >
												<h:outputText >.</h:outputText>
											</td>
										</tr>
										<tr>
											<td align="right">
												<h:outputText value="#{jspMsg['label.insType']} : " styleClass="ms7" />
											</td>
											<td align="left" >
												<h:outputText ></h:outputText>
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
											<td align="right">
												<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7" />
											</td>
											<td align="left" >
												<h:outputText ></h:outputText>
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
													<td align="right">
														<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
													</td>
													<td align="left" >
														<h:outputText ></h:outputText>
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
											</table>
										</h:panelGroup>
								</rich:panel>
							</h:panelGrid> 
							<!-- >> group 2 -->
							 
							<rich:spacer height="10"></rich:spacer>
							 
							<!-- << group 3 -->
							<h:panelGroup rendered="false">
				                <div>
				                	<h:selectBooleanCheckbox></h:selectBooleanCheckbox>
				                	<h:outputText value="#{jspMsg['label.changeinsInfo']}" styleClass="ms7" />
				                </div>
				            </h:panelGroup>
							<!-- >> group 3 -->
							 
							<rich:spacer height="10"></rich:spacer>
							 
							<!-- << group 4 -->
							<h:panelGroup>
			           		<h:outputText value="#{jspMsg['label.changeinsInfo']}" styleClass="ms7" 
			           		rendered="#{semmsi004Bean.reqTypeParam != '01'}"/>
							
								<h:selectOneRadio id="rbtMsi004tab6_changeIR" value="#{semmsi004tab6Bean.insuranceEditFlag}" styleClass="ms7" 
								rendered="#{semmsi004Bean.reqTypeParam != '01'}"
								disabled="" onclick="fnMsi004tab6_changeIRComfirm();">
		                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_notEdit']}" />
		                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_edit']}"/>
		                		</h:selectOneRadio>
		                		
		                		<a4j:jsFunction name="fnMsi004tab6_changeIRComfirm"
		                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
		                		action="#{semmsi004tab6Action.doSetParamConfirmNotChangeInsurance}"
		                		 reRender="pnlInsurance,
		                		 msi004PopUpCommon_commonConfirm"></a4j:jsFunction>
			      	</h:panelGroup>
							<rich:panel id="pnlInsuranceParam">
				
								<f:facet name="header">
									<h:outputText value="#{jspMsg['label.inscond']}" style="width: 100%;"/>
								</f:facet>
							
								<h:panelGrid>
									<h:panelGroup style="width:100%;">
										<h:panelGroup>
						                	<div style="width:100%; border:solid 1px fff;padding:5px;">
						                		<table style="width:100%;">
						                			<tr>
						                				<td align="right" width="17%">
						                					<h:outputText value="#{jspMsg['label.insType']} : " styleClass="ms7" />
						                				</td>
						                				<td align="left">
						                					<h:selectOneMenu onchange="RenderInsuranceType();" styleClass="ms7"
						                					value="#{semmsi004tab6Bean.insurance.insuranceType}"
						                					disabled="#{semmsi004tab6Bean.insuranceEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01' }">
						                						<f:selectItems value="#{semmsi004tab6Bean.insuranceTypeList}"/>
									                				
									                			<a4j:jsFunction name="RenderInsuranceType"  action="#{semmsi004tab6Action.renderInsuranceType}"
			               				 						reRender="msi004tab6_pnlPLX, msa002Tab6_pnlInsuranceOwner, pnlInsuranceParam"/>
												       		</h:selectOneMenu>
						                				</td>
						                			</tr>
						                			<tr>
						                				<td align="right" >
						                					<h:outputText value="#{jspMsg['label.th_remark']} : " styleClass="ms7" />
						                				</td>
						                				<td align="left">
						                					<h:inputTextarea rows="5" style="width:80%;"
			                								value="#{semmsi004tab6Bean.insurance.remark}"
			                								disabled="#{semmsi004tab6Bean.insuranceEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01' }"></h:inputTextarea>
						                				</td>
						                			</tr>
						                		</table>
						                	</div>
						                	
						                	<div style="clear:both; height:10px;" ></div>
						                	
						                	<h:panelGroup rendered="#{semmsi004tab6Bean.renderedPLX or semmsi004tab6Bean.renderedInsuranceOwner}">
						                		<div style="width:100%; border:solid 1px fff;padding:5px;">
							                	<!-- panel PLX -->
							                	<h:panelGrid id="msi004tab6_pnlPLX" width="90%" border="0" cellpadding="0" cellspacing="1" 
							                	rendered="#{semmsi004tab6Bean.renderedPLX}">
													<h:panelGroup rendered="true">
													<table width="100%">
							                		<tr>
								                		<td align="left" colspan="4">
								                		 <h:outputText value="#{semmsi004tab6Bean.irHeaderLabel}" styleClass="ms7" style="text-decoration: underline"/>
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
								                			<h:inputText id="txtPlxBeneficiary" value="#{semmsi004tab6Bean.insurance.plxBeneficiary}" 
								       						 style="width:80%;"
								       						 disabled="#{semmsi004tab6Bean.insuranceEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01' }"/>
															</h:panelGroup>
								                		</td>
							                		</tr>
							                		<tr>
								                	  <td width="20%" align="right">
								                	  	<h:outputText value="#{jspMsg['labe.plxOldAmt']}" styleClass="ms7"/>
								                	  </td>
								                	  <td width="30%" >
								                	  <h:panelGroup>
								                		<h:inputText id="txtPlxOldAmt" value="#{semmsi004tab6Bean.insurance.plxOldAmt}" size="18" 
							       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
							       						 onblur="return numberformat.moneyFormat(this);"
							       						 onfocus="return numberformat.setCursorPosToEnd(this);"
							       						 maxlength="16" 
							       						 styleClass="inputRight"
							       						 disabled="#{semmsi004tab6Bean.disabledInsurance}">
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
						                			<h:inputText id="txtPlxAddAmt" value="#{semmsi004tab6Bean.insurance.plxAddAmt}" size="18" 
						       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
						       						 onblur="return numberformat.moneyFormat(this);"
						       						 onfocus="return numberformat.setCursorPosToEnd(this);"
						       						 maxlength="16" 
						       						 styleClass="inputRight"
						       						 disabled="#{semmsi004tab6Bean.disabledInsurance}">
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
															<h:outputText value="#{jspMsg['label.plxAmt']}" styleClass="ms7"/>
								                		</td>
								                		<td width="80%" colspan="3">
								                			<h:panelGroup>
								                			<h:inputText id="txtPlxAmt" value="#{semmsi004tab6Bean.insurance.plxAmt}" size="18" 
								       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
								       						 onblur="return numberformat.moneyFormat(this);"
								       						 onfocus="return numberformat.setCursorPosToEnd(this);"
								       						 maxlength="16" 
								       						 styleClass="inputRight"
								       						 disabled="#{semmsi004tab6Bean.disabledInsurance}">
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
							                			value="#{semmsi004tab6Bean.insurance.plxEffectiveDt}" 
							                			showWeeksBar="false" 
							                			inputSize="13"
							                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
														cellWidth="20px" cellHeight="20px"
														label="#{jspMsg['label.startDate']}"
														disabled="#{semmsi004tab6Bean.disabledInsurance}">
														</rich:calendar>
								                	  </td>
								                	   <td width="20%" align="right">
								                	  <h:outputText value="#{jspMsg['label.endDate']} :" styleClass="ms7"/>
								                	  </td>
								                	  <td width="30%" >
									                	   <rich:calendar id="cldPlxExpDate" locale="th" enableManualInput="true" 
								                			datePattern="dd/MM/yyyy" 
								                			value="#{semmsi004tab6Bean.insurance.plxExpireDt}"
								                			showWeeksBar="false" 
								                			inputSize="13"
								                			label="#{jspMsg['label.endDate']}"
								                			oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								                			disabled="#{semmsi004tab6Bean.disabledInsurance}">
									                	   </rich:calendar>
								                	  </td>
							                		</tr>
													</table>
													</h:panelGroup>
												</h:panelGrid>
										
												<h:panelGrid id="msa002Tab6_pnlInsuranceOwner" width="90%" border="0" cellpadding="0" cellspacing="1" 
												rendered="#{semmsi004tab6Bean.renderedInsuranceOwner}">
													<h:panelGroup rendered="true">
													<table width="100%">
													<tr>
							                		<td align="left" colspan="2">
							                		 <h:outputText value="#{semmsi004tab6Bean.irHeaderLabel}" styleClass="ms7" style="text-decoration: underline"/>
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
						                			<h:inputText id="txtOwnerAmt" value="#{semmsi004tab6Bean.insurance.ownerAmt}" size="18" 
						       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
						       						 onblur="return numberformat.moneyFormat(this);"
						       						 onfocus="return numberformat.setCursorPosToEnd(this);"
						       						 maxlength="16" 
						       						 styleClass="inputRight"
						       						 disabled="#{semmsi004tab6Bean.disabledInsurance or semmsi004tab6Bean.noOwnerAmtFlag}">
													<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
						                			</h:inputText>
													<rich:spacer width="5"></rich:spacer>
													<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
													<rich:spacer width="2"></rich:spacer>
						                			<h:outputText value="/" styleClass="ms7"/>
						                			<rich:spacer width="2"></rich:spacer>
						              				<h:selectOneMenu id="ddlOwnerAmtPeriodType" value="#{semmsi004tab6Bean.insurance.ownerPeriodType}"
						              				disabled="#{semmsi004tab6Bean.disabledInsurance}" onchange="defaultOwnerPayPeriodType();"> 
													<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
													</h:selectOneMenu>
													
							<script type="text/javascript">
								function defaultOwnerPayPeriodType(){
									var periodType = document.getElementById("incContent:frmAddSiteInfo:incTab6:ddlOwnerAmtPeriodType").value;
									var payPeriodType01 = document.getElementById("incContent:frmAddSiteInfo:incTab6:rbtOwnerPayPeriodType01:0");
									var payPeriodType02 = document.getElementById("incContent:frmAddSiteInfo:incTab6:rbtOwnerPayPeriodType02:0");
									var payPeriodType03 = document.getElementById("incContent:frmAddSiteInfo:incTab6:rbtOwnerPayPeriodType03:0");
									var payPeriodType04 = document.getElementById("incContent:frmAddSiteInfo:incTab6:rbtOwnerPayPeriodType04:0");
									var payPeriodType05 = document.getElementById("incContent:frmAddSiteInfo:incTab6:rbtOwnerPayPeriodType05:0");
									
									var year = document.getElementById("incContent:frmAddSiteInfo:incTab6:txtOwnerPayPeriodTypeYear");
									var month = document.getElementById("incContent:frmAddSiteInfo:incTab6:txtOwnerPayPeriodTypeMonth");
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
													<rich:spacer width="20"></rich:spacer>
													
													<h:selectBooleanCheckbox id="msi004tab6_noOwnerAmt" value="#{semmsi004tab6Bean.noOwnerAmtFlag}" onclick="reREnderTab6();"></h:selectBooleanCheckbox>
													<rich:spacer width="5"></rich:spacer>
													<h:outputText value="#{jspMsg['label.noOwnerAmt']}" styleClass="ms7"></h:outputText>
													<a4j:jsFunction name="reREnderTab6" reRender="pnlInsuranceParam"></a4j:jsFunction>
													</h:panelGroup>
													
								                	</td>
							                		</tr>
							                		<tr>
								                	  <td width="20%" align="right" >
								                	  <h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
								                	  </td>
								                	  <td width="80%" >
								                	  <h:selectOneRadio id="rbtOwnerVatType" value="#{semmsi004tab6Bean.insurance.ownerVatType}"  
								                	  styleClass="ms7" rendered="true" >
							               				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']}" />
						                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}" />
						                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']}" />
						                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.vatType00']}" />
						               				  </h:selectOneRadio>
								                	  </td>
								                	  </tr>
								                	   <tr>
								                	  <td width="20%" align="right" >
								                	  <h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"/>
								                	  </td>
								                	  <td width="80%" >
								                	  	<h:panelGrid columns="5">
								                			<h:panelGroup>
									                			<h:selectOneRadio id="rbtOwnerPayPeriodType01" value="#{semmsi004tab6Bean.payPeriodType01}"  styleClass="ms7" rendered="true"
									                			onclick="setOwnerPayPeriodType01();" disabled="#{semmsi004tab6Bean.disabledInsurance}">
								                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
								                				 <a4j:jsFunction name="setOwnerPayPeriodType01" action="#{semmsi004tab6Action.renderPayPeriodType}" 
								                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear">
													        	<a4j:actionparam  name="ownerPayPeriodType" value="01"></a4j:actionparam>
													        	</a4j:jsFunction>
								                				</h:selectOneRadio>
							                				</h:panelGroup>
							                				<h:panelGroup>
									                			<h:selectOneRadio id="rbtOwnerPayPeriodType02" value="#{semmsi004tab6Bean.payPeriodType02}"  styleClass="ms7" rendered="true"
									                			onclick="setOwnerPayPeriodType02();" disabled="#{semmsi004tab6Bean.disabledInsurance}">
								                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}"/>
								                				<a4j:jsFunction name="setOwnerPayPeriodType02" action="#{semmsi004tab6Action.renderPayPeriodType}" 
								                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear">
													        	<a4j:actionparam  name="ownerPayPeriodType" value="02"></a4j:actionparam>
													        	</a4j:jsFunction>
								                				</h:selectOneRadio>
							                				</h:panelGroup>
								                				<h:panelGroup>
								                				<table>
								                					<tr> 
								                					<td>
								                					<h:selectOneRadio id="rbtOwnerPayPeriodType03" value="#{semmsi004tab6Bean.payPeriodType03}"  styleClass="ms7" rendered="true"
								                					onclick="setOwnerPayPeriodType03();" disabled="#{semmsi004tab6Bean.disabledInsurance}">
									                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
									                				<a4j:jsFunction name="setOwnerPayPeriodType03" action="#{semmsi004tab6Action.renderPayPeriodType}" 
									                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear">
														        	<a4j:actionparam  name="ownerPayPeriodType" value="03"></a4j:actionparam>
														        	</a4j:jsFunction>
									                				</h:selectOneRadio>
									                				</td>
									                				<td>
									                				<h:inputText id="txtOwnerPayPeriodTypeMonth" size="5" 
									                				value="#{semmsi004tab6Bean.payPeriod03}" styleClass="inputRight" 
									                				disabled="#{semmsi004tab6Bean.disabledPayPeriod03}" 
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
								                					<h:selectOneRadio id="rbtOwnerPayPeriodType04" value="#{semmsi004tab6Bean.payPeriodType04}"  styleClass="ms7" rendered="true"
								                					onclick="setOwnerPayPeriodType04();" disabled="#{semmsi004tab6Bean.disabledInsurance}">
									                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
									                				<a4j:jsFunction name="setOwnerPayPeriodType04" action="#{semmsi004tab6Action.renderPayPeriodType}" 
									                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear">
														        	<a4j:actionparam  name="ownerPayPeriodType" value="04"></a4j:actionparam>
														        	</a4j:jsFunction>
									                				</h:selectOneRadio>
									                				</td>
									                				<td>
									                				<h:inputText id="txtOwnerPayPeriodTypeYear" size="5" 
									                				disabled="#{semmsi004tab6Bean.disabledPayPeriod04}"
									                				value="#{semmsi004tab6Bean.payPeriod04}" styleClass="inputRight"
									                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
									                				<rich:spacer width="5"></rich:spacer>
									                				<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"></h:outputText>
									                				</td>
									                				</tr>
									                				</table>
									                			</h:panelGroup>
									                			<h:panelGroup>
								                					<h:selectOneRadio id="rbtOwnerPayPeriodType05" value="#{semmsi004tab6Bean.payPeriodType05}"  styleClass="ms7" rendered="true"
								                					onclick="setOwnerPayPeriodType05();" disabled="#{semmsi004tab6Bean.disabledInsurance}">
									                				<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
									                				<a4j:jsFunction name="setOwnerPayPeriodType05" action="#{semmsi004tab6Action.renderPayPeriodType}" 
									                				 reRender="rbtOwnerPayPeriodType01,rbtOwnerPayPeriodType02,rbtOwnerPayPeriodType03,rbtOwnerPayPeriodType04,rbtOwnerPayPeriodType05,txtOwnerPayPeriodTypeMonth,txtOwnerPayPeriodTypeYear">
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
						                	</h:panelGroup>
						                	
						                	<rich:spacer height="10" rendered="#{semmsi004tab6Bean.renderedPLX or semmsi004tab6Bean.renderedInsuranceOwner}"></rich:spacer>
						                	
						                	
											<h:panelGroup rendered="#{semmsi004Bean.reqTypeParam != '01'}">
												<div style="width:100%; border:solid 1px fff;padding:5px;">
													<table width="100%">
														<tr>
															<td align="right" width="18%">
																<h:outputText value="#{jspMsg['label.th_eff_dt']} : " styleClass="ms7"
																rendered="#{semmsi004Bean.reqTypeParam != '01'}"></h:outputText>
															</td>
															<td align="left">
																<rich:calendar locale="th" enableManualInput="true" 
																	   datePattern="dd/MM/yyyy" 
																	   value="#{semmsi004tab6Bean.insurance.effectiveDt}"
																	   showWeeksBar="falSEMMEL005Actionse"
																	   inputSize="10"
																	   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
																   	   cellWidth="15px" cellHeight="20px"
																   	   label=""
																   	   styleClass="ms7"
																   	   rendered="#{semmsi004Bean.reqTypeParam != '01'}"
																   	   disabled="#{semmsi004tab6Bean.disabledInsurance}">
																</rich:calendar>
															</td>
														</tr>
													</table>
												</div>
											</h:panelGroup>
												
											
												<div style="margin:5px;">
													<h:panelGroup >
														<a4j:commandButton id="btnAdd_tab6" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
										           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError,txtOldContractNo" 
										           		rendered="false">
											           		<a4j:actionparam name="navModule" value="si" />
															<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
															<a4j:actionparam name="moduleWithNavi" value="si" />
															<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
															<a4j:actionparam name="methodWithNavi" value="doUpdateTab6" />
										           		</a4j:commandButton>
													
														<rich:spacer width="10"></rich:spacer>
													
														<a4j:commandButton id="btnSave_tab6" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
										           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError,txtOldContractNo" 
										           		rendered="false">
											           		<a4j:actionparam name="navModule" value="si" />
															<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
															<a4j:actionparam name="moduleWithNavi" value="si" />
															<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
															<a4j:actionparam name="methodWithNavi" value="doUpdateTab6" />
										           		</a4j:commandButton>
										           		
														<a4j:commandButton id="msi004tab6_btnAddIR" value="Add" styleClass="rich-button" 
								       					rendered="false"
								       					disabled="#{semmsi004tab6Bean.disabledInsurance}"
								       					action="#{navAction.navi}" 
								       					reRender="oppContent" style=" width : 46px;">
								       						<a4j:actionparam name="navModule" value="sa" />
								                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
								                            <a4j:actionparam name="moduleWithNavi" value="sa" />
								                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
								                            <a4j:actionparam name="methodWithNavi" value="doSiteAppIRIns" />
								       					</a4j:commandButton>
								       					
								       					<rich:spacer width="5"></rich:spacer>
								       					
								       					<a4j:commandButton id="msi004tab6_btnSaveIR" value="Save" styleClass="rich-button" 
								       					rendered="false"
								       					disabled="#{semmsi004tab6Bean.disabledInsurance}"
								       					action="#{navAction.navi}" reRender="oppContent">
								       						<a4j:actionparam name="navModule" value="sa" />
								                            <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
								                            <a4j:actionparam name="moduleWithNavi" value="sa" />
								                            <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
								                            <a4j:actionparam name="methodWithNavi" value="doSiteAppIRUpd" />
								       					</a4j:commandButton>
								       					
								       					<rich:spacer width="5"></rich:spacer>
								       					
								       					<a4j:commandButton id="msi004tab6_btnDelIR" value="Delete" styleClass="rich-button" 
								       					rendered="false"
								       					disabled="#{semmsi004tab6Bean.disabledInsurance}"
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
								       					
								       					<a4j:commandButton id="msi004tab6_btnClearIR" value="Clear" styleClass="rich-button" 
								       					rendered="false"
								       					disabled="#{semmsi004tab6Bean.disabledInsurance}"
								       					action="#{navAction.navi}" reRender="oppContent">
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
							                        var="siteAcqSP" value="#{semmsi004tab6Bean.siteAppInsuranceList}" reRender="dtbPTHist" 
							                        rows="#{semmsi004tab6Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
							                            
							                            <rich:column rendered="false">
								                            <f:facet name="header">
								                                <h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								                            </f:facet>
								                            <div align="center">
									                            <a4j:commandButton action="#{navAction.navi}" image="images/edit.png" style="height: 15; width: 15"
									                            reRender="oppContent">
									                                <a4j:actionparam name="navModule" value="sa" />
									                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									                                                    
									                                <a4j:actionparam name="moduleWithNavi" value="sa" />
									                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									                                
									                            </a4j:commandButton>
								                            </div>
								                        </rich:column>
								                        
								                        <rich:column rendered="false">
								                            <f:facet name="header">
								                                <h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								                            </f:facet>
								                            <div align="center">
									                            <a4j:commandButton action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
									                            reRender="oppContent">
									                                <a4j:actionparam name="navModule" value="sa" />
									                                <a4j:actionparam name="navProgram" value="SEMMSA002-1" />
									                                                    
									                                <a4j:actionparam name="moduleWithNavi" value="sa" />
									                                <a4j:actionparam name="actionWithNavi" value="SEMMSA002" />
									                                <a4j:actionparam name="methodWithNavi" value="doInitialMsa002Tab" />
									                                
									                            </a4j:commandButton>
								                            </div>
								                        </rich:column>
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
							                                    <h:outputText styleClass="contentform"  />
							                                </div>
							                      		</rich:column>
							                      		
							                      		<rich:column>
							                                <f:facet name="header">
							                                    <h:outputText value="#{jspMsg['column.header.createby']}" styleClass="contentform" style="width: 100"/>
							                                </f:facet>
							                                <div align="center">
							                                    <h:outputText styleClass="contentform"/>
							                                </div>
							                      		</rich:column>
							                      		
							                      		
							                      		<f:facet name="footer">
							                                <rich:columnGroup>
							                                    <rich:column colspan="4">
							                                        <h:outputFormat value="#{msg['message.totalRecords']}">
							                                        	<f:param value="#{fn:length(semmsi004tab6Bean.siteAppInsuranceList)}"></f:param>
							                                        </h:outputFormat>
							                                    </rich:column>
							                                    <rich:column colspan="11">
							                                        <rich:datascroller immediate="true" rendered="true" align="left" for="dtbPTHist"
							                                            maxPages="#{semmsi004tab6Bean.rowPerPage}"  selectedStyleClass="selectScroll"
							                                            stepControls="hide" fastControls="auto" boundaryControls="auto" 
							                                            id="dstRentalServOtherinfo" 
							                                            style="background-color: #cccccc;"
							                                            page="#{semmsi004tab6Bean.scrollerPage}" 
							                                        />
							                                    </rich:column>
							                                </rich:columnGroup>
							                            </f:facet>
							                            
							                   		</rich:dataTable>
												
											</h:panelGroup>
										</rich:panel>
						               	
									</h:panelGroup>
								</h:panelGrid>
							</rich:panel>
							<!-- >> group 4 -->
							 
							<rich:spacer height="10"></rich:spacer>
			
					</h:panelGroup>
				</h:panelGrid>
			</rich:panel>			
		</a4j:region>				
	</h:panelGrid>
					
</h:panelGrid>