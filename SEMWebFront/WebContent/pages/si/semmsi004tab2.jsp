<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<h:panelGrid columnClasses="gridContent" width="100%">
	<h:panelGrid id="pnlTab2" width="98%">
		           <rich:panel id="pnlContract">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['label.tab.contract']}"/>
						</f:facet>
						<h:panelGrid width="98%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<table >
									<tr>
										<td style="width:15%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.company']}" styleClass="ms7"/>
										</td>
										<td style="text-align:left;">
											<h:inputText value="#{semmsi004tab1Bean.siteInfo.company}" readonly="true" styleClass="ms7"/>
										</td>
										<td style="width:20%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms28"/>
										</td>
										<td style="text-align:left;">
											<h:inputText id="txtContractNoDisplay" value="#{semmsi004tab2Bean.contract.contractNo}" 
			                			 size="16"  readonly="true" styleClass="ms28Blue"/>
										</td>
										
									</tr>
								</table>
							</h:panelGroup>
						</h:panelGrid>
						
						<h:panelGroup>
			           		<h:outputText value="#{jspMsg['label.changeContractInfo']}" styleClass="ms7" 
			           		rendered="#{semmsi004Bean.reqTypeParam != '01'}"/>
							
								<h:selectOneRadio id="rbtMsi004tab3_changeContractInfo" value="#{semmsi004tab2Bean.contractInfoEditFlag}" styleClass="ms7" 
								rendered="#{semmsi004Bean.reqTypeParam != '01'}"
								disabled="" onclick="fnMsi004tab3_changeContractInfoComfirm();">
		                				<f:selectItem itemValue="N" itemLabel="#{jspMsg['label.th_notEdit']}" />
		                				<f:selectItem itemValue="Y" itemLabel="#{jspMsg['label.th_edit']}"/>
		                		</h:selectOneRadio>
		                		
		                		<a4j:jsFunction name="fnMsi004tab3_changeContractInfoComfirm"
		                		oncomplete="#{rich:component('msi004PopUpCommon_commonConfirm')}.show(); return false;"
		                		action="#{semmsi004tab2Action.doSetParamConfirmNotChangeContractInfo}"
		                		 reRender="pnlContractLessor,pnlContactAddress,
		                		 msi004PopUpCommon_commonConfirm"></a4j:jsFunction>
			           	</h:panelGroup>
						
						<h:panelGrid id="pnlContractLessor" width="98%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<div>
			                		<h:selectBooleanCheckbox rendered="false"></h:selectBooleanCheckbox>
			                		<h:outputText value="#{jspMsg['label.changeContractInfo']} " rendered="false" styleClass="ms7" />
			                	</div>
			                	
			                	<rich:spacer height="10"></rich:spacer>
			                	
			                	<rich:panel>
			                		<table style="width:90%;">
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												
											</td>
											<td style="white-space:nowrap; width:90%; text-align:left;">
												<h:selectBooleanCheckbox value="#{semmsi004tab2Bean.chkLeaseholdRights}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:selectBooleanCheckbox>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.th_leasehold_rights']}" styleClass="ms7"></h:outputText>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_renewCont']}" styleClass="ms7"></h:outputText>
												
												<h:selectBooleanCheckbox value="#{semmsi004tab2Bean.chkContRentAdj}" onclick="reRenderContRentAdd();"
							       				disabled="#{semmsi004tab2Bean.disabledContract || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       						
							       				</h:selectBooleanCheckbox>
							       					
							       					
							       				<a4j:jsFunction name="reRenderContRentAdd" reRender="msi004tab2_rentAdj,msi004tab2_rentAdjPeriod"></a4j:jsFunction>
							       				<rich:spacer width="10"></rich:spacer>
											</td>
											<td style="width:90%; text-align:left;">
												<h:selectOneMenu id="msi004tab2_rentAdj" value="#{semmsi004tab2Bean.contract.rentAdj}"
							       					disabled="#{!semmsi004tab2Bean.chkContRentAdj || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
							       						<f:selectItems value="#{semmsi004tab3Bean.rentAdjList}"/> 
							       					</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_rentalAgreement']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputText id="msi004tab2_rentPromise" value="#{semmsi004tab2Bean.contract.promiseRenewTime}" maxlength="5" size="7"
												onkeypress="return numberformat.keyPressIntegerOnly(this, event);" style="text-align:right;" styleClass="ms7"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													<f:convertNumber pattern="#,##0" maxIntegerDigits="9" />
												</h:inputText> 
												<h:outputText value="#{jspMsg['label.th_periodBy']}" style="margin:0 5px 0 5px;" styleClass="ms7" />
												
												<h:inputText id="msi004tab2_rentPromiseTime" value="#{semmsi004tab2Bean.contract.promiseRenewPeriod}" maxlength="2" size="5"
												onkeypress="return numberformat.keyPressIntegerOnly(this, event);" style="text-align:right;" styleClass="ms7"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
												</h:inputText> 
												<h:selectOneMenu id="ddlPromiseRenewUnitType" value="#{semmsi004tab2Bean.contract.promiseRenewPeriodType}"
				                				disabled="#{semmsi004tab2Bean.disabledContract || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"> 
													<f:selectItems value="#{semmsi004tab2Bean.periodTypeList}"/>
												</h:selectOneMenu>
												
												<rich:spacer width="40"></rich:spacer>
												
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
											
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputTextarea id="msi004tab2_promiseRenewRemark" value="#{semmsi004tab2Bean.contract.promiseRenewRemark}"
				                                rows="3" style="width:80%;" styleClass="ms7" 
				                                disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
				                                </h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
											<a4j:region>
												<h:selectBooleanCheckbox id="msi004tab2_chkContractWanted" value="#{semmsi004tab2Bean.chkContractWanted}" 
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" style="margin-left:100px;" onclick="msi004tab2_doChkContractWantedJS();"/>
												
												<a4j:jsFunction name="msi004tab2_doChkContractWantedJS" reRender="msi004tab2_contractWantedRemark" 
												action="#{semmsa002Action.doChkContractWanted}"/>
												
												<h:outputText style="white-space:nowrap;" value="#{jspMsg['label.th_contractNotMustBe']}" styleClass="ms7" />
												
												<rich:spacer width="10"></rich:spacer>
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.th_because']} : " styleClass="ms7" />
											</a4j:region>
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputTextarea id="msi004tab2_contractWantedRemark" value="#{semmsi004tab2Bean.contract.contractWantedRemark}"
				                                rows="3" style="width:80%;" styleClass="ms7" disabled="#{semmsi004tab2Bean.chkContractWanted == false || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
				                                </h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;">
												
											</td>
											<td style="width:90%; text-align:left;">
												<h:selectOneRadio styleClass="ms7" value="#{semmsi004tab2Bean.contract.license}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
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
												<h:selectBooleanCheckbox value="#{semmsi004tab2Bean.chkOwnerContractFlag}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:selectBooleanCheckbox>
												<rich:spacer width="5"></rich:spacer>
												<h:outputText value="#{jspMsg['label.owner_create_contract']}" styleClass="ms7" />
											</td>
										</tr>
										<tr>
											<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
												<h:outputText value="#{jspMsg['label.th_special_condition']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputTextarea value="#{semmsi004tab2Bean.contract.remarkSpacial}" id="msi004tab2_special_cond"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
				                                rows="3" style="width:80%;" styleClass="ms7" >
				                                </h:inputTextarea>
											</td>
										</tr>
									</table>
			                	</rich:panel>
			                	
								<rich:spacer height="10"></rich:spacer>
								
								<rich:panel>
									<table style="width:97%; border:solid 1px;">
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
												<h:selectOneMenu id="msa002tab2_owner_cate" value="#{semmsi004tab2Bean.contract.ownerCategory}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													<f:selectItems value="#{semmsi004tab2Bean.ownerCategoryList}"/>
												</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_owner_sub_category']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:selectOneMenu id="msa002tab2_owner_sub_cate" value="#{semmsi004tab2Bean.contract.ownerSubCategory}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													<f:selectItems value="#{semmsi004tab2Bean.ownerSubCategoryList}"/>
												</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:selectOneMenu value="#{semmsi004tab2Bean.contract.ownerTitleName}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													<f:selectItems value="#{semmsi004tab2Bean.titleList}"/>
												</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.th_ownername']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputTextarea id="txtOwnerName" value="#{semmsi004tab2Bean.contract.ownerName}" 
				                                rows="3" style="width:80%;" styleClass="ms7"
				                                disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<a4j:commandButton  id="msi004tab2_BtnCopy1" value="Copy #{jspMsg['label.th_from']}#{jspMsg['label.th_ownername']}" 
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
												styleClass="rich-button" rendered="true">
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
												<h:selectOneMenu value="#{semmsi004tab2Bean.contract.lessorTitleName}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													<f:selectItems value="#{semmsi004tab2Bean.titleList}"/>
												</h:selectOneMenu>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="* " style="font-style:bold; color:red;" />
												<h:outputText value="#{jspMsg['label.th_landlordName']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputTextarea id="txtContractLessorName" value="#{semmsi004tab2Bean.contract.lessorName}"  
												rows="2" style="width:50%; height:50px; overflow:visible;" styleClass="ms7"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
												</h:inputTextarea>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.th_taxId']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<h:inputText value="#{semmsi004tab2Bean.contract.lessorTaxId}" 
												style="width:400px;" maxlength="13"
												onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:inputText>
											</td>
										</tr>
										
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.birthday']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;">
												<rich:calendar locale="th" enableManualInput="true" 
														   datePattern="dd/MM/yyyy" 
														   value="#{semmsi004tab2Bean.contract.lessorBirthday}"
														   showWeeksBar="false"
														   inputSize="10"
														   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													   	   cellWidth="15px" cellHeight="20px"
													   	   label=""
													   	   styleClass="ms7"
													   	   disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
												</rich:calendar>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_landlordAddr']}" styleClass="ms7" style="text-decoration:underline;"/>
											</td>
											<td>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;" colspan="2">
											
												<table style="width:100%; border:solid ececec 1px;">
													<tr>
														<td colspan="6" style="background-color:ececec; border:solid dcdcdc 1px;">
															<a4j:commandButton id="msi004tab2_BtnCopy" value="Copy #{jspMsg['label.th_from']} #{jspMsg['label.th_info_station']}"
															styleClass="rich-button" rendered="true" disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
															</a4j:commandButton>
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;" valign="top">
															<h:outputText value="#{jspMsg['label.th_number']} : " styleClass="ms7" />
														</td>
														<td colspan="5">
															<h:inputTextarea id="txtContractLessorHouseNo" value="#{semmsi004tab2Bean.contract.lessorHouseNo}" 
				                               	 			rows="3" style="width:80%;" styleClass="ms7"
				                               	 			disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:inputTextarea>
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
														</td>
														<td style="">
															<h:inputText id="msi004tab2_lessorBuilding" value="#{semmsi004tab2Bean.contract.lessorBuilding}"
															 maxlength="500" style="width:80%;" styleClass="ms7"
															 disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
														</td>
														<td style="white-space:nowrap;">
															<h:inputText id="msi004tab2_lessorFloor" value="#{semmsi004tab2Bean.contract.lessorFloor}" 
															style="text-align:right; width:150px;" styleClass="ms7"
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
														</td>
														<td style="width:30%; white-space:nowrap;">
															<h:inputText id="msi004tab2_lessorRoomNo" value="#{semmsi004tab2Bean.contract.lessorRoomNo}" 
															style="text-align:right;" styleClass="ms7"
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
														</td>
														<td style="" >
															<h:inputText id="txtContractLessorStreet" value="#{semmsi004tab2Bean.contract.lessorStreet}"
															 style="width:80%;" styleClass="ms7"
															 disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
														</td>
														<td colspan="3">
															<h:inputText id="txtContractLessorTambon" value="#{semmsi004tab2Bean.contract.lessorTambon}" 
															style="width:40%;" styleClass="ms7" 
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
														</td>
														<td style="">
															<h:selectOneMenu id="ddlContractLessorAmphurId" value="#{semmsi004tab2Bean.contract.lessorAmphurId}"
								                			disabled="#{semmsi004tab2Bean.disabledContract || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
																<f:selectItems value="#{semmsi004tab2Bean.contractLessorAmphurList}"/>
													 		</h:selectOneMenu>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
														</td>
														<td style="" >
															<a4j:region>
																<h:selectOneMenu id="ddlContractLessorProvinceId" value="#{semmsi004tab2Bean.contract.lessorProvinceId}" 
										                			onchange="GetContractLessorAmphurListJS();" disabled="#{semmsi004tab2Bean.disabledContract || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
																		<f:selectItems value="#{semmsi004Bean.provinceList}"/>
															 		</h:selectOneMenu>
																
															</a4j:region>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
														</td>
														<td style="width:30%;" >
															<h:inputText id="txtContractLessorPostcode" value="#{semmsi004tab2Bean.contract.lessorPostcode}"
															style="text-align:right;" maxlength="5" styleClass="ms7" 
															onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														</td>
													</tr>
													
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_localPhone']} : " styleClass="ms7" />
														</td>
														<td style="" colspan="5">
															<h:inputText id="txtContractLessorTel" value="#{semmsi004tab2Bean.contract.lessorTel}"  
															style="width:300px;" styleClass="ms7"
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														
															<h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="padding-left:110px;" styleClass="ms7" />
															<h:inputText id="msi004tab2_lessorMobile" value="#{semmsi004tab2Bean.contract.lessorMobile}" 
															style="width:300px;" styleClass="ms7" 
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td colspan="2"></td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.en_fax']} : " styleClass="ms7" />
														</td>
														<td style="" colspan="5">
															<h:inputText id="txtContractLessorFax" value="#{semmsi004tab2Bean.contract.lessorFax}"
															style="width:300px;" styleClass="ms7"
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														
															<h:outputText value="#{jspMsg['label.en_email']} : " style="padding-left:114px;" styleClass="ms7" />
															<h:inputText id="msi004tab2_lessorEmail" value="#{semmsi004tab2Bean.contract.lessorEmail}" 
															style="width:300px;" styleClass="ms7" 
															disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td colspan="2"></td>
													</tr>
													<tr>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															
														</td>
														<td style="" colspan="5">
															
														</td>
														<td colspan="2"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</rich:panel>
								
							</h:panelGroup>
							
							<rich:spacer height="10"></rich:spacer>
							
							<h:panelGroup>
								<table width="100%">
									<tr>
									<td align="left" colspan="4" >
									<h:panelGroup rendered="#{semmsi004Bean.renderedModeView}">
									<a4j:commandButton id="btnCopyLessorName" value="#{jspMsg['btn.copyLessorName']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="pnlLessorName" style="width:160"
					           		disabled="#{semmsi004tab2Bean.editableContractFlag == 'N' || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
					           		<a4j:actionparam name="navModule" value="si" />
									<a4j:actionparam name="navProgram" value="SEMMSI004TAB2" />
									<a4j:actionparam name="moduleWithNavi" value="si" />
									<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2"/>
									<a4j:actionparam name="methodWithNavi" value="doUpdateContractLessor" />
					           		</a4j:commandButton>
					           		<rich:spacer width="5"></rich:spacer>
					           		<a4j:commandButton id="btnAddLessorName" value="#{jspMsg['btn.addLessorName']}" styleClass="rich-button" 
					           		action="#{navAction.navi}" reRender="popupAddLessor" style="width:100"
					           		 oncomplete="#{rich:component('popupAddLessor_popup')}.show(); return false"
					           		 disabled="#{semmsi004tab2Bean.editableContractFlag == 'N' || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
						           		<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI004-4" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2"/>
										<a4j:actionparam name="methodWithNavi" value="initAddLessorName" />
					           		</a4j:commandButton>
					           		</h:panelGroup>
		                			</td>
			                	 </tr>
								</table>
							</h:panelGroup>
							
							<h:panelGroup>
								<rich:panel id="pnlLessorName">
									<f:facet name="header" >
										<h:outputText value="#{jspMsg['header.panel.lessorName']}" />
									</f:facet>
									<div align="left">
									<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green"/>
									</div>
									<rich:dataTable width="97%" id="dtbLessor" cellpadding="1" cellspacing="0" border="0"
									var="siteLessorSP" value="#{semmsi004tab2Bean.lessorSPList}" reRender="dtbLessor" 
									rows="#{semmsi004tab2Bean.rowPerPage}" rowClasses="cur" styleClass="dataTable">
									<a4j:support event="onRowClick"   action="#{semmsi004Action.getRowIdOnClick}" reRender="dtbLessor">
										<a4j:actionparam name="rowId" value="#{siteLessorSP.rowId}" />
									</a4j:support>
									<rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}" 
									rendered="#{semmsi004Bean.renderedModeView}">
										<f:facet name="header" >
											<h:outputText value="Edit" styleClass="contentform" style="width: 40"/>
										</f:facet>
										<div align="center">
			            					<a4j:commandButton action="#{navAction.navi}" reRender="popupAddLessor,frmPopupAddLessor"
			            					oncomplete="#{rich:component('popupAddLessor')}.show(); return false"
			            					image="images/edit.png" style="height: 15; width: 15"
			            					disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"
			            					rendered="#{semmsi004tab2Bean.editableContractFlag == 'Y'}">
												<a4j:actionparam name="navModule" value="si" />
				            					<a4j:actionparam name="navProgram" value="SEMMSI004-4" />	
												<a4j:actionparam name="moduleWithNavi" value="si" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2" />
												<a4j:actionparam name="methodWithNavi" value="initUpdateContractLessor" />
												<a4j:actionparam name="rowId" value="#{siteLessorSP.rowId}" />
			            					</a4j:commandButton>          							
										</div>
									</rich:column>
									<rich:column styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}"
									rendered="#{semmsi004Bean.renderedModeView}">
										<f:facet name="header">
											<h:outputText value="Delete" styleClass="contentform" style="width: 40"/>
										</f:facet>
										<div align="center">
			            					<a4j:commandButton oncomplete="#{rich:component('mdpConfirmDelLessorDialog')}.show(); return false" 
		     									   action="#{navAction.navi}" image="images/delete.png" style="height: 15; width: 15"
		     									   rendered="#{semmsi004tab2Bean.editableContractFlag == 'Y'}"
		     									   disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
												<a4j:actionparam name="navModule" value="si" />
				            					<a4j:actionparam name="navProgram" value="SEMMSI004TAB2" />	
												<a4j:actionparam name="moduleWithNavi" value="si" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2" />
												<a4j:actionparam name="methodWithNavi" value="initDeleteContractLessor" />
												<a4j:actionparam name="rowId" value="#{siteLessorSP.rowId}" />
			            					</a4j:commandButton>          							
										</div>
									</rich:column>
									<rich:column  sortBy="#{siteLessorSP.lessorName}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.lessorName']}" styleClass="contentform" />
										</f:facet>
										<div align="left">
											<h:outputText value="#{siteLessorSP.lessorName}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column sortBy="#{siteLessorSP.address}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['label.address']}" styleClass="contentform" />
										</f:facet>
										<div align="left">
											<h:outputText value="#{siteLessorSP.address}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column  sortBy="#{siteLessorSP.tel}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.telephone']}" styleClass="contentform" />
										</f:facet>
										<div align="left">
											<h:outputText value="#{siteLessorSP.tel}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column sortBy="#{siteLessorSP.fax}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
										<f:facet name="header">
											<h:outputText value="#{jspMsg['column.header.fax']}" styleClass="contentform" />
										</f:facet>
										<div align="left">
											<h:outputText value="#{siteLessorSP.fax}" styleClass="contentform"  />
										</div>
									</rich:column>
									<rich:column sortBy="#{siteLessorSP.overFlagName}" styleClass="#{(semmsi004Bean.tmpRowId==siteLessorSP.rowId)?'onClick':'unClick'}">
									<f:facet name="header">
										<h:outputText value="#{jspMsg['label.overFlag']}" styleClass="contentform" style="width: 80"/>
									</f:facet>
									<div align="center">
										<h:outputText value="#{siteLessorSP.overFlagName}" styleClass="contentform"  />
									</div>
									</rich:column>
									<f:facet name="footer">
										<rich:columnGroup>
											<rich:column colspan="4">
												<h:outputFormat value="#{msg['message.totalRecords']}">
													<f:param value="#{fn:length(semmsi004tab2Bean.lessorSPList)}"></f:param>
												</h:outputFormat>
											</rich:column>
											<rich:column colspan="3">
												<rich:datascroller immediate="true" rendered="true" align="left" for="dtbLessor"
													maxPages="#{semmsi004tab2Bean.rowPerPage}"  selectedStyleClass="selectScroll"
													stepControls="hide" fastControls="auto" boundaryControls="auto" 
													id="dstLessor" 
													style="background-color: #cccccc;"
													page="#{semmsi004tab2Bean.scrollerPage}" 
												/>
											</rich:column>
										</rich:columnGroup>
									</f:facet>
								</rich:dataTable>
								</rich:panel>
							</h:panelGroup>
						</h:panelGrid>
						
						
						
					<rich:spacer height="10"></rich:spacer>
					<a4j:region id="rgnContactAddress">
					<h:panelGrid id="pnlContactAddress" width="98%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
								<rich:panel>
									<table width="97%" >
					                	 <tr>
											<td align="left" colspan="4" style="text-decoration: underline">
											<h:outputText value="#{jspMsg['label.contract']}" styleClass="ms7"/>
				                			</td>
					                	 </tr>
					                	 <tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.th_title']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;" colspan="3">
												<h:selectOneMenu id="msi004Tab2_contact_title" value="#{semmsi004tab2Bean.contract.contactTitleName	}"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
													<f:selectItems value="#{semmsi004tab2Bean.titleList}"/>
												</h:selectOneMenu>
											</td>
										</tr>
					                	<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
											<h:outputText value="#{jspMsg['label.contractName']}" styleClass="ms7"/>
				                			</td>
				                			<td width="65%" colspan="3">
				                			<h:inputTextarea id="txtContractName" value="#{semmsi004tab2Bean.contract.contactName}" 
				                			cols="100" rows="3" 
				                			disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
						                	</td>
					                	 </tr>
					                	 
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.th_personalId']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;" colspan="3">
												<h:inputText value="#{semmsi004tab2Bean.contract.contactIdCard}"
												onkeypress="return numberformat.keyPressIntegerOnly(this, event);"
												style="width:400px;" maxlength="13"
												disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:inputText>
											</td>
										</tr>
										<tr>
											<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												
												<h:outputText value="#{jspMsg['label.birthday']} : " styleClass="ms7" />
											</td>
											<td style="width:90%; text-align:left;" colspan="3">
												<rich:calendar locale="th" enableManualInput="true" 
														   datePattern="dd/MM/yyyy" 
														   value="#{semmsi004tab2Bean.contract.contactBirthday}"
														   showWeeksBar="false"
														   inputSize="10"
														   oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
													   	   cellWidth="15px" cellHeight="20px"
													   	   label=""
													   	   styleClass="ms7"
													   	   disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
												</rich:calendar>
											</td>
										</tr>
					                	 
					                	 <tr>
											<td align="left" colspan="4" style="text-decoration: underline">
												<h:outputText value="#{jspMsg['label.contactAddress']}" styleClass="ms7"/>
				                			</td>
					                	 </tr>
					                	 
					                	 <tr>
											<td align="left" colspan="4" >
											<h:panelGrid >
							           		<a4j:commandButton id="btnCopyContact" value="#{jspMsg['btn.copyContact']}" styleClass="rich-button" 
							           		action="#{navAction.navi}" 
							           		reRender="ddlContactAmphurId" 
							           		style="width:170"
							           		oncomplete="copyContactAddress();"
							           		disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
								           		<a4j:actionparam name="navModule" value="si" />
												<a4j:actionparam name="navProgram" value="SEMMSI004TAB2" />
												<a4j:actionparam name="moduleWithNavi" value="si" />
												<a4j:actionparam name="actionWithNavi" value="SEMMSI004Tab2"/>
												<a4j:actionparam name="methodWithNavi" value="doCopyContactAddress" />
							           		</a4j:commandButton>
							           		</h:panelGrid>
							           		
				                			</td>
					                	 </tr>
					                	 <tr>
					                	 	<td colspan="4">
					                	 		<table style="width:100%; border:solid ececec 1px;">
													<tr>
														<td style="vertical-align:top; width:12%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.addressNo']} " styleClass="ms7" />
														</td>
														<td colspan="5">
															<h:inputTextarea id="txtContactHouseNo" value="#{semmsi004tab2Bean.contract.contactHouseNo}"
				                               	 			rows="3" style="width:80%;" styleClass="ms7" disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"></h:inputTextarea>
														</td>
													</tr>
													<tr>
														<td style="width:12%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_building']} : " styleClass="ms7" />
														</td>
														<td style="">
															<h:inputText id="msi004tab2_contactBuilding" value="#{semmsi004tab2Bean.contract.contactbuilding}" 
															maxlength="500" style="width:80%;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_floor']} : " styleClass="ms7" />
														</td>
														<td style="white-space:nowrap;">
															<h:inputText id="msi004tab2_contactFloor" value="#{semmsi004tab2Bean.contract.contactFloor}" 
															style="text-align:right; width:150px;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_roomNumber']} : " style="margin-left:20px;" styleClass="ms7" />
														</td>
														<td style="width:30%; white-space:nowrap;">
															<h:inputText id="msi004tab2_contactRoomNo" value="#{semmsi004tab2Bean.contract.contactRoomNo}" 
															style="text-align:right;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
													</tr>
													<tr>
														<td style="width:12%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_street']} : " styleClass="ms7" />
														</td>
														<td style="" >
															<h:inputText id="msi004tab2_contactStreet" value="#{semmsi004tab2Bean.contract.contactStreet}" 
															style="width:80%;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_tambol']} : " styleClass="ms7" />
														</td>
														<td colspan="3">
															<h:inputText id="msi004tab2_contactTambon" value="#{semmsi004tab2Bean.contract.contactTambon}" 
															style="width:40%;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
													</tr>
													<tr>
														<td style="width:12%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_district']} : " styleClass="ms7" />
														</td>
														<td style="">
															<h:selectOneMenu id="ddlContactAmphurId" value="#{semmsi004tab2Bean.contract.contactAmphurId}"
								                			disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
															<f:selectItems value="#{semmsi004tab2Bean.contactAmphurList}"/>
													 		</h:selectOneMenu>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_province']} : " styleClass="ms7" />
														</td>
														<td style="" >
															<a4j:region>
																<h:selectOneMenu id="ddlContactProvinceId" value="#{semmsi004tab2Bean.contract.contactProvinceId}" 
									                			onchange="GetContactAmphurListJS();" 
									                			disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}">
																<f:selectItems value="#{semmsi004Bean.provinceList}"/>
														 		</h:selectOneMenu>
														 		<a4j:jsFunction name="GetContactAmphurListJS" reRender="ddlContactAmphurId" action="#{semmsi004tab2Action.getContactAmphurList}"/>
																
																
															</a4j:region>
														</td>
														<td style="width:10%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_postCode']} : " styleClass="ms7" />
														</td>
														<td style="width:30%;" >
															<h:inputText id="msi004tab2_contactPostCode" value="#{semmsi004tab2Bean.contract.contactPostcode}" 
															style="text-align:right;" maxlength="5" styleClass="ms7" 
															onkeypress="return numberformat.keyPressIntegerOnly(this, event);" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
													</tr>
													
													<tr>
														<td style="width:12%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.th_localPhone']} : " styleClass="ms7" />
														</td>
														<td style="" colspan="5">
															<h:inputText id="msi004tab2_contactTel" value="#{semmsi004tab2Bean.contract.contactTel}" 
															style="width:300px;" styleClass="ms7"
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
														
															<h:outputText value="#{jspMsg['label.th_mobilePhone']} : " style="padding-left:110px;" styleClass="ms7" />
															<h:inputText id="msi004tab2_contactMobile" value="#{semmsi004tab2Bean.contract.contactMobile}" 
															style="width:300px;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td colspan="2"></td>
													</tr>
													<tr>
														<td style="width:12%; text-align:right; white-space:nowrap;">
															<h:outputText value="#{jspMsg['label.en_fax']} : " styleClass="ms7" />
														</td>
														<td style="" colspan="5">
															<h:inputText id="msi004tab2_contactFax" value="#{semmsi004tab2Bean.contract.contactFax}" 
															style="width:300px;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														
															<h:outputText value="#{jspMsg['label.en_email']} : " style="padding-left:114px;" styleClass="ms7" />
															<h:inputText id="msi004tab2_contactEmail" value="#{semmsi004tab2Bean.contract.contactEmail}" 
															style="width:300px;" styleClass="ms7" 
															disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
														</td>
														<td colspan="2"></td>
													</tr>
												</table>
					                	 	</td>
					                	 </tr>
									</table>
								</rich:panel>
								
							</h:panelGroup>
						</h:panelGrid>
						</a4j:region>
						
						<rich:spacer height="10"></rich:spacer>
						<a4j:region id="rgnEmerContactAddress">
						<h:panelGrid id="pnlEmerContactAddress" width="98%" border="0" cellpadding="0" cellspacing="1">
								<h:panelGroup>
									<rich:panel>
										<table width="97%" >
						                	 <tr>
												<td align="left" colspan="4" style="text-decoration: underline">
												<h:outputText value="#{jspMsg['label.contractEmer']}" styleClass="ms7"/>
					                			</td>
						                	 </tr>
						                	<tr>
												<td style="vertical-align:top; width:10%; text-align:right; white-space:nowrap;">
												<h:outputText value="#{jspMsg['label.contractNameEmer']} :" styleClass="ms7"/>
					                			</td>
					                			<td width="65%" colspan="3">
					                			<h:inputTextarea id="txtEmerContractName" value="#{semmsi004tab2Bean.contract.emerContactName}" 
					                			cols="100" rows="3" 
					                			disabled="#{(semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}"/>
							                	</td>
						                	 </tr>
						                	
						                	 <tr>
						                	 	<td style="width:12%; text-align:right; white-space:nowrap;">
													<h:outputText value="#{jspMsg['label.th_emerPhoneNo']} : " styleClass="ms7" />
												</td>
												<td style="" colspan="5">
													<h:inputText id="msi004tab2_emContactTel" value="#{semmsi004tab2Bean.contract.emerContactTel}" 
													style="width:300px;" styleClass="ms7"
													disabled="#{semmsi004Bean.disabledModeView || (semmsi004tab2Bean.contractInfoEditFlag != 'Y' && semmsi004Bean.reqTypeParam != '01')}" />
															
												</td>
						                	 </tr>
						                	
										</table>
									</rich:panel>
									
								</h:panelGroup>
							</h:panelGrid>
						</a4j:region>
					</rich:panel>
					
					<rich:spacer height="10"></rich:spacer>
					<h:panelGrid  width="100%" border="0" cellpadding="0" cellspacing="1">
					<table id="tblSaveContract" align="right">
					<tr>
	           		<td align="right">
	           		<a4j:commandButton id="btnSaveTab2" value="#{jspMsg['btn.save']}" styleClass="rich-button" 
	           		action="#{navAction.navi}" reRender="frmAddSiteInfo,frmSiteInfoError" >
	           		<a4j:actionparam name="navModule" value="si" />
					<a4j:actionparam name="navProgram" value="SEMMSI004-2" />
					<a4j:actionparam name="moduleWithNavi" value="si" />
					<a4j:actionparam name="actionWithNavi" value="SEMMSI004" />
					<a4j:actionparam name="methodWithNavi" value="doUpdateTab" />
	           		</a4j:commandButton>
	           		</td>
	           		</tr>
	           		</table>
					</h:panelGrid>
		</h:panelGrid>
		</h:panelGrid>
		
