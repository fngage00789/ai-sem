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
						<td >
							
						</td>
						<td>
							<a4j:commandButton id="btnCopyVendorAddr" value="Copy Vendor Address" styleClass="rich-button"
											action="#{semmmm001Action.doCopyVendorAddr}" 
											reRender="payeeDetail, payeeInfoAddress1, payeeInfoAddress2, payeeInfoTambol, 
											payeeInfoAmphur, payeeInfoProvince, payeeInfoPostCode,panelTab0" 
											disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}">
												<a4j:actionparam name="pageParam" value="PAGE_PAYEE" />
											</a4j:commandButton>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab0_addr1" value="#{semmmm001Bean.payeeAddrObj.address1}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="35" style="width:70%;" styleClass="" />
							
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab0_addr2" value="#{semmmm001Bean.payeeAddrObj.address2}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="35" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_tambol']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
							<h:panelGroup id="tab0Payee_addrGroup1">
								<h:selectOneMenu id="mmm001tab0Payee_tambol" value="#{semmmm001Bean.payeeAddrObj.tambol}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								rendered="#{semmmm001Bean.payeeAddrObj.chkTambolOther == 'false'}" 
								onchange="mmm001tab0Payee_FillinPostCodeJS();"
								style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.payeeAddrObj.tambolList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab0Payee_FillinPostCodeJS" 
								reRender="mmm001tab0Payee_postCode" 
								action="#{semmmm001Action.doFillinPostCodePayee}">
									<a4j:actionparam  name="fieldAddrParam" value="TAB0_POSTCODE"/>
								</a4j:jsFunction>
								
								
								<h:inputText id="mmm001tab0_tambolOther" value="#{semmmm001Bean.payeeAddrObj.tambolName}" 
								rendered="#{semmmm001Bean.payeeAddrObj.chkTambolOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab0_chkTambolOther" 
								value="#{semmmm001Bean.payeeAddrObj.chkTambolOther}"
								disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent) or semmmm001Bean.payeeAddrObj.chkAmphurOther}"
								onclick="mmm001tab0Payee_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab0Payee_RenderTambolNameJS" 
								reRender="tab0Payee_addrGroup1, mmm001tab0Payee_tambol, mmm001tab0Payee_tambolOther" 
								action="#{semmmm001Action.renderedTextFieldAddressPayee}">
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
							<h:panelGroup id="tab0Payee_addrGroup2">
								<h:selectOneMenu id="mmm001tab0Payee_amphur" value="#{semmmm001Bean.payeeAddrObj.amphur}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								rendered="#{semmmm001Bean.payeeAddrObj.chkAmphurOther == 'false'}"
								onchange="mmm001tab0Payee_GetTambolListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.payeeAddrObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab0Payee_GetTambolListJS" 
								reRender="tab0Payee_addrGroup1, mmm001tab0Payee_tambol, mmm001tab0Payee_postCode" 
								action="#{semmmm001Action.doSetOwnerLocationPayee}"
								oncomplete="mmm001tab0Payee_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab0Payee_amphurOther" value="#{semmmm001Bean.payeeAddrObj.amphurName}" 
								rendered="#{semmmm001Bean.payeeAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab0Payee_chkAmphurOther" 
								value="#{semmmm001Bean.payeeAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								onclick="mmm001tab0Payee_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								
								<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab0Payee_RenderAmphurNameJS" 
								reRender="tab0Payee_addrGroup1, tab0Payee_addrGroup2, mmm001tab0Payee_amphur, mmm001tab0Payee_amphurOther" 
								action="#{semmmm001Action.renderedTextFieldAddressPayee}">
									<a4j:actionparam  name="fieldAddrParam" value="VD_AMPHUR"/>
								</a4j:jsFunction>
							</h:panelGroup>
							</a4j:region>
							
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_province']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
								<h:selectOneMenu id="mmm001tab0Payee_province" value="#{semmmm001Bean.payeeAddrObj.province}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								onchange="mmm001tab0Payee_GetAmphurListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.payeeAddrObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab0Payee_GetAmphurListJS" 
								reRender="mmm001tab0Payee_amphur, mmm001tab0Payee_tambol, mmm001tab0Payee_postCode" 
								action="#{semmmm001Action.doSetOwnerLocationPayee}"
								oncomplete="mmm001tab0Payee_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:selectBooleanCheckbox id="mmm001tab0Payee_chkLocalDepartment" 
								value="#{semmmm001Bean.payeeAddrObj.chkLocalDepartment}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								onclick="" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
							</a4j:region>
							
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab0Payee_postCode" value="#{semmmm001Bean.payeeAddrObj.postCode}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="5" style="width:116px;" styleClass="" />
							
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab0Payee_contactName" value="#{semmmm001Bean.payeeAddrObj.contactName}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0Payee_tele_sendto_sap" 
							value="#{semmmm001Bean.payeeAddrObj.chkTelephoneSapFlag}"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" rendered="false"/>
							<h:outputText value="#{jspMsg['desc.telephone.upto.sap']}" styleClass="ms7" rendered="false"/>
							<br/>
						
							<h:inputText id="mmm001tab0Payee_telephone" value="#{semmmm001Bean.payeeAddrObj.telephone}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0Payee_mobi_sendto_sap" 
							value="#{semmmm001Bean.payeeAddrObj.chkMobileNoSapFlag}"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" rendered="false"/>
							<h:outputText value="#{jspMsg['desc.mobile.upto.sap']}" styleClass="ms7" rendered="false"/>
							<br/>
							
							<h:inputText id="mmm001tab0Payee_mobile" value="#{semmmm001Bean.payeeAddrObj.mobileNo}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0Payee_fax_sendto_sap"
							value="#{semmmm001Bean.payeeAddrObj.chkFaxSapFlag}"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" rendered="false"/>
							<h:outputText value="#{jspMsg['desc.fax.upto.sap']}" styleClass="ms7" rendered="false"/>
							<br/>
							
							<h:inputText id="mmm001tab0Payee_fax" value="#{semmmm001Bean.payeeAddrObj.fax}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:selectBooleanCheckbox id="mmm001tab0Payee_email_sendto_sap" 
							value="#{semmmm001Bean.payeeAddrObj.chkEmailSapFlag}"
							rendered="false"
							onclick="" style="margin:0px 5px 0px -3px; vertical-align:middle;" />
							<h:outputText value="#{jspMsg['desc.email.upto.sap']}" styleClass="ms7" rendered="false"/>
							<br/>
							
							<h:inputText id="mmm001tab0Payee_email" value="#{semmmm001Bean.payeeAddrObj.email}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
							
							
						</td>
					</tr>
				</table>
			</h:panelGroup>
			<!-- .. << -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
