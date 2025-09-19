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
				
				<table style="width:80%; border:solid ececec 1px;" align="center">
					
					<tr>
						<td style="width:10%; text-align:left;">
							
							<h:outputText value="#{jspMsg['desc.address']} 1" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_addr1" value="#{semmmm001Bean.rentalPayeeAddrHistObj.address1}" 
							 styleClass="ms7" />
						</td>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['desc.address']} 2" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_addr2" value="#{semmmm001Bean.rentalPayeeAddrHistObj.address2}" 
							styleClass="ms7" />
						</td>
					</tr>
					<tr>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.th_tambolTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_tambol" value="#{semmmm001Bean.rentalPayeeAddrHistObj.tambolTxt}" styleClass="ms7" />
						</td>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.th_amphurTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_amphur" value="#{semmmm001Bean.rentalPayeeAddrHistObj.amphurTxt}" styleClass="ms7" />
							
						</td>
					</tr>
					<tr>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.th_provinceTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_province" value="#{semmmm001Bean.rentalPayeeAddrHistObj.provinceTxt}" styleClass="ms7" />
						</td>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.th_post.codeTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_postCode" value="#{semmmm001Bean.rentalPayeeAddrHistObj.postCode}" 
							styleClass="ms7" />
						</td>
					</tr>
					<tr>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.contact.nameTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_contactName" value="#{semmmm001Bean.rentalPayeeAddrHistObj.contactName}" 
							styleClass="ms7" />
						</td>
					</tr>
					<tr>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.th_telephoneTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_telephone" value="#{semmmm001Bean.rentalPayeeAddrHistObj.telephone}" 
							styleClass="ms7" />
						</td>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.mobileTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_mobile" value="#{semmmm001Bean.rentalPayeeAddrHistObj.mobileNo}" 
							styleClass="ms7" />
						</td>
					</tr>
					<tr>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.faxTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_fax" value="#{semmmm001Bean.rentalPayeeAddrHistObj.fax}" 
							styleClass="ms7" />
						</td>
						<td style="width:10%; text-align:left;">
							<h:outputText value="#{jspMsg['label.emailTxt']}" styleClass="ms7" />
						</td>
						<td style="width:1%;" >
							<h:outputText value=":" styleClass="ms7"/>
						</td>
						<td style="width:28%;text-align:left;">
							<h:outputText id="mmm001tab1_email" value="#{semmmm001Bean.rentalPayeeAddrHistObj.email}" 
							styleClass="ms7" />
						</td>
					</tr>
				</table>
			</h:panelGroup>
			<!-- .. << -->
				
		</rich:panel>	
	</h:panelGrid>
	<!-- << wrapper panel -->
	
	
	
