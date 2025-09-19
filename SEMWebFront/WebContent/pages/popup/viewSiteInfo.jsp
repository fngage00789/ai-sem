<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<html>
<head>
<title>View Site Info</title>
<link href="../../css/style.css" rel="stylesheet" type="text/css" />


<style type="text/css" media="print">
@page 
{
	size: landscape;
	margin: 2 cm;
}
</style>

</head>
<body>
<f:view>
<f:loadBundle basename="resources.popup.viewSiteInfo" var="jspMsgViewSiteInfo" />
	<a4j:form id="popupFrmSearchViewSiteInfo">
	<a4j:jsFunction name="pageLoad" reRender="popupFrmSearchViewSiteInfo"></a4j:jsFunction>
		<h:panelGrid columnClasses="gridContent" width="100%"
			id="grdPopupSearchSiteInfoCriteria">
			<h:panelGrid width="100%">
				<h:panelGroup>
					<table width="100%" border="0" cellpadding="1" cellspacing="0">
						<tr valign="top">
						<td align="right" width=""><h:outputText
								value="#{jspMsgViewSiteInfo['label.contract_no']}"
								styleClass="#{popupViewSiteInfoBean.contractNoStyle}" /></td>
							<td align="left" width=""><h:inputText id="txtcontractNo"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractNo}"
								size="22" maxlength="15" readonly="true"/></td>
							<td align="right" width="" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.reqType']} :"
								styleClass="ms7" /></td>
							<td align="left" width="" rowspan="2"><h:inputTextarea id="txtReqTypeName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.reqTypeName}"
								rows="3" cols="24"  readonly="true"/></td>
							
							<td align="right" width="" >
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.rent_amt']}" 
								styleClass="#{popupViewSiteInfoBean.rentAmtStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtRentalDetail"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalDetail}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
								</h:inputText>
							</td>
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
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.vat']}"
								styleClass="#{popupViewSiteInfoBean.checkServiceVatTypeStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtRentVatType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentVatType}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
								</h:inputText>	
							</td>
						</tr>
						
						<tr valign="top">
							<td align="right" valign="top">
							<h:outputText
								value="#{jspMsgViewSiteInfo['label.site_name']}"
								styleClass="#{popupViewSiteInfoBean.siteNameStyle}" />
							</td>
							<td valign="top">
							<h:inputText id="txtSiteName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.siteName}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner']}" 
								styleClass="#{popupViewSiteInfoBean.ownerStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea id="txtOwner"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.owner}"
								rows="3" cols="24" readonly="true" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.wht']}"
								styleClass="#{popupViewSiteInfoBean.checkServiceVatTypeStyle}" /></td>
							<td align="left"><h:inputText id="txtrentVatType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentWhtType}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
								</h:inputText>	
						</tr>
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.location_id']}"
								styleClass="#{popupViewSiteInfoBean.locationIdStyle}" /></td>
							<td align="left"><h:inputText id="txtLocationId"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.locationId}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.service_amt']}"
								styleClass="#{popupViewSiteInfoBean.checkServiceWhtTypeTaxStyle}" /></td>
							<td align="left">
								<h:inputText id="txtChkServWhtTypeTaxStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.servDetail}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						
						<tr>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.location_code']}"
								styleClass="#{popupViewSiteInfoBean.locationCodeStyle}" /></td>
							<td align="left"><h:inputText id="txtLocationCode"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.locationCode}"
								size="22" maxlength="15" readonly="true" /></td>
								
							<td align="right" rowspan="2" valign="top">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.lessor_name']}"
								styleClass="#{popupViewSiteInfoBean.lessorNameStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea id="txtLessorName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.lessorName}"
								rows="3" cols="24" readonly="true" /></td>
								
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.vat']}"
								styleClass="#{popupViewSiteInfoBean.rentServiceAmtStyle}" /></td>
							<td align="left">
								<h:inputText id="txtServiceVatType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.serviceVatType}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						
						
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.first_effective_dt']}"
								styleClass="#{popupViewSiteInfoBean.firstEffectiveDtStyle}" /></td>
							<td align="left"><h:inputText id="txtFirstEffectiveDt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.firsteffectiveDtStr}"
								size="22" maxlength="15" readonly="true">
							</h:inputText></td>
							
							<td align="right" >
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.wht']} " styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText id="txtServiceWhtType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.serviceWhtType}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>

						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.effective_dt']}"
								styleClass="#{popupViewSiteInfoBean.effectiveDtStyle}" /></td>
							<td align="left"><h:inputText id="txtEffectiveDt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.effectiveDtStr}"
								size="22" maxlength="15" readonly="true">
							</h:inputText></td>
							<td align="right" valign="top" rowspan="2"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_address']}"
								styleClass="#{popupViewSiteInfoBean.ownerAddressStyle}" /></td>
							<td align="left" rowspan="2"><h:inputTextarea
								id="txtOwnerAddress"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerAddress}"
								rows="3" cols="24" readonly="true" /></td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.rent_service_amt']}"
								styleClass="ms7" />
							</td>
							<td align="left" >
								<h:inputText id="txtRentServiceAmt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentServiceAmt}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.expire_dt']}"
								styleClass = "#{popupViewSiteInfoBean.epDtStyle}"  /></td>
							<td align="left"><h:inputText id="txtExpireDt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.expireDtStr}"
								size="22" maxlength="15" readonly="true">
							</h:inputText></td>
							
							
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.moneyInsured']} :"
								styleClass="ms7" />
							</td>
							<td>
								<h:inputText id="txtElDepositDetail"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalDepositDetail}"
								size="22" maxlength="15" readonly="true" />
							</td>
						</tr>
						<tr valign="top">
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.station_type']}"
								styleClass="#{popupViewSiteInfoBean.stationTypeStyle}"  /></td>
							<td align="left"><h:inputText id="txtStationType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.stationType}"
								size="22" maxlength="15" readonly="true" /></td>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_street']}"
								styleClass="#{popupViewSiteInfoBean.ownerStreetStyle}"/></td>
							<td align="left"><h:inputText id="txtOwnerStreet"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerStreet}"
								size="22" readonly="true"/>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.rentServDept']} :"
								styleClass="ms7" />
							</td>
							<td valign="top" align="left">
								<h:inputText id="txtRentServDeposit"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.serviceDepositDetail}"
								size="22" maxlength="15" readonly="true" />
							</td>
							
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
								value="#{jspMsgViewSiteInfo['label.owner_tambon']}"
								styleClass="#{popupViewSiteInfoBean.ownerTambonStyle}" /></td>
							<td align="left"><h:inputText id="txtOwnerTombon"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerTambon}"
								size="22" maxlength="15" readonly="true" /></td>
							<td valign="top" align="right" >
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.eldeposit']} :"
								styleClass="ms7" />
							</td>
							<td valign="top" align="left" >
								<h:inputText id="txtELDeposit"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.elDepositDetail}"
								size="22" maxlength="15" readonly="true" />
							</td>	
						</tr>
						<tr valign="top">
							
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_amphur']}"
								styleClass="#{popupViewSiteInfoBean.ownerAmphurStyle}" /></td>
							<td align="left"><h:inputText
								id="txtOwnerAmphur"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerAmphur}"
								size="22" maxlength="15" readonly="true" /></td>
							
							<td align="right">
								<u><h:outputText
								value="#{jspMsgViewSiteInfo['label.property_tax_pay_typeHead']}"
								styleClass="ms7" /></u>
							</td>
							<td>
								<h:inputText id="txtChkPropTaxPayStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkPropertyTaxPayTypeStr}"
								size="22" maxlength="15" readonly="true" />
							</td>
						</tr>
						
						
						<tr valign="top">
							
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.zone']} :"
								styleClass="#{popupViewSiteInfoBean.ownerProvinceStyle}" /></td>
							<td align="left"><h:inputText id="txtZone"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.zone}"
								size="22" maxlength="15" readonly="true" /></td>
							
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.owner_province']}"
								styleClass="#{popupViewSiteInfoBean.ownerProvinceStyle}" /></td>
							<td align="left"><h:inputText id="txtOwnerProvince"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.ownerProvince}"
								size="22" maxlength="15" readonly="true" /></td>
							
							<td align="right" rowspan="2">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.property_tax_hist_pay']}"
								styleClass="ms7" />
							</td>	
							<td align="left" rowspan="2">
								<h:inputTextarea
								id="txtPropertyTaxHistPay"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.propertyTaxHistPay}"
								rows="3" cols="24" readonly="true" />
							</td>
						</tr>
						<tr valign="top">
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
								styleClass="ms7" />
							</td>
							<td align="left">
								<h:inputText id="txtNetworkStatus"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.networkStatus}"
								size="22" maxlength="15" readonly="true" />
							</td>
					
							
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
								value="#{jspMsgViewSiteInfo['label.contract_status']}"
								styleClass="ms7" />
							</td>
							<td align=left>
								<h:inputText id="txtConstractStatus"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractStatus}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right" rowspan="2">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.electric_type']}"
								styleClass="#{popupViewSiteInfoBean.electricTypeStyle}" />
							</td>
							<td  rowspan="2">
								<h:inputTextarea
								id="txtElectricType"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.electricType}"
								rows="3" cols="24" readonly="true" />
							</td>
						</tr>
						<tr valign="top" >
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
								value="#{jspMsgViewSiteInfo['label.flowContract']} :"
								styleClass="ms7" />
							</td>
							<td align="left">
								<h:inputText id="txtContractFlow"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractFlow}"
								size="22" maxlength="15" readonly="true" />
							</td>
							
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
								value="#{jspMsgViewSiteInfo['label.contact_name']}"
								styleClass="#{popupViewSiteInfoBean.contactNameStyle}"/>
								
							</td>
							<td align="left">
								<h:inputText id="txtContactName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contactName}"
								size="22" maxlength="15" readonly="true" />
								
							
								<h:inputText id="txtTitle"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.title}"
								readonly="true" size="22" rendered="false"/>
							</td>
							<td align="left">
								<U><h:outputText
								value="#{jspMsgViewSiteInfo['label.case_user_fireHead']}"
								styleClass="#{popupViewSiteInfoBean.etUnitPriceAmtStyle}" /> </U>
							</td>
							<td align="left">
								
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
							<td align="right" rowspan="2">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.contact_tel']}"
								styleClass="#{popupViewSiteInfoBean.contactTelStyle}" />
								
							</td>
							<td align="left" rowspan="2">
								<h:inputTextarea id="txtContactTel"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contactTel}"
								rows="2" cols="24" readonly="true" />
								
							</td>
							<td align="right">
								<h:outputText value="#{jspMsgViewSiteInfo['label.et_unit_price_amt']}"
								styleClass="#{popupViewSiteInfoBean.etUnitPriceAmtStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtetUnitPriceAmt"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.etUnitPriceAmt}"
								size="10" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						<tr valign="top">
							
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.take_all_amt']}"
								styleClass="#{popupViewSiteInfoBean.takeAllAmtStyle}" />
							</td>
							<td>
								<h:panelGrid cellpadding="0" cellspacing="0" columns="5">
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
						<tr valign="top" >
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
							<td align="right" >
								<h:outputText value="#{jspMsgViewSiteInfo['label.emerContactName']} :" 
								styleClass="ms7"/>
							</td>
							<td align="left">
								<h:inputText id="txtEmerContactName"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.emerContactName}"
								readonly="true" size="22"/>
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.vat']}"
								styleClass="#{popupViewSiteInfoBean.checkELVatTypeStyle}" />
							</td>
							<td>
								<h:inputText id="txtChkELVatTypeStr"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkELVatTypeStr}"
								size="22" maxlength="15" readonly="true" />
							</td>	
							
						</tr>

						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.taxid']} :"
								styleClass="ms7" />
							</td>
							<td>
								<h:inputText id="txtTaxID"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.taxId}"
								size="22" maxlength="15" readonly="true" />
							</td>
							<td align="right" >
								<h:outputText value="#{jspMsgViewSiteInfo['label.emerContactPhoneNum']} :" 
								styleClass="ms7"/>
							</td>
							<td align="left" >
								<h:inputText id="txtEmerContactPhoneNum"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.emerPhoneNum}"
								readonly="true" size="22"/>
							</td>
							<td align="right" >
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.insurance']} :"
								styleClass="#{popupViewSiteInfoBean.insuranceTypeStyle}" />
							</td>
							<td>
								<h:inputText id="txtInsurance" styleClass="inputLeft"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.insuranceType}"
								size="22" maxlength="15" readonly="true" >
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						<tr valign="top">
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.birthday']} :"
								styleClass="ms7" />
							</td>
							<td align="left">
								<rich:calendar id="ownerBirthday" locale="th" enableManualInput="true" 
								datePattern="dd/MM/yyyy" 
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.onwerBirthday}"
								showWeeksBar="false" inputSize="10"
								oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
								cellWidth="15px" cellHeight="20px"
								oninputblur="return dateformat.submitFomatDate(this);"
								label="" disabled="true" styleClass="ms7">
								</rich:calendar>
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.category']} :"
								styleClass="#{popupViewSiteInfoBean.contactFaxStyle}" />
								</td>
							<td align="left">
								<h:inputText id="txtCategory"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.categoryName}"
								size="22" maxlength="15" readonly="true" />
								
							</td>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.money']} :"
								styleClass="#{popupViewSiteInfoBean.moneyAmountStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtMoneyAmount" styleClass="inputRight"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.moneyAmount}"
								size="22" maxlength="15" readonly="true" >
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
							<!--<td align="left"><h:panelGrid cellpadding="0" cellspacing="0" columns="2">
								<h:selectBooleanCheckbox readonly="true" id="chkLabelTakeAll" disabled="true"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.checkTakeAll}" />
								<h:outputText value="#{jspMsgViewSiteInfo['label.take_all']}"
									styleClass="ms7" />
							</h:panelGrid></td>	
						--></tr>
						<tr  valign="top">
							
							
							<td></td>
							<td></td>				
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td align="right" valign="top"><h:outputText
								value="#{jspMsgViewSiteInfo['label.SubCategory']} :" 
								styleClass="#{popupViewSiteInfoBean.rentAmtStyle}" /></td>
							<td align="left">
								<h:inputText id="txtSubCategory"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.subCategoryName}"
								size="22" maxlength="15" readonly="true" />
							</td>
						</tr>
						<tr valign="top">
							<td colspan="6">
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
				           		
				           		<rich:spacer width="15"></rich:spacer>
				           		
				           		<a4j:commandButton id="btnCloselySite" value="#{jspMsgViewSiteInfo['btn.label.closelySite']}" styleClass="rich-button"
					           		action="#{navAction.navi}"  style=" width : 110px;" oncomplete="#{rich:component('popupCloselySite')}.show();"
					           		reRender="grdPopupCloselySite,dtbCloselySite">
					           		<a4j:actionparam name="navModule" value="popup" />
									<a4j:actionparam name="navProgram" value="viewsiteinfo-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="showCloselySite" />
				           		</a4j:commandButton>
								
								<rich:spacer width="5"/>
								
								
								<a4j:commandButton id="btnRentConDetail" value="#{jspMsgViewSiteInfo['btn.label.rentAndServiceDetail']}"styleClass="rich-button"
					           		action="#{navAction.navi}"  style=" width : 170px;" oncomplete="#{rich:component('popupRentServiceDetail')}.show();"
					           		reRender="pnlResultRentServiceDetail,dtbRentCondDetail,frmError">
					           		<a4j:actionparam name="navModule" value="popup" />
									<a4j:actionparam name="navProgram" value="viewsiteinfo-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="showRentCond" />
				           		</a4j:commandButton>
				           		
				           		<rich:spacer width="15"></rich:spacer>
				           		
				           		<a4j:commandButton id="btnRentHistory" value="#{jspMsgViewSiteInfo['btn.label.rentAndServiceHistory']}"   styleClass="rich-button"
					           		action="#{navAction.navi}"  style=" width : 200px;" oncomplete="#{rich:component('popupRentHistory')}.show();"
					           		reRender="pnlResultRentHistory,dtbRentHistory">
					           		<a4j:actionparam name="navModule" value="popup" />
									<a4j:actionparam name="navProgram" value="viewsiteinfo-popup" />
									<a4j:actionparam name="moduleWithNavi" value="common" />
									<a4j:actionparam name="actionWithNavi" value="PopupViewSiteInfo"/>
									<a4j:actionparam name="methodWithNavi" value="showRentHistory" />
				           		</a4j:commandButton>
							</td>
						</tr>
						<tr valign="top">
							<td align="right">
								
							</td>
							<td align="left">
								
							</td>
							<td align="right">
								
							</td>
							<td align="left">
								
							</td>
							<td align="left" colspan="2"> </td>
							
						</tr>
						<tr valign="top">
							<td align="right">
								
							</td>
							<td align="left">
								
							</td>
							<td align="right">
								
							</td>
							<td align="left">
								
							</td>
							<td align="left" colspan="2">
								
								
							</td>
						</tr>
						<tr>
							<td><rich:spacer width="5"/></td>
							<td><rich:spacer width="5"/></td>
							<td><rich:spacer width="5"/></td>
							<td><rich:spacer width="5"/></td>
							<td colspan="2">
								
									
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
		
		
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="35%">
					<table>
						<tr>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.deck_area']}"
								styleClass="#{popupViewSiteInfoBean.deckAreaStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtDeckArea1"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.deckArea}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
							</h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.building_area']}"
								styleClass="#{popupViewSiteInfoBean.buildingAreaStyle}" />
							</td>
							<td align="left">
								<h:inputText id="txtBuildingArea1"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.buildingArea}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.room_no']}" 
								styleClass="#{popupViewSiteInfoBean.roomNoStyle}"  />
							</td>
							<td align="left">
								<h:inputText id="txtRoomNo1"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.roomNo}"
								size="22" maxlength="15" readonly="true" />
							</td>
						</tr>
						<tr>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.room_area']}"
								styleClass="#{popupViewSiteInfoBean.roomAreaStyle}"  />
							</td>
							<td align="left">
								<h:inputText id="txtRoomArae1"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.roomArea}"
								size="22" maxlength="15" readonly="true" styleClass="inputRight">
								<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
									maxFractionDigits="2" />
								</h:inputText>
							</td>
						</tr>
						<tr>
							<td align="right">
								<h:outputText
								value="#{jspMsgViewSiteInfo['label.land_area']}"
								styleClass="#{popupViewSiteInfoBean.landAreaStyle}" />
							</td>
							<td align="left">
								<h:panelGrid cellpadding="0" cellspacing="0" columns="2">
								<h:inputText id="txtLandArea1"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.landArea}"
									size="7" maxlength="15" readonly="true" styleClass="inputRight">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13"
										maxFractionDigits="2" />
								</h:inputText>
								<h:inputText id="txtetLandAreaUnitType1"
									value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.areaUnitType}"
									size="7" maxlength="15" readonly="true" />
								</h:panelGrid>
							</td>
						</tr>
						<tr>
							<td colspan="2" height="20">
							
							</td>
						</tr>
						<tr>
							<td align="right"><h:outputText
								value="#{jspMsgViewSiteInfo['label.doc_remain']}"
								styleClass="ms7" /></td>
							<td align="left" ><h:inputTextarea id="txtDocRemain"
								value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.docRemain}"
								rows="3" cols="24" readonly="true" /></td>
						</tr>
						<tr>
							<td colspan="2" height="20">
							
							</td>
						</tr>
						<tr>
							<td align="right" >
							</td>
							<td align="left" >
								
							</td>
						</tr>
						<tr>
							<td align="right" >
								
							</td>
							<td align="left">
								
							</td>
						</tr>
					</table>
					
					<rich:spacer height="20"></rich:spacer>
					
				</td>
				
				<td valign="top">
					<table border="1" cellpadding="0" cellspacing="0" bordercolor="#000000" width="90%">
						<tr bgcolor="#ADFF2F" align="center">
							<td width="25%">
								<h:outputText value="#{jspMsgViewSiteInfo['column.header.contractStartDt']}" styleClass="ms7" />
							</td>
							<td width="25%">
								<h:outputText value="#{jspMsgViewSiteInfo['column.header.contractEndDt']}" styleClass="ms7" />
							</td>
							<td width="25%">
								<h:outputText value="#{jspMsgViewSiteInfo['column.header.rantalAmt']}" styleClass="ms7" />
							</td>
							<td width="25%">
								<h:outputText value="#{jspMsgViewSiteInfo['column.header.rentalInclude']}" styleClass="ms7" />
							</td>
						</tr>
						<tr>
							<td align="center">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractStartDtStr_p1}" styleClass="ms7" />
							</td>
							<td align="center">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractEndDtStr_p1}" styleClass="ms7" />
							</td>
							<td align="right">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalAmt_p1Str}" styleClass="ms7" >
								</h:outputText>
							</td>
							<td align="right">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalInclude_p1}" styleClass="ms7">
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2"/>
								</h:outputText>
							</td>
						</tr>
						<tr>
							<td align="center">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractStartDtStr_p2}" styleClass="ms7" />
							</td>
							<td align="center">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractEndDtStr_p2}" styleClass="ms7" />
							</td>
							<td align="right">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalAmt_p2Str}" styleClass="ms7" >
								</h:outputText>
							</td>
							<td align="right">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalInclude_p2}" styleClass="ms7" >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2"/>
								</h:outputText>
							</td>
						</tr>
						<tr>
							<td align="center">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractStartDtStr_p3}" styleClass="ms7" />
							</td>
							<td align="center">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.contractEndDtStr_p3}" styleClass="ms7" />
							</td>
							<td align="right">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalAmt_p3Str}" styleClass="ms7" >
								</h:outputText>
							</td>
							<td align="right">
								<h:outputText value="#{popupViewSiteInfoBean.popupViewSiteInfoSearchSP.rentalInclude_p3}" styleClass="ms7" >
									<f:convertNumber pattern="#,##0.00" maxIntegerDigits="13" maxFractionDigits="2"/>
								</h:outputText>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
			
				
		
	</a4j:form>
	<jsp:include page="../../pages/popup/closelySite-popup.jsp" />
	<jsp:include page="../../pages/popup/rentService-popup.jsp" />
	<jsp:include page="../../pages/popup/rentHistory-popup.jsp" />
<rich:spacer height="5"/>
</f:view>
</body>
</html>