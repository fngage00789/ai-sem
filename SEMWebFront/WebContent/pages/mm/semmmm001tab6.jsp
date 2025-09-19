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
							<h:outputText value="#{jspMsg['label.address.info.from.vendor']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<a4j:commandButton id="mmm001tab6_btnCopyVendorAddr" value="Copy Vendor Address" styleClass="rich-button"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
							action="#{semmmm001Action.doCopyVendorAddr}" 
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
							<h:inputText id="mmm001tab6_withholdName" value="#{semmmm001Bean.withholdAddrObj.withHoldName}"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_addr1" value="#{semmmm001Bean.withholdAddrObj.address1}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="35" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_addr2" value="#{semmmm001Bean.withholdAddrObj.address2}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
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
							<h:panelGroup id="tab6_addrGroup1">
								<h:selectOneMenu id="mmm001tab6_tambol" value="#{semmmm001Bean.withholdAddrObj.tambol}" 
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
								styleClass="" style="width:120px;" 
								onchange="mmm001tab6_FillinPostCodeJS();"
								rendered="#{semmmm001Bean.withholdAddrObj.chkTambolOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.withholdAddrObj.tambolList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6_FillinPostCodeJS" 
								reRender="mmm001tab6_postCode" 
								action="#{semmmm001Action.doFillinPostCode}">
									<a4j:actionparam  name="fieldAddrParam" value="TAB6_POSTCODE"/>
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab6_tambolOther" value="#{semmmm001Bean.withholdAddrObj.tambolName}" 
								rendered="#{semmmm001Bean.withholdAddrObj.chkTambolOther}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab6_chkTambolOther" 
								value="#{semmmm001Bean.withholdAddrObj.chkTambolOther}"
								disabled="#{(semmmm001Bean.disableContent and semmmm001Bean.disableEditVendorContent) or semmmm001Bean.withholdAddrObj.chkAmphurOther}"
								onclick="mmm001tab6_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab6_RenderTambolNameJS" 
								reRender="tab6_addrGroup1, mmm001tab6_tambol, mmm001tab6_tambolOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
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
							<h:panelGroup id="tab6_addrGroup2">
								<h:selectOneMenu id="mmm001tab6_amphur" value="#{semmmm001Bean.withholdAddrObj.amphur}" 
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
								onchange="mmm001tab6_GetTambolListJS();" styleClass="" style="width:120px;"
								rendered="#{semmmm001Bean.withholdAddrObj.chkAmphurOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.withholdAddrObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6_GetTambolListJS" 
								reRender="mmm001tab6_tambol, mmm001tab6_postCode" 
								action="#{semmmm001Action.doSetOwnerLocation}"
								oncomplete="mmm001tab6_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab6_amphurOther" value="#{semmmm001Bean.withholdAddrObj.amphurName}" 
								rendered="#{semmmm001Bean.withholdAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab6_chkAmphurOther" 
								value="#{semmmm001Bean.withholdAddrObj.chkAmphurOther}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								onclick="mmm001tab6_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab6_RenderAmphurNameJS" 
								reRender="tab6_addrGroup1, tab6_addrGroup2, mmm001tab6_tambol, 
								mmm001tab6_tambolOther, mmm001tab6_amphur, mmm001tab6_amphurOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
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
								<h:selectOneMenu id="mmm001tab6_province" value="#{semmmm001Bean.withholdAddrObj.province}" 
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
								onchange="mmm001tab6_GetAmphurListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.withholdAddrObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6_GetAmphurListJS" 
								reRender="mmm001tab6_amphur, mmm001tab6_tambol, mmm001tab6_postCode" 
								action="#{semmmm001Action.doSetOwnerLocation}"
								oncomplete="mmm001tab6_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:selectBooleanCheckbox id="mmm001tab6_chkLocalDepartment" 
								value="#{semmmm001Bean.withholdAddrObj.chkLocalDepartment}"
								disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}"
								onclick="" style="margin:0px 5px 0px 5px; vertical-align:top;" rendered="false"/>
								<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" rendered="false"/>
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab6_postCode" value="#{semmmm001Bean.withholdAddrObj.postCode}"
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="5" style="width:116px;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab6_contactName" value="#{semmmm001Bean.withholdAddrObj.contactName}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_telephone" value="#{semmmm001Bean.withholdAddrObj.telephone}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_mobile" value="#{semmmm001Bean.withholdAddrObj.mobileNo}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_fax" value="#{semmmm001Bean.withholdAddrObj.fax}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_email" value="#{semmmm001Bean.withholdAddrObj.email}" 
							disabled="#{semmmm001Bean.validatePage.addressBox == 'N'}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
				</table>
			</h:panelGroup>
			<!-- .. << -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
