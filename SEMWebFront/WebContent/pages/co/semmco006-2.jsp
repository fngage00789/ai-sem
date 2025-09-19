<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<f:loadBundle basename="resources.co.semmco006" var="jspMsg"/>
<rich:modalPanel id="popupAddContractStatus" width="600" autosized="true" minWidth="220">
	<f:facet name="header">
			<h:panelGroup>
				<h:outputText value="#{jspMsg['header.name']}"></h:outputText>
			</h:panelGroup>
	</f:facet>

	<f:facet name="controls">
			<h:panelGroup>
				<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupAddContractStatus" style="cursor:pointer"/>
				<rich:componentControl for="popupAddContractStatus" attachTo="hidePopupAddContractStatus" operation="hide" event="onclick" />
				</div>
			</h:panelGroup>
	</f:facet>
		<h:panelGrid>
			<a4j:form id="popupFrmError">
				<rich:messages layout="list" errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" rendered="#{semmco006Bean.renderedMsgFormSearchPopup}">
				 		<f:facet name="header">
                        	<h:outputText value="Entered Data Status:"></h:outputText>
                    	</f:facet>
			 			<f:facet name="errorMarker">
			 				 <h:graphicImage value="images/error.gif" />  
	                    </f:facet>
                </rich:messages>
			</a4j:form>
		</h:panelGrid>
				<a4j:form id="popupFrmAddContractStatus"> 
				<rich:panel id="pnlAddContractStatus">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popup.name']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%"  border="0" cellpadding="0" cellspacing="1">
							<h:panelGroup>
							<table width="100%">
							<tr>
									<td align="right" width="25%" valign="baseline">
									<h:panelGroup>
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['labe.contractStatus']}" styleClass="ms7"/>
									</h:panelGroup>
		                			</td>
		                			<td width="75%" colspan="3" valign="bottom">
									<h:selectOneMenu id="ddlContractStatus" value="#{semmco006Bean.contractStatus.contractStatus}"
									                 onchange="RenderDDLBorrowOfficer();">
										<f:selectItems value="#{semmco006Bean.contractStatusList}"/>
									</h:selectOneMenu>
									<a4j:jsFunction name="RenderDDLBorrowOfficer" reRender="pnlAddContractStatus"/>
				                	</td>
			                	 </tr>
								<tr>
								<td align="right" width="25%">
									<h:graphicImage value="images/icon_required.gif"/>
									<rich:spacer width="5"></rich:spacer>
									<h:outputText value="#{jspMsg['label.changeStatusDate']} :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
									<rich:calendar id="cldChangeStatusDate" locale="th" enableManualInput="true"  
									datePattern="dd/MM/yyyy" 
									value="#{semmco006Bean.contractStatus.changeStatusDt}" 
									showWeeksBar="false" 
									inputSize="13"
									oninputkeypress="return numberformat.keyPressFormatDateOnly(this, event);"
									cellWidth="20px" cellHeight="20px"
									label="#{jspMsg['label.changeStatusDate']}">
									</rich:calendar> 
				                	</td>
			                	 </tr>
			                	 
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="#{jspMsg['label.remark']}" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:inputTextarea id="txtRemark" value="#{semmco006Bean.contractStatus.remark}" 
		                			cols="70" rows="3"/>
				                	</td>
			                	 </tr>
			                	 <h:panelGroup id="pnlGp0022Recipient" rendered="#{semmco006Bean.contractStatus.contractStatus eq '01'}">
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="ผู้รับ :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlRecipient" value="#{semmco006Bean.contract.receivePersonCode}">
										<f:selectItems value="#{semmco006Bean.borrowOfficerList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
			                	 <h:panelGroup id="pnlGp0022Organizer" rendered="#{semmco006Bean.contractStatus.contractStatus eq '01'}">
			                	 <tr>
									<td align="right" width="25%" valign="top">
									<h:outputText value="ผู้จัดทำ :" styleClass="ms7"/>
		                			</td>
		                			<td width="75%" colspan="3">
		                			<h:selectOneMenu id="ddlOrganizer" value="#{semmco006Bean.contract.createPersonCode}">
										<f:selectItems value="#{semmco006Bean.borrowOfficerList}"/>
									</h:selectOneMenu>
				                	</td>
			                	 </tr>
			                	 </h:panelGroup>
							</table>
							</h:panelGroup>
						</h:panelGrid>
						<!-- end content criteria -->
						<h:panelGrid columns="2" id="grdPopupCommand">
						<a4j:commandButton id="btnSave" value="#{jspMsg['btn.save']}" styleClass="rich-button"
						action="#{navAction.navi}" reRender="frmSearchResult,pnlSearchResult,dtbContractStatus,frmError,popupFrmError" 
						rendered="#{semmco006Bean.renderedAddHistory}"
						oncomplete="if(#{semmco006Bean.popupClose == 'true'})#{rich:component('popupAddContractStatus')}.hide();">
						<a4j:actionparam name="navModule" value="co" />
						<a4j:actionparam name="navProgram" value="SEMMCO006-1" />
						<a4j:actionparam name="moduleWithNavi" value="co" />
						<a4j:actionparam name="actionWithNavi" value="SEMMCO006" />
						<a4j:actionparam name="methodWithNavi" value="doSaveContractStatus" />
						</a4j:commandButton>
						<a4j:commandButton value="#{jspMsg['btn.cancel']}" styleClass="rich-button" immediate="true" rendered="#{semmco006Bean.renderedAddHistory}">
							<rich:componentControl for="popupAddContractStatus" operation="hide" event="onclick" />
						</a4j:commandButton>
					</h:panelGrid>
						</rich:panel>
				</a4j:form>
</rich:modalPanel>

