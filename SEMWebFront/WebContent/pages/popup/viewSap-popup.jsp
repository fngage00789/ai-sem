<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.account.semmac001" var="jspMsgPopup"/>
	<rich:modalPanel id="popupView" width="470" minWidth="250" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsgPopup['header.popupRemarkApprove']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupView" style="cursor:pointer"/>
					<rich:componentControl for="popupView" attachTo="hidePopupView" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupFrmView">
			<rich:panel id="pnlPopupView">
				<f:facet name="header">
							<h:outputText value="#{jspMsgPopup['header.popupView']} - View"/>
				</f:facet> 
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									
									<td width="20%">
										<h:outputText value="#{jspMsgPopup['label.popupView1']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:outputText id="txtPaymentStatusDesc" value="#{semmac001Bean.mac001SrchR.paymentStatusDesc}" styleClass="ms7"/>
				                	</td>
			                	 </tr>
			                	 <tr>
				                	<td width="20%">
				                		<h:outputText value="#{jspMsgPopup['label.popupView2']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:outputText id="txtPaymentStatusDt" value="#{semmac001Bean.mac001SrchR.paymentStatusDt}" styleClass="ms7">
		                					<f:convertDateTime type="date" pattern="dd/MM/yyyy" locale="en" />
		                				</h:outputText>
		                			</td>
				                </tr>
				                <tr>
				                	<td width="10%">
				                		<h:outputText value="#{jspMsgPopup['label.popupRemark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:outputText id="txtReason" value="#{semmac001Bean.mac001SrchR.reason}" styleClass="ms7"/>
		                			</td>
				                </tr>	
				                 <tr>
				                	<td width="20%">
				                		<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
											 reRender="dtbMac001Srch,frmError">
											<rich:componentControl for="popupView" operation="hide" event="onclick" />
										</a4j:commandButton>	
		                			</td>
				                </tr>
				                                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>