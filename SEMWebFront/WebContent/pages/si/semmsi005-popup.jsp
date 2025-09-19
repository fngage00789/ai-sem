<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="/WEB-INF/sem-radio-tags.tld" prefix="sem"%>

<f:loadBundle basename="resources.siteinfo.semmsi005" var="jspMsg"/>
<rich:modalPanel id="popupSendRenewBackDt" width="350" autosized="true" minWidth="120">
	<f:facet name="header">
		<h:panelGroup>
			<h:outputText value="#{jspMsg['header.popupSendRenewBackDt.name']}"></h:outputText>
		</h:panelGroup>
	</f:facet>
	<f:facet name="controls">
		<h:panelGroup>
			<div align="left">
			    <h:graphicImage value="images/ico_close.png" id="hidePopupSendRenewBackDt" style="cursor:pointer"/>
				<rich:componentControl for="popupSendRenewBackDt" attachTo="hidePopupSendRenewBackDt" operation="hide" event="onclick" />
			</div>
		</h:panelGroup>
	</f:facet>
	<h:panelGrid>
			<a4j:form id="frmErrorPopupSave">
				<h:messages errorClass="ms7red" warnClass="ms7blue" infoClass="ms7green" globalOnly="true"/>
			</a4j:form>
		</h:panelGrid>
	<a4j:form id="popupFrmAdd"> 
		<h:panelGrid width="330" id="grdPopupSendRenewBackDt">
			<rich:panel id="pnlPopupSendRenewBackDt">
						<f:facet name="header">
							<h:outputText value="#{jspMsg['header.popupName']}"/>
						</f:facet>
						<!-- begin content criteria -->
						<h:panelGrid width="90%" columns="5" border="0" cellpadding="0" cellspacing="1">
						<h:panelGroup>
							<table width="100%">
								<tr>
									<td align="right" width="50%">
										<h:graphicImage value="images/icon_required.gif"/>
										<rich:spacer width="5"></rich:spacer>
										<h:outputText value="#{jspMsg['label.popup.sendRenewBackDt']}" styleClass="ms7"/>
		                			</td>
		                			<td width="30%">
		                				<rich:calendar id="cldPopupSendRenewBackDt" showWeeksBar="false" locale="th/TH" enableManualInput="true" datePattern="dd/MM/yyyy" 
		                				 value="#{semmsi005Bean.sendRenewBackDt}" inputSize="13"/>
				                	</td>      	
		                		</tr>
		                		<tr height="20">
			                	<tr>
			                		<td>
									
									</td>
									<td>
									<a4j:commandButton id="btnPopupSave" value="#{jspMsg['btn.popup.save']}" styleClass="rich-button"
									action="#{navAction.navi}" reRender="frmErrorPopupSave,frmError,pnlSearchResult"
									oncomplete="if(#{semmsi005Bean.popupClose == 'true'})#{rich:component('popupSendRenewBackDt')}.hide();">
										<a4j:actionparam name="navModule" value="si" />
										<a4j:actionparam name="navProgram" value="SEMMSI005-2" />
										<a4j:actionparam name="moduleWithNavi" value="si" />
										<a4j:actionparam name="actionWithNavi" value="SEMMSI005" />
										<a4j:actionparam name="methodWithNavi" value="doSave" />
									</a4j:commandButton>
									<rich:spacer width="5"/>
									<a4j:commandButton id="btnPopupCancle" value="#{jspMsg['btn.cancle']}" styleClass="rich-button" reRender="frmError"> 
										<rich:componentControl for="popupSendRenewBackDt" operation="hide" event="onclick" />
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