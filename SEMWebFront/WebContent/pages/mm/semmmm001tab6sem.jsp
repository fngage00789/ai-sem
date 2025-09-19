<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

	<f:loadBundle basename="resources.mm.semmmm001" var="jspMsg" />

	<!-- >> wrapper panel -->
	<h:panelGrid id="panelTab2" style="width:100%;" columns="1">
	
		<rich:panel style="height:100%; border:1 ececec solid;">

			<!-- .. >> -->
			<h:panelGroup style="width:100%;">
				
				<table style="width:100%; border:solid ececec 1px;">
					<tr>
						<td style="width:20%; text-align:right;">
							<h:selectBooleanCheckbox id="mmm001tab6_sem_sendto_sap" 
							value="#{semmmm001Bean.withholdSemAddrObj.chkSendToSap}" 
							disabled="#{semmmm001Bean.viewMode}" 
							onclick="" style="margin:0 0 0 10px;" rendered="false"/>
						</td>
						<td colspan="3">
							<h:outputText value="#{jspMsg['desc.upto.sap']}" styleClass="ms7" rendered="false"/>
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['desc.address']} 1 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_sem_addr1" value="#{semmmm001Bean.withholdSemAddrObj.address1}" 
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="500" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['desc.address']} 2 : " styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_sem_addr2" value="#{semmmm001Bean.withholdSemAddrObj.address2}" 
							disabled="#{semmmm001Bean.viewMode}"
							maxlength="500" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_tambol']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
								<h:selectOneMenu id="mmm001tab6_sem_tambol" value="#{semmmm001Bean.withholdSemAddrObj.tambol}" 
								disabled="#{semmmm001Bean.viewMode}" 
								styleClass="" style="width:70%;">
									<f:selectItems value="#{semmmm001Bean.withholdSemAddrObj.tambolList}"/>
								</h:selectOneMenu>
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="* " style="font-style:bold; color:red;" />
							<h:outputText value="#{jspMsg['label.th_amphur']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<a4j:region>
								<h:selectOneMenu id="mmm001tab6_sem_amphur" value="#{semmmm001Bean.withholdSemAddrObj.amphur}" 
								disabled="#{semmmm001Bean.viewMode}" 
								onchange="mmm001tab6_sem_GetTambolListJS();" styleClass="" style="width:70%;">
									<f:selectItems value="#{semmmm001Bean.withholdSemAddrObj.amphurList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6_sem_GetTambolListJS" reRender="mmm001tab6_sem_tambol" 
								action="#{semmmm001Action.doSetOwnerLocation}">
								</a4j:jsFunction>
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
								<h:selectOneMenu id="mmm001tab6_sem_province" value="#{semmmm001Bean.withholdSemAddrObj.province}" 
								disabled="#{semmmm001Bean.viewMode}" 
								onchange="mmm001tab6_sem_GetAmphurListJS();" styleClass="" style="width:70%;">
									<f:selectItems value="#{semmmm001Bean.withholdSemAddrObj.provinceList}"/>
								</h:selectOneMenu>
								
								<a4j:jsFunction name="mmm001tab6_sem_GetAmphurListJS" reRender="mmm001tab6_sem_amphur, mmm001tab6_sem_tambol" 
								action="#{semmmm001Action.doSetOwnerLocation}">
								</a4j:jsFunction>
							</a4j:region>
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_post.code']}" styleClass="ms7" />
						</td>
						<td style="width:30%;" >
							<h:inputText id="mmm001tab6_sem_postCode" value="#{semmmm001Bean.withholdSemAddrObj.postCode}"
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="5" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.contact.name']}" styleClass="ms7" />
						</td>
						<td colspan="3">
							<h:inputText id="mmm001tab6_sem_contactName" value="#{semmmm001Bean.withholdSemAddrObj.contactName}" 
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="500" style="width:89%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.th_telephone']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_sem_telephone" value="#{semmmm001Bean.withholdSemAddrObj.telephone}" 
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.mobile']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_sem_mobile" value="#{semmmm001Bean.withholdSemAddrObj.mobileNo}" 
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
					<tr>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.fax']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_sem_fax" value="#{semmmm001Bean.withholdSemAddrObj.fax}" 
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
						<td style="width:20%; text-align:right;">
							<h:outputText value="#{jspMsg['label.email']}" styleClass="ms7" />
						</td>
						<td style="width:30%;">
							<h:inputText id="mmm001tab6_sem_email" value="#{semmmm001Bean.withholdSemAddrObj.email}" 
							disabled="#{semmmm001Bean.viewMode}" 
							maxlength="50" style="width:70%;" styleClass="" />
						</td>
					</tr>
				</table>
			</h:panelGroup>
			<!-- .. << -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
