<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.siteinfo.semmsi004" var="jspMsg"/>
<h:panelGrid width="100%">
	<rich:panel>
		<f:facet name="header"><h:outputText value="#{jspMsg['tab.header.rent']}"/></f:facet>	
			<h:panelGrid>
			<a4j:form id="frmErrorRentCond">
				<h:messages errorClass="ms7red" warnClass="ms7green" infoClass="ms7blue" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>	
		<h:panelGrid columnClasses="gridContent" width="100%">
				<!-- begin content layout criteria -->
				<h:panelGrid width="90%">
				<a4j:form id="frmRentCond">
					<rich:panel id="pnlRentCond">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.panel.rentCond']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="25%">
									<h:outputText value="#{jspMsg['label.condition']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%">
		                			<h:selectOneRadio id="rbtRentCondType" value=""  styleClass="ms7" rendered="true">
	                				<f:selectItem itemValue="01" itemLabel="#{jspMsg['label.normal']}" />
	                				<f:selectItem itemValue="02" itemLabel="#{jspMsg['label.extra']}"/>
		                		</h:selectOneRadio>
			                	 </tr>
								 
			                </table>
			                </h:panelGroup>
			                
			                </h:panelGrid>
			               
			               
						
					</rich:panel>
					
					</a4j:form>
				</h:panelGrid>
			
				<!-- end content layout criteria -->
				
				</h:panelGrid>
			
			</rich:panel>
		</h:panelGrid>


