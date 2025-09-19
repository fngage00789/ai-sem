<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab0" style="width:95%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- .. >> -->
			<h:panelGroup style="width:100%;">
			
				<table style="width:100%; border:solid ececec 1px;">
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab0_addr1" value="#{semmmm001Bean.vendorAddrObj.address1}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							maxlength="35" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address1}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address1 != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab0_addr2" value="#{semmmm001Bean.vendorAddrObj.address2}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							maxlength="35" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address2}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address2 != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" rendered="false"/>
							<h:outputText value="#{jspMsg['desc.address']} 3 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab0_addr3" value="#{semmmm001Bean.vendorAddrObj.address3}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							maxlength="35" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address3}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address3 != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 4 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab0_addr4" value="#{semmmm001Bean.vendorAddrObj.address4}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							maxlength="35" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address4}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.address4 != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
					</tr>					
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_tambol']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
							<h:panelGroup id="tab0_addrGroup1">
								<h:selectOneMenu id="mmm001tab0_tambol" value="#{semmmm001Bean.vendorAddrObj.tambol}" 
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								rendered="#{semmmm001Bean.vendorAddrObj.chkTambolOther == 'false'}" 
								onchange="mmm001tab0_FillinPostCodeJS();"
								styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.vendorAddrObj.tambolList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab0_FillinPostCodeJS" 
								reRender="mmm001tab0_postCode" 
								action="#{semmmm001Action.doFillinPostCode}">
									<a4j:actionparam  name="fieldAddrParam" value="TAB0_POSTCODE"/>
								</a4j:jsFunction>
								
								
								<h:inputText id="mmm001tab0_tambolOther" value="#{semmmm001Bean.vendorAddrObj.tambolName}" 
								rendered="#{semmmm001Bean.vendorAddrObj.chkTambolOther}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab0_chkTambolOther" 
								value="#{semmmm001Bean.vendorAddrObj.chkTambolOther}"
								disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent) or semmmm001Bean.vendorAddrObj.chkAmphurOther}"
								onclick="mmm001tab0_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
								
								<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.tambolName}" 
								rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.tambolName != null}"
								style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
								
								<a4j:jsFunction name="mmm001tab0_RenderTambolNameJS" 
								reRender="tab0_addrGroup1, mmm001tab0_tambol, mmm001tab0_tambolOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
									<a4j:actionparam  name="fieldAddrParam" value="VD_TAMBOL"/>
								</a4j:jsFunction>
							</h:panelGroup>
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_amphur']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
							<h:panelGroup id="tab0_addrGroup2">
								<h:selectOneMenu id="mmm001tab0_amphur" value="#{semmmm001Bean.vendorAddrObj.amphur}" 
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
								rendered="#{semmmm001Bean.vendorAddrObj.chkAmphurOther == 'false'}"
								onchange="mmm001tab0_GetTambolListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.vendorAddrObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab0_GetTambolListJS" 
								reRender="mmm001tab0_tambol, mmm001tab0_postCode" 
								action="#{semmmm001Action.doSetOwnerLocation}"
								oncomplete="mmm001tab0_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab0_amphurOther" value="#{semmmm001Bean.vendorAddrObj.amphurName}" 
								rendered="#{semmmm001Bean.vendorAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab0_chkAmphurOther" 
								value="#{semmmm001Bean.vendorAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								onclick="mmm001tab0_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								
								<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab0_RenderAmphurNameJS" 
								reRender="tab0_addrGroup1, tab0_addrGroup2, mmm001tab0_amphur, mmm001tab0_amphurOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
									<a4j:actionparam  name="fieldAddrParam" value="VD_AMPHUR"/>
								</a4j:jsFunction>
							</h:panelGroup>
							</a4j:region>
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.amphurName}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.amphurName != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_province']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
								<h:selectOneMenu id="mmm001tab0_province" value="#{semmmm001Bean.vendorAddrObj.province}" 
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
								onchange="mmm001tab0_GetAmphurListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.vendorAddrObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab0_GetAmphurListJS" 
								reRender="mmm001tab0_amphur, mmm001tab0_tambol, mmm001tab0_postCode" 
								action="#{semmmm001Action.doSetOwnerLocation}"
								oncomplete="mmm001tab0_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								
							</a4j:region>
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.provinceName}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.provinceName != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab0_postCode" value="#{semmmm001Bean.vendorAddrObj.postCode}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							maxlength="5" style="width:116px;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.postCode}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.postCode != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab0_contactName" value="#{semmmm001Bean.vendorAddrObj.contactName}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0_tele_sendto_sap" 
							value="#{semmmm001Bean.vendorAddrObj.chkTelephoneSapFlag}"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" />
							<h:outputText value="#{jspMsg['desc.telephone.upto.sap']}" styleClass="ms7" />
							<br/>
						
							<h:inputText id="mmm001tab0_telephone" value="#{semmmm001Bean.vendorAddrObj.telephone}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.telephone}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.telephone != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0_mobi_sendto_sap" 
							value="#{semmmm001Bean.vendorAddrObj.chkMobileNoSapFlag}"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" />
							<h:outputText value="#{jspMsg['desc.mobile.upto.sap']}" styleClass="ms7" />
							<br/>
							
							<h:inputText id="mmm001tab0_mobile" value="#{semmmm001Bean.vendorAddrObj.mobileNo}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.mobileNo}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.mobileNo != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0_fax_sendto_sap"
							value="#{semmmm001Bean.vendorAddrObj.chkFaxSapFlag}"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" />
							<h:outputText value="#{jspMsg['desc.fax.upto.sap']}" styleClass="ms7" />
							<br/>
							
							<h:inputText id="mmm001tab0_fax" value="#{semmmm001Bean.vendorAddrObj.fax}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.fax}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.fax != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0_email_sendto_sap" 
							value="#{semmmm001Bean.vendorAddrObj.chkEmailSapFlag}"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" />
							<h:outputText value="#{jspMsg['desc.email.upto.sap']}" styleClass="ms7" />
							<br/>
							
							<h:inputText id="mmm001tab0_email" value="#{semmmm001Bean.vendorAddrObj.email}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
							<h:outputText value="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.email}" 
							rendered="#{semmmm001Bean.vendorInfoMissMatchWithSAPObj.email != null}"
							style="color:red; padding-left:4px; display:block;" styleClass="ms7"/>
						</td>
					</tr>
				</table>
			</h:panelGroup>
			<!-- .. << -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
