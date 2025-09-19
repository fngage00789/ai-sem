<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab6" style="width:95%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- .. >> -->
			<h:panelGroup style="width:100%;">
				
				<table style="width:100%; border:solid ececec 1px;">
					<tr>
						<td style="width:20%; text-align:right;" class="ms7">
							<h:outputText value="#{jspMsg['label.address.info.from.payee']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<a4j:commandButton id="mmm001tab6Payee_btnCopyVendorAddr" value="Copy Payee Address" styleClass="rich-button"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
							action="#{semmmm001Action.doCopyPayeeAddr}" 
							reRender="oppContent" >
								<a4j:actionparam name="pageParam" value="TAB_06" />
							</a4j:commandButton>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.withhold.name']}" styleClass="ms7" />
						</td>
						<td colspan="3" style="">
							<h:inputText id="mmm001tab6Payee_withholdName" value="#{semmmm001Bean.withholdPayeeAddrObj.withHoldName}"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6Payee_addr1" value="#{semmmm001Bean.withholdPayeeAddrObj.address1}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="35" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6Payee_addr2" value="#{semmmm001Bean.withholdPayeeAddrObj.address2}" 
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
							<h:panelGroup id="tab6Payee_addrGroup1">
								<h:selectOneMenu id="mmm001tab6Payee_tambol" value="#{semmmm001Bean.withholdPayeeAddrObj.tambol}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								styleClass="" style="width:120px;" 
								onchange="mmm001tab6Payee_FillinPostCodeJS();"
								rendered="#{semmmm001Bean.withholdPayeeAddrObj.chkTambolOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.withholdPayeeAddrObj.tambolList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6Payee_FillinPostCodeJS" 
								reRender="mmm001tab6Payee_postCode" 
								action="#{semmmm001Action.doFillinPostCodePayee}">
									<a4j:actionparam  name="fieldAddrParam" value="TAB6_POSTCODE"/>
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab6Payee_tambolOther" value="#{semmmm001Bean.withholdPayeeAddrObj.tambolName}" 
								rendered="#{semmmm001Bean.withholdPayeeAddrObj.chkTambolOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab6Payee_chkTambolOther" 
								value="#{semmmm001Bean.withholdPayeeAddrObj.chkTambolOther}"
								disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent) or semmmm001Bean.withholdPayeeAddrObj.chkAmphurOther}"
								onclick="mmm001tab6Payee_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab6Payee_RenderTambolNameJS" 
								reRender="tab6Payee_addrGroup1, mmm001tab6Payee_tambol, mmm001tab6Payee_tambolOther" 
								action="#{semmmm001Action.renderedTextFieldAddressPayee}">
									<a4j:actionparam  name="fieldAddrParam" value="WH_TAMBOL"/>
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
							<h:panelGroup id="tab6Payee_addrGroup2">
								<h:selectOneMenu id="mmm001tab6Payee_amphur" value="#{semmmm001Bean.withholdPayeeAddrObj.amphur}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								onchange="mmm001tab6Payee_GetTambolListJS();" styleClass="" style="width:120px;"
								rendered="#{semmmm001Bean.withholdPayeeAddrObj.chkAmphurOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.withholdPayeeAddrObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6Payee_GetTambolListJS" 
								reRender="mmm001tab6Payee_tambol, mmm001tab6Payee_postCode" 
								action="#{semmmm001Action.doSetOwnerLocationPayee}"
								oncomplete="mmm001tab6Payee_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab6Payee_amphurOther" value="#{semmmm001Bean.withholdPayeeAddrObj.amphurName}" 
								rendered="#{semmmm001Bean.withholdPayeeAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab6Payee_chkAmphurOther" 
								value="#{semmmm001Bean.withholdPayeeAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								onclick="mmm001tab6Payee_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab6Payee_RenderAmphurNameJS" 
								reRender="tab6Payee_addrGroup1, tab6Payee_addrGroup2, mmm001tab6Payee_tambol, 
								mmm001tab6Payee_tambolOther, mmm001tab6Payee_amphur, mmm001tab6Payee_amphurOther" 
								action="#{semmmm001Action.renderedTextFieldAddressPayee}">
									<a4j:actionparam  name="fieldAddrParam" value="WH_AMPHUR"/>
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
								<h:selectOneMenu id="mmm001tab6Payee_province" value="#{semmmm001Bean.withholdPayeeAddrObj.province}" 
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
								onchange="mmm001tab6Payee_GetAmphurListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.withholdPayeeAddrObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6Payee_GetAmphurListJS" 
								reRender="mmm001tab6Payee_amphur, mmm001tab6Payee_tambol, mmm001tab6Payee_postCode" 
								action="#{semmmm001Action.doSetOwnerLocationPayee}"
								oncomplete="mmm001tab6Payee_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:selectBooleanCheckbox id="mmm001tab6Payee_chkLocalDepartment" 
								value="#{semmmm001Bean.withholdPayeeAddrObj.chkLocalDepartment}"
								disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}"
								onclick="" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab6Payee_postCode" value="#{semmmm001Bean.withholdPayeeAddrObj.postCode}"
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="5" style="width:116px;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab6Payee_contactName" value="#{semmmm001Bean.withholdPayeeAddrObj.contactName}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6Payee_telephone" value="#{semmmm001Bean.withholdPayeeAddrObj.telephone}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6Payee_mobile" value="#{semmmm001Bean.withholdPayeeAddrObj.mobileNo}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6Payee_fax" value="#{semmmm001Bean.withholdPayeeAddrObj.fax}" 
							disabled="#{semmmm001Bean.disableContent and semmmm001Bean.disableEditPayeeContent}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6Payee_email" value="#{semmmm001Bean.withholdPayeeAddrObj.email}" 
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
	
	
	
