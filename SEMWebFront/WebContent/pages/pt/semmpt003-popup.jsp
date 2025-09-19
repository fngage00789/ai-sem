<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j" %>

<f:loadBundle basename="resources.propertyTax.semmpt003" var="jspMsg"/>	
	<rich:modalPanel id="popupShowEditProperty" width="800" minWidth="500" moveable="false" height="300" >
		<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.popupShowEditProperty']}"></h:outputText>
			</h:panelGroup>
		</f:facet>
		<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
				    <h:graphicImage value="images/ico_close.png" id="hidePopupShowEditProperty" style="cursor:pointer"/>
					<rich:componentControl for="popupShowEditProperty" attachTo="hidePopupShowEditProperty" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
		</f:facet>
		<a4j:form id="frmErrorPopup">
				 <rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmpt003Bean.renderedMsgFormSearch}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		<a4j:form id="popupFrmShowEditProperty">
			<rich:panel id="pnlShowEditProperty">
				<f:facet name="header">
							<h:outputText value="Edit"/>
				</f:facet> 
			<h:panelGrid width="90%" border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
								<tr>
									<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.contractNo']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
										<h:inputText value="#{semmpt003Bean.mpt003Srch.editContractNo}" disabled="true"/>
		                			</td>
		                			<td width="20%" align="right">
										<h:outputText value="#{jspMsg['lebal.pTaxYear']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
										<h:inputText value="#{semmpt003Bean.mpt003Srch.editPTaxYear}" disabled="true"/>
		                			</td>
			                	 </tr>
			                	 <tr>
				                	<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.rentPreAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
										<h:inputText id="editRentPreId" value="#{semmpt003Bean.mpt003Srch.editRentPreAmt}" disabled="true">
										<f:convertNumber pattern="#,##0.00"/>
										</h:inputText>
		                			</td>
		                			<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.rentAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
										<h:inputText id="editRentId" value="#{semmpt003Bean.mpt003Srch.editRentAmt}" disabled="#{semmpt003Bean.disableEditPropertyTax}">
										<f:convertNumber pattern="#,##0.00"/>
										</h:inputText>
		                			</td>
			                	 </tr>
			                	 <tr>
			                	 	<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.pTaxAmt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%" align="left">
										<h:inputText id="editPTax" value="#{semmpt003Bean.mpt003Srch.editPtaxAmt}" disabled="#{semmpt003Bean.disableEditPropertyTax}">
										<f:convertNumber pattern="#,##0.00"/>
										</h:inputText>
		                			</td>
				                	<td width="20%" align="right">
										<h:outputText value="#{jspMsg['label.edit']}" styleClass="ms7"/>
		                			</td>
		                			<td align="left" >
										<h:selectBooleanCheckbox id="selectedBox" value="#{semmpt003Bean.chkEditBox}" rendered="true">
											<a4j:support event="onclick" action="#{semmpt003Action.chkDisablePropertyTax}" reRender="editPTax,editRentId">
											</a4j:support>
										</h:selectBooleanCheckbox>
		                			</td>
			                	 </tr>
			                	 
			                	  <tr>
				                	<td width="20%" align="right" valign="top">
										<h:outputText value="Remark" styleClass="ms7"/>
		                			</td>
		                			<td colspan="3" align="left">
										<h:inputTextarea value="#{semmpt003Bean.mpt003Srch.editRemark}" cols="80" rows="3"/>
		                			</td>
			                	 </tr>
			                	 
			                	 <tr>
			                	 	<td align="left">
			                	 	<a4j:commandButton id="btnSave" value="Save" styleClass="rich-button"
										action="#{navAction.navi}" reRender="pnlSearchResult,grdAddNewCommand,pnlSearchCriteria,frmError,frmErrorPopup"
										oncomplete="if(#{semmpt003Bean.popupClose == 'true'})#{rich:component('popupShowEditProperty')}.hide();">
										<a4j:actionparam name="navModule" value="pt" />
										<a4j:actionparam name="navProgram" value="SEMMPT003-1" />
										<a4j:actionparam name="moduleWithNavi" value="pt" />
										<a4j:actionparam name="actionWithNavi" value="SEMMPT003" />
										<a4j:actionparam name="methodWithNavi" value="doSavePropertyTax" />
									</a4j:commandButton>
									<a4j:commandButton value="Cancel" styleClass="rich-button" immediate="true" >
										<rich:componentControl for="popupShowEditProperty" operation="hide" event="onclick" />
									</a4j:commandButton>
			                	 	</td>
			                	 </tr>			                	
							</table>
							</h:panelGroup>
						</h:panelGrid>
					</rich:panel>
			</a4j:form>
	</rich:modalPanel>