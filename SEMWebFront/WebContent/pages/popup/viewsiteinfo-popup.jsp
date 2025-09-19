<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.popup.viewSiteInfo"
	var="jspMsgViewSiteInfo" />
<rich:modalPanel id="popupViewSiteInfo"  height="800"  style="width:1024 px"
	autosized="false"><!-- 990  600 -->
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsgViewSiteInfo['header.popup']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left"><h:graphicImage value="images/ico_close.png"
				id="hidePopupViewSiteInfo" style="cursor:pointer" /> <rich:componentControl
				for="popupViewSiteInfo" attachTo="hidePopupViewSiteInfo"
				operation="hide" event="onclick" /></div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="popupFrmSearchViewSiteInfo">
		<h:panelGrid columnClasses="gridContent" width="100%"
			id="grdPopupSearchSiteInfoCriteria">
			<h:panelGrid width="100%">
				<h:panelGroup>
					<table width="100%" border="0" cellpadding="1" cellspacing="0">
						<tr valign="top">
						<td align="right" width="18%"><h:outputText
								value="#{jspMsgViewSiteInfo['label.contract_no']}"
								styleClass="#{popupViewSiteInfoBean.contractNoStyle}" /></td>
							<td align="left"><h:inputText id="txtcontractNo"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractNo}"
								size="22" maxlength="15" readonly="true"/></td>
							<td align="right" width="15%"><h:outputText
								value="#{jspMsgViewSiteInfo['label.reqType']} :"
								styleClass="#{popupViewSiteInfoBean.reqTypeNameStyle}"  /></td>
							<td align="left"><h:inputText id="txtReqTypeName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.reqTypeName}"
								size="22" maxlength="15" readonly="true"/></td>
							
							<td align="right" width="15%"><h:outputText
								value="#{jspMsgViewSiteInfo['label.title']} :" 
								styleClass="#{popupViewSiteInfoBean.titleStyle}"/></td>
							<td align="left"><h:inputText id="txtTitle"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.title}"
								readonly="true" size="22"/></td>
							
						</tr>
					
						<tr valign="top">
							<td align="right" valign="top">
							<h:outputText value="#{jspMsgViewSiteInfo['label.oldContractNo']}" 
							styleClass="#{popupViewSiteInfoBean.oldContractNoStyle}"/>
							</td>
							<td valign="top">
							<h:inputText id="txtOldConNo" value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.oldContractNo}" 	
										 size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right" width="15%" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner']}" 
								styleClass="#{popupViewSiteInfoBean.ownerStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea id="txtOwner"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.owner}"
								rows="3" cols="24" readonly="true" /></td>
							<td align="right" width="15%"><h:outputText
								value="#{jspMsgViewSiteInfo['label.contact_name']}"
								styleClass="#{popupViewSiteInfoBean.contactNameStyle}" /></td>
							<td align="left"><h:inputText id="txtContactName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contactName}"
								size="22" maxlength="15" readonly="true" /></td>
						</tr>
						
						<tr>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.site_name']}"
								styleClass="#{popupViewSiteInfoBean.siteNameStyle}" /></td>
							<td align="left"><h:inputText id="txtSiteName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.siteName}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right" valign="top"><h:outputText
								value="#{jspMsgViewSiteInfo['label.contact_tel']}"
								styleClass="#{popupViewSiteInfoBean.contactTelStyle}" /></td>
							<td align="left"><h:inputTextarea id="txtContactTel"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contactTel}"
								rows="2" cols="24" readonly="true" /></td>
						</tr>
						
						
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.location_id']}"
								styleClass="#{popupViewSiteInfoBean.locationIdStyle}" /></td>
							<td align="left"><h:inputText id="txtLocationId"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.locationId}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.lessor_name']}"
								styleClass="#{popupViewSiteInfoBean.lessorNameStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea id="txtLessorName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.lessorName}"
								rows="3" cols="24" readonly="true" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.contact_fax']}"
								styleClass="#{popupViewSiteInfoBean.contactFaxStyle}" /></td>
							<td align="left"><h:inputText id="txtContactFax"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contactFax}"
								size="22" maxlength="15" readonly="true" /></td>
						</tr>

						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.location_code']}"
								styleClass="#{popupViewSiteInfoBean.locationCodeStyle}" /></td>
							<td align="left"><h:inputText id="txtLocationCode"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.locationCode}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right" valign="top"><h:outputText
								value="#{jspMsgViewSiteInfo['label.rent_amt']}" 
								styleClass="#{popupViewSiteInfoBean.rentAmtStyle}" /></td>
							<td align="left"><h:panelGrid cellpadding="0" cellspacing="0" columns="5">
									<h:inputText id="txtRentAmt"
										value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentAmt}"
										size="10" maxlength="15" readonly="true" styleClass="inputRight">
										<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
											maxFractionDigits="2" />
									</h:inputText>
									<rich:spacer width="1px"/>
									<h:inputText id="txtPeriodType"
										value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentPayPeriod}"
										size="5" readonly="true">
									</h:inputText>
									
									<!--<h:selectBooleanCheckbox readonly="true" id="chkRentPayPeriodYear" disabled="true"
										value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkRentWhtTypeYear}" />
									<h:outputText style="width:34;"
										value="#{jspMsgViewSiteInfo['label.rent_pay_period_year']}"
										styleClass="ms7" />
									<h:selectBooleanCheckbox readonly="true" id="chkRentPayPeriodMonth"  disabled="true"
										value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkRentWhtTypeMonth}" />
									<h:outputText style="width:34;"
										value="#{jspMsgViewSiteInfo['label.rent_pay_period_month']}"
										styleClass="ms7" />
								--></h:panelGrid></td>
						</tr>
						
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.first_effective_dt']}"
								styleClass="#{popupViewSiteInfoBean.firstEffectiveDtStyle}" /></td>
							<td align="left"><h:inputText id="txtFirstEffectiveDt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.firsteffectiveDt}"
								size="22" maxlength="15" readonly="true">
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
							</h:inputText></td>
							<td align="right" valign="top" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_address']}"
								styleClass="#{popupViewSiteInfoBean.ownerAddressStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea
								id="txtOwnerAddress"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerAddress}"
								rows="3" cols="24" readonly="true" /></td>
							<td><rich:spacer width="5"></rich:spacer></td>
							<td align="left">
								<h:inputText id="txtChkRentWhtTypeStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkRentWhtTypeTaxStr}"
								size="22" maxlength="15" readonly="true" />
							</td>
						</tr>
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.effective_dt']}"
								styleClass="#{popupViewSiteInfoBean.effectiveDtStyle}" /></td>
							<td align="left"><h:inputText id="txtEffectiveDt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.effectiveDt}"
								size="22" maxlength="15" readonly="true">
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
							</h:inputText></td>
							
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.service_amt']}"
								styleClass="#{popupViewSiteInfoBean.serviceAmtStyle}" /></td>
							<td align="left"><h:panelGrid cellpadding="0" cellspacing="0" columns="5">
								<h:inputText id="txtServiceAmt"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.serviceAmt}"
									size="10" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
										maxFractionDigits="2" />
								</h:inputText>
								<rich:spacer width="1px"/>
									<h:inputText id="txtServicePeriodType"
										value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.servicePayPeriod}"
										size="5" readonly="true"></h:inputText></h:panelGrid></td>
						</tr>
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.expire_dt']}"
								styleClass = "#{popupViewSiteInfoBean.epDtStyle}"  /></td>
							<td align="left"><h:inputText id="txtExpireDt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.expireDt}"
								size="22" maxlength="15" readonly="true">
								<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
							</h:inputText></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_street']}"
								styleClass="#{popupViewSiteInfoBean.ownerStreetStyle}"/></td>
							<td align="left"><h:inputText id="txtOwnerStreet"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerStreet}"
								size="22" readonly="true"/>
								
								<!--<h:selectBooleanCheckbox readonly="true" id="chkServicePayPeriodYear"  disabled="true"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkServicePayPeriodYear}" />
								<h:outputText style="width:34;"
									value="#{jspMsgViewSiteInfo['label.service_pay_period_year']}"
									styleClass="ms7" />
								<h:selectBooleanCheckbox readonly="true" id="chkRentPayPeriod1"  disabled="true"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkServicePayPeriodMonth}" />
								<h:outputText style="width:34;"
									value="#{jspMsgViewSiteInfo['label.rent_pay_period_month']}"
									styleClass="ms7" />
							--></td>
							<td><rich:spacer width="5"></rich:spacer></td>
							<td align="left"><h:inputText id="txtChkServVatTypeStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkServiceVatTypeStr}"
								size="22" maxlength="15" readonly="true" />	
						</tr>
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.station_type']}"
								styleClass="#{popupViewSiteInfoBean.stationTypeStyle}"  /></td>
							<td align="left"><h:inputText id="txtStationType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.stationType}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_tambon']}"
								styleClass="#{popupViewSiteInfoBean.ownerTambonStyle}" /></td>
							<td align="left"><h:inputText id="txtOwnerTombon"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerTambon}"
								size="22" maxlength="15" readonly="true" /></td>
							<td><rich:spacer width="5"></rich:spacer></td>
							<td align="left">
								<h:inputText id="txtChkServWhtTypeTaxStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkServiceWhtTypeTaxStr}"
								size="22" maxlength="15" readonly="true" /></td>
						</tr>
						
						
						<tr valign="top">
							<td align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.address']}" 
								styleClass="#{popupViewSiteInfoBean.addressStyle}" /></td>
							<td align="left" rowspan="2">
							<h:inputTextarea
								id="txtAddress"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.address}"
								rows="3" cols="24" readonly="true" />
							</td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_amphur']}"
								styleClass="#{popupViewSiteInfoBean.ownerAmphurStyle}" /></td>
							<td align="left"><h:inputText
								id="txtOwnerAmphur"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerAmphur}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.rent_service_amt']}"
								styleClass="#{popupViewSiteInfoBean.rentServiceAmtStyle}" /></td>
							<td align="left"><h:inputText id="txtRentServiceAmt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentServiceAmt}"
								size="10" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
							</h:inputText></td>
						</tr>
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_province']}"
								styleClass="#{popupViewSiteInfoBean.ownerProvinceStyle}" /></td>
							<td align="left"><h:inputText id="txtOwnerProvince"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerProvince}"
								size="22" maxlength="15" readonly="true" /></td>
					
							<td align="right">
							<u><h:outputText
								value="#{jspMsgViewSiteInfo['label.property_tax_pay_typeHead']}"
								styleClass="ms7" /></u>
							</td>
							<td><h:inputText id="txtChkPropTaxPayStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkPropertyTaxPayTypeStr}"
								size="22" maxlength="15" readonly="true" /></td>	
						</tr>
						<tr valign="top" >
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.street']}" 
								styleClass="#{popupViewSiteInfoBean.streetStyle}" />
							</td>
							<td align="left"><h:inputText id="txtStreet"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.street}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.network_status']}"
								styleClass="#{popupViewSiteInfoBean.networkStatusStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtNetworkStatus"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.networkStatus}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.property_tax_hist_pay']}"
								styleClass="#{popupViewSiteInfoBean.propertyTaxHistPayStyle}" /></td>
							<td valign="top" align="left" rowspan="2"><h:inputTextarea
								id="txtPropertyTaxHistPay"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.propertyTaxHistPay}"
								rows="3" cols="24" readonly="true" /></td>
						</tr>
						<tr valign="top" >
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.tambon']}" 
								styleClass="#{popupViewSiteInfoBean.tambonStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtTambon"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.tambon}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.site_status']}"
								styleClass="#{popupViewSiteInfoBean.siteStatusStyle}" />
							</td>
							<td align=left>
								<h:inputText id="txtSiteStatus"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.siteStatus}"
								size="22" maxlength="15" readonly="true" />
							</td>
							
							
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.amphur']}" 
								styleClass="#{popupViewSiteInfoBean.amphurStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtTambon_Sub"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.amphur}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.contract_status']}"
								styleClass="#{popupViewSiteInfoBean.contractStatusStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtConstractStatus"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractStatus}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td valign="top" align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.electric_type']}"
								styleClass="#{popupViewSiteInfoBean.electricTypeStyle}" /></td>
							<td valign="top" align="left" rowspan="2"><h:inputTextarea
								id="txtElectricType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.electricType}"
								rows="3" cols="24" readonly="true" /></td>
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.province']}" 
								styleClass="#{popupViewSiteInfoBean.provinceStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtProvince"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.province}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.send_tot_status']}"
								styleClass="#{popupViewSiteInfoBean.sendTOTStatusStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtSendTOTStatus"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.sendTOTStatus}"
								size="22" maxlength="15" readonly="true" />
							</td>
							
							
						</tr>
						<tr valign="top">
							<td align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.remark']}" 
								styleClass="#{popupViewSiteInfoBean.remarkStyle}" />
							</td>
							<td align="left"  rowspan="2"><h:inputTextarea id="txtRemark"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.remark}"
								rows="3" cols="24" readonly="true" /></td>
							<td align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.doc_remain']}"
								styleClass="#{popupViewSiteInfoBean.docRemainStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea id="txtDocRemain"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.docRemain}"
								rows="3" cols="24" readonly="true" /></td>
							<td><rich:spacer width="5"></rich:spacer></td>
							<td align="left"><U><h:outputText
								value="#{jspMsgViewSiteInfo['label.case_user_fireHead']}"
								styleClass="#{popupViewSiteInfoBean.etUnitPriceAmtStyle}" /> </U></td>	
						</tr>
						<tr valign="top" >
						<td align="right">
								<h:outputText value="#{jspMsgViewSiteInfo['label.et_unit_price_amt']}"
								styleClass="#{popupViewSiteInfoBean.etUnitPriceAmtStyle}" /></td>
							<td><h:inputText id="txtetUnitPriceAmt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.etUnitPriceAmt}"
								size="10" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
							</h:inputText></td>	
						</tr>

						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.site_type']}"
								styleClass="#{popupViewSiteInfoBean.siteTypeStyle}"/>
							</td>
							<td	align="left">
								<h:inputText id="txtSiteType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.siteType}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="left">
							<rich:spacer width="5px"/>
							</td>
							<td align="left">
								<u><h:outputText
								value="#{jspMsgViewSiteInfo['label.moneyInsured']}"
								styleClass="ms7" /></u>
							</td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.take_all_amt']}"
								styleClass="#{popupViewSiteInfoBean.takeAllAmtStyle}" /></td>
							<td align="left"><h:panelGrid cellpadding="0" cellspacing="0" columns="5">
								<h:inputText id="txtTakeAllAmt"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.takeAllAmt}"
									size="10" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
								<rich:spacer width="1px"/>
								<h:inputText id="txtChkTakeAllPeriodType"
										value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkTakeAllPeriodTypeStr}"
										size="5" readonly="true"></h:inputText></h:panelGrid>
							</td>	
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.deck_area']}"
								styleClass="#{popupViewSiteInfoBean.deckAreaStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtDeckArea"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.deckArea}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
							</h:inputText>
							</td>
							<td align="right"> <rich:spacer width="5"/>
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.deposit_cash']}"
								styleClass="#{popupViewSiteInfoBean.depositCashStyle}" /></td>
							<td align="left"><h:inputText id="txtDepositCash"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.depositCash}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
							</h:inputText></td>
							<td><rich:spacer width="5"></rich:spacer></td>
							<td align="left"><h:inputText id="txtChkELVatTypeStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkELVatTypeStr}"
								size="22" maxlength="15" readonly="true" /></td>	
							<!--<td align="left"><h:panelGrid cellpadding="0" cellspacing="0" columns="2">
								<h:selectBooleanCheckbox readonly="true" id="chkLabelTakeAll" disabled="true"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkTakeAll}" />
								<h:outputText value="#{jspMsgViewSiteInfo['label.take_all']}"
									styleClass="ms7" />
							</h:panelGrid></td>	
						--></tr>
						<tr  valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.building_area']}"
								styleClass="#{popupViewSiteInfoBean.buildingAreaStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtBuildingArea"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.buildingArea}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.deposit_bg']}"
								styleClass="#{popupViewSiteInfoBean.depositBgStyle}" /></td>
							<td align="left"><h:inputText id="txtDepositBg" styleClass="inputRight"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.depositBg}"
								size="22" maxlength="15" readonly="true" >
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText></td>	
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.insurance']}"
								styleClass="#{popupViewSiteInfoBean.insuranceTypeStyle}" /></td>
							<td><h:inputText id="txtInsurance" styleClass="inputLeft"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.insuranceType}"
								size="22" maxlength="15" readonly="true" >
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText></td>				
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.room_no']}" 
								styleClass="#{popupViewSiteInfoBean.roomNoStyle}"  />
							</td>
							<td align="left">
								<h:inputText id="txtRoomNo"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.roomNo}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="left"><rich:spacer width="5"/> 
							</td>
							<td align="left" >
								<U><h:outputText value="#{jspMsgViewSiteInfo['label.moneyFire']}"
								styleClass="ms7" /></U></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.money']}"
								styleClass="#{popupViewSiteInfoBean.moneyAmountStyle}" /></td>
							<td><h:inputText id="txtMoneyAmount" styleClass="inputRight"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.moneyAmount}"
								size="22" maxlength="15" readonly="true" >
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText></td>
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.room_area']}"
								styleClass="#{popupViewSiteInfoBean.roomAreaStyle}"  />
							</td>
							<td align="left">
								<h:inputText id="txtRoomArae"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.roomArea}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.deposit_et_cash']}"
								styleClass="#{popupViewSiteInfoBean.depositEtCashStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtDepositEtCash"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.depositEtCash}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />	
								</h:inputText>
							</td>
							<td align="right"> <rich:spacer width="5px"></rich:spacer> </td>
							<td><rich:spacer width="5px"></rich:spacer></td>
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.land_area']}"
								styleClass="#{popupViewSiteInfoBean.landAreaStyle}" />
							</td>
							<td align="left">
								<h:panelGrid cellpadding="0" cellspacing="0" columns="2">
								<h:inputText id="txtLandArea"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.landArea}"
									size="7" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
										maxFractionDigits="2" />
								</h:inputText>
								<h:inputText id="txtetLandAreaUnitType"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.areaUnitType}"
									size="7" maxlength="15" readonly="true" />
							</h:panelGrid>
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.deposit_et_bg']}"
								styleClass="#{popupViewSiteInfoBean.depositEtBgStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtDepositEtBg" styleClass="inputRight"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.depositEtBg}"
								size="22" maxlength="15" readonly="true" >
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
							<td align="center" colspan="2">
								<a4j:commandButton id="btnPreviousView" value="Previous" styleClass="rich-button"
					           		action="#{navAction.navi}" reRender="popupFrmSearchViewSiteInfo" style="width:80"
					           		disabled="#{popupViewSiteInfoBean.disabledPreviousBtn}">
					           		<a4j:actionparam name="navModule" value="popup" />
									<a4j:actionparam name="navProgram" value="viewsiteinfo-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="doViewSiteInfo" />
									<a4j:actionparam name="mode" value="PREVIOUS" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
								<a4j:commandButton id="btnNextView" value="Next" styleClass="rich-button"
					           		action="#{navAction.navi}" reRender="popupFrmSearchViewSiteInfo" style="width:80"
					           		disabled="#{popupViewSiteInfoBean.disabledNextBtn}">
					           		<a4j:actionparam name="navModule" value="popup" />
									<a4j:actionparam name="navProgram" value="viewsiteinfo-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="doViewSiteInfo" />
									<a4j:actionparam name="mode" value="NEXT" />
				           		</a4j:commandButton>
				           		<rich:spacer width="5"></rich:spacer>
				           		<a4j:commandButton id="btnPrint" value="Print" styleClass="rich-button" style="width:80" onclick="self.print();">
				           		</a4j:commandButton>
							</td>
						</tr>
						<tr valign="top">
							<td align="right"></td>
							<td align="left"></td>
							
							
						</tr>
					</table>
					
					
				</h:panelGroup>
			</h:panelGrid>
		</h:panelGrid>
	</a4j:form>
</rich:modalPanel>

