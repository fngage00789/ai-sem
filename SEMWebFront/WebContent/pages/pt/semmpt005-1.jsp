<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt005" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['header.name']}"/></f:facet>
		<h:panelGrid>
		<table width="100%" border="0">
			<tr><td></td>
			<td>
			<a4j:form id="frmError">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt005Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
			</td></tr>
			</table>
		</h:panelGrid>
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="88%">
				<a4j:form id="frmSearch">
					<rich:panel id="pnlSearchCriteria">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.criteria.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="95%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
								<td align="right" width="20%" valign="baseline">
				                	<h:panelGroup>
				                		<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
									</h:panelGroup>
									
		                			</td>
		                			<td colspan="3" width="80%" valign="bottom">
		                				<h:selectOneMenu id="ddlCompany" value="#{semmpt005Bean.mpt004Srch.company}" 
		                				 onchange="GetCompanyJS();">
											<f:selectItems value="#{semmpt005Bean.companyList}"/>
										</h:selectOneMenu>
										<a4j:jsFunction name="GetCompanyJS" reRender="companyDisplay"/>
										<rich:spacer width="10"></rich:spacer>
										<h:outputText id="companyDisplay" value="#{semmpt005Bean.mpt004Srch.company}" styleClass="ms28"/>
				                	</td>
							</tr>
							<tr>
				                	<td align="right" width="20%">
				                	<h:panelGroup>
										<h:outputText value="#{jspMsg['label.pTaxYearFrom']}" styleClass="ms7"/>
									</h:panelGroup>
									</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPTaxYearFrom" value="#{semmpt005Bean.mpt004Srch.pTaxYearFrom}" onchange="renderPtaxYearTo();">
											<a4j:jsFunction name="renderPtaxYearTo" reRender="ddlYearTo" action="#{semmpt005Action.doDefaultPtaxYearFrom}"/>
											<f:selectItems value="#{semmpt005Bean.pTaxYearFromList}"/>
										</h:selectOneMenu>
										<rich:spacer width="5"/>
										<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
										<rich:spacer width="5"/>
										<h:selectOneMenu id="ddlPTaxYearTo" value="#{semmpt005Bean.mpt004Srch.pTaxYearTo}">
											<f:selectItems value="#{semmpt005Bean.pTaxYearToList}"/>
										</h:selectOneMenu>
				                	</td>
				                	<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.periodFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPeriodFrom" value="#{semmpt005Bean.mpt004Srch.periodNoFrom}">
											<f:selectItems value="#{semmpt005Bean.periodFromList}"/>
										</h:selectOneMenu>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.to']}" styleClass="ms7"/>
										<rich:spacer width="5"></rich:spacer>
										<h:selectOneMenu id="ddlPeriodTo" value="#{semmpt005Bean.mpt004Srch.periodNoTo}">
											<f:selectItems value="#{semmpt005Bean.periodToList}"/>
										</h:selectOneMenu>
										
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtContractNo" value="#{semmpt005Bean.mpt004Srch.contractNo}" size="23" maxlength="20"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.picoFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox id="chkPicoFlag" value="#{semmpt005Bean.chkPayGovtFlag}"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.pTaxPayType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPTaxPayType" value="#{semmpt005Bean.mpt004Srch.pTaxPayType}">
											<f:selectItems value="#{semmpt005Bean.pTaxPayTypeList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.expenseType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlExpenseType" value="#{semmpt005Bean.mpt004Srch.expenseType}">
											<f:selectItems value="#{semmpt005Bean.expenseTypeList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.region']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlRegion" 
														 value="#{semmpt005Bean.mpt004Srch.regionIn}"
														 onchange="GetRegionJS();">
											
											<a4j:jsFunction name="GetRegionJS" reRender="ddlProvince" action="#{semmpt005Action.renderProvinceList}"/>
											<f:selectItems value="#{semmpt005Bean.regionList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.province']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlProvince" 
														 value="#{semmpt005Bean.mpt004Srch.province}"
														 onchange="GetSiteAmphurListJS(),GetGovtJS();">
											
											<a4j:jsFunction name="GetSiteAmphurListJS" reRender="ddlAmphur" action="#{semmpt005Action.renderAmphurList}"/>
											<a4j:jsFunction name="GetGovtJS" reRender="ddlGovt" action="#{semmpt005Action.renderGovtList}"/>
											<f:selectItems value="#{semmpt005Bean.provinceList}"/>
										</h:selectOneMenu>			
									</td>
									
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.amphur']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlAmphur" value="#{semmpt005Bean.mpt004Srch.amphur}">
											<f:selectItems value="#{semmpt005Bean.amphurList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.govtName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlGovt" value="#{semmpt005Bean.mpt004Srch.govtName}" >
											<f:selectItems value="#{semmpt005Bean.govtList}"/>	
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.estimateFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="optPTaxStatus" value="#{semmpt005Bean.mpt004Srch.estimateFlag}">
											<f:selectItem itemLabel="#{jspMsg['label.selectItem']}" itemValue="" />
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus1']}" itemValue="01" />
											<f:selectItem itemLabel="#{jspMsg['label.pTaxStatus2']}" itemValue="02" />											
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paygovtFlag']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectBooleanCheckbox value="#{semmpt005Bean.tmpPayGovtFlag}"></h:selectBooleanCheckbox>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="Vendor Code :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorCode" value="#{semmpt005Bean.mpt004Srch.vendorCode}"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="Vendor Name :" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtVendorName" value="#{semmpt005Bean.mpt004Srch.vendorName}" size="30" maxlength="255"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.payeeName']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPayeeName" value="#{semmpt005Bean.mpt004Srch.payeeName}" size="30" maxlength="255"/>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentStatus']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentStatus" value="#{semmpt005Bean.mpt004Srch.paymentStatus}">
											<f:selectItems value="#{semmpt005Bean.paymentStatusList}"/>
										</h:selectOneMenu>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentType']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:selectOneMenu id="ddlPaymentType" value="#{semmpt005Bean.mpt004Srch.paymentType}">
											<f:selectItems value="#{semmpt005Bean.paymentTypeList}"/>
										</h:selectOneMenu>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.chqDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldChqDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmpt005Bean.mpt004Srch.chqDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.chqDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldChqDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultChqDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldChqDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultChqDtFrom" />
											   </a4j:support>
										</rich:calendar>
										<rich:spacer width="5"/>
		                				<h:outputText value="(To) :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldChqDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmpt005Bean.mpt004Srch.chqDtTo}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 cellWidth="20px" cellHeight="20px"
										 label="#{jspMsg['column.header.chqDtTo']}">
										 
										 		<a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldChqDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultChqDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldChqDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultChqDtTo" />
											   </a4j:support>
										 </rich:calendar>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.transferDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldTransferDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmpt005Bean.mpt004Srch.transferDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.transferDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldTransferDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultTransferDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldTransferDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultTransferDtFrom" />
											   </a4j:support>
										</rich:calendar>
										<rich:spacer width="5"/>
		                				<h:outputText value="(To) :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldTransferDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmpt005Bean.mpt004Srch.transferDtTo}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 cellWidth="20px" cellHeight="20px"
										 label="#{jspMsg['column.header.transferDtTo']}"
										 >
										 	<a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldTransferDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultTransferDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldTransferDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultTransferDtTo" />
											   </a4j:support>
										 </rich:calendar>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentBy']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtPaymentBy" value="#{semmpt005Bean.mpt004Srch.paymentBy}" size="30" maxlength="255"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.paymentDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldPaymentDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmpt005Bean.mpt004Srch.paymentDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.paymentDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldPaymentDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultPaymentDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldPaymentDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultPaymentDtFrom" />
											   </a4j:support>
										</rich:calendar>
										<rich:spacer width="5"/>
		                				<h:outputText value="(To) :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldPaymentDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmpt005Bean.mpt004Srch.paymentDtTo}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 cellWidth="20px" cellHeight="20px"
										 label="#{jspMsg['column.header.paymentDtTo']}"
										 >
										 	<a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldPaymentDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultPaymentDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldPaymentDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultPaymentDtTo" />
											   </a4j:support>
										 </rich:calendar>
									</td>
							</tr>
							<tr>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.estBy']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<h:inputText id="txtEstimateBy" value="#{semmpt005Bean.mpt004Srch.estimateBy}" size="30" maxlength="255"/>
									</td>
									<td align="right" width="20%">
										<h:outputText value="#{jspMsg['label.estDtFrom']}" styleClass="ms7"/>
									</td>
									<td width="30%">
										<rich:calendar id="cldEstimateDtFrom" locale="th" 
											   enableManualInput="true" 
											   datePattern="dd/MM/yyyy" 
											   value="#{semmpt005Bean.mpt004Srch.estimateDtFrom}"
											   showWeeksBar="false" 
											   inputSize="13" 
											   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
											   cellWidth="20px" cellHeight="20px"
											   label="#{jspMsg['column.header.estimateDtFrom']}"
											   >
											   <a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldEstimateDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultEstimateDtFrom" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldEstimateDtTo">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultEstimateDtFrom" />
											   </a4j:support>
										</rich:calendar>
										<rich:spacer width="5"/>
		                				<h:outputText value="(To) :" styleClass="ms7"/>
		                				<rich:spacer width="5"/>
		                				<rich:calendar id="cldEstimateDtTo" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
			                			 value="#{semmpt005Bean.mpt004Srch.estimateDtTo}" 
			                			 inputSize="13" 
			                			 oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
										 cellWidth="20px" cellHeight="20px"
										 label="#{jspMsg['column.header.estimateDtTo']}"
										 >
										 		<a4j:support event="onchanged" action="#{navAction.navi}" ajaxSingle="true" reRender="cldEstimateDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultEstimateDtTo" />
											   </a4j:support>
											   <a4j:support event="oninputblur" action="#{navAction.navi}" reRender="cldEstimateDtFrom">
											   		<a4j:actionparam name="navModule" value="pt" />
													<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
													<a4j:actionparam name="moduleWithNavi" value="pt" />
													<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
													<a4j:actionparam name="methodWithNavi" value="doDefaultEstimateDtTo" />
											   </a4j:support>
										 </rich:calendar>
									</td>
							</tr>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdSearchCommand">
							<a4j:commandButton id="btnSearch" value="Search" styleClass="rich-button" action="#{navAction.navi}"
							reRender="frmError,pnlSearchResult">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
								<a4j:actionparam name="methodWithNavi" value="doSearch" />
							</a4j:commandButton>
							<a4j:commandButton id="btnClear" value="Clear" styleClass="rich-button"
 							 action="#{navAction.navi}" reRender="frmError,pnlSearchResult,pnlSearchCriteria">
								<a4j:actionparam name="navModule" value="pt" />
								<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
								<a4j:actionparam name="moduleWithNavi" value="pt" />
								<a4j:actionparam name="actionWithNavi" value="SEMMPT005" />
								<a4j:actionparam name="methodWithNavi" value="doClear" />	 		 
							</a4j:commandButton>
						</h:panelGrid>
					</rich:panel>
					</a4j:form>
				</h:panelGrid>
			
			<a4j:form id="frmSearchResult">	
				<!-- end content layout criteria -->
				<!-- begin content button-->
		
				
				<!-- end content button -->
				
				<!-- begin content layout data grid-->
				<h:panelGrid  width="90%">
					<rich:panel id="pnlSearchResult" styleClass="sem_autoScrollbar">
						<f:facet name="header" >
							<h:outputText value="#{jspMsg['header.resultTable.name']}" style="width: 3500"/>
						</f:facet>
						<div align="center">
							<h:outputLabel style="color:red;size:20px" value="#{semmpt005Bean.msgDataNotFound}" rendered="#{semmpt005Bean.renderedMsgDataNotFound}" />
						</div>
						 <rich:dataTable id="dtbMpt005Srch" cellpadding="1" cellspacing="0" border="0"
							var="mpt004SrchSP" value="#{semmpt005Bean.mpt004SrchList}" reRender="dstMpt005Srch" 
							rows="#{semmpt004Bean.rowPerPage}" styleClass="dataTable" rowClasses="cur">
							<a4j:support event="onRowClick"   action="#{semmpt004Action.getRowIdOnClick}" reRender="dtbMpt005Srch">
								<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.rowId}" />
							</a4j:support> 
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.contractNo}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.contractNo']}" styleClass="contentform" style="width:120px"/>
								</f:facet>
								<div align="center">
									<a4j:commandLink id="hypView" value="#{mpt004SrchSP.dataObj.contractNo}" 
										oncomplete="showViewSiteInfoPopup()"
										action="#{navAction.navi}" style="width:100">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT005-1" />
										<a4j:actionparam name="moduleWithNavi" value="common" />
										<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
										<a4j:actionparam name="methodWithNavi" value="initPopup" />
										<a4j:actionparam name="rowId" value="#{mpt004SrchSP.dataObj.siteInfoId}" />
									</a4j:commandLink>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.pTaxYear}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.pTaxYear']}" styleClass="contentform"  style="width:30px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.pTaxYear}" styleClass="contentform" >
										
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.paymentStatus}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentStatus']}"   styleClass="contentform" style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.paymentStatus}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.periodNo}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.periodNo']}" styleClass="contentform" style="width:12px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.periodNo}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.expenseType}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.expenseType']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.expenseType}" styleClass="contentform" />
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.vendorCode}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorCode']}" styleClass="contentform"  style="width:80px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.vendorCode}" styleClass="contentform" >
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.vendorName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vendorName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.vendorName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.payeeName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.payeeName']}" styleClass="contentform"  style="width:210px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.payeeName}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.excAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.excAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.excAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.whtAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.whtAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.whtAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.vatAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.vatAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.vatAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.chqAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.chqAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.diffAmt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.diffAmt']}" styleClass="contentform"  style="width:110px"/>
								</f:facet>
								<div align="right">
									<h:outputText value="#{mpt004SrchSP.dataObj.diffAmt}" styleClass="contentform">
										<f:convertNumber pattern="#,##0.00"/>
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.paymentTypeDesc}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.paymentType']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.paymentTypeDesc}" styleClass="contentform"/>
								</div>
							</rich:column>	
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.bankName}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankName']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.bankName}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.bankAccNo}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.bankAccNo']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.bankAccNo}" styleClass="contentform"/>
								</div>
							</rich:column>		
							<rich:column sortBy="#{mpt004SrchSP.dataObj.chqDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.chqDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.chqReceiveDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.chqReceiveDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.chqReceiveDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.transferDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.transferDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.transferDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.remark}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.remark']}" styleClass="contentform"  style="width:240px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.remark}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.exportFlag}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.exportFlag']}" styleClass="contentform"  style="width:6px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.exportFlag}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column sortBy="#{mpt004SrchSP.dataObj.exportDt}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.exportDt']}" styleClass="contentform"  style="width:100px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.exportDt}" styleClass="contentform">
										<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
									</h:outputText>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.docType}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.docType']}" styleClass="contentform"  style="width:150px"/>
								</f:facet>
								<div align="left">
									<h:outputText value="#{mpt004SrchSP.dataObj.docTypeDesc}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.doc68}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc68']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.doc68}" styleClass="contentform"/>
								</div>
							</rich:column>
							<rich:column  sortBy="#{mpt004SrchSP.dataObj.doc92}" styleClass="#{(semmpt004Bean.tmpRowId==mpt004SrchSP.dataObj.rowId)?'onClick':'unClick'}">
								<f:facet name="header">
									<h:outputText value="#{jspMsg['column.doc92']}" styleClass="contentform"  style="width:90px"/>
								</f:facet>
								<div align="center">
									<h:outputText value="#{mpt004SrchSP.dataObj.doc92}" styleClass="contentform"/>
								</div>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller immediate="true" rendered="true" align="left" for="dtbMpt005Srch" 
									maxPages="10" id="dstMpt005Srch" selectedStyleClass="selectScroll" 
									page="#{semmpt005Bean.scrollerPage}"/>
							</f:facet>
						</rich:dataTable>
					</rich:panel>
				</h:panelGrid>
				<!-- end content layout data grid -->
			</a4j:form>
		</h:panelGrid>
	</rich:panel>
</h:panelGrid>

