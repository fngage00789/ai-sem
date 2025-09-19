<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab1Cmp" style="width:95%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- .. >> -->
			<h:panelGroup style="width:100%;">
				
				<table style="width:100%; border:solid ececec 1px;">
					<tr>
						<td style="width:20%; text-align:right;" class="ms7">
							<h:outputText value="#{jspMsg['label.address.info.from.vendor']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<a4j:commandButton id="mmm001tab1Cmp_btnCopyVendorAddr" value="Copy Vendor Address" styleClass="rich-button"
							action="#{semmmm001Action.doCopyVendorAddrCmp}" 
							reRender="oppContent" >
								<a4j:actionparam name="pageParam" value="TAB_01CMP" />
							</a4j:commandButton>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Cmp_addr1" value="#{semmmm001Bean.rentalAddrCmpObj.address1}" 
							maxlength="35" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Cmp_addr2" value="#{semmmm001Bean.rentalAddrCmpObj.address2}" 
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
							<h:panelGroup id="tab1Cmp_addrGroup1">
								<h:selectOneMenu id="mmm001tab1Cmp_tambol" value="#{semmmm001Bean.rentalAddrCmpObj.tambol}" 
								styleClass="" style="width:120px;"
								onchange="mmm001tab1Cmp_FillinPostCodeJS();"
								rendered="#{semmmm001Bean.rentalAddrCmpObj.chkTambolOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.rentalAddrCmpObj.tambolList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab1Cmp_FillinPostCodeJS" 
								reRender="mmm001tab1Cmp_postCode" 
								action="#{semmmm001Action.doFillinPostCode}">
									<a4j:actionparam  name="fieldAddrParam" value="TAB1_CMP_POSTCODE"/>
								</a4j:jsFunction>
								
								
								<h:inputText id="mmm001tab1Cmp_tambolOther" value="#{semmmm001Bean.rentalAddrCmpObj.tambolName}" 
								rendered="#{semmmm001Bean.rentalAddrCmpObj.chkTambolOther}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab1Cmp_chkTambolOther" 
								value="#{semmmm001Bean.rentalAddrCmpObj.chkTambolOther}"
								disabled="#{semmmm001Bean.rentalAddrCmpObj.chkAmphurOther}"
								onclick="mmm001tab1Cmp_RenderTambolNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.tambol.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab1Cmp_RenderTambolNameJS" 
								reRender="tab1Cmp_addrGroup1, mmm001tab1Cmp_tambol, mmm001tab1Cmp_tambolOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
									<a4j:actionparam  name="fieldAddrParam" value="RT_CMP_TAMBOL"/>
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
							<h:panelGroup id="tab1Cmp_addrGroup2">
								<h:selectOneMenu id="mmm001tab1Cmp_amphur" value="#{semmmm001Bean.rentalAddrCmpObj.amphur}" 
								onchange="mmm001tab1Cmp_GetTambolListJS();" styleClass="" style="width:120px;"
								rendered="#{semmmm001Bean.rentalAddrCmpObj.chkAmphurOther == 'false'}">
									<f:selectItems value="#{semmmm001Bean.rentalAddrCmpObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab1Cmp_GetTambolListJS" 
								reRender="mmm001tab1Cmp_tambol, mmm001tab1Cmp_postCode" 
								action="#{semmmm001Action.doSetOwnerLocation}"
								oncomplete="mmm001tab1Cmp_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:inputText id="mmm001tab1Cmp_amphurOther" value="#{semmmm001Bean.rentalAddrCmpObj.amphurName}" 
								rendered="#{semmmm001Bean.rentalAddrCmpObj.chkAmphurOther}"
								maxlength="150" style="width:200px;" styleClass="" />
								
								<h:selectBooleanCheckbox id="mmm001tab1Cmp_chkAmphurOther" 
								value="#{semmmm001Bean.rentalAddrCmpObj.chkAmphurOther}"
								onclick="mmm001tab1Cmp_RenderAmphurNameJS();" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.amphur.other']}" styleClass="ms7" />
								
								<a4j:jsFunction name="mmm001tab1Cmp_RenderAmphurNameJS" 
								reRender="tab1Cmp_addrGroup1, tab1Cmp_addrGroup2, mmm001tab1Cmp_tambol, 
								mmm001tab1Cmp_tambolOther, mmm001tab1Cmp_amphur, mmm001tab1Cmp_amphurOther" 
								action="#{semmmm001Action.renderedTextFieldAddress}">
									<a4j:actionparam  name="fieldAddrParam" value="RT_CMP_AMPHUR"/>
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
								<h:selectOneMenu id="mmm001tab1Cmp_province" value="#{semmmm001Bean.rentalAddrCmpObj.province}" 
								onchange="mmm001tab1Cmp_GetAmphurListJS();" styleClass="" style="width:120px;">
									<f:selectItems value="#{semmmm001Bean.rentalAddrCmpObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab1Cmp_GetAmphurListJS" 
								reRender="mmm001tab1Cmp_amphur, mmm001tab1Cmp_tambol, mmm001tab1Cmp_postCode" 
								action="#{semmmm001Action.doSetOwnerLocation}"
								oncomplete="mmm001tab1Cmp_FillinPostCodeJS();">
								</a4j:jsFunction>
								
								<h:selectBooleanCheckbox id="mmm001tab1Cmp_chkLocalDepartment" 
								value="#{semmmm001Bean.rentalAddrCmpObj.chkLocalDepartment}"
								onclick="" style="margin:0px 5px 0px 5px; vertical-align:top;" />
								<h:outputText value="#{jspMsg['desc.local.department']}" styleClass="ms7" />
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab1Cmp_postCode" value="#{semmmm001Bean.rentalAddrCmpObj.postCode}"
							onkeypress="return numberformat.keyPressDecimalOnly('mmm001tab1Cmp_postCode', event);"  
							maxlength="5" style="width:116px;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab1Cmp_contactName" value="#{semmmm001Bean.rentalAddrCmpObj.contactName}" 
							
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Cmp_telephone" value="#{semmmm001Bean.rentalAddrCmpObj.telephone}" 
							
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Cmp_mobile" value="#{semmmm001Bean.rentalAddrCmpObj.mobileNo}" 
							
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Cmp_fax" value="#{semmmm001Bean.rentalAddrCmpObj.fax}" 
							 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab1Cmp_email" value="#{semmmm001Bean.rentalAddrCmpObj.email}" 
							
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
				</table>
			</h:panelGroup>
			<!-- .. << -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
