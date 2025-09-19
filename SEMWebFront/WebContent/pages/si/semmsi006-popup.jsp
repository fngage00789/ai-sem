<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi006" var="jspMsg"/>
<rich:modalPanel id="popupApproveRenewEdit" width="400" autosized="true">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg['header.popupApproveRenew']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidepopupApproveRenewEdit" style="cursor:pointer"/>
				<rich:componentControl for="popupApproveRenewEdit" attachTo="hidepopupApproveRenewEdit" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<a4j:form id="popupFrmAdd"> 
		<h:panelGrid width="400" id="grdPopupApproveRenewEdit">
			<rich:panel id="pnlPopupApproveRenewEdit">
				<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupName']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
						
						
							<table width="100%">
								<tr>
									<td align="right" width="40%">
										<h:outputText value="#{jspMsg['label.renewAgeCode']}" styleClass="ms7"/>
		                			</td>
		                			<td width="60%">
		                				<h:selectOneMenu id="ddlRenewAgeCode" value="#{semmsi006Bean.sendRenew.renewAgeCode}">
											<f:selectItems value="#{semmsi006Bean.renewAgeCodeList}"/>
										</h:selectOneMenu>
				                	</td>      	
		                		</tr>
		                		<tr>
		                			<td align="right" width="40%" valign="top">
		                			<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="60%">
		                			<h:inputTextarea id="txtRemark" value="#{semmsi006Bean.sendRenew.remark}" rows="3" cols="40"/>
		                			</td>
		                		</tr>
		                		<tr>
			                		<td>
									
									</td>
									<td>
									<a4j:commandButton id="btnPopupSave" value="#{jspMsg['btn.popup.save']}" styleClass="rich-button"
									 action="#{navAction.navi}" reRender="popupFrmAdd,frmError,frmSearchResult,pnlSearchResult"
									 oncomplete="reRenderPopup()">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI006" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI006" />
										<a4j:actionparam name="methodWithNavi" value="doUpdate" />
										<a4j:jsFunction name="reRenderPopup" 
										reRender="pnlSearchResult,#{semmsi006Bean.validatePopup}"></a4j:jsFunction>
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnPopupCancle" value="Cancel" styleClass="rich-button">
										<rich:componentControl for="popupApproveRenewEdit" operation="hide" event="onclick" />
									</a4j:commandButton>
									</td>	
			                	</tr>
			            	</table>
						</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
		
					</rich:panel>
				</h:panelGrid>
	</a4j:form>
</rich:modalPanel>