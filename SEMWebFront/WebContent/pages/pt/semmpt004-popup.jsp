<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt004" var="jspMsg"/>	
	<rich:modalPanel id="popupShowContractNo" width="600" minWidth="250" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupShowContractNo']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupShowContractNo" style="cursor:pointer"/>
					<rich:componentControl for="popupShowContractNo" attachTo="hidePopupShowContractNo" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupFrmShowContractNo">
			<rich:panel id="pnlShowContractNo">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupShowContractNo']}"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td colspan="4" width="100%">
										<h:outputText value="#{semmpt004Bean.concatContractNo}" styleClass="ms7"/>
		                			</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%">
		                			</td>
		                			<td colspan="3">
				                	</td>
				                	
			                	 </tr>
			                	 <tr>
			                	 	<td align="left">
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" >
										<rich:componentControl for="popupShowContractNo" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>