<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab1" style="width:95%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- .. >> -->
			<h:panelGroup style="width:100%;">
				
				<table style="width:100%; border:solid ececec 1px;">
					<tr>
						<td style="width:20%; text-align:right;" class="ms7">
							<h:outputText value="#{jspMsg['label.address.info.from.payee']}" styleClass="ms7" rendered="true"/>
						</td>
						<td colspan="3">
							<a4j:commandButton id="mmm001tab1Payee_btnCopyVendorAddr" value="Copy Payee Address" styleClass="rich-button"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							action="#{semmmm001Action.doCopyPayeeAddr}" 
							reRender="panelTab1" rendered="true">
								<a4j:actionparam name="pageParam" value="TAB_01" />
							</a4j:commandButton>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Payee_addr1" value="#{semmmm001Bean.rentalPayeeAddrObj.address1}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="35" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Payee_addr2" value="#{semmmm001Bean.rentalPayeeAddrObj.address2}" 
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
							<h:panelGroup id="tab1Payee_addrGroup1">
								<h:selectOneMenu id="mmm001tab1Payee_tambol" value="#{semmmm001Bean.rentalPayeeAddrObj.tambol}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								rendered="#{semmmm001Bean.rentalPayeeAddrObj.chkTambolOther == 'false'}"
								onchange="mmm001tab1Payee_FillinPostCodeJS()"
								styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.rentalPayeeAddrObj.tambolList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab1Payee_FillinPostCodeJS" 
								reRender="mmm001tab1Payee_postCode" 
								action="#{semmmm001Action.doFillinPostCodePayee}">
									<a4j:actionparam  name="fieldAddrParam" value="TAB1_POSTCODE"/>
								</a4j:jsFunction>
								
								
								<h:inputText id="mmm001tab1Payee_tambolOther" value="#{semmmm001Bean.rentalPayeeAddrObj.tambolName}" 
								rendered="#{semmmm001Bean.rentalPayeeAddrObj.chkTambolOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab1Payee_chkTambolOther" 
								value="#{semmmm001Bean.rentalPayeeAddrObj.chkTambolOther}"
								disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent) or semmmm001Bean.rentalPayeeAddrObj.chkAmphurOther}"
								onclick="mmm001tab1Payee_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab1Payee_RenderTambolNameJS" 
								reRender="tab1Payee_addrGroup1, mmm001tab1Payee_tambol, mmm001tab1Payee_tambolOther" 
								action="#{semmmm001Action.renderedTextFieldAddressPayee}">
									<a4j:actionparam  name="fieldAddrParam" value="RT_TAMBOL"/>
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
							<h:panelGroup id="tab1Payee_addrGroup2">
								<h:selectOneMenu id="mmm001tab1Payee_amphur" value="#{semmmm001Bean.rentalPayeeAddrObj.amphur}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								onchange="mmm001tab1Payee_GetTambolListJS();" styleClass="" style="width:120px;"
								rendered="#{semmmm001Bean.rentalPayeeAddrObj.chkAmphurOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.rentalPayeeAddrObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab1Payee_GetTambolListJS" 
								reRender="mmm001tab1Payee_tambol, mmm001tab1Payee_postCode" 
								action="#{semmmm001Action.doSetOwnerLocationPayee}"
								oncomplete="mmm001tab1Payee_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab1Payee_amphurOther" value="#{semmmm001Bean.rentalPayeeAddrObj.amphurName}" 
								rendered="#{semmmm001Bean.rentalPayeeAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab1Payee_chkAmphurOther" 
								value="#{semmmm001Bean.rentalPayeeAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								onclick="mmm001tab1Payee_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab1Payee_RenderAmphurNameJS" 
								reRender="tab1Payee_addrGroup1, tab1Payee_addrGroup2, mmm001tab1Payee_tambol, 
								mmm001tab1Payee_tambolOther, mmm001tab1Payee_amphur, mmm001tab1Payee_amphurOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
									<a4j:actionparam  name="fieldAddrParam" value="RT_AMPHUR"/>
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
								<h:selectOneMenu id="mmm001tab1Payee_province" value="#{semmmm001Bean.rentalPayeeAddrObj.province}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								onchange="mmm001tab1Payee_GetAmphurListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.rentalPayeeAddrObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab1Payee_GetAmphurListJS" 
								reRender="mmm001tab1Payee_amphur, mmm001tab1Payee_tambol, mmm001tab1Payee_postCode" 
								action="#{semmmm001Action.doSetOwnerLocationPayee}"
								oncomplete="mmm001tab1Payee_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:selectBooleanCheckbox id="mmm001tab1Payee_chkLocalDepartment" 
								value="#{semmmm001Bean.rentalPayeeAddrObj.chkLocalDepartment}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								onclick="" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab1Payee_postCode" value="#{semmmm001Bean.rentalPayeeAddrObj.postCode}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="5" style="width:116px;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab1Payee_contactName" value="#{semmmm001Bean.rentalPayeeAddrObj.contactName}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Payee_telephone" value="#{semmmm001Bean.rentalPayeeAddrObj.telephone}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Payee_mobile" value="#{semmmm001Bean.rentalPayeeAddrObj.mobileNo}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Payee_fax" value="#{semmmm001Bean.rentalPayeeAddrObj.fax}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Payee_email" value="#{semmmm001Bean.rentalPayeeAddrObj.email}" 
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
	
	
	
