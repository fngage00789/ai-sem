<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid columnClasses="gridContent" width="100%">
	<a4j:region id="rgnRentCond">
				<h:panelGrid  width="95%" id="pnlRent">
				<h:panelGroup>
						<table width="80%">
						<tr>
							<td align="right" width="25%">
							<h:outputText value="#{jspMsg['label.effDate']} :" styleClass="ms7"/>
                			</td>
                			<td width="15%">
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
							<td width="15%">
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
		           <rich:panel id="pnlRentCond">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.rentCond']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgFormTop}"/>
						</div>
						<h:panelGrid width="90%" id="pnlRentCondAndService"  border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						<table width="100%">
							<!-- row for condition -->
							<tr>
							<td>
							<h:panelGroup>
							<table width="100%">
							<tr>
							<td width="75%" align="left">
							<script type="text/javascript">
							var tempWhtRateRentSpecial = '';
							var tempWhtRateServiceSpecial = '';
							function renderedImgRequireTotalRent(){
								var rentCondType02 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtRentCondType:1");
								var imgAgeRent = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalAgeRentAmt");
								var imgAgeService = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalAgeServiceAmt");
								var detail1 = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtRentCondSpecialDetail").value;
								var detail2 = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtServiceDetail").value;
								if(rentCondType02.checked){
									if(detail1 != ''){
										imgAgeRent.style.display = '';
									}else{
										imgAgeRent.style.display = 'none';
									}
									if(detail2 != ''){
										imgAgeService.style.display = '';
									}else{
										imgAgeService.style.display = 'none';
									}
								}else{
									imgAgeRent.style.display = 'none';
									imgAgeService.style.display = 'none';
								}
								tempWhtRateRentSpecial = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtWhtRateRentSpecial").value;
								tempWhtRateServiceSpecial = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtWhtRateServiceSpecial").value;
																		
							}
							</script>               				
							</td>
							</tr>
							</table>
							</h:panelGroup>
							</td>
							</tr>
							<!-- row for normal condition tab3 -->
							<tr>
							<td>
							<h:panelGroup  id="pnlRentCondNormal">
							<table width="100%">
							<tr>
							<td width="25%" align="right">
							<h:graphicImage value="images/icon_required.gif"/>
							<rich:spacer width="5"></rich:spacer>
							<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
							</td>
							<td width="30%" align="left">
								<h:selectOneMenu id="ddlExpenseType" value="#{semmsi004tab3Bean.rentCondNormal.expenseType}"
								disabled="#{semmsi004tab3Bean.disabledRent}" onchange="RenderedNormalVatTypeJS();"> 
										<f:selectItems value="#{semmsi004tab3Bean.expenseTypeRentList}"/>
								</h:selectOneMenu>
								<a4j:jsFunction name="RenderedNormalVatTypeJS" reRender="pnlRentCondNormal" 
								action="#{semmsi004tab3Action.renderedNormalVatType}" oncomplete="setTempWhtRateNormal();"/>
								<script type="text/javascript">
								var tempWhtRateRentNormal = '';
								var tempWhtRateServiceNormal = '';
								function setTempWhtRateNormal(){
									var ddlExpenseType = document.getElementById("incContent:frmAddSiteInfo:incTab3:ddlExpenseType").value;
									var whtRate = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtWhtRateNormal");
									if(ddlExpenseType != '' && ddlExpenseType == '01'){
										tempWhtRateRentNormal = whtRate.value;
									}else if(ddlExpenseType != '' && ddlExpenseType == '02'){
										tempWhtRateServiceNormal = whtRate.value;
									}else{
										tempWhtRateRentNormal = '';
										tempWhtRateServiceNormal = '';
										whtRate.value = '';
									}
								}
								
							</script>
							</td>
							<td width="25%" align="right">
							<h:outputText value="#{jspMsg['label.placeName']}" styleClass="ms7"/>
							</td>
							<td width="20%">
		                		<h:inputText id="txtPlaceName" value="#{semmsi004tab3Bean.rentCondNormal.placeName}" 
		                		size="30" disabled="#{semmsi004tab3Bean.disabledRent}"/>
				            </td>
							</tr>
							<tr>
								<td align="right" width="25%" valign="top">
								<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
	                			</td>
	                			<td colspan="3" width="75%">
	                			<h:inputTextarea id="txtDetail" value="#{semmsi004tab3Bean.rentCondNormal.detail}" 
	                			cols="100" rows="3" disabled="#{semmsi004tab3Bean.disabledRent}"/>
			                	</td>
		                	 </tr>
		                	 <tr>
								<td align="right" width="25%">
								<h:outputText value="#{jspMsg['label.ownerGroup']}" styleClass="ms7"/>
	                			</td>
	                			<td width="75%" colspan="3">
	                			<h:selectOneMenu id="ddlOwnerGroup" value="#{semmsi004tab2Bean.contract.ownerGroup}"
	                			disabled="#{semmsi004tab2Bean.disabledContract}"> 
								<f:selectItems value="#{semmsi004tab2Bean.ownerGroupList}"/>
								</h:selectOneMenu>
			                	</td>
		                	 </tr>
		                	 <h:panelGroup rendered="#{semmsi004tab3Bean.renderedRentOldAmt}">
		                	  <tr>
								<td align="right" width="25%">
								<h:outputText value="#{jspMsg['label.rentOldAmt']}" styleClass="ms7"/>
	                			</td>
	                			<td colspan="3" width="75%">
	                			<h:inputText id="txtRentOldAmt2" value="#{semmsi004tab3Bean.rentCondNormal.rentOldAmt}" size="15" 
              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
              						 onblur="return numberformat.moneyFormat(this);"
              						 onfocus="return numberformat.setCursorPosToEnd(this);"
              						 maxlength="16" 
              						 styleClass="inputRight"
              						 disabled="#{semmsi004tab3Bean.disabledRentOldAmt}">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                		</h:inputText>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
	                			<h:outputText value="/" styleClass="ms7"/>
	                			<rich:spacer width="2"></rich:spacer>
               					<h:selectOneMenu id="ddlRentOldPeriodType" value="#{semmsi004tab3Bean.rentCondNormal.rentOldPeriodType}"
               					disabled="#{semmsi004tab3Bean.disabledPeriodType}"> 
								<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
								</h:selectOneMenu>
			                	</td>
			                	 </tr>
			                	  <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.rentAddPercent']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="75%">
		                			<table width="75%">
		                				 <tr>
		                				 	<td width="20%">
		                				 	<h:inputText id="txtRentAddPercent" value="#{semmsi004tab3Bean.rentCondNormal.rentAddPercent}" 
		                					size="10" maxlength="12" styleClass="inputRight" disabled="#{semmsi004tab3Bean.disabledRent}"
		                					onchange="CalRentAddAmtJS();"
		                					onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		                					onblur="return numberformat.moneyFormat(this);"
		              						onfocus="return numberformat.setCursorPosToEnd(this);">
		                					<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                					<a4j:support event="oninputchange" ajaxSingle="true" reRender="txtRentAddAmt2,txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAddAmt}"/>
											<a4j:support event="oninputblur" ajaxSingle="true" reRender="txtRentAddAmt2,txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAddAmt}"/>
											<a4j:support event="onchanged" ajaxSingle="true" reRender="txtRentAddAmt2,txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAddAmt}"/>
											<a4j:jsFunction name="CalRentAddAmtJS" action="#{semmsi004tab3Action.calRentAddAmt}" 
											 reRender="txtRentAddAmt2,txtRentalAmount"/>
		                					</h:inputText>
		                				 	<rich:spacer width="2" ></rich:spacer>
		                					<h:outputText value="%" styleClass="ms7"/>
		                				 	</td>
		                				 	<td width="55%" align="left" colspan="2">	
		                				 	<h:inputText id="txtRentAddAmt2" value="#{semmsi004tab3Bean.rentCondNormal.rentAddAmt}" size="15" 
		              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
		              						 onblur="return numberformat.moneyFormat(this);"
		              						 onfocus="return numberformat.setCursorPosToEnd(this);"
		              						 maxlength="16" 
		              						 styleClass="inputRight"
		              						 disabled="#{semmsi004tab3Bean.disabledRent}"
		              						 onchange="CalRentAmtJS();">
											<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
		                					<a4j:support event="oninputchange" ajaxSingle="true" reRender="txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAmt}"/>
											<a4j:support event="oninputblur" ajaxSingle="true" reRender="txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAmt}"/>
											<a4j:support event="onchanged" ajaxSingle="true" reRender="txtRentalAmount" 
											action="#{semmsi004tab3Action.calRentAmt}"/>
											<a4j:jsFunction name="CalRentAmtJS" action="#{semmsi004tab3Action.calRentAmt}" 
											 reRender="txtRentalAmount,txtRentAddPercent"/>
		                					</h:inputText>
		                					<rich:spacer width="2"></rich:spacer>
				                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
				                			<rich:spacer width="2"></rich:spacer>
				                			<h:outputText value="/" styleClass="ms7"/>
				                			<rich:spacer width="2"></rich:spacer>
				                			<h:selectOneMenu id="ddlRentAddPeriodType" value="#{semmsi004tab3Bean.rentCondNormal.rentAddPeriodType}"
		                				 	disabled="#{semmsi004tab3Bean.disabledPeriodType}"> 
											<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
											</h:selectOneMenu>
		                				 	</td>
		                				 </tr>
		                				</table>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
			                	  <tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.rentalAmount']}" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" width="75%">
		                			<h:inputText id="txtRentalAmount" value="#{semmsi004tab3Bean.rentCondNormal.rentAmt}" size="15" 
              						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
              						 onblur="return numberformat.moneyFormat(this);"
              						 onfocus="return numberformat.setCursorPosToEnd(this);"
              						 maxlength="16" 
              						 styleClass="inputRight"
              						 disabled="#{semmsi004tab3Bean.disabledRent}"
              						 onchange="CalRentAddPercentAndRentAddAmt();">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									<a4j:support event="oninputchange" ajaxSingle="true" reRender="txtRentAddPercent,txtRentAddAmt2" 
									action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}"/>
									<a4j:support event="oninputblur" ajaxSingle="true" reRender="txtRentAddPercent,txtRentAddAmt2" 
									action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}"/>
									<a4j:support event="onchanged" ajaxSingle="true" reRender="txtRentAddPercent,txtRentAddAmt2" 
									action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}"/>
		                			</h:inputText>
		                			<a4j:jsFunction name="CalRentAddPercentAndRentAddAmt" action="#{semmsi004tab3Action.calRentAddPercentAndRentAddAmt}" 
									reRender="txtRentAddPercent,txtRentAddAmt2"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<h:outputText value="/" styleClass="ms7"/>
		                			<rich:spacer width="2"></rich:spacer>
                					<h:selectOneMenu id="ddlRentalPeriodType" value="#{semmsi004tab3Bean.rentCondNormal.rentPeriodType}"
                					disabled="#{semmsi004tab3Bean.disabledRent}" onchange="defaultRentPayPeriodType();"> 
									<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
									</h:selectOneMenu>
									<script type="text/javascript">
									function defaultRentPayPeriodType(){
									var periodType = document.getElementById("incContent:frmAddSiteInfo:incTab3:ddlRentalPeriodType").value;
									var payPeriodType01 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType01:0");
									var payPeriodType02 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType02:0");
									var payPeriodType03 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType03:0");
									var payPeriodType04 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType04:0");
									var payPeriodType05 = document.getElementById("incContent:frmAddSiteInfo:incTab3:rbtPayPeriodType05:0");
									var year = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtPayPeriodTypeYear");
									var month = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtPayPeriodTypeMonth");
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
									CalRentAddPercentAndRentAddAmt();
								}
							</script>
				                	</td>
			                	 </tr>
			                	 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" align="left" colspan="3">
		                			<table width="100%" border="0" cellspacing="0">
		                			 <tr>
		                			 <td width="63%" align="left">
		                			 <h:selectOneRadio id="rbtWhtTypeNormalRent" value="#{semmsi004tab3Bean.rentCondNormal.whtType}"  
		                			 styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledRent}" onclick="ClearWhtRateJS();">
	                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']} " />
	                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}"/>
	                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']} " />
	                				</h:selectOneRadio>
	                				<a4j:jsFunction name="ClearWhtRateJS"  action="#{semmsi004tab3Action.clearWhtRate}"  reRender="txtWhtRateNormal,chkWhtRateNormal"/>
		                			 </td>
		                			<td width="37%" align="left">
		                			 <h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
									<rich:spacer width="2"></rich:spacer>
		                			<h:inputText id="txtWhtRateNormal" value="#{semmsi004tab3Bean.rentCondNormal.whtRate}" 
		                			size="5" disabled="#{semmsi004tab3Bean.disabledWhtRateNormal}"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<h:outputText value="%" styleClass="ms7"/>
		                			<rich:spacer width="2"></rich:spacer>
		                			<h:selectBooleanCheckbox id="chkWhtRateNormal"  styleClass="ms7" onclick="RenderWhtRateNormalJS();" 
		                			value="#{semmsi004tab3Bean.chkWhtRateNormal}" disabled="#{semmsi004tab3Bean.disabledRent}"/>
	                				<h:outputText value="#{jspMsg['label.edit']}"  styleClass="ms7"/>
	                				<a4j:jsFunction name="RenderWhtRateNormalJS" reRender="txtWhtRateNormal" 
	                				action="#{semmsi004tab3Action.renderWhtRateNormal}" />
		                			 </td>
		                			 </tr>
		                			 </table>
		                			 </td>
		                			 </tr>
		                			 <h:panelGroup  rendered="#{semmsi004tab3Bean.renderedNormalVatType}">
		                			 <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3" align="left">
		                			<h:selectOneRadio id="rbtVatType" value="#{semmsi004tab3Bean.rentCondNormal.vatType}"  
		                			styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledRent}">
	                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
	                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
	                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
	                				<f:selectItem itemValue="" itemLabel="#{jspMsg['label.vatType00']} "/>
	                				</h:selectOneRadio>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
			                	  <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.payPeriodType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" align="left" colspan="3">
		                			<h:panelGrid columns="5">
		                			<h:panelGroup>
			                			<h:selectOneRadio id="rbtPayPeriodType01" value="#{semmsi004tab3Bean.payPeriodType01}"  styleClass="ms7" rendered="true"
			                			onclick="setPayPeriodType01();" disabled="#{semmsi004tab3Bean.disabledRent}">
		                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.payPeriodType01']} " />
		                				 <a4j:jsFunction name="setPayPeriodType01" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
							        	<a4j:actionparam  name="payPeriodType" value="01"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
	                				</h:panelGroup>
	                				<h:panelGroup>
			                			<h:selectOneRadio id="rbtPayPeriodType02" value="#{semmsi004tab3Bean.payPeriodType02}"  styleClass="ms7" rendered="true"
			                			onclick="setPayPeriodType02();" disabled="#{semmsi004tab3Bean.disabledRent}">
		                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.payPeriodType02']}"/>
		                				<a4j:jsFunction name="setPayPeriodType02" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
							        	<a4j:actionparam  name="payPeriodType" value="02"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
	                				</h:panelGroup>
	                				<h:panelGroup>
	                				<table>
	                					<tr> 
	                					<td>
	                					<h:selectOneRadio id="rbtPayPeriodType03" value="#{semmsi004tab3Bean.payPeriodType03}"  styleClass="ms7" rendered="true"
	                					onclick="setPayPeriodType03();" disabled="#{semmsi004tab3Bean.disabledRent}">
		                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.payPeriodType03']} " />
		                				<a4j:jsFunction name="setPayPeriodType03" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
							        	<a4j:actionparam  name="payPeriodType" value="03"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
		                				</td>
		                				<td>
		                				<h:inputText id="txtPayPeriodTypeMonth" size="5"  disabled="#{semmsi004tab3Bean.disabledPayPeriod03}"
		                				value="#{semmsi004tab3Bean.payPeriod03}" styleClass="inputRight"
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
	                					<h:selectOneRadio id="rbtPayPeriodType04" value="#{semmsi004tab3Bean.payPeriodType04}"  styleClass="ms7" rendered="true"
	                					onclick="setPayPeriodType04();" disabled="#{semmsi004tab3Bean.disabledRent}">
		                				<f:selectItem itemValue="04" itemLabel="#{jspMsg['label.payPeriodType03']} " />
		                				<a4j:jsFunction name="setPayPeriodType04" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
							        	<a4j:actionparam  name="payPeriodType" value="04"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
		                				</td>
		                				<td>
		                				<h:inputText id="txtPayPeriodTypeYear" size="5"  disabled="#{semmsi004tab3Bean.disabledPayPeriod04}"
		                				value="#{semmsi004tab3Bean.payPeriod04}" styleClass="inputRight"
		                				onkeypress="return numberformat.keyPressIntegerOnly(this, event);"/>
		                				<rich:spacer width="5"></rich:spacer>
		                				<h:outputText value="#{jspMsg['label.year']}" styleClass="ms7"></h:outputText>
		                				</td>
		                				</tr>
		                				</table>
		                			</h:panelGroup>
		                			<h:panelGroup>
	                					<h:selectOneRadio id="rbtPayPeriodType05" value="#{semmsi004tab3Bean.payPeriodType05}"  styleClass="ms7" rendered="true"
	                					onclick="setPayPeriodType05();" disabled="#{semmsi004tab3Bean.disabledRent}">
		                				<f:selectItem itemValue="05" itemLabel="#{jspMsg['label.payPeriodType05']} " />
		                				<a4j:jsFunction name="setPayPeriodType05" action="#{semmsi004tab3Action.renderPayPeriodType}" 
		                				 reRender="rbtPayPeriodType01,rbtPayPeriodType02,rbtPayPeriodType03,rbtPayPeriodType04,rbtPayPeriodType05,txtPayPeriodTypeMonth,txtPayPeriodTypeYear">
							        	<a4j:actionparam  name="payPeriodType" value="05"></a4j:actionparam>
							        	</a4j:jsFunction>
		                				</h:selectOneRadio>
		                			</h:panelGroup>
	                				
	                				</h:panelGrid>
	                				</td>
			                	 </tr>
			                	 <h:panelGroup rendered="#{semmsi004tab3Bean.renderedEffDate}">
			                	 <tr>
									<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.effectiveDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<rich:calendar id="cldEffDate2" locale="th" enableManualInput="true"
									datePattern="dd/MM/yyyy" 
									value="#{semmsi004tab3Bean.rentCondNormal.effectiveDt}" 
									showWeeksBar="false"
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.effectiveDate']}"
									disabled="#{semmsi004tab3Bean.disabledRent}">
									</rich:calendar>
		                			</td>
		                			</tr>
		                		</h:panelGroup>
		                		<tr>
									<td align="right" width="25%">
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectBooleanCheckbox id="chkRentOverFlag" value="#{semmsi004tab3Bean.chkOverFlag}" styleClass="ms7"
		                			disabled="#{semmsi004tab3Bean.disabledRent}" rendered="false"/>
						             <h:outputText value="#{jspMsg['label.overFlag']}" styleClass="ms7" rendered="false"/>
				                	</td>
			                	 </tr>
		                		<tr>
			                	 <td colspan="2" width="100%">
			                	 <h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
			                	<a4j:commandButton id="btnAddRentCond" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlRentCond,pnlResultSearchRentCondAndService,dtbRentCond,pnlResultSearchRentCond,pnlRentCond,pnlSumRent,ddlRentDepositExpenseType" 
				           		disabled="#{semmsi004tab3Bean.disabledBtnAddRentCond}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doAddRentCond" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
				           		<a4j:commandButton id="btnSaveRentCond" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" 
				           		reRender="pnlRentCond,pnlResultSearchRentCondAndService,dtbRentCond,pnlResultSearchRentCond,pnlRentCond,pnlSumRent,ddlRentDepositExpenseType" 
				           		disabled="#{semmsi004tab3Bean.disabledBtnUpdateRentCond}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateRentCond" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
			                	 <a4j:commandButton id="btnCancelRentCond" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlResultSearchRentCondAndService,dtbRentCond,pnlResultSearchRentCond,frmSiteInfoError,pnlRentCond" 
				           		disabled="#{semmsi004tab3Bean.disabledRent or semmsi004Bean.disabledModeView}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doClearRentCond" />
				           		</a4j:commandButton>
				           		</h:panelGroup>
			                	 </td>
			                	 </tr>
							</table>
							</h:panelGroup>
							</td>
							</tr>
							<!-- row for rentCond special -->
							<tr>
							<td>
							 
							</td>
							</tr>
							</table>
							</h:panelGroup>
							</h:panelGrid>
					</rich:panel>
					</h:panelGrid>
					
					<!-- panel RentCond and Service -->
					<h:panelGrid id="pnlResultSearchRentCond" width="90%" >
						<h:panelGroup rendered="#{semmsi004tab3Bean.renderDataTableRentCond}">
						<rich:panel id="pnlResultSearchRentCondAndService"  styleClass="sem_autoScrollbar_5Rows"  >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.resultRentAndService']}" style="width:1420"/>
						</f:facet>
						<!-- datatable -->
						<rich:dataTable id="dtbRentCond" width="95%"  cellpadding="1" cellspacing="0" border="0"
							var="rentCondSP"  value="#{semmsi004tab3Bean.rentCondSPList}" reRender="dtbRentCond" 
							rows="#{semmsi004tab3Bean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbRentCond">
								<a4j:actionparam name="rowId" value="#{rentCondSP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlRentCondNormal"
	            					image="images/edit.png" style="height: 15; width: 15" 
	            					rendered="#{semmsi004tab3Bean.editableRentFlag == 'Y'}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateRentCond" />
										<a4j:actionparam name="rowId" value="#{rentCondSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelRentCondDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
     									   rendered="#{rentCondSP.renderedButtonDelete}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteRentCond" />
										<a4j:actionparam name="rowId" value="#{rentCondSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.expenseTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header" >
									<h:outputText value="#{jspMsg['header.column.type']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCondSP.expenseTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.placeName}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.placeName']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentCondSP.placeName}" styleClass="contentform" ></h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.detail}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.detail']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{rentCondSP.detail}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.rentOldAmt}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentOldAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCondSP.rentOldAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.rentAddPercent}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAddPercent']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCondSP.rentAddPercent}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.rentAddAmt}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAddAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCondSP.rentAddAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>		
							<rich:column sortBy="#{rentCondSP.rentAmt}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentAmt']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCondSP.rentAmt}" styleClass="contentform">
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column sortBy="#{rentCondSP.rentPeriodTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.rentPeriodTypeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCondSP.rentPeriodTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>		
							<rich:column sortBy="#{rentCondSP.whtTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.whtTypeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCondSP.whtTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{rentCondSP.whtRate}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.whtRate']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{rentCondSP.whtRate}" styleClass="contentform"  />
								</div>
							</rich:column>	
							<rich:column sortBy="#{rentCondSP.vatTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="VAT(#{semmsi004tab3Bean.columnVatRate}%)" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCondSP.vatTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.payPeriodTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.payPeriodTypeName']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCondSP.payPeriodTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{rentCondSP.effDate}" styleClass="#{(semmsi004Bean.tmpRowId==rentCondSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.effDate']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{rentCondSP.effDate}" styleClass="contentform">
									<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="3">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi004tab3Bean.rentCondSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="13">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbRentCond"
											maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstRentCond" 
											style="background-color: #cccccc;"
											page="#{semmsi004tab3Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
					</h:panelGroup>
					 </h:panelGrid>
					 <!-- Panel Special -->
					 <h:panelGrid width="95%">
					 	<h:panelGroup >
							<rich:simpleTogglePanel switchType="client" label="#{jspMsg['header.panel.renCondSpecial']}" opened="true" width="100%">
								<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
									<h:panelGroup id="pnlRentCondSpecial" >
									  <table width="100%" id="tableRentCondSpecial">
					                	 <tr>
											<td align="right" width="25%" valign="top" style="text-decoration: underline">
											<h:outputText value="#{jspMsg['label.detail']}" styleClass="ms7"/>
				                			</td>
				                			<td colspan="3" width="75%" align="left">
				                			<h:inputTextarea id="txtRentCondSpecialDetail" value="#{semmsi004tab3Bean.rentCondSpecial1.detail}" 
				                			cols="100" rows="3" disabled="#{semmsi004tab3Bean.disabledRent}" onblur="renderImgRequireTotalAgeRentAmt();"/>
				                			<script type="text/javascript">
											function renderImgRequireTotalAgeRentAmt(){
												var detail = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtRentCondSpecialDetail").value;
												var img = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalAgeRentAmt");
												if(detail == ''){
													img.style.display = 'none';
												}else{
													img.style.display = '';
												}
											}
											</script>
						                	</td>
					                	 </tr>
					                	  <tr>
											<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
				                			</td>
				                			<td width="75%" align="left" colspan="3">
				                			<table width="100%" border="0" cellspacing="0">
				                			 <tr>
				                			 <td width="63%" align="left">
				                			<h:selectOneRadio id="rbtRentCondSpecialWhtType" value="#{semmsi004tab3Bean.rentCondSpecial1.whtType}"  
				                			styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledRent}"
				                			onclick="ClearWhtRateRentSpecialJS();">
			                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.whtType01']} " />
			                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.whtType02']}"/>
			                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.whtType03']} " />
			                				</h:selectOneRadio>
			                				<a4j:jsFunction name="ClearWhtRateRentSpecialJS"  action="#{semmsi004tab3Action.clearWhtRateRentSpecial}" 
			                				 reRender="txtWhtRateRentSpecial, chkWhtRateRentSpecial"/>
				                			 </td>
				                			<td width="37%" align="left">
				                			<h:outputText value="#{jspMsg['label.whtType']}" styleClass="ms7"/>
											<rich:spacer width="2"></rich:spacer>
				                			<h:inputText id="txtWhtRateRentSpecial" value="#{semmsi004tab3Bean.rentCondSpecial1.whtRate}" size="5" 
				                			disabled="#{semmsi004tab3Bean.disabledWhtRateRentSpecial}"
				                			onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
				                			onblur="return numberformat.moneyFormat(this);"
				              				onfocus="return numberformat.setCursorPosToEnd(this);" style="text-align: right;">
				                			<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
				                			</h:inputText>
				                			<rich:spacer width="2"></rich:spacer>
				                			<h:outputText value="%" styleClass="ms7"/>
				                			<rich:spacer width="2"></rich:spacer>
				                			<h:selectBooleanCheckbox id="chkWhtRateRentSpecial"  styleClass="ms7" onclick="RenderWhtRateRentSpecialJS();" 
				                			value="#{semmsi004tab3Bean.chkWhtRateRentSpecial}" disabled="#{semmsi004tab3Bean.disabledRent}"/>
			                				<h:outputText value="#{jspMsg['label.edit']}"  styleClass="ms7"/>
			                				<a4j:jsFunction name="RenderWhtRateRentSpecialJS" reRender="txtWhtRateRentSpecial" 
			                				action="#{semmsi004tab3Action.renderWhtRateRentSpecial}"/>
				                			 </td>
				                			 </tr>
				                			 </table>
						                	</td>
					                	 </tr>
					                	 <tr>
											<td align="right" width="25%">
											<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
				                			</td>
				                			<td width="75%" colspan="3">
				                			<h:selectOneRadio id="rbtRentCondSpecialVatTypeService" value="#{semmsi004tab3Bean.rentCondSpecial2.vatType}"  
				                			styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledRent}">
			                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
			                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
			                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
			                				</h:selectOneRadio>
				                			</td>
				                			</tr>
					                	 </table>
									 </h:panelGroup>
								</h:panelGrid>
							</rich:simpleTogglePanel>
							</h:panelGroup>
						</h:panelGrid>
					<!-- panel sum rent -->
					<rich:panel id="pnlSumRent" >
							<div align="left">
								<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgFormMiddle}"/>
							</div>
							<h:panelGrid width="95%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRent}">
	                		<tr>
							<td align="right" width="15%">
							<h:outputText value="#{jspMsg['label.rentAddAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="33%">
                			 <h:inputText id="txtRentAddAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalRentAddAmt}" size="18" 
	   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	   						 onblur="return numberformat.moneyFormat(this);"
	   						 onfocus="return numberformat.setCursorPosToEnd(this);"
	   						 maxlength="16" 
	   						 styleClass="inputRight"
	   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
              				<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalRentAddPeriodType" value="#{semmsi004tab3Bean.totalRent.totalRentAddPeriodType}"
              				disabled="#{semmsi004tab3Bean.disabledRent  or semmsi004tab3Bean.disabledTotalNormalRent}"> 
							<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.serviceAddAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			<h:inputText id="txtServiceAddAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalServiceAddAmt}" size="18" 
	   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	   						 onblur="return numberformat.moneyFormat(this);"
	   						 onfocus="return numberformat.setCursorPosToEnd(this);"
	   						 maxlength="16" 
	   						 styleClass="inputRight"
	   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalServiceAddPeriodType" value="#{semmsi004tab3Bean.totalRent.totalServiceAddPeriodType}"
              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}"> 
							<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="15%">
							<h:outputText value="#{jspMsg['label.rentAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="33%">
                			 <h:inputText id="txtRentAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalRentAmt}" size="18" 
	   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	   						 onblur="return numberformat.moneyFormat(this);"
	   						 onfocus="return numberformat.setCursorPosToEnd(this);"
	   						 maxlength="16" 
	   						 styleClass="inputRight"
	   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalRentPeriodType" value="#{semmsi004tab3Bean.totalRent.totalRentPeriodType}"
              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}"> 
							<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.serviceAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			 <h:inputText id="txtServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalServiceAmt}" size="18" 
	   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	   						 onblur="return numberformat.moneyFormat(this);"
	   						 onfocus="return numberformat.setCursorPosToEnd(this);"
	   						 maxlength="16" 
	   						 styleClass="inputRight"
	   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalServicePeriodType" value="#{semmsi004tab3Bean.totalRent.totalServicePeriodType}"
              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}"> 
							<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
	                		
	                		<tr>
	                		<td align="right" width="15%">
							<h:outputText value="#{jspMsg['label.rentServiceAmt']}" styleClass="ms7BlueBold"/>
                			</td>
                			<td width="85%" colspan="3">
                			 <h:inputText id="txtRentServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalRentServiceAmt}" size="18" 
	   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	   						 onblur="return numberformat.moneyFormat(this);"
	   						 onfocus="return numberformat.setCursorPosToEnd(this);"
	   						 maxlength="16" 
	   						 styleClass="inputRight"
	   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="/" styleClass="ms7"/>
                			<rich:spacer width="2"></rich:spacer>
              				<h:selectOneMenu id="ddlTotalRentServicePeriodType" value="#{semmsi004tab3Bean.totalRent.totalRentServicePeriodType}"
              				disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}"> 
							<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
							</h:selectOneMenu>
		                	</td>
	                		</tr>
	                		<tr>
							<td align="right" width="15%">
                			</td>
                			<td width="33%">
		                	</td>
		                	<td align="right" width="20%">
							<h:graphicImage id="imgRequireTotalAgeRentAmt" value="images/icon_required.gif" 
							style="#{(not(semmsi004tab3Bean.rentCondSpecial1.detail eq '') and semmsi004tab3Bean.rentCondNormal.rentCondType eq '02') ? '':'display:none;'}"/>
							<rich:spacer width="2"></rich:spacer>
							<h:outputText value="#{jspMsg['label.totalAgeRentAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			 <h:inputText id="txtTotalAgeRentAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeRentAmt}" 
        						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
        						 onblur="SumTotalRentServiceAmtJS();return numberformat.moneyFormat(this);"
        						 onfocus="return numberformat.setCursorPosToEnd(this);"
        						 maxlength="16" 
        						 styleClass="inputRight"
        						 size="18"
        						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="15%">
                			</td>
                			<td width="33%">
		                	</td>
		                	<td align="right" width="20%">
							<h:graphicImage id="imgRequireTotalAgeServiceAmt" value="images/icon_required.gif" 
							style="#{(not(semmsi004tab3Bean.rentCondSpecial2.detail eq '') and semmsi004tab3Bean.rentCondNormal.rentCondType eq '02') ? '':'display:none;'}"/>
							<rich:spacer width="2"></rich:spacer>
							<h:outputText value="#{jspMsg['label.totalAgeServiceAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			 <h:inputText id="txtTotalAgeServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeServiceAmt}" 
       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
       						 onblur="SumTotalRentServiceAmtJS();return numberformat.moneyFormat(this);"
       						 onfocus="return numberformat.setCursorPosToEnd(this);"
       						 maxlength="16" 
       						 styleClass="inputRight"
       						 size="18"
       						 disabled="#{semmsi004tab3Bean.disabledTotalNormalRent}">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
                			</h:inputText>
                			<a4j:jsFunction name="SumTotalRentServiceAmtJS" reRender="txtTotalAgeRentServiceAmtTab3" 
                			action="#{semmsi004tab3Action.calTotalAgeServiceAmt}"/>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		
	                		<tr>
							<td align="right" width="15%">
                			</td>
                			<td width="33%">
		                	</td>
		                	<td align="right" width="20%">
							<h:outputText value="#{jspMsg['label.totalAgeRentServiceAmt']}" styleClass="ms7"/>
                			</td>
                			<td width="32%">
                			 <h:inputText id="txtTotalAgeRentServiceAmtTab3" value="#{semmsi004tab3Bean.totalRent.totalAgeRentServiceAmt}" size="18" 
	   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	   						 onblur="return numberformat.moneyFormat(this);"
	   						 onfocus="return numberformat.setCursorPosToEnd(this);"
	   						 maxlength="16" 
	   						 styleClass="inputRight"
	   						 disabled="true">
							<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	              			</h:inputText>
	              			<rich:spacer width="2"></rich:spacer>
                			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
		                	</td>
	                		</tr>
	                		
	                		</h:panelGroup>
	                		<tr>
		               		<td align="right" width="15%">
		             		</td>
		             		<td width="85%" colspan="3">
		             		<h:selectBooleanCheckbox id="chkNoRent" value="#{semmsi004tab3Bean.chkNoRent}" styleClass="ms7"
							disabled="#{semmsi004tab3Bean.disabledChkNoRent}" onclick="RenderNoRentJS();"/>
		                	<h:outputText value="#{jspMsg['label.noRent']}" styleClass="ms7" />
		                	<a4j:jsFunction name="RenderNoRentJS" reRender="pnlRent,pnlRentCond,pnlSumRent,pnlResultSearchRentCond" 
			                	action="#{semmsi004tab3Action.renderedNoRent}"/>
		              		</td>
		               		</tr>
	                		<tr>
	                		<td colspan="4" align="left">
	                		 <a4j:commandButton id="btnSaveTotalRent" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlSumRent,pnlRentCond" rendered="#{!semmsi004tab3Bean.disabledRent}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doSaveTotalRent" />
				           		</a4j:commandButton>
	                		</td>
	                		</tr>
							</table>
							</h:panelGroup>
							</h:panelGrid>
						</rich:panel>
						 </a4j:region>
						 
						 <!-- region deposit rentCond -->
					<a4j:region id="rgnDepositRentCond">
						<h:panelGrid id="pnlAddDeposit" width="95%" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}">
						<rich:panel id="pnlRentDeposit" >
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.rentDeposit']}"/>
						</f:facet>
						<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgFormBottom}"/>
						</div>
						<h:panelGroup>
							<table width="97%" id="tableRentDepositCondition">
			                	  <tr>
			                	  <td colspan="2">
			                	  <h:panelGroup id="pnlRentDepositNormal"  >
			                	  <table id="tableRentDepositNormal" width="100%">
			                	  
			                	  <tr>
			                	  <td width="25%" align="right">
			                	  	<h:outputText value="#{jspMsg['label.depositType']}" styleClass="ms7"/>
			                	  </td>
			                	  <td width="75%" colspan="3">
			                	  	<h:selectOneRadio id="rbtDepositType" value="#{semmsi004tab3Bean.siteDepositNormal.depositType}"  
			                	   		styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledDepositRent}"
			                	   		onclick="RenderedDepositNormalVatTypeJS();">
	                					<f:selectItem itemValue="01" itemLabel="BG" />
	                					<f:selectItem itemValue="02" itemLabel="Cash"/>
	                				</h:selectOneRadio>
	                				<a4j:jsFunction name="RenderedDepositNormalVatTypeJS" reRender="pnlRentDepositNormal" 
	                					action="#{semmsi004tab3Action.renderedDepositNormalVatType}"/>
			                	  </td>
			                	  </tr>
			                	  </td>
			                	  <tr>
			                	  <td width="25%" align="right">
			                	  <h:graphicImage value="images/icon_required.gif"/>
								  <rich:spacer width="5"></rich:spacer>
			                	  <h:outputText value="#{jspMsg['label.expendType']}" styleClass="ms7"/>
			                	  </td>
			                	  <td width="75%" colspan="3">
			                	  <h:selectOneMenu id="ddlRentDepositExpenseType" value="#{semmsi004tab3Bean.siteDepositNormal.expenseType}"
			                	  disabled="#{semmsi004tab3Bean.disabledDepositRent}" onchange="RenderedVatTypeJS();"> 
										<f:selectItems value="#{semmsi004tab3Bean.expenseTypeDepositRentList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="RenderedVatTypeJS" reRender="pnlRentDepositNormal" 
	                				action="#{semmsi004tab3Action.renderedVatType}"/>
			                	  </td>
			                	  </tr>
			                	  <tr>
			                	  <td width="25%" align="right">
			                	  <h:graphicImage value="images/icon_required.gif"/>
								  <rich:spacer width="5"></rich:spacer>
			                	  <h:outputText value="#{jspMsg['label.depositAmt']}" styleClass="ms7"/>
			                	  </td>
			                	  <td width="75%" colspan="3">
			                	  <h:inputText id="txtDepositAmtTab3" value="#{semmsi004tab3Bean.siteDepositNormal.depositAmt}" size="18" 
	       						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
	       						 onblur="return numberformat.moneyFormat(this);"
	       						 onfocus="return numberformat.setCursorPosToEnd(this);"
	       						 maxlength="16" 
	       						 styleClass="inputRight"
	       						 disabled="#{semmsi004tab3Bean.disabledDepositRent}">
								<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
	                			</h:inputText>
			                	  </td>
			                	  </tr>
			                	  <h:panelGroup rendered="#{semmsi004tab3Bean.renderedDeposiNormalVatType}">
			                	   <tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3" align="left">
		                			<h:selectOneRadio id="rbtRentDepositVatType" value="#{semmsi004tab3Bean.siteDepositNormal.vatType}"  
		                			styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledDepositRent}">
	                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
	                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
	                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
	                				</h:selectOneRadio>
				                	</td>
			                	 </tr>
			                	</h:panelGroup>
			                	  <tr>
			                	  <td width="25%" align="right" valign="top">
			                	  <h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
			                	  </td>
			                	  <td width="75%" colspan="3">
			                	  <h:inputTextarea id="txtDepositRemark" value="#{semmsi004tab3Bean.siteDepositNormal.remark}" 
			                	  cols="100" rows="3" disabled="#{semmsi004tab3Bean.disabledDepositRent}"/>
			                	  </td>
			                	  </tr>
			                	   <tr>
			                	  <td width="25%" align="right">
			                	  </td>
			                	  <td width="75%" colspan="3">
				                	   <h:selectBooleanCheckbox id="chkOldMoneyInsuranceTab3" value="#{semmsi004tab3Bean.siteDepositNormal.chkNewStatus}" 
							           styleClass="ms7" disabled="#{semmsi004tab3Bean.disabledDepositRent or semmsi004tab3Bean.disabledOldInsurance}"/>
							           <rich:spacer width="5"></rich:spacer>
					                   <h:outputText value="#{jspMsg['label.oldMoneyInsurance']}" styleClass="ms7" />
			                	  </td>
			                	  </tr>
			                	  <tr>
			                	  <td colspan="4">
			                	 <h:panelGroup id="pnlBtnDepositNormal" rendered="#{semmsi004Bean.renderedModeView}">
			                	<a4j:commandButton id="btnAddDepositNormal" value="#{jspMsg['btn.add']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlRentDeposit,pnlDeposit,pnlAddDeposit,tableRentDepositCondition,dtbDepositRentBG,dtbDepositRentCash"  
				           		disabled="#{semmsi004tab3Bean.disabledBtnAddDepositNormal}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doAddDepositNormal" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
				           		<a4j:commandButton id="btnUpdateDepositDepositNormal" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlRentDeposit,pnlDeposit,pnlAddDeposit,tableRentDepositCondition,dtbDepositRentBG,dtbDepositRentCash" 
				           		disabled="#{semmsi004tab3Bean.disabledBtnUpdateDepositNormal}">
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doUpdateDepositNormal" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
			                	 <a4j:commandButton id="btnClearDepositRentNormal" value="#{jspMsg['btn.clear']}" styleClass="rich-button" 
				           		action="#{navAction.navi}" reRender="pnlDeposit,pnlAddDeposit,tableRentDepositCondition,pnlRentDeposit,dtbDepositRentBG,dtbDepositRentCash"
				           		disabled="#{semmsi004tab3Bean.disabledDepositRent or semmsi004Bean.disabledModeView}" >
				           		<a4j:actionparam name="navModule" value="si" />
								<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
								<a4j:actionparam name="moduleWithNavi" value="si" />
								<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
								<a4j:actionparam name="methodWithNavi" value="doClearDepositNormal" />
				           		</a4j:commandButton>
				           		</h:panelGroup>
			                	  </td>
			                	  </tr>
			                	  </table>
			                	  </h:panelGroup>
			                	  </td>
			                	  </tr>
			                	  <tr>
			                	  <td colspan="2">
			                	  
			                	  </td>
			                	  </tr>
			                	 </table>
			            </h:panelGroup>
					</rich:panel>
					</h:panelGroup>
					 </h:panelGrid>
					<!-- panel BG -->
					<h:panelGrid id="pnlDeposit"  width="95%">
					<h:panelGroup rendered="#{semmsi004tab3Bean.renderDataTableDeposit}">
					<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}">
					<rich:panel id="pnlResultBG" >
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.panel.BG']}" />
						</f:facet>
							<rich:dataTable width="97%" id="dtbDepositRentBG"  cellpadding="1" cellspacing="0" border="0"
							var="depositRentBgSP" value="#{semmsi004tab3Bean.depositRentBgSPList}" reRender="dtbDepositRentBG" 
							rows="#{semmsi004tab3Bean.rowPerPage}"  rowClasses="cur" 	styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbDepositRentBG">
								<a4j:actionparam name="rowId" value="#{depositRentBgSP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlRentDeposit"
	            					image="images/edit.png" style="height: 15; width: 15"
	            					rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentBgSP.editableFlag == 'Y'}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateDepositNormal" />
										<a4j:actionparam name="rowId" value="#{depositRentBgSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDepositRentBgDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="width: 15; height : 15px;"
     									   rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentBgSP.deleteableFlag == 'Y'}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteDepositNormal" />
										<a4j:actionparam name="rowId" value="#{depositRentBgSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentBgSP.expenseTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.expenseType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{depositRentBgSP.expenseTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentBgSP.depositAmt}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.amount']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{depositRentBgSP.depositAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentBgSP.remark}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.remark']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{depositRentBgSP.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentBgSP.newStatusName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentBgSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.status']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{depositRentBgSP.newStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi004tab3Bean.depositRentBgSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="4">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositRentBG"
											maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstDepositRentBG" 
											style="background-color: #cccccc;"
											page="#{semmsi004tab3Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
				</rich:panel>
				
		<rich:spacer height="20"></rich:spacer>
					<!-- panel Cash -->
					<rich:panel id="pnlResultCash">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.panel.Cash']}" />
						</f:facet>
							<rich:dataTable width="97%" id="dtbDepositRentCash"  cellpadding="1" cellspacing="0" border="0"
							var="depositRentCashSP" value="#{semmsi004tab3Bean.depositRentCashSPList}" reRender="dtbDepositRentCash" 
							rows="#{semmsi004tab3Bean.rowPerPage}"	rowClasses="cur" styleClass="dataTable">
							<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbDepositRentCash">
								<a4j:actionparam name="rowId" value="#{depositRentCashSP.rowId}" />
							</a4j:support>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header" >
									<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton action="#{navAction.navi}" reRender="pnlRentDeposit"
	            					image="images/edit.png" style="height: 15; width: 15"
	            					rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentCashSP.editableFlag == 'Y'}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="initUpdateDepositNormal" />
										<a4j:actionparam name="rowId" value="#{depositRentCashSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}"
							rendered="#{semmsi004Bean.renderedModeView}">
								<f:facet name="header">
									<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
								</f:facet>
								<div align="center">
	            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelDepositRentCashDialog')}.show(); return false" 
     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
     									   rendered="#{semmsi004tab3Bean.editableDepositRentFlag == 'Y' and depositRentCashSP.deleteableFlag == 'Y'}">
										<a4j:actionparam name="navModule" value="si" />
		            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />	
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
										<a4j:actionparam name="methodWithNavi" value="initDeleteDepositNormal" />
										<a4j:actionparam name="rowId" value="#{depositRentCashSP.rowId}" />
	            					</a4j:commandButton>          							
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentCashSP.expenseTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.expenseType']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{depositRentCashSP.expenseTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentCashSP.depositAmt}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.amount']}" styleClass="contentform" />
								</f:facet>
								<div align="right">
									<h:outputText value="#{depositRentCashSP.depositAmt}" styleClass="contentform" >
									<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentCashSP.vatTypeName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="VAT" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{depositRentCashSP.vatTypeName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentCashSP.remark}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.remark']}" styleClass="contentform" />
								</f:facet>
								<div align="left">
									<h:outputText value="#{depositRentCashSP.remark}" styleClass="contentform"  />
								</div>
							</rich:column>
							<rich:column sortBy="#{depositRentCashSP.newStatusName}" styleClass="#{(semmsi004Bean.tmpRowId==depositRentCashSP.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['header.column.status']}" styleClass="contentform" />
								</f:facet>
								<div align="center">
									<h:outputText value="#{depositRentCashSP.newStatusName}" styleClass="contentform"  />
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:columnGroup>
									<rich:column colspan="2">
										<h:outputFormat value="#{msg['message.totalRecords']}">
											<f:param value="#{fn:length(semmsi004tab3Bean.depositRentCashSPList)}"></f:param>
										</h:outputFormat>
									</rich:column>
									<rich:column colspan="5">
										<rich:datascroller immediate="true" rendered="true" align="left" for="dtbDepositRentCash"
											maxPages="#{semmsi004tab3Bean.rowPerPage}"  selectedStyleClass="selectScroll"
											stepControls="hide" fastControls="auto" boundaryControls="auto" 
											id="dstDepositRentCash" 
											style="background-color: #cccccc;"
											page="#{semmsi004tab3Bean.scrollerPage}" 
										/>
									</rich:column>
								</rich:columnGroup>
							</f:facet>
						</rich:dataTable>
				</rich:panel>
				</h:panelGroup>
				</h:panelGroup>
				<rich:spacer height="10"></rich:spacer>
				<!-- Panel Special -->
					 <h:panelGrid width="95%">
					 	<h:panelGroup >
							<rich:simpleTogglePanel switchType="client" label="#{jspMsg['header.panel.renCondSpecial']}" opened="true" width="100%" rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}">
								<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
									  <h:panelGroup id="pnlRentDepositSpecial" >
			                	  <table id="tableRentDepositSpecial" width="100%">
			                	  <tr>
			                	  <td width="25%" align="right" valign="top" style="text-decoration: underline">
			                	  <h:outputText value="#{jspMsg['label.detailBg']}" styleClass="ms7"/>
			                	  </td>
			                	   <td width="75%" colspan="3">
			                	   <h:inputTextarea id="txtDepositDetailBg" value="#{semmsi004tab3Bean.siteDepositSpecialBg.detail}" 
			                	   cols="100" rows="3" disabled="#{semmsi004tab3Bean.disabledDepositRent}"
			                	   onblur="renderImgRequireTotalDepositBgAmt();"/>
			                	   <script type="text/javascript">
									function renderImgRequireTotalDepositBgAmt(){
										var detail = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtDepositDetailBg").value;
										var img = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalDepositBgAmt");
										if(detail == ''){
											img.style.display = 'none';
										}else{
											img.style.display = '';
										}
									}
									</script>
			                	  </td>
			                	  </tr>
			                	  <tr>
			                	  <td width="25%" align="right" valign="top" style="text-decoration: underline">
			                	  <h:outputText value="#{jspMsg['label.detailCash']}" styleClass="ms7"/>
			                	  </td>
			                	   <td width="75%" colspan="3">
			                	   <h:inputTextarea id="txtDepositDetailCash" value="#{semmsi004tab3Bean.siteDepositSpecialCash.detail}" 
			                	   cols="100" rows="3" disabled="#{semmsi004tab3Bean.disabledDepositRent}"
			                	   onblur="renderImgRequireTotalDepositCashAmt();"/>
			                	   <script type="text/javascript">
									function renderImgRequireTotalDepositCashAmt(){
										var detail = document.getElementById("incContent:frmAddSiteInfo:incTab3:txtDepositDetailCash").value;
										var img = document.getElementById("incContent:frmAddSiteInfo:incTab3:imgRequireTotalDepositCashAmt");
										if(detail == ''){
											img.style.display = 'none';
										}else{
											img.style.display = '';
										}
									}
									</script>
			                	  </td>
			                	  </tr>
			                	  <tr>
			                	  <td width="25%" align="right">
			                	  <h:outputText value="#{jspMsg['label.vatType']}" styleClass="ms7"/>
			                	  </td>
			                	   <td width="75%" colspan="3">
			                	   <h:selectOneRadio id="rbtRentDepositSpecialVatType" value="#{semmsi004tab3Bean.siteDepositSpecialCash.vatType}"  
			                	   styleClass="ms7" rendered="true" disabled="#{semmsi004tab3Bean.disabledDepositRent}">
	                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.vatType01']} " />
	                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.vatType02']}"/>
	                				<f:selectItem itemValue="03" itemLabel="#{jspMsg['label.vatType03']} " />
	                				<f:selectItem itemValue="00" itemLabel="#{jspMsg['label.vatType00']} " />
	                				</h:selectOneRadio>
			                	  </td>
			                	  </tr>
			                	  </table>
			                	  </h:panelGroup>
								</h:panelGrid>
							</rich:simpleTogglePanel>
							</h:panelGroup>
						</h:panelGrid>
				
				<rich:spacer height="10"></rich:spacer>
				<rich:panel>
				<h:panelGrid id="pnlTotalDepositRent" width="95%" border="0" cellpadding="0" cellspacing="1">
				<div align="left">
							<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmsi004tab3Bean.renderedMsgSumDeposit}"/>
				</div>
				<h:panelGroup>
					<table width="100%">
					<h:panelGroup rendered="#{semmsi004tab3Bean.renderedNoRentDeposit}">
               		<tr>
					<td align="right" width="15%">
					<h:graphicImage id="imgRequireTotalDepositBgAmt" value="images/icon_required.gif" 
					style="#{(not(semmsi004tab3Bean.siteDepositSpecialBg.detail eq '') and semmsi004tab3Bean.siteDepositNormal.depositCondType eq '02') ? '':'display:none;'}"/>
					<rich:spacer width="2"></rich:spacer>
					<h:outputText value="#{jspMsg['label.depositBgAmt']}" styleClass="ms7"/>
              			</td>
              			<td width="33%">
           			  	<h:inputText id="txtDepositBgAmtTab3" value="#{semmsi004tab3Bean.totalDeposit.totalDepositBgAmt}" size="18" 
   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
   						 onblur="return numberformat.moneyFormat(this);"
   						 onfocus="return numberformat.setCursorPosToEnd(this);"
   						 maxlength="16" 
   						 styleClass="inputRight"
   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalDeposit}">
						<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
              			</h:inputText>
              			 <rich:spacer width="5"></rich:spacer>
              			 <h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                	</td>
                	<td align="right" width="20%">
						<h:graphicImage id="imgRequireTotalDepositCashAmt" value="images/icon_required.gif" 
						style="#{(not(semmsi004tab3Bean.siteDepositSpecialCash.detail eq '') and semmsi004tab3Bean.siteDepositNormal.depositCondType eq '02') ? '':'display:none;'}"/>
						<rich:spacer width="2"></rich:spacer>
					<h:outputText value="#{jspMsg['label.depositCashAmt']}" styleClass="ms7"/>
              			</td>
              			<td width="32%">
              			<h:inputText id="txtDepositCashAmtTab3" value="#{semmsi004tab3Bean.totalDeposit.totalDepositCashAmt}" size="18" 
   						 onkeypress="return numberformat.keyPressDecimalOnly(this, event);"
   						 onblur="return numberformat.moneyFormat(this);"
   						 onfocus="return numberformat.setCursorPosToEnd(this);"
   						 maxlength="16" 
   						 styleClass="inputRight"
   						 disabled="#{semmsi004tab3Bean.disabledTotalNormalDeposit}">
						<f:convertNumber pattern="#,##0.00"  maxIntegerDigits="13" maxFractionDigits="2" />
              			</h:inputText>
              			<rich:spacer width="5"></rich:spacer>
              			<h:outputText value="#{jspMsg['label.baht']}" styleClass="ms7"/>
                	</td>
               		</tr>
               		</h:panelGroup>
               		<tr>
               		<td align="right" width="15%">
             		</td>
             		<td width="85%" colspan="3">
             		<h:selectBooleanCheckbox id="chkNoRentDeposit" value="#{semmsi004tab3Bean.chkNoRentDeposit}" styleClass="ms7"
					disabled="#{semmsi004tab3Bean.disabledChkNoDeposit}" onclick="RenderNoRentDepositJS();"/>
                	<h:outputText value="#{jspMsg['label.noDeposit']}" styleClass="ms7" />
                	<a4j:jsFunction name="RenderNoRentDepositJS" reRender="pnlAddDeposit, pnlDeposit, pnlTotalDepositRent" 
			        action="#{semmsi004tab3Action.renderedNoRentDeposit}"/>
              		</td>
               		</tr>
               		<tr>
               		<td colspan="4" align="left">
             		<a4j:commandButton id="btnSaveTotalDeposit" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="pnlTotalDepositRent,pnlAddDeposit,pnlRentDeposit" rendered="#{!semmsi004tab3Bean.disabledDepositRent}">
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004TAB3" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab3" />
					<a4j:actionparam name="methodWithNavi" value="doSaveTotalDeposit" />
	           		</a4j:commandButton>
               		</td>
               		</tr>
					</table>
					</h:panelGroup>
					</h:panelGrid>
					</rich:panel>
		</h:panelGrid>
		</a4j:region>
		</h:panelGrid>
