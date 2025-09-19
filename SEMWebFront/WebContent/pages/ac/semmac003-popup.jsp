<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.account.semmac003" var="jspMsgPopup"/>
	<rich:modalPanel id="popupSapErrorLog" width="400" autosized="true">
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="Update Status - Edit"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupSapErrorLog" style="cursor:pointer"/>
					<rich:componentControl for="popupSapErrorLog" attachTo="hidePopupSapErrorLog" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="popupFrmSapErrorLog"> 
			<rich:panel id="pnlSapErrorLog">
				<f:facet name="header">
							<h:outputText value="Update Status"/>
				</f:facet>
			<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
				                	<td valign="top" width="10%">
										<h:outputText value="Status :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:selectOneMenu id="ddlPopupErrorStatus" value="#{semmac003Bean.tmpStatus}">
												<f:selectItems value="#{semmac003Bean.errorStatusList}"/>
										</h:selectOneMenu>
				                	</td>
				                </tr>
			                	<tr>
				                	<td width="10%">
				                		<h:outputText value="Remark :" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<h:inputTextarea id="txtPopupRemark" value="#{semmac003Bean.tmpRemark}" rows="3" cols="30"></h:inputTextarea>
				                	</td>
			                	 </tr>
			                	 <tr>
			                	 <td colspan="4">
			                	 		<!-- end content criteria -->
								<h:panelGroup>
									<a4j:commandButton id="btnPopupSapSave" value="Save" styleClass="rich-button"
									 action="#{navAction.navi}" reRender="dtbMac003Srch,frmError" >
										<a4j:actionparam name="navModule" value="ac" />
										<a4j:actionparam name="navProgram" value="SEMMAC003-1" />
										<a4j:actionparam name="moduleWithNavi" value="ac" />
										<a4j:actionparam name="actionWithNavi" value="SEMMAC003" />
										<a4j:actionparam name="methodWithNavi" value="doUpdate" />
										<rich:componentControl for="popupSapErrorLog" operation="hide" event="onclick" />
									</a4j:commandButton>
									<rich:spacer width="10"/>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true"
									 reRender="dtbMac003Srch,frmError">
										<rich:componentControl for="popupSapErrorLog" operation="hide" event="onclick" />
									</a4j:commandButton>
								</h:panelGroup>
			                	 </td>
			                	 </tr>
			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>