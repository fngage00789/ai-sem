<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<rich:hotKey key="backspace" handler="return false;" disableInInput="true"/>
<f:loadBundle basename="resources.el.semmel005-4" var="jspMsg"/>
<a4j:form id="frmUpdateStatusDialog">
<h:panelGrid width="100%">
		
		<rich:modalPanel id="mdpUpdateStatus" autosized="true">	

	<f:facet name="header">
    	<h:outputText value="#{jspMsg['header.updateStatusPopup']}"></h:outputText>
    </f:facet>
	
	
		<table width="500px" border="0" cellspacing="" cellpadding="2">			
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnItem']}" styleClass="ms7" />
			
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnItem}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnMorTor']}" styleClass="ms7" />
					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnMorTor}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnMru']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnMru}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnMeterId']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnMeterId}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnName']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnName}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnAddress']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnAddress}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnVoltage']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnVoltage}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnKw']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnKw}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnMultiply']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnMultiply}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnPmrDt']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnPmrDt}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnMrDt']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnMrDt}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnPmr']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnPmr}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnMr']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnMr}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnUnit']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnUnit}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnAmt']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnAmt}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnVatAmt']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnVatAmt}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnRateCat']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnRateCat}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="right">
					<h:outputText value="#{jspMsg['label.popup.pnInvNo']}" styleClass="ms7" />					
				</td>
				<td align="left">
					<h:inputText value="#{semmel005Bean.uploadText.pnInvNo}" styleClass="ms7" style="width : 160px"/>
				</td>
			</tr>
			<tr>
				<td align="left" colspan="2">
					<a4j:commandButton value="#{jspMsg['btn.save']}" styleClass="rich-button" action="#{navAction.navi}" reRender="oppContent">
						<a4j:actionparam name="navModule" value="el" />
						<a4j:actionparam name="navProgram" value="SEMMEL005-4" />
						<a4j:actionparam name="moduleWithNavi" value="el" />
						<a4j:actionparam name="actionWithNavi" value="SEMMEL005" />
						<a4j:actionparam name="methodWithNavi" value="doUpdateELPAY07" />
					</a4j:commandButton>
					<rich:spacer width="10"/>
					<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button">
					    <rich:componentControl for="mdpUpdateStatus" operation="hide" event="onclick" />
					</a4j:commandButton>
				</td>
			</tr>
		</table>	
		
	
	
</rich:modalPanel>
</h:panelGrid>
</a4j:form>
